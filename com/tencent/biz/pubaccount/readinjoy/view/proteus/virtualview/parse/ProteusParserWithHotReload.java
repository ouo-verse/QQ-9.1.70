package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.loaders.ComplementFileStringLoader;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class ProteusParserWithHotReload extends ProteusParser {
    private static final String BROADCAST_ACTION = "com.tencent.proteus.ReloadBroadcast";
    private static final String PROTEUS_DEBUG_FOLDER = Environment.getExternalStorageDirectory().getAbsolutePath() + "/ProteusDebug/";
    private static final String SPLIT_FLAG = "^#^";
    private static final String TAG = "ProteusParserHotReload";
    private HashMap<String, ArrayList<String>> mComplementMap;
    private ArrayList<IHotReloadChangedObserver> mHotReloadChangedObservers;
    private HashMap<String, String> mHotReloadMap;
    private boolean mIsSupportHotReload;
    private HashMap<String, ComplementFileStringLoader> mPathMap;
    private HashMap<String, String> mTemplateBeanToStyleMap;

    /* loaded from: classes4.dex */
    public interface IHotReloadChangedObserver {
        void onHotReloadChanged(Context context, String str, String str2);
    }

    /* loaded from: classes4.dex */
    class ProteusBroadCastReceiver extends BroadcastReceiver {
        ProteusBroadCastReceiver() {
        }

        private void getNewPathAndHotReload(Context context, String str, ArrayList<String> arrayList) {
            String replace = str.replace(ProteusParserWithHotReload.SPLIT_FLAG, "/");
            ProteusParserWithHotReload.this.mHotReloadMap.put(replace, str);
            if (replace.endsWith("style_map.geojson")) {
                return;
            }
            if (ProteusParserWithHotReload.this.mComplementMap.containsKey(replace)) {
                Iterator it = ((ArrayList) ProteusParserWithHotReload.this.mComplementMap.get(replace)).iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    if (!arrayList.contains(str2)) {
                        arrayList.add(str2);
                        try {
                            hotReloadByFilePath(context, str2);
                        } catch (IOException unused) {
                            LogUtil.QLog.e("readinjoy.proteus", 2, " proteus hot-reload file not found error: " + ProteusParserWithHotReload.PROTEUS_DEBUG_FOLDER + str);
                        } catch (JSONException e16) {
                            LogUtil.QLog.e("readinjoy.proteus", 2, " proteus hot-reload json error: " + e16.toString());
                        }
                    }
                }
                return;
            }
            if (!arrayList.contains(replace)) {
                arrayList.add(replace);
                try {
                    hotReloadByFilePath(context, replace);
                } catch (IOException unused2) {
                    LogUtil.QLog.e("readinjoy.proteus", 2, " proteus hot-reload file not found error: " + ProteusParserWithHotReload.PROTEUS_DEBUG_FOLDER + str);
                } catch (JSONException e17) {
                    LogUtil.QLog.e("readinjoy.proteus", 2, " proteus hot-reload json error: " + e17.toString());
                }
            }
        }

        private void hotReloadByFilePath(Context context, String str) throws JSONException, IOException {
            String str2;
            JSONObject jSONObject = new JSONObject(ProteusParserWithHotReload.this.getJsonStringFromFile(context, str));
            if (jSONObject.keys().hasNext()) {
                str2 = (String) jSONObject.keys().next();
            } else {
                str2 = "";
            }
            for (int i3 = 0; i3 < ProteusParserWithHotReload.this.mHotReloadChangedObservers.size(); i3++) {
                ((IHotReloadChangedObserver) ProteusParserWithHotReload.this.mHotReloadChangedObservers.get(i3)).onHotReloadChanged(context, str2, str);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!ProteusParserWithHotReload.this.mIsSupportHotReload) {
                return;
            }
            String[] split = intent.getStringExtra("file_path").split(";");
            ArrayList<String> arrayList = new ArrayList<>();
            for (String str : split) {
                getNewPathAndHotReload(context, str, arrayList);
            }
        }
    }

    /* loaded from: classes4.dex */
    private static class SingletonInstance {
        private static final ProteusParserWithHotReload instance = new ProteusParserWithHotReload();

        SingletonInstance() {
        }
    }

    public static ProteusParserWithHotReload getInstance() {
        return SingletonInstance.instance;
    }

    private void initHotReloadMap() {
        File[] listFiles;
        if (this.mIsSupportHotReload && (listFiles = new File(PROTEUS_DEBUG_FOLDER).listFiles()) != null && listFiles.length > 0) {
            for (File file : listFiles) {
                String name = file.getName();
                this.mHotReloadMap.put(name.replace(SPLIT_FLAG, "/"), name);
            }
        }
    }

    private JSONObject maybeIncludeComponent(JSONObject jSONObject, ComplementFileStringLoader complementFileStringLoader, String str, String str2) throws JSONException {
        if (jSONObject.has(ParseCommon.INCLUDE_COMPONENT)) {
            if (complementFileStringLoader != null) {
                String loadFileAsString = complementFileStringLoader.loadFileAsString(jSONObject.getString(ParseCommon.INCLUDE_COMPONENT));
                if (this.mIsSupportHotReload) {
                    String str3 = str2 + "/" + jSONObject.getString(ParseCommon.INCLUDE_COMPONENT);
                    if (this.mHotReloadMap.containsKey(str3)) {
                        try {
                            loadFileAsString = readInputStreamAsString(new FileInputStream(new File(PROTEUS_DEBUG_FOLDER + this.mHotReloadMap.get(str3))));
                        } catch (FileNotFoundException unused) {
                            LogUtil.QLog.e("readinjoy.proteus", 2, " proteus hot-reload file not found error: " + PROTEUS_DEBUG_FOLDER + this.mHotReloadMap.get(str3));
                        }
                    }
                    HashMap<String, ArrayList<String>> hashMap = this.mComplementMap;
                    if (hashMap != null) {
                        if (hashMap.get(str3) == null) {
                            this.mComplementMap.put(str3, new ArrayList<>());
                        }
                        if (!this.mComplementMap.get(str3).contains(str)) {
                            this.mComplementMap.get(str3).add(str);
                        }
                    }
                }
                if (loadFileAsString != null) {
                    return new JSONObject(loadFileAsString);
                }
            }
            return null;
        }
        return jSONObject;
    }

    private void parseAndCreateViewTemplate(BaseTemplateFactory baseTemplateFactory, JSONObject jSONObject, ComplementFileStringLoader complementFileStringLoader, String str, String str2, String str3) throws JSONException {
        int templateId = baseTemplateFactory.getTemplateId();
        String styleId = getStyleId(jSONObject);
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(styleId);
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<String> arrayList2 = new ArrayList<>();
            baseTemplateFactory.createTemplate(templateId, styleId, parseItemView(jSONObject2, complementFileStringLoader, str, str2, str3, arrayList2, arrayList), getTemplateGloabalVar(arrayList2, arrayList));
        } catch (IllegalArgumentException e16) {
            throw new IllegalArgumentException("\u95ee\u9898\u6e90:" + styleId + e16.getMessage());
        }
    }

    private void parseAttr(JSONObject jSONObject, final ViewBean viewBean, String str, final ArrayList<String> arrayList) throws JSONException {
        Iterator keys = jSONObject.keys();
        ArrayMap arrayMap = new ArrayMap();
        System.currentTimeMillis();
        parseDataMap(arrayMap, str);
        Map<String, String> map = arrayMap.get(viewBean.viewId);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                putStyleMapValueKey(viewBean.valueBean, entry.getKey(), entry.getValue());
            }
        }
        while (keys.hasNext()) {
            final String str2 = (String) keys.next();
            final Object obj = jSONObject.get(str2);
            dealMethod(viewBean.valueBean, str2, obj, new ProteusParser.HasDynamicDataCallback() { // from class: com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParserWithHotReload.1
                @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser.HasDynamicDataCallback
                public void onCallBack(boolean z16) {
                    if (z16) {
                        viewBean.valueBean.putAttributeDynamicValue(str2, obj);
                        arrayList.addAll(ProteusParserWithHotReload.this.getDollarName(obj));
                    } else {
                        viewBean.valueBean.putNomalValue(str2, obj);
                    }
                }
            });
        }
    }

    private void parseDataMap(Map<String, Map<String, String>> map, String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(str).getJSONObject("data_map");
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            map.put(str2, getKeyValue(jSONObject.getJSONObject(str2)));
        }
    }

    private ViewBean parseItemView(JSONObject jSONObject, ComplementFileStringLoader complementFileStringLoader, String str, String str2, String str3, ArrayList<String> arrayList, ArrayList<String> arrayList2) throws JSONException {
        int i3;
        ViewBean viewBean = new ViewBean();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str4 = (String) keys.next();
            Object obj = jSONObject.get(str4);
            if (jSONObject.has("view_id")) {
                viewBean.viewId = jSONObject.getString("view_id");
            } else {
                viewBean.viewId = ParseCommon.DEFAULT_VIEW_ID + ProteusParser.defaultId.getAndIncrement();
            }
            if (str4.equals("view_type")) {
                String string = jSONObject.getString("view_type");
                if (!TextUtils.equals(string, "cell") && !TextUtils.equals(string, ParseCommon.CONTAINER)) {
                    if (TextUtils.equals(string, ParseCommon.UIVIEW)) {
                        if (jSONObject.optJSONArray(ParseCommon.SUB_VIEWS) != null) {
                            if (TextUtils.equals(ParseCommon.LAYOUT_RELATIVE, jSONObject.optString(ParseCommon.LAYOUT_TYPE))) {
                                viewBean.viewType = ParseCommon.UI_NATIVE_RELATIVELAYOUT;
                            } else {
                                viewBean.viewType = ParseCommon.UI_NATIVE_LINEARLAYOUT;
                            }
                        } else {
                            viewBean.viewType = ParseCommon.UI_NATIVE_LINEARLAYOUT;
                        }
                    } else {
                        viewBean.viewType = string;
                    }
                } else if (TextUtils.equals(ParseCommon.LAYOUT_RELATIVE, jSONObject.optString(ParseCommon.LAYOUT_TYPE))) {
                    viewBean.viewType = ParseCommon.RELATIVE_LAYOUT;
                } else {
                    viewBean.viewType = ParseCommon.LINEAR_LAYOUT;
                }
            } else if (!str4.equals("view_id")) {
                if (str4.equals(ParseCommon.SUB_VIEWS)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(str4);
                    ArrayList arrayList3 = new ArrayList();
                    int i16 = 0;
                    while (i16 < jSONArray.length()) {
                        JSONObject maybeIncludeComponent = maybeIncludeComponent(jSONArray.getJSONObject(i16), complementFileStringLoader, str, str2);
                        if (maybeIncludeComponent != null) {
                            i3 = i16;
                            arrayList3.add(parseItemView(maybeIncludeComponent, complementFileStringLoader, str, str2, str3, arrayList, arrayList2));
                        } else {
                            i3 = i16;
                        }
                        i16 = i3 + 1;
                    }
                    ViewBean[] viewBeanArr = new ViewBean[arrayList3.size()];
                    viewBean.children = viewBeanArr;
                    arrayList3.toArray(viewBeanArr);
                } else if (str4.equals("attributes")) {
                    parseAttr(jSONObject.getJSONObject(str4), viewBean, str3, arrayList2);
                } else if (str4.equals(ParseCommon.DATA_ATTRIBUTES)) {
                    parseDataAttr(jSONObject.getJSONObject(str4), viewBean, arrayList2);
                } else if (str4.equals(ParseCommon.INCLUDE_GLOBAL_VAR_FILE)) {
                    parseIncludeGlobalFile(obj, complementFileStringLoader, arrayList);
                } else {
                    parseLayoutParams(str4, obj, viewBean.valueBean);
                }
            }
        }
        return viewBean;
    }

    private String readInputStreamAsString(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb5 = new StringBuilder();
        while (true) {
            try {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb5.append(readLine);
                    } catch (Throwable th5) {
                        try {
                            inputStream.close();
                        } catch (IOException e16) {
                            Log.e(TAG, "readInputStreamAsString: fail to close InputStream", e16);
                        }
                        throw th5;
                    }
                } catch (IOException unused) {
                    Log.d(TAG, "fail to read string from input stream");
                    inputStream.close();
                }
            } catch (IOException e17) {
                Log.e(TAG, "readInputStreamAsString: fail to close InputStream", e17);
            }
        }
        inputStream.close();
        return sb5.toString();
    }

    public void addHotReloadChangedObserver(IHotReloadChangedObserver iHotReloadChangedObserver) {
        this.mHotReloadChangedObservers.add(iHotReloadChangedObserver);
    }

    public void createViewTempFromAssets(Context context, BaseTemplateFactory baseTemplateFactory, ComplementFileStringLoader complementFileStringLoader, String str, String str2, String str3) {
        try {
            String jsonStringFromFile = getJsonStringFromFile(context, str);
            if (this.mIsSupportHotReload) {
                this.mPathMap.put(str, complementFileStringLoader);
                this.mTemplateBeanToStyleMap.put(str, str3);
            }
            createViewTemplateFromFile(context, baseTemplateFactory, jsonStringFromFile, complementFileStringLoader, str, str2, str3);
        } catch (IOException e16) {
            Log.e(TAG, "Fail to create view template from assets " + str + " " + e16.toString());
        } catch (JSONException e17) {
            Log.e(TAG, "Json error: " + e17.toString());
        }
    }

    public void createViewTemplate(BaseTemplateFactory baseTemplateFactory, JSONObject jSONObject, ComplementFileStringLoader complementFileStringLoader, String str) throws JSONException {
        parseAndCreateViewTemplate(baseTemplateFactory, jSONObject, complementFileStringLoader, "", "", str);
    }

    public void createViewTemplateFromFile(Context context, BaseTemplateFactory baseTemplateFactory, String str) throws JSONException, IOException {
        createViewTemplateFromFile(context, baseTemplateFactory, getJsonStringFromFile(context, str), this.mPathMap.get(str), str, str.substring(0, str.lastIndexOf("/")), this.mTemplateBeanToStyleMap.get(str));
    }

    public void finishHotReload() {
        File[] listFiles;
        if (this.mIsSupportHotReload && (listFiles = new File(PROTEUS_DEBUG_FOLDER).listFiles()) != null && listFiles.length > 0) {
            for (File file : listFiles) {
                file.deleteOnExit();
            }
        }
    }

    public String getJsonStringFromFile(Context context, String str) throws IOException {
        if (!this.mIsSupportHotReload) {
            return readInputStreamAsString(context.getAssets().open(str));
        }
        if (context != null && str != null) {
            HashMap<String, String> hashMap = this.mHotReloadMap;
            if (hashMap != null && hashMap.containsKey(str)) {
                return readInputStreamAsString(new FileInputStream(new File(PROTEUS_DEBUG_FOLDER + this.mHotReloadMap.get(str))));
            }
            return readInputStreamAsString(context.getAssets().open(str));
        }
        return "";
    }

    public TemplateBean getTemplateBeanFromJson(BaseTemplateFactory baseTemplateFactory, JSONObject jSONObject) throws JSONException {
        if (jSONObject == null || baseTemplateFactory == null) {
            return null;
        }
        String string = jSONObject.getString(ParseCommon.STYLE_ID);
        TemplateBean template = baseTemplateFactory.getTemplate(string);
        if (template == null) {
            LogUtil.QLog.e("readinjoy.proteus", 2, "proteus error : there is not Template: " + string);
            return null;
        }
        template.bindData(jSONObject);
        return template;
    }

    public void initHotReload(Context context) {
        this.mIsSupportHotReload = true;
        ProteusBroadCastReceiver proteusBroadCastReceiver = new ProteusBroadCastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BROADCAST_ACTION);
        context.registerReceiver(proteusBroadCastReceiver, intentFilter);
        File file = new File(PROTEUS_DEBUG_FOLDER);
        if (!file.exists()) {
            file.mkdirs();
        }
        initHotReloadMap();
    }

    public boolean isSupportHotReload() {
        return this.mIsSupportHotReload;
    }

    public void removeHotReloadChangedObserver(IHotReloadChangedObserver iHotReloadChangedObserver) {
        this.mHotReloadChangedObservers.remove(iHotReloadChangedObserver);
    }

    ProteusParserWithHotReload() {
        this.mIsSupportHotReload = false;
        this.mPathMap = new HashMap<>();
        this.mHotReloadMap = new HashMap<>();
        this.mComplementMap = new HashMap<>();
        this.mTemplateBeanToStyleMap = new HashMap<>();
        this.mHotReloadChangedObservers = new ArrayList<>();
    }

    public void createViewTemplate(BaseTemplateFactory baseTemplateFactory, String str, ComplementFileStringLoader complementFileStringLoader, String str2) throws JSONException {
        createViewTemplate(baseTemplateFactory, new JSONObject(str), complementFileStringLoader, str2);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser
    @Deprecated
    public void createViewTemplate(BaseTemplateFactory baseTemplateFactory, String str, ComplementFileStringLoader complementFileStringLoader) throws JSONException {
        super.createViewTemplate(baseTemplateFactory, str, complementFileStringLoader);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser
    @Deprecated
    public void createViewTemplate(BaseTemplateFactory baseTemplateFactory, JSONObject jSONObject, ComplementFileStringLoader complementFileStringLoader) throws JSONException {
        super.createViewTemplate(baseTemplateFactory, jSONObject, complementFileStringLoader);
    }

    private void createViewTemplateFromFile(Context context, BaseTemplateFactory baseTemplateFactory, String str, ComplementFileStringLoader complementFileStringLoader, String str2, String str3, String str4) throws JSONException {
        String str5;
        JSONObject jSONObject = new JSONObject(str);
        try {
            str5 = getJsonStringFromFile(context, str4);
        } catch (IOException e16) {
            e16.printStackTrace();
            str5 = "";
        }
        parseAndCreateViewTemplate(baseTemplateFactory, jSONObject, complementFileStringLoader, str2, str3, str5);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser
    @Deprecated
    public void parseDataMap(String str) throws JSONException {
        super.parseDataMap(str);
    }
}
