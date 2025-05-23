package gu2;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADApkDownloadTaskState;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pw2.n;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d extends hv2.d {

    /* renamed from: d, reason: collision with root package name */
    private final HashMap<String, Integer> f403360d;

    /* renamed from: e, reason: collision with root package name */
    private final HashMap<String, c> f403361e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f403362f;

    /* renamed from: g, reason: collision with root package name */
    private final DownloadListener f403363g;

    /* renamed from: h, reason: collision with root package name */
    private final gv2.c f403364h;

    /* renamed from: i, reason: collision with root package name */
    private final Runnable f403365i;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b implements gv2.c {
        b() {
        }

        @Override // gv2.c
        public void a() {
            n.e("QAdDownloadService", "onSwitchFront");
            ev2.a.c(d.this.f403364h);
            d.this.A().removeCallbacks(d.this.f403365i);
        }

        @Override // gv2.c
        public void b() {
            n.e("QAdDownloadService", MosaicConstants$JsFunction.FUNC_ON_SWITCH_BACKGROUND);
            d.this.A().removeCallbacks(d.this.f403365i);
            d.this.A().postDelayed(d.this.f403365i, 1800000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private boolean f403368a;

        /* renamed from: b, reason: collision with root package name */
        private int f403369b;

        /* renamed from: c, reason: collision with root package name */
        private com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.c f403370c;

        c() {
        }
    }

    public d() {
        super(qv2.b.a());
        this.f403360d = new HashMap<>();
        this.f403361e = new HashMap<>();
        this.f403363g = new a();
        this.f403364h = new b();
        this.f403365i = new Runnable() { // from class: gu2.c
            @Override // java.lang.Runnable
            public final void run() {
                d.this.F();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Handler A() {
        if (this.f403362f == null) {
            this.f403362f = new Handler(ThreadManagerV2.getQQCommonThreadLooper());
        }
        return this.f403362f;
    }

    private QADApkDownloadTaskState B(int i3) {
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 6) {
                        if (i3 != 10) {
                            if (i3 != 20) {
                                if (i3 != 30) {
                                    return QADApkDownloadTaskState.STATE_TASK_UNKNOWN;
                                }
                                return QADApkDownloadTaskState.TASK_FAILED;
                            }
                            return QADApkDownloadTaskState.TASK_WAITING;
                        }
                        return QADApkDownloadTaskState.TASK_DELETE;
                    }
                    return QADApkDownloadTaskState.TASK_APK_INSTALLED;
                }
                return QADApkDownloadTaskState.TASK_SUCCEED;
            }
            return QADApkDownloadTaskState.TASK_PAUSED;
        }
        return QADApkDownloadTaskState.TASK_DOWNLOADING;
    }

    private QADApkDownloadTaskState C(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return QADApkDownloadTaskState.STATE_TASK_UNKNOWN;
        }
        return B(downloadInfo.f());
    }

    private boolean D(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.c cVar) {
        Map<String, Object> c16 = cVar.c();
        if (c16 == null) {
            return false;
        }
        Object obj = c16.get("auto_install");
        if (!(obj instanceof Boolean)) {
            return false;
        }
        return ((Boolean) obj).booleanValue();
    }

    private boolean E(DownloadInfo downloadInfo) {
        c cVar;
        if (downloadInfo == null || TextUtils.isEmpty(downloadInfo.f341182d) || (cVar = this.f403361e.get(downloadInfo.f341182d)) == null) {
            return false;
        }
        return cVar.f403368a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F() {
        n.e("QAdDownloadService", "unRegisterDownloadListener");
        jy2.d.f411161a.a(this.f403363g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(DownloadInfo downloadInfo, int i3, String str) {
        if (downloadInfo == null) {
            return;
        }
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.e eVar = new com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.e(downloadInfo.f341186f, downloadInfo.f341189h, QADApkDownloadTaskState.TASK_FAILED);
        eVar.k(downloadInfo.L);
        eVar.h(i3);
        eVar.i(str);
        int i16 = 1;
        if (downloadInfo.J != 1) {
            i16 = 0;
        }
        eVar.g(i16);
        f().b(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.d dVar = new com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.d(downloadInfo.f341186f, downloadInfo.f341189h, downloadInfo.Q);
        dVar.e(downloadInfo.V);
        dVar.f(downloadInfo.f341180b0);
        f().a(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(DownloadInfo downloadInfo) {
        if (downloadInfo == null || !z(downloadInfo)) {
            return;
        }
        J(downloadInfo, C(downloadInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(DownloadInfo downloadInfo, QADApkDownloadTaskState qADApkDownloadTaskState) {
        if (downloadInfo == null) {
            return;
        }
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.e eVar = new com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.e(downloadInfo.f341186f, downloadInfo.f341189h, qADApkDownloadTaskState);
        eVar.k(downloadInfo.L);
        int i3 = 1;
        if (downloadInfo.J != 1) {
            i3 = 0;
        }
        eVar.g(i3);
        eVar.j(E(downloadInfo));
        f().b(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(String str) {
        f().b(new com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.e("", str, QADApkDownloadTaskState.TASK_APK_INSTALLED));
    }

    private void L() {
        n.e("QAdDownloadService", "registerDownloadListener");
        jy2.d dVar = jy2.d.f411161a;
        dVar.a(this.f403363g);
        dVar.e(this.f403363g);
        ev2.a.c(this.f403364h);
        ev2.a.b(this.f403364h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(DownloadInfo downloadInfo) {
        if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.f341182d)) {
            this.f403361e.remove(downloadInfo.f341182d);
        }
    }

    private void N(DownloadInfo downloadInfo, boolean z16, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.c cVar) {
        if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.f341182d)) {
            c cVar2 = this.f403361e.get(downloadInfo.f341182d);
            if (cVar2 == null) {
                cVar2 = new c();
            }
            cVar2.f403368a = z16;
            cVar2.f403369b = 1;
            cVar2.f403370c = cVar;
            this.f403361e.put(downloadInfo.f341182d, cVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.c y(DownloadInfo downloadInfo) {
        c cVar;
        if (downloadInfo == null || TextUtils.isEmpty(downloadInfo.f341182d) || (cVar = this.f403361e.get(downloadInfo.f341182d)) == null) {
            return null;
        }
        if (cVar.f403369b <= 0) {
            cVar.f403370c = null;
        } else {
            cVar.f403369b--;
        }
        return cVar.f403370c;
    }

    private boolean z(DownloadInfo downloadInfo) {
        if (TextUtils.isEmpty(downloadInfo.f341182d)) {
            return true;
        }
        Integer num = this.f403360d.get(downloadInfo.f341182d);
        if (num != null && num.intValue() == downloadInfo.f()) {
            return false;
        }
        if (downloadInfo.f() == 4) {
            this.f403360d.remove(downloadInfo.f341182d);
        } else {
            this.f403360d.put(downloadInfo.f341182d, Integer.valueOf(downloadInfo.f()));
        }
        return true;
    }

    @Override // hv2.d
    protected boolean a(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.c cVar) {
        return jy2.d.f411161a.d(cVar.b());
    }

    @Override // hv2.d
    protected void g(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.c cVar) {
        jy2.d.f411161a.f(cVar.b());
    }

    @Override // hv2.d
    public void i(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.b bVar, gv2.a aVar) {
        if (aVar == null) {
            return;
        }
        if (pw2.b.b(qv2.b.a(), bVar.b())) {
            aVar.a(new com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.a(bVar.a(), bVar.b(), QADApkDownloadTaskState.TASK_APK_INSTALLED, 100.0f));
            return;
        }
        DownloadInfo downloadInfoByUrl = jy2.d.f411161a.getDownloadInfoByUrl(bVar.a());
        if (downloadInfoByUrl == null) {
            aVar.a(null);
            return;
        }
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.a aVar2 = new com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.a(downloadInfoByUrl.f341186f, downloadInfoByUrl.f341189h, C(downloadInfoByUrl), downloadInfoByUrl.Q);
        aVar2.f(downloadInfoByUrl.L);
        aVar.a(aVar2);
    }

    @Override // hv2.d
    protected void l(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.c cVar) {
        boolean z16;
        L();
        jy2.d dVar = jy2.d.f411161a;
        DownloadInfo downloadInfoByUrl = dVar.getDownloadInfoByUrl(cVar.b());
        if (downloadInfoByUrl == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            downloadInfoByUrl = new DownloadInfo();
            downloadInfoByUrl.f341186f = cVar.b();
            downloadInfoByUrl.f341189h = cVar.e();
            downloadInfoByUrl.Y = cVar.d();
            downloadInfoByUrl.m();
        }
        downloadInfoByUrl.T = D(cVar);
        downloadInfoByUrl.f341203s0 = true;
        downloadInfoByUrl.M = "biz_src_ads_xsj";
        N(downloadInfoByUrl, z16, cVar);
        if (downloadInfoByUrl.f() == 4) {
            J(downloadInfoByUrl, QADApkDownloadTaskState.TASK_LAUNCH_INSTALL_SUCCESS);
            if (!dVar.b(downloadInfoByUrl)) {
                J(downloadInfoByUrl, QADApkDownloadTaskState.TASK_LAUNCH_INSTALL_FAILED);
                return;
            }
            return;
        }
        dVar.c(downloadInfoByUrl);
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements DownloadListener {
        a() {
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void installSucceed(String str, String str2) {
            d.this.K(str2);
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadCancel(DownloadInfo downloadInfo) {
            d.this.I(downloadInfo);
            d.this.M(downloadInfo);
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadError(DownloadInfo downloadInfo, int i3, String str, int i16) {
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.c y16;
            if (i3 != 6 || (y16 = d.this.y(downloadInfo)) == null) {
                d.this.G(downloadInfo, i3, str);
            } else {
                d.this.l(y16);
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadFinish(DownloadInfo downloadInfo) {
            d.this.I(downloadInfo);
            d.this.J(downloadInfo, QADApkDownloadTaskState.TASK_LAUNCH_INSTALL_SUCCESS);
            d.this.M(downloadInfo);
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadPause(DownloadInfo downloadInfo) {
            d.this.I(downloadInfo);
            d.this.M(downloadInfo);
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadUpdate(List<DownloadInfo> list) {
            if (y.h(list)) {
                return;
            }
            for (DownloadInfo downloadInfo : list) {
                d.this.I(downloadInfo);
                d.this.H(downloadInfo);
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadWait(DownloadInfo downloadInfo) {
            d.this.I(downloadInfo);
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void packageReplaced(String str, String str2) {
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void uninstallSucceed(String str, String str2) {
        }
    }
}
