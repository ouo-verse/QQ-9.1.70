package cooperation.plugin;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoConfig;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ds;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.rdelivery.reshub.FileSuffix;
import cooperation.plugin.f;
import cooperation.plugin.patch.PatchDownloadManager;
import cooperation.plugin.patch.PatchReporter;
import cooperation.plugin.patch.f;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes28.dex */
public class d implements Handler.Callback, INetEngineListener, HttpEngineTask.IHttpEngineTask {
    private IPreDownloadController C;
    private PatchDownloadManager D;

    /* renamed from: d, reason: collision with root package name */
    private Context f390259d;

    /* renamed from: f, reason: collision with root package name */
    private HashMap<String, Long> f390261f = new HashMap<>();

    /* renamed from: m, reason: collision with root package name */
    private final Lock f390264m = new ReentrantLock();

    /* renamed from: e, reason: collision with root package name */
    private Handler f390260e = new Handler(ThreadManagerV2.getSubThreadLooper(), this);

    /* renamed from: h, reason: collision with root package name */
    private HashMap<String, b> f390262h = new HashMap<>();

    /* renamed from: i, reason: collision with root package name */
    private HashMap<String, HttpEngineTask> f390263i = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a implements f.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PluginInfo f390265a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bundle f390266b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f390267c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f390268d;

        a(PluginInfo pluginInfo, Bundle bundle, c cVar, boolean z16) {
            this.f390265a = pluginInfo;
            this.f390266b = bundle;
            this.f390267c = cVar;
            this.f390268d = z16;
        }

