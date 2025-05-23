package dov.com.qq.im.ae.download.old;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.ams.fusion.widget.cny2025.twist.CNYTwistArrowLayer;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.VideoEnvironment64BitUtils;
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
import dov.com.qq.im.ae.download.old.e;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.manager.Manager;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes28.dex */
public class AEOldShortVideoResManager implements Manager, INetEngineListener, e.a {
    protected static final String E;
    protected static final String F;
    public static final String G;
    public static final String H;

    /* renamed from: i, reason: collision with root package name */
    public static long f394453i;

    /* renamed from: f, reason: collision with root package name */
    private QQAppInterface f394457f;

    /* renamed from: m, reason: collision with root package name */
    private static c f394454m = new c();
    private static ArrayList<e.a> C = new ArrayList<>();
    private static final Object D = new Object();

    /* renamed from: d, reason: collision with root package name */
    private HashMap<String, d> f394455d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private final Object f394456e = new Object();

    /* renamed from: h, reason: collision with root package name */
    private INetInfoHandler f394458h = new a();

    /* compiled from: P */
    /* renamed from: dov.com.qq.im.ae.download.old.AEOldShortVideoResManager$3, reason: invalid class name */
    /* loaded from: classes28.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f394462d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f394463e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f394464f;

        @Override // java.lang.Runnable
        public void run() {
            AEOldShortVideoResManager.q(this.f394462d, this.f394463e, this.f394464f, "new_qq_android_native_short_other_");
        }
    }

    /* compiled from: P */
    /* renamed from: dov.com.qq.im.ae.download.old.AEOldShortVideoResManager$7, reason: invalid class name */
    /* loaded from: classes28.dex */
    class AnonymousClass7 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f394470d;

        @Override // java.lang.Runnable
        public void run() {
            QQToast.makeText(VideoEnvironment.getContext(), "" + this.f394470d, 1).show();
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
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
    /* loaded from: classes28.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final String f394472a;

        /* renamed from: b, reason: collision with root package name */
        public static final String f394473b;

        static {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(AEOldShortVideoResManager.F);
            String str = File.separator;
            sb5.append(str);
            sb5.append("ae");
            f394472a = sb5.toString();
            f394473b = AEOldShortVideoResManager.E + str + "ae";
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class c {

        /* renamed from: b, reason: collision with root package name */
        int f394475b;

        /* renamed from: d, reason: collision with root package name */
        int f394477d;

        /* renamed from: a, reason: collision with root package name */
        volatile int f394474a = 0;

        /* renamed from: c, reason: collision with root package name */
        int f394476c = 0;

        String a() {
            int i3 = this.f394474a;
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
    /* loaded from: classes28.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        HttpNetReq f394478a;

        /* renamed from: c, reason: collision with root package name */
        String f394480c;

        /* renamed from: d, reason: collision with root package name */
        int f394481d;

        /* renamed from: b, reason: collision with root package name */
        ArrayList<e> f394479b = new ArrayList<>(1);

        /* renamed from: e, reason: collision with root package name */
        int f394482e = 0;

        d(HttpNetReq httpNetReq) {
            this.f394478a = httpNetReq;
        }

        void a() {
            if (QLog.isColorLevel()) {
                QLog.d("AEOldShortVideoResManager", 2, "HttpEngineTask[start]: " + this);
            }
            this.f394482e = 1;
            try {
                ((IHttpEngineService) AEOldShortVideoResManager.this.f394457f.getRuntimeService(IHttpEngineService.class, "all")).sendReq(this.f394478a);
            } catch (Exception e16) {
                QLog.e("AEOldShortVideoResManager", 2, "getRuntimeService[IHttpEngineService] exception " + e16.getMessage());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
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
        sb5.append(b.f394472a);
        String str = File.separator;
        sb5.append(str);
        sb5.append("sv_config_resources");
        sb5.append(str);
        G = sb5.toString();
        H = b.f394473b + str + "tmp";
        A();
    }

    public AEOldShortVideoResManager(QQAppInterface qQAppInterface) {
        this.f394457f = qQAppInterface;
        AppNetConnInfo.registerConnectionChangeReceiver(VideoEnvironment.getContext(), this.f394458h);
        QLog.d("AEOldShortVideoResManager", 1, "onCreate registerNetInfoHandler = ", u());
    }

    private static void A() {
        File file = new File(y());
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(x());
        if (!file2.exists()) {
            file2.mkdirs();
        }
    }

    public static synchronized void B() {
        synchronized (AEOldShortVideoResManager.class) {
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "onConfigCmdSend LogSignature=" + t(), null);
            if (f394454m.f394474a == 1) {
                f394454m.f394474a = 2;
            } else {
                VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "ShortVideoResourceManager[onConfigCmdSend] mConfigStatus=" + f394454m.a(), null);
                if (f394454m.f394474a == 0) {
                    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "onConfigCmdSend[Error status] size=" + C.size(), null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        synchronized (this.f394456e) {
            for (d dVar : this.f394455d.values()) {
                if (dVar != null && dVar.f394479b != null) {
                    for (int i3 = 0; i3 < dVar.f394479b.size(); i3++) {
                        dVar.f394479b.get(i3).onNetWorkNone();
                    }
                }
            }
        }
    }

    public static synchronized void D(int i3) {
        synchronized (AEOldShortVideoResManager.class) {
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "onReceiveFailed:status=" + f394454m.a() + " mGetConfigType" + f394454m.f394475b + ",serverResult=" + i3 + ",LogSignature=" + t(), null);
            if (f394454m.f394474a == 2) {
                f394454m.f394474a = 0;
                if (i3 == 0) {
                    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "onReceiveFailed[RESULT_NO_DATA]", null);
                    c cVar = f394454m;
                    cVar.f394476c = 1;
                    cVar.f394477d = 0;
                } else {
                    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "onReceiveFailed[RESULT_FAILED]", null);
                    c cVar2 = f394454m;
                    cVar2.f394476c = -1;
                    cVar2.f394477d = i3;
                }
                for (int size = C.size() - 1; size >= 0; size--) {
                    if (C.get(size) != null) {
                        e.a aVar = C.get(size);
                        c cVar3 = f394454m;
                        aVar.onConfigResult(cVar3.f394476c, cVar3.f394477d);
                    }
                }
                C.clear();
            } else {
                VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "ShortVideoResourceManager[onReceiveFailed] mConfigStatus=" + f394454m.a(), null);
            }
        }
    }

    public static synchronized void E() {
        synchronized (AEOldShortVideoResManager.class) {
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "onReceiveNoDataUpdate LogSignature=" + t(), null);
            if (f394454m.f394474a == 2) {
                f394454m.f394474a = 0;
                f394454m.f394476c = 1;
                for (int size = C.size() - 1; size >= 0; size--) {
                    if (C.get(size) != null) {
                        C.get(size).onConfigResult(f394454m.f394476c, 0);
                    }
                }
                C.clear();
            } else {
                VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "ShortVideoResourceManager[onReceiveNoDataUpdate] mConfigStatus=" + f394454m.a(), null);
            }
        }
    }

