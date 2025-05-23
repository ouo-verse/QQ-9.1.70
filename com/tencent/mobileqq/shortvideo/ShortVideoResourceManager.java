package com.tencent.mobileqq.shortvideo;

import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.ams.fusion.widget.cny2025.twist.CNYTwistArrowLayer;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.x;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.video.decode.AVDecodeError;
import com.tencent.video.decode.ShortVideoSoLoad;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import mqq.manager.Manager;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ShortVideoResourceManager implements Manager, INetEngineListener, x.a {
    public static final String E;
    public static final String F;
    public static final String G;
    public static final String H;

    /* renamed from: i, reason: collision with root package name */
    public static long f287682i;

    /* renamed from: f, reason: collision with root package name */
    private final WeakReference<QQAppInterface> f287686f;

    /* renamed from: m, reason: collision with root package name */
    private static c f287683m = new c();
    private static ArrayList<x.a> C = new ArrayList<>();
    private static final Object D = new Object();

    /* renamed from: d, reason: collision with root package name */
    private HashMap<String, d> f287684d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private final Object f287685e = new Object();

    /* renamed from: h, reason: collision with root package name */
    private INetInfoHandler f287687h = new a();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.shortvideo.ShortVideoResourceManager$4, reason: invalid class name */
    /* loaded from: classes18.dex */
    class AnonymousClass4 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f287693d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f287694e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f287695f;

        @Override // java.lang.Runnable
        public void run() {
            ShortVideoResourceManager.t(this.f287693d, this.f287694e, this.f287695f, "new_qq_android_native_short_other_");
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.shortvideo.ShortVideoResourceManager$6, reason: invalid class name */
    /* loaded from: classes18.dex */
    class AnonymousClass6 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f287699d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f287700e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f287701f;

        @Override // java.lang.Runnable
        public void run() {
            ShortVideoResourceManager.t(this.f287699d, this.f287700e, this.f287701f, "new_qq_android_native_portrait_filter_");
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class SVConfigItem {
        public String arm64v8a_md5;
        public String arm64v8a_url;
        public String arm_md5;
        public String arm_url;
        public String armv7a_md5;
        public String armv7a_url;
        public String extend1;
        public String extend2;
        public String name;
        public boolean predownload;
        public int versionCode;
        public String x86_md5;
        public String x86_url;

        public boolean check64BitReady() {
            if (!StringUtil.isEmpty(this.arm64v8a_md5) && !StringUtil.isEmpty(this.arm64v8a_url)) {
                return true;
            }
            return false;
        }

        public String getSignature() {
            if (VideoEnvironment64BitUtils.checkIs64bit() && check64BitReady()) {
                return this.arm64v8a_md5 + util.base64_pad_url + this.versionCode;
            }
            return this.armv7a_md5 + util.base64_pad_url + this.versionCode;
        }

        public String toString() {
            return "SVConfigItem{name='" + this.name + "', arm_url='" + this.arm_url + "', armv7a_url='" + this.armv7a_url + "', x86_url='" + this.x86_url + "', arm64v8a_url='" + this.arm64v8a_url + "', arm_md5='" + this.arm_md5 + "', armv7a_md5='" + this.armv7a_md5 + "', x86_md5='" + this.x86_md5 + "', arm64v8a_md5='" + this.arm64v8a_md5 + "', versionCode=" + this.versionCode + ", predownload=" + this.predownload + ", extend1='" + this.extend1 + "', extend2='" + this.extend2 + "'}";
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final String f287706a;

        /* renamed from: b, reason: collision with root package name */
        public static final String f287707b;

        static {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(ShortVideoResourceManager.F);
            String str = File.separator;
            sb5.append(str);
            sb5.append("ae");
            f287706a = sb5.toString();
            f287707b = ShortVideoResourceManager.E + str + "ae";
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class c {

        /* renamed from: b, reason: collision with root package name */
        int f287709b;

        /* renamed from: d, reason: collision with root package name */
        int f287711d;

        /* renamed from: a, reason: collision with root package name */
        volatile int f287708a = 0;

        /* renamed from: c, reason: collision with root package name */
        int f287710c = 0;

        String a() {
            int i3 = this.f287708a;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        return "UNKNOWN_STATUS";
                    }
                    return "CONFIG_SEND_REQ";
                }
                return "CONFIG_START_SERVLET";
            }
            return "CONFIG_REQUEST_OK";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        HttpNetReq f287712a;

        /* renamed from: c, reason: collision with root package name */
        String f287714c;

        /* renamed from: d, reason: collision with root package name */
        int f287715d;

        /* renamed from: b, reason: collision with root package name */
        ArrayList<e> f287713b = new ArrayList<>(1);

        /* renamed from: e, reason: collision with root package name */
        int f287716e = 0;

        d(HttpNetReq httpNetReq) {
            this.f287712a = httpNetReq;
        }

        void a() {
            if (QLog.isColorLevel()) {
                QLog.d("ShortVideoResourceManager", 2, "HttpEngineTask[start]: " + this);
            }
            this.f287716e = 1;
            if (ShortVideoResourceManager.this.f287686f.get() != null) {
                ((IHttpEngineService) ((QQAppInterface) ShortVideoResourceManager.this.f287686f.get()).getRuntimeService(IHttpEngineService.class, "all")).sendReq(this.f287712a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface e {
        void onDownloadFinish(String str, int i3, String str2);

        void onNetWorkNone();

        void onUpdateProgress(String str, long j3, long j16);
    }

    static {
        boolean z16;
        if (BaseApplication.getContext().getExternalFilesDir(null) != null && BaseApplication.getContext().getExternalCacheDir() != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            F = BaseApplication.getContext().getExternalFilesDir(null).getPath();
            E = BaseApplication.getContext().getExternalCacheDir().getPath();
        } else {
            F = BaseApplication.getContext().getFilesDir().getPath();
            E = BaseApplication.getContext().getCacheDir().getPath();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(b.f287706a);
        String str = File.separator;
        sb5.append(str);
        sb5.append("sv_config_resources");
        sb5.append(str);
        G = sb5.toString();
        H = b.f287707b + str + "tmp";
        C();
    }

    public ShortVideoResourceManager(QQAppInterface qQAppInterface) {
        this.f287686f = new WeakReference<>(qQAppInterface);
        AppNetConnInfo.registerConnectionChangeReceiver(VideoEnvironment.getContext(), this.f287687h);
    }

    public static String A() {
        return G;
    }

    public static String B(String str) {
        return A() + str;
    }

    private static void C() {
        File file = new File(A());
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(z());
        if (!file2.exists()) {
            file2.mkdirs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        synchronized (this.f287685e) {
            for (d dVar : this.f287684d.values()) {
                if (dVar != null && dVar.f287713b != null) {
                    for (int i3 = 0; i3 < dVar.f287713b.size(); i3++) {
                        dVar.f287713b.get(i3).onNetWorkNone();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(NetResp netResp) {
        d dVar;
        String str;
        int i3;
        int i16;
        NetReq netReq = netResp.mReq;
        String str2 = netReq.mOutPath;
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "[onResp]filePath=" + str2 + ",resp.mResult=" + netResp.mResult + ",mHttpCode=" + netResp.mHttpCode + ",mErrCode=" + netResp.mErrCode + ",mErrDesc=" + netResp.mErrDesc, null);
        String str3 = (String) netReq.getUserData();
        synchronized (this.f287685e) {
            dVar = this.f287684d.get(str3);
            str = dVar.f287714c;
            i3 = dVar.f287715d;
        }
        String A = A();
        String str4 = A + str3;
        if (netResp.mResult == 0) {
            i16 = R(str3, str, str2);
            VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "[onResp]verifyResource keyName=" + str3 + ",errCode=" + i16, null);
            if (i16 != 0) {
                if (i16 == -108) {
                    boolean J = J(A + str3 + "error", str2);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("[onResp]renameResourceZip, save error file, success=");
                    sb5.append(J);
                    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", sb5.toString(), null);
                }
                j(str2);
                VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "[onResp]verifyResource clearDownloadTempFile errCode=" + i16, null);
            } else if (J(str4, str2)) {
                String str5 = str + util.base64_pad_url + i3;
                if (this.f287686f.get() != null) {
                    i16 = Q(this.f287686f.get(), str3, str5, str4, i3);
                    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "[onRespAsync]signature=" + str5 + ",errCode=" + i16 + ",key=" + str3, null);
                }
            } else {
                j(str4);
                j(str2);
                i16 = -3;
            }
            x.b(str3, i3, 0, i16);
        } else {
            x.b(str3, i3, 1, -117);
            j(str2);
            VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "[onResp]filePath=" + str2 + ",resp.mResult=" + netResp.mResult + ",mErrDesc=" + netResp.mErrDesc + ",mErrDesc=" + netResp.mErrDesc, null);
            i16 = -117;
        }
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "[onRespAsync]errCode=" + i16 + ",saveFilePath=" + str4 + ",key=" + str3, null);
        synchronized (this.f287685e) {
            dVar.f287716e = 3;
            int size = dVar.f287713b.size();
            for (int i17 = 0; i17 < size; i17++) {
                try {
                    if (dVar.f287713b.get(i17) != null && str3 != null) {
                        dVar.f287713b.get(i17).onDownloadFinish(str3, i16, str4);
                    }
                } catch (IndexOutOfBoundsException unused) {
                }
            }
            dVar.f287713b.clear();
            this.f287684d.remove(str3);
        }
    }

    public static int F(String str, List<SVConfigItem> list) {
        JSONArray jSONArray;
        int length;
        int i3 = -100;
        try {
            jSONArray = new JSONArray(str);
            length = jSONArray.length();
        } catch (OutOfMemoryError e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ShortVideoResourceManager", 2, "parseConfigData[OutOfMemoryError]", e16);
            }
            list.clear();
        } catch (JSONException e17) {
            if (QLog.isColorLevel()) {
                QLog.d("ShortVideoResourceManager", 2, "parseConfigData[JSONException]", e17);
            }
            list.clear();
        }
        if (length <= 0) {
            VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "parseConfigData: arrayLength=" + length, null);
            return -100;
        }
        for (int i16 = 0; i16 < length; i16++) {
            SVConfigItem sVConfigItem = (SVConfigItem) JSONUtils.b(jSONArray.getJSONObject(i16), SVConfigItem.class);
            if (sVConfigItem == null) {
                VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "parseConfigData:item=null i=" + i16, null);
                list.clear();
                return -100;
            }
            list.add(sVConfigItem);
        }
        i3 = 0;
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "parseConfigData:errCode=" + i3, null);
        return i3;
    }

    private void G(final List<SVConfigItem> list) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.7
            @Override // java.lang.Runnable
            public void run() {
                ShortVideoResourceManager.this.H(list);
            }
        }, 128, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(List<SVConfigItem> list) {
        boolean z16;
        synchronized (D) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                SVConfigItem sVConfigItem = list.get(i3);
                if (!sVConfigItem.predownload) {
                    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "preDownloadResource:parseConfigData predownload=false", null);
                } else {
                    if (this.f287686f.get() != null) {
                        z16 = h(this.f287686f.get(), sVConfigItem);
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        L(sVConfigItem, null);
                    } else if (this.f287686f.get() != null) {
                        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "preDownloadResourceSync:needDownload=false [doNoNeedDownload] errCode=" + o(this.f287686f.get(), sVConfigItem), null);
                    }
                }
            }
        }
    }

    public static void I(QQAppInterface qQAppInterface, int i3) {
        C();
        if (i3 != 3) {
            u(qQAppInterface, i3, qQAppInterface.getShortVideoResourceManager());
            return;
        }
        throw new Error("preDownloadShortVideoConfigData: call user type...");
    }

    private static boolean J(String str, String str2) {
        synchronized (D) {
            VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "[onResp]renameResourceZip destPath=" + str + ",outPath=" + str2, null);
            File file = new File(str);
            if (file.exists()) {
                file.delete();
                VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "[onResp]renameResourceZip rename  destFile already exists[delete]...", null);
            }
            File file2 = new File(str2);
            long length = file2.length();
            boolean renameTo = file2.renameTo(file);
            VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "[onResp]renameResourceZip orgLength=" + length + ",success=" + renameTo, null);
            if (renameTo) {
                boolean exists = file.exists();
                long length2 = file.length();
                VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "[onResp]renameResourceZip destExists=" + exists + ",destLength=" + length2, null);
                if (exists && length2 == length) {
                    return true;
                }
            }
            return false;
        }
    }

    public static boolean K(String str, int i3) {
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("new_short_video_resource_cfg", 4).edit();
        edit.putString("new_short_video_res_config_key", str);
        edit.putInt("new_short_video_resource_version", i3);
        if (QLog.isColorLevel()) {
            QLog.d("ShortVideoResourceManager", 2, "updateShortVideoResConfigContent| saveContentOK\uff0cconfig_content = " + str);
        }
        return edit.commit();
    }

    public static int M(QQAppInterface qQAppInterface, x.a aVar) {
        C();
        int g16 = g();
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "startUserDownloadConfig[checkLocalConfigIsOK]:errCode=" + g16, null);
        if (g16 != 0) {
            VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "startUserDownloadConfig:netUsable=" + NetworkUtil.isNetworkAvailable(null), null);
            g16 = e(aVar);
            if (g16 == -115) {
                P(qQAppInterface, aVar);
                g16 = 0;
            }
        } else if (aVar != null) {
            aVar.onConfigResult(1, 0);
        }
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "startUserDownloadConfig[end]:errCode=" + g16, null);
        return g16;
    }

    public static void N(final String str) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.9
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(VideoEnvironment.getContext(), "" + str, 1).show();
            }
        });
    }

    private static boolean O() {
        if (((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("short_video_res_check_exists_by_unzip_file")) {
            String shortVideoSoPath = ShortVideoSoLoad.getShortVideoSoPath(BaseApplication.getContext());
            String str = shortVideoSoPath + VideoEnvironment.getShortVideoSoLibName();
            String str2 = shortVideoSoPath + "trim_process_pie";
            String str3 = shortVideoSoPath + "trim_process_pic";
            if (FileUtils.fileExists(str) && FileUtils.fileExists(str2) && FileUtils.fileExists(str3)) {
                return true;
            }
            return false;
        }
        return false;
    }

    private static void P(QQAppInterface qQAppInterface, x.a aVar) {
        u(qQAppInterface, 3, aVar);
    }

    private static int Q(QQAppInterface qQAppInterface, String str, String str2, String str3, int i3) {
        int i16;
        boolean c16 = m.c(qQAppInterface, str, str2, str3, i3);
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "[userUncompressZipResource]needRestore=" + c16 + ",keyName=" + str, null);
        if (c16) {
            i16 = CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE;
        } else {
            i16 = 0;
        }
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "[userUncompressZipResource]errCode=" + i16 + ",keyName=" + str, null);
        return i16;
    }

    private static int R(String str, String str2, String str3) {
        return S(str, str2, "", str3);
    }

    private static int S(String str, String str2, String str3, String str4) {
        String str5;
        if (QLog.isColorLevel()) {
            QLog.d("ShortVideoResourceManager", 2, str + "|verifyResource() lResMd5=" + str2 + ", filepath=" + str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return -105;
        }
        if (TextUtils.isEmpty(str2)) {
            return -106;
        }
        File file = new File(str4);
        if (!file.exists()) {
            if (QLog.isColorLevel()) {
                QLog.e("ShortVideoResourceManager", 2, str + "|verifyResource() file[" + str4 + "] not exist..");
                return -107;
            }
            return -107;
        }
        try {
            try {
                str5 = HexUtil.bytes2HexStr(MD5.getFileMd5(str4));
            } catch (Exception unused) {
                str5 = null;
            }
        } catch (UnsatisfiedLinkError unused2) {
            str5 = com.tencent.qqprotect.singleupdate.a.d(file);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ShortVideoResourceManager", 2, str + "|verifyResource  lResMd5=" + str2 + ",md5=" + str5);
        }
        if (str2.equalsIgnoreCase(str5)) {
            return 0;
        }
        if (!StringUtil.isEmpty(str3) && !str3.equalsIgnoreCase(str5)) {
            try {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("keyName", str);
                hashMap.put(WadlProxyConsts.RES_MD5, str2);
                if (str5 == null) {
                    str5 = "";
                }
                hashMap.put("fileMd5", str5);
                hashMap.put("fileLen", String.valueOf(file.length()));
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "ShortVideoResMd5Error", true, 0L, 0L, hashMap, "");
                return AVDecodeError.VIDEO_DECODE_V_ERR;
            } catch (Exception e16) {
                QLog.e("ShortVideoResourceManager", 1, "report fail, ", e16);
                return AVDecodeError.VIDEO_DECODE_V_ERR;
            }
        }
        return AVDecodeError.VIDEO_DECODE_V_ERR;
    }

    private static boolean T(String str) {
        return FileUtils.fileExists(A() + str);
    }

    private static int U(SVConfigItem sVConfigItem) {
        String str = A() + sVConfigItem.name;
        if (VideoEnvironment64BitUtils.checkIs64bit() && sVConfigItem.check64BitReady()) {
            return S(sVConfigItem.name, sVConfigItem.arm64v8a_md5, sVConfigItem.armv7a_md5, str);
        }
        return S(sVConfigItem.name, sVConfigItem.armv7a_md5, sVConfigItem.arm64v8a_md5, str);
    }

    private static synchronized int e(x.a aVar) {
        int i3;
        synchronized (ShortVideoResourceManager.class) {
            if (f287683m.f287708a == 0) {
                i3 = AVDecodeError.JNI_BITMAP_STRIDE_ERR;
            } else if (aVar == null) {
                i3 = AVDecodeError.AUDIO_DATA_DECODE_FINISH;
            } else {
                boolean contains = C.contains(aVar);
                VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "addConfigCallBack contains=" + contains, null);
                if (!contains) {
                    C.add(aVar);
                    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "addConfigCallBack: add callBack OK...", null);
                }
                i3 = 0;
            }
        }
        return i3;
    }

    public static int f(QQAppInterface qQAppInterface, List<SVConfigItem> list) {
        int y16 = y();
        String w3 = w();
        if (y16 != 0 && !TextUtils.isEmpty(w3)) {
            int F2 = F(w3, list);
            VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "[checkConfigResourceIsOK]parseConfigData_errCode=" + F2, null);
            if (F2 != 0) {
                list.clear();
                VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "[doUserDownloadResource]parseConfigData:errCode=" + F2 + ", successReset=" + K("", 0) + ", config_content=" + w3, null);
            } else {
                F2 = i(list);
                if (F2 != 0) {
                    list.clear();
                    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "[doUserDownloadResource]checkResourceVersion:errCode=" + F2 + ", successReset=" + K("", 0) + ", config_content=" + w3, null);
                }
            }
            return F2;
        }
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "[checkConfigResourceIsOK]:version=" + y16 + ", successReset=" + K("", 0) + ", config_content=" + w3, null);
        return -101;
    }

    private static int g() {
        try {
            int y16 = y();
            String w3 = w();
            VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "checkLocalConfigIsOK:version=" + y16 + " config_content" + w3, null);
            if (y16 != 0 && !TextUtils.isEmpty(w3)) {
                ArrayList arrayList = new ArrayList();
                int F2 = F(w3, arrayList);
                VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "checkLocalConfigIsOK:parseConfigData_errCode=" + F2, null);
                if (F2 == 0) {
                    return i(arrayList);
                }
                return F2;
            }
            return -101;
        } catch (Error e16) {
            QLog.e("ShortVideoResourceManager", 1, e16, new Object[0]);
            return -1;
        }
    }

    private static boolean h(QQAppInterface qQAppInterface, SVConfigItem sVConfigItem) {
        String B = B(sVConfigItem.name);
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "checkResourceItemNeedDownload:name=" + sVConfigItem.name, null);
        x.b a16 = x.a(sVConfigItem.name);
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "checkResourceItemNeedDownload:versionCode=" + sVConfigItem.versionCode + " status.version" + a16.f288325a + ",status.lastErr=" + a16.f288327c, null);
        if (!m.d(qQAppInterface, sVConfigItem)) {
            VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "checkResourceItemNeedDownload:userDownload=false", null);
            return false;
        }
        int i3 = sVConfigItem.versionCode;
        int i16 = a16.f288325a;
        if (i3 > i16) {
            if (i16 == 0) {
                VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "checkResourceItemNeedDownload:status.version=0", null);
                if (new File(B).exists()) {
                    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "checkResourceItemNeedDownload:[exists]filePath=" + B, null);
                    int U = U(sVConfigItem);
                    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "checkResourceItemNeedDownload[zipVerifyMd5]:errCode=" + U, null);
                    if (U == 0) {
                        return false;
                    }
                    j(B);
                }
            } else {
                j(B);
            }
        } else {
            if (i3 != i16) {
                return false;
            }
            if (a16.f288326b != 0) {
                VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "checkResourceItemNeedDownload[No equal]:status=" + a16.f288326b + ",version" + a16.f288325a, null);
                j(B);
            } else {
                if (O()) {
                    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "checkResourceItemNeedDownload[equal]:unzipResourceExists.", null);
                    return false;
                }
                boolean T = T(sVConfigItem.name);
                VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "checkResourceItemNeedDownload[equal]:exist=" + T, null);
                if (T) {
                    int U2 = U(sVConfigItem);
                    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "checkResourceItemNeedDownload[equal]:errCode=" + U2, null);
                    if (U2 != 0) {
                        j(B);
                    } else {
                        if (a16.f288327c == 0) {
                            return false;
                        }
                        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "checkResourceItemNeedDownload[equal]:status=" + a16.f288326b + ",lastErr" + a16.f288327c, null);
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static int i(List<SVConfigItem> list) {
        int i3 = 0;
        for (int i16 = 0; i16 < list.size() && (i3 = m.b(list.get(i16))) == 0; i16++) {
        }
        return i3;
    }

    private static void j(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static void k(QQAppInterface qQAppInterface, e eVar) {
        n(qQAppInterface, eVar, "new_qq_android_native_short_video_");
    }

    private static void n(QQAppInterface qQAppInterface, e eVar, String str) {
        if (qQAppInterface != null) {
            if (eVar != null) {
                qQAppInterface.getShortVideoResourceManager().m(eVar, str);
                return;
            }
            return;
        }
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "clearResourceCallBackWithNamePrefixSafe: app=null...", null);
    }

    private static int o(QQAppInterface qQAppInterface, SVConfigItem sVConfigItem) {
        String B = B(sVConfigItem.name);
        if (m.d(qQAppInterface, sVConfigItem)) {
            String signature = sVConfigItem.getSignature();
            VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "doNoNeedDownload: signature=" + signature, null);
            int Q = Q(qQAppInterface, sVConfigItem.name, signature, B, sVConfigItem.versionCode);
            if (Q != 0) {
                x.b(sVConfigItem.name, sVConfigItem.versionCode, -1, Q);
                j(B);
                VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "doNoNeedDownload: errCode=" + Q, null);
                return Q;
            }
            x.b(sVConfigItem.name, sVConfigItem.versionCode, 0, Q);
            return Q;
        }
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "doNoNeedDownload: sysSupport=false", null);
        return -1000;
    }

    private boolean p(SVConfigItem sVConfigItem, e eVar, boolean[] zArr) {
        boolean z16;
        String B = B(sVConfigItem.name);
        boolean z17 = false;
        if (this.f287686f.get() != null) {
            z16 = m.a(this.f287686f.get(), sVConfigItem.name);
        } else {
            z16 = false;
        }
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "doRealSendRequest:alreadyExists=" + z16, null);
        zArr[0] = z16;
        if (z16) {
            VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "doRealSendRequest:onDownloadFinish...", null);
            if (eVar != null) {
                eVar.onDownloadFinish(sVConfigItem.name, 0, B);
            }
            VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "doRealSendRequest:itemConfig.versionCode=" + sVConfigItem.versionCode, null);
            if (this.f287686f.get() != null) {
                z17 = h(this.f287686f.get(), sVConfigItem);
            }
            if (!z17 && this.f287686f.get() != null) {
                VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "doRealSendRequest:doNoNeedDownload_errCode=" + o(this.f287686f.get(), sVConfigItem), null);
            }
            return z17;
        }
        return true;
    }

    public static void q(final QQAppInterface qQAppInterface, final List<SVConfigItem> list, final e eVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.3
            @Override // java.lang.Runnable
            public void run() {
                ShortVideoResourceManager.t(QQAppInterface.this, list, eVar, "new_qq_android_native_short_video_");
            }
        }, 128, null, false);
    }

    public static void r(final QQAppInterface qQAppInterface, final List<SVConfigItem> list, final e eVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.5
            @Override // java.lang.Runnable
            public void run() {
                ShortVideoResourceManager.t(QQAppInterface.this, list, eVar, "new_qq_android_native_art_filter_");
            }
        }, 128, null, false);
    }

    public static void s(final QQAppInterface qQAppInterface, final e eVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.2
            @Override // java.lang.Runnable
            public void run() {
                ShortVideoResourceManager.t(QQAppInterface.this, ShortVideoResourceManager.v(), eVar, "new_qq_android_native_short_video_");
            }
        }, 128, null, false);
    }

    public static void t(QQAppInterface qQAppInterface, List<SVConfigItem> list, e eVar, String str) {
        synchronized (D) {
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    break;
                }
                SVConfigItem sVConfigItem = list.get(i3);
                if (sVConfigItem.name.startsWith(str)) {
                    if (qQAppInterface == null) {
                        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "doUserDownloadResourceWithNamePrefix: app=null [RES_APP_INTERFACE_NULL_ERROR]", null);
                        if (eVar != null) {
                            eVar.onDownloadFinish(sVConfigItem.name, -1501, "");
                        }
                    } else {
                        boolean h16 = h(qQAppInterface, sVConfigItem);
                        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "doUserDownloadResourceWithNamePrefix: needDownload=" + h16, null);
                        if (h16) {
                            ShortVideoResourceManager shortVideoResourceManager = qQAppInterface.getShortVideoResourceManager();
                            if (shortVideoResourceManager != null) {
                                shortVideoResourceManager.L(sVConfigItem, eVar);
                            }
                        } else {
                            String B = B(sVConfigItem.name);
                            int o16 = o(qQAppInterface, sVConfigItem);
                            VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "doUserDownloadResourceWithNamePrefix:[doNoNeedDownload] itemConfig.name = " + sVConfigItem.name + ", errCode=" + o16, null);
                            if (eVar != null) {
                                eVar.onDownloadFinish(sVConfigItem.name, o16, B);
                            }
                        }
                    }
                } else {
                    i3++;
                }
            }
        }
    }

    private static synchronized void u(QQAppInterface qQAppInterface, int i3, x.a aVar) {
        int g16;
        synchronized (ShortVideoResourceManager.class) {
            if (f287683m.f287708a == 0) {
                if (i3 == 3 && (g16 = g()) == 0) {
                    if (aVar != null) {
                        aVar.onConfigResult(1, g16);
                    }
                    return;
                }
                VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "doUserDownload[Begin download print]:version=" + y() + " config_content" + w(), null);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("downloadShortVideoConfigData LogSignature=");
                sb5.append(x());
                VideoEnvironment.LogDownLoad("ShortVideoResourceManager", sb5.toString(), null);
                f287683m.f287708a = 1;
                c cVar = f287683m;
                cVar.f287709b = i3;
                cVar.f287710c = 0;
                cVar.f287711d = 0;
                ConfigServlet.t(qQAppInterface, i3);
                VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "downloadShortvideoConfigData[request started]:status=" + f287683m.a() + " mGetConfigType" + f287683m.f287709b, null);
            } else {
                VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "downloadShortvideoConfigData[request pending]:status=" + f287683m.a() + " mGetConfigType" + f287683m.f287709b, null);
            }
            if (aVar != null) {
                boolean contains = C.contains(aVar);
                VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "downloadShortVideoConfigData contains=" + contains, null);
                if (!contains) {
                    if (i3 != 3) {
                        C.add(0, aVar);
                    } else {
                        C.add(aVar);
                    }
                    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "downloadShortVideoConfigData: add callBack OK...", null);
                }
            }
        }
    }

    public static List<SVConfigItem> v() {
        LinkedList linkedList = new LinkedList();
        SVConfigItem sVConfigItem = new SVConfigItem();
        sVConfigItem.name = "new_qq_android_native_short_video_67";
        sVConfigItem.arm_url = "https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_video_67_test.zip";
        sVConfigItem.armv7a_url = "https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_video_67_test.zip";
        sVConfigItem.x86_url = "https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_video_67_test.zip";
        sVConfigItem.arm64v8a_url = "https://downv6.qq.com/shadow_qqcamera/Android/new_qq_android_native_short_video_67_new.zip";
        sVConfigItem.arm_md5 = "a679405ee702c0b96d35cf8676372368";
        sVConfigItem.armv7a_md5 = "a679405ee702c0b96d35cf8676372368";
        sVConfigItem.x86_md5 = "a679405ee702c0b96d35cf8676372368";
        sVConfigItem.arm64v8a_md5 = "fa9cec0ed8f7017e3d086bd94a2f4d41";
        sVConfigItem.versionCode = 67;
        sVConfigItem.predownload = false;
        linkedList.add(sVConfigItem);
        return linkedList;
    }

    public static String w() {
        return BaseApplicationImpl.getApplication().getSharedPreferences("new_short_video_resource_cfg", 4).getString("new_short_video_res_config_key", "");
    }

    private static String x() {
        return "hashCode=" + f287683m.hashCode() + " ,pid=" + Process.myPid() + ",tid" + Process.myTid();
    }

    public static int y() {
        return BaseApplicationImpl.getApplication().getSharedPreferences("new_short_video_resource_cfg", 4).getInt("new_short_video_resource_version", 0);
    }

    private static String z() {
        return H + File.separator;
    }

    public void L(SVConfigItem sVConfigItem, e eVar) {
        synchronized (this.f287685e) {
            d dVar = this.f287684d.get(sVConfigItem.name);
            if (dVar == null) {
                boolean[] zArr = new boolean[1];
                boolean p16 = p(sVConfigItem, eVar, zArr);
                if (zArr[0]) {
                    eVar = null;
                }
                VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "doRealSendRequest:doDownload=" + p16, null);
                if (p16) {
                    j(A() + sVConfigItem.name);
                    String z16 = z();
                    j(z16 + sVConfigItem.name);
                    HttpNetReq httpNetReq = new HttpNetReq();
                    httpNetReq.mCallback = this;
                    if (VideoEnvironment64BitUtils.checkIs64bit() && sVConfigItem.check64BitReady()) {
                        httpNetReq.mReqUrl = sVConfigItem.arm64v8a_url;
                    } else {
                        httpNetReq.mReqUrl = sVConfigItem.armv7a_url;
                    }
                    httpNetReq.mHttpMethod = 0;
                    httpNetReq.mOutPath = z16 + sVConfigItem.name;
                    httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
                    httpNetReq.bAcceptNegativeContentLength = true;
                    httpNetReq.setUserData(sVConfigItem.name);
                    d dVar2 = new d(httpNetReq);
                    dVar2.f287715d = sVConfigItem.versionCode;
                    if (VideoEnvironment64BitUtils.checkIs64bit() && sVConfigItem.check64BitReady()) {
                        dVar2.f287714c = sVConfigItem.arm64v8a_md5;
                    } else {
                        dVar2.f287714c = sVConfigItem.armv7a_md5;
                    }
                    if (eVar != null) {
                        dVar2.f287713b.add(eVar);
                        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "sendRequest[session][new]add callBack ok...", null);
                    }
                    this.f287684d.put(sVConfigItem.name, dVar2);
                    dVar2.a();
                }
            } else if (dVar.f287716e == 0) {
                dVar.f287715d = sVConfigItem.versionCode;
                if (VideoEnvironment64BitUtils.checkIs64bit() && sVConfigItem.check64BitReady()) {
                    dVar.f287714c = sVConfigItem.arm64v8a_md5;
                } else {
                    dVar.f287714c = sVConfigItem.armv7a_md5;
                }
                if (eVar != null) {
                    boolean contains = dVar.f287713b.contains(eVar);
                    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "sendRequest[oldSession][start]contains=" + contains, null);
                    if (!contains) {
                        dVar.f287713b.add(eVar);
                        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "sendRequest[oldSession][start]add callBack ok...", null);
                    }
                }
                dVar.a();
            } else if (eVar != null) {
                boolean contains2 = dVar.f287713b.contains(eVar);
                VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "sendRequest[oldSession][pending]contains=" + contains2, null);
                if (!contains2) {
                    dVar.f287713b.add(eVar);
                    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "sendRequest[oldSession][pending]add callBack ok...", null);
                }
            }
        }
    }

    public void l() {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("new_qq_android_native_short_video_");
        arrayList.add("new_qq_android_native_art_filter_");
        arrayList.add("new_qq_android_native_portrait_filter_");
        arrayList.add("new_qq_android_native_short_other_");
        for (String str : arrayList) {
            synchronized (this.f287685e) {
                d dVar = this.f287684d.get(str);
                if (dVar != null) {
                    dVar.f287713b.clear();
                }
            }
        }
    }

    public void m(e eVar, String str) {
        d dVar;
        synchronized (this.f287685e) {
            for (String str2 : this.f287684d.keySet()) {
                if (str2 != null && str2.startsWith(str) && (dVar = this.f287684d.get(str2)) != null && eVar != null) {
                    dVar.f287713b.remove(eVar);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.x.a
    public void onConfigResult(int i3, int i16) {
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "[PreDownload]onConfigResult:result=" + i3 + ",serverError" + i16 + ",getType=" + f287683m.f287709b, null);
        if (i3 == 1 || i3 == 0) {
            if (i16 != 0) {
                VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "[PreDownload]onConfigResult:RESULT_OK,saveError=" + i16, null);
                return;
            }
            int y16 = y();
            String w3 = w();
            if (y16 != 0 && !TextUtils.isEmpty(w3)) {
                ArrayList arrayList = new ArrayList(1);
                int F2 = F(w3, arrayList);
                VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "[PreDownload]onConfigResult:parseConfigData_errCode=" + F2, null);
                if (F2 == -100) {
                    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "[PreDownload]onConfigResult:parseConfigData_errCode=" + F2 + ",successReset=" + K("", 0), null);
                    return;
                }
                if (F2 == 0) {
                    int i17 = i(arrayList);
                    if (i17 != 0) {
                        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "[PreDownload]onConfigResult:checkResourceVersion errCode=" + i17 + ",successReset=" + K("", 0), null);
                        return;
                    }
                    G(arrayList);
                    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "[PreDownload]onConfigResult:success,sendRequest or no needDownload or predownload = false...", null);
                    return;
                }
                VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "[PreDownload]onConfigResult:parseConfigData Other error code ...", null);
                return;
            }
            VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "[PreDownload]onConfigResult:version=" + y16 + ",successReset=" + K("", 0) + ",config_content=" + w3, null);
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        int size;
        synchronized (ShortVideoResourceManager.class) {
            size = C.size();
            C.clear();
        }
        QLog.d("ShortVideoResourceManager", 1, "onDestroy sizeCallBack = ", Integer.valueOf(size));
        AppNetConnInfo.unregisterNetInfoHandler(this.f287687h);
        w.b();
        l();
    }

    @Override // com.tencent.mobileqq.transfile.INetEngineListener
    public final void onResp(final NetResp netResp) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.8
            @Override // java.lang.Runnable
            public void run() {
                ShortVideoResourceManager.this.E(netResp);
            }
        }, 5, null, false);
    }

    @Override // com.tencent.mobileqq.transfile.INetEngineListener
    public final void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        String str = (String) netReq.getUserData();
        synchronized (this.f287685e) {
            d dVar = this.f287684d.get(str);
            dVar.f287716e = 2;
            int size = dVar.f287713b.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (dVar.f287713b.get(i3) != null && str != null) {
                    dVar.f287713b.get(i3).onUpdateProgress(str, j3, j16);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements INetInfoHandler {
        a() {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
            ShortVideoResourceManager.this.D();
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
            ShortVideoResourceManager.this.D();
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(String str) {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(String str) {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(String str) {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(String str) {
        }
    }
}
