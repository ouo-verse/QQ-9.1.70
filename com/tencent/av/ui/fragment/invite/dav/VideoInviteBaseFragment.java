package com.tencent.av.ui.fragment.invite.dav;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import com.tencent.av.VideoRecoveryReporter;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.business.handler.SafetyHandler;
import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.av.compat.AVCallCompactHelper;
import com.tencent.av.n;
import com.tencent.av.q;
import com.tencent.av.r;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.ui.part.invite.b;
import com.tencent.av.ui.part.invite.k;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.ad;
import com.tencent.av.utils.ag;
import com.tencent.av.utils.bd;
import com.tencent.av.utils.i;
import com.tencent.av.zplan.QAVControllerForZplan;
import com.tencent.avcore.jni.audiodevice.TraeConstants;
import com.tencent.avcore.rtc.node.report.data.NodeModel$NodeEndReason;
import com.tencent.avcore.rtc.node.report.utils.RtcNodeReportReceiverHelper;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzonestatus.QZoneVideoContactsFeedHelper;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.remote.ServiceConst;
import mw.m;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class VideoInviteBaseFragment extends QPublicBaseFragment {

    /* renamed from: u0, reason: collision with root package name */
    private static String f75713u0 = "VideoInviteBaseFragment";
    public boolean C;
    private bd D;
    private int F;
    public sw.a V;
    public VideoAppInterface E = null;
    public SessionInfo G = null;
    public boolean H = false;
    public boolean I = false;
    public boolean J = false;
    public boolean K = false;
    public int L = 0;
    public int M = 0;
    public int N = 0;
    public byte[] P = null;
    public int Q = 0;
    public String R = null;
    public String S = null;
    public String T = null;
    public String U = null;
    public boolean W = false;
    boolean X = false;
    boolean Y = true;
    AudioManager Z = null;

    /* renamed from: a0, reason: collision with root package name */
    boolean f75714a0 = false;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f75715b0 = false;

    /* renamed from: c0, reason: collision with root package name */
    public int f75716c0 = 0;

    /* renamed from: d0, reason: collision with root package name */
    public int f75717d0 = 0;

    /* renamed from: e0, reason: collision with root package name */
    String f75718e0 = "";

    /* renamed from: f0, reason: collision with root package name */
    BroadcastReceiver f75719f0 = null;

    /* renamed from: g0, reason: collision with root package name */
    boolean f75720g0 = false;

    /* renamed from: h0, reason: collision with root package name */
    long f75721h0 = -1;

    /* renamed from: i0, reason: collision with root package name */
    boolean f75722i0 = false;

    /* renamed from: j0, reason: collision with root package name */
    boolean f75723j0 = false;

    /* renamed from: k0, reason: collision with root package name */
    boolean f75724k0 = false;

    /* renamed from: l0, reason: collision with root package name */
    private com.tencent.av.compat.a f75725l0 = new com.tencent.av.compat.a();

    /* renamed from: m0, reason: collision with root package name */
    private long f75726m0 = -1;

    /* renamed from: n0, reason: collision with root package name */
    boolean f75727n0 = false;

    /* renamed from: o0, reason: collision with root package name */
    protected long f75728o0 = 0;

    /* renamed from: p0, reason: collision with root package name */
    protected long f75729p0 = 0;

    /* renamed from: q0, reason: collision with root package name */
    VideoObserver f75730q0 = new c();

    /* renamed from: r0, reason: collision with root package name */
    GAudioUIObserver f75731r0 = new d();

    /* renamed from: s0, reason: collision with root package name */
    lu.b f75732s0 = new e();

    /* renamed from: t0, reason: collision with root package name */
    QAVNotification f75733t0 = null;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f75734d;

        a(long j3) {
            this.f75734d = j3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (VideoInviteBaseFragment.this.getActivity() == null || VideoInviteBaseFragment.this.getActivity().isFinishing() || VideoInviteBaseFragment.this.getActivity().isDestroyed() || i3 == 1) {
                return;
            }
            VideoInviteBaseFragment.this.Sh(this.f75734d, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f75736d;

        b(long j3) {
            this.f75736d = j3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (VideoInviteBaseFragment.this.getActivity() == null || VideoInviteBaseFragment.this.getActivity().isFinishing() || VideoInviteBaseFragment.this.getActivity().isDestroyed()) {
                return;
            }
            if (i3 == 1) {
                VideoInviteBaseFragment.this.wh(this.f75736d);
            } else {
                VideoInviteBaseFragment.this.Sh(this.f75736d, true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class c extends VideoObserver {
        c() {
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void N(int i3) {
            VideoInviteBaseFragment.this.Oh(i3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.VideoObserver
        public void X() {
            super.X();
            VideoInviteBaseFragment.this.refreshUI();
            VideoInviteBaseFragment videoInviteBaseFragment = VideoInviteBaseFragment.this;
            VideoAppInterface videoAppInterface = videoInviteBaseFragment.E;
            if (videoAppInterface != null) {
                videoAppInterface.y0(videoInviteBaseFragment.M, videoInviteBaseFragment.S, videoInviteBaseFragment.U);
                VideoInviteBaseFragment videoInviteBaseFragment2 = VideoInviteBaseFragment.this;
                SessionInfo sessionInfo = videoInviteBaseFragment2.G;
                if (sessionInfo != null) {
                    videoInviteBaseFragment2.E.x0(sessionInfo.B0, sessionInfo.D0);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.VideoObserver
        public void b(int i3) {
            VideoInviteBaseFragment.this.Kh(i3);
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void e(long j3, int i3, String str) {
            if (TextUtils.equals(VideoInviteBaseFragment.this.S, str)) {
                if (QLog.isColorLevel()) {
                    QLog.d(VideoInviteBaseFragment.f75713u0, 2, "onClose  wrong uin: " + VideoInviteBaseFragment.this.S + ", " + str);
                    return;
                }
                return;
            }
            SessionInfo sessionInfo = VideoInviteBaseFragment.this.G;
            if (sessionInfo == null || sessionInfo.u()) {
                return;
            }
            TraeHelper.n0(VideoInviteBaseFragment.this.E);
            VideoInviteBaseFragment videoInviteBaseFragment = VideoInviteBaseFragment.this;
            if (!videoInviteBaseFragment.f75723j0 || videoInviteBaseFragment.Gh()) {
                VideoInviteBaseFragment.this.Ah(i3, 251);
            } else {
                VideoInviteBaseFragment.this.Rh(i3, 250, 0L, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.VideoObserver
        public void h(String str, boolean z16) {
            String str2 = VideoInviteBaseFragment.this.S;
            if (str2 == null || !str2.equals(str)) {
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.i(VideoInviteBaseFragment.f75713u0, 4, "onDestroyUI, peer[" + str + "], isQuit[" + z16 + "]");
            }
            if (z16) {
                TraeHelper.n0(VideoInviteBaseFragment.this.E);
                VideoInviteBaseFragment videoInviteBaseFragment = VideoInviteBaseFragment.this;
                if (videoInviteBaseFragment.f75723j0 && !videoInviteBaseFragment.Gh()) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i(VideoInviteBaseFragment.f75713u0, 4, "onDestroyUI, outAnim, peer[" + str + "], isQuit[" + z16 + "]");
                    }
                    VideoInviteBaseFragment.this.Qh();
                    return;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.i(VideoInviteBaseFragment.f75713u0, 4, "onDestroyUI, noAnim, peer[" + str + "], isQuit[" + z16 + "]");
                }
                VideoInviteBaseFragment videoInviteBaseFragment2 = VideoInviteBaseFragment.this;
                videoInviteBaseFragment2.W = z16;
                if (videoInviteBaseFragment2.getActivity() != null) {
                    VideoInviteBaseFragment.this.getActivity().finish();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.VideoObserver
        public void l(String str) {
            super.l(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.VideoObserver
        public void m(String str, Bitmap bitmap) {
            if (QLog.isColorLevel()) {
                QLog.d(VideoInviteBaseFragment.f75713u0, 2, "onGetStrangeFace uin = " + str);
            }
            super.m(str, bitmap);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class d extends GAudioUIObserver {
        d() {
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void h(long j3, int i3) {
            String str;
            long d16 = com.tencent.av.utils.e.d();
            if (QLog.isColorLevel()) {
                QLog.w(VideoInviteBaseFragment.f75713u0, 1, "onDestroyInviteUI, relationId[" + j3 + "], seq[" + d16 + "]");
            }
            VideoInviteBaseFragment videoInviteBaseFragment = VideoInviteBaseFragment.this;
            boolean z16 = videoInviteBaseFragment.f75715b0;
            if (z16 && (str = videoInviteBaseFragment.S) != null && str.equals(String.valueOf(j3))) {
                super.i(j3);
                TraeHelper.n0(VideoInviteBaseFragment.this.E);
                VideoInviteBaseFragment.this.ai(d16);
                if (z16 && VideoInviteBaseFragment.this.S.length() > 2 && j3 != 0) {
                    long longValue = Long.valueOf(VideoInviteBaseFragment.this.S).longValue();
                    VideoInviteBaseFragment videoInviteBaseFragment2 = VideoInviteBaseFragment.this;
                    if (!videoInviteBaseFragment2.f75714a0) {
                        videoInviteBaseFragment2.f75714a0 = true;
                        if (i3 == 1) {
                            r.h0().o(d16, longValue, 7);
                        } else if (i3 == 2) {
                            r.h0().o(d16, longValue, 2);
                        }
                    }
                }
                VideoInviteBaseFragment videoInviteBaseFragment3 = VideoInviteBaseFragment.this;
                videoInviteBaseFragment3.W = true;
                if (videoInviteBaseFragment3.f75723j0 && !videoInviteBaseFragment3.Gh()) {
                    VideoInviteBaseFragment.this.Qh();
                } else if (VideoInviteBaseFragment.this.getActivity() != null) {
                    VideoInviteBaseFragment.this.getActivity().finish();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class f implements b.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f75741a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f75742b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f75743c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f75744d;

        f(int i3, long j3, boolean z16, int i16) {
            this.f75741a = i3;
            this.f75742b = j3;
            this.f75743c = z16;
            this.f75744d = i16;
        }

        @Override // com.tencent.av.ui.part.invite.b.d
        public void onAnimationEnd() {
            int i3 = this.f75741a;
            if (i3 == 246) {
                VideoInviteBaseFragment.this.Bh(this.f75742b, 246, false, this.f75743c);
                VideoInviteBaseFragment videoInviteBaseFragment = VideoInviteBaseFragment.this;
                if (!videoInviteBaseFragment.f75715b0 && videoInviteBaseFragment.getActivity() != null) {
                    VideoInviteBaseFragment.this.getActivity().finish();
                }
            } else if (i3 == 248) {
                VideoInviteBaseFragment.this.Bh(this.f75742b, 248, true, this.f75743c);
                VideoInviteBaseFragment videoInviteBaseFragment2 = VideoInviteBaseFragment.this;
                if (!videoInviteBaseFragment2.f75715b0) {
                    RtcNodeReportReceiverHelper.s(videoInviteBaseFragment2.f75718e0, 2, NodeModel$NodeEndReason.K_INTERRUPTION.ordinal());
                    if (VideoInviteBaseFragment.this.getActivity() != null) {
                        VideoInviteBaseFragment.this.getActivity().finish();
                    }
                }
            } else if (i3 == 250) {
                VideoInviteBaseFragment.this.Ah(this.f75744d, 250);
            } else {
                VideoInviteBaseFragment videoInviteBaseFragment3 = VideoInviteBaseFragment.this;
                videoInviteBaseFragment3.W = true;
                if (videoInviteBaseFragment3.getActivity() != null) {
                    VideoInviteBaseFragment.this.getActivity().finish();
                }
            }
            if (VideoInviteBaseFragment.this.getActivity() != null) {
                VideoInviteBaseFragment.this.getActivity().overridePendingTransition(0, R.anim.f154854e3);
            }
        }

        @Override // com.tencent.av.ui.part.invite.b.d
        public void onAnimationStart() {
            VideoInviteBaseFragment.this.V.P1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class g extends BroadcastReceiver {
        g() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (QLog.isColorLevel()) {
                QLog.d(VideoInviteBaseFragment.f75713u0, 2, "onReceive action = " + action);
            }
            if ("tencent.video.q2v.ACTION_ON_UPDATE_FRIEND_INFO".equals(action)) {
                VideoInviteBaseFragment.this.refreshUI();
                return;
            }
            if ("tencent.video.q2v.sdk.onRequestVideo".equals(action)) {
                QLog.d(VideoInviteBaseFragment.f75713u0, 1, "onReceive action = " + action);
                VideoInviteBaseFragment.this.Ph();
                return;
            }
            if ("android.intent.action.USER_PRESENT".equals(action)) {
                VideoInviteBaseFragment.this.xh("ACTION_USER_PRESENT");
            } else {
                VideoInviteBaseFragment.this.Lh(context, action, intent);
            }
        }
    }

    public VideoInviteBaseFragment(boolean z16) {
        this.C = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ah(int i3, int i16) {
        r.h0().r(this.S, i16);
        r.h0().j2(i16);
        r.h0().q(this.S, i3);
        this.W = true;
        QLog.d(f75713u0, 1, "onClose()-> else ->finish closeType=" + i3);
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    private void Dh(String str, String str2, boolean z16) {
        SessionInfo sessionInfo = this.G;
        if (sessionInfo == null || sessionInfo.P2.booleanValue()) {
            return;
        }
        ((SafetyHandler) this.E.getBusinessHandler(SafetyHandler.class.getName())).E2(str, str2, z16);
        this.G.P2 = Boolean.TRUE;
    }

    private boolean Eh(Context context) {
        VideoAppInterface videoAppInterface = (VideoAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        this.E = videoAppInterface;
        if (videoAppInterface == null) {
            return false;
        }
        this.D = new bd(context, 1, "video wifi lock");
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean Fh(Activity activity) {
        Intent intent = activity.getIntent();
        boolean z16 = true;
        if (intent != null && !ag.b(intent)) {
            String stringExtra = intent.getStringExtra("peerUin");
            this.S = stringExtra;
            if (TextUtils.isEmpty(stringExtra)) {
                z16 = false;
            } else {
                this.M = intent.getIntExtra("uinType", 0);
                this.U = intent.getStringExtra("extraUin");
                this.L = intent.getIntExtra("curUserStatus", 0);
                this.I = intent.getBooleanExtra("isAudioMode", false);
                this.K = intent.getBooleanExtra("powerKey", false);
                this.Y = intent.getBooleanExtra("isPlayRing", true);
                this.f75715b0 = intent.getBooleanExtra("isDoubleVideoMeeting", false);
            }
            if (QLog.isColorLevel()) {
                QLog.i(f75713u0, 2, "initVideoParam fromIntent peer[" + this.S + "], uinType[" + this.M + "], audioMode[" + this.I + "], ret[" + z16 + "], mIsDoubleVideoMeeting[" + this.f75715b0 + "]");
            }
        } else {
            SessionInfo f16 = n.e().f();
            if (f16 != null) {
                this.M = f16.f73067q;
                String str = f16.f73091w;
                this.S = str;
                if (!TextUtils.isEmpty(str)) {
                    this.M = f16.f73067q;
                    this.U = f16.f73103z;
                    this.L = r.h0().M();
                    this.I = f16.M0;
                    this.f75715b0 = f16.f73060o0;
                    if (QLog.isColorLevel()) {
                        QLog.i(f75713u0, 2, "initVideoParam from Session peer[" + this.S + "], uinType[" + this.M + "], audioMode[" + this.I + "], ret[" + z16 + "]");
                    }
                }
            }
            z16 = false;
            if (QLog.isColorLevel()) {
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Hh(DialogInterface dialogInterface, int i3) {
        if (this.E == null) {
            return;
        }
        dialogInterface.dismiss();
        r.h0().Z1();
        this.V.L1();
        r.h0().P2(com.tencent.av.utils.e.d(), this.I ? 1 : 2, false, true);
        Zh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ih(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        Sh(com.tencent.av.utils.e.d(), true);
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rh(int i3, int i16, long j3, boolean z16) {
        Yh(new f(i16, j3, z16, i3));
    }

    private void Th() {
        RFWIocAbilityProvider.g().registerIoc(getView(), new mw.n(this), m.class);
    }

    private void Uh(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(f75713u0, 2, "sendIsResumeBroadcast isResume = " + z16);
        }
        SmallScreenUtils.A(BaseApplication.getContext(), z16);
    }

    private void bi() {
        RFWIocAbilityProvider.g().unregisterSingleIoc(getView(), m.class);
    }

    private boolean zh() {
        bd bdVar;
        if (this.D == null) {
            this.D = new bd(getContext(), 1, "video wifi lock");
        }
        if (ad.q(getContext()) && (bdVar = this.D) != null) {
            bdVar.b();
        }
        return true;
    }

    public abstract void Ch(boolean z16);

    public boolean Gh() {
        return this.C;
    }

    void Kh(int i3) {
        if (this.F == i3) {
            return;
        }
        if (i3 == 0) {
            cw.e.o(this.E, 1040, R.string.f171269dm3);
        } else if (i3 == 1) {
            cw.e.o(this.E, 1040, R.string.f171267dm0);
        } else if (i3 == 2) {
            cw.e.o(this.E, 1040, R.string.dly);
        }
        this.F = i3;
    }

    public abstract void Lh(Context context, String str, Intent intent);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Mh() {
        String str;
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            String str2 = f75713u0;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onVideoRequestTimeout, seq[");
            sb5.append(d16);
            sb5.append("], state[");
            SessionInfo sessionInfo = this.G;
            sb5.append(sessionInfo == null ? -1 : sessionInfo.f73043k);
            sb5.append("]");
            QLog.w(str2, 2, sb5.toString());
        }
        SessionInfo sessionInfo2 = this.G;
        if (sessionInfo2 != null && ((sessionInfo2.A() || this.G.z()) && (str = this.S) != null && str.equals(this.G.f73091w))) {
            if (getActivity() != null) {
                getActivity().finish();
            }
        } else {
            TraeHelper.n0(this.E);
            ai(d16);
            if (this.f75723j0) {
                Rh(0, 246, d16, true);
            } else {
                Bh(d16, 247, false, true);
            }
        }
    }

    public void Nh(long j3) {
        SessionInfo sessionInfo = this.G;
        if (sessionInfo == null || !sessionInfo.H2) {
            nw.b.e(j3, this.E, this.K, this.Y, this.S);
        }
    }

    public abstract void Oh(int i3);

    protected boolean Ph() {
        return r.h0().X1(this.S);
    }

    public void Sh(long j3, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i(f75713u0, 2, "refuseVideoRequest", new Throwable("refuseVideoRequest"));
        }
        SessionInfo sessionInfo = this.G;
        if (sessionInfo != null && sessionInfo.I2) {
            QLog.d(f75713u0, 1, "refuseVideoRequest NeedNotifyHangupEvent");
            QAVControllerForZplan.p().y(true, this.S);
        }
        this.V.O1();
        TraeHelper.n0(this.E);
        if (this.f75723j0 && !this.f75720g0) {
            Rh(0, 248, j3, z16);
        } else {
            Bh(j3, 249, true, z16);
        }
    }

    public abstract void Vh(String str);

    void Wh() {
        if (QLog.isColorLevel()) {
            QLog.d(f75713u0, 2, "showGAudioDialog");
        }
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.av.ui.fragment.invite.dav.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                VideoInviteBaseFragment.this.Hh(dialogInterface, i3);
            }
        };
        DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener() { // from class: com.tencent.av.ui.fragment.invite.dav.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                VideoInviteBaseFragment.this.Ih(dialogInterface, i3);
            }
        };
        if (getActivity() != null) {
            DialogUtil.createCustomDialog(getActivity(), 230, (String) null, getActivity().getString(R.string.dbj), R.string.icb, R.string.d_d, onClickListener, onClickListener2).show();
        }
    }

    abstract void Xh(b.d dVar);

    abstract void Yh(b.d dVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public void ai(long j3) {
        nw.b.f(j3);
    }

    public abstract void ci(VideoAppInterface videoAppInterface, int i3, String str, String str2, String str3);

    public abstract void di(VideoAppInterface videoAppInterface, int i3, String str, String str2, Bitmap bitmap);

    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        LiveData<Boolean> M1;
        sw.a aVar = this.V;
        if (aVar == null || (M1 = aVar.M1()) == null || !Boolean.FALSE.equals(M1.getValue())) {
            return true;
        }
        long d16 = com.tencent.av.utils.e.d();
        QLog.w(f75713u0, 1, "onKeyDown, seq[" + d16 + "]");
        if (i3 == 25 || i3 == 24) {
            TraeHelper.n0(this.E);
            ai(d16);
            return false;
        }
        if (i3 != 26) {
            return false;
        }
        ai(d16);
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        QLog.d(f75713u0, 1, "onNewIntent()");
        yh(intent);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        QLog.d(f75713u0, 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(getActivity(), 2, true);
        Uh(false);
        r.h0().L3("state", "0");
        if ("0".equals(q.a.f74207a)) {
            r.h0().L3("backgroundReason", "5");
        }
        if (!this.X) {
            ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplication.getContext(), true, 50, 1);
        }
        this.f75723j0 = false;
        this.f75725l0.a(this.E);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        xh("onResume");
        long d16 = com.tencent.av.utils.e.d();
        QLog.w(f75713u0, 1, "onResume, mCheckQAVPermission[" + this.f75727n0 + "], isInLockMode[" + Gh() + "], seq[" + d16 + "]");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.ui.fragment.invite.dav.VideoInviteBaseFragment.1
            @Override // java.lang.Runnable
            public void run() {
                ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(VideoInviteBaseFragment.this.getContext(), 2, false);
                ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(BaseApplication.getContext(), 50, 0);
                ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplication.getContext(), false, 50, 1);
                ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(BaseApplication.getContext(), 50, 2);
            }
        }, 16, null, true);
        Ph();
        this.K = false;
        Uh(true);
        SessionInfo f16 = n.e().f();
        VideoNodeReporter videoNodeReporter = (VideoNodeReporter) this.E.B(4);
        if (videoNodeReporter != null && f16 != null) {
            videoNodeReporter.w(f16.b(), 24, System.currentTimeMillis() - this.E.f73117f0);
        }
        r.h0().g2(VideoInviteActivity.class);
        r.h0().L3("state", "1");
        q.a.f74207a = "0";
        if (!this.f75727n0) {
            this.f75727n0 = true;
            ChatActivityUtils.m(getActivity(), f16 == null || f16.M0, new a(d16));
        }
        if (!Gh()) {
            Nh(d16);
        }
        this.f75723j0 = true;
        this.f75725l0.b(getActivity(), this.E);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        QLog.d(f75713u0, 1, "QAV_COLD_START_COST end: " + System.currentTimeMillis());
        if (Gh()) {
            long d16 = com.tencent.av.utils.e.d();
            if (getActivity() != null && r.h1(getActivity())) {
                Nh(d16);
            }
        }
        this.f75726m0 = System.currentTimeMillis();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        long d16 = com.tencent.av.utils.e.d();
        boolean m3 = ad.m(getContext());
        QLog.w(f75713u0, 1, "avideo onStop, isRingerNormal[" + m3 + "], mIsAccepted[" + this.V.M1().getValue() + "], seq[" + d16 + "]");
        if (m3 && !this.V.M1().getValue().booleanValue()) {
            ai(d16);
        }
        SessionInfo sessionInfo = this.G;
        if (sessionInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.w(f75713u0, 2, "onStop mSessionInfo is null ");
            }
        } else {
            this.f75723j0 = false;
            if (this.W || !sessionInfo.u()) {
                return;
            }
            ei(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        String str;
        String str2;
        int i3;
        String currentAccountUin;
        super.onActivityCreated(bundle);
        long d16 = com.tencent.av.utils.e.d();
        QLog.w(f75713u0, 1, "avideo onViewCreated, seq[" + d16 + "]");
        this.f75721h0 = System.currentTimeMillis();
        this.V = (sw.a) getViewModel(sw.a.class);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.overridePendingTransition(R.anim.f154855e4, 0);
        AVUtil.t(activity.getWindow(), true);
        ImmersiveUtils.setStatusTextColor(true, activity.getWindow());
        AVUtil.u(activity.getWindow());
        if (Eh(activity) && Fh(activity)) {
            String b16 = n.b(this.f75715b0 ? 100 : 3, this.S, new int[0]);
            if (!this.f75715b0) {
                String stringExtra = activity.getIntent().getStringExtra("traceId");
                this.f75718e0 = stringExtra;
                RtcNodeReportReceiverHelper.v(stringExtra);
                if (r.h0() != null && !TextUtils.isEmpty(this.S)) {
                    long currentTimeMillis = System.currentTimeMillis() - r.h0().k0(Long.valueOf(this.S).longValue());
                    if (currentTimeMillis > 5 && currentTimeMillis < 10000) {
                        RtcNodeReportReceiverHelper.t(this.f75718e0, currentTimeMillis);
                        RtcNodeReportReceiverHelper.u(this.f75718e0, "rtc_receiver_page_exposure_new_cost_time_ms", currentTimeMillis);
                        VideoAppInterface videoAppInterface = this.E;
                        long currentTimeMillis2 = System.currentTimeMillis() - (videoAppInterface == null ? 0L : videoAppInterface.f73118g0);
                        if (currentTimeMillis2 < currentTimeMillis) {
                            RtcNodeReportReceiverHelper.u(this.f75718e0, "rtc_receiver_page_exposure_inner_cost_time_ms", currentTimeMillis2);
                        }
                    }
                }
            }
            this.Z = (AudioManager) activity.getSystemService("audio");
            this.G = n.e().i(b16);
            AVCallCompactHelper A = r.h0() == null ? null : r.h0().A();
            if (A != null) {
                A.g(getClass().getName(), activity.getIntent());
            }
            SessionInfo sessionInfo = this.G;
            if (sessionInfo == null || !sessionInfo.u()) {
                if (QLog.isColorLevel()) {
                    String str3 = f75713u0;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("session state error! ");
                    SessionInfo sessionInfo2 = this.G;
                    sb5.append(sessionInfo2 != null ? sessionInfo2.f73043k : -1);
                    QLog.w(str3, 2, sb5.toString());
                }
                SessionInfo sessionInfo3 = this.G;
                if (sessionInfo3 != null && sessionInfo3.K() && (str2 = this.S) != null && str2.equals(this.G.f73091w)) {
                    if (QLog.isColorLevel()) {
                        QLog.w(f75713u0, 2, "onCreate state[" + this.G.f73043k + "], peerUin[" + this.S + "]");
                    }
                } else {
                    SessionInfo sessionInfo4 = this.G;
                    if (sessionInfo4 != null && ((sessionInfo4.A() || this.G.z()) && (str = this.S) != null && str.equals(this.G.f73091w))) {
                        if (QLog.isColorLevel()) {
                            QLog.w(f75713u0, 2, "onCreate state[" + this.G.f73043k + "], peerUin[" + this.S + "]");
                        }
                        activity.finish();
                    } else {
                        Ah(2, 245);
                        return;
                    }
                }
            }
            yh(activity.getIntent());
            if (!r.h0().W0()) {
                VideoAppInterface videoAppInterface2 = this.E;
                TraeHelper.G(videoAppInterface2 != null ? videoAppInterface2.getApp().getApplicationContext() : null);
                ai(d16);
                if (this.G.f73039j == 1) {
                    TraeHelper.I().i0(TraeConstants.VOICE_CALL_CONFIG);
                } else {
                    TraeHelper.I().i0(TraeConstants.VIDEO_CALL_CONFIG);
                }
            }
            VideoAppInterface videoAppInterface3 = this.E;
            if (videoAppInterface3 != null) {
                videoAppInterface3.addObserver(this.f75730q0);
                this.E.addObserver(this.f75731r0);
                this.E.addObserver(this.f75732s0);
            }
            if (r.h0().L() > 0) {
                r.h0().P3(203, this.S);
            } else {
                r.h0().P3(202, this.S);
            }
            this.f75716c0 = ad.f(activity);
            SessionInfo sessionInfo5 = this.G;
            this.R = sessionInfo5.D0;
            this.N = sessionInfo5.B0;
            this.P = sessionInfo5.J0;
            this.Q = sessionInfo5.f73021f0;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("tencent.video.q2v.ACTION_ON_UPDATE_FRIEND_INFO");
            intentFilter.addAction("tencent.video.q2v.sdk.onRequestVideo");
            intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
            intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_ON);
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            g gVar = new g();
            this.f75719f0 = gVar;
            activity.registerReceiver(gVar, intentFilter);
            Intent intent = activity.getIntent();
            if (intent != null) {
                if (intent.getBooleanExtra(ReportConst.ACTION.FULLSCREEN, false)) {
                    VideoRecoveryReporter.d();
                }
                i3 = intent.getIntExtra("inviteScene", 0);
            } else {
                i3 = 0;
            }
            boolean z16 = i3 == 2;
            this.J = z16;
            SessionInfo sessionInfo6 = this.G;
            sessionInfo6.f73004b0 = i3;
            sessionInfo6.f73102y2 = z16;
            sessionInfo6.H2 = intent != null && intent.getBooleanExtra("isInZplanHome", false);
            this.G.I2 = intent != null && intent.getBooleanExtra("needNotifyHangupEvent", false);
            if (!this.W && this.G.u() && !this.G.H2) {
                ei(false);
            }
            if (!this.G.H2) {
                activity.setRequestedOrientation(1);
            }
            initUI();
            activity.setTitle(this.T + getString(R.string.f170486sm));
            int i16 = this.G.f73067q;
            if (i16 == 21 || i16 == 1011) {
                this.V.L1();
                wh(com.tencent.av.utils.e.d());
            }
            this.f75722i0 = true;
            if (this.G.H2) {
                QAVControllerForZplan.p().Q((VideoInviteActivity) activity, this.E);
                activity.onBackPressed();
            }
            VideoAppInterface videoAppInterface4 = this.E;
            if (videoAppInterface4 == null) {
                currentAccountUin = "";
            } else {
                currentAccountUin = videoAppInterface4.getCurrentAccountUin();
            }
            Dh(currentAccountUin, this.S, this.G.G);
            QLog.w(f75713u0, 1, "avideo onCreateView end");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w(f75713u0, 2, "init param failure.");
        }
        this.W = true;
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        QLog.d(f75713u0, 1, "onViewCreatedAfterPartInit...");
        Xh(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        Th();
    }

    public void refreshUI() {
        QLog.d(f75713u0, 1, "refreshUI", new Throwable());
        SessionInfo sessionInfo = this.G;
        if (sessionInfo == null) {
            return;
        }
        String str = this.S;
        int i3 = this.M;
        if (sessionInfo.B0 == 1 && i3 == 9500 && !TextUtils.isEmpty(sessionInfo.D0)) {
            str = this.G.D0;
            i3 = 0;
        }
        di(this.E, i3, str, this.U, null);
        if (k.x9(this.E, this.G.f73043k, str)) {
            Ch(false);
        } else if (getActivity() != null && !nw.b.d(this.I, getActivity())) {
            VideoAppInterface videoAppInterface = this.E;
            SessionInfo sessionInfo2 = this.G;
            ci(videoAppInterface, i3, sessionInfo2.f73091w, sessionInfo2.f73103z, sessionInfo2.B);
        }
        String G = this.E.G(i3, str, this.U);
        this.T = G;
        Vh(G);
    }

    public void wh(long j3) {
        if (zh()) {
            boolean z16 = this.I || this.H;
            FragmentActivity activity = getActivity();
            if (ChatActivityUtils.m(activity, z16, new b(j3))) {
                if (QLog.isDevelopLevel()) {
                    QLog.i(f75713u0, 2, "acceptVideoRequest");
                }
                if (activity != null) {
                    nw.b.a(activity);
                    activity.sendBroadcast(new Intent("tencent.video.v2g.match_friend.exit_voice_chat"));
                }
                if (r.h0().W0()) {
                    Wh();
                } else {
                    Zh();
                }
                TraeHelper.n0(this.E);
                ai(j3);
            }
        }
    }

    public void xh(String str) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        boolean g16 = r.g1(context);
        if (QLog.isColorLevel()) {
            QLog.i(f75713u0, 2, "checkAndSwitchMode isLocked[" + g16 + "], cur[" + this.C + "], destroy[" + this.f75724k0 + "], from[" + str + "]");
        }
        if (this.f75724k0 || this.C == g16 || getActivity() == null) {
            return;
        }
        ((VideoInviteActivity) getActivity()).init();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class e extends lu.b {
        e() {
        }

        @Override // lu.b
        public void a(boolean z16, Object obj) {
            if (!z16 || VideoInviteBaseFragment.this.getActivity() == null || VideoInviteBaseFragment.this.getActivity().isFinishing() || !(obj instanceof String)) {
                return;
            }
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            cw.e.p(VideoInviteBaseFragment.this.E, 3023, str);
        }
    }

    private void initUI() {
        this.F = 1;
        if (!NetworkUtil.isWifiConnected(getContext()) && !NetworkUtil.isBluetoothSharedNetwork(getContext())) {
            this.F = 2;
        }
        refreshUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bh(long j3, int i3, boolean z16, boolean z17) {
        if (!z16) {
            this.V.O1();
        }
        if (this.f75715b0) {
            if (z16) {
                r.h0().g(j3, this.S, 1, true);
            }
            long g16 = i.g(this.S);
            r.h0().P0(j3, 3, g16);
            if (!this.f75714a0 || z16) {
                this.f75714a0 = true;
                r.h0().o(j3, g16, z16 ? 1 : 2);
            }
            this.W = true;
            if (getActivity() != null) {
                getActivity().finish();
                return;
            }
            return;
        }
        if (z16) {
            r.h0().g(j3, this.S, 1, false);
        }
        r.h0().r(this.S, i3);
        r.h0().j2(i3);
        if (z17) {
            r.h0().q(this.S, z16 ? 1 : 0);
        }
    }

    private void Zh() {
        if (QLog.isColorLevel()) {
            QLog.d(f75713u0, 2, "startVideoChatActivity");
        }
        TraeHelper.I().F();
        if (r.h0().d1()) {
            this.E.k0(new Object[]{113});
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            QLog.e(f75713u0, 1, "startVideoChatActivity error: activity is null.");
            return;
        }
        Intent intent = new Intent(activity.getApplicationContext(), (Class<?>) AVActivity.class);
        intent.addFlags(262144);
        SessionInfo sessionInfo = this.G;
        intent.putExtra("needNotifyHangupEvent", sessionInfo != null && sessionInfo.I2);
        intent.putExtra("uin", this.S);
        intent.putExtra("name", this.T);
        intent.putExtra("isSender", false);
        if (this.f75715b0) {
            intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 3);
            intent.putExtra("Type", 1);
            intent.putExtra("uinType", 0);
            intent.putExtra("isDoubleVideoMeeting", true);
            intent.putExtra("inviteUin", this.S);
            intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 1);
            intent.putExtra("isEnter", true);
        } else {
            RtcNodeReportReceiverHelper.s(this.f75718e0, 1, NodeModel$NodeEndReason.K_NORMAL.ordinal());
            intent.putExtra("uinType", this.M);
            intent.putExtra("bindType", this.N);
            intent.putExtra("bindId", this.R);
            intent.putExtra("extraUin", this.U);
            intent.putExtra("receive", true);
            intent.putExtra("isAudioMode", this.I);
            intent.putExtra(PreloadTRTCPlayerParams.KEY_SIG, this.P);
            intent.putExtra("subServiceType", this.Q);
            if (activity.getIntent() != null && !this.H && ax.a.c(this.E)) {
                int intExtra = activity.getIntent().getIntExtra("inviteScene", 0);
                intent.putExtra("inviteScene", intExtra);
                if (intExtra == 2) {
                    ReportController.o(null, "dc00898", "", "", "0X800C438", "0X800C438", 0, 0, "7", "", "", "");
                }
            }
            if (QLog.isColorLevel()) {
                String str = f75713u0;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("startVideoChatActivity: mBindType = ");
                sb5.append(this.N);
                sb5.append(",mBindId = ");
                sb5.append(this.R);
                sb5.append(",BindType = ");
                SessionInfo sessionInfo2 = this.G;
                sb5.append(sessionInfo2 == null ? -1 : sessionInfo2.B0);
                QLog.d(str, 2, sb5.toString());
            }
            if (this.M == 0) {
                intent.putExtra(IProfileProtocolConst.PARAM_IS_FRIEND, this.E.isFriend(this.S));
            }
            if (this.I) {
                intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 1);
            } else {
                intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 2);
            }
            intent.putExtra("shutCamera", this.H);
        }
        activity.startActivity(intent);
        this.W = false;
        this.X = true;
        activity.finish();
        activity.overridePendingTransition(R.anim.f154855e4, R.anim.f154854e3);
    }

    private void ei(boolean z16) {
        if (this.f75733t0 == null) {
            this.f75733t0 = QAVNotification.l(this.E);
        }
        if (this.G == null) {
            return;
        }
        boolean z17 = AVUtil.p() ? z16 : true;
        if (QLog.isColorLevel()) {
            QLog.i("QAVNotification", 2, "updateInviteNotification show[" + z17 + "], mIsAudioMode[" + this.I + "], isOnlyAudio[" + this.G.M0 + "], session[" + this.G + "]");
        }
        if (z17) {
            Bitmap J = this.E.J(this.M, this.S, this.U, true, true);
            String G = this.E.G(this.M, this.S, this.U);
            this.T = G;
            SessionInfo sessionInfo = this.G;
            if (sessionInfo.M0) {
                this.f75733t0.b(true, sessionInfo.f73030h, G, J, null, 45, this.M, 1, this.f75718e0);
                return;
            } else {
                this.f75733t0.b(true, sessionInfo.f73030h, G, J, null, 40, this.M, 2, this.f75718e0);
                return;
            }
        }
        this.f75733t0.f(this.G.f73030h);
    }

    public void Jh(boolean z16) {
        if (z16) {
            this.f75728o0 = SystemClock.elapsedRealtime();
        } else {
            this.f75729p0 = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        long d16 = com.tencent.av.utils.e.d();
        QLog.w(f75713u0, 1, "avideo onDestroy, seq[" + d16 + "]");
        if (this.J && ax.a.c(this.E)) {
            ReportController.o(null, "dc00898", "", "", "0X800C43F", "0X800C43F", 0, 0, ((int) (System.currentTimeMillis() - this.f75726m0)) + "", "", "", "");
        }
        QZoneVideoContactsFeedHelper.d();
        com.tencent.av.business.manager.report.a.b(this.f75721h0);
        this.f75721h0 = -1L;
        bd bdVar = this.D;
        if (bdVar != null) {
            bdVar.c();
            this.D = null;
        }
        this.E.deleteObserver(this.f75730q0);
        this.E.deleteObserver(this.f75731r0);
        this.E.removeObserver(this.f75732s0);
        if (this.f75719f0 != null) {
            if (getActivity() != null) {
                getActivity().unregisterReceiver(this.f75719f0);
            }
            this.f75719f0 = null;
        }
        ai(d16);
        TraeHelper.n0(this.E);
        this.D = null;
        this.f75733t0 = null;
        this.Z = null;
        this.f75730q0 = null;
        this.f75731r0 = null;
        this.f75732s0 = null;
        this.G = null;
        this.f75724k0 = true;
        AVUtil.e(getActivity());
        AVUtil.d(getContext());
        bi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qh() {
        Rh(0, 0, 0L, false);
    }

    private void yh(Intent intent) {
        if (intent == null) {
            return;
        }
        if (ag.b(intent)) {
            DataReport.T(null, "dc00898", "", "", "0X800A2C5", "0X800A2C5", 0, 0, "", "", "", "");
        }
        long d16 = com.tencent.av.utils.e.d();
        String action = intent.getAction();
        if ("com.tencent.qav.notify.accept".equals(action)) {
            String stringExtra = intent.getStringExtra(ServiceConst.PARA_SESSION_ID);
            SessionInfo sessionInfo = this.G;
            String str = sessionInfo == null ? null : sessionInfo.f73030h;
            if (TextUtils.equals(stringExtra, str)) {
                wh(d16);
            } else if (QLog.isColorLevel()) {
                QLog.i(f75713u0, 2, "checkParamAndDoAction not same , coming[" + stringExtra + "], cur[" + str + "]");
            }
            DataReport.T(null, "dc00898", "", "", "0X800A2C6", "0X800A2C6", 0, 0, "", "", "", "");
        } else if ("com.tencent.qav.notify.refuse".equals(action)) {
            Sh(d16, true);
        }
        if (QLog.isColorLevel()) {
            QLog.i(f75713u0, 2, "checkParamAndDoAction action[" + action + "], seq[" + d16 + "]");
        }
    }

    public void onBackPressed() {
    }
}