    public static synchronized void F(int i3) {
        synchronized (AEOldShortVideoResManager.class) {
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "onReceiveSuccess LogSignature=" + t(), null);
            if (f394454m.f394474a == 2) {
                f394454m.f394474a = 0;
                f394454m.f394476c = 0;
                for (int size = C.size() - 1; size >= 0; size--) {
                    if (C.get(size) != null) {
                        C.get(size).onConfigResult(f394454m.f394476c, i3);
                    }
                }
                C.clear();
            } else {
                VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "ShortVideoResourceManager[onReceiveSuccess] mConfigStatus=" + f394454m.a(), null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(NetResp netResp) {
        d dVar;
        String str;
        int i3;
        int i16;
        NetReq netReq = netResp.mReq;
        String str2 = netReq.mOutPath;
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[onResp]filePath=" + str2 + ",resp.mResult=" + netResp.mResult + ",mHttpCode=" + netResp.mHttpCode + ",mErrCode=" + netResp.mErrCode + ",mErrDesc=" + netResp.mErrDesc, null);
        String str3 = (String) netReq.getUserData();
        synchronized (this.f394456e) {
            dVar = this.f394455d.get(str3);
            str = dVar.f394480c;
            i3 = dVar.f394481d;
        }
        String y16 = y();
        String str4 = y16 + str3;
        if (netResp.mResult == 0) {
            i16 = V(str3, str, str2);
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[onResp]verifyResource keyName=" + str3 + ",errCode=" + i16, null);
            if (i16 != 0) {
                if (i16 == -108) {
                    boolean M = M(y16 + str3 + "error", str2);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("[onResp]renameResourceZip, save error file, success=");
                    sb5.append(M);
                    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", sb5.toString(), null);
                }
                k(str2);
                VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[onResp]verifyResource clearDownloadTempFile errCode=" + i16, null);
            } else if (M(str4, str2)) {
                String str5 = str + util.base64_pad_url + i3;
                int U = U(this.f394457f, str3, str5, str4, i3);
                VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[onRespAsync]signature=" + str5 + ",errCode=" + U + ",key=" + str3, null);
                i16 = U;
            } else {
                k(str4);
                k(str2);
                i16 = -3;
            }
            dov.com.qq.im.ae.download.old.e.b(str3, i3, 0, i16);
        } else {
            dov.com.qq.im.ae.download.old.e.b(str3, i3, 1, -117);
            k(str2);
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[onResp]filePath=" + str2 + ",resp.mResult=" + netResp.mResult + ",mErrDesc=" + netResp.mErrDesc + ",mErrDesc=" + netResp.mErrDesc, null);
            i16 = -117;
        }
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[onRespAsync]errCode=" + i16 + ",saveFilePath=" + str4 + ",key=" + str3, null);
        synchronized (this.f394456e) {
            dVar.f394482e = 3;
            int size = dVar.f394479b.size();
            for (int i17 = 0; i17 < size; i17++) {
                try {
                    if (dVar.f394479b.get(i17) != null && str3 != null) {
                        dVar.f394479b.get(i17).onDownloadFinish(str3, i16, str4);
                    }
                } catch (IndexOutOfBoundsException unused) {
                }
            }
            dVar.f394479b.clear();
            this.f394455d.remove(str3);
        }
    }

    public static int H(String str, List<SVConfigItem> list) {
        JSONArray jSONArray;
        int length;
        int i3 = -100;
        try {
            jSONArray = new JSONArray(str);
            length = jSONArray.length();
        } catch (OutOfMemoryError e16) {
            if (QLog.isColorLevel()) {
                QLog.d("AEOldShortVideoResManager", 2, "parseConfigData[OutOfMemoryError]", e16);
            }
            list.clear();
        } catch (JSONException e17) {
            if (QLog.isColorLevel()) {
                QLog.d("AEOldShortVideoResManager", 2, "parseConfigData[JSONException]", e17);
            }
            list.clear();
        }
        if (length <= 0) {
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "parseConfigData: arrayLength=" + length, null);
            return -100;
        }
        for (int i16 = 0; i16 < length; i16++) {
            SVConfigItem sVConfigItem = (SVConfigItem) JSONUtils.b(jSONArray.getJSONObject(i16), SVConfigItem.class);
            if (sVConfigItem == null) {
                VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "parseConfigData:item=null i=" + i16, null);
                list.clear();
                return -100;
            }
            list.add(sVConfigItem);
        }
        i3 = 0;
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "parseConfigData:errCode=" + i3, null);
        return i3;
    }

    private void I(final List<SVConfigItem> list) {
        ThreadManagerV2.excute(new Runnable() { // from class: dov.com.qq.im.ae.download.old.AEOldShortVideoResManager.5
            @Override // java.lang.Runnable
            public void run() {
                AEOldShortVideoResManager.this.J(list);
            }
        }, 128, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(List<SVConfigItem> list) {
        synchronized (D) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                SVConfigItem sVConfigItem = list.get(i3);
                if (!sVConfigItem.predownload) {
                    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "preDownloadResource:parseConfigData predownload=false", null);
                } else if (i(this.f394457f, sVConfigItem)) {
                    O(sVConfigItem, null);
                } else {
                    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "preDownloadResourceSync:needDownload=false [doNoNeedDownload] errCode=" + m(this.f394457f, sVConfigItem), null);
                }
            }
        }
    }

    public static void K(QQAppInterface qQAppInterface, int i3) {
        A();
        if (i3 != 3) {
            r(qQAppInterface, i3, v(qQAppInterface));
            return;
        }
        throw new Error("preDownloadShortVideoConfigData: call user type...");
    }

    public static int L(QQAppInterface qQAppInterface, e.a aVar) {
        int e16 = e(aVar);
        if (e16 == -115) {
            T(qQAppInterface, aVar);
            return 0;
        }
        return e16;
    }

    private static boolean M(String str, String str2) {
        synchronized (D) {
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[onResp]renameResourceZip destPath=" + str + ",outPath=" + str2, null);
            File file = new File(str);
            if (file.exists()) {
                file.delete();
                VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[onResp]renameResourceZip rename  destFile already exists[delete]...", null);
            }
            File file2 = new File(str2);
            long length = file2.length();
            boolean renameTo = file2.renameTo(file);
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[onResp]renameResourceZip orgLength=" + length + ",success=" + renameTo, null);
            if (renameTo) {
                boolean exists = file.exists();
                long length2 = file.length();
                VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[onResp]renameResourceZip destExists=" + exists + ",destLength=" + length2, null);
                if (exists && length2 == length) {
                    return true;
                }
            }
            return false;
        }
    }

    public static boolean N(String str, int i3) {
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_resource_cfg", 4).edit();
        edit.putString("short_video_res_config_key", str);
        edit.putInt("short_video_resource_version", i3);
        if (QLog.isColorLevel()) {
            QLog.d("AEOldShortVideoResManager", 2, "updateShortVideoResConfigContent| saveContentOK\uff0cconfig_content = " + str);
        }
        return edit.commit();
    }

    public static int P(QQAppInterface qQAppInterface, e.a aVar) {
        A();
        int h16 = h();
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "startUserDownloadConfig[checkLocalConfigIsOK]:errCode=" + h16, null);
        if (h16 != 0) {
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "startUserDownloadConfig:netUsable=" + NetworkUtil.isNetworkAvailable(null), null);
            h16 = L(qQAppInterface, aVar);
        } else if (aVar != null) {
            aVar.onConfigResult(1, 0);
        }
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "startUserDownloadConfig[end]:errCode=" + h16, null);
        return h16;
    }

    private static void T(QQAppInterface qQAppInterface, e.a aVar) {
        r(qQAppInterface, 3, aVar);
    }

    private static int U(QQAppInterface qQAppInterface, String str, String str2, String str3, int i3) {
        int i16;
        boolean c16 = dov.com.qq.im.ae.download.old.a.c(qQAppInterface, str, str2, str3, i3);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[userUncompressZipResource]needRestore=" + c16 + ",keyName=" + str, null);
        if (c16) {
            i16 = CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE;
        } else {
            i16 = 0;
        }
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[userUncompressZipResource]errCode=" + i16 + ",keyName=" + str, null);
        return i16;
    }

    private static int V(String str, String str2, String str3) {
        return W(str, str2, "", str3);
    }

    private static int W(String str, String str2, String str3, String str4) {
        String str5;
        if (QLog.isColorLevel()) {
            QLog.d("AEOldShortVideoResManager", 2, str + "|verifyResource() lResMd5=" + str2 + ", filepath=" + str4);
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
                QLog.e("AEOldShortVideoResManager", 2, str + "|verifyResource() file[" + str4 + "] not exist..");
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
            QLog.d("AEOldShortVideoResManager", 2, str + "|verifyResource  lResMd5=" + str2 + ",md5=" + str5);
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
                QLog.e("AEOldShortVideoResManager", 1, "report fail, ", e16);
                return AVDecodeError.VIDEO_DECODE_V_ERR;
            }
        }
        return AVDecodeError.VIDEO_DECODE_V_ERR;
    }

    private static boolean X(String str) {
        return FileUtils.fileExists(y() + str);
    }

    private static int Y(SVConfigItem sVConfigItem) {
        String str = y() + sVConfigItem.name;
        if (VideoEnvironment64BitUtils.checkIs64bit() && sVConfigItem.check64BitReady()) {
            return W(sVConfigItem.name, sVConfigItem.arm64v8a_md5, sVConfigItem.armv7a_md5, str);
        }
        return W(sVConfigItem.name, sVConfigItem.armv7a_md5, sVConfigItem.arm64v8a_md5, str);
    }

    private static synchronized int e(e.a aVar) {
        int i3;
        synchronized (AEOldShortVideoResManager.class) {
            if (f394454m.f394474a == 0) {
                i3 = AVDecodeError.JNI_BITMAP_STRIDE_ERR;
            } else if (aVar == null) {
                i3 = AVDecodeError.AUDIO_DATA_DECODE_FINISH;
            } else {
                boolean contains = C.contains(aVar);
                VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "addConfigCallBack contains=" + contains, null);
                if (!contains) {
                    C.add(aVar);
                    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "addConfigCallBack: add callBack OK...", null);
                }
                i3 = 0;
            }
        }
        return i3;
    }

    public static int f(QQAppInterface qQAppInterface, List<SVConfigItem> list) {
        int w3 = w();
        String s16 = s();
        if (w3 != 0 && !TextUtils.isEmpty(s16)) {
            int H2 = H(s16, list);
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[checkConfigResourceIsOK]parseConfigData_errCode=" + H2, null);
            if (H2 != 0) {
                list.clear();
                VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[doUserDownloadResource]parseConfigData:errCode=" + H2 + ", successReset=" + N("", 0) + ", config_content=" + s16, null);
            } else {
                H2 = j(list);
                if (H2 != 0) {
                    list.clear();
                    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[doUserDownloadResource]checkResourceVersion:errCode=" + H2 + ", successReset=" + N("", 0) + ", config_content=" + s16, null);
                }
            }
            return H2;
        }
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[checkConfigResourceIsOK]:version=" + w3 + ", successReset=" + N("", 0) + ", config_content=" + s16, null);
        return -101;
    }

    private static int g(List<SVConfigItem> list) {
        if (list != null && !list.isEmpty()) {
            for (SVConfigItem sVConfigItem : list) {
                if (sVConfigItem.name.startsWith("new_qq_android_native_short_new_other_")) {
                    String str = "new_qq_android_native_short_new_other_" + sVConfigItem.versionCode;
                    if (!sVConfigItem.name.equalsIgnoreCase(str)) {
                        QLog.e("AEOldShortVideoResManager", 1, "checkFaceIdentityResVersion: check name ignore error, itemName: ", sVConfigItem.name, " validName : ", str);
                        return -4;
                    }
                    int i3 = sVConfigItem.versionCode;
                    if (i3 >= 3) {
                        return 0;
                    }
                    QLog.e("AEOldShortVideoResManager", 1, "checkFaceIdentityResVersion:item.versionCode=", Integer.valueOf(i3), " buildInOther=", 3);
                    return -2;
                }
            }
            return -2;
        }
        QLog.e("AEOldShortVideoResManager", 1, "checkFaceIdentityResVersion: error: listItem is null or empty");
        return -125;
    }

    private static int h() {
        int w3 = w();
        String s16 = s();
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "checkLocalConfigIsOK:version=" + w3 + " config_content" + s16, null);
        if (w3 != 0 && !TextUtils.isEmpty(s16)) {
            ArrayList arrayList = new ArrayList();
            int H2 = H(s16, arrayList);
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "checkLocalConfigIsOK:parseConfigData_errCode=" + H2, null);
            if (H2 == 0) {
                return j(arrayList);
            }
            return H2;
        }
        return -101;
    }

    private static boolean i(QQAppInterface qQAppInterface, SVConfigItem sVConfigItem) {
        String z16 = z(sVConfigItem.name);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "checkResourceItemNeedDownload:name=" + sVConfigItem.name, null);
        e.b a16 = dov.com.qq.im.ae.download.old.e.a(sVConfigItem.name);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "checkResourceItemNeedDownload:versionCode=" + sVConfigItem.versionCode + " status.version" + a16.f394495a + ",status.lastErr=" + a16.f394497c, null);
        if (!dov.com.qq.im.ae.download.old.a.d(qQAppInterface, sVConfigItem)) {
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "checkResourceItemNeedDownload:userDownload=false", null);
            return false;
        }
        int i3 = sVConfigItem.versionCode;
        int i16 = a16.f394495a;
        if (i3 > i16) {
            if (i16 == 0) {
                VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "checkResourceItemNeedDownload:status.version=0", null);
                if (new File(z16).exists()) {
                    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "checkResourceItemNeedDownload:[exists]filePath=" + z16, null);
                    int Y = Y(sVConfigItem);
                    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "checkResourceItemNeedDownload[zipVerifyMd5]:errCode=" + Y, null);
                    if (Y == 0) {
                        return false;
                    }
                    k(z16);
                }
            } else {
                k(z16);
            }
        } else {
            if (i3 != i16) {
                return false;
            }
            if (a16.f394496b != 0) {
                VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "checkResourceItemNeedDownload[No equal]:status=" + a16.f394496b + ",version" + a16.f394495a, null);
                k(z16);
            } else {
                boolean X = X(sVConfigItem.name);
                VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "checkResourceItemNeedDownload[equal]:exist=" + X, null);
                if (X) {
                    int Y2 = Y(sVConfigItem);
                    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "checkResourceItemNeedDownload[equal]:errCode=" + Y2, null);
                    if (Y2 != 0) {
                        k(z16);
                    } else {
                        if (a16.f394497c == 0) {
                            return false;
                        }
                        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "checkResourceItemNeedDownload[equal]:status=" + a16.f394496b + ",lastErr" + a16.f394497c, null);
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static int j(List<SVConfigItem> list) {
        int i3 = 0;
        for (int i16 = 0; i16 < list.size() && (i3 = dov.com.qq.im.ae.download.old.a.b(list.get(i16))) == 0; i16++) {
        }
        if (i3 == 0) {
            return g(list);
        }
        return i3;
    }

    private static void k(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    private static int m(QQAppInterface qQAppInterface, SVConfigItem sVConfigItem) {
        String z16 = z(sVConfigItem.name);
        if (dov.com.qq.im.ae.download.old.a.d(qQAppInterface, sVConfigItem)) {
            String signature = sVConfigItem.getSignature();
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "doNoNeedDownload: signature=" + signature, null);
            int U = U(qQAppInterface, sVConfigItem.name, signature, z16, sVConfigItem.versionCode);
            if (U != 0) {
                dov.com.qq.im.ae.download.old.e.b(sVConfigItem.name, sVConfigItem.versionCode, -1, U);
                k(z16);
                VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "doNoNeedDownload: errCode=" + U, null);
                return U;
            }
            dov.com.qq.im.ae.download.old.e.b(sVConfigItem.name, sVConfigItem.versionCode, 0, U);
            return U;
        }
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "doNoNeedDownload: sysSupport=false", null);
        return -1000;
    }

    private boolean n(SVConfigItem sVConfigItem, e eVar, boolean[] zArr) {
        String z16 = z(sVConfigItem.name);
        boolean a16 = dov.com.qq.im.ae.download.old.a.a(this.f394457f, sVConfigItem.name);
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "doRealSendRequest:alreadyExists=" + a16, null);
        zArr[0] = a16;
        if (a16) {
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "doRealSendRequest:onDownloadFinish...", null);
            if (eVar != null) {
                eVar.onDownloadFinish(sVConfigItem.name, 0, z16);
            }
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "doRealSendRequest:itemConfig.versionCode=" + sVConfigItem.versionCode, null);
            boolean i3 = i(this.f394457f, sVConfigItem);
            if (!i3) {
                VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "doRealSendRequest:doNoNeedDownload_errCode=" + m(this.f394457f, sVConfigItem), null);
            }
            return i3;
        }
        return true;
    }

    public static void o(final QQAppInterface qQAppInterface, final List<SVConfigItem> list, final e eVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: dov.com.qq.im.ae.download.old.AEOldShortVideoResManager.2
            @Override // java.lang.Runnable
            public void run() {
                AEOldShortVideoResManager.q(QQAppInterface.this, list, eVar, "new_qq_android_native_short_video_");
            }
        }, 128, null, false);
    }

    public static void p(final QQAppInterface qQAppInterface, final List<SVConfigItem> list, final e eVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: dov.com.qq.im.ae.download.old.AEOldShortVideoResManager.4
            @Override // java.lang.Runnable
            public void run() {
                AEOldShortVideoResManager.q(QQAppInterface.this, list, eVar, "new_qq_android_native_art_filter_");
            }
        }, 128, null, false);
    }

    public static void q(QQAppInterface qQAppInterface, List<SVConfigItem> list, e eVar, String str) {
        synchronized (D) {
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    break;
                }
                SVConfigItem sVConfigItem = list.get(i3);
                if (sVConfigItem.name.startsWith(str)) {
                    if (qQAppInterface == null) {
                        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "doUserDownloadResourceWithNamePrefix: app=null [RES_APP_INTERFACE_NULL_ERROR]", null);
                        if (eVar != null) {
                            eVar.onDownloadFinish(sVConfigItem.name, -1501, "");
                        }
                    } else {
                        boolean i16 = i(qQAppInterface, sVConfigItem);
                        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "doUserDownloadResourceWithNamePrefix: needDownload=" + i16, null);
                        if (i16) {
                            AEOldShortVideoResManager v3 = v(qQAppInterface);
                            if (v3 != null) {
                                v3.O(sVConfigItem, eVar);
                            }
                        } else {
                            String z16 = z(sVConfigItem.name);
                            int m3 = m(qQAppInterface, sVConfigItem);
                            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "doUserDownloadResourceWithNamePrefix:[doNoNeedDownload] itemConfig.name = " + sVConfigItem.name + ", errCode=" + m3, null);
                            if (eVar != null) {
                                eVar.onDownloadFinish(sVConfigItem.name, m3, z16);
                            }
                        }
                    }
                } else {
                    i3++;
                }
            }
        }
    }

    private static synchronized void r(QQAppInterface qQAppInterface, int i3, e.a aVar) {
        int h16;
        synchronized (AEOldShortVideoResManager.class) {
            if (f394454m.f394474a == 0) {
                if (i3 == 3 && (h16 = h()) == 0) {
                    if (aVar != null) {
                        aVar.onConfigResult(1, h16);
                    }
                    return;
                }
                w();
                s();
                f394454m.f394474a = 1;
                c cVar = f394454m;
                cVar.f394475b = i3;
                cVar.f394476c = 0;
                cVar.f394477d = 0;
                ConfigServlet.r(qQAppInterface, i3);
            } else {
                VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "downloadShortvideoConfigData[request pending]:status=" + f394454m.a() + " mGetConfigType" + f394454m.f394475b, null);
            }
            if (aVar != null && !C.contains(aVar)) {
                if (i3 != 3) {
                    C.add(0, aVar);
                } else {
                    C.add(aVar);
                }
                VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "downloadShortVideoConfigData: add callBack OK...", null);
            }
        }
    }

    public static String s() {
        return BaseApplicationImpl.getApplication().getSharedPreferences("short_video_resource_cfg", 4).getString("short_video_res_config_key", "");
    }

    private static String t() {
        return "hashCode=" + f394454m.hashCode() + " ,pid=" + Process.myPid() + ",tid" + Process.myTid();
    }

    private String u() {
        INetInfoHandler iNetInfoHandler = this.f394458h;
        if (iNetInfoHandler != null) {
            return Integer.toHexString(iNetInfoHandler.hashCode());
        }
        return "null";
    }

    public static AEOldShortVideoResManager v(QQAppInterface qQAppInterface) {
        if (qQAppInterface != null) {
            return (AEOldShortVideoResManager) qQAppInterface.getManager(QQManagerFactory.OLD_SHORT_VIDEO_RES_MANAGER);
        }
        return null;
    }

    public static int w() {
        return BaseApplicationImpl.getApplication().getSharedPreferences("short_video_resource_cfg", 4).getInt("short_video_resource_version", 0);
    }

    private static String x() {
        return H + File.separator;
    }

    public static String y() {
        return G;
    }

    public static String z(String str) {
        return y() + str;
    }

    public void O(SVConfigItem sVConfigItem, e eVar) {
        synchronized (this.f394456e) {
            d dVar = this.f394455d.get(sVConfigItem.name);
            if (dVar == null) {
                boolean[] zArr = new boolean[1];
                boolean n3 = n(sVConfigItem, eVar, zArr);
                if (zArr[0]) {
                    eVar = null;
                }
                VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "doRealSendRequest:doDownload=" + n3, null);
                if (n3) {
                    k(y() + sVConfigItem.name);
                    String x16 = x();
                    k(x16 + sVConfigItem.name);
                    HttpNetReq httpNetReq = new HttpNetReq();
                    httpNetReq.mCallback = this;
                    if (VideoEnvironment64BitUtils.checkIs64bit() && sVConfigItem.check64BitReady()) {
                        httpNetReq.mReqUrl = sVConfigItem.arm64v8a_url;
                    } else {
                        httpNetReq.mReqUrl = sVConfigItem.armv7a_url;
                    }
                    httpNetReq.mHttpMethod = 0;
                    httpNetReq.mOutPath = x16 + sVConfigItem.name;
                    httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
                    httpNetReq.bAcceptNegativeContentLength = true;
                    httpNetReq.setUserData(sVConfigItem.name);
                    d dVar2 = new d(httpNetReq);
                    dVar2.f394481d = sVConfigItem.versionCode;
                    if (VideoEnvironment64BitUtils.checkIs64bit() && sVConfigItem.check64BitReady()) {
                        dVar2.f394480c = sVConfigItem.arm64v8a_md5;
                    } else {
                        dVar2.f394480c = sVConfigItem.armv7a_md5;
                    }
                    if (eVar != null) {
                        dVar2.f394479b.add(eVar);
                        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "sendRequest[session][new]add callBack ok...", null);
                    }
                    this.f394455d.put(sVConfigItem.name, dVar2);
                    dVar2.a();
                }
            } else if (dVar.f394482e == 0) {
                dVar.f394481d = sVConfigItem.versionCode;
                if (VideoEnvironment64BitUtils.checkIs64bit() && sVConfigItem.check64BitReady()) {
                    dVar.f394480c = sVConfigItem.arm64v8a_md5;
                } else {
                    dVar.f394480c = sVConfigItem.armv7a_md5;
                }
                if (eVar != null) {
                    boolean contains = dVar.f394479b.contains(eVar);
                    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "sendRequest[oldSession][start]contains=" + contains, null);
                    if (!contains) {
                        dVar.f394479b.add(eVar);
                        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "sendRequest[oldSession][start]add callBack ok...", null);
                    }
                }
                dVar.a();
            } else if (eVar != null) {
                boolean contains2 = dVar.f394479b.contains(eVar);
                VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "sendRequest[oldSession][pending]contains=" + contains2, null);
                if (!contains2) {
                    dVar.f394479b.add(eVar);
                    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "sendRequest[oldSession][pending]add callBack ok...", null);
                }
            }
        }
    }

    public void Q() {
        QLog.d("AEOldShortVideoResManager", 1, "unregisterNetInfoHandler = ", u());
        AppNetConnInfo.unregisterNetInfoHandler(this.f394458h);
    }

    public int R(String str, int i3) {
        QLog.d("AEOldShortVideoResManager", 1, "updateShortVideoOtherConfigOnly|received save version: " + i3 + ", config_content: " + str);
        if (TextUtils.isEmpty(str)) {
            QLog.d("AEOldShortVideoResManager", 1, "updateShortVideoOtherConfigOnly| version: " + i3 + ",config_content: " + str);
            return -101;
        }
        boolean N = N(str, i3);
        QLog.d("AEOldShortVideoResManager", 1, "updateShortVideoOtherConfigOnly| saveContentOK: " + N);
        if (N) {
            return 0;
        }
        return -128;
    }

    public int S(Context context, String str, int i3) {
        int i16;
        if (QLog.isColorLevel()) {
            QLog.d("AEOldShortVideoResManager", 2, "updateShortVideoResConfigContent|received save version: " + i3 + ", config_content: " + str);
        }
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("AEOldShortVideoResManager", 2, "updateShortVideoResConfigContent| version: " + i3 + ",config_content: " + str);
            }
            return -101;
        }
        boolean N = N(str, i3);
        if (QLog.isColorLevel()) {
            QLog.d("AEOldShortVideoResManager", 2, "updateShortVideoResConfigContent| saveContentOK: " + N);
        }
        if (N) {
            i16 = 0;
        } else {
            i16 = -128;
        }
        if (N) {
            boolean e16 = dov.com.qq.im.ae.download.old.d.e(this.f394457f, false);
            if (QLog.isColorLevel()) {
                QLog.d("AEOldShortVideoResManager", 2, "updateShortVideoResConfigContent| downloadState: " + e16);
            }
        }
        return i16;
    }

    public void l() {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("new_qq_android_native_short_video_");
        arrayList.add("new_qq_android_native_art_filter_");
        arrayList.add("new_qq_android_native_portrait_filter_");
        arrayList.add("new_qq_android_native_short_other_");
        for (String str : arrayList) {
            synchronized (this.f394456e) {
                d dVar = this.f394455d.get(str);
                if (dVar != null) {
                    dVar.f394479b.clear();
                }
            }
        }
    }

    @Override // dov.com.qq.im.ae.download.old.e.a
    public void onConfigResult(int i3, int i16) {
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[PreDownload]onConfigResult:result=" + i3 + ",serverError" + i16 + ",getType=" + f394454m.f394475b, null);
        if (i3 == 1 || i3 == 0) {
            if (i16 != 0) {
                VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[PreDownload]onConfigResult:RESULT_OK,saveError=" + i16, null);
                return;
            }
            int w3 = w();
            String s16 = s();
            if (w3 != 0 && !TextUtils.isEmpty(s16)) {
                ArrayList arrayList = new ArrayList(1);
                int H2 = H(s16, arrayList);
                VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[PreDownload]onConfigResult:parseConfigData_errCode=" + H2, null);
                if (H2 == -100) {
                    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[PreDownload]onConfigResult:parseConfigData_errCode=" + H2 + ",successReset=" + N("", 0), null);
                    return;
                }
                if (H2 == 0) {
                    int j3 = j(arrayList);
                    if (j3 != 0) {
                        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[PreDownload]onConfigResult:checkResourceVersion errCode=" + j3 + ",successReset=" + N("", 0), null);
                        return;
                    }
                    I(arrayList);
                    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[PreDownload]onConfigResult:success,sendRequest or no needDownload or predownload = false...", null);
                    return;
                }
                VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[PreDownload]onConfigResult:parseConfigData Other error code ...", null);
                return;
            }
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[PreDownload]onConfigResult:version=" + w3 + ",successReset=" + N("", 0) + ",config_content=" + s16, null);
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        int size;
        synchronized (AEOldShortVideoResManager.class) {
            size = C.size();
            C.clear();
        }
        QLog.d("AEOldShortVideoResManager", 1, "onDestroy sizeCallBack = ", Integer.valueOf(size));
        QLog.d("AEOldShortVideoResManager", 1, "onDestroy unregisterNetInfoHandler = ", u());
        AppNetConnInfo.unregisterNetInfoHandler(this.f394458h);
        dov.com.qq.im.ae.download.old.d.b();
        l();
    }

    @Override // com.tencent.mobileqq.transfile.INetEngineListener
    public final void onResp(final NetResp netResp) {
        ThreadManagerV2.post(new Runnable() { // from class: dov.com.qq.im.ae.download.old.AEOldShortVideoResManager.6
            @Override // java.lang.Runnable
            public void run() {
                AEOldShortVideoResManager.this.G(netResp);
            }
        }, 5, null, false);
    }

    @Override // com.tencent.mobileqq.transfile.INetEngineListener
    public final void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        String str = (String) netReq.getUserData();
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "[onUpdateProgeress]curOffset=" + j3 + ",totalLen=" + j16 + ",key=" + str, null);
        synchronized (this.f394456e) {
            d dVar = this.f394455d.get(str);
            dVar.f394482e = 2;
            int size = dVar.f394479b.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (dVar.f394479b.get(i3) != null && str != null) {
                    dVar.f394479b.get(i3).onUpdateProgress(str, j3, j16);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a implements INetInfoHandler {
        a() {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
            AEOldShortVideoResManager.this.C();
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
            AEOldShortVideoResManager.this.C();
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
