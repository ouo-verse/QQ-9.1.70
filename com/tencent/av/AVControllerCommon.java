package com.tencent.av;

import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.tencent.av.QavChannelProxy;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.av.compat.AVCallCompactHelper;
import com.tencent.av.compat.InviteUIChecker;
import com.tencent.av.doodle.DoodleLogic;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.ScreenRecordHelper;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.VideoUtil;
import com.tencent.av.utils.ba;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.Constants;
import com.tencent.avcore.jni.NtrtcVideoRender;
import com.tencent.avcore.jni.audiodevice.TraeConstants;
import com.tencent.avcore.jni.dav.NtrtcAudio;
import com.tencent.avcore.jni.dav.NtrtcEngine;
import com.tencent.avcore.jni.dav.NtrtcUtil;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dt.api.IQSecChannel;
import com.tencent.mobileqq.gamecenter.api.impl.GameCenterCommonApiImpl;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qav.monitor.PhoneStatusAudioModeMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AVControllerCommon implements QavChannelProxy.a {
    private static String J = "AVControllerCommon";
    static volatile AVControllerCommon K;
    public AVCallCompactHelper G;
    ScreenRecordHelper H;
    ScreenShareCtrl I;

    /* renamed from: f, reason: collision with root package name */
    InviteUIChecker f72575f;

    /* renamed from: g, reason: collision with root package name */
    public MqqHandler f72576g;

    /* renamed from: w, reason: collision with root package name */
    com.tencent.av.opengl.effects.m f72592w;

    /* renamed from: y, reason: collision with root package name */
    public PhoneStatusMonitor f72594y;

    /* renamed from: z, reason: collision with root package name */
    PhoneStatusMonitor.a f72595z;

    /* renamed from: a, reason: collision with root package name */
    boolean f72570a = true;

    /* renamed from: c, reason: collision with root package name */
    boolean f72572c = false;

    /* renamed from: d, reason: collision with root package name */
    Runnable f72573d = null;

    /* renamed from: e, reason: collision with root package name */
    public TraeHelper f72574e = null;

    /* renamed from: h, reason: collision with root package name */
    private boolean f72577h = false;

    /* renamed from: i, reason: collision with root package name */
    public int f72578i = 0;

    /* renamed from: j, reason: collision with root package name */
    private PhoneStatusAudioModeMonitor f72579j = null;

    /* renamed from: k, reason: collision with root package name */
    private String f72580k = TraeConstants.DEVICE_NONE;

    /* renamed from: l, reason: collision with root package name */
    boolean f72581l = false;

    /* renamed from: m, reason: collision with root package name */
    int f72582m = 0;

    /* renamed from: n, reason: collision with root package name */
    OrientationEventListener f72583n = null;

    /* renamed from: o, reason: collision with root package name */
    boolean f72584o = false;

    /* renamed from: p, reason: collision with root package name */
    public final p f72585p = new p();

    /* renamed from: q, reason: collision with root package name */
    boolean f72586q = true;

    /* renamed from: r, reason: collision with root package name */
    List<Runnable> f72587r = new ArrayList();

    /* renamed from: s, reason: collision with root package name */
    public boolean f72588s = false;

    /* renamed from: t, reason: collision with root package name */
    public boolean f72589t = false;

    /* renamed from: u, reason: collision with root package name */
    public boolean f72590u = true;

    /* renamed from: v, reason: collision with root package name */
    Runnable f72591v = new Runnable() { // from class: com.tencent.av.AVControllerCommon.1
        @Override // java.lang.Runnable
        public void run() {
            if (QLog.isColorLevel()) {
                QLog.d(AVControllerCommon.J, 2, "networkBrokenRunnable");
            }
            if (n.e().f().f73043k > 0 && n.e().f().f73043k <= 4) {
                DAVController.R().F(n.e().f().f73091w, 215);
                DAVController.R().H0(215);
                DAVController.R().E(n.e().f().f73091w, 9);
            } else {
                MAVController.Y().onGAudioSDKError(MAVController.Y().f72701c, MAVController.Y().f72700b, 15, 0);
            }
            AVControllerCommon.this.f72577h = false;
        }
    };

    /* renamed from: x, reason: collision with root package name */
    final Object f72593x = new Object();
    AudioManager A = null;
    AudioManager.OnAudioFocusChangeListener B = null;
    Runnable C = null;
    int D = r.f74235d;
    Runnable E = new Runnable() { // from class: com.tencent.av.AVControllerCommon.9
        @Override // java.lang.Runnable
        public void run() {
            long y16 = AVControllerCommon.this.y();
            if (y16 > 0) {
                long j3 = y16 % 60;
                if (j3 % 30 == 0) {
                    QAVNotification.l(VideoAppInterface.N()).C(n.e().f().f73030h, n.e().f().f73035i, ba.formatTime(AVControllerCommon.this.y()));
                    if (VideoAppInterface.N().isBackgroundStop && j3 % 10 == 0) {
                        QLog.w(AVControllerCommon.J, 1, "chattingTimerRunnale -->updateNotification() sessionId = " + n.e().f().f73030h);
                    }
                }
            }
            VideoAppInterface.N().M().postDelayed(this, 1000L);
        }
    };
    Runnable F = null;

    /* renamed from: b, reason: collision with root package name */
    public final QavChannelProxy f72571b = new QavChannelProxy(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a extends OrientationEventListener {

        /* renamed from: a, reason: collision with root package name */
        private long f72602a;

        a(Context context, int i3) {
            super(context, i3);
            this.f72602a = 0L;
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i3) {
            if (i3 == -1) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f72602a < 50) {
                return;
            }
            this.f72602a = currentTimeMillis;
            if (i3 <= 315 && i3 > 45) {
                if (i3 > 45 && i3 <= 135) {
                    AVControllerCommon.this.f72582m = 2;
                    return;
                } else if (i3 > 135 && i3 <= 225) {
                    AVControllerCommon.this.f72582m = 3;
                    return;
                } else {
                    AVControllerCommon.this.f72582m = 4;
                    return;
                }
            }
            AVControllerCommon.this.f72582m = 1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static abstract class c implements MediaPlayer.OnCompletionListener {

        /* renamed from: d, reason: collision with root package name */
        public long f72605d = 0;

        public String toString() {
            return "Custom." + this.f72605d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class d implements PhoneStatusMonitor.a {
        public d() {
            if (QLog.isColorLevel()) {
                QLog.d(AVControllerCommon.J, 2, "new QQPhoneStatusListener");
            }
        }

        @Override // com.tencent.av.utils.PhoneStatusMonitor.a
        public void a(boolean z16) {
            boolean z17;
            SessionInfo f16 = n.e().f();
            boolean z18 = f16.N0;
            long d16 = com.tencent.av.utils.e.d();
            if (DAVController.R() == null) {
                QLog.e(AVControllerCommon.J, 1, "onCallStateChanged error. isCalling[" + f16.f73071r);
                return;
            }
            if (QLog.isColorLevel()) {
                String str = AVControllerCommon.J;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onCallStateChanged, isCalling[");
                sb5.append(f16.f73071r);
                sb5.append("->");
                sb5.append(z16);
                sb5.append("], mVcCtrl[");
                if (DAVController.R().f72607a != null) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                sb5.append(z17);
                sb5.append("], sessionInfo state[");
                sb5.append(f16.f73043k);
                sb5.append("], isPeerOnPhone[");
                sb5.append(z18);
                sb5.append("], seq[");
                sb5.append(d16);
                sb5.append("]");
                QLog.w(str, 1, sb5.toString());
            }
            if (DAVController.R().f72607a == null) {
                return;
            }
            if (z16) {
                switch (f16.f73043k) {
                    case 1:
                        DAVController.R().F(f16.f73091w, 218);
                        DAVController.R().H0(218);
                        DAVController.R().E(f16.f73091w, 0);
                        break;
                    case 2:
                        DAVController.R().f72607a.rejectVideo(f16.f73091w, com.tencent.av.app.q.a(), 65535);
                        DAVController.R().F(f16.f73091w, 219);
                        DAVController.R().H0(219);
                        DAVController.R().E(f16.f73091w, 1);
                        break;
                    case 3:
                    case 4:
                    case 9:
                    case 10:
                    case 14:
                        AVControllerCommon.this.O(true);
                        break;
                    case 7:
                        MAVController.Y().l0(d16, MAVController.Y().f72718t, MAVController.Y().f72717s);
                        VideoAppInterface.N().k0(new Object[]{67, Long.valueOf(MAVController.Y().f72717s), 3});
                        break;
                    case 8:
                        MAVController.Y().a1(ba.uinType2AVRelationType(f16.f73067q), f16.P0, 86);
                        VideoAppInterface.N().k0(new Object[]{66, Long.valueOf(f16.P0)});
                        break;
                    case 13:
                        MAVController.Y().l0(d16, 3, Long.valueOf(f16.f73091w).longValue());
                        if (QLog.isColorLevel()) {
                            QLog.e(AVControllerCommon.J, 2, "Reject Video Request when chating");
                            break;
                        }
                        break;
                }
            } else {
                int i3 = f16.f73043k;
                if (i3 == 3 || i3 == 4 || i3 == 9 || i3 == 10) {
                    AVControllerCommon.this.O(false);
                }
            }
            if (!z18) {
                AVControllerCommon.this.R(true, z16);
            }
        }

        protected void finalize() throws Throwable {
            super.finalize();
            if (QLog.isColorLevel()) {
                QLog.d(AVControllerCommon.J, 2, "finalize QQPhoneStatusListener");
            }
        }
    }

    AVControllerCommon() {
        if (AVUtil.p()) {
            this.G = new AVCallCompactHelper();
        }
        this.f72575f = new InviteUIChecker();
        if (QLog.isColorLevel()) {
            QLog.i(J, 2, "AVControllerCommon create.");
        }
        this.f72576g = ThreadManager.getSubThreadHandler();
    }

    public static AVControllerCommon D() {
        return K;
    }

    private void I() {
        if (QLog.isColorLevel()) {
            QLog.d(J, 2, "initOrientationListener");
        }
        a aVar = new a(VideoAppInterface.N().getApp().getApplicationContext(), 3);
        this.f72583n = aVar;
        if (aVar.canDetectOrientation()) {
            if (QLog.isColorLevel()) {
                QLog.d(J, 2, "Can detect orientation");
            }
            this.f72583n.enable();
        } else {
            if (QLog.isColorLevel()) {
                QLog.d(J, 2, "Cannot detect orientation");
            }
            this.f72583n.disable();
            this.f72583n = null;
        }
    }

    private boolean K() {
        int i3;
        WindowManager windowManager = (WindowManager) VideoAppInterface.N().getApp().getApplicationContext().getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i16 = displayMetrics.widthPixels;
        int i17 = displayMetrics.heightPixels;
        int rotation = windowManager.getDefaultDisplay().getRotation();
        if (QLog.isColorLevel()) {
            QLog.d(J, 2, "isLandscape screenWidth: " + i16 + ", screenHeight: " + i17 + ", rotation: " + rotation + ", orientation: " + this.f72582m);
        }
        if (i16 > i17 || rotation == 1 || rotation == 3 || (i3 = this.f72582m) == 4 || i3 == 2) {
            return true;
        }
        return false;
    }

    public static boolean N(Context context) {
        if (context == null) {
            return false;
        }
        return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0070, code lost:
    
        if (r19 == 2) goto L54;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:54:0x0086. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:55:0x0089. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0093 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0096 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0099 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008f A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int n(int i3, boolean z16, int i16) {
        if (z16) {
            if (i3 != 0) {
                if (i3 != 8) {
                    if (i3 != 1004) {
                        if (i3 == 1006) {
                            return 5;
                        }
                        if (i3 != 1021) {
                            if (i3 != 1044) {
                                if (i3 != 9500) {
                                    if (i3 == 1000) {
                                        return 8;
                                    }
                                    if (i3 == 1001) {
                                        return 12;
                                    }
                                    if (i3 != 1010) {
                                        if (i3 != 1011) {
                                            if (i3 != 1024 && i3 != 1025) {
                                                if (i3 != 10002) {
                                                    if (i3 == 10003) {
                                                        return 29;
                                                    }
                                                    switch (i3) {
                                                        case 24:
                                                            return 24;
                                                        case 25:
                                                            return 25;
                                                        case 26:
                                                            return 26;
                                                        default:
                                                            return -1;
                                                    }
                                                }
                                                return 27;
                                            }
                                            return 19;
                                        }
                                        return 21;
                                    }
                                    return 20;
                                }
                            } else {
                                return 30;
                            }
                        } else {
                            return 10;
                        }
                    } else {
                        return 9;
                    }
                }
                return 22;
            }
        } else {
            if (i3 != 0) {
                if (i3 == 12) {
                    return 1001;
                }
                if (i3 != 9500) {
                    if (i3 == 4 || i3 == 5) {
                        return 1006;
                    }
                    if (i3 == 29) {
                        return 10003;
                    }
                    if (i3 != 30) {
                        switch (i3) {
                            case 8:
                                return 1000;
                            case 9:
                                return 1004;
                            case 10:
                                return 1021;
                            default:
                                switch (i3) {
                                    case 19:
                                        return 1025;
                                    case 20:
                                        return 1010;
                                    case 21:
                                        return 1011;
                                    case 22:
                                        return 22;
                                    default:
                                        switch (i3) {
                                            case 27:
                                                return 10002;
                                        }
                                }
                        }
                    }
                    return 1044;
                }
            }
            return 0;
        }
    }

    private void o() {
        if (this.f72592w == null) {
            synchronized (this.f72593x) {
                if (this.f72592w == null) {
                    com.tencent.av.opengl.effects.m mVar = new com.tencent.av.opengl.effects.m(VideoAppInterface.N());
                    this.f72592w = mVar;
                    mVar.h();
                }
            }
            this.f72592w.v(DAVController.R().f72628v);
            this.f72585p.h(this.f72592w);
        }
    }

    public static AVControllerCommon p() {
        if (K == null) {
            synchronized (AVControllerCommon.class) {
                if (K == null) {
                    QLog.d(J, 1, "create AVControllerCommon");
                    K = new AVControllerCommon();
                }
            }
        }
        return K;
    }

    public static void q() {
        K = null;
    }

    public long A() {
        int i3 = n.e().f().f73035i;
        if (i3 != 1 && i3 != 2) {
            if (i3 != 3 && i3 != 4) {
                return 0L;
            }
            return MAVController.Y().V();
        }
        return DAVController.R().O();
    }

    public int B(boolean z16) {
        if (!n.e().f().z() && !MAVController.Y().f72699a) {
            return 255;
        }
        if (n.e().f().f73035i == 1) {
            if (DAVController.R().f72607a != null) {
                return NtrtcAudio.getInstance().getVolume(z16);
            }
        } else if (n.e().f().f73035i == 3) {
            if (MAVController.Y().f72712n != null) {
                return MAVController.Y().f72712n.getVolume();
            }
        } else {
            return NtrtcAudio.getInstance().getVolume(z16);
        }
        return 0;
    }

    public com.tencent.av.opengl.effects.m C(boolean z16) {
        if (!com.tencent.av.opengl.effects.j.D()) {
            return null;
        }
        if (this.f72592w == null && z16) {
            o();
        }
        return this.f72592w;
    }

    public int E() {
        return this.D;
    }

    @Nullable
    public PhoneStatusAudioModeMonitor F() {
        return this.f72579j;
    }

    @TargetApi(21)
    public ScreenRecordHelper G() {
        if (this.H == null) {
            this.H = new ScreenRecordHelper();
        }
        return this.H;
    }

    public ScreenShareCtrl H() {
        if (this.I == null) {
            this.I = new ScreenShareCtrl();
        }
        return this.I;
    }

    public boolean J() {
        boolean N = N(VideoAppInterface.N().getApp().getApplicationContext());
        boolean K2 = K();
        boolean g06 = VideoAppInterface.N().g0();
        if (QLog.isColorLevel()) {
            QLog.d(J, 2, "isGameMode isQQPaused: " + g06 + ", isVideoPaused: " + VideoAppInterface.N().isBackgroundPause + ", isLandscape: " + K2 + ", isScreenLocked: " + N);
        }
        if (!N && K2 && g06 && VideoAppInterface.N().isBackgroundPause) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0061, code lost:
    
        if (r9.f73070q2 >= 100) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0064, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0065, code lost:
    
        r6 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006e, code lost:
    
        if (r9.f73070q2 >= 101) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean L(SessionInfo sessionInfo) {
        if (QLog.isColorLevel()) {
            QLog.i("double_2_multi", 2, "isPeerSupportDoubleSwitchToTroop, start[" + sessionInfo.f73074r2 + "," + sessionInfo.f73070q2 + "]");
        }
        int i3 = sessionInfo.f73074r2;
        if (i3 == -1 || i3 == 0) {
            sessionInfo.f73074r2 = DAVController.R().U(sessionInfo.f73091w);
        }
        int i16 = sessionInfo.f73070q2;
        if (i16 == -1 || i16 == 0) {
            sessionInfo.f73070q2 = DAVController.R().T(sessionInfo.f73091w);
        }
        int i17 = sessionInfo.f73074r2;
        boolean z16 = true;
        boolean z17 = false;
        if (i17 != 2) {
            if (i17 == 4) {
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("double_2_multi", 2, "isPeerSupportDoubleSwitchToTroop, end[" + sessionInfo.f73074r2 + "," + sessionInfo.f73070q2 + "," + z17 + "]");
        }
        return z17;
    }

    public boolean M(int i3, String str, String str2, byte[] bArr, boolean z16, String str3, int i16, int i17) {
        int n3;
        String str4;
        int i18;
        QLog.d(J, 1, "avideo isRequestVideo uinType = " + i3 + ", fromUin = " + str + ", extraUin = " + str2 + ", sig = " + bArr + ", onlyAudio = " + z16 + ", bindID=" + str3 + " ,bindType=" + i16);
        if (VideoAppInterface.N() != null && VideoAppInterface.N().getApp() != null) {
            boolean f16 = this.f72571b.f(str);
            if (i3 == 19 && !TextUtils.isEmpty(str)) {
                n3 = VideoAppInterface.N().q(str);
            } else {
                n3 = n(i3, false, i16);
            }
            if (QLog.isColorLevel()) {
                QLog.d(J, 2, "isRequestVideo converted uinType = " + n3 + ",sdkAVAccostType = " + i3 + "|" + q.f74191b + ", isVideoPaused: " + VideoAppInterface.N().isBackgroundPause);
            }
            if (n.e().c() >= 2) {
                if (QLog.isColorLevel()) {
                    QLog.d(J, 2, "isRequestVideo->pending session exists");
                }
                if (n.e().f() != null) {
                    i18 = n.e().f().f73067q;
                    str4 = n.e().f().f73091w;
                } else {
                    str4 = null;
                    i18 = -1;
                }
                if (n3 != 1011 || i18 != 1011 || str4 == null || !str4.equals(str)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(J, 2, "isRequestVideo->pending session exists, return false");
                    }
                    return false;
                }
            }
            boolean N = N(VideoAppInterface.N().getApp().getApplicationContext());
            if (QLog.isColorLevel()) {
                QLog.d(J, 2, "isRequestVideo->isScreenLocked:" + N);
            }
            if (n.e().f().D()) {
                if (n3 == -1) {
                    return false;
                }
            } else if ((n.e().f().f73043k != 7 || MAVController.Y().f72717s == 0) && n.e().f().f73043k != 14 && n.e().f().f73043k != 13) {
                if (!MAVController.Y().f72699a) {
                    if (QLog.isColorLevel()) {
                        QLog.d(J, 2, "isRequestVideo when chatting: fromUin = " + str + "|" + N);
                    }
                    if (n.e().f().f73091w != null && str.equals(n.e().f().f73091w)) {
                        AVCoreLog.printAllUserLog(J, "isRequestVideo when request: fromUin = " + str);
                        return false;
                    }
                    if (N) {
                        return false;
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(J, 2, "isRequestVideo when in group chat, fromUin = " + str);
                    }
                    if (N) {
                        return false;
                    }
                }
            } else if (N) {
                return false;
            }
            if (VideoAppInterface.N().b0() || f16) {
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.d(J, 2, "isRequestVideo orientation: " + this.f72582m + ", isQQPaused: " + q.f74191b + ", isVideoPaused: " + VideoAppInterface.N().isBackgroundPause + ", isScreenLocked: " + N + ", isAppOnForeground: " + BaseGesturePWDUtil.isAppOnForegroundByTasks(VideoAppInterface.N().getApp().getApplicationContext(), 0));
            }
            return true;
        }
        QLog.d(J, 1, "isRequestVideo  faile,app is null, return false");
        return false;
    }

    public void O(boolean z16) {
        boolean z17;
        if (QLog.isColorLevel()) {
            String str = J;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("notifyAnotherSelfIsRing, isCalling[");
            sb5.append(this.f72581l);
            sb5.append("->");
            sb5.append(z16);
            sb5.append("], mVcCtrl[");
            if (DAVController.R().f72607a != null) {
                z17 = true;
            } else {
                z17 = false;
            }
            sb5.append(z17);
            sb5.append("], sessionInfo SessionType[");
            sb5.append(n.e().f().f73035i);
            sb5.append("], sessionInfo state[");
            sb5.append(n.e().f().f73043k);
            sb5.append("], isPeerOnPhone[");
            sb5.append(n.e().f().N0);
            sb5.append("]");
            QLog.w(str, 1, sb5.toString());
        }
        if (this.f72581l == z16) {
            return;
        }
        this.f72581l = z16;
        if (n.e().f().N0) {
            return;
        }
        if (z16) {
            if (n.e().f().f73043k > 0 && n.e().f().f73043k <= 4) {
                if (!n.e().f().M0 && n.e().f().N) {
                    DAVController.R().w0(n.e().f().f73091w);
                }
                if (!n.e().f().K) {
                    DAVController.R().d1(true, n.e().f().f73091w);
                }
                DAVController.R().e1(false, n.e().f().f73091w);
            } else {
                MAVController.Y().K1("notifyAnotherSelfIsRing", true);
            }
        } else if (n.e().f().f73043k > 0 && n.e().f().f73043k <= 4) {
            if (!n.e().f().M0 && n.e().f().N) {
                DAVController.R().L0(n.e().f().f73091w);
            }
            if (!n.e().f().K) {
                DAVController.R().d1(false, n.e().f().f73091w);
            }
            DAVController.R().e1(true, n.e().f().f73091w);
            S();
        } else {
            MAVController.Y().K1("notifyAnotherSelfIsRing", false);
            if (n.e().f().I0) {
                if (this.C == null) {
                    this.C = new Runnable() { // from class: com.tencent.av.AVControllerCommon.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (n.e().f().I0) {
                                ((AudioManager) VideoAppInterface.N().getApp().getApplicationContext().getSystemService("audio")).setSpeakerphoneOn(true);
                            }
                        }
                    };
                }
                VideoAppInterface.N().M().postDelayed(this.C, 2000L);
            }
        }
        if (DAVController.R().f72607a != null) {
            DAVController.R().f72607a.notifyAnotherSelfIsRing(n.e().f().f73091w, z16);
        }
    }

    public void P(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(J, 2, "onApnChanged netType = " + i3);
        }
        if (this.f72578i != i3) {
            this.f72578i = i3;
            if (i3 == 0) {
                VideoAppInterface.N().M().postDelayed(this.f72591v, 60000L);
            } else {
                VideoAppInterface.N().M().removeCallbacks(this.f72591v);
            }
            if (MAVController.Y().f72712n != null) {
                MAVController.Y().f72712n.setApType(com.tencent.av.app.q.a());
            }
            if (DAVController.R().f72607a != null) {
                NtrtcEngine.getInstance().setApType(com.tencent.av.app.q.a());
            }
            VideoAppInterface.N().k0(new Object[]{21, Integer.valueOf(i3)});
        }
    }

    public void Q(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(J, 2, "onGetQCallNickName nickName : " + str);
        }
        VideoAppInterface.N().k0(new Object[]{600, str});
    }

    public void R(boolean z16, boolean z17) {
        boolean z18;
        String str;
        SessionInfo f16 = n.e().f();
        String str2 = J;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onPhoneCalling, isSelf[");
        sb5.append(z16);
        sb5.append("], isCalling[");
        sb5.append(f16.f73071r);
        sb5.append("->");
        sb5.append(z17);
        sb5.append("], deviceName[");
        sb5.append(f16.F0);
        sb5.append("], audioStateBeforePhoneCall[");
        sb5.append(f16.f73065p1);
        sb5.append("], mTraeHelper[");
        if (this.f72574e != null) {
            z18 = true;
        } else {
            z18 = false;
        }
        sb5.append(z18);
        sb5.append("]");
        QLog.w(str2, 1, sb5.toString());
        TraeHelper traeHelper = this.f72574e;
        if (traeHelper == null) {
            return;
        }
        int i3 = f16.f73043k;
        if (i3 != 0 && i3 != 5 && i3 != 6 && f16.f73071r != z17) {
            f16.f73071r = z17;
            if (z17) {
                traeHelper.m0();
                String str3 = f16.F0;
                f16.f73065p1 = str3;
                this.f72580k = str3;
            } else {
                long d16 = com.tencent.av.utils.e.d();
                boolean equals = TraeConstants.DEVICE_SPEAKERPHONE.equals(f16.f73065p1);
                String str4 = TraeConstants.VIDEO_CALL_CONFIG;
                if (equals) {
                    this.f72574e.h0(d16, TraeConstants.VIDEO_CALL_CONFIG, f16.f73065p1);
                } else if (TraeConstants.DEVICE_EARPHONE.equals(f16.f73065p1)) {
                    this.f72574e.h0(d16, TraeConstants.VOICE_CALL_CONFIG, f16.f73065p1);
                } else {
                    if (f16.f73035i == 1) {
                        str4 = TraeConstants.VOICE_CALL_CONFIG;
                    }
                    if (!TraeConstants.DEVICE_NONE.equals(this.f72580k)) {
                        str = this.f72580k;
                    } else {
                        str = null;
                    }
                    QLog.d(J, 1, "onPhoneCalling, connectDevice[" + str + "] mBeforePhoneCallingSpeakerStatus[" + this.f72580k + "]");
                    this.f72574e.h0(d16, str4, str);
                    this.f72580k = TraeConstants.DEVICE_NONE;
                }
            }
        }
        if (z16) {
            VideoAppInterface.N().k0(new Object[]{22, Boolean.valueOf(z17)});
        } else {
            VideoAppInterface.N().k0(new Object[]{23, Boolean.valueOf(z17)});
        }
    }

    public void S() {
        boolean z16;
        SessionInfo f16 = n.e().f();
        if (f16 != null) {
            int i3 = f16.f73082t2;
            if (i3 == 0) {
                i3 = f16.f73078s2;
            }
            r0(i3);
            if (i3 != 0 && f16.Z1) {
                z16 = true;
            } else {
                z16 = false;
            }
            s(z16);
        }
    }

    public void T() {
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.w(J, 1, "playRecordDing, seq[" + d16 + "]");
        }
        this.f72574e.k0(d16);
        this.f72574e.g0(d16, VideoAppInterface.N(), R.raw.f169420s, null, 1, null);
    }

    public void U() {
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.w(J, 1, "playRecordVoice, seq[" + d16 + "]");
        }
        V(d16, R.raw.f169421t, 1, null);
    }

    public void V(long j3, int i3, int i16, MediaPlayer.OnCompletionListener onCompletionListener) {
        if (QLog.isColorLevel()) {
            QLog.w(J, 1, "playRing, listener[" + onCompletionListener + "], seq[" + j3 + "]");
        }
        D().f72574e.k0(j3);
        if (!D().f72574e.g0(j3, VideoAppInterface.N(), i3, null, i16, onCompletionListener)) {
            AVCoreLog.printAllUserLog(J, "exit !mTraeHelper.startRing");
            DAVController.R().F(n.e().f().f73091w, 212);
            DAVController.R().H0(212);
            DAVController.R().E(n.e().f().f73091w, n.e().f().A0);
        }
        if (n.e().f().N0) {
            AVCoreLog.printAllUserLog(J, "exit SessionMgr.getInstance().getMainSession().isPeerOnPhone");
            DAVController.R().F(n.e().f().f73091w, 213);
            DAVController.R().H0(213);
            DAVController.R().E(n.e().f().f73091w, n.e().f().A0);
        }
    }

    public void W(String str, int i3) {
        ClientLogReport.sGatewayIP = str;
        ClientLogReport.sGatewayPort = i3;
        try {
            this.f72571b.receiveGatewayMsg(str, i3);
            ea.W0(VideoAppInterface.N().getCurrentAccountUin()).edit().putString(q.f74200k, str).apply();
        } catch (UnsatisfiedLinkError e16) {
            AVCoreLog.e(J, "saveGateWayMsg fail.", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X(long j3, boolean z16, int i3, String str, String str2, int i16, String str3, boolean z17) {
        String b16;
        long j16;
        if (QLog.isColorLevel()) {
            QLog.w(J, 1, "reject3rdDoubleCall, isDoubleVideoMeeting[" + z16 + "], uinType[" + i3 + "], fromUin[" + str + "], extraUin[" + str2 + "], bindType[" + i16 + "], bindID[" + str3 + "], onlyAudio[" + z17 + "], seq[" + j3 + "]");
        }
        if (z16) {
            b16 = n.b(100, str, new int[0]);
        } else {
            b16 = n.b(3, str, new int[0]);
        }
        SessionInfo i17 = n.e().i(b16);
        if (i17 == null) {
            i17 = n.e().a(b16, false);
        }
        i17.f73067q = i3;
        i17.B0 = i16;
        i17.D0 = str3;
        i17.G = true;
        u(b16, i3, !z17, str, str2);
        if (z16) {
            try {
                j16 = com.tencent.av.utils.i.g(str);
            } catch (NumberFormatException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(J, 2, "", e16);
                }
                j16 = -1;
            }
            MAVController.Y().l0(j3, 3, j16);
        } else {
            DAVController.R().f72607a.rejectVideo(str, com.tencent.av.app.q.a(), 65536);
        }
        n.e().n(j3, b16);
    }

    public void Y() {
        if (this.f72592w != null) {
            QLog.w(J, 1, "close c2c or group video and release ae and light sdk res");
            this.f72592w.uninit();
            this.f72592w.q();
        }
    }

    public void Z(Class cls) {
        InviteUIChecker inviteUIChecker = this.f72575f;
        if (inviteUIChecker != null) {
            inviteUIChecker.b(cls.getName());
        }
    }

    @Override // com.tencent.av.QavChannelProxy.a
    public boolean a() {
        return MAVController.Y().f72699a;
    }

    public void a0(String str) {
        InviteUIChecker inviteUIChecker = this.f72575f;
        if (inviteUIChecker != null) {
            inviteUIChecker.c(str);
        }
    }

    @Override // com.tencent.av.QavChannelProxy.a
    public void b() {
        if (MAVController.Y().f72712n == null) {
            MAVController.Y().o0();
        }
    }

    public void b0(int i3) {
        String str;
        String str2;
        String str3;
        String str4;
        String valueOf;
        String str5;
        String currentAccountUin;
        String str6;
        QLog.i(J, 1, "reportCameraOpenForSec from: " + i3);
        if (VideoAppInterface.N() == null) {
            QLog.e(J, 1, "reportCameraOpenForSec: VideoAppInterface.getInstance() null");
            return;
        }
        SessionInfo f16 = n.e().f();
        if (f16 == null) {
            QLog.e(J, 1, "reportCameraOpenForSec: sessionInfo null");
            return;
        }
        if (!f16.N) {
            QLog.d(J, 2, "reportCameraOpenForSec intercept: error time");
            return;
        }
        boolean z16 = f16.R;
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        if (z16) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        String valueOf2 = String.valueOf(f16.b());
        if (VideoUtil.g(VideoAppInterface.N(), false) && !f16.f73060o0) {
            if (!f16.z()) {
                QLog.i(J, 1, "reportCameraOpenForSec stop: no connected");
                return;
            }
            if (f16.G) {
                currentAccountUin = f16.f73091w;
                str6 = VideoAppInterface.N().getCurrentAccountUin();
            } else {
                currentAccountUin = VideoAppInterface.N().getCurrentAccountUin();
                str6 = f16.f73091w;
            }
            str4 = currentAccountUin;
            str5 = str6;
            valueOf = "";
        } else {
            if (!f16.U0) {
                QLog.i(J, 1, "reportCameraOpenForSec intercept: no enter room");
                return;
            }
            if (i3 == 0 && f16.V2) {
                QLog.i(J, 1, "reportCameraOpenForSec intercept: duplicate report");
                return;
            }
            if (TextUtils.isEmpty(f16.Y0)) {
                str3 = VideoAppInterface.N().getCurrentAccountUin();
            } else {
                str3 = f16.Y0;
            }
            String valueOf3 = String.valueOf(f16.P0);
            str4 = str3;
            valueOf = String.valueOf(f16.f73063p);
            str5 = valueOf3;
        }
        QLog.i(J, 1, "reportCameraOpenForSec roomId: " + valueOf2 + " businessId: " + valueOf + " cameraId: " + str2 + " cameraType: " + str + " fromUin: " + str4 + " toUin: " + str5);
        ((IQSecChannel) QRoute.api(IQSecChannel.class)).feCameraActionReport(VideoAppInterface.N(), valueOf2, valueOf, str2, str, str4, str5, null);
    }

    @Override // com.tencent.av.QavChannelProxy.a
    public void c(String str, long j3) {
        DAVController.R().i1(str, j3);
    }

    public void c0() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.AVControllerCommon.11
            @Override // java.lang.Runnable
            public void run() {
                AVBizModuleFactory.getModuleByName(Constants.Business.QQ_RTC).requestAVFocus();
            }
        }, 16, null, true);
    }

    @Override // com.tencent.av.QavChannelProxy.a
    public void d() {
        VideoProcessExitMonitor Q;
        if (VideoAppInterface.N() != null && (Q = VideoAppInterface.N().Q()) != null) {
            Q.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d0() {
        QLog.d(J, 1, "requestAudioFoucs");
        if (this.B == null) {
            this.B = new b();
        }
        if (this.A == null) {
            this.A = (AudioManager) VideoAppInterface.N().getApp().getApplicationContext().getSystemService("audio");
        }
        AudioManager audioManager = this.A;
        if (audioManager != null) {
            try {
                int requestAudioFocus = audioManager.requestAudioFocus(this.B, 3, 2);
                if (requestAudioFocus != 1 && QLog.isColorLevel()) {
                    QLog.d("AudioManager", 2, "request audio focus fail. " + requestAudioFocus);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(J, 2, "requestAudioFocus e = " + e16);
                }
            }
        }
        Intent intent = new Intent("tencent.video.v2q.ACTION_NOTIFY_AUDIO_HAS_BEEN_REQUEST_FOCUSED");
        intent.setPackage(VideoAppInterface.N().getApp().getPackageName());
        e0(intent);
    }

    public void e0(final Intent intent) {
        w().post(new Runnable() { // from class: com.tencent.av.AVControllerCommon.10
            @Override // java.lang.Runnable
            public void run() {
                VideoAppInterface.N().getApp().sendBroadcast(intent);
            }
        });
    }

    public void f0(String str, int i3, boolean z16, boolean z17, boolean z18) {
        SessionInfo i16;
        if (VideoAppInterface.N() != null) {
            if (com.tencent.av.utils.e.k()) {
                QLog.w(J, 1, "sendStartVideoBroadcast, sessionId[" + str + "], sessionType[" + i3 + "], updateTime[" + z16 + "], showTime[" + z17 + "], isDouble[" + z18 + "]");
            }
            Intent intent = new Intent();
            intent.setAction(ITroopHWApi.ACTION_START_VIDEO_CHAT);
            intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, i3);
            intent.putExtra("sessionId", str);
            if (n.e() != null && (i16 = n.e().i(str)) != null) {
                intent.putExtra("uinType", i16.f73067q);
                if (i16.f73067q == 26) {
                    intent.putExtra("peerUin", i16.f73103z);
                } else {
                    intent.putExtra("peerUin", i16.f73091w);
                }
                if (i3 == 3 || i3 == 4) {
                    intent.putExtra("peerUin", String.valueOf(i16.P0));
                    intent.putExtra("relationType", i16.S0);
                    intent.putExtra("relationId", i16.P0);
                }
                intent.putExtra("extraUin", i16.f73103z);
                intent.putExtra("bindType", i16.B0);
                intent.putExtra("bindId", i16.D0);
                intent.putExtra("isReceiver", i16.G);
                intent.putExtra("isDoubleVideoMeeting", i16.f73060o0);
                if (!i16.G) {
                    c0();
                }
            }
            intent.putExtra("updateTime", z16);
            intent.putExtra("isDouble", z18);
            intent.putExtra(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME, z17);
            intent.setPackage(VideoAppInterface.N().getApp().getPackageName());
            D().e0(intent);
        }
    }

    public void g() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.AVControllerCommon.12
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AVBizModuleFactory.getModuleByName(Constants.Business.QQ_RTC).abandonAVFocus();
                    AVBizModuleFactory.removeModuleByName(Constants.Business.QQ_RTC);
                } catch (Exception e16) {
                    QLog.e(AVControllerCommon.J, 1, "abandonAVFocusOnSubThread exception:" + e16.toString());
                }
            }
        }, 16, null, true);
    }

    public void g0(String str, String str2, int i3, String str3, String str4, int i16, String str5, boolean z16, boolean z17) {
        SessionInfo sessionInfo;
        String currentAccountUin;
        long j3;
        long y16;
        if (n.e() != null) {
            sessionInfo = n.e().i(str2);
        } else {
            sessionInfo = null;
        }
        if (VideoAppInterface.N() == null) {
            currentAccountUin = "VideoAppInterface.getInstance() is null";
        } else {
            currentAccountUin = VideoAppInterface.N().getCurrentAccountUin();
        }
        QLog.w(J, 1, "sendStopVideoBroadcast[" + str + "], sessionId[" + str2 + "], uinType[" + i3 + "], peerUin[" + str3 + "], extraUin[" + str4 + "], stopReason[" + i16 + "], senderUin[" + str5 + "], isSystemCalling[" + z16 + "], selfUin[" + currentAccountUin + "], isDouble[" + z17 + "], session[" + sessionInfo + "]");
        if (VideoAppInterface.N() != null && sessionInfo != null && DAVController.R().f72607a != null) {
            Intent intent = new Intent();
            intent.setPackage(VideoAppInterface.N().getApp().getPackageName());
            intent.setAction("tencent.av.v2q.StopVideoChat");
            intent.putExtra("sessionId", str2);
            intent.putExtra("uinType", i3);
            intent.putExtra("bindType", sessionInfo.B0);
            intent.putExtra("bindId", sessionInfo.D0);
            intent.putExtra("peerUin", str3);
            intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, sessionInfo.f73035i);
            intent.putExtra("isDoubleVideoMeeting", sessionInfo.f73060o0);
            intent.putExtra("extraUin", str4);
            intent.putExtra("stopReason", i16);
            intent.putExtra("isSystemCalling", z16);
            intent.putExtra("isDouble", z17);
            intent.putExtra("selfUin", VideoAppInterface.N().getCurrentAccountUin());
            intent.putExtra(q.f74198i, sessionInfo.f73100y0);
            intent.putExtra(q.f74199j, SystemClock.elapsedRealtime());
            intent.putExtra(q.f74196g, D().A());
            int i17 = sessionInfo.f73035i;
            long j16 = 1;
            if (i17 != 1 && i17 != 2) {
                j3 = 0;
            } else {
                j3 = 1;
            }
            if (i17 == 3 || i17 == 4) {
                j3 = 2;
            }
            intent.putExtra(q.f74201l, j3);
            if ((j3 == 2 && sessionInfo.f73043k == 9 && !sessionInfo.f73069q1) || (z17 && !sessionInfo.z())) {
                y16 = 0;
            } else {
                y16 = y();
            }
            intent.putExtra("score_connect_duration", y16);
            int i18 = sessionInfo.f73035i;
            if (i18 != 1 && i18 != 3) {
                j16 = 0;
            }
            intent.putExtra(q.f74202m, j16);
            if (n.e().i(str2).f73026g0 != null) {
                intent.putExtra(GameCenterCommonApiImpl.KEY_ACT_ID, n.e().i(str2).f73026g0);
            }
            if (n.e().i(str2).f73031h0 != null) {
                intent.putExtra("mp_ext_params", n.e().i(str2).f73031h0);
            }
            if (!z17) {
                intent.putExtra("relationType", n.e().i(str2).S0);
                intent.putExtra("relationId", n.e().i(str2).P0);
            } else {
                DoodleLogic.b().f73595n.d();
            }
            if (TextUtils.isEmpty(str5)) {
                intent.putExtra(AppConstants.Key.COLUMN_MSG_SENDER_UIN, "");
            } else {
                intent.putExtra(AppConstants.Key.COLUMN_MSG_SENDER_UIN, str5);
            }
            D().e0(intent);
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        QLog.d(J, 1, "abandonAudioFocus");
        AudioManager audioManager = this.A;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(this.B);
            this.A = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0159, code lost:
    
        if (r9.G != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x015b, code lost:
    
        r14 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x015d, code lost:
    
        r14 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0161, code lost:
    
        if (r9.G != false) goto L63;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h0(String str, int i3, int i16, boolean z16, String str2, String str3, boolean z17) {
        Object currentAccountUin;
        boolean z18;
        String str4;
        String str5 = J;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("sendVideoMsgBroadcast uinType: ");
        sb5.append(i3);
        sb5.append(", msgType: ");
        sb5.append(i16);
        sb5.append(", friendUin: ");
        sb5.append(str2);
        sb5.append(", selfUin: ");
        boolean z19 = false;
        if (VideoAppInterface.N() == null) {
            currentAccountUin = 0;
        } else {
            currentAccountUin = VideoAppInterface.N().getCurrentAccountUin();
        }
        sb5.append(currentAccountUin);
        sb5.append(", isReceiver = ");
        sb5.append(n.e().f().G);
        sb5.append(", isVideoMsg = ");
        sb5.append(z16);
        sb5.append(", extraUin: ");
        sb5.append(str3);
        sb5.append(", forceUnread:");
        sb5.append(z17);
        QLog.d(str5, 1, sb5.toString());
        if (!TextUtils.isEmpty(str2) && !"0".equals(str2)) {
            if (VideoAppInterface.N() != null) {
                Intent intent = new Intent();
                intent.setAction("tencent.video.v2q.AddVideoMsg");
                SessionInfo i17 = n.e().i(str);
                if (i17 == null) {
                    QLog.d(J, 1, "sendVideoMsgBroadcast() -> session == null, return!");
                    return;
                }
                if (i16 == 21) {
                    int i18 = i17.f73047l;
                    if (i18 != 11 && i18 != 12) {
                        i16 = 48;
                    } else {
                        i16 = 47;
                    }
                    i17.t0("sendVideoMsgBroadcast", 0);
                } else {
                    if (i16 == 72) {
                        int i19 = i17.f73047l;
                        if (i19 != 16 && i19 != 17) {
                            i16 = 48;
                        } else {
                            i16 = 47;
                        }
                        i17.t0("sendVideoMsgBroadcast", 0);
                    }
                    if ((!i17.u() && i16 == 1) || i17.z()) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (!z17) {
                        z19 = z18;
                    }
                    intent.putExtra("uinType", i3);
                    intent.putExtra(QQBrowserActivity.KEY_MSG_TYPE, i16);
                    intent.putExtra("isVideoMsg", z16);
                    intent.putExtra("isRead", z19);
                    intent.putExtra("bindType", i17.B0);
                    intent.putExtra("bindId", i17.D0);
                    intent.putExtra("isDoubleVideoMeeting", i17.f73060o0);
                    intent.putExtra("MultiAVType", i17.f73063p);
                    if (i16 == 17) {
                        intent.putExtra("msgDetail", Integer.parseInt(str3));
                    }
                    String currentAccountUin2 = VideoAppInterface.N().getCurrentAccountUin();
                    if (i3 != 1004 && i3 != 1000) {
                        if (i3 != 1006) {
                            if (!str2.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                                str2 = str3;
                            }
                        }
                    }
                    if (i16 == 20) {
                        str3 = currentAccountUin2;
                    }
                    if (TextUtils.isEmpty(str3)) {
                        str3 = currentAccountUin2;
                    }
                    if (i17.f73060o0) {
                        if (i17.f73072r0) {
                            str3 = currentAccountUin2;
                        } else {
                            str3 = str2;
                        }
                    }
                    intent.putExtra("friendUin", str2);
                    intent.putExtra(AppConstants.Key.COLUMN_MSG_SENDER_UIN, str3);
                    intent.putExtra("selfUin", currentAccountUin2);
                    intent.putExtra("isSender", !i17.G);
                    if (i17.f73100y0 <= 0) {
                        str4 = ba.formatTime(D().y());
                    } else {
                        str4 = null;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(J, 2, "getConnectedTime():" + D().y() + " extra:" + str4);
                    }
                    intent.putExtra("extra", str4);
                    intent.setPackage(VideoAppInterface.N().getApp().getPackageName());
                    D().e0(intent);
                    return;
                }
                i3 = 0;
                if (!i17.u()) {
                }
                z18 = false;
                if (!z17) {
                }
                intent.putExtra("uinType", i3);
                intent.putExtra(QQBrowserActivity.KEY_MSG_TYPE, i16);
                intent.putExtra("isVideoMsg", z16);
                intent.putExtra("isRead", z19);
                intent.putExtra("bindType", i17.B0);
                intent.putExtra("bindId", i17.D0);
                intent.putExtra("isDoubleVideoMeeting", i17.f73060o0);
                intent.putExtra("MultiAVType", i17.f73063p);
                if (i16 == 17) {
                }
                String currentAccountUin22 = VideoAppInterface.N().getCurrentAccountUin();
                if (i3 != 1004) {
                    if (i3 != 1006) {
                    }
                }
                if (i16 == 20) {
                }
                if (TextUtils.isEmpty(str3)) {
                }
                if (i17.f73060o0) {
                }
                intent.putExtra("friendUin", str2);
                intent.putExtra(AppConstants.Key.COLUMN_MSG_SENDER_UIN, str3);
                intent.putExtra("selfUin", currentAccountUin22);
                intent.putExtra("isSender", !i17.G);
                if (i17.f73100y0 <= 0) {
                }
                if (QLog.isColorLevel()) {
                }
                intent.putExtra("extra", str4);
                intent.setPackage(VideoAppInterface.N().getApp().getPackageName());
                D().e0(intent);
                return;
            }
            return;
        }
        QLog.i(J, 1, "sendVideoMsgBroadcast, invalid uin[" + str2 + "]");
    }

    public void i(String str) {
        if (QLog.isColorLevel()) {
            QLog.w(J, 1, "cancelNetWorkTimer[" + str + "]");
        }
        this.f72577h = false;
        if (VideoAppInterface.N() != null) {
            VideoAppInterface.N().M().removeCallbacks(this.f72591v);
        }
        PopupDialog.g0();
    }

    public void i0(boolean z16) {
        VideoProcessExitMonitor Q;
        if (VideoAppInterface.N() != null && (Q = VideoAppInterface.N().Q()) != null) {
            Q.r(z16);
        }
    }

    public boolean j(String str, boolean z16, int i3, String str2) {
        String b16;
        SessionInfo f16 = n.e().f();
        boolean z17 = false;
        if (z16) {
            if (i3 == 3) {
                b16 = n.b(100, str2, new int[0]);
            } else {
                b16 = n.b(i3, str2, new int[0]);
            }
        } else {
            b16 = n.b(i3, str2, new int[0]);
        }
        if (!TextUtils.equals(f16.f73030h, b16)) {
            z17 = n.e().o(b16);
            QLog.i(J, 1, "checkMainSession, need reset main session, from[" + str + "], cur" + f16.f73030h + "], coming[" + b16 + "], ret[" + z17 + "]");
        }
        if (QLog.isColorLevel()) {
            QLog.i(J, 2, "checkMainSession, from[" + str + "], isFromMAVEngine[" + z16 + "], relationType[" + i3 + "], relationId[" + str2 + "], ret[" + z17 + "]");
        }
        return z17;
    }

    public void j0(boolean z16) {
        VideoProcessExitMonitor Q;
        if (VideoAppInterface.N() != null && (Q = VideoAppInterface.N().Q()) != null) {
            Q.s(z16);
        }
    }

    public boolean k(String str, SessionInfo sessionInfo) {
        boolean z16;
        if (sessionInfo == null) {
            return false;
        }
        int l3 = sessionInfo.l();
        long b16 = sessionInfo.b();
        long a16 = sessionInfo.a();
        if (l3 == 2) {
            long P = DAVController.R().P(sessionInfo);
            if (P != sessionInfo.b()) {
                sessionInfo.d(P);
            }
        } else if (l3 == 1) {
            long W = MAVController.Y().W(sessionInfo);
            if (W != sessionInfo.b()) {
                sessionInfo.d(W);
            }
        }
        long b17 = sessionInfo.b();
        long a17 = sessionInfo.a();
        if (b16 == b17 && a16 == a17) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ChatRoomUtil", 2, String.format("checkRoomIdChange, from[%s], ret[%s], session[%s], pre[%s, %s], cur[%s, %s]", str, Boolean.valueOf(z16), sessionInfo, Long.valueOf(b16), Long.valueOf(a16), Long.valueOf(b17), Long.valueOf(a17)));
        }
        return z16;
    }

    public void k0(VideoAppInterface videoAppInterface) {
        this.f72571b.t(VideoAppInterface.N());
        this.f72595z = new d();
        if (Build.VERSION.SDK_INT >= 31) {
            PhoneStatusAudioModeMonitor phoneStatusAudioModeMonitor = new PhoneStatusAudioModeMonitor();
            this.f72579j = phoneStatusAudioModeMonitor;
            phoneStatusAudioModeMonitor.i(this.f72595z);
        }
        VideoAppInterface.N().M().post(new Runnable() { // from class: com.tencent.av.AVControllerCommon.2
            @Override // java.lang.Runnable
            public void run() {
                AVControllerCommon.this.f72594y = new PhoneStatusMonitor(VideoAppInterface.N().getApp().getApplicationContext(), AVControllerCommon.this.f72595z);
            }
        });
        if (!NetworkUtil.isNetSupport(VideoAppInterface.N().getApp().getApplicationContext())) {
            this.f72578i = 0;
        } else if (NetworkUtil.isWifiEnabled(VideoAppInterface.N().getApp().getApplicationContext())) {
            this.f72578i = 1;
        } else {
            this.f72578i = 2;
        }
        DAVController.R().Z();
        if (MAVController.Y().F == 0 && SmallScreenUtils.i(VideoAppInterface.N().getApp())) {
            MAVController.Y().F = 1;
        }
        this.f72574e = TraeHelper.G(VideoAppInterface.N().getApp().getApplicationContext());
        if (this.f72584o) {
            I();
        }
        if (DAVController.R().f72607a != null) {
            NtrtcUtil.getInstance().updateProcessInfo(0L, "qqVersion", AppSetting.j(VideoAppInterface.N().getApp().getApplicationContext()));
        }
        com.tencent.av.opengl.effects.m mVar = this.f72592w;
        if (mVar != null) {
            mVar.M(VideoAppInterface.N());
        }
    }

    @TargetApi(21)
    public boolean l() {
        ScreenRecordHelper screenRecordHelper = this.H;
        if (screenRecordHelper != null && screenRecordHelper.m()) {
            return true;
        }
        return false;
    }

    public void l0(boolean z16) {
        int i3;
        if (z16) {
            i3 = 5;
        } else {
            i3 = 0;
        }
        int i16 = n.e().f().f73035i;
        if (i16 != 1 && i16 != 2) {
            if (i16 == 3 || i16 == 4) {
                if (MAVController.Y().f72712n != null) {
                    MAVController.Y().f72712n.setAudioScene(i3);
                    QLog.d(J, 1, "multi setAudioScene " + z16);
                    return;
                }
                QLog.e(J, 1, "multi setAudioScene " + z16 + " error.");
                return;
            }
            return;
        }
        if (DAVController.R().f72607a != null) {
            NtrtcAudio.getInstance().setAudioScene(i3);
            QLog.d(J, 1, "double setAudioScene " + z16);
            return;
        }
        QLog.e(J, 1, "double setAudioScene " + z16 + " error.");
    }

    public void m(boolean z16, int i3, int... iArr) {
        long d16 = com.tencent.av.utils.e.d();
        SessionInfo f16 = n.e().f();
        if (f16.f73043k == 0) {
            return;
        }
        QAVNotification l3 = QAVNotification.l(VideoAppInterface.N());
        if (l3 != null) {
            l3.f(f16.f73030h);
        }
        QLog.w(J, 1, "closeMainSession, mGAudioInRoom[" + MAVController.Y().f72699a + "], isDoubleVideoMeeting[" + f16.f73060o0 + "], \nsession[" + f16 + "], \nseq[" + d16 + "]");
        int i16 = f16.f73035i;
        if (i16 != 3 && i16 != 4) {
            if (i16 == 1 || i16 == 2) {
                int i17 = f16.f73043k;
                if (i17 != 2 && i17 != 13) {
                    if (f16.f73060o0) {
                        if (z16) {
                            VideoAppInterface.N().k0(new Object[]{28, f16.f73091w, Boolean.TRUE});
                        }
                        MAVController.Y().Y0(d16, Long.valueOf(f16.f73091w).longValue(), true, 0);
                        return;
                    } else {
                        DAVController.R().F(f16.f73091w, i3);
                        DAVController.R().E(f16.f73091w, 0);
                        n0(d16, 2, true, true);
                        return;
                    }
                }
                if (f16.f73060o0) {
                    DAVController.R().z(d16, f16.f73091w, 1, true);
                    long longValue = Long.valueOf(f16.f73091w).longValue();
                    MAVController.Y().l0(d16, 3, longValue);
                    MAVController.Y().z(d16, longValue, 1);
                    return;
                }
                DAVController.R().z(d16, f16.f73091w, 1, false);
                DAVController.R().F(f16.f73091w, i3);
                DAVController.R().E(f16.f73091w, 0);
                return;
            }
            return;
        }
        if (MAVController.Y().f72699a) {
            if (z16) {
                VideoAppInterface.N().k0(new Object[]{28, String.valueOf(f16.P0), Boolean.TRUE});
            }
            if (f16.f73060o0) {
                MAVController.Y().Y0(d16, MAVController.Y().f72700b, true, 0);
            } else {
                MAVController.Y().a1(MAVController.Y().f72701c, MAVController.Y().f72700b, 30);
            }
        }
    }

    public int m0(boolean z16) {
        if (z16) {
            ((VideoNodeReporter) VideoAppInterface.N().B(4)).x();
        } else {
            Iterator<Runnable> it = this.f72587r.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
            this.f72587r.clear();
        }
        this.f72586q = z16;
        return 0;
    }

    public void n0(long j3, int i3, boolean z16, boolean z17) {
        boolean z18;
        if (i3 != 4 && i3 != 3 && ((i3 != 2 && i3 != 1) || !n.e().f().f73060o0)) {
            z18 = false;
        } else {
            z18 = true;
        }
        QLog.w(J, 1, "setEncodeDecodePtr, sessionType[" + i3 + "], clean[" + z16 + "], isRemote[" + z17 + "], isMultiEngine[" + z18 + "], seq[" + j3 + "]");
        if (z18) {
            if (MAVController.Y().f72712n != null) {
                NtrtcVideoRender.getInstance().setEngineFlag(true);
            }
        } else if (DAVController.R().f72607a != null) {
            NtrtcVideoRender.getInstance().setEngineFlag(false);
        }
    }

    public void o0(boolean z16) {
        int i3;
        if (z16) {
            i3 = r.f74236e;
        } else {
            i3 = r.f74237f;
        }
        if (this.D != i3) {
            this.D = i3;
            QLog.w(J, 1, "setLoadPTuSo, bloadSuc[" + z16 + "]");
        }
    }

    public void p0() {
        AudioManager audioManager = (AudioManager) VideoAppInterface.N().getApp().getApplicationContext().getSystemService("audio");
        if (audioManager != null) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean isMicrophoneMute = audioManager.isMicrophoneMute();
            if (isMicrophoneMute) {
                audioManager.setMicrophoneMute(false);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            AVCoreLog.printColorLog(J, " ---setMicrophoneMute:" + isMicrophoneMute + "|" + (currentTimeMillis2 - currentTimeMillis));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q0() {
        if (this.F == null) {
            this.F = new Runnable() { // from class: com.tencent.av.AVControllerCommon.13
                @Override // java.lang.Runnable
                public void run() {
                    if (QLog.isColorLevel()) {
                        QLog.d(AVControllerCommon.J, 2, "mSwitchToMultiRunnable timeOut ");
                    }
                    DAVController.R().E(n.e().f().f73091w, 2);
                }
            };
            if (VideoAppInterface.N() != null && this.F != null) {
                VideoAppInterface.N().M().postDelayed(this.F, 20000L);
            }
        }
    }

    public void r(boolean z16) {
        QLog.w(J, 1, "doAIDenoiseStatusChanged | sessionType=" + n.e().f().f73035i + " enable=" + z16);
        if (n.e().f().f73035i != 1 && n.e().f().f73035i != 2) {
            if ((n.e().f().f73035i == 3 || n.e().f().f73035i == 4) && MAVController.Y().f72712n != null && n.e().f().f73063p != 0) {
                MAVController.Y().f72712n.enableAIDenoise(z16);
                return;
            }
            return;
        }
        if (DAVController.R().f72607a != null) {
            NtrtcAudio.getInstance().enableAIDenoise(z16);
        }
    }

    public int r0(int i3) {
        AVCoreLog.printAllUserLog(J, "setVoiceType| sessionType=" + n.e().f().f73035i + "type=" + i3);
        if (n.e().f().f73035i != 1 && n.e().f().f73035i != 2) {
            if ((n.e().f().f73035i == 3 || n.e().f().f73035i == 4) && MAVController.Y().f72712n != null) {
                return MAVController.Y().f72712n.setVoiceType(i3);
            }
        } else if (DAVController.R().f72607a != null) {
            return NtrtcAudio.getInstance().setVoiceType(i3);
        }
        return -1;
    }

    public boolean s(boolean z16) {
        AVCoreLog.printAllUserLog(J, "enableLoopback| sessionType=" + n.e().f().f73035i + "enable=" + z16);
        if (n.e().f().f73035i != 1 && n.e().f().f73035i != 2) {
            if ((n.e().f().f73035i == 3 || n.e().f().f73035i == 4) && MAVController.Y().f72712n != null) {
                return MAVController.Y().f72712n.enableLoopback(z16);
            }
        } else if (DAVController.R().f72607a != null) {
            return NtrtcAudio.getInstance().enableLoopback(z16);
        }
        return false;
    }

    public void s0() {
        if (n.e().f().f73043k == 4 || n.e().f().f73043k == 10 || n.e().f().f73043k == 14) {
            if (QLog.isColorLevel()) {
                QLog.d(J, 2, "Chatting Timer-->Start");
            }
            VideoAppInterface.N().M().removeCallbacks(this.E);
            VideoAppInterface.N().M().postDelayed(this.E, 1000L);
        }
    }

    public void t(int i3) {
        long d16 = com.tencent.av.utils.e.d();
        QLog.w(J, 1, "exitProcess, reason[" + i3 + "], seq[" + d16 + "]");
        if (i3 < 200) {
            i3 += 200;
        }
        if (TraeHelper.I() != null) {
            TraeHelper.I().X(d16);
        }
        OrientationEventListener orientationEventListener = this.f72583n;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        try {
            QAVNotification.l(VideoAppInterface.N()).g();
        } catch (Exception e16) {
            AVCoreLog.printErrorLog(J, "exception msg = " + e16.getMessage());
        }
        Intent intent = new Intent("tencent.video.destroyService");
        intent.setPackage(VideoAppInterface.N().getApp().getPackageName());
        D().e0(intent);
        VideoAppInterface.N().u(d16, i3);
    }

    public void t0() {
        if (QLog.isColorLevel()) {
            QLog.d(J, 2, "startNetWorkTimer");
        }
        if (this.f72577h) {
            VideoAppInterface.N().M().removeCallbacks(this.f72591v);
        }
        this.f72577h = true;
        VideoAppInterface.N().M().postDelayed(this.f72591v, 30000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(String str, int i3, boolean z16, String str2, String str3) {
        h0(str, i3, 2, z16, str2, str3, true);
    }

    public void u0() {
        VideoAppInterface.N().M().removeCallbacks(this.E);
    }

    public AVCallCompactHelper v() {
        return this.G;
    }

    public synchronized void v0() {
        int i3;
        final int i16;
        QAVNotification l3 = QAVNotification.l(VideoAppInterface.N());
        final SessionInfo f16 = n.e().f();
        int i17 = 47;
        if (f16.G) {
            if (f16.u()) {
                int i18 = f16.f73035i;
                if (i18 != 1 && i18 != 2) {
                    final String valueOf = String.valueOf(f16.P0);
                    final String str = f16.f73091w;
                    final String str2 = f16.f73030h;
                    Bitmap J2 = VideoAppInterface.N().J(3000, valueOf, null, true, true);
                    l3.c(str2, VideoAppInterface.N().G(1004, str, valueOf), J2, valueOf, 57, 3000, 3);
                    if (J2 == null) {
                        VideoAppInterface.N().M().postDelayed(new Runnable() { // from class: com.tencent.av.AVControllerCommon.4
                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap J3 = VideoAppInterface.N().J(3000, valueOf, null, true, true);
                                QAVNotification.l(VideoAppInterface.N()).c(str2, VideoAppInterface.N().G(1004, str, valueOf), J3, valueOf, 57, 3000, 3);
                            }
                        }, 1000L);
                    }
                    return;
                }
                if (!f16.M0 && !f16.f73060o0) {
                    i3 = 56;
                } else {
                    i3 = 55;
                }
                i16 = i3;
            } else {
                if (f16.f73035i == 1) {
                    i16 = i17;
                }
                i17 = 42;
                i16 = i17;
            }
        } else if (f16.z()) {
            if (f16.f73035i == 1) {
                i16 = i17;
            }
            i17 = 42;
            i16 = i17;
        } else {
            if (f16.f73035i == 1) {
                i3 = 46;
            } else {
                i3 = 41;
            }
            i16 = i3;
        }
        int i19 = f16.f73035i;
        if (i19 != 3 && i19 != 4) {
            if (f16.f73099y == null) {
                f16.f73099y = VideoAppInterface.N().G(f16.f73067q, f16.f73091w, f16.f73103z);
            }
            Bitmap J3 = VideoAppInterface.N().J(f16.f73067q, f16.f73091w, f16.f73103z, true, false);
            if (J3 != null) {
                l3.c(f16.f73030h, f16.f73099y, J3, f16.f73091w, i16, f16.f73067q, f16.f73035i);
            } else {
                VideoAppInterface.N().M().postDelayed(new Runnable() { // from class: com.tencent.av.AVControllerCommon.6
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoAppInterface N = VideoAppInterface.N();
                        SessionInfo sessionInfo = f16;
                        Bitmap J4 = N.J(sessionInfo.f73067q, sessionInfo.f73091w, sessionInfo.f73103z, true, true);
                        QAVNotification l16 = QAVNotification.l(VideoAppInterface.N());
                        SessionInfo sessionInfo2 = f16;
                        l16.c(sessionInfo2.f73030h, sessionInfo2.f73099y, J4, sessionInfo2.f73091w, i16, sessionInfo2.f73067q, sessionInfo2.f73035i);
                    }
                }, 1000L);
            }
            s0();
        }
        if (f16.f73060o0) {
            l3.c(f16.f73030h, f16.f73099y, VideoAppInterface.N().J(0, f16.f73091w, null, true, true), String.valueOf(f16.P0), 48, 0, f16.f73035i);
        } else {
            String G = VideoAppInterface.N().G(n.e().f().f73067q, String.valueOf(n.e().f().P0), null);
            Bitmap J4 = VideoAppInterface.N().J(f16.f73067q, String.valueOf(f16.P0), null, true, true);
            if (J4 != null) {
                l3.c(f16.f73030h, G, J4, String.valueOf(f16.P0), 44, f16.f73067q, f16.f73035i);
            } else {
                VideoAppInterface.N().M().postDelayed(new Runnable() { // from class: com.tencent.av.AVControllerCommon.5
                    @Override // java.lang.Runnable
                    public void run() {
                        QAVNotification.l(VideoAppInterface.N()).c(n.e().f().f73030h, VideoAppInterface.N().G(n.e().f().f73067q, String.valueOf(n.e().f().P0), null), VideoAppInterface.N().J(n.e().f().f73067q, String.valueOf(n.e().f().P0), null, true, true), String.valueOf(n.e().f().P0), 44, n.e().f().f73067q, n.e().f().f73035i);
                    }
                }, 1000L);
            }
        }
        s0();
    }

    public MqqHandler w() {
        return this.f72576g;
    }

    public long x(String str) {
        SessionInfo d16 = n.e().d(str);
        long j3 = 0;
        if (d16 != null && d16.b() != 0) {
            return d16.b();
        }
        if (DAVController.R().f72607a != null) {
            j3 = DAVController.R().f72607a.getChatRoomId(str);
            QLog.i(J, 1, "retry to get room id. new room id = " + j3);
            if (d16 != null) {
                d16.d(j3);
            }
        }
        return j3;
    }

    public long y() {
        if (n.e().f().f73100y0 == 0) {
            return 0L;
        }
        long elapsedRealtime = ((SystemClock.elapsedRealtime() - n.e().f().f73100y0) / 1000) + n.e().f().f73104z0;
        VideoAppInterface.N().E0(elapsedRealtime);
        return elapsedRealtime;
    }

    public int z() {
        return D().f72571b.f72837b;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class b implements AudioManager.OnAudioFocusChangeListener {
        b() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i3) {
        }
    }
}
