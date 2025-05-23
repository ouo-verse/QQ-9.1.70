package com.tencent.mobileqq.listentogether.lyrics;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Process;
import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.listentogether.ListenTogetherHandler;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment;
import com.tencent.mobileqq.perf.process.state.floating.IFloatingState;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ListenTogetherTheme.FloatViewSkin;
import com.tencent.mobileqq.theme.ListenTogetherTheme.a;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ff;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.ActionSheet;
import java.util.HashMap;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes33.dex */
public class LyricsController implements com.tencent.mobileqq.listentogether.lyrics.a, a.InterfaceC8646a {
    String D;
    protected FloatIconLayout E;
    protected FloatTextLayout F;
    int G;
    int H;
    int I;
    int J;
    int K;
    int L;
    com.tencent.mobileqq.listentogether.i R;

    /* renamed from: c0, reason: collision with root package name */
    ValueAnimator f241001c0;

    /* renamed from: d, reason: collision with root package name */
    protected QQAppInterface f241002d;

    /* renamed from: d0, reason: collision with root package name */
    int f241003d0;

    /* renamed from: e0, reason: collision with root package name */
    String f241005e0;

    /* renamed from: f0, reason: collision with root package name */
    String f241007f0;

    /* renamed from: g0, reason: collision with root package name */
    Boolean f241008g0;

    /* renamed from: e, reason: collision with root package name */
    protected Set<String> f241004e = new ArraySet();

    /* renamed from: f, reason: collision with root package name */
    boolean f241006f = true;

    /* renamed from: h, reason: collision with root package name */
    protected com.tencent.mobileqq.listentogether.lyrics.b f241009h = new com.tencent.mobileqq.listentogether.lyrics.b();

    /* renamed from: i, reason: collision with root package name */
    boolean f241010i = false;

    /* renamed from: m, reason: collision with root package name */
    boolean f241011m = false;
    int C = -1;
    HashMap<String, Boolean> M = new HashMap<>();
    public boolean N = false;
    public boolean P = false;
    boolean Q = true;
    private Runnable S = new Runnable() { // from class: com.tencent.mobileqq.listentogether.lyrics.LyricsController.2
        @Override // java.lang.Runnable
        public void run() {
            if (QLog.isColorLevel()) {
                QLog.i("LyricsController", 2, "mDelayUpdateLyricsFloatWindowRunnable isForeground: " + LyricsController.this.f241006f + " mFloatParams:" + LyricsController.this.f241009h);
            }
            LyricsController.this.a0();
        }
    };
    protected com.tencent.mobileqq.listentogether.e T = new f();
    private BroadcastReceiver U = new g();
    int V = 0;
    Runnable W = new Runnable() { // from class: com.tencent.mobileqq.listentogether.lyrics.LyricsController.6
        @Override // java.lang.Runnable
        public void run() {
            if (QLog.isColorLevel()) {
                QLog.d("LyricsController", 2, "onActivityResumed: mHoldByPermissionType:" + LyricsController.this.C + " mHoldByPermissionUin:" + LyricsController.this.D);
            }
            LyricsController lyricsController = LyricsController.this;
            lyricsController.V++;
            if (lyricsController.w()) {
                LyricsController lyricsController2 = LyricsController.this;
                if (lyricsController2.C != -1 && !TextUtils.isEmpty(lyricsController2.D)) {
                    LyricsController lyricsController3 = LyricsController.this;
                    lyricsController3.R(lyricsController3.C, lyricsController3.D);
                }
            }
            LyricsController lyricsController4 = LyricsController.this;
            if (lyricsController4.V >= 3) {
                lyricsController4.f241011m = false;
                lyricsController4.V = 0;
            }
        }
    };
    boolean X = false;
    Application.ActivityLifecycleCallbacks Y = new h();
    private boolean Z = false;

    /* renamed from: a0, reason: collision with root package name */
    private final IGuardInterface f240999a0 = new i();

