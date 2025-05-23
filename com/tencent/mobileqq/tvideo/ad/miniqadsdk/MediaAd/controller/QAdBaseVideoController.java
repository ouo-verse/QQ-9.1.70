package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.e;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.AdConstants$ViewState;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.d;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.QAdVideoHelper;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.report.QAdPerformanceDefine$MonitorAdKey;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.utils.BaseTimerRunnable;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.QAdBaseVideoView;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.QAdVideoView;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.VideoReportInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adclick.QAdStandardClickReportInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adexposure.QAdStandardExposureReportInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.QAdThreadManager;
import com.tencent.qqlive.ona.protocol.jce.AdAction;
import com.tencent.qqlive.ona.protocol.jce.AdInSideExtraReportItem;
import com.tencent.qqlive.ona.protocol.jce.AdInSideVideoExposureItem;
import com.tencent.qqlive.ona.protocol.jce.AdInsideEmptyItem;
import com.tencent.qqlive.ona.protocol.jce.AdInsideVideoItem;
import com.tencent.qqlive.ona.protocol.jce.AdInsideVideoPoster;
import com.tencent.qqlive.ona.protocol.jce.AdInsideVideoRequest;
import com.tencent.qqlive.ona.protocol.jce.AdLongVideoInfo;
import com.tencent.qqlive.ona.protocol.jce.AdOrderItem;
import com.tencent.qqlive.ona.protocol.jce.AdReport;
import com.tencent.qqlive.ona.protocol.jce.AdTempletItem;
import com.tencent.qqlive.ona.protocol.jce.AdVideoItem;
import com.tencent.qqlive.ona.protocol.jce.InsideVideoSkipAdInfo;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import pw2.n;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class QAdBaseVideoController implements xu2.a, uu2.b {
    protected static String Z = "QAdBaseVideoController";

    /* renamed from: a0, reason: collision with root package name */
    static HashMap<Integer, k> f303532a0;

    /* renamed from: b0, reason: collision with root package name */
    private static int f303533b0;
    private int C;
    protected boolean D;
    protected int E;
    private BroadcastReceiver G;
    private boolean H;
    private boolean I;
    protected ju2.a J;
    private AdInsideVideoItem K;
    private boolean L;
    protected com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.a O;
    private QAdVrReportParams P;
    public vu2.a Q;
    private CountDownRunnable X;
    private Thread Y;

    /* renamed from: a, reason: collision with root package name */
    protected AdInsideVideoRequest f303534a;

    /* renamed from: b, reason: collision with root package name */
    protected volatile Context f303535b;

    /* renamed from: c, reason: collision with root package name */
    protected String f303536c;

    /* renamed from: d, reason: collision with root package name */
    protected volatile bv2.b f303537d;

    /* renamed from: e, reason: collision with root package name */
    protected iu2.a f303538e;

    /* renamed from: h, reason: collision with root package name */
    protected InsideVideoSkipAdInfo f303541h;

    /* renamed from: i, reason: collision with root package name */
    private volatile QAdBaseVideoView f303542i;

    /* renamed from: l, reason: collision with root package name */
    private boolean f303545l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f303546m;

    /* renamed from: n, reason: collision with root package name */
    protected boolean f303547n;

    /* renamed from: o, reason: collision with root package name */
    protected long f303548o;

    /* renamed from: p, reason: collision with root package name */
    private int f303549p;

    /* renamed from: q, reason: collision with root package name */
    protected int f303550q;

    /* renamed from: t, reason: collision with root package name */
    protected volatile AdInsideVideoItem f303553t;

    /* renamed from: x, reason: collision with root package name */
    private long f303557x;

    /* renamed from: z, reason: collision with root package name */
    private boolean f303559z;

    /* renamed from: k, reason: collision with root package name */
    private boolean f303544k = false;

    /* renamed from: r, reason: collision with root package name */
    protected int f303551r = -1;

    /* renamed from: s, reason: collision with root package name */
    private int f303552s = -1;

    /* renamed from: u, reason: collision with root package name */
    protected final ArrayList<AdReport> f303554u = new ArrayList<>();

    /* renamed from: v, reason: collision with root package name */
    protected final ArrayList<AdReport> f303555v = new ArrayList<>();

    /* renamed from: w, reason: collision with root package name */
    private final Set<String> f303556w = new HashSet();

    /* renamed from: y, reason: collision with root package name */
    protected int f303558y = -1;
    protected volatile boolean A = false;
    private int B = 1;
    private boolean F = true;
    private boolean M = false;
    protected boolean N = false;
    private boolean R = false;
    private boolean S = false;
    protected int T = 0;
    protected boolean U = true;
    protected boolean V = false;
    private l W = new l(this);

    /* renamed from: f, reason: collision with root package name */
    protected CopyOnWriteArrayList<com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.b> f303539f = new CopyOnWriteArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    protected final CopyOnWriteArrayList<com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c> f303540g = new CopyOnWriteArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    private CountDownLatch f303543j = new CountDownLatch(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class CountDownRunnable extends BaseTimerRunnable {

        /* renamed from: f, reason: collision with root package name */
        private int f303562f;

        /* renamed from: h, reason: collision with root package name */
        private boolean f303563h = false;

        /* renamed from: i, reason: collision with root package name */
        private boolean f303564i = false;

        /* renamed from: m, reason: collision with root package name */
        private final WeakReference<QAdBaseVideoController> f303565m;

        public CountDownRunnable(QAdBaseVideoController qAdBaseVideoController) {
            this.f303565m = new WeakReference<>(qAdBaseVideoController);
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.utils.BaseTimerRunnable
        protected void e() {
            n.g(QAdBaseVideoController.Z, "CountDownRunnable started");
            QAdBaseVideoController qAdBaseVideoController = this.f303565m.get();
            if (qAdBaseVideoController == null) {
                n.b(QAdBaseVideoController.Z, "CountDownRunnable.doPreparation -> mController.get() = null");
                return;
            }
            CopyOnWriteArrayList<com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c> copyOnWriteArrayList = qAdBaseVideoController.f303540g;
            if (copyOnWriteArrayList == null) {
                this.f303562f = 0;
            } else {
                this.f303562f = yu2.b.n(copyOnWriteArrayList, copyOnWriteArrayList.size(), qAdBaseVideoController.U);
            }
            n.a(QAdBaseVideoController.Z, "Total duration:" + this.f303562f);
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.utils.BaseTimerRunnable
        protected void f() {
            QAdBaseVideoController qAdBaseVideoController = this.f303565m.get();
            if (qAdBaseVideoController == null) {
                n.b(QAdBaseVideoController.Z, "CountDownRunnable.doPreparation -> mController.get() = null");
                return;
            }
            bv2.b m06 = qAdBaseVideoController.m0();
            QAdBaseVideoView n06 = qAdBaseVideoController.n0();
            if (qAdBaseVideoController.f303547n && m06 != null && n06 != null) {
                final int d16 = m06.d();
                m06.i(d16);
                if (d16 > 0) {
                    qAdBaseVideoController.f303550q = d16;
                }
                if (!qAdBaseVideoController.f303546m && qAdBaseVideoController.f303551r == 0 && !this.f303564i) {
                    qAdBaseVideoController.O(0);
                    this.f303564i = true;
                }
                qAdBaseVideoController.f303546m = true;
                int n3 = yu2.b.n(qAdBaseVideoController.f303540g, qAdBaseVideoController.f303551r + 1, qAdBaseVideoController.U);
                int i3 = qAdBaseVideoController.f303551r + 1;
                if (!this.f303563h) {
                    this.f303563h = true;
                    qAdBaseVideoController.W.sendEmptyMessage(1001);
                }
                if (d16 + 10 >= this.f303562f) {
                    n.a(QAdBaseVideoController.Z, "Last roll with position:" + d16 + " , now destory webview");
                }
                n.a(QAdBaseVideoController.Z, "doRepeatedWork - position:" + d16 + ", duration:" + n3);
                if (yu2.d.e() + d16 >= n3 && i3 < qAdBaseVideoController.f303540g.size()) {
                    qAdBaseVideoController.W(qAdBaseVideoController.f303551r);
                    qAdBaseVideoController.L0(i3);
                    qAdBaseVideoController.W.sendEmptyMessage(1001);
                    qAdBaseVideoController.W.sendEmptyMessage(1106);
                    qAdBaseVideoController.W.sendEmptyMessage(1112);
                }
                final int n16 = d16 - yu2.b.n(qAdBaseVideoController.f303540g, qAdBaseVideoController.f303551r, qAdBaseVideoController.U);
                final int o16 = yu2.b.o(qAdBaseVideoController.f303540g, qAdBaseVideoController.f303551r, qAdBaseVideoController.U);
                qAdBaseVideoController.S(n16, false);
                qAdBaseVideoController.u1(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.QAdBaseVideoController.CountDownRunnable.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QAdBaseVideoController qAdBaseVideoController2 = (QAdBaseVideoController) CountDownRunnable.this.f303565m.get();
                        if (qAdBaseVideoController2 == null) {
                            n.b(QAdBaseVideoController.Z, "CountDownRunnable.doPreparation -> mController.get() = null");
                            return;
                        }
                        QAdBaseVideoView n07 = qAdBaseVideoController2.n0();
                        if (n07 != null) {
                            if (((int) Math.round(n16 / 1000.0d)) >= qAdBaseVideoController2.B) {
                                n07.X();
                            }
                            int unused = QAdBaseVideoController.f303533b0 = QAdBaseVideoController.A(qAdBaseVideoController2, d16, o16);
                            n07.Z(d16, n16, QAdBaseVideoController.f303533b0);
                            n07.b0(QAdBaseVideoController.p0(qAdBaseVideoController2, n16, o16));
                            qAdBaseVideoController2.O1(d16, qAdBaseVideoController2.f303548o);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements e.a {
        a() {
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.e.a
        public void a() {
            QAdBaseVideoController.this.t1();
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.e.a
        public void b() {
            QAdBaseVideoController.this.d1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f303570a;

        static {
            int[] iArr = new int[QAdBaseVideoView.SkipCause.values().length];
            f303570a = iArr;
            try {
                iArr[QAdBaseVideoView.SkipCause.REQUEST_TIMEOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f303570a[QAdBaseVideoView.SkipCause.PLAY_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f303570a[QAdBaseVideoView.SkipCause.PLAY_STUCK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class c implements k {
        c() {
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.QAdBaseVideoController.k
        public void a(QAdBaseVideoView qAdBaseVideoView, QAdBaseVideoController qAdBaseVideoController) {
            qAdBaseVideoController.M0();
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class d implements k {
        d() {
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.QAdBaseVideoController.k
        public void a(QAdBaseVideoView qAdBaseVideoView, QAdBaseVideoController qAdBaseVideoController) {
            if (qAdBaseVideoView != null) {
                qAdBaseVideoView.V();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class e implements k {
        e() {
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.QAdBaseVideoController.k
        public void a(QAdBaseVideoView qAdBaseVideoView, QAdBaseVideoController qAdBaseVideoController) {
            if ((qAdBaseVideoController == null || !yu2.b.G(qAdBaseVideoController.f303540g, qAdBaseVideoController.f303559z)) && qAdBaseVideoView != null) {
                qAdBaseVideoView.Y();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class f implements k {
        f() {
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.QAdBaseVideoController.k
        public void a(QAdBaseVideoView qAdBaseVideoView, QAdBaseVideoController qAdBaseVideoController) {
            if ((qAdBaseVideoController == null || !yu2.b.G(qAdBaseVideoController.f303540g, qAdBaseVideoController.f303559z)) && qAdBaseVideoView != null) {
                qAdBaseVideoView.y();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class g implements k {
        g() {
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.QAdBaseVideoController.k
        public void a(QAdBaseVideoView qAdBaseVideoView, QAdBaseVideoController qAdBaseVideoController) {
            if (qAdBaseVideoView != null) {
                qAdBaseVideoView.X();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class h implements k {
        h() {
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.QAdBaseVideoController.k
        public void a(QAdBaseVideoView qAdBaseVideoView, QAdBaseVideoController qAdBaseVideoController) {
            boolean z16;
            if (qAdBaseVideoView != null) {
                if (qAdBaseVideoController.f303551r == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                qAdBaseVideoView.w(z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class i implements k {
        i() {
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.QAdBaseVideoController.k
        public void a(QAdBaseVideoView qAdBaseVideoView, QAdBaseVideoController qAdBaseVideoController) {
            if (qAdBaseVideoView != null) {
                qAdBaseVideoView.setVisibility(0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class j implements k {
        j() {
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.QAdBaseVideoController.k
        public void a(QAdBaseVideoView qAdBaseVideoView, QAdBaseVideoController qAdBaseVideoController) {
            if (qAdBaseVideoView != null) {
                qAdBaseVideoView.setVisibility(8);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    interface k {
        void a(QAdBaseVideoView qAdBaseVideoView, QAdBaseVideoController qAdBaseVideoController);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class l extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QAdBaseVideoController> f303571a;

        public l(QAdBaseVideoController qAdBaseVideoController) {
            super(Looper.getMainLooper());
            this.f303571a = new WeakReference<>(qAdBaseVideoController);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            QAdBaseVideoController qAdBaseVideoController = this.f303571a.get();
            if (qAdBaseVideoController == null) {
                n.b(QAdBaseVideoController.Z, "UIHandler -> mController.get() is null");
                return;
            }
            QAdBaseVideoView n06 = qAdBaseVideoController.n0();
            int i3 = message.what;
            if (QAdBaseVideoController.f303532a0.get(Integer.valueOf(i3)) != null) {
                QAdBaseVideoController.f303532a0.get(Integer.valueOf(i3)).a(n06, qAdBaseVideoController);
            }
        }
    }

    static {
        HashMap<Integer, k> hashMap = new HashMap<>();
        f303532a0 = hashMap;
        hashMap.put(1006, new c());
        f303532a0.put(1106, new d());
        f303532a0.put(1112, new e());
        f303532a0.put(1107, new f());
        f303532a0.put(1001, new g());
        f303532a0.put(1012, new h());
        f303532a0.put(1003, new i());
        f303532a0.put(1004, new j());
        f303533b0 = 0;
    }

    public QAdBaseVideoController(Context context) {
        this.f303535b = context;
        w1();
    }

    protected static int A(QAdBaseVideoController qAdBaseVideoController, int i3, int i16) {
        return (int) Math.round((((qAdBaseVideoController.f303548o - qAdBaseVideoController.f303549p) - i3) - i16) / 1000.0d);
    }

    private void A1(View view) {
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.a aVar = this.O;
        if (aVar != null) {
            aVar.d(view);
        }
    }

    private void B0(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean equals = str.equals("MODE_MINI_VIEW_NEW");
        if (z16) {
            if (equals) {
                k0();
                y1(1);
                return;
            } else {
                G0();
                return;
            }
        }
        if (!equals) {
            D1();
        }
    }

    private boolean C1(ArrayList<com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c> arrayList) {
        if (arrayList.size() == 0) {
            this.f303538e = new iu2.a(101, "no ad for this vid.");
            return true;
        }
        if (this.N && yu2.b.R(this.f303534a)) {
            arrayList.size();
            this.f303538e = new iu2.a(200, "User is vip.");
            return true;
        }
        return false;
    }

    private void D0(long j3, @NonNull AdInsideVideoItem adInsideVideoItem) {
        AdLongVideoInfo adLongVideoInfo;
        this.f303548o += j3;
        AdOrderItem adOrderItem = adInsideVideoItem.orderItem;
        if (adOrderItem != null && 5 == adOrderItem.adType) {
            this.f303549p = (int) (this.f303549p + j3);
        }
        AdInsideVideoPoster adInsideVideoPoster = adInsideVideoItem.videoPoster;
        if (adInsideVideoPoster != null && (adLongVideoInfo = adInsideVideoPoster.longVideoInfo) != null) {
            adLongVideoInfo.playDuration *= 1000;
            adLongVideoInfo.fullVideoButtonShowTime *= 1000;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E1(QAdBaseVideoView qAdBaseVideoView) {
        qAdBaseVideoView.setRequest(this.f303534a);
        qAdBaseVideoView.setAdItem(this.f303553t);
        qAdBaseVideoView.setCanShowSkipCountDown(this.f303559z);
        qAdBaseVideoView.J(this.N);
        qAdBaseVideoView.setEnableClick(this.F);
        qAdBaseVideoView.setEnableScroll(QAdVideoHelper.n(z0()));
        qAdBaseVideoView.j0();
        G1();
        V(qAdBaseVideoView);
    }

    private void G1() {
        n.a(Z, "updateCountDown");
        if (this.X == null) {
            this.X = new CountDownRunnable(this);
        }
        Thread thread = this.Y;
        if (thread == null || !thread.isAlive() || !this.X.g()) {
            BaseThread baseThread = new BaseThread(this.X);
            this.Y = baseThread;
            try {
                baseThread.start();
                n.a(Z, "updateCountDown start");
            } catch (Throwable th5) {
                n.c(Z, th5);
            }
        }
    }

    private com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.b I(AdInsideVideoItem adInsideVideoItem, int i3, Context context, wv2.a aVar) {
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.b a16 = wv2.b.a(aVar, context);
        if (a16 == null) {
            return null;
        }
        a16.i(K(adInsideVideoItem, i3));
        return a16;
    }

    private void I1() {
        L0(0);
        this.W.sendEmptyMessage(1006);
    }

    private wv2.a J(AdInsideVideoItem adInsideVideoItem, int i3, AdAction adAction, int i16) {
        wv2.a T = yu2.b.T(adInsideVideoItem, t0(), adAction, i16, i3, w0(i3), this.R);
        if (this.f303553t != null && this.f303553t.orderItem != null) {
            T.F = this.f303553t.orderItem.vrReportMap;
        }
        return T;
    }

    private com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.e K(AdInsideVideoItem adInsideVideoItem, int i3) {
        return new com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.e(new a(), this.f303553t, i3);
    }

    private com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d L(AdInsideVideoItem adInsideVideoItem, QAdStandardClickReportInfo.ClickExtraInfo clickExtraInfo, int i3, wv2.a aVar, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.b bVar) {
        boolean z16;
        int i16 = 0;
        if ((aVar.f446568d && yu2.b.B(bVar) && yu2.b.v(i3)) || (aVar.f446568d && (bVar instanceof cw2.c))) {
            z16 = true;
        } else {
            z16 = false;
        }
        HashMap<String, String> e16 = qu2.a.e((com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c) y.d(this.f303540g, this.f303551r));
        e16.putAll(qu2.a.a(this.J));
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d U = yu2.b.U(adInsideVideoItem, this.f303536c, clickExtraInfo, z16, i3, e16);
        if (U == null) {
            return null;
        }
        U.w(U0());
        if (T0(this.f303553t) && yu2.b.V(this.f303558y)) {
            i16 = 4;
        }
        U.u(i16);
        return U;
    }

    private void L1() {
        if (this.G != null) {
            try {
                this.f303535b.unregisterReceiver(this.G);
                this.G = null;
                n.g(Z, "unregister mInstallReceiver");
            } catch (Throwable th5) {
                n.c(Z, th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0() {
        if (this.f303535b == null) {
            return;
        }
        this.f303542i = new QAdVideoView(this.f303535b);
        this.f303542i.A(this.f303541h, this.f303553t);
        this.f303542i.setAdUIListener(this);
        this.f303542i.setIsPortraitEpisode(this.V);
        this.f303542i.B(yu2.b.k(o0(), this.K));
        this.f303542i.setAdType(this.f303558y);
    }

    private void N() {
        n.a(Z, "destroyVariable");
        this.f303537d = null;
        this.f303543j = null;
        this.f303544k = false;
        this.V = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(int i3) {
        R(false);
        a0(i3);
    }

    private void P(AdInsideVideoItem adInsideVideoItem, QAdStandardClickReportInfo.ClickExtraInfo clickExtraInfo, int i3, AdAction adAction, int i16) {
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d L;
        Context context = this.f303535b;
        if (context != null && adInsideVideoItem != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f303557x < 500) {
                n.a(Z, "return due to click-wait");
                return;
            }
            this.f303557x = currentTimeMillis;
            wv2.a J = J(adInsideVideoItem, i3, adAction, i16);
            x(J, adInsideVideoItem);
            n.a(Z, "doclick mApkDownloading=" + this.S + " from=" + i16);
            if (J != null && this.S) {
                J.B = true;
            }
            J.G = yu2.b.v(i3);
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.b I = I(adInsideVideoItem, i16, context, J);
            if (I == null || (L = L(adInsideVideoItem, clickExtraInfo, i3, J, I)) == null) {
                return;
            }
            I.c(L, null);
        }
    }

    private void P0() {
        if (this.f303553t == null && n0() != null) {
            return;
        }
        QAdVrReportParams f16 = qu2.b.f(this.f303553t.orderItem, n0());
        this.P = f16;
        f16.e("eid");
    }

    private void Q(int i3, boolean z16) {
        synchronized (this.f303555v) {
            if (y.h(this.f303555v)) {
                return;
            }
            AdInsideVideoItem o06 = o0();
            if (o06 == null) {
                return;
            }
            Iterator<AdReport> it = this.f303555v.iterator();
            while (it.hasNext()) {
                AdReport next = it.next();
                int i16 = 1;
                if (i3 >= next.reportTime) {
                    HashMap<String, String> e16 = qu2.a.e((com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c) y.d(this.f303540g, this.f303551r));
                    e16.putAll(qu2.a.a(this.J));
                    QAdStandardExposureReportInfo F = QAdStandardExposureReportInfo.F(next, o06.orderItem, 1001, nv2.a.a(this.f303536c), i3, e16);
                    if (F != null) {
                        if (!T0(o06) || !yu2.b.V(this.f303558y)) {
                            i16 = 0;
                        }
                        F.u(i16);
                        F.w(U0());
                        F.t(null);
                        b1();
                        if (!TextUtils.isEmpty(F.q())) {
                            g0();
                        } else {
                            n.e(Z, "doVREffectExposureReport return ,report url is null");
                        }
                    }
                    it.remove();
                } else if (z16) {
                    ru2.a K = ru2.a.K(next, o06.orderItem, 1001, nv2.a.a(this.f303536c), i3);
                    if (K != null) {
                        if (!T0(o06) || !yu2.b.V(this.f303558y)) {
                            i16 = 0;
                        }
                        K.u(i16);
                        K.w(U0());
                        K.t(null);
                    }
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R0() {
        QAdBaseVideoView n06 = n0();
        if (n06 != null) {
            n06.m();
        }
    }

    private void R1(int i3, AdInsideVideoItem adInsideVideoItem, int i16) {
        S1(i3, adInsideVideoItem, -1L, i16);
    }

    private void S1(int i3, AdInsideVideoItem adInsideVideoItem, long j3, int i16) {
        AdVideoItem adVideoItem;
        if (this.f303547n && this.O != null) {
            AdOrderItem adOrderItem = null;
            if (adInsideVideoItem != null) {
                adVideoItem = adInsideVideoItem.videoItem;
            } else {
                adVideoItem = null;
            }
            if (adInsideVideoItem != null) {
                adOrderItem = adInsideVideoItem.orderItem;
            }
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.d g16 = new d.b().k(adVideoItem).f(s0(i3, adInsideVideoItem)).h(false).j(z0()).i(j3).g();
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.e eVar = new com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.e();
            eVar.f303605b = i3;
            eVar.f303606c = adOrderItem;
            eVar.f303604a = i16;
            eVar.f303607d = this.T;
            eVar.f303609f = g16;
            this.O.h(eVar);
        }
    }

    private void T(boolean z16) {
        String str;
        if (z16) {
            str = "doVREffectExposureReport";
        } else {
            str = "doVROriginExposureReport";
        }
        if (this.f303553t == null) {
            n.e(Z, str + " return ,mCurrentAdItem = null");
            return;
        }
        QAdBaseVideoView n06 = n0();
        if (n06 == null) {
            n.e(Z, str + " return ,qAdVideoView = null");
            return;
        }
        QAdVrReportParams i3 = new QAdVrReportParams.a().f(QAdVrReportParams.ParamKey.AD_SHOW_TYPE, String.valueOf(this.T)).f(QAdVrReportParams.ParamKey.AD_LAYER, Integer.valueOf(l0())).f(QAdVrReportParams.ParamKey.IS_FULLSCREEN, x0(n06)).i();
        n.e(Z, str);
        if (z16) {
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.c.d(this.f303553t.orderItem, n06, QAdVrReport.ElementID.WHOLE_PLAYBOX_AD, i3);
        } else {
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.c.e(this.f303553t.orderItem, n06, QAdVrReport.ElementID.WHOLE_PLAYBOX_AD, i3);
        }
    }

    private boolean U0() {
        AdInSideExtraReportItem adInSideExtraReportItem;
        AdInsideVideoItem o06 = o0();
        if (o06 != null && (adInSideExtraReportItem = o06.extraReportItem) != null && adInSideExtraReportItem.needRetryReport) {
            return true;
        }
        return false;
    }

    private void V(QAdBaseVideoView qAdBaseVideoView) {
        O0(qAdBaseVideoView);
    }

    private void X(int i3, boolean z16) {
        synchronized (this.f303554u) {
            if (y.h(this.f303554u)) {
                return;
            }
            AdInsideVideoItem o06 = o0();
            if (o06 == null) {
                return;
            }
            Iterator<AdReport> it = this.f303554u.iterator();
            while (it.hasNext()) {
                AdReport next = it.next();
                if (i3 >= next.reportTime) {
                    this.f303556w.add(next.url);
                    HashMap<String, String> e16 = qu2.a.e((com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c) y.d(this.f303540g, this.f303551r));
                    e16.putAll(qu2.a.a(this.J));
                    QAdStandardExposureReportInfo F = QAdStandardExposureReportInfo.F(next, o06.orderItem, 1000, nv2.a.a(this.f303536c), i3, e16);
                    if (F != null) {
                        F.w(U0());
                        F.u(u0(o06));
                        F.t(null);
                        c1();
                        if (!TextUtils.isEmpty(F.q())) {
                            h0();
                        } else {
                            n.e(Z, "doVROriginExposureReport return ,report url is null");
                        }
                        P0();
                    }
                    it.remove();
                } else if (z16) {
                    ru2.a K = ru2.a.K(next, o06.orderItem, 1000, nv2.a.a(this.f303536c), i3);
                    if (K != null) {
                        K.w(U0());
                        K.u(u0(o06));
                        K.t(null);
                    }
                    it.remove();
                }
            }
        }
    }

    private void Z(QAdBaseVideoView.SkipCause skipCause) {
        int i3 = b.f303570a[skipCause.ordinal()];
        if (i3 != 1 && i3 != 2) {
            if (i3 != 3) {
                l1(y0(this.f303551r));
                return;
            } else {
                j1(y0(this.f303551r), 2);
                return;
            }
        }
        j1(y0(this.f303551r), 1);
    }

    private void a0(int i3) {
        if (i3 > 0) {
            q1(i3);
        }
        p1(i3);
    }

    private void b0() {
        iu2.a aVar = this.f303538e;
        if (aVar != null && !this.L) {
            AdInsideVideoItem adInsideVideoItem = this.K;
            if (adInsideVideoItem != null) {
                su2.b.q(adInsideVideoItem, aVar.a(), this.f303536c);
                this.L = true;
            } else {
                bv2.b m06 = m0();
                if (m06 != null) {
                    m06.r(this.f303538e);
                    this.L = true;
                }
            }
        }
        U();
    }

    private void c0(QAdBaseVideoView.SkipCause skipCause) {
        if (!this.f303547n) {
            return;
        }
        Z(skipCause);
    }

    private void d0(QAdBaseVideoView.SkipCause skipCause) {
        n.a(Z, "informAdSkipped: " + skipCause.toString());
        if (skipCause == QAdBaseVideoView.SkipCause.PLAY_FAILED) {
            this.f303538e = new iu2.a(204, "player played ad failed.");
        } else if (skipCause == QAdBaseVideoView.SkipCause.PLAY_STUCK) {
            this.f303538e = new iu2.a(207, "AD is closed by partner.");
        } else if (skipCause == QAdBaseVideoView.SkipCause.REQUEST_TIMEOUT) {
            B();
            this.f303538e = new iu2.a(205, "ad request is timeout, e.g. 5 seconds.");
        } else if (skipCause == QAdBaseVideoView.SkipCause.USER_RETURN) {
            if (!this.A) {
                B();
                this.f303538e = new iu2.a(208, "AD request is closed by user.");
            }
            a1(1, 0);
        } else if (skipCause == QAdBaseVideoView.SkipCause.USER_SKIP) {
            a1(2, 0);
        }
        J1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d1() {
        n.a(Z, "mraid pause");
        this.H = true;
        bv2.b m06 = m0();
        if (m06 != null) {
            m06.q();
        }
    }

    private void e0() {
        AdOrderItem adOrderItem;
        QAdBaseVideoView n06 = n0();
        if (n06 == null) {
            n.h(Z, "doSkipViewEventReport videoView is null");
            return;
        }
        QAdVrReportParams i3 = new QAdVrReportParams().i().d(l0()).f("ad_showtime", Integer.valueOf(this.f303550q - yu2.b.q(this.f303541h))).f(QAdVrReportParams.ParamKey.AD_SHOW_TYPE, Integer.valueOf(this.T)).i();
        if (this.f303553t == null) {
            adOrderItem = null;
        } else {
            adOrderItem = this.f303553t.orderItem;
        }
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.c.c(adOrderItem, n06.p(), QAdVrReport.ElementID.SKIP_BUTTON, i3);
    }

    private void g0() {
        T(true);
    }

    private void g1() {
        ew2.f D;
        Iterator<com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.b> it = this.f303539f.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.b next = it.next();
            AdInsideEmptyItem adInsideEmptyItem = next.f303587a;
            if (adInsideEmptyItem != null && (D = ew2.f.D(adInsideEmptyItem.orderItem, nv2.a.a(this.f303536c))) != null) {
                D.u(2);
                D.t(null);
                X0(next.f303587a.orderItem);
            }
        }
        this.f303539f.clear();
    }

    private void h0() {
        T(false);
    }

    private void h1() {
        Iterator<com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.b> it = this.f303539f.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.b next = it.next();
            if (next.f303587a != null) {
                com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c cVar = (com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c) y.d(this.f303540g, this.f303551r);
                if (cVar == null) {
                    return;
                }
                if (next.f303588b < cVar.f303593e) {
                    ew2.f D = ew2.f.D(next.f303587a.orderItem, nv2.a.a(this.f303536c));
                    if (D != null) {
                        D.u(2);
                        D.t(null);
                        X0(next.f303587a.orderItem);
                    }
                    this.f303539f.remove(next);
                }
            }
        }
    }

    private void i0(String str, QAdVrReportParams qAdVrReportParams) {
        AdOrderItem adOrderItem;
        QAdBaseVideoView n06 = n0();
        if (n06 != null && !TextUtils.isEmpty(str)) {
            View d16 = qu2.b.d(n0().t(), str);
            for (Map.Entry<String, Object> entry : qAdVrReportParams.h().entrySet()) {
                qu2.b.b(d16, entry.getKey(), entry.getValue());
            }
            qAdVrReportParams.f(QAdVrReportParams.ParamKey.AD_SHOW_TYPE, Integer.valueOf(this.T));
            if (this.f303553t == null) {
                adOrderItem = null;
            } else {
                adOrderItem = this.f303553t.orderItem;
            }
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.c.c(adOrderItem, n06, str, qAdVrReportParams);
        }
    }

    private void i1() {
        AdInsideVideoItem adInsideVideoItem;
        ew2.f D;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c cVar = (com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c) y.d(this.f303540g, this.f303551r);
        if (cVar != null && (adInsideVideoItem = cVar.f303589a) != null && (D = ew2.f.D(adInsideVideoItem.orderItem, nv2.a.a(this.f303536c))) != null) {
            D.u(2);
            D.t(null);
            X0(cVar.f303589a.orderItem);
        }
    }

    private void j1(int i3, int i16) {
        fw2.a F;
        AdInsideVideoItem o06 = o0();
        if (o06 != null && (F = fw2.a.F(o06.orderItem, 6, i3, i16, r0())) != null) {
            F.t(null);
        }
        R1(5, this.f303553t, i16);
    }

    private void k1(int i3, int i16) {
        AdInsideVideoItem adInsideVideoItem;
        AdOrderItem adOrderItem;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c cVar = (com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c) y.d(this.f303540g, i16);
        if (cVar != null && (adInsideVideoItem = cVar.f303589a) != null && (adOrderItem = adInsideVideoItem.orderItem) != null) {
            fw2.a E = fw2.a.E(adOrderItem, 4, i3, 0);
            if (E != null) {
                E.t(null);
            }
            R1(4, cVar.f303589a, 0);
        }
    }

    private void l1(int i3) {
        fw2.a E;
        if (F0()) {
            return;
        }
        AdInsideVideoItem o06 = o0();
        if (o06 != null && (E = fw2.a.E(o06.orderItem, 10, i3, 0)) != null) {
            E.t(null);
        }
        R1(9, o06, 0);
    }

    private void m1(int i3) {
        fw2.a E;
        AdInsideVideoItem o06 = o0();
        if (o06 != null && (E = fw2.a.E(o06.orderItem, 2, i3, 0)) != null) {
            E.t(null);
        }
        R1(2, o06, 0);
    }

    private void n1(int i3) {
        R1(8, o0(), 0);
    }

    private void o1(int i3) {
        fw2.a E;
        AdInsideVideoItem o06 = o0();
        if (o06 != null && (E = fw2.a.E(o06.orderItem, 3, i3, 0)) != null) {
            E.t(null);
        }
        R1(3, o06, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int p0(QAdBaseVideoController qAdBaseVideoController, int i3, int i16) {
        return (int) Math.round((((qAdBaseVideoController.C - qAdBaseVideoController.f303549p) - i3) - i16) / 1000.0d);
    }

    private void p1(int i3) {
        fw2.a E;
        AdInsideVideoItem o06 = o0();
        if (o06 != null && (E = fw2.a.E(o06.orderItem, 1, 0, 0)) != null) {
            E.t(null);
        }
        S1(1, o06, 0L, 0);
    }

    private String q0() {
        if (this.f303558y != 3) {
            return "";
        }
        return QAdPerformanceDefine$MonitorAdKey.Q_AD_MONITOR_INFO_REPORT_KEY_MIDDLE;
    }

    private String r0() {
        AdInsideVideoItem adInsideVideoItem;
        AdOrderItem adOrderItem;
        StringBuilder sb5 = new StringBuilder();
        if (this.f303540g != null) {
            int i3 = this.f303551r;
            if (i3 < 0) {
                i3 = 0;
            }
            while (i3 < this.f303540g.size()) {
                com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c cVar = this.f303540g.get(i3);
                if (cVar != null && (adInsideVideoItem = cVar.f303589a) != null && (adOrderItem = adInsideVideoItem.orderItem) != null) {
                    sb5.append(adOrderItem.orderId);
                    sb5.append(",");
                }
                i3++;
            }
        }
        return sb5.toString();
    }

    private void r1(ArrayList<com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c> arrayList) {
        this.f303545l = true;
        this.f303546m = false;
        this.f303540g.clear();
        this.f303540g.addAll(arrayList);
    }

    private long s0(int i3, AdInsideVideoItem adInsideVideoItem) {
        long n3;
        if (i3 == 4) {
            n3 = yu2.b.i(adInsideVideoItem, this.U);
        } else {
            n3 = this.f303550q - yu2.b.n(this.f303540g, this.f303551r, this.U);
        }
        return Math.max(n3, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t1() {
        n.a(Z, "mraid resume");
        bv2.b m06 = m0();
        if (this.H && m06 != null) {
            m06.o();
        }
        this.H = false;
    }

    private int u0(AdInsideVideoItem adInsideVideoItem) {
        if (T0(adInsideVideoItem) && yu2.b.V(this.f303558y)) {
            return 1;
        }
        return 0;
    }

    private String x0(@Nullable QAdBaseVideoView qAdBaseVideoView) {
        if (qAdBaseVideoView != null && qAdBaseVideoView.F()) {
            return "1";
        }
        return "0";
    }

    private int y0(int i3) {
        CopyOnWriteArrayList<com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c> copyOnWriteArrayList = this.f303540g;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() != 0) {
            return (int) yu2.b.h((com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c) y.d(this.f303540g, i3), this.U);
        }
        return 0;
    }

    private kt3.j z0() {
        bv2.b m06 = m0();
        if (m06 != null) {
            return m06.c();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ArrayList<com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c> A0(ArrayList<AdTempletItem> arrayList) {
        ArrayList<com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c> arrayList2 = (ArrayList) H(arrayList);
        this.f303539f = (CopyOnWriteArrayList) G(arrayList);
        if (y.h(arrayList2)) {
            iu2.a aVar = new iu2.a(101, "no ad for this vid.");
            this.f303538e = aVar;
            V0(aVar);
            return null;
        }
        this.K = arrayList2.get(0).f303589a;
        E0(arrayList2);
        if (C1(arrayList2)) {
            n.e(Z, "shouldCloseAd");
            V0(this.f303538e);
            return null;
        }
        r1(arrayList2);
        W0((com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c[]) arrayList2.toArray(new com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c[arrayList2.size()]), this.f303558y);
        I1();
        return arrayList2;
    }

    public void B1(vu2.a aVar) {
        this.Q = aVar;
    }

    protected boolean C(ArrayList<com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c> arrayList) {
        if (y.h(arrayList)) {
            return false;
        }
        InsideVideoSkipAdInfo insideVideoSkipAdInfo = this.f303541h;
        if (insideVideoSkipAdInfo != null && insideVideoSkipAdInfo.enableMultiTrueViewAd) {
            return true;
        }
        AdInsideVideoItem adInsideVideoItem = arrayList.get(0).f303589a;
        if ((arrayList.size() != 1 && !yu2.b.H(adInsideVideoItem)) || adInsideVideoItem == null || !yu2.b.O(adInsideVideoItem)) {
            return false;
        }
        AdOrderItem adOrderItem = adInsideVideoItem.orderItem;
        if (adOrderItem != null && 5 == adOrderItem.adType) {
            return false;
        }
        return true;
    }

    public void C0(InsideVideoSkipAdInfo insideVideoSkipAdInfo) {
        this.f303541h = insideVideoSkipAdInfo;
    }

    protected void D() {
        QAdBaseVideoView n06 = n0();
        if (n06 != null) {
            n06.z();
        }
    }

    protected void D1() {
        n.a(Z, "show");
        this.W.sendEmptyMessage(1003);
    }

    protected void E() {
        if (this.f303559z) {
            QAdBaseVideoView n06 = n0();
            if (n06 != null && n06.L()) {
                boolean z16 = !yu2.b.M(this.f303553t);
                n.e(Z, "skipAd while isTrueView, isSkipAll=" + z16);
                F1(z16);
                return;
            }
            return;
        }
        if (yu2.b.R(this.f303534a)) {
            n.e(Z, "skipAd while isVip");
            F1(true);
            return;
        }
        n.e(Z, "skipAd while isNormal");
        bv2.b m06 = m0();
        if (m06 != null) {
            m06.h();
        }
    }

    protected void E0(ArrayList<com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c> arrayList) {
        long j3;
        this.f303559z = C(arrayList);
        this.U = true;
        Iterator<com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c> it = arrayList.iterator();
        while (it.hasNext()) {
            AdInsideVideoItem adInsideVideoItem = it.next().f303589a;
            if (yu2.b.Q(adInsideVideoItem, this.U)) {
                if (this.U) {
                    AdVideoItem adVideoItem = adInsideVideoItem.videoItem;
                    int i3 = adVideoItem.duration * 1000;
                    adVideoItem.duration = i3;
                    j3 = i3;
                } else {
                    j3 = adInsideVideoItem.posterItem.duration;
                }
                D0(j3, adInsideVideoItem);
            } else {
                it.remove();
            }
        }
        n.e(Z, "mAdTotalDuration=" + this.f303548o + ", isTureView=" + this.f303559z);
    }

    public void F() {
        QAdThreadManager.INSTANCE.execOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.b
            @Override // java.lang.Runnable
            public final void run() {
                QAdBaseVideoController.this.R0();
            }
        });
    }

    protected boolean F0() {
        boolean z16;
        int i3 = this.f303552s;
        int i16 = this.f303551r;
        if (i3 == i16) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f303552s = i16;
        return z16;
    }

    public void F1(boolean z16) {
        n.a(Z, "skipCurAd: skipAll: " + z16);
        bv2.b m06 = m0();
        if (m06 == null) {
            return;
        }
        CopyOnWriteArrayList<com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c> copyOnWriteArrayList = this.f303540g;
        if (copyOnWriteArrayList != null && this.f303551r == copyOnWriteArrayList.size() - 1) {
            this.D = true;
            this.E = m06.d();
        }
        m06.l(z16);
    }

    protected List<com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.b> G(ArrayList<AdTempletItem> arrayList) {
        return yu2.e.a(arrayList);
    }

    protected void G0() {
        n.a(Z, "hide");
        this.W.sendEmptyMessage(1004);
    }

    protected List<com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c> H(ArrayList<AdTempletItem> arrayList) {
        return yu2.e.b(arrayList, yu2.b.j(this.f303534a), this.N);
    }

    public void H0() {
        n.a(Z, "[AdFinished]");
        bv2.b m06 = m0();
        if (m06 != null) {
            m06.b(this.f303558y);
        }
        CopyOnWriteArrayList<com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c> copyOnWriteArrayList = this.f303540g;
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i3 = this.f303551r;
            if (size > i3) {
                W(i3);
                R(true);
                Y();
            }
        }
        J1();
    }

    public synchronized void H1(boolean z16) {
        if (!z16) {
            try {
                if (this.M) {
                    o1(y0(this.f303551r));
                    this.M = false;
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
        if (!z16 && !this.M) {
            n1(y0(this.f303551r));
        }
        this.M = false;
    }

    public void I0() {
        boolean z16;
        String str = Z;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("informAdPrepared ");
        if (this.f303542i == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        n.a(str, sb5.toString());
        this.f303547n = true;
    }

    public void J0(QAdBaseVideoView.SkipCause skipCause) {
        bv2.b m06 = m0();
        if (m06 != null) {
            m06.b(this.f303558y);
        }
        d0(skipCause);
        c0(skipCause);
        B();
    }

    protected void J1() {
        iu2.a aVar;
        n.a(Z, "stopAd");
        QAdBaseVideoView n06 = n0();
        if (n06 != null) {
            n06.T();
        }
        CountDownRunnable countDownRunnable = this.X;
        if (countDownRunnable != null) {
            try {
                countDownRunnable.stop();
            } finally {
                try {
                } finally {
                }
            }
        }
        if (this.f303545l && !this.f303546m && ((aVar = this.f303538e) == null || aVar.a() == 101)) {
            n.a(Z, "EC301");
            this.f303538e = new iu2.a(301, "ad not played.");
        }
        this.f303545l = false;
        this.f303546m = false;
        M();
    }

    protected void K0(AdInsideVideoItem adInsideVideoItem) {
        if (adInsideVideoItem != null && adInsideVideoItem.videoPoster == null) {
            return;
        }
        if (this.f303559z) {
            this.W.sendEmptyMessage(1107);
        }
        if (!this.I && yu2.b.K(adInsideVideoItem)) {
            this.W.sendEmptyMessage(1012);
        }
    }

    public void K1(Map<String, Object> map) {
        n.a(Z, "triggerInstantUIStrategy: " + map);
        if (y.i(map)) {
            return;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry != null) {
                String key = entry.getKey();
                if (TextUtils.isEmpty(key)) {
                    continue;
                } else {
                    Object value = entry.getValue();
                    if (!(value instanceof Boolean)) {
                        return;
                    }
                    if (key.equals("MODE_MINI_VIEW") || key.equals("MODE_MINI_VIEW_NEW")) {
                        B0(key, ((Boolean) value).booleanValue());
                    }
                }
            }
        }
    }

    protected void L0(int i3) {
        if (y.h(this.f303540g)) {
            return;
        }
        int size = this.f303540g.size();
        if (i3 >= 0 && i3 < size) {
            N1(i3);
            QAdBaseVideoView n06 = n0();
            if (n06 != null) {
                n06.setCurrentAdIndex(this.f303551r);
                n06.setAdItem(this.f303553t);
                O0(n06);
            }
            if (i3 > 0) {
                u1(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.QAdBaseVideoController.10
                    @Override // java.lang.Runnable
                    public void run() {
                        QAdBaseVideoView n07 = QAdBaseVideoController.this.n0();
                        if (n07 != null) {
                            n07.x();
                        }
                    }
                });
                O(i3);
            }
            K0(this.f303553t);
        }
    }

    protected void M() {
        L1();
        n.a(Z, "doDestroy");
        QAdBaseVideoView n06 = n0();
        if (n06 != null && n06.u() == AdConstants$ViewState.DESTROYED) {
            n.a(Z, "mViewState is destroyed");
            return;
        }
        B();
        b0();
        N();
        if (n06 != null) {
            n06.n();
        }
        u1(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.QAdBaseVideoController.15
            @Override // java.lang.Runnable
            public void run() {
                if (QAdBaseVideoController.this.f303535b != null) {
                    QAdBaseVideoController.this.f303535b = null;
                }
            }
        });
        this.W.removeCallbacksAndMessages(null);
    }

    public void M1() {
        n.e("[QAdTask]", "updateAdVideoCacheFiles");
        QAdThreadManager.INSTANCE.execTask(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.QAdBaseVideoController.9
            @Override // java.lang.Runnable
            public void run() {
                if (yu2.d.f()) {
                    ku2.b.a(yu2.d.b(), yu2.d.c());
                }
            }
        });
    }

    public void N0(AdInsideVideoRequest adInsideVideoRequest) {
        this.f303534a = adInsideVideoRequest;
        s1();
        D();
    }

    protected void N1(int i3) {
        AdOrderItem adOrderItem;
        AdInSideVideoExposureItem adInSideVideoExposureItem;
        AdOrderItem adOrderItem2;
        AdInSideVideoExposureItem adInSideVideoExposureItem2;
        this.f303551r = i3;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c cVar = (com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c) y.d(this.f303540g, i3);
        if (cVar == null) {
            return;
        }
        this.f303553t = cVar.f303589a;
        this.C = (int) yu2.b.i(this.f303553t, this.U);
        AdInsideVideoItem o06 = o0();
        synchronized (this.f303554u) {
            this.f303554u.clear();
            if (o06 != null && (adOrderItem2 = o06.orderItem) != null && (adInSideVideoExposureItem2 = adOrderItem2.exposureItem) != null && !y.h(adInSideVideoExposureItem2.originExposureReportList)) {
                this.f303554u.addAll(o06.orderItem.exposureItem.originExposureReportList);
            }
        }
        synchronized (this.f303555v) {
            this.f303555v.clear();
            if (o06 != null && (adOrderItem = o06.orderItem) != null && (adInSideVideoExposureItem = adOrderItem.exposureItem) != null && !y.h(adInSideVideoExposureItem.exposureReportList)) {
                this.f303555v.addAll(o06.orderItem.exposureItem.exposureReportList);
            }
        }
    }

    public void O1(long j3, long j16) {
        if (this.f303542i == null) {
            return;
        }
        this.f303542i.f0(j3, j16);
    }

    public void P1(ju2.a aVar) {
        this.J = aVar;
    }

    public boolean Q0() {
        return yu2.b.S(this.f303553t);
    }

    public void Q1(kt3.j jVar) {
        vu2.a aVar = this.Q;
        if (aVar != null) {
            aVar.h(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void R(boolean z16) {
        if (z16) {
            g1();
        } else {
            h1();
            i1();
        }
    }

    protected void S(int i3, boolean z16) {
        X(i3, z16);
        Q(i3, z16);
    }

    public void S0(AdInsideVideoRequest adInsideVideoRequest) {
        N0(adInsideVideoRequest);
        j0(adInsideVideoRequest);
    }

    protected boolean T0(AdInsideVideoItem adInsideVideoItem) {
        AdInSideExtraReportItem adInSideExtraReportItem;
        if (adInsideVideoItem != null && (adInSideExtraReportItem = adInsideVideoItem.extraReportItem) != null && !adInSideExtraReportItem.needOperationReport) {
            return false;
        }
        return true;
    }

    public void V0(iu2.a aVar) {
        bv2.b m06 = m0();
        if (m06 != null) {
            m06.k(aVar);
        }
        iu2.a aVar2 = this.f303538e;
        if (aVar2 == null || aVar2.a() != 101) {
            M();
        }
    }

    protected void W(int i3) {
        if (!this.D) {
            S(yu2.b.m(this.f303540g, i3, this.U), false);
        }
    }

    protected void W0(com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c[] cVarArr, int i3) {
        bv2.b m06 = m0();
        if (m06 != null) {
            m06.p(cVarArr, i3);
        }
    }

    public /* synthetic */ void X0(Object obj) {
        uu2.a.a(this, obj);
    }

    protected void Y() {
        if (this.D) {
            l1(this.E);
        } else {
            k1(y0(this.f303551r), this.f303551r);
        }
    }

    public void Y0() {
        n.e(Z, "[CLICK] PrerollView onMultiTrueViewRightTipClick");
        bv2.b m06 = m0();
        if (m06 != null) {
            m06.h();
        }
        e0();
    }

    public void Z0(int i3) {
        n.a(Z, "onPlayerError --> errMsg = " + i3);
    }

    @Override // xu2.a
    public void a() {
        n.e(Z, "[CLICK] PrerollView onEnterVipPageClick");
        bv2.b m06 = m0();
        if (m06 != null) {
            m06.a();
        }
    }

    public /* synthetic */ void a1(int i3, int i16) {
        uu2.a.b(this, i3, i16);
    }

    @Override // xu2.a
    public void b() {
        n.e(Z, "[CLICK] PrerollView onVipTipClick");
        Y0();
    }

    @Override // xu2.a
    public void c() {
        n.e(Z, "[CLICK] PrerollView onMultiTrueViewTipClick");
        QAdBaseVideoView n06 = n0();
        if (n06 != null && n06.L()) {
            e0();
            n.e(Z, "skipAd while isTrueView");
            F1(true);
        }
    }

    @Override // xu2.a
    public void d(QAdStandardClickReportInfo.ClickExtraInfo clickExtraInfo, int i3) {
        AdAction adAction;
        n.g(Z, "onDetailClick");
        if (yu2.b.C(this.f303553t) && i3 == 1021 && y.k(this.f303535b) && this.f303542i != null) {
            this.f303542i.S(clickExtraInfo);
            return;
        }
        if (this.f303553t != null && this.f303553t.videoPoster != null && i3 == 1021) {
            adAction = this.f303553t.videoPoster.buttonAction;
        } else {
            adAction = null;
        }
        AdAction adAction2 = adAction;
        int l3 = yu2.b.l(this.f303553t);
        i0(qu2.b.a(i3), new QAdVrReportParams().i().e(i3).d(l0()).i());
        P(this.f303553t, clickExtraInfo, i3, adAction2, l3);
    }

    @Override // xu2.a
    public void e() {
        n.a(Z, "[CLICK] PrerollView onSkipTipClick");
        E();
        i0("close", new QAdVrReportParams().i().d(l0()).i());
    }

    public synchronized void e1() {
        if (!this.M) {
            m1(y0(this.f303551r));
            this.M = true;
        }
    }

    @Override // xu2.a
    public void f() {
        n.a(Z, "[CLICK] PrerollView onWarnerClick");
        bv2.b m06 = m0();
        if (m06 != null) {
            m06.g();
        }
    }

    public void f0(iu2.a aVar, tu2.a aVar2, tu2.b bVar, String str, String str2, String str3, String str4) {
        if (aVar != null && aVar.a() == 230) {
            R(true);
        } else {
            su2.b.r(aVar, aVar2, bVar, str, str2, str3, str4, q0());
        }
    }

    public void f1() {
        u1(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.QAdBaseVideoController.14
            @Override // java.lang.Runnable
            public void run() {
                QAdBaseVideoView n06 = QAdBaseVideoController.this.n0();
                if (n06 != null) {
                    n06.setAdUIListener(null);
                    QAdBaseVideoController.this.f303542i = null;
                    QAdBaseVideoController.this.f303535b = null;
                }
            }
        });
    }

    protected void k0() {
        n.a(Z, "enableMiniMode");
        this.W.sendEmptyMessage(1109);
    }

    public int l0() {
        int a16 = yu2.a.a(this.f303535b, this.f303553t, false);
        n.e(Z, "getAdLayer:" + a16);
        return a16;
    }

    public bv2.b m0() {
        return this.f303537d;
    }

    protected QAdBaseVideoView n0() {
        return this.f303542i;
    }

    protected AdInsideVideoItem o0() {
        return this.f303553t;
    }

    protected void q1(int i3) {
        int i16 = i3 - 1;
        k1(y0(i16), i16);
    }

    protected void s1() {
        n.e(Z, "resetLoadAdParams");
        this.f303548o = 0L;
        this.f303550q = 0;
        this.f303540g.clear();
        this.f303539f.clear();
        this.f303545l = false;
        this.f303546m = false;
        this.f303549p = 0;
        this.I = false;
        this.f303559z = false;
        this.N = false;
        synchronized (this.f303555v) {
            this.f303555v.clear();
        }
        synchronized (this.f303554u) {
            this.f303554u.clear();
        }
    }

    public String t0() {
        return this.f303536c;
    }

    protected void u1(Runnable runnable) {
        this.W.post(runnable);
    }

    public int v0() {
        return yu2.b.s(this.f303553t);
    }

    public void v1(bv2.b bVar) {
        this.f303537d = bVar;
    }

    protected VideoReportInfo w0(int i3) {
        QAdBaseVideoView n06 = n0();
        if (i3 == 0 || n06 == null || this.f303553t == null) {
            return null;
        }
        String a16 = qu2.b.a(i3);
        Map<String, View> t16 = n06.t();
        if (y.i(t16)) {
            return null;
        }
        return vv2.a.a(t16.get(a16), new QAdVrReportParams().i().h(qu2.b.c(this.f303553t.orderItem)).f(QAdVrReportParams.ParamKey.AD_SHOW_TYPE, Integer.valueOf(this.T)).i());
    }

    public void x1(boolean z16) {
        this.L = z16;
    }

    public void y(final ViewGroup viewGroup) {
        n.a(Z, "On attach to play view!");
        u1(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.QAdBaseVideoController.11
            @Override // java.lang.Runnable
            public void run() {
                n.a(QAdBaseVideoController.Z, "On attach to play view, runOnUiThread begin");
                QAdBaseVideoView n06 = QAdBaseVideoController.this.n0();
                if (n06 == null) {
                    return;
                }
                if (n06.getParent() != null) {
                    ((ViewGroup) n06.getParent()).removeView(n06);
                }
                n06.setVisibility(0);
                n06.l(viewGroup);
                QAdBaseVideoController.this.f303544k = true;
                CountDownLatch countDownLatch = QAdBaseVideoController.this.f303543j;
                if (countDownLatch != null && countDownLatch.getCount() == 1) {
                    n.a(QAdBaseVideoController.Z, "attachTo --> view has attach to player!");
                    countDownLatch.countDown();
                }
                QAdBaseVideoController.this.E1(n06);
            }
        });
        A1(viewGroup);
    }

    protected void y1(int i3) {
        QAdBaseVideoView n06 = n0();
        if (n06 != null) {
            n06.setPicInPicState(i3);
        }
    }

    public void z(final ViewGroup viewGroup) {
        u1(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.QAdBaseVideoController.12
            @Override // java.lang.Runnable
            public void run() {
                try {
                    QAdBaseVideoView n06 = QAdBaseVideoController.this.n0();
                    if (n06 != null) {
                        if (viewGroup != null && n06.getParent() == null) {
                            n06.setVisibility(0);
                            n06.l(viewGroup);
                            n.e(QAdBaseVideoController.Z, "call-ad, attachView");
                            ViewParent viewParent = viewGroup;
                            if (viewParent instanceof kt3.f) {
                                ((kt3.f) viewParent).a(n06);
                            }
                            QAdBaseVideoController.this.E1(n06);
                            if (QAdBaseVideoController.this.f303543j != null && QAdBaseVideoController.this.f303543j.getCount() == 1) {
                                n.e(QAdBaseVideoController.Z, "attachViewIfNot --> view has attach to player!");
                                QAdBaseVideoController.this.f303543j.countDown();
                            }
                            QAdBaseVideoController.this.f303544k = true;
                            return;
                        }
                        n.e(QAdBaseVideoController.Z, "Dispview has attach");
                    }
                } catch (Exception e16) {
                    n.c(QAdBaseVideoController.Z, e16);
                }
            }
        });
        A1(viewGroup);
    }

    public void z1(String str) {
        this.f303536c = str;
    }

    protected void B() {
    }

    protected void U() {
    }

    protected void b1() {
    }

    protected void c1() {
    }

    protected void w1() {
    }

    private void O0(QAdBaseVideoView qAdBaseVideoView) {
    }

    protected void j0(AdInsideVideoRequest adInsideVideoRequest) {
    }

    @Override // xu2.a
    public void onWindowVisibilityChanged(int i3) {
    }

    private void x(wv2.a aVar, AdInsideVideoItem adInsideVideoItem) {
    }
}
