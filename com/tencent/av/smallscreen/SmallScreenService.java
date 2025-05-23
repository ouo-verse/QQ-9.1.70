package com.tencent.av.smallscreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.WindowManager;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.av.ui.ScreenRecordHelper;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.VideoUtil;
import com.tencent.av.utils.ak;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class SmallScreenService extends BaseSmallScreenService {

    /* renamed from: b0, reason: collision with root package name */
    public static boolean f74515b0 = false;

    /* renamed from: c0, reason: collision with root package name */
    public static boolean f74516c0 = false;
    VideoAppInterface U;
    boolean Q = false;
    Runnable R = null;
    OnSelectMemberActivityIsResumeChangedRunnable S = null;
    SmallScreenVideoController T = null;
    WindowManager V = null;
    long W = -1;
    final boolean[] X = new boolean[3];
    final boolean[] Y = new boolean[3];
    BroadcastReceiver Z = new a();

    /* renamed from: a0, reason: collision with root package name */
    private GAudioUIObserver f74517a0 = new b();

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class OnSelectMemberActivityIsResumeChangedRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        long f74519d = 0;

        OnSelectMemberActivityIsResumeChangedRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (r.h0() == null || r.h0().F()) {
                return;
            }
            SmallScreenService.this.I(this.f74519d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            long d16 = com.tencent.av.utils.e.d();
            String action = intent.getAction();
            if (QLog.isColorLevel()) {
                QLog.w("SmallScreenService", 1, "onReceive, action[" + action + "], seq[" + d16 + "]");
            }
            if (action.equals("android.intent.action.NEW_OUTGOING_CALL")) {
                String stringExtra = intent.getStringExtra("android.intent.extra.PHONE_NUMBER");
                if (QLog.isColorLevel()) {
                    QLog.d("SmallScreenService", 2, "onReceive NEW_OUTGOING_CALL phoneNumber = " + stringExtra);
                    return;
                }
                return;
            }
            if (action.equals("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED")) {
                SmallScreenService smallScreenService = SmallScreenService.this;
                if (smallScreenService.S != null) {
                    smallScreenService.y().removeCallbacks(SmallScreenService.this.S);
                    SmallScreenService smallScreenService2 = SmallScreenService.this;
                    smallScreenService2.S.f74519d = d16;
                    smallScreenService2.y().postDelayed(SmallScreenService.this.S, 200L);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b extends GAudioUIObserver {
        b() {
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void D(long j3, long j16) {
            String str = n.e().f().f73091w;
            QLog.d("SmallScreenService", 1, "[onMeetingNotifyTimeout] relationId=" + j16 + " peerUin=" + str);
            if (r.h0() == null || !n.e().f().B1) {
                return;
            }
            SmallScreenService.this.O();
            TraeHelper.I().k0(j3);
            r.h0().Y1(j3, j16, true, 12);
            SmallScreenService.this.U.k0(new Object[]{28, str, Boolean.TRUE});
        }
    }

    private void N() {
        LayoutInflater layoutInflater;
        QLog.d("SmallScreenService", 1, "checkSmallScreenItemAndInit");
        if (this.Y[0] && this.I[0] == null) {
            layoutInflater = P();
            d dVar = new d(this);
            dVar.a(this, layoutInflater, this);
            this.I[0] = dVar;
            dVar.f74602b.setCurPosition(this.G);
            SmallScreenVideoController smallScreenVideoController = this.T;
            if (smallScreenVideoController != null) {
                smallScreenVideoController.q(false);
            }
            QLog.d("SmallScreenService", 1, "checkSmallScreenItemAndInit new TOAST_AUDIO");
        } else {
            layoutInflater = null;
        }
        if (this.Y[1] && this.I[1] == null) {
            if (layoutInflater == null) {
                layoutInflater = P();
            }
            k kVar = new k(this);
            kVar.a(this, layoutInflater, this);
            this.I[1] = kVar;
            kVar.f74602b.setCurPosition(this.G);
            SmallScreenVideoController smallScreenVideoController2 = this.T;
            if (smallScreenVideoController2 != null) {
                smallScreenVideoController2.q(false);
            }
            QLog.d("SmallScreenService", 1, "checkSmallScreenItemAndInit new TOAST_VIDEO");
        }
        if (this.Y[2] && this.I[2] == null) {
            if (layoutInflater == null) {
                layoutInflater = P();
            }
            h hVar = new h(this);
            hVar.a(this, layoutInflater, this);
            this.I[2] = hVar;
            hVar.f74602b.setCurPosition(this.G);
            f74516c0 = true;
            QLog.d("SmallScreenService", 1, "checkSmallScreenItemAndInit new TOAST_SHARE");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private LayoutInflater P() {
        LayoutInflater layoutInflater;
        try {
            layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("SmallScreenService", 2, "onCreate e = " + e16);
            }
            layoutInflater = null;
            if (layoutInflater == null) {
            }
            return layoutInflater;
        } catch (OutOfMemoryError e17) {
            if (QLog.isColorLevel()) {
                QLog.e("SmallScreenService", 2, "onCreate e = " + e17);
            }
            layoutInflater = null;
            if (layoutInflater == null) {
            }
            return layoutInflater;
        }
        if (layoutInflater == null) {
            QLog.e("SmallScreenService", 1, "onCreate cannot get inflate service!");
            stopSelf();
        }
        return layoutInflater;
    }

    private void Q(String str) {
        if (!this.f74474h && r.h0() != null) {
            boolean z16 = r.h0().x0().m();
            if (QLog.isColorLevel()) {
                QLog.i("SmallScreenService", 2, "initSmallScreenVideoUI, shareScreen[" + z16 + "], uiCtrl[" + this.T + "], from[" + str + "]");
            }
            if (z16 || this.T != null) {
                return;
            }
            SmallScreenVideoController smallScreenVideoController = new SmallScreenVideoController(this);
            this.T = smallScreenVideoController;
            smallScreenVideoController.p(this.app);
            this.T.v();
            this.T.u();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SmallScreenService", 2, "initSmallScreenVideoUI, isDestroyed.");
        }
    }

    private boolean T(String str, boolean z16, boolean z17) {
        SessionInfo f16 = r.h0() != null ? n.e().f() : null;
        return (z17 || z16 || !SmallScreenUtils.x() || (!this.f74476m && (!ea.s2(str) || this.C)) || f16 == null || f16.H2) ? false : true;
    }

    private boolean U() {
        return (this.f74474h || r.h0() == null || this.U == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(long j3, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27, boolean z28) {
        if (!U()) {
            QLog.e("SmallScreenService", 1, "showHideToastAsync checkService failed on main thread!");
            return;
        }
        M(j3, Y(j3, z16, z17, z18, z19, z26, z27, z28), z28);
        Z(this.Y, this.X);
        a0(this.Y, this.X);
    }

    private boolean Y(long j3, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27, boolean z28) {
        SessionInfo f16;
        boolean z29;
        boolean z36;
        if (r.h0() == null || this.f74474h || (f16 = n.e().f()) == null) {
            return false;
        }
        int i3 = f16.f73035i;
        int i16 = f16.S0;
        String str = f16.f73030h;
        boolean z37 = (str == null || !str.startsWith("10-") || f16.f73060o0) ? false : true;
        if (i16 == 10 || z37) {
            z29 = false;
            z36 = false;
        } else {
            z29 = z16;
            z36 = z17;
        }
        if (!z19 && z29 && this.T == null) {
            Q("showHideToast");
        }
        if (z26 && this.f74471d) {
            this.f74471d = false;
        }
        for (int i17 = 0; i17 < 3; i17++) {
            e eVar = this.I[i17];
            if (eVar != null) {
                this.X[i17] = eVar.b();
            } else {
                this.X[i17] = false;
            }
        }
        boolean[] zArr = this.Y;
        zArr[0] = z36 && (this.f74471d ^ true) && z29;
        zArr[1] = z18 && z29;
        zArr[2] = z19 && z29;
        N();
        if (QLog.isColorLevel()) {
            QLog.w("SmallScreenService", 2, "showHideToast, hasVideo[" + z26 + "], mIsInCall[" + this.Q + "], isOpEnable[" + z27 + "], isVideoToastCanShow[" + z18 + "], isAudioToastCanShow[" + z36 + "], isShareToastCanShow[" + z19 + "], isToastShow[" + z29 + "], mIsLock[" + this.f74473f + "], mIsInit[" + this.f74471d + "], mIsAppOnForeground[" + this.f74476m + "], SessionType[" + i3 + "], relationType[" + i16 + "], isSelectMemberActivityIsResume[" + z28 + "], mSmallScreenStateBroadcast[" + this.H + "], seq[" + j3 + "]");
        }
        for (int i18 = 0; i18 < 3; i18++) {
            e eVar2 = this.I[i18];
            if (eVar2 != null && eVar2.f74602b != null && eVar2.f74603c != null) {
                eVar2.f(this);
                if (eVar2.b() && !this.Y[i18]) {
                    this.G = eVar2.f74602b.b();
                }
            }
        }
        for (int i19 = 0; i19 < 3; i19++) {
            e eVar3 = this.I[i19];
            if (eVar3 != null && eVar3.f74602b != null && eVar3.f74603c != null) {
                eVar3.e(this.Y[i19], this.G);
            }
        }
        return z29;
    }

    private void e0(final long j3) {
        SessionInfo f16;
        String str;
        if (this.f74474h || (f16 = n.e().f()) == null) {
            return;
        }
        final boolean z16 = this.F > 0 || f16.f73102y2 || f16.f73098x2;
        VideoAppInterface videoAppInterface = this.U;
        if (videoAppInterface != null) {
            r3 = (f16.f73060o0 && f16.f73043k == 15) ? false : SmallScreenUtils.r(videoAppInterface.getApp());
            str = this.U.getCurrentAccountUin();
        } else {
            str = "";
        }
        final String str2 = str;
        final boolean z17 = r3;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.smallscreen.f
            @Override // java.lang.Runnable
            public final void run() {
                SmallScreenService.this.W(z16, str2, z17, j3);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.av.smallscreen.BaseSmallScreenService
    void F() {
        String str;
        String str2;
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.w("SmallScreenService", 1, "onOpChanged, mIsOpEnable[" + this.f74475i + "], seq[" + d16 + "]");
        }
        I(d16);
        if (this.f74475i) {
            str = "0X80057D9";
        } else {
            str = "0X80057DB";
        }
        String str3 = str;
        ReportController.o(null, "CliOper", "", "", str3, str3, 0, 0, "", "", "", "");
        if (this.F > 0) {
            if (this.f74475i) {
                str2 = "0X80057DA";
            } else {
                str2 = "0X80057DC";
            }
            String str4 = str2;
            ReportController.o(null, "CliOper", "", "", str4, str4, 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.av.smallscreen.BaseSmallScreenService
    public void I(long j3) {
        SessionInfo f16;
        String str;
        boolean z16;
        if (ak.c("qav_anr_fix_control", "async_show_hide_toast", false)) {
            e0(j3);
            return;
        }
        if (this.f74474h || (f16 = n.e().f()) == null) {
            return;
        }
        boolean z17 = true;
        boolean z18 = this.F > 0 || f16.f73102y2 || f16.f73098x2;
        VideoAppInterface videoAppInterface = this.U;
        if (videoAppInterface != null) {
            boolean r16 = SmallScreenUtils.r(videoAppInterface.getApp());
            if (f16.f73060o0 && f16.f73043k == 15) {
                r16 = false;
            }
            str = this.U.getCurrentAccountUin();
            z16 = r16;
        } else {
            str = "";
            z16 = false;
        }
        this.f74476m = S();
        boolean z19 = r.h0().x0().m();
        boolean z26 = !z19 && z18 && SmallScreenUtils.y() && (this.f74476m || ea.t2(str));
        boolean T = T(str, z18, z19);
        boolean z06 = r.h0().z0();
        if (!((this.Q || !z16 || z06 || this.f74473f) ? false : true) || (!z19 && !z26 && !T)) {
            z17 = false;
        }
        M(j3, Y(j3, z17, T, z26, z19, z18, z16, z06), z06);
        Z(this.Y, this.X);
        a0(this.Y, this.X);
    }

    protected void O() {
        ScreenShareCtrl y06 = r.h0().y0();
        if (y06 != null) {
            y06.p(2);
        }
        ScreenRecordHelper x06 = r.h0().x0();
        if (x06 != null) {
            x06.y(2);
        }
    }

    public void R() {
        LayoutInflater P = P();
        if (P == null) {
            return;
        }
        k kVar = new k(this);
        kVar.a(this, P, this);
        this.I[1] = kVar;
        kVar.f74602b.setCurPosition(this.G);
        SmallScreenVideoController smallScreenVideoController = this.T;
        if (smallScreenVideoController != null) {
            smallScreenVideoController.q(false);
        }
    }

    protected boolean S() {
        VideoAppInterface videoAppInterface = this.U;
        boolean z16 = false;
        if (videoAppInterface == null) {
            return false;
        }
        boolean j3 = VideoUtil.j();
        boolean z17 = (j3 && videoAppInterface.isBackgroundPause) ? false : true;
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenService", 2, "isAppOnForeground result = " + z17 + ", isQQPaused = " + j3 + ", isAVPaused = " + videoAppInterface.isBackgroundPause);
        }
        if (z17) {
            try {
                if (BaseGesturePWDUtil.isAppOnForegroundByTasks(this, 0)) {
                    z16 = true;
                }
            } catch (Exception e16) {
                if (!QLog.isColorLevel()) {
                    return z17;
                }
                QLog.e("SmallScreenService", 2, "isAppOnForeground e = " + e16);
                return z17;
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X(int i3) {
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isDevelopLevel()) {
            QLog.w("SmallScreenService", 1, "onVideoNumChanged, videoViewCount[" + this.F + "->" + i3 + "], seq[" + d16 + "]");
        }
        this.F = i3;
        I(d16);
    }

    protected void Z(boolean[] zArr, boolean[] zArr2) {
        String str;
        SessionInfo f16 = n.e().f();
        int i3 = f16.f73035i;
        int i16 = f16.S0;
        boolean z16 = i3 == 1 || i3 == 2;
        String str2 = null;
        if (zArr[1]) {
            if (!zArr2[1]) {
                if (zArr2[0]) {
                    if (z16) {
                        str2 = "0X8005A4A";
                    } else if (i16 == 1) {
                        str2 = "0X8005A4C";
                    } else if (i16 == 2) {
                        str2 = "0X8005A4B";
                    }
                }
                str = "0X80057E6";
            }
            str = null;
        } else {
            if (zArr2[1]) {
                str = "0X80057E5";
            }
            str = null;
        }
        if (zArr[0] && !zArr2[0] && zArr2[1]) {
            if (z16) {
                str2 = "0X8005A4D";
            } else if (i16 == 1) {
                str2 = "0X8005A4F";
            } else if (i16 == 2) {
                str2 = "0X8005A4E";
            }
        }
        if (str != null) {
            ReportController.o(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
        }
        if (str2 != null) {
            ReportController.o(null, "CliOper", "", "", str2, str2, 0, 0, "", "", "", "");
        }
    }

    void c0() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.smallscreen.SmallScreenService.3
            @Override // java.lang.Runnable
            public void run() {
                VideoAppInterface videoAppInterface = (VideoAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                if (videoAppInterface != null) {
                    SharedPreferences.Editor edit = ea.U0(videoAppInterface.getApp()).edit();
                    if (r.h0().Y0()) {
                        edit.putInt("small_window_position_land", n.e().f().D1);
                    }
                    edit.apply();
                }
            }
        }, 16, null, true);
    }

    void d0(long j3, int i3) {
        if (QLog.isDevelopLevel()) {
            QLog.i("SmallScreenService", 4, "sendStateBroadcast, state[" + i3 + "], sCanSendStateDelayFlag[" + f74515b0 + "]");
        }
        f74515b0 = false;
        if (this.R != null) {
            y().removeCallbacks(this.R);
        }
        if (SmallScreenUtils.B(j3, this.U, i3)) {
            this.H = i3;
        }
    }

    @Override // com.tencent.av.smallscreen.BaseSmallScreenService, com.tencent.av.smallscreen.SmallScreenRelativeLayout.a
    public void m(SmallScreenRelativeLayout smallScreenRelativeLayout) {
        SmallScreenVideoController smallScreenVideoController = this.T;
        if (smallScreenVideoController != null) {
            smallScreenVideoController.s();
        }
    }

    @Override // com.tencent.av.smallscreen.BaseSmallScreenService, mqq.app.AppService, android.app.Service
    public void onCreate() {
        long d16 = com.tencent.av.utils.e.d();
        QLog.w("SmallScreenService", 1, "avideo onCreate start, seq[" + d16 + "]");
        super.onCreate();
        VideoAppInterface videoAppInterface = (VideoAppInterface) this.app;
        this.U = videoAppInterface;
        videoAppInterface.addObserver(this.f74517a0);
        SessionInfo f16 = n.e().f();
        d0(d16, 1);
        this.V = (WindowManager) getSystemService("window");
        SharedPreferences U0 = ea.U0(this.U.getApp());
        if (r.h0().Y0()) {
            this.G = U0.getInt("small_window_position_land", 12);
        } else {
            this.G = f16.D1;
        }
        f16.D1 = this.G;
        for (int i3 = 0; i3 < 3; i3++) {
            SmallScreenRelativeLayout B = B(i3);
            if (B != null) {
                B.setCurPosition(this.G);
            }
        }
        if (this.S == null) {
            OnSelectMemberActivityIsResumeChangedRunnable onSelectMemberActivityIsResumeChangedRunnable = new OnSelectMemberActivityIsResumeChangedRunnable();
            this.S = onSelectMemberActivityIsResumeChangedRunnable;
            onSelectMemberActivityIsResumeChangedRunnable.f74519d = d16;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.NEW_OUTGOING_CALL");
            intentFilter.addAction("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED");
            registerReceiver(this.Z, intentFilter);
        } catch (Exception e16) {
            this.Z = null;
            QLog.d("SmallScreenService", 1, "registerReceiver failed: " + e16);
        }
        this.Q = this.U.b0();
        Q("onCreate");
        I(d16);
        QLog.d("SmallScreenService", 1, "onCreate end");
    }

    @Override // com.tencent.av.smallscreen.BaseSmallScreenService, android.app.Service
    public void onDestroy() {
        SmallScreenRelativeLayout B;
        long d16 = com.tencent.av.utils.e.d();
        QLog.w("SmallScreenService", 1, "avideo onDestroy start, seq[" + d16 + "], sLastActionOnFrom[" + SmallScreenUtils.f74525d + "]");
        if (this.F > 0) {
            B = B(1);
        } else {
            B = B(0);
        }
        if (B != null) {
            n.e().f().D1 = B.b();
        }
        c0();
        super.onDestroy();
        d0(d16, 0);
        this.R = null;
        SmallScreenVideoController smallScreenVideoController = this.T;
        if (smallScreenVideoController != null) {
            smallScreenVideoController.t();
            this.T.w();
            this.T.r(d16);
        }
        BroadcastReceiver broadcastReceiver = this.Z;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
        if (this.S != null) {
            this.U.M().removeCallbacks(this.S);
        }
        this.U.deleteObserver(this.f74517a0);
        this.f74517a0 = null;
        this.S = null;
        this.T = null;
        this.Z = null;
        this.U = null;
        f74516c0 = false;
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenService", 2, "onDestroy end");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.av.smallscreen.BaseSmallScreenService
    public void v() {
        int i3;
        int i16;
        super.v();
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.w("SmallScreenService", 1, "doInitRunnable, start, seq[" + d16 + "]");
        }
        if (r.h0() != null) {
            if (r.h0().F()) {
                QLog.w("SmallScreenService", 1, "doInitRunnable, AvActivityIsResume, seq[" + d16 + "]");
                return;
            }
            SessionInfo f16 = n.e().f();
            if (f16 != null) {
                if (QLog.isColorLevel()) {
                    QLog.w("SmallScreenService", 1, "InitRunnable, SessionType[" + f16.f73035i + "]");
                }
                int i17 = f16.f73035i;
                if (i17 == 1 || i17 == 3) {
                    this.f74471d = false;
                    I(d16);
                } else if (i17 == 4) {
                    if (!NetworkUtil.isWifiConnected(this.U.getApp()) && !f16.C1) {
                        this.f74471d = false;
                        I(d16);
                    }
                } else if (i17 == 0 && f16.G && (((i3 = f16.f73043k) == 1 || i3 == 2) && ((i16 = f16.f73039j) == 1 || i16 == 2))) {
                    QLog.w("SmallScreenService", 1, "doInitRunnable, sessionInfo.BeginSessionType,[" + i16 + "]");
                    this.f74471d = false;
                    I(d16);
                }
            } else if (QLog.isColorLevel()) {
                QLog.w("SmallScreenService", 1, "doInitRunnable, sessionInfo\u4e3a\u7a7a, seq[" + d16 + "]");
            }
        } else if (QLog.isColorLevel()) {
            QLog.w("SmallScreenService", 1, "doInitRunnable, VideoController\u4e3a\u7a7a, seq[" + d16 + "]");
        }
        if (QLog.isColorLevel()) {
            QLog.w("SmallScreenService", 1, "doInitRunnable, end, seq[" + d16 + "]");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.av.smallscreen.BaseSmallScreenService
    public void w(boolean z16) {
        super.w(z16);
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.w("SmallScreenService", 1, "doOnCallStateChange, isCalling[" + z16 + "], mIsInCall[" + this.Q + "], seq[" + d16 + "]");
        }
        this.Q = z16;
        I(d16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.av.smallscreen.BaseSmallScreenService
    public void x(int i3, String str) {
        super.x(i3, str);
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.w("SmallScreenService", 1, "doPhoneStateChange, state[" + i3 + "], incomingNumber[" + str + "], mIsInCall[" + this.Q + "], seq[" + d16 + "]");
        }
        if (i3 == 0) {
            this.Q = false;
        } else if (i3 == 1) {
            this.Q = true;
        } else if (i3 == 2) {
            this.Q = true;
        }
        I(d16);
    }

    public void a0(boolean[] zArr, boolean[] zArr2) {
        if (zArr[0] && !this.f74476m && ea.s2(this.U.getCurrentAccountUin()) && !this.C) {
            ReportController.o(null, "dc00898", "", "", "0X800C134", "0X800C134", 1, 0, "", "", "", "");
        }
        if (!zArr[1] || this.f74476m || !ea.t2(this.U.getCurrentAccountUin()) || System.currentTimeMillis() - this.W <= 1000) {
            return;
        }
        this.W = System.currentTimeMillis();
        ReportController.o(null, "dc00898", "", "", "0X800C134", "0X800C134", 2, 0, "", "", "", "");
    }

    @Override // com.tencent.av.smallscreen.BaseSmallScreenService, com.tencent.av.smallscreen.SmallScreenRelativeLayout.a
    public boolean b(SmallScreenRelativeLayout smallScreenRelativeLayout) {
        if (smallScreenRelativeLayout == B(2)) {
            O();
        }
        SmallScreenVideoController smallScreenVideoController = this.T;
        if (smallScreenVideoController != null) {
            smallScreenVideoController.o();
        } else {
            SmallScreenVideoController.j(getApplicationContext());
        }
        b0(smallScreenRelativeLayout);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(final boolean z16, String str, final boolean z17, final long j3) {
        String str2;
        final boolean z18;
        if (!U()) {
            QLog.e("SmallScreenService", 1, "showHideToastAsync checkService failed on normal thread!");
            return;
        }
        this.f74476m = S();
        if (r.h0() == null || this.f74474h) {
            return;
        }
        final boolean z19 = r.h0().x0().m();
        if (!z19 && z16 && SmallScreenUtils.y() && (this.f74476m || ea.t2(str))) {
            str2 = str;
            z18 = true;
        } else {
            str2 = str;
            z18 = false;
        }
        final boolean T = T(str2, z16, z19);
        final boolean z06 = r.h0().z0();
        final boolean z26 = (!this.Q && z17 && !z06 && !this.f74473f) && (z19 || z18 || T);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.av.smallscreen.g
            @Override // java.lang.Runnable
            public final void run() {
                SmallScreenService.this.V(j3, z26, T, z18, z19, z16, z17, z06);
            }
        });
    }

    private void M(final long j3, boolean z16, boolean z17) {
        int i3;
        if (z16) {
            boolean[] zArr = this.Y;
            if (zArr[0] || zArr[1]) {
                if (this.H != 3) {
                    d0(j3, 3);
                    return;
                }
                return;
            }
        }
        if (z17 || this.f74473f || !this.f74476m || (i3 = this.H) == 2) {
            return;
        }
        if (z16 && this.Y[2]) {
            d0(j3, 2);
            return;
        }
        if (i3 == 1) {
            Handler y16 = y();
            if (this.R == null) {
                this.R = new Runnable() { // from class: com.tencent.av.smallscreen.SmallScreenService.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QLog.isDevelopLevel()) {
                            QLog.i("SmallScreenService", 4, "hideStateRunnable, sCanSendStateDelayFlag[" + SmallScreenService.f74515b0 + "]");
                        }
                        if (SmallScreenService.f74515b0) {
                            SmallScreenService.this.d0(j3, 2);
                        }
                    }
                };
            }
            y16.removeCallbacks(this.R);
            f74515b0 = true;
            y16.postDelayed(this.R, 1000L);
            return;
        }
        d0(j3, 2);
    }

    public void b0(SmallScreenRelativeLayout smallScreenRelativeLayout) {
        String str;
        String str2;
        SmallScreenRelativeLayout B = B(0);
        SmallScreenRelativeLayout B2 = B(1);
        if (smallScreenRelativeLayout == B) {
            if (this.f74476m) {
                str2 = "1";
            } else {
                str2 = "2";
            }
            ReportController.o(null, "dc00898", "", "", "0X800C135", "0X800C135", 1, 0, str2, "", "", "");
        }
        if (smallScreenRelativeLayout == B2) {
            if (this.f74476m) {
                str = "1";
            } else {
                str = "2";
            }
            ReportController.o(null, "dc00898", "", "", "0X800C135", "0X800C135", 2, 0, str, "", "", "");
        }
    }
}
