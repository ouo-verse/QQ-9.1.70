package com.tencent.mobileqq.richmedia.capture.data;

import android.annotation.TargetApi;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.biz.common.util.k;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.mobileqq.activity.richmedia.f;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.richmedia.capture.data.CaptureRedDotConfig;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.a;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes18.dex */
public class CapturePtvTemplateManager {

    /* renamed from: h, reason: collision with root package name */
    public static String f281328h;

    /* renamed from: i, reason: collision with root package name */
    public static String f281329i;

    /* renamed from: j, reason: collision with root package name */
    public static File f281330j;

    /* renamed from: k, reason: collision with root package name */
    public static File f281331k;

    /* renamed from: l, reason: collision with root package name */
    public static String f281332l;

    /* renamed from: b, reason: collision with root package name */
    String f281335b;

    /* renamed from: c, reason: collision with root package name */
    String f281336c;

    /* renamed from: d, reason: collision with root package name */
    CaptureRedDotConfig f281337d;

    /* renamed from: g, reason: collision with root package name */
    public static final Long f281327g = 2000L;

    /* renamed from: m, reason: collision with root package name */
    static Object f281333m = new Object();

    /* renamed from: f, reason: collision with root package name */
    HashMap<Integer, Object> f281339f = new HashMap<>();

    /* renamed from: a, reason: collision with root package name */
    List<com.tencent.mobileqq.richmedia.capture.data.a> f281334a = new CopyOnWriteArrayList();

    /* renamed from: e, reason: collision with root package name */
    public Handler f281338e = new Handler(ThreadManagerV2.getSubThreadLooper());

    /* renamed from: com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager$7, reason: invalid class name */
    /* loaded from: classes18.dex */
    class AnonymousClass7 implements Runnable {
        final /* synthetic */ CapturePtvTemplateManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.v(true);
            if (QLog.isColorLevel()) {
                QLog.d("QIMRedDotConfig", 2, "saved to red dot config file");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private static final CapturePtvTemplateManager f281350a = new CapturePtvTemplateManager();
    }

    static {
        f281328h = "ptv_template_usable";
        f281329i = "ptv_debug";
        f281332l = "new_ptv_template_usable";
        File cacheDir = BaseApplicationImpl.getApplication().getCacheDir();
        f281330j = new File(cacheDir, "capture_ptv_template");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(f281330j.getPath());
        String str = File.separator;
        sb5.append(str);
        sb5.append(f281328h);
        sb5.append(str);
        f281328h = sb5.toString();
        f281329i = f281330j.getPath() + str + f281329i;
        f281331k = new File(cacheDir, "new_ptv_template");
        f281332l = f281331k.getPath() + str + f281332l + str;
    }

    CapturePtvTemplateManager() {
    }

    public static String c(String str, String str2) {
        String str3 = f281328h + str;
        String str4 = f281332l + str2 + File.separator + str;
        if (new File(str4).exists()) {
            return str4;
        }
        return str3;
    }

    public static String d(String str) {
        return f281332l + str + File.separator;
    }

    public static final CapturePtvTemplateManager e() {
        return c.f281350a;
    }

    public static boolean j() {
        File file = new File(f281330j, "ptv_template_new.cfg");
        File file2 = new File(f281330j, "temp_ptv_template_zip");
        if (file.exists() && file2.exists()) {
            return true;
        }
        return false;
    }

    public static boolean l(String str, String str2, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(f281331k, str2);
        boolean exists = file.exists();
        if (!exists) {
            file = new File(f281330j, str);
            if (file.exists()) {
                try {
                    String calcMd5 = FileUtils.calcMd5(file.getPath());
                    if (!TextUtils.isEmpty(calcMd5)) {
                        if (calcMd5.equalsIgnoreCase(str2)) {
                            exists = true;
                        }
                    }
                } catch (UnsatisfiedLinkError e16) {
                    if (QLog.isColorLevel()) {
                        e16.printStackTrace();
                    }
                }
            }
        }
        if (!exists) {
            return false;
        }
        String str3 = c(str, str2) + File.separator;
        File file2 = new File(str3, IVideoFilterTools.CONFIG_FILE);
        File file3 = new File(str3, "params.dat");
        long length = file2.length();
        if ((!file2.exists() || length >= 1) && (file2.exists() || (z16 && file3.exists()))) {
            return true;
        }
        try {
            ZipUtils.unZipFile(file, d(str2));
            return true;
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                e17.printStackTrace();
            }
            return false;
        }
    }

