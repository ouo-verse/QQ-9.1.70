package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ValueBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.valueitem.SizeValue;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.loaders.ComplementFileStringLoader;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class ProteusParser {
    public static final String DYNAMIC_VALUE = "-1";
    public static final String DYNAMIC_VALUE_PRE = "$";
    private static final String PLATFORM = "android";
    private static final String TAG = "ProteusParser";
    public static AtomicInteger defaultId = new AtomicInteger(1);
    private String version;
    private Map<String, Map<String, String>> dynamicValueKeyMap = new ArrayMap();
    private Set<String> aladdinKey = new HashSet();
    ArrayMap<String, Map<String, Object>> globalVarFileMapping = new ArrayMap<>();
    private Map<String, Object> globalVariable = new ArrayMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface HasDynamicDataCallback {
        void onCallBack(boolean z16);
    }

    private boolean check$ValueItem(ValueBean valueBean, String str, Object obj) {
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.startsWith("$")) {
                valueBean.putDynamicValue(obj2.substring(1, obj2.length()), str);
                return true;
            }
            ArrayList<String> parse$Value = parse$Value(obj2);
            if (!parse$Value.isEmpty()) {
                Iterator<String> it = parse$Value.iterator();
                while (it.hasNext()) {
                    valueBean.putDynamicValue(it.next(), str);
                }
                return true;
            }
            return false;
        }
        return deal$AttrValue(valueBean, str, obj);
    }

    private static int compare(List<Integer> list, List<Integer> list2) {
        int min = Math.min(list.size(), list2.size());
        for (int i3 = 0; i3 < min; i3++) {
            if (list.get(i3).intValue() > list2.get(i3).intValue()) {
                return 1;
            }
            if (list.get(i3).intValue() < list2.get(i3).intValue()) {
                return -1;
            }
        }
        return 0;
    }

    private boolean deal$AttrValue(ValueBean valueBean, String str, Object obj) {
        boolean z16 = false;
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            boolean z17 = false;
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    z17 |= check$ValueItem(valueBean, str, jSONArray.get(i3));
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
            return z17;
        }
        if (!(obj instanceof JSONObject)) {
            return false;
        }
        JSONObject jSONObject = (JSONObject) obj;
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                z16 |= check$ValueItem(valueBean, str, jSONObject.get((String) keys.next()));
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
        }
        return z16;
    }

    private void dealStyleMapArray(ValueBean valueBean, String str, String str2, JSONArray jSONArray) throws JSONException {
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            Object obj = jSONArray.get(i3);
            if (obj instanceof String) {
                valueBean.putDynamicValue((String) obj, str);
            } else {
                dealStyleMapArray(valueBean, str, str2, (JSONArray) obj);
            }
        }
    }

    private Object getLayoutParamValue(Object obj) throws JSONException {
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            SizeValue sizeValue = new SizeValue();
            if (jSONObject.has("value")) {
                sizeValue.value = Double.valueOf(jSONObject.getString("value")).doubleValue();
            }
            if (jSONObject.has("type")) {
                String string = jSONObject.getString("type");
                if (string.equals(ParseCommon.LAYOUT_PARAMS_RELATIVE)) {
                    sizeValue.valueType = 1003;
                } else if (string.equals(ParseCommon.LAYOUT_PARAMS_ABSOLUTELY)) {
                    sizeValue.valueType = 1004;
                } else if (string.equals(ParseCommon.LAYOUT_PARAMS_MATCH_PARENT)) {
                    sizeValue.valueType = 1001;
                } else {
                    sizeValue.valueType = 1002;
                }
            }
            return sizeValue;
        }
        return getParamValue(obj);
    }

    private int getPriority(JSONObject jSONObject) {
        return getPriority(jSONObject.optString("platform"), jSONObject.optString("min_version"), jSONObject.optString("max_version"), jSONObject.optString("aladdin_key"));
    }

    public static TemplateBean getTemplateBean(BaseTemplateFactory baseTemplateFactory, JSONObject jSONObject) throws JSONException {
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

    private static List<Integer> getVersionArr(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (String str2 : str.split("\\.")) {
            try {
                arrayList.add(Integer.valueOf(Integer.parseInt(str2)));
            } catch (Exception e16) {
                LogUtil.QLog.d("readinjoy.proteus", 2, "", e16);
            }
        }
        return arrayList;
    }

    private boolean isAlladinValid(String str) {
        if (TextUtils.isEmpty(str) || this.aladdinKey.contains(str)) {
            return true;
        }
        return false;
    }

    private boolean isPlatformValid(String str) {
        if (TextUtils.isEmpty(str) || "android".equalsIgnoreCase(str)) {
            return true;
        }
        return false;
    }

    private boolean isStyleValid(BaseTemplateFactory baseTemplateFactory, JSONObject jSONObject) {
        String optString = jSONObject.optString("platform");
        String optString2 = jSONObject.optString("min_version");
        String optString3 = jSONObject.optString("max_version");
        String optString4 = jSONObject.optString("aladdin_key");
        if (!isPlatformValid(optString) || !isVersionValid(optString2, optString3)) {
            return false;
        }
        if (!TextUtils.isEmpty(optString4)) {
            return isAlladinValid(optString4);
        }
        String styleId = getStyleId(jSONObject);
        if (styleId == null) {
            return false;
        }
        int priority = getPriority(optString, optString2, optString3, optString4);
        ParseData parseData = baseTemplateFactory.getParseData(styleId);
        if (parseData != null && priority <= parseData.priority) {
            return false;
        }
        return true;
    }

    private boolean isVersionValid(String str, String str2) {
        if (TextUtils.isEmpty(this.version)) {
            return true;
        }
        List<Integer> versionArr = getVersionArr(this.version);
        List<Integer> versionArr2 = getVersionArr(str);
        List<Integer> versionArr3 = getVersionArr(str2);
        if (!versionArr2.isEmpty() && compare(versionArr, versionArr2) < 0) {
            return false;
        }
        if (versionArr3.isEmpty() || compare(versionArr, versionArr3) <= 0) {
            return true;
        }
        return false;
    }

    private void logStyleConfig(JSONObject jSONObject) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("" + getStyleId(jSONObject));
        sb5.append(":");
        sb5.append(jSONObject.optString("min_version"));
        sb5.append(":");
        sb5.append(jSONObject.optString("max_version"));
        sb5.append(":");
        sb5.append(jSONObject.optString("aladdin_key"));
        sb5.append(":");
        sb5.append(jSONObject.optString("platform"));
        LogUtil.QLog.w("readinjoy.proteus", 1, "logStyleConfig: " + sb5.toString());
    }

    private JSONObject maybeIncludeComponent(JSONObject jSONObject, ComplementFileStringLoader complementFileStringLoader) throws JSONException {
        String loadFileAsString;
        if (jSONObject.has(ParseCommon.INCLUDE_COMPONENT)) {
            if (complementFileStringLoader == null || (loadFileAsString = complementFileStringLoader.loadFileAsString(jSONObject.getString(ParseCommon.INCLUDE_COMPONENT))) == null) {
                return null;
            }
            return new JSONObject(loadFileAsString);
        }
        return jSONObject;
    }

    private ArrayList<String> parse$Value(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        trim$String(str, arrayList);
        return arrayList;
    }

    private void parseAttr(JSONObject jSONObject, final ViewBean viewBean, final ArrayList<String> arrayList) throws JSONException {
        Iterator keys = jSONObject.keys();
        Map<String, String> map = this.dynamicValueKeyMap.get(viewBean.viewId);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                putStyleMapValueKey(viewBean.valueBean, entry.getKey(), entry.getValue());
            }
        }
        while (keys.hasNext()) {
            final String str = (String) keys.next();
            final Object obj = jSONObject.get(str);
            dealMethod(viewBean.valueBean, str, obj, new HasDynamicDataCallback() { // from class: com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser.1
                @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser.HasDynamicDataCallback
                public void onCallBack(boolean z16) {
                    if (z16) {
                        viewBean.valueBean.putAttributeDynamicValue(str, obj);
                        arrayList.addAll(ProteusParser.this.getDollarName(obj));
                    } else {
                        viewBean.valueBean.putNomalValue(str, obj);
                    }
                }
            });
        }
    }

    private void parseDataAttrSetLocalData(JSONObject jSONObject, ViewBean viewBean) throws JSONException {
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            viewBean.valueBean.putDataAttributeLocalData(str, jSONObject.get(str));
        }
    }

    private void parseDataAttrSetRemoteData(JSONObject jSONObject, final ViewBean viewBean, final ArrayList<String> arrayList) throws JSONException {
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            final String str = (String) keys.next();
            final Object obj = jSONObject.get(str);
            dealMethod(viewBean.valueBean, str, obj, new HasDynamicDataCallback() { // from class: com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser.3
                @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser.HasDynamicDataCallback
                public void onCallBack(boolean z16) {
                    if (z16) {
                        viewBean.valueBean.putDataAttributeDynamicValue(str, obj);
                        arrayList.addAll(ProteusParser.this.getDollarName(obj));
                    } else {
                        viewBean.valueBean.putDataAttributeLocalData(str, obj);
                    }
                }
            });
        }
    }

    private ViewBean parseItemView(JSONObject jSONObject, ComplementFileStringLoader complementFileStringLoader, ArrayList<String> arrayList, ArrayList<String> arrayList2) throws JSONException {
        ViewBean viewBean = new ViewBean();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object obj = jSONObject.get(str);
            if (jSONObject.has("view_id")) {
                viewBean.viewId = jSONObject.getString("view_id");
            } else {
                viewBean.viewId = ParseCommon.DEFAULT_VIEW_ID + defaultId.getAndIncrement();
            }
            if (str.equals("view_type")) {
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
            } else if (!str.equals("view_id")) {
                if (str.equals(ParseCommon.SUB_VIEWS)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    ArrayList arrayList3 = new ArrayList();
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONObject maybeIncludeComponent = maybeIncludeComponent(jSONArray.getJSONObject(i3), complementFileStringLoader);
                        if (maybeIncludeComponent != null) {
                            arrayList3.add(parseItemView(maybeIncludeComponent, complementFileStringLoader, arrayList, arrayList2));
                        }
                    }
                    ViewBean[] viewBeanArr = new ViewBean[arrayList3.size()];
                    viewBean.children = viewBeanArr;
                    arrayList3.toArray(viewBeanArr);
                } else if (str.equals("attributes")) {
                    parseAttr(jSONObject.getJSONObject(str), viewBean, arrayList2);
                } else if (str.equals(ParseCommon.DATA_ATTRIBUTES)) {
                    parseDataAttr(jSONObject.getJSONObject(str), viewBean, arrayList2);
                } else if (str.equals(ParseCommon.INCLUDE_GLOBAL_VAR_FILE)) {
                    parseIncludeGlobalFile(obj, complementFileStringLoader, arrayList);
                } else {
                    parseLayoutParams(str, obj, viewBean.valueBean);
                }
            }
        }
        return viewBean;
    }

    private void recordPriority(BaseTemplateFactory baseTemplateFactory, String str, JSONObject jSONObject) {
        if (baseTemplateFactory != null && jSONObject != null) {
            baseTemplateFactory.getParseData(str).priority = getPriority(jSONObject);
        }
    }

    private void trim$String(String str, ArrayList<String> arrayList) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Matcher matcher = Pattern.compile("\\$\\{\\w+\\}").matcher(str);
                while (matcher.find()) {
                    String group = matcher.group();
                    arrayList.add(group.substring(group.indexOf(123) + 1, group.indexOf(125)));
                }
            } catch (Exception e16) {
                LogUtil.QLog.e("readinjoy.proteus", 1, "trim$String error! msg=" + e16);
            }
        }
    }

    public void createViewTemplate(BaseTemplateFactory baseTemplateFactory, String str, ComplementFileStringLoader complementFileStringLoader) throws JSONException {
        createViewTemplate(baseTemplateFactory, new JSONObject(str), complementFileStringLoader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dealMethod(ValueBean valueBean, String str, Object obj, HasDynamicDataCallback hasDynamicDataCallback) {
        String str2;
        if (obj instanceof String) {
            str2 = (String) obj;
        } else {
            str2 = null;
        }
        if (obj != null && !"-1".equals(obj)) {
            if (str2 != null && str2.startsWith("$")) {
                hasDynamicDataCallback.onCallBack(true);
                valueBean.putDynamicValue(str2.substring(1, str2.length()), str);
            } else {
                hasDynamicDataCallback.onCallBack(deal$AttrValue(valueBean, str, obj));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<String> getDollarName(Object obj) {
        ArrayList arrayList = new ArrayList();
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.startsWith("$")) {
                arrayList.add(str.substring(1));
                return arrayList;
            }
        }
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                arrayList.addAll(getDollarName(jSONObject.opt((String) keys.next())));
            }
        } else if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                arrayList.addAll(getDollarName(jSONArray.opt(i3)));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> getKeyValue(JSONObject jSONObject) throws JSONException {
        String str;
        ArrayMap arrayMap = new ArrayMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            Object paramValue = getParamValue(jSONObject.get(str2));
            if (paramValue != null) {
                str = paramValue.toString();
            } else {
                str = null;
            }
            if (str != null) {
                arrayMap.put(str2, str);
            }
        }
        return arrayMap;
    }

    protected Object getParamValue(Object obj, boolean z16) throws JSONException {
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject.has("value")) {
                return jSONObject.getString("value");
            }
            if (jSONObject.has("type")) {
                return jSONObject.getString("type");
            }
            Iterator keys = jSONObject.keys();
            if (keys.hasNext()) {
                return jSONObject.getString((String) keys.next());
            }
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (!(obj instanceof JSONArray)) {
            return null;
        }
        if (!z16) {
            return obj;
        }
        Object obj2 = ((JSONArray) obj).get(0);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        if (obj2 instanceof JSONArray) {
            return obj;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getStyleId(JSONObject jSONObject) {
        Iterator keys = jSONObject.keys();
        while (keys != null && keys.hasNext()) {
            String str = (String) keys.next();
            try {
                Object obj = jSONObject.get(str);
                if ((obj instanceof JSONObject) && ((JSONObject) obj).has("view_type")) {
                    return str;
                }
            } catch (JSONException unused) {
                LogUtil.QLog.d("readinjoy.proteus", 2, "getStyleId : " + jSONObject);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ArrayMap<String, Object> getTemplateGloabalVar(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        ArrayMap arrayMap = new ArrayMap();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            String str = arrayList.get(i3);
            if (this.globalVarFileMapping.containsKey(str)) {
                arrayMap.putAll(this.globalVarFileMapping.get(str));
            }
        }
        ArrayMap<String, Object> arrayMap2 = new ArrayMap<>();
        for (int i16 = 0; i16 < arrayList2.size(); i16++) {
            String str2 = arrayList2.get(i16);
            if (arrayMap.containsKey(str2)) {
                arrayMap2.put(str2, arrayMap.get(str2));
            }
        }
        return arrayMap2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void parseDataAttr(JSONObject jSONObject, final ViewBean viewBean, final ArrayList<String> arrayList) throws JSONException {
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            final Object obj = jSONObject.get(str);
            if (ParseCommon.DATA_ATTRIBUTES_SETLOCALDATA.equals(str)) {
                if (obj instanceof JSONObject) {
                    parseDataAttrSetLocalData((JSONObject) obj, viewBean);
                }
            } else if (ParseCommon.DATA_ATTRIBUTES_SETREMOTEDATA.equals(str)) {
                if (obj instanceof JSONObject) {
                    parseDataAttrSetRemoteData((JSONObject) obj, viewBean, arrayList);
                } else if ((obj instanceof String) && ((String) obj).startsWith("$")) {
                    dealMethod(viewBean.valueBean, "$setRemoteInfo:", obj, new HasDynamicDataCallback() { // from class: com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser.2
                        @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser.HasDynamicDataCallback
                        public void onCallBack(boolean z16) {
                            if (z16) {
                                viewBean.valueBean.putDataAttributeDynamicValue("$setRemoteInfo:", obj);
                                arrayList.addAll(ProteusParser.this.getDollarName(obj));
                            } else {
                                viewBean.valueBean.putDataAttributeLocalData("$setRemoteInfo:", obj);
                            }
                        }
                    });
                }
            }
        }
    }

    public void parseDataMap(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("version")) {
            LogUtil.QLog.d("readinjoy.proteus", 2, "proteus version : " + jSONObject.getString("version"));
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("data_map");
        Iterator keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            this.dynamicValueKeyMap.put(str2, getKeyValue(jSONObject2.getJSONObject(str2)));
        }
    }

    protected Map<String, Object> parseGlobalVariable(String str, String str2) throws JSONException {
        ArrayMap arrayMap = new ArrayMap();
        JSONObject jSONObject = new JSONObject(str2);
        Iterator keys = jSONObject.keys();
        StringBuilder sb5 = new StringBuilder("globaleVariable[" + str + "] : ");
        while (keys.hasNext()) {
            String str3 = (String) keys.next();
            Object obj = jSONObject.get(str3);
            if (obj != null) {
                sb5.append("key : ");
                sb5.append(str3);
                sb5.append(", value : ");
                sb5.append(obj);
                sb5.append(";");
                arrayMap.put(str3, obj);
            }
        }
        LogUtil.QLog.d(TAG, 1, sb5.toString());
        return arrayMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void parseIncludeGlobalFile(Object obj, ComplementFileStringLoader complementFileStringLoader, ArrayList<String> arrayList) throws JSONException {
        if (obj instanceof String) {
            String str = (String) obj;
            if (!this.globalVarFileMapping.containsKey(str)) {
                String loadFileAsString = complementFileStringLoader.loadFileAsString(str);
                if (!TextUtils.isEmpty(loadFileAsString)) {
                    this.globalVarFileMapping.put(str, parseGlobalVariable(str, loadFileAsString));
                    arrayList.add(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void parseLayoutParams(String str, Object obj, ValueBean valueBean) throws JSONException {
        valueBean.putNomalValue(str, getLayoutParamValue(obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public void putStyleMapValueKey(ValueBean valueBean, String str, String str2) {
        JSONArray jSONArray;
        Exception e16;
        Object obj;
        try {
        } catch (Exception e17) {
            jSONArray = str2;
            e16 = e17;
        }
        if (str2.contains("[")) {
            jSONArray = new JSONArray(str2);
            try {
                dealStyleMapArray(valueBean, str, str2, jSONArray);
            } catch (Exception e18) {
                e16 = e18;
                LogUtil.QLog.e("readinjoy.proteus", 1, "style_map\u53ea\u652f\u6301Json\u5b57\u7b26\u4e32/\u6570\u7ec4,\u7528$\u90fd\u652f\u6301:", e16);
                obj = jSONArray;
                valueBean.putAttributeDynamicValue(str, obj);
            }
            obj = jSONArray;
            valueBean.putAttributeDynamicValue(str, obj);
        }
        valueBean.putDynamicValue(str2, str);
        obj = str2;
        valueBean.putAttributeDynamicValue(str, obj);
    }

    public void setAladdinKey(Set<String> set) {
        this.aladdinKey = set;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public void createViewTemplate(BaseTemplateFactory baseTemplateFactory, JSONObject jSONObject, ComplementFileStringLoader complementFileStringLoader) throws JSONException {
        if (!isStyleValid(baseTemplateFactory, jSONObject)) {
            logStyleConfig(jSONObject);
            return;
        }
        int templateId = baseTemplateFactory.getTemplateId();
        String styleId = getStyleId(jSONObject);
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(styleId);
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<String> arrayList2 = new ArrayList<>();
            baseTemplateFactory.createTemplate(templateId, styleId, parseItemView(jSONObject2, complementFileStringLoader, arrayList2, arrayList), getTemplateGloabalVar(arrayList2, arrayList));
            recordPriority(baseTemplateFactory, styleId, jSONObject);
        } catch (IllegalArgumentException e16) {
            throw new IllegalArgumentException("\u95ee\u9898\u6e90:" + styleId + e16.getMessage());
        }
    }

    private int getPriority(String str, String str2, String str3, String str4) {
        int i3 = !TextUtils.isEmpty(str) ? 10 : 0;
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            i3 += 100;
        }
        return !TextUtils.isEmpty(str4) ? i3 + 1000 : i3;
    }

    Object getParamValue(Object obj) throws JSONException {
        return getParamValue(obj, false);
    }

    void dataCheck(ViewBean viewBean) {
    }
}
