package com.tencent.adelie.av.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStub;
import com.tencent.adelie.av.api.impl.AdelieAVActivityApiImpl;
import com.tencent.adelie.av.qav.AdelieAVController;
import com.tencent.adelie.av.qav.a;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.e;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.perf.report.PerfFeature;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.utils.GameActivityStatusWatcher;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.BaseActivity;

/* compiled from: P */
/* loaded from: classes37.dex */
public class AdelieAVActivity extends BaseActivity implements a.InterfaceC0520a {
    private static String P = "AdelieAVActivity";
    private static int Q = 3;
    private static Runnable R;
    private Integer H;
    private Integer I;
    private Integer J;
    private AdelieAVControlUI K;
    private sp.a L;
    private View M;

    /* renamed from: d, reason: collision with root package name */
    private BroadcastReceiver f61378d = null;

    /* renamed from: e, reason: collision with root package name */
    private int f61379e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f61380f = -1;

    /* renamed from: h, reason: collision with root package name */
    private String f61381h = null;

    /* renamed from: i, reason: collision with root package name */
    private String f61382i = null;

    /* renamed from: m, reason: collision with root package name */
    private boolean f61383m = false;
    private boolean C = true;
    private String D = null;
    private long E = 0;
    private String F = null;
    private String G = null;
    private Runnable N = new Runnable() { // from class: com.tencent.adelie.av.ui.AdelieAVActivity.2
        /* JADX WARN: Removed duplicated region for block: B:14:0x0092  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x009d  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            boolean z16;
            AdelieAVActivity adelieAVActivity = AdelieAVActivity.this;
            adelieAVActivity.G = adelieAVActivity.f61381h;
            QLog.i(AdelieAVActivity.P, 1, "mEnterAvRoomRunnable begin isFinishing:" + AdelieAVActivity.this.isFinishing() + " mRoomId:" + AdelieAVActivity.this.G);
            if (TextUtils.isEmpty(AdelieAVActivity.this.G) || !AdelieAVController.J()) {
                return;
            }
            String b16 = up.a.b(11, Long.valueOf(AdelieAVActivity.this.G).longValue());
            up.a E = AdelieAVController.D().E();
            if (E != null && E.f439383b.equalsIgnoreCase(b16)) {
                if (E.e() == 2) {
                    AdelieAVActivity.this.v(5);
                } else if (E.e() == 1) {
                    AdelieAVActivity.this.v(6);
                }
                z16 = false;
                if (z16) {
                    QLog.i(AdelieAVActivity.P, 1, "mEnterAvRoomRunnable already in room");
                    return;
                }
                if (E != null) {
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.adelie.av.ui.AdelieAVActivity.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AdelieAVController.J()) {
                                boolean B = AdelieAVController.D().B();
                                if (QLog.isColorLevel()) {
                                    QLog.d(AdelieAVActivity.P, 2, "mEnterAvRoomRunnable exitRoom isSuccess=" + B);
                                }
                            }
                        }
                    }, 16, null, false);
                    if (QLog.isColorLevel()) {
                        QLog.d(AdelieAVActivity.P, 2, "mEnterAvRoomRunnable exit old session");
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                AdelieAVControlUI.D = System.currentTimeMillis();
                int A = AdelieAVController.D().A(AdelieAVActivity.this.G, AdelieAVActivity.this.f61382i, 1, 8, AdelieAVActivity.this);
                if (QLog.isColorLevel()) {
                    QLog.d(AdelieAVActivity.P, 2, "mEnterAvRoomRunnable enterRoom coast " + (System.currentTimeMillis() - currentTimeMillis) + " retCode=" + A);
                }
                QLog.i(AdelieAVActivity.P, 1, "mEnterAvRoomRunnable end isFinishing:" + AdelieAVActivity.this.isFinishing());
                return;
            }
            z16 = true;
            if (z16) {
            }
        }
    };

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
                GameActivityStatusWatcher.InnerRecevier.SYSTEM_DIALOG_REASON_HOME_KEY.equals(intent.getStringExtra("reason"));
            }
        }
    }

    public AdelieAVActivity() {
        P = "AdelieAVActivity_" + e.d();
    }

    static void o0(Activity activity) {
        LiuHaiUtils.initLiuHaiProperty(activity);
        if (LiuHaiUtils.isLiuHaiUseValid()) {
            int notchInScreenHeight = LiuHaiUtils.getNotchInScreenHeight(activity);
            int statusBarHeight = ImmersiveUtils.getStatusBarHeight(activity);
            boolean enableNotch = LiuHaiUtils.enableNotch(activity);
            QLog.w(ImmersiveUtils.TAG, 1, "initLiuHaiProperty, onAttachedToWindow, notchheight[" + notchInScreenHeight + "], statusBarHeight[" + statusBarHeight + "], isEnableNotch[" + enableNotch + "]");
        }
    }

    private void p0(long j3) {
        Intent intent = super.getIntent();
        this.f61379e = intent.getIntExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 3);
        this.f61380f = intent.getIntExtra("uinType", -1);
        String stringExtra = intent.getStringExtra("uin");
        this.f61381h = stringExtra;
        this.G = stringExtra;
        this.f61382i = intent.getStringExtra("name");
        this.f61383m = intent.getBooleanExtra("receive", false);
        this.C = intent.getBooleanExtra("isAudioMode", true);
        this.D = intent.getStringExtra("extraUin");
        this.E = intent.getLongExtra("main_timestamp", 0L);
        this.F = intent.getStringExtra("from");
        QLog.d(P, 1, "processIntentData mPeerUin=" + this.f61381h + " mPeerName=" + this.f61382i + " mFrom=" + this.F);
    }

    private void q0() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.adelie.av.ui.AdelieAVActivity.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AdelieAVActivity.this.f61378d = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
                    AdelieAVActivity adelieAVActivity = AdelieAVActivity.this;
                    adelieAVActivity.registerReceiver(adelieAVActivity.f61378d, intentFilter);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(AdelieAVActivity.P, 2, "Exception", e16);
                    }
                }
            }
        }, 16, null, false);
    }

    private void r0() {
        BroadcastReceiver broadcastReceiver = this.f61378d;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.f61378d = null;
        }
    }

    public void BtnOnClick(View view) {
        this.K.I(view);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        o0(this);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        QLog.d(P, 1, "onBackPressed");
        AdelieAVControlUI adelieAVControlUI = this.K;
        if (adelieAVControlUI != null) {
            adelieAVControlUI.P();
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onDestroy() {
        Runnable runnable;
        super.onDestroy();
        boolean z16 = !AdelieAVController.J();
        QLog.d(P, 1, "onDestroy isChatFinish=" + z16);
        if (z16 && (runnable = R) != null) {
            ThreadManagerV2.removeJob(runnable, 16);
            R = null;
            QLog.d(P, 1, "onDestroy remove job.");
        }
        r0();
        this.K.S();
        this.K = null;
        this.N = null;
        sp.a aVar = this.L;
        if (aVar != null) {
            aVar.d();
            this.L = null;
        }
        tp.b.f437029a.h(findViewById(R.id.rb9), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.K.T();
        if (getIntent().getIntExtra("hc_code", 0) != 0) {
            HardCoderManager.getInstance().stop(getIntent().getIntExtra("hc_code", 0), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // com.tencent.adelie.av.qav.a.InterfaceC0520a
    public void v(int i3) {
        if (AdelieAVController.J()) {
            up.a E = AdelieAVController.D().E();
            QLog.d(P, 1, "onEnterRoom retCode=" + i3 + " session=" + E);
            if (E != null) {
                E.f439404w = SystemClock.elapsedRealtime();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.requestWindowFeature(1);
        super.onCreate(bundle);
        setRequestedOrientation(1);
        PerfFeature.a(PerfFeature.CustomFlag.AdelieAV);
        long d16 = e.d();
        QLog.d(P, 1, "ADELIE_COST startActivity cost=" + (System.currentTimeMillis() - AdelieAVActivityApiImpl.sPlusPanelClickTime) + "ms");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(P);
        sb5.append("|VideoNodeManager");
        QLog.w(sb5.toString(), 1, "avideo life_onCreate, seq[" + d16 + "], IS_CPU_64_BIT = true needChangeOrientation=");
        setContentView(R.layout.f167473di2);
        this.M = findViewById(R.id.rb9);
        super.getWindow().addFlags(524288);
        super.getWindow().addFlags(2097152);
        super.getWindow().addFlags(128);
        super.getWindow().setSoftInputMode(18);
        AVUtil.t(getWindow(), true);
        AVUtil.u(super.getWindow());
        ImmersiveUtils.setStatusTextColor(false, getWindow());
        if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
            ((ViewStub) findViewById(R.id.rbj)).inflate();
            findViewById(R.id.m18).setVisibility(0);
        }
        AdelieAVFloatWindowManager.z().D();
        p0(d16);
        up.a E = AdelieAVController.D().E();
        if (R == null && (E == null || E.f())) {
            double a16 = rp.a.a();
            if (a16 < 0.0d) {
                a16 = Q;
            }
            long j3 = (long) (1000.0d * a16);
            QLog.d(P, 1, "delay start enter room delay=" + a16 + " delayMs=" + j3);
            R = ThreadManagerV2.executeDelay(this.N, 16, null, false, j3);
        }
        QLog.w(P + "|VideoNodeManager", 1, "avideo life_onCreate AdelieAVSession=" + E);
        q0();
        this.K = new AdelieAVControlUI(this, this.f61381h, this.f61382i);
        sp.a aVar = new sp.a((AppInterface) BaseApplicationImpl.getApplication().getRuntime());
        this.L = aVar;
        aVar.c();
        tp.b bVar = tp.b.f437029a;
        bVar.a(this.M, this.F);
        bVar.h(findViewById(R.id.rb9), true);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 24 || i3 == 25) {
            try {
                if (au.a.d() && au.a.c().isPlayStarted()) {
                    int i16 = i3 == 25 ? -1 : 1;
                    AudioManager audioManager = (AudioManager) BaseApplicationImpl.getApplication().getSystemService("audio");
                    int streamVolume = SystemMethodProxy.getStreamVolume(audioManager, 0);
                    if (this.H == null) {
                        this.H = Integer.valueOf(streamVolume);
                    }
                    int streamMaxVolume = audioManager.getStreamMaxVolume(0);
                    if (this.J == null) {
                        this.J = Integer.valueOf(streamMaxVolume);
                    }
                    audioManager.adjustStreamVolume(0, i16, 1);
                    int streamVolume2 = SystemMethodProxy.getStreamVolume(audioManager, 0);
                    this.I = Integer.valueOf(streamVolume2);
                    if (QLog.isColorLevel()) {
                        QLog.d(P, 2, "adjustStreamVolume. streamType = 0, maxVolume = " + streamMaxVolume + ", oldVolume = " + streamVolume + ", newVolume = " + streamVolume2);
                    }
                    return true;
                }
            } catch (Exception e16) {
                QLog.e(P, 1, "adjustStreamVolume fail.", e16);
            }
        }
        return super.onKeyDown(i3, keyEvent);
    }
}
