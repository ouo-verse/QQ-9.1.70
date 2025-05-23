package com.tencent.ams.xsad.rewarded.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.ams.xsad.rewarded.RewardedAdData;
import com.tencent.ams.xsad.rewarded.RewardedAdError;
import com.tencent.ams.xsad.rewarded.RewardedAdListener;
import com.tencent.ams.xsad.rewarded.player.DefaultRewardedAdPlayer;
import com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer;
import com.tencent.ams.xsad.rewarded.view.RewardedAdController;
import com.tencent.ams.xsad.rewarded.view.a;
import com.tencent.ams.xsad.rewarded.view.b;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05507;

/* compiled from: P */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class RewardedAdView extends FrameLayout implements RewardedAdPlayer.a, RewardedAdController {
    static IPatchRedirector $redirector_;
    private RewardedAdData C;
    private h D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private long J;
    private AudioManager K;
    private boolean L;
    private BroadcastReceiver M;
    private Application.ActivityLifecycleCallbacks N;

    /* renamed from: d, reason: collision with root package name */
    private Activity f71888d;

    /* renamed from: e, reason: collision with root package name */
    private RewardedAdListener f71889e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f71890f;

    /* renamed from: h, reason: collision with root package name */
    private RewardedAdPlayer f71891h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.ams.xsad.rewarded.view.b f71892i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.ams.xsad.rewarded.view.a f71893m;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RewardedAdView.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && RewardedAdView.this.K != null) {
                if (SystemMethodProxy.getStreamVolume(RewardedAdView.this.K, 3) == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (RewardedAdView.this.f71891h != null) {
                    RewardedAdView.this.f71891h.setOutputMute(z16);
                }
                if (RewardedAdView.this.f71892i != null) {
                    RewardedAdView.this.f71892i.setMute(z16, false);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class b implements Application.ActivityLifecycleCallbacks {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RewardedAdView.this);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) bundle);
                return;
            }
            com.tencent.ams.xsad.rewarded.utils.c.a("RewardedAdView", "onActivityCreated: " + activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
                return;
            }
            com.tencent.ams.xsad.rewarded.utils.c.a("RewardedAdView", "onActivityDestroyed: " + activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
                return;
            }
            com.tencent.ams.xsad.rewarded.utils.c.a("RewardedAdView", "onActivityPaused: " + activity);
            if (RewardedAdView.this.f71888d == activity) {
                if (RewardedAdView.this.f71891h != null) {
                    RewardedAdView.this.f71891h.onActivityPause();
                }
                RewardedAdView.this.G(false);
                if (activity.isFinishing()) {
                    com.tencent.ams.xsad.rewarded.utils.c.a("RewardedAdView", "onActivityPaused: activity is finishing, do close");
                    RewardedAdView.this.u();
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
                return;
            }
            com.tencent.ams.xsad.rewarded.utils.c.a("RewardedAdView", "onActivityResumed: " + activity);
            if (RewardedAdView.this.f71888d == activity) {
                if (com.tencent.ams.xsad.rewarded.c.f().h() == 0) {
                    com.tencent.ams.xsad.rewarded.c.f().o(com.tencent.ams.xsad.rewarded.utils.f.m(RewardedAdView.this.f71888d));
                }
                if (RewardedAdView.this.f71891h != null) {
                    RewardedAdView.this.f71891h.onActivityResume();
                }
                RewardedAdView.this.H(false);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity, (Object) bundle);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
                return;
            }
            com.tencent.ams.xsad.rewarded.utils.c.a("RewardedAdView", "onActivityStarted: " + activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
                return;
            }
            com.tencent.ams.xsad.rewarded.utils.c.a("RewardedAdView", "onActivityStopped: " + activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RewardedAdView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Object tag = view.getTag();
                if ((tag instanceof RewardedAdListener.ClickInfo) && RewardedAdView.this.f71889e != null) {
                    RewardedAdView.this.f71889e.Ab((RewardedAdListener.ClickInfo) tag);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RewardedAdView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (RewardedAdView.this.f71889e != null) {
                    RewardedAdView.this.f71889e.a5();
                }
                RewardedAdView.this.z();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class e implements b.a {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RewardedAdView.this);
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.view.b.a
        public void a(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (RewardedAdView.this.f71891h != null) {
                RewardedAdView.this.f71891h.setOutputMute(z16);
            }
            if (z17 && RewardedAdView.this.f71889e != null) {
                RewardedAdView.this.f71889e.J1(z16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class f implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RewardedAdView.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (RewardedAdView.this.f71889e != null) {
                RewardedAdView.this.f71889e.gb(RewardedAdView.this.f71893m, true);
            }
            RewardedAdView.this.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class g implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RewardedAdView.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            dialogInterface.cancel();
            RewardedAdView.this.H(true);
            if (RewardedAdView.this.f71889e != null) {
                RewardedAdView.this.f71889e.gb(RewardedAdView.this.f71893m, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class h extends CountDownTimer {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private long f71901a;

        h(long j3, long j16) {
            super(j3, j16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, RewardedAdView.this, Long.valueOf(j3), Long.valueOf(j16));
            } else {
                this.f71901a = j3;
            }
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (RewardedAdView.this.f71891h != null && RewardedAdView.this.f71891h.isPlaying()) {
                RewardedAdView.this.J(5000L);
                com.tencent.ams.xsad.rewarded.utils.c.a("RewardedAdView", "timer finish: player is playing, start a new timer");
            } else {
                if (RewardedAdView.this.f71892i != null) {
                    RewardedAdView.this.f71892i.c(0, 0);
                }
                RewardedAdView.this.F();
                com.tencent.ams.xsad.rewarded.utils.c.a("RewardedAdView", "timer finish: player is end, notifyUserEarnedReward");
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, j3);
                return;
            }
            this.f71901a = j3;
            if (RewardedAdView.this.C != null && RewardedAdView.this.f71891h != null) {
                int currentPosition = RewardedAdView.this.f71891h.getCurrentPosition();
                if (RewardedAdView.this.f71892i != null) {
                    int v3 = RewardedAdView.this.v(r6.C.f71690d - currentPosition);
                    int v16 = RewardedAdView.this.v(r0.C.f71693g - currentPosition);
                    RewardedAdView.this.f71892i.c(v3, Math.max(v16, 0));
                    if (v16 <= 0) {
                        RewardedAdView.this.F();
                    }
                }
                if (!RewardedAdView.this.I && currentPosition >= 1000) {
                    if (RewardedAdView.this.f71889e != null) {
                        RewardedAdView.this.f71889e.we();
                    }
                    RewardedAdView.this.I = true;
                }
                if (RewardedAdView.this.f71889e != null) {
                    RewardedAdView.this.f71889e.Od(currentPosition);
                }
                RewardedAdView rewardedAdView = RewardedAdView.this;
                rewardedAdView.J = Math.max(rewardedAdView.J, currentPosition);
            }
        }
    }

    public RewardedAdView(Activity activity, RewardedAdListener rewardedAdListener, boolean z16) {
        super(activity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, rewardedAdListener, Boolean.valueOf(z16));
            return;
        }
        this.M = new a();
        this.N = new b();
        this.f71888d = activity;
        this.f71889e = rewardedAdListener;
        this.f71890f = z16;
        C();
    }

    private String B() {
        int i3;
        RewardedAdData rewardedAdData = this.C;
        String str = "\u81f3\u5c11\u9700\u89c2\u770b__TIME__\u79d2\u5e7f\u544a\u89c6\u9891\u624d\u80fd\u83b7\u5f97\u5956\u52b1\u54e6";
        if (rewardedAdData != null) {
            if (!TextUtils.isEmpty(rewardedAdData.f71692f)) {
                str = this.C.f71692f;
            }
            i3 = v(this.C.f71693g);
        } else {
            i3 = 30;
        }
        return str.replace("__TIME__", String.valueOf(i3));
    }

    private void C() {
        boolean E = E();
        RewardedAdPlayer w3 = w();
        this.f71891h = w3;
        w3.b(getContext(), this);
        this.f71891h.setOutputMute(E);
        this.f71891h.setAutoPlay(true);
        if (com.tencent.ams.xsad.rewarded.c.f().h() == 0) {
            com.tencent.ams.xsad.rewarded.c.f().o(com.tencent.ams.xsad.rewarded.utils.f.m(this.f71888d));
        }
        com.tencent.ams.xsad.rewarded.view.b x16 = x(this);
        this.f71892i = x16;
        x16.setMute(E, false);
        this.f71892i.setActionButtonClickListener(new c());
        this.f71892i.setSkipButtonClickListener(new d());
        this.f71892i.setMuteStatusChangeListener(new e());
        Activity activity = this.f71888d;
        if (activity != null) {
            activity.getApplication().registerActivityLifecycleCallbacks(this.N);
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            getContext().registerReceiver(this.M, intentFilter);
        } catch (Throwable th5) {
            com.tencent.ams.xsad.rewarded.utils.c.b("RewardedAdView", "register volumeReceiver failed", th5);
        }
        setBackgroundColor(-16777216);
    }

    private boolean D() {
        Activity activity;
        Context context = getContext();
        if (!(context instanceof Activity) || (activity = (Activity) context) == null || activity.isDestroyed() || activity.isFinishing()) {
            return false;
        }
        return true;
    }

    private boolean E() {
        AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
        this.K = audioManager;
        if (audioManager == null) {
            return true;
        }
        int streamVolume = SystemMethodProxy.getStreamVolume(audioManager, 3);
        com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdView", "current volume: " + streamVolume);
        if (streamVolume <= 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdView", "notifyUserEarnedReward");
        RewardedAdListener rewardedAdListener = this.f71889e;
        if (rewardedAdListener != null && !this.H) {
            rewardedAdListener.yg(new com.tencent.ams.xsad.rewarded.b());
            this.H = true;
        }
    }

    private void I() {
        com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdView", "showCloseTipsDialog");
        G(true);
        com.tencent.ams.xsad.rewarded.view.a aVar = this.f71893m;
        if (aVar != null) {
            aVar.dismiss();
        }
        if (!D()) {
            return;
        }
        com.tencent.ams.xsad.rewarded.view.a h16 = new a.C0707a(getContext()).e(B()).g("\u7ee7\u7eed\u89c2\u770b", new g()).f("\u5173\u95ed\u5e7f\u544a", new f()).d(false).h();
        this.f71893m = h16;
        RewardedAdListener rewardedAdListener = this.f71889e;
        if (rewardedAdListener != null) {
            rewardedAdListener.S7(h16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(long j3) {
        com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdView", "startTimer: " + j3);
        h hVar = this.D;
        if (hVar != null) {
            hVar.cancel();
        }
        h hVar2 = new h(j3, 200L);
        this.D = hVar2;
        hVar2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdView", QCircleLpReportDc05507.KEY_CLEAR);
        com.tencent.ams.xsad.rewarded.view.a aVar = this.f71893m;
        if (aVar != null) {
            aVar.dismiss();
        }
        RewardedAdPlayer rewardedAdPlayer = this.f71891h;
        if (rewardedAdPlayer != null) {
            rewardedAdPlayer.stop();
            this.f71891h = null;
        }
        Activity activity = this.f71888d;
        if (activity != null) {
            activity.getApplication().unregisterActivityLifecycleCallbacks(this.N);
            this.f71888d = null;
        }
        this.f71889e = null;
        h hVar = this.D;
        if (hVar != null) {
            hVar.cancel();
        }
        this.D = null;
        com.tencent.ams.xsad.rewarded.view.b bVar = this.f71892i;
        if (bVar != null) {
            bVar.clear();
            this.f71892i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int v(long j3) {
        if (j3 < 100) {
            return 0;
        }
        return Double.valueOf(Math.ceil(j3 / 1000.0d)).intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private RewardedAdPlayer w() {
        RewardedAdPlayer rewardedAdPlayer;
        Class<? extends RewardedAdPlayer> c16 = com.tencent.ams.xsad.rewarded.c.f().c();
        if (c16 != null) {
            try {
                rewardedAdPlayer = c16.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable th5) {
                com.tencent.ams.xsad.rewarded.utils.c.b("RewardedAdView", "create ad player failed", th5);
            }
            if (rewardedAdPlayer != null) {
                return new DefaultRewardedAdPlayer();
            }
            return rewardedAdPlayer;
        }
        rewardedAdPlayer = null;
        if (rewardedAdPlayer != null) {
        }
    }

    private com.tencent.ams.xsad.rewarded.view.b x(ViewGroup viewGroup) {
        RewardedAdControllerView rewardedAdControllerView = new RewardedAdControllerView(getContext(), this.f71890f);
        viewGroup.addView(rewardedAdControllerView);
        return rewardedAdControllerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        RewardedAdListener rewardedAdListener = this.f71889e;
        if (rewardedAdListener != null) {
            rewardedAdListener.jb(this.J);
        }
        u();
    }

    public void A(RewardedAdData rewardedAdData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) rewardedAdData);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdView", "doShow");
        if (rewardedAdData == null) {
            com.tencent.ams.xsad.rewarded.utils.c.e("RewardedAdView", "can't set null data");
            return;
        }
        this.C = rewardedAdData;
        com.tencent.ams.xsad.rewarded.view.b bVar = this.f71892i;
        if (bVar != null) {
            bVar.setData(rewardedAdData);
            this.f71892i.c(v(rewardedAdData.f71690d), v(rewardedAdData.f71693g));
            this.f71892i.showLoading();
        }
        if (this.f71891h != null) {
            RewardedAdPlayer.b a16 = RewardedAdPlayer.b.a(rewardedAdData);
            this.f71891h.c(a16);
            this.f71891h.d(this);
            this.f71891h.start();
            com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdView", "start play: " + a16);
        }
    }

    public void G(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdView", "pausePlay, userPause: " + z16);
        if (z16) {
            this.L = true;
        }
        RewardedAdPlayer rewardedAdPlayer = this.f71891h;
        if (rewardedAdPlayer != null && rewardedAdPlayer.isPlaying()) {
            this.f71891h.pause();
            h hVar = this.D;
            if (hVar != null) {
                hVar.cancel();
            }
            RewardedAdListener rewardedAdListener = this.f71889e;
            if (rewardedAdListener != null) {
                rewardedAdListener.onAdPlayPause();
            }
        }
    }

    public void H(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdView", "resumePlay, userResume: " + z16);
        if (z16) {
            this.L = false;
        }
        RewardedAdPlayer rewardedAdPlayer = this.f71891h;
        if (rewardedAdPlayer != null && !this.F && !rewardedAdPlayer.isPlaying() && !this.L) {
            this.f71891h.start();
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdView", "onPlayComplete");
        this.F = true;
        com.tencent.ams.xsad.rewarded.view.b bVar = this.f71892i;
        if (bVar != null) {
            bVar.b();
            this.f71892i.c(0, 0);
            F();
        }
        RewardedAdListener rewardedAdListener = this.f71889e;
        if (rewardedAdListener != null) {
            rewardedAdListener.onAdPlayComplete();
        }
        h hVar = this.D;
        if (hVar != null) {
            hVar.cancel();
        }
        if (this.C != null) {
            this.J = r0.f71690d;
        }
        if (this.f71891h != null) {
            this.J = Math.max(this.J, r0.getDuration());
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.view.RewardedAdController
    public void b(Activity activity, ViewGroup viewGroup, RewardedAdData rewardedAdData, RewardedAdController.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, activity, viewGroup, rewardedAdData, aVar);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdView", "show");
        if (activity != null && rewardedAdData != null && viewGroup != null) {
            viewGroup.addView(this, new ViewGroup.LayoutParams(-1, -1));
            A(rewardedAdData);
            if (aVar != null) {
                aVar.onSuccess();
                return;
            }
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.e("RewardedAdView", "activity or data is null");
        if (aVar != null) {
            aVar.onFailure();
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.view.RewardedAdController
    public long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
        }
        return this.J;
    }

    @Override // com.tencent.ams.xsad.rewarded.view.RewardedAdController
    public void d(com.tencent.ams.xsad.rewarded.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) aVar);
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.view.RewardedAdController
    public int getDisplayType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.ams.xsad.rewarded.view.RewardedAdController
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this;
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer.a
    public void l1(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdView", "onPlayError");
        this.G = true;
        if (this.f71889e != null) {
            RewardedAdError rewardedAdError = new RewardedAdError(205, "play failed");
            rewardedAdError.d(i3);
            this.f71889e.L7(rewardedAdError);
        }
        com.tencent.ams.xsad.rewarded.view.b bVar = this.f71892i;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.view.RewardedAdController
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            z();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) configuration);
            return;
        }
        super.onConfigurationChanged(configuration);
        RewardedAdPlayer rewardedAdPlayer = this.f71891h;
        if (rewardedAdPlayer != null) {
            rewardedAdPlayer.onConfigurationChanged(configuration);
        }
        com.tencent.ams.xsad.rewarded.view.b bVar = this.f71892i;
        if (bVar != null) {
            bVar.onConfigurationChanged(configuration);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdView", NodeProps.ON_DETACHED_FROM_WINDOW);
        u();
        try {
            getContext().unregisterReceiver(this.M);
        } catch (Throwable th5) {
            com.tencent.ams.xsad.rewarded.utils.c.b("RewardedAdView", "unregister volumeReceiver failed", th5);
        }
        super.onDetachedFromWindow();
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer.a
    public void onPlayStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAdView", HippyQQPagView.EventName.ON_PLAY_START);
        com.tencent.ams.xsad.rewarded.view.b bVar = this.f71892i;
        if (bVar != null) {
            bVar.hideLoading();
        }
        if (this.f71891h != null) {
            J(r0.getDuration() - this.f71891h.getCurrentPosition());
        }
        if (!this.E) {
            RewardedAdListener rewardedAdListener = this.f71889e;
            if (rewardedAdListener != null) {
                rewardedAdListener.onAdPlayStart();
            }
            this.E = true;
            return;
        }
        RewardedAdListener rewardedAdListener2 = this.f71889e;
        if (rewardedAdListener2 != null) {
            rewardedAdListener2.onAdPlayResume();
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.view.RewardedAdController
    public void setRewardedAdListener(RewardedAdListener rewardedAdListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) rewardedAdListener);
        } else {
            this.f71889e = rewardedAdListener;
        }
    }

    public void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else if (!this.H && !this.G) {
            I();
        } else {
            y();
        }
    }
}
