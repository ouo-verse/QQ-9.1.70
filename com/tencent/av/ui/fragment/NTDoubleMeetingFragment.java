package com.tencent.av.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.api.ICameraUtilsStaticApi;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.ScreenRecordHelper;
import com.tencent.av.ui.chatroom.VideoChatRoomUIContoller;
import com.tencent.av.ui.m;
import com.tencent.av.ui.part.base.AVHidePart;
import com.tencent.av.ui.part.base.AVNameAndHeadPart;
import com.tencent.av.ui.part.base.AVNetConnectInfoPart;
import com.tencent.av.ui.part.base.AVToolBarPart;
import com.tencent.av.ui.part.base.e;
import com.tencent.av.ui.part.base.h;
import com.tencent.av.ui.part.base.panel.c;
import com.tencent.av.ui.part.base.panel.d;
import com.tencent.av.ui.part.dav.panel.AVCameraPart;
import com.tencent.av.ui.s;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.as;
import com.tencent.avcore.util.AVConstants;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class NTDoubleMeetingFragment extends NTBaseVideoFragment {
    String A0;
    long B0;
    private AVNameAndHeadPart C0;
    private e D0;
    Runnable E0;
    QueryPeerVideoRunnable F0;
    GAudioUIObserver G0;
    private boolean H0;

    /* renamed from: u0, reason: collision with root package name */
    boolean f75631u0;

    /* renamed from: v0, reason: collision with root package name */
    boolean f75632v0;

    /* renamed from: w0, reason: collision with root package name */
    boolean f75633w0;

    /* renamed from: x0, reason: collision with root package name */
    s f75634x0;

    /* renamed from: y0, reason: collision with root package name */
    String f75635y0;

    /* renamed from: z0, reason: collision with root package name */
    long f75636z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class QueryPeerVideoRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        public String f75644d = null;

        QueryPeerVideoRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (QLog.isColorLevel()) {
                QLog.d(NTBaseVideoFragment.f75610s0, 2, "QueryPeerVideoRunnable-->Function Name = " + this.f75644d);
            }
            NTDoubleMeetingFragment.this.hl();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class RequestVideoTimeoutRunnale implements Runnable {
        RequestVideoTimeoutRunnale() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (r.h0() != null && !NTDoubleMeetingFragment.this.isDestroyed()) {
                r.h0().B3("Meeting_RequestVideoTimeoutRunnale");
                NTDoubleMeetingFragment.this.ml(true);
                cw.e.d(NTDoubleMeetingFragment.this.G, 1036);
                cw.e.d(NTDoubleMeetingFragment.this.G, 1037);
                n.e().f().V(NTDoubleMeetingFragment.this.B0, true, true);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(NTBaseVideoFragment.f75610s0, 2, "RequestVideoTimeoutRunnale-->VideoControl is null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements as.b {
        a() {
        }

        @Override // com.tencent.av.utils.as.b
        public void a() {
            d dVar = NTDoubleMeetingFragment.this.f75622k0;
            if (dVar != null) {
                dVar.ia();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements s.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f75649a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f75650b;

        b(long j3, int i3) {
            this.f75649a = j3;
            this.f75650b = i3;
        }

        @Override // com.tencent.av.ui.s.e
        public void a() {
            NTDoubleMeetingFragment.this.el(this.f75649a, this.f75650b);
            NTDoubleMeetingFragment.this.N = false;
        }

        @Override // com.tencent.av.ui.s.e
        public void b() {
            NTDoubleMeetingFragment nTDoubleMeetingFragment = NTDoubleMeetingFragment.this;
            nTDoubleMeetingFragment.N = true;
            nTDoubleMeetingFragment.tj();
        }
    }

    public NTDoubleMeetingFragment() {
        this.f75631u0 = false;
        this.f75632v0 = false;
        this.f75633w0 = false;
        this.f75634x0 = null;
        this.f75635y0 = null;
        this.E0 = null;
        this.F0 = new QueryPeerVideoRunnable();
        this.G0 = new GAudioUIObserver() { // from class: com.tencent.av.ui.fragment.NTDoubleMeetingFragment.1
            @Override // com.tencent.av.app.GAudioUIObserver
            protected void D(long j3, long j16) {
                if (QLog.isColorLevel()) {
                    QLog.i(AVConstants.SHARE_TAG, 2, "onMeetingNotifyTimeout, relationId[" + j16 + "]");
                }
                SessionInfo f16 = n.e().f();
                NTDoubleMeetingFragment nTDoubleMeetingFragment = NTDoubleMeetingFragment.this;
                if (j16 == nTDoubleMeetingFragment.f75636z0 && f16.P0 == j16) {
                    nTDoubleMeetingFragment.Yk(j3, f16, 3);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.av.app.GAudioUIObserver
            public void F(long j3, long j16, boolean z16, boolean z17) {
                long d16 = com.tencent.av.utils.e.d();
                if (QLog.isColorLevel()) {
                    QLog.w(NTBaseVideoFragment.f75610s0, 1, "onMemberJoin, groupId[" + j3 + "], friendUin[" + j16 + "], isRfresh[" + z16 + "], isQQUser[" + z17 + "], seq[" + d16 + "]");
                }
                if (j16 == NTDoubleMeetingFragment.this.f75636z0) {
                    n.e().f().f73058n2 = 1;
                    NTDoubleMeetingFragment.this.fl(d16, j3, j16, 5);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.av.app.GAudioUIObserver
            public void G(long j3, long j16, boolean z16, boolean z17) {
                long d16 = com.tencent.av.utils.e.d();
                if (QLog.isColorLevel()) {
                    QLog.w(NTBaseVideoFragment.f75610s0, 1, "onMemberLeave, groupId[" + j3 + "], friendUin[" + j16 + "], isQQUser[" + z16 + "], seq[" + d16 + "]");
                }
                NTDoubleMeetingFragment.this.fl(d16, j3, j16, 6);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.av.app.GAudioUIObserver
            public void J(long j3, long j16) {
                long d16 = com.tencent.av.utils.e.d();
                if (QLog.isColorLevel()) {
                    QLog.w(NTBaseVideoFragment.f75610s0, 1, "onMemberVideoIn, groupId[" + j3 + "], friendUin[" + j16 + "], seq[" + d16 + "]");
                }
                NTDoubleMeetingFragment.this.fl(d16, j3, j16, 1);
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void K(long j3, long j16, long j17, int i3) {
                if (QLog.isColorLevel()) {
                    QLog.w(NTBaseVideoFragment.f75610s0, 1, "onMemberVideoOut, groupId[" + j16 + "], friendUin[" + j17 + "], videoSrcType[" + i3 + "], seq[" + j3 + "]");
                }
                NTDoubleMeetingFragment.this.fl(j3, j16, j17, 2);
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void g(long j3, long j16) {
                if (QLog.isColorLevel()) {
                    QLog.d(NTBaseVideoFragment.f75610s0, 2, "onCreateRoomSuc-->relationId = " + j16);
                }
                NTDoubleMeetingFragment nTDoubleMeetingFragment = NTDoubleMeetingFragment.this;
                if (j16 != nTDoubleMeetingFragment.f75636z0) {
                    return;
                }
                nTDoubleMeetingFragment.ol(j3, true);
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void h(long j3, int i3) {
                if (QLog.isColorLevel()) {
                    QLog.d(NTBaseVideoFragment.f75610s0, 2, "onDestroyInviteUI-->GroupId = " + j3);
                }
                if (j3 == NTDoubleMeetingFragment.this.f75636z0) {
                    super.i(j3);
                    NTDoubleMeetingFragment.this.Zk(true);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.av.app.GAudioUIObserver
            public void i(long j3) {
                if (QLog.isColorLevel()) {
                    QLog.d(NTBaseVideoFragment.f75610s0, 2, "onDestory UI-->relationId = " + j3);
                }
                NTDoubleMeetingFragment nTDoubleMeetingFragment = NTDoubleMeetingFragment.this;
                if (nTDoubleMeetingFragment.f75636z0 == j3) {
                    nTDoubleMeetingFragment.Zk(true);
                }
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void k(long j3, long j16) {
                if (QLog.isColorLevel()) {
                    QLog.d(NTBaseVideoFragment.f75610s0, 2, "EnterRoomSuc-->GroupId = " + j16);
                }
                NTDoubleMeetingFragment nTDoubleMeetingFragment = NTDoubleMeetingFragment.this;
                if (j16 == nTDoubleMeetingFragment.f75636z0) {
                    nTDoubleMeetingFragment.dk(j3);
                }
                NTDoubleMeetingFragment.this.ol(j3, false);
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void l(long j3, int i3) {
                if (r.h0() == null || NTDoubleMeetingFragment.this.isDestroyed() || NTDoubleMeetingFragment.this.G == null) {
                    return;
                }
                long d16 = com.tencent.av.utils.e.d();
                if (QLog.isColorLevel()) {
                    QLog.w(NTBaseVideoFragment.f75610s0, 1, "onFirstFrameDataComeIn, uin[" + j3 + "], videoSrcType[" + i3 + "], seq[" + d16 + "]");
                }
                int q16 = n.e().f().q(j3, i3);
                if (q16 != -1 && n.e().f().f73045k1.get(q16).f73829c) {
                    cw.e.d(NTDoubleMeetingFragment.this.G, 1036);
                    cw.e.d(NTDoubleMeetingFragment.this.G, 1037);
                }
                NTDoubleMeetingFragment.super.yj(d16);
                NTDoubleMeetingFragment.this.gl("OnFirstFrameDataComeIn");
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void n() {
                if (QLog.isColorLevel()) {
                    QLog.d(NTBaseVideoFragment.f75610s0, 2, "onGAudioInviteResp");
                }
                AVActivity aVActivity = (AVActivity) NTDoubleMeetingFragment.this.F.get();
                if (aVActivity == null || aVActivity.isFinishing()) {
                    return;
                }
                aVActivity.runOnUiThread(new Runnable() { // from class: com.tencent.av.ui.fragment.NTDoubleMeetingFragment.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ScreenShareCtrl y06 = r.h0().y0();
                        if (y06 != null) {
                            y06.u(NTDoubleMeetingFragment.this.wh(), 1L);
                        }
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.av.app.GAudioUIObserver
            public void u(long j3, long j16, boolean z16, boolean z17) {
                long d16 = com.tencent.av.utils.e.d();
                if (QLog.isColorLevel()) {
                    QLog.w(NTBaseVideoFragment.f75610s0, 1, "onGaMemberShareSrcInOrOut, groupId[" + j3 + "], groupId[" + j3 + "], bIn[" + z16 + "], isPPT[" + z17 + "], seq[" + d16 + "]");
                }
                if (z16) {
                    NTDoubleMeetingFragment.this.fl(d16, j3, j16, 3);
                } else {
                    NTDoubleMeetingFragment.this.fl(d16, j3, j16, 4);
                }
                NTDoubleMeetingFragment.this.f75632v0 = z17;
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void v(long j3, int i3, long j16, long j17, long j18, int i16) {
                if (NTDoubleMeetingFragment.this.isDestroyed()) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.w(NTBaseVideoFragment.f75610s0, 1, "onGaOperationResult, result[" + i3 + "], uin[" + j16 + "], info[" + j17 + "], groupId[" + j18 + "], relationType[" + i16 + "], seq[" + j3 + "]");
                }
                SessionInfo f16 = n.e().f();
                switch (i3) {
                    case 90:
                        if (j17 == 3) {
                            NTDoubleMeetingFragment nTDoubleMeetingFragment = NTDoubleMeetingFragment.this;
                            if (nTDoubleMeetingFragment.J != null && nTDoubleMeetingFragment.getContext() != null) {
                                if (((ICameraUtilsStaticApi) QRoute.api(ICameraUtilsStaticApi.class)).getInstance(NTDoubleMeetingFragment.this.getContext()).getCameraNum() > 1) {
                                    NTDoubleMeetingFragment.this.J.setViewVisibility(m.l.B, 0);
                                } else {
                                    NTDoubleMeetingFragment.this.J.setViewVisibility(m.l.B, 8);
                                }
                            }
                            if (!f16.N || NTDoubleMeetingFragment.this.f75633w0) {
                                NTDoubleMeetingFragment nTDoubleMeetingFragment2 = NTDoubleMeetingFragment.this;
                                nTDoubleMeetingFragment2.f75633w0 = false;
                                nTDoubleMeetingFragment2.ki(j3);
                                int q16 = f16.q(NTDoubleMeetingFragment.this.B0, 1);
                                NTDoubleMeetingFragment.this.G.k0(new Object[]{105, Boolean.valueOf(q16 != -1 ? f16.f73045k1.get(q16).f73829c : false), Long.valueOf(j3)});
                            }
                            NTDoubleMeetingFragment.super.yj(j3);
                            return;
                        }
                        return;
                    case 91:
                    case 92:
                        NTDoubleMeetingFragment.this.gi(j3, true);
                        NTDoubleMeetingFragment.this.al(j3);
                        NTDoubleMeetingFragment.this.G.k0(new Object[]{106, Long.valueOf(j3)});
                        return;
                    case 93:
                    case 94:
                    case 95:
                        NTDoubleMeetingFragment.this.lk(j3, 33554431);
                        return;
                    case 96:
                        if (j17 != 1 || f16.B1) {
                            return;
                        }
                        NTDoubleMeetingFragment.this.Vk("onGaOperationResult->REQUEST_VIDEO_SUC");
                        NTDoubleMeetingFragment.this.bl(j3, f16.f73045k1);
                        return;
                    default:
                        return;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.av.app.GAudioUIObserver
            public void w(long j3, long j16, String str) {
                super.w(j3, j16, str);
                if (QLog.isColorLevel()) {
                    QLog.d(NTBaseVideoFragment.f75610s0, 2, "onGroupSecurityLimit-->groupid=" + j3 + " info=" + j16 + " strMsg=" + str);
                }
                if (j16 < 201 || j16 > 299) {
                    return;
                }
                Intent intent = new Intent();
                intent.setAction("tencent.av.v2q.MultiVideo");
                intent.putExtra("type", 33);
                intent.putExtra("relationId", j3);
                intent.putExtra("uinType", 0);
                intent.putExtra("info", j16);
                intent.putExtra("strMsg", str);
                intent.putExtra("from", "DoubleVideoMeetingCtrlUI");
                AVActivity aVActivity = (AVActivity) NTDoubleMeetingFragment.this.F.get();
                if (aVActivity != null) {
                    intent.setPackage(NTDoubleMeetingFragment.this.G.getApplication().getPackageName());
                    aVActivity.sendBroadcast(intent);
                } else if (QLog.isColorLevel()) {
                    QLog.e(NTBaseVideoFragment.f75610s0, 2, "onGroupSecurityLimit-->can not get the activity");
                }
                NTDoubleMeetingFragment.this.el(com.tencent.av.utils.e.d(), -255);
            }
        };
        this.H0 = false;
    }

    private void nl(boolean z16) {
        AVNameAndHeadPart aVNameAndHeadPart = this.C0;
        if (aVNameAndHeadPart != null) {
            aVNameAndHeadPart.O9(z16);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public int Ch() {
        return m.j.f76051b;
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    void Gi() {
        c cVar = this.f75618g0;
        if (cVar != null) {
            cVar.F9();
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Ii() {
        VideoChatRoomUIContoller videoChatRoomUIContoller;
        QLog.d(NTBaseVideoFragment.f75610s0, 1, "onCreate");
        WeakReference<Context> weakReference = this.F;
        if (weakReference == null) {
            QLog.d(NTBaseVideoFragment.f75610s0, 1, "onCreate mContext is null");
            return;
        }
        Activity activity = (Activity) weakReference.get();
        if (activity == null) {
            return;
        }
        super.Ii();
        long d16 = com.tencent.av.utils.e.d();
        SessionInfo f16 = n.e().f();
        if (QLog.isColorLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "onCreate, SessionType[" + f16.f73035i + "], localHasVideo[" + f16.N + "], seq[" + d16 + "]");
        }
        if (f16.V0) {
            if (QLog.isColorLevel()) {
                QLog.i(NTBaseVideoFragment.f75610s0, 2, "onCreate, localMute[" + f16.K + "], localHasVideo[" + f16.N + "], hasLocalVideoWhenSwitch[" + f16.f73062o2 + "], deviceName[" + f16.F0 + "]");
            }
            r.h0().R2("switch2DoubleMeeting_onCreate", f16.K);
            r.h0().T2("switch2DoubleMeeting_onCreate", f16.K ? 1 : 0);
        }
        initUI();
        this.G.addObserver(this.G0);
        String str = f16.f73091w;
        this.f75635y0 = str;
        try {
            this.f75636z0 = Long.valueOf(str).longValue();
        } catch (NumberFormatException e16) {
            AVCoreLog.printErrorLog(NTBaseVideoFragment.f75610s0, e16.getMessage());
        }
        cl(d16);
        s sVar = this.f75634x0;
        if (sVar != null) {
            sVar.b();
        }
        if (!(activity instanceof AVActivity) || (videoChatRoomUIContoller = ((AVActivity) activity).f74657h1) == null) {
            return;
        }
        videoChatRoomUIContoller.o(3);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Ki(long j3) {
        QLog.w(NTBaseVideoFragment.f75610s0, 1, "onDestroy, seq[" + j3 + "]");
        VideoAppInterface videoAppInterface = this.G;
        if (videoAppInterface != null) {
            videoAppInterface.deleteObserver(this.G0);
        }
        as asVar = this.L;
        if (asVar != null) {
            asVar.m(false);
            this.L.n(false);
            this.L.r(false);
        }
        ViewGroup viewGroup = this.H;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        s sVar = this.f75634x0;
        if (sVar != null) {
            sVar.a();
            this.f75634x0 = null;
        }
        super.Ki(j3);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Ni(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(NTBaseVideoFragment.f75610s0, 2, "onLayoutModeChange --> ScreenType = " + i3 + " , hasSetBigVideoView = " + n.e().f().s());
        }
        Pk();
        if (i3 == 3) {
            if (4 == r.h0().H0()) {
                Iterator<com.tencent.av.gaudio.c> it = n.e().f().f73045k1.iterator();
                while (it.hasNext()) {
                    com.tencent.av.gaudio.c next = it.next();
                    if (!next.f73829c) {
                        next.f73831e = true;
                    }
                }
            } else if (n.e().f().f73045k1.size() > 0) {
                n.e().f().f73045k1.get(0).f73831e = true;
            }
        } else if (i3 == 4) {
            if (!n.e().f().s() && n.e().f().f73045k1.size() > 0) {
                n.e().f().f73045k1.get(0).f73829c = true;
                if (QLog.isColorLevel()) {
                    QLog.d(NTBaseVideoFragment.f75610s0, 2, "MultiVideoCtrlLayerUIBase onLayoutModeChange --> displayList  not has big one");
                }
            }
            if (4 == r.h0().H0()) {
                Iterator<com.tencent.av.gaudio.c> it5 = n.e().f().f73045k1.iterator();
                while (it5.hasNext()) {
                    com.tencent.av.gaudio.c next2 = it5.next();
                    if (!next2.f73829c) {
                        next2.f73831e = true;
                    }
                }
            } else if (n.e().f().f73045k1.size() > 0) {
                n.e().f().f73045k1.get(0).f73831e = true;
            }
        }
        hl();
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Pi(long j3, int i3, int i16) {
        super.Qi(j3, i3, i16);
        d dVar = this.f75622k0;
        if (dVar != null) {
            dVar.I9(i3, i16);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Pk() {
        AVNetConnectInfoPart aVNetConnectInfoPart = this.T;
        if (aVNetConnectInfoPart != null) {
            aVNetConnectInfoPart.U9(di());
        }
    }

    void Vk(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(NTBaseVideoFragment.f75610s0, 2, "addRequestVideoTimeoutRunnable,Function = " + str);
        }
        if (this.E0 == null) {
            this.E0 = new RequestVideoTimeoutRunnale();
        } else {
            this.G.M().removeCallbacks(this.E0);
        }
        this.G.M().postDelayed(this.E0, 30000L);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Wi(long j3) {
        if (QLog.isColorLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "onPause, seq[" + j3 + "], quit[" + this.f75631u0 + "]");
        }
        super.Wi(j3);
        if (r.h0() != null && !isDestroyed()) {
            n.e().f().B1 = true;
            n.e().f().A1 = true;
            if ((!SmallScreenUtils.w() || (!NetworkUtil.isWifiConnected(this.F.get()) && !n.e().f().C1)) && n.e().f().N) {
                r.h0().K0();
                this.I.update(null, new Object[]{106, Long.valueOf(j3)});
                QavPanel qavPanel = this.J;
                if (qavPanel != null) {
                    qavPanel.setViewVisibility(m.l.B, 8);
                }
                n.e().f().S = true;
            }
            if (n.e().f().f73064p0) {
                super.ek(j3);
            }
            gl("OnPause");
            if (this.f75631u0 || !SmallScreenUtils.w()) {
                r.h0().B3("Meeting_onPause");
            }
            n.e().f().V(this.B0, true, true);
        }
        this.G.C0("DoubleVideoMeetingCtrlUI");
        this.G.M().removeCallbacks(this.F0);
        AVToolBarPart aVToolBarPart = this.Y;
        if (aVToolBarPart != null) {
            aVToolBarPart.onPause();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void Wk(int i3) {
        boolean z16;
        as asVar;
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "avSwitch, sessionType[" + i3 + "], seq[" + d16 + "]");
        }
        ViewGroup viewGroup = this.H;
        if (viewGroup == null) {
            return;
        }
        View findViewById = viewGroup.findViewById(R.id.boj);
        AVActivity aVActivity = (AVActivity) this.F.get();
        AVNetConnectInfoPart aVNetConnectInfoPart = this.T;
        if (aVNetConnectInfoPart != null) {
            aVNetConnectInfoPart.C9(i3);
        }
        if (i3 == 3) {
            AVNameAndHeadPart aVNameAndHeadPart = this.C0;
            if (aVNameAndHeadPart != null) {
                aVNameAndHeadPart.D9(1);
            }
            sh();
            this.J.I0(false);
            if (aVActivity != null) {
                aVActivity.X3(true);
                aVActivity.U3();
            }
        } else if (i3 == 4) {
            findViewById.setBackgroundColor(this.E.getColor(R.color.ajr));
            AVNameAndHeadPart aVNameAndHeadPart2 = this.C0;
            if (aVNameAndHeadPart2 != null) {
                aVNameAndHeadPart2.D9(2);
            }
            this.J.I0(true);
            if (aVActivity != null) {
                aVActivity.X3(false);
                aVActivity.U3();
            }
            z16 = true;
            boolean z17 = n.e().f().f73035i != 3;
            asVar = this.L;
            if (asVar != null) {
                asVar.m(z17);
                this.L.n(z17);
            }
            oj(Boolean.valueOf(z16));
            lk(d16, 33554431);
            this.G.k0(new Object[]{102});
        }
        z16 = false;
        if (n.e().f().f73035i != 3) {
        }
        asVar = this.L;
        if (asVar != null) {
        }
        oj(Boolean.valueOf(z16));
        lk(d16, 33554431);
        this.G.k0(new Object[]{102});
    }

    boolean Xk(long j3) {
        if (n.e().f().f73045k1.size() == 0) {
            n.e().f().w0(j3, "checkRemoteHasVideo.1", false, true);
            return false;
        }
        if (n.e().f().f73045k1.size() == 1 && n.e().f().f73045k1.get(0).f73827a == this.B0) {
            n.e().f().w0(j3, "checkRemoteHasVideo.2", false, true);
            return false;
        }
        n.e().f().w0(j3, "checkRemoteHasVideo.3", true, true);
        return true;
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public boolean Yh() {
        return yt.e.c(this.G.getCurrentAccountUin());
    }

    public void Yk(long j3, SessionInfo sessionInfo, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i(NTBaseVideoFragment.f75610s0, 2, "closeChat, from[" + i3 + "], session[" + sessionInfo + "]");
        }
        ScreenShareCtrl y06 = r.h0().y0();
        if (y06 != null) {
            y06.p(2);
        }
        AVActivity wh5 = wh();
        ScreenRecordHelper d36 = wh5 == null ? null : wh5.d3();
        if (d36 != null) {
            d36.y(1);
        }
        int i16 = 0;
        if (!sessionInfo.B1 && this.f75634x0 != null) {
            if (i3 != 1) {
                if (i3 == 2) {
                    sessionInfo.X(j3, 0L);
                    Oj(3);
                    i16 = 3;
                } else if (i3 == 3) {
                    sessionInfo.X(j3, 0L);
                    Oj(43);
                    i16 = 12;
                }
            }
            final b bVar = new b(j3, i16);
            if (i16 != 0) {
                this.G.M().postDelayed(new Runnable() { // from class: com.tencent.av.ui.fragment.NTDoubleMeetingFragment.4
                    @Override // java.lang.Runnable
                    public void run() {
                        s sVar = NTDoubleMeetingFragment.this.f75634x0;
                        if (sVar != null) {
                            sVar.d(bVar);
                        }
                    }
                }, 1000L);
                return;
            } else {
                this.f75634x0.d(bVar);
                return;
            }
        }
        el(j3, 0);
    }

    void Zk(boolean z16) {
        e eVar;
        this.f75631u0 = z16;
        this.G.k0(new Object[]{28, String.valueOf(this.f75636z0), Boolean.valueOf(z16)});
        if (!this.f75631u0 || (eVar = this.D0) == null) {
            return;
        }
        eVar.x9();
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void ak(int i3) {
        AVToolBarPart aVToolBarPart = this.Y;
        if (aVToolBarPart != null) {
            aVToolBarPart.ga(i3);
        }
    }

    void al(long j3) {
        r.h0().K0();
        lk(j3, 33554431);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        com.tencent.av.ui.part.base.c cVar = new com.tencent.av.ui.part.base.c();
        this.R = cVar;
        assembleParts.add(cVar);
        AVToolBarPart aVToolBarPart = new AVToolBarPart(100);
        this.Y = aVToolBarPart;
        assembleParts.add(aVToolBarPart);
        d dVar = new d(this.J, true);
        this.f75622k0 = dVar;
        assembleParts.add(dVar);
        AVNameAndHeadPart aVNameAndHeadPart = new AVNameAndHeadPart(true);
        this.C0 = aVNameAndHeadPart;
        assembleParts.add(aVNameAndHeadPart);
        e eVar = new e();
        this.D0 = eVar;
        assembleParts.add(eVar);
        return assembleParts;
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public boolean bi() {
        if (r.h0() == null || isDestroyed()) {
            return false;
        }
        return n.e().f().N() || n.e().f().L();
    }

    void bl(long j3, ArrayList<com.tencent.av.gaudio.c> arrayList) {
        if (arrayList.size() == 0) {
            if (QLog.isColorLevel()) {
                QLog.e(NTBaseVideoFragment.f75610s0, 2, "notifyShowVideo-->info list is null");
                return;
            }
            return;
        }
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            if (i3 < arrayList.size()) {
                if (arrayList.get(i3).f73827a == this.B0 && !n.e().f().N) {
                    arrayList.remove(i3);
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        ControlUIObserver controlUIObserver = this.I;
        Object[] objArr = new Object[4];
        objArr[0] = 103;
        objArr[1] = arrayList;
        objArr[2] = Long.valueOf(j3);
        objArr[3] = Boolean.valueOf(size != arrayList.size());
        controlUIObserver.update(null, objArr);
        AVNameAndHeadPart aVNameAndHeadPart = this.C0;
        if (aVNameAndHeadPart == null || !aVNameAndHeadPart.I9()) {
            return;
        }
        Wk(n.e().f().f73035i);
    }

    void cl(long j3) {
        AVActivity aVActivity = (AVActivity) this.F.get();
        if (aVActivity == null) {
            if (QLog.isColorLevel()) {
                QLog.d(NTBaseVideoFragment.f75610s0, 2, "processExtraData-->can not get the activity");
            }
            Zk(true);
            return;
        }
        Intent intent = aVActivity.getIntent();
        boolean booleanExtra = intent != null ? intent.getBooleanExtra("isEnter", false) : false;
        SessionInfo i3 = n.e().i(n.b(100, String.valueOf(this.f75636z0), new int[0]));
        if (QLog.isColorLevel()) {
            QLog.i(NTBaseVideoFragment.f75610s0, 2, "processExtraData uin[" + this.f75636z0 + "], info[" + i3 + "]");
        }
        if (!booleanExtra && (i3 == null || !i3.u())) {
            if (i3 == null || i3.f73043k == 0) {
                r h06 = r.h0();
                long j16 = this.f75636z0;
                h06.y3(3, j16, 8, new long[]{j16}, false, null);
                Cj(j3, R.string.djr);
                return;
            }
            return;
        }
        TraeHelper.I().k0(j3);
        TraeHelper.n0(this.G);
        if (i3 != null && i3.f73043k == 0) {
            Zk(true);
        } else {
            r.h0().a(j3, 3, this.f75636z0, null, false);
            Cj(j3, R.string.db6);
        }
    }

    void dl(boolean z16) {
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "quitDoubleVideoMeeting, needAnimation[" + z16 + "], seq[" + d16 + "]");
        }
        if (z16) {
            Gi();
            r.h0().Y1(d16, this.f75636z0, false, 2);
            this.f75631u0 = true;
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void ej(long j3) {
        if (QLog.isColorLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "onResume, seq[" + j3 + "]");
        }
        super.ej(j3);
        refreshUI();
        n.e().f().B1 = false;
        n.e().f().A1 = false;
        if (n.e().f().f73064p0) {
            if (n.e().f().N() || n.e().f().L()) {
                super.dk(j3);
            }
            as asVar = this.L;
            if (asVar != null) {
                asVar.m(n.e().f().f73035i == 3);
                this.L.n(n.e().f().f73035i == 3);
            }
            kl();
            jl();
        }
        this.G.A0(0, this.f75635y0);
    }

    void fl(long j3, long j16, long j17, int i3) {
        if (QLog.isColorLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "refreshUI, relationId[" + j16 + "], friendUin[" + j17 + "], refreshType[" + i3 + "], isAVActivityBackground[" + n.e().f().B1 + "]");
        }
        if (n.e().f().B1) {
            return;
        }
        RefreshUIRunnable refreshUIRunnable = new RefreshUIRunnable(j3, i3, j17);
        AVActivity aVActivity = (AVActivity) this.F.get();
        if (aVActivity == null) {
            if (QLog.isColorLevel()) {
                QLog.e(NTBaseVideoFragment.f75610s0, 2, "refreshUI-->Can not get AVActivity");
                return;
            }
            return;
        }
        aVActivity.runOnUiThread(refreshUIRunnable);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void gi(long j3, boolean z16) {
        if (isDestroyed()) {
            return;
        }
        SessionInfo f16 = n.e().f();
        if (!f16.O) {
            Wk(f16.f73035i);
        } else {
            lk(j3, 33554431);
        }
    }

    void gl(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(NTBaseVideoFragment.f75610s0, 2, "removeRequestVideoTimeoutRunnbale-->Function = " + str);
        }
        if (this.E0 != null) {
            this.G.M().removeCallbacks(this.E0);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void hi(long j3, boolean z16, int i3) {
        if (QLog.isColorLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "onAfterOpenCamera, success[" + z16 + "], preSessionType[" + i3 + "], seq[" + j3 + "]");
        }
        if (isDestroyed()) {
            return;
        }
        SessionInfo f16 = n.e().f();
        if (f16.B1) {
            return;
        }
        lk(j3, 33554431);
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d(NTBaseVideoFragment.f75610s0, 2, "Go On Stage onAfterOpenCamera");
            }
            r.h0().L0();
            if (f16.O || this.J == null) {
                return;
            }
            Wk(f16.f73035i);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(NTBaseVideoFragment.f75610s0, 2, "Open Camera Failed");
        }
    }

    public void hl() {
        if (QLog.isColorLevel()) {
            QLog.d(NTBaseVideoFragment.f75610s0, 2, "request peer video");
        }
        if (r.h0() != null && !isDestroyed()) {
            if (n.e().f().f73045k1.size() == 0) {
                if (QLog.isColorLevel()) {
                    QLog.e(NTBaseVideoFragment.f75610s0, 2, "Peer VideoInfoList Size is null");
                }
                r.h0().B3("Meeting_requestPeerVideo");
                return;
            }
            n.e().f().f73057n1.clear();
            for (int i3 = 0; i3 < n.e().f().f73045k1.size(); i3++) {
                if (n.e().f().f73045k1.get(i3).f73827a != this.B0) {
                    n.e().f().f73057n1.add(n.e().f().f73045k1.get(i3));
                }
            }
            ml(false);
            r.h0().m2(false);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(NTBaseVideoFragment.f75610s0, 2, "requestPeerVideo-->ERROR mVideoControl is NULL");
        }
    }

    void il(String str) {
        this.F0.f75644d = str;
        this.G.M().removeCallbacks(this.F0);
        this.G.M().postDelayed(this.F0, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void initUI() {
        super.initUI();
        as k3 = as.k(this.L, getActivity(), new a());
        this.L = k3;
        k3.r(true);
        if (((AVActivity) this.F.get()) == null) {
            if (QLog.isColorLevel()) {
                QLog.d(NTBaseVideoFragment.f75610s0, 2, "initUI-->activity is null");
            }
            Zk(true);
        }
    }

    void jl() {
        if (QLog.isColorLevel()) {
            QLog.d(NTBaseVideoFragment.f75610s0, 2, "resumeUI");
        }
        if (n.e().f().f73064p0) {
            d dVar = this.f75622k0;
            if (dVar != null) {
                dVar.ja();
            }
            Wk(n.e().f().f73035i);
            mk(0L);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void kj(long j3) {
        if (QLog.isColorLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "onStart, seq[" + j3 + "]");
        }
        super.kj(j3);
    }

    void kl() {
        SessionInfo f16 = n.e().f();
        boolean z16 = f16.O;
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "resumeVideo, remoteHasVideo[" + z16 + "], displayViewList[" + f16.f73045k1.size() + "], seq[" + d16 + "], \nsessionInfo[" + f16 + "]");
        }
        if (f16.f73035i == 4 && !f16.N && (f16.f73045k1.size() == 0 || !z16)) {
            f16.p0(d16, "resumeVideo", 3);
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "resumeVideo, fix SessionType");
        }
        ArrayList arrayList = new ArrayList();
        com.tencent.av.gaudio.c cVar = new com.tencent.av.gaudio.c();
        if (!TextUtils.isEmpty(f16.f73091w)) {
            cVar.f73827a = Long.parseLong(f16.f73091w);
        }
        cVar.f73828b = 1;
        arrayList.add(cVar);
        com.tencent.av.gaudio.c cVar2 = new com.tencent.av.gaudio.c();
        if (!TextUtils.isEmpty(f16.f73091w)) {
            cVar2.f73827a = Long.parseLong(f16.f73091w);
        }
        cVar2.f73828b = 2;
        arrayList.add(cVar2);
        this.I.update(null, new Object[]{104, arrayList});
        if (f16.N) {
            if (QLog.isColorLevel()) {
                QLog.d(NTBaseVideoFragment.f75610s0, 2, "Go On Stage ");
            }
            r.h0().L0();
        }
        if (f16.N && !f16.O) {
            this.f75633w0 = true;
        }
        if (f16.f73045k1.size() > 0) {
            hl();
        }
        sh();
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void lj(long j3) {
        boolean z16 = this.C != 4 && this.H0;
        this.H0 = false;
        if (QLog.isColorLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "onStop, seq[" + j3 + "]interceptStopAction:=" + z16);
        }
        if (!z16) {
            super.lj(j3);
        }
        if (r.h0() == null || isDestroyed()) {
            return;
        }
        n.e().f().B1 = true;
    }

    void ll(long j3, boolean z16, int i3, long j16) {
        if (QLog.isColorLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "showOrClosePeerVideo, bShow[" + z16 + "], videoSrcType[" + i3 + "], friendUin[" + j16 + "], seq[" + j3 + "]");
        }
        Xk(j3);
        if (!n.e().f().O) {
            gl("showOrClosePeerVideo");
        }
        if (z16) {
            il("showOrClosePeerVideo");
            return;
        }
        com.tencent.av.gaudio.c cVar = new com.tencent.av.gaudio.c();
        cVar.f73827a = j16;
        cVar.f73828b = i3;
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        this.I.update(null, new Object[]{104, arrayList});
        if (i3 == 2) {
            cw.e.d(this.G, 1036);
        }
        if (n.e().f().f73045k1.size() > 0) {
            il("showOrClosePeerVideo");
            return;
        }
        n.e().f().w0(j3, "showOrClosePeerVideo", false, true);
        r.h0().B3("Meeting_showOrClosePeerVideo");
        Wk(n.e().f().f73035i);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void mi(long j3, View view) {
        if (QLog.isColorLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "onClick, id[" + com.tencent.av.utils.e.h(view, view.getId()) + "], seq[" + j3 + "]");
        }
        super.mi(j3, view);
        SessionInfo f16 = n.e().f();
        String str = f16.f73091w;
        int id5 = view.getId();
        if (id5 == m.l.f76080z) {
            AVHidePart aVHidePart = this.f75619h0;
            if (aVHidePart != null) {
                aVHidePart.G9();
                return;
            }
            return;
        }
        if (id5 == m.l.f76063i) {
            QLog.d(NTBaseVideoFragment.f75610s0, 1, "onClick QavPanel.ViewID.LEAVE_MSG");
            r.h0().y2(f16.f73067q, str, f16.f73099y, null, true);
            return;
        }
        if (id5 != m.l.S && id5 != m.e.f76024k) {
            if (id5 != m.l.Q && id5 != m.e.f76029p) {
                if (id5 == m.e.f76015b) {
                    Ei(j3, view);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.e(NTBaseVideoFragment.f75610s0, 2, "Error View Id.ID=" + view.getId());
                    return;
                }
                return;
            }
            zi(j3, view);
            return;
        }
        this.H0 = true;
        yi(j3, view);
    }

    void ml(boolean z16) {
        h hVar = this.X;
        if (hVar != null) {
            hVar.F9(z16);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void oi(long j3, View view) {
        AVCameraPart aVCameraPart = this.f75613b0;
        if (aVCameraPart != null) {
            aVCameraPart.O9(j3, view);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void oj(Boolean bool) {
        AVNetConnectInfoPart aVNetConnectInfoPart;
        if (bool.booleanValue() && (aVNetConnectInfoPart = this.T) != null) {
            aVNetConnectInfoPart.O9(8);
        }
        Pk();
        super.oj(bool);
    }

    public void ol(final long j3, final boolean z16) {
        e eVar;
        if (QLog.isColorLevel()) {
            QLog.i(NTBaseVideoFragment.f75610s0, 2, "updateWhenCreateOrEnterRoomSuc, seq[" + j3 + "], create[" + z16 + "]");
        }
        if (r.h0() == null || isDestroyed() || this.F == null || this.G == null) {
            return;
        }
        SessionInfo f16 = n.e().f();
        f16.z0("onEnterRoomSuc", true);
        f16.f73097x1 = true;
        if (TextUtils.isEmpty(f16.f73091w)) {
            f16.f73091w = String.valueOf(f16.P0);
        }
        r.h0().x3(3, 0, true, true, f16.f73091w);
        if (!this.f75631u0 && (eVar = this.D0) != null) {
            eVar.A9();
        }
        final AVActivity aVActivity = (AVActivity) this.F.get();
        if (aVActivity != null && !aVActivity.isFinishing()) {
            aVActivity.runOnUiThread(new Runnable() { // from class: com.tencent.av.ui.fragment.NTDoubleMeetingFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    NTDoubleMeetingFragment.this.jl();
                    aVActivity.U2(4);
                    if (!z16 || r.h0() == null || NTDoubleMeetingFragment.this.isDestroyed()) {
                        return;
                    }
                    NTDoubleMeetingFragment.this.Cj(j3, R.string.d95);
                }
            });
        }
        if (f16.f73062o2) {
            this.G.M().postDelayed(new Runnable() { // from class: com.tencent.av.ui.fragment.NTDoubleMeetingFragment.6
                @Override // java.lang.Runnable
                public void run() {
                    if (r.h0() == null || NTDoubleMeetingFragment.this.isDestroyed() || !n.e().f().f73062o2) {
                        return;
                    }
                    r.h0().P2(j3, 4, false, false);
                    NTDoubleMeetingFragment.this.f75633w0 = true;
                    r.h0().L0();
                }
            }, 500L);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public boolean onBackPressed() {
        AVHidePart aVHidePart = this.f75619h0;
        if (aVHidePart == null) {
            return false;
        }
        aVHidePart.F9();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        WeakReference<Context> weakReference = this.F;
        s sVar = new s(weakReference == null ? null : weakReference.get(), 2, this.J, this.H.findViewById(m.d.f76006d), null, this.C0.F9(), this.C0.G9(), this.H.findViewById(m.n.f76083a), null);
        this.f75634x0 = sVar;
        sVar.b();
        this.f75618g0.L9(this.f75634x0);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void pj(long j3) {
        super.pj(j3);
        d dVar = this.f75622k0;
        if (dVar != null) {
            dVar.da();
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void qj(long j3) {
        super.qj(j3);
        d dVar = this.f75622k0;
        if (dVar != null) {
            dVar.ea();
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void refreshUI() {
        super.refreshUI();
        AVNameAndHeadPart aVNameAndHeadPart = this.C0;
        if (aVNameAndHeadPart != null) {
            aVNameAndHeadPart.P9();
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void ri(long j3) {
        d dVar = this.f75622k0;
        if (dVar != null) {
            dVar.R9();
        }
        super.yj(j3);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void ti(long j3) {
        super.yj(j3);
        com.tencent.av.ui.part.dav.panel.d dVar = this.f75620i0;
        if (dVar != null) {
            dVar.G9(j3, true);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void wi(long j3, View view) {
        d dVar = this.f75622k0;
        if (dVar != null) {
            dVar.W9(j3, view);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void zi(long j3, View view) {
        super.zi(j3, view);
        Ek();
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void si(long j3, View view) {
        Ph(true);
        Yk(j3, n.e().f(), 1);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void yi(long j3, View view) {
        nl(false);
        super.yi(j3, view);
        com.tencent.av.screenshare.c.a("0X800AD8D");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class RefreshUIRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        long f75645d;

        /* renamed from: e, reason: collision with root package name */
        int f75646e;

        /* renamed from: f, reason: collision with root package name */
        long f75647f;

        public RefreshUIRunnable(long j3, int i3, long j16) {
            this.f75647f = j3;
            this.f75645d = j16;
            this.f75646e = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NTDoubleMeetingFragment.this.isDestroyed()) {
                return;
            }
            a(this.f75646e, this.f75645d);
        }

        private void a(int i3, long j3) {
            if (i3 == 1) {
                NTDoubleMeetingFragment.this.ll(this.f75647f, true, 1, j3);
                return;
            }
            if (i3 == 2) {
                NTDoubleMeetingFragment.this.ll(this.f75647f, false, 1, j3);
                return;
            }
            if (i3 == 3) {
                NTDoubleMeetingFragment.this.ll(this.f75647f, true, 2, j3);
                return;
            }
            if (i3 == 4) {
                NTDoubleMeetingFragment.this.ll(this.f75647f, false, 2, j3);
                return;
            }
            if (i3 == 5) {
                NTDoubleMeetingFragment.this.Dj(this.f75647f, null);
                NTDoubleMeetingFragment.super.dk(this.f75647f);
                return;
            }
            if (i3 == 6) {
                NTDoubleMeetingFragment nTDoubleMeetingFragment = NTDoubleMeetingFragment.this;
                if (j3 != nTDoubleMeetingFragment.B0) {
                    nTDoubleMeetingFragment.dl(true);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.w(NTBaseVideoFragment.f75610s0, 1, "refreshUI, ERROR, refreshType[" + i3 + "], friendUin[" + j3 + "], seq[" + this.f75647f + "]");
            }
        }
    }

    void el(long j3, int i3) {
        TraeHelper.I().k0(j3);
        if (!n.e().f().M0) {
            super.yj(j3);
        }
        this.f75631u0 = true;
        r.h0().Y1(j3, this.f75636z0, true, i3);
        super.ek(j3);
        Zk(true);
        ReportController.o(null, "CliOper", "", "", "0X8005206", "0X8005206", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Pj(long j3, int i3) {
        Sj(j3, 360 - i3);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void ki(long j3) {
        lk(j3, 33554431);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void rj(String str, int i3, String str2, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d(NTBaseVideoFragment.f75610s0, 2, "onVideoViewChange-->BigViewUin = " + str + " ,BigViewVideoSrcType = " + i3 + " ,SmallViewUin = " + str2 + " ,SmallViewVideoSrcType = " + i16);
        }
        long q16 = AVUtil.q(str);
        long q17 = AVUtil.q(str2);
        if (q16 == 0 || q17 == 0) {
            return;
        }
        if (i3 == 2) {
            cw.e.d(this.G, 1036);
        }
        int q18 = n.e().f().q(q16, i3);
        int q19 = n.e().f().q(q17, i16);
        if (QLog.isColorLevel()) {
            QLog.d(NTBaseVideoFragment.f75610s0, 2, "onVideoViewChange-->BigViewIndex = " + q18 + " ,SmallViewIndex = " + q19);
        }
        if (q18 == -1 || q19 == -1) {
            return;
        }
        com.tencent.av.gaudio.c cVar = n.e().f().f73045k1.get(q18);
        com.tencent.av.gaudio.c cVar2 = n.e().f().f73045k1.get(q19);
        cVar2.f73829c = true;
        cVar.f73829c = false;
        n.e().f().f73045k1.set(q18, cVar2);
        n.e().f().f73045k1.set(q19, cVar);
        if (QLog.isColorLevel()) {
            String I0 = r.h0().I0(n.e().f().f73045k1);
            QLog.d(NTBaseVideoFragment.f75610s0, 2, "onVideoViewChange finish" + I0);
        }
        synchronized (n.e().f().f73053m1) {
            if (q18 < n.e().f().f73053m1.size()) {
                n.e().f().f73053m1.set(q18, cVar2);
            }
            if (q19 < n.e().f().f73053m1.size()) {
                n.e().f().f73053m1.set(q19, cVar);
            }
            n.e().f().S();
        }
        if (((AVActivity) this.F.get()).J0 != null) {
            ((AVActivity) this.F.get()).J0.K2(cVar.f73827a, cVar.f73828b, cVar2.f73827a, cVar2.f73828b);
        }
        hl();
        if (q17 == this.B0) {
            ReportController.o(null, "CliOper", "", "", "0X800520E", "0X800520E", 0, 0, "", "", "", "");
            return;
        }
        if (q17 == this.f75636z0) {
            ReportController.o(null, "CliOper", "", "", "0X800520F", "0X800520F", 0, 0, "", "", "", "");
            if (this.f75632v0) {
                ReportController.o(null, "CliOper", "", "", "0X8005213", "0X8005213", 0, 0, "", "", "", "");
            } else {
                ReportController.o(null, "CliOper", "", "", "0X8005212", "0X8005212", 0, 0, "", "", "", "");
            }
        }
    }

    public NTDoubleMeetingFragment(VideoAppInterface videoAppInterface, AVActivity aVActivity, ControlUIObserver controlUIObserver) {
        super(videoAppInterface, aVActivity, controlUIObserver);
        this.f75631u0 = false;
        this.f75632v0 = false;
        this.f75633w0 = false;
        this.f75634x0 = null;
        this.f75635y0 = null;
        this.E0 = null;
        this.F0 = new QueryPeerVideoRunnable();
        this.G0 = new GAudioUIObserver() { // from class: com.tencent.av.ui.fragment.NTDoubleMeetingFragment.1
            @Override // com.tencent.av.app.GAudioUIObserver
            protected void D(long j3, long j16) {
                if (QLog.isColorLevel()) {
                    QLog.i(AVConstants.SHARE_TAG, 2, "onMeetingNotifyTimeout, relationId[" + j16 + "]");
                }
                SessionInfo f16 = n.e().f();
                NTDoubleMeetingFragment nTDoubleMeetingFragment = NTDoubleMeetingFragment.this;
                if (j16 == nTDoubleMeetingFragment.f75636z0 && f16.P0 == j16) {
                    nTDoubleMeetingFragment.Yk(j3, f16, 3);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.av.app.GAudioUIObserver
            public void F(long j3, long j16, boolean z16, boolean z17) {
                long d16 = com.tencent.av.utils.e.d();
                if (QLog.isColorLevel()) {
                    QLog.w(NTBaseVideoFragment.f75610s0, 1, "onMemberJoin, groupId[" + j3 + "], friendUin[" + j16 + "], isRfresh[" + z16 + "], isQQUser[" + z17 + "], seq[" + d16 + "]");
                }
                if (j16 == NTDoubleMeetingFragment.this.f75636z0) {
                    n.e().f().f73058n2 = 1;
                    NTDoubleMeetingFragment.this.fl(d16, j3, j16, 5);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.av.app.GAudioUIObserver
            public void G(long j3, long j16, boolean z16, boolean z17) {
                long d16 = com.tencent.av.utils.e.d();
                if (QLog.isColorLevel()) {
                    QLog.w(NTBaseVideoFragment.f75610s0, 1, "onMemberLeave, groupId[" + j3 + "], friendUin[" + j16 + "], isQQUser[" + z16 + "], seq[" + d16 + "]");
                }
                NTDoubleMeetingFragment.this.fl(d16, j3, j16, 6);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.av.app.GAudioUIObserver
            public void J(long j3, long j16) {
                long d16 = com.tencent.av.utils.e.d();
                if (QLog.isColorLevel()) {
                    QLog.w(NTBaseVideoFragment.f75610s0, 1, "onMemberVideoIn, groupId[" + j3 + "], friendUin[" + j16 + "], seq[" + d16 + "]");
                }
                NTDoubleMeetingFragment.this.fl(d16, j3, j16, 1);
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void K(long j3, long j16, long j17, int i3) {
                if (QLog.isColorLevel()) {
                    QLog.w(NTBaseVideoFragment.f75610s0, 1, "onMemberVideoOut, groupId[" + j16 + "], friendUin[" + j17 + "], videoSrcType[" + i3 + "], seq[" + j3 + "]");
                }
                NTDoubleMeetingFragment.this.fl(j3, j16, j17, 2);
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void g(long j3, long j16) {
                if (QLog.isColorLevel()) {
                    QLog.d(NTBaseVideoFragment.f75610s0, 2, "onCreateRoomSuc-->relationId = " + j16);
                }
                NTDoubleMeetingFragment nTDoubleMeetingFragment = NTDoubleMeetingFragment.this;
                if (j16 != nTDoubleMeetingFragment.f75636z0) {
                    return;
                }
                nTDoubleMeetingFragment.ol(j3, true);
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void h(long j3, int i3) {
                if (QLog.isColorLevel()) {
                    QLog.d(NTBaseVideoFragment.f75610s0, 2, "onDestroyInviteUI-->GroupId = " + j3);
                }
                if (j3 == NTDoubleMeetingFragment.this.f75636z0) {
                    super.i(j3);
                    NTDoubleMeetingFragment.this.Zk(true);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.av.app.GAudioUIObserver
            public void i(long j3) {
                if (QLog.isColorLevel()) {
                    QLog.d(NTBaseVideoFragment.f75610s0, 2, "onDestory UI-->relationId = " + j3);
                }
                NTDoubleMeetingFragment nTDoubleMeetingFragment = NTDoubleMeetingFragment.this;
                if (nTDoubleMeetingFragment.f75636z0 == j3) {
                    nTDoubleMeetingFragment.Zk(true);
                }
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void k(long j3, long j16) {
                if (QLog.isColorLevel()) {
                    QLog.d(NTBaseVideoFragment.f75610s0, 2, "EnterRoomSuc-->GroupId = " + j16);
                }
                NTDoubleMeetingFragment nTDoubleMeetingFragment = NTDoubleMeetingFragment.this;
                if (j16 == nTDoubleMeetingFragment.f75636z0) {
                    nTDoubleMeetingFragment.dk(j3);
                }
                NTDoubleMeetingFragment.this.ol(j3, false);
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void l(long j3, int i3) {
                if (r.h0() == null || NTDoubleMeetingFragment.this.isDestroyed() || NTDoubleMeetingFragment.this.G == null) {
                    return;
                }
                long d16 = com.tencent.av.utils.e.d();
                if (QLog.isColorLevel()) {
                    QLog.w(NTBaseVideoFragment.f75610s0, 1, "onFirstFrameDataComeIn, uin[" + j3 + "], videoSrcType[" + i3 + "], seq[" + d16 + "]");
                }
                int q16 = n.e().f().q(j3, i3);
                if (q16 != -1 && n.e().f().f73045k1.get(q16).f73829c) {
                    cw.e.d(NTDoubleMeetingFragment.this.G, 1036);
                    cw.e.d(NTDoubleMeetingFragment.this.G, 1037);
                }
                NTDoubleMeetingFragment.super.yj(d16);
                NTDoubleMeetingFragment.this.gl("OnFirstFrameDataComeIn");
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void n() {
                if (QLog.isColorLevel()) {
                    QLog.d(NTBaseVideoFragment.f75610s0, 2, "onGAudioInviteResp");
                }
                AVActivity aVActivity2 = (AVActivity) NTDoubleMeetingFragment.this.F.get();
                if (aVActivity2 == null || aVActivity2.isFinishing()) {
                    return;
                }
                aVActivity2.runOnUiThread(new Runnable() { // from class: com.tencent.av.ui.fragment.NTDoubleMeetingFragment.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ScreenShareCtrl y06 = r.h0().y0();
                        if (y06 != null) {
                            y06.u(NTDoubleMeetingFragment.this.wh(), 1L);
                        }
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.av.app.GAudioUIObserver
            public void u(long j3, long j16, boolean z16, boolean z17) {
                long d16 = com.tencent.av.utils.e.d();
                if (QLog.isColorLevel()) {
                    QLog.w(NTBaseVideoFragment.f75610s0, 1, "onGaMemberShareSrcInOrOut, groupId[" + j3 + "], groupId[" + j3 + "], bIn[" + z16 + "], isPPT[" + z17 + "], seq[" + d16 + "]");
                }
                if (z16) {
                    NTDoubleMeetingFragment.this.fl(d16, j3, j16, 3);
                } else {
                    NTDoubleMeetingFragment.this.fl(d16, j3, j16, 4);
                }
                NTDoubleMeetingFragment.this.f75632v0 = z17;
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void v(long j3, int i3, long j16, long j17, long j18, int i16) {
                if (NTDoubleMeetingFragment.this.isDestroyed()) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.w(NTBaseVideoFragment.f75610s0, 1, "onGaOperationResult, result[" + i3 + "], uin[" + j16 + "], info[" + j17 + "], groupId[" + j18 + "], relationType[" + i16 + "], seq[" + j3 + "]");
                }
                SessionInfo f16 = n.e().f();
                switch (i3) {
                    case 90:
                        if (j17 == 3) {
                            NTDoubleMeetingFragment nTDoubleMeetingFragment = NTDoubleMeetingFragment.this;
                            if (nTDoubleMeetingFragment.J != null && nTDoubleMeetingFragment.getContext() != null) {
                                if (((ICameraUtilsStaticApi) QRoute.api(ICameraUtilsStaticApi.class)).getInstance(NTDoubleMeetingFragment.this.getContext()).getCameraNum() > 1) {
                                    NTDoubleMeetingFragment.this.J.setViewVisibility(m.l.B, 0);
                                } else {
                                    NTDoubleMeetingFragment.this.J.setViewVisibility(m.l.B, 8);
                                }
                            }
                            if (!f16.N || NTDoubleMeetingFragment.this.f75633w0) {
                                NTDoubleMeetingFragment nTDoubleMeetingFragment2 = NTDoubleMeetingFragment.this;
                                nTDoubleMeetingFragment2.f75633w0 = false;
                                nTDoubleMeetingFragment2.ki(j3);
                                int q16 = f16.q(NTDoubleMeetingFragment.this.B0, 1);
                                NTDoubleMeetingFragment.this.G.k0(new Object[]{105, Boolean.valueOf(q16 != -1 ? f16.f73045k1.get(q16).f73829c : false), Long.valueOf(j3)});
                            }
                            NTDoubleMeetingFragment.super.yj(j3);
                            return;
                        }
                        return;
                    case 91:
                    case 92:
                        NTDoubleMeetingFragment.this.gi(j3, true);
                        NTDoubleMeetingFragment.this.al(j3);
                        NTDoubleMeetingFragment.this.G.k0(new Object[]{106, Long.valueOf(j3)});
                        return;
                    case 93:
                    case 94:
                    case 95:
                        NTDoubleMeetingFragment.this.lk(j3, 33554431);
                        return;
                    case 96:
                        if (j17 != 1 || f16.B1) {
                            return;
                        }
                        NTDoubleMeetingFragment.this.Vk("onGaOperationResult->REQUEST_VIDEO_SUC");
                        NTDoubleMeetingFragment.this.bl(j3, f16.f73045k1);
                        return;
                    default:
                        return;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.av.app.GAudioUIObserver
            public void w(long j3, long j16, String str) {
                super.w(j3, j16, str);
                if (QLog.isColorLevel()) {
                    QLog.d(NTBaseVideoFragment.f75610s0, 2, "onGroupSecurityLimit-->groupid=" + j3 + " info=" + j16 + " strMsg=" + str);
                }
                if (j16 < 201 || j16 > 299) {
                    return;
                }
                Intent intent = new Intent();
                intent.setAction("tencent.av.v2q.MultiVideo");
                intent.putExtra("type", 33);
                intent.putExtra("relationId", j3);
                intent.putExtra("uinType", 0);
                intent.putExtra("info", j16);
                intent.putExtra("strMsg", str);
                intent.putExtra("from", "DoubleVideoMeetingCtrlUI");
                AVActivity aVActivity2 = (AVActivity) NTDoubleMeetingFragment.this.F.get();
                if (aVActivity2 != null) {
                    intent.setPackage(NTDoubleMeetingFragment.this.G.getApplication().getPackageName());
                    aVActivity2.sendBroadcast(intent);
                } else if (QLog.isColorLevel()) {
                    QLog.e(NTBaseVideoFragment.f75610s0, 2, "onGroupSecurityLimit-->can not get the activity");
                }
                NTDoubleMeetingFragment.this.el(com.tencent.av.utils.e.d(), -255);
            }
        };
        this.H0 = false;
        String currentAccountUin = this.G.getCurrentAccountUin();
        this.A0 = currentAccountUin;
        this.B0 = Long.valueOf(currentAccountUin).longValue();
        SessionInfo f16 = n.e().f();
        if (!f16.N && !f16.O) {
            f16.p0(-1033L, "DoubleVideoMeetingCtrlUI", 3);
        } else {
            f16.p0(-1033L, "DoubleVideoMeetingCtrlUI", 4);
        }
        f16.f73067q = 0;
        f16.f73099y = this.G.G(0, f16.f73091w, null);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        d dVar;
        if (i3 != 4) {
            if ((i3 == 24 || i3 == 25) && (dVar = this.f75622k0) != null) {
                dVar.na();
            }
            return false;
        }
        if (n.e().f().N) {
            ReportController.o(null, "CliOper", "", "", "0X8005215", "0X8005215", 0, 0, "", "", "", "");
        } else {
            ReportController.o(null, "CliOper", "", "", "0X8005218", "0X8005218", 0, 0, "", "", "", "");
        }
        return false;
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void hk(int i3) {
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void ji(long j3) {
    }
}
