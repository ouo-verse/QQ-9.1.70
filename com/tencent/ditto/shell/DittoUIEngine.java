package com.tencent.ditto.shell;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.type.DeviceType;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoAreaGroup;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.content.res.DittoResources;
import com.tencent.ditto.reflect.DittoValue;
import com.tencent.ditto.reflect.MustacheParser;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.utils.DittoLog;
import com.tencent.ditto.utils.FileUtils;
import com.tencent.ditto.utils.Log;
import com.tencent.ditto.widget.DittoButtonArea;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.raft.codegenmeta.utils.Constants;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DittoUIEngine {
    private static float DENSITY = 0.0f;
    private static final String HABO_UPDATE_JSON_FILE_CMD = "tencent.ditto.updateLayoutFile";
    private static final byte[] INSTANCE_LOCK = new byte[0];
    private static float SCREEN_HEIGHT = 0.0f;
    private static float SCREEN_WIDTH = 0.0f;
    private static final String TAG = "DittoUIEngine";
    private static boolean needLoadFromSdcard = true;
    private static volatile DittoValue.GLOBAL outerGlobalData;
    private static volatile DittoUIEngine sInstance;
    private Context mContext;
    private DittoResources mDittoResources;
    private Map<String, String> mJsonContentMap;
    private Map<String, String> mJsonMd5Map;
    private Class mRClass;
    private IReporter mReporter;
    private String subDirectoryPath = "";
    private boolean mHasInitDisplayMetrics = false;
    private final HashMap<String, JSONObject> jsonCache = new HashMap<>();
    private final Map<String, List<DittoArea>> inflatedAreaBuffer = new HashMap();
    private Map<String, String> fileMd5 = null;
    private final Map<String, Integer> resourceIdCache = new ConcurrentHashMap();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface DittoUIEngineInflateListener {
        void didInflatedArea(DittoArea dittoArea, String str);

        void setOutKVCSet(DittoArea dittoArea, Map<String, DittoValue> map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class FakeHost implements DittoHost {
        FakeHost() {
        }

        @Override // com.tencent.ditto.area.DittoHost
        public View getContainerView() {
            return null;
        }

        @Override // com.tencent.ditto.area.DittoHost
        public Context getContext() {
            return DittoUIEngine.g().mContext;
        }

        @Override // com.tencent.ditto.area.DittoHost
        public Object getCurrentViewModel() {
            return null;
        }

        @Override // com.tencent.ditto.area.DittoHost
        public int getPaddingBottom() {
            return 0;
        }

        @Override // com.tencent.ditto.area.DittoHost
        public int getPaddingLeft() {
            return 0;
        }

        @Override // com.tencent.ditto.area.DittoHost
        public int getPaddingRight() {
            return 0;
        }

        @Override // com.tencent.ditto.area.DittoHost
        public int getPaddingTop() {
            return 0;
        }

        @Override // com.tencent.ditto.area.DittoHost
        public void invalidate() {
        }

        @Override // com.tencent.ditto.area.DittoHost
        public void invalidate(int i3, int i16, int i17, int i18) {
        }

        @Override // com.tencent.ditto.area.DittoHost
        public void postInvalidate() {
        }

        @Override // com.tencent.ditto.area.DittoHost
        public void requestLayout() {
        }

        @Override // com.tencent.ditto.area.DittoHost
        public void turnOffHardwareAcceleration() {
        }

        @Override // com.tencent.ditto.area.DittoHost
        public void onContentDescriptionChanged(DittoArea dittoArea) {
        }

        @Override // com.tencent.ditto.area.DittoHost
        public void postInvalidateDelayed(long j3) {
        }

        @Override // com.tencent.ditto.area.DittoHost
        public void removeAccessibilityArea(List<DittoArea> list) {
        }

        @Override // com.tencent.ditto.area.DittoHost
        public void storageViewModel(boolean z16) {
        }

        @Override // com.tencent.ditto.area.DittoHost
        public void invokeAreaClick(String str, MotionEvent motionEvent) {
        }

        @Override // com.tencent.ditto.area.DittoHost
        public void handleSilentUri(String str, DittoArea dittoArea, MotionEvent motionEvent) {
        }

        @Override // com.tencent.ditto.area.DittoHost
        public void handleUri(String str, DittoArea dittoArea, MotionEvent motionEvent) {
        }

        @Override // com.tencent.ditto.area.DittoHost
        public void handleSilentRequest(String str, String str2, int i3, DittoArea dittoArea, MotionEvent motionEvent) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface IReporter {
        void compassReport(int[] iArr);

        void haboReport(String str, int i3, String str2, int i16);

        void reportTTTClick(String str);

        void reportTTTLongClick(String str);
    }

    public DittoUIEngine() {
        DittoLog.v(DittoButtonArea.class.toString());
    }

    private void clearCanvasUIFileInfo() {
        synchronized (this) {
            Map<String, String> map = this.fileMd5;
            if (map != null) {
                map.clear();
            }
        }
    }

    private void createVersionFile(String str) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.mContext.getFilesDir().getAbsolutePath());
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append(this.subDirectoryPath);
        sb5.append(str2);
        sb5.append("version");
        File file = new File(sb5.toString(), str);
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            DittoLog.e(String.format("create version file:%s failed", str));
            return;
        }
        try {
            if (!file.createNewFile()) {
                DittoLog.e(String.format("create version file:%s failed", str));
            }
        } catch (IOException e16) {
            DittoLog.e(DittoLog.defaultTag, String.format("create version file:%s failed", str), e16);
        }
    }

    public static synchronized DittoUIEngine g() {
        DittoUIEngine dittoUIEngine;
        synchronized (DittoUIEngine.class) {
            if (sInstance == null) {
                synchronized (INSTANCE_LOCK) {
                    if (sInstance == null) {
                        sInstance = new DittoUIEngine();
                    }
                }
            }
            dittoUIEngine = sInstance;
        }
        return dittoUIEngine;
    }

    private JSONObject generateBuffer(String str, String str2) throws Exception {
        JSONObject jSONObject = new JSONObject(str2);
        synchronized (this.inflatedAreaBuffer) {
            if (this.inflatedAreaBuffer.containsKey(str)) {
                this.inflatedAreaBuffer.remove(str);
            }
            ArrayList arrayList = new ArrayList();
            this.inflatedAreaBuffer.put(str, arrayList);
            FakeHost fakeHost = new FakeHost();
            for (int i3 = 0; i3 < 6; i3++) {
                arrayList.add(inflateDittoArea(fakeHost, jSONObject, (DittoUIEngineInflateListener) null));
            }
            DittoLog.i("generated area buffer:" + str);
        }
        return jSONObject;
    }

    private Map<String, String> generateFileMd5() {
        File[] listFiles;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(g().mContext.getFilesDir().getAbsolutePath());
            String str = File.separator;
            sb5.append(str);
            sb5.append(this.subDirectoryPath);
            sb5.append(str);
            File file = new File(sb5.toString());
            if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    String md5ByFile = FileUtils.getMd5ByFile(file2);
                    DittoLog.w(DittoLog.defaultTag, "Layout File from sd card:" + file2.getName() + " md5:" + md5ByFile);
                    if (!TextUtils.isEmpty(md5ByFile)) {
                        concurrentHashMap.put(file2.getName(), md5ByFile);
                    }
                }
            }
            Map<String, String> map = this.mJsonMd5Map;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                        concurrentHashMap.put(key, value);
                    }
                }
            }
        } catch (Exception e16) {
            DittoLog.e(DittoLog.defaultTag, "", e16);
        }
        return concurrentHashMap;
    }

    public static DittoValue.GLOBAL getOuterGlobalData() {
        return outerGlobalData;
    }

    private void initDisplayMetricsLazy() {
        Resources resources;
        if (this.mHasInitDisplayMetrics) {
            return;
        }
        Context context = this.mContext;
        if (context == null) {
            resources = null;
        } else {
            resources = context.getResources();
        }
        if (resources == null) {
            DittoLog.e(TAG, "initDisplayMetricsLazy error! context or resources is null!");
            return;
        }
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        if (displayMetrics == null) {
            DittoLog.e(TAG, "initDisplayMetricsLazy error! displayMetrics null!");
            return;
        }
        DENSITY = displayMetrics.density;
        SCREEN_WIDTH = displayMetrics.widthPixels;
        SCREEN_HEIGHT = displayMetrics.heightPixels;
        this.mHasInitDisplayMetrics = true;
    }

    private boolean isFirstBoot(String str) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.mContext.getFilesDir().getAbsolutePath());
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append(this.subDirectoryPath);
        sb5.append(str2);
        sb5.append("version");
        return !new File(sb5.toString(), str).exists();
    }

    private JSONObject loadJsonObject(String str) {
        JSONObject jSONObject;
        Exception e16;
        try {
            jSONObject = this.jsonCache.get(str);
            if (jSONObject == null) {
                try {
                    String loadLayoutContent = loadLayoutContent(str);
                    if (loadLayoutContent != null) {
                        JSONObject jSONObject2 = new JSONObject(loadLayoutContent);
                        try {
                            this.jsonCache.put(str, jSONObject2);
                            return jSONObject2;
                        } catch (Exception e17) {
                            e16 = e17;
                            jSONObject = jSONObject2;
                            DittoLog.e(DittoLog.defaultTag, str + "json parse err:", e16);
                            return jSONObject;
                        }
                    }
                    return jSONObject;
                } catch (Exception e18) {
                    e16 = e18;
                }
            } else {
                return jSONObject;
            }
        } catch (Exception e19) {
            jSONObject = null;
            e16 = e19;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00b6 A[Catch: Exception -> 0x00b2, TRY_LEAVE, TryCatch #5 {Exception -> 0x00b2, blocks: (B:56:0x00ae, B:49:0x00b6), top: B:55:0x00ae }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String loadLayoutContent(String str) {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        String str2;
        BufferedReader bufferedReader2 = null;
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(g().mContext.getFilesDir().getAbsolutePath());
            String str3 = File.separator;
            sb5.append(str3);
            sb5.append(this.subDirectoryPath);
            sb5.append(str3);
            File file = new File(sb5.toString(), str);
            if (file.exists() && file.isFile()) {
                StringBuilder sb6 = new StringBuilder();
                fileInputStream = new FileInputStream(file);
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                    while (true) {
                        try {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb6.append(readLine);
                            } catch (Throwable th5) {
                                th = th5;
                                bufferedReader2 = bufferedReader;
                                if (bufferedReader2 != null) {
                                    try {
                                        bufferedReader2.close();
                                    } catch (Exception e16) {
                                        DittoLog.e(DittoLog.defaultTag, "", e16);
                                        throw th;
                                    }
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                throw th;
                            }
                        } catch (IOException e17) {
                            e = e17;
                            DittoLog.e(DittoLog.defaultTag, "", e);
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception e18) {
                                    DittoLog.e(DittoLog.defaultTag, "", e18);
                                    return null;
                                }
                            }
                            if (fileInputStream == null) {
                                return null;
                            }
                            fileInputStream.close();
                            return null;
                        }
                    }
                    str2 = sb6.toString().trim();
                    bufferedReader2 = bufferedReader;
                } catch (IOException e19) {
                    e = e19;
                    bufferedReader = null;
                } catch (Throwable th6) {
                    th = th6;
                    if (bufferedReader2 != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
            } else {
                Map<String, String> map = this.mJsonContentMap;
                if (map != null) {
                    str2 = map.get(str);
                    fileInputStream = null;
                } else {
                    str2 = null;
                    fileInputStream = null;
                }
            }
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception e26) {
                    DittoLog.e(DittoLog.defaultTag, "", e26);
                }
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return str2;
        } catch (IOException e27) {
            e = e27;
            fileInputStream = null;
            bufferedReader = null;
        } catch (Throwable th7) {
            th = th7;
            fileInputStream = null;
        }
    }

    private void modifyInflatedArea(DittoArea dittoArea, DittoHost dittoHost, DittoUIEngineInflateListener dittoUIEngineInflateListener) {
        dittoArea.setHost(dittoHost);
        if (dittoUIEngineInflateListener != null) {
            dittoUIEngineInflateListener.didInflatedArea(dittoArea, dittoArea.getId());
        }
        if (dittoArea instanceof DittoAreaGroup) {
            DittoAreaGroup dittoAreaGroup = (DittoAreaGroup) dittoArea;
            int childCount = dittoAreaGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                modifyInflatedArea(dittoAreaGroup.getChildAt(i3), dittoHost, dittoUIEngineInflateListener);
            }
        }
    }

    private void preloadJsonObjects() {
        loadJsonObject("qzone_canvas_ui_titleview.json");
        loadJsonObject("qzone_canvas_ui_feedcontent.json");
        loadJsonObject("qzone_canvas_ui_birthday_card.json");
    }

    public static void setOuterGlobalData(DittoValue.GLOBAL global) {
        outerGlobalData = global;
    }

    public void addResourceIdCache(String str, int i3) {
        this.resourceIdCache.put(str, Integer.valueOf(i3));
    }

    public void clearAllAreaCache() {
        try {
            new DittoArea(new FakeHost(), null).clearAllAreaCache();
        } catch (Throwable th5) {
            DittoLog.e(TAG, "error:", th5);
        }
    }

    public void clearCache() {
        clearCanvasUIFileInfo();
        clearRichTextAreaCache();
    }

    public void clearRichTextAreaCache() {
        try {
            new DittoArea(new FakeHost(), null).clearRichTextAreaCache();
        } catch (Throwable th5) {
            DittoLog.e(TAG, "error:", th5);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public float getDensity() {
        initDisplayMetricsLazy();
        return DENSITY;
    }

    public DittoResources getDittoResources() {
        return this.mDittoResources;
    }

    public Map<String, String> getDittoUIFileInfo() {
        synchronized (this) {
            if (this.fileMd5 == null) {
                this.fileMd5 = generateFileMd5();
            }
        }
        return this.fileMd5;
    }

    public String getFileMd5(String str) {
        getDittoUIFileInfo();
        synchronized (this.fileMd5) {
            if (this.fileMd5.containsKey(str)) {
                return this.fileMd5.get(str);
            }
            return null;
        }
    }

    public IReporter getReporter() {
        return this.mReporter;
    }

    public int getResourceId(String str) {
        if (this.resourceIdCache.containsKey(str)) {
            return this.resourceIdCache.get(str).intValue();
        }
        if (this.mRClass != null && !TextUtils.isEmpty(str)) {
            String[] split = str.split("/");
            if (split.length != 2) {
                DittoLog.e(String.format("reference string:%s of incorrect format", str));
                return 0;
            }
            try {
                String str2 = split[0];
                int i3 = Class.forName(this.mRClass.getName() + "$" + str2.substring(1, str2.length())).getDeclaredField(split[1]).getInt(null);
                this.resourceIdCache.put(str, Integer.valueOf(i3));
                return i3;
            } catch (Exception e16) {
                DittoLog.e(DittoLog.defaultTag, "get resource id err:" + e16.getMessage() + "  idString:" + str, e16);
            }
        }
        return 0;
    }

    public float getScreenHeight() {
        initDisplayMetricsLazy();
        return SCREEN_HEIGHT;
    }

    public float getScreenWidth() {
        initDisplayMetricsLazy();
        return SCREEN_WIDTH;
    }

    public DittoArea inflateDittoArea(DittoHost dittoHost, String str, DittoUIEngineInflateListener dittoUIEngineInflateListener) {
        return inflateDittoArea(dittoHost, str, dittoUIEngineInflateListener, false);
    }

    public View inflateView(Context context, String str, ViewGroup viewGroup) {
        try {
            return inflateView(context, loadJsonObject(str), viewGroup);
        } catch (InvocationTargetException e16) {
            DittoLog.e(DittoLog.defaultTag, "inflate err:" + e16.getTargetException().getMessage(), e16.getTargetException());
            return null;
        } catch (Exception e17) {
            DittoLog.e(DittoLog.defaultTag, "inflate err:" + e17.getMessage(), e17);
            return null;
        }
    }

    public void init(Context context, Log log) {
        this.mContext = context;
        DittoLog.setLog(log);
    }

    public void initExtra(DittoResources dittoResources, IReporter iReporter, String str, String str2, Class cls, Map<String, String> map, Map<String, String> map2) {
        Context context = this.mContext;
        if (context == null) {
            DittoLog.e(TAG, "initExtra error! context is null!");
            return;
        }
        this.mDittoResources = dittoResources;
        this.mReporter = iReporter;
        this.subDirectoryPath = str2;
        if (!TextUtils.isEmpty(str) && isFirstBoot(str)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(context.getFilesDir().getAbsolutePath());
            String str3 = File.separator;
            sb5.append(str3);
            sb5.append(str2);
            sb5.append(str3);
            String sb6 = sb5.toString();
            if (sb6 != null) {
                FileUtils.deleteFile(new File(sb6));
            }
            DittoLog.i("Clean the storage field when updated:" + sb6);
            createVersionFile(str);
        }
        this.mRClass = cls;
        this.mJsonContentMap = map;
        this.mJsonMd5Map = map2;
        preloadJsonObjects();
    }

    public void updateLayoutFile(Map<String, String> map) {
        int i3;
        if (map != null && map.size() > 0) {
            try {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(g().mContext.getFilesDir().getAbsolutePath());
                String str = File.separator;
                sb5.append(str);
                sb5.append(this.subDirectoryPath);
                sb5.append(str);
                File file = new File(sb5.toString());
                if (!file.exists()) {
                    file.mkdirs();
                }
                FileOutputStream fileOutputStream = null;
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    try {
                        if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                            JSONObject generateBuffer = generateBuffer(key, value);
                            synchronized (this.jsonCache) {
                                this.jsonCache.put(key, generateBuffer);
                            }
                            File file2 = new File(file.getPath(), key);
                            if (file2.exists()) {
                                file2.delete();
                            }
                            file2.createNewFile();
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                            try {
                                fileOutputStream2.write(value.getBytes());
                                fileOutputStream2.close();
                                String md5ByFile = FileUtils.getMd5ByFile(file2);
                                synchronized (this.fileMd5) {
                                    this.fileMd5.put(key, md5ByFile);
                                }
                                String str2 = "update Layout File:" + key + " md5:" + md5ByFile;
                                DittoLog.i(str2);
                                getReporter().haboReport(HABO_UPDATE_JSON_FILE_CMD, 0, str2, 1);
                                fileOutputStream = fileOutputStream2;
                            } catch (Exception e16) {
                                e = e16;
                                fileOutputStream = fileOutputStream2;
                                if (e instanceof JSONException) {
                                    i3 = -61442;
                                } else if (e instanceof ReflectiveOperationException) {
                                    i3 = -61441;
                                } else {
                                    i3 = -1;
                                }
                                DittoLog.e(DittoLog.defaultTag, "update file error! " + key + " -- " + value + "Exception:" + e.getMessage(), e);
                                getReporter().haboReport(HABO_UPDATE_JSON_FILE_CMD, i3, DittoLog.getTraceString(e), 1);
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                        }
                    } catch (Exception e17) {
                        e = e17;
                    }
                }
            } catch (Exception e18) {
                DittoLog.e(DittoLog.defaultTag, "updateLayoutFile error!", e18);
            }
        }
    }

    public DittoArea inflateDittoArea(DittoHost dittoHost, String str, DittoUIEngineInflateListener dittoUIEngineInflateListener, boolean z16) {
        DittoArea dittoArea;
        if (z16) {
            dittoArea = null;
        } else {
            synchronized (this.inflatedAreaBuffer) {
                if (this.inflatedAreaBuffer.containsKey(str)) {
                    List<DittoArea> list = this.inflatedAreaBuffer.get(str);
                    if (list.size() != 0) {
                        dittoArea = list.get(0);
                        list.remove(0);
                        if (list.size() == 0) {
                            this.inflatedAreaBuffer.remove(str);
                        }
                        DittoLog.i("area buffer used:" + str + "buffer remained:" + list.size());
                    }
                }
                dittoArea = null;
            }
        }
        if (dittoArea != null) {
            modifyInflatedArea(dittoArea, dittoHost, dittoUIEngineInflateListener);
            return dittoArea;
        }
        if (dittoArea == null) {
            try {
                return inflateDittoArea(dittoHost, z16 ? new JSONObject(str) : loadJsonObject(str), dittoUIEngineInflateListener);
            } catch (InvocationTargetException e16) {
                DittoLog.e(DittoLog.defaultTag, "inflate err:" + e16.getTargetException().getMessage(), e16.getTargetException());
            } catch (Exception e17) {
                DittoLog.e(DittoLog.defaultTag, "inflate err:" + e17.getMessage(), e17);
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v6, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r6v5, types: [android.widget.LinearLayout$LayoutParams] */
    public View inflateView(Context context, JSONObject jSONObject, ViewGroup viewGroup) throws Exception {
        JSONArray jSONArray;
        RelativeLayout.LayoutParams layoutParams;
        LinearLayout linearLayout;
        if (jSONObject == null) {
            return null;
        }
        String string = jSONObject.getString("View");
        View view = viewGroup;
        if (!DeviceType.DeviceCategory.MERGER.equals(string)) {
            if ("include".equals(string)) {
                LayoutAttrSet createFrom = LayoutAttrSet.createFrom(jSONObject.getJSONObject("shell"));
                String attr = createFrom.getAttr(TtmlNode.TAG_LAYOUT, "");
                String attr2 = createFrom.getAttr("id", "");
                if (!TextUtils.isEmpty(attr)) {
                    LayoutInflater.from(context).inflate(getResourceId(attr), viewGroup);
                    if (viewGroup != null) {
                        View childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
                        view = childAt;
                        view = childAt;
                        if (!TextUtils.isEmpty(attr2) && childAt != null) {
                            childAt.setId(getResourceId(attr2));
                            view = childAt;
                        }
                    }
                }
                view = null;
            } else {
                Class findAreaClass = DittoAreaEnv.findAreaClass(string);
                DittoLog.i(DittoLog.defaultTag, "inflateView name:" + string);
                LayoutAttrSet createFrom2 = LayoutAttrSet.createFrom(jSONObject.getJSONObject("shell"));
                Object newInstance = findAreaClass.getConstructor(Context.class, AttributeSet.class).newInstance(context, null);
                if (newInstance instanceof ViewStub) {
                    View view2 = (View) newInstance;
                    ViewStub viewStub = (ViewStub) newInstance;
                    String attr3 = createFrom2.getAttr("id", "");
                    String attr4 = createFrom2.getAttr("inflatedId", "");
                    String attr5 = createFrom2.getAttr(TtmlNode.TAG_LAYOUT, "");
                    int resourceId = !TextUtils.isEmpty(attr3) ? getResourceId(attr3) : 0;
                    int resourceId2 = !TextUtils.isEmpty(attr4) ? getResourceId(attr4) : 0;
                    int resourceId3 = !TextUtils.isEmpty(attr5) ? getResourceId(attr5) : 0;
                    viewStub.setId(resourceId);
                    viewStub.setInflatedId(resourceId2);
                    viewStub.setLayoutResource(resourceId3);
                    linearLayout = view2;
                } else {
                    View view3 = (View) newInstance;
                    String str = createFrom2.f100546id;
                    if (!TextUtils.isEmpty(str)) {
                        view3.setId(getResourceId(str));
                    }
                    linearLayout = view3;
                    if (createFrom2.mAttrs.containsKey("visibility")) {
                        String attr6 = createFrom2.getAttr("visibility", NodeProps.VISIBLE);
                        if (TextUtils.equals(NodeProps.VISIBLE, attr6)) {
                            view3.setVisibility(0);
                            linearLayout = view3;
                        } else if (TextUtils.equals("gone", attr6)) {
                            view3.setVisibility(8);
                            linearLayout = view3;
                        } else {
                            linearLayout = view3;
                            if (TextUtils.equals(QZoneJsConstants.DYNAMIC_ALBUM_INVISIBLE, attr6)) {
                                view3.setVisibility(4);
                                linearLayout = view3;
                            }
                        }
                    }
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(createFrom2.width, createFrom2.height);
                marginLayoutParams.leftMargin = createFrom2.leftMargin;
                marginLayoutParams.topMargin = createFrom2.topMargin;
                marginLayoutParams.rightMargin = createFrom2.rightMargin;
                marginLayoutParams.bottomMargin = createFrom2.bottomMargin;
                linearLayout.setLayoutParams(marginLayoutParams);
                linearLayout.setPadding(createFrom2.leftPadding, createFrom2.topPadding, createFrom2.rightPadding, createFrom2.bottomPadding);
                boolean z16 = linearLayout instanceof LinearLayout;
                view = linearLayout;
                if (z16) {
                    linearLayout.setOrientation(createFrom2.orientation);
                    view = linearLayout;
                }
            }
        }
        if (jSONObject.has(Node.CHILDREN_ATTR) && (view instanceof ViewGroup) && (jSONArray = jSONObject.getJSONArray(Node.CHILDREN_ATTR)) != null) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                View inflateView = inflateView(context, jSONArray.getJSONObject(i3), viewGroup2);
                if (inflateView != null && inflateView.getParent() == null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) inflateView.getLayoutParams();
                    if (marginLayoutParams2 != null) {
                        if (viewGroup2 instanceof LinearLayout) {
                            ?? layoutParams2 = new LinearLayout.LayoutParams(marginLayoutParams2.width, marginLayoutParams2.height);
                            ((LinearLayout.LayoutParams) layoutParams2).leftMargin = marginLayoutParams2.leftMargin;
                            ((LinearLayout.LayoutParams) layoutParams2).topMargin = marginLayoutParams2.topMargin;
                            ((LinearLayout.LayoutParams) layoutParams2).rightMargin = marginLayoutParams2.rightMargin;
                            ((LinearLayout.LayoutParams) layoutParams2).bottomMargin = marginLayoutParams2.bottomMargin;
                            layoutParams = layoutParams2;
                        } else if (viewGroup2 instanceof RelativeLayout) {
                            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(marginLayoutParams2.width, marginLayoutParams2.height);
                            layoutParams3.leftMargin = marginLayoutParams2.leftMargin;
                            layoutParams3.topMargin = marginLayoutParams2.topMargin;
                            layoutParams3.rightMargin = marginLayoutParams2.rightMargin;
                            layoutParams3.bottomMargin = marginLayoutParams2.bottomMargin;
                            layoutParams = layoutParams3;
                        } else {
                            layoutParams = null;
                        }
                        if (layoutParams != null) {
                            viewGroup2.addView(inflateView, layoutParams);
                        }
                    } else {
                        viewGroup2.addView(inflateView);
                    }
                }
            }
        }
        return view;
    }

    private DittoArea inflateDittoArea(DittoHost dittoHost, JSONObject jSONObject, DittoUIEngineInflateListener dittoUIEngineInflateListener) throws Exception {
        JSONArray jSONArray;
        if (jSONObject == null) {
            return null;
        }
        Class findAreaClass = DittoAreaEnv.findAreaClass(jSONObject.getString(Constants.Service.CLASS));
        JSONObject jSONObject2 = jSONObject.getJSONObject("shell");
        final ArrayMap arrayMap = new ArrayMap();
        DittoArea dittoArea = (DittoArea) findAreaClass.getConstructor(DittoHost.class, LayoutAttrSet.class).newInstance(dittoHost, LayoutAttrSet.createFrom(jSONObject2, new LayoutAttrSet.ValueIndicator() { // from class: com.tencent.ditto.shell.DittoUIEngine.1
            @Override // com.tencent.ditto.shell.LayoutAttrSet.ValueIndicator
            public boolean onJsonField(String str, Object obj) {
                DittoValue parse;
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (str2.startsWith("{{") && (parse = MustacheParser.parse(str2.substring(2, str2.length() - 2))) != null) {
                        ((ArrayMap) arrayMap).put(str, parse);
                        return true;
                    }
                    return false;
                }
                return false;
            }
        }));
        dittoArea.doneInflate();
        if (dittoArea.getId() != null && dittoUIEngineInflateListener != null) {
            dittoUIEngineInflateListener.didInflatedArea(dittoArea, dittoArea.getId());
        }
        if (jSONObject.has(Node.CHILDREN_ATTR) && (jSONArray = jSONObject.getJSONArray(Node.CHILDREN_ATTR)) != null) {
            DittoAreaGroup dittoAreaGroup = (DittoAreaGroup) dittoArea;
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                DittoArea inflateDittoArea = inflateDittoArea(dittoHost, jSONArray.getJSONObject(i3), dittoUIEngineInflateListener);
                if (inflateDittoArea != null) {
                    dittoAreaGroup.addChild(inflateDittoArea);
                }
            }
        }
        if (dittoUIEngineInflateListener != null && arrayMap.size() != 0) {
            dittoUIEngineInflateListener.setOutKVCSet(dittoArea, arrayMap);
        }
        return dittoArea;
    }
}
