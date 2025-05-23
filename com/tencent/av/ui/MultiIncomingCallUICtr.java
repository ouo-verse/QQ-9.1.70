package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.at;
import com.tencent.av.utils.ba;
import com.tencent.avcore.jni.audiodevice.TraeConstants;
import com.tencent.avcore.rtc.node.report.data.NodeModel$NodeEndReason;
import com.tencent.avcore.rtc.node.report.utils.RtcNodeReportReceiverHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MultiIncomingCallUICtr extends BaseInviteFloatBarUICtr {
    QAVNotification A;

    /* renamed from: v, reason: collision with root package name */
    boolean f74876v;

    /* renamed from: y, reason: collision with root package name */
    Intent f74879y;

    /* renamed from: r, reason: collision with root package name */
    com.tencent.av.n f74872r = com.tencent.av.n.e();

    /* renamed from: s, reason: collision with root package name */
    boolean f74873s = false;

    /* renamed from: t, reason: collision with root package name */
    int f74874t = 0;

    /* renamed from: u, reason: collision with root package name */
    int f74875u = -1;

    /* renamed from: w, reason: collision with root package name */
    String f74877w = "";

    /* renamed from: x, reason: collision with root package name */
    Runnable f74878x = null;

    /* renamed from: z, reason: collision with root package name */
    boolean f74880z = false;
    String B = TraeConstants.VIDEO_CALL_CONFIG;
    private BroadcastReceiver C = new BroadcastReceiver() { // from class: com.tencent.av.ui.MultiIncomingCallUICtr.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            long a16 = at.a(intent);
            if (action.equals("tencent.av.EXIT_QZONE_LIVE_RSP_ACTION")) {
                MultiIncomingCallUICtr multiIncomingCallUICtr = MultiIncomingCallUICtr.this;
                if (multiIncomingCallUICtr.f74729f == 1) {
                    multiIncomingCallUICtr.f74725b.M().postDelayed(new Runnable() { // from class: com.tencent.av.ui.MultiIncomingCallUICtr.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MultiIncomingCallUICtr.this.o();
                            VideoInviteFloatBar videoInviteFloatBar = MultiIncomingCallUICtr.this.f74737n;
                            if (videoInviteFloatBar != null) {
                                videoInviteFloatBar.b();
                            }
                        }
                    }, 500L);
                    return;
                }
                MultiIncomingCallUICtr.this.f(a16, com.tencent.av.n.e().f());
                MultiIncomingCallUICtr.this.f74725b.k0(new Object[]{67, Long.valueOf(MultiIncomingCallUICtr.this.f74726c), 3});
                VideoInviteFloatBar videoInviteFloatBar = MultiIncomingCallUICtr.this.f74737n;
                if (videoInviteFloatBar != null) {
                    videoInviteFloatBar.b();
                    return;
                }
                return;
            }
            if (action.equals("tencent.video.invite.multiaccept")) {
                MultiIncomingCallUICtr.this.f(a16, com.tencent.av.n.e().f());
            } else {
                if (action.equals("tencent.video.invite.multirefuse")) {
                    if (!MultiIncomingCallUICtr.this.i(0)) {
                        MultiIncomingCallUICtr.this.k(a16, true, null);
                        return;
                    }
                    return;
                }
                action.equals("tencent.video.destroyService");
            }
        }
    };
    GAudioUIObserver D = new GAudioUIObserver() { // from class: com.tencent.av.ui.MultiIncomingCallUICtr.3
        @Override // com.tencent.av.app.GAudioUIObserver
        protected void A(long j3, long j16, String str) {
            if (QLog.isColorLevel()) {
                QLog.d("MultiIncomingCallUICtr.troopgroup_vedio.invite", 2, "groupId:" + j3 + ", memUin:" + j16 + ",invitedId:" + str + ", mInviterUin:" + MultiIncomingCallUICtr.this.f74731h + ", mGroupId:" + MultiIncomingCallUICtr.this.f74726c);
            }
            MultiIncomingCallUICtr multiIncomingCallUICtr = MultiIncomingCallUICtr.this;
            if (j16 == multiIncomingCallUICtr.f74731h && j3 == multiIncomingCallUICtr.f74726c) {
                multiIncomingCallUICtr.b();
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void b(long j3) {
            if (QLog.isColorLevel()) {
                QLog.d("MultiIncomingCallUICtr", 2, "notifyCloseAllGroupVideoInviteMsgBox-->GroupID=" + j3);
            }
            MultiIncomingCallUICtr multiIncomingCallUICtr = MultiIncomingCallUICtr.this;
            if (multiIncomingCallUICtr.f74726c != j3) {
                multiIncomingCallUICtr.i(0);
            }
            MultiIncomingCallUICtr.this.b();
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void c(long j3) {
            if (QLog.isColorLevel()) {
                QLog.d("MultiIncomingCallUICtr", 2, "notifyCloseGroupVideoInviteMsgBox-->GroupID=" + j3);
            }
            MultiIncomingCallUICtr multiIncomingCallUICtr = MultiIncomingCallUICtr.this;
            if (multiIncomingCallUICtr.f74726c == j3) {
                multiIncomingCallUICtr.b();
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void d(long j3, String str) {
            if (QLog.isColorLevel()) {
                QLog.d("MultiIncomingCallUICtr", 2, "notifyCloseGroupVideoInviteMsgBoxByInviteId-->GroupID=" + j3);
            }
            MultiIncomingCallUICtr multiIncomingCallUICtr = MultiIncomingCallUICtr.this;
            if (multiIncomingCallUICtr.f74726c == j3 && multiIncomingCallUICtr.f74877w.equals(str)) {
                MultiIncomingCallUICtr.this.b();
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void g(long j3, long j16) {
            if (QLog.isColorLevel()) {
                QLog.d("MultiIncomingCallUICtr", 2, "onCreateRoomSuc-->GroupID=" + j16);
            }
            MultiIncomingCallUICtr multiIncomingCallUICtr = MultiIncomingCallUICtr.this;
            multiIncomingCallUICtr.f74734k.f73097x1 = true;
            if (multiIncomingCallUICtr.f74729f == 1) {
                multiIncomingCallUICtr.f74725b.V(j16);
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void h(long j3, int i3) {
            MultiIncomingCallUICtr multiIncomingCallUICtr = MultiIncomingCallUICtr.this;
            if (multiIncomingCallUICtr.f74873s) {
                long d16 = com.tencent.av.utils.e.d();
                if (QLog.isColorLevel()) {
                    QLog.w("MultiIncomingCallUICtr", 1, "onDestroyInviteUI, groupId[" + j3 + "], mPeerUin[" + MultiIncomingCallUICtr.this.f74735l + "], seq[" + d16 + "]");
                }
                String str = MultiIncomingCallUICtr.this.f74735l;
                if (str != null && str.equals(String.valueOf(j3))) {
                    MultiIncomingCallUICtr.this.h(d16, i3);
                    MultiIncomingCallUICtr.this.b();
                }
            } else if (multiIncomingCallUICtr.f74726c == j3 || 0 == j3) {
                multiIncomingCallUICtr.b();
            }
            if (QLog.isColorLevel()) {
                QLog.d("MultiIncomingCallUICtr", 2, "onDestroyInviteUI, groupId:" + j3 + ", reason:" + i3 + ", mGroupId:" + MultiIncomingCallUICtr.this.f74726c);
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void k(long j3, final long j16) {
            if (QLog.isColorLevel()) {
                QLog.w("MultiIncomingCallUICtr", 1, "onEnterRoomSuc, groupId[" + j16 + "], seq[" + j3 + "]");
            }
            MultiIncomingCallUICtr.this.f74725b.M().postDelayed(new Runnable() { // from class: com.tencent.av.ui.MultiIncomingCallUICtr.3.1
                @Override // java.lang.Runnable
                public void run() {
                    MultiIncomingCallUICtr multiIncomingCallUICtr = MultiIncomingCallUICtr.this;
                    multiIncomingCallUICtr.f74734k.f73097x1 = true;
                    if (multiIncomingCallUICtr.f74729f == 1) {
                        multiIncomingCallUICtr.f74725b.V(j16);
                    }
                }
            }, 500L);
            MultiIncomingCallUICtr.this.g();
            SmallScreenActivityPlugin.a(MultiIncomingCallUICtr.this.f74725b).f(j3, false);
            VideoInviteFloatBar videoInviteFloatBar = MultiIncomingCallUICtr.this.f74737n;
            if (videoInviteFloatBar != null) {
                videoInviteFloatBar.d();
            }
            MultiIncomingCallUICtr.this.f74725b.M().postDelayed(MultiIncomingCallUICtr.this.F, 1000L);
            TraeHelper.I().i0(MultiIncomingCallUICtr.this.B);
        }
    };
    VideoObserver E = new a();
    Runnable F = new Runnable() { // from class: com.tencent.av.ui.MultiIncomingCallUICtr.5
        @Override // java.lang.Runnable
        public void run() {
            String formatTime = ba.formatTime(com.tencent.av.r.h0().K());
            VideoInviteFloatBar videoInviteFloatBar = MultiIncomingCallUICtr.this.f74737n;
            if (videoInviteFloatBar != null) {
                videoInviteFloatBar.j(formatTime);
                if (com.tencent.av.r.h0().K() % 60 >= 1) {
                    MultiIncomingCallUICtr.this.f74737n.b();
                    MultiIncomingCallUICtr.this.b();
                } else {
                    MultiIncomingCallUICtr.this.f74725b.M().postDelayed(this, 1000L);
                }
            }
        }
    };

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends VideoObserver {
        a() {
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void e(long j3, int i3, String str) {
            String str2 = MultiIncomingCallUICtr.this.f74735l;
            if (str2 != null && str2.equals(str)) {
                MultiIncomingCallUICtr.this.h(j3, i3);
                MultiIncomingCallUICtr.this.b();
            }
            if (QLog.isColorLevel()) {
                QLog.w("MultiIncomingCallUICtr", 1, "onClose, reason[" + i3 + "], peerUin[" + str + "], mPeerUin[" + MultiIncomingCallUICtr.this.f74735l + "], seq[" + j3 + "]");
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void g(long j3) {
            if (QLog.isColorLevel()) {
                QLog.w("MultiIncomingCallUICtr", 1, "onConnected, seq[" + j3 + "]");
            }
            com.tencent.av.r.h0().K3();
            SmallScreenActivityPlugin.a(MultiIncomingCallUICtr.this.f74725b).f(j3, false);
            VideoInviteFloatBar videoInviteFloatBar = MultiIncomingCallUICtr.this.f74737n;
            if (videoInviteFloatBar != null) {
                videoInviteFloatBar.d();
            }
            MultiIncomingCallUICtr multiIncomingCallUICtr = MultiIncomingCallUICtr.this;
            if (multiIncomingCallUICtr.f74734k.f73035i == 1) {
                multiIncomingCallUICtr.B = TraeConstants.VOICE_CALL_CONFIG;
            }
            TraeHelper.I().i0(MultiIncomingCallUICtr.this.B);
            MultiIncomingCallUICtr.this.f74725b.M().postDelayed(MultiIncomingCallUICtr.this.F, 1000L);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.VideoObserver
        public void h(String str, boolean z16) {
            super.h(str, z16);
            VideoInviteFloatBar videoInviteFloatBar = MultiIncomingCallUICtr.this.f74737n;
            if (videoInviteFloatBar != null) {
                videoInviteFloatBar.b();
            }
            MultiIncomingCallUICtr.this.b();
            if (QLog.isColorLevel()) {
                QLog.d("MultiIncomingCallUICtr", 2, "onDestroyUI, peerUin:" + str + ", isQuit:" + z16 + ", mPeerUin:" + MultiIncomingCallUICtr.this.f74735l);
            }
        }
    }

    public MultiIncomingCallUICtr(VideoAppInterface videoAppInterface, Intent intent) {
        this.f74725b = videoAppInterface;
        this.f74879y = intent;
    }

    @Override // com.tencent.av.ui.BaseInviteFloatBarUICtr
    public void b() {
        super.b();
        VideoAppInterface videoAppInterface = this.f74725b;
        if (videoAppInterface != null) {
            try {
                videoAppInterface.getApplication().unregisterReceiver(this.C);
                this.f74725b.deleteObserver(this.D);
                this.f74725b.deleteObserver(this.E);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("MultiIncomingCallUICtr", 2, "onDestroy error : " + e16);
                }
            }
            if (this.f74878x != null) {
                this.f74725b.M().removeCallbacks(this.f74878x);
                this.f74878x = null;
            }
            if (this.F != null) {
                this.f74725b.M().removeCallbacks(this.F);
                this.F = null;
            }
        }
    }

    @Override // com.tencent.av.ui.BaseInviteFloatBarUICtr
    void c() {
        if (!i(0)) {
            k(-1036L, true, null);
        }
    }

    void f(long j3, SessionInfo sessionInfo) {
        if (QLog.isColorLevel()) {
            QLog.w("MultiIncomingCallUICtr", 1, "acceptRequest, seq[" + j3 + "]");
        }
        this.f74880z = true;
        SessionInfo f16 = com.tencent.av.n.e().f();
        boolean z16 = false;
        if (sessionInfo != null && f16 == sessionInfo) {
            if (com.tencent.av.n.e().c() >= 2) {
                if (sessionInfo.u()) {
                    k(j3, false, sessionInfo);
                } else {
                    com.tencent.av.r.h0().p(true, 201, f16.f73063p);
                    com.tencent.av.r.h0().j2(201);
                }
                p(sessionInfo);
            } else if (QLog.isColorLevel()) {
                QLog.d("MultiIncomingCallUICtr", 2, "no need to close main session because there is only one session");
            }
        } else if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("mainSession invalid when accept 3rd request, currMainSession == mainSessionInfo:");
            if (f16 == sessionInfo) {
                z16 = true;
            }
            sb5.append(z16);
            QLog.d("MultiIncomingCallUICtr", 2, sb5.toString());
        }
        SessionInfo sessionInfo2 = this.f74734k;
        if (sessionInfo2 != null) {
            if (!sessionInfo2.u()) {
                if (QLog.isColorLevel()) {
                    QLog.d("MultiIncomingCallUICtr", 2, "Session already destroyed, id:" + this.f74734k.f73030h + ", status = " + this.f74734k.f73043k);
                }
            } else if (AVUtil.o(this.f74729f)) {
                com.tencent.av.r.h0().a(j3, this.f74730g, this.f74734k.P0, this.f74732i, false);
                ReportController.o(null, "CliOper", "", "", "0X8008B2B", "0X8008B2B", 0, 0, "", "", "", "");
            } else {
                int i3 = !this.f74733j ? 1 : 0;
                if (QLog.isColorLevel()) {
                    QLog.d("MultiIncomingCallUICtr", 2, "appType :" + i3);
                }
                if (this.f74873s) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MultiIncomingCallUICtr", 2, "acceptVideoRequest isDoubleVideoMeeting");
                    }
                    com.tencent.av.r.h0().a(j3, 3, Long.valueOf(this.f74734k.f73091w).longValue(), null, false);
                    ReportController.o(null, "CliOper", "", "", "0X8008B2B", "0X8008B2B", 0, 0, "", "", "", "");
                } else {
                    RtcNodeReportReceiverHelper.s(this.f74734k.r("MultiIncomingInviteFloat_accept"), 1, NodeModel$NodeEndReason.K_NORMAL.ordinal());
                    com.tencent.av.r.h0().b(j3, this.f74735l, i3, ba.avRalationType2DAVRelationType(this.f74730g));
                    if (this.f74733j) {
                        ReportController.o(null, "CliOper", "", "", "0X8008B24", "0X8008B24", 0, 0, "", "", "", "");
                    } else {
                        ReportController.o(null, "CliOper", "", "", "0X8008B27", "0X8008B27", 0, 0, "", "", "", "");
                    }
                }
                a();
            }
            VideoInviteFloatBar videoInviteFloatBar = this.f74737n;
            if (videoInviteFloatBar != null) {
                videoInviteFloatBar.g(HardCodeUtil.qqStr(R.string.obt));
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MultiIncomingCallUICtr", 2, "session invalid when accept request");
        }
    }

    void g() {
        if (this.A == null) {
            this.A = QAVNotification.l(this.f74725b);
        }
        if (!AVUtil.o(this.f74729f)) {
            Bitmap J = this.f74725b.J(this.f74729f, this.f74735l, this.f74736m, true, true);
            if (!this.f74733j && !this.f74873s) {
                this.A.c(this.f74734k.f73030h, this.f74727d, J, null, 56, this.f74729f, 2);
                return;
            } else {
                this.A.c(this.f74734k.f73030h, this.f74727d, J, null, 55, this.f74729f, 1);
                return;
            }
        }
        String valueOf = String.valueOf(this.f74726c);
        Bitmap J2 = this.f74725b.J(this.f74729f, valueOf, null, true, true);
        String G = this.f74725b.G(AVUtil.g(this.f74729f), Long.toString(this.f74731h), valueOf);
        SessionInfo sessionInfo = this.f74734k;
        if (sessionInfo != null) {
            this.A.c(sessionInfo.f73030h, G, J2, valueOf, 57, this.f74729f, 3);
        }
    }

    void h(long j3, int i3) {
        if (com.tencent.av.r.h0() == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w("MultiIncomingCallUICtr", 1, "closeSession, reason[" + i3 + "], seq[" + j3 + "]");
        }
        long g16 = com.tencent.av.utils.i.g(this.f74735l);
        if (this.f74873s) {
            if (i3 == 1) {
                com.tencent.av.r.h0().o(j3, g16, 7);
                return;
            } else {
                if (i3 == 2) {
                    com.tencent.av.r.h0().o(j3, g16, 2);
                    return;
                }
                return;
            }
        }
        com.tencent.av.r.h0().r(this.f74734k.f73091w, 243);
        com.tencent.av.r.h0().j2(243);
    }

    boolean i(int i3) {
        if (this.f74729f == 1 && !TextUtils.isEmpty(this.f74877w)) {
            Intent intent = new Intent("tencent.video.v2q.ACTION_DEAL_INVITE_TO_ENTER_GROUP_VEDIO");
            intent.putExtra("relationId", this.f74726c + "");
            intent.putExtra("dealResult", i3);
            intent.putExtra("inviteId", this.f74877w);
            intent.putExtra("friendUin", this.f74731h);
            intent.setPackage(this.f74725b.getApp().getPackageName());
            this.f74725b.getApp().sendBroadcast(intent);
            if (QLog.isDevelopLevel()) {
                QLog.d("MultiIncomingCallUICtr", 2, "sendBroadcast, qav_gaudio_join");
            }
            return true;
        }
        return false;
    }

    void j(long j3, int i3, long j16, boolean z16, int i16, boolean z17) {
        VideoAppInterface videoAppInterface;
        if (com.tencent.av.r.h0() == null) {
            return;
        }
        if (!z17) {
            com.tencent.av.r.h0().Q0(j3, i3, j16, 10, false);
        } else {
            com.tencent.av.r.h0().Q0(j3, i3, j16, i16, false);
        }
        if (z16 && (videoAppInterface = this.f74725b) != null) {
            videoAppInterface.k0(new Object[]{67, Long.valueOf(j16), 3});
        }
        ReportController.o(null, "CliOper", "", "", "0X8008B2C", "0X8008B2C", 0, 0, "", "", "", "");
        b();
    }

    void k(long j3, boolean z16, SessionInfo sessionInfo) {
        l(j3, z16, sessionInfo, -1);
    }

    void l(long j3, boolean z16, SessionInfo sessionInfo, int i3) {
        boolean z17 = false;
        if (z16) {
            this.f74880z = false;
        }
        TraeHelper.n0(this.f74725b);
        String str = this.f74735l;
        boolean z18 = this.f74873s;
        int i16 = this.f74730g;
        long j16 = this.f74726c;
        if (!z16) {
            if (sessionInfo != null) {
                str = sessionInfo.f73091w;
                if (TextUtils.isEmpty(str)) {
                    str = sessionInfo.Y0;
                }
                z18 = sessionInfo.f73060o0;
                i16 = sessionInfo.S0;
                j16 = sessionInfo.P0;
            } else {
                return;
            }
        }
        long j17 = j16;
        String str2 = str;
        int i17 = i16;
        boolean z19 = z18;
        int avRelationType2UinType = ba.avRelationType2UinType(i17);
        if (!z16 && (z19 || n(avRelationType2UinType))) {
            z17 = true;
        }
        boolean z26 = z17;
        if (AVUtil.o(avRelationType2UinType)) {
            j(j3, i17, j17, z26, i3, z16);
        } else {
            t(j3, z19, str2, z26, z16);
        }
    }

    boolean m() {
        if (QLog.isColorLevel()) {
            QLog.d("MultiIncomingCallUICtr", 2, "initEnvParam");
        }
        if (this.f74725b != null && com.tencent.av.r.h0() != null) {
            if (com.tencent.av.n.e().f().w() || com.tencent.av.n.e().f().x()) {
                if (QLog.isColorLevel()) {
                    QLog.d("MultiIncomingCallUICtr", 2, "initEnvParam closeSession");
                }
                com.tencent.av.r.h0().q(com.tencent.av.n.e().f().f73091w, 2);
            }
            return true;
        }
        return false;
    }

    boolean n(int i3) {
        if (i3 == 3000) {
            return true;
        }
        return false;
    }

    void o() {
        Intent intent = new Intent("tencent.video.v2q.ACTION_ENTER_GROUP_VEDIO");
        intent.putExtra("relationId", this.f74726c + "");
        intent.putExtra("enterType", 1);
        intent.setPackage(this.f74725b.getApp().getPackageName());
        this.f74725b.getApp().sendBroadcast(intent);
        if (QLog.isDevelopLevel()) {
            QLog.d("MultiIncomingCallUICtr.troopgroup_vedio.invite", 2, "sendBroadcast, qav_gaudio_answer");
        }
        this.f74725b.k0(new Object[]{514, Long.valueOf(this.f74726c)});
        i(1);
    }

    void p(SessionInfo sessionInfo) {
        if (com.tencent.av.r.h0() != null && sessionInfo != null) {
            Intent intent = new Intent();
            intent.setPackage(this.f74725b.getApp().getPackageName());
            intent.setAction("tencent.av.v2q.StopVideoChat");
            intent.putExtra("stopReason3rd", 1);
            intent.putExtra("groupId", sessionInfo.P0);
            intent.putExtra("peerUin", sessionInfo.f73091w);
            this.f74725b.getApp().sendBroadcast(intent);
        }
    }

    public void q() {
        if (QLog.isColorLevel()) {
            QLog.d("MultiIncomingCallUICtr", 2, "onCreate start");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.NEW_OUTGOING_CALL");
        intentFilter.addAction("tencent.video.invite.multiaccept");
        intentFilter.addAction("tencent.video.invite.multirefuse");
        intentFilter.addAction("tencent.av.EXIT_QZONE_LIVE_RSP_ACTION");
        intentFilter.addAction("tencent.video.destroyService");
        this.f74725b.getApplication().registerReceiver(this.C, intentFilter);
    }

    public int r(Intent intent) {
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.w("MultiIncomingCallUICtr", 1, "onStartCommand, seq[" + d16 + "]");
        }
        m();
        s(d16, intent);
        return 2;
    }

    void s(long j3, Intent intent) {
        if (intent == null) {
            return;
        }
        this.f74735l = intent.getStringExtra("peerUin");
        this.f74736m = intent.getStringExtra("extraUin");
        this.f74873s = intent.getBooleanExtra("isDoubleVideoMeeting", false);
        this.f74729f = intent.getIntExtra("uinType", 0);
        this.f74730g = intent.getIntExtra("relationType", 3);
        this.f74875u = intent.getIntExtra("memberType", -1);
        this.f74876v = intent.getBooleanExtra("hasGVideoJoined", false);
        this.f74733j = intent.getBooleanExtra("isAudioMode", false);
        this.f74874t = intent.getIntExtra("bindType", 0);
        if (AVUtil.o(this.f74729f)) {
            if (intent.getIntExtra("MultiAVType", -1) == 2) {
                this.f74733j = false;
            } else {
                this.f74733j = true;
            }
            this.f74731h = intent.getLongExtra("friendUin", 0L);
            this.f74877w = intent.getStringExtra("inviteId");
            long longExtra = intent.getLongExtra("discussId", 0L);
            this.f74726c = longExtra;
            this.f74734k = this.f74872r.i(com.tencent.av.n.b(this.f74730g, String.valueOf(longExtra), new int[0]));
            this.f74732i = intent.getLongArrayExtra("memberList");
            this.f74725b.addObserver(this.D);
        } else if (this.f74873s) {
            String b16 = com.tencent.av.n.b(100, this.f74735l, new int[0]);
            if (QLog.isColorLevel()) {
                QLog.d("MultiIncomingCallUICtr", 2, "sessionId : " + b16);
            }
            this.f74733j = false;
            SessionInfo i3 = com.tencent.av.n.e().i(b16);
            this.f74734k = i3;
            if (i3 != null) {
                i3.p0(j3, "processIntent.1", 4);
                this.f74734k.y0("processIntent", true);
                SessionInfo sessionInfo = this.f74734k;
                sessionInfo.B1 = true;
                sessionInfo.G = true;
                sessionInfo.f73084u0 = this.f74725b.isFriend(this.f74735l);
            }
            this.f74725b.addObserver(this.D);
        } else {
            RtcNodeReportReceiverHelper.v(intent.getStringExtra("traceId"));
            SessionInfo i16 = com.tencent.av.n.e().i(com.tencent.av.n.b(3, this.f74735l, new int[0]));
            this.f74734k = i16;
            if (i16 != null) {
                if (this.f74733j) {
                    i16.p0(j3, "processIntent.2", 1);
                    this.f74734k.c0(j3, false);
                } else {
                    i16.p0(j3, "processIntent.3", 2);
                    this.f74734k.c0(j3, true);
                }
                SessionInfo sessionInfo2 = this.f74734k;
                sessionInfo2.G = true;
                sessionInfo2.f73084u0 = this.f74725b.isFriend(this.f74735l);
            }
            this.f74725b.addObserver(this.E);
        }
        e(true);
        if (this.f74734k == null && this.f74729f != 1) {
            if (QLog.isColorLevel()) {
                QLog.d("MultiIncomingCallUICtr", 2, "session info null!");
            }
            b();
        }
    }

    void t(long j3, boolean z16, final String str, boolean z17, final boolean z18) {
        char c16;
        VideoAppInterface videoAppInterface;
        long j16;
        if (com.tencent.av.r.h0() == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w("MultiIncomingCallUICtr", 1, "refuseDoubleCall, isDoubleVideoMeeting[" + z16 + "], peerUin[" + str + "], notifyDestroyUI[" + z17 + "], refuse3rd[" + z18 + "], seq[" + j3 + "]");
        }
        if (this.f74734k.M0) {
            ReportController.o(null, "CliOper", "", "", "0X8008B25", "0X8008B25", 0, 0, "", "", "", "");
        } else {
            ReportController.o(null, "CliOper", "", "", "0X8008B28", "0X8008B28", 0, 0, "", "", "", "");
        }
        if (z16) {
            com.tencent.av.r.h0().g(j3, str, 1, true);
            try {
                j16 = com.tencent.av.utils.i.g(str);
            } catch (NumberFormatException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("MultiIncomingCallUICtr", 2, "", e16);
                }
                j16 = -1;
            }
            if (!z18) {
                c16 = 2;
                com.tencent.av.r.h0().Q0(j3, 3, j16, 10, false);
                com.tencent.av.r.h0().o(j3, j16, 23);
                b();
            } else {
                c16 = 2;
                com.tencent.av.r.h0().P0(j3, 3, j16);
                com.tencent.av.r.h0().o(j3, j16, 1);
                b();
            }
        } else {
            c16 = 2;
            RtcNodeReportReceiverHelper.s(this.f74734k.r("MultiIncomingInviteFloat_accept"), 2, NodeModel$NodeEndReason.K_INTERRUPTION.ordinal());
            com.tencent.av.r.h0().c(j3, str, 1, false, new Runnable() { // from class: com.tencent.av.ui.MultiIncomingCallUICtr.2
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.av.r.h0().r(str, 244);
                    com.tencent.av.r.h0().j2(244);
                    if (!z18) {
                        com.tencent.av.r.h0().q(str, 23);
                    } else {
                        com.tencent.av.r.h0().q(str, 1);
                    }
                }
            });
        }
        if (z17 && (videoAppInterface = this.f74725b) != null) {
            Object[] objArr = new Object[3];
            objArr[0] = 28;
            objArr[1] = str;
            objArr[c16] = Boolean.TRUE;
            videoAppInterface.k0(objArr);
        }
    }
}
