package com.tencent.av;

import android.app.ActivityOptions;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.av.AVControllerCommon;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.av.chatroom.ChatRoomMng;
import com.tencent.av.compat.AVCallCompactHelper;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.av.doodle.DoodleLogic;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.MultiIncomingCallUICtr;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.ui.VideoInviteFloatBarUICtr;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.utils.AVSoUtils;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.PerfReporter;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.SignalStrengthReport;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.aa;
import com.tencent.av.utils.ad;
import com.tencent.av.utils.ag;
import com.tencent.av.utils.ba;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.av.zplan.QAVControllerForZplan;
import com.tencent.av.zplan.avatar.listener.impl.ZplanAvatarRenderTipsListener;
import com.tencent.av.zplan.avatar.manager.AVChatAvatarEasterEggManager;
import com.tencent.av.zplan.avatar.manager.AVChatBgSwitchLoadingManager;
import com.tencent.av.zplan.avatar.resmgr.AVAvatarResMgr;
import com.tencent.avbiz.Constants;
import com.tencent.avcore.jni.NtrtcVideoRender;
import com.tencent.avcore.jni.audiodevice.TraeConstants;
import com.tencent.avcore.jni.data.DavPBCommonParam;
import com.tencent.avcore.jni.data.NtrtcAppParam;
import com.tencent.avcore.jni.data.NtrtcAudioParam;
import com.tencent.avcore.jni.data.NtrtcCommonParam;
import com.tencent.avcore.jni.data.NtrtcNetworkParam;
import com.tencent.avcore.jni.data.NtrtcVideoParam;
import com.tencent.avcore.jni.dav.NtrtcAudio;
import com.tencent.avcore.jni.dav.NtrtcEngine;
import com.tencent.avcore.jni.dav.NtrtcRoom;
import com.tencent.avcore.jni.dav.NtrtcSession;
import com.tencent.avcore.jni.dav.NtrtcUtil;
import com.tencent.avcore.jni.dav.NtrtcVideo;
import com.tencent.avcore.rtc.node.report.data.NodeModel$EndStatusCode;
import com.tencent.avcore.rtc.node.report.data.NodeModel$NodeEndReason;
import com.tencent.avcore.rtc.node.report.utils.RtcNodeReportReceiverHelper;
import com.tencent.avcore.rtc.node.report.utils.RtcVideoRecoveryNodeReport;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.filament.zplan.view.AVFilamentTextureView;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.guild.api.IGuildLiveChannelApi;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.util.az;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.util.Pair;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import cooperation.qzone.remote.ServiceConst;
import dx.ZplanAvatarAbilitySupportStatus;
import dx.ZplanAvatarStatus;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.NewIntent;
import mqq.util.ForegroundUtil;
import mqq.util.LogUtil;
import mqq.util.WeakReference;
import okhttp3.internal.ws.WebSocketProtocol;
import org.light.avatar.AvatarAIInfo;
import org.slf4j.Marker;
import tencent.im.cs.net.echo$ReqEcho;
import tencent.im.s2c.msgtype0x210.security.S2cSafeInfo$SafeCheckInfo;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DAVController implements com.tencent.av.core.d, VcControllerImpl.c {
    private static String D = "DAVController";
    public static AVChatAvatarEasterEggManager E;
    private static AVChatBgSwitchLoadingManager F;
    static volatile DAVController G;

    /* renamed from: g, reason: collision with root package name */
    public int f72613g;

    /* renamed from: a, reason: collision with root package name */
    VcControllerImpl f72607a = null;

    /* renamed from: b, reason: collision with root package name */
    boolean f72608b = false;

    /* renamed from: c, reason: collision with root package name */
    private final int f72609c = 3;

    /* renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f72610d = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    public boolean f72611e = false;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f72612f = true;

    /* renamed from: h, reason: collision with root package name */
    HashMap<Long, Long> f72614h = new HashMap<>();

    /* renamed from: i, reason: collision with root package name */
    private boolean f72615i = false;

    /* renamed from: j, reason: collision with root package name */
    public ax.j f72616j = null;

    /* renamed from: k, reason: collision with root package name */
    private ZplanAvatarRenderTipsListener f72617k = null;

    /* renamed from: l, reason: collision with root package name */
    private Runnable f72618l = null;

    /* renamed from: m, reason: collision with root package name */
    public long f72619m = 0;

    /* renamed from: n, reason: collision with root package name */
    private volatile VideoCallStateMonitor f72620n = null;

    /* renamed from: o, reason: collision with root package name */
    public StartRingRunnable f72621o = null;

    /* renamed from: p, reason: collision with root package name */
    AVControllerCommon.c f72622p = new f();

    /* renamed from: q, reason: collision with root package name */
    AVControllerCommon.c f72623q = new g();

    /* renamed from: r, reason: collision with root package name */
    private Runnable f72624r = null;

    /* renamed from: s, reason: collision with root package name */
    Runnable f72625s = null;

    /* renamed from: t, reason: collision with root package name */
    int f72626t = 0;

    /* renamed from: u, reason: collision with root package name */
    Runnable f72627u = new Runnable() { // from class: com.tencent.av.DAVController.17
        @Override // java.lang.Runnable
        public void run() {
            if (QLog.isColorLevel()) {
                QLog.d(DAVController.D, 2, "connectingRunnable");
            }
            if (!n.e().f().z()) {
                DAVController.this.F(n.e().f().f73091w, 216);
                DAVController.this.H0(216);
                DAVController.this.E(n.e().f().f73091w, 5);
            }
        }
    };

    /* renamed from: v, reason: collision with root package name */
    final com.tencent.av.avatar.a f72628v = new b();

    /* renamed from: w, reason: collision with root package name */
    public long f72629w = -1;

    /* renamed from: x, reason: collision with root package name */
    private boolean f72630x = false;

    /* renamed from: y, reason: collision with root package name */
    private final com.tencent.av.zplan.avatar.manager.a f72631y = new d();

    /* renamed from: z, reason: collision with root package name */
    Runnable f72632z = null;
    Runnable A = new Runnable() { // from class: com.tencent.av.DAVController.26
        @Override // java.lang.Runnable
        public void run() {
            DAVController.this.x1(1);
        }
    };
    private Runnable B = null;
    boolean C = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements QAVControllerForZplan.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SessionInfo f72680a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f72681b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f72682c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f72683d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f72684e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f72685f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f72686g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Intent f72687h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f72688i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ long f72689j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ boolean f72690k;

        a(SessionInfo sessionInfo, boolean z16, String str, String str2, int i3, String str3, long j3, Intent intent, boolean z17, long j16, boolean z18) {
            this.f72680a = sessionInfo;
            this.f72681b = z16;
            this.f72682c = str;
            this.f72683d = str2;
            this.f72684e = i3;
            this.f72685f = str3;
            this.f72686g = j3;
            this.f72687h = intent;
            this.f72688i = z17;
            this.f72689j = j16;
            this.f72690k = z18;
        }

        @Override // com.tencent.av.zplan.QAVControllerForZplan.d
        public void a(boolean z16) {
            if (!this.f72680a.M0 || this.f72681b) {
                DAVController.this.n1(this.f72689j, this.f72687h, this.f72683d, this.f72690k, this.f72688i);
                return;
            }
            QAVControllerForZplan.p().z(this.f72682c, this.f72683d, VideoAppInterface.N().G(this.f72684e, this.f72683d, this.f72685f), this.f72686g);
            this.f72687h.putExtra("isInZplanHome", true);
            if (Build.VERSION.SDK_INT >= 26) {
                this.f72687h.removeFlags(268435456);
            }
            this.f72687h.addFlags(131072);
            DAVController.this.m1(this.f72687h, this.f72683d, this.f72688i, false, true);
        }

        @Override // com.tencent.av.zplan.QAVControllerForZplan.d
        public void b() {
            DAVController.this.n1(this.f72689j, this.f72687h, this.f72683d, this.f72690k, this.f72688i);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class b implements com.tencent.av.avatar.a {
        b() {
        }

        @Override // com.tencent.av.avatar.a
        public void a(AvatarAIInfo avatarAIInfo, long j3) {
            if (avatarAIInfo != null) {
                ax.j jVar = DAVController.this.f72616j;
                if (jVar != null) {
                    jVar.p(true, avatarAIInfo, j3);
                }
                AVChatAvatarEasterEggManager aVChatAvatarEasterEggManager = DAVController.E;
                if (aVChatAvatarEasterEggManager != null) {
                    aVChatAvatarEasterEggManager.y(true, avatarAIInfo);
                }
                DAVController.this.a1(com.tencent.av.opengl.effects.b.b(avatarAIInfo), j3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c implements AVAvatarResMgr.c {
        c() {
        }

        @Override // com.tencent.av.zplan.avatar.resmgr.AVAvatarResMgr.c
        public void onRequestFinish(boolean z16) {
            QLog.i(DAVController.D, 1, "requestCDNServerUseState.onRequestFinish. isCDNOverload: " + z16);
            if (!z16) {
                AVAvatarResMgr.v().G(null, 90000, true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class f extends AVControllerCommon.c {
        f() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            int i3;
            QLog.w(DAVController.D, 1, "onCompletion, request, mainSession[" + n.e().f() + "], seq[" + this.f72605d + "]");
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            if (!n.e().f().w()) {
                this.f72605d = 0L;
                return;
            }
            n.e().f().n0("OnCompletionListener", 6);
            AVControllerCommon D = AVControllerCommon.D();
            long j3 = this.f72605d;
            if (n.e().f().f73076s0 == 2) {
                i3 = 4;
            } else {
                i3 = 1;
            }
            D.V(j3, R.raw.f169423v, i3, DAVController.this.L(this.f72605d));
            VideoAppInterface.N().k0(new Object[]{14, Integer.valueOf(n.e().f().A0), n.e().f().f73091w, Long.valueOf(this.f72605d)});
            this.f72605d = 0L;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class g extends AVControllerCommon.c {
        g() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            SessionInfo f16 = n.e().f();
            QLog.w(DAVController.D, 1, "onCompletion, onClose, mainSession[" + f16 + "], seq[" + this.f72605d + "], timeOutTask[" + DAVController.this.f72624r + "]");
            if (DAVController.this.f72624r != null) {
                VideoAppInterface.N().M().removeCallbacks(DAVController.this.f72624r);
                DAVController.this.f72624r = null;
            }
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            if (!f16.x()) {
                AVCoreLog.printAllUserLog(DAVController.D, "onCompletion onClose is not Closing2");
                this.f72605d = 0L;
            } else {
                DAVController.this.F(f16.f73091w, 217);
                DAVController.this.H0(217);
                DAVController.this.E(f16.f73091w, n.e().f().A0);
                this.f72605d = 0L;
            }
        }
    }

    DAVController() {
    }

    private void D() {
        if (this.B != null) {
            VideoAppInterface.N().M().removeCallbacks(this.B);
        }
        this.B = null;
    }

    public static DAVController G() {
        if (G == null) {
            synchronized (DAVController.class) {
                if (G == null) {
                    QLog.d(D, 1, "create DAVController");
                    G = new DAVController();
                }
            }
        }
        return G;
    }

    public static void H() {
        G = null;
    }

    private void J0(final int i3) {
        this.f72630x = true;
        VideoAppInterface N = VideoAppInterface.N();
        Boolean bool = Boolean.TRUE;
        N.k0(new Object[]{Integer.valueOf(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_REFRESH_PLAYER_WITH_REOPEN_START), bool, bool});
        AVAvatarResMgr.v().G(new AVAvatarResMgr.b() { // from class: com.tencent.av.DAVController.24
            @Override // com.tencent.av.zplan.avatar.resmgr.AVAvatarResMgr.b
            public void onDownloadFinish(final boolean z16) {
                QLog.i(DAVController.D, 1, "requestDownloadAvatarResIfNeed.onDownloadFinish. isSuccess: " + z16);
                if (VideoAppInterface.N() != null) {
                    VideoAppInterface.N().M().postDelayed(new Runnable() { // from class: com.tencent.av.DAVController.24.1
                        @Override // java.lang.Runnable
                        public void run() {
                            String str;
                            DAVController.this.f72630x = false;
                            if (z16) {
                                SessionInfo f16 = n.e().f();
                                if (f16 != null) {
                                    f16.F2 = true;
                                    QLog.i(DAVController.D, 1, "requestDownloadAvatarResIfNeed.isAllAvatarResValid: true.");
                                }
                            } else {
                                QQToast.makeText(VideoAppInterface.N().getApplicationContext(), R.string.f1786837b, 0).show();
                                SessionInfo f17 = n.e().f();
                                if (f17 != null) {
                                    boolean z17 = f17.G2;
                                    boolean P = f17.P();
                                    if (z17) {
                                        str = "1";
                                    } else if (P) {
                                        str = "3";
                                    } else {
                                        str = "2";
                                    }
                                    ReportController.o(null, "dc00898", "", "", "0X800C45A", "0X800C45A", 0, 0, str, "2", "", "");
                                    if (f17.f73098x2 && ax.a.c(VideoAppInterface.N())) {
                                        VideoAppInterface.N().k0(new Object[]{Integer.valueOf(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARED), Boolean.FALSE});
                                    }
                                    if (f17.f73102y2 && ax.a.c(VideoAppInterface.N())) {
                                        VideoAppInterface.N().k0(new Object[]{530, f17.f73091w, Boolean.FALSE, "", 0});
                                    }
                                }
                            }
                            if (i3 == 2) {
                                VideoAppInterface N2 = VideoAppInterface.N();
                                Boolean bool2 = Boolean.FALSE;
                                N2.k0(new Object[]{Integer.valueOf(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_REFRESH_PLAYER_WITH_REOPEN_START), bool2, bool2});
                            }
                        }
                    }, 0L);
                }
            }

            @Override // com.tencent.av.zplan.avatar.resmgr.AVAvatarResMgr.b
            public void onDownloadProgress(int i16) {
                VideoAppInterface.N().k0(new Object[]{Integer.valueOf(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_REFRESH_PLAYER_WITH_REOPEN_END), Integer.valueOf(i16)});
            }
        }, 90000, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AVControllerCommon.c L(long j3) {
        if (this.f72624r == null) {
            this.f72624r = new Runnable() { // from class: com.tencent.av.DAVController.9
                @Override // java.lang.Runnable
                public void run() {
                    AVControllerCommon.c cVar = DAVController.this.f72623q;
                    if (cVar != null) {
                        cVar.onCompletion(null);
                    }
                    DAVController.this.f72624r = null;
                }
            };
        }
        VideoAppInterface.N().M().postDelayed(this.f72624r, 2000L);
        AVControllerCommon.c cVar = this.f72623q;
        cVar.f72605d = j3;
        return cVar;
    }

    private long M() {
        if (n.e().f() == null || n.e().f().f73100y0 == 0) {
            return 0L;
        }
        return ((SystemClock.elapsedRealtime() - n.e().f().f73100y0) / 1000) + n.e().f().f73104z0;
    }

    private SessionInfo Q(int i3, String str) {
        SessionInfo sessionInfo;
        if (i3 == 1) {
            sessionInfo = n.e().i(n.b(3, str, new int[0]));
            if (sessionInfo == null) {
                sessionInfo = n.e().i(n.b(100, str, new int[0]));
            }
        } else if (i3 == 4) {
            sessionInfo = n.e().i(n.b(4, str, new int[0]));
        } else {
            sessionInfo = null;
        }
        if (sessionInfo == null) {
            return n.e().g(str);
        }
        return sessionInfo;
    }

    public static DAVController R() {
        return G;
    }

    private void V0() {
        if (this.f72629w != -1 && System.currentTimeMillis() - this.f72629w < 10000) {
            return;
        }
        this.f72629w = System.currentTimeMillis();
        MessageMicro<echo$ReqEcho> messageMicro = new MessageMicro<echo$ReqEcho>() { // from class: tencent.im.cs.net.echo$ReqEcho
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_uid"}, new Object[]{0L}, echo$ReqEcho.class);
            public final PBUInt64Field uint64_uid = PBField.initUInt64(0);
        };
        NewIntent newIntent = new NewIntent(VideoAppInterface.N().getApplication(), t.class);
        newIntent.putExtra("reqType", 20);
        newIntent.putExtra("vMsg", messageMicro.toByteArray());
        if (QLog.isColorLevel()) {
            QLog.d(D, 2, "checkNetStatus -->sendEcho");
        }
        AVControllerCommon.D().f72571b.o(newIntent);
    }

    private boolean c0(String str) {
        SessionInfo f16;
        String str2;
        if (str == null || (f16 = n.e().f()) == null || (str2 = f16.f73091w) == null || !str.equals(str2)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(AVFilamentTextureView aVFilamentTextureView, Rect rect, int i3) {
        ax.j jVar = this.f72616j;
        if (jVar == null) {
            return;
        }
        jVar.K(aVFilamentTextureView);
        if (i3 != 1) {
            int dimensionPixelSize = aVFilamentTextureView.getResources().getDimensionPixelSize(R.dimen.b27);
            int dimensionPixelSize2 = aVFilamentTextureView.getResources().getDimensionPixelSize(R.dimen.f159623b24);
            int dimensionPixelSize3 = aVFilamentTextureView.getResources().getDimensionPixelSize(R.dimen.f159624b25);
            int dimensionPixelSize4 = aVFilamentTextureView.getResources().getDimensionPixelSize(R.dimen.b26);
            int width = (aVFilamentTextureView.getWidth() - dimensionPixelSize) - dimensionPixelSize3;
            int i16 = dimensionPixelSize2 - dimensionPixelSize4;
            int height = (aVFilamentTextureView.getHeight() - i16) - dimensionPixelSize2;
            rect.set(width, height, width + dimensionPixelSize, height + dimensionPixelSize2);
            this.f72616j.p0(dimensionPixelSize, dimensionPixelSize2, width, i16);
        }
        if (n.e().f().f73098x2) {
            W(true, true);
        }
        if (n.e().f().f73102y2) {
            W(true, false);
        }
        if (VideoAppInterface.N() != null) {
            VideoAppInterface.N().k0(new Object[]{Integer.valueOf(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_DETECTED_MULTI_NETWORK_CARD_AND_LOW_SPEED), Boolean.TRUE});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n1(long j3, Intent intent, String str, boolean z16, boolean z17) {
        boolean s16 = SmallScreenUtils.s(VideoAppInterface.N().getApplication().getApplicationContext());
        if (AVControllerCommon.D().f72572c && s16) {
            if (!z16 && !u.d()) {
                VideoInviteFloatBarUICtr videoInviteFloatBarUICtr = new VideoInviteFloatBarUICtr(VideoAppInterface.N(), intent);
                videoInviteFloatBarUICtr.k();
                videoInviteFloatBarUICtr.l(j3, intent);
            } else {
                MultiIncomingCallUICtr multiIncomingCallUICtr = new MultiIncomingCallUICtr(VideoAppInterface.N(), intent);
                multiIncomingCallUICtr.q();
                multiIncomingCallUICtr.r(intent);
            }
            QLog.w(D, 1, "processVideoRequest startActivity when GameMode");
            A1("mode", "1");
            B0(str);
            B1(str, "screenState", String.valueOf(1));
            return;
        }
        m1(intent, str, z17, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(String str, String str2) {
        boolean z16;
        boolean z17;
        ZplanAvatarStatus a16 = ZplanAvatarStatus.a(str2);
        if (a16 != null) {
            if (a16.getEnable() == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (n.e().f().f73102y2 == z17) {
                QLog.d(D, 1, "onReceivePeerZPlanAvatarStatus same status:=" + z17);
                return;
            }
        }
        if (a16 == null) {
            QLog.i(D, 2, "onReceivePeerZPlanAvatarStatus convert null");
        } else {
            QLog.i(D, 2, a16.b());
            SessionInfo f16 = n.e().f();
            if (a16.getEnable() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            f16.f73102y2 = z16;
            if (n.e().f().f73102y2) {
                ax.j jVar = this.f72616j;
                if (jVar != null) {
                    jVar.t(false, str);
                }
                VideoAppInterface.N().j0(19, null);
            }
            VideoAppInterface.N().k0(new Object[]{530, str, Boolean.valueOf(n.e().f().f73102y2), a16.getBackgroundId(), 0});
        }
        f1();
    }

    private void t1() {
        vv.e b16 = vv.e.b(VideoAppInterface.N());
        b16.g(n.e().f());
        b16.h(n.e().f());
        b16.f(n.e().f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w1() {
        boolean z16;
        SessionInfo f16 = n.e().f();
        ax.j jVar = this.f72616j;
        if (jVar != null) {
            boolean z17 = true;
            if (f16.f73098x2) {
                jVar.P(true);
                z16 = true;
            } else {
                z16 = false;
            }
            if (f16.f73102y2) {
                this.f72616j.P(false);
            } else {
                z17 = z16;
            }
            if (z17) {
                k1();
            }
        }
    }

    private void y0(final long j3, final String str, final int i3, final String str2, final String str3, final boolean z16, boolean z17, final boolean z18, final int i16, final int i17, final String str4) {
        if (this.B != null) {
            VideoAppInterface.N().M().removeCallbacks(this.B);
        }
        this.B = new Runnable() { // from class: com.tencent.av.DAVController.28
            @Override // java.lang.Runnable
            public void run() {
                int i18;
                SessionInfo i19 = n.e().i(str);
                if (!MAVController.Y().f72699a && i19 != null && (i18 = i19.f73067q) != 21 && i18 != 1011) {
                    AVControllerCommon.D().f0(str, i19.f73039j, false, false, true);
                }
                DAVController.this.z0(j3, str, i3, str2, str3, z16, false, z18, i16, i17, str4);
            }
        };
        VideoAppInterface.N().M().postDelayed(this.B, 1000L);
    }

    public boolean A() {
        boolean z16;
        if (n.e().f().G && (n.e().f().f73035i == 1 || n.e().f().f73035i == 2 || (n.e().f().f73035i == 0 && (n.e().f().f73039j == 1 || n.e().f().f73039j == 2)))) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d(D, 1, "checkIsDoubleReceiveInviting ret=" + z16);
        return z16;
    }

    void A0(final long j3, final String str, final int i3, final String str2, final String str3, final boolean z16, final boolean z17, final boolean z18, final int i16, final int i17, final String str4, boolean z19) {
        Intent intent;
        boolean z26;
        AVControllerCommon.D().f72572c = AVControllerCommon.D().J();
        boolean s16 = SmallScreenUtils.s(VideoAppInterface.N().getApplication().getApplicationContext());
        long x16 = AVControllerCommon.D().x(str2);
        QLog.w(D, 1, "processVideoRequest, uinType[" + i3 + "], peerUin[" + str2 + "], extraUin[" + str3 + "], onlyAudio[" + z16 + "], isDoubleVideoMeeting[" + z17 + "], mIsGameMode[" + AVControllerCommon.D().f72572c + "], isFloatWindowOpAllowedOnBackground[" + s16 + "], aSessionExists[" + z18 + "], roomId[" + x16 + "], sessionId[" + str + "], seq[" + j3 + "], inviteScene[" + i17 + "], traceId[" + str4 + "], needWaitService[" + z19 + "]");
        if (z16 && !pu.c.n(VideoAppInterface.N().getApp())) {
            z(j3, str2, 0, z17);
            E(str2, 0);
            return;
        }
        SessionInfo i18 = n.e().i(str);
        if (i18 == null) {
            QLog.w(D, 1, "processVideoRequest, sessionInfo\u4e3a\u7a7a");
            return;
        }
        i18.v0("processVideoRequest", str4);
        i18.G = true;
        i18.M0 = z16;
        i18.n0("processVideoRequest.1", 2);
        i18.f73073r1 = false;
        i18.f73014d2 = System.currentTimeMillis();
        zv.b.a().f453506i0 = i18.M0;
        if (!z18 && !u.d() && !VideoAppInterface.N().a0()) {
            if (z19 && !VideoAppInterface.N().f0()) {
                QLog.w(D, 1, "processVideoRequest, QQService not Bind.");
                VideoAppInterface.N().M().postDelayed(new Runnable() { // from class: com.tencent.av.DAVController.14
                    @Override // java.lang.Runnable
                    public void run() {
                        DAVController.this.A0(j3, str, i3, str2, str3, z16, z17, z18, i16, i17, str4, false);
                    }
                }, 300L);
                return;
            } else {
                Intent intent2 = new Intent(VideoAppInterface.N().getApp().getApplicationContext(), (Class<?>) VideoInviteActivity.class);
                if (az.a(VideoAppInterface.N().getApp().getApplicationContext(), VideoAppInterface.N())) {
                    intent2.addFlags(262144);
                }
                intent = intent2;
                z26 = true;
            }
        } else {
            Intent intent3 = new Intent(VideoAppInterface.N().getApp().getApplicationContext(), (Class<?>) MultiIncomingCallsActivity.class);
            AVControllerCommon.D();
            intent3.putExtra("isScreenLocked", AVControllerCommon.N(VideoAppInterface.N().getApp().getApplicationContext()));
            intent = intent3;
            z26 = false;
        }
        intent.addFlags(268435456);
        intent.putExtra("uinType", i3);
        intent.putExtra("relationType", ba.uinType2AVRelationType(i3));
        intent.putExtra(ServiceConst.PARA_SESSION_ID, str);
        intent.putExtra("peerUin", str2);
        intent.putExtra("extraUin", str3);
        intent.putExtra("isAudioMode", z16);
        intent.putExtra("curUserStatus", this.f72626t);
        intent.putExtra("isDoubleVideoMeeting", z17);
        intent.putExtra("bindType", i16);
        intent.putExtra("inviteScene", i17);
        intent.putExtra("traceId", str4);
        if (i18.Q(VideoAppInterface.N())) {
            if (QLog.isColorLevel()) {
                QLog.i(D, 2, "processVideoRequest block notify video msg");
            }
            RtcNodeReportReceiverHelper.l(str4, 1, NodeModel$NodeEndReason.K_INTERRUPTION.ordinal());
        } else {
            RtcNodeReportReceiverHelper.l(str4, 0, NodeModel$NodeEndReason.K_NORMAL.ordinal());
            AVControllerCommon.D();
            if (AVControllerCommon.N(VideoAppInterface.N().getApp().getApplicationContext())) {
                m1(intent, str2, z26, true, false);
            } else {
                QAVControllerForZplan.p().t(VideoAppInterface.N().getApp().getApplicationContext(), new a(i18, z17, str, str2, i3, str3, x16, intent, z26, j3, z18));
            }
            AVControllerCommon.D().d0();
        }
    }

    public void A1(String str, String str2) {
        B1(null, str, str2);
    }

    public boolean B(int i3, String str) {
        SessionInfo f16 = n.e().f();
        if (TextUtils.equals(f16.f73030h, n.b(3, str, new int[0]))) {
            return false;
        }
        if (i3 == 1011 && f16.f73067q == i3 && TextUtils.equals(f16.f73091w, str)) {
            return false;
        }
        int c16 = n.e().c();
        if (c16 >= 2) {
            QLog.d(D, 1, "checkNeedAutoRejectDAV, to many session, reject. [" + c16 + "]");
            return true;
        }
        if (!f16.u() || !VideoAppInterface.N().a0()) {
            return false;
        }
        QLog.i(D, 1, "checkNeedAutoRejectDAV, one in av game and one in invite.");
        return true;
    }

    public boolean B0(String str) {
        return C0(str, 1, 0L);
    }

    public void B1(String str, String str2, String str3) {
        long parseLong;
        if (QLog.isDevelopLevel()) {
            QLog.d(D, 2, "updateProcessInfo peerUin = " + str + ",key = " + str2 + ",value = " + str3 + ", isAllSessionIdle = " + n.e().k());
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                parseLong = Long.parseLong(str);
            } catch (Exception e16) {
                QLog.e(D, 2, Log.getStackTraceString(e16));
            }
            if (this.f72607a == null && !n.e().k()) {
                NtrtcUtil.getInstance().updateProcessInfo(parseLong, str2, str3);
                if (QLog.isDevelopLevel()) {
                    QLog.d(D, 2, "quaReport --> updateProcessInfo peerUin = " + parseLong + ",key = " + str2 + ",value = " + str3);
                    return;
                }
                return;
            }
        }
        parseLong = 0;
        if (this.f72607a == null) {
        }
    }

    public void C() {
        int systemNetwork = NetworkUtil.getSystemNetwork(null);
        if (systemNetwork != 0) {
            if (systemNetwork != 1 && systemNetwork != 2 && systemNetwork != 3 && systemNetwork != 4 && systemNetwork != 5) {
                w(0);
                return;
            } else {
                V0();
                return;
            }
        }
        w(3);
    }

    public boolean C0(String str, int i3, long j3) {
        boolean z16;
        long x16 = AVControllerCommon.D().x(str);
        long v06 = v0(VideoAppInterface.N().getCurrentAccountUin());
        long v07 = v0(str);
        if (this.f72607a != null) {
            z16 = NtrtcUtil.getInstance().quaReport(v06, v07, x16, i3, j3);
        } else {
            z16 = false;
        }
        QLog.d(D, 1, "quaReport --> report result = " + z16 + " | node = " + i3 + " | timestamp = " + j3);
        return z16;
    }

    public int C1(String str) {
        VcControllerImpl vcControllerImpl = this.f72607a;
        if (vcControllerImpl != null) {
            return vcControllerImpl.updateSelfUin(str);
        }
        return -1;
    }

    public void D0(String str) {
        A1("deviceMemory", com.tencent.av.business.manager.report.c.s() + "");
        A1("manufacturer", Build.MANUFACTURER);
        A1("qqVersion", AppSetting.j(VideoAppInterface.N().getApp().getApplicationContext()));
    }

    public void D1() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.DAVController.20
            @Override // java.lang.Runnable
            public void run() {
                if (DAVController.this.f72607a != null) {
                    NtrtcVideo.getInstance().updateVideoParam(new aa(false).f());
                }
            }
        }, 16, null, false);
    }

    public void E(String str, int i3) {
        VideoRecoveryMonitor T;
        long d16 = com.tencent.av.utils.e.d();
        if (i3 == 21 && (T = VideoAppInterface.N().T()) != null) {
            T.k(1);
        }
        if (TraeHelper.I() != null) {
            TraeHelper.I().k0(d16);
            TraeHelper.I().x();
        }
        TraeHelper.n0(VideoAppInterface.N());
        if (c0(str) && TraeHelper.I() != null) {
            TraeHelper.I().m0();
        }
        if (QLog.isColorLevel()) {
            QLog.i(D, 2, "closeSession", new Throwable("closeSession"));
        }
        I(d16, str, i3, false);
    }

    public void E0() {
        boolean z16;
        SessionInfo f16 = n.e().f();
        long d16 = com.tencent.av.utils.e.d();
        if (f16.z() || f16.N() || f16.f73043k == 9 || f16.L()) {
            SmallScreenUtils.B(d16, VideoAppInterface.N(), 2);
            AVControllerCommon D2 = AVControllerCommon.D();
            String str = f16.f73030h;
            int i3 = f16.f73035i;
            if (f16.f73043k != 9) {
                z16 = true;
            } else {
                z16 = false;
            }
            D2.f0(str, i3, false, z16, f16.E());
        }
        QLog.w(D, 1, "reNotifyChatInfo2QQ, sessionInfo[" + f16 + "]");
    }

    public void E1(int i3, String str) {
        VcControllerImpl vcControllerImpl = this.f72607a;
        if (vcControllerImpl != null) {
            vcControllerImpl.uploadSharpNode(i3, str);
            if (QLog.isColorLevel()) {
                QLog.d("SharpReport_Node", 2, "report_node is" + i3);
            }
        }
    }

    public void F(String str, int i3) {
        long d16 = com.tencent.av.utils.e.d();
        QLog.w(D, 1, "avideo closeVideo begin, peerUin[" + str + "], emCloseReason[" + i3 + "], seq[" + d16 + "], mStartRing[" + this.f72621o + "]", new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
        if (VideoAppInterface.N() == null) {
            return;
        }
        PerfReporter.j(n.e().f());
        PerfReporter.l();
        t1();
        if (n.e().k()) {
            return;
        }
        if (this.f72621o != null) {
            VideoAppInterface.N().M().removeCallbacks(this.f72621o);
            this.f72621o = null;
        }
        if (com.tencent.av.utils.e.j()) {
            SignalStrengthReport.e(VideoAppInterface.N().getApp().getApplicationContext()).p();
        }
        if (this.f72607a == null) {
            return;
        }
        if (this.f72620n != null) {
            this.f72620n.m();
        }
        boolean z16 = false;
        this.f72612f = false;
        int closeVideo = this.f72607a.closeVideo(str, i3, this);
        VideoRecoveryMonitor T = VideoAppInterface.N().T();
        if (T != null) {
            T.k(i3);
        }
        B1(str, "inviteUIState", "");
        B1(str, "screenState", "");
        String str2 = n.e().f().f73091w;
        if (!TextUtils.isEmpty(str2) && str2.equalsIgnoreCase(str)) {
            VideoAppInterface.N().k0(new Object[]{106, Long.valueOf(d16)});
            if (n.e().f().O) {
                String i26 = VideoLayerUI.i2(str, 1);
                NtrtcVideoRender.getInstance().setGlRender(i26, null);
                if (QLog.isColorLevel()) {
                    QLog.i(D, 2, "avideo closeVideo, clear gl render, key[" + i26 + "]");
                }
                AVControllerCommon.D().n0(d16, n.e().f().f73035i, true, true);
            }
            AVControllerCommon.D().t(i3);
            QAVNotification.h(VideoAppInterface.N().getApplication().getApplicationContext());
            z16 = true;
        }
        QLog.w(D, 1, "avideo closeVideo end, result[" + closeVideo + "], cancelNotificationForce[" + z16 + "], seq[" + d16 + "]");
    }

    public void F0(String str) {
        if (this.f72610d.size() > 3) {
            this.f72610d.clear();
        }
        this.f72610d.put(str, str);
    }

    public int G0(int i3, boolean z16) {
        if (n.e().f().f73035i != 1 && n.e().f().f73035i != 2) {
            return -1;
        }
        return NtrtcAudio.getInstance().registerAudioDataCallback(i3, z16);
    }

    public void H0(int i3) {
        QLog.d(D, 1, "reportCloseReasonBeacon,reason  = " + i3);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLOSE_REASON, String.valueOf(i3));
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance((String) null, "actAvideoCloseReasonB", true, 0L, 0L, hashMap, "", true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v43 */
    public void I(long j3, String str, int i3, boolean z16) {
        int i16;
        SessionInfo i17;
        boolean z17;
        Enum r95;
        int i18;
        String str2;
        String str3;
        int i19;
        ?? r06;
        boolean z18;
        String str4 = str;
        if (i3 == 23) {
            i16 = 1;
        } else {
            i16 = i3;
        }
        if (this.f72616j != null && c0(str4)) {
            this.f72616j.g0();
            final ax.j jVar = this.f72616j;
            this.f72616j = null;
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.av.DAVController.10
                @Override // java.lang.Runnable
                public void run() {
                    ax.j jVar2 = jVar;
                    if (jVar2 != null) {
                        jVar2.d0();
                    }
                }
            }, 200L);
        }
        String b16 = n.b(3, str4, new int[0]);
        if (n.e().j(b16)) {
            i17 = n.e().i(b16);
        } else {
            b16 = n.b(100, str4, new int[0]);
            i17 = n.e().i(b16);
        }
        String str5 = b16;
        SessionInfo sessionInfo = i17;
        if (sessionInfo == 0) {
            QLog.w(D + "|VideoNodeManager", 1, "doCloseSession, fail to find session, peerUin[" + str4 + "], type[" + i16 + "], fourceCloseIgnoreSessionState[" + z16 + "], seq[" + j3 + "]");
            return;
        }
        ChatRoomMng D2 = VideoAppInterface.N().D();
        if (D2 != null) {
            D2.s(sessionInfo);
        }
        String r16 = sessionInfo.r("closeSession");
        if (sessionInfo.G && !sessionInfo.f73087v) {
            int i26 = 7;
            if (i16 == 7) {
                i26 = 3;
            }
            RtcNodeReportReceiverHelper.s(r16, i26, NodeModel$NodeEndReason.K_INTERRUPTION.ordinal());
        }
        if (sessionInfo.K() && !sessionInfo.G) {
            com.tencent.avcore.rtc.node.report.utils.b.m(r16, sessionInfo.W);
            com.tencent.avcore.rtc.node.report.utils.b.i(r16, 4, NodeModel$NodeEndReason.K_INTERRUPTION.ordinal());
        }
        if (sessionInfo.f73043k >= 4 && sessionInfo.f73087v) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            r95 = NodeModel$NodeEndReason.K_NORMAL;
        } else {
            r95 = NodeModel$EndStatusCode.K_ABNORMAL;
        }
        int ordinal = r95.ordinal();
        if (!sessionInfo.G) {
            com.tencent.avcore.rtc.node.report.utils.b.b(sessionInfo.I, r16, i16, ordinal);
        } else {
            RtcNodeReportReceiverHelper.c(r16, i16, ordinal);
        }
        VideoNodeReporter videoNodeReporter = (VideoNodeReporter) VideoAppInterface.N().B(4);
        if (sessionInfo.G) {
            i18 = 12;
        } else {
            i18 = 5;
        }
        videoNodeReporter.w(sessionInfo.b(), i18, i16 + 500);
        videoNodeReporter.C("NoCrash");
        videoNodeReporter.w(sessionInfo.b(), 29, 1L);
        videoNodeReporter.v(36, 1L);
        videoNodeReporter.z(sessionInfo.b());
        boolean z19 = true;
        QLog.w(D, 1, "avideo doCloseSession, peerUin[" + str4 + "], type[" + i3 + "->" + i16 + "], fourceCloseIgnoreSessionState[" + z16 + "], mIsQuit[" + AVControllerCommon.D().f72570a + "], sessionId[" + str5 + "], sessionInfo.isIdling[" + sessionInfo.D() + "], sessionInfo.peerUin[" + sessionInfo.f73091w + "], sessionInfo.isOnlyAudio[" + sessionInfo.M0 + "], sessionInfo.SessionType[" + sessionInfo.f73035i + "], seq[" + j3 + "]", new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
        if (sessionInfo.D() && !z16) {
            QLog.e(D, 1, "closeSession state error!!!");
            return;
        }
        int i27 = sessionInfo.f73039j;
        if (i27 == 2) {
            str2 = "2";
        } else if (i27 != 1) {
            str2 = "";
            z19 = false;
        } else {
            if (sessionInfo.f73004b0 == 2) {
                str3 = "3";
            } else {
                str3 = "1";
            }
            str2 = str3;
            z19 = true;
        }
        if (z19) {
            DataReport.T(null, "dc00898", "", "", "0X800C445", "0X800C445", 0, 0, ((int) M()) + "", str2, "", "");
        }
        if (sessionInfo.f73035i == 2 && !sessionInfo.f73060o0 && sessionInfo.f73043k >= 4 && sessionInfo.f73100y0 > 0) {
            int z26 = VideoAppInterface.N().z("BEAUTY_SKIN");
            String str6 = D;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("closeSession double video call end with beauty: ");
            sb5.append(z26);
            sb5.append(APLogFileUtil.SEPARATOR_LOG);
            i19 = i16;
            sb5.append(sessionInfo.f73100y0);
            sb5.append(APLogFileUtil.SEPARATOR_LOG);
            sb5.append(sessionInfo.f73043k);
            sb5.append(APLogFileUtil.SEPARATOR_LOG);
            sb5.append(sessionInfo.Y);
            AVCoreLog.printAllUserLog(str6, sb5.toString());
            if (sessionInfo.Y || z26 > 0) {
                DataReport.T(null, "CliOper", "", "", "0X8006292", "0X8006292", 0, 0, "", "", "", "");
            }
        } else {
            i19 = i16;
        }
        if (AVControllerCommon.D().f72572c && AVControllerCommon.D().y() > 0) {
            int i28 = sessionInfo.f73035i;
            if (i28 == 1) {
                DataReport.T(null, "CliOper", "", "", "0X8008B29 ", "0X8008B29 ", 0, 0, "", "", ba.formatTime(AVControllerCommon.D().y()), "");
            } else if (i28 == 2) {
                DataReport.T(null, "CliOper", "", "", "0X8008B2A ", "0X8008B2A ", 0, 0, "", "", ba.formatTime(AVControllerCommon.D().y()), "");
            }
        }
        sessionInfo.f73076s0 = 0L;
        sessionInfo.f73080t0 = null;
        if (!TextUtils.isEmpty(sessionInfo.f73091w) && str4 != null && sessionInfo.f73091w.contains(str4)) {
            str4 = sessionInfo.f73091w;
        }
        String str7 = str4;
        if (sessionInfo.w() || sessionInfo.x()) {
            sessionInfo.A0 = i19;
        }
        if (sessionInfo.K() || (sessionInfo.u() && i19 == sessionInfo.A0)) {
            sessionInfo.X(j3, 0L);
        }
        if (sessionInfo.f73081t1 && this.f72625s != null) {
            VideoAppInterface.N().M().removeCallbacks(this.f72625s);
            this.f72625s = null;
        }
        if (i3 == 23) {
            if (sessionInfo.f73035i == 2) {
                z18 = true;
            } else {
                z18 = false;
            }
            AVControllerCommon.D().u(sessionInfo.f73030h, sessionInfo.f73067q, z18, sessionInfo.f73091w, sessionInfo.f73103z);
        } else {
            U0(j3, str5, str7, i19);
        }
        if (!n.e().m()) {
            AVControllerCommon.D().h();
            s1();
            AVControllerCommon.D().u0();
        }
        if (AVControllerCommon.D().f72570a) {
            r06 = 0;
            r06 = 0;
            DataReport.b0(false);
            DataReport.X(false);
            if (VideoAppInterface.N().r() > 0) {
                DataReport.s();
            }
        } else {
            r06 = 0;
        }
        sessionInfo.n0("doCloseSession", r06);
        sessionInfo.p0(j3, "doCloseSession", r06);
        sessionInfo.f73039j = r06;
        sessionInfo.I1.clear();
        sessionInfo.K1 = 0L;
        NtrtcVideoRender.getInstance().setBeautyOrFaceConfig(r06, 1);
        sessionInfo.L1 = r06;
        sessionInfo.H0 = null;
        sessionInfo.Y("doCloseSession", null);
        sessionInfo.U = true;
        if (i19 != 21 && i19 != 72 && i19 != 110) {
            sessionInfo.f73067q = -1;
            if (VideoAppInterface.N().r() > 0) {
                VideoAppInterface.N().k0(new Object[]{28, str7, Boolean.valueOf(AVControllerCommon.D().f72570a)});
            } else {
                boolean z27 = AVControllerCommon.D().f72570a;
            }
        }
        VideoAppInterface.N().k0(new Object[]{203, str7, Boolean.valueOf(AVControllerCommon.D().f72570a), Long.valueOf(j3)});
        sessionInfo.c0(j3, false);
        sessionInfo.k0(j3, false);
        sessionInfo.X(j3, 0L);
        sessionInfo.h(j3);
        QLog.d(D, 2, "close session removeSession sessionId = " + str5);
        boolean n3 = n.e().n(j3, str5);
        QAVNotification l3 = QAVNotification.l(VideoAppInterface.N());
        if (l3 != null && l3.n()) {
            l3.f(str5);
            if (n3) {
                AVControllerCommon.D().v0();
            }
        }
        if (AVControllerCommon.D().f72571b.e()) {
            VideoAppInterface.N().M().postDelayed(new Runnable() { // from class: com.tencent.av.DAVController.11
                @Override // java.lang.Runnable
                public void run() {
                    AVControllerCommon.D().f72571b.b();
                }
            }, 5000L);
        }
        if (!n3) {
            AVControllerCommon.D().Y();
            AVAvatarResMgr.q();
        }
    }

    public int I0(long j3, String str, int i3, int i16, String str2, String str3, String str4, int i17, String str5, String str6, byte[] bArr, String str7, String str8, int i18, int i19, String str9, String str10) {
        int i26;
        int i27;
        int i28;
        String str11;
        long j16;
        int i29;
        String str12;
        String str13;
        SessionInfo sessionInfo;
        int i36;
        int i37;
        boolean z16;
        long j17;
        String str14;
        String str15 = str;
        String str16 = D;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("avideo request, selfUin[");
        sb5.append(LogUtil.getSafePrintUin(VideoAppInterface.N().getCurrentAccountUin()));
        sb5.append("], peerUin[");
        sb5.append(LogUtil.getSafePrintUin(str));
        sb5.append("], businessType[");
        sb5.append(i3);
        sb5.append("], relationType[");
        sb5.append(i16);
        sb5.append("], fromNation[");
        sb5.append(str2);
        sb5.append("], fromMobile[");
        sb5.append(str3);
        sb5.append("], toMobile[");
        sb5.append(str4);
        sb5.append("], uinType[");
        sb5.append(i17);
        sb5.append("], extraUin[");
        sb5.append(str5);
        sb5.append("], sig[");
        sb5.append(bArr != null);
        sb5.append("], bindID[");
        sb5.append(str8);
        sb5.append("], bindType[");
        sb5.append(i18);
        sb5.append("], subServiceType[");
        sb5.append(i19);
        sb5.append("], mStartRing[");
        sb5.append(this.f72621o);
        sb5.append("], seq[");
        sb5.append(j3);
        sb5.append("], traceId[");
        sb5.append(str10);
        sb5.append("]");
        QLog.w(str16, 1, sb5.toString());
        com.tencent.av.utils.e.w(VideoAppInterface.N());
        if (bArr != null) {
            QLog.d(D, 2, "request sigLength: " + bArr.length);
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            QLog.e(D, 1, "request fail, network not support!");
            return -2;
        }
        if (this.f72607a == null) {
            QLog.e(D, 1, "request fail,controller is null!");
            return -1;
        }
        if (i17 == 1006 && str15.startsWith(Marker.ANY_NON_NULL_MARKER)) {
            str15 = str15.substring(1);
        }
        int n3 = AVControllerCommon.n(i17, true, 1);
        if (n3 == -1) {
            QLog.e(D, 1, "request fail, accostType = " + n3);
            return -1;
        }
        SessionInfo f16 = n.e().f();
        if (f16.u() && (str14 = f16.f73091w) != null && str15.equals(str14)) {
            QLog.e(D, 1, "request fail,----already receive invite, return~");
            f16.G = true;
            return -1;
        }
        if (QLog.isColorLevel()) {
            i26 = n3;
            i27 = 2;
            QLog.d(D, 2, "avideo request mIsInZplanHome " + f16.H2);
        } else {
            i26 = n3;
            i27 = 2;
        }
        int i38 = f16.H2 ? 5 : 0;
        int i39 = f16.f73004b0;
        f16.E2 = i39 == i27;
        if (i17 == 9500) {
            AVControllerCommon.D().f72571b.d(Const.BUNDLE_KEY_REQUEST);
        } else {
            AVControllerCommon.D().f72571b.b();
            this.f72615i = true;
        }
        if (f16.f73081t1) {
            long j18 = f16.f73089v1;
            String str17 = D;
            i28 = i39;
            StringBuilder sb6 = new StringBuilder();
            str11 = Const.BUNDLE_KEY_REQUEST;
            sb6.append("request, startTerminalSwitchTimeOutCheck, oldRoomId[");
            sb6.append(j18);
            sb6.append("], seq[");
            sb6.append(j3);
            sb6.append("]");
            QLog.w(str17, 1, sb6.toString());
            q1();
            j16 = j18;
        } else {
            i28 = i39;
            str11 = Const.BUNDLE_KEY_REQUEST;
            j16 = 0;
        }
        String string = BaseApplicationImpl.getApplication().getSharedPreferences(VipFunCallConstants.FUN_CALL_SP_FILE, 4).getString(VipFunCallConstants.SP_KEY_FUN_CALL_BUFF, "");
        if (QLog.isColorLevel()) {
            QLog.d(D, 2, "request funcall buffer:" + string);
        }
        VideoAppInterface.N().getVideoConfigUpdate();
        VideoAppInterface.N().H0();
        ((VideoNodeReporter) VideoAppInterface.N().B(4)).w(-1L, 2, 1L);
        AVControllerCommon.D().p0();
        String r16 = TextUtils.isEmpty(str10) ? f16.r("requestCall") : str10;
        com.tencent.avcore.rtc.node.report.utils.b.x(r16, VideoAppInterface.N().getCurrentAccountUin(), f16.f73091w, i3 == 0, 0L);
        com.tencent.avcore.rtc.node.report.utils.b.w(r16, f16.f73079t);
        int i46 = f16.f73067q;
        if (i46 == 1011 || i46 == 21) {
            i29 = i26;
            String str18 = r16;
            str12 = "";
            int i47 = i28;
            str13 = str11;
            if (QLog.isColorLevel()) {
                QLog.e(D, 2, "request Anychat Mode ");
            }
            f16.M0 = true;
            if (Long.valueOf(VideoAppInterface.N().getCurrentAccountUin()).longValue() > Long.valueOf(str15).longValue()) {
                sessionInfo = f16;
                i36 = this.f72607a.requestVideo(str15, 0L, com.tencent.av.app.q.a(), 0, 4, str2, str3, str4, 21, str5, str6, j16, bArr, string, str7, str8, i18, i19, str9, i38, i47, str18);
            } else {
                sessionInfo = f16;
                i36 = 0;
            }
        } else if (i17 == 9500) {
            try {
                long g16 = com.tencent.av.utils.i.g(str15);
                int intValue = !TextUtils.isEmpty(str6) ? Integer.valueOf(str6).intValue() : 4200;
                if (QLog.isColorLevel()) {
                    QLog.d("SDVideo", 2, "request smart tv " + intValue);
                }
                f16.M0 = false;
                NtrtcEngine.getInstance().setApType(com.tencent.av.app.q.a());
                i29 = i26;
                sessionInfo = f16;
                i36 = this.f72607a.requestFromUnQQ(g16, i3, i16, intValue);
                str12 = "";
                str13 = str11;
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
                QLog.e(D, 1, "request fail,NumberFormatException ", e16);
                return -1;
            }
        } else if (i3 == 0) {
            f16.M0 = true;
            i29 = i26;
            str13 = str11;
            str12 = "";
            i36 = this.f72607a.requestVideo(str15, 0L, com.tencent.av.app.q.a(), i3, i16, str2, str3, str4, i29, str5, str6, j16, bArr, string, str7, str8, i18, i19, str9, i38, i28, r16);
            sessionInfo = f16;
        } else {
            i29 = i26;
            String str19 = r16;
            str12 = "";
            int i48 = i28;
            str13 = str11;
            if (1 == i3) {
                f16.M0 = false;
                i36 = this.f72607a.requestVideo(str15, 0L, com.tencent.av.app.q.a(), i3, i16, str2, str3, str4, i29, str5, str6, j16, bArr, string, str7, str8, i18, i19, str9, i38, i48, str19);
                sessionInfo = f16;
            } else {
                sessionInfo = f16;
                i36 = -1;
            }
        }
        zv.b.a().f453506i0 = sessionInfo.M0;
        QLog.d(D, 1, "request result = " + i36 + ", uinType = " + i17 + ", accostType = " + i29);
        if (i36 == 0) {
            sessionInfo.n0(str13, 1);
            sessionInfo.f73067q = i17;
            sessionInfo.f73075s = i29;
            int i49 = sessionInfo.f73035i;
            if (i49 == 3 || i49 == 4) {
                i37 = 1;
                j17 = j3;
            } else {
                i37 = 1;
                j17 = j3;
                sessionInfo.X(j17, SystemClock.elapsedRealtime());
            }
            AVControllerCommon.D().d0();
            AVControllerCommon.D().f0(sessionInfo.f73030h, sessionInfo.M0 ? i37 : 2, false, false, true);
            sessionInfo.f73008c0 = -1;
            z16 = false;
            this.f72611e = false;
            if (!sessionInfo.H2) {
                p1(j17, sessionInfo.f73091w);
                AVControllerCommon.D().v0();
            }
        } else {
            i37 = 1;
            z16 = false;
        }
        sessionInfo.f73073r1 = z16;
        C0(str15, 2, sessionInfo.F);
        C0(str15, i37, 0L);
        A1("deviceMemory", com.tencent.av.business.manager.report.c.s() + str12);
        A1("manufacturer", Build.MANUFACTURER);
        A1("qqVersion", AppSetting.j(VideoAppInterface.N().getApp().getApplicationContext()));
        if (this.f72620n != null) {
            this.f72620n.m();
        }
        this.f72620n = new VideoCallStateMonitor(VideoAppInterface.N(), str15);
        return i36;
    }

    public AVChatBgSwitchLoadingManager J() {
        if (F == null) {
            F = new AVChatBgSwitchLoadingManager();
        }
        return F;
    }

    public AVChatAvatarEasterEggManager K() {
        if (E == null) {
            E = new AVChatAvatarEasterEggManager();
        }
        return E;
    }

    public void K0(int i3) {
        if (this.f72630x) {
            return;
        }
        boolean k3 = AVAvatarResMgr.v().k();
        QLog.i(D, 1, "requestDownloadAvatarResIfNeed. isAllAvatarResValid: " + k3);
        SessionInfo f16 = n.e().f();
        if (f16 != null) {
            f16.F2 = k3;
        }
        if (k3) {
            AVAvatarResMgr.v().F(new c(), 3000);
        } else if (!AVAvatarResMgr.v().z()) {
            J0(i3);
        }
    }

    public void L0(String str) {
        VcControllerImpl vcControllerImpl;
        if (QLog.isColorLevel()) {
            QLog.d(D, 2, "resumeVideo SessionType :" + n.e().f().f73035i);
        }
        try {
            NtrtcVideoRender.getInstance().clearCameraFrames();
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
        }
        if (n.e().f().f73035i > 0 && n.e().f().f73035i <= 2) {
            if ((!n.e().f().z() && n.e().f().f73098x2) || (vcControllerImpl = this.f72607a) == null) {
                return;
            }
            vcControllerImpl.resumeVideo(str);
        }
    }

    public void M0(String str) {
        long x16 = AVControllerCommon.D().x(str);
        QLog.d(D, 1, "send0x211C2CMsg_Audio_start roomId = " + x16);
        if (VideoAppInterface.N() != null) {
            Intent intent = new Intent();
            intent.setAction("tencent.video.v2q.AudioEngineReady");
            intent.putExtra("peerUin", str);
            intent.putExtra("roomId", x16);
            intent.setPackage(VideoAppInterface.N().getApp().getPackageName());
            AVControllerCommon.D().e0(intent);
            VideoAppInterface.N().k0(new Object[]{36});
        }
    }

    public int N() {
        return this.f72626t;
    }

    public int N0(int i3, String str) {
        boolean z16 = n.e().f().z();
        QLog.w(D, 1, "sendAVFunChatMsg, type[" + i3 + "], data[" + str + "], isConnected[" + z16 + "]");
        if (!z16) {
            return 0;
        }
        return this.f72607a.sendAVFunChatMsg(n.e().f().f73091w, i3, str);
    }

    public long O() {
        return P(n.e().f());
    }

    public int O0(int i3, byte[] bArr) {
        int length;
        boolean z16 = n.e().f().z();
        if (QLog.isDevelopLevel()) {
            String str = D;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("sendAVFunChatMsg, type[");
            sb5.append(i3);
            sb5.append("], isConnected[");
            sb5.append(z16);
            sb5.append("], dataLen[");
            if (bArr == null) {
                length = 0;
            } else {
                length = bArr.length;
            }
            sb5.append(length);
            sb5.append("]");
            QLog.i(str, 4, sb5.toString());
        }
        if (!z16) {
            return 0;
        }
        return this.f72607a.sendAVFunChatMsg(n.e().f().f73091w, i3, bArr);
    }

    public long P(SessionInfo sessionInfo) {
        if (sessionInfo == null) {
            return 0L;
        }
        long b16 = sessionInfo.b();
        int i3 = sessionInfo.f73035i;
        if (i3 == 1 || i3 == 2) {
            return AVControllerCommon.D().x(sessionInfo.f73091w);
        }
        return b16;
    }

    public void P0(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i(D, 2, "sendAVZplanAvatarAbility isSupportZplanAvatar:" + z16);
        }
        N0(16, new ZplanAvatarAbilitySupportStatus(z16 ? 1 : 0).b());
    }

    public void Q0(final boolean z16, final int i3, final int i16, final String str) {
        if (QLog.isColorLevel()) {
            QLog.i(D, 2, "sendAVZplanAvatarSwitchRequest enable:" + z16 + " width: " + i3 + " height: " + i16 + " bgId:" + str);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.DAVController.18
            @Override // java.lang.Runnable
            public void run() {
                for (int i17 = 0; i17 < 2; i17++) {
                    DAVController.this.N0(17, new ZplanAvatarStatus(z16 ? 1 : 0, i3, i16, str).b());
                }
                VideoAppInterface.N().j0(19, null);
                VideoAppInterface.N().k0(new Object[]{Integer.valueOf(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARED), Boolean.valueOf(z16)});
                DAVController.this.f1();
            }
        }, 16, null, true);
    }

    public void R0(int i3, String str, long j3, int i16) {
        if (VideoAppInterface.N() != null) {
            QLog.d(D, 1, "sendAnotherChatingBroadcast session:" + i16 + ", peerUin:" + str + "\uff0c roomid\uff1a" + j3);
            SessionInfo i17 = n.e().i(n.b(n.h(i3), str, new int[0]));
            if (i17 == null) {
                i17 = n.e().f();
            }
            Intent intent = new Intent();
            intent.setAction("tencent.av.v2q.AnotherTerChating");
            intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, i16);
            if (i17.f73039j == i16 && str.equalsIgnoreCase(i17.f73091w) && i17.G) {
                intent.putExtra("isReceiver", true);
            }
            intent.putExtra("uinType", i3);
            intent.putExtra("peerUin", str);
            intent.putExtra("bindType", i17.B0);
            intent.putExtra("bindId", i17.D0);
            intent.putExtra("roomId", j3);
            intent.setPackage(VideoAppInterface.N().getApp().getPackageName());
            AVControllerCommon.D().e0(intent);
        }
    }

    public long S() {
        if (this.f72607a == null) {
            QLog.e(D, 1, "getOnPeerFrameRenderEndFunctionPtr failed. mVcCtrl == null.");
            return 0L;
        }
        return NtrtcVideo.getInstance().getOnPeerFrameRenderEndFunctionPtr();
    }

    public void S0(int i3) {
        SessionInfo f16 = n.e().f();
        if (VideoAppInterface.N() != null) {
            Intent intent = new Intent();
            intent.setAction("tencent.av.v2q.AvSwitch");
            intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, i3);
            intent.putExtra("uinType", f16.f73067q);
            intent.putExtra("peerUin", f16.f73091w);
            intent.putExtra("extraUin", f16.f73103z);
            intent.putExtra("relationType", f16.S0);
            long j3 = f16.P0;
            if (j3 == 0 && f16.f73067q == 0) {
                intent.putExtra("relationId", AVUtil.q(f16.f73091w));
            } else {
                intent.putExtra("relationId", j3);
            }
            intent.putExtra("isDoubleVideoMeeting", f16.f73060o0);
            intent.setPackage(VideoAppInterface.N().getApp().getPackageName());
            AVControllerCommon.D().e0(intent);
        }
        if (QLog.isColorLevel()) {
            QLog.i(D, 2, "sendAvSwitchBroadcast, sessionType[" + i3 + "], peer[" + f16.f73091w + "], type[" + f16.f73035i + "], uinType[" + f16.f73067q + "], relationType[" + f16.S0 + "], relationId[" + f16.P0 + "]");
        }
    }

    public int T(String str) {
        int i3;
        SessionInfo d16 = n.e().d(str);
        if (d16 != null && (i3 = d16.f73070q2) != -1 && i3 != 0) {
            return i3;
        }
        VcControllerImpl vcControllerImpl = this.f72607a;
        if (vcControllerImpl == null) {
            return -1;
        }
        return vcControllerImpl.getPeerSdkVersion(str);
    }

    void T0() {
        if (VideoAppInterface.N() != null) {
            Intent intent = new Intent();
            intent.setAction("tencent.video.q2v.sdk.onRequestVideo");
            intent.setPackage(VideoAppInterface.N().getApp().getPackageName());
            AVControllerCommon.D().e0(intent);
        }
    }

    public int U(String str) {
        int i3;
        SessionInfo d16 = n.e().d(str);
        if (d16 != null && (i3 = d16.f73074r2) != -1 && i3 != 0) {
            return i3;
        }
        VcControllerImpl vcControllerImpl = this.f72607a;
        if (vcControllerImpl == null) {
            return -1;
        }
        return vcControllerImpl.getPeerTerminalType(str);
    }

    void U0(long j3, String str, String str2, int i3) {
        int i16;
        boolean z16;
        String str3 = str2;
        SessionInfo i17 = n.e().i(str);
        QLog.w(D, 1, "sendDoubleChatMsgToMQQ, sessionId[" + str + "], peerUin[" + str3 + "], type[" + i3 + "], seq[" + j3 + "], \nsession[" + i17 + "]", new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
        if (i17 != null && (!i17.f73073r1 || i17.f73055n)) {
            int i18 = n.e().i(str).f73067q;
            String str4 = i17.f73103z;
            if (!TextUtils.isEmpty(i17.f73091w) && str3 != null && i17.f73091w.contains(str3)) {
                str3 = i17.f73091w;
            }
            String str5 = str3;
            if (AVControllerCommon.D().f72571b.e()) {
                if (this.f72615i) {
                    i16 = 0;
                } else {
                    i16 = 9500;
                }
            } else {
                i16 = i18;
            }
            if (i17.f73039j == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!VideoAppInterface.N().c0()) {
                AVControllerCommon.D().h0(str, i16, i3, z16, str5, str4, false);
                if (i3 == 12 && !TextUtils.isEmpty(n.e().f().B)) {
                    AVControllerCommon.D().h0(str, i16, 66, z16, str5, str4, false);
                }
            } else if (i17.f73055n) {
                AVControllerCommon.D().h0(str, i16, i3, z16, str5, str4, false);
            }
            if (MAVController.Y().f72699a) {
                AVControllerCommon.D().g0("sendDoubleChatMsgToMQQ_1", str, i16, str5, str4, 1, n.e().f().Y0, false, true);
            } else if (VideoAppInterface.N().c0()) {
                AVControllerCommon.D().g0("sendDoubleChatMsgToMQQ_2", str, i16, str5, str4, 2, n.e().i(str).Y0, true, true);
            } else {
                AVControllerCommon.D().g0("sendDoubleChatMsgToMQQ_3", str, i16, str5, str4, 0, n.e().i(str).Y0, false, true);
            }
            i17.f73073r1 = true;
            i17.f73055n = false;
        }
    }

    public ax.j V() {
        return this.f72616j;
    }

    public void W(boolean z16, boolean z17) {
        String str;
        ax.j jVar = this.f72616j;
        if (jVar != null) {
            if (z16) {
                if (z17) {
                    str = VideoAppInterface.N().getCurrentAccountUin();
                } else {
                    str = n.e().f().f73091w;
                }
                if (TextUtils.isEmpty(str)) {
                    QLog.e(D, 1, "handleAvatarView add AvatarView error : uin is empty!!!");
                    return;
                } else {
                    this.f72616j.t(z17, str);
                    return;
                }
            }
            jVar.i0(z17);
        }
    }

    public void W0(int i3, String str, String str2, String str3, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(D, 2, "sendLeaveMsg uinType: " + i3 + ", friendUin: " + str + ", friendName: " + str2 + ", extraUin: " + str3 + ", isPtt: " + z16);
        }
        if (VideoAppInterface.N() != null) {
            Intent intent = new Intent();
            intent.setAction("tencent.video.v2q.leaveMsg");
            intent.putExtra("uinType", i3);
            intent.putExtra("friendUin", str);
            intent.putExtra("friendName", str2);
            if (i3 != 1006 || str3 != null) {
                str = str3;
            }
            intent.putExtra("extraUin", str);
            intent.putExtra("isPtt", z16);
            intent.setPackage(VideoAppInterface.N().getApp().getPackageName());
            AVControllerCommon.D().e0(intent);
        }
    }

    public void X(AVFilamentTextureView aVFilamentTextureView, boolean z16, final Rect rect, final int i3) {
        boolean z17;
        if (z16) {
            k1();
            if (this.f72616j == null) {
                this.f72616j = new ax.j(VideoAppInterface.N().getApp().getApplicationContext());
                if (this.f72617k == null) {
                    this.f72617k = new ZplanAvatarRenderTipsListener(aVFilamentTextureView.getContext(), VideoAppInterface.N());
                }
                this.f72618l = null;
                final WeakReference weakReference = new WeakReference(aVFilamentTextureView);
                this.f72618l = new Runnable() { // from class: com.tencent.av.DAVController.21
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        DAVController.this.m0((AVFilamentTextureView) weakReference.get(), rect, i3);
                    }
                };
                this.f72616j.l0(this.f72617k);
                AVControllerCommon.D();
                boolean N = AVControllerCommon.N(VideoAppInterface.N().getApp().getApplicationContext());
                if (i3 == 1 && !SmallScreenUtils.r(VideoAppInterface.N().getApp().getApplicationContext())) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                QLog.d(D, 1, "[handleFilamentView] isNotAllowedInSmallScreen=" + z17 + " isScreenLocked=" + N + " videoLayerType=" + i3);
                if (!N && !z17 && i3 != 1) {
                    aVFilamentTextureView.post(this.f72618l);
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(this.f72618l);
                }
                y1();
                return;
            }
            return;
        }
        if (this.f72618l != null) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.f72618l);
            aVFilamentTextureView.removeCallbacks(this.f72618l);
            this.f72618l = null;
        }
        r1();
        ax.j jVar = this.f72616j;
        if (jVar != null) {
            jVar.g0();
            final ax.j jVar2 = this.f72616j;
            this.f72616j = null;
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.av.DAVController.22
                @Override // java.lang.Runnable
                public void run() {
                    ax.j jVar3 = jVar2;
                    if (jVar3 != null) {
                        jVar3.d0();
                    }
                }
            }, 200L);
        }
        AVChatAvatarEasterEggManager aVChatAvatarEasterEggManager = E;
        if (aVChatAvatarEasterEggManager != null) {
            aVChatAvatarEasterEggManager.w();
        }
        AVChatBgSwitchLoadingManager aVChatBgSwitchLoadingManager = F;
        if (aVChatBgSwitchLoadingManager != null) {
            aVChatBgSwitchLoadingManager.k();
        }
    }

    void X0(int i3, String str, String str2, byte[] bArr) {
        if (QLog.isColorLevel()) {
            QLog.d(D, 2, "sendMsgSigBroadcast uinType: " + i3 + ", peerUin: " + str + ", extraUin: " + str2 + ", sig = " + bArr);
        }
        if (VideoAppInterface.N() != null) {
            Intent intent = new Intent();
            intent.setPackage(VideoAppInterface.N().getApp().getPackageName());
            intent.setAction("tencent.video.v2q.AddMsgSig");
            intent.putExtra("uinType", i3);
            intent.putExtra("peerUin", str);
            intent.putExtra("extraUin", str2);
            intent.putExtra(PreloadTRTCPlayerParams.KEY_SIG, bArr);
            AVControllerCommon.D().e0(intent);
        }
    }

    public boolean Y(String str) {
        return this.f72610d.contains(str);
    }

    public void Y0(long j3, long j16) {
        if (this.f72607a == null) {
            QLog.w(D, 1, "QueryRoomInfo failed. mVcCtrl == null.");
            return;
        }
        SessionInfo f16 = n.e().f();
        if (!TextUtils.isEmpty(f16.f73091w) && (!f16.f73091w.equals(String.valueOf(j16)) || f16.f73035i == 0)) {
            int sendQueryRoomInfoRequest = NtrtcSession.getInstance().sendQueryRoomInfoRequest(j3, j16);
            QLog.w(D, 1, "QueryRoomInfo1, result[" + sendQueryRoomInfoRequest + "]");
            return;
        }
        if (n.e().c() == 0 && TextUtils.isEmpty(f16.f73030h) && TextUtils.isEmpty(f16.f73091w)) {
            int sendQueryRoomInfoRequest2 = NtrtcSession.getInstance().sendQueryRoomInfoRequest(j3, j16);
            QLog.w(D, 1, "QueryRoomInfo2, result[" + sendQueryRoomInfoRequest2 + "]");
            return;
        }
        QLog.w(D, 1, "QueryRoomInfo fail, mainSession[" + n.e().f() + "]");
    }

    public synchronized boolean Z() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        QLog.d(D, 1, String.format("initVcController mVcCtrl=%s", this.f72607a));
        try {
            if (this.f72607a == null) {
                String currentAccountUin = VideoAppInterface.N().getCurrentAccountUin();
                if (!TextUtils.isEmpty(currentAccountUin)) {
                    VcControllerImpl vcControllerImpl = new VcControllerImpl(VideoAppInterface.N().getApp().getApplicationContext(), String.valueOf(AppSetting.f()), AVControllerCommon.D().f72571b, this);
                    if (AVSoUtils.A()) {
                        NtrtcSession.getInstance().setCallback(new NtrtcSessionCallbackImpl());
                        NtrtcRoom.getInstance().setCallback(new j());
                        NtrtcAudio.getInstance().setCallback(new h());
                        NtrtcVideo.getInstance().setCallback(new k());
                    }
                    ClientLogReport.instance().setAppInterface(VideoAppInterface.N());
                    aa aaVar = new aa(false);
                    NtrtcAppParam b16 = aaVar.b(VideoAppInterface.N().getApp().getPackageName());
                    NtrtcNetworkParam e16 = aaVar.e(com.tencent.mobileqq.vip.e.b(VideoAppInterface.N().getCurrentAccountUin()));
                    NtrtcAudioParam c16 = aaVar.c();
                    NtrtcVideoParam f16 = aaVar.f();
                    NtrtcCommonParam d16 = aaVar.d();
                    i iVar = new i();
                    int init = NtrtcEngine.getInstance().init(VideoAppInterface.N().getApp().getApplicationContext(), currentAccountUin, b16, e16, c16, f16, d16, iVar);
                    String str = c16.traeSoFullFilename;
                    if (init != -49) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    AVSoUtils.K(str, z18, 0);
                    if (init != 0) {
                        QLog.e(D, 1, "DAVEngine init failed. result: " + init);
                        NtrtcEngine.getInstance().uninit();
                        if (init == -49) {
                            c16.traeSoFullFilename = AVSoUtils.J(c16.traeSoFullFilename);
                        }
                        QLog.i(D, 1, "DAVEngine reinit start.");
                        int init2 = NtrtcEngine.getInstance().init(VideoAppInterface.N().getApp().getApplicationContext(), currentAccountUin, b16, e16, c16, f16, d16, iVar);
                        QLog.i(D, 1, "DAVEngine reinit end. result: " + init2);
                        String str2 = c16.traeSoFullFilename;
                        if (init2 != -49) {
                            z26 = true;
                        } else {
                            z26 = false;
                        }
                        AVSoUtils.K(str2, z26, 1);
                    }
                    NtrtcUtil.getInstance().updateProcessInfo(0L, "manufacturer", Build.MANUFACTURER);
                    if (c16.aiDenoiseModelDir != "") {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    ea.l3(z19);
                    Context applicationContext = VideoAppInterface.N().getApp().getApplicationContext();
                    String str3 = AppSetting.f99551k;
                    PerfReporter.i(applicationContext, currentAccountUin, str3);
                    QLog.w(D, 1, "initVcController, AppSetting.subVersion:=" + str3);
                    this.f72607a = vcControllerImpl;
                } else {
                    QLog.e(D, 1, "initVcController selfUin invalid.");
                    AVSoUtils.I();
                }
            }
            z16 = true;
        } catch (Throwable th5) {
            z16 = true;
            QLog.e(D, 1, "initVcController fail.", th5);
            this.f72607a = null;
            AVSoUtils.I();
        }
        if (this.f72607a != null) {
            z17 = z16;
        } else {
            z17 = false;
        }
        return z17;
    }

    public void Z0(int i3, String str, String str2, String str3, String str4, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(D, 2, "sendReplyMsgToAio uinType: " + i3 + ", friendUin: " + str + ", friendName: " + str2 + ", extraUin: " + str3 + ", replyMsg: " + str4 + ", isDiyMsg: " + z16);
        }
        if (VideoAppInterface.N() != null) {
            Intent intent = new Intent();
            intent.setAction("tencent.video.v2q.replyMsg");
            intent.putExtra("uinType", i3);
            intent.putExtra("friendUin", str);
            intent.putExtra("friendName", str2);
            if (i3 != 1006 || str3 != null) {
                str = str3;
            }
            intent.putExtra("extraUin", str);
            intent.putExtra("replyMsg", str4);
            intent.putExtra("isDiyMsg", z16);
            intent.setPackage(VideoAppInterface.N().getApp().getPackageName());
            AVControllerCommon.D().e0(intent);
        }
    }

    @Override // com.tencent.av.core.d
    public void a(String str, int i3, byte[] bArr) {
        if (QLog.isDevelopLevel()) {
            QLog.w(D, 1, "\u6536\u5230\u672a\u77e5\u7684C2C\u6d88\u606f[" + i3 + "], handlerForVideo[false]");
        }
    }

    public void a0(AVFilamentTextureView aVFilamentTextureView) {
        if (this.f72616j != null) {
            QLog.i(D, 2, "initZPlanRenderView");
            this.f72616j.K(aVFilamentTextureView);
        } else {
            QLog.e(D, 1, "initZPlanRenderView failed");
        }
    }

    public int a1(byte[] bArr, long j3) {
        if (!n.e().f().z()) {
            QLog.e(D, 1, "sendSuperAvatarMsg, is not Connected");
            return 0;
        }
        long handleAndParseUin = this.f72607a.handleAndParseUin(n.e().f().f73091w);
        if (handleAndParseUin == -1) {
            return -1;
        }
        return NtrtcRoom.getInstance().sendSuperAVAvatarMsg(handleAndParseUin, bArr, j3);
    }

    @Override // com.tencent.av.core.d
    public void b(String str, String str2) {
        VideoAppInterface.N().k0(new Object[]{162, str, str2});
    }

    public boolean b0() {
        ZplanAvatarRenderTipsListener zplanAvatarRenderTipsListener = this.f72617k;
        if (zplanAvatarRenderTipsListener != null && zplanAvatarRenderTipsListener.f()) {
            return true;
        }
        return false;
    }

    public void b1(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(D, 2, "setAgreeUseCellularForQuality isAgree: " + z16);
        }
        try {
            if (this.f72607a != null) {
                NtrtcEngine.getInstance().setAgreeUseCellularForQuality(z16);
            }
        } catch (UnsatisfiedLinkError e16) {
            QLog.e(D, 1, "setAgreeUseCellularForQuality UnsatisfiedLinkError[" + e16.getMessage() + "]");
        }
    }

    @Override // com.tencent.av.core.d
    public void c(final String str, final String str2) {
        if (QLog.isColorLevel()) {
            QLog.i(D, 2, "onReceivePeerZPlanAvatarStatus zplanAvatarStatus: " + str2);
        }
        if (!ax.a.c(VideoAppInterface.N())) {
            QLog.i(D, 2, "onReceivePeerZPlanAvatarStatus no support user");
        } else if (AVAvatarResMgr.v().k()) {
            p0(str, str2);
        } else {
            AVAvatarResMgr.v().F(new AVAvatarResMgr.c() { // from class: com.tencent.av.DAVController.16
                @Override // com.tencent.av.zplan.avatar.resmgr.AVAvatarResMgr.c
                public void onRequestFinish(final boolean z16) {
                    QLog.i(DAVController.D, 1, "requestCDNServerUseState.onRequestFinish. isCDNOverload: " + z16);
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.av.DAVController.16.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z16) {
                                QQToast.makeText(VideoAppInterface.N().getApplicationContext(), R.string.f1786837b, 0).show();
                            } else {
                                AnonymousClass16 anonymousClass16 = AnonymousClass16.this;
                                DAVController.this.p0(str, str2);
                            }
                        }
                    });
                }
            }, 3000);
        }
    }

    public int c1(int i3, int i16, int i17, int i18) {
        if (n.e().f().f73035i != 1 && n.e().f().f73035i != 2) {
            return -1;
        }
        return NtrtcAudio.getInstance().setAudioDataFormat(i3, i16, i17, i18);
    }

    @Override // com.tencent.av.core.d
    public void d(String str) {
        VideoAppInterface.N().k0(new Object[]{129, str});
    }

    public boolean d0() {
        return this.f72608b;
    }

    public int d1(boolean z16, String str) {
        if (this.f72607a == null) {
            return -1;
        }
        if (QLog.isColorLevel()) {
            QLog.d(D, 2, String.format("setAudioInputMute enable=%s uin=%s", Boolean.valueOf(z16), str));
        }
        VideoRecoveryMonitor T = VideoAppInterface.N().T();
        if (T != null) {
            T.d();
        }
        return this.f72607a.setAudioInputMute(str, z16);
    }

    @Override // com.tencent.av.core.d
    public void e(String str) {
        VideoAppInterface.N().k0(new Object[]{131, str});
    }

    public boolean e0() {
        if (this.f72607a == null) {
            return false;
        }
        return true;
    }

    public int e1(boolean z16, String str) {
        VcControllerImpl vcControllerImpl = this.f72607a;
        if (vcControllerImpl == null) {
            return -1;
        }
        return vcControllerImpl.setAudioOutput(str, z16);
    }

    @Override // com.tencent.av.core.d
    public void f(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.i(D, 2, "onNotifyZPlanHomeStatus zplanStatus: " + str2);
        }
        n.e().f().J2 = "1".equals(str2);
        VideoAppInterface.N().k0(new Object[]{1001});
    }

    public boolean f0(String str) {
        int U = U(str);
        if (U != 5 && U != 14) {
            return false;
        }
        return true;
    }

    public void f1() {
        int i3;
        SessionInfo f16 = n.e().f();
        if (f16 == null) {
            QLog.e(D, 2, "setAvChatScene session null");
            return;
        }
        int i16 = 0;
        if (f16.f73098x2) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        if (f16.f73102y2) {
            i16 = 2;
        }
        if (QLog.isColorLevel()) {
            QLog.d(D, 2, "setAvChatScene selfAVChatScene: " + i3 + " peerAVChatScene: " + i16);
        }
        if (this.f72607a != null) {
            NtrtcRoom.getInstance().setAVChatScene(i3, i16);
        }
    }

    @Override // com.tencent.av.core.d
    public void g(int i3, String str) {
        AVCoreLog.printAllUserLog(D, String.format("onReceiveMagicface|type=%d, id=%s", Integer.valueOf(i3), str));
        if (VideoAppInterface.N().A() != null) {
            boolean b16 = VideoAppInterface.N().A().b();
            QLog.w(D, 1, "onReceiveMagicface can be handled: " + b16);
        }
        VideoAppInterface.N().k0(new Object[]{6103, Integer.valueOf(i3), str});
    }

    public void g0(int i3, boolean z16, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.d(D, 2, "notifyOtherTerminalChatStatus time:" + i3 + ", camera:" + z16 + ", mic:" + z17);
        }
        int i16 = (i3 & 1048575) + ((z16 ? 1 : 0) << 20) + ((z17 ? 1 : 0) << 21);
        if (this.f72607a != null && n.e().f().f73091w != null) {
            try {
                NtrtcEngine.getInstance().notifyAnotherTerChatStatus(Long.parseLong(n.e().f().f73091w), i16);
            } catch (NumberFormatException e16) {
                com.tencent.qav.log.a.c(D, "expection[" + e16.getMessage() + "]", new Throwable("stack trace"));
            }
        }
    }

    public int g1(int i3, int i16, int i17) {
        if (QLog.isColorLevel()) {
            QLog.d(D, 2, "setGatewayTestResult networkType:" + i3 + " | signalStrength:" + i16 + " | pingResult:" + i17);
        }
        return this.f72607a.setNativeGatewayTestResult(i3, i16, i17);
    }

    @Override // com.tencent.avcore.engine.dav.IDavEventListener
    public int getAPAndGateWayIP() {
        return com.tencent.av.app.q.a();
    }

    @Override // com.tencent.avcore.engine.dav.IDavEventListener
    public long getMSFInviteMessageTimeStamp(long j3) {
        long j16;
        if (this.f72614h.containsKey(Long.valueOf(j3))) {
            j16 = this.f72614h.get(Long.valueOf(j3)).longValue();
        } else {
            j16 = 0;
        }
        QLog.d(D, 1, String.format("getMSFInviteMessageTimeStamp uin=%s msfTimestamp=%s", Long.valueOf(j3), Long.valueOf(j16)));
        return j16;
    }

    @Override // com.tencent.av.core.d
    public void h(byte[] bArr) {
        int g16 = DoodleLogic.b().g(bArr);
        if (g16 == 1) {
            VideoAppInterface.N().k0(new Object[]{127});
        }
        if (g16 == 2 && n.e().f().Y2) {
            VideoAppInterface.N().k0(new Object[]{164, 1});
        }
    }

    public void h0() {
        if (this.f72607a != null) {
            NtrtcEngine.getInstance().onProcessExit();
        }
    }

    public int h1(int i3) {
        if (!n.e().f().z()) {
            return 0;
        }
        return this.f72607a.setGroundGlassSwitch(n.e().f().f73091w, i3);
    }

    @Override // com.tencent.av.core.d
    public void i(String str, String str2) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.i(D, 2, "onReceivePeerZPlanAvatarAbility zplanAvatarAbility: " + str2);
        }
        ZplanAvatarAbilitySupportStatus a16 = ZplanAvatarAbilitySupportStatus.a(str2);
        if (a16 == null) {
            QLog.i(D, 2, "onReceivePeerZPlanAvatarAbility convert null");
            return;
        }
        QLog.i(D, 2, a16.b());
        if (a16.getSupportStatus() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        n.e().f().C2 = a16.getSupportStatus();
        VideoAppInterface.N().k0(new Object[]{Integer.valueOf(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARE_FAILED), str, Boolean.valueOf(z16)});
    }

    public void i0(boolean z16) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.i(D, 2, "notifyZplanHomeStatusC2C isInZplanHome:" + z16);
        }
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        N0(15, str);
    }

    public void i1(String str, long j3) {
        try {
            QLog.d(D, 1, String.format("setMSFInviteMessageTimeStamp uin=%s msfTimestamp=%s", str, Long.valueOf(j3)));
            long longValue = Long.valueOf(str).longValue();
            if (longValue > 0 && j3 > 0) {
                R().f72614h.put(Long.valueOf(longValue), Long.valueOf(j3));
            }
        } catch (Throwable th5) {
            QLog.d(D, 1, "setMSFInviteMessageTimeStamp fail.", th5);
        }
    }

    @Override // com.tencent.avcore.engine.dav.IDavEventListener
    public int isOfflineSession(String str) {
        SessionInfo f16 = n.e().f();
        if (f16 != null && f16.f73055n) {
            return 1;
        }
        return 0;
    }

    @Override // com.tencent.av.core.VcControllerImpl.c
    public void j(int i3) {
        QLog.d(D, 1, "closeVideo timeout. force to exitProcess. closeReason = " + i3);
        AVControllerCommon.D().t(261);
    }

    public void j0(String str, long j3) {
        final long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.w(D, 2, "onChannelReady, fromUin[" + str + "], mStartRing[" + this.f72621o + "], seq[" + d16 + "]");
        }
        if (VideoAppInterface.N() == null) {
            return;
        }
        final SessionInfo f16 = n.e().f();
        int i3 = f16.S0;
        if (i3 == 1 || i3 == 2 || i3 == 0 || i3 == 100) {
            i3 = 3;
        }
        if (AVControllerCommon.D().j("onChannelReady", false, i3, str)) {
            f16 = n.e().f();
        }
        QLog.i(D, 1, "onChannelReady, fromUin[" + str + "], roomId[" + j3 + "], session[" + f16 + "]");
        String r16 = f16.r("onChannelReady");
        f16.f73087v = true;
        if (f16.G) {
            RtcNodeReportReceiverHelper.n(r16, NodeModel$EndStatusCode.K_NORMAL.ordinal(), NodeModel$NodeEndReason.K_NORMAL.ordinal());
        } else {
            com.tencent.avcore.rtc.node.report.utils.b.n(r16, NodeModel$EndStatusCode.K_NORMAL.ordinal(), NodeModel$NodeEndReason.K_NORMAL.ordinal());
        }
        com.tencent.avcore.rtc.node.report.utils.c.d(r16, j3);
        if (this.f72621o != null) {
            VideoAppInterface.N().M().removeCallbacks(this.f72621o);
            this.f72621o = null;
        }
        if (com.tencent.av.utils.e.j()) {
            SignalStrengthReport.e(VideoAppInterface.N().getApp().getApplicationContext()).o();
        }
        if (1 == f16.f73076s0) {
            AVControllerCommon.D().f72574e.k0(d16);
            if (f16.M0 && f16.G) {
                AVControllerCommon.D().f72574e.i0(TraeConstants.VOICE_CALL_CONFIG);
            }
            d1(true, f16.f73091w);
            return;
        }
        AVControllerCommon.D().f72574e.k0(d16);
        if (f16.f73067q != 1011) {
            TraeHelper.j0(VideoAppInterface.N(), true, d16);
        }
        f16.h0(this.f72607a.getPeerSdkVersion(str));
        f16.i0(this.f72607a.getPeerTerminalType(str));
        f16.d(j3);
        s1();
        f16.f73051m = f16.f73043k;
        int i16 = 4;
        f16.n0("onChannelReady", 4);
        f16.X(d16, SystemClock.elapsedRealtime());
        if (f16.G) {
            if (f16.M0) {
                AVControllerCommon.D().f72574e.i0(TraeConstants.VOICE_CALL_CONFIG);
            } else {
                AVControllerCommon.D().f72574e.i0(TraeConstants.VIDEO_CALL_CONFIG);
            }
        }
        VideoNodeReporter videoNodeReporter = (VideoNodeReporter) VideoAppInterface.N().B(4);
        if (f16.G) {
            i16 = 11;
        }
        videoNodeReporter.w(f16.b(), i16, 1L);
        if (VideoAppInterface.N() != null && VideoAppInterface.N().r() > 0) {
            VideoAppInterface.N().k0(new Object[]{13, Long.valueOf(d16)});
        }
        if (!f16.H2) {
            AVControllerCommon.D().v0();
        }
        QAVControllerForZplan.p().t(VideoAppInterface.N().getApp().getApplicationContext(), new e(f16));
        if (f16.K) {
            d1(true, f16.f73091w);
        } else {
            d1(false, f16.f73091w);
        }
        VideoAppInterface.N().M().postDelayed(new Runnable() { // from class: com.tencent.av.DAVController.4
            @Override // java.lang.Runnable
            public void run() {
                SessionInfo f17 = n.e().f();
                if (f17.G && f17.S && f17.f73035i == 2) {
                    f17.c0(d16, false);
                    DAVController.this.f72607a.pauseVideo(f17.f73091w);
                }
            }
        }, 50L);
        AVControllerCommon.D().f0(f16.f73030h, f16.f73035i, true, true, true);
        DataReport.W();
        DataReport.X(true);
        DataReport.b0(true);
        ea.W0(VideoAppInterface.N().getCurrentAccountUin()).edit().putLong("qav_roomid", AVControllerCommon.D().A()).commit();
        j1(false);
        VideoRecoveryMonitor T = VideoAppInterface.N().T();
        if (T != null) {
            T.b();
        }
        if (this.f72620n != null) {
            this.f72620n.l();
        }
        ChatRoomMng D2 = VideoAppInterface.N().D();
        if (D2 != null) {
            D2.f(f16);
        }
        if (!f16.G) {
            AVControllerCommon.D().b0(1);
        }
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.av.DAVController.5
            @Override // java.lang.Runnable
            public void run() {
                boolean c16 = ax.a.c(VideoAppInterface.N());
                QLog.i(DAVController.D, 2, "isSupportZplanAvatar " + c16);
                DAVController.this.P0(c16);
                if (f16.f73098x2) {
                    DAVController.this.Q0(true, 640, 480, "");
                }
            }
        }, 128, null, true, 1500L);
    }

    public void j1(boolean z16) {
        VideoProcessExitMonitor Q;
        if (VideoAppInterface.N() != null && (Q = VideoAppInterface.N().Q()) != null) {
            Q.w(z16);
        }
    }

    @Override // com.tencent.av.core.d
    public void k(String str) {
        VideoAppInterface.N().k0(new Object[]{132, str});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x017f, code lost:
    
        if (r34 != 43) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0270  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void k0(long j3, String str, int i3, boolean z16) {
        SessionInfo i16;
        char c16;
        int i17;
        int i18;
        int i19;
        boolean z17;
        int i26;
        QLog.w(D, 1, "avideo onCloseVideo fromUin[" + str + "], type[" + i3 + "], seq[" + j3 + "], mStartRing[" + this.f72621o + "]");
        D();
        String b16 = n.b(3, str, new int[0]);
        if (n.e().j(b16)) {
            i16 = n.e().i(b16);
        } else {
            b16 = n.b(100, str, new int[0]);
            i16 = n.e().i(b16);
        }
        String str2 = b16;
        SessionInfo sessionInfo = i16;
        if (sessionInfo == null) {
            AVCoreLog.printErrorLog(D, "onCloseVideo fail to find session");
            return;
        }
        if (sessionInfo.K() && !sessionInfo.G && i3 == 12) {
            com.tencent.avcore.rtc.node.report.utils.b.m(sessionInfo.r("onCloseVideo"), sessionInfo.W);
            com.tencent.avcore.rtc.node.report.utils.b.i(sessionInfo.r("onCloseVideo"), 5, NodeModel$NodeEndReason.K_INTERRUPTION.ordinal());
        }
        if (sessionInfo.C() && sessionInfo.G && i3 == 2) {
            RtcNodeReportReceiverHelper.s(sessionInfo.r("onCloseVideo"), 6, NodeModel$NodeEndReason.K_INTERRUPTION.ordinal());
        }
        sessionInfo.f73059o = false;
        if (this.f72620n != null) {
            this.f72620n.m();
            this.f72620n = null;
        }
        this.f72612f = false;
        B1(str, "inviteUIState", "");
        B1(str, "screenState", "");
        s1();
        if (sessionInfo.f73076s0 == 1 && (i3 == 2 || i3 == 24)) {
            c16 = 2;
            i17 = 6;
            U0(j3, str2, str, 3);
        } else {
            c16 = 2;
            i17 = 6;
            U0(j3, str2, str, i3);
        }
        if (sessionInfo.u()) {
            sessionInfo.A0 = i3;
            if (sessionInfo.u() && i3 == sessionInfo.f73035i) {
                sessionInfo.X(j3, 0L);
            }
            sessionInfo.n0("onCloseVideo.isBeInviting", i17);
            VideoAppInterface N = VideoAppInterface.N();
            Object[] objArr = new Object[4];
            objArr[0] = 14;
            objArr[1] = Integer.valueOf(i3);
            objArr[c16] = str;
            objArr[3] = Long.valueOf(j3);
            N.k0(objArr);
            E(sessionInfo.f73091w, sessionInfo.A0);
        } else if (sessionInfo.K()) {
            sessionInfo.A0 = i3;
            sessionInfo.X(j3, 0L);
            int i27 = R.raw.f169423v;
            if (i3 != 3) {
                if (i3 != 12) {
                    if (i3 != 25 && i3 != 56) {
                        if (i3 == 42) {
                            DataReport.T(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "3", "", "", "");
                        }
                        i27 = R.raw.f169422u;
                        i19 = 4;
                        z17 = false;
                        this.f72622p.f72605d = j3;
                        if (sessionInfo.H2) {
                            i27 = 0;
                        }
                        if (z16) {
                            F(n.e().f().f73091w, 212);
                            H0(212);
                            E(n.e().f().f73091w, n.e().f().A0);
                        } else {
                            AVControllerCommon D2 = AVControllerCommon.D();
                            if (z17) {
                                i26 = i19;
                            } else {
                                i26 = 3;
                            }
                            D2.V(j3, i27, i26, this.f72622p);
                        }
                        sessionInfo.n0("onCloseVideo.isInviting1", 5);
                        VideoAppInterface N2 = VideoAppInterface.N();
                        Object[] objArr2 = new Object[i19];
                        objArr2[0] = 14;
                        objArr2[1] = Integer.valueOf(i3);
                        objArr2[c16] = str;
                        objArr2[3] = Long.valueOf(j3);
                        N2.k0(objArr2);
                    } else {
                        sessionInfo.n0("onCloseVideo.isInviting", i17);
                        AVControllerCommon.D().V(j3, R.raw.f169423v, 1, L(j3));
                        VideoAppInterface N3 = VideoAppInterface.N();
                        Object[] objArr3 = new Object[4];
                        objArr3[0] = 14;
                        objArr3[1] = Integer.valueOf(i3);
                        objArr3[c16] = str;
                        objArr3[3] = Long.valueOf(j3);
                        N3.k0(objArr3);
                        return;
                    }
                } else {
                    i19 = 4;
                    if (sessionInfo.f73076s0 != 2) {
                        DataReport.T(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "1", "", "", "");
                    } else {
                        i27 = R.raw.f169423v;
                        z17 = true;
                        this.f72622p.f72605d = j3;
                        if (sessionInfo.H2) {
                        }
                        if (z16) {
                        }
                        sessionInfo.n0("onCloseVideo.isInviting1", 5);
                        VideoAppInterface N22 = VideoAppInterface.N();
                        Object[] objArr22 = new Object[i19];
                        objArr22[0] = 14;
                        objArr22[1] = Integer.valueOf(i3);
                        objArr22[c16] = str;
                        objArr22[3] = Long.valueOf(j3);
                        N22.k0(objArr22);
                    }
                }
            } else {
                i19 = 4;
                DataReport.T(null, "CliOper", "", "", "Two_video_call", "Two_video_call_cancel", 0, 0, "2", "", "", "");
            }
            i27 = R.raw.f169422u;
            z17 = false;
            this.f72622p.f72605d = j3;
            if (sessionInfo.H2) {
            }
            if (z16) {
            }
            sessionInfo.n0("onCloseVideo.isInviting1", 5);
            VideoAppInterface N222 = VideoAppInterface.N();
            Object[] objArr222 = new Object[i19];
            objArr222[0] = 14;
            objArr222[1] = Integer.valueOf(i3);
            objArr222[c16] = str;
            objArr222[3] = Long.valueOf(j3);
            N222.k0(objArr222);
        } else if (!sessionInfo.w()) {
            sessionInfo.A0 = i3;
            if (sessionInfo.u()) {
                sessionInfo.X(j3, 0L);
            }
            sessionInfo.n0("onCloseVideo.isClosing1", i17);
            if (ad.h(VideoAppInterface.N().getApp())) {
                F(sessionInfo.f73091w, 209);
                H0(209);
                E(sessionInfo.f73091w, sessionInfo.A0);
                i18 = 4;
            } else {
                i18 = 4;
                AVControllerCommon.D().V(j3, R.raw.f169423v, 1, L(j3));
                QAVNotification.l(VideoAppInterface.N()).f(str2);
            }
            VideoAppInterface N4 = VideoAppInterface.N();
            Object[] objArr4 = new Object[i18];
            objArr4[0] = 14;
            objArr4[1] = Integer.valueOf(i3);
            objArr4[c16] = str;
            objArr4[3] = Long.valueOf(j3);
            N4.k0(objArr4);
        }
        if (this.f72621o != null && VideoAppInterface.N() != null) {
            VideoAppInterface.N().M().removeCallbacks(this.f72621o);
        }
    }

    public void k1() {
        QLog.i(D, 2, "startAvatarBgUpdateTask");
        r1();
        if (VideoAppInterface.N() != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.DAVController.27
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoAppInterface.N() == null) {
                        return;
                    }
                    long Y = ((ku.b) VideoAppInterface.N().B(19)).Y();
                    if (Y != -1) {
                        QLog.i(DAVController.D, 2, "startAvatarBgUpdateTask delay: " + Y);
                        DAVController dAVController = DAVController.this;
                        dAVController.f72632z = ThreadManagerV2.executeDelay(dAVController.A, 16, null, true, 1000 * Y);
                    }
                }
            }, 16, null, true);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:37:0x00f8. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0316  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l0(String str, int i3, long j3, byte[] bArr, int i16, String str2) {
        Integer valueOf;
        int i17;
        int i18;
        int i19;
        boolean z16;
        int i26;
        SessionInfo sessionInfo;
        long d16 = com.tencent.av.utils.e.d();
        SessionInfo g16 = n.e().g(str);
        String str3 = D;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onCloseVideo, fromUin[");
        sb5.append(str);
        sb5.append("], reason[");
        sb5.append(i3);
        sb5.append("], extraParam[");
        sb5.append(j3);
        sb5.append("], buffer[");
        if (bArr == null) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(bArr.length);
        }
        sb5.append(valueOf);
        sb5.append("], seq[");
        sb5.append(d16);
        sb5.append("], Main[");
        sb5.append(n.e().f());
        sb5.append("], come[");
        sb5.append(g16);
        sb5.append("], operationCode[");
        sb5.append(i16);
        sb5.append("], traceId[");
        sb5.append(str2);
        sb5.append("]");
        int i27 = 1;
        QLog.w(str3, 1, sb5.toString());
        if (g16 == null) {
            QLog.i(D, 1, "onCloseVideo, fromUin[" + str + "], no session");
            return;
        }
        if (i3 == 21 && !TextUtils.isEmpty(str2) && !g16.G && (i16 == 1 || i16 == 3 || i16 == 5)) {
            com.tencent.avcore.rtc.node.report.utils.b.c(i16, str2);
        }
        VideoRecoveryMonitor T = VideoAppInterface.N().T();
        if (T != null) {
            T.k(i3);
        }
        AVControllerCommon.D().a0(g16.f73030h);
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        i27 = 4;
                        if (i3 != 4) {
                            if (i3 != 5) {
                                if (i3 != 14) {
                                    if (i3 != 15) {
                                        i27 = 28;
                                        if (i3 != 28) {
                                            switch (i3) {
                                                case 8:
                                                case 9:
                                                    k0(d16, str, 12, false);
                                                    return;
                                                case 10:
                                                    break;
                                                case 11:
                                                    i27 = 29;
                                                    break;
                                                case 12:
                                                    i27 = 9;
                                                    break;
                                                default:
                                                    switch (i3) {
                                                        case 18:
                                                            i27 = 10;
                                                            break;
                                                        case 19:
                                                            i27 = 39;
                                                            break;
                                                        case 20:
                                                            i27 = 21;
                                                            break;
                                                        case 21:
                                                            if (j3 == 62) {
                                                                g16.W = false;
                                                                k0(d16, str, 12, false);
                                                                return;
                                                            } else if (j3 == 61) {
                                                                g16.W = false;
                                                                k0(d16, str, 25, false);
                                                                return;
                                                            } else {
                                                                i27 = 64;
                                                                break;
                                                            }
                                                    }
                                            }
                                        } else {
                                            i27 = 62;
                                            k0(d16, str, 62, false);
                                        }
                                    } else {
                                        i27 = 35;
                                    }
                                }
                                i27 = 5;
                            } else {
                                k0(d16, str, 25, false);
                                return;
                            }
                        }
                    }
                } else {
                    if (j3 == 100) {
                        String b16 = n.b(3, str, new int[0]);
                        if (n.e().j(b16)) {
                            sessionInfo = n.e().i(b16);
                        } else {
                            sessionInfo = null;
                        }
                        if (sessionInfo != null && sessionInfo.f73043k == 1) {
                            QLog.w(D, 1, "onCloseVideo, set autoAcceptChat, seq[" + d16 + "]");
                            sessionInfo.f73059o = true;
                            return;
                        }
                    }
                    if (g16.K() && !g16.G) {
                        String r16 = g16.r("sdkClose");
                        com.tencent.avcore.rtc.node.report.utils.b.m(r16, g16.W);
                        com.tencent.avcore.rtc.node.report.utils.b.i(r16, 3, NodeModel$NodeEndReason.K_INTERRUPTION.ordinal());
                    }
                    if (j3 != 3 && j3 != WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                        i26 = 3;
                    } else {
                        i26 = 42;
                    }
                    k0(d16, str, i26, false);
                    return;
                }
            } else {
                if (j3 == 9) {
                    i19 = 43;
                } else if (j3 == 10) {
                    i19 = 54;
                } else {
                    if (j3 == 5) {
                        i19 = 49;
                        i18 = 49;
                        z16 = false;
                        i17 = 2;
                        if (j3 != 12 || j3 == 13 || j3 == 15 || j3 == 16) {
                            if (g16.f73035i == i17) {
                                DataReport.T(null, "CliOper", "", "", "0X800478B", "0X800478B", 0, 0, "", "", "", "");
                            } else {
                                DataReport.T(null, "CliOper", "", "", "0X800478F", "0X800478F", 0, 0, "", "", "", "");
                            }
                        }
                        if (i19 == i18) {
                            j1(true);
                        }
                        k0(d16, str, i19, z16);
                        return;
                    }
                    if (j3 != 12 && j3 != 16) {
                        if (j3 == 13) {
                            i19 = 50;
                        } else if (j3 == 14) {
                            if (g16.f73035i == 2) {
                                DataReport.T(null, "CliOper", "", "", "0X800478A", "0X800478A", 0, 0, "", "", "", "");
                            } else {
                                DataReport.T(null, "CliOper", "", "", "0X800478E", "0X800478E", 0, 0, "", "", "", "");
                            }
                            i19 = 51;
                        } else if (j3 == 15) {
                            i19 = 55;
                        } else if (j3 == 17) {
                            DataReport.T(null, "CliOper", "", "", "0X80049C9", "0X80049C9", 0, 0, "", "", "", "");
                            i19 = 56;
                        } else if (j3 == 6) {
                            i19 = 72;
                        } else if (j3 == 7) {
                            i19 = 24;
                        } else if (j3 == 983055) {
                            i19 = 63;
                        } else if (j3 == 907) {
                            u0(bArr);
                            i19 = 2;
                            i17 = 2;
                            z16 = true;
                            i18 = 49;
                        } else {
                            i19 = 2;
                            i18 = 49;
                            z16 = false;
                            i17 = 2;
                        }
                    } else {
                        i17 = 2;
                        i18 = 49;
                        R0(g16.f73067q, g16.f73091w, g16.f73089v1, 0);
                        i19 = 52;
                        z16 = false;
                    }
                    if (j3 != 12) {
                    }
                    if (g16.f73035i == i17) {
                    }
                    if (i19 == i18) {
                    }
                    k0(d16, str, i19, z16);
                    return;
                }
                i18 = 49;
                z16 = false;
                i17 = 2;
                if (j3 != 12) {
                }
                if (g16.f73035i == i17) {
                }
                if (i19 == i18) {
                }
                k0(d16, str, i19, z16);
                return;
            }
        } else {
            i27 = 0;
        }
        E(str, i27);
    }

    void l1() {
        if (VideoAppInterface.N() != null) {
            VideoAppInterface.N().M().postDelayed(this.f72627u, com.tencent.mobileqq.msf.core.s.G);
        }
        if (QLog.isColorLevel()) {
            QLog.i(D, 2, "startConnectingTimer");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m1(Intent intent, String str, boolean z16, boolean z17, boolean z18) {
        boolean z19;
        boolean z26;
        DAVController dAVController;
        long a16;
        AVCallCompactHelper v3 = AVControllerCommon.D().v();
        u.f("Video:StartActivity", 5000L);
        if (z16) {
            VideoAppInterface.N().getApp().startActivity(intent, ActivityOptions.makeCustomAnimation(VideoAppInterface.N().getApp(), R.anim.f154855e4, 0).toBundle());
        } else {
            VideoAppInterface.N().getApp().startActivity(intent);
        }
        IQQFloatingPermission iQQFloatingPermission = (IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class);
        VideoAppInterface.N().getApp();
        boolean checkPermission = iQQFloatingPermission.checkPermission(BaseApplication.getContext());
        boolean isAppOnForeground = ForegroundUtil.isAppOnForeground();
        if (!checkPermission && !isAppOnForeground) {
            z19 = isAppOnForeground;
            z26 = checkPermission;
            DataReport.T(null, "dc00898", "", str, "0X800C57E", "0X800C57E", n.e().f().f73035i, 0, "", "", "", "");
        } else {
            z19 = isAppOnForeground;
            z26 = checkPermission;
        }
        QLog.w(D, 1, "startInvite startActivity. hasFloatPermission: " + z26 + " GuardManager mIsInBackGroud:" + z19);
        if (v3 != null) {
            v3.m(intent);
        }
        if (z17) {
            dAVController = this;
            dAVController.B1(str, "screenState", String.valueOf(2));
        } else {
            dAVController = this;
            dAVController.B1(str, "screenState", String.valueOf(1));
        }
        dAVController.B1(str, "inviteUIState", String.valueOf(1));
        if (z18) {
            VideoAppInterface.N().v0(true, new Notification());
        } else if (AVControllerCommon.D().f72575f != null) {
            a16 = AVControllerCommon.D().f72575f.a(VideoAppInterface.N(), intent, true);
            if (!QLog.isColorLevel()) {
                QLog.i("CompatModeTag", 2, "startInvite  canStartActivityNow[true], timeout[" + a16 + "]");
                return;
            }
            return;
        }
        a16 = 0;
        if (!QLog.isColorLevel()) {
        }
    }

    public void n0() {
        ax.j jVar = this.f72616j;
        if (jVar != null) {
            jVar.e0();
        }
    }

    public void o0(String str) {
        SessionInfo f16 = n.e().f();
        long d16 = com.tencent.av.utils.e.d();
        QLog.w(D, 1, "onPauseVideo, fromUin[" + str + "], remoteHasVideo[" + f16.O + "], isOnlyAudio[" + f16.M0 + "], seq[" + d16 + "]");
        if (tv.c.c(BaseApplication.getContext()) == 1) {
            f16.k0(d16, false);
            return;
        }
        if (f16.f73035i == 2 && f16.O) {
            f16.k0(d16, false);
            if (!f16.N) {
                f16.M0 = true;
                f16.p0(d16, "onPauseVideo", 1);
                S0(f16.f73035i);
            }
            VideoAppInterface.N().k0(new Object[]{15});
            DataReport.O();
        }
    }

    public void o1(long j3) {
        if (n.e().f().f73067q != 1011 && n.e().f().f73067q != 21 && !n.e().f().H2 && n.e().f().f73076s0 == 0) {
            long j16 = n.e().f().f73012d0;
            if (QLog.isColorLevel()) {
                QLog.d(D, 2, "startReachedRing, peer colorRingId=" + j16);
            }
            String e16 = com.tencent.mobileqq.vas.h.e(j16, 3);
            if (new File(e16).exists()) {
                TraeHelper.I().g0(j3, VideoAppInterface.N(), 0, e16, -1, null);
                n.e().f().H = true;
                DataReport.T(null, "CliOper", "", "", "0X8004A21", "0X8004A21", 0, 0, "" + n.e().f().f73016e0, j16 + "", "", "");
                return;
            }
            TraeHelper.I().g0(j3, VideoAppInterface.N(), R.raw.f169426x, null, -1, null);
            n.e().f().H = true;
        }
    }

    @Override // com.tencent.avcore.engine.dav.IDavEventListener
    public void onCancelRequest(String str) {
        s1();
        QLog.d(D, 1, "avideo onCancelRequest: fromUin = " + str);
        E(str, 10);
    }

    @Override // com.tencent.avcore.engine.dav.IDavEventListener
    public void onChangePreviewSize(int i3, int i16) {
        long d16 = com.tencent.av.utils.e.d();
        boolean c16 = com.tencent.av.camera.e.c();
        QLog.w(D, 1, "onChangePreviewSize, size[" + i3 + ", " + i16 + "], localHasVideo[" + n.e().f().N + "], preSize[" + com.tencent.avcore.camera.b.f77378u + ", " + com.tencent.avcore.camera.b.f77379v + "], seq[" + d16 + "], forbiddenReopenCamera[" + c16 + "]");
        if (!c16 && n.e().f().N) {
            Pair<Integer, Integer> a16 = com.tencent.av.camera.e.a(i3, i16);
            int intValue = a16.first.intValue();
            int intValue2 = a16.second.intValue();
            if (com.tencent.avcore.camera.b.f77378u != intValue || com.tencent.avcore.camera.b.f77379v != intValue2) {
                VideoAppInterface.N().k0(new Object[]{32, Integer.valueOf(intValue), Integer.valueOf(intValue2), Long.valueOf(d16)});
            }
        }
    }

    @Override // com.tencent.avcore.engine.dav.IDavEventListener
    public void onRejectVideo(String str) {
        QLog.d(D, 1, "avideo onRejectVideo fromUin = " + str);
        E(str, 3);
    }

    void p1(long j3, String str) {
        if (this.f72621o != null) {
            VideoAppInterface.N().M().removeCallbacks(this.f72621o);
        }
        StartRingRunnable startRingRunnable = new StartRingRunnable(str);
        this.f72621o = startRingRunnable;
        startRingRunnable.f72846e = j3;
        VideoAppInterface.N().M().postDelayed(this.f72621o, 6000L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0285, code lost:
    
        if (com.tencent.av.app.VideoAppInterface.N().L() != false) goto L63;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q0(int i3, final String str, final String str2, byte[] bArr, final boolean z16, String str3, final int i16, int i17, DavPBCommonParam.CommonParam commonParam) {
        DAVController dAVController;
        boolean z17;
        String str4;
        int i18;
        final boolean z18;
        boolean z19;
        int i19;
        boolean f16 = AVControllerCommon.D().f72571b.f(str);
        final long d16 = com.tencent.av.utils.e.d();
        int i26 = commonParam != null ? commonParam.invite_scene.get() : -1;
        String str5 = commonParam != null ? commonParam.invite_trace_id.get() : QzoneWebMusicJsPlugin.EVENT_UNKOWN;
        boolean z26 = commonParam == null || TextUtils.isEmpty(str5) || Y(str5);
        F0(str5);
        String str6 = D;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("avideo onRequestVideo, uinType[");
        sb5.append(i3);
        sb5.append("], fromUin[");
        sb5.append(str);
        sb5.append("], extraUin[");
        sb5.append(str2);
        sb5.append("], sig[");
        sb5.append(bArr != null);
        sb5.append("], onlyAudio[");
        sb5.append(z16);
        sb5.append("], bindID[");
        sb5.append(str3);
        sb5.append("], bindType[");
        sb5.append(i16);
        sb5.append("], isOfflineSession[");
        sb5.append(f16);
        sb5.append("], seq[");
        sb5.append(d16);
        sb5.append("], invite_scene[");
        sb5.append(i26);
        sb5.append("], traceId[");
        sb5.append(str5);
        sb5.append("]");
        final int i27 = i26;
        QLog.w(str6, 1, sb5.toString());
        if (VideoAppInterface.N() == null || VideoAppInterface.N().getApp() == null) {
            return;
        }
        RtcNodeReportReceiverHelper.i(str5, i3);
        if (z26) {
            dAVController = this;
            z17 = f16;
        } else {
            z17 = f16;
            dAVController = this;
            long currentTimeMillis = System.currentTimeMillis() - dAVController.getMSFInviteMessageTimeStamp(Long.valueOf(str).longValue());
            if (currentTimeMillis <= 10000) {
                RtcNodeReportReceiverHelper.z(str5, currentTimeMillis);
            }
            RtcNodeReportReceiverHelper.r(str5, 0, NodeModel$NodeEndReason.K_NORMAL.ordinal());
            RtcNodeReportReceiverHelper.m(str5);
        }
        AVControllerCommon.D().f72571b.c();
        q.f74191b = VideoAppInterface.N().g0();
        com.tencent.av.utils.e.w(VideoAppInterface.N());
        int a16 = ag.a(VideoAppInterface.N(), i3, str, i16);
        if (QLog.isColorLevel()) {
            QLog.d(D, 2, "onRequestVideo converted uinType = " + a16 + ",sdkAVAccostType = " + i3 + "|" + q.f74191b + ", isVideoPaused: " + VideoAppInterface.N().isBackgroundPause);
        }
        boolean checkGuildLiveAvBusinessFocus = ((IGuildLiveChannelApi) QRoute.api(IGuildLiveChannelApi.class)).checkGuildLiveAvBusinessFocus(Constants.Business.QQ_GUILD_LIVE_AUTHOR);
        if (checkGuildLiveAvBusinessFocus) {
            str4 = ", isVideoPaused: ";
            RtcVideoRecoveryNodeReport rtcVideoRecoveryNodeReport = new RtcVideoRecoveryNodeReport(VideoAppInterface.N().getAccount(), str, str5, 4100);
            rtcVideoRecoveryNodeReport.d(NodeModel$NodeEndReason.K_INTERRUPTION.ordinal());
            rtcVideoRecoveryNodeReport.c();
            QLog.i(D, 1, "onRequestVideo: live author. refused");
        } else {
            str4 = ", isVideoPaused: ";
        }
        if (!dAVController.B(a16, str) && !checkGuildLiveAvBusinessFocus) {
            SessionInfo f17 = n.e().f();
            final String b16 = n.b(3, str, new int[0]);
            if (TextUtils.equals(b16, f17.f73030h) && f17.f73059o) {
                if (!f17.G) {
                    com.tencent.avcore.rtc.node.report.utils.b.d(f17.r("autoAccept"));
                }
                f17.G = true;
                int i28 = !f17.M0 ? 1 : 0;
                QLog.w(D, 1, "onRequestVideo, autoAcceptChat, seq[" + d16 + "]");
                f17.v0("autoAccept", str5);
                RtcNodeReportReceiverHelper.e(str5);
                u(d16, str, i28, f17.S0);
                return;
            }
            AVControllerCommon.D();
            boolean N = AVControllerCommon.N(VideoAppInterface.N().getApp().getApplicationContext());
            QLog.w(D, 1, "onRequestVideo->isScreenLocked:" + N);
            if (f17.D()) {
                if (a16 == -1) {
                    RtcNodeReportReceiverHelper.l(str5, 0, NodeModel$NodeEndReason.K_INTERRUPTION.ordinal());
                    dAVController.f72607a.ignoreVideo(str, com.tencent.av.app.q.a());
                    QLog.w(D, 1, "closeVideo uinType == -1");
                    dAVController.f72607a.closeVideo(str, 0, dAVController);
                    VideoRecoveryMonitor T = VideoAppInterface.N().T();
                    if (T != null) {
                        T.k(0);
                        return;
                    }
                    return;
                }
            } else if (!f17.w() && !f17.x()) {
                if ((f17.f73043k == 7 && MAVController.Y().f72717s != 0) || (i18 = f17.f73043k) == 14 || i18 == 13) {
                    if (N) {
                        RtcNodeReportReceiverHelper.l(str5, 0, NodeModel$NodeEndReason.K_INTERRUPTION.ordinal());
                        AVControllerCommon.D().X(d16, false, a16, str, str2, i16, str3, z16);
                        return;
                    }
                } else if (!MAVController.Y().f72699a) {
                    QLog.w(D, 1, "onRequestVideo when chatting: fromUin = " + str + "|" + N);
                    String str7 = f17.f73091w;
                    if (str7 != null && str.equals(str7)) {
                        QLog.w(D, 1, "onRequestVideo when request: fromUin = " + str);
                        T0();
                        dAVController.D0(str);
                        return;
                    }
                    if (N) {
                        RtcNodeReportReceiverHelper.l(str5, 0, NodeModel$NodeEndReason.K_INTERRUPTION.ordinal());
                        AVControllerCommon.D().X(d16, false, a16, str, str2, i16, str3, z16);
                        return;
                    }
                } else {
                    QLog.d(D, 1, "onRequestVideo when in group chat, fromUin = " + str);
                    if (N) {
                        RtcNodeReportReceiverHelper.l(str5, 0, NodeModel$NodeEndReason.K_INTERRUPTION.ordinal());
                        AVControllerCommon.D().X(d16, false, a16, str, str2, i16, str3, z16);
                        return;
                    }
                }
                z18 = true;
            } else {
                dAVController.E(f17.f73091w, 2);
                z18 = false;
            }
            if (!z18 || !AVUtil.l()) {
                AVControllerCommon.D().p0();
            }
            n.e().a(b16, false);
            SessionInfo i29 = n.e().i(b16);
            i29.B0 = i16;
            i29.D0 = str3;
            i29.J0 = bArr;
            i29.C0 = a16;
            if (AVControllerCommon.D().f72573d != null) {
                VideoAppInterface.N().M().removeCallbacks(AVControllerCommon.D().f72573d);
                AVControllerCommon.D().f72573d = null;
                i29.n0("onRequestVideo.1", 0);
            }
            if (AVControllerCommon.D().f72571b.e()) {
                a16 = 9500;
            }
            AVControllerCommon.D().f72570a = true;
            i29.M0 = z16;
            if (z16) {
                i29.f73039j = 1;
            } else {
                i29.f73039j = 2;
            }
            long x16 = AVControllerCommon.D().x(str);
            QLog.w(D, 1, "onRequestVideo  ,roomId = " + x16);
            i29.d(x16);
            i29.f73067q = a16;
            i29.f73075s = i3;
            i29.f73091w = str;
            i29.f73103z = str2;
            i29.G = true;
            if (!TextUtils.isEmpty(str5)) {
                i29.v0("onRequestVideo.2", str5);
            }
            i29.n0("onRequestVideo.2", 2);
            i29.f73021f0 = i17;
            dAVController.X0(a16, str, str2, bArr);
            VideoNodeReporter videoNodeReporter = (VideoNodeReporter) VideoAppInterface.N().B(4);
            videoNodeReporter.w(x16, 20, z16 ? 1 : 2);
            videoNodeReporter.w(x16, 6, 1L);
            dAVController.D0(str);
            if (z17) {
                i29.f73055n = true;
                y0(d16, b16, a16, str, str2, z16, false, z18, i16, i27, str5);
                return;
            }
            if (!MAVController.Y().f72699a && (i19 = i29.f73067q) != 21 && i19 != 1011) {
                AVControllerCommon.D().f0(b16, i29.f73039j, false, false, true);
            }
            if (QLog.isColorLevel()) {
                String str8 = D;
                StringBuilder sb6 = new StringBuilder();
                sb6.append("onRequestVideo orientation: ");
                sb6.append(AVControllerCommon.D().f72582m);
                sb6.append(", isQQPaused: ");
                sb6.append(q.f74191b);
                sb6.append(str4);
                sb6.append(VideoAppInterface.N().isBackgroundPause);
                sb6.append(", isScreenLocked: ");
                z19 = N;
                sb6.append(z19);
                sb6.append(", isAppOnForeground: ");
                sb6.append(BaseGesturePWDUtil.isAppOnForegroundByTasks(VideoAppInterface.N().getApp().getApplicationContext(), 0));
                QLog.d(str8, 2, sb6.toString());
            } else {
                z19 = N;
            }
            if (AVControllerCommon.D().f72584o && AVControllerCommon.D().f72582m == 0 && !z19 && q.f74191b && VideoAppInterface.N().isBackgroundPause) {
                final int i36 = a16;
                final String str9 = str5;
                VideoAppInterface.N().M().postDelayed(new Runnable() { // from class: com.tencent.av.DAVController.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DAVController.this.z0(d16, b16, i36, str, str2, z16, false, z18, i16, i27, str9);
                    }
                }, 100L);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(D, 2, "updateProcessInfo INVITEUI_STATE to 0 when onRequestVideo, from = " + str);
            }
            B1(str, "inviteUIState", String.valueOf(0));
            if (this.f72620n != null) {
                this.f72620n.m();
            }
            this.f72620n = new VideoCallStateMonitor(VideoAppInterface.N(), str);
            z0(d16, b16, a16, str, str2, z16, false, z18, i16, i27, str5);
            return;
        }
        AVControllerCommon.D().X(d16, false, a16, str, str2, i16, str3, z16);
        RtcNodeReportReceiverHelper.l(str5, 0, NodeModel$NodeEndReason.K_INTERRUPTION.ordinal());
    }

    void q1() {
        final long d16 = com.tencent.av.utils.e.d();
        if (this.f72625s == null) {
            this.f72625s = new Runnable() { // from class: com.tencent.av.DAVController.13
                @Override // java.lang.Runnable
                public void run() {
                    AVControllerCommon.D().f72574e.k0(d16);
                    TraeHelper.n0(VideoAppInterface.N());
                    DAVController.this.E(n.e().f().f73091w, 50);
                }
            };
            if (VideoAppInterface.N() != null && this.f72625s != null) {
                VideoAppInterface.N().M().postDelayed(this.f72625s, 15000L);
            }
        }
    }

    public void r0() {
        ax.j jVar = this.f72616j;
        if (jVar != null) {
            jVar.f0();
        }
    }

    public void r1() {
        QLog.i(D, 2, "stopAvatarBgUpdateTask");
        if (this.f72632z != null) {
            QLog.i(D, 2, "stopAvatarBgUpdateTask remove runnable");
            ThreadManagerV2.removeJob(this.f72632z, 16);
            this.f72632z = null;
        }
    }

    public void s0(final long j3) {
        if (QLog.isColorLevel()) {
            QLog.i(D, 2, "onSubState2 seq[" + j3 + "]");
        }
        TraeHelper.j0(VideoAppInterface.N(), true, j3);
        SessionInfo f16 = n.e().f();
        s1();
        f16.n0("onSubState2", 4);
        f16.X(j3, SystemClock.elapsedRealtime());
        if (VideoAppInterface.N().r() > 0) {
            VideoAppInterface.N().k0(new Object[]{13, Long.valueOf(j3)});
        } else {
            AVControllerCommon.D().v0();
        }
        if (f16.K) {
            d1(true, f16.f73091w);
        } else {
            d1(false, f16.f73091w);
        }
        VideoAppInterface.N().M().postDelayed(new Runnable() { // from class: com.tencent.av.DAVController.6
            @Override // java.lang.Runnable
            public void run() {
                SessionInfo f17 = n.e().f();
                if (f17.G && f17.S && f17.f73035i == 2) {
                    f17.c0(j3, false);
                    DAVController.this.f72607a.pauseVideo(f17.f73091w);
                }
            }
        }, 50L);
        AVControllerCommon.D().f0(f16.f73030h, f16.f73035i, true, true, true);
        DataReport.W();
        DataReport.X(true);
        DataReport.b0(true);
        ChatRoomMng D2 = VideoAppInterface.N().D();
        if (D2 != null) {
            D2.f(f16);
        }
    }

    void s1() {
        if (VideoAppInterface.N() != null) {
            VideoAppInterface.N().M().removeCallbacks(this.f72627u);
        }
        if (QLog.isColorLevel()) {
            QLog.i(D, 2, "stopConnectingTimer");
        }
    }

    public void t0(String str, long j3) {
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.w(D, 1, "onSwitchTerminalSuccess, fromUin[" + str + "], roomId[" + j3 + "], seq[" + d16 + "]");
        }
        if (VideoAppInterface.N() == null) {
            return;
        }
        if (!n.e().f().f73085u1 && n.e().f().f73081t1 && n.e().f() != null && !n.e().f().G && n.e().f().f73043k < 5) {
            com.tencent.avcore.rtc.node.report.utils.b.e(n.e().f().r("onSwitchTerminalSuccess"));
        }
        if (this.f72625s != null) {
            VideoAppInterface.N().M().removeCallbacks(this.f72625s);
            this.f72625s = null;
        }
        final SessionInfo f16 = n.e().f();
        if (f16.f73085u1) {
            f16.f73085u1 = false;
            if (f16.K) {
                d1(true, f16.f73091w);
            }
            f16.f73087v = true;
            if (VideoAppInterface.N().r() > 0) {
                VideoAppInterface.N().k0(new Object[]{33, f16.f73091w, Boolean.FALSE});
            } else {
                AVControllerCommon.D().f72587r.add(new Runnable() { // from class: com.tencent.av.DAVController.12
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoAppInterface.N().k0(new Object[]{33, f16.f73091w, Boolean.FALSE});
                    }
                });
            }
            u1(d16);
            g0((int) AVControllerCommon.D().y(), f16.O, !f16.L);
            if (VideoAppInterface.N() != null && f16.f73098x2 && ax.a.c(VideoAppInterface.N())) {
                Q0(true, 640, 480, "");
            }
        } else if (f16.f73081t1) {
            j0(f16.f73091w, j3);
        }
        ChatRoomMng D2 = VideoAppInterface.N().D();
        if (D2 != null) {
            D2.r(f16);
        }
    }

    public int u(long j3, String str, int i3, int i16) {
        int i17;
        QLog.w(D, 1, "avideo acceptRequest, peerUin[" + str + "], businessType[" + i3 + "], relationType[" + i16 + "], uiMode[" + this.f72613g + "], seq[" + j3 + "]");
        AVControllerCommon.D().c0();
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            QLog.d(D, 1, "acceptRequest fail,network not support");
            return -2;
        }
        int i18 = -1;
        if (this.f72607a == null) {
            QLog.d(D, 1, "acceptRequest fail,mVcCtrl is null");
            return -1;
        }
        SessionInfo Q = Q(i16, str);
        if (Q == null) {
            Q = n.e().f();
        }
        SessionInfo sessionInfo = Q;
        AVControllerCommon.D().i0(false);
        VideoAppInterface.N().getVideoConfigUpdate();
        VideoAppInterface.N().H0();
        if (sessionInfo.H2) {
            i17 = 5;
        } else {
            i17 = 0;
        }
        if (i3 == 0) {
            i18 = this.f72607a.acceptVideo(str, 0L, com.tencent.av.app.q.a(), 0, i16, i17);
        } else if (1 == i3) {
            i18 = this.f72607a.acceptVideo(str, 0L, com.tencent.av.app.q.a(), 2, i16, i17);
        }
        if (QLog.isColorLevel()) {
            QLog.i(D, 2, "acceptRequest, result[" + i18 + "], peerUin[" + str + "], relationType[" + i16 + "], session[" + sessionInfo + "]");
        }
        if (i18 == 0) {
            sessionInfo.n0("acceptRequest", 3);
            l1();
        }
        AVControllerCommon.D().f72571b.h();
        ((VideoNodeReporter) VideoAppInterface.N().B(4)).w(n.e().f().b(), 9, 1L);
        return i18;
    }

    public void u0(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            S2cSafeInfo$SafeCheckInfo s2cSafeInfo$SafeCheckInfo = new S2cSafeInfo$SafeCheckInfo();
            try {
                s2cSafeInfo$SafeCheckInfo.mergeFrom(bArr);
                int i3 = s2cSafeInfo$SafeCheckInfo.safe_code.get();
                String stringUtf8 = s2cSafeInfo$SafeCheckInfo.safe_url.get().toStringUtf8();
                String stringUtf82 = s2cSafeInfo$SafeCheckInfo.safe_str.get().toStringUtf8();
                QLog.i(D, 1, "parseAndSendSecurityLimitBroadcast: safe code: " + i3 + " safe url: " + stringUtf8 + " safe str: " + stringUtf82);
                if (i3 == -1) {
                    QLog.e(D, 1, "parseAndSendSecurityLimitBroadcast: invalid safe code");
                    return;
                }
                if (TextUtils.isEmpty(stringUtf82)) {
                    QLog.e(D, 1, "parseAndSendSecurityLimitBroadcast: empty safe str");
                    return;
                }
                Intent intent = new Intent();
                intent.setAction("tencent.av.v2q.security");
                intent.putExtra("type", 38);
                intent.putExtra("safeCode", i3);
                intent.putExtra("safeUrl", stringUtf8);
                intent.putExtra("safeStr", stringUtf82);
                AVControllerCommon.D().e0(intent);
                return;
            } catch (InvalidProtocolBufferMicroException unused) {
                QLog.e(D, 1, "parseAndSendSecurityLimitBroadcast: parse buffer exception");
                return;
            }
        }
        QLog.e(D, 1, "parseAndSendSecurityLimitBroadcast: empty buffer");
    }

    public void u1(long j3) {
        if (n.e().f().N) {
            int switchVideo = this.f72607a.switchVideo(n.e().f().f73091w);
            if (QLog.isColorLevel() || switchVideo == -1) {
                QLog.w(D, 1, "switchVideo , ret[" + switchVideo + "], seq[" + j3 + "]");
                return;
            }
            return;
        }
        int switchAudio = this.f72607a.switchAudio(n.e().f().f73091w);
        if (QLog.isColorLevel() || switchAudio == -1) {
            QLog.w(D, 1, "switchAudio , ret[" + switchAudio + "], seq[" + j3 + "]");
        }
    }

    public void v(final long j3, final String str, final int i3, final boolean z16, final Runnable runnable) {
        new BaseThread(new Runnable() { // from class: com.tencent.av.DAVController.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.z(j3, str, i3, z16);
                    runnable.run();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }).start();
    }

    public long v0(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
            str = str.substring(1);
        }
        try {
            return com.tencent.av.utils.i.g(str);
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            AVCoreLog.printErrorLog(D, e16.getMessage());
            return -1L;
        }
    }

    public int v1(int i3, boolean z16) {
        if (n.e().f().f73035i != 1 && n.e().f().f73035i != 2) {
            return -1;
        }
        return NtrtcAudio.getInstance().unregisterAudioDataCallback(i3);
    }

    public void w(int i3) {
        long j3;
        if (n.e().f().f73091w == null) {
            QLog.d(D, 1, "checkNetStatus <--receiveEcho peerUin = null, return!");
            return;
        }
        try {
            j3 = Long.valueOf(n.e().f().f73091w).longValue();
        } catch (Exception e16) {
            QLog.d(D, 1, "checkNetStatus Long.valueOf(peerUin) Exception= " + e16.getMessage());
            j3 = 0L;
        }
        if (this.f72607a != null && j3 > 0) {
            QLog.d(D, 1, "checkNetStatus <--receiveEcho netStatus = " + i3);
            NtrtcEngine.getInstance().updateNetworkTestResult(j3, i3);
        }
    }

    public void w0(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(D, 2, "pauseVideo");
        }
        if (n.e().f().f73035i > 0 && n.e().f().f73035i <= 2 && this.f72607a != null) {
            if (!n.e().f().z() && n.e().f().f73098x2) {
                return;
            } else {
                this.f72607a.pauseVideo(str);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(D, 2, "pauseVideo end");
        }
    }

    public void x(boolean z16) {
        if (z16) {
            long currentTimeMillis = System.currentTimeMillis() - this.f72629w;
            QLog.d(D, 1, "callBackNetStatus <--receiveEcho Cost = " + currentTimeMillis);
            if (currentTimeMillis < 3000) {
                w(1);
            } else {
                w(2);
            }
        } else {
            w(4);
        }
        this.f72629w = -1L;
    }

    public byte[] x0(long j3, long j16, byte[] bArr) {
        if (this.f72607a == null) {
            return null;
        }
        return NtrtcVideo.getInstance().postData(j16, bArr);
    }

    public void x1(int i3) {
        QLog.i(D, 2, "updateAvAvatarBg");
        J();
        if (i3 != 0 && F.h() && SmallScreenUtils.p(VideoAppInterface.N().getApp().getApplicationContext())) {
            F.m(this.f72631y);
            SessionInfo f16 = n.e().f();
            if (this.f72616j != null) {
                if (f16.f73098x2 || f16.f73102y2) {
                    F.n();
                    return;
                }
                return;
            }
            return;
        }
        w1();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean y() {
        boolean z16;
        int i3 = n.e().f().f73067q;
        if (i3 == 21 || i3 == 22 || i3 == 26) {
            return false;
        }
        if (n.e().f().f73039j != 1) {
            return true;
        }
        String str = n.e().f().f73091w;
        if (n.e().f().f73067q == 1006 && !n.e().f().G && n.e().f().f73103z != null) {
            str = n.e().f().f73103z;
        }
        try {
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d(D, 2, "Can not get Number. PeerUin = " + str);
            }
        }
        if (NtrtcRoom.getInstance().hasAVShiftAbility(com.tencent.av.utils.i.g(str)) != -1) {
            z16 = true;
            if (z16) {
                int U = U(str);
                int T = T(str);
                if (QLog.isColorLevel()) {
                    QLog.d(D, 2, "canAVShift peerTerminalType: " + U + ", peerSharpVersion: " + T);
                }
                if ((T < 16 || (U != 4 && U != 8 && U != 2 && U != 3)) && (U != 5 || T < 5437)) {
                    return false;
                }
                return true;
            }
            return z16;
        }
        z16 = false;
        if (z16) {
        }
    }

    public void y1() {
        int i3;
        int i16 = n.e().f().D2;
        dx.e a16 = ax.a.a();
        if (a16 == null) {
            return;
        }
        int collectFps = a16.getCollectFps();
        if (collectFps <= i16) {
            i16 = collectFps;
        }
        int max = Math.max(10, i16);
        com.tencent.av.opengl.effects.m C = AVControllerCommon.D().C(false);
        if (C == null) {
            return;
        }
        C.u(max);
        if (max <= 10) {
            i3 = 10000;
        } else if (max <= 15) {
            i3 = 15000;
        } else {
            i3 = 20000;
        }
        com.tencent.av.camera.b.a(VideoAppInterface.N().getApp().getApplicationContext()).setCameraWithNewFps(-1L, i3);
        QLog.d(D, 1, "targetOutputFps:=" + max + ",targetCameraFps:=" + i3);
    }

    public void z(long j3, String str, int i3, boolean z16) {
        boolean z17;
        int i16;
        String str2 = D;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("cancelVideoChat, peerUin[");
        sb5.append(str);
        sb5.append("], reason[");
        sb5.append(i3);
        sb5.append("], isDoubleMetting[");
        sb5.append(z16);
        sb5.append("], mVcCtrl[");
        if (this.f72607a != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        sb5.append(z17);
        sb5.append("], seq[");
        sb5.append(j3);
        sb5.append("]");
        QLog.w(str2, 1, sb5.toString());
        if (this.f72607a == null) {
            return;
        }
        AVControllerCommon.D().f72574e.k0(j3);
        TraeHelper.n0(VideoAppInterface.N());
        AVControllerCommon.D().f72574e.x();
        if (!z16) {
            i16 = this.f72607a.rejectVideo(str, com.tencent.av.app.q.a(), i3);
            ((VideoNodeReporter) VideoAppInterface.N().B(4)).w(n.e().f().b(), 10, 1L);
        } else {
            i16 = -99;
        }
        QLog.w(D, 1, "cancelVideoChat, result[" + i16 + "]");
        AVControllerCommon.D().h();
        s1();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z0(long j3, String str, int i3, String str2, String str3, boolean z16, boolean z17, boolean z18, int i16, int i17, String str4) {
        A0(j3, str, i3, str2, str3, z16, z17, z18, i16, i17, str4, true);
    }

    public void z1(boolean z16) {
        this.f72607a.updateForeBackgroundFlag(n.e().f().f73091w, z16);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class d implements com.tencent.av.zplan.avatar.manager.a {
        d() {
        }

        @Override // com.tencent.av.zplan.avatar.manager.a
        public void onLoadingStart() {
            DAVController.this.w1();
        }

        @Override // com.tencent.av.zplan.avatar.manager.a
        public void a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class e implements QAVControllerForZplan.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SessionInfo f72695a;

        e(SessionInfo sessionInfo) {
            this.f72695a = sessionInfo;
        }

        @Override // com.tencent.av.zplan.QAVControllerForZplan.d
        public void a(boolean z16) {
            boolean z17;
            QLog.i(DAVController.D, 2, "onChannelReady onInZplanHome isInZPlanSmallHomeMod: " + z16);
            if (z16) {
                DAVController dAVController = DAVController.this;
                SessionInfo sessionInfo = this.f72695a;
                if (!sessionInfo.H2 && !sessionInfo.I2) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                dAVController.i0(z17);
            }
        }

        @Override // com.tencent.av.zplan.QAVControllerForZplan.d
        public void b() {
        }
    }
}
