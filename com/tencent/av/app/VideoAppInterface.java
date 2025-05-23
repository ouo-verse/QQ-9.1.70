package com.tencent.av.app;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.av.VideoProcessExitMonitor;
import com.tencent.av.VideoRecoveryMonitor;
import com.tencent.av.app.q;
import com.tencent.av.avsdkconfig.pb.CommonConfig$CodecConfigReq;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.av.chatroom.ChatRoomMng;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.AVSoUtils;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.ai;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.avcore.jni.net.NetworkAccelerationAdapterProxy;
import com.tencent.avcore.rtc.node.report.RtcNodeReportManager;
import com.tencent.avcore.rtc.node.report.data.NodeModel$NodeEndReason;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseVideoAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qav.monitor.PhoneStatusAudioModeMonitor;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VideoAppInterface extends BaseVideoAppInterface implements q.a {

    /* renamed from: m0, reason: collision with root package name */
    private static String f73107m0 = "VideoAppInterface";

    /* renamed from: n0, reason: collision with root package name */
    static volatile VideoAppInterface f73108n0;
    protected com.tencent.av.business.manager.c C;
    protected boolean D;
    protected int E;
    public boolean F;
    public boolean G;
    m H;
    n I;
    j J;
    GAccountMonitor K;
    GKillProcessMonitor L;
    p M;
    i N;
    k P;
    l Q;
    q R;
    MobileNetSwitchMonitor S;
    MicrophoneMuteChangeMonitor T;
    ChatRoomMng U;
    xw.b V;
    private VideoProcessExitMonitor W;
    private VideoRecoveryMonitor X;
    private QAVNotifyActionMonitor Y;
    r Z;

    /* renamed from: a0, reason: collision with root package name */
    com.tencent.av.app.a f73109a0;

    /* renamed from: b0, reason: collision with root package name */
    private zw.a f73110b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f73111c0;

    /* renamed from: d, reason: collision with root package name */
    protected Handler f73112d;

    /* renamed from: d0, reason: collision with root package name */
    private final com.tencent.av.opengl.effects.c f73113d0;

    /* renamed from: e, reason: collision with root package name */
    public DeviceCapabilityExamination f73114e;

    /* renamed from: e0, reason: collision with root package name */
    private Runnable f73115e0;

    /* renamed from: f, reason: collision with root package name */
    private EntityManagerFactory f73116f;

    /* renamed from: f0, reason: collision with root package name */
    public long f73117f0;

    /* renamed from: g0, reason: collision with root package name */
    public long f73118g0;

    /* renamed from: h, reason: collision with root package name */
    private cu.a f73119h;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f73120h0;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.av.business.handler.b f73121i;

    /* renamed from: i0, reason: collision with root package name */
    u f73122i0;

    /* renamed from: j0, reason: collision with root package name */
    private Runnable f73123j0;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f73124k0;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f73125l0;

    /* renamed from: m, reason: collision with root package name */
    protected com.tencent.av.business.manager.b f73126m;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class CameraUsageRunnable implements Runnable {
        CameraUsageRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            QLog.w(VideoAppInterface.f73107m0, 1, "CameraUsageRunnable");
            QavCameraUsage.c(VideoAppInterface.this.getApplication(), "CameraUsageRunnable");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            QLog.d(VideoAppInterface.f73107m0, 2, String.format("onReceive action=%s", intent.getAction()));
            System.exit(0);
        }
    }

    public VideoAppInterface(MobileQQ mobileQQ, String str) {
        super(mobileQQ, str);
        this.f73112d = null;
        this.f73116f = null;
        this.D = false;
        this.E = 1;
        this.F = false;
        this.G = false;
        this.f73110b0 = null;
        this.f73111c0 = false;
        this.f73113d0 = new com.tencent.av.opengl.effects.c();
        this.f73115e0 = null;
        this.f73117f0 = 0L;
        this.f73118g0 = 0L;
        this.f73120h0 = false;
        this.f73122i0 = null;
        this.f73123j0 = new Runnable() { // from class: com.tencent.av.app.VideoAppInterface.4
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                if (!Build.MANUFACTURER.toLowerCase().equals("xiaomi")) {
                    ImmersiveUtils.enableStatusBarDarkModeForMIUI = false;
                }
                boolean supportStatusBarDarkMode = ImmersiveUtils.supportStatusBarDarkMode();
                long currentTimeMillis2 = System.currentTimeMillis();
                VideoAppInterface.this.f73123j0 = null;
                QLog.w(VideoAppInterface.f73107m0, 1, "supportStatusBarDarkMode, support[" + supportStatusBarDarkMode + "], start[" + currentTimeMillis + "], cost[" + (currentTimeMillis2 - currentTimeMillis) + "]");
            }
        };
        this.f73124k0 = false;
        this.f73125l0 = false;
        QLog.d(f73107m0, 1, "Create VideoAppInterface.");
        f73108n0 = this;
    }

    private void I0() {
        if (com.tencent.av.utils.e.j() && com.tencent.av.utils.e.e(13) == 1) {
            QLog.d(f73107m0, 1, "onCreate, \u97f3\u89c6\u9891\u8fdb\u7a0b\u5728\u7b49\u5f85\u8c03\u8bd5\u5668\u8fde\u63a5(\u754c\u9762\u4f1a\u65e0\u54cd\u5e94)");
            Debug.waitForDebugger();
        }
    }

    public static VideoAppInterface N() {
        return f73108n0;
    }

    private boolean e0() {
        Context applicationContext;
        AudioManager audioManager;
        PhoneStatusAudioModeMonitor u06;
        if (Build.VERSION.SDK_INT < 31) {
            return false;
        }
        if (com.tencent.av.r.h0() != null && (u06 = com.tencent.av.r.h0().u0()) != null && u06.h()) {
            return ai.j(u06.f());
        }
        MobileQQ application = getApplication();
        if (application == null || (applicationContext = application.getApplicationContext()) == null || (audioManager = (AudioManager) applicationContext.getSystemService("audio")) == null) {
            return false;
        }
        return ai.j(audioManager.getMode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0() {
        AudioManager audioManager = (AudioManager) getApplication().getApplicationContext().getSystemService("audio");
        if (audioManager != null) {
            try {
                audioManager.setSpeakerphoneOn(this.D);
            } catch (NullPointerException unused) {
                AVCoreLog.printAllUserLog(f73107m0, "VideoAppInterface.exit() -> am.setSpeakerphoneOn() catch NullPointerException !");
            }
            audioManager.setMode(this.E);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0() {
        QQBeaconReport.start();
        RtcNodeReportManager.getInstance().init();
        RtcNodeReportManager.getInstance().reportInterrupt(NodeModel$NodeEndReason.K_CRASH.ordinal(), 0L);
        if (hv.a.d() && !NetworkAccelerationAdapterProxy.getInstance().isInit()) {
            NetworkAccelerationAdapterProxy.getInstance().init(new yu.a());
        }
        w();
    }

    private void m() {
        try {
            PowerManager powerManager = (PowerManager) getApp().getSystemService("power");
            if (!powerManager.isScreenOn()) {
                powerManager.newWakeLock(1, "mobileqq:videoapp").acquire(10000L);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void p() {
        ThreadManagerV2.post(this.f73123j0, 10, null, true);
    }

    private void p0() {
        this.K.a();
        this.J.a();
        this.L.g();
        this.M.a();
        this.N.a();
        this.P.b();
        this.I.a();
        this.H.a();
        this.Q.b();
        this.Y.a();
        this.S.f();
        if (AVUtil.l()) {
            this.T.c();
        }
    }

    private void q0() {
        QLog.d(f73107m0, 2, "registerExitProcessReceiver");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.av.exit_process");
        getApp().registerReceiver(new a(), intentFilter);
    }

    private void s() {
        QLog.d(f73107m0, 1, "createVideoController");
        if (com.tencent.av.r.h0() == null) {
            com.tencent.av.r.t();
            com.tencent.av.r.h0().G2(this);
        } else {
            com.tencent.av.r.h0().G2(this);
        }
        com.tencent.av.utils.e.p("VideoAppInterface.onCreate.end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTalkbackSwitch() {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.i(f73107m0, 1, "setTalkbackSwitch");
        }
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.app.getSystemService("accessibility");
            boolean isEnabled = accessibilityManager.isEnabled();
            boolean isTouchExplorationEnabled = accessibilityManager.isTouchExplorationEnabled();
            if (isEnabled && isTouchExplorationEnabled) {
                z16 = true;
            } else {
                z16 = false;
            }
            AppSetting.f99565y = z16;
        } catch (Throwable unused) {
            QLog.e(f73107m0, 1, "setTalkbackSwitch failed");
        }
    }

    private void u0() {
        if (this.f73115e0 == null) {
            this.f73115e0 = new Runnable() { // from class: com.tencent.av.app.VideoAppInterface.7
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoAppInterface.this.f73113d0.i()) {
                        String f16 = VideoAppInterface.this.f73113d0.f();
                        com.tencent.av.ui.f.h(VideoAppInterface.this.getCurrentAccountUin(), f16);
                        VideoAppInterface.this.f73113d0.k();
                        if (QLog.isColorLevel()) {
                            QLog.i(VideoAppInterface.f73107m0, 2, "saveBeautyConfig, config[" + f16 + "]");
                        }
                    }
                    VideoAppInterface.this.f73115e0 = null;
                }
            };
        } else {
            M().removeCallbacks(this.f73115e0);
        }
        M().postDelayed(this.f73115e0, 5000L);
    }

    private void w() {
        AudioManager audioManager = (AudioManager) getApplication().getApplicationContext().getSystemService("audio");
        if (audioManager != null) {
            this.D = audioManager.isSpeakerphoneOn();
            this.E = audioManager.getMode();
        }
    }

    public com.tencent.av.business.manager.c A() {
        return this.C;
    }

    public void A0(int i3, String str) {
        this.Z.N(i3, str);
    }

    public com.tencent.av.business.manager.a B(int i3) {
        return this.f73126m.b(i3);
    }

    public boolean B0() {
        return this.Z.O();
    }

    public synchronized Map<String, Integer> C() {
        return this.Q.a();
    }

    public void C0(String str) {
        this.Z.P(str);
    }

    public ChatRoomMng D() {
        if (this.U == null && isRunning()) {
            this.U = new ChatRoomMng(this);
        }
        return this.U;
    }

    public void D0(String str) {
        List<SimpleAccount> refreAccountList = getApplication().refreAccountList();
        if (refreAccountList != null) {
            for (SimpleAccount simpleAccount : refreAccountList) {
                if (str.equals(simpleAccount.getUin())) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f73107m0, 2, "Switch Account: " + str);
                    }
                    switchAccount(simpleAccount, null);
                    if (com.tencent.av.r.h0() != null) {
                        com.tencent.av.r.h0().N3(str);
                    }
                    com.tencent.av.r.u();
                    return;
                }
            }
        }
    }

    public long[] E(String str) {
        return this.Z.j(str);
    }

    public void E0(long j3) {
        this.Z.Q(j3);
    }

    public long F(String str) {
        return this.Z.i(str);
    }

    public void F0() {
        this.Z.R();
    }

    public String G(int i3, String str, String str2) {
        return this.Z.k(i3, str, str2);
    }

    public synchronized void G0(String str, int i3) {
        this.Q.d(str, i3);
    }

    public String H(int i3, String str, String str2) {
        return this.Z.l(i3, str, str2);
    }

    public void H0() {
        CommonConfig$CodecConfigReq commonConfig$CodecConfigReq = new CommonConfig$CodecConfigReq();
        commonConfig$CodecConfigReq.app_id.set(0L);
        commonConfig$CodecConfigReq.app_version.set(AppSetting.f99551k);
        commonConfig$CodecConfigReq.scenes.set(1);
        commonConfig$CodecConfigReq.platform_chipinfo.set("android_" + Build.HARDWARE + "_" + AVCoreSystemInfo.getCpuModel());
        commonConfig$CodecConfigReq.os_version.set(Integer.toString(Build.VERSION.SDK_INT));
        commonConfig$CodecConfigReq.device_name.set(DeviceInfoMonitor.getModel());
        if (QLog.isColorLevel() || QLog.isDebugVersion()) {
            StringBuilder sb5 = new StringBuilder(50);
            sb5.append("composeRequestIntent\n ");
            sb5.append("app_id:=");
            sb5.append(commonConfig$CodecConfigReq.app_id.get());
            sb5.append("\n");
            sb5.append("app_version:=");
            sb5.append(commonConfig$CodecConfigReq.app_version.get());
            sb5.append("\n");
            sb5.append("scenes:=");
            sb5.append(commonConfig$CodecConfigReq.scenes.get());
            sb5.append("\n");
            sb5.append("chip:=");
            sb5.append(commonConfig$CodecConfigReq.platform_chipinfo.get());
            sb5.append("\n");
            sb5.append("os_version:=");
            sb5.append(commonConfig$CodecConfigReq.os_version.get());
            sb5.append("\n");
            sb5.append("device_name:=");
            sb5.append(commonConfig$CodecConfigReq.device_name.get());
            sb5.append("\n");
            QLog.d(f73107m0, 1, sb5.toString());
        }
        NewIntent newIntent = new NewIntent(this.app, com.tencent.av.t.class);
        newIntent.putExtra("reqType", 24);
        newIntent.putExtra("vMsg", commonConfig$CodecConfigReq.toByteArray());
        startServlet(newIntent);
    }

    public boolean I() {
        return this.Z.m();
    }

    public Bitmap J(int i3, String str, String str2, boolean z16, boolean z17) {
        return this.Z.n(i3, str, str2, z16, z17);
    }

    public int K(int i3, String str) {
        return this.Z.p(i3, str);
    }

    public boolean L() {
        return this.Z.q();
    }

    public Handler M() {
        if (this.f73112d == null) {
            this.f73112d = new Handler(Looper.getMainLooper());
        }
        return this.f73112d;
    }

    public String O(String str) {
        return this.Z.t(str);
    }

    public String P(String str) {
        return this.Z.u(str);
    }

    public VideoProcessExitMonitor Q() {
        return this.W;
    }

    public xw.b R() {
        if (this.V == null) {
            this.V = new xw.b(this);
        }
        return this.V;
    }

    public boolean S() {
        return this.Z.v();
    }

    public VideoRecoveryMonitor T() {
        return this.X;
    }

    public boolean U() {
        return this.Z.w();
    }

    public boolean V(long j3) {
        return this.Z.x(j3);
    }

    public BusinessInfoCheckUpdate.AppInfo W(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("red_touch_app_id", str);
        Bundle s06 = s0(7, 0, 0, bundle, null);
        if (s06 == null) {
            return null;
        }
        s06.setClassLoader(RedAppInfo.class.getClassLoader());
        return com.tencent.mobileqq.redtouch.g.e((RedAppInfo) s06.getParcelable("red_touch_red_app_info"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u X() {
        if (this.f73122i0 == null) {
            this.f73122i0 = new u(this);
        }
        return this.f73122i0;
    }

    public boolean Y(int i3) {
        return this.f73126m.c(i3);
    }

    public boolean Z() {
        com.tencent.av.opengl.effects.c y16 = y();
        if (y16.b("BEAUTY_SKIN") != 0) {
            return true;
        }
        return y16.j();
    }

    public boolean a0() {
        return this.Z.A();
    }

    public void addObserver(Observer observer) {
        if (observer != null) {
            X().addObserver(observer);
            r rVar = this.Z;
            if (rVar != null && rVar.f73199c != null) {
                observer.update(X(), new Object[]{10});
            }
        }
    }

    public boolean b0() {
        if (!this.Z.B() && !e0()) {
            return false;
        }
        return true;
    }

    public boolean c0() {
        return this.Z.B();
    }

    public void deleteObserver(Observer observer) {
        X().deleteObserver(observer);
    }

    public boolean f0() {
        return this.Z.C();
    }

    public boolean g0() {
        return this.Z.D();
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public BaseApplication getApp() {
        return this.app;
    }

    @Override // com.tencent.common.app.AppInterface
    public int getAppid() {
        return AppSetting.f();
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public String getCurrentAccountUin() {
        return getAccount();
    }

    @Override // mqq.app.AppRuntime
    public EntityManagerFactory getEntityManagerFactory(String str) {
        if (this.f73116f == null) {
            this.f73116f = com.tencent.mobileqq.persistence.l.d(getAccount(), super.getEntityManagerFactory());
        }
        return this.f73116f;
    }

    @Override // mqq.app.AppRuntime
    protected Class<? extends MSFServlet>[] getMessagePushServlets() {
        return new Class[]{com.tencent.av.t.class};
    }

    @Override // mqq.app.AppRuntime
    public String getModuleId() {
        return "module_video";
    }

    public void getVideoConfigUpdate() {
        if (QLog.isColorLevel()) {
            QLog.d(f73107m0, 2, "getVideoConfigUpdate");
        }
        NewIntent newIntent = new NewIntent(this.app, com.tencent.mobileqq.servlet.r.class);
        newIntent.putExtra("reqType", 11);
        startServlet(newIntent);
    }

    public void h0(boolean z16) {
        r rVar = this.Z;
        if (rVar != null) {
            rVar.E(z16);
        }
    }

    public boolean isFriend(String str) {
        return this.Z.z(str);
    }

    public void j0(int i3, String str) {
        this.f73126m.d(i3, str);
    }

    public void k0(Object[] objArr) {
        if (objArr != null && objArr.length > 0) {
            X().a(objArr);
        }
    }

    public boolean m0(String str) {
        return this.Z.H(str);
    }

    public void n(long j3, String str, long j16) {
        this.Z.a(j3, str, j16);
    }

    public void n0(String str) {
        this.Z.I(str);
    }

    public void o() {
        this.Z.c();
    }

    public void o0(String str) {
        this.Z.J(str);
    }

    @Override // com.tencent.av.app.q.a
    public void onApnChanged(int i3) {
        if (com.tencent.av.r.h0() != null) {
            com.tencent.av.r.h0().u1(i3);
        }
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onCreate(Bundle bundle) {
        this.f73118g0 = System.currentTimeMillis();
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.av.utils.e.p("VideoAppInterface.onCreate.begin");
        QLog.d(f73107m0, 1, "QAV_COLD_START_COST begin: " + this.f73118g0);
        if (com.tencent.av.utils.e.j()) {
            QLog.setUIN_REPORTLOG_LEVEL(4);
        }
        com.tencent.av.m.a();
        AVSoUtils.g(-1045L);
        this.F = true;
        super.onCreate(bundle);
        I0();
        if (QQAudioHelper.f()) {
            QQAudioHelper.q(BaseApplicationImpl.getApplication(), getLongAccountUin());
        }
        com.tencent.av.utils.e.q(this.app, getLongAccountUin());
        com.tencent.av.utils.e.s(BaseApplication.getContext());
        com.tencent.av.utils.e.p("VideoAppInterface.onCreate.begin1");
        m();
        this.R = new q(this);
        AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.R);
        this.f73119h = new cu.a(this);
        com.tencent.av.business.handler.b bVar = new com.tencent.av.business.handler.b();
        this.f73121i = bVar;
        bVar.a(this.f73119h);
        this.f73126m = new com.tencent.av.business.manager.b(this);
        this.C = new com.tencent.av.business.manager.c(this);
        s();
        this.f73114e = new DeviceCapabilityExamination(this);
        this.J = new j(this);
        this.K = new GAccountMonitor(this);
        this.L = new GKillProcessMonitor(this);
        this.M = new p(this);
        this.N = new i(this);
        this.P = new k(this);
        this.I = new n(this);
        this.H = new m(this);
        this.Q = new l(this);
        this.W = new VideoProcessExitMonitor(this);
        this.X = new VideoRecoveryMonitor(this);
        this.Y = new QAVNotifyActionMonitor(this);
        this.S = new MobileNetSwitchMonitor(this);
        this.T = new MicrophoneMuteChangeMonitor(this);
        r rVar = new r(this);
        this.Z = rVar;
        rVar.y();
        this.Z.c();
        com.tencent.av.app.a aVar = new com.tencent.av.app.a(this);
        this.f73109a0 = aVar;
        aVar.b();
        this.f73110b0 = new zw.a(this);
        zv.b.a().c();
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).registerSyncReceiver();
        ThreadManagerV2.post(new CameraUsageRunnable(), 5, null, true);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.app.VideoAppInterface.1
            @Override // java.lang.Runnable
            public void run() {
                VideoAppInterface.this.l0();
            }
        }, 16, null, true);
        p();
        p0();
        q0();
        ClientLogReport.instance().checkLocalReportRecord();
        if (com.tencent.av.utils.e.e(25) == 1) {
            com.tencent.av.utils.e.x("\u4f7f\u7528\u4e86index_disable_immersive");
            ImmersiveUtils.i_support_immersive = 0;
        }
        z0();
        if (QLog.isDevelopLevel()) {
            QLog.d("IVR_TS_" + f73107m0, 4, String.format("VideoAppInterface onCreate(), cost=%dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        }
        com.tencent.av.utils.e.p("VideoAppInterface.onCreate.end");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onDestroy() {
        if (this.f73115e0 != null) {
            M().removeCallbacks(this.f73115e0);
            this.f73115e0 = null;
        }
        u0();
        this.f73123j0 = null;
        this.f73109a0.d();
        this.Z.S();
        this.Z.R();
        zw.a aVar = this.f73110b0;
        if (aVar != null) {
            aVar.disconnect();
        }
        PtvTemplateManager.f();
        this.I.b();
        this.H.c();
        this.J.b();
        this.K.b();
        this.L.h();
        this.M.b();
        this.N.b();
        this.P.c();
        this.Q.c();
        this.Y.b();
        this.S.h();
        if (AVUtil.l()) {
            this.T.d();
        }
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).unRegisterSyncReceiver();
        du.a.c(getApp());
        this.U = null;
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppRuntime
    public void onRunningForeground() {
        super.onRunningForeground();
        z0();
    }

    public int q(String str) {
        return this.Z.d(str);
    }

    public int r() {
        return X().countObservers();
    }

    public void r0(boolean z16) {
        QLog.d(f73107m0, 1, "reportQuaProcessWakeUp() isBroadcastCreated = " + z16);
        if (z16) {
            this.f73124k0 = true;
        } else {
            this.f73125l0 = true;
        }
        boolean z17 = this.f73124k0;
        if (z17) {
            boolean z18 = this.f73125l0;
            if (z18) {
                com.tencent.av.business.manager.report.a.d(z17, z18);
            } else {
                M().postDelayed(new Runnable() { // from class: com.tencent.av.app.VideoAppInterface.5
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoAppInterface videoAppInterface = VideoAppInterface.this;
                        com.tencent.av.business.manager.report.a.d(videoAppInterface.f73124k0, videoAppInterface.f73125l0);
                    }
                }, 3000L);
            }
        }
    }

    @Override // com.tencent.common.app.AppInterface
    public void receiveToService(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        QLog.d(f73107m0, 2, "receiveToService");
        this.f73119h.d(fromServiceMsg.isSuccess(), toServiceMsg, fromServiceMsg, null);
    }

    public Bundle s0(int i3, int i16, int i17, Bundle bundle, ResultReceiver resultReceiver) {
        return this.Z.K(i3, i16, i17, bundle, resultReceiver);
    }

    @Override // com.tencent.common.app.AppInterface
    public void sendToService(ToServiceMsg toServiceMsg) {
        AVCoreLog.printColorLog(f73107m0, "sendToService");
        this.f73119h.c(toServiceMsg, com.tencent.av.t.class);
    }

    public boolean t(int i3, long j3) {
        return this.Z.e(i3, j3);
    }

    public void t0() {
        y().m();
        u0();
    }

    public void u(long j3, int i3) {
        int i16;
        boolean z16;
        if (i3 < 200) {
            i16 = i3 + 200;
        } else {
            i16 = i3;
        }
        if (i16 == 261) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.w(f73107m0, 1, "video exit, mIsExit[" + this.f73120h0 + "], reason[" + i16 + "], _reason[" + i3 + "], mManagerFactory[" + this.f73126m + "], seq[" + j3 + "]", new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
        this.f73120h0 = true;
        if (com.tencent.av.r.h0() != null && com.tencent.av.n.e().f() != null) {
            if (com.tencent.av.n.e().f().f73029g3) {
                DataReport.T(null, "CliOper", "", "", "0X8008AAD", "0X8008AAD", 0, 0, "", "", "", "");
            } else {
                DataReport.T(null, "CliOper", "", "", "0X8008AAC", "0X8008AAC", 0, 0, "", "", "", "");
            }
        }
        SmallScreenUtils.a(j3, 1, getApplication());
        if (QLog.isDevelopLevel()) {
            AVCoreLog.printAllUserLog(f73107m0, "exit video process clearNotification");
        }
        QQNotificationManager.getInstance().cancel(f73107m0, 235);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.app.t
            @Override // java.lang.Runnable
            public final void run() {
                VideoAppInterface.this.i0();
            }
        }, 16, null, false);
        QAVNotification l3 = QAVNotification.l(this);
        if (l3 != null) {
            l3.g();
        }
        if (QLog.isDevelopLevel()) {
            AVCoreLog.printAllUserLog(f73107m0, "force exit video process ...");
        }
        QLog.flushLog();
        VideoProcessExitMonitor videoProcessExitMonitor = this.W;
        if (videoProcessExitMonitor != null) {
            if (videoProcessExitMonitor.h()) {
                this.W.n(z16);
            }
            if (this.W.k() && com.tencent.av.r.h0() != null) {
                com.tencent.av.r.h0().F2(false);
            }
            if (this.W.l()) {
                M().postDelayed(new Runnable() { // from class: com.tencent.av.app.VideoAppInterface.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.tencent.av.r.h0() != null) {
                            com.tencent.av.r.h0().p3(false);
                        }
                    }
                }, 1500L);
            }
        }
        zw.a aVar = this.f73110b0;
        if (aVar != null) {
            aVar.disconnect();
        }
    }

    public void v(int i3) {
        int i16;
        long d16 = com.tencent.av.utils.e.d();
        QLog.w(f73107m0, 1, "exitVideoProcess, reason[" + i3 + "], VideoController.getInstance()[" + com.tencent.av.r.h0() + "], reason[" + i3 + "], seq[" + d16 + "]");
        switch (i3) {
            case 1000:
                i16 = 254;
                break;
            case 1001:
                i16 = 255;
                break;
            case 1002:
                i16 = 257;
                break;
            case 1003:
                i16 = 256;
                break;
            case 1004:
                i16 = 259;
                break;
            case 1005:
                i16 = 258;
                break;
            default:
                i16 = 260;
                break;
        }
        try {
            if (com.tencent.av.r.h0() != null) {
                int i17 = com.tencent.av.n.e().f().f73043k;
                if (i17 > 0 && i17 <= 4) {
                    String str = com.tencent.av.n.e().f().f73091w;
                    com.tencent.av.r.h0().r(str, i16);
                    com.tencent.av.r.h0().j2(i16);
                    com.tencent.av.r.h0().q(str, 0);
                } else if (com.tencent.av.r.h0().W0()) {
                    com.tencent.av.r.h0().a2(com.tencent.av.r.h0().b0(), com.tencent.av.r.h0().X(), 72);
                }
                com.tencent.av.r.h0().n3(false);
                u(d16, i3);
                return;
            }
            QLog.d(f73107m0, 1, "exitVideoProcess System.exit ");
            QLog.flushLog();
        } catch (Exception unused) {
            QLog.d(f73107m0, 1, "exitVideoProcess Exception System.exit ");
            QLog.flushLog();
        }
    }

    public void v0(boolean z16, Notification notification) {
        this.f73109a0.c(z16, notification);
    }

    public void w0(String str, int i3, boolean z16) {
        y().n(str, i3);
        if (z16) {
            u0();
            if (QLog.isDevelopLevel()) {
                QLog.i(f73107m0, 4, "setBeautyValue name[" + str + "], value[" + i3 + "]");
            }
        }
    }

    public String x(ew.a aVar, int i3) throws NullPointerException {
        return this.Z.f(aVar, i3);
    }

    public void x0(int i3, String str) {
        this.Z.L(i3, str);
    }

    public com.tencent.av.opengl.effects.c y() {
        if (this.f73111c0) {
            return this.f73113d0;
        }
        synchronized (this.f73113d0) {
            if (!this.f73111c0) {
                String a16 = com.tencent.av.ui.f.a(getCurrentAccountUin());
                if (!TextUtils.isEmpty(a16)) {
                    this.f73113d0.l(a16);
                }
                this.f73111c0 = true;
                if (QLog.isColorLevel()) {
                    QLog.i(f73107m0, 2, "getBeautyConfig config[" + a16 + "], level[-1]");
                }
            }
        }
        return this.f73113d0;
    }

    public void y0(int i3, String str, String str2) {
        this.Z.M(i3, str, str2);
    }

    public int z(String str) {
        return y().b(str);
    }

    public void z0() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.app.VideoAppInterface.2
            @Override // java.lang.Runnable
            public void run() {
                VideoAppInterface.this.setTalkbackSwitch();
            }
        }, 16, null, true);
    }
}