        @Override // cooperation.plugin.patch.f.b
        public void a() {
            Bundle bundle;
            this.f390265a.mPatchDescription = null;
            QLog.i("plugin_tag", 1, "onPatchFailed");
            if (GroupVideoConfig.c().c() || ((bundle = this.f390266b) != null && bundle.getBoolean("fullDownLoad"))) {
                d.this.f(this.f390265a, this.f390267c, this.f390268d, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private HttpNetReq f390270a;

        /* renamed from: b, reason: collision with root package name */
        private c f390271b;

        /* renamed from: c, reason: collision with root package name */
        private AbsPreDownloadTask f390272c;

        /* renamed from: d, reason: collision with root package name */
        private volatile boolean f390273d;

        b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface c extends f.d {
        void E3(int i3, int i16, String str);

        void Z2(String str);

        void j(String str);

        void v(boolean z16, String str);

        void x(String str);
    }

    public d(Context context, QQAppInterface qQAppInterface) {
        this.f390259d = context;
        try {
            this.C = (IPreDownloadController) qQAppInterface.getRuntimeService(IPreDownloadController.class);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        this.D = new PatchDownloadManager(context);
    }

    private void b(File file, String str, boolean z16) {
        File[] listFiles;
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "doDeleteDiscardFiles: " + str);
        }
        if (file != null && file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                String path = file2.getPath();
                if (path != null && path.startsWith(str) && !path.endsWith(PluginUtils.CONFIG_FILE_EXTEND_NAME)) {
                    if (path.equals(str)) {
                        if (z16) {
                            file2.delete();
                            if (QLog.isColorLevel()) {
                                QLog.d("plugin_tag", 2, "doDeleteDiscardFiles: " + path);
                            }
                        }
                    } else {
                        file2.delete();
                        if (QLog.isColorLevel()) {
                            QLog.d("plugin_tag", 2, "doDeleteDiscardFiles: " + path);
                        }
                    }
                }
            }
        }
    }

    private void c(String str) {
        c cVar;
        IPreDownloadController iPreDownloadController;
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "doCancelInstall: " + str);
        }
        this.f390264m.lock();
        try {
            b remove = this.f390262h.remove(str);
            HttpEngineTask remove2 = this.f390263i.remove(str);
            if (remove != null || remove2 != null) {
                if (remove != null) {
                    if (remove.f390272c != null) {
                        IPreDownloadController iPreDownloadController2 = this.C;
                        if (iPreDownloadController2 != null) {
                            iPreDownloadController2.cancelPreDownload(remove.f390270a.mReqUrl);
                        }
                    } else {
                        ((IHttpEngineService) g().getRuntimeService(IHttpEngineService.class, "all")).cancelReq(remove.f390270a);
                    }
                }
                if (remove != null && (iPreDownloadController = this.C) != null) {
                    iPreDownloadController.cancelPreDownload(remove.f390270a.mReqUrl);
                }
                if (remove != null) {
                    cVar = remove.f390271b;
                } else {
                    cVar = (c) remove2.userData;
                }
                if (cVar != null) {
                    cVar.x(str);
                }
                m(str);
                if ((remove != null && remove.f390273d) || remove2 != null) {
                    p(str, "cancel");
                }
            }
        } finally {
            this.f390264m.unlock();
        }
    }

    private void d(NetReq netReq, int i3, int i16) {
        c cVar;
        String str = (String) netReq.getUserData();
        if (i16 > 0) {
            b bVar = this.f390262h.get(str);
            if (bVar != null) {
                cVar = bVar.f390271b;
            } else {
                cVar = null;
            }
            if (cVar != null) {
                cVar.E3(i3, i16, str);
            }
        }
    }

    private void e(NetResp netResp) {
        boolean z16;
        IPreDownloadController iPreDownloadController;
        String str;
        String str2 = (String) netResp.mReq.getUserData();
        q(str2);
        if (netResp.mResult == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        try {
            iPreDownloadController = (IPreDownloadController) g().getRuntimeService(IPreDownloadController.class);
        } catch (Exception e16) {
            QLog.e("plugin_tag", 1, "get IPreDownloadController error!", e16);
            iPreDownloadController = null;
        }
        b remove = this.f390262h.remove(str2);
        if (remove != null) {
            if (remove.f390270a != null && iPreDownloadController != null) {
                iPreDownloadController.preDownloadSuccess(remove.f390270a.mReqUrl, netResp.mTotalFileLen);
            }
            c cVar = remove.f390271b;
            n(str2, netResp);
            if (remove.f390273d) {
                if (z16) {
                    str = "success";
                } else {
                    str = "failed";
                }
                p(str2, str);
            }
            b(i(this.f390259d), str2, false);
            if (QLog.isColorLevel()) {
                QLog.d("plugin_tag", 2, "doOnResp. result,pluginid,length: " + netResp.mResult + "," + str2 + ", " + netResp.mTotalFileLen);
                if (!z16 && QLog.isColorLevel()) {
                    QLog.e("plugin_tag", 2, "doOnResp. err: " + netResp.mErrCode + ", " + netResp.mErrDesc);
                }
            }
            if (cVar != null) {
                cVar.v(z16, str2);
            }
        }
    }

    private QQAppInterface g() {
        return (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private int h(String str) {
        if (PluginProxyActivity.READER_ID.equals(str)) {
            return 10010;
        }
        if (IQQComicPluginUtil.COMIC_PLUGIN_ID.equals(str)) {
            return 10011;
        }
        if ("qqdataline.apk".equals(str)) {
            return 10013;
        }
        if ("qlink_plugin.apk".equals(str)) {
            return 10060;
        }
        return 10058;
    }

    public static final File i(Context context) {
        File file = new File(new File(new File(context.getFilesDir(), "pddata"), PreDownloadConstants.DEPARTMENT_PRD), "plugin_download");
        file.mkdirs();
        return file;
    }

    private c j(PluginInfo pluginInfo, String str, String str2, c cVar, boolean z16, Bundle bundle) {
        return this.D.b(pluginInfo, str, str2, cVar, new a(pluginInfo, bundle, cVar, z16));
    }

    private boolean k(String str) {
        long j3 = this.f390259d.getSharedPreferences("pluginPreDownloadStartTime", 0).getLong(str, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (j3 != 0 && currentTimeMillis - j3 < MiniBoxNoticeInfo.HOUR_8) {
            return false;
        }
        return true;
    }

    private void l(String str, HttpNetReq httpNetReq, c cVar, AbsPreDownloadTask absPreDownloadTask, boolean z16) {
        IPreDownloadController iPreDownloadController;
        if (cVar != null) {
            cVar.j(str);
        }
        this.f390261f.put(str, Long.valueOf(SystemClock.uptimeMillis()));
        this.f390264m.lock();
        try {
            HttpEngineTask remove = this.f390263i.remove(str);
            if (remove != null && (iPreDownloadController = this.C) != null) {
                iPreDownloadController.cancelPreDownload(remove.httpReq.mReqUrl);
            }
            b bVar = new b();
            bVar.f390270a = httpNetReq;
            bVar.f390271b = cVar;
            bVar.f390272c = absPreDownloadTask;
            bVar.f390273d = z16;
            this.f390262h.put(str, bVar);
        } finally {
            this.f390264m.unlock();
        }
    }

    private void m(String str) {
        Long l3 = this.f390261f.get(str);
        if (l3 == null) {
            l3 = 0L;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_FailCode", "0");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(g().getCurrentAccountUin(), "NetPluginsCancelDownload", false, l3.longValue(), 0L, hashMap, null);
    }

    private void n(String str, NetResp netResp) {
        boolean z16;
        HashMap<String, String> hashMap = new HashMap<>();
        Long l3 = this.f390261f.get(str);
        if (l3 == null) {
            l3 = 0L;
        }
        hashMap.put("mResult", String.valueOf(netResp.mResult));
        hashMap.put("param_FailCode", String.valueOf(netResp.mErrCode));
        hashMap.put("mErrDesc", netResp.mErrDesc);
        NetReq netReq = netResp.mReq;
        if (netResp.mResult != 0 && netReq != null && (netReq instanceof HttpNetReq)) {
            hashMap.put("Url", ((HttpNetReq) netReq).mReqUrl);
        }
        hashMap.put("mRespProperties[KeyReason]", netResp.mRespProperties.get(NetResp.KEY_REASON));
        hashMap.put("mRespProperties[KeyRawRespHttpHeader]", netResp.mRespProperties.get("param_reqHeader"));
        StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
        String currentAccountUin = g().getCurrentAccountUin();
        if (netResp.mResult == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        statisticCollector.collectPerformance(currentAccountUin, "NetPluginsDownload", z16, l3.longValue(), 0L, hashMap, null);
    }

    private void o(Context context, PluginInfo pluginInfo) {
        PluginInfo d16;
        if (new File(cooperation.plugin.patch.g.b(context, pluginInfo.mID)).exists() && !TextUtils.isEmpty(pluginInfo.mPatchDescription) && cooperation.plugin.patch.g.e(context, pluginInfo) == null && (d16 = cooperation.plugin.patch.g.d(context, pluginInfo.mID)) != null) {
            PatchReporter.b(PatchReporter.ERROR.PATCH_MISMATCH.ordinal(), null, -1L, -1L, d16.mVersion);
        }
    }

    private void p(String str, String str2) {
        String str3;
        if (Float.compare(ds.b(0.0f, 1.0f), 0.01f) > 0) {
            QLog.e("plugin_tag", 1, "Do not need to report this plugin launch event!");
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>(3);
        hashMap.put("plugin_id", str);
        try {
            str3 = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
        } catch (Throwable unused) {
            QLog.e("plugin_tag", 1, "getAccount faild \uff01\uff01\uff01");
            str3 = "";
        }
        String str4 = str3;
        hashMap.put("qq_num", str4);
        hashMap.put("result", str2);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str4, "qqPluginPreDownloadReporter", true, 0L, 0L, hashMap, null);
    }

    private void q(String str) {
        this.f390259d.getSharedPreferences("pluginPreDownloadStartTime", 0).edit().putLong(str, System.currentTimeMillis()).apply();
    }

    private boolean r(PluginInfo pluginInfo, c cVar) {
        String str;
        if (!pluginInfo.mURL.startsWith("file:///") && !pluginInfo.mURL.startsWith("/")) {
            return false;
        }
        QLog.d("plugin_tag", 1, "downloadLocalFile." + pluginInfo.mURL);
        if (pluginInfo.mURL.startsWith("file:///")) {
            str = pluginInfo.mURL.substring(7);
        } else {
            str = pluginInfo.mURL;
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        FileUtils.copyFile(file, new File(i(this.f390259d), pluginInfo.mID));
        if (cVar != null) {
            cVar.v(true, pluginInfo.mID);
        }
        return true;
    }

    public void a(String str) {
        this.f390260e.obtainMessage(Friends.TERM_TYPE_MOBILE_OTHER, str).sendToTarget();
    }

    public void f(PluginInfo pluginInfo, c cVar, boolean z16, Bundle bundle) {
        IHttpEngineService iHttpEngineService;
        String path;
        String str;
        c cVar2;
        IPreDownloadController iPreDownloadController;
        String str2;
        IPreDownloadController iPreDownloadController2;
        QLog.d("plugin_tag", 1, "doDownloadPlugin." + pluginInfo.mID + ", isPreDownload " + z16);
        if (z16 && !k(pluginInfo.mID)) {
            if (QLog.isColorLevel()) {
                QLog.i("plugin_tag", 2, "exceed pre download frequency, ignore this call!");
                return;
            }
            return;
        }
        if (r(pluginInfo, cVar)) {
            return;
        }
        try {
            iHttpEngineService = (IHttpEngineService) g().getRuntimeService(IHttpEngineService.class, "all");
        } catch (Exception e16) {
            QLog.e("plugin_tag", 1, "download plugin get IHttpEngineService error", e16);
            iHttpEngineService = null;
        }
        if (iHttpEngineService == null) {
            QLog.d("plugin_tag", 1, "doDownloadPlugin nohttpabort" + pluginInfo.mID);
            if (cVar != null) {
                cVar.x(pluginInfo.mID);
                return;
            }
            return;
        }
        String str3 = i(this.f390259d) + File.separator + pluginInfo.mID;
        this.f390264m.lock();
        try {
            if (this.f390262h.containsKey(pluginInfo.mID)) {
                b bVar = this.f390262h.get(pluginInfo.mID);
                if (!z16 && bVar != null && bVar.f390273d) {
                    bVar.f390273d = false;
                    p(pluginInfo.mID, "cancel");
                    bVar.f390271b = cVar;
                    if (cVar != null) {
                        cVar.j(pluginInfo.mID);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("plugin_tag", 2, "has pre download task running, replace current record listener!");
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("plugin_tag", 2, "downloading already");
                }
            } else {
                if (this.f390263i.containsKey(pluginInfo.mID)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("plugin_tag", 2, "pending downloading already exist");
                    }
                    if (!z16) {
                        HttpEngineTask remove = this.f390263i.remove(pluginInfo.mID);
                        if (remove != null && (iPreDownloadController2 = this.C) != null) {
                            iPreDownloadController2.cancelPreDownload(remove.httpReq.mReqUrl);
                        }
                    }
                }
                this.f390264m.unlock();
                if (((float) (pluginInfo.mLength * 1.75d)) > FileUtils.getAvailableInnernalMemorySize()) {
                    if (cVar != null) {
                        cVar.Z2(pluginInfo.mID);
                        return;
                    }
                    return;
                }
                HttpNetReq httpNetReq = new HttpNetReq();
                httpNetReq.mCallback = this;
                httpNetReq.mSupportBreakResume = true;
                httpNetReq.mHttpMethod = 0;
                httpNetReq.mNeedIpConnect = true;
                httpNetReq.bAcceptNegativeContentLength = true;
                httpNetReq.setUserData(pluginInfo.mID);
                if (cooperation.plugin.patch.g.a(this.f390259d, pluginInfo, z16, bundle)) {
                    QLog.i("plugin_tag", 1, "canPatch");
                    PatchDownloadManager.PatchInfo e17 = cooperation.plugin.patch.g.e(this.f390259d, pluginInfo);
                    if (e17 != null) {
                        httpNetReq.mReqUrl = e17.url;
                    }
                    File file = new File(i(this.f390259d), pluginInfo.mID + FileSuffix.PATCH_FILE);
                    if (file.exists()) {
                        file.delete();
                    }
                    path = file.getPath();
                    if (e17 != null) {
                        str2 = e17.md5;
                    } else {
                        str2 = "";
                    }
                    str = pluginInfo.mID + str2 + FileSuffix.PATCH_FILE;
                    cVar2 = j(pluginInfo, path, str3, cVar, z16, bundle);
                } else {
                    httpNetReq.mReqUrl = pluginInfo.mURL;
                    path = new File(str3).getPath();
                    str = pluginInfo.mID + pluginInfo.mMD5;
                    o(this.f390259d, pluginInfo);
                    QLog.i("plugin_tag", 1, "miss Patch");
                    cVar2 = cVar;
                }
                String str4 = str;
                String str5 = path;
                httpNetReq.mOutPath = str5;
                if (z16 && (iPreDownloadController = this.C) != null && iPreDownloadController.isEnable()) {
                    this.f390264m.lock();
                    try {
                        HttpEngineTask httpEngineTask = new HttpEngineTask(g(), pluginInfo.mID, this, httpNetReq);
                        httpEngineTask.userData = cVar2;
                        this.C.requestPreDownload(h(pluginInfo.mID), null, str4, 0, httpNetReq.mReqUrl, str5, 1, 0, false, httpEngineTask);
                        this.f390263i.put(pluginInfo.mID, httpEngineTask);
                    } finally {
                    }
                } else {
                    l(pluginInfo.mID, httpNetReq, cVar2, null, false);
                    iHttpEngineService.sendReq(httpNetReq);
                }
                if (QLog.isColorLevel()) {
                    QLog.i("plugin_tag", 2, "downloadPlugin: " + httpNetReq.mReqUrl);
                }
            }
        } finally {
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 65792:
                e((NetResp) message.obj);
                return false;
            case 65793:
                d((NetReq) message.obj, message.arg1, message.arg2);
                return false;
            case Friends.TERM_TYPE_MOBILE_OTHER /* 65794 */:
                c((String) message.obj);
                return false;
            default:
                return false;
        }
    }

    @Override // com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask
    public void onPreDownloadStart(HttpEngineTask httpEngineTask) {
        this.f390263i.remove(httpEngineTask.httpReq.getUserData());
        l((String) httpEngineTask.httpReq.getUserData(), httpEngineTask.httpReq, (c) httpEngineTask.userData, httpEngineTask, true);
    }

    @Override // com.tencent.mobileqq.transfile.INetEngineListener
    public void onResp(NetResp netResp) {
        this.f390260e.obtainMessage(65792, netResp).sendToTarget();
    }

    @Override // com.tencent.mobileqq.transfile.INetEngineListener
    public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        this.f390260e.obtainMessage(65793, (int) j3, (int) j16, netReq).sendToTarget();
    }
}