    /* renamed from: b0, reason: collision with root package name */
    private Runnable f241000b0 = new Runnable() { // from class: com.tencent.mobileqq.listentogether.lyrics.LyricsController.13
        @Override // java.lang.Runnable
        public void run() {
            LyricsController lyricsController = LyricsController.this;
            lyricsController.f241009h.f241059k = true;
            if (lyricsController.f241010i) {
                if (lyricsController.w()) {
                    LyricsController.this.a0();
                    return;
                }
                LyricsController lyricsController2 = LyricsController.this;
                com.tencent.mobileqq.listentogether.lyrics.b bVar = lyricsController2.f241009h;
                lyricsController2.x(bVar.f241062n, bVar.f241063o);
                if (QLog.isColorLevel()) {
                    QLog.d("LyricsController", 2, "ACTION_QQ_FOREGROUND no permission hideLyrics");
                }
            }
        }
    };

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements DialogInterface.OnCancelListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            LyricsController.this.T(false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f241014d;

        b(ActionSheet actionSheet) {
            this.f241014d = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            this.f241014d.dismiss();
            LyricsController.this.I();
            LyricsController.this.T(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int C;
        final /* synthetic */ int D;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f241017d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f241018e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f241019f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f241020h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f241021i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ int f241022m;

        d(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            this.f241017d = i3;
            this.f241018e = i16;
            this.f241019f = i17;
            this.f241020h = i18;
            this.f241021i = i19;
            this.f241022m = i26;
            this.C = i27;
            this.D = i28;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!LyricsController.this.f241010i) {
                valueAnimator.cancel();
                LyricsController.this.f241001c0 = null;
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i3 = (int) (this.f241017d + ((this.f241018e - r0) * floatValue) + 0.5f);
            int i16 = (int) (this.f241019f + ((this.f241020h - r2) * floatValue) + 0.5f);
            int i17 = (int) (this.f241021i + ((this.f241022m - r3) * floatValue) + 0.5f);
            int i18 = (int) (this.C + ((this.D - r4) * floatValue) + 0.5f);
            LyricsController.this.E.r(i3, i16);
            LyricsController.this.F.r(i17, i18);
            LyricsController.this.E.b();
            LyricsController.this.F.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class j implements ActionSheet.OnDismissListener {
        j() {
        }

        @Override // com.tencent.widget.ActionSheet.OnDismissListener
        public void onDismiss() {
            LyricsController.this.T(false);
        }
    }

    public LyricsController(QQAppInterface qQAppInterface) {
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.f241002d = qQAppInterface;
        qQAppInterface.addObserver(this.T);
        this.f241009h.f241053e = true;
        BaseApplication context = BaseApplication.getContext();
        this.K = ViewUtils.getScreenWidth();
        this.L = ViewUtils.getScreenHeight();
        int f16 = BaseAIOUtils.f(12.0f, context.getResources());
        this.I = f16;
        this.G = f16;
        int f17 = BaseAIOUtils.f(12.0f, context.getResources());
        this.J = f17;
        this.H = f17;
        com.tencent.mobileqq.listentogether.lyrics.b bVar = this.f241009h;
        bVar.f241049a = -1000;
        bVar.f241050b = -1000;
        Q();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.listentogether.lyrics.LyricsController.1
            @Override // java.lang.Runnable
            public void run() {
                LyricsController.this.C();
            }
        }, 32, null, true);
    }

    public static boolean B() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        QQAppInterface qQAppInterface = this.f241002d;
        if (qQAppInterface == null) {
            QLog.i("LyricsController", 1, "notifyThemeChanged fail, app is null");
            return;
        }
        ListenTogetherHandler listenTogetherHandler = (ListenTogetherHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
        if (listenTogetherHandler != null) {
            listenTogetherHandler.notifyUI(16, true, null);
        }
    }

    private void J() {
        QQAppInterface qQAppInterface = this.f241002d;
        if (qQAppInterface != null) {
            ListenTogetherManager.J(qQAppInterface).x1(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(String str, int i3, int i16) {
        if (this.f241010i) {
            Y(str, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("LyricsController", 2, String.format("onPlaySongChange [pre,next]=[%s,%s]", this.f241005e0, str));
        }
        if (!Utils.p(str, this.f241005e0)) {
            this.f241005e0 = str;
            this.f241007f0 = null;
            this.f241008g0 = null;
        }
        com.tencent.mobileqq.listentogether.lyrics.c u16 = u();
        if (u16 == null || Utils.p(u16.a(), str)) {
            return;
        }
        u16.setSongId(str);
        u16.setLyric(null, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(String str, int i3) {
        if (Utils.p(str, this.f241005e0)) {
            this.f241003d0 = i3;
            if (this.f241010i) {
                Z(str, i3);
            }
        }
    }

    private void N() {
        if (this.X) {
            return;
        }
        BaseApplicationImpl.getApplication().registerActivityLifecycleCallbacks(this.Y);
        this.X = true;
    }

    private void O() {
        QQAppInterface qQAppInterface = this.f241002d;
        if (qQAppInterface == null) {
            return;
        }
        SharedPreferences.Editor edit = qQAppInterface.getPreferences().edit();
        synchronized (this.f241004e) {
            if (!this.f241004e.isEmpty()) {
                edit.putStringSet("listen_together_lyric_user_closes", this.f241004e);
            } else {
                edit.remove("listen_together_lyric_user_closes");
            }
        }
        edit.putInt("listen_together_float_loc_icon_cx", this.f241009h.f241049a);
        edit.putInt("listen_together_float_loc_icon_cy", this.f241009h.f241050b);
        edit.putBoolean("listen_together_float_align_right", this.f241009h.f241053e);
        edit.apply();
    }

    private boolean S(int i3, String str) {
        if (this.f241010i && this.f241009h.a(i3, str)) {
            return true;
        }
        BaseApplication context = BaseApplication.getContext();
        synchronized (this.f241004e) {
            this.f241009h.f241054f = this.f241004e.contains(i3 + "_" + str);
        }
        boolean z16 = !this.f241009h.b(i3, str);
        com.tencent.mobileqq.listentogether.lyrics.b bVar = this.f241009h;
        if (z16 != bVar.f241056h) {
            bVar.f241056h = z16;
            bVar.f241057i = true;
        }
        if (this.E == null) {
            FloatIconLayout floatIconLayout = new FloatIconLayout(context);
            this.E = floatIconLayout;
            floatIconLayout.setFloatLayoutCallback(this);
            FloatViewSkin.o().v(this.E);
            c();
        }
        if (this.F == null) {
            FloatTextLayout floatTextLayout = new FloatTextLayout(context);
            this.F = floatTextLayout;
            floatTextLayout.setFloatLayoutCallback(this);
        }
        this.F.w();
        com.tencent.mobileqq.listentogether.lyrics.b bVar2 = this.f241009h;
        if (!bVar2.f241056h) {
            if (bVar2.f241053e) {
                bVar2.f241049a = ((this.K / 2) - (this.E.j() / 2)) - (this.F.j() / 2);
            } else {
                bVar2.f241049a = (this.K / 2) + (this.E.j() / 2) + (this.F.j() / 2);
            }
            com.tencent.mobileqq.listentogether.lyrics.b bVar3 = this.f241009h;
            if (bVar3.f241050b == -1000) {
                bVar3.f241050b = (this.L - (this.E.g() / 2)) - BaseAIOUtils.f(110.0f, BaseApplication.getContext().getResources());
            }
            this.f241009h.f241058j = true;
        } else {
            if (bVar2.f241053e) {
                bVar2.f241049a = this.I + (this.E.j() / 2);
            } else {
                bVar2.f241049a = (this.K - this.G) - (this.E.j() / 2);
            }
            com.tencent.mobileqq.listentogether.lyrics.b bVar4 = this.f241009h;
            if (bVar4.f241050b == -1000) {
                bVar4.f241050b = BaseAIOUtils.f(70.0f, BaseApplication.getContext().getResources()) + (this.E.g() / 2);
            }
            this.f241009h.f241058j = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LyricsController", 2, "showLyricsInner mFloatParams: " + this.f241009h);
        }
        this.E.C(this.f241009h);
        this.F.x(this.f241009h);
        FloatIconLayout floatIconLayout2 = this.E;
        floatIconLayout2.r(floatIconLayout2.s(this.f241009h), this.E.t(this.f241009h));
        FloatTextLayout floatTextLayout2 = this.F;
        floatTextLayout2.r(floatTextLayout2.t(this.f241009h), this.F.u(this.f241009h));
        boolean y16 = this.F.y(this.f241009h);
        boolean D = this.E.D(this.f241009h);
        this.f241009h.f241057i = false;
        return (D && y16) ? false : true;
    }

    private void V() {
        if (this.X) {
            BaseApplicationImpl.getApplication().unregisterActivityLifecycleCallbacks(this.Y);
            this.X = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean X(String str, String str2, boolean z16) {
        com.tencent.mobileqq.listentogether.lyrics.c u16;
        if (QLog.isColorLevel()) {
            QLog.i("LyricsController", 2, String.format("updateLyricContent [%s]", str));
        }
        if (TextUtils.isEmpty(str) || (u16 = u()) == null || !str.equals(u16.a()) || u16.getState() == 2) {
            return false;
        }
        if (!TextUtils.isEmpty(str2)) {
            str2 = str2.replace("&apos;", "'").replace("&quot;", "\"").replace("&nbsp;", " ").replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", ContainerUtils.FIELD_DELIMITER);
        }
        com.tencent.mobileqq.lyric.data.b a16 = com.tencent.mobileqq.lyric.util.b.a(str2, true);
        if (a16 == null) {
            a16 = com.tencent.mobileqq.lyric.util.b.a(str2, false);
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(a16 == null);
            QLog.i("LyricsController", 2, String.format("updateLyricContent parse lyric==null [%b]", objArr));
        }
        int i3 = a16 == null ? z16 ? 3 : 4 : 2;
        u16.stop();
        u16.setLyric(a16, i3);
        return true;
    }

    private void Y(String str, int i3) {
        com.tencent.mobileqq.listentogether.lyrics.c u16 = u();
        if (u16 != null && Utils.p(u16.a(), str)) {
            u16.seek(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("LyricsController", 2, String.format("updateLyricState [%s, %s]", com.tencent.mobileqq.listentogether.player.a.a(i3), str));
        }
        com.tencent.mobileqq.listentogether.lyrics.c u16 = u();
        if (u16 == null) {
            return;
        }
        u16.setSongId(str);
        if (i3 != 2) {
            if (3 == i3) {
                u16.seek(0);
                u16.pause();
                return;
            } else if (1 != i3 && i3 != 0) {
                u16.stop();
                return;
            } else {
                u16.pause();
                return;
            }
        }
        boolean isPlaying = u16.isPlaying();
        if (!isPlaying) {
            u16.start();
        }
        QLog.i("LyricsController", 1, "updateLyricPosition() seek to playPosition:0 isPlaying:" + isPlaying);
        u16.seek(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.listentogether.lyrics.d
            @Override // java.lang.Runnable
            public final void run() {
                LyricsController.this.b0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        int j3;
        BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            int i3 = context.getResources().getDisplayMetrics().widthPixels;
            int i16 = context.getResources().getDisplayMetrics().heightPixels;
            if (i3 != this.K) {
                this.K = i3;
                if (this.f241010i) {
                    this.F.w();
                }
            }
            if (i16 != this.L) {
                this.L = i16;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("LyricsController", 2, "updateLyricsFloatWindow mScreenWidth: " + this.K + "  mScreenHeight: " + this.L + " mIsListenFloatShowing=" + this.f241010i);
        }
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.S);
        com.tencent.mobileqq.listentogether.lyrics.b bVar = this.f241009h;
        bVar.f241070v = false;
        if (this.f241010i) {
            if (bVar.f241059k && !bVar.f241060l) {
                int i17 = bVar.f241049a;
                int i18 = bVar.f241050b;
                boolean z16 = bVar.f241053e;
                if (bVar.f241056h) {
                    int f16 = this.E.f();
                    int i19 = this.K;
                    z16 = f16 < i19 / 2;
                    if (z16) {
                        i17 = this.I + (this.E.j() / 2);
                    } else {
                        i17 = (i19 - this.G) - (this.E.j() / 2);
                    }
                    this.f241009h.f241058j = false;
                } else if (bVar.f241057i) {
                    if (z16) {
                        j3 = ((this.K / 2) - (this.E.j() / 2)) - (this.F.j() / 2);
                    } else {
                        j3 = (this.K / 2) + (this.E.j() / 2) + (this.F.j() / 2);
                    }
                    i17 = j3;
                    this.f241009h.f241058j = true;
                } else {
                    int i26 = this.F.i();
                    int i27 = this.I;
                    if (i26 <= i27) {
                        i17 = i27 - (this.E.j() / 2);
                        z16 = true;
                    } else {
                        int h16 = this.F.h();
                        int i28 = this.K;
                        int i29 = this.G;
                        if (h16 >= i28 - i29) {
                            i17 = (i28 - i29) + (this.E.j() / 2);
                            z16 = false;
                        }
                    }
                }
                if (i18 < this.J + (this.E.g() / 2)) {
                    i18 = (this.E.g() / 2) + this.J;
                } else if (i18 > (this.L - this.H) - (this.E.g() / 2)) {
                    i18 = (this.L - this.H) - (this.E.g() / 2);
                }
                com.tencent.mobileqq.listentogether.lyrics.b bVar2 = this.f241009h;
                bVar2.f241053e = z16;
                bVar2.f241049a = i17;
                bVar2.f241050b = i18;
            }
            this.E.C(this.f241009h);
            this.F.x(this.f241009h);
            com.tencent.mobileqq.listentogether.lyrics.b bVar3 = this.f241009h;
            if (bVar3.f241059k && !bVar3.f241060l) {
                c0();
            }
            boolean n3 = this.F.n();
            this.F.y(this.f241009h);
            this.E.D(this.f241009h);
            boolean n16 = this.F.n();
            this.f241009h.f241057i = false;
            if (n3 == n16 || !n16 || TextUtils.isEmpty(this.f241005e0)) {
                return;
            }
            Z(this.f241005e0, this.f241003d0);
        }
    }

    private com.tencent.mobileqq.listentogether.lyrics.c u() {
        FloatTextLayout floatTextLayout = this.F;
        if (floatTextLayout != null) {
            return floatTextLayout.s();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w() {
        QQAppInterface qQAppInterface = this.f241002d;
        if (qQAppInterface == null || qQAppInterface.getApp() == null) {
            return false;
        }
        boolean checkPermission = ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(this.f241002d.getApp());
        if (QLog.isColorLevel()) {
            QLog.i("LyricsController", 2, "hasFloatPermission, isOpEnable: " + checkPermission);
        }
        return checkPermission;
    }

    private void y() {
        FloatIconLayout floatIconLayout = this.E;
        if (floatIconLayout != null) {
            floatIconLayout.l();
        }
        FloatTextLayout floatTextLayout = this.F;
        if (floatTextLayout != null) {
            floatTextLayout.l();
        }
        ValueAnimator valueAnimator = this.f241001c0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f241001c0 = null;
        }
    }

    public boolean A(int i3, String str) {
        boolean z16;
        synchronized (this.f241004e) {
            Set<String> set = this.f241004e;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(i3);
            sb5.append("_");
            sb5.append(str);
            z16 = !set.contains(sb5.toString());
        }
        if (QLog.isColorLevel()) {
            QLog.i("LyricsController", 2, "isLyricsTextShowing type:" + i3 + " uin:" + str + " show:" + z16 + " mLyricUserClosedAIOs:" + this.f241004e);
        }
        return z16;
    }

    protected void C() {
        QQAppInterface qQAppInterface = this.f241002d;
        if (qQAppInterface == null) {
            return;
        }
        SharedPreferences preferences = qQAppInterface.getPreferences();
        Set<String> stringSet = preferences.getStringSet("listen_together_lyric_user_closes", null);
        com.tencent.mobileqq.listentogether.lyrics.b bVar = this.f241009h;
        bVar.f241049a = preferences.getInt("listen_together_float_loc_icon_cx", bVar.f241049a);
        com.tencent.mobileqq.listentogether.lyrics.b bVar2 = this.f241009h;
        bVar2.f241050b = preferences.getInt("listen_together_float_loc_icon_cy", bVar2.f241050b);
        com.tencent.mobileqq.listentogether.lyrics.b bVar3 = this.f241009h;
        bVar3.f241053e = preferences.getBoolean("listen_together_float_align_right", bVar3.f241053e);
        synchronized (this.f241004e) {
            if (stringSet != null) {
                if (!stringSet.isEmpty()) {
                    this.f241004e.addAll(stringSet);
                }
            }
        }
    }

    public void E(int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.i("LyricsController", 2, "onDestroyAIO, type:" + i3 + " uin:" + str + ", isForeground: " + this.f241006f + " mFloatParams:" + this.f241009h);
        }
        this.M.remove(i3 + "_" + str);
    }

    public void F(int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.i("LyricsController", 2, "onEnterAIO, type:" + i3 + " uin:" + str + " mFloatParams:" + this.f241009h + " mIsForeground:" + this.f241006f);
        }
        this.f241009h.e(i3, str);
        boolean z16 = !this.f241009h.a(i3, str);
        com.tencent.mobileqq.listentogether.lyrics.b bVar = this.f241009h;
        if (z16 != bVar.f241056h) {
            bVar.f241056h = z16;
            if (this.f241006f) {
                bVar.f241057i = true;
            }
            a0();
        }
        if (BaseActivity.sTopActivity instanceof SplashActivity) {
            this.M.put(i3 + "_" + str, Boolean.TRUE);
        } else {
            this.M.put(i3 + "_" + str, Boolean.FALSE);
        }
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.registerCallBack(this.f240999a0);
        }
    }

    public void G(int i3, String str, boolean z16) {
        FloatTextLayout floatTextLayout;
        Paint.Align align;
        int i16;
        int i17;
        if (QLog.isColorLevel()) {
            QLog.i("LyricsController", 2, "onExitAIO, type:" + i3 + " uin:" + str + ", isForeground: " + this.f241006f + " mFloatParams:" + this.f241009h);
        }
        if (this.f241009h.b(i3, str)) {
            this.f241009h.e(0, null);
            com.tencent.mobileqq.listentogether.lyrics.b bVar = this.f241009h;
            if (!bVar.f241056h) {
                bVar.f241056h = true;
                bVar.f241057i = true;
                bVar.f241070v = false;
                if (this.f241010i && (floatTextLayout = this.F) != null && this.E != null && this.f241006f) {
                    if (bVar.f241053e) {
                        align = Paint.Align.RIGHT;
                    } else {
                        align = Paint.Align.LEFT;
                    }
                    floatTextLayout.K.setAlign(align);
                    int d16 = this.F.d();
                    int d17 = this.E.d();
                    if (this.f241009h.f241053e) {
                        i16 = -this.F.j();
                        i17 = -this.E.j();
                    } else {
                        i16 = this.K;
                        i17 = i16;
                    }
                    FloatTextLayout floatTextLayout2 = this.F;
                    floatTextLayout2.r(i16, floatTextLayout2.e());
                    FloatIconLayout floatIconLayout = this.E;
                    floatIconLayout.r(i17, floatIconLayout.e());
                    this.F.l();
                    com.tencent.mobileqq.listentogether.lyrics.b bVar2 = this.f241009h;
                    bVar2.f241070v = true;
                    bVar2.f241067s = d16;
                    bVar2.f241068t = d17;
                    bVar2.f241069u = Paint.Align.CENTER;
                }
                ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.S);
                ThreadManagerV2.getUIHandlerV2().postDelayed(this.S, z16 ? 500 : 300);
            }
        }
        FloatViewSkin o16 = FloatViewSkin.o();
        FloatIconLayout floatIconLayout2 = this.E;
        com.tencent.mobileqq.listentogether.lyrics.b bVar3 = this.f241009h;
        o16.n(floatIconLayout2, bVar3.f241063o, bVar3.f241062n);
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.unregisterCallback(this.f240999a0);
        }
    }

    public void H(String str, String str2, boolean z16) {
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[5];
            objArr[0] = this.f241005e0;
            objArr[1] = str;
            objArr[2] = Boolean.valueOf(z16);
            objArr[3] = Integer.valueOf(str2 != null ? str2.length() : 0);
            objArr[4] = str2;
            QLog.i("LyricsController", 2, String.format("onGetLyric [pre=%s,next=%s] netErr=%b lyric=%d %s", objArr));
        }
        if (str == null || !str.equals(this.f241005e0)) {
            return;
        }
        this.f241007f0 = str2;
        this.f241008g0 = Boolean.valueOf(z16);
        if (this.f241010i) {
            X(str, str2, z16);
            Z(this.f241005e0, this.f241003d0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P(int i3, String str, boolean z16) {
        synchronized (this.f241004e) {
            String str2 = i3 + "_" + str;
            if (z16) {
                this.f241004e.add(str2);
            } else if (this.f241004e.contains(str2)) {
                this.f241004e.remove(str2);
            }
        }
        O();
    }

    protected void Q() {
        FloatViewSkin.o().i(this);
    }

    public void R(int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.i("LyricsController", 2, "showLyrics, type:" + i3 + " uin:" + str);
        }
        if (!w()) {
            if (this.Q) {
                s();
            }
            this.C = i3;
            this.D = str;
            this.Q = false;
            return;
        }
        if (B()) {
            BaseApplication.getContext().registerReceiver(this.U, new IntentFilter(SkinEngine.ACTION_THEME_INVALIDATE), "com.tencent.msg.permission.pushnotify", null);
        }
        N();
        this.Q = false;
        this.f241011m = false;
        this.V = 0;
        this.C = -1;
        this.D = null;
        if (S(i3, str)) {
            this.f241009h.d(i3, str);
            this.f241010i = true;
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[4];
                objArr[0] = this.f241005e0;
                objArr[1] = com.tencent.mobileqq.listentogether.player.a.a(this.f241003d0);
                String str2 = this.f241007f0;
                objArr[2] = Integer.valueOf(str2 != null ? str2.length() : 0);
                objArr[3] = this.f241008g0;
                QLog.i("LyricsController", 2, String.format("showLyrics[%s %s %d %s]", objArr));
            }
            L(this.f241005e0);
            Boolean bool = this.f241008g0;
            if (bool != null) {
                X(this.f241005e0, this.f241007f0, bool.booleanValue());
            }
            Z(this.f241005e0, this.f241003d0);
            FloatIconLayout floatIconLayout = this.E;
            if (floatIconLayout != null) {
                floatIconLayout.setPlayState(true);
            }
        }
        ((IFloatingState) QRoute.api(IFloatingState.class)).writeState(getClass().getName());
    }

    public void T(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("LyricsController", 2, "tmpGoneForSomePage yes: " + z16);
        }
        com.tencent.mobileqq.listentogether.lyrics.b bVar = this.f241009h;
        if (bVar.f241060l != z16) {
            bVar.f241060l = z16;
            if (this.f241010i) {
                a0();
            }
        }
    }

    public void U(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("LyricsController", 2, "tmpGoneForSomePageDelay yes: " + z16);
        }
        com.tencent.mobileqq.listentogether.lyrics.b bVar = this.f241009h;
        if (bVar.f241060l != z16) {
            bVar.f241060l = z16;
            if (this.f241010i) {
                ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.S);
                ThreadManagerV2.getUIHandlerV2().postDelayed(this.S, 500L);
            }
        }
    }

    public void W(boolean z16) {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.f241000b0);
        if (z16) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(this.f241000b0, 500L);
            return;
        }
        this.f241009h.f241059k = z16;
        if (this.f241010i) {
            a0();
        }
    }

    @Override // com.tencent.mobileqq.listentogether.lyrics.a
    public void a() {
        BaseActivity baseActivity;
        if (QLog.isColorLevel()) {
            QLog.i("LyricsController", 2, "onClickLyrics mIsListenFloatShowing:" + this.f241010i);
        }
        if (this.f241010i) {
            if (this.f241009h.c() && (baseActivity = BaseActivity.sTopActivity) != null) {
                ActionSheet create = ActionSheet.create(baseActivity);
                create.addButton(R.string.irw);
                create.addCancelButton(R.string.cancel);
                create.setOnDismissListener(new j());
                create.setOnCancelListener(new a());
                create.setOnButtonClickListener(new b(create));
                create.show();
                T(true);
                ReportController.o(this.f241002d, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A5C1", 1, 0, "", "", "", "");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("type", 1);
            intent.putExtra("public_fragment_window_feature", 1);
            intent.setFlags(268435456);
            J();
            PublicFragmentActivity.b.a(BaseApplication.getContext(), intent, PublicTransFragmentActivity.class, ListenTogetherOverlayFragment.class);
        }
    }

    @Override // com.tencent.mobileqq.listentogether.lyrics.a
    public void b() {
        if (QLog.isColorLevel()) {
            QLog.i("LyricsController", 2, "onPositionChangeEnd mFloatParams:" + this.f241009h + " mScreenWidth:" + this.K + " mScreenHeight:" + this.L);
        }
        a0();
        O();
    }

    @Override // com.tencent.mobileqq.theme.ListenTogetherTheme.a.InterfaceC8646a
    public void c() {
        if (this.E != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.listentogether.lyrics.LyricsController.16
                @Override // java.lang.Runnable
                public void run() {
                    LyricsController lyricsController = LyricsController.this;
                    FloatIconLayout floatIconLayout = lyricsController.E;
                    if (floatIconLayout != null) {
                        floatIconLayout.x(lyricsController.f241009h.f241066r, FloatViewSkin.o().c());
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.listentogether.lyrics.a
    public void d(int i3, int i16) {
        FloatTextLayout floatTextLayout;
        if (!this.f241010i || (floatTextLayout = this.F) == null) {
            return;
        }
        int j3 = floatTextLayout.j();
        if (QLog.isColorLevel()) {
            QLog.i("LyricsController", 2, "onLyricTextSizeChanged oldWidth:" + j3 + " newWidth:" + i3);
        }
        this.F.setFloatWidth(i3);
        com.tencent.mobileqq.listentogether.lyrics.b bVar = this.f241009h;
        if (bVar.f241058j && !bVar.f241056h) {
            if (bVar.f241053e) {
                bVar.f241049a = ((this.K / 2) - (this.E.j() / 2)) - (this.F.j() / 2);
            } else {
                bVar.f241049a = (this.K / 2) + (this.E.j() / 2) + (this.F.j() / 2);
            }
        }
        FloatTextLayout floatTextLayout2 = this.F;
        floatTextLayout2.r(floatTextLayout2.t(this.f241009h), this.F.u(this.f241009h));
        this.F.b();
    }

    @Override // com.tencent.mobileqq.listentogether.lyrics.a
    public void e(int i3, int i16) {
        int j3;
        if (this.f241010i) {
            com.tencent.mobileqq.listentogether.lyrics.b bVar = this.f241009h;
            int i17 = bVar.f241049a;
            int i18 = bVar.f241050b;
            int i19 = i17 - i3;
            int i26 = this.K;
            if (bVar.f241053e) {
                if (bVar.f241056h && !bVar.f241054f) {
                    j3 = 0 - this.F.j();
                } else {
                    if (!bVar.f241054f) {
                        j3 = 0 - this.F.j();
                        i26 -= this.E.j();
                    }
                    j3 = 0;
                }
            } else {
                if (bVar.f241056h && !bVar.f241054f) {
                    i26 += this.F.j();
                } else if (!bVar.f241054f) {
                    j3 = this.E.j() + 0;
                    i26 += this.F.j();
                }
                j3 = 0;
            }
            if (i19 < j3) {
                i19 = j3;
            } else if (i19 > i26) {
                i19 = i26;
            }
            int i27 = i18 - i16;
            if (i27 < 0) {
                i27 = 0;
            } else {
                int i28 = this.L;
                if (i27 > i28) {
                    i27 = i28;
                }
            }
            com.tencent.mobileqq.listentogether.lyrics.b bVar2 = this.f241009h;
            bVar2.f241058j = false;
            bVar2.f241049a = i19;
            bVar2.f241050b = i27;
            FloatIconLayout floatIconLayout = this.E;
            floatIconLayout.r(floatIconLayout.s(bVar2), this.E.t(this.f241009h));
            FloatTextLayout floatTextLayout = this.F;
            floatTextLayout.r(floatTextLayout.t(this.f241009h), this.F.u(this.f241009h));
            this.E.D(this.f241009h);
            this.F.y(this.f241009h);
        }
    }

    @Override // com.tencent.mobileqq.listentogether.lyrics.a
    public void f() {
        if (this.f241002d != null) {
            com.tencent.mobileqq.listentogether.lyrics.b bVar = this.f241009h;
            int i3 = bVar.f241062n;
            String str = bVar.f241063o;
            this.R = new c();
            ListenTogetherManager.J(this.f241002d).C(i3, str, this.R);
        }
    }

    public void s() {
        final boolean w3 = w();
        this.Q = false;
        if (!w3) {
            if (QLog.isColorLevel()) {
                QLog.i("LyricsController", 2, "checkPermissionAndShowDialog in mIsFirstJoinTipsShowing:" + this.N);
            }
            if (!this.N) {
                N();
                Intent intent = new Intent();
                intent.putExtra("type", 2);
                intent.putExtra("public_fragment_window_feature", 1);
                intent.setFlags(268435456);
                J();
                PublicFragmentActivity.b.a(BaseApplication.getContext(), intent, PublicTransFragmentActivity.class, ListenTogetherOverlayFragment.class);
                this.f241011m = true;
                this.V = 0;
                this.P = false;
            } else {
                this.P = true;
            }
        } else {
            this.P = false;
        }
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.listentogether.lyrics.LyricsController.4
            @Override // java.lang.Runnable
            public void run() {
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "listen_together_float_window_permission_quality", w3, 0L, 0L, (HashMap<String, String>) null, "", false);
            }
        });
    }

    public void t() {
        com.tencent.mobileqq.listentogether.lyrics.b bVar = this.f241009h;
        x(bVar.f241062n, bVar.f241063o);
        FloatIconLayout floatIconLayout = this.E;
        if (floatIconLayout != null) {
            floatIconLayout.destroy();
        }
        FloatTextLayout floatTextLayout = this.F;
        if (floatTextLayout != null) {
            floatTextLayout.destroy();
        }
        QQAppInterface qQAppInterface = this.f241002d;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.T);
        }
        this.f241002d = null;
        V();
    }

    public com.tencent.mobileqq.listentogether.lyrics.b v() {
        return this.f241009h;
    }

    public void x(int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.i("LyricsController", 2, "hideLyrics,  type:" + i3 + " uin:" + str + " mFloatParams:" + this.f241009h);
        }
        if (this.f241009h.a(i3, str)) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.S);
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.W);
            y();
            this.f241010i = false;
            this.f241009h.d(0, null);
            this.C = -1;
            this.D = null;
            this.f241011m = false;
            this.V = 0;
            if (B()) {
                BaseApplication.getContext().unregisterReceiver(this.U);
            }
            V();
            FloatViewSkin.o().q();
            ((IFloatingState) QRoute.api(IFloatingState.class)).removeState(getClass().getName());
        }
    }

