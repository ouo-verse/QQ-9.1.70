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
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.at;
import com.tencent.av.utils.ba;
import com.tencent.av.utils.bd;
import com.tencent.avcore.jni.audiodevice.TraeConstants;
import com.tencent.avcore.rtc.node.report.data.NodeModel$NodeEndReason;
import com.tencent.avcore.rtc.node.report.utils.RtcNodeReportReceiverHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VideoInviteFloatBarUICtr extends BaseInviteFloatBarUICtr {

    /* renamed from: t, reason: collision with root package name */
    bd f75184t;

    /* renamed from: x, reason: collision with root package name */
    Intent f75188x;

    /* renamed from: r, reason: collision with root package name */
    public boolean f75182r = false;

    /* renamed from: s, reason: collision with root package name */
    boolean f75183s = false;

    /* renamed from: u, reason: collision with root package name */
    int f75185u = -1;

    /* renamed from: v, reason: collision with root package name */
    public boolean f75186v = false;

    /* renamed from: w, reason: collision with root package name */
    String f75187w = "";

    /* renamed from: y, reason: collision with root package name */
    String f75189y = TraeConstants.VIDEO_CALL_CONFIG;

    /* renamed from: z, reason: collision with root package name */
    BroadcastReceiver f75190z = new a();
    VideoObserver A = new b();
    GAudioUIObserver B = new GAudioUIObserver() { // from class: com.tencent.av.ui.VideoInviteFloatBarUICtr.3
        @Override // com.tencent.av.app.GAudioUIObserver
        protected void A(long j3, long j16, String str) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoInviteFloatBarUICtr.troopgroup_vedio.invite", 2, "groupId:" + j3 + ", memUin:" + j16 + ",invitedId:" + str + ", mInviterUin:" + VideoInviteFloatBarUICtr.this.f74731h + ", mGroupId:" + VideoInviteFloatBarUICtr.this.f74726c);
            }
            VideoInviteFloatBarUICtr videoInviteFloatBarUICtr = VideoInviteFloatBarUICtr.this;
            if (j16 == videoInviteFloatBarUICtr.f74731h && j3 == videoInviteFloatBarUICtr.f74726c) {
                videoInviteFloatBarUICtr.b();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void O() {
            super.O();
            VideoInviteFloatBarUICtr.this.e(false);
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void S(long j3, ArrayList<com.tencent.av.e> arrayList, int i3, int i16) {
            Iterator<com.tencent.av.e> it = arrayList.iterator();
            while (it.hasNext()) {
                if (String.valueOf(it.next().f73701a).equalsIgnoreCase(VideoInviteFloatBarUICtr.this.f74725b.getAccount())) {
                    VideoInviteFloatBarUICtr.this.b();
                }
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void b(long j3) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoInviteFloatBarUICtr", 2, "notifyCloseAllGroupVideoInviteMsgBox-->notifyByGroupId=" + j3);
            }
            VideoInviteFloatBarUICtr videoInviteFloatBarUICtr = VideoInviteFloatBarUICtr.this;
            long j16 = videoInviteFloatBarUICtr.f74726c;
            videoInviteFloatBarUICtr.b();
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void c(long j3) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoInviteFloatBarUICtr", 2, "notifyCloseGroupVideoInviteMsgBox-->groupId=" + j3);
            }
            VideoInviteFloatBarUICtr videoInviteFloatBarUICtr = VideoInviteFloatBarUICtr.this;
            if (videoInviteFloatBarUICtr.f74726c == j3) {
                videoInviteFloatBarUICtr.b();
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void d(long j3, String str) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoInviteFloatBarUICtr", 2, "notifyCloseGroupVideoInviteMsgBoxByInviteId-->groupId=" + j3);
            }
            VideoInviteFloatBarUICtr videoInviteFloatBarUICtr = VideoInviteFloatBarUICtr.this;
            if (videoInviteFloatBarUICtr.f74726c == j3 && videoInviteFloatBarUICtr.f75187w.equals(str)) {
                VideoInviteFloatBarUICtr.this.b();
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void g(long j3, long j16) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoInviteFloatBarUICtr", 2, "onCreateRoomSuc-->GroupID=" + j16);
            }
            VideoInviteFloatBarUICtr videoInviteFloatBarUICtr = VideoInviteFloatBarUICtr.this;
            videoInviteFloatBarUICtr.f74734k.f73097x1 = true;
            if (videoInviteFloatBarUICtr.f74729f == 1) {
                videoInviteFloatBarUICtr.f74725b.V(j16);
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void h(long j3, int i3) {
            super.i(j3);
            if (QLog.isColorLevel()) {
                QLog.d("VideoInviteFloatBarUICtr", 2, "onDestroyInviteUI-->reason=" + i3);
            }
            VideoInviteFloatBarUICtr videoInviteFloatBarUICtr = VideoInviteFloatBarUICtr.this;
            if (videoInviteFloatBarUICtr.f74726c == j3 || 0 == j3) {
                videoInviteFloatBarUICtr.b();
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void k(long j3, final long j16) {
            if (QLog.isColorLevel()) {
                QLog.w("VideoInviteFloatBarUICtr", 1, "onEnterRoomSuc, groupId[" + j16 + "], seq[" + j3 + "]");
            }
            VideoInviteFloatBarUICtr.this.f74725b.M().postDelayed(new Runnable() { // from class: com.tencent.av.ui.VideoInviteFloatBarUICtr.3.1
                @Override // java.lang.Runnable
                public void run() {
                    VideoInviteFloatBarUICtr videoInviteFloatBarUICtr = VideoInviteFloatBarUICtr.this;
                    videoInviteFloatBarUICtr.f74734k.f73097x1 = true;
                    if (videoInviteFloatBarUICtr.f74729f == 1) {
                        videoInviteFloatBarUICtr.f74725b.V(j16);
                    }
                }
            }, 500L);
            com.tencent.av.r.h0().K3();
            SmallScreenActivityPlugin.a(VideoInviteFloatBarUICtr.this.f74725b).f(j3, false);
            VideoInviteFloatBar videoInviteFloatBar = VideoInviteFloatBarUICtr.this.f74737n;
            if (videoInviteFloatBar != null) {
                videoInviteFloatBar.d();
            }
            TraeHelper.I().i0(VideoInviteFloatBarUICtr.this.f75189y);
            VideoInviteFloatBarUICtr.this.f74725b.M().postDelayed(VideoInviteFloatBarUICtr.this.C, 1000L);
        }
    };
    Runnable C = new Runnable() { // from class: com.tencent.av.ui.VideoInviteFloatBarUICtr.4
        @Override // java.lang.Runnable
        public void run() {
            String formatTime = ba.formatTime(com.tencent.av.r.h0().K());
            VideoInviteFloatBar videoInviteFloatBar = VideoInviteFloatBarUICtr.this.f74737n;
            if (videoInviteFloatBar != null) {
                videoInviteFloatBar.j(formatTime);
                if (com.tencent.av.r.h0().K() % 60 >= 1) {
                    VideoInviteFloatBarUICtr.this.b();
                } else {
                    VideoInviteFloatBarUICtr.this.f74725b.M().postDelayed(this, 1000L);
                }
            }
        }
    };

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                long a16 = at.a(intent);
                if (action.equals("tencent.video.invite.accept")) {
                    VideoInviteFloatBarUICtr.this.g(a16);
                    return;
                }
                if (action.equals("tencent.video.invite.refuse")) {
                    VideoInviteFloatBarUICtr.this.n(a16);
                    return;
                }
                if (action.equals("tencent.video.invite.gaaccept")) {
                    VideoInviteFloatBarUICtr.this.f(a16);
                    return;
                }
                if (action.equals("tencent.video.invite.gaignore")) {
                    VideoInviteFloatBarUICtr.this.j(a16);
                    return;
                }
                if (action.equals("tencent.video.q2v.sdk.onRequestVideo")) {
                    QLog.d("VideoInviteFloatBarUICtr", 1, "onReceive action = " + action);
                    VideoInviteFloatBarUICtr.this.m();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class b extends VideoObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.VideoObserver
        public void X() {
            super.X();
            if (QLog.isColorLevel()) {
                QLog.d("VideoInviteFloatBarUICtr", 2, "onServiceConnected uin = " + VideoInviteFloatBarUICtr.this.f74735l);
            }
            VideoInviteFloatBarUICtr videoInviteFloatBarUICtr = VideoInviteFloatBarUICtr.this;
            VideoAppInterface videoAppInterface = videoInviteFloatBarUICtr.f74725b;
            if (videoAppInterface != null) {
                videoAppInterface.y0(videoInviteFloatBarUICtr.f74729f, videoInviteFloatBarUICtr.f74735l, videoInviteFloatBarUICtr.f74736m);
                VideoInviteFloatBarUICtr videoInviteFloatBarUICtr2 = VideoInviteFloatBarUICtr.this;
                VideoAppInterface videoAppInterface2 = videoInviteFloatBarUICtr2.f74725b;
                SessionInfo sessionInfo = videoInviteFloatBarUICtr2.f74734k;
                videoAppInterface2.x0(sessionInfo.B0, sessionInfo.D0);
            }
            VideoInviteFloatBarUICtr.this.e(false);
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void e(long j3, int i3, String str) {
            QLog.d("VideoInviteFloatBarUICtr", 1, "onClose  reason = " + i3 + ",peerUin =  " + str);
            if (TextUtils.equals(VideoInviteFloatBarUICtr.this.f74735l, str)) {
                QLog.d("VideoInviteFloatBarUICtr", 1, "onClose  wrong uin: " + VideoInviteFloatBarUICtr.this.f74735l + ", " + str);
                VideoInviteFloatBarUICtr.this.b();
                return;
            }
            if (com.tencent.av.r.h0() != null) {
                VideoInviteFloatBarUICtr.this.f74734k.u();
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void g(long j3) {
            if (QLog.isColorLevel()) {
                QLog.w("VideoInviteFloatBarUICtr", 1, "onConnected, seq[" + j3 + "]");
            }
            com.tencent.av.r.h0().K3();
            SmallScreenActivityPlugin.a(VideoInviteFloatBarUICtr.this.f74725b).f(j3, false);
            VideoInviteFloatBar videoInviteFloatBar = VideoInviteFloatBarUICtr.this.f74737n;
            if (videoInviteFloatBar != null) {
                videoInviteFloatBar.d();
            }
            VideoInviteFloatBarUICtr.this.f74725b.M().postDelayed(VideoInviteFloatBarUICtr.this.C, 1000L);
            VideoInviteFloatBarUICtr videoInviteFloatBarUICtr = VideoInviteFloatBarUICtr.this;
            if (videoInviteFloatBarUICtr.f74734k.f73035i == 1) {
                videoInviteFloatBarUICtr.f75189y = TraeConstants.VOICE_CALL_CONFIG;
            }
            TraeHelper.I().i0(VideoInviteFloatBarUICtr.this.f75189y);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.VideoObserver
        public void h(String str, boolean z16) {
            super.h(str, z16);
            QLog.d("VideoInviteFloatBarUICtr", 1, "onDestroyUI  peerUin: " + VideoInviteFloatBarUICtr.this.f74735l + ", isQuit : " + z16);
            String str2 = VideoInviteFloatBarUICtr.this.f74735l;
            if (str2 != null && str != null && str2.equals(str) && z16) {
                VideoInviteFloatBarUICtr.this.b();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.VideoObserver
        public void l(String str) {
            super.l(str);
            if (VideoInviteFloatBarUICtr.this.f74729f == 25) {
                if (QLog.isColorLevel()) {
                    QLog.d("VideoInviteFloatBarUICtr", 2, "VideoInviteActivity onGetQCallNickName nickName:" + str);
                }
                VideoInviteFloatBarUICtr videoInviteFloatBarUICtr = VideoInviteFloatBarUICtr.this;
                videoInviteFloatBarUICtr.f74727d = str;
                VideoInviteFloatBar videoInviteFloatBar = videoInviteFloatBarUICtr.f74737n;
                if (videoInviteFloatBar != null) {
                    videoInviteFloatBar.h(str);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.VideoObserver
        public void m(String str, Bitmap bitmap) {
            VideoInviteFloatBar videoInviteFloatBar;
            if (QLog.isColorLevel()) {
                QLog.d("VideoInviteFloatBarUICtr", 2, "onGetStrangeFace uin = " + VideoInviteFloatBarUICtr.this.f74735l);
            }
            VideoInviteFloatBarUICtr videoInviteFloatBarUICtr = VideoInviteFloatBarUICtr.this;
            if (videoInviteFloatBarUICtr.f74729f == 25 && (videoInviteFloatBar = videoInviteFloatBarUICtr.f74737n) != null) {
                videoInviteFloatBar.e(bitmap);
            }
            super.m(str, bitmap);
        }
    }

    public VideoInviteFloatBarUICtr(VideoAppInterface videoAppInterface, Intent intent) {
        this.f74725b = videoAppInterface;
        this.f75188x = intent;
    }

    private boolean i(int i3) {
        String str;
        if (this.f74730g == 1 && !TextUtils.isEmpty(this.f75187w)) {
            Intent intent = new Intent("tencent.video.v2q.ACTION_DEAL_INVITE_TO_ENTER_GROUP_VEDIO");
            intent.putExtra("relationId", this.f74726c + "");
            intent.putExtra("dealResult", i3);
            intent.putExtra("inviteId", this.f75187w);
            intent.putExtra("friendUin", this.f74731h);
            intent.setPackage(this.f74725b.getApp().getPackageName());
            this.f74725b.getApp().sendBroadcast(intent);
            if (QLog.isDevelopLevel()) {
                QLog.d("VideoInviteFloatBarUICtr", 2, "sendBroadcast, qav_gaudio_join");
            }
            if (i3 == 1) {
                str = "tip_in";
            } else {
                str = "tip_no";
            }
            ReportController.o(null, "dc00899", "Grp_video", "", "invite", str, 0, 0, String.valueOf(com.tencent.av.n.e().f().P0), this.f75185u + "", "", "");
            return true;
        }
        return false;
    }

    @Override // com.tencent.av.ui.BaseInviteFloatBarUICtr
    public void b() {
        super.b();
        VideoAppInterface videoAppInterface = this.f74725b;
        if (videoAppInterface != null) {
            try {
                videoAppInterface.getApplication().unregisterReceiver(this.f75190z);
                this.f74725b.deleteObserver(this.B);
                this.f74725b.deleteObserver(this.A);
            } catch (Exception e16) {
                QLog.d("VideoInviteFloatBarUICtr", 1, "onDestroy error : " + e16);
            }
            if (this.C != null) {
                this.f74725b.M().removeCallbacks(this.C);
                this.C = null;
            }
        }
    }

    @Override // com.tencent.av.ui.BaseInviteFloatBarUICtr
    void c() {
        j(-1039L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.av.ui.BaseInviteFloatBarUICtr
    public void e(boolean z16) {
        super.e(z16);
        com.tencent.av.r.h0().K3();
    }

    public void f(long j3) {
        QLog.w("VideoInviteFloatBarUICtr", 1, "acceptGAudioChat, seq[" + j3 + "]");
        VideoInviteFloatBar videoInviteFloatBar = this.f74737n;
        if (videoInviteFloatBar != null) {
            videoInviteFloatBar.g(HardCodeUtil.qqStr(R.string.v4l));
        }
        com.tencent.av.r.h0().a(j3, this.f74730g, this.f74734k.P0, this.f74732i, false);
        ReportController.o(null, "CliOper", "", "", "0X8008B2B", "0X8008B2B", 0, 0, "", "", "", "");
        a();
    }

    public void g(long j3) {
        int i3;
        int i16;
        if (!h()) {
            QLog.d("VideoInviteFloatBarUICtr", 1, "acceptVideoRequest return 1");
            return;
        }
        if (com.tencent.av.r.h0() != null && this.f74734k != null) {
            QLog.w("VideoInviteFloatBarUICtr", 1, "acceptVideoRequest, seq[" + j3 + "], mIsDoubleVideoMeeting[" + this.f75183s + "]");
            SessionInfo sessionInfo = this.f74734k;
            int i17 = !sessionInfo.M0 ? 1 : 0;
            if (!sessionInfo.f73084u0) {
                i3 = 4;
            } else {
                i3 = 1;
            }
            if (1008 == sessionInfo.f73067q) {
                i16 = 4;
            } else {
                i16 = i3;
            }
            if (this.f75183s) {
                com.tencent.av.r.h0().a(j3, 3, Long.valueOf(this.f74734k.f73091w).longValue(), null, false);
            } else {
                RtcNodeReportReceiverHelper.s(sessionInfo.r("VideoInviteFloat_accept"), 1, NodeModel$NodeEndReason.K_NORMAL.ordinal());
                com.tencent.av.r.h0().b(j3, this.f74734k.f73091w, i17, i16);
            }
            VideoInviteFloatBar videoInviteFloatBar = this.f74737n;
            if (videoInviteFloatBar != null) {
                videoInviteFloatBar.g(HardCodeUtil.qqStr(R.string.v4k));
            }
            if (this.f74734k.M0) {
                ReportController.o(null, "CliOper", "", "", "0X8008B24", "0X8008B24", 0, 0, "", "", "", "");
                return;
            } else {
                ReportController.o(null, "CliOper", "", "", "0X8008B27", "0X8008B27", 0, 0, "", "", "", "");
                return;
            }
        }
        QLog.d("VideoInviteFloatBarUICtr", 1, "acceptVideoRequest return 2");
    }

    protected boolean h() {
        bd bdVar;
        if (this.f75184t == null) {
            this.f75184t = new bd(this.f74725b.getApplication().getApplicationContext(), 1, "video wifi lock");
        }
        if (com.tencent.av.utils.ad.q(this.f74725b.getApplication().getApplicationContext()) && (bdVar = this.f75184t) != null) {
            bdVar.b();
        }
        return true;
    }

    public void j(long j3) {
        QLog.w("VideoInviteFloatBarUICtr", 1, "ignoreGAInvite, seq[" + j3 + "]");
        ReportController.o(null, "CliOper", "", "", "0X8008B2C", "0X8008B2C", 0, 0, "", "", "", "");
        if (!i(0)) {
            com.tencent.av.r.h0().P0(j3, this.f74730g, this.f74726c);
        }
        b();
    }

    public void k() {
        QLog.d("VideoInviteFloatBarUICtr", 1, "onCreate start");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.NEW_OUTGOING_CALL");
        intentFilter.addAction("tencent.video.invite.accept");
        intentFilter.addAction("tencent.video.invite.refuse");
        intentFilter.addAction("tencent.video.invite.gaaccept");
        intentFilter.addAction("tencent.video.invite.gaignore");
        intentFilter.addAction("tencent.video.q2v.sdk.onRequestVideo");
        this.f74725b.getApplication().registerReceiver(this.f75190z, intentFilter);
    }

    public int l(long j3, Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.w("VideoInviteFloatBarUICtr", 1, "onStartCommand, seq[" + j3 + "]");
            com.tencent.av.utils.e.m("VideoInviteFloatBarUICtr.onStartCommand", intent.getExtras());
        }
        this.f74729f = intent.getIntExtra("uinType", 0);
        this.f74730g = intent.getIntExtra("relationType", 0);
        if (AVUtil.o(this.f74729f)) {
            this.f74731h = intent.getLongExtra("friendUin", 0L);
            this.f75187w = intent.getStringExtra("inviteId");
            this.f74726c = intent.getLongExtra("discussId", 0L);
            this.f75185u = intent.getIntExtra("memberType", -1);
            this.f74732i = intent.getLongArrayExtra("memberList");
            this.f74725b.addObserver(this.B);
            String b16 = com.tencent.av.n.b(this.f74730g, String.valueOf(this.f74726c), new int[0]);
            if (com.tencent.av.n.e().j(b16)) {
                this.f74734k = com.tencent.av.n.e().i(b16);
            } else {
                this.f74734k = com.tencent.av.n.e().f();
            }
        } else {
            this.f74735l = intent.getStringExtra("peerUin");
            this.f74736m = intent.getStringExtra("extraUin");
            this.f74733j = intent.getBooleanExtra("isAudioMode", false);
            this.f75182r = intent.getBooleanExtra("shutCamera", false);
            this.f75183s = intent.getBooleanExtra("isDoubleVideoMeeting", false);
            if (QLog.isColorLevel()) {
                QLog.d("VideoInviteFloatBarUICtr", 2, "onStartCommand  mIsAudioMode = " + this.f74733j + ", isDoubleVideoMeeting = " + this.f75183s);
            }
            if (TextUtils.isEmpty(this.f74735l)) {
                if (QLog.isColorLevel()) {
                    QLog.e("VideoInviteFloatBarUICtr", 2, "mPeerUin is empty!");
                }
                b();
            } else if (QLog.isColorLevel()) {
                QLog.d("VideoInviteFloatBarUICtr", 2, "mPeerUin : " + this.f74735l);
            }
            if (this.f75183s) {
                String b17 = com.tencent.av.n.b(100, this.f74735l, new int[0]);
                if (QLog.isColorLevel()) {
                    QLog.d("VideoInviteFloatBarUICtr", 2, "sessionId : " + b17);
                }
                SessionInfo i3 = com.tencent.av.n.e().i(b17);
                this.f74734k = i3;
                if (i3 != null) {
                    i3.p0(j3, "onStartCommand.1", 4);
                    this.f74734k.y0("onStartCommand", true);
                    SessionInfo sessionInfo = this.f74734k;
                    sessionInfo.B1 = true;
                    sessionInfo.G = true;
                    sessionInfo.f73084u0 = this.f74725b.isFriend(this.f74735l);
                    this.f74725b.addObserver(this.B);
                }
            } else {
                RtcNodeReportReceiverHelper.v(intent.getStringExtra("traceId"));
                SessionInfo i16 = com.tencent.av.n.e().i(com.tencent.av.n.b(3, this.f74735l, new int[0]));
                this.f74734k = i16;
                if (i16 != null) {
                    if (this.f74733j) {
                        i16.p0(j3, "onStartCommand.2", 1);
                        this.f74734k.c0(j3, false);
                    } else {
                        i16.p0(j3, "onStartCommand.3", 2);
                        this.f74734k.c0(j3, !this.f75182r);
                    }
                    SessionInfo sessionInfo2 = this.f74734k;
                    sessionInfo2.G = true;
                    sessionInfo2.f73084u0 = this.f74725b.isFriend(this.f74735l);
                    this.f74725b.addObserver(this.A);
                }
            }
        }
        return 2;
    }

    protected boolean m() {
        if (com.tencent.av.r.h0() == null) {
            QLog.d("VideoInviteFloatBarUICtr", 1, "VideoInviteFloatBarUICtr_quaReport VideoController.getInstance() = null, return !");
            return false;
        }
        if (this.f74735l == null) {
            QLog.d("VideoInviteFloatBarUICtr", 1, "VideoInviteFloatBarUICtr_quaReport mPeerUin = null, return !");
            return false;
        }
        return com.tencent.av.r.h0().X1(this.f74735l);
    }

    public void n(long j3) {
        QLog.w("VideoInviteFloatBarUICtr", 1, "refuseVideoRequest, seq[" + j3 + "]");
        if (this.f74734k.M0) {
            ReportController.o(null, "CliOper", "", "", "0X8008B25", "0X8008B25", 0, 0, "", "", "", "");
        } else {
            ReportController.o(null, "CliOper", "", "", "0X8008B28", "0X8008B28", 0, 0, "", "", "", "");
        }
        if (this.f75183s) {
            com.tencent.av.r.h0().g(j3, this.f74735l, 1, true);
            long g16 = com.tencent.av.utils.i.g(this.f74735l);
            com.tencent.av.r.h0().P0(j3, 3, g16);
            com.tencent.av.r.h0().o(j3, g16, 1);
            b();
            return;
        }
        RtcNodeReportReceiverHelper.s(this.f74734k.r("VideoInviteFloat_accept"), 2, NodeModel$NodeEndReason.K_INTERRUPTION.ordinal());
        com.tencent.av.r.h0().g(j3, this.f74735l, 1, false);
        com.tencent.av.r.h0().r(this.f74735l, 252);
        com.tencent.av.r.h0().j2(252);
        com.tencent.av.r.h0().q(this.f74735l, 1);
    }
}
