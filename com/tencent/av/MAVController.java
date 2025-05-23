package com.tencent.av;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.av.AVControllerCommon;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.chatroom.ChatRoomMng;
import com.tencent.av.compat.AVCallCompactHelper;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.av.doodle.DoodleUtils;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.GInviteTimeOutHelper;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.MultiIncomingCallUICtr;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.ui.ScreenRecordHelper;
import com.tencent.av.ui.VideoInviteFloatBarUICtr;
import com.tencent.av.ui.fragment.api.INTGaInviteFragmentPluginHelperApi;
import com.tencent.av.ui.notdisturb.api.IGaInviteFloatBarHelperApi;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.at;
import com.tencent.av.utils.ax;
import com.tencent.av.utils.ba;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.av.video.call.GAClientLogReport;
import com.tencent.av.zplan.QAVControllerForZplan;
import com.tencent.avbiz.Constants;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.avcore.data.AVInviteAccount;
import com.tencent.avcore.data.MavInviteData;
import com.tencent.avcore.data.RecordParam;
import com.tencent.avcore.jni.audiodevice.TraeConstants;
import com.tencent.avcore.jni.data.AVUserInfo;
import com.tencent.avcore.jni.data.GetSignResponse;
import com.tencent.avcore.jni.data.MavCommonPBMsg;
import com.tencent.avcore.jni.data.UinOpenIdResponse;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.debug.api.IQQDebugApi;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.guild.api.IGuildLiveChannelApi;
import com.tencent.mobileqq.mini.servlet.MiniAppGeneralServlet;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.util.az;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.cp;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.sharp.jni.api.IMediaPlayerApi;
import com.tencent.state.data.SquareJSConst;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import com.tencent.util.Pair;
import cooperation.qzone.remote.ServiceConst;
import cooperation.qzone.util.WnsNetworkConst;
import dx.GAudioZPlanStatus;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;
import mqq.util.ForegroundUtil;
import tencent.im.s2c.msgtype0x210.submsgtype0x116.submsgtype0x116$MemberInfo;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MAVController implements com.tencent.av.gaudio.b, au.f {
    private static String J = "MAVController";
    static volatile MAVController K;

    /* renamed from: a, reason: collision with root package name */
    public boolean f72699a = false;

    /* renamed from: b, reason: collision with root package name */
    public long f72700b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f72701c = 0;

    /* renamed from: d, reason: collision with root package name */
    boolean f72702d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f72703e = false;

    /* renamed from: f, reason: collision with root package name */
    com.tencent.av.app.o f72704f = new com.tencent.av.app.o();

    /* renamed from: g, reason: collision with root package name */
    private int f72705g = 0;

    /* renamed from: h, reason: collision with root package name */
    public String f72706h = null;

    /* renamed from: i, reason: collision with root package name */
    public int f72707i = 0;

    /* renamed from: j, reason: collision with root package name */
    public long f72708j = 6000;

    /* renamed from: k, reason: collision with root package name */
    public int f72709k = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f72710l = 0;

    /* renamed from: m, reason: collision with root package name */
    public com.tencent.av.ui.funchat.record.i[] f72711m = null;

    /* renamed from: n, reason: collision with root package name */
    QQGAudioCtrl f72712n = null;

    /* renamed from: o, reason: collision with root package name */
    private int f72713o = 1;

    /* renamed from: p, reason: collision with root package name */
    boolean f72714p = false;

    /* renamed from: q, reason: collision with root package name */
    private boolean f72715q = false;

    /* renamed from: r, reason: collision with root package name */
    public boolean f72716r = false;

    /* renamed from: s, reason: collision with root package name */
    public long f72717s = 0;

    /* renamed from: t, reason: collision with root package name */
    public int f72718t = 0;

    /* renamed from: u, reason: collision with root package name */
    private final Object f72719u = new Object();

    /* renamed from: v, reason: collision with root package name */
    private int f72720v = -1;

    /* renamed from: w, reason: collision with root package name */
    Runnable f72721w = null;

    /* renamed from: x, reason: collision with root package name */
    AVControllerCommon.c f72722x = new d();

    /* renamed from: y, reason: collision with root package name */
    boolean f72723y = false;

    /* renamed from: z, reason: collision with root package name */
    Runnable f72724z = null;
    private ArrayList<com.tencent.av.e> A = new ArrayList<>();
    private Runnable B = new Runnable() { // from class: com.tencent.av.MAVController.16
        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList = new ArrayList();
            long i3 = com.tencent.av.utils.e.i() / 1000;
            Iterator it = MAVController.this.A.iterator();
            while (it.hasNext()) {
                com.tencent.av.e eVar = (com.tencent.av.e) it.next();
                if (eVar.f73724x || eVar.f73725y + 60 > i3) {
                    arrayList.add(eVar);
                }
            }
            if (arrayList.size() != MAVController.this.A.size()) {
                MAVController.this.A = arrayList;
                VideoAppInterface.N().k0(new Object[]{Integer.valueOf(TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_HOOK), 1L, 1L, MAVController.this.A});
            }
            VideoAppInterface.N().M().postDelayed(MAVController.this.B, 10000L);
            QLog.d(MAVController.J, 1, "InviteMemberList call mRemoveUnAttenedMember");
        }
    };
    private final ArrayList<com.tencent.av.e> C = new ArrayList<>();
    ArrayList<com.tencent.av.e> D = new ArrayList<>();
    boolean E = false;
    int F = 0;
    public boolean G = false;
    StartAudioSendRunnable H = null;
    Runnable I = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class StartAudioSendRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        int f72757d = 5;

        /* renamed from: e, reason: collision with root package name */
        long f72758e;

        /* renamed from: f, reason: collision with root package name */
        String f72759f;

        /* renamed from: h, reason: collision with root package name */
        boolean f72760h;

        /* renamed from: i, reason: collision with root package name */
        boolean f72761i;

        StartAudioSendRunnable(long j3, String str, boolean z16, boolean z17) {
            this.f72758e = j3;
            this.f72759f = str;
            this.f72760h = z16;
            this.f72761i = z17;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3 = 1;
            int i16 = this.f72757d - 1;
            this.f72757d = i16;
            if (i16 <= 0) {
                i3 = 2;
            }
            MAVController.Y().p0(this.f72758e, "StartAudioSendRunnable", this.f72760h, this.f72761i, i3);
        }

        public String toString() {
            return "seq[" + this.f72758e + "], mFrom[" + this.f72759f + "], mEnable[" + this.f72760h + "], mNotifySvr[" + this.f72761i + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements Comparator<com.tencent.av.e> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.av.e eVar, com.tencent.av.e eVar2) {
            return (int) (eVar.f73725y - eVar2.f73725y);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b implements Comparator<com.tencent.av.e> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.av.e eVar, com.tencent.av.e eVar2) {
            return (int) (eVar.f73725y - eVar2.f73725y);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c implements yw.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f72764a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f72765b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f72766c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f72767d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f72768e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f72769f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ xw.b f72770g;

        c(long j3, long j16, int i3, long j17, int i16, Context context, xw.b bVar) {
            this.f72764a = j3;
            this.f72765b = j16;
            this.f72766c = i3;
            this.f72767d = j17;
            this.f72768e = i16;
            this.f72769f = context;
            this.f72770g = bVar;
        }

        @Override // yw.a
        public void a(boolean z16) {
            QLog.d(MAVController.J, 2, "onScreenShareRecv onAuthResult auth:" + z16);
            if (z16) {
                MAVController.this.V0(this.f72764a, this.f72765b, true, this.f72766c, false, this.f72767d, this.f72768e);
            } else {
                QLog.e(MAVController.J, 2, "onScreenShareRecv fail to auth");
                QQToast.makeText(this.f72769f, 1, R.string.f1783336d, 1).show();
            }
            this.f72770g.k(null);
        }

        @Override // yw.a
        public void onCancel() {
            QLog.d(MAVController.J, 2, "onScreenShareRecv onCancel");
            this.f72770g.k(null);
            QQToast.makeText(this.f72769f, 1, R.string.f1783336d, 1).show();
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class d extends AVControllerCommon.c {
        d() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (MAVController.this.f72721w != null) {
                VideoAppInterface.N().M().removeCallbacks(MAVController.this.f72721w);
                MAVController.this.f72721w = null;
            }
            AVCoreLog.printAllUserLog(MAVController.J, "onCompletion onCloseDoubleVideoMeeting");
            if (n.e().f().f73064p0) {
                if (mediaPlayer != null) {
                    mediaPlayer.release();
                }
                long j3 = n.e().f().P0;
                VideoAppInterface.N().k0(new Object[]{28, String.valueOf(j3), Boolean.TRUE});
                MAVController.this.a1(3, j3, 85);
                n.e().f().z0("OnCloseDoubleVideoMeetingListener", false);
                n.e().f().y0("OnCloseDoubleVideoMeetingListener", false);
            } else {
                AVCoreLog.printErrorLog(MAVController.J, "mOnCloseDoubleVideoMeetingListener-->Is not in doubleMeetingRoom");
            }
            this.f72605d = 0L;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class g implements DialogInterface.OnClickListener {
        g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            DataReport.T(null, "CliOper", "", "", "0x8006994", "0x8006994", 0, 0, "", "", "", "");
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class h implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f72776d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f72777e;

        h(boolean z16, boolean z17) {
            this.f72776d = z16;
            this.f72777e = z17;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (!this.f72776d) {
                int T = MAVController.this.T();
                MAVController mAVController = MAVController.this;
                mAVController.F("onHowling_click", mAVController.f72700b, true, false, -1);
                MAVController mAVController2 = MAVController.this;
                mAVController2.B0(-1L, T, mAVController2.T());
                if (VideoAppInterface.N() != null) {
                    VideoAppInterface.N().k0(new Object[]{108});
                }
            }
            if (this.f72777e) {
                AVControllerCommon.D().f72574e.S();
            }
            DataReport.T(null, "CliOper", "", "", "0x8006993", "0x8006993", 0, 0, "", "", "", "");
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class i implements QAVControllerForZplan.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SessionInfo f72779a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f72780b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f72781c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f72782d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Intent f72783e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ VideoAppInterface f72784f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f72785g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f72786h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f72787i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ long[] f72788j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f72789k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ long f72790l;

        i(SessionInfo sessionInfo, String str, boolean z16, long j3, Intent intent, VideoAppInterface videoAppInterface, int i3, long j16, long j17, long[] jArr, int i16, long j18) {
            this.f72779a = sessionInfo;
            this.f72780b = str;
            this.f72781c = z16;
            this.f72782d = j3;
            this.f72783e = intent;
            this.f72784f = videoAppInterface;
            this.f72785g = i3;
            this.f72786h = j16;
            this.f72787i = j17;
            this.f72788j = jArr;
            this.f72789k = i16;
            this.f72790l = j18;
        }

        @Override // com.tencent.av.zplan.QAVControllerForZplan.d
        public void a(boolean z16) {
            SessionInfo sessionInfo = this.f72779a;
            if (sessionInfo.f73035i != 3) {
                MAVController.this.I1(this.f72785g, this.f72786h, this.f72787i, this.f72788j, this.f72789k, this.f72790l, this.f72784f, sessionInfo, this.f72781c, this.f72783e, false);
                return;
            }
            QAVControllerForZplan.p().A(this.f72779a.f73030h, String.valueOf(this.f72780b), VideoAppInterface.N().G(0, String.valueOf(this.f72780b), null), this.f72781c, this.f72782d);
            this.f72783e.setClass(this.f72784f.getApp().getApplicationContext(), GaInviteLockActivity.class);
            this.f72783e.putExtra("isInZplanHome", true);
            if (Build.VERSION.SDK_INT >= 26) {
                this.f72783e.removeFlags(268435456);
            }
            this.f72783e.addFlags(131072);
            MAVController.this.I1(this.f72785g, this.f72786h, this.f72787i, this.f72788j, this.f72789k, this.f72790l, this.f72784f, this.f72779a, this.f72781c, this.f72783e, true);
        }

        @Override // com.tencent.av.zplan.QAVControllerForZplan.d
        public void b() {
            MAVController.this.I1(this.f72785g, this.f72786h, this.f72787i, this.f72788j, this.f72789k, this.f72790l, this.f72784f, this.f72779a, this.f72781c, this.f72783e, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class j implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f72792d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Intent f72793e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f72794f;

        j(long j3, Intent intent, boolean z16) {
            this.f72792d = j3;
            this.f72793e = intent;
            this.f72794f = z16;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            if (eIPCResult.code == 0) {
                boolean z16 = eIPCResult.data.getBoolean("qav_is_not_disturb");
                QLog.d(MAVController.J, 1, "startInviteForGroupWrapper EIPCResult notDisturb=" + z16);
                if (!z16) {
                    MAVController.this.H1(this.f72793e, this.f72794f);
                } else {
                    ((IGaInviteFloatBarHelperApi) QRoute.api(IGaInviteFloatBarHelperApi.class)).showHalfScreen(this.f72792d, this.f72793e);
                }
            }
        }
    }

    MAVController() {
    }

    public static MAVController A() {
        if (K == null) {
            synchronized (MAVController.class) {
                if (K == null) {
                    QLog.d(J, 1, "create MAVController");
                    K = new MAVController();
                }
            }
        }
        return K;
    }

    public static void D() {
        K = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:183:0x01c9, code lost:
    
        if (r1 == 2) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void G0(int i3, long j3, AVUserInfo aVUserInfo, boolean z16, long j16, int... iArr) {
        long j17;
        SessionInfo i16;
        long j18;
        long j19;
        long j26;
        long j27;
        long j28;
        boolean z17;
        long j29;
        long j36;
        long j37;
        boolean z18;
        ScreenShareCtrl H;
        long j38;
        int i17;
        if (i3 == 7 && !z16 && n.e().m()) {
            QLog.w(J, 1, "onGAudioUserEnterOrLeave, AV_RELATION_MULTI_RANDOM");
            return;
        }
        try {
            j17 = Long.parseLong(aVUserInfo.account);
        } catch (NumberFormatException e16) {
            com.tencent.qav.log.a.c(J, "expection[" + e16.getMessage() + "]", new Throwable("stack trace"));
            j17 = 0L;
        }
        long g16 = com.tencent.av.utils.i.g(VideoAppInterface.N().getCurrentAccountUin());
        boolean z19 = g16 == j17;
        String b16 = n.b(i3, String.valueOf(j3), new int[0]);
        if (i3 == 3) {
            b16 = n.b(100, String.valueOf(j3), new int[0]);
        }
        if (i3 == 1) {
            i16 = n.e().f();
        } else {
            i16 = n.e().i(b16);
        }
        SessionInfo sessionInfo = i16;
        if (sessionInfo != null && !TextUtils.isEmpty(sessionInfo.f73030h)) {
            long d16 = com.tencent.av.utils.e.d();
            if (com.tencent.av.utils.e.k()) {
                j19 = j17;
                String str = J;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onGAudioUserEnterOrLeave, mGAudioGroupId[");
                j18 = d16;
                sb5.append(this.f72700b);
                sb5.append("], relationId[");
                sb5.append(j3);
                sb5.append("], mGAudioRelationType[");
                sb5.append(this.f72701c);
                sb5.append("], relationType[");
                sb5.append(i3);
                sb5.append("], UserInfo[");
                sb5.append(aVUserInfo);
                sb5.append("], isEnter[");
                sb5.append(z16);
                sb5.append("], bSelfIn[");
                sb5.append(z19);
                sb5.append("], selfUin[");
                sb5.append(g16);
                sb5.append("], mGAudioMute[");
                sb5.append(this.f72714p);
                sb5.append("], mSessionType[");
                sb5.append(sessionInfo.f73035i);
                sb5.append("], localHasVideo[");
                sb5.append(sessionInfo.N);
                sb5.append("], switchToGAudioMode[");
                sb5.append(sessionInfo.T0);
                sb5.append("], extroInfo = ");
                sb5.append(j16);
                sb5.append("], seq[");
                sb5.append(j18);
                sb5.append("]");
                QLog.w(str, 1, sb5.toString());
            } else {
                j18 = d16;
                j19 = j17;
            }
            if (z16 && z19) {
                j28 = j18;
                z17 = z19;
                j26 = g16;
                j27 = j19;
                O1("onGAudioUserEnterOrLeave", true, i3, j3);
                sessionInfo.U0 = true;
                VideoAppInterface.N().M().removeCallbacks(this.f72724z);
                final boolean H2 = sessionInfo.H();
                if (AVControllerCommon.D().f72576g != null) {
                    AVControllerCommon.D().f72576g.post(new Runnable() { // from class: com.tencent.av.MAVController.18
                        @Override // java.lang.Runnable
                        public void run() {
                            MAVController.this.L1("onGAudioUserEnterOrLeave", !r0.f72714p, H2);
                        }
                    });
                }
                if (sessionInfo.N && sessionInfo.f73035i == 4) {
                    k0();
                }
                int i18 = this.f72701c;
                if (i18 == 1 && sessionInfo.f73063p == 10) {
                    i17 = 2;
                } else {
                    i17 = 2;
                }
                sessionInfo.f73041j1 = j16 != 0;
                AVControllerCommon.D().b0(i17);
            } else {
                j26 = g16;
                j27 = j19;
                j28 = j18;
                z17 = z19;
            }
            SessionInfo f16 = n.e().f();
            if (z16 || j27 != Long.valueOf(VideoAppInterface.N().getCurrentAccountUin()).longValue()) {
                j29 = j27;
                j36 = j3;
            } else {
                j29 = j27;
                j36 = j3;
                if (j36 == f16.P0) {
                    if (j16 == 4 && !TextUtils.isEmpty(aVUserInfo.commonTipsInfo)) {
                        m1(false, "", String.valueOf(j3), i3, aVUserInfo.commonTipsInfo);
                    }
                    a1(i3, j36, 72);
                    VideoAppInterface.N().k0(new Object[]{66, Long.valueOf(j3)});
                    return;
                }
            }
            O0(aVUserInfo, z16);
            if (z16) {
                f16.Z("onGAudioUserEnterOrLeave", 2);
                if (f16.f73043k < 10) {
                    if (this.C.size() == 1 && z17) {
                        f16.n0("onGAudioUserEnterOrLeave.1", 9);
                        f16.f73069q1 = false;
                    } else {
                        f16.n0("onGAudioUserEnterOrLeave.2", 10);
                        AVControllerCommon.D().s0();
                    }
                }
                if (f16.Z0 != j29 && j29 != j26) {
                    cw.e.d(VideoAppInterface.N(), 1047);
                }
                if (!f16.f73060o0) {
                    j38 = j28;
                    if (f16.f73100y0 == 0) {
                        f16.X(j38, SystemClock.elapsedRealtime());
                    }
                } else if (z17) {
                    j37 = j28;
                } else {
                    j38 = j28;
                    f16.X(j38, SystemClock.elapsedRealtime());
                }
                j37 = j38;
            } else {
                j37 = j28;
                synchronized (this.C) {
                    z18 = this.C.size() == 1 && this.C.get(0) != null && this.C.get(0).f73701a == j26;
                }
                if (z18) {
                    f16.n0("onGAudioUserEnterOrLeave.3", 9);
                    f16.f73069q1 = true;
                    QAVNotification l3 = QAVNotification.l(VideoAppInterface.N());
                    if (l3 != null && l3.n()) {
                        AVControllerCommon.D().u0();
                        AVControllerCommon.D().v0();
                    }
                }
                cw.e.d(VideoAppInterface.N(), 1047);
            }
            if (z16) {
                VideoAppInterface N = VideoAppInterface.N();
                Object[] objArr = new Object[5];
                objArr[0] = 61;
                objArr[1] = Long.valueOf(j3);
                objArr[2] = Long.valueOf(j29);
                objArr[3] = Boolean.TRUE;
                objArr[4] = Boolean.valueOf(aVUserInfo.accountType == 0);
                N.k0(objArr);
            } else if (j16 == 1) {
                z0(true);
            } else if (j16 == 0) {
                VideoAppInterface N2 = VideoAppInterface.N();
                Object[] objArr2 = new Object[5];
                objArr2[0] = 62;
                objArr2[1] = Long.valueOf(j3);
                objArr2[2] = Long.valueOf(j29);
                objArr2[3] = Boolean.valueOf(aVUserInfo.accountType == 0);
                objArr2[4] = Boolean.TRUE;
                N2.k0(objArr2);
            } else if (j16 == 4) {
                if (TextUtils.isEmpty(aVUserInfo.commonTipsInfo)) {
                    VideoAppInterface N3 = VideoAppInterface.N();
                    Object[] objArr3 = new Object[5];
                    objArr3[0] = 62;
                    objArr3[1] = Long.valueOf(j3);
                    objArr3[2] = Long.valueOf(j29);
                    objArr3[3] = Boolean.valueOf(aVUserInfo.accountType == 0);
                    objArr3[4] = Boolean.TRUE;
                    N3.k0(objArr3);
                } else {
                    VideoAppInterface N4 = VideoAppInterface.N();
                    Object[] objArr4 = new Object[5];
                    objArr4[0] = 62;
                    objArr4[1] = Long.valueOf(j3);
                    objArr4[2] = Long.valueOf(j29);
                    objArr4[3] = Boolean.valueOf(aVUserInfo.accountType == 0);
                    objArr4[4] = Boolean.FALSE;
                    N4.k0(objArr4);
                    VideoAppInterface.N().k0(new Object[]{526, aVUserInfo.commonTipsInfo});
                }
            } else {
                VideoAppInterface N5 = VideoAppInterface.N();
                Object[] objArr5 = new Object[5];
                objArr5[0] = 62;
                objArr5[1] = Long.valueOf(j3);
                objArr5[2] = Long.valueOf(j29);
                objArr5[3] = Boolean.valueOf(aVUserInfo.accountType == 0);
                objArr5[4] = Boolean.TRUE;
                N5.k0(objArr5);
            }
            VideoAppInterface.N().k0(new Object[]{1001});
            if (f16.f73060o0) {
                if (z16 && !z17 && (H = AVControllerCommon.D().H()) != null) {
                    H.o(j36);
                }
                Intent intent = new Intent();
                intent.setAction("tencent.av.v2q.MultiVideo");
                if (z16) {
                    intent.putExtra("type", 401);
                } else {
                    intent.putExtra("type", 402);
                }
                intent.putExtra("relationType", 3);
                intent.putExtra("relationId", j36);
                intent.putExtra("friendUin", j29);
                intent.putExtra("MultiAVType", f16.f73063p);
                intent.setPackage(VideoAppInterface.N().getApp().getPackageName());
                AVControllerCommon.D().e0(intent);
                if (z16) {
                    return;
                }
                if (j16 == 4 && !TextUtils.isEmpty(aVUserInfo.commonTipsInfo)) {
                    m1(true, String.valueOf(j3), "", 0, aVUserInfo.commonTipsInfo);
                }
                if (f16.f73064p0) {
                    QAVNotification l16 = QAVNotification.l(VideoAppInterface.N());
                    AVControllerCommon.D().u0();
                    if (l16.n()) {
                        l16.f(f16.f73030h);
                    }
                }
                if (f16.B1) {
                    Y0(j37, j3, false, 2);
                    return;
                }
                return;
            }
            Intent intent2 = new Intent();
            intent2.setAction("tencent.av.v2q.MultiVideo");
            if (z16) {
                intent2.putExtra("type", 22);
                intent2.putExtra("isStart", this.f72723y);
            } else {
                intent2.putExtra("type", 23);
            }
            intent2.putExtra("roomUserNum", this.C.size());
            intent2.putExtra("relationType", i3);
            intent2.putExtra("relationId", j36);
            intent2.putExtra("friendUin", j29);
            intent2.putExtra("MultiAVType", n.e().f().f73063p);
            intent2.putExtra("from", "VideoController5");
            intent2.setPackage(VideoAppInterface.N().getApp().getPackageName());
            AVControllerCommon.D().e0(intent2);
            return;
        }
        QLog.i(J, 1, "onGAudioUserEnterOrLeave, illegal session, sessionId[" + b16 + "]");
    }

    private void H0(long j3, long j16, boolean z16, int i3, long j17, int i16) {
        int i17;
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.w(J, 1, "onGaChatVideoInOrOut, groupId[" + j3 + "], user[" + j16 + "], bVideoIn[" + z16 + "], relationType[" + i3 + "], extraInfo[" + j17 + "], avtype[" + i16 + "], seq[" + d16 + "]");
        }
        long longValue = Long.valueOf(VideoAppInterface.N().getCurrentAccountUin()).longValue();
        if (j17 == 1 && !z16 && j16 != longValue && i3 == 3) {
            return;
        }
        if (!z16 && i3 == 1 && i16 == 2 && j16 != com.tencent.av.utils.i.g(VideoAppInterface.N().getCurrentAccountUin())) {
            for (int i18 = 0; i18 < n.e().f().f73045k1.size(); i18++) {
                if (n.e().f().f73045k1.get(i18).f73827a == j16) {
                    i17 = n.e().f().f73045k1.get(i18).f73828b;
                    break;
                }
            }
        }
        i17 = 1;
        S0(j16, z16, i3, j17);
        if (z16) {
            if (i3 == 2 || i3 == 3 || (i3 == 1 && i16 == 10)) {
                VideoAppInterface.N().k0(new Object[]{69, Long.valueOf(j3), Long.valueOf(j16)});
                return;
            }
            return;
        }
        VideoAppInterface.N().k0(new Object[]{70, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i17), Long.valueOf(d16)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void H1(Intent intent, boolean z16) {
        long a16;
        AVCallCompactHelper v3 = AVControllerCommon.D().v();
        VideoAppInterface.N().getApp().startActivity(intent);
        if (v3 != null) {
            v3.m(intent);
        }
        if (z16) {
            VideoAppInterface.N().v0(true, new Notification());
        } else if (AVControllerCommon.D().f72575f != null) {
            a16 = AVControllerCommon.D().f72575f.a(VideoAppInterface.N(), intent, true);
            if (!QLog.isColorLevel()) {
                QLog.i("CompatModeTag", 2, "startInviteForGroup canStartActivityNow[true], timeout[" + a16 + "]");
                return;
            }
            return;
        }
        a16 = 0;
        if (!QLog.isColorLevel()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I1(int i3, long j3, long j16, long[] jArr, int i16, long j17, VideoAppInterface videoAppInterface, SessionInfo sessionInfo, boolean z16, Intent intent, boolean z17) {
        ((INTGaInviteFragmentPluginHelperApi) QRoute.api(INTGaInviteFragmentPluginHelperApi.class)).setIntentFrom(intent, "onGAudioInvite");
        intent.addFlags(268435456);
        intent.putExtra("uinType", ba.avRelationType2UinType(i3));
        intent.putExtra("peerUin", String.valueOf(j16));
        intent.putExtra("friendUin", j16);
        intent.putExtra("relationType", i3);
        intent.putExtra("MultiAVType", i16);
        intent.putExtra("discussId", j3);
        intent.putExtra("memberList", jArr);
        intent.putExtra(ServiceConst.PARA_SESSION_ID, sessionInfo.f73030h);
        if (AVControllerCommon.D().f72572c && SmallScreenUtils.s(videoAppInterface.getApplication().getApplicationContext()) && i16 != 17 && !z17) {
            if (!z16 && !u.d()) {
                VideoInviteFloatBarUICtr videoInviteFloatBarUICtr = new VideoInviteFloatBarUICtr(videoAppInterface, intent);
                videoInviteFloatBarUICtr.k();
                videoInviteFloatBarUICtr.l(j17, intent);
            } else {
                MultiIncomingCallUICtr multiIncomingCallUICtr = new MultiIncomingCallUICtr(videoAppInterface, intent);
                multiIncomingCallUICtr.q();
                multiIncomingCallUICtr.r(intent);
            }
        } else {
            boolean b16 = az.b(BaseApplication.getContext());
            boolean isAppOnForeground = ForegroundUtil.isAppOnForeground();
            boolean r16 = SmallScreenUtils.r(BaseApplication.getContext());
            int intExtra = intent.getIntExtra("uinType", 0);
            String className = intent.getComponent().getClassName();
            boolean equals = AVCallCompactHelper.f73543c.equals(className);
            QLog.d(J, 1, "startInviteForGroupWrapper canNotDisturb=" + b16 + " isAppOnForeground=" + isAppOnForeground + " uinType=" + intExtra + " isOpEnable=" + r16 + " className=" + className + " isGaInviteActivityInvite=" + equals);
            if (equals && AVUtil.o(intExtra) && r16 && isAppOnForeground) {
                Bundle bundle = new Bundle();
                bundle.putLong("groupUin", intent.getLongExtra("discussId", 0L));
                QIPCClientHelper.getInstance().getClient().callServer("QavQIPCModule", "qav_action_is_not_disturb_mode", bundle, new j(j17, intent, z17));
            } else {
                H1(intent, z17);
            }
        }
    }

    private void P0(long j3, boolean z16, int i3, boolean z17, int i16) {
        boolean z18;
        long j16;
        int n3;
        if (i3 != 2 && i3 != 3 && i3 == 1 && i16 == 2) {
            if (QLog.isColorLevel()) {
                QLog.e(J, 2, "onMemberShareSrcInOrOut-->relationtype is not discuss,uin=" + j3 + ",bin=" + z16 + ",relationType=" + i3 + ",isPPT=" + z17);
                return;
            }
            return;
        }
        if (j3 == Long.valueOf(VideoAppInterface.N().getCurrentAccountUin()).longValue()) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            if (QLog.isColorLevel()) {
                QLog.e(J, 2, "ScreenShare launcher shoult not display content");
                return;
            }
            return;
        }
        com.tencent.av.e K2 = K(String.valueOf(j3));
        if (K2 == null) {
            if (QLog.isColorLevel()) {
                QLog.e(J, 2, "onMemberSpeak-->Can not find the.Uin=" + j3);
                return;
            }
            return;
        }
        if (z16) {
            com.tencent.av.gaudio.c cVar = new com.tencent.av.gaudio.c();
            if (z17) {
                K2.f73706f = 2;
            } else {
                K2.f73706f = 1;
            }
            cVar.f73827a = j3;
            cVar.f73828b = 2;
            cVar.f73829c = true;
            cVar.f73830d = false;
            if (z18) {
                j16 = 4;
            } else {
                j16 = 5;
            }
            cVar.f73833g = j16;
            if (n.e().f().q(j3, cVar.f73828b) != -1) {
                return;
            }
            if (n.e().f().f73045k1.size() > 0) {
                n.e().f().f73045k1.get(0).f73829c = false;
                if (h0() != 4 && (n3 = n.e().f().n(Long.valueOf(VideoAppInterface.N().getCurrentAccountUin()).longValue())) != -1) {
                    n.e().f().f73045k1.get(n3).f73831e = false;
                }
            }
            cVar.f73831e = true;
            if (n.e().f().f73045k1.size() > 1) {
                com.tencent.av.gaudio.c cVar2 = n.e().f().f73045k1.get(0);
                n.e().f().f73045k1.set(0, cVar);
                synchronized (n.e().f().f73053m1) {
                    n.e().f().f73053m1.set(0, cVar);
                }
                n.e().f().e(cVar2, false);
                return;
            }
            n.e().f().e(cVar, true);
            return;
        }
        K2.f73706f = 0;
        g1(j3, n.e().f().f73045k1, n.e().f().f73053m1, 2, false);
        E1();
    }

    private boolean Q0(long j3, boolean z16, int i3) {
        com.tencent.av.e K2 = K(String.valueOf(j3));
        if (K2 == null) {
            if (QLog.isColorLevel()) {
                QLog.e(J, 2, "onMemberSpeak-->Can not find the.Uin=" + j3);
            }
            return false;
        }
        K2.f73703c = z16;
        K2.f73704d = i3;
        return false;
    }

    private qav_gvideo_sdk_transfer$RespInfo R(int i3, int i16, long j3) {
        qav_gvideo_sdk_transfer$ReqInfo qav_gvideo_sdk_transfer_reqinfo = new qav_gvideo_sdk_transfer$ReqInfo();
        qav_gvideo_sdk_transfer_reqinfo.req_event.set(4);
        qav_gvideo_sdk_transfer_reqinfo.gAudioInfo.setHasFlag(true);
        qav_gvideo_sdk_transfer$GAudioInfo qav_gvideo_sdk_transfer_gaudioinfo = qav_gvideo_sdk_transfer_reqinfo.gAudioInfo;
        qav_gvideo_sdk_transfer_gaudioinfo.uint32_relationType.set(i3);
        qav_gvideo_sdk_transfer_gaudioinfo.uint32_multiBusiType.set(i16);
        qav_gvideo_sdk_transfer_gaudioinfo.uint64_relationId.set(j3);
        qav_gvideo_sdk_transfer$RespInfo X0 = X0(3, qav_gvideo_sdk_transfer_reqinfo.toByteArray());
        if (QLog.isColorLevel()) {
            QLog.w(J, 1, "getGAudioRoomInfo, result[" + X0.uint32_result.get() + "], uint64_roomId[" + X0.gAudioInfo.uint64_roomId.get() + "]");
        }
        return X0;
    }

    private void S0(long j3, boolean z16, int i3, long j16) {
        boolean z17;
        com.tencent.av.e K2 = K(String.valueOf(j3));
        if (K2 == null) {
            if (QLog.isColorLevel()) {
                QLog.e(J, 2, "onMemberVideoInOrOut-->Can not find the.Uin=" + j3);
                return;
            }
            return;
        }
        K2.f73705e = z16;
        if (j3 == Long.valueOf(VideoAppInterface.N().getCurrentAccountUin()).longValue()) {
            if (!z16 && i3 == 3 && n.e().f().f73063p == 8) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (n.e().f().q(j3, 1) != -1 && !z17) {
                return;
            }
        }
        if (z16) {
            com.tencent.av.gaudio.c cVar = new com.tencent.av.gaudio.c();
            cVar.f73827a = j3;
            cVar.f73828b = 1;
            if (n.e().f().q(j3, cVar.f73828b) != -1) {
                return;
            }
            cVar.f73833g = j16;
            if (i3 == 1 && j16 != 4 && j16 != 8 && j16 != 2 && j16 != 3) {
                cVar.f73833g = 5L;
            }
            if (!n.e().f().s()) {
                cVar.f73829c = true;
            } else {
                cVar.f73829c = false;
            }
            if (h0() != 4 && i3 != 3) {
                if (n.e().f().n(Long.valueOf(VideoAppInterface.N().getCurrentAccountUin()).longValue()) == -1) {
                    cVar.f73831e = true;
                } else {
                    cVar.f73831e = false;
                }
            } else {
                cVar.f73831e = true;
            }
            if (K2.f73701a == Long.valueOf(VideoAppInterface.N().getCurrentAccountUin()).longValue()) {
                cVar.f73830d = true;
                cVar.f73832f = true;
                cVar.f73831e = true;
                if (!n.e().f().s()) {
                    cVar.f73829c = true;
                } else {
                    cVar.f73829c = false;
                }
            } else {
                cVar.f73830d = false;
            }
            n.e().f().e(cVar, false);
            return;
        }
        if (i3 == 2) {
            g1(j3, n.e().f().f73045k1, n.e().f().f73053m1, 1, false);
        } else if (i3 == 1) {
            if (n.e().f().f73063p == 10) {
                g1(j3, n.e().f().f73045k1, n.e().f().f73053m1, 1, false);
            } else {
                g1(j3, n.e().f().f73045k1, n.e().f().f73053m1, 0, true);
            }
        } else if (i3 == 3) {
            g1(j3, n.e().f().f73045k1, n.e().f().f73053m1, 1, false);
        }
        E1();
    }

    private void U0(long j3, long j16, int i3, long j17, int i16) {
        QLog.d(J, 2, "onVideoRecv ");
        Context applicationContext = VideoAppInterface.N().getApp().getApplicationContext();
        if (applicationContext == null) {
            return;
        }
        xw.b R = VideoAppInterface.N().R();
        R.j(VideoAppInterface.N().getApp().getString(R.string.f1783236c));
        R.e(new c(j3, j16, i3, j17, i16, applicationContext, R));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0(long j3, long j16, boolean z16, int i3, boolean z17, long j17, int i16) {
        String b16;
        if (QLog.isColorLevel()) {
            QLog.d(J, 2, "onGaChatPPTInOrOut,groupUin=" + j3 + " uin = " + j16 + " bIn = " + z16 + " bIsPPT = " + z17 + " extraInfo = " + j17);
        }
        long q16 = AVUtil.q(VideoAppInterface.N().getCurrentAccountUin());
        if (j17 == 1 && !z16 && j16 != q16 && i3 == 3) {
            if (i16 != 10) {
                return;
            }
        }
        if (i3 == 3) {
            b16 = n.b(100, String.valueOf(j3), new int[0]);
        } else {
            b16 = n.b(i3, String.valueOf(j3), new int[0]);
        }
        SessionInfo i17 = n.e().i(b16);
        if (i17 != null) {
            i17.B0(j16, z16, z17);
        }
        if (j16 == VideoAppInterface.N().getLongAccountUin() && i17 != null) {
            i17.C1 = true;
        }
        P0(j16, z16, i3, z17, i16);
        if (z16) {
            VideoAppInterface.N().k0(new Object[]{77, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z17)});
        } else {
            VideoAppInterface.N().k0(new Object[]{78, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z17)});
        }
    }

    private void W0() {
        SessionInfo f16 = n.e().f();
        Vector<Long> vector = this.f72712n.mInviteGAudioUinList;
        if (vector != null && vector.size() > 0) {
            int size = this.f72712n.mInviteGAudioUinList.size();
            long j3 = f16.Z0;
            this.f72712n.inviteUser(f16.f73063p, new long[]{j3}, this.f72709k, null);
            int i3 = size - 1;
            long[] jArr = new long[i3];
            int i16 = 0;
            for (int i17 = 0; i17 < size; i17++) {
                if (this.f72712n.mInviteGAudioUinList.get(i17).longValue() != j3 && i16 < i3) {
                    jArr[i16] = this.f72712n.mInviteGAudioUinList.get(i17).longValue();
                    i16++;
                }
            }
            this.f72712n.inviteUser(f16.f73063p, jArr, 4, null);
        }
    }

    public static MAVController Y() {
        return K;
    }

    private void e1(ArrayList<com.tencent.av.gaudio.c> arrayList, int i3) {
        boolean z16;
        int size;
        boolean z17 = false;
        if (n.e().f().O1 == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (n.e().f().f73035i == 4) {
            z17 = true;
        }
        if (z16 && z17 && (size = arrayList.size() - 1) != i3) {
            com.tencent.av.gaudio.c cVar = arrayList.get(i3);
            arrayList.set(i3, arrayList.get(size));
            arrayList.set(size, cVar);
            i3 = size;
        }
        arrayList.remove(i3);
        if (QLog.isColorLevel()) {
            QLog.w(J, 1, "onRequest_ShowVideo,in removeChildrenWithStytle infoLogs[" + i0(n.e().f().f73045k1) + "]");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int p0(long j3, String str, boolean z16, boolean z17, int i3) {
        int i16;
        boolean z18;
        int nativeStopAudioSend;
        QQGAudioCtrl qQGAudioCtrl = this.f72712n;
        boolean z19 = false;
        if (qQGAudioCtrl != null) {
            if (z16) {
                nativeStopAudioSend = qQGAudioCtrl.startAudioSend(z17);
            } else {
                nativeStopAudioSend = qQGAudioCtrl.nativeStopAudioSend(z17);
            }
            i16 = nativeStopAudioSend;
        } else {
            i16 = 0;
        }
        boolean z26 = this.G;
        StartAudioSendRunnable startAudioSendRunnable = this.H;
        if (!z16) {
            if (!z17 && !z26) {
                z18 = false;
            } else {
                z18 = true;
            }
            this.G = z18;
        } else {
            this.G = false;
        }
        if (i3 != 2) {
            if (i16 != 0 && z17) {
                if (startAudioSendRunnable == null) {
                    this.H = new StartAudioSendRunnable(j3, str, z16, z17);
                } else {
                    if (AVControllerCommon.D().f72576g != null) {
                        AVControllerCommon.D().f72576g.removeCallbacks(this.H);
                    }
                    if (i3 == 0) {
                        this.H = new StartAudioSendRunnable(j3, str, z16, z17);
                    }
                }
                if (AVControllerCommon.D().f72576g != null) {
                    AVControllerCommon.D().f72576g.postDelayed(this.H, 1000L);
                }
            } else if (i3 == 1) {
                this.H = null;
            }
        } else {
            this.H = null;
        }
        String str2 = J;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("switchAudioSend[");
        sb5.append(str);
        sb5.append("], seq[");
        sb5.append(j3);
        sb5.append("], flag[");
        sb5.append(i3);
        sb5.append("], enable[");
        sb5.append(z16);
        sb5.append("], notifySvr[");
        sb5.append(z17);
        sb5.append("], mIsMicOffBySelf[");
        sb5.append(z26);
        sb5.append("->");
        sb5.append(this.G);
        sb5.append("], result[");
        sb5.append(i16);
        sb5.append("], mGAudioCtrl[");
        if (this.f72712n != null) {
            z19 = true;
        }
        sb5.append(z19);
        sb5.append("], lastRunnable[");
        sb5.append(startAudioSendRunnable);
        sb5.append("], curRunnable[");
        sb5.append(this.H);
        sb5.append("]");
        QLog.w(str2, 1, sb5.toString());
        return i16;
    }

    public void A0() {
        VideoAppInterface.N().k0(new Object[]{307});
    }

    public void A1(boolean z16) {
        VideoProcessExitMonitor Q;
        if (VideoAppInterface.N() != null && (Q = VideoAppInterface.N().Q()) != null) {
            Q.v(z16);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x01a0 A[Catch: Exception -> 0x01a8, TRY_LEAVE, TryCatch #3 {Exception -> 0x01a8, blocks: (B:39:0x018b, B:41:0x0195, B:43:0x019b, B:45:0x01a0, B:59:0x0184), top: B:58:0x0184 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean B(SessionInfo sessionInfo, SessionInfo sessionInfo2, long j3, long j16, String str, int i3, long j17, long[] jArr) {
        long j18;
        boolean z16;
        int i16;
        boolean z17;
        boolean z18;
        QAVNotification l3;
        try {
            j18 = Long.parseLong(sessionInfo.f73091w);
        } catch (Throwable th5) {
            th5.printStackTrace();
            j18 = 0;
        }
        if (j18 == j16 && sessionInfo != sessionInfo2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("double_2_multi", 2, "dealSwitchP2PAV ], peerUin[" + j18 + "], friendUin[" + j16 + "], ret[" + z16 + "], main[" + sessionInfo + "], new[" + sessionInfo2 + "]");
        }
        if (!z16) {
            return false;
        }
        if (sessionInfo.A0 == 0) {
            sessionInfo.n0("onGAudioInvite.2", 0);
            n.e().n(j3, str);
            return z16;
        }
        try {
            sessionInfo2.c0(j3, sessionInfo.N);
            i16 = 2;
            z17 = z16;
            try {
                AVControllerCommon.D().f0(str, sessionInfo2.f73035i, false, false, false);
                if (AVControllerCommon.D().F != null && VideoAppInterface.N().M() != null) {
                    VideoAppInterface.N().M().removeCallbacks(AVControllerCommon.D().F);
                }
                if (!sessionInfo.G()) {
                    AVControllerCommon.D().V(j3, R.raw.qav_gaudio_join, 1, null);
                }
                int i17 = sessionInfo.f73035i;
                sessionInfo2.f73091w = sessionInfo.f73091w;
                sessionInfo2.c0(j3, sessionInfo.N);
                sessionInfo2.K = sessionInfo.K;
                sessionInfo2.r0("onGAudioInvite", sessionInfo.I0);
                sessionInfo2.Y("onGAudioInvite", sessionInfo.F0);
                sessionInfo2.f73038i2 = true;
                sessionInfo2.t0("onGAudioInvite", 12);
                sessionInfo.t0("onGAudioInvite", 12);
                DAVController.R().E(sessionInfo.f73091w, 21);
                if (i17 == 1) {
                    sessionInfo2.p0(j3, "onGAudioInvite.2", 3);
                } else if (i17 == 2) {
                    sessionInfo2.p0(j3, "onGAudioInvite.3", 4);
                } else if (i17 == 4) {
                    sessionInfo2.p0(j3, "onGAudioInvite.4", 4);
                } else {
                    sessionInfo2.p0(j3, "onGAudioInvite.5", 3);
                }
                sessionInfo2.f73067q = ba.avRelationType2UinType(i3);
                sessionInfo2.P0 = j17;
                if (jArr != null) {
                    sessionInfo2.Q0 = jArr;
                }
                sessionInfo2.Z("onGAudioInvite.2", 1);
            } catch (Exception e16) {
                e = e16;
            }
        } catch (Exception e17) {
            e = e17;
            i16 = 2;
            z17 = z16;
        }
        if (VideoAppInterface.N().r() > 0) {
            sessionInfo2.u0("onGAudioInvite1", AVUtil.i(sessionInfo2.f73067q));
            VideoAppInterface.N().k0(new Object[]{101, Long.valueOf(j3)});
        } else if (VideoAppInterface.N().isBackgroundStop) {
            sessionInfo2.u0("onGAudioInvite2", 0);
            t(j3, i3, j17, jArr, false);
            z18 = false;
            try {
                A1(false);
                l3 = QAVNotification.l(VideoAppInterface.N());
                if (l3 != null && (z18 = l3.n())) {
                    l3.f(str);
                }
                if (z18) {
                    AVControllerCommon.D().v0();
                }
            } catch (Exception e18) {
                e = e18;
                if (QLog.isColorLevel()) {
                    QLog.e(J, i16, "onGAudioInvite, Exception", e);
                }
                n.e().n(j3, str);
                return z17;
            }
            return z17;
        }
        z18 = false;
        l3 = QAVNotification.l(VideoAppInterface.N());
        if (l3 != null) {
            l3.f(str);
        }
        if (z18) {
        }
        return z17;
    }

    public void B0(long j3, int i3, int i16) {
        VideoAppInterface.N().k0(new Object[]{15001, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16)});
    }

    void B1() {
        if (this.I == null) {
            this.I = new Runnable() { // from class: com.tencent.av.MAVController.26
                @Override // java.lang.Runnable
                public void run() {
                    if (QLog.isColorLevel()) {
                        QLog.d(MAVController.J, 2, "mDoubleVideoMeetingSwitchMulti timeOut ");
                    }
                    VideoAppInterface.N().k0(new Object[]{28, String.valueOf(n.e().f().P0), Boolean.TRUE});
                }
            };
        }
        if (VideoAppInterface.N() != null && this.I != null) {
            VideoAppInterface.N().M().postDelayed(this.I, 5000L);
        }
    }

    public boolean C(SessionInfo sessionInfo, SessionInfo sessionInfo2, long j3, long j16, String str, int i3, long j17, long[] jArr) {
        long j18;
        boolean z16;
        int i16;
        try {
            j18 = Long.parseLong(sessionInfo.f73091w);
        } catch (Throwable th5) {
            th5.printStackTrace();
            j18 = 0;
        }
        boolean z17 = false;
        if (j18 == j16 && sessionInfo.f73068q0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("double_2_multi", 2, "dealSwitchP2PShare ], peerUin[" + j18 + "], friendUin[" + j16 + "], isTurnDoubleVideoMeeting2Multi[" + sessionInfo.f73068q0 + "], ret[" + z16 + "], main[" + sessionInfo + "], new[" + sessionInfo2 + "]");
        }
        sessionInfo.f73068q0 = false;
        if (!z16) {
            return false;
        }
        try {
            VideoAppInterface N = VideoAppInterface.N();
            sessionInfo2.c0(j3, sessionInfo.N);
            AVControllerCommon.D().f0(str, sessionInfo2.f73035i, false, false, false);
            if (this.I != null && N != null) {
                N.M().removeCallbacks(this.I);
            }
            if (!sessionInfo.G()) {
                AVControllerCommon.D().V(j3, R.raw.qav_gaudio_join, 1, null);
            }
            int i17 = sessionInfo.f73035i;
            sessionInfo2.f73038i2 = true;
            sessionInfo2.f73091w = sessionInfo.f73091w;
            if (sessionInfo.f73043k == 15 || sessionInfo.f73064p0) {
                z0(false);
            }
            sessionInfo.t0("onGAudioInvite", 12);
            if (i17 == 1) {
                sessionInfo.p0(j3, "onGAudioInvite.6", 3);
                i16 = 2;
            } else {
                i16 = 2;
                if (i17 == 2) {
                    sessionInfo.p0(j3, "onGAudioInvite.7", 4);
                } else if (i17 == 4) {
                    sessionInfo.p0(j3, "onGAudioInvite.8", 4);
                } else {
                    sessionInfo.p0(j3, "onGAudioInvite.9", 3);
                }
            }
            sessionInfo.f73067q = ba.avRelationType2UinType(i3);
            sessionInfo.P0 = j17;
            if (jArr != null) {
                sessionInfo.Q0 = jArr;
            }
            sessionInfo.Z("onGAudioInvite.1", 1);
            if (N != null) {
                if (N.r() > 0) {
                    sessionInfo.u0("onGAudioInvite3", AVUtil.i(sessionInfo.f73067q));
                    Object[] objArr = new Object[i16];
                    objArr[0] = 101;
                    objArr[1] = Long.valueOf(j3);
                    N.k0(objArr);
                } else if (N.isBackgroundStop) {
                    sessionInfo.u0("onGAudioInvite4", 0);
                    t(j3, i3, j17, jArr, false);
                    A1(false);
                }
            }
            QAVNotification l3 = QAVNotification.l(N);
            if (l3 != null && (z17 = l3.n())) {
                l3.f(sessionInfo.f73030h);
            }
            if (z17) {
                AVControllerCommon.D().v0();
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(J, 2, "onGAudioInviteError-->Exception=" + e16.getMessage());
            }
            n.e().n(j3, str);
        }
        return z16;
    }

    public void C0(ArrayList<AVPhoneUserInfo> arrayList) {
        int size;
        if (QLog.isColorLevel()) {
            String str = J;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("on 0x626Recv --> Size = ");
            if (arrayList == null) {
                size = 0;
            } else {
                size = arrayList.size();
            }
            sb5.append(size);
            QLog.d(str, 2, sb5.toString());
        }
        if (arrayList != null && arrayList.size() != 0) {
            StringBuilder sb6 = new StringBuilder(1024);
            Iterator<AVPhoneUserInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                AVPhoneUserInfo next = it.next();
                Iterator<AVPhoneUserInfo> it5 = n.e().f().f73061o1.iterator();
                boolean z16 = false;
                while (it5.hasNext()) {
                    AVPhoneUserInfo next2 = it5.next();
                    long j3 = next2.account;
                    if (j3 != 0 && j3 == next.account) {
                        AVPhoneUserInfo.TelInfo telInfo = next2.telInfo;
                        AVPhoneUserInfo.TelInfo telInfo2 = next.telInfo;
                        telInfo.mobile = telInfo2.mobile;
                        telInfo.nation = telInfo2.nation;
                        telInfo.prefix = telInfo2.prefix;
                        z16 = true;
                    }
                }
                if (!z16 && QLog.isColorLevel()) {
                    sb6.append("on0x626Recv --> can not find the item . Info = ");
                    sb6.append(next.toString());
                    sb6.append("\n");
                }
                Iterator<com.tencent.av.e> it6 = this.D.iterator();
                while (it6.hasNext()) {
                    com.tencent.av.e next3 = it6.next();
                    if (next3.f73715o == 1 && next3.f73701a == next.account) {
                        if (next3.f73716p == null) {
                            next3.f73716p = new AVPhoneUserInfo();
                        }
                        AVPhoneUserInfo aVPhoneUserInfo = next3.f73716p;
                        aVPhoneUserInfo.accountType = 2;
                        aVPhoneUserInfo.account = next.account;
                        AVPhoneUserInfo.TelInfo telInfo3 = aVPhoneUserInfo.telInfo;
                        AVPhoneUserInfo.TelInfo telInfo4 = next.telInfo;
                        telInfo3.mobile = telInfo4.mobile;
                        telInfo3.nation = telInfo4.nation;
                        telInfo3.prefix = telInfo4.prefix;
                    }
                }
            }
            if (sb6.length() > 0 && QLog.isColorLevel()) {
                QLog.e(J, 2, sb6.toString());
            }
            VideoAppInterface.N().k0(new Object[]{406});
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(J, 2, "on0x626Recv --> no data");
        }
    }

    void C1(com.tencent.av.e eVar, int i3) {
        eVar.f73706f = 0;
        eVar.f73705e = false;
        eVar.f73707g = false;
        eVar.f73708h = false;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (QLog.isColorLevel()) {
                                QLog.e(J, 2, "setVideoSrcType-->wrong type of videosrctype,type=" + i3);
                                return;
                            }
                            return;
                        }
                        eVar.f73708h = true;
                        return;
                    }
                    eVar.f73707g = true;
                    return;
                }
                eVar.f73706f = 1;
                return;
            }
            eVar.f73705e = true;
        }
    }

    void D0(Long l3, long j3, int i3, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(J, 2, "onBanAudio-->relationId" + l3 + " uin=" + j3 + " relationType=" + i3 + " bBan=" + z16);
        }
        if (j3 != Long.valueOf(VideoAppInterface.N().getCurrentAccountUin()).longValue()) {
            return;
        }
        if (z16) {
            n.e().f().f73032h1 = true;
            VideoAppInterface.N().k0(new Object[]{71, l3, Integer.valueOf(i3), Long.valueOf(j3)});
        } else {
            n.e().f().f73032h1 = false;
            VideoAppInterface.N().k0(new Object[]{72, l3, Integer.valueOf(i3), Long.valueOf(j3)});
        }
    }

    public ArrayList<com.tencent.av.e> D1() {
        ArrayList<com.tencent.av.e> arrayList = new ArrayList<>();
        HashSet hashSet = new HashSet();
        Iterator<com.tencent.av.e> it = O().iterator();
        while (it.hasNext()) {
            com.tencent.av.e next = it.next();
            arrayList.add(next);
            hashSet.add(Long.valueOf(next.f73701a));
        }
        Iterator<com.tencent.av.e> it5 = Z().iterator();
        while (it5.hasNext()) {
            com.tencent.av.e next2 = it5.next();
            if (!hashSet.contains(Long.valueOf(next2.f73701a))) {
                next2.f73724x = false;
                arrayList.add(next2);
            }
        }
        return arrayList;
    }

    public void E(String str, long j3, boolean z16) {
        F(str, j3, z16, false, -1);
    }

    public void E0(long j3, String str, String[] strArr) {
        if (!this.f72699a || n.e().f().P0 != j3 || strArr == null || strArr.length == 0 || VideoAppInterface.N().getCurrentAccountUin().equals(str)) {
            return;
        }
        VideoAppInterface.N().k0(new Object[]{82, str, strArr});
    }

    public void E1() {
        if (n.e().f().f73045k1.size() > 0) {
            if (h0() != 4) {
                int o16 = n.e().f().o();
                if (o16 == -1) {
                    n.e().f().f73045k1.get(0).f73829c = true;
                    n.e().f().f73045k1.get(0).f73831e = true;
                    return;
                }
                com.tencent.av.gaudio.c cVar = n.e().f().f73045k1.get(o16);
                cVar.f73829c = true;
                if (cVar.f73827a == Long.valueOf(VideoAppInterface.N().getCurrentAccountUin()).longValue()) {
                    if (o16 != 0) {
                        com.tencent.av.gaudio.c cVar2 = n.e().f().f73045k1.get(0);
                        cVar2.f73829c = false;
                        n.e().f().f73045k1.set(0, cVar);
                        n.e().f().f73045k1.set(o16, cVar2);
                        synchronized (n.e().f().f73053m1) {
                            n.e().f().f73053m1.set(0, cVar);
                            n.e().f().f73053m1.set(o16, cVar2);
                            n.e().f().S();
                        }
                    }
                    if (n.e().f().n(Long.valueOf(VideoAppInterface.N().getCurrentAccountUin()).longValue()) == -1) {
                        for (int i3 = 0; i3 < n.e().f().f73045k1.size(); i3++) {
                            if (n.e().f().f73045k1.get(i3).f73827a != Long.valueOf(VideoAppInterface.N().getCurrentAccountUin()).longValue()) {
                                n.e().f().f73045k1.get(i3).f73831e = true;
                            }
                        }
                        return;
                    }
                    return;
                }
                if (o16 != 0) {
                    com.tencent.av.gaudio.c cVar3 = n.e().f().f73045k1.get(0);
                    cVar3.f73829c = false;
                    n.e().f().f73045k1.set(0, cVar);
                    n.e().f().f73045k1.set(o16, cVar3);
                    synchronized (n.e().f().f73053m1) {
                        n.e().f().f73053m1.set(0, cVar);
                        n.e().f().f73053m1.set(o16, cVar3);
                        n.e().f().S();
                    }
                    return;
                }
                return;
            }
            n.e().f().f73045k1.get(0).f73829c = true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void F(final String str, final long j3, final boolean z16, final boolean z17, int i3) {
        byte b16;
        if (this.f72712n != null) {
            if (AVControllerCommon.D().f72576g != null) {
                AVControllerCommon.D().f72576g.post(new Runnable() { // from class: com.tencent.av.MAVController.7
                    @Override // java.lang.Runnable
                    public void run() {
                        MAVController.this.L1(str + "_" + j3, z16, z17);
                    }
                });
            }
            p1("gAudioSetInput", !z16);
            if (i3 == -1) {
                i3 = !z16 ? 1 : 0;
            }
            r1("gAudioSetInput", i3);
        }
        long g16 = com.tencent.av.utils.i.g(VideoAppInterface.N().getCurrentAccountUin());
        synchronized (this.C) {
            if (this.C.size() > 1) {
                b16 = true;
            } else {
                b16 = false;
            }
        }
        if (!z16 && b16 != false) {
            R0(this.f72700b, new long[]{g16}, z16, 0);
        }
    }

    public void F0(int i3, long j3, int i16, int i17, int i18) {
        char c16;
        char c17;
        long j16;
        String b16 = n.b(i3, String.valueOf(j3), new int[0]);
        if (i3 == 3) {
            b16 = n.b(100, String.valueOf(j3), new int[0]);
        }
        long d16 = com.tencent.av.utils.e.d();
        QLog.w(J, 1, "onGAudioSDKError, relationType[" + i3 + "], relationId[" + j3 + "], reason[" + i16 + "], detail[" + i17 + "], type[" + i18 + "], sessionId[" + b16 + "], mGAudioInRoom[" + this.f72699a + "], seq[" + d16 + "]");
        if (j3 == 0) {
            return;
        }
        SessionInfo f16 = n.e().f();
        if (f16 != null && f16.N) {
            VideoAppInterface.N().k0(new Object[]{106, Long.valueOf(d16)});
        }
        int avRelationType2UinType = ba.avRelationType2UinType(i3);
        AVControllerCommon.D().h0(n.e().f().f73030h, avRelationType2UinType, i16, false, String.valueOf(j3), String.valueOf(i17), false);
        if (this.f72699a) {
            a1(i3, j3, 71);
            c16 = 2;
            c17 = 1;
            j16 = d16;
        } else {
            String currentAccountUin = VideoAppInterface.N().getCurrentAccountUin();
            c16 = 2;
            c17 = 1;
            j16 = d16;
            AVControllerCommon.D().g0("onGAudioSDKError", b16, avRelationType2UinType, currentAccountUin, String.valueOf(j3), 7, currentAccountUin, false, false);
            if (this.f72724z != null) {
                VideoAppInterface.N().M().removeCallbacks(this.f72724z);
                this.f72724z = null;
            }
        }
        AVControllerCommon.D().i("onGAudioSDKError_2");
        if (AVControllerCommon.D().f72574e != null) {
            AVControllerCommon.D().f72574e.X(j16);
        }
        VideoAppInterface N = VideoAppInterface.N();
        Object[] objArr = new Object[3];
        objArr[0] = 66;
        objArr[c17] = Long.valueOf(j3);
        objArr[c16] = Integer.valueOf(i18);
        N.k0(objArr);
        n.e().n(j16, b16);
    }

    public void F1(int i3, int i16, boolean z16, boolean z17, String str) {
        if (VideoAppInterface.N() != null) {
            Intent intent = new Intent();
            intent.setAction("tencent.av.v2q.StartDoubleVideoMeeting");
            intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, i3);
            intent.putExtra("uinType", i16);
            intent.putExtra("peerUin", str);
            intent.putExtra("isReceiver", true);
            intent.putExtra("updateTime", z16);
            intent.putExtra(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME, z17);
            intent.setPackage(VideoAppInterface.N().getApp().getPackageName());
            AVControllerCommon.D().e0(intent);
        }
    }

    public AVPhoneUserInfo G(long j3, ArrayList<AVPhoneUserInfo> arrayList) {
        Iterator<AVPhoneUserInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            AVPhoneUserInfo next = it.next();
            if (j3 == next.account) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int G1(int i3, long j3, int i16, long[] jArr, boolean z16, String[] strArr) {
        boolean z17;
        boolean z18;
        SessionInfo i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        SessionInfo f16;
        final long j16;
        int i29;
        int i36;
        if (j3 == 0) {
            QLog.i(J, 1, "startGAudioChat, relationId illegal.");
            return -1;
        }
        if (this.f72712n == null) {
            o0();
        }
        com.tencent.av.utils.e.w(VideoAppInterface.N());
        AVCoreLog.printInfoLog("VideoNodeManager", "==> startGAudioChat() ********************************** isVideo = " + z16 + "  SessionMgr.getInstance().getMainSession().multiAVType = " + n.e().f().f73063p);
        com.tencent.av.utils.e.p("startGAudioChat ");
        String str = J;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("startGAudioChat, relationType[");
        sb5.append(i3);
        sb5.append("], relationId[");
        sb5.append(j3);
        sb5.append("], businessId[");
        sb5.append(i16);
        sb5.append("], uinList[");
        sb5.append(jArr);
        sb5.append("], openIdList[");
        sb5.append(strArr);
        sb5.append("], isVideo[");
        sb5.append(z16);
        sb5.append("], mGAudioCtrl[");
        int i37 = 0;
        if (this.f72712n != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        sb5.append(z17);
        sb5.append("], VideoAppInterface.getInstance()[");
        if (VideoAppInterface.N() != null) {
            z18 = true;
        } else {
            z18 = false;
        }
        sb5.append(z18);
        sb5.append("]");
        QLog.w(str, 1, sb5.toString());
        if (this.f72712n == null || VideoAppInterface.N() == null) {
            return -1;
        }
        String b16 = n.b(i3, String.valueOf(j3), new int[0]);
        if (i3 == 3) {
            b16 = n.b(100, String.valueOf(j3), new int[0]);
        }
        if (!n.e().j(b16)) {
            i17 = n.e().a(b16, true);
            if (i17 != null) {
                i17.S0 = i3;
                i17.f73063p = i16;
            }
        } else {
            i17 = n.e().i(b16);
        }
        this.f72716r = false;
        long g16 = com.tencent.av.utils.i.g(VideoAppInterface.N().getCurrentAccountUin());
        int i38 = 5;
        if (i3 != 7 && i3 != 9) {
            if (i3 == 2) {
                if (n.e().f().N) {
                    i28 = 2;
                } else {
                    i28 = 1;
                }
                i19 = i3;
                i18 = 3;
                i27 = 0;
                i26 = 1;
            } else if (i3 == 1) {
                int i39 = n.e().f().f73063p;
                if (n.e().f().N) {
                    i28 = 2;
                } else {
                    i28 = 1;
                }
                i26 = i39;
                i18 = 3;
                i27 = 0;
                i19 = 1;
            } else if (i3 == 11) {
                int i46 = n.e().f().f73063p;
                if (i46 == 17) {
                    i29 = 5;
                } else {
                    i29 = 0;
                }
                if (n.e().f().N) {
                    i36 = 2;
                } else {
                    i36 = 1;
                }
                QLog.w(J, 1, "startGAudioChat multiAVType\uff1a" + i46);
                i27 = i29;
                i18 = 3;
                i37 = 0;
                i26 = i46;
                i28 = i36;
                i19 = i3;
            } else if (i3 == 10) {
                i19 = i3;
                i26 = i16;
                i28 = 1;
                i18 = 3;
                i37 = 0;
                i27 = 0;
            } else {
                i18 = 3;
                if (i3 == 3) {
                    if (i17 != null) {
                        i17.P0 = j3;
                        i17.S0 = i3;
                        i17.f73063p = i16;
                        i17.f73091w = String.valueOf(j3);
                        i37 = 0;
                        i17.f73067q = 0;
                        i17.y0("startGAudioChat", true);
                    } else {
                        i37 = 0;
                    }
                } else {
                    return -1;
                }
            }
            f16 = n.e().f();
            if (z16) {
                i28 = 2;
            }
            if (f16.f73060o0 || !f16.V0) {
                if (!f16.G()) {
                    i38 = i18;
                } else {
                    i38 = i28;
                }
            }
            AVControllerCommon.D().t0();
            if (QLog.isColorLevel()) {
                QLog.d(J, 2, "SessionMgr.getInstance().getMainSession().localHasVideo = " + n.e().f().N);
            }
            AVControllerCommon.D().p0();
            VideoAppInterface.N().getVideoConfigUpdate();
            VideoAppInterface.N().H0();
            final int i47 = i19;
            int i48 = i37;
            this.f72712n.startGAudio(i19, i26, i38, j3, jArr, strArr, com.tencent.av.app.q.a(), g16, n.e().f().G(), n.e().f().R1, n.e().f().Q1, n.e().f().f73042j2, i27);
            if (this.f72724z != null) {
                j16 = j3;
                this.f72724z = new Runnable() { // from class: com.tencent.av.MAVController.4
                    @Override // java.lang.Runnable
                    public void run() {
                        int i49;
                        MAVController.this.f72724z = null;
                        SessionInfo f17 = n.e().f();
                        f17.n0("startGAudioChat.1", 0);
                        boolean isNetworkAvailable = NetworkUtil.isNetworkAvailable(VideoAppInterface.N().getApplication().getApplicationContext());
                        long j17 = j16;
                        if (j17 == f17.P0 && !f17.U0) {
                            MAVController mAVController = MAVController.this;
                            int i56 = i47;
                            if (isNetworkAvailable) {
                                i49 = 71;
                            } else {
                                i49 = 70;
                            }
                            mAVController.onGAudioSDKError(i56, j17, i49, 0);
                        }
                    }
                };
            } else {
                j16 = j3;
            }
            this.f72723y = true;
            f16.n0("startGAudioChat.2", 8);
            f16.P0 = j16;
            VideoAppInterface.N().M().postDelayed(this.f72724z, 30000L);
            AVControllerCommon.D().d0();
            AVControllerCommon.D().f0(f16.f73030h, 3, false, false, false);
            return i48;
        }
        i18 = 3;
        i19 = i3;
        i26 = i16;
        i27 = i37;
        i28 = 1;
        f16 = n.e().f();
        if (z16) {
        }
        if (f16.f73060o0) {
        }
        if (!f16.G()) {
        }
        AVControllerCommon.D().t0();
        if (QLog.isColorLevel()) {
        }
        AVControllerCommon.D().p0();
        VideoAppInterface.N().getVideoConfigUpdate();
        VideoAppInterface.N().H0();
        final int i472 = i19;
        int i482 = i37;
        this.f72712n.startGAudio(i19, i26, i38, j3, jArr, strArr, com.tencent.av.app.q.a(), g16, n.e().f().G(), n.e().f().R1, n.e().f().Q1, n.e().f().f73042j2, i27);
        if (this.f72724z != null) {
        }
        this.f72723y = true;
        f16.n0("startGAudioChat.2", 8);
        f16.P0 = j16;
        VideoAppInterface.N().M().postDelayed(this.f72724z, 30000L);
        AVControllerCommon.D().d0();
        AVControllerCommon.D().f0(f16.f73030h, 3, false, false, false);
        return i482;
    }

    public boolean H() {
        return this.E;
    }

    public long I() {
        return this.f72717s;
    }

    public void I0(int i3, long j3, long j16, int i16, long j17, long j18) {
        VideoAppInterface.N().k0(new Object[]{500, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i16), Long.valueOf(j17), Long.valueOf(j18)});
    }

    public Bitmap J(String str, String str2, int i3, boolean z16, boolean z17) {
        int i16;
        if (VideoAppInterface.N().isFriend(str)) {
            i16 = 0;
        } else if (i3 == 1) {
            i16 = 1000;
        } else {
            i16 = 1004;
        }
        return VideoAppInterface.N().J(i16, str, str2, z17, z16);
    }

    public void J0(int i3, long j3, long j16, int i16, int i17, long j17, long j18) {
        VideoAppInterface.N().k0(new Object[]{502, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j17), Long.valueOf(j18)});
    }

    public boolean J1(String str) {
        final long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.i(J, 2, "stopGVideo, from[" + str + "]");
        }
        if (this.f72712n != null) {
            if (AVControllerCommon.D().f72576g != null) {
                AVControllerCommon.D().f72576g.post(new Runnable() { // from class: com.tencent.av.MAVController.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MAVController.this.f72712n.stopVideoRecv() != 0) {
                            if (n.e().f().f73045k1.size() == 0) {
                                n.e().f().w0(d16, "StopGVideo", false, true);
                            }
                        } else if (QLog.isColorLevel()) {
                            QLog.e(MAVController.J, 2, "stopGVideo-->Stop GVideo Failed.The Cmd Did Not Send Suc");
                        }
                    }
                });
                return true;
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.e(J, 2, "stopGVideo-->Stop GVideo Failed.The mGAudioCtrl is null");
            return false;
        }
        return false;
    }

    public com.tencent.av.e K(String str) {
        com.tencent.av.e eVar;
        synchronized (this.C) {
            int i3 = 0;
            while (true) {
                if (i3 < this.C.size()) {
                    eVar = this.C.get(i3);
                    if (eVar != null && eVar.f73701a == Long.valueOf(str).longValue()) {
                        break;
                    }
                    i3++;
                } else {
                    eVar = null;
                    break;
                }
            }
        }
        return eVar;
    }

    public void K0(long j3, long j16, int i3, int i16, boolean z16) {
        QQGAudioCtrl qQGAudioCtrl = this.f72712n;
        if (qQGAudioCtrl == null) {
            QLog.w(J, 2, "onGroupSystemMsgCome()  mGAudioCtrl == null !!    return !");
            return;
        }
        if (i16 != 3) {
            if (i16 != 7) {
                if (i16 == 15) {
                    if (z16) {
                        qQGAudioCtrl.modifyGroupAdmin(j16, false);
                    }
                    if (this.f72699a && this.f72700b == j3) {
                        n.e().f().f73037i1 = false;
                        VideoAppInterface.N().k0(new Object[]{303, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16)});
                        return;
                    }
                    return;
                }
                return;
            }
            VideoAppInterface.N().k0(new Object[]{66, Long.valueOf(j3)});
            return;
        }
        if (z16) {
            qQGAudioCtrl.modifyGroupAdmin(j16, true);
        }
        if (this.f72699a && this.f72700b == j3) {
            n.e().f().f73037i1 = true;
            VideoAppInterface.N().k0(new Object[]{302, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16)});
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int K1(String str, boolean z16) {
        QQGAudioCtrl qQGAudioCtrl = this.f72712n;
        if (qQGAudioCtrl == null) {
            return -1;
        }
        if (this.f72699a) {
            if (z16) {
                qQGAudioCtrl.stopAudioRecv();
                String str2 = str + "_stopOrStartGAudioTRAE_stop";
                this.f72715q = this.f72714p;
                L1(str2, false, true);
                p1(str2, true);
                r1(str2, 1);
            } else {
                String str3 = str + "_stopOrStartGAudioTRAE";
                L1(str3, !this.f72715q, true);
                p1(str3, this.f72715q);
                r1(str3, this.f72715q ? 1 : 0);
                this.f72712n.startAudioRecv();
            }
        }
        return 0;
    }

    public String L(String str, String str2, int i3) {
        int i16;
        if (i3 == 1) {
            i16 = 1000;
        } else if (i3 != 2 && VideoAppInterface.N().isFriend(str)) {
            i16 = 0;
        } else {
            i16 = 1004;
        }
        return VideoAppInterface.N().G(i16, str, str2);
    }

    public void L0(int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.d(J, 2, "onInviteUser --> Count = " + i3 + " , firstName = " + str);
        }
        if (i3 > 0 && str != null) {
            VideoAppInterface.N().k0(new Object[]{409, Integer.valueOf(i3), str});
        }
    }

    int L1(String str, boolean z16, boolean z17) {
        return p0(com.tencent.av.utils.e.d(), str, z16, z17, 0);
    }

    public String M(String str, String str2, int i3) {
        int i16;
        if (i3 == 1) {
            i16 = 1000;
        } else if (i3 != 2 && VideoAppInterface.N().isFriend(str)) {
            i16 = 0;
        } else {
            i16 = 1004;
        }
        return VideoAppInterface.N().H(i16, str, str2);
    }

    void M0(int i3, long j3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d(J, 2, "onGaRoomSettingChanged-->relationType = " + i3 + " relationUin = " + j3 + " changedType = " + i16);
        }
        if (i16 == 102) {
            n.e().f().f73017e1 = true;
        } else if (i16 == 103) {
            n.e().f().f73017e1 = false;
        }
        VideoAppInterface.N().k0(new Object[]{85, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16)});
    }

    public void M1(long j3, int i3, long j16, ArrayList<String> arrayList) {
        Object obj;
        int i16;
        int i17;
        int i18;
        int i19;
        SessionInfo sessionInfo;
        String str;
        int i26;
        SessionInfo sessionInfo2;
        int i27;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("switchToMultiAudio, roomId[");
        sb5.append(j16);
        sb5.append("], memberList[");
        if (arrayList != null) {
            obj = Integer.valueOf(arrayList.size());
        } else {
            obj = "null";
        }
        sb5.append(obj);
        sb5.append("], seq[");
        sb5.append(j3);
        sb5.append("], uinType[");
        sb5.append(i3);
        sb5.append("]");
        QLog.w("double_2_multi", 1, sb5.toString());
        if (i3 == 1) {
            i16 = 1;
        } else {
            i16 = 2;
        }
        DataReport.T(null, "dc00898", "", "", "0X800A2CA", "0X800A2CA", i16, 0, "", "", "", "");
        if (arrayList != null) {
            z1(true);
            if (i3 == 1) {
                i17 = 10;
                i18 = 1;
            } else {
                i17 = 1;
                i18 = 2;
            }
            SessionInfo f16 = n.e().f();
            SessionInfo a16 = n.e().a(n.b(i18, String.valueOf(j16), new int[0]), false);
            int i28 = f16.f73035i;
            a16.c0(j3, f16.N);
            a16.K = f16.K;
            a16.r0("switchToMultiAudio", f16.I0);
            a16.Y("switchToMultiAudio", f16.F0);
            a16.f73091w = f16.f73091w;
            a16.f73063p = i17;
            a16.f73038i2 = true;
            if (AVControllerCommon.D().F != null) {
                VideoAppInterface.N().M().removeCallbacks(AVControllerCommon.D().F);
            }
            if (f16.f73060o0) {
                boolean z16 = this.f72714p;
                i19 = i28;
                sessionInfo = a16;
                str = "switchToMultiAudio";
                i26 = 1;
                Y0(j3, Long.valueOf(f16.f73091w).longValue(), true, 0);
                p1(str, z16);
                r1(str, z16 ? 1 : 0);
                this.f72709k = 2;
                sessionInfo2 = f16;
            } else {
                i19 = i28;
                sessionInfo = a16;
                str = "switchToMultiAudio";
                i26 = 1;
                sessionInfo2 = f16;
                DAVController.R().F(sessionInfo2.f73091w, 1);
                DAVController.R().H0(214);
                DAVController.R().E(sessionInfo2.f73091w, 21);
                this.f72709k = 1;
            }
            if (!arrayList.contains(sessionInfo2.f73091w)) {
                arrayList.add(sessionInfo2.f73091w);
            }
            int size = arrayList.size();
            long[] jArr = new long[size];
            Iterator<String> it = arrayList.iterator();
            int i29 = 0;
            while (it.hasNext()) {
                try {
                    int i36 = i29 + 1;
                    try {
                        jArr[i29] = Long.parseLong(it.next());
                        i29 = i36;
                    } catch (Throwable th5) {
                        th = th5;
                        i29 = i36;
                        th.printStackTrace();
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            }
            if (i29 == size) {
                sessionInfo.Q0 = jArr;
                i27 = 0;
            } else {
                long[] jArr2 = new long[i29];
                sessionInfo.Q0 = jArr2;
                i27 = 0;
                if (i29 >= 0) {
                    System.arraycopy(jArr, 0, jArr2, 0, i29);
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("double_2_multi", 4, "switchToMultiAudio uinList[" + size + "]");
            }
            sessionInfo.A0 = -1;
            int i37 = i19;
            if (i37 == i26) {
                sessionInfo.p0(j3, "switchToMultiAudio.1", 3);
            } else if (i37 == 2) {
                sessionInfo.p0(j3, "switchToMultiAudio.2", 4);
            } else if (i37 == 3) {
                sessionInfo.p0(j3, "switchToMultiAudio.3", 3);
            } else if (i37 == 4) {
                sessionInfo.p0(j3, "switchToMultiAudio.4", 3);
            }
            int i38 = i26;
            sessionInfo.f73067q = i3;
            SessionInfo sessionInfo3 = sessionInfo;
            sessionInfo3.P0 = j16;
            sessionInfo3.u0(str, AVUtil.i(i3));
            sessionInfo3.Z(str, i27);
            VideoAppInterface N = VideoAppInterface.N();
            Object[] objArr = new Object[2];
            objArr[i27] = 101;
            objArr[i38] = Long.valueOf(j3);
            N.k0(objArr);
        }
    }

    public QQGAudioCtrl N() {
        return this.f72712n;
    }

    void N0(int i3, long j3, int i16) {
        if (i16 == 108) {
            n.e().f().f73027g1 = true;
            n.e().f().f73022f1 = !s0();
            int T = T();
            F("onMVSpeakModeChanged_1", this.f72700b, false, false, -1);
            B0(-1L, T, T());
        } else if (n.e().f().f73027g1) {
            n.e().f().f73027g1 = false;
            int T2 = T();
            if (n.e().f().f73022f1) {
                F("onMVSpeakModeChanged_2", this.f72700b, true, false, -1);
            } else {
                F("onMVSpeakModeChanged_3", this.f72700b, false, false, -1);
            }
            B0(-1L, T2, T());
        }
        VideoAppInterface.N().k0(new Object[]{86, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16)});
    }

    public boolean N1(qav_gvideo_sdk_transfer$gVideoDownChannelControl qav_gvideo_sdk_transfer_gvideodownchannelcontrol) {
        com.tencent.av.app.o oVar = this.f72704f;
        if (oVar != null) {
            return oVar.c(qav_gvideo_sdk_transfer_gvideodownchannelcontrol);
        }
        return false;
    }

    public ArrayList<com.tencent.av.e> O() {
        synchronized (this.C) {
            if (com.tencent.av.utils.e.j() && ((IQQDebugApi) QRoute.api(IQQDebugApi.class)).getSGAudioVirtualList() != null) {
                ArrayList<com.tencent.av.e> arrayList = new ArrayList<>();
                arrayList.addAll(this.C);
                arrayList.addAll(((IQQDebugApi) QRoute.api(IQQDebugApi.class)).getSGAudioVirtualList());
                return arrayList;
            }
            return this.C;
        }
    }

    void O0(AVUserInfo aVUserInfo, boolean z16) {
        long j3;
        com.tencent.av.e eVar;
        synchronized (this.C) {
            try {
                j3 = Long.parseLong(aVUserInfo.account);
            } catch (NumberFormatException e16) {
                com.tencent.qav.log.a.c(J, "expection[" + e16.getMessage() + "]", new Throwable("stack trace"));
                j3 = 0;
            }
            long j16 = j3;
            if (z16) {
                if (X(j16) != -1) {
                    return;
                }
                com.tencent.av.e eVar2 = new com.tencent.av.e();
                eVar2.f73701a = j16;
                eVar2.f73715o = aVUserInfo.accountType;
                if (aVUserInfo.extInfoType == 1) {
                    eVar2.f73726z = GAudioZPlanStatus.a(aVUserInfo.extBusinessInfo);
                }
                this.C.add(eVar2);
            } else {
                int X = X(j16);
                if (X != -1) {
                    eVar = this.C.remove(X);
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.e(J, 2, "onMemberInOrOut-->can not find the member.userInfo = " + aVUserInfo);
                    }
                    eVar = null;
                }
                g1(j16, n.e().f().f73045k1, n.e().f().f73053m1, 0, true);
                E1();
                if (eVar != null && !eVar.f73717q && eVar.f73719s) {
                    onGAudioUserAudioSuspectNoisy(0L, false, 0L);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i(J, 2, "onMemberInOrOut, size[" + this.C.size() + "], coming[" + aVUserInfo + "]");
            }
        }
    }

    public void O1(String str, boolean z16, int i3, long j3) {
        if (this.f72699a != z16 || this.f72701c != i3 || this.f72700b != j3 || QLog.isColorLevel()) {
            QLog.i(J, 1, String.format("updateCurJoinGRoomInfo, from[%s], [%s, %s, %s] --> [%s, %s, %s]", str, Boolean.valueOf(this.f72699a), Integer.valueOf(this.f72701c), Long.valueOf(this.f72700b), Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3)));
        }
        this.f72699a = z16;
        this.f72700b = j3;
        this.f72701c = i3;
    }

    public ArrayList<ResultRecord> P() {
        ArrayList<ResultRecord> arrayList;
        synchronized (this.C) {
            ArrayList<com.tencent.av.e> O = O();
            arrayList = new ArrayList<>();
            Iterator<com.tencent.av.e> it = O.iterator();
            while (it.hasNext()) {
                com.tencent.av.e next = it.next();
                ResultRecord resultRecord = new ResultRecord();
                resultRecord.uin = String.valueOf(next.f73701a);
                arrayList.add(resultRecord);
            }
            Iterator<com.tencent.av.e> it5 = this.A.iterator();
            while (it5.hasNext()) {
                com.tencent.av.e next2 = it5.next();
                ResultRecord resultRecord2 = new ResultRecord();
                resultRecord2.uin = String.valueOf(next2.f73701a);
                arrayList.add(resultRecord2);
            }
        }
        return arrayList;
    }

    public boolean P1(long j3, int i3, int i16, boolean z16) {
        boolean z17 = false;
        if (this.f72712n == null) {
            return false;
        }
        synchronized (this.C) {
            int size = this.C.size();
            int i17 = 0;
            while (true) {
                if (i17 >= size) {
                    break;
                }
                com.tencent.av.e eVar = this.C.get(i17);
                if (eVar != null && eVar.f73701a == j3) {
                    eVar.f73717q = z16;
                    eVar.f73715o = i3;
                    boolean z18 = eVar.f73719s;
                    if (z16) {
                        eVar.f73719s = false;
                    } else if (eVar.f73718r) {
                        eVar.f73718r = false;
                        VideoAppInterface.N().k0(new Object[]{157, Long.valueOf(j3), Boolean.FALSE});
                    }
                    z17 = z18;
                }
                i17++;
            }
        }
        return z17;
    }

    public int Q() {
        QQGAudioCtrl qQGAudioCtrl;
        if (this.f72699a && (qQGAudioCtrl = this.f72712n) != null) {
            return qQGAudioCtrl.getNetLevel();
        }
        return -1;
    }

    public Pair<Integer, ArrayList<com.tencent.av.e>> Q1() {
        synchronized (this.C) {
            ArrayList<com.tencent.av.e> arrayList = this.C;
            ArrayList<com.tencent.av.e> Z = Z();
            if (arrayList.size() == 0) {
                return new Pair<>(0, null);
            }
            ArrayList arrayList2 = new ArrayList();
            HashSet hashSet = new HashSet();
            Iterator<com.tencent.av.e> it = arrayList.iterator();
            while (it.hasNext()) {
                com.tencent.av.e next = it.next();
                next.f73724x = true;
                arrayList2.add(next);
                hashSet.add(Long.valueOf(next.f73701a));
            }
            int size = arrayList2.size();
            Iterator<com.tencent.av.e> it5 = Z.iterator();
            while (it5.hasNext()) {
                com.tencent.av.e next2 = it5.next();
                if (!hashSet.contains(Long.valueOf(next2.f73701a))) {
                    next2.f73724x = false;
                    arrayList2.add(next2);
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.d(J, 1, "updateMemberAttendedInfo joint number size:=" + arrayList.size() + ";all members:=" + arrayList2.size());
            }
            return new Pair<>(Integer.valueOf(size), arrayList2);
        }
    }

    void R0(long j3, long[] jArr, boolean z16, int i3) {
        long j16 = jArr[0];
        if (QLog.isDevelopLevel()) {
            QLog.d(J, 2, "onMemberSpeak-->setSpeakingUin,uin=" + j16 + ", isSpeaking = " + z16 + ", audioEnergy = " + i3);
        }
        VideoAppInterface.N().k0(new Object[]{63, Long.valueOf(j16), Boolean.valueOf(z16), Boolean.valueOf(Q0(j16, z16, i3)), Integer.valueOf(i3)});
        final Intent intent = new Intent("tencent.video.v2q.memberSpeaking");
        intent.putExtra("groupId", j3);
        intent.putExtra(SquareJSConst.Params.PARAMS_UIN_LIST, jArr);
        intent.putExtra("isSpeaking", z16);
        intent.putExtra("audioEnergy", i3);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.MAVController.20
            @Override // java.lang.Runnable
            public void run() {
                VideoAppInterface.N().getApplication().sendBroadcast(intent);
            }
        }, 16, null, true);
        if (n.e().f().H2) {
            QAVControllerForZplan.p().E(j16, z16);
        }
    }

    public void R1(PBRepeatMessageField<submsgtype0x116$MemberInfo> pBRepeatMessageField, PBRepeatMessageField<submsgtype0x116$MemberInfo> pBRepeatMessageField2, int i3, int i16) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d(J, 2, "InviteMemberList updateMemberListWithPushMessage joins" + pBRepeatMessageField.size() + ";quits size" + pBRepeatMessageField2.size() + ";eventType:=" + i16);
        }
        HashSet hashSet = new HashSet();
        Iterator<com.tencent.av.e> it = this.A.iterator();
        while (it.hasNext()) {
            hashSet.add(Long.valueOf(it.next().f73701a));
        }
        if (QLog.isColorLevel()) {
            QLog.d(J, 2, "mMemberChangeEventReceiver totalCount:" + i3);
        }
        boolean z17 = false;
        for (int i17 = 0; i17 < pBRepeatMessageField.size(); i17++) {
            submsgtype0x116$MemberInfo submsgtype0x116_memberinfo = pBRepeatMessageField.get(i17).get();
            if (submsgtype0x116_memberinfo.uint64_member_uin.get() == VideoAppInterface.N().getLongAccountUin()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!hashSet.contains(Long.valueOf(submsgtype0x116_memberinfo.uint64_member_uin.get())) && !z16) {
                com.tencent.av.e eVar = new com.tencent.av.e();
                eVar.f73715o = 0;
                eVar.f73701a = submsgtype0x116_memberinfo.uint64_member_uin.get();
                eVar.f73724x = false;
                eVar.f73725y = submsgtype0x116_memberinfo.uint32_invite_timestamp.get();
                this.A.add(eVar);
                if (QLog.isColorLevel()) {
                    QLog.d(J, 2, "mMemberChangeEventReceiver add member UIN:" + eVar.f73701a);
                }
                z17 = true;
            }
        }
        for (int i18 = 0; i18 < pBRepeatMessageField2.size(); i18++) {
            submsgtype0x116$MemberInfo submsgtype0x116_memberinfo2 = pBRepeatMessageField2.get(i18).get();
            Iterator<com.tencent.av.e> it5 = this.A.iterator();
            while (true) {
                if (it5.hasNext()) {
                    com.tencent.av.e next = it5.next();
                    if (next.f73701a == submsgtype0x116_memberinfo2.uint64_member_uin.get()) {
                        this.A.remove(next);
                        if (i16 != 2) {
                            z17 = true;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(J, 2, "mMemberChangeEventReceiver remove member UIN:" + next.f73701a);
                        }
                    }
                }
            }
        }
        if (z17) {
            VideoAppInterface.N().k0(new Object[]{Integer.valueOf(TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_HOOK), 1L, 1L, this.A});
        }
    }

    public boolean S(int i3, long j3, int i16) {
        int i17;
        QQGAudioCtrl qQGAudioCtrl;
        int i18;
        if (this.f72712n == null) {
            o0();
        }
        if (j3 > 0 && (qQGAudioCtrl = this.f72712n) != null) {
            this.f72716r = true;
            if (i3 != 1) {
                if (i3 == 2) {
                    i18 = 1;
                } else if (i3 == 3) {
                    i16 = 8;
                } else {
                    i18 = 0;
                }
                i17 = qQGAudioCtrl.nativeUpdateRoomInfo(i3, j3, i18, true, true, true);
            }
            i18 = i16;
            i17 = qQGAudioCtrl.nativeUpdateRoomInfo(i3, j3, i18, true, true, true);
        } else {
            i17 = -999;
        }
        if (i17 != 0) {
            return false;
        }
        return true;
    }

    public ArrayList<Long> S1(long j3, boolean z16, long j16) {
        ArrayList<Long> arrayList;
        synchronized (this.C) {
            int size = this.C.size();
            arrayList = new ArrayList<>();
            long currentTimeMillis = System.currentTimeMillis();
            for (int i3 = 0; i3 < size; i3++) {
                com.tencent.av.e eVar = this.C.get(i3);
                if (eVar != null) {
                    long j17 = eVar.f73701a;
                    if (j17 == j3) {
                        if (!eVar.f73717q) {
                            eVar.f73719s = z16;
                            eVar.f73720t = currentTimeMillis;
                            eVar.f73721u = j16;
                        } else if (eVar.f73719s) {
                            eVar.f73719s = false;
                        }
                    }
                    if (eVar.f73719s) {
                        arrayList.add(Long.valueOf(j17));
                    }
                }
            }
        }
        return arrayList;
    }

    public int T() {
        return this.f72713o;
    }

    public void T0(long j3, long j16) {
        if (AVControllerCommon.D().x(n.e().f().f73091w) == j16) {
            n.e().f().f73105z1 = true;
        }
        QLog.d(J, 1, "onRecvAudioReady uin = " + j3 + ",roomid = " + j16);
        VideoAppInterface.N().k0(new Object[]{37});
    }

    public long U() {
        if (n.e().f().f73035i != 3 && n.e().f().f73035i != 4) {
            return 0L;
        }
        return this.f72712n.getEnterRoomTime();
    }

    public long V() {
        return W(n.e().f());
    }

    public long W(SessionInfo sessionInfo) {
        int i3;
        if (sessionInfo == null) {
            return 0L;
        }
        if (this.f72712n != null && (((i3 = sessionInfo.f73035i) == 3 || i3 == 4) && (sessionInfo.b() == 0 || sessionInfo.a() == 0))) {
            qav_gvideo_sdk_transfer$RespInfo R = R(sessionInfo.S0, sessionInfo.f73063p, sessionInfo.P0);
            if (R.uint32_result.get() == 0) {
                sessionInfo.d(R.gAudioInfo.uint64_roomId.get());
                sessionInfo.c(R.gAudioInfo.uint32_roomCreateTime.get());
            }
        }
        return sessionInfo.b();
    }

    int X(long j3) {
        synchronized (this.C) {
            for (int i3 = 0; i3 < this.C.size(); i3++) {
                com.tencent.av.e eVar = this.C.get(i3);
                if (eVar != null && eVar.f73701a == j3) {
                    return i3;
                }
            }
            return -1;
        }
    }

    public qav_gvideo_sdk_transfer$RespInfo X0(int i3, byte[] bArr) {
        qav_gvideo_sdk_transfer$RespInfo qav_gvideo_sdk_transfer_respinfo = new qav_gvideo_sdk_transfer$RespInfo();
        QQGAudioCtrl qQGAudioCtrl = this.f72712n;
        int i16 = -101;
        if (qQGAudioCtrl != null) {
            try {
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                qav_gvideo_sdk_transfer_respinfo.mergeFrom(qQGAudioCtrl.postData(i3, bArr));
                return qav_gvideo_sdk_transfer_respinfo;
            } catch (Throwable th6) {
                th = th6;
                i16 = -102;
                if (QLog.isDevelopLevel()) {
                    QLog.w(J, 1, "postData exception , event[" + i3 + "]", th);
                }
                qav_gvideo_sdk_transfer_respinfo.uint32_result.set(i16);
                return qav_gvideo_sdk_transfer_respinfo;
            }
        }
        qav_gvideo_sdk_transfer_respinfo.uint32_result.set(i16);
        return qav_gvideo_sdk_transfer_respinfo;
    }

    @TargetApi(21)
    public void Y0(long j3, long j16, boolean z16, int i3) {
        if (QLog.isColorLevel()) {
            QLog.w(J, 1, "quitDoubleVideoMeeting, relationId[" + j16 + "], seq[" + j3 + "]");
        }
        ScreenRecordHelper screenRecordHelper = AVControllerCommon.D().H;
        if (screenRecordHelper != null) {
            screenRecordHelper.y(4);
        }
        String b16 = n.b(100, String.valueOf(j16), new int[0]);
        SessionInfo i16 = n.e().i(b16);
        if (i16 == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("tencent.av.v2q.MultiVideo");
        intent.putExtra("type", 402);
        intent.putExtra("relationType", 3);
        intent.putExtra("relationId", j16);
        intent.putExtra("friendUin", j16);
        intent.putExtra("MultiAVType", i16.f73063p);
        intent.putExtra("from", "VideoController6");
        at.f(intent, j3);
        intent.setPackage(VideoAppInterface.N().getApp().getPackageName());
        AVControllerCommon.D().e0(intent);
        if (i3 != -255 && i16.f73043k != 15) {
            AVControllerCommon.D().h0(b16, 0, i3, true, "" + j16, "" + j16, false);
        }
        if (i16.N) {
            VideoAppInterface.N().k0(new Object[]{106, Long.valueOf(j3)});
        }
        if (z16) {
            a1(3, j16, 84);
            i16.z0("quitDoubleVideoMeeting", false);
            i16.y0("quitDoubleVideoMeeting", false);
        } else {
            i16.n0("quitDoubleVideoMeeting", 15);
            AVControllerCommon.D().V(j3, R.raw.f169423v, 1, this.f72722x);
            this.f72721w = new Runnable() { // from class: com.tencent.av.MAVController.19
                @Override // java.lang.Runnable
                public void run() {
                    if (QLog.isColorLevel()) {
                        QLog.i(MAVController.J, 2, "quitDoubleVideoMeeting, time out task run.");
                    }
                    AVControllerCommon.c cVar = MAVController.this.f72722x;
                    if (cVar != null) {
                        cVar.onCompletion(null);
                    }
                }
            };
            VideoAppInterface.N().M().postDelayed(this.f72721w, 2000L);
        }
        ScreenShareCtrl H = AVControllerCommon.D().H();
        if (H != null) {
            H.o(j16);
        }
    }

    public ArrayList<com.tencent.av.e> Z() {
        if (com.tencent.av.utils.e.j() && ((IQQDebugApi) QRoute.api(IQQDebugApi.class)).getSGAudioVirtualList() != null) {
            ArrayList<com.tencent.av.e> arrayList = new ArrayList<>();
            arrayList.addAll(this.A);
            arrayList.addAll(((IQQDebugApi) QRoute.api(IQQDebugApi.class)).getSGAudioVirtualList());
            return arrayList;
        }
        return this.A;
    }

    public void Z0() {
        if (this.f72699a) {
            long j3 = this.f72700b;
            a1(this.f72701c, j3, 50);
            VideoAppInterface.N().k0(new Object[]{66, Long.valueOf(j3)});
        }
    }

    @Override // com.tencent.av.gaudio.b
    public long a(int i3, int i16, long j3) {
        qav_gvideo_sdk_transfer$RespInfo R = R(i3, i16, j3);
        if (QLog.isColorLevel()) {
            QLog.w(J, 1, "getGAudioRoomId, result[" + R.uint32_result.get() + "], uint64_roomId[" + R.gAudioInfo.uint64_roomId.get() + "]");
        }
        return R.gAudioInfo.uint64_roomId.get();
    }

    public ArrayList<Long> a0() {
        ArrayList<Long> arrayList = new ArrayList<>();
        if (n.e().f() == null) {
            return arrayList;
        }
        arrayList.addAll(n.e().f().f73092w0);
        Iterator<com.tencent.av.e> it = O().iterator();
        while (it.hasNext()) {
            com.tencent.av.e next = it.next();
            if (next.f73715o == 0 && arrayList.contains(Long.valueOf(next.f73701a))) {
                arrayList.remove(Long.valueOf(next.f73701a));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x04d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a1(int i3, long j3, int i16) {
        int i17;
        SessionInfo sessionInfo;
        String str;
        int i18;
        SessionInfo sessionInfo2;
        long j16;
        boolean z16;
        int size;
        long j17;
        MAVController mAVController = this;
        synchronized (this) {
            long d16 = com.tencent.av.utils.e.d();
            VideoAppInterface N = VideoAppInterface.N();
            String b16 = n.b(i3, String.valueOf(j3), new int[0]);
            if (i3 == 3) {
                b16 = n.b(100, String.valueOf(j3), new int[0]);
            }
            String str2 = b16;
            SessionInfo i19 = n.e().i(str2);
            if (QLog.isColorLevel()) {
                String str3 = J;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("quitGAudioChat, groupId[");
                sb5.append(j3);
                sb5.append("], relationType[");
                sb5.append(i3);
                sb5.append("], reason[");
                sb5.append(i16);
                sb5.append("], sessionId[");
                sb5.append(str2);
                sb5.append("], seq[");
                sb5.append(d16);
                sb5.append("], app[");
                sb5.append(N != null);
                sb5.append("], \nsessionInfo[");
                sb5.append(i19);
                sb5.append("]");
                QLog.w(str3, 1, sb5.toString());
            }
            com.tencent.av.screenshare.c.g(str2, "quitGAudioChat");
            if (N == null) {
                return;
            }
            if (i19 == null) {
                return;
            }
            ScreenRecordHelper screenRecordHelper = AVControllerCommon.D().H;
            if (screenRecordHelper != null && screenRecordHelper.m()) {
                screenRecordHelper.y(4);
            }
            if (QLog.isColorLevel()) {
                QLog.i(J, 2, "quitGAudioChat, check screen share and stop.");
            }
            ChatRoomMng D = N.D();
            if (D != null) {
                D.s(i19);
            }
            N.M().removeCallbacks(mAVController.f72724z);
            mAVController.f72724z = null;
            if (AVControllerCommon.D().C != null) {
                N.M().removeCallbacks(AVControllerCommon.D().C);
                AVControllerCommon.D().C = null;
            }
            if (mAVController.f72712n == null) {
                return;
            }
            N.k0(new Object[]{203, String.valueOf(j3), Boolean.valueOf(AVControllerCommon.D().f72570a), Long.valueOf(d16)});
            if (n.e().f().f73061o1.size() <= 0 || !n.e().f().f73041j1) {
                i17 = 2;
                sessionInfo = i19;
                str = str2;
                i18 = 3;
            } else {
                i17 = 2;
                sessionInfo = i19;
                str = str2;
                i18 = 3;
                w0(2, 0, 0, 0L);
            }
            if (i3 == i17) {
                sessionInfo2 = sessionInfo;
                if (!sessionInfo2.f73041j1 && sessionInfo2.f73061o1 != null) {
                    Intent intent = new Intent();
                    intent.setAction("tencent.av.v2q.MultiVideo");
                    intent.putExtra("type", 411);
                    intent.putExtra("phoneList", n.e().f().f73061o1);
                    intent.putExtra("relationType", n.e().f().S0);
                    intent.putExtra("relationId", n.e().f().P0);
                    intent.putExtra("MultiAVType", n.e().f().f73063p);
                    intent.putExtra("from", "VideoController2");
                    intent.setPackage(N.getApp().getPackageName());
                    N.getApp().sendBroadcast(intent);
                }
            } else {
                sessionInfo2 = sessionInfo;
            }
            if (i3 == i17) {
                if (TraeConstants.DEVICE_EARPHONE.equals(sessionInfo2.F0)) {
                    DataReport.T(null, "CliOper", "", "", "0X8004CE5", "0X8004CE5", 0, 0, "", "", "", "");
                }
                if (s0()) {
                    DataReport.T(null, "CliOper", "", "", "0X8004CE8", "0X8004CE8", 0, 0, "", "", "", "");
                }
                if (sessionInfo2.N) {
                    DataReport.T(null, "CliOper", "", "", "0X8004CEB", "0X8004CEB", 0, 0, "", "", "", "");
                    if (!sessionInfo2.R) {
                        DataReport.T(null, "CliOper", "", "", "0X8004CEF ", "0X8004CEF ", 0, 0, "", "", "", "");
                    }
                }
            } else if (i3 == 1) {
                if (TraeConstants.DEVICE_EARPHONE.equals(sessionInfo2.F0)) {
                    if (sessionInfo2.f73063p == 10) {
                        DataReport.T(null, "CliOper", "", "", "0X8005942", "0X8005942", 0, 0, "", "", "", "");
                    } else {
                        DataReport.T(null, "CliOper", "", "", "0X8004F54", "0X8004F54", 0, 0, "", "", "", "");
                    }
                }
                if (s0()) {
                    if (sessionInfo2.f73063p == 10) {
                        DataReport.T(null, "CliOper", "", "", "0X8005943", "0X8005943", 0, 0, "", "", "", "");
                    } else {
                        DataReport.T(null, "CliOper", "", "", "0X8004F55", "0X8004F55", 0, 0, "", "", "", "");
                    }
                }
                if (sessionInfo2.N) {
                    if (sessionInfo2.f73063p == 10) {
                        DataReport.T(null, "CliOper", "", "", "0X8005944", "0X8005944", 0, 0, "", "", "", "");
                    } else {
                        DataReport.T(null, "CliOper", "", "", "0X8004F56", "0X8004F56", 0, 0, "", "", "", "");
                    }
                    if (!sessionInfo2.R) {
                        if (sessionInfo2.f73063p == 10) {
                            DataReport.T(null, "CliOper", "", "", "0X8005945 ", "0X8005945 ", 0, 0, "", "", "", "");
                        } else {
                            DataReport.T(null, "CliOper", "", "", "0X8004F57 ", "0X8004F57 ", 0, 0, "", "", "", "");
                        }
                    }
                }
            }
            if (AVControllerCommon.D().f72572c && AVControllerCommon.D().y() > 0) {
                DataReport.T(null, "CliOper", "", "", "0X8008B2F ", "0X8008B2F ", 0, 0, "", "", ba.formatTime(AVControllerCommon.D().y()), "");
            }
            final int i26 = i16 == 7 ? i17 : (i16 == 69 || i16 == 70 || i16 == 71 || i16 == 82 || i16 == 83) ? 0 : i18;
            if (!VcControllerImpl.sIsSpecialDevice && i16 != 69 && i16 != 70 && i16 != 71) {
                mAVController.f72712n.quitRoom(i26);
                int i27 = i26;
                long y16 = (mAVController.f72699a || sessionInfo2.f73043k != 9 || sessionInfo2.f73069q1) ? AVControllerCommon.D().y() : 0L;
                mAVController.p1("quitGAudioChat", false);
                mAVController.r1("quitGAudioChat", 1);
                synchronized (mAVController.C) {
                    if (mAVController.C.size() != 0 || mAVController.f72699a) {
                        j16 = y16;
                    } else {
                        j16 = y16;
                        if (mAVController.f72700b == 0) {
                            z16 = true;
                            size = mAVController.C.size();
                            mAVController.C.clear();
                        }
                    }
                    z16 = false;
                    size = mAVController.C.size();
                    mAVController.C.clear();
                }
                long j18 = j16;
                SessionInfo sessionInfo3 = sessionInfo2;
                O1("quitGAudioChat", false, 0, 0L);
                sessionInfo3.U0 = false;
                mAVController.f72712n.mIsSwitchGroup = false;
                String currentAccountUin = N.getCurrentAccountUin();
                long g16 = currentAccountUin != null ? com.tencent.av.utils.i.g(currentAccountUin) : 0L;
                if (TextUtils.isEmpty(currentAccountUin)) {
                    j17 = d16;
                } else {
                    Intent intent2 = new Intent();
                    intent2.setAction("tencent.av.v2q.MultiVideo");
                    intent2.putExtra("type", 23);
                    intent2.putExtra("friendUin", g16);
                    intent2.putExtra("relationId", j3);
                    intent2.putExtra("relationType", i3);
                    intent2.putExtra("MultiAVType", sessionInfo3.f73063p);
                    intent2.putExtra("time", j18);
                    intent2.putExtra("isStart", mAVController.f72723y);
                    intent2.putExtra("quitReson", i16);
                    intent2.putExtra("from", "VideoController3");
                    if (size > 1) {
                        intent2.putExtra("roomUserNum", size - 1);
                    } else {
                        intent2.putExtra("roomUserNum", 0);
                    }
                    intent2.setPackage(N.getApp().getPackageName());
                    j17 = d16;
                    at.f(intent2, j17);
                    N.getApp().sendBroadcast(intent2);
                    if (QLog.isColorLevel()) {
                        QLog.w(J, 1, "quitGAudioChat, send broadcast of quitRoom chatting, seq[" + j17 + "]");
                    }
                }
                sessionInfo3.Y("quitGAudioChat", null);
                sessionInfo3.H0 = null;
                AVControllerCommon.D().h();
                TraeHelper.I().x();
                if (sessionInfo3.f73045k1.size() > 0) {
                    N.k0(new Object[]{104, sessionInfo3.f73045k1});
                }
                String str4 = sessionInfo3.Y0;
                int i28 = sessionInfo3.S0;
                if (i28 == 1 || i28 == 2) {
                    if (sessionInfo3.N) {
                        N.k0(new Object[]{106, Long.valueOf(j17)});
                    }
                    sessionInfo3.c0(j17, false);
                }
                if (!z16) {
                    AVControllerCommon.D().g0("quitGAudioChat_" + i16, str, ba.avRelationType2UinType(i3), currentAccountUin, String.valueOf(j3), 7, str4, false, false);
                }
                sessionInfo3.i(j17);
                mAVController.f72704f.b();
                cw.e.a(j17, N);
                sessionInfo3.f73067q = -1;
                sessionInfo3.U = true;
                String str5 = str;
                boolean n3 = n.e().n(j17, str5);
                QAVNotification l3 = QAVNotification.l(N);
                if (l3 != null && l3.n()) {
                    l3.f(str5);
                    if (n3) {
                        AVControllerCommon.D().v0();
                    }
                }
                PopupDialog.g0();
                AVControllerCommon.D().Y();
                AVControllerCommon.D().t(i27);
                return;
            }
            mAVController.f72720v = MiniAppGeneralServlet.ERR_MSF_EXCEPTION;
            if (AVControllerCommon.D().f72576g != null) {
                AVControllerCommon.D().f72576g.post(new Runnable() { // from class: com.tencent.av.MAVController.6
                    @Override // java.lang.Runnable
                    public void run() {
                        QLog.d(MAVController.J, 1, "GAudioCtrl.quitRoom start.");
                        MAVController mAVController2 = MAVController.this;
                        mAVController2.f72720v = mAVController2.f72712n.quitRoom(i26);
                        QLog.d(MAVController.J, 1, "GAudioCtrl.quitRoom end. mQuitResult = " + MAVController.this.f72720v);
                        synchronized (MAVController.this.f72719u) {
                            MAVController.this.f72719u.notify();
                        }
                    }
                });
            }
            synchronized (mAVController.f72719u) {
                try {
                    try {
                        mAVController.f72719u.wait(2000);
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                } catch (Throwable th5) {
                    th = th5;
                    while (true) {
                        try {
                            break;
                        } catch (Throwable th6) {
                            th = th6;
                        }
                    }
                    throw th;
                }
            }
            mAVController = this;
            if (mAVController.f72720v == -1000001) {
                i26 = 261;
            }
            QLog.d(J, 1, "GAudioCtrl.quitRoom end. continue. mQuitResult = " + mAVController.f72720v);
            int i272 = i26;
            if (mAVController.f72699a) {
            }
            mAVController.p1("quitGAudioChat", false);
            mAVController.r1("quitGAudioChat", 1);
            synchronized (mAVController.C) {
            }
        }
    }

    public int b0() {
        int i3;
        synchronized (this.C) {
            i3 = 0;
            for (int i16 = 0; i16 < this.C.size(); i16++) {
                com.tencent.av.e eVar = this.C.get(i16);
                if (eVar != null && eVar.f73701a != com.tencent.av.utils.i.g(VideoAppInterface.N().getCurrentAccountUin())) {
                    if (eVar.f73705e) {
                        i3++;
                    }
                    if (eVar.f73708h) {
                        i3++;
                    }
                    if (eVar.f73707g) {
                        i3++;
                    }
                }
            }
        }
        return i3;
    }

    public boolean b1() {
        boolean z16;
        synchronized (this.C) {
            int size = this.C.size();
            long currentTimeMillis = System.currentTimeMillis();
            z16 = false;
            for (int i3 = 0; i3 < size; i3++) {
                com.tencent.av.e eVar = this.C.get(i3);
                if (eVar != null && eVar.f73719s) {
                    long j3 = eVar.f73721u;
                    if (j3 < 2000 || j3 >= this.f72708j) {
                        j3 = this.f72708j;
                        if (j3 < 2000) {
                            j3 = 2000;
                        }
                    }
                    if (currentTimeMillis - eVar.f73720t > j3) {
                        eVar.f73719s = false;
                        eVar.f73720t = currentTimeMillis;
                        if (QLog.isColorLevel()) {
                            QLog.d(J, 2, "refreshUserNoiseState : has valid state uin = " + eVar.f73701a + ",isSuspectNoisy = " + eVar.f73719s);
                        }
                        z16 = true;
                    }
                }
            }
        }
        return z16;
    }

    public int c0(SessionInfo sessionInfo, String str) {
        QQGAudioCtrl qQGAudioCtrl = this.f72712n;
        if (qQGAudioCtrl != null) {
            return qQGAudioCtrl.getRoomUserSdkVersion(sessionInfo, str);
        }
        return -1;
    }

    void c1(long j3, String str, String str2, int i3, String str3, String str4) {
        if (QLog.isColorLevel()) {
            QLog.w(J, 1, "reject3rdMultiCall[" + str + "], sessionId[" + str2 + "], relationType[" + i3 + "], senderUin[" + str3 + "], extraUin[" + str4 + "], seq[" + j3 + "]");
        }
        AVControllerCommon.D().g0(str, str2, ba.avRelationType2UinType(i3), VideoAppInterface.N().getCurrentAccountUin(), str4, 5, str3, false, false);
        n.e().n(j3, str2);
    }

    @Override // com.tencent.av.gaudio.b
    public boolean d(long j3, int i3) {
        com.tencent.av.app.o oVar = this.f72704f;
        if (oVar == null) {
            return com.tencent.av.app.o.e();
        }
        return oVar.a(j3, i3);
    }

    public int d0(SessionInfo sessionInfo, String str) {
        QQGAudioCtrl qQGAudioCtrl = this.f72712n;
        if (qQGAudioCtrl != null) {
            return qQGAudioCtrl.getRoomUserTerminalType(sessionInfo, str);
        }
        return -1;
    }

    public void d1(long j3, boolean z16) {
        boolean z17;
        boolean z18 = false;
        int i3 = 0;
        while (true) {
            if (i3 < this.A.size()) {
                com.tencent.av.e eVar = this.A.get(i3);
                if (eVar.f73701a == j3) {
                    this.A.remove(i3);
                    if (QLog.isColorLevel()) {
                        QLog.d(J, 2, "InviteMemberList removeCertainInviteNumber remove: member uin:=" + eVar.f73701a);
                    }
                    z17 = true;
                } else {
                    i3++;
                }
            } else {
                z17 = false;
                break;
            }
        }
        if (z17 && z16) {
            VideoAppInterface.N().k0(new Object[]{Integer.valueOf(TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_HOOK), 1L, 1L, this.A});
        }
        String str = J;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("InviteMemberList removeCertainInviteNumber uin:");
        sb5.append(j3);
        sb5.append(";result:");
        if (z17 && z16) {
            z18 = true;
        }
        sb5.append(z18);
        QLog.d(str, 1, sb5.toString());
    }

    public boolean e0() {
        if (com.tencent.av.utils.e.k()) {
            QLog.w(J, 1, "getSelectMemberActivityIsResume, mSelectMemberActivityIsResume[" + this.F + "]");
        }
        if (this.F > 0) {
            return true;
        }
        return false;
    }

    @Override // au.f
    public synchronized void f(int i3, com.tencent.av.ui.funchat.record.i iVar) {
        QLog.i(J, 1, "Record setAudioFrameCallback, type=" + i3 + ", callback=" + iVar);
        if (i3 >= 2) {
            return;
        }
        if (this.f72711m == null) {
            this.f72711m = new com.tencent.av.ui.funchat.record.i[2];
        }
        this.f72711m[i3] = iVar;
    }

    public String f0() {
        QQGAudioCtrl qQGAudioCtrl = this.f72712n;
        if (qQGAudioCtrl != null) {
            return qQGAudioCtrl.getAVGQuality();
        }
        return null;
    }

    public void f1(long j3, ArrayList<com.tencent.av.gaudio.c> arrayList, int i3, boolean z16) {
        if (arrayList == n.e().f().f73053m1) {
            synchronized (n.e().f().f73053m1) {
                int i16 = 0;
                while (true) {
                    if (i16 >= arrayList.size()) {
                        break;
                    }
                    if (arrayList.get(i16).f73827a == j3) {
                        if (z16) {
                            e1(arrayList, i16);
                            n.e().f().S();
                            break;
                        } else if (i3 == arrayList.get(i16).f73828b) {
                            e1(arrayList, i16);
                            n.e().f().S();
                            break;
                        }
                    }
                    i16++;
                }
            }
        }
    }

    @Override // com.tencent.av.gaudio.b
    public void g(final long j3, final long j16, final ArrayList<com.tencent.av.gaudio.a> arrayList) {
        VideoAppInterface.N().M().post(new Runnable() { // from class: com.tencent.av.MAVController.14
            @Override // java.lang.Runnable
            public void run() {
                if (MAVController.this.A.isEmpty()) {
                    QLog.d(MAVController.J, 1, "InviteMemberList dealInviteMemberRsp empty result");
                }
                HashSet hashSet = new HashSet();
                Iterator it = MAVController.this.A.iterator();
                while (it.hasNext()) {
                    hashSet.add(Long.valueOf(((com.tencent.av.e) it.next()).f73701a));
                }
                Iterator it5 = arrayList.iterator();
                boolean z16 = false;
                while (it5.hasNext()) {
                    com.tencent.av.gaudio.a aVar = (com.tencent.av.gaudio.a) it5.next();
                    if (!hashSet.contains(Long.valueOf(aVar.f73825a))) {
                        com.tencent.av.e eVar = new com.tencent.av.e();
                        eVar.f73715o = 0;
                        eVar.f73701a = aVar.f73825a;
                        eVar.f73724x = false;
                        eVar.f73725y = aVar.f73826b;
                        MAVController.this.A.add(eVar);
                        z16 = true;
                    }
                }
                if (z16) {
                    VideoAppInterface.N().k0(new Object[]{Integer.valueOf(TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_HOOK), Long.valueOf(j3), Long.valueOf(j16), MAVController.this.A});
                }
                QLog.d(MAVController.J, 1, "InviteMemberList dealInviteMemberRsp memberLists size=" + arrayList.size() + ";change:" + z16);
            }
        });
    }

    public ArrayList<com.tencent.av.e> g0() {
        if (com.tencent.av.utils.e.j() && ((IQQDebugApi) QRoute.api(IQQDebugApi.class)).getSGAudioVirtualList() != null) {
            ArrayList<com.tencent.av.e> arrayList = new ArrayList<>();
            arrayList.addAll(this.D);
            arrayList.addAll(((IQQDebugApi) QRoute.api(IQQDebugApi.class)).getSGAudioVirtualList());
            return arrayList;
        }
        return this.D;
    }

    public void g1(long j3, ArrayList<com.tencent.av.gaudio.c> arrayList, ArrayList<com.tencent.av.gaudio.c> arrayList2, int i3, boolean z16) {
        if (arrayList != null && arrayList.size() != 0) {
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                if (arrayList.get(i16).f73827a == j3) {
                    if (z16) {
                        e1(arrayList, i16);
                        f1(j3, arrayList2, i3, z16);
                        return;
                    } else if (i3 == arrayList.get(i16).f73828b) {
                        e1(arrayList, i16);
                        f1(j3, arrayList2, i3, z16);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.tencent.av.gaudio.b
    public synchronized void h(byte[] bArr, int i3, int i16, int i17, int i18) {
        com.tencent.av.ui.funchat.record.i[] iVarArr;
        com.tencent.av.ui.funchat.record.i iVar;
        com.tencent.av.ui.funchat.record.i iVar2;
        if (QLog.isDevelopLevel()) {
            QLog.d(J, 2, "onAudioProcess=" + bArr.length + ", type=" + i18 + ", bits=" + i17);
        }
        if (i18 == 100) {
            com.tencent.av.ui.funchat.record.i[] iVarArr2 = this.f72711m;
            if (iVarArr2 != null && (iVar2 = iVarArr2[0]) != null) {
                iVar2.onReceiveAudioFrame(bArr, i18, bArr.length);
            }
        } else if ((i18 == 3 || i18 == 0 || i18 == 1 || i18 == 2 || i18 == 8) && (iVarArr = this.f72711m) != null && (iVar = iVarArr[1]) != null) {
            iVar.onReceiveAudioFrame(bArr, i18, bArr.length);
        }
    }

    public int h0() {
        QQGAudioCtrl qQGAudioCtrl;
        if (this.f72705g <= 0 && (qQGAudioCtrl = this.f72712n) != null) {
            this.f72705g = qQGAudioCtrl.getVideoAbilityLevel();
        }
        return this.f72705g;
    }

    public boolean h1(final boolean z16) {
        String i06 = i0(n.e().f().f73057n1);
        if (QLog.isColorLevel()) {
            QLog.d(J, 2, "requestGVideo-->info=" + i06);
        }
        if (this.f72712n != null) {
            if (!AVUtil.l()) {
                AVControllerCommon.D().p0();
            }
            int i3 = 0;
            while (true) {
                if (i3 >= n.e().f().f73057n1.size()) {
                    break;
                }
                if (n.e().f().f73057n1.get(i3).f73827a == Long.valueOf(VideoAppInterface.N().getCurrentAccountUin()).longValue()) {
                    n.e().f().f73057n1.remove(i3);
                    break;
                }
                i3++;
            }
            if (16 < n.e().f().f73057n1.size()) {
                ArrayList<com.tencent.av.gaudio.c> arrayList = new ArrayList<>(16);
                for (int i16 = 0; i16 < 16; i16++) {
                    arrayList.add(n.e().f().f73057n1.get(i16));
                }
                n.e().f().f73057n1 = arrayList;
            }
            if (n.e().f().f73057n1.size() > 0) {
                final ArrayList arrayList2 = (ArrayList) n.e().f().f73057n1.clone();
                if (AVControllerCommon.D().f72576g != null) {
                    AVControllerCommon.D().f72576g.post(new Runnable() { // from class: com.tencent.av.MAVController.2
                        @Override // java.lang.Runnable
                        public void run() {
                            String i07 = MAVController.this.i0(arrayList2);
                            if (MAVController.this.f72712n.startVideoRecv(arrayList2, z16) == 0) {
                                QLog.e(MAVController.J, 1, "requestGVideo failed. viewInfos = " + i07);
                            }
                        }
                    });
                    return true;
                }
                return true;
            }
            return true;
        }
        n.e().f().f73057n1.clear();
        if (QLog.isColorLevel()) {
            QLog.e(J, 2, "requestGVideo-->Request video failed,mGaudioCtrl is null,ViewInfo=" + i06);
        }
        return false;
    }

    @Override // com.tencent.av.gaudio.b
    public void i(long j3, long j16, String str) {
        QLog.e(J, 1, "onGAudioInviteRespFail, groupId[" + j3 + "], mGAudioGroupId[" + this.f72700b + "], err[" + j16 + "], msg[" + str + "]");
    }

    public String i0(ArrayList<com.tencent.av.gaudio.c> arrayList) {
        StringBuilder sb5;
        if (arrayList == null) {
            sb5 = new StringBuilder("VideoViewInfo[0]");
        } else {
            StringBuilder sb6 = new StringBuilder("VideoViewInfo[" + arrayList.size() + "]\n");
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                sb6.append(i3);
                sb6.append(", ");
                sb6.append(arrayList.get(i3));
                sb6.append("\n");
            }
            sb5 = sb6;
        }
        return sb5.toString();
    }

    public void i1() {
        QLog.d(J, 1, "requestStartTimerOfMemberLists");
        VideoAppInterface.N().M().removeCallbacks(this.B);
        VideoAppInterface.N().M().postDelayed(this.B, 3000L);
    }

    @Override // com.tencent.av.gaudio.b
    public void j() {
        if (QLog.isColorLevel()) {
            QLog.i(J, 2, "onMavSpeakingWhenCloseMic");
        }
        if (ax.e()) {
            VideoAppInterface.N().k0(new Object[]{529});
        }
    }

    public void j0() {
        if (this.f72712n != null) {
            if (n.e().f().S0 == 2) {
                DataReport.T(null, "CliOper", "", "", "0X80041B1", "0X80041B1", 0, 0, "", "", "", "");
            } else if (n.e().f().S0 == 1 && n.e().f().f73063p == 10) {
                DataReport.T(null, "CliOper", "", "", "0X8005937", "0X8005937", 0, 0, "", "", "", "");
            }
            int nativeStopVideoSend = this.f72712n.nativeStopVideoSend();
            if (QLog.isColorLevel()) {
                QLog.w(J, 1, "goOffStage, ret[" + nativeStopVideoSend + "]");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(J, 2, "goOffStage-->mGAudioCtrl is null");
        }
    }

    public void j1() {
        QLog.d(J, 1, "requestStopTimerOfMemberLists");
        VideoAppInterface.N().M().removeCallbacks(this.B);
    }

    public boolean k0() {
        if (this.f72712n != null) {
            if (n.e().f().S0 == 2) {
                DataReport.T(null, "CliOper", "", "", "0X80041B0", "0X80041B0", 0, 0, "", "", "", "");
            } else if (n.e().f().S0 == 1 && n.e().f().f73063p == 10) {
                DataReport.T(null, "CliOper", "", "", "0X8005936", "0X8005936", 0, 0, "", "", "", "");
            }
            int startVideoSend = this.f72712n.startVideoSend();
            if (QLog.isColorLevel()) {
                QLog.w(J, 1, "goOnstage, ret[" + startVideoSend + "]");
            }
            if (startVideoSend == 0) {
                return false;
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.e(J, 2, "goOnstage-->mGAudioCtrl is null");
        }
        return false;
    }

    public void k1(final long j3, final long j16, final ArrayList<com.tencent.av.gaudio.a> arrayList) {
        VideoAppInterface.N().M().post(new Runnable() { // from class: com.tencent.av.MAVController.15
            @Override // java.lang.Runnable
            public void run() {
                MAVController.this.A.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.tencent.av.gaudio.a aVar = (com.tencent.av.gaudio.a) it.next();
                    com.tencent.av.e eVar = new com.tencent.av.e();
                    eVar.f73715o = 0;
                    eVar.f73701a = aVar.f73825a;
                    eVar.f73724x = false;
                    eVar.f73725y = aVar.f73826b;
                    MAVController.this.A.add(eVar);
                    if (QLog.isColorLevel()) {
                        QLog.d(MAVController.J, 2, "InviteMemberList saveInviteMembers add: member uin:=" + eVar.f73701a);
                    }
                }
                VideoAppInterface.N().k0(new Object[]{Integer.valueOf(TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_HOOK), Long.valueOf(j3), Long.valueOf(j16), MAVController.this.A});
                QLog.d(MAVController.J, 1, "InviteMemberList saveInviteMembers + mIviteMemberLists size=" + MAVController.this.A.size());
            }
        });
    }

    public void l0(long j3, int i3, long j16) {
        m0(j3, i3, j16, -1, false);
    }

    public void l1(long j3, ArrayList<String> arrayList) {
        int size = arrayList.size();
        long[] jArr = new long[size];
        for (int i3 = 0; i3 < size; i3++) {
            String str = arrayList.get(i3);
            if (str != null) {
                jArr[i3] = Long.valueOf(str).longValue();
            }
        }
        q0(jArr, false, null);
    }

    public void m0(long j3, int i3, long j16, int i16, boolean z16) {
        String b16;
        int i17;
        int i18;
        int i19 = i16;
        if (i3 == 3) {
            b16 = n.b(100, String.valueOf(j16), new int[0]);
        } else {
            b16 = n.b(i3, String.valueOf(j16), new int[0]);
        }
        SessionInfo i26 = n.e().i(b16);
        if (this.f72712n != null) {
            if (i3 == 1) {
                i18 = 10;
            } else if (i3 == 2) {
                i18 = 1;
            } else if (i3 == 3) {
                i18 = 8;
            } else {
                QLog.e(J, 1, "ignoreGAudioChat, Can't Support Ignore" + i3);
                i18 = 0;
            }
            this.f72712n.ignore(i3, j16, i18);
        }
        QLog.w(J + "|VideoNodeManager", 1, "ignoreGAudioChat, groupId[" + j16 + "], iFlag[" + i19 + "], sessionId[" + b16 + "], sessionInfo[" + i26 + "]");
        if (i26 == null) {
            return;
        }
        VideoAppInterface.N().G = false;
        i26.f73077s1 = true;
        if (i26.f73043k == 7) {
            i26.n0("ignoreGAudioChat", 0);
            if (i19 == -1) {
                i19 = 3;
            }
        } else if (i19 == -1) {
            i19 = 4;
        }
        AVControllerCommon.D().h();
        int avRelationType2UinType = ba.avRelationType2UinType(i3);
        String currentAccountUin = VideoAppInterface.N().getCurrentAccountUin();
        if (i19 == 10) {
            AVControllerCommon.D().g0("ignoreGAudioChat_1", i26.f73030h, ba.avRelationType2UinType(i3), VideoAppInterface.N().getCurrentAccountUin(), String.valueOf(i26.P0), 5, i26.Y0, false, false);
            i17 = 1;
        } else if (i3 == 3) {
            i17 = 1;
            AVControllerCommon.D().g0("ignoreGAudioChat_2", b16, avRelationType2UinType, i26.f73091w, String.valueOf(j16), i19, i26.Y0, z16, false);
        } else {
            i17 = 1;
            AVControllerCommon.D().g0("ignoreGAudioChat_3", b16, avRelationType2UinType, currentAccountUin, String.valueOf(j16), i19, i26.Y0, z16, false);
        }
        boolean n3 = n.e().n(j3, b16);
        SessionInfo f16 = n.e().f();
        if (TextUtils.isEmpty(f16.f73030h) || f16.f73043k == 0) {
            if (TraeHelper.I() != null) {
                TraeHelper.I().m0();
                TraeHelper.I().x();
            }
            AVControllerCommon.D().t(i19);
        }
        GInviteTimeOutHelper.b().a();
        QLog.d(J, i17, "ignoreGAudioChat hasOtherSession=" + n3 + " sessionId=" + b16 + " ----- " + n.e().f());
        QAVNotification l3 = QAVNotification.l(VideoAppInterface.N());
        if (l3 == null || !l3.n()) {
            return;
        }
        l3.f(b16);
        if (n3) {
            AVControllerCommon.D().v0();
        }
    }

    public void m1(boolean z16, String str, String str2, int i3, String str3) {
        if (TextUtils.isEmpty(str3)) {
            QLog.e(J, 1, "sendShareScreenExitBroadcast empty msgStr");
            return;
        }
        QLog.i(J, 2, "sendShareScreenExitBroadcast isDoubleMeeting: " + z16 + " peerUin: " + str + " relationId: " + str2 + " relationType: " + i3 + " msgStr: " + str3);
        Intent intent = new Intent();
        intent.setAction("tencent.av.v2q.MultiVideo");
        if (z16) {
            intent.putExtra("type", 540);
            intent.putExtra("peerUin", str);
        } else {
            intent.putExtra("type", TVKQQLiveAssetPlayerMsg.PLAYER_INFO_MULTI_NETWORK_CARD_STATUS_CHANGE);
            intent.putExtra("relationId", str2);
            intent.putExtra("relationType", i3);
        }
        intent.putExtra("msgStr", str3);
        intent.setPackage(VideoAppInterface.N().getApp().getPackageName());
        AVControllerCommon.D().e0(intent);
    }

    public void n0(long j3, int i3, long j16, boolean z16) {
        m0(j3, i3, j16, -1, z16);
    }

    public void n1(boolean z16) {
        this.E = z16;
    }

    public void o0() {
        boolean isSupportSharpAudio = AVCoreSystemInfo.isSupportSharpAudio();
        QLog.d(J, 1, String.format("initGAudioCtrl isSupportSharpAudio=%s mGAudioCtrl=%s ", Boolean.valueOf(isSupportSharpAudio), this.f72712n));
        if (!isSupportSharpAudio) {
            this.f72712n = null;
        }
        try {
            if (this.f72712n == null) {
                QQGAudioCtrl gAudioCtrlInstance = QQGAudioCtrl.getGAudioCtrlInstance();
                this.f72712n = gAudioCtrlInstance;
                if (gAudioCtrlInstance != null) {
                    long g16 = com.tencent.av.utils.i.g(VideoAppInterface.N().getCurrentAccountUin());
                    int a16 = com.tencent.av.app.q.a();
                    this.f72712n.setNetChannel(AVControllerCommon.D().f72571b);
                    this.f72712n.setCallback(this);
                    this.f72712n.setAppId(VideoAppInterface.N().getAppid());
                    this.f72712n.init(VideoAppInterface.N().getApp().getApplicationContext(), g16, com.tencent.mobileqq.vip.e.b(VideoAppInterface.N().getCurrentAccountUin()), true, -1, -1, true);
                    this.f72712n.setApType(a16);
                    if (!TextUtils.isEmpty(ClientLogReport.sGatewayIP)) {
                        AVControllerCommon.D().f72571b.receiveGatewayMsg(ClientLogReport.sGatewayIP, ClientLogReport.sGatewayPort);
                    }
                    GAClientLogReport.instance();
                    return;
                }
                QLog.e(J, 1, "initGAudioCtrl create instance fail.");
                AVControllerCommon.D().t(1014);
            }
        } catch (Throwable th5) {
            QLog.e(J, 1, "initGAudioCtrl fail.", th5);
            this.f72712n = null;
            AVControllerCommon.D().t(1014);
        }
    }

    public void o1(long[] jArr) {
        String currentAccountUin = VideoAppInterface.N().getCurrentAccountUin();
        if (currentAccountUin != null) {
            long g16 = com.tencent.av.utils.i.g(currentAccountUin);
            QQGAudioCtrl qQGAudioCtrl = this.f72712n;
            if (qQGAudioCtrl != null) {
                qQGAudioCtrl.setInviteUserList(g16, jArr);
            }
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onCheckScreenShareAvailable(int i3, byte[] bArr) {
        if (QLog.isColorLevel()) {
            QLog.d(J, 2, "onCheckScreenShareValid, isValid[" + i3 + "], detail[" + bArr + "]");
        }
        VideoAppInterface.N().k0(new Object[]{Integer.valueOf(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_CGI_RESPONSE), Integer.valueOf(i3), bArr});
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onCreateRoomSuc(int i3, long j3, int i16) {
        String str;
        String str2;
        boolean z16;
        boolean z17;
        int i17;
        ScreenShareCtrl H;
        long d16 = com.tencent.av.utils.e.d();
        String str3 = J + "|VideoNodeManager";
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onCreateRoomSuc, relationType[");
        sb5.append(i3);
        sb5.append("], groupId[");
        sb5.append(j3);
        sb5.append("], mGAudioCtrl[");
        sb5.append(this.f72712n != null);
        sb5.append("], mutiAvType[");
        sb5.append(i16);
        sb5.append("], seq[");
        sb5.append(d16);
        sb5.append("]");
        QLog.w(str3, 1, sb5.toString());
        if (this.f72712n == null) {
            return;
        }
        SessionInfo f16 = n.e().f();
        if (AVControllerCommon.D().j("onCreateRoomSuc", true, i3, String.valueOf(j3))) {
            f16 = n.e().f();
        }
        SessionInfo sessionInfo = f16;
        sessionInfo.f73088v0 = true;
        sessionInfo.f73092w0.clear();
        if (AVUtil.m(i3) && this.f72712n.mIsSwitchGroup) {
            W0();
            str = "onCreateRoomSuc";
            str2 = "]";
            z16 = true;
            i17 = 17;
            z17 = false;
        } else if (sessionInfo.f73042j2 == 5) {
            int i18 = sessionInfo.f73074r2;
            int i19 = sessionInfo.f73070q2;
            if (QLog.isColorLevel()) {
                QLog.i(J, 2, "onCreateRoomSuc, double meeting, terminalType[" + i18 + "], sdkVersion[" + i19 + "]");
            }
            if (t0(i18, i19)) {
                str = "onCreateRoomSuc";
                str2 = "]";
                z16 = true;
                this.f72712n.inviteUser(i16, new long[]{sessionInfo.P0}, 3, sessionInfo.f73042j2, 0, null);
                z17 = false;
            } else {
                str = "onCreateRoomSuc";
                str2 = "]";
                z16 = true;
                z17 = false;
                this.f72712n.inviteUser(i16, new long[]{sessionInfo.P0}, 4, sessionInfo.f73042j2, 0, null);
            }
            i17 = 17;
        } else {
            str = "onCreateRoomSuc";
            str2 = "]";
            z16 = true;
            z17 = false;
            if (i16 == 17) {
                Vector<String> vector = this.f72712n.mInviteGAudioOpenIdList;
                if (vector != null && vector.size() > 0) {
                    int size = this.f72712n.mInviteGAudioOpenIdList.size();
                    String[] strArr = new String[size];
                    for (int i26 = 0; i26 < size; i26++) {
                        strArr[i26] = this.f72712n.mInviteGAudioOpenIdList.get(i26);
                    }
                    i17 = 17;
                    this.f72712n.inviteUser(i16, null, 4, sessionInfo.f73042j2, 0, strArr);
                } else {
                    i17 = 17;
                    com.tencent.av.utils.e.x(HardCodeUtil.qqStr(R.string.f172879v04));
                    this.f72712n.inviteUser(i16, null, 4, sessionInfo.f73042j2, 0, null);
                }
            } else {
                i17 = 17;
                Vector<Long> vector2 = this.f72712n.mInviteGAudioUinList;
                if (vector2 != null && vector2.size() > 0) {
                    int size2 = this.f72712n.mInviteGAudioUinList.size();
                    long[] jArr = new long[size2];
                    for (int i27 = 0; i27 < size2; i27++) {
                        jArr[i27] = this.f72712n.mInviteGAudioUinList.get(i27).longValue();
                    }
                    this.f72712n.inviteUser(i16, jArr, 4, sessionInfo.f73042j2, 0, null);
                } else if ((com.tencent.av.utils.e.e(19) == 1) != false) {
                    com.tencent.av.utils.e.x(HardCodeUtil.qqStr(R.string.f172879v04));
                    this.f72712n.inviteUser(i16, null, 4, sessionInfo.f73042j2, 0, null);
                }
            }
        }
        AVControllerCommon.D().i(str);
        String str4 = str2;
        boolean z18 = z16;
        int i28 = i17;
        boolean z19 = z17;
        String str5 = str;
        O1("onCreateSuc", true, i3, j3);
        sessionInfo.E1 = z19;
        if (sessionInfo.f73060o0) {
            sessionInfo.z0(str5, z18);
            sessionInfo.f73072r0 = z18;
        }
        if (QLog.isColorLevel()) {
            QLog.w(J, z18 ? 1 : 0, "onCreateRoomSuc, MainSession[" + n.e().f() + str4);
        }
        VideoAppInterface N = VideoAppInterface.N();
        Object[] objArr = new Object[3];
        objArr[z19 ? 1 : 0] = 83;
        objArr[z18 ? 1 : 0] = Long.valueOf(j3);
        objArr[2] = Long.valueOf(d16);
        N.k0(objArr);
        if ((i3 == 2 || i3 == z18) && (i16 == 10 || i16 == z18)) {
            this.A.clear();
            if (QLog.isColorLevel()) {
                QLog.w(J, z18 ? 1 : 0, "InviteMemberList onCreateRoomSuc, request memberList]" + (z19 ? 1 : 0));
            }
        }
        if ((i3 == 11 && i16 == i28) || i3 == z18) {
            QLog.w(J, z18 ? 1 : 0, "onCreateRoomSuc, relation may notify small home");
            if (sessionInfo.H2) {
                QAVControllerForZplan.p().t(BaseApplication.getContext(), new e());
            }
        }
        this.f72709k = z19 ? 1 : 0;
        ChatRoomMng D = VideoAppInterface.N().D();
        if (D != null) {
            D.f(n.e().f());
        }
        if ((sessionInfo.f73060o0 || sessionInfo.S0 == 3) && (H = AVControllerCommon.D().H()) != null) {
            H.t(sessionInfo);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onDetectAudioDataIssue(int i3) {
        long d16 = com.tencent.av.utils.e.d();
        QLog.w(J, 1, "onDetectAudioDataIssue, issueType[" + this.f72710l + "->" + i3 + "], seq[" + d16 + "]");
        this.f72710l = i3;
        VideoAppInterface.N().k0(new Object[]{38, Integer.valueOf(i3), Long.valueOf(d16)});
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x01c3, code lost:
    
        if (com.tencent.av.app.VideoAppInterface.N().L() != false) goto L40;
     */
    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onDoubleVideoMeetingInvite(String str, int i3, int i16) {
        long j3;
        boolean z16;
        int c16 = n.e().c();
        try {
            j3 = Long.parseLong(str);
        } catch (NumberFormatException e16) {
            QLog.e(J, 1, "expection[" + e16.getMessage() + "]", new Throwable("stack trace"));
            j3 = 0;
        }
        long j16 = j3;
        final long d16 = com.tencent.av.utils.e.d();
        QLog.w(J, 1, "onDoubleVideoMeetingInvite, inviteUin[" + j16 + "], aliveSessionCount[" + c16 + "], multiAVType[" + i3 + "], multiSubType[" + i16 + "], seq[" + d16 + "], \nmainSession[" + n.e().f() + "]");
        if (i16 == 5 && c16 == 0) {
            QLog.w(J, 1, "onDoubleVideoMeetingInvite, should ignore this case");
            return;
        }
        if (u(j16, i3, i16)) {
            AVControllerCommon.D().X(d16, true, 0, String.valueOf(j16), String.valueOf(j16), 0, null, false);
            return;
        }
        final String b16 = n.b(100, String.valueOf(j16), new int[0]);
        n.e().a(b16, false);
        q.f74191b = VideoAppInterface.N().g0();
        AVControllerCommon.D();
        boolean N = AVControllerCommon.N(VideoAppInterface.N().getApp().getApplicationContext());
        if (TextUtils.equals(n.e().f().f73091w, String.valueOf(j16)) && (n.e().f().f73047l == 16 || i16 == 5)) {
            if (AVControllerCommon.D().F != null) {
                VideoAppInterface.N().M().removeCallbacks(AVControllerCommon.D().F);
                AVControllerCommon.D().F = null;
            }
            ScreenShareCtrl H = AVControllerCommon.D().H();
            if (H != null) {
                H.m(d16, j16, i3, i16);
                return;
            }
            return;
        }
        if (TextUtils.equals(n.e().f().f73091w, String.valueOf(j16)) && n.e().f().f73047l == 11) {
            if (AVControllerCommon.D().F != null) {
                VideoAppInterface.N().M().removeCallbacks(AVControllerCommon.D().F);
                AVControllerCommon.D().F = null;
            }
            n.e().i(b16).n0("onDoubleVideoMeetingInvite.1", 2);
            DAVController.R().E(n.e().f().f73091w, 2);
        }
        if (!n.e().f().D()) {
            if (!n.e().f().w() && !n.e().f().x() && !n.e().f().y()) {
                if (QLog.isColorLevel()) {
                    QLog.e(J, 2, "onDoubleVideoMeetingInvite-->Reject Video Request when chating");
                }
                if (N) {
                    AVControllerCommon.D().X(d16, true, 0, String.valueOf(j16), String.valueOf(j16), 0, null, false);
                    return;
                }
            } else if (String.valueOf(j16).equals(n.e().f().f73091w)) {
                n.e().i(b16).n0("onDoubleVideoMeetingInvite.2", 2);
                y1(true);
                DAVController.R().F(n.e().f().f73091w, 299);
                DAVController.R().H0(299);
                DAVController.R().E(n.e().f().f73091w, 2);
            } else {
                if (n.e().f().w() || n.e().f().x()) {
                    AVControllerCommon.D().X(d16, true, 0, String.valueOf(j16), String.valueOf(j16), 0, null, false);
                    return;
                }
                z16 = false;
            }
            z16 = true;
        }
        AVControllerCommon.D().f72570a = true;
        SessionInfo i17 = n.e().i(b16);
        if (i17 != null) {
            i17.M0 = true;
            i17.f73039j = 2;
            i17.f73067q = 0;
            i17.S0 = 3;
            i17.f73091w = String.valueOf(j16);
            i17.f73103z = null;
            i17.G = true;
            i17.n0("onDoubleVideoMeetingInvite.3", 2);
            i17.y0("onDoubleVideoMeetingInvite", true);
            i17.Y0 = String.valueOf(j16);
        }
        if (VideoAppInterface.N().b0()) {
            if (QLog.isColorLevel()) {
                QLog.e(J, 2, "recv double video meeting when phone is not idle:from uin=" + j16);
            }
            Intent intent = new Intent();
            intent.setAction("tencent.video.v2q.CallingDialog");
            intent.putExtra("isAudio", true);
            intent.putExtra("friendUin", String.valueOf(j16));
            intent.putExtra("uinType", 0);
            intent.putExtra("type", 1);
            intent.putExtra(AppConstants.Key.COLUMN_MSG_SENDER_UIN, j16);
            intent.putExtra("isSender", false);
            intent.setPackage(VideoAppInterface.N().getApp().getPackageName());
            AVControllerCommon.D().e0(intent);
            IMediaPlayerApi iMediaPlayerApi = (IMediaPlayerApi) QRoute.api(IMediaPlayerApi.class);
            iMediaPlayerApi.init(VideoAppInterface.N().getApp().getApplicationContext(), null);
            iMediaPlayerApi.playRing(d16, 0, R.raw.f169419r, null, null, false, 1, false, true, 0);
            l0(d16, 3, j16);
            z(d16, j16, 1);
            n.e().n(d16, b16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w(J, 1, "onDoubleVideoMeetingInvite, mOrientation[" + AVControllerCommon.D().f72582m + "], isQQPaused[" + q.f74191b + "], isVideoPaused[" + VideoAppInterface.N().isBackgroundPause + "], isScreenLocked[" + N + "], isAppOnForeground[" + BaseGesturePWDUtil.isAppOnForegroundByTasks(VideoAppInterface.N().getApp().getApplicationContext(), 0) + "], seq[" + d16 + "]");
        }
        if (AVControllerCommon.D().f72584o && AVControllerCommon.D().f72582m == 0 && !N && q.f74191b && VideoAppInterface.N().isBackgroundPause) {
            final String valueOf = String.valueOf(j16);
            final int i18 = 0;
            final boolean z17 = true;
            final boolean z18 = z16;
            VideoAppInterface.N().M().postDelayed(new Runnable() { // from class: com.tencent.av.MAVController.10
                @Override // java.lang.Runnable
                public void run() {
                    DAVController.R().z0(d16, b16, i18, valueOf, null, z17, false, z18, 0, 0, "doubleVideoMeeting");
                }
            }, 100L);
            return;
        }
        DAVController.R().z0(d16, b16, 0, String.valueOf(j16), null, true, true, z16, 0, 0, "doubleVideoMeeting");
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onEnterSuc(final long j3, final int i3, final int i16) {
        long d16 = com.tencent.av.utils.e.d();
        SessionInfo f16 = n.e().f();
        if (AVControllerCommon.D().j("onEnterSuc", true, i3, String.valueOf(j3))) {
            f16 = n.e().f();
        }
        QLog.w(J + "|VideoNodeManager", 1, "onEnterSuc, groupId[" + j3 + "], relationType[" + i3 + "], multiAVType[" + i16 + "], MainSession[" + f16 + "], seq[" + d16 + "]");
        AVControllerCommon.D().i("onEnterSuc");
        f16.E1 = false;
        if (i3 == 3) {
            f16.n0("onEnterSuc.1", 14);
            f16.z0("onEnterSuc", true);
            f16.X(d16, SystemClock.elapsedRealtime());
        } else {
            O1("onEnterSuc", true, i3, j3);
            SessionInfo i17 = n.e().i(n.b(i3, String.valueOf(j3), new int[0]));
            if (i17 != null) {
                i17.U0 = true;
                i17.f73088v0 = false;
                i17.f73023f2 = true;
            }
            if (AVUtil.m(i3) && this.f72712n.mIsSwitchGroup) {
                W0();
            }
            AVControllerCommon.D().b0(3);
        }
        VideoAppInterface.N().k0(new Object[]{80, Long.valueOf(j3), Long.valueOf(d16)});
        if ((i3 == 2 || i3 == 1) && (i16 == 10 || i16 == 1)) {
            this.A.clear();
            if (AVControllerCommon.D().f72576g != null) {
                AVControllerCommon.D().f72576g.post(new Runnable() { // from class: com.tencent.av.MAVController.22
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AVControllerCommon.D().f72571b != null) {
                            AVControllerCommon.D().f72571b.m(j3, MAVController.this.a(i3, i16, j3), false);
                        }
                    }
                });
            }
        }
        if ((i3 == 11 && i16 == 17) || i3 == 1) {
            QLog.w(J, 1, "onEnterSuc, relation may notify small home");
            SessionInfo i18 = n.e().i(n.b(i3, String.valueOf(j3), new int[0]));
            if (i18 != null && i18.H2) {
                QAVControllerForZplan.p().t(BaseApplication.getContext(), new f());
            }
        }
        if (i3 == 11 && i16 == 17) {
            ReportController.o(null, "dc00898", "", "", "0X800C260", "0X800C260", 0, 0, "", "", "", "");
        }
        ChatRoomMng D = VideoAppInterface.N().D();
        if (D != null) {
            D.f(n.e().f());
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onFpsChange(int i3) {
        int i16;
        if (i3 >= 20) {
            i16 = Math.min(30000, i3 * 1000);
        } else {
            i16 = 15000;
        }
        int i17 = n.e().f().f73033h2;
        if (i17 != i16 && !DeviceInfoMonitor.getModel().equalsIgnoreCase("HWI-AL00") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("VKY-AL00")) {
            long d16 = com.tencent.av.utils.e.d();
            QLog.w(J, 1, "onFpsChange, nFps[" + i17 + "->" + i16 + "], seq[" + d16 + "]");
            n.e().f().f73033h2 = i16;
            com.tencent.av.camera.b.a(VideoAppInterface.N().getApp().getApplicationContext()).setCameraWithNewFps(d16, i16);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGAudioInvite(int i3, long j3, String str, String[] strArr, boolean z16, int i16, int i17, int i18) {
        VideoAppInterface videoAppInterface;
        long j16;
        int i19;
        boolean z17;
        boolean z18;
        SessionInfo sessionInfo;
        String str2;
        SessionInfo sessionInfo2;
        boolean z19;
        char c16;
        boolean z26;
        long j17;
        String str3;
        String str4;
        int i26;
        VideoAppInterface videoAppInterface2;
        long[] jArr;
        long j18;
        boolean z27;
        int i27;
        Intent intent;
        VideoAppInterface videoAppInterface3;
        VideoAppInterface videoAppInterface4;
        boolean z28;
        String str5;
        String[] strArr2 = strArr;
        String str6 = "stack trace";
        long d16 = com.tencent.av.utils.e.d();
        AVCoreLog.printDebugLog("VideoNodeManager", "-->onGAudioInvite()**************************");
        VideoAppInterface N = VideoAppInterface.N();
        com.tencent.av.utils.e.w(VideoAppInterface.N());
        try {
            j16 = Long.parseLong(str);
            videoAppInterface = N;
        } catch (NumberFormatException e16) {
            videoAppInterface = N;
            QLog.e(J, 1, "expection[" + e16.getMessage() + "]", new Throwable("stack trace"));
            j16 = 0L;
        }
        long[] jArr2 = new long[strArr2.length];
        int i28 = 0;
        while (i28 < strArr2.length) {
            try {
                jArr2[i28] = Long.parseLong(strArr2[i28]);
                str5 = str6;
            } catch (NumberFormatException e17) {
                str5 = str6;
                QLog.e(J, 1, "expection[" + e17.getMessage() + "]", new Throwable(str6));
            }
            i28++;
            strArr2 = strArr;
            str6 = str5;
        }
        SessionInfo f16 = n.e().f();
        long x16 = AVControllerCommon.D().x(String.valueOf(j16));
        long V = V();
        if (QLog.isColorLevel()) {
            String str7 = J;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onGAudioInvite, friendUin[");
            sb5.append(j16);
            sb5.append("], groupId[");
            sb5.append(j3);
            sb5.append("], multiSubType[");
            sb5.append(i17);
            sb5.append("], multiAVType[");
            sb5.append(i16);
            sb5.append("], relationType[");
            sb5.append(i3);
            sb5.append("], mGAudioInRoom[");
            sb5.append(this.f72699a);
            sb5.append("], mGAudioGroupId[");
            sb5.append(this.f72700b);
            sb5.append("], mCurrentInviteId[");
            sb5.append(this.f72717s);
            sb5.append("], mCurrentInviteRelationType[");
            sb5.append(this.f72718t);
            sb5.append("], offLineInvite[");
            sb5.append(z16);
            sb5.append("], roomId[");
            sb5.append(x16);
            sb5.append("], gRoomId[");
            sb5.append(V);
            sb5.append("], seq[");
            d16 = d16;
            sb5.append(d16);
            sb5.append("], main[");
            sb5.append(f16);
            sb5.append("], app[");
            if (videoAppInterface != null) {
                z28 = true;
            } else {
                z28 = false;
            }
            sb5.append(z28);
            sb5.append("], original[");
            i19 = i18;
            sb5.append(i19);
            sb5.append("]");
            QLog.w(str7, 2, sb5.toString());
        } else {
            i19 = i18;
        }
        if (videoAppInterface == null) {
            return;
        }
        if (i17 != 6 && i17 != 5 && i17 != 4 && i17 != 3 && i16 != 17) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!cp.c(VideoAppInterface.N(), j3, z17)) {
            QLog.w(J, 1, "onGAudioInvite, forceDisableInviteBox");
            return;
        }
        String b16 = n.b(i3, String.valueOf(j3), new int[0]);
        if (n.e().j(b16) && i16 != 17) {
            QLog.d(J, 1, "onGAudioInvite, Session already exists, newSessionId=" + b16 + " mTerminalEnterRoomFirstSessionId=" + this.f72706h);
            this.f72706h = null;
            return;
        }
        SessionInfo a16 = n.e().a(b16, false);
        a16.P0 = j3;
        a16.S0 = i3;
        a16.f73063p = i16;
        a16.f73077s1 = false;
        a16.Q0 = jArr2;
        a16.f73042j2 = i19;
        if (i19 == 4) {
            com.tencent.av.screenshare.c.i(a16.f73030h, 2, "onGAudioInvite");
        }
        if (((IGuildLiveChannelApi) QRoute.api(IGuildLiveChannelApi.class)).checkGuildLiveAvBusinessFocus(Constants.Business.QQ_GUILD_LIVE_AUTHOR)) {
            QLog.i(J, 1, "onGAudioInvite: live author. refused");
            this.f72712n.ignore(i3, j3, 10);
            c1(d16, "ignoreGAudioChat_3", b16, 3, String.valueOf(j16), String.valueOf(j3));
            return;
        }
        if (v(i3, j3, i17)) {
            c1(d16, "too_much_session", b16, i3, String.valueOf(j16), String.valueOf(j3));
            return;
        }
        q.f74191b = videoAppInterface.g0();
        if (!f16.D() || videoAppInterface.L()) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (AVControllerCommon.D().f72573d != null) {
            if (videoAppInterface.M() != null) {
                videoAppInterface.M().removeCallbacks(AVControllerCommon.D().f72573d);
            }
            AVControllerCommon.D().f72573d = null;
            a16.n0("onGAudioInvite.1", 0);
        }
        if (!z18 || !AVUtil.l()) {
            AVControllerCommon.D().p0();
        }
        AVControllerCommon.D();
        boolean N2 = AVControllerCommon.N(videoAppInterface.getApp().getApplicationContext());
        if (N2) {
            int i29 = f16.f73043k;
            str2 = "onGAudioInvite";
            if (i29 > 0 && i29 <= 4 && i17 != 3) {
                c1(d16, "ScreenLocked_before_connect", b16, i3, String.valueOf(j16), String.valueOf(j3));
                return;
            }
            if (7 == i29) {
                c1(d16, "ScreenLocked_group_invite", b16, i3, String.valueOf(j16), String.valueOf(j3));
                return;
            }
            sessionInfo = a16;
            if (this.f72699a && this.f72700b == j3) {
                c1(d16, "ScreenLocked_group_in_room", b16, i3, String.valueOf(j16), String.valueOf(j3));
                return;
            } else if (i29 != 14 && i29 != 13) {
                if (z18 && i17 != 3) {
                    c1(d16, "ScreenLocked_session_exist", b16, i3, String.valueOf(j16), String.valueOf(j3));
                    return;
                }
            } else {
                c1(d16, "ScreenLocked_double_meeting", b16, i3, String.valueOf(j16), String.valueOf(j3));
                return;
            }
        } else {
            sessionInfo = a16;
            str2 = "onGAudioInvite";
        }
        if (QLog.isColorLevel()) {
            String str8 = J;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("onGAudioInvite,  aSessionExists[");
            sb6.append(z18);
            sb6.append("], isScreenLocked[");
            sb6.append(N2);
            sb6.append("], \nmainSession[");
            sb6.append(f16);
            sb6.append("], \nsessionInfo[");
            sessionInfo2 = sessionInfo;
            sb6.append(sessionInfo2);
            sb6.append("]");
            String sb7 = sb6.toString();
            z19 = true;
            QLog.w(str8, 1, sb7);
        } else {
            sessionInfo2 = sessionInfo;
            z19 = true;
        }
        if (sessionInfo2.f73035i == 0) {
            sessionInfo2.G = z19;
            sessionInfo2.p0(d16, "onGAudioInvite.1", 3);
            sessionInfo2.f73067q = ba.avRelationType2UinType(i3);
            sessionInfo2.f73091w = String.valueOf(j16);
            c16 = 2;
            if (i3 == 2) {
                sessionInfo2.Y0 = String.valueOf(j16);
            }
            sessionInfo2.G = z19;
            if (i17 != 3 && i17 != 4) {
                AVControllerCommon.D().f0(b16, sessionInfo2.f73035i, false, false, false);
            }
        } else {
            c16 = 2;
        }
        this.f72717s = j3;
        this.f72718t = i3;
        if (sessionInfo2.f73043k == 0) {
            sessionInfo2.n0(str2, 7);
        }
        if (i17 == 3 && f16.P0 == 0) {
            z26 = z18;
            j18 = V;
            j17 = d16;
            str3 = b16;
            jArr = jArr2;
            videoAppInterface2 = videoAppInterface;
            str4 = "]";
            i26 = i17;
            z27 = B(f16, sessionInfo2, d16, j16, b16, i3, j3, jArr);
        } else {
            z26 = z18;
            j17 = d16;
            str3 = b16;
            str4 = "]";
            i26 = i17;
            videoAppInterface2 = videoAppInterface;
            jArr = jArr2;
            j18 = V;
            if (i26 == 4) {
                z27 = C(f16, sessionInfo2, j17, j16, str3, i3, j3, jArr);
            } else {
                z27 = false;
            }
        }
        if (QLog.isColorLevel()) {
            i27 = 2;
            QLog.i(J, 2, "onGAudioInvite multiSubType[" + i26 + "], hasDeal[" + z27 + str4);
        } else {
            i27 = 2;
        }
        if (z27) {
            return;
        }
        if (videoAppInterface2.b0()) {
            if (QLog.isColorLevel()) {
                QLog.d(J, i27, "onGAudioInvite, phone is calling");
            }
            Intent intent2 = new Intent();
            intent2.setAction("tencent.video.v2q.CallingDialogMulti");
            intent2.setPackage(videoAppInterface2.getApp().getPackageName());
            intent2.putExtra("friendUin", j16);
            intent2.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 3);
            if (i3 == 1) {
                intent2.putExtra("uinType", 1);
            } else if (i3 == 2) {
                intent2.putExtra("uinType", 3000);
            }
            intent2.putExtra("relationType", i3);
            intent2.putExtra("extraUin", f16.f73103z);
            intent2.putExtra("relationId", j3);
            intent2.putExtra("type", 13);
            intent2.putExtra(AppConstants.Key.COLUMN_MSG_SENDER_UIN, videoAppInterface2.getCurrentAccountUin());
            intent2.putExtra("isSender", false);
            intent2.putExtra("peerUin", videoAppInterface2.getCurrentAccountUin());
            intent2.putExtra("realSenderUin", f16.Y0);
            videoAppInterface2.getApp().sendBroadcast(intent2);
            n0(j17, this.f72718t, j3, true);
            IMediaPlayerApi iMediaPlayerApi = (IMediaPlayerApi) QRoute.api(IMediaPlayerApi.class);
            iMediaPlayerApi.init(VideoAppInterface.N().getApp().getApplicationContext(), null);
            iMediaPlayerApi.playRing(j17, 0, R.raw.f169419r, null, null, false, 1, false, true, 0);
            n.e().n(j17, str3);
            return;
        }
        long j19 = j17;
        long j26 = j16;
        f16.Y0 = "" + j26;
        AVControllerCommon.D().f72572c = AVControllerCommon.D().J();
        VideoAppInterface videoAppInterface5 = videoAppInterface2;
        if (sessionInfo2.Q(videoAppInterface5)) {
            if (QLog.isColorLevel()) {
                QLog.i(J, 2, "onGAudioInvite msg blocked [" + sessionInfo2.f73030h + str4);
            }
            videoAppInterface4 = videoAppInterface5;
        } else {
            if (!z26 && !u.d() && !VideoAppInterface.N().a0()) {
                intent = new Intent(videoAppInterface5.getApp().getApplicationContext(), (Class<?>) GaInviteLockActivity.class);
            } else {
                intent = new Intent(videoAppInterface5.getApp().getApplicationContext(), (Class<?>) MultiIncomingCallsActivity.class);
                cp.c.g();
            }
            QLog.d(J, 1, "[handleInviteComing] fLongFriendUin=" + j26 + " relationId=" + j3);
            AVControllerCommon.D();
            if (AVControllerCommon.N(VideoAppInterface.N().getApp().getApplicationContext())) {
                videoAppInterface3 = videoAppInterface5;
                I1(i3, j3, j26, jArr, i16, j19, videoAppInterface3, sessionInfo2, z26, intent, false);
            } else {
                videoAppInterface3 = videoAppInterface5;
                QAVControllerForZplan.p().t(VideoAppInterface.N().getApp().getApplicationContext(), new i(sessionInfo2, str, z26, j18, intent, videoAppInterface3, i3, j3, j26, jArr, i16, j19));
            }
            videoAppInterface4 = videoAppInterface3;
        }
        if (videoAppInterface4.F) {
            videoAppInterface4.F = false;
        }
        videoAppInterface4.G = true;
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGAudioInviteResp(MavInviteData mavInviteData) {
        ArrayList<AVInviteAccount> arrayList;
        boolean z16;
        int size;
        if (mavInviteData == null) {
            arrayList = null;
        } else {
            arrayList = mavInviteData.inviteAccountList;
        }
        if (mavInviteData != null) {
            com.tencent.av.screenshare.d.c(mavInviteData.retCode, mavInviteData.tip);
        }
        if (QLog.isColorLevel()) {
            String str = J;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onGAudioInviteResp, inviteAccountList[");
            if (arrayList != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append("], size[");
            if (arrayList == null) {
                size = 0;
            } else {
                size = arrayList.size();
            }
            sb5.append(size);
            sb5.append("]");
            QLog.w(str, 1, sb5.toString());
        }
        if (arrayList == null) {
            return;
        }
        if (n.e().f().f73092w0 != null) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3).accountType == 1 && arrayList.get(i3).inviteType == 1) {
                    try {
                        Long valueOf = Long.valueOf(Long.parseLong(arrayList.get(i3).account));
                        if (!n.e().f().f73092w0.contains(valueOf)) {
                            n.e().f().f73092w0.add(valueOf);
                        }
                    } catch (NumberFormatException e16) {
                        QLog.e(J, 1, "expection[" + e16.getMessage() + "]", new Throwable("stack trace"));
                    }
                }
            }
        }
        VideoAppInterface.N().k0(new Object[]{99});
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGAudioKickOut(long j3, int i3, int i16) {
        int i17;
        long d16 = com.tencent.av.utils.e.d();
        QLog.w(J, 1, "onGAudioKickOut, Groupid[" + j3 + "], relationType[" + i3 + "], seq[" + d16 + "]");
        int avRelationType2UinType = ba.avRelationType2UinType(i3);
        if (this.f72699a && j3 == this.f72700b) {
            this.f72703e = true;
            if (i3 == 3) {
                AVControllerCommon.D().h0(n.e().f().f73030h, avRelationType2UinType, 7, false, String.valueOf(j3), null, false);
                i17 = 7;
            } else {
                AVControllerCommon.D().h0(n.e().f().f73030h, avRelationType2UinType, 20, false, String.valueOf(j3), null, false);
                i17 = 20;
            }
            if (avRelationType2UinType == 3000) {
                DataReport.T(null, "CliOper", "", "", "Multi_call", "Calling_kick_off", 0, 0, "", "", "", "");
            } else if (avRelationType2UinType == 1) {
                if (n.e().f().f73063p == 10) {
                    DataReport.T(null, "CliOper", "", "", "0X8005932", "0X8005932", 0, 0, "", "", "", "");
                } else {
                    DataReport.T(null, "CliOper", "", "", "0X80046D9", "0X80046D9", 0, 0, "", "", "", "");
                }
            }
            if (n.e().f().f73060o0) {
                DataReport.T(null, "CliOper", "", "", "0X800520B", "0X800520B", 0, 0, "", "", "", "");
            }
            SessionInfo f16 = n.e().f();
            if (f16 != null && f16.N) {
                VideoAppInterface.N().k0(new Object[]{106, Long.valueOf(d16)});
            }
            a1(this.f72701c, this.f72700b, i17);
            VideoAppInterface.N().k0(new Object[]{66, Long.valueOf(j3)});
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGAudioMemAllUpdate(long j3, String[] strArr, int i3, int i16) {
        this.D.clear();
        if (strArr == null) {
            VideoAppInterface.N().k0(new Object[]{64, Long.valueOf(j3), g0(), Integer.valueOf(i3), Integer.valueOf(i16)});
            return;
        }
        for (String str : strArr) {
            com.tencent.av.e eVar = new com.tencent.av.e();
            try {
                eVar.f73701a = Long.parseLong(str);
            } catch (NumberFormatException e16) {
                QLog.e(J, 1, "expection[" + e16.getMessage() + "]", new Throwable("stack trace"));
            }
            if (n.e().f().f73043k != 0 || eVar.f73701a != VideoAppInterface.N().getLongAccountUin()) {
                this.D.add(eVar);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(J, 2, "onGAudioMemAllUpdate, size[" + this.D.size() + "]");
        }
        VideoAppInterface.N().k0(new Object[]{64, Long.valueOf(j3), g0(), Integer.valueOf(i3)});
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGAudioMemberMicChanged(String str, int i3, int i16, boolean z16) {
        long j3;
        try {
            j3 = Long.parseLong(str);
        } catch (NumberFormatException e16) {
            com.tencent.qav.log.a.c(J, "expection[" + e16.getMessage() + "]", new Throwable("stack trace"));
            j3 = 0;
        }
        long j16 = j3;
        boolean P1 = P1(j16, i3, i16, z16);
        if (j16 == VideoAppInterface.N().getLongAccountUin()) {
            if (QLog.isColorLevel()) {
                QLog.w(J, 2, "onGAudioMemberMicChanged, uin[" + j16 + "], mGAudioMute[" + this.f72714p + "], isMicOff[" + z16 + "], mIsMicOffBySelf[" + this.G + "]");
            }
            if (z16 != this.f72714p && !this.G) {
                int T = T();
                F("onGAudioMemberMicChanged", this.f72700b, !z16, false, -1);
                B0(-1L, T, T());
            }
        }
        VideoAppInterface.N().k0(new Object[]{138, Long.valueOf(j16), Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16)});
        if (z16 && P1) {
            onGAudioUserAudioSuspectNoisy(0L, false, 0L);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGAudioMicSetByAdmin(long j3, int i3) {
        boolean z16;
        boolean z17;
        QLog.w(J, 1, "onGAudioMicSetByAdmin, manager uin[" + j3 + "], old micAuthByAdmin[" + n.e().f().X0 + "], new micAuthByAdmin[" + i3 + "], mIsMicOffBySelf[" + this.G + "], mGAudioGroupId[" + this.f72700b + "]");
        n.e().f().e0("onGAudioMicSetByAdmin", i3);
        if (i3 == 2) {
            return;
        }
        if (j3 == VideoAppInterface.N().getLongAccountUin() || i3 != 0) {
            int T = T();
            long j16 = this.f72700b;
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (VideoAppInterface.N().getLongAccountUin() == j3) {
                z17 = true;
            } else {
                z17 = false;
            }
            F("onGAudioMicSetByAdmin", j16, z16, z17, -1);
            B0(-1L, T, T());
        }
        VideoAppInterface.N().k0(new Object[]{140, Long.valueOf(j3), Integer.valueOf(i3)});
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGAudioRoomDestroy(int i3, long j3) {
        SessionInfo sessionInfo;
        int i16;
        char c16;
        long j16;
        SessionInfo sessionInfo2;
        QAVNotification l3;
        int i17;
        String str;
        String b16 = n.b(i3, String.valueOf(j3), new int[0]);
        if (i3 == 3) {
            b16 = n.b(100, String.valueOf(j3), new int[0]);
        }
        if (n.e().j(b16)) {
            sessionInfo = n.e().i(b16);
        } else {
            sessionInfo = null;
        }
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.w(J, 1, "onGAudioRoomDestroy, relationType[" + i3 + "], seq[" + d16 + "], sessionId[" + b16 + "], \nsession[" + sessionInfo + "]");
        }
        this.f72706h = null;
        com.tencent.av.screenshare.c.g(b16, "onGAudioRoomDestroy");
        if (sessionInfo == null) {
            return;
        }
        if (AVControllerCommon.D().f72574e != null) {
            AVControllerCommon.D().f72574e.k0(d16);
        }
        TraeHelper.n0(VideoAppInterface.N());
        TraeHelper.I().m0();
        if (com.tencent.av.utils.e.k() || sessionInfo.E1) {
            QLog.w(J, 1, "onGAudioRoomDestroy, \nmainsession[" + n.e().f() + "], \nstate[" + sessionInfo.f73043k + "], seq[" + d16 + "], isAcceptingMultiAV[" + sessionInfo.E1 + "], isCurJoinedGRoom[" + r0(i3, j3) + "]");
        }
        if (sessionInfo.E1) {
            return;
        }
        if (this.f72717s == j3) {
            this.f72717s = 0L;
            this.f72718t = 0;
        }
        if (i3 == 3 && sessionInfo.f73060o0 && ((str = sessionInfo.f73091w) == null || j3 != Long.valueOf(str).longValue())) {
            if (QLog.isColorLevel()) {
                QLog.d(J, 2, "onGAudioRoomDestroy-->RelationId is wrong-->PeerUin = " + sessionInfo.f73091w + " ,relationId = " + j3);
                return;
            }
            return;
        }
        if (!sessionInfo.f73077s1 && !sessionInfo.f73060o0) {
            if (sessionInfo.f73043k == 7) {
                i17 = 5;
            } else {
                i17 = 6;
            }
            i16 = 2;
            c16 = 1;
            j16 = d16;
            sessionInfo2 = sessionInfo;
            AVControllerCommon.D().g0("onGAudioRoomDestroy", b16, ba.avRelationType2UinType(i3), VideoAppInterface.N().getCurrentAccountUin(), String.valueOf(j3), i17, sessionInfo.Y0, false, false);
        } else {
            i16 = 2;
            c16 = 1;
            j16 = d16;
            sessionInfo2 = sessionInfo;
        }
        if (sessionInfo2.H2) {
            QAVControllerForZplan.p().C();
        }
        if (r0(i3, j3)) {
            a1(i3, j3, 69);
        }
        sessionInfo2.n0("onGAudioRoomDestroy", 0);
        VideoAppInterface N = VideoAppInterface.N();
        Object[] objArr = new Object[3];
        objArr[0] = 67;
        objArr[c16] = Long.valueOf(j3);
        objArr[i16] = Integer.valueOf(i16);
        N.k0(objArr);
        VideoAppInterface N2 = VideoAppInterface.N();
        Object[] objArr2 = new Object[3];
        objArr2[0] = 66;
        objArr2[c16] = Long.valueOf(j3);
        objArr2[i16] = Integer.valueOf(i16);
        N2.k0(objArr2);
        if (n.e().j(b16)) {
            if (i3 == 3) {
                AVControllerCommon.D().h0(n.e().i(b16).f73030h, ba.avRelationType2UinType(i3), 10, true, String.valueOf(j3), null, true);
            }
            if (n.e().n(j16, b16) && (l3 = QAVNotification.l(VideoAppInterface.N())) != null && l3.n()) {
                l3.f(b16);
                AVControllerCommon.D().v0();
            }
        }
        this.A.clear();
        j1();
        AVControllerCommon.D().Y();
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGAudioRoomMicModeChanged(long j3, boolean z16, boolean z17) {
        boolean z18;
        if (z17 && n.e().f().X0 != 2) {
            z18 = false;
        } else {
            z18 = true;
        }
        QLog.w(J, 1, "onGAudioRoomMicModeChanged, manager uin[" + j3 + "], old isRoomMicOff[" + n.e().f().W0 + "], new isRoomMicOff[" + z16 + "], mIsMicOffBySelf[" + this.G + "], mGAudioGroupId[" + this.f72700b + "], micAuthByAdmin[" + n.e().f().X0 + "], isCreateRoomOrEnterRoom[" + z17 + "], bNeedUpdateMic[" + z18 + "]");
        n.e().f().l0("onGAudioRoomMicModeChanged", z16);
        if (z18 && !this.G && ((j3 != VideoAppInterface.N().getLongAccountUin() || !z16) && z16)) {
            int T = T();
            F("onGAudioRoomMicModeChanged", this.f72700b, !z16, false, -1);
            B0(-1L, T, T());
        }
        VideoAppInterface.N().k0(new Object[]{139, Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17)});
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGAudioSDKError(int i3, long j3, int i16, int i17) {
        F0(i3, j3, i16, i17, 0);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGAudioSetMicFailed(int i3, ArrayList<AVUserInfo> arrayList) {
        long j3;
        for (int i16 = 0; i16 < i3; i16++) {
            AVUserInfo aVUserInfo = arrayList.get(i16);
            try {
                j3 = Long.parseLong(aVUserInfo.account);
            } catch (NumberFormatException e16) {
                com.tencent.qav.log.a.c(J, "expection[" + e16.getMessage() + "]", new Throwable("stack trace"));
                j3 = 0;
            }
            P1(j3, aVUserInfo.accountType, aVUserInfo.pstnStatus, false);
        }
        VideoAppInterface.N().k0(new Object[]{141, arrayList});
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGAudioTerminalEnterRoom(int i3, long j3, int... iArr) {
        int i16;
        long j16;
        String b16 = n.b(i3, String.valueOf(j3), new int[0]);
        if (!n.e().j(b16) && i3 == 3) {
            b16 = n.b(100, String.valueOf(j3), new int[0]);
        }
        SessionInfo i17 = n.e().i(b16);
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.w(J, 1, "onGAudioTerminalEnterRoom begin, sessionId[" + b16 + "], seq[" + d16 + "], \nsession[" + i17 + "]");
        }
        if (i17 != null && ((i16 = i17.f73043k) == 7 || i16 == 2)) {
            i17.n0("onGAudioTerminalEnterRoom", 0);
            this.f72706h = b16;
            VideoAppInterface.N().k0(new Object[]{67, Long.valueOf(j3), 1});
            if (n.e().j(b16)) {
                SessionInfo i18 = n.e().i(b16);
                int avRelationType2UinType = ba.avRelationType2UinType(i3);
                if (i3 == 3) {
                    AVControllerCommon.D().h0(i18.f73030h, avRelationType2UinType, 7, true, String.valueOf(j3), null, false);
                } else if (i3 == 2 || i3 == 1) {
                    j16 = d16;
                    AVControllerCommon.D().g0("ignoreGAudioChat_4", b16, avRelationType2UinType, VideoAppInterface.N().getCurrentAccountUin(), String.valueOf(j3), 4, i18.Y0, true, false);
                    n.e().n(j16, b16);
                    return;
                }
                j16 = d16;
                n.e().n(j16, b16);
                return;
            }
            return;
        }
        if (i17 == null) {
            this.f72706h = b16;
        } else {
            this.f72706h = null;
        }
        QLog.d(J, 1, "onGAudioTerminalEnterRoom mTermimalEnterRoomFirst=" + this.f72706h);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGAudioUserAudioSuspectNoisy(long j3, boolean z16, long j16) {
        ArrayList<Long> S1 = S1(j3, z16, j16);
        if (S1 != null) {
            VideoAppInterface.N().k0(new Object[]{142, S1, Integer.valueOf(S1.size())});
        }
        if (j3 == Long.valueOf(VideoAppInterface.N().getCurrentAccountUin()).longValue()) {
            if (z16) {
                DataReport.T(null, "CliOper", "", "", "0X8005DF2", "0X8005DF2", 0, 0, "", "", "", "");
            }
            DataReport.T(null, "CliOper", "", "", "0X8005DF0", "0X8005DF0", 0, 0, "", "", "", "");
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGVideoDownloadChannelCtlChanged(byte[] bArr) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d(J, 2, "onGVideoDownloadChannelCtlChanged start");
        }
        if (bArr != null) {
            qav_gvideo_sdk_transfer$gVideoDownChannelControl qav_gvideo_sdk_transfer_gvideodownchannelcontrol = new qav_gvideo_sdk_transfer$gVideoDownChannelControl();
            boolean z17 = false;
            try {
                qav_gvideo_sdk_transfer_gvideodownchannelcontrol.mergeFrom(bArr);
                qav_gvideo_sdk_transfer_gvideodownchannelcontrol.uint32_switch.get();
                z16 = N1(qav_gvideo_sdk_transfer_gvideodownchannelcontrol);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                z16 = false;
            }
            if (z16) {
                if (n.e().f().O1 == 3) {
                    z17 = true;
                }
                if (z17) {
                    h1(true);
                }
            }
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGaGoOffStageResult(int i3, long j3, long j16, int i16) {
        long d16 = com.tencent.av.utils.e.d();
        n.e().f().w0(d16, "onGaGoOffStageResult", false, false);
        if (VideoAppInterface.N() != null) {
            VideoAppInterface.N().k0(new Object[]{Integer.valueOf(i3), Long.valueOf(Long.valueOf(VideoAppInterface.N().getCurrentAccountUin()).longValue()), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i16), Long.valueOf(d16)});
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGaGoOnStageResult(int i3, long j3, long j16, int i16) {
        String b16;
        char c16;
        long d16 = com.tencent.av.utils.e.d();
        SessionInfo f16 = n.e().f();
        if (i16 == 3) {
            b16 = n.b(100, String.valueOf(j16), new int[0]);
        } else {
            b16 = n.b(i16, String.valueOf(j16), new int[0]);
        }
        boolean equals = TextUtils.equals(f16.f73030h, b16);
        if (!equals || QLog.isDevelopLevel()) {
            QLog.w(J, 1, "onGaGoOnStageResult, result[" + i3 + "], info[" + j3 + "], groupId[" + j16 + "], relationType[" + i16 + "], main[" + f16.f73030h + "], seq[" + d16 + "]");
        }
        if (!equals || VideoAppInterface.N() == null) {
            return;
        }
        if (i3 == 90) {
            if (j3 == 3) {
                c16 = 2;
                n.e().f().w0(d16, "onGaGoOnStageResult.1", true, false);
            } else {
                c16 = 2;
                n.e().f().w0(d16, "onGaGoOnStageResult.2", false, false);
                VideoAppInterface.N().k0(new Object[]{106, Long.valueOf(d16)});
            }
        } else {
            c16 = 2;
            n.e().f().w0(d16, "onGaGoOnStageResult.3", false, false);
            VideoAppInterface.N().k0(new Object[]{106, Long.valueOf(d16)});
        }
        long longValue = Long.valueOf(VideoAppInterface.N().getCurrentAccountUin()).longValue();
        VideoAppInterface N = VideoAppInterface.N();
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(i3);
        objArr[1] = Long.valueOf(longValue);
        objArr[c16] = Long.valueOf(j3);
        objArr[3] = Long.valueOf(j16);
        objArr[4] = Integer.valueOf(i16);
        objArr[5] = Long.valueOf(d16);
        N.k0(objArr);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGaSwitchVideoResult(int i3, long j3, long j16, int i16) {
        char c16;
        char c17;
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.w(J, 1, "onGaSwitchVideoResult, result[" + i3 + "], info[" + j3 + "], groupId[" + j16 + "], relationType[" + i16 + "], seq[" + d16 + "]");
        }
        if (i3 == 96) {
            if (n.e().f().f73057n1.size() > 0) {
                n.e().f().w0(d16, "onGaSwitchVideoResult", true, true);
                this.f72702d = true;
                for (int i17 = 0; i17 < n.e().f().f73045k1.size(); i17++) {
                    com.tencent.av.gaudio.c cVar = n.e().f().f73045k1.get(i17);
                    if (cVar.f73827a != Long.valueOf(VideoAppInterface.N().getCurrentAccountUin()).longValue()) {
                        if (v0(cVar.f73827a, cVar.f73828b, n.e().f().f73057n1)) {
                            cVar.f73830d = true;
                        } else {
                            cVar.f73830d = false;
                        }
                    }
                }
                c16 = 0;
                n.e().f().f73057n1.clear();
                n.e().f().V(Long.valueOf(VideoAppInterface.N().getCurrentAccountUin()).longValue(), false, true);
                String i06 = i0(n.e().f().f73045k1);
                if (QLog.isColorLevel()) {
                    c17 = 2;
                    QLog.d(J, 2, "onGaSwitchVideoResult-->Display VideoViewInfo List = " + i06);
                } else {
                    c17 = 2;
                }
            } else {
                c16 = 0;
                c17 = 2;
            }
        } else {
            c16 = 0;
            c17 = 2;
            this.f72702d = false;
            n.e().f().V(Long.valueOf(VideoAppInterface.N().getCurrentAccountUin()).longValue(), true, true);
            n.e().f().f73057n1.clear();
        }
        if (VideoAppInterface.N() != null) {
            VideoAppInterface N = VideoAppInterface.N();
            Object[] objArr = new Object[5];
            objArr[c16] = Integer.valueOf(i3);
            objArr[1] = Long.valueOf(j3);
            objArr[c17] = Long.valueOf(j16);
            objArr[3] = Integer.valueOf(i16);
            objArr[4] = Long.valueOf(d16);
            N.k0(objArr);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGetUinOpenIdRespond(UinOpenIdResponse uinOpenIdResponse, long j3, int i3, int i16, long j16, int i17) {
        if (uinOpenIdResponse != null) {
            QLog.i(J, 2, "onGetUinOpenIdRespond: " + uinOpenIdResponse.ret + uinOpenIdResponse.f77482msg + "");
            VideoAppInterface.N().k0(new Object[]{312, uinOpenIdResponse});
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGroupChatModeChange(long j3, int i3, int i16) {
        switch (i16) {
            case 101:
                n.e().f().f73013d1 = true;
                N0(i3, j3, i16);
                return;
            case 102:
            case 103:
                M0(i3, j3, i16);
                return;
            case 104:
            case 107:
            case 108:
                n.e().f().f73009c1 = i16;
                N0(i3, j3, i16);
                return;
            case 105:
            case 106:
            default:
                return;
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGroupSecurityLimit(long j3, long j16, String str) {
        QLog.w(J, 1, "onGroupSecurityLimit, mGAudioInRoom[" + this.f72699a + "], mGAudioGroupId[" + this.f72700b + "], relationId[" + j3 + "], info[" + j16 + "], strMsg[" + str + "]");
        if (this.f72699a && this.f72700b == j3) {
            a1(1, j3, 82);
        } else {
            VideoAppInterface.N().M().removeCallbacks(this.f72724z);
            this.f72724z = null;
            n.e().f().n0("onGroupSecurityLimit", 0);
            onGAudioSDKError(1, j3, 17, 0);
        }
        VideoAppInterface.N().k0(new Object[]{89, Long.valueOf(j3), Long.valueOf(j16), str});
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGroupVideoClosed(int i3, long j3, int i16, int i17) {
        QLog.w(J, 1, "onGroupVideoClosed, relationId[" + j3 + "], reason[" + i16 + "], avtype[" + i17 + "], bKickout[" + this.f72703e + "], mGAudioInRoom[" + this.f72699a + "], mGAudioGroupId[" + this.f72700b + "]");
        if (this.f72703e) {
            return;
        }
        if (this.f72699a && this.f72700b == j3) {
            a1(1, j3, 83);
        } else {
            VideoAppInterface.N().M().removeCallbacks(this.f72724z);
            this.f72724z = null;
            n.e().f().n0("onGroupVideoClosed", 0);
            F0(i3, j3, 17, 0, i16);
        }
        VideoAppInterface.N().k0(new Object[]{88, Long.valueOf(j3), Integer.valueOf(i16), Integer.valueOf(i17)});
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onHowling() {
        if (QLog.isColorLevel()) {
            QLog.d(J, 2, "onHowling");
        }
        this.f72712n.setHowlingDetectEnable(false);
        if (pu.c.m(VideoAppInterface.N().getApp().getApplicationContext())) {
            boolean s06 = s0();
            if (!s06) {
                int T = T();
                F("onHowling", this.f72700b, false, false, -1);
                B0(-1L, T, T());
                VideoAppInterface.N().k0(new Object[]{109});
            }
            boolean z16 = n.e().f().I0;
            if (z16) {
                AVControllerCommon.D().f72574e.S();
            }
            PopupDialog.m0(VideoAppInterface.N().getApp().getApplicationContext(), 230, null, VideoAppInterface.N().getApp().getApplicationContext().getString(R.string.ddv), R.string.cancel, R.string.f171151ok, new g(), new h(s06, z16));
            DataReport.T(null, "CliOper", "", "", "0x8006992", "0x8006992", 0, 0, "", "", "", "");
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onInitAIDenoiseStatus() {
        QLog.w(J, 1, "onInitAIDenoiseStatus");
        if (ea.r2()) {
            if ((n.e().f().f73035i == 3 || n.e().f().f73035i == 4) && this.f72712n != null && n.e().f().f73063p != 0) {
                this.f72712n.enableAIDenoise(ea.l2());
            }
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onKickOutFail(long j3, int i3, int i16, int i17, String str) {
        if (QLog.isColorLevel()) {
            QLog.w(J, 1, "onKickOutFail, groupId[" + j3 + "], relationType[" + i3 + "], multiAVType[" + i16 + "], errCode[" + i17 + "], strMsg[" + str + "]");
        }
        VideoAppInterface.N().k0(new Object[]{Integer.valueOf(WnsNetworkConst.WRITE_FAIL), Boolean.FALSE, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str});
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onKickOutSuc(long j3, int i3, int i16, int i17, String str) {
        if (QLog.isColorLevel()) {
            QLog.w(J, 1, "onKickOutSuc, groupId[" + j3 + "], relationType[" + i3 + "], multiAVType[" + i16 + "], errCode[" + i17 + "], strMsg[" + str + "]");
        }
        VideoAppInterface.N().k0(new Object[]{Integer.valueOf(WnsNetworkConst.WRITE_FAIL), Boolean.TRUE, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str});
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onMAVMemberInOrOut(AVUserInfo aVUserInfo, long j3, int i3, int i16, long j16, int... iArr) {
        long j17;
        if (QLog.isColorLevel()) {
            QLog.d(J, 2, "onMAVMemberInOrOut--> UserInfo = " + aVUserInfo.toString() + " ,relationId = " + j3 + " ,opType = " + i3 + " ,relationType = " + i16 + " ,extroInfo = " + j16);
        }
        try {
            j17 = Long.parseLong(aVUserInfo.account);
        } catch (NumberFormatException e16) {
            com.tencent.qav.log.a.c(J, "expection[" + e16.getMessage() + "]", new Throwable("stack trace"));
            j17 = 0;
        }
        if (i3 == 70) {
            if (aVUserInfo.accountType == 1) {
                if (n.e().f().k(j17) != null) {
                    AVPhoneUserInfo k3 = n.e().f().k(j17);
                    if (QLog.isColorLevel()) {
                        QLog.e(J, 2, "onMAVMemberInOrOut --> This PSTN User is in List. Info = " + k3);
                    }
                } else {
                    AVPhoneUserInfo aVPhoneUserInfo = new AVPhoneUserInfo();
                    aVPhoneUserInfo.account = j17;
                    aVPhoneUserInfo.accountType = 2;
                    n.e().f().T(aVPhoneUserInfo);
                    AVControllerCommon.D().f72571b.k(j17);
                }
            }
            G0(i16, j3, aVUserInfo, true, j16, iArr);
            return;
        }
        if (i3 == 71) {
            if (aVUserInfo.accountType == 1) {
                AVPhoneUserInfo aVPhoneUserInfo2 = new AVPhoneUserInfo();
                aVPhoneUserInfo2.account = j17;
                aVPhoneUserInfo2.accountType = 2;
            }
            G0(i16, j3, aVUserInfo, false, j16, iArr);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(J, 2, "onMAVMemberInOrOut-->WRONG OPTYPE");
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onMultiVideoChatMembersInfoChange(long j3, String[] strArr, int i3, int i16, long j16, int i17, int i18) {
        if (strArr == null) {
            if (QLog.isColorLevel()) {
                QLog.e(J, 2, "onGaChatUserInOrOut-->userUin is 0,OpType = " + i3);
                return;
            }
            return;
        }
        int length = strArr.length;
        long[] jArr = new long[length];
        for (int i19 = 0; i19 < strArr.length; i19++) {
            try {
                jArr[i19] = Long.parseLong(strArr[i19]);
            } catch (NumberFormatException e16) {
                QLog.e(J, 1, "expection[" + e16.getMessage() + "]", new Throwable("stack trace"));
            }
        }
        long j17 = jArr[0];
        if (i3 != 42) {
            if (i3 != 43) {
                switch (i3) {
                    case 72:
                        H0(j3, j17, true, i16, j16, i17);
                        return;
                    case 73:
                        H0(j3, j17, false, i16, j16, i17);
                        return;
                    case 74:
                        D0(Long.valueOf(j3), j17, i16, true);
                        return;
                    case 75:
                        D0(Long.valueOf(j3), j17, i16, false);
                        return;
                    case 76:
                        V0(j3, j17, true, i16, true, j16, i17);
                        return;
                    case 77:
                        V0(j3, j17, false, i16, true, j16, i17);
                        return;
                    case 78:
                        if (QLog.isColorLevel()) {
                            QLog.d(J, 2, "onMultiVideoChatMembersInfoChange = userUin:" + j17 + "curuin:" + VideoAppInterface.N().getCurrentAccountUin());
                        }
                        if (j17 != VideoAppInterface.N().getLongAccountUin()) {
                            U0(j3, j17, i16, j16, i17);
                        } else {
                            V0(j3, j17, true, i16, false, j16, i17);
                        }
                        com.tencent.av.screenshare.c.h(n.e().f().f73030h, "MEMBER_SHARE_SCREEN_IN");
                        return;
                    case 79:
                        V0(j3, j17, false, i16, false, j16, i17);
                        com.tencent.av.screenshare.c.g(n.e().f().f73030h, "MEMBER_SHARE_SCREEN_OUT");
                        return;
                    default:
                        if (QLog.isColorLevel()) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("Wrong type of GaChatMemBerInType, and Type = ");
                            sb5.append(i3);
                            sb5.append(", groupUin = ");
                            sb5.append(j3);
                            for (int i26 = 0; i26 < length; i26++) {
                                long j18 = jArr[i26];
                                sb5.append(", userUin = ");
                                sb5.append(j18);
                            }
                            QLog.e(J, 2, sb5.toString());
                            return;
                        }
                        return;
                }
            }
            R0(j3, jArr, false, i18);
            return;
        }
        R0(j3, jArr, true, i18);
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onNotifyBusinessExtInfo(AVUserInfo aVUserInfo, long j3, int i3, int i16, long j16, int i17) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.i(J, 2, "onNotifyBusinessExtInfo avuserInfo " + aVUserInfo);
        }
        Iterator<com.tencent.av.e> it = this.C.iterator();
        boolean z17 = false;
        while (it.hasNext()) {
            com.tencent.av.e next = it.next();
            if (String.valueOf(next.f73701a).equals(aVUserInfo.account) && aVUserInfo.extInfoType == 1) {
                next.f73726z = GAudioZPlanStatus.a(aVUserInfo.extBusinessInfo);
                QAVControllerForZplan p16 = QAVControllerForZplan.p();
                String str = aVUserInfo.account;
                if (next.f73726z.getStatus() == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                p16.J(str, z16);
                z17 = true;
            }
        }
        if (z17) {
            VideoAppInterface.N().k0(new Object[]{1001});
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onNotifyCommonTips(int i3, byte[] bArr) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.i(J, 2, "Mav onNotifyCommonTips commonTipsType = " + i3);
        }
        if (bArr != null && bArr.length > 0) {
            str = new String(bArr, StandardCharsets.UTF_8);
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            VideoAppInterface.N().k0(new Object[]{526, str});
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onOpenMicFail() {
        String str;
        if (QLog.isDevelopLevel()) {
            QLog.d(J, 2, "WL_DEBUG onOpenMicFail");
        }
        if (VideoAppInterface.N().getApp().getApplicationContext() != null) {
            QQToast.makeText(VideoAppInterface.N().getApp().getApplicationContext(), R.string.dg7, 1).show();
        }
        SessionInfo f16 = n.e().f();
        if (f16 != null) {
            if (f16.S0 == 1) {
                str = "0x8007CB5";
            } else {
                str = "0x8007CB6";
            }
            DoodleUtils.h(str);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onPPTInOrOut(long j3, long j16, int i3, int i16) {
        com.tencent.av.e K2 = K(String.valueOf(j16));
        if (K2 != null && i16 != 1) {
            if (i16 == 3 || i16 == 4) {
                K2.f73708h = false;
            }
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onRecSharePushEncParam(int i3, long j3, RecordParam recordParam) {
        if (AVControllerCommon.D().I != null) {
            AVControllerCommon.D().I.i(i3, j3, recordParam);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onRecvCommonChannelMsg(MavCommonPBMsg.MavCommonChannelInfo mavCommonChannelInfo, long j3, int i3, int i16, int i17) {
        if (mavCommonChannelInfo != null) {
            QLog.d(J, 1, "onRecvCommonChannelMsg relationId=" + j3 + " eventId=" + i3 + " relationType=" + i16 + " multiAvType=" + i17 + " cmdType=" + mavCommonChannelInfo.cmdType + " businessType=" + mavCommonChannelInfo.businessType + " roomId=" + mavCommonChannelInfo.roomId + " groupId=" + mavCommonChannelInfo.groupId + " " + mavCommonChannelInfo.relationType + " " + mavCommonChannelInfo.fromAccount);
            SessionInfo f16 = n.e().f();
            if (f16 != null) {
                long j16 = mavCommonChannelInfo.groupId;
                if (j16 == f16.P0 && i17 == 17 && mavCommonChannelInfo.cmdType == 9) {
                    onGAudioRoomDestroy(i16, j16);
                    return;
                }
                return;
            }
            return;
        }
        QLog.e(J, 1, "onRecvCommonChannelMsg param null error.");
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onRemoteVideoDataComeIn(int i3, String str, int i16) {
        long j3;
        try {
            j3 = Long.parseLong(str);
        } catch (NumberFormatException e16) {
            com.tencent.qav.log.a.c(J, "expection[" + e16.getMessage() + "]", new Throwable("stack trace"));
            j3 = 0;
        }
        SessionInfo f16 = n.e().f();
        if (!f16.A1 && !f16.M(j3, i16)) {
            if (QLog.isColorLevel()) {
                QLog.d(J, 2, "onRemoteVideoDataComeIn-->uin = " + j3 + ", videoSrcType=" + i16);
            }
            for (int i17 = 0; i17 < f16.f73045k1.size(); i17++) {
                if (f16.f73045k1.get(i17).f73827a == j3 && f16.f73045k1.get(i17).f73828b == i16) {
                    f16.f73045k1.get(i17).f73832f = true;
                }
            }
            VideoAppInterface.N().k0(new Object[]{81, Long.valueOf(j3), Integer.valueOf(i16)});
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onSelfAudioVolumeChange(long j3) {
        if (QLog.isDevelopLevel()) {
            QLog.d(J, 2, "onSelfAudioVolumeChange qav.value:=" + j3);
        }
        try {
            VideoAppInterface.N().k0(new Object[]{20002, Long.valueOf(j3), 0L, 100L});
        } catch (NullPointerException unused) {
            QLog.e(J, 1, "onSelfAudioVolumeChange failed.");
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onSetMicBySelf(long j3) {
        if (QLog.isDevelopLevel()) {
            QLog.d(J, 2, "WL_DEBUG onSetMicBySelf uin = " + j3);
        }
        synchronized (this.C) {
            Iterator<com.tencent.av.e> it = this.C.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.tencent.av.e next = it.next();
                if (next.f73701a == j3) {
                    if (!next.f73718r) {
                        next.f73718r = true;
                        VideoAppInterface.N().k0(new Object[]{157, Long.valueOf(j3), Boolean.TRUE});
                    }
                }
            }
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onShareOpsCallback(int i3, int i16, int i17, long j3, int i18, int i19) {
        if (AVControllerCommon.D().I != null) {
            AVControllerCommon.D().I.l(i3, i16, i17, j3, i18, i19);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onVideoSrcChange(int i3, int i16, long j3, long j16) {
        int i17;
        char c16;
        int i18;
        char c17;
        char c18;
        boolean z16;
        int i19;
        char c19;
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.w(J, 1, "onVideoSrcChange, videoSrcType[" + i3 + "], relationType[" + i16 + "], userUin[" + j3 + "], groupUin[" + j16 + "], seq[" + d16 + "]");
        }
        com.tencent.av.e K2 = K(String.valueOf(j3));
        if (K2 == null) {
            if (QLog.isColorLevel()) {
                QLog.e(J, 2, "onVideoSrcChange-->can not find the user");
                return;
            }
            return;
        }
        int i26 = 0;
        while (true) {
            if (i26 < n.e().f().f73045k1.size()) {
                if (n.e().f().f73045k1.get(i26).f73827a == j3) {
                    i17 = n.e().f().f73045k1.get(i26).f73828b;
                    break;
                }
                i26++;
            } else {
                i26 = -1;
                i17 = 1;
                break;
            }
        }
        if (i3 == 4) {
            if (i26 != -1) {
                c16 = 4;
                c17 = 0;
                i19 = 5;
                g1(j3, n.e().f().f73045k1, n.e().f().f73053m1, 0, true);
                E1();
                c19 = 2;
                VideoAppInterface.N().k0(new Object[]{70, Long.valueOf(j16), Long.valueOf(j3), Integer.valueOf(i17), Long.valueOf(d16)});
                z16 = false;
            } else {
                c16 = 4;
                i19 = 5;
                c19 = 2;
                c17 = 0;
                z16 = true;
            }
            VideoAppInterface N = VideoAppInterface.N();
            Object[] objArr = new Object[i19];
            objArr[c17] = 73;
            objArr[1] = Long.valueOf(j16);
            objArr[c19] = Long.valueOf(j3);
            objArr[3] = Integer.valueOf(i16);
            objArr[c16] = Long.valueOf(d16);
            N.k0(objArr);
            c18 = c19;
            i18 = i19;
        } else {
            c16 = 4;
            i18 = 5;
            c17 = 0;
            if (i3 != 0) {
                int q16 = n.e().f().q(j3, 0);
                if (q16 == -1) {
                    c18 = 2;
                    S0(j3, true, i16, 5L);
                    C1(K2, i3);
                    n.e().f().f73045k1.get(n.e().f().q(j3, 0)).f73828b = i3;
                } else {
                    c18 = 2;
                    com.tencent.av.gaudio.c cVar = n.e().f().f73045k1.get(q16);
                    com.tencent.av.gaudio.c cVar2 = new com.tencent.av.gaudio.c();
                    cVar2.f73827a = cVar.f73827a;
                    cVar2.f73828b = cVar.f73828b;
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(cVar2);
                    VideoAppInterface.N().k0(new Object[]{104, arrayList});
                    cVar.f73828b = i3;
                }
                z16 = true;
            } else {
                c18 = 2;
                z16 = false;
            }
        }
        if (z16) {
            VideoAppInterface N2 = VideoAppInterface.N();
            Object[] objArr2 = new Object[i18];
            objArr2[c17] = 87;
            objArr2[1] = Long.valueOf(j16);
            objArr2[c18] = Long.valueOf(j3);
            objArr2[3] = Integer.valueOf(i3);
            objArr2[c16] = Integer.valueOf(i16);
            N2.k0(objArr2);
        }
    }

    public void p1(String str, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i(J, 2, "setGAudioMute, [" + this.f72714p + " --> " + z16 + "], from[" + str + "]");
        }
        this.f72714p = z16;
    }

    public void q0(long[] jArr, boolean z16, String[] strArr) {
        int i3;
        QLog.w(J, 1, "inviteNewMemJoin, uinList[" + jArr + "], needNotifyUI[" + z16 + "], mMultiInviteEntranceFlag[" + this.f72707i + "]");
        if ((jArr != null && jArr.length != 0) || (strArr != null && strArr.length != 0)) {
            SessionInfo f16 = n.e().f();
            if (this.f72707i == 1 || f16.f73063p == 17) {
                long[] jArr2 = null;
                if (f16.f73063p != 17) {
                    if (jArr != null && jArr.length > 0) {
                        i3 = jArr.length;
                        jArr2 = new long[i3];
                    } else {
                        i3 = 0;
                    }
                    System.arraycopy(jArr, 0, jArr2, 0, i3);
                } else {
                    i3 = 0;
                }
                this.f72712n.inviteUser(f16.f73063p, jArr2, 4, strArr);
                if (jArr != null && jArr.length > 0) {
                    for (int i16 = 0; i16 < i3; i16++) {
                        if (!n.e().f().f73092w0.contains(Long.valueOf(jArr[i16]))) {
                            n.e().f().f73092w0.add(Long.valueOf(jArr[i16]));
                        }
                    }
                }
            }
            if (z16 && jArr != null && jArr.length > 0) {
                VideoAppInterface.N().k0(new Object[]{68, Long.valueOf(jArr[0]), Integer.valueOf(jArr.length)});
            }
        }
    }

    public void q1(final int i3, final int i16, final int i17) {
        this.f72708j = i17;
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            if (AVControllerCommon.D().f72576g != null) {
                AVControllerCommon.D().f72576g.post(new Runnable() { // from class: com.tencent.av.MAVController.11
                    @Override // java.lang.Runnable
                    public void run() {
                        QQGAudioCtrl qQGAudioCtrl = MAVController.this.f72712n;
                        if (qQGAudioCtrl != null) {
                            qQGAudioCtrl.setAudioNoiseCtrlParam(i3, i16, i17);
                        }
                    }
                });
            }
        } else {
            QQGAudioCtrl qQGAudioCtrl = this.f72712n;
            if (qQGAudioCtrl != null) {
                qQGAudioCtrl.setAudioNoiseCtrlParam(i3, i16, i17);
            }
        }
    }

    public boolean r0(int i3, long j3) {
        if (this.f72699a && this.f72701c == i3 && this.f72700b == j3) {
            return true;
        }
        return false;
    }

    public void r1(String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i(J, 2, "setGAudioSpeakerMode, [" + this.f72713o + " --> " + i3 + "], from[" + str + "]");
        }
        this.f72713o = i3;
    }

    public boolean s0() {
        return this.f72714p;
    }

    public void s1() {
        boolean z16;
        if (this.f72699a) {
            long g16 = com.tencent.av.utils.i.g(VideoAppInterface.N().getCurrentAccountUin());
            synchronized (this.C) {
                z16 = true;
                if (this.C.size() != 1 || this.C.get(0) == null || g16 != this.C.get(0).f73701a) {
                    z16 = false;
                }
            }
            if (z16) {
                n.e().f().n0("setGAudioState.1", 9);
            } else {
                n.e().f().n0("setGAudioState.2", 10);
            }
        }
    }

    public int t(long j3, final int i3, final long j16, long[] jArr, boolean z16) {
        int i16;
        int i17;
        String str = J + "|VideoNodeManager";
        StringBuilder sb5 = new StringBuilder();
        sb5.append("acceptGAudioChat, relationType[");
        sb5.append(i3);
        sb5.append("], relationId[");
        sb5.append(j16);
        sb5.append("], isVideo[");
        sb5.append(z16);
        sb5.append("], relationId[");
        sb5.append(j16);
        sb5.append("], mIsStartGAuio[");
        sb5.append(this.f72723y);
        sb5.append("], uinList[");
        sb5.append(jArr != null);
        sb5.append("], mGAudioCtrl[");
        sb5.append(this.f72712n != null);
        sb5.append("], seq[");
        sb5.append(j3);
        sb5.append("]");
        sb5.append(QLog.getStackTraceString(new Throwable()));
        QLog.w(str, 1, sb5.toString());
        AVControllerCommon.D().c0();
        if (this.f72712n == null) {
            o0();
        }
        if (this.f72712n == null) {
            return -1;
        }
        AVControllerCommon.D().i0(false);
        this.f72716r = false;
        synchronized (this.C) {
            this.C.clear();
        }
        n.e().f().n0("acceptGAudioChat", 8);
        n.e().f().P0 = j16;
        n.e().f().f73077s1 = true;
        n.e().f().E1 = true;
        long g16 = com.tencent.av.utils.i.g(VideoAppInterface.N().getCurrentAccountUin());
        if (i3 == 2) {
            i17 = n.e().f().N ? 2 : 1;
            i16 = 1;
        } else if (i3 == 1) {
            i16 = n.e().f().f73063p;
            if (n.e().f().N) {
                i17 = 2;
            }
            i17 = 1;
        } else if (i3 == 3) {
            i16 = 8;
            i17 = 1;
        } else if (i3 == 11) {
            i16 = n.e().f().f73063p;
            i17 = n.e().f().N ? 2 : 1;
            QLog.w(J, 1, "acceptGAudioChat multiAVType\uff1a" + i16);
        } else {
            i16 = 2;
            i17 = 2;
        }
        if (z16) {
            i17 = 2;
        }
        if (com.tencent.av.utils.e.k()) {
            QLog.w(J, 1, "acceptGAudioChat, MainSession[" + n.e().f() + "]");
        }
        VideoAppInterface.N().getVideoConfigUpdate();
        VideoAppInterface.N().H0();
        this.f72712n.acceptGAudio(i3, i16, i17, j16, jArr, com.tencent.av.app.q.a(), g16, n.e().f().Q1, n.e().f().H2 ? 5 : 0);
        GInviteTimeOutHelper.b().a();
        if (this.f72724z == null) {
            this.f72724z = new Runnable() { // from class: com.tencent.av.MAVController.5
                @Override // java.lang.Runnable
                public void run() {
                    int i18;
                    MAVController.this.f72724z = null;
                    n.e().f().n0("acceptGAudioChat", 0);
                    boolean isNetworkAvailable = NetworkUtil.isNetworkAvailable(VideoAppInterface.N().getApplication().getApplicationContext());
                    MAVController mAVController = MAVController.this;
                    int i19 = i3;
                    long j17 = j16;
                    if (isNetworkAvailable) {
                        i18 = 69;
                    } else {
                        i18 = 68;
                    }
                    mAVController.onGAudioSDKError(i19, j17, i18, 0);
                }
            };
        }
        this.f72723y = false;
        VideoAppInterface.N().M().postDelayed(this.f72724z, 30000L);
        AVControllerCommon.D().d0();
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
    
        if (r8 >= 10000) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005e, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005f, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005b, code lost:
    
        if (r8 >= 114) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean t0(int i3, int i16) {
        boolean z16 = true;
        boolean z17 = false;
        if (i3 != 2 && i3 != 3 && i3 != 4 && i3 != 8) {
            if (i3 == 12 || i3 == 5) {
                QLog.i(J, 2, "isPeerC2CToDoubleMeetingEnable pc type peerSdkVersion: " + i16 + " targetVersion: 10000");
            }
        } else {
            QLog.i(J, 2, "isPeerC2CToDoubleMeetingEnable mobile type peerSdkVersion: " + i16 + " targetVersion: 114");
        }
        QLog.i(J, 2, "isPeerC2CToDoubleMeetingEnable isSupport: " + z17);
        return z17;
    }

    public boolean t1(long j3, boolean z16) {
        QQGAudioCtrl qQGAudioCtrl = this.f72712n;
        if (qQGAudioCtrl == null) {
            return false;
        }
        return qQGAudioCtrl.setMicByAdmin(j3, z16);
    }

    public boolean u(long j3, int i3, int i16) {
        if (i16 == 5) {
            return false;
        }
        String b16 = n.b(100, String.valueOf(j3), new int[0]);
        SessionInfo f16 = n.e().f();
        if (TextUtils.equals(b16, f16.f73030h)) {
            return false;
        }
        int c16 = n.e().c();
        if (c16 >= 2) {
            QLog.i(J, 1, "checkNeedAutoRejectDM, to many session, reject. [" + c16 + "]");
            return true;
        }
        if (!f16.u() || !VideoAppInterface.N().a0()) {
            return false;
        }
        QLog.i(J, 1, "checkNeedAutoRejectDM, one in av game and one in invite.");
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0024, code lost:
    
        if (r6.f73070q2 >= 100) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
    
        r3 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0031, code lost:
    
        if (r6.f73070q2 >= 101) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003b, code lost:
    
        if (r6.f73070q2 >= 5635) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean u0(SessionInfo sessionInfo) {
        if (sessionInfo.f73074r2 == -1) {
            sessionInfo.f73074r2 = d0(sessionInfo, sessionInfo.f73091w);
        }
        if (sessionInfo.f73070q2 == -1) {
            sessionInfo.f73070q2 = c0(sessionInfo, sessionInfo.f73091w);
        }
        int i3 = sessionInfo.f73074r2;
        boolean z16 = true;
        boolean z17 = false;
        if (i3 != 2) {
            if (i3 != 4) {
                if (i3 == 5) {
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("double_2_multi", 2, "isPeerSupportDMeetingSwitchTroop, end[" + sessionInfo.f73074r2 + "," + sessionInfo.f73070q2 + "," + z17 + "]");
        }
        return z17;
    }

    public boolean u1(boolean z16) {
        if (this.f72712n == null) {
            return false;
        }
        QLog.w(J, 1, "setRoomMicOff, micOff[" + z16 + "]");
        return this.f72712n.setMicMode(z16 ? 1 : 0);
    }

    public boolean v(int i3, long j3, int i16) {
        if (i16 != 5 && i16 != 4 && i16 != 3) {
            SessionInfo f16 = n.e().f();
            if (f16.S0 == i3 && f16.P0 == j3) {
                return false;
            }
            int c16 = n.e().c();
            if (c16 >= 2) {
                QLog.i(J, 1, "checkNeedAutoRejectMAV, to many session, reject. [" + c16 + "]");
                return true;
            }
            if (f16.u() && VideoAppInterface.N().a0()) {
                QLog.i(J, 1, "checkNeedAutoRejectMAV, one in av game and one in invite.");
                return true;
            }
        }
        return false;
    }

    boolean v0(long j3, int i3, ArrayList<com.tencent.av.gaudio.c> arrayList) {
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            if (arrayList.get(i16).f73827a == j3 && arrayList.get(i16).f73828b == i3) {
                return true;
            }
        }
        return false;
    }

    public void v1(boolean z16) {
        QLog.w(J, 1, "setSelectMemberActivityIsResume, IsResume[" + z16 + "], mSelectMemberActivityIsResume[" + this.F + "]");
        if (z16) {
            this.F++;
            return;
        }
        int i3 = this.F - 1;
        this.F = i3;
        if (i3 < 0) {
            this.F = 0;
        }
    }

    public void w() {
        if (QLog.isColorLevel()) {
            QLog.d(J, 2, "checkScreenShareValid");
        }
        QQGAudioCtrl qQGAudioCtrl = this.f72712n;
        if (qQGAudioCtrl != null) {
            qQGAudioCtrl.checkScreenShareAvaliable();
        }
    }

    public void w0(int i3, int i16, int i17, long j3) {
        String str = i16 + "|" + i17 + "|" + j3;
        qav_gvideo_sdk_transfer$RespInfo X0 = X0(i3, str.getBytes());
        if (QLog.isColorLevel()) {
            QLog.w(J, 1, "kickOutUsers, event[" + i3 + "], result[" + X0.uint32_result.get() + "], data[" + str + "]");
        }
    }

    public void w1(boolean z16) {
        if (this.f72712n == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(J, 2, "setSoundEnable: " + z16);
        }
        if (this.f72699a) {
            if (z16) {
                this.f72712n.startAudioRecv();
            } else {
                this.f72712n.stopAudioRecv();
            }
        }
    }

    public void x() {
        if (!this.f72699a) {
            n.e().f().n0("clearGAudioState", 0);
        }
    }

    public ArrayList<com.tencent.av.e> x0(int i3, ArrayList<com.tencent.av.e> arrayList) {
        boolean z16;
        int i16 = i3;
        long currentTimeMillis = System.currentTimeMillis();
        if (i16 > 8) {
            z16 = true;
        } else {
            z16 = false;
        }
        ArrayList arrayList2 = new ArrayList(8);
        long longAccountUin = VideoAppInterface.N().getLongAccountUin();
        com.tencent.av.e eVar = null;
        if (!z16) {
            for (int i17 = 0; i17 < arrayList.size() && i17 < 8; i17++) {
                com.tencent.av.e eVar2 = arrayList.get(i17);
                if (eVar2.f73701a == longAccountUin) {
                    eVar = eVar2;
                }
                arrayList2.add(eVar2);
            }
        } else {
            for (int i18 = 0; i18 < i16; i18++) {
                com.tencent.av.e eVar3 = arrayList.get(i18);
                if (eVar3.f73701a == longAccountUin) {
                    eVar = eVar3;
                }
                arrayList2.add(eVar3);
            }
        }
        ArrayList<com.tencent.av.e> arrayList3 = new ArrayList<>();
        if (eVar != null) {
            arrayList3.add(eVar);
        }
        ArrayList arrayList4 = new ArrayList();
        for (int i19 = 0; i19 < i16; i19++) {
            long j3 = ((com.tencent.av.e) arrayList2.get(i19)).f73701a;
            if (j3 != longAccountUin) {
                if (VideoAppInterface.N().isFriend(String.valueOf(j3))) {
                    arrayList3.add((com.tencent.av.e) arrayList2.get(i19));
                } else {
                    arrayList4.add((com.tencent.av.e) arrayList2.get(i19));
                }
            }
        }
        if (!arrayList4.isEmpty()) {
            Collections.sort(arrayList4, new a());
            arrayList3.addAll(arrayList4);
        }
        if (z16) {
            while (i16 < arrayList.size()) {
                arrayList3.add(arrayList.get(i16));
                i16++;
            }
            QLog.d(J, 1, "InviteMemberList listSort exceedMaxNumber cost" + (System.currentTimeMillis() - currentTimeMillis));
            return arrayList3;
        }
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        while (i16 < arrayList2.size()) {
            if (VideoAppInterface.N().isFriend(String.valueOf(((com.tencent.av.e) arrayList2.get(i16)).f73701a))) {
                arrayList5.add((com.tencent.av.e) arrayList2.get(i16));
            } else {
                arrayList6.add((com.tencent.av.e) arrayList2.get(i16));
            }
            i16++;
        }
        if (!arrayList6.isEmpty()) {
            Collections.sort(arrayList6, new b());
            arrayList5.addAll(arrayList6);
        }
        if (!arrayList5.isEmpty()) {
            arrayList3.addAll(arrayList5);
        }
        if (arrayList.size() > 8) {
            for (int i26 = 8; i26 < arrayList.size(); i26++) {
                arrayList3.add(arrayList.get(i26));
            }
        }
        QLog.d(J, 1, "InviteMemberList listSort not exceedMaxNumber cost" + (System.currentTimeMillis() - currentTimeMillis));
        return arrayList3;
    }

    public boolean x1() {
        boolean z16 = false;
        if (this.f72712n == null) {
            return false;
        }
        synchronized (this.C) {
            int size = this.C.size();
            long longValue = Long.valueOf(VideoAppInterface.N().getCurrentAccountUin()).longValue();
            int i3 = 0;
            while (i3 < size) {
                com.tencent.av.e eVar = this.C.get(i3);
                if (eVar != null && eVar.f73719s) {
                    long j3 = eVar.f73701a;
                    if (longValue == j3) {
                        int T = T();
                        F("setSuspectNoisyUserMicOff", this.f72700b, false, true, -1);
                        B0(-1L, T, T());
                    } else {
                        this.f72712n.setMicByAdmin(j3, true);
                    }
                }
                i3++;
            }
            if (i3 != size) {
                z16 = true;
            }
        }
        return z16;
    }

    public void y() {
        QLog.w(J, 1, "clearSelectMemberActivityIsResume, selectMemberActivityIsResume[" + this.F + "]");
        this.F = 0;
    }

    public void y0(int i3, String str) {
        QQGAudioCtrl qQGAudioCtrl;
        if ((n.e().f().f73035i == 4 || n.e().f().f73035i == 2) && (qQGAudioCtrl = this.f72712n) != null) {
            qQGAudioCtrl.lockVideoMaxQP(i3, str);
        }
    }

    public void y1(boolean z16) {
        VideoProcessExitMonitor Q;
        if (VideoAppInterface.N() != null && (Q = VideoAppInterface.N().Q()) != null) {
            Q.t(z16);
        }
    }

    public void z(long j3, long j16, int i3) {
        String b16 = n.b(100, String.valueOf(j16), new int[0]);
        SessionInfo i16 = n.e().i(b16);
        if (i16 == null) {
            if (QLog.isColorLevel()) {
                QLog.e(J, 2, "closeDoubleVideoMeetingInvite found no session, relationId :" + j16);
                return;
            }
            return;
        }
        i16.n0("closeDoubleVideoMeetingInvite", 0);
        if (i3 == 23) {
            AVControllerCommon D = AVControllerCommon.D();
            String str = i16.f73091w;
            D.u(b16, 0, true, str, str);
        } else {
            AVControllerCommon.D().h0(b16, 0, i3, true, "" + j16, "" + j16, false);
        }
        Intent intent = new Intent();
        intent.setAction("tencent.av.v2q.MultiVideo");
        intent.putExtra("type", 403);
        intent.putExtra("relationType", 3);
        intent.putExtra("relationId", j16);
        intent.putExtra("friendUin", j16);
        intent.putExtra("MultiAVType", i16.f73063p);
        intent.putExtra("from", "VideoController4");
        intent.setPackage(VideoAppInterface.N().getApp().getPackageName());
        AVControllerCommon.D().e0(intent);
        boolean n3 = n.e().n(j3, b16);
        QAVNotification l3 = QAVNotification.l(VideoAppInterface.N());
        if (l3 != null && l3.n()) {
            l3.f(b16);
            if (n3) {
                AVControllerCommon.D().v0();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void z0(boolean z16) {
        int i3;
        ?? r142;
        long j3;
        boolean z17;
        long d16 = com.tencent.av.utils.e.d();
        SessionInfo f16 = n.e().f();
        if (QLog.isColorLevel()) {
            QLog.w("double_2_multi", 2, "DoubleVideoMeeting2MultiVideo begin, session[" + f16 + "], seq[" + d16 + "]");
        }
        long longValue = Long.valueOf(f16.f73091w).longValue();
        int i16 = f16.f73035i;
        long longValue2 = Long.valueOf(VideoAppInterface.N().getCurrentAccountUin()).longValue();
        boolean s06 = s0();
        int i17 = f16.f73067q;
        if (VideoAppInterface.N().r() > 0) {
            com.tencent.av.gaudio.c cVar = new com.tencent.av.gaudio.c();
            com.tencent.av.gaudio.c cVar2 = new com.tencent.av.gaudio.c();
            cVar.f73827a = longValue;
            cVar.f73828b = 1;
            cVar2.f73827a = longValue;
            cVar2.f73828b = 2;
            ArrayList arrayList = new ArrayList();
            arrayList.add(cVar2);
            arrayList.add(cVar);
            VideoAppInterface.N().k0(new Object[]{104, arrayList});
            if (f16.N) {
                VideoAppInterface.N().k0(new Object[]{106, Long.valueOf(d16)});
            }
        } else if (f16.q(longValue2, 1) != -1) {
            i3 = i17;
            r142 = s06;
            j3 = longValue;
            z17 = true;
            f16.w0(d16, "DoubleVideoMeeting2MultiVideo", true, false);
            A1(z17);
            boolean z18 = z17;
            Y0(d16, j3, true, 0);
            n.e().f().f73091w = String.valueOf(j3);
            n.e().f().p0(d16, "notifyChangeDoubleVideoMeeting2MultiVideo", i16);
            n.e().f().y0("notifyChangeDoubleVideoMeeting2MultiVideo", false);
            n.e().f().z0("notifyChangeDoubleVideoMeeting2MultiVideo", false);
            n.e().f().f73068q0 = z18;
            p1("notifyChangeDoubleVideoMeeting2MultiVideo", r142);
            r1("notifyChangeDoubleVideoMeeting2MultiVideo", r142);
            if (z16) {
                B1();
                n.e().f().t0("notifyChangeDoubleVideoMeeting2MultiVideo", 11);
                n.e().f().u0("notifyChangeDoubleVideoMeeting2MultiVideo", AVUtil.i(i3));
                VideoAppInterface N = VideoAppInterface.N();
                Object[] objArr = new Object[2];
                objArr[0] = 101;
                objArr[z18 ? 1 : 0] = Long.valueOf(d16);
                N.k0(objArr);
            }
            if (!QLog.isColorLevel()) {
                QLog.w("double_2_multi", 2, "notifyChangeDoubleVideoMeeting2MultiVideo end, mGAudioMute[" + this.f72714p + "], session[" + f16 + "], seq[" + d16 + "]");
                return;
            }
            return;
        }
        i3 = i17;
        r142 = s06;
        j3 = longValue;
        z17 = true;
        A1(z17);
        boolean z182 = z17;
        Y0(d16, j3, true, 0);
        n.e().f().f73091w = String.valueOf(j3);
        n.e().f().p0(d16, "notifyChangeDoubleVideoMeeting2MultiVideo", i16);
        n.e().f().y0("notifyChangeDoubleVideoMeeting2MultiVideo", false);
        n.e().f().z0("notifyChangeDoubleVideoMeeting2MultiVideo", false);
        n.e().f().f73068q0 = z182;
        p1("notifyChangeDoubleVideoMeeting2MultiVideo", r142);
        r1("notifyChangeDoubleVideoMeeting2MultiVideo", r142);
        if (z16) {
        }
        if (!QLog.isColorLevel()) {
        }
    }

    public void z1(boolean z16) {
        VideoProcessExitMonitor Q;
        if (VideoAppInterface.N() != null && (Q = VideoAppInterface.N().Q()) != null) {
            Q.u(z16);
        }
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGAudioMemAllUpdate(long j3, ArrayList<AVUserInfo> arrayList, int i3, int i16) {
        long j16;
        this.D.clear();
        ArrayList<Long> arrayList2 = new ArrayList<>();
        for (int i17 = 0; i17 < arrayList.size(); i17++) {
            try {
                j16 = Long.parseLong(arrayList.get(i17).account);
            } catch (NumberFormatException e16) {
                com.tencent.qav.log.a.c(J, "expection[" + e16.getMessage() + "]", new Throwable("stack trace"));
                j16 = 0;
            }
            com.tencent.av.e eVar = new com.tencent.av.e();
            eVar.f73701a = j16;
            eVar.f73715o = arrayList.get(i17).accountType;
            if (n.e().f().f73043k != 0 || eVar.f73701a != VideoAppInterface.N().getLongAccountUin()) {
                this.D.add(eVar);
            }
            if (arrayList.get(i17).accountType == 1) {
                arrayList2.add(Long.valueOf(j16));
            }
        }
        if (arrayList2.size() > 0) {
            AVControllerCommon.D().f72571b.l(arrayList2);
        }
        if (QLog.isColorLevel()) {
            QLog.i(J, 2, "onGAudioMemAllUpdate, size[" + this.D.size() + "]");
        }
        VideoAppInterface.N().k0(new Object[]{64, Long.valueOf(j3), g0(), Integer.valueOf(i3), Integer.valueOf(i16)});
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class e implements QAVControllerForZplan.d {
        e() {
        }

        @Override // com.tencent.av.zplan.QAVControllerForZplan.d
        public void a(boolean z16) {
            QLog.i(MAVController.J, 2, "onCreateRoomSuc isInZPlanSmallHomeMod: " + z16);
            if (z16) {
                String b16 = new GAudioZPlanStatus(1, VideoAppInterface.N().getCurrentAccountUin(), String.valueOf(System.currentTimeMillis())).b();
                MAVController.this.f72712n.NotifyBusinessExtInfo(VideoAppInterface.N().getCurrentAccountUin(), 1, b16, b16.length());
                QLog.i(MAVController.J, 2, "onCreateRoomSuc, notify self in small home extInfo " + b16);
            }
        }

        @Override // com.tencent.av.zplan.QAVControllerForZplan.d
        public void b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class f implements QAVControllerForZplan.d {
        f() {
        }

        @Override // com.tencent.av.zplan.QAVControllerForZplan.d
        public void a(boolean z16) {
            QLog.i(MAVController.J, 2, "onEnterSuc isInZPlanSmallHomeMod: " + z16);
            if (z16) {
                String b16 = new GAudioZPlanStatus(1, VideoAppInterface.N().getCurrentAccountUin(), String.valueOf(System.currentTimeMillis())).b();
                MAVController.this.f72712n.NotifyBusinessExtInfo(VideoAppInterface.N().getCurrentAccountUin(), 1, b16, b16.length());
                QLog.i(MAVController.J, 2, "onEnterSuc, notify self in small home extInfo " + b16);
            }
        }

        @Override // com.tencent.av.zplan.QAVControllerForZplan.d
        public void b() {
        }
    }

    @Override // com.tencent.av.gaudio.b
    public void b(long j3, ArrayList<AVUserInfo> arrayList) {
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onChangeAuthority(int i3, String str) {
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onChangeRole(int i3, String str) {
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onCameraSettingNotify(int i3, int i16, int i17) {
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGeneralRawChannelData(long j3, int i3, int i16, long j16, byte[] bArr) {
    }

    @Override // com.tencent.avcore.engine.mav.IMavEventListener
    public void onGetSignRespond(GetSignResponse getSignResponse, long j3, int i3, int i16, long j16, int i17) {
    }
}
