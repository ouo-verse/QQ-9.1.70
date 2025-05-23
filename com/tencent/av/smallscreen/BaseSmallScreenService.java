package com.tencent.av.smallscreen;

import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.view.LayoutInflater;
import android.view.WindowManager;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.broadcast.ThemeBroadcastReceiver;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.smallscreen.SmallScreenRelativeLayout;
import com.tencent.av.ui.ScreenRecordHelper;
import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.av.utils.ad;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qav.monitor.PhoneStatusAudioModeMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import mqq.app.AppService;

/* compiled from: P */
/* loaded from: classes32.dex */
public class BaseSmallScreenService extends AppService implements SmallScreenRelativeLayout.a {
    Handler L;

    /* renamed from: d, reason: collision with root package name */
    boolean f74471d = true;

    /* renamed from: e, reason: collision with root package name */
    boolean f74472e = false;

    /* renamed from: f, reason: collision with root package name */
    boolean f74473f = false;

    /* renamed from: h, reason: collision with root package name */
    boolean f74474h = false;

    /* renamed from: i, reason: collision with root package name */
    boolean f74475i = true;

    /* renamed from: m, reason: collision with root package name */
    boolean f74476m = false;
    boolean C = false;
    boolean D = false;
    boolean E = false;
    int F = 0;
    int G = 7;
    int H = 0;
    final e[] I = new e[3];
    Runnable J = null;
    Runnable K = null;
    PhoneStateListener M = new a();
    private final PhoneStatusMonitor.a N = new PhoneStatusMonitor.a() { // from class: com.tencent.av.smallscreen.a
        @Override // com.tencent.av.utils.PhoneStatusMonitor.a
        public final void a(boolean z16) {
            BaseSmallScreenService.this.w(z16);
        }
    };
    ThemeBroadcastReceiver P = new ThemeBroadcastReceiver(new b());

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class InitRunnable implements Runnable {
        InitRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSmallScreenService.this.v();
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class OnOpChangedRunnable implements Runnable {
        OnOpChangedRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            if (BaseSmallScreenService.this.f74474h) {
                return;
            }
            boolean z17 = false;
            boolean z18 = (r.h0() == null || r.h0().x0() == null || !r.h0().x0().m()) ? false : true;
            if (SmallScreenUtils.r(((AppInterface) ((AppService) BaseSmallScreenService.this).app).getApp()) && !z18) {
                z17 = true;
            }
            BaseSmallScreenService baseSmallScreenService = BaseSmallScreenService.this;
            if (z17 != baseSmallScreenService.f74475i) {
                baseSmallScreenService.f74475i = z17;
                baseSmallScreenService.F();
            }
            boolean o16 = SmallScreenUtils.o();
            BaseSmallScreenService baseSmallScreenService2 = BaseSmallScreenService.this;
            if (o16 != baseSmallScreenService2.f74472e) {
                baseSmallScreenService2.f74472e = o16;
                baseSmallScreenService2.D();
            }
            boolean u16 = SmallScreenUtils.u(((AppInterface) ((AppService) BaseSmallScreenService.this).app).getApp());
            BaseSmallScreenService baseSmallScreenService3 = BaseSmallScreenService.this;
            if (u16 != baseSmallScreenService3.f74473f) {
                baseSmallScreenService3.f74473f = u16;
                baseSmallScreenService3.E();
            }
            boolean p16 = SmallScreenUtils.p(((AppInterface) ((AppService) BaseSmallScreenService.this).app).getApp());
            if (p16 != BaseSmallScreenService.this.f74476m) {
                long d16 = com.tencent.av.utils.e.d();
                if (QLog.isDevelopLevel()) {
                    QLog.w("BaseSmallScreenService", 1, "OnOpChangedRunnable, AppOnForegroundChanged, seq[" + d16 + "]");
                }
                BaseSmallScreenService baseSmallScreenService4 = BaseSmallScreenService.this;
                baseSmallScreenService4.f74476m = p16;
                baseSmallScreenService4.I(d16);
            }
            boolean C = BaseSmallScreenService.this.C();
            if (BaseSmallScreenService.this.C != C) {
                long d17 = com.tencent.av.utils.e.d();
                if (QLog.isDevelopLevel()) {
                    QLog.w("BaseSmallScreenService", 1, "OnOpChangedRunnable, screen orientation changed, isHorizontalScreen " + C + " and seq[" + d17 + "]");
                }
                BaseSmallScreenService baseSmallScreenService5 = BaseSmallScreenService.this;
                baseSmallScreenService5.C = C;
                baseSmallScreenService5.I(d17);
            }
            boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
            if (BaseSmallScreenService.this.E != isNowThemeIsNight) {
                long d18 = com.tencent.av.utils.e.d();
                if (QLog.isDevelopLevel()) {
                    QLog.w("BaseSmallScreenService", 1, "OnOpChangedRunnable, night mode changed, isNightMode " + isNowThemeIsNight + " and seq[" + d18 + "]");
                }
                BaseSmallScreenService baseSmallScreenService6 = BaseSmallScreenService.this;
                baseSmallScreenService6.E = isNowThemeIsNight;
                baseSmallScreenService6.I(d18);
            }
            SessionInfo f16 = n.e().f();
            if (f16 != null && BaseSmallScreenService.this.D != (z16 = f16.H2)) {
                long d19 = com.tencent.av.utils.e.d();
                if (QLog.isDevelopLevel()) {
                    QLog.w("BaseSmallScreenService", 1, "OnOpChangedRunnable, small home state changed, isInZplanHome " + z16 + " and seq[" + d19 + "]");
                }
                BaseSmallScreenService baseSmallScreenService7 = BaseSmallScreenService.this;
                baseSmallScreenService7.D = z16;
                baseSmallScreenService7.I(d19);
            }
            BaseSmallScreenService.this.y().postDelayed(this, 1000L);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends PhoneStateListener {
        a() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i3, String str) {
            super.onCallStateChanged(i3, str);
            BaseSmallScreenService.this.x(i3, str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements ThemeBroadcastReceiver.b {
        b() {
        }

        @Override // com.tencent.av.broadcast.ThemeBroadcastReceiver.b
        public void onPostThemeChanged() {
            if (QLog.isColorLevel()) {
                QLog.i("BaseSmallScreenService", 2, "onPostThemeChanged");
            }
            QQTheme.getCurrentThemeId(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C() {
        int rotation = ((WindowManager) getApplicationContext().getSystemService("window")).getDefaultDisplay().getRotation();
        return rotation == 1 || rotation == 3;
    }

    private void G() {
        PhoneStatusAudioModeMonitor u06;
        if (r.h0() == null || (u06 = r.h0().u0()) == null) {
            return;
        }
        u06.i(this.N);
    }

    private void H(final Context context, final int i3) {
        try {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.smallscreen.BaseSmallScreenService.3
                @Override // java.lang.Runnable
                public void run() {
                    ad.r(context, BaseSmallScreenService.this.M, i3);
                }
            }, 16, null, false);
        } catch (Exception e16) {
            QLog.d("BaseSmallScreenService", 1, "setPhoneStateListener e = " + e16);
        }
    }

    private void J() {
        PhoneStatusAudioModeMonitor u06;
        if (r.h0() == null || (u06 = r.h0().u0()) == null) {
            return;
        }
        u06.n(this.N);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i A(int i3) {
        e eVar = this.I[i3];
        if (eVar != null) {
            return eVar.f74603c;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SmallScreenRelativeLayout B(int i3) {
        e eVar = this.I[i3];
        if (eVar != null) {
            return eVar.f74602b;
        }
        return null;
    }

    void D() {
        if (QLog.isColorLevel()) {
            QLog.d("BaseSmallScreenService", 2, "onHasSmartBarChanged mHasSmartBar = " + this.f74472e);
        }
        SmallScreenRelativeLayout B = B(1);
        if (B != null) {
            B.k();
        }
    }

    void E() {
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.w("BaseSmallScreenService", 1, "onIsLockChanged, mIsLock[" + this.f74473f + "], seq[" + d16 + "]");
        }
        I(d16);
    }

    @Override // com.tencent.av.smallscreen.SmallScreenRelativeLayout.a
    public boolean b(SmallScreenRelativeLayout smallScreenRelativeLayout) {
        return true;
    }

    @Override // com.tencent.av.smallscreen.SmallScreenRelativeLayout.a
    public void e(SmallScreenRelativeLayout smallScreenRelativeLayout, int i3, int i16, int i17, int i18) {
        i z16 = z(smallScreenRelativeLayout);
        if (z16 != null) {
            WindowManager.LayoutParams c16 = z16.c();
            c16.x = i3;
            c16.y = i16;
            c16.width = i17 - i3;
            c16.height = i18 - i16;
            z16.f();
        }
    }

    @Override // com.tencent.av.smallscreen.SmallScreenRelativeLayout.a
    public int i(SmallScreenRelativeLayout smallScreenRelativeLayout) {
        i z16 = z(smallScreenRelativeLayout);
        if (z16 == null) {
            return 0;
        }
        return z16.c().x;
    }

    @Override // com.tencent.av.smallscreen.SmallScreenRelativeLayout.a
    public int o(SmallScreenRelativeLayout smallScreenRelativeLayout) {
        i z16 = z(smallScreenRelativeLayout);
        if (z16 == null) {
            return 0;
        }
        return z16.c().y;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ScreenRecordHelper x06 = r.h0().x0();
        if (!this.f74476m && x06.m()) {
            x06.t(configuration.orientation == 2);
        }
        QLog.d("BaseSmallScreenService", 2, "onConfigurationChanged " + configuration.orientation + " mIsAppOnForeground=" + this.f74476m + " isScreenRecordRunning=" + x06.m());
    }

    @Override // mqq.app.AppService, android.app.Service
    public void onCreate() {
        if (QLog.isColorLevel()) {
            QLog.d("BaseSmallScreenService", 2, "onCreate start");
        }
        try {
            super.onCreate();
            boolean z16 = false;
            this.f74474h = false;
            H(getApplicationContext(), 32);
            G();
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
            if (layoutInflater != null) {
                d dVar = new d(this);
                dVar.a(this, layoutInflater, this);
                this.I[0] = dVar;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.NEW_OUTGOING_CALL");
            intentFilter.addAction("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED");
            this.f74472e = SmallScreenUtils.o();
            boolean z17 = r.h0() != null && r.h0().x0().m();
            if (SmallScreenUtils.r(((AppInterface) this.app).getApp()) && !z17) {
                z16 = true;
            }
            this.f74475i = z16;
            this.f74473f = SmallScreenUtils.u(((AppInterface) this.app).getApp());
            this.f74476m = SmallScreenUtils.p(((AppInterface) this.app).getApp());
            this.C = C();
            this.E = QQTheme.isNowThemeIsNight();
            if (this.J == null) {
                this.J = new InitRunnable();
            }
            y().postDelayed(this.J, 400L);
            if (this.K == null) {
                this.K = new OnOpChangedRunnable();
            }
            y().postDelayed(this.K, 1000L);
            if (QLog.isColorLevel()) {
                QLog.d("BaseSmallScreenService", 2, "onCreate end");
            }
            try {
                registerReceiver(this.P, new IntentFilter(SkinEngine.ACTION_THEME_INVALIDATE), "com.tencent.msg.permission.pushnotify", null);
            } catch (Exception e16) {
                QLog.e("BaseSmallScreenService", 1, "onCreate error : " + e16);
            }
        } catch (Exception e17) {
            QLog.e("BaseSmallScreenService", 1, "onCreate e = " + e17);
            stopSelf();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (QLog.isColorLevel()) {
            QLog.d("BaseSmallScreenService", 2, "onDestroy start");
        }
        super.onDestroy();
        this.f74474h = true;
        H(getApplicationContext(), 0);
        J();
        unregisterReceiver(this.P);
        if (this.K != null) {
            y().removeCallbacks(this.K);
        }
        if (this.J != null) {
            y().removeCallbacks(this.J);
        }
        this.M = null;
        this.J = null;
        this.K = null;
        for (int i3 = 0; i3 < 3; i3++) {
            e eVar = this.I[i3];
            if (eVar != null) {
                eVar.c();
                this.I[i3] = null;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("BaseSmallScreenService", 2, "onDestroy end");
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        if (QLog.isColorLevel()) {
            QLog.d("BaseSmallScreenService", 2, "onLowMemory");
        }
    }

    public Handler y() {
        if (this.L == null) {
            this.L = new Handler(Looper.getMainLooper());
        }
        return this.L;
    }

    protected i z(SmallScreenRelativeLayout smallScreenRelativeLayout) {
        for (int i3 = 0; i3 < 3; i3++) {
            if (B(i3) == smallScreenRelativeLayout) {
                return A(i3);
            }
        }
        return null;
    }

    void I(long j3) {
    }

    @Override // com.tencent.av.smallscreen.SmallScreenRelativeLayout.a
    public void m(SmallScreenRelativeLayout smallScreenRelativeLayout) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(boolean z16) {
    }

    void F() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(int i3, String str) {
    }
}
