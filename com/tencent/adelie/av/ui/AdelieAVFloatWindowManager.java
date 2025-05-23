package com.tencent.adelie.av.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.WindowManager;
import com.tencent.adelie.av.qav.AdelieAVController;
import com.tencent.av.smallscreen.SmallScreenRelativeLayout;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.av.utils.e;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qav.QavDef$MultiUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes37.dex */
public class AdelieAVFloatWindowManager implements SmallScreenRelativeLayout.a {
    private static AdelieAVFloatWindowManager M;
    private OnOpChangedRunnable C;
    private Runnable D;
    private AdelieAVTimerController E;
    private AdelieAVChatStatusManager F;
    private sp.a G;
    private String I;
    private String J;

    /* renamed from: d, reason: collision with root package name */
    private d f61448d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<Context> f61449e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f61450f;

    /* renamed from: i, reason: collision with root package name */
    private boolean f61452i;

    /* renamed from: h, reason: collision with root package name */
    private boolean f61451h = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f61453m = false;
    private boolean H = false;
    private BroadcastReceiver K = new a();
    private qp.a L = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class OnOpChangedRunnable implements Runnable {
        OnOpChangedRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            synchronized (AdelieAVFloatWindowManager.this) {
                boolean z17 = true;
                if (AdelieAVFloatWindowManager.this.f61449e == null) {
                    QLog.d("AdelieAVFloatWindowManager", 1, "[OnOpChangedRunnable] mContext is null");
                    return;
                }
                boolean r16 = SmallScreenUtils.r((Context) AdelieAVFloatWindowManager.this.f61449e.get());
                if (r16 != AdelieAVFloatWindowManager.this.f61450f) {
                    AdelieAVFloatWindowManager.this.f61450f = r16;
                    QLog.d("AdelieAVFloatWindowManager", 1, "OnOpChangedRunnable mIsOpEnable change to " + AdelieAVFloatWindowManager.this.f61450f);
                    z16 = true;
                } else {
                    z16 = false;
                }
                boolean u16 = SmallScreenUtils.u((Context) AdelieAVFloatWindowManager.this.f61449e.get());
                if (u16 != AdelieAVFloatWindowManager.this.f61451h) {
                    AdelieAVFloatWindowManager.this.f61451h = u16;
                    QLog.d("AdelieAVFloatWindowManager", 1, "OnOpChangedRunnable mIsLock change to " + AdelieAVFloatWindowManager.this.f61451h);
                    z16 = true;
                }
                boolean p16 = SmallScreenUtils.p((Context) AdelieAVFloatWindowManager.this.f61449e.get());
                QLog.d("AdelieAVFloatWindowManager", 1, "OnOpChangedRunnable isAppOnForeground=" + p16 + " isBackgroundPause=" + BaseApplicationImpl.getApplication().getRuntime().isBackgroundPause);
                if (p16 != AdelieAVFloatWindowManager.this.f61452i) {
                    long d16 = e.d();
                    if (QLog.isDevelopLevel()) {
                        QLog.w("AdelieAVFloatWindowManager", 1, "OnOpChangedRunnable, AppOnForegroundChanged, seq[" + d16 + "]");
                    }
                    AdelieAVFloatWindowManager.this.f61452i = p16;
                }
                boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
                if (AdelieAVFloatWindowManager.this.f61453m != isNowThemeIsNight) {
                    long d17 = e.d();
                    if (QLog.isDevelopLevel()) {
                        QLog.w("AdelieAVFloatWindowManager", 1, "OnOpChangedRunnable, night mode changed, isNightMode " + isNowThemeIsNight + " and seq[" + d17 + "]");
                    }
                    AdelieAVFloatWindowManager.this.f61453m = isNowThemeIsNight;
                } else {
                    z17 = z16;
                }
                if (z17) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.adelie.av.ui.AdelieAVFloatWindowManager.OnOpChangedRunnable.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AdelieAVFloatWindowManager.this.F();
                        }
                    });
                }
                AdelieAVFloatWindowManager.this.D = ThreadManagerV2.executeDelay(this, 16, null, false, 1000L);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("com.tencent.adelie.av.exit")) {
                AdelieAVFloatWindowManager.this.w(true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class b extends qp.a {
        b() {
        }

        @Override // qp.a
        public void a(long j3, int i3) {
            super.a(j3, i3);
            if (AdelieAVController.J()) {
                int l3 = AdelieAVChatStatusManager.l(i3);
                up.a E = AdelieAVController.D().E();
                if (E == null) {
                    return;
                }
                QLog.d("AdelieAVFloatWindowManager", 1, "onAdelieRobotStatusChange status=" + i3 + " str=" + l3 + " groupId=" + j3 + " str=" + AdelieAVChatStatusManager.n(i3) + " mChatStatus" + E.f439402u);
                int i16 = E.f439402u;
                if (i16 == -1) {
                    if (i3 == 11 || i3 == 33) {
                        if (!E.f439393l) {
                            AdelieAVController.D().y(true);
                        }
                        if (i3 == 11) {
                            AdelieAVFloatWindowManager.this.F.t(0);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (l3 == 1 && i16 == 3) {
                    QLog.d("AdelieAVFloatWindowManager", 1, "onAdelieRobotStatusChange illegal");
                } else if (l3 == 4) {
                    AdelieAVFloatWindowManager.this.w(false);
                } else {
                    AdelieAVFloatWindowManager.this.F.t(l3);
                }
            }
        }

        @Override // qp.a
        public void b(int i3) {
            super.b(i3);
            QLog.d("AdelieAVFloatWindowManager", 1, "onApnChanged netType=" + i3 + " curChatStatus=" + AdelieAVFloatWindowManager.this.y());
            if (i3 != 0) {
                if (AdelieAVFloatWindowManager.this.y() == 4) {
                    AdelieAVFloatWindowManager.this.F.t(0);
                    return;
                }
                return;
            }
            AdelieAVFloatWindowManager.this.F.t(4);
        }

        @Override // qp.a
        public void d(int i3) {
            QLog.d("AdelieAVFloatWindowManager", 1, "onEnterRoomError errorType=" + i3);
            super.d(i3);
            QQToast.makeText((Context) AdelieAVFloatWindowManager.this.f61449e.get(), "\u8fdb\u623f\u5931\u8d25\uff1a" + i3, 1).show();
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            VideoMsgTools.l(qQAppInterface, 1043, 45, true, AdelieAVFloatWindowManager.this.A(), qQAppInterface.getCurrentAccountUin(), true, null, true, new Object[0]);
            AdelieAVFloatWindowManager.this.w(false);
        }

        @Override // qp.a
        public void e() {
            super.e();
            up.a E = AdelieAVController.D().E();
            QLog.d("AdelieAVFloatWindowManager", 1, "onEnterRoomSuccess session=" + E);
            if (E != null) {
                E.f439404w = SystemClock.elapsedRealtime();
            }
            if (AdelieAVFloatWindowManager.this.E == null) {
                AdelieAVFloatWindowManager adelieAVFloatWindowManager = AdelieAVFloatWindowManager.this;
                adelieAVFloatWindowManager.E = new AdelieAVTimerController(adelieAVFloatWindowManager.f61448d.i());
            }
            AdelieAVFloatWindowManager.this.E.e();
            if (AdelieAVFloatWindowManager.this.F != null) {
                AdelieAVFloatWindowManager.this.F.q();
            }
        }

        @Override // qp.a
        public void l(QavDef$MultiUserInfo qavDef$MultiUserInfo) {
            QLog.d("AdelieAVFloatWindowManager", 1, "onUserExit userInfo=" + qavDef$MultiUserInfo);
            super.l(qavDef$MultiUserInfo);
            AdelieAVFloatWindowManager.this.w(false);
        }

        @Override // qp.a
        public void m(QavDef$MultiUserInfo qavDef$MultiUserInfo, boolean z16, int i3) {
            super.m(qavDef$MultiUserInfo, z16, i3);
            if (AdelieAVFloatWindowManager.this.F != null) {
                AdelieAVFloatWindowManager.this.F.r(qavDef$MultiUserInfo, z16, i3);
            }
        }
    }

    AdelieAVFloatWindowManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String A() {
        up.a E;
        if (!AdelieAVController.J() || (E = AdelieAVController.D().E()) == null) {
            return "";
        }
        return String.valueOf(E.f439387f);
    }

    private void G(boolean z16) {
        QLog.d("AdelieAVFloatWindowManager", 1, "showOrHide show=" + z16);
        d dVar = this.f61448d;
        if (dVar == null) {
            return;
        }
        dVar.e(z16, 7);
        this.f61448d.f(null);
    }

    private void H(int i3) {
        if (AdelieAVController.J()) {
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            up.a E = AdelieAVController.D().E();
            qQAppInterface.getAVNotifyCenter().V0(e.d(), i3);
            if (E == null || E.f439387f <= 0) {
                return;
            }
            qQAppInterface.getAVNotifyCenter().q0(String.valueOf(E.f439387f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z16) {
        String A = A();
        AdelieAVControlUI.H(A, z16);
        AdelieAVController.D().B();
        ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.adelie.av.ui.AdelieAVFloatWindowManager.4
            @Override // java.lang.Runnable
            public void run() {
                AdelieAVFloatWindowManager.this.D();
            }
        });
        AdelieAVController.x();
        AdelieAvatarHelper.p().g(A);
    }

    private void x() {
        up.a E = AdelieAVController.D().E();
        Intent intent = new Intent(this.f61449e.get(), (Class<?>) AdelieAVActivity.class);
        intent.addFlags(268435456);
        if (E != null) {
            intent.putExtra("uin", E.f439387f + "");
            intent.putExtra("name", E.f439390i);
            intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, E.f439382a);
        } else {
            intent.putExtra("uin", this.J);
            intent.putExtra("name", this.I);
            intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 1);
            QLog.d("AdelieAVFloatWindowManager", 1, "setSessionInfo peerName=" + this.I + " relationId=" + this.J);
        }
        intent.putExtra("from", "5");
        this.f61449e.get().startActivity(intent);
        D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int y() {
        up.a B = B();
        if (B != null) {
            return B.f439402u;
        }
        return -1;
    }

    public static AdelieAVFloatWindowManager z() {
        if (M == null) {
            synchronized (AdelieAVFloatWindowManager.class) {
                if (M == null) {
                    M = new AdelieAVFloatWindowManager();
                }
            }
        }
        return M;
    }

    public up.a B() {
        if (AdelieAVController.J()) {
            return AdelieAVController.D().E();
        }
        return null;
    }

    public void C(Context context) {
        WeakReference<Context> weakReference = new WeakReference<>(context);
        this.f61449e = weakReference;
        this.f61450f = SmallScreenUtils.r(weakReference.get());
        this.f61451h = SmallScreenUtils.u(this.f61449e.get());
        this.f61452i = SmallScreenUtils.p(this.f61449e.get());
        this.f61453m = QQTheme.isNowThemeIsNight();
        sp.a aVar = new sp.a((AppInterface) BaseApplicationImpl.getApplication().getRuntime());
        this.G = aVar;
        aVar.c();
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        d dVar = this.f61448d;
        if (dVar != null) {
            dVar.c();
            this.f61448d = null;
        }
        if (layoutInflater != null) {
            d dVar2 = new d(context);
            this.f61448d = dVar2;
            dVar2.a(context, layoutInflater, this);
            this.f61448d.j(7);
            up.a E = AdelieAVController.D().E();
            int e16 = E != null ? E.e() : 0;
            if (e16 == 2) {
                if (this.E == null) {
                    this.E = new AdelieAVTimerController(this.f61448d.i());
                }
                this.E.e();
            } else if (e16 == 1 || e16 == 0) {
                this.f61448d.k(R.string.dmu);
            }
        }
        OnOpChangedRunnable onOpChangedRunnable = new OnOpChangedRunnable();
        this.C = onOpChangedRunnable;
        this.D = ThreadManagerV2.executeDelay(onOpChangedRunnable, 16, null, false, 1000L);
        if (!SmallScreenUtils.r(this.f61449e.get())) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.adelie.av.ui.AdelieAVFloatWindowManager.3
                @Override // java.lang.Runnable
                public void run() {
                    SmallScreenUtils.D((Context) AdelieAVFloatWindowManager.this.f61449e.get(), true, BaseApplicationImpl.getApplication().getRuntime().getCurrentAccountUin(), false);
                }
            }, 16, null, false);
        }
        AdelieAVController.D().v(this.L);
        this.F = new AdelieAVChatStatusManager(null, true, null, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.adelie.av.exit");
        try {
            this.H = true;
            context.registerReceiver(this.K, intentFilter);
        } catch (Throwable th5) {
            th5.printStackTrace();
            this.H = false;
        }
    }

    public void E(String str, String str2) {
        this.I = str;
        this.J = str2;
    }

    public void F() {
        boolean r16 = SmallScreenUtils.r(this.f61449e.get());
        boolean z16 = SmallScreenUtils.x() && r16 && !this.f61451h;
        QLog.d("AdelieAVFloatWindowManager", 1, "showHideToast hasFloatWindowPermission=" + r16 + " mIsLock=" + this.f61451h + " mIsAppOnForeground=" + this.f61452i + " isAudioToastCanShow=" + z16);
        H(z16 ? 3 : 2);
        G(z16);
    }

    @Override // com.tencent.av.smallscreen.SmallScreenRelativeLayout.a
    public boolean b(SmallScreenRelativeLayout smallScreenRelativeLayout) {
        x();
        return true;
    }

    @Override // com.tencent.av.smallscreen.SmallScreenRelativeLayout.a
    public void e(SmallScreenRelativeLayout smallScreenRelativeLayout, int i3, int i16, int i17, int i18) {
        WindowManager.LayoutParams h16 = this.f61448d.h();
        if (h16 == null) {
            return;
        }
        h16.x = i3;
        h16.y = i16;
        h16.width = i17 - i3;
        h16.height = i18 - i16;
        this.f61448d.l();
    }

    @Override // com.tencent.av.smallscreen.SmallScreenRelativeLayout.a
    public int i(SmallScreenRelativeLayout smallScreenRelativeLayout) {
        if (this.f61448d.h() == null) {
            return 0;
        }
        return this.f61448d.h().x;
    }

    @Override // com.tencent.av.smallscreen.SmallScreenRelativeLayout.a
    public int o(SmallScreenRelativeLayout smallScreenRelativeLayout) {
        if (this.f61448d.h() == null) {
            return 0;
        }
        return this.f61448d.h().y;
    }

    public void D() {
        G(false);
        H(0);
        d dVar = this.f61448d;
        if (dVar != null) {
            dVar.c();
            this.f61448d = null;
        }
        AdelieAVTimerController adelieAVTimerController = this.E;
        if (adelieAVTimerController != null) {
            adelieAVTimerController.f();
            this.E = null;
        }
        Runnable runnable = this.D;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 16);
            this.D = null;
        }
        this.C = null;
        try {
            if (this.H) {
                this.f61449e.get().unregisterReceiver(this.K);
                this.H = false;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        synchronized (this) {
            this.f61449e = null;
        }
        if (AdelieAVController.J()) {
            AdelieAVController.D().N(this.L);
        }
        this.L = null;
        AdelieAVChatStatusManager adelieAVChatStatusManager = this.F;
        if (adelieAVChatStatusManager != null) {
            adelieAVChatStatusManager.s();
            this.F = null;
        }
        M = null;
        sp.a aVar = this.G;
        if (aVar != null) {
            aVar.d();
            this.G = null;
        }
        QLog.d("AdelieAVFloatWindowManager", 1, "release.");
    }

    @Override // com.tencent.av.smallscreen.SmallScreenRelativeLayout.a
    public void m(SmallScreenRelativeLayout smallScreenRelativeLayout) {
    }
}