    public boolean z() {
        if (QLog.isColorLevel()) {
            QLog.i("LyricsController", 2, "isListenFloatShowing : " + this.f241010i);
        }
        return this.f241010i;
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class c implements com.tencent.mobileqq.listentogether.i {
        c() {
        }

        @Override // com.tencent.mobileqq.listentogether.i
        public void a(boolean z16) {
            String str;
            LyricsController lyricsController = LyricsController.this;
            com.tencent.mobileqq.listentogether.lyrics.b bVar = lyricsController.f241009h;
            int i3 = bVar.f241062n;
            String str2 = bVar.f241063o;
            lyricsController.x(i3, str2);
            ListenTogetherManager.J(LyricsController.this.f241002d).Y0(i3, str2, z16);
            if (i3 == 2 && !TextUtils.isEmpty(str2)) {
                ReportController.o(null, "dc00899", "c2c_AIO", "", "music_tab", "close_tab", 0, 0, str2, "", "", "");
                return;
            }
            if (i3 != 1 || TextUtils.isEmpty(str2)) {
                return;
            }
            TroopInfo k3 = ((TroopManager) LyricsController.this.f241002d.getManager(QQManagerFactory.TROOP_MANAGER)).k(str2);
            if (k3 != null) {
                if (k3.isTroopOwner(LyricsController.this.f241002d.getCurrentUin())) {
                    str = "0";
                } else if (k3.isOwnerOrAdmin()) {
                    str = "1";
                }
                ReportController.o(null, "dc00899", "Grp_AIO", "", "music_tab", "close_tab", 0, 0, str2, "", str, "");
            }
            str = "2";
            ReportController.o(null, "dc00899", "Grp_AIO", "", "music_tab", "close_tab", 0, 0, str2, "", str, "");
        }

        @Override // com.tencent.mobileqq.listentogether.i
        public void onCancel() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class f extends com.tencent.mobileqq.listentogether.e {
        f() {
        }

        @Override // com.tencent.mobileqq.listentogether.e
        protected void d(boolean z16, ListenTogetherSession listenTogetherSession) {
            if (QLog.isColorLevel()) {
                QLog.i("LyricsController", 2, "onFloatNeedShowOrDismiss show:" + z16 + " session:" + listenTogetherSession);
            }
            if (listenTogetherSession == null) {
                return;
            }
            int i3 = listenTogetherSession.f437188e;
            String str = listenTogetherSession.f437189f;
            if (z16) {
                MusicInfo c16 = listenTogetherSession.c();
                String str2 = c16 != null ? c16.C : null;
                LyricsController lyricsController = LyricsController.this;
                com.tencent.mobileqq.listentogether.lyrics.b bVar = lyricsController.f241009h;
                bVar.f241055g = str2;
                bVar.f241066r = listenTogetherSession.W;
                lyricsController.c();
                LyricsController.this.R(i3, str);
                return;
            }
            LyricsController.this.x(i3, str);
        }

        @Override // com.tencent.mobileqq.listentogether.e
        protected void f(String str, String str2, boolean z16) {
            LyricsController.this.H(str, str2, z16);
        }

        @Override // com.tencent.mobileqq.listentogether.e
        protected void p(ISong iSong) {
            if (QLog.isColorLevel()) {
                QLog.i("LyricsController", 2, "onPlayMusicChange song.id:" + iSong.getId());
            }
            LyricsController.this.L(iSong.getId());
            LyricsController.this.f241009h.f241055g = iSong.getAlbum();
            LyricsController.this.a0();
        }

        @Override // com.tencent.mobileqq.listentogether.e
        protected void q(String str, int i3, int i16) {
            LyricsController.this.K(str, i3, i16);
        }

        @Override // com.tencent.mobileqq.listentogether.e
        protected void r(String str, int i3) {
            FloatIconLayout floatIconLayout;
            if (QLog.isColorLevel()) {
                QLog.i("LyricsController", 2, "onPlayStateChange state:" + i3);
            }
            if (i3 == 2) {
                FloatIconLayout floatIconLayout2 = LyricsController.this.E;
                if (floatIconLayout2 != null) {
                    floatIconLayout2.setPlayState(true);
                }
            } else if (i3 == 3) {
                FloatIconLayout floatIconLayout3 = LyricsController.this.E;
                if (floatIconLayout3 != null) {
                    floatIconLayout3.setPlayState(false);
                }
            } else if (i3 == 4 && (floatIconLayout = LyricsController.this.E) != null) {
                floatIconLayout.setPlayState(false);
            }
            LyricsController.this.M(str, i3);
            FloatViewSkin.o().m();
        }

        @Override // com.tencent.mobileqq.listentogether.e
        protected void t() {
            FloatIconLayout floatIconLayout;
            LyricsController lyricsController = LyricsController.this;
            if (!lyricsController.f241010i || (floatIconLayout = lyricsController.E) == null) {
                return;
            }
            floatIconLayout.y();
        }

        @Override // com.tencent.mobileqq.listentogether.e
        protected void l(int i3, String str, boolean z16, boolean z17) {
            boolean z18 = !z16;
            if (QLog.isColorLevel()) {
                QLog.i("LyricsController", 2, "onLyricModuleSwitchChange, newUserClosed:" + z18 + " type:" + i3 + " uin:" + str + " mFloatParams:" + LyricsController.this.f241009h);
            }
            if (LyricsController.this.f241009h.a(i3, str)) {
                LyricsController lyricsController = LyricsController.this;
                com.tencent.mobileqq.listentogether.lyrics.b bVar = lyricsController.f241009h;
                if (bVar.f241054f != z18) {
                    bVar.f241054f = z18;
                    lyricsController.a0();
                    if (!TextUtils.isEmpty(LyricsController.this.f241005e0) && !z18 && z17) {
                        LyricsController lyricsController2 = LyricsController.this;
                        lyricsController2.L(lyricsController2.f241005e0);
                        LyricsController lyricsController3 = LyricsController.this;
                        Boolean bool = lyricsController3.f241008g0;
                        if (bool != null) {
                            lyricsController3.X(lyricsController3.f241005e0, lyricsController3.f241007f0, bool.booleanValue());
                        }
                        LyricsController lyricsController4 = LyricsController.this;
                        lyricsController4.Z(lyricsController4.f241005e0, lyricsController4.f241003d0);
                    }
                }
            }
            if (z17) {
                LyricsController.this.P(i3, str, z18);
            }
        }

        @Override // com.tencent.mobileqq.listentogether.e
        protected void u(ListenTogetherSession listenTogetherSession) {
            if (listenTogetherSession == null) {
                return;
            }
            boolean z16 = listenTogetherSession.f437192m == 2;
            if (QLog.isColorLevel()) {
                QLog.i("LyricsController", 2, "onUIModuleNeedRefresh sessionJoined:" + z16);
            }
            if (z16) {
                MusicInfo c16 = listenTogetherSession.c();
                String str = c16 != null ? c16.C : null;
                LyricsController lyricsController = LyricsController.this;
                com.tencent.mobileqq.listentogether.lyrics.b bVar = lyricsController.f241009h;
                bVar.f241055g = str;
                bVar.f241066r = listenTogetherSession.W;
                lyricsController.c();
                LyricsController.this.a0();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class g extends BroadcastReceiver {
        g() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getIntExtra("pid", Process.myPid()) == Process.myPid()) {
                QLog.i("LyricsController", 1, "onThemeChange.");
                LyricsController.this.D();
            }
        }
    }

    public void I() {
        String str;
        com.tencent.mobileqq.listentogether.lyrics.b bVar = this.f241009h;
        bVar.f241054f = true;
        bVar.f241060l = false;
        a0();
        com.tencent.mobileqq.listentogether.lyrics.b bVar2 = this.f241009h;
        int i3 = bVar2.f241062n;
        String str2 = bVar2.f241063o;
        P(i3, str2, true);
        QQAppInterface qQAppInterface = this.f241002d;
        if (qQAppInterface != null) {
            ((ListenTogetherHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(14, true, new Object[]{Integer.valueOf(i3), str2});
            ((ListenTogetherManager) this.f241002d.getManager(QQManagerFactory.LISTEN_TOGETHER_MANAGER)).K0(i3, str2, "closeLyric", 0);
            if (i3 == 2 && !TextUtils.isEmpty(str2)) {
                ReportController.o(null, "dc00899", "c2c_AIO", "", "music_tab", "clk_close", 0, 0, str2, "", "", "");
                return;
            }
            if (i3 != 1 || TextUtils.isEmpty(str2)) {
                return;
            }
            TroopInfo k3 = ((TroopManager) this.f241002d.getManager(QQManagerFactory.TROOP_MANAGER)).k(str2);
            if (k3 != null) {
                if (k3.isTroopOwner(this.f241002d.getCurrentUin())) {
                    str = "0";
                } else if (k3.isOwnerOrAdmin()) {
                    str = "1";
                }
                ReportController.o(null, "dc00899", "Grp_AIO", "", "music_tab", "clk_close", 0, 0, str2, "", str, "");
            }
            str = "2";
            ReportController.o(null, "dc00899", "Grp_AIO", "", "music_tab", "clk_close", 0, 0, str2, "", str, "");
        }
    }

    public void c0() {
        ValueAnimator valueAnimator = this.f241001c0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f241001c0 = null;
        }
        int s16 = this.E.s(this.f241009h);
        int t16 = this.E.t(this.f241009h);
        int t17 = this.F.t(this.f241009h);
        int u16 = this.F.u(this.f241009h);
        int d16 = this.E.d();
        int e16 = this.E.e();
        int d17 = this.F.d();
        int e17 = this.F.e();
        if (Math.abs(d16 - s16) < 10 && Math.abs(e16 - t16) < 10 && Math.abs(d17 - t17) < 10 && Math.abs(e17 - u16) < 10) {
            this.E.r(s16, t16);
            this.F.r(t17, u16);
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f241001c0 = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.f241001c0.setDuration(250L);
        this.f241001c0.addUpdateListener(new d(d16, s16, e16, t16, d17, t17, e17, u16));
        this.f241001c0.addListener(new e(s16, t16, t17, u16));
        this.f241001c0.start();
    }

    @Override // com.tencent.mobileqq.listentogether.lyrics.a
    public void g() {
        Intent m3;
        if (!this.f241010i || TextUtils.isEmpty(this.f241009h.f241063o)) {
            return;
        }
        com.tencent.mobileqq.listentogether.lyrics.b bVar = this.f241009h;
        int i3 = bVar.f241062n;
        if ((i3 == 2 || i3 == 1) && !bVar.c()) {
            BaseApplication context = BaseApplication.getContext();
            String str = this.f241009h.f241062n + "_" + this.f241009h.f241063o;
            boolean z16 = (BaseActivity.sTopActivity instanceof SplashActivity) && SplashActivity.currentFragment == 1;
            if (!z16 && (!this.M.containsKey(str) || !this.M.get(str).booleanValue())) {
                m3 = BaseAIOUtils.m(new Intent(context, (Class<?>) ChatActivity.class), new int[]{2});
                m3.putExtra(AppConstants.LeftViewText.LEFTVIEWTEXT, "");
            } else {
                m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(context), new int[]{z16 ? 1 : 2});
            }
            m3.putExtra("uin", this.f241009h.f241063o);
            if (this.f241009h.f241062n == 2) {
                m3.putExtra("uintype", 0);
            } else {
                m3.putExtra("uintype", 1);
                m3.putExtra("troop_uin", this.f241009h.f241063o);
            }
            m3.addFlags(268435456);
            context.startActivity(m3);
            QQAppInterface qQAppInterface = this.f241002d;
            if (qQAppInterface != null) {
                ReportController.o(qQAppInterface, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A5C0", FloatViewSkin.o().p() ? 1 : 2, 0, "", "", ff.t(this.f241002d), "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class e extends com.tencent.mobileqq.widget.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f241023d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f241024e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f241025f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f241026h;

        e(int i3, int i16, int i17, int i18) {
            this.f241023d = i3;
            this.f241024e = i16;
            this.f241025f = i17;
            this.f241026h = i18;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            LyricsController.this.E.r(this.f241023d, this.f241024e);
            LyricsController.this.F.r(this.f241025f, this.f241026h);
            LyricsController.this.E.b();
            LyricsController.this.F.b();
            LyricsController.this.f241001c0 = null;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            LyricsController.this.E.r(this.f241023d, this.f241024e);
            LyricsController.this.F.r(this.f241025f, this.f241026h);
            LyricsController.this.E.b();
            LyricsController.this.F.b();
            LyricsController.this.f241001c0 = null;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class h implements Application.ActivityLifecycleCallbacks {
        h() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (QLog.isColorLevel()) {
                QLog.d("LyricsController", 2, "onActivityDestroyed: " + activity.getClass().getName());
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (QLog.isColorLevel()) {
                QLog.d("LyricsController", 2, "onActivityResumed: " + activity.getClass().getName());
            }
            LyricsController lyricsController = LyricsController.this;
            if (!lyricsController.f241011m || lyricsController.f241010i) {
                if (lyricsController.Z) {
                    LyricsController.this.Z = false;
                    LyricsController lyricsController2 = LyricsController.this;
                    lyricsController2.f241006f = true;
                    lyricsController2.W(true);
                    return;
                }
                return;
            }
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(LyricsController.this.W);
            ThreadManagerV2.getUIHandlerV2().postDelayed(LyricsController.this.W, 1000L);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (QLog.isColorLevel()) {
                QLog.d("LyricsController", 2, "onActivityStarted: " + activity.getClass().getName());
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            if (QLog.isColorLevel()) {
                QLog.d("LyricsController", 2, "onActivityStopped: " + activity.getClass().getName());
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class i implements IGuardInterface {
        i() {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            FloatTextLayout floatTextLayout;
            LyricsController lyricsController = LyricsController.this;
            if (lyricsController.f241010i && (floatTextLayout = lyricsController.F) != null && lyricsController.E != null) {
                com.tencent.mobileqq.listentogether.lyrics.b bVar = lyricsController.f241009h;
                if (bVar.f241070v) {
                    floatTextLayout.K.setAlign(bVar.f241069u);
                    LyricsController lyricsController2 = LyricsController.this;
                    FloatTextLayout floatTextLayout2 = lyricsController2.F;
                    floatTextLayout2.r(lyricsController2.f241009h.f241067s, floatTextLayout2.e());
                    LyricsController lyricsController3 = LyricsController.this;
                    FloatIconLayout floatIconLayout = lyricsController3.E;
                    floatIconLayout.r(lyricsController3.f241009h.f241068t, floatIconLayout.e());
                    LyricsController.this.f241009h.f241070v = false;
                }
            }
            LyricsController.this.W(false);
            LyricsController lyricsController4 = LyricsController.this;
            lyricsController4.f241006f = false;
            lyricsController4.Z = false;
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            LyricsController lyricsController = LyricsController.this;
            lyricsController.f241006f = true;
            lyricsController.W(true);
            LyricsController.this.Z = false;
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundTimeTick(long j3) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundUnguardTimeTick(long j3) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onLiteTimeTick(long j3) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onScreensStateChanged(boolean z16) {
        }
    }
}