    private static boolean m(String str, String str2, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(f281330j, str);
        if (!file.exists()) {
            return false;
        }
        try {
            String calcMd5 = FileUtils.calcMd5(file.getPath());
            if (TextUtils.isEmpty(calcMd5) || !calcMd5.equalsIgnoreCase(str2)) {
                return false;
            }
            String str3 = f281328h + str + File.separator;
            File file2 = new File(str3, IVideoFilterTools.CONFIG_FILE);
            File file3 = new File(str3, "params.dat");
            long length = file2.length();
            if ((!file2.exists() || length >= 1) && (file2.exists() || (z16 && file3.exists()))) {
                return true;
            }
            try {
                ZipUtils.unZipFile(new File(f281330j, str), f281328h);
                return true;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    e16.printStackTrace();
                }
                return false;
            }
        } catch (UnsatisfiedLinkError e17) {
            if (QLog.isColorLevel()) {
                e17.printStackTrace();
            }
            return false;
        }
    }

    public static String n(File file) {
        byte[] fileToBytes = FileUtils.fileToBytes(file);
        if (fileToBytes == null || fileToBytes.length <= 0) {
            return null;
        }
        try {
            return new String(fileToBytes, "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            if (!QLog.isDevelopLevel()) {
                return null;
            }
            e16.printStackTrace();
            return null;
        }
    }

    static List<com.tencent.mobileqq.richmedia.capture.data.a> o(JSONArray jSONArray, CaptureRedDotConfig captureRedDotConfig) {
        int length;
        int i3;
        String str;
        String str2;
        CaptureRedDotConfig.CategoryRedConfig categoryRedConfig;
        JSONArray jSONArray2 = jSONArray;
        CaptureRedDotConfig captureRedDotConfig2 = captureRedDotConfig;
        String str3 = "commonRes";
        String str4 = "Tips";
        if (QLog.isColorLevel()) {
            QLog.i("CapturePtvTemplateManager", 2, "parse config: " + jSONArray2);
        }
        if (jSONArray2 == null || (length = jSONArray.length()) <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i16 = 0;
        while (i16 < length) {
            try {
                com.tencent.mobileqq.richmedia.capture.data.a aVar = new com.tencent.mobileqq.richmedia.capture.data.a();
                JSONObject jSONObject = jSONArray2.getJSONObject(i16);
                if (jSONObject.has("content")) {
                    aVar.f281360a = PtvTemplateManager.PtvTemplateInfo.convertFrom(jSONObject.getJSONArray("content"));
                }
                if (jSONObject.has("categoryName")) {
                    aVar.f281362c = jSONObject.getString("categoryName");
                }
                if (jSONObject.has("TipsVer") && jSONObject.has(str4)) {
                    aVar.f281364e = jSONObject.getInt("TipsVer");
                    aVar.f281363d = jSONObject.getString(str4);
                }
                if (jSONObject.has("categoryId")) {
                    aVar.f281361b = jSONObject.getInt("categoryId");
                    if (captureRedDotConfig2 != null) {
                        int optInt = jSONObject.optInt("redDotVersion");
                        boolean optBoolean = jSONObject.optBoolean("needRedDot");
                        categoryRedConfig = captureRedDotConfig2.categories.get(Integer.valueOf(aVar.f281361b));
                        if (categoryRedConfig != null) {
                            if (categoryRedConfig.version != optInt) {
                                categoryRedConfig.version = optInt;
                                categoryRedConfig.showRedDot = optBoolean;
                                categoryRedConfig.hasShow = false;
                                i3 = i16;
                                categoryRedConfig.firstShowTime = 0L;
                            } else {
                                i3 = i16;
                            }
                        } else {
                            i3 = i16;
                            categoryRedConfig = new CaptureRedDotConfig.CategoryRedConfig();
                            categoryRedConfig.categoryId = aVar.f281361b;
                            categoryRedConfig.version = optInt;
                            categoryRedConfig.showRedDot = optBoolean;
                        }
                    } else {
                        i3 = i16;
                        categoryRedConfig = null;
                    }
                    List<PtvTemplateManager.PtvTemplateInfo> list = aVar.f281360a;
                    if (list != null && !list.isEmpty()) {
                        for (PtvTemplateManager.PtvTemplateInfo ptvTemplateInfo : aVar.f281360a) {
                            ptvTemplateInfo.categoryId = aVar.f281361b;
                            ptvTemplateInfo.categoryName = aVar.f281362c;
                        }
                    }
                    if (captureRedDotConfig2 != null && categoryRedConfig != null) {
                        captureRedDotConfig2.categories.put(Integer.valueOf(categoryRedConfig.categoryId), categoryRedConfig);
                    }
                } else {
                    i3 = i16;
                }
                if (jSONObject.has(str3)) {
                    try {
                        JSONObject jSONObject2 = jSONObject.getJSONObject(str3);
                        String string = jSONObject2.getString("dg_stage_name");
                        RecentDanceConfigMgr.p(string);
                        String string2 = jSONObject2.getString("dg_stage_resurl");
                        String string3 = jSONObject2.getString("dg_stage_resmd5");
                        String string4 = jSONObject2.getString("dg_model_name");
                        String string5 = jSONObject2.getString("dg_model_resurl");
                        String string6 = jSONObject2.getString("dg_model_resmd5");
                        List<PtvTemplateManager.PtvTemplateInfo> list2 = aVar.f281360a;
                        if (list2 != null) {
                            Iterator<PtvTemplateManager.PtvTemplateInfo> it = list2.iterator();
                            while (it.hasNext()) {
                                Iterator<PtvTemplateManager.PtvTemplateInfo> it5 = it;
                                PtvTemplateManager.PtvTemplateInfo next = it.next();
                                str = str3;
                                try {
                                    int i17 = next.kind;
                                    str2 = str4;
                                    if (i17 == 3 || i17 == 4) {
                                        try {
                                            next.dgStageName = string;
                                            next.dgStageResurl = string2;
                                            next.dgStageResmd5 = string3;
                                            next.dgModelName = string4;
                                            next.dgModelResurl = string5;
                                            next.dgModelResmd5 = string6;
                                        } catch (Exception e16) {
                                            e = e16;
                                            e.printStackTrace();
                                            arrayList.add(aVar);
                                            i16 = i3 + 1;
                                            jSONArray2 = jSONArray;
                                            captureRedDotConfig2 = captureRedDotConfig;
                                            str3 = str;
                                            str4 = str2;
                                        }
                                    }
                                    str3 = str;
                                    it = it5;
                                    str4 = str2;
                                } catch (Exception e17) {
                                    e = e17;
                                    str2 = str4;
                                    e.printStackTrace();
                                    arrayList.add(aVar);
                                    i16 = i3 + 1;
                                    jSONArray2 = jSONArray;
                                    captureRedDotConfig2 = captureRedDotConfig;
                                    str3 = str;
                                    str4 = str2;
                                }
                            }
                        }
                    } catch (Exception e18) {
                        e = e18;
                        str = str3;
                    }
                }
                str = str3;
                str2 = str4;
                arrayList.add(aVar);
                i16 = i3 + 1;
                jSONArray2 = jSONArray;
                captureRedDotConfig2 = captureRedDotConfig;
                str3 = str;
                str4 = str2;
            } catch (JSONException e19) {
                if (QLog.isColorLevel()) {
                    e19.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    static List<com.tencent.mobileqq.richmedia.capture.data.a> p(CapturePtvTemplateManager capturePtvTemplateManager, String str, CaptureRedDotConfig captureRedDotConfig) {
        String str2;
        String str3;
        JSONObject jSONObject;
        if (QLog.isColorLevel()) {
            QLog.i("CapturePtvTemplateManager", 2, "parseConfigRaw " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (capturePtvTemplateManager != null) {
                if (jSONObject2.has("guide_video_url")) {
                    capturePtvTemplateManager.f281335b = jSONObject2.getString("guide_video_url");
                }
                if (jSONObject2.has("guide_video_md5")) {
                    capturePtvTemplateManager.f281336c = jSONObject2.getString("guide_video_md5");
                }
                if (jSONObject2.has("gestureGapFrame")) {
                    a.f.f374010a = jSONObject2.getString("gestureGapFrame");
                }
                if (jSONObject2.has("gestureGapTime")) {
                    a.f.f374011b = jSONObject2.getString("gestureGapTime");
                }
                if (jSONObject2.has("gesturethreadcoldtime")) {
                    a.f.f374012c = jSONObject2.getString("gesturethreadcoldtime");
                }
                if (jSONObject2.has("gestureShouldUpload")) {
                    a.f.f374013d = jSONObject2.getBoolean("gestureShouldUpload");
                }
            }
            String str4 = "";
            if (!jSONObject2.has("bigheadCommonRes") || (jSONObject = jSONObject2.getJSONObject("bigheadCommonRes")) == null) {
                str2 = "";
                str3 = str2;
            } else {
                String optString = jSONObject.optString("bighead_model_name", "");
                str3 = jSONObject.optString("bighead_model_resurl", "");
                str2 = jSONObject.optString("bighead_model_resmd5", "");
                str4 = optString;
            }
            if (captureRedDotConfig != null) {
                int optInt = jSONObject2.optInt("iconRedDotVersion");
                boolean optBoolean = jSONObject2.optBoolean("needRedDot");
                int optInt2 = jSONObject2.optInt("redDotShowTime", CaptureRedDotConfig.SHOW_TIME_DEFAULT);
                if (QLog.isColorLevel()) {
                    QLog.d("QIMRedDotConfig_PTV", 2, "parseConfig|oldVer= " + captureRedDotConfig.iconVersion + ",ver=" + optInt + ",showRed=" + optBoolean + ",showTime=" + optInt2);
                }
                captureRedDotConfig.showTime = optInt2;
                if (captureRedDotConfig.iconVersion != optInt) {
                    captureRedDotConfig.iconVersion = optInt;
                    captureRedDotConfig.showRedDot = optBoolean;
                    captureRedDotConfig.hasShow = false;
                    captureRedDotConfig.firstShowTime = 0L;
                }
                int optInt3 = jSONObject2.optInt("defaultCategoryVersion");
                int optInt4 = jSONObject2.optInt("defaultCategoryId", -1);
                if (QLog.isColorLevel()) {
                    QLog.d("QIMRedDotConfig_PTV", 2, "parseConfig|oldVer= " + captureRedDotConfig.defaultCategoryVer + ",ver=" + optInt3 + ",defaultCategoryId=" + optInt4);
                }
                if (captureRedDotConfig.defaultCategoryVer != optInt3) {
                    captureRedDotConfig.defaultCategoryVer = optInt3;
                    captureRedDotConfig.defaultCategoryId = optInt4;
                    captureRedDotConfig.hasChoose = false;
                }
                int optInt5 = jSONObject2.optInt("defaultUseVersion");
                String optString2 = jSONObject2.optString("defaultUseId");
                if (QLog.isColorLevel()) {
                    QLog.d("QIMRedDotConfig_PTV", 2, "parseConfig|oldVer= " + captureRedDotConfig.defaultUseVer + ",ver=" + optInt5 + ",defaultUseId=" + optString2);
                }
                if (captureRedDotConfig.defaultUseVer != optInt5) {
                    captureRedDotConfig.defaultUseVer = optInt5;
                    captureRedDotConfig.defaultUseId = optString2;
                    captureRedDotConfig.hasUse = false;
                }
                int optInt6 = jSONObject2.optInt("itemRedDotVersion");
                if (captureRedDotConfig.redDotVersion != optInt6) {
                    captureRedDotConfig.redDotVersion = optInt6;
                    captureRedDotConfig.redDotItems.clear();
                    if (jSONObject2.has("itemNeedRedDot")) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("parseConfig|redDotList:");
                        JSONArray jSONArray = jSONObject2.getJSONArray("itemNeedRedDot");
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            String optString3 = jSONArray.optString(i3);
                            if (!TextUtils.isEmpty(optString3)) {
                                CaptureRedDotConfig.RedDotItemConfig redDotItemConfig = new CaptureRedDotConfig.RedDotItemConfig();
                                redDotItemConfig.filterId = optString3;
                                sb5.append(optString3);
                                sb5.append(",");
                                captureRedDotConfig.redDotItems.put(optString3, redDotItemConfig);
                            }
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("QIMRedDotConfig_PTV", 2, "parseConfig|redDotItem= " + sb5.toString());
                        }
                    }
                }
            }
            if (jSONObject2.has("category")) {
                List<com.tencent.mobileqq.richmedia.capture.data.a> o16 = o(jSONObject2.getJSONArray("category"), captureRedDotConfig);
                s(o16, str4, str3, str2);
                return o16;
            }
            return null;
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                e16.printStackTrace();
                return null;
            }
            return null;
        }
    }

    private void q(QQAppInterface qQAppInterface, String str) {
        synchronized (f281333m) {
            if (this.f281337d == null) {
                this.f281337d = new CaptureRedDotConfig(2);
                if (QLog.isColorLevel()) {
                    QLog.d("QIMRedDotConfig_PTV", 2, "parseFilterConfigZip RedDot is null");
                }
            }
        }
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip TextUtils.isEmpty(config) return");
            }
            f.k(-1);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip config=" + str);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String str2 = "";
            String str3 = "";
            String str4 = "";
            if (jSONObject.has("pendantMD5")) {
                str2 = jSONObject.getString("pendantMD5");
            }
            String str5 = str2;
            if (jSONObject.has("pendantUrl")) {
                str3 = jSONObject.getString("pendantUrl");
            }
            String str6 = str3;
            if (jSONObject.has("pendantName")) {
                str4 = jSONObject.getString("pendantName");
            }
            if (QLog.isColorLevel()) {
                QLog.d("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip pendantMD5=" + str5 + " pendantUrl=" + str6);
            }
            if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(f281330j);
                String str7 = File.separator;
                sb5.append(str7);
                String sb6 = sb5.toString();
                String str8 = f281330j + str7 + str4;
                File file = new File(f281330j, "temp_ptv_template_zip");
                if (file.exists()) {
                    file.delete();
                    if (QLog.isColorLevel()) {
                        QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip file.delete()");
                    }
                }
                File file2 = new File(str8);
                if (file2.exists()) {
                    file2.delete();
                    if (QLog.isColorLevel()) {
                        QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip filejson.delete()");
                    }
                }
                HttpNetReq httpNetReq = new HttpNetReq();
                httpNetReq.mCallback = new a(str5, sb6, qQAppInterface, str8);
                httpNetReq.mReqUrl = str6;
                httpNetReq.mHttpMethod = 0;
                httpNetReq.mOutPath = file.getPath();
                httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
                try {
                    AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                    if (QQAppInterface.class.isInstance(runtime)) {
                        ((IHttpEngineService) ((QQAppInterface) runtime).getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
                        if (QLog.isColorLevel()) {
                            QLog.i("CapturePtvTemplateManager", 2, "startDownloadFilterConfigZip, url: " + str6);
                            return;
                        }
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.w("CapturePtvTemplateManager_PTV", 2, "zipMd5 or zipUrl empty return!");
            }
            f.k(-1);
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                e16.printStackTrace();
            }
        }
    }

    private static void s(List<com.tencent.mobileqq.richmedia.capture.data.a> list, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && list != null && list.size() > 0) {
            for (com.tencent.mobileqq.richmedia.capture.data.a aVar : list) {
                List<PtvTemplateManager.PtvTemplateInfo> list2 = aVar.f281360a;
                if (list2 != null && list2.size() > 0) {
                    for (PtvTemplateManager.PtvTemplateInfo ptvTemplateInfo : aVar.f281360a) {
                        if (ptvTemplateInfo != null && ptvTemplateInfo.kind == 20) {
                            ptvTemplateInfo.bigHeadName = str;
                            ptvTemplateInfo.bigHeadUrl = str2;
                            ptvTemplateInfo.bigHeadMd5 = str3;
                        }
                    }
                }
            }
        }
    }

    private void t(File file, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i("CapturePtvTemplateManager", 2, String.format("rebuildTemplateInfos, cur_runnable[%s]", Integer.valueOf(hashCode())));
        }
        if (this.f281334a.size() > 0) {
            return;
        }
        String n3 = n(file);
        if (TextUtils.isEmpty(n3)) {
            return;
        }
        List<com.tencent.mobileqq.richmedia.capture.data.a> p16 = p(e(), n3, null);
        if (p16 != null) {
            this.f281334a.clear();
            this.f281334a.addAll(p16);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QIMRedDotConfig_PTV", 2, "rebuildTemplateInfos");
        }
        x(p16, z16);
        b();
    }

    static void u(final String str, final String str2) {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager.2
            @Override // java.lang.Runnable
            public void run() {
                FileUtils.writeFile(CapturePtvTemplateManager.f281330j.getPath() + File.separator, str2, str);
                if (QLog.isColorLevel()) {
                    QLog.i("CapturePtvTemplateManager", 2, "save Config to file finish.");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        ArrayList<com.tencent.mobileqq.richmedia.capture.data.a> arrayList = new ArrayList();
        arrayList.addAll(this.f281334a);
        int i3 = 0;
        int i16 = 0;
        for (com.tencent.mobileqq.richmedia.capture.data.a aVar : arrayList) {
            if (aVar.f281360a != null) {
                ArrayList<PtvTemplateManager.PtvTemplateInfo> arrayList2 = new ArrayList();
                arrayList2.addAll(aVar.f281360a);
                for (PtvTemplateManager.PtvTemplateInfo ptvTemplateInfo : arrayList2) {
                    if (ptvTemplateInfo != null) {
                        i16++;
                        boolean k3 = k(ptvTemplateInfo);
                        ptvTemplateInfo.usable = k3;
                        if (k3) {
                            i3++;
                        }
                    }
                }
            }
        }
        ea.f3(i3, i16);
    }

    public void b() {
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager.4
            @Override // java.lang.Runnable
            public void run() {
                boolean m3 = com.tencent.mobileqq.shortvideo.util.f.m();
                boolean isNetSupport = NetworkUtil.isNetSupport(BaseApplication.getContext());
                boolean z16 = true;
                if (MobileQQ.sProcessId == 1) {
                    z16 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("CapturePtvTemplateManager", 2, "dealyPreDownload isSupport: " + m3 + " isNetWorkSupport: " + isNetSupport);
                }
                if (m3 && isNetSupport && z16) {
                    CapturePtvTemplateManager capturePtvTemplateManager = CapturePtvTemplateManager.this;
                    capturePtvTemplateManager.r(capturePtvTemplateManager.f281334a);
                }
            }
        }, f281327g.longValue());
    }

    public void f(QQAppInterface qQAppInterface, String str, int i3) {
        q(qQAppInterface, str);
    }

    public void g(final boolean z16) {
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager.1
            /* JADX WARN: Removed duplicated region for block: B:15:0x0061  */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0075  */
            /* JADX WARN: Removed duplicated region for block: B:46:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                InputStream inputStream;
                Throwable th5;
                String str;
                List<com.tencent.mobileqq.richmedia.capture.data.a> p16;
                if (!CapturePtvTemplateManager.this.f281334a.isEmpty() && !z16) {
                    return;
                }
                try {
                    inputStream = BaseApplication.getContext().getAssets().open("ptv_template_new.cfg");
                } catch (IOException e16) {
                    e = e16;
                    inputStream = null;
                } catch (Throwable th6) {
                    inputStream = null;
                    th5 = th6;
                    if (inputStream != null) {
                    }
                    throw th5;
                }
                try {
                    try {
                        str = k.h(inputStream);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e17) {
                                if (QLog.isColorLevel()) {
                                    e17.printStackTrace();
                                }
                            }
                        }
                    } catch (Throwable th7) {
                        th5 = th7;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e18) {
                                if (QLog.isColorLevel()) {
                                    e18.printStackTrace();
                                }
                            }
                        }
                        throw th5;
                    }
                } catch (IOException e19) {
                    e = e19;
                    if (QLog.isColorLevel()) {
                        e.printStackTrace();
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e26) {
                            if (QLog.isColorLevel()) {
                                e26.printStackTrace();
                            }
                        }
                    }
                    str = "";
                    p16 = CapturePtvTemplateManager.p(CapturePtvTemplateManager.this, str, null);
                    if (p16 != null) {
                    }
                    if (QLog.isColorLevel()) {
                    }
                    CapturePtvTemplateManager.this.x(p16, false);
                    CapturePtvTemplateManager.this.getClass();
                }
                p16 = CapturePtvTemplateManager.p(CapturePtvTemplateManager.this, str, null);
                if (p16 != null) {
                    CapturePtvTemplateManager.this.f281334a.clear();
                    CapturePtvTemplateManager.this.f281334a.addAll(p16);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QIMRedDotConfig_PTV", 2, "initAssetsFile");
                }
                CapturePtvTemplateManager.this.x(p16, false);
                CapturePtvTemplateManager.this.getClass();
            }
        }, null, false);
    }

    @TargetApi(9)
    public void h(boolean z16) {
        i();
        File file = new File(f281330j, "ptv_template_new.cfg");
        if (!file.exists()) {
            if (QLog.isColorLevel()) {
                QLog.d("CapturePtvTemplateManager", 2, "initLocalTemplateConfigInfo config file not exist.");
            }
            g(false);
            return;
        }
        t(file, z16);
    }

    public void i() {
        CaptureRedDotConfig redDotConfigFromFile = CaptureRedDotConfig.getRedDotConfigFromFile(f281330j.getAbsolutePath(), "_PTV");
        if (redDotConfigFromFile != null) {
            synchronized (f281333m) {
                if (this.f281337d == null) {
                    this.f281337d = redDotConfigFromFile;
                }
            }
        }
    }

    public boolean k(PtvTemplateManager.PtvTemplateInfo ptvTemplateInfo) {
        if (ptvTemplateInfo == null) {
            return false;
        }
        int i3 = ptvTemplateInfo.kind;
        if (i3 == 3) {
            ptvTemplateInfo.dgStageUsable = m(ptvTemplateInfo.dgStageName, ptvTemplateInfo.dgStageResmd5, false);
            ptvTemplateInfo.dgModelUsable = m(ptvTemplateInfo.dgModelName, ptvTemplateInfo.dgModelResmd5, false);
            boolean m3 = m(ptvTemplateInfo.name, ptvTemplateInfo.md5, false);
            if (QLog.isColorLevel()) {
                QLog.d("CapturePtvTemplateManager", 2, String.format("isDGTemplateUsage stage[%s], model[%s], total[%s], id[%s]", Boolean.valueOf(ptvTemplateInfo.dgStageUsable), Boolean.valueOf(ptvTemplateInfo.dgModelUsable), Boolean.valueOf(m3), ptvTemplateInfo.f287668id));
            }
            if (!ptvTemplateInfo.dgStageUsable || !ptvTemplateInfo.dgModelUsable) {
                return false;
            }
            return m3;
        }
        if (i3 == 20) {
            if (!ptvTemplateInfo.bigHeadModelUsable) {
                ptvTemplateInfo.bigHeadModelUsable = m(ptvTemplateInfo.bigHeadName, ptvTemplateInfo.bigHeadMd5, false);
            }
            boolean m16 = m(ptvTemplateInfo.name, ptvTemplateInfo.md5, false);
            if (QLog.isColorLevel()) {
                QLog.d("CapturePtvTemplateManager", 2, String.format("isDGTemplateUsage stage[%s], model[%s], total[%s], id[%s]", Boolean.valueOf(ptvTemplateInfo.dgStageUsable), Boolean.valueOf(ptvTemplateInfo.dgModelUsable), Boolean.valueOf(m16), ptvTemplateInfo.f287668id));
            }
            if (!ptvTemplateInfo.bigHeadModelUsable) {
                return false;
            }
            return m16;
        }
        if (i3 == 4) {
            boolean m17 = m(ptvTemplateInfo.dgStageName, ptvTemplateInfo.dgStageResmd5, false);
            ptvTemplateInfo.dgStageUsable = m17;
            if (!m17) {
                return false;
            }
            return m(ptvTemplateInfo.name, ptvTemplateInfo.md5, false);
        }
        return l(ptvTemplateInfo.name, ptvTemplateInfo.md5, true);
    }

    void r(List<com.tencent.mobileqq.richmedia.capture.data.a> list) {
        AppRuntime onGetSubRuntime;
        if (list != null && !list.isEmpty()) {
            Iterator<com.tencent.mobileqq.richmedia.capture.data.a> it = list.iterator();
            while (it.hasNext()) {
                List<PtvTemplateManager.PtvTemplateInfo> list2 = it.next().f281360a;
                if (list2 != null) {
                    for (int i3 = 0; i3 < list2.size(); i3++) {
                        PtvTemplateManager.PtvTemplateInfo ptvTemplateInfo = list2.get(i3);
                        if (ptvTemplateInfo != null && ptvTemplateInfo.predownload && !TextUtils.isEmpty(ptvTemplateInfo.resurl)) {
                            if (k(ptvTemplateInfo)) {
                                ptvTemplateInfo.usable = true;
                            } else {
                                ptvTemplateInfo.usable = false;
                                int availableInnernalMemorySize = (int) ((FileUtils.getAvailableInnernalMemorySize() / 1024.0f) / 1024.0f);
                                int i16 = (int) (ptvTemplateInfo.sizeFree * 1024.0d);
                                if (QLog.isColorLevel()) {
                                    QLog.d("CapturePtvTemplateManager", 2, "preDownloadTemplates getAvailableInnernalMemorySize: " + availableInnernalMemorySize + " mSizeFree: " + i16);
                                }
                                if (availableInnernalMemorySize < i16) {
                                    if (QLog.isColorLevel()) {
                                        QLog.i("CapturePtvTemplateManager", 2, "preDownloadTemplates return getAvailableInnernalMemorySize: " + availableInnernalMemorySize + " mSizeFree: " + i16);
                                        return;
                                    }
                                    return;
                                }
                                HttpNetReq httpNetReq = new HttpNetReq();
                                httpNetReq.mCallback = new b(ptvTemplateInfo);
                                httpNetReq.mReqUrl = ptvTemplateInfo.resurl;
                                httpNetReq.mHttpMethod = 0;
                                httpNetReq.mOutPath = new File(f281331k, ptvTemplateInfo.md5).getPath();
                                httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
                                try {
                                    AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                                    if (runtime != null && (runtime instanceof ToolRuntimePeak) && (onGetSubRuntime = ((ToolRuntimePeak) runtime).onGetSubRuntime("peak")) != null) {
                                        ((IHttpEngineService) ((PeakAppInterface) onGetSubRuntime).getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
                                        if (QLog.isColorLevel()) {
                                            QLog.i("CapturePtvTemplateManager", 2, "startDownloadFilterConfigZip, url: " + ptvTemplateInfo.resurl);
                                        }
                                    }
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void v(boolean z16) {
        if (z16) {
            CaptureRedDotConfig captureRedDotConfig = this.f281337d;
            if (captureRedDotConfig != null && captureRedDotConfig.update) {
                captureRedDotConfig.update = false;
                CaptureRedDotConfig.saveRedDotConfig(captureRedDotConfig, f281330j.getAbsolutePath(), "_PTV");
                return;
            }
            return;
        }
        CaptureRedDotConfig.saveRedDotConfig(this.f281337d, f281330j.getAbsolutePath(), "_PTV");
    }

    public void x(List<com.tencent.mobileqq.richmedia.capture.data.a> list, boolean z16) {
        if (list != null && !list.isEmpty()) {
            if (z16) {
                w();
            } else {
                ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager.6
                    @Override // java.lang.Runnable
                    public void run() {
                        CapturePtvTemplateManager.this.w();
                        CapturePtvTemplateManager.this.getClass();
                    }
                });
            }
            if (QLog.isColorLevel()) {
                QLog.d("CapturePtvTemplateManager", 2, "updateFaceuTemplateConfigInfo size=" + this.f281334a.size());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class a implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f281343d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f281344e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f281345f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f281346h;

        a(String str, String str2, QQAppInterface qQAppInterface, String str3) {
            this.f281343d = str;
            this.f281344e = str2;
            this.f281345f = qQAppInterface;
            this.f281346h = str3;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            String str;
            if (QLog.isColorLevel()) {
                QLog.i("CapturePtvTemplateManager_PTV", 2, "onResp resultcode: " + netResp.mHttpCode + " threadid=" + Thread.currentThread().getId());
            }
            File file = new File(CapturePtvTemplateManager.f281330j, "temp_ptv_template_zip");
            if (!file.exists()) {
                if (QLog.isColorLevel()) {
                    QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip !zipfile.exists()");
                }
                f.k(0);
                return;
            }
            try {
                str = FileUtils.calcMd5(file.getPath());
            } catch (UnsatisfiedLinkError e16) {
                if (QLog.isColorLevel()) {
                    e16.printStackTrace();
                }
                str = "";
            }
            if (!TextUtils.isEmpty(this.f281343d) && this.f281343d.equalsIgnoreCase(str)) {
                try {
                    ZipUtils.unZipFile(file, this.f281344e);
                } catch (Exception e17) {
                    f.k(-3);
                    ea.Y2(this.f281345f.getApp(), 0);
                    if (QLog.isColorLevel()) {
                        e17.printStackTrace();
                    }
                }
            } else {
                f.k(-2);
            }
            File file2 = new File(this.f281346h);
            if (file2.exists()) {
                String n3 = CapturePtvTemplateManager.n(file2);
                List<com.tencent.mobileqq.richmedia.capture.data.a> p16 = CapturePtvTemplateManager.p(null, n3, CapturePtvTemplateManager.this.f281337d);
                if (p16 != null && !p16.isEmpty()) {
                    CapturePtvTemplateManager.u(n3, "ptv_template_new.cfg");
                    CapturePtvTemplateManager.this.v(false);
                    if (QLog.isColorLevel()) {
                        QLog.d("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip finsh configContent=" + n3);
                    }
                    f.k(1);
                    return;
                }
                CapturePtvTemplateManager.u(n3, "ptv_template_new.cfg");
                if (QLog.isColorLevel()) {
                    QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip null == infos || infos.isEmpty()");
                }
                f.k(-4);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip !jsonFile.exists()");
            }
            ea.Y2(this.f281345f.getApp(), 0);
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class b implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PtvTemplateManager.PtvTemplateInfo f281348d;

        b(PtvTemplateManager.PtvTemplateInfo ptvTemplateInfo) {
            this.f281348d = ptvTemplateInfo;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            if (QLog.isColorLevel()) {
                QLog.i("CapturePtvTemplateManager", 2, "onResp url: " + this.f281348d.resurl + " resultcode: " + netResp.mHttpCode);
            }
            PtvTemplateManager.PtvTemplateInfo ptvTemplateInfo = this.f281348d;
            ptvTemplateInfo.usable = CapturePtvTemplateManager.this.k(ptvTemplateInfo);
            if (this.f281348d.usable) {
                try {
                    ZipUtils.unZipFile(new File(CapturePtvTemplateManager.f281331k, this.f281348d.md5), CapturePtvTemplateManager.d(this.f281348d.md5));
                } catch (IOException e16) {
                    if (QLog.isColorLevel()) {
                        e16.printStackTrace();
                    }
                }
                CapturePtvTemplateManager.this.getClass();
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        }
    }
}
