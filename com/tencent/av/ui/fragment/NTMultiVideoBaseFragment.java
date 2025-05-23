package com.tencent.av.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.c;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.m;
import com.tencent.av.ui.part.base.AVHidePart;
import com.tencent.av.ui.part.base.AVNetConnectInfoPart;
import com.tencent.av.ui.part.base.AVToolBarPart;
import com.tencent.av.ui.part.base.e;
import com.tencent.av.ui.part.base.h;
import com.tencent.av.ui.part.base.panel.d;
import com.tencent.av.ui.part.dav.panel.AVCameraPart;
import com.tencent.av.ui.part.mav.AVInviteUserNoticePart;
import com.tencent.av.ui.part.mav.AVMemberListUIPart;
import com.tencent.av.ui.part.mav.AVSmallHomeTipsPart;
import com.tencent.av.ui.part.mav.AVUserNamePart;
import com.tencent.av.ui.part.mav.AudioSuspectNoisyPart;
import com.tencent.av.ui.s;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.VideoUtil;
import com.tencent.av.utils.af;
import com.tencent.av.utils.as;
import com.tencent.av.utils.q;
import com.tencent.av.zplan.QAVControllerForZplan;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class NTMultiVideoBaseFragment extends NTBaseVideoFragment {
    static int T0 = 16;
    int A0;
    s B0;
    Runnable C0;
    Runnable D0;
    Runnable E0;
    public boolean F0;
    boolean G0;
    boolean H0;
    boolean I0;
    AVUserNamePart J0;
    pw.b K0;
    com.tencent.av.ui.part.mav.a L0;
    e M0;
    AVMemberListUIPart N0;
    AudioSuspectNoisyPart O0;
    AVInviteUserNoticePart P0;
    private boolean Q0;
    StartRecvVideoRunnable R0;
    GAudioUIObserver S0;

    /* renamed from: u0, reason: collision with root package name */
    public int f75666u0;

    /* renamed from: v0, reason: collision with root package name */
    int f75667v0;

    /* renamed from: w0, reason: collision with root package name */
    public int f75668w0;

    /* renamed from: x0, reason: collision with root package name */
    long f75669x0;

    /* renamed from: y0, reason: collision with root package name */
    public long f75670y0;

    /* renamed from: z0, reason: collision with root package name */
    long f75671z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class AutoCheckRunnable implements Runnable {
        AutoCheckRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NTMultiVideoBaseFragment.this.Hl();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class RefreshUIRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        long f75672d;

        /* renamed from: e, reason: collision with root package name */
        int f75673e;

        /* renamed from: f, reason: collision with root package name */
        boolean f75674f;

        /* renamed from: h, reason: collision with root package name */
        int f75675h;

        public RefreshUIRunnable(long j3, int i3, boolean z16, int i16) {
            this.f75674f = z16;
            this.f75675h = i16;
            this.f75672d = j3;
            this.f75673e = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            NTMultiVideoBaseFragment.this.Vk(this.f75672d, this.f75673e, this.f75674f, this.f75675h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class RequestVideoTimeOutRunnable implements Runnable {
        RequestVideoTimeOutRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (r.h0() != null && !NTMultiVideoBaseFragment.this.isDestroyed()) {
                r.h0().B3("Multi_RequestVideoTimeOutRunnable");
                NTMultiVideoBaseFragment.this.xl();
                if (NTMultiVideoBaseFragment.this.f75668w0 == 2) {
                    ReportController.o(null, "CliOper", "", "", "0X8004425", "0X8004425", 0, 0, "", "", "", "");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e(NTBaseVideoFragment.f75610s0, 2, "RequestVideoTimeOutRunnable, VideoController.getInstance() = null!!!");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class StartRecvVideoRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        public String f75676d = null;

        StartRecvVideoRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (QLog.isColorLevel()) {
                QLog.d(NTBaseVideoFragment.f75610s0, 2, "StartRecvAllVideoRunnable-->FunctionName=" + this.f75676d);
            }
            NTMultiVideoBaseFragment.this.Il();
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements as.b {
        a() {
        }

        @Override // com.tencent.av.utils.as.b
        public void a() {
            d dVar = NTMultiVideoBaseFragment.this.f75622k0;
            if (dVar != null) {
                dVar.ia();
            }
        }
    }

    public NTMultiVideoBaseFragment() {
        this.f75666u0 = -1;
        this.f75667v0 = -1;
        this.f75668w0 = 0;
        this.f75669x0 = 0L;
        this.f75670y0 = 0L;
        this.f75671z0 = 0L;
        this.A0 = 0;
        this.B0 = null;
        this.C0 = null;
        this.D0 = null;
        this.E0 = null;
        this.F0 = false;
        this.G0 = false;
        this.H0 = true;
        this.I0 = false;
        this.Q0 = false;
        this.R0 = new StartRecvVideoRunnable();
        this.S0 = new b();
    }

    void Al() {
        if (QLog.isColorLevel()) {
            QLog.d(NTBaseVideoFragment.f75610s0, 2, "resumeVideo");
        }
        if (this.C0 == null) {
            this.C0 = new AutoCheckRunnable();
        } else {
            this.G.M().removeCallbacks(this.C0);
        }
        this.G.M().postDelayed(this.C0, 500L);
    }

    void Bl(long j3) {
        if (QLog.isColorLevel()) {
            QLog.d(NTBaseVideoFragment.f75610s0, 2, "sendVideoMsgBroadcast--> discussionId = " + j3);
        }
        if (this.G != null) {
            Intent intent = new Intent();
            intent.setAction("tencent.video.v2q.AddVideoMsg");
            intent.putExtra("uinType", this.f75667v0);
            intent.putExtra(QQBrowserActivity.KEY_MSG_TYPE, 13);
            intent.putExtra("isVideoMsg", false);
            intent.putExtra("friendUin", Long.toString(j3));
            intent.putExtra(AppConstants.Key.COLUMN_MSG_SENDER_UIN, this.G.getCurrentAccountUin());
            intent.putExtra("isSender", true);
            intent.putExtra("isRead", true);
            intent.putExtra("MultiAVType", n.e().f().f73063p);
            intent.setPackage(this.G.getApplication().getPackageName());
            this.G.getApp().sendBroadcast(intent);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public int Ch() {
        return m.j.f76052c;
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Ck(long j3) {
        pw.a aVar = this.f75616e0;
        if (aVar != null) {
            aVar.G9(j3);
        }
    }

    abstract void Cl(int i3, int i16, String str, String str2);

    void Dl(int i3, int i16) {
        QavPanel qavPanel = this.J;
        if (qavPanel == null) {
            return;
        }
        qavPanel.setViewVisibility(i3, i16);
    }

    public void El() {
        e eVar = this.M0;
        if (eVar != null) {
            eVar.z9();
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public long Fh() {
        if (r.h0().W0()) {
            return this.f75670y0;
        }
        return this.f75669x0;
    }

    void Fl(boolean z16, boolean z17, boolean z18) {
        if (QLog.isColorLevel()) {
            QLog.d(NTBaseVideoFragment.f75610s0, 2, "showOrHideRecvVideoBtnAndTips --> bShow = " + z16 + " , needNoticeWiFiTips = " + z17 + " , needShowGLView = " + z18);
        }
        this.Q0 = z16;
        h hVar = this.X;
        if (hVar != null) {
            hVar.G9(z16, z17, z18);
        }
        if (z16) {
            sh();
        }
        if (z18) {
            il(com.tencent.av.utils.e.d(), n.e().f().f73045k1);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Ii() {
        super.Ii();
        if (QLog.isColorLevel()) {
            QLog.d(NTBaseVideoFragment.f75610s0, 2, "OnCreate");
        }
        WeakReference<Context> weakReference = this.F;
        if (weakReference == null) {
            QLog.e(NTBaseVideoFragment.f75610s0, 2, "Can not get mContext");
            return;
        }
        if (((Activity) weakReference.get()) == null) {
            if (QLog.isColorLevel()) {
                QLog.e(NTBaseVideoFragment.f75610s0, 2, "Can not get activity");
            }
        } else {
            this.G.addObserver(this.S0);
            Intent intent = getIntent();
            ql(intent);
            pl(intent);
            r.h0().n2();
        }
    }

    void Jl(boolean z16) {
        if (((Activity) this.F.get()) == null) {
            if (QLog.isColorLevel()) {
                QLog.e(NTBaseVideoFragment.f75610s0, 2, "switchMode --> Can not get activity");
                return;
            }
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) this.H.findViewById(R.id.g8b);
        AVActivity aVActivity = (AVActivity) this.F.get();
        SessionInfo f16 = n.e().f();
        vj();
        if (f16.f73035i != 3) {
            if (z16) {
                relativeLayout.setBackgroundColor(this.E.getColor(R.color.ajr));
            } else {
                relativeLayout.setBackgroundColor(this.E.getColor(R.color.f157525s3));
            }
        }
        if (z16) {
            aVActivity.X3(false);
            aVActivity.U3();
        } else {
            aVActivity.X3(true);
            aVActivity.U3();
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Ki(long j3) {
        if (QLog.isColorLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "OnDestroy, seq[" + j3 + "]");
        }
        r.h0().o2();
        VideoAppInterface videoAppInterface = this.G;
        if (videoAppInterface != null) {
            videoAppInterface.deleteObserver(this.S0);
            this.G.M().removeCallbacks(this.C0);
            this.G.M().removeCallbacks(this.D0);
            this.G.M().removeCallbacks(this.E0);
        }
        this.C0 = null;
        this.D0 = null;
        this.E0 = null;
        Oh();
        cw.e.d(this.G, 1030);
        cw.e.d(this.G, 1036);
        cw.e.d(this.G, 1037);
        cw.e.d(this.G, 3015);
        cw.e.d(this.G, 1034);
        cw.e.d(this.G, 1035);
        as asVar = this.L;
        if (asVar != null) {
            asVar.r(false);
            this.L.n(false);
            this.L.m(false);
            this.L = null;
        }
        ViewGroup viewGroup = this.H;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        s sVar = this.B0;
        if (sVar != null) {
            sVar.a();
            this.B0 = null;
        }
        super.Ki(j3);
    }

    void Kl(String str, long j3) {
        SessionInfo f16;
        boolean z16;
        VideoLayerUI videoLayerUI;
        if (r.h0() == null || this.F == null || isDestroyed() || (f16 = n.e().f()) == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "switchUIMode[" + str + "], SessionType[" + f16.f73035i + "], seq[" + j3 + "]");
        }
        int i3 = f16.f73035i;
        if (i3 == 4) {
            as asVar = this.L;
            if (asVar != null) {
                asVar.m(false);
                this.L.n(false);
            }
            if (((AVActivity) this.F.get()).J0 != null) {
                ((AVActivity) this.F.get()).J0.v3(n.e().f().O1);
                ((AVActivity) this.F.get()).J0.r3(n.e().f());
            }
            rl();
            zj(true, (f16.N || f16.O) ? 2 : 1);
            Jl(true);
            z16 = true;
        } else {
            this.H.setVisibility(0);
            Vj(true);
            as asVar2 = this.L;
            if (asVar2 != null) {
                asVar2.m(true);
                this.L.n(true);
            }
            AVActivity aVActivity = (AVActivity) this.F.get();
            if (!aVActivity.isFinishing() && (videoLayerUI = aVActivity.J0) != null) {
                videoLayerUI.v3(-1);
            }
            rl();
            zj(false, 1);
            Jl(false);
            Sj(j3, 0.0f);
            z16 = false;
        }
        AVMemberListUIPart aVMemberListUIPart = this.N0;
        if (aVMemberListUIPart != null) {
            aVMemberListUIPart.I9(i3);
        }
        d dVar = this.f75622k0;
        if (dVar != null) {
            dVar.pa(i3 == 4, false);
        }
        AVNetConnectInfoPart aVNetConnectInfoPart = this.T;
        if (aVNetConnectInfoPart != null) {
            aVNetConnectInfoPart.T9(i3 == 4);
        }
        oj(Boolean.valueOf(z16));
        lk(j3, 33554431);
        this.G.k0(new Object[]{102});
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Ni(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(NTBaseVideoFragment.f75610s0, 2, "onLayoutModeChange --> ScreenType = " + i3 + " , hasSetBigVideoView = " + n.e().f().s());
        }
        if (i3 == 3) {
            if (4 == r.h0().H0()) {
                Iterator<c> it = n.e().f().f73045k1.iterator();
                while (it.hasNext()) {
                    c next = it.next();
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
                Iterator<c> it5 = n.e().f().f73045k1.iterator();
                while (it5.hasNext()) {
                    c next2 = it5.next();
                    if (!next2.f73829c) {
                        next2.f73831e = true;
                    }
                }
            } else if (n.e().f().f73045k1.size() > 0) {
                n.e().f().f73045k1.get(0).f73831e = true;
            }
        }
        Il();
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    void Nk(long j3) {
        pw.b bVar = this.K0;
        if (bVar != null) {
            bVar.D9(j3);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Pi(long j3, int i3, int i16) {
        d dVar = this.f75622k0;
        if (dVar != null) {
            dVar.X9(j3, i3, i16);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Pj(long j3, int i3) {
        this.K = i3;
        if (r.h0() == null || isDestroyed() || n.e().f().t()) {
            return;
        }
        int i16 = 360 - i3;
        Sj(j3, i16);
        com.tencent.av.ui.part.base.panel.c cVar = this.f75618g0;
        if (cVar != null) {
            cVar.M9(i16);
        }
        com.tencent.av.ui.part.mav.a aVar = this.L0;
        if (aVar != null) {
            aVar.C9(i3);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Qi(long j3, int i3, int i16) {
        d dVar = this.f75622k0;
        if (dVar != null) {
            dVar.H9(i3, i16);
        }
    }

    void Sk(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(NTBaseVideoFragment.f75610s0, 2, "addRequestVideoTimeoutRunnable[" + str + "]");
        }
        if (this.D0 != null) {
            this.G.M().removeCallbacks(this.D0);
        } else {
            this.D0 = new RequestVideoTimeOutRunnable();
        }
        this.G.M().postDelayed(this.D0, 30000L);
    }

    boolean Tk(long j3) {
        if (r.h0() != null && !isDestroyed()) {
            SessionInfo f16 = n.e().f();
            if (QLog.isColorLevel()) {
                QLog.w(NTBaseVideoFragment.f75610s0, 1, "checkRemoteVideo, displayViewList[" + f16.f73045k1.size() + "], seq[" + j3 + "]");
            }
            if (f16.f73045k1.size() == 0) {
                Uk(j3, "checkRemoteVideo");
                Fl(false, false, false);
                return false;
            }
            if (f16.f73045k1.size() != 1 || f16.f73045k1.get(0).f73827a != this.f75671z0) {
                return true;
            }
            Fl(false, false, false);
            wl();
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.e(NTBaseVideoFragment.f75610s0, 2, "checkRemoteVideo --> VideoController is null");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Uk(long j3, String str) {
        if (QLog.isColorLevel()) {
            String str2 = NTBaseVideoFragment.f75610s0;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("closeRemoteVideo[");
            sb5.append(str);
            sb5.append("], seq[");
            sb5.append(j3);
            sb5.append("], VideoController.getInstance()[");
            sb5.append(r.h0() != null);
            sb5.append("]");
            QLog.d(str2, 2, sb5.toString());
        }
        if (r.h0() == null || this.F == null || isDestroyed()) {
            return;
        }
        r.h0().B3("Multi_closeRemoteVideo");
        n.e().f().w0(j3, "closeRemoteVideo", false, true);
        Kl("closeRemoteVideo", j3);
        wl();
        ControlUIObserver controlUIObserver = this.I;
        if (controlUIObserver != null) {
            controlUIObserver.update(null, new Object[]{104, n.e().f().f73045k1});
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Wi(long j3) {
        if (QLog.isColorLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "OnPause, seq[" + j3 + "]");
        }
        super.Wi(j3);
        if (r.h0() != null && !isDestroyed() && this.G != null) {
            n.e().f().A1 = true;
            this.G.C0("MultiVideoCtrlLayerUIBase");
            if (r.h0() != null && !isDestroyed()) {
                WeakReference<Context> weakReference = this.F;
                Context context = weakReference == null ? null : weakReference.get();
                if ((!SmallScreenUtils.w() || (!NetworkUtil.isWifiConnected(context) && !n.e().f().C1)) && n.e().f().N) {
                    Xk(j3);
                }
                if (n.e().f().o() != -1) {
                    r.h0().B3("Multi_onPause");
                }
                n.e().f().V(this.f75671z0, true, true);
            }
            this.G.M().removeCallbacks(this.R0);
            AVToolBarPart aVToolBarPart = this.Y;
            if (aVToolBarPart != null) {
                aVToolBarPart.onPause();
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(NTBaseVideoFragment.f75610s0, 2, "OnPause Error : VideoController is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Wk(boolean z16) {
        e eVar;
        this.F0 = z16;
        this.G.k0(new Object[]{28, String.valueOf(this.f75669x0), Boolean.valueOf(z16)});
        if (!this.F0 || (eVar = this.M0) == null) {
            return;
        }
        eVar.x9();
    }

    public void Xk(long j3) {
        if (QLog.isColorLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "goOffStage, seq[" + j3 + "]");
        }
        if (r.h0() != null && !isDestroyed() && this.I != null && this.J != null) {
            r.h0().K0();
            n.e().f().w0(j3, "goOffStage", false, false);
            this.I.update(null, new Object[]{106, Long.valueOf(j3)});
            Dl(m.l.A, 8);
            nj(false);
            Kl("goOffStage", j3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(NTBaseVideoFragment.f75610s0, 2, "goOffStage --> Error");
        }
    }

    boolean Yk() {
        if (QLog.isColorLevel()) {
            QLog.d(NTBaseVideoFragment.f75610s0, 2, "Go on Stage");
        }
        if (r.h0() != null && !isDestroyed()) {
            return r.h0().L0();
        }
        if (!QLog.isColorLevel()) {
            return false;
        }
        QLog.e(NTBaseVideoFragment.f75610s0, 2, "Go On Stage, VideoController is null");
        return false;
    }

    abstract void Zk();

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void ak(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(NTBaseVideoFragment.f75610s0, 2, "showToolBars");
        }
        AVToolBarPart aVToolBarPart = this.Y;
        if (aVToolBarPart != null) {
            aVToolBarPart.ga(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void al(long j3, int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "onGroupVideoChatClosed, relationId[" + j3 + "], mIntentRelationId[" + this.f75669x0 + "]");
        }
        if (this.f75669x0 != j3) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("tencent.av.v2q.MultiVideo");
        intent.putExtra("type", 32);
        intent.putExtra("relationId", j3);
        intent.putExtra("uinType", this.f75667v0);
        intent.putExtra(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLOSE_TYPE, i3);
        intent.putExtra("MultiAVType", i16);
        intent.putExtra("from", NTBaseVideoFragment.f75610s0);
        AVActivity aVActivity = (AVActivity) this.F.get();
        if (aVActivity != null) {
            intent.setPackage(this.G.getApplication().getPackageName());
            aVActivity.sendBroadcast(intent);
            Wk(true);
        } else if (QLog.isColorLevel()) {
            QLog.e(NTBaseVideoFragment.f75610s0, 2, "onGroupVideoChatClosed-->can not get the activity");
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        AVUserNamePart aVUserNamePart = new AVUserNamePart();
        this.J0 = aVUserNamePart;
        assembleParts.add(aVUserNamePart);
        AVSmallHomeTipsPart aVSmallHomeTipsPart = new AVSmallHomeTipsPart();
        this.W = aVSmallHomeTipsPart;
        assembleParts.add(aVSmallHomeTipsPart);
        pw.b bVar = new pw.b(this.J);
        this.K0 = bVar;
        assembleParts.add(bVar);
        com.tencent.av.ui.part.mav.a aVar = new com.tencent.av.ui.part.mav.a();
        this.L0 = aVar;
        assembleParts.add(aVar);
        e eVar = new e();
        this.M0 = eVar;
        assembleParts.add(eVar);
        AVMemberListUIPart aVMemberListUIPart = new AVMemberListUIPart();
        this.N0 = aVMemberListUIPart;
        assembleParts.add(aVMemberListUIPart);
        AudioSuspectNoisyPart audioSuspectNoisyPart = new AudioSuspectNoisyPart();
        this.O0 = audioSuspectNoisyPart;
        assembleParts.add(audioSuspectNoisyPart);
        AVInviteUserNoticePart aVInviteUserNoticePart = new AVInviteUserNoticePart();
        this.P0 = aVInviteUserNoticePart;
        assembleParts.add(aVInviteUserNoticePart);
        return assembleParts;
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public boolean bi() {
        if (r.h0() == null || isDestroyed()) {
            return false;
        }
        return n.e().f().N();
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void bj(boolean z16, boolean z17) {
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "onPhoneCalling, isSelf[" + z16 + "], seq[" + d16 + "]");
        }
        if (r.h0() == null || isDestroyed() || !z16) {
            return;
        }
        d dVar = this.f75622k0;
        if (dVar != null) {
            dVar.Z9();
        }
        sl();
    }

    public void bl() {
        int i3 = n.e().f().O1;
        AVActivity aVActivity = (AVActivity) this.F.get();
        int g36 = aVActivity != null ? aVActivity.g3() : 1;
        if (i3 != 1) {
            if (g36 != i3) {
                if (QLog.isDevelopLevel()) {
                    QLog.d(NTBaseVideoFragment.f75610s0, 4, "initScreenLayout2 Style=" + i3 + "|" + n.e().f().O1 + "|" + r.h0().H0());
                }
                if (aVActivity != null) {
                    aVActivity.U2(i3);
                    return;
                }
                return;
            }
            return;
        }
        int i16 = r.h0().H0() == 4 ? 3 : 4;
        if (i16 == 3 && !af.B()) {
            i16 = 4;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(NTBaseVideoFragment.f75610s0, 4, "initScreenLayout Style=" + i16 + "|" + n.e().f().O1 + "|" + r.h0().H0());
        }
        if (aVActivity != null) {
            aVActivity.U2(i16);
        }
    }

    public abstract boolean cl();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dl() {
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
        r.h0().S2(sharedPreferences.getInt("group_video_push_cfg_txt." + this.G.getCurrentAccountUin() + ".level", 1), sharedPreferences.getInt("group_video_push_cfg_txt." + this.G.getCurrentAccountUin() + ".sendDura", 5000), sharedPreferences.getInt("group_video_push_cfg_txt." + this.G.getCurrentAccountUin() + ".validDura", 6000));
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void ej(long j3) {
        if (QLog.isColorLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "onResume, seq[" + j3 + "]");
        }
        QLog.d(NTBaseVideoFragment.f75610s0, 1, "[new] QAV_CALL_START_COST end: " + System.currentTimeMillis());
        super.ej(j3);
        yl(j3);
        zl(j3);
        if (r.h0() != null && !isDestroyed()) {
            n.e().f().A1 = false;
        }
        if (r.h0() != null && !isDestroyed() && r.h0().W0()) {
            Al();
        }
        AVMemberListUIPart aVMemberListUIPart = this.N0;
        if (aVMemberListUIPart != null) {
            aVMemberListUIPart.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void el(long j3, String str) {
        AVMemberListUIPart aVMemberListUIPart = this.N0;
        if (aVMemberListUIPart != null) {
            aVMemberListUIPart.C9(j3, str);
        }
    }

    void fl(long j3, String str, int i3, long j16) {
        if (QLog.isDevelopLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "notifyDataChangeByQuitUin, from[" + str + "], seq[" + j3 + "]");
        }
        if (i3 == 1 && this.F != null) {
            r.h0().f2(j16, this.C != 3);
        }
        el(j3, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Intent getIntent() {
        AVActivity aVActivity;
        WeakReference<Context> weakReference = this.F;
        if (weakReference == null || (aVActivity = (AVActivity) weakReference.get()) == null) {
            return null;
        }
        return aVActivity.getIntent();
    }

    public void gl() {
        AVMemberListUIPart aVMemberListUIPart = this.N0;
        if (aVMemberListUIPart != null) {
            aVMemberListUIPart.D9();
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void hi(long j3, boolean z16, int i3) {
        tl();
    }

    void hl(long j3, boolean z16) {
        AVMemberListUIPart aVMemberListUIPart = this.N0;
        if (aVMemberListUIPart != null) {
            aVMemberListUIPart.E9(j3, z16);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public int ii(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(NTBaseVideoFragment.f75610s0, 2, "onApnChanged --> NetType = " + i3);
        }
        VideoUtil.n(this.G, i3);
        WeakReference<Context> weakReference = this.F;
        if (!NetworkUtil.isWifiConnected(weakReference == null ? null : weakReference.get()) || r.h0() == null || isDestroyed() || !r.h0().W0() || !this.Q0) {
            return 0;
        }
        Il();
        return 0;
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void ij(boolean z16, boolean z17) {
        d dVar = this.f75622k0;
        if (dVar != null) {
            dVar.aa(z16, z17);
        }
    }

    void il(long j3, ArrayList<c> arrayList) {
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            if (i3 >= arrayList.size()) {
                break;
            }
            c cVar = arrayList.get(i3);
            if (cVar.f73827a == this.f75671z0 && cVar.f73828b == 1 && !n.e().f().N) {
                arrayList.remove(i3);
                break;
            }
            i3++;
        }
        ControlUIObserver controlUIObserver = this.I;
        Object[] objArr = new Object[4];
        objArr[0] = 103;
        objArr[1] = arrayList;
        objArr[2] = Long.valueOf(j3);
        objArr[3] = Boolean.valueOf(size != arrayList.size());
        controlUIObserver.update(null, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void initUI() {
        long d16 = com.tencent.av.utils.e.d();
        SessionInfo f16 = n.e().f();
        QLog.w(NTBaseVideoFragment.f75610s0, 1, "initUI, SessionType[" + f16.f73035i + "], switchToGAudioMode[" + f16.T0 + "], localMute[" + f16.K + "], seq[" + d16 + "]");
        super.initUI();
        if (this.F == null) {
            QLog.e(NTBaseVideoFragment.f75610s0, 1, "initUI error.");
            return;
        }
        as k3 = as.k(this.L, getActivity(), new a());
        this.L = k3;
        k3.r(true);
        WeakReference<Context> weakReference = this.F;
        if (weakReference == null) {
            if (QLog.isColorLevel()) {
                QLog.e(NTBaseVideoFragment.f75610s0, 2, "initUI-->can not get mContext");
                return;
            }
            return;
        }
        AVActivity aVActivity = (AVActivity) weakReference.get();
        if (aVActivity == null) {
            if (QLog.isColorLevel()) {
                QLog.e(NTBaseVideoFragment.f75610s0, 2, "initUI-->can not get AVActivity");
                return;
            }
            return;
        }
        q.c(aVActivity.getApplicationContext());
        if (r.h0().W0()) {
            this.L.n(true);
            this.L.m(true);
        }
        r.h0().T2("MultiVideoCtrlLayerUIBase_initUi", r.h0().X0() ? 1 : 0);
        s sVar = new s(this.F.get(), 3, this.J, this.H.findViewById(m.d.f76006d), null, null, this.H.findViewById(R.id.g86), this.H.findViewById(m.n.f76083a), null);
        this.B0 = sVar;
        sVar.b();
        if (((AVActivity) this.F.get()).J0 != null) {
            ((AVActivity) this.F.get()).J0.V2(this.f75671z0, r.h0().X0());
        }
    }

    void jl() {
        pw.a aVar = this.f75616e0;
        if (aVar != null) {
            aVar.E9();
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void kj(long j3) {
        if (QLog.isColorLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "onStart, seq[" + j3 + "]");
        }
        super.kj(j3);
        if (this.G0) {
            Bl(this.f75670y0);
            this.G0 = false;
        }
    }

    void kl(long j3) {
        pw.a aVar = this.f75616e0;
        if (aVar != null) {
            aVar.C9(j3);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void lj(long j3) {
        if (QLog.isColorLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 2, "onStop, seq[" + j3 + "]");
        }
        super.lj(j3);
        El();
        this.G0 = false;
    }

    public void ll(long j3) {
        pw.a aVar = this.f75616e0;
        if (aVar != null) {
            aVar.D9(j3);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void mi(long j3, View view) {
        WeakReference<Context> weakReference = this.F;
        if (weakReference == null || !(weakReference.get() instanceof AVActivity)) {
            return;
        }
        super.mi(j3, view);
        int id5 = view.getId();
        if (id5 != m.e.f76018e && id5 != m.l.C) {
            if (id5 == m.e.f76015b) {
                Ei(j3, view);
                return;
            }
            if (id5 == m.e.f76022i) {
                ml(j3);
                return;
            }
            if (id5 != m.p.f76092d && id5 != m.InterfaceC0763m.f76082b) {
                if (id5 == m.l.f76080z) {
                    AVHidePart aVHidePart = this.f75619h0;
                    if (aVHidePart != null) {
                        aVHidePart.H9();
                    }
                    Wk(false);
                    return;
                }
                if (id5 == m.e.f76021h) {
                    kl(j3);
                    return;
                }
                if (id5 == m.e.f76028o) {
                    ni(j3, view);
                    return;
                }
                if (id5 == m.g.f76034b) {
                    Bi(j3, view);
                    return;
                } else {
                    if (id5 == m.l.E) {
                        ll(j3);
                        AVUtil.r("0X800BC0B", AVUtil.h(), 0, "", "", "", "");
                        return;
                    }
                    return;
                }
            }
            jl();
            return;
        }
        qi(j3, view);
    }

    void ml(long j3) {
        pw.b bVar = this.K0;
        if (bVar != null) {
            bVar.C9(j3);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void oi(long j3, View view) {
        AVCameraPart aVCameraPart = this.f75613b0;
        if (aVCameraPart != null) {
            aVCameraPart.P9(j3, view);
        }
    }

    public void ol(boolean z16, long j3) {
        SessionInfo f16 = n.e().f();
        if (z16 && f16 != null) {
            AVCoreLog.printAllUserLog(NTBaseVideoFragment.f75610s0, " TYPE_NOTIFY_CAMERA_CLOSE 2: " + f16.N + "|" + f16.f73035i);
            if (f16.N) {
                this.I.update(null, new Object[]{106, Long.valueOf(j3)});
            }
        }
        ek(com.tencent.av.utils.e.d());
        Wk(true);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        d dVar;
        super.onNewIntent(intent);
        if (QLog.isColorLevel()) {
            QLog.d(NTBaseVideoFragment.f75610s0, 2, "OnNewIntent");
        }
        ql(intent);
        boolean z16 = false;
        if (intent != null) {
            z16 = intent.getBooleanExtra("needStartTRAE", false);
            sh();
        }
        pl(intent);
        if (z16 && (dVar = this.f75622k0) != null) {
            dVar.ma();
        }
        Zk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        SessionInfo f16 = n.e().f();
        boolean z16 = this.f75667v0 != f16.f73067q;
        if ((this.f75669x0 != f16.P0) || z16) {
            this.J0.C9(false);
        }
        this.T.H9();
        long d16 = com.tencent.av.utils.e.d();
        lk(d16, 33554431);
        if (f16.f73035i == 4) {
            Kl("onViewCreatedAfterPartInit", d16);
        }
    }

    abstract void pl(Intent intent);

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void ri(long j3) {
        d dVar = this.f75622k0;
        if (dVar != null) {
            dVar.O9();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void rl() {
        long d16 = com.tencent.av.utils.e.d();
        SessionInfo f16 = n.e().f();
        if (QLog.isDevelopLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "refreshMemberCtrlButton, SessionType[" + f16.f73035i + "], multiAVType[" + f16.f73063p + "], mUinType[" + this.f75667v0 + "], isManager[" + f16.f73037i1 + "], isRoomCreator[" + f16.f73041j1 + "], mGAudioInRoom[" + r.h0().W0() + "]");
        }
        lk(d16, 33554431);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void sj(int i3, int i16, String str) {
        int n3;
        super.sj(i3, i16, str);
        if (QLog.isColorLevel()) {
            QLog.d(NTBaseVideoFragment.f75610s0, 2, "onVideoViewModeChange --> lastMode = " + i3 + " , currentMode = " + i16 + ",bigUin=" + str);
        }
        if (i3 == i16 || this.Q0) {
            return;
        }
        boolean z16 = i16 == 3;
        boolean z17 = 4 != r.h0().H0();
        for (int i17 = 1; i17 < n.e().f().f73045k1.size(); i17++) {
            c cVar = n.e().f().f73045k1.get(i17);
            cVar.f73829c = z16;
            if (z17 && !cVar.f73831e && (n3 = n.e().f().n(this.f75671z0)) != -1) {
                n.e().f().f73045k1.get(n3).f73831e = false;
            }
            cVar.f73831e = (i16 == 3 && z17) ? false : true;
        }
        if (Il()) {
            n.e().f().f73049l1 = true;
        }
    }

    abstract void sl();

    public void tl() {
        com.tencent.av.ui.part.mav.a aVar = this.L0;
        if (aVar != null) {
            aVar.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ul(long j3, int i3, boolean z16, int i16, int i17) {
        if (isDestroyed()) {
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "refreshUI, uin[" + j3 + "], refreshType[" + i3 + "], needRefresh[" + z16 + "], originalType[" + i16 + "], audioEnergy[" + i17 + "]");
        }
        if (j3 == 0) {
            return;
        }
        wh().runOnUiThread(new RefreshUIRunnable(j3, i3, z16, i16));
        AVMemberListUIPart aVMemberListUIPart = this.N0;
        if (aVMemberListUIPart != null) {
            aVMemberListUIPart.H9(nw.b.b().getLongAccountUin(), r.h0().X0());
        }
        com.tencent.av.ui.part.mav.a aVar = this.L0;
        if (aVar != null) {
            aVar.B9(j3, i16 == 42, i17);
        }
        cw.e.c(this.G);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void vj() {
        AVMemberListUIPart aVMemberListUIPart = this.N0;
        if (aVMemberListUIPart != null) {
            aVMemberListUIPart.G9();
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void wi(long j3, View view) {
        d dVar = this.f75622k0;
        if (dVar != null) {
            dVar.Y9(j3, view);
        }
    }

    void wl() {
        if (this.D0 != null) {
            this.G.M().removeCallbacks(this.D0);
        }
    }

    void xl() {
        Oh();
        cw.e.d(this.G, 1036);
        cw.e.d(this.G, 1037);
        cw.e.n(this.G, 1030);
        n.e().f().V(this.f75671z0, true, true);
        Fl(true, false, true);
    }

    void yl(long j3) {
        if (r.h0() == null || isDestroyed() || !r.h0().W0()) {
            return;
        }
        if (r.h0().X0()) {
            super.gk(m.l.f76060f);
            QavPanel qavPanel = this.J;
            if (qavPanel != null) {
                qavPanel.D0(r.h0().X0());
            }
        }
        dk(j3);
        r.h0().U2();
        if (n.e().f().f73043k == 9) {
            Cj(j3, R.string.dcj);
        } else {
            Dj(j3, null);
        }
        as asVar = this.L;
        if (asVar != null) {
            asVar.m(true);
            this.L.n(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zl(long j3) {
        if (isDestroyed()) {
            return;
        }
        if (r.h0().W0()) {
            QavPanel qavPanel = this.J;
            int i3 = m.l.f76060f;
            qavPanel.setViewEnable(i3, true);
            this.J.S0(i3, true);
            if (r.h0().X0()) {
                gk(i3);
            } else {
                fk(i3);
            }
            this.J.D0(r.h0().X0());
            rl();
        }
        this.G.A0(this.f75667v0, String.valueOf(this.f75670y0));
        lk(j3, 33554431);
        dk(j3);
    }

    void ql(Intent intent) {
        try {
            this.f75671z0 = Long.valueOf(this.G.getCurrentAccountUin()).longValue();
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d(NTBaseVideoFragment.f75610s0, 2, "Can not get AccountUin WHY!!!???");
            }
            this.f75671z0 = 0L;
        }
        SessionInfo f16 = n.e().f();
        int i3 = f16.f73067q;
        this.f75667v0 = i3;
        if (i3 == 3000) {
            this.f75668w0 = 2;
        } else if (i3 == 1) {
            if (f16.f73063p == 17) {
                this.f75668w0 = 11;
            } else {
                this.f75668w0 = 1;
            }
        }
        f16.S0 = this.f75668w0;
        int i16 = f16.R0;
        this.f75669x0 = f16.P0;
        this.f75666u0 = i16;
        if (intent != null) {
            this.I0 = intent.getBooleanExtra(BaseProfileQZoneComponent.KEY_IS_VIDEO, false);
        }
        QLog.w(NTBaseVideoFragment.f75610s0, 1, "processIntentData, mUinType[" + this.f75667v0 + "], mRelationType[" + this.f75668w0 + "], mIntentRelationId[" + this.f75669x0 + "], mStatusType[" + this.f75666u0 + "], mStatusType[" + i16 + "->" + this.f75666u0 + "], getSimpleDataList[" + r.h0().B0() + "], getGAudioList[" + r.h0().Y() + "]");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Hl() {
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            String str = NTBaseVideoFragment.f75610s0;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("startOrResumeRemoteOrLocalVideo, seq[");
            sb5.append(d16);
            sb5.append("], VideoController.getInstance()[");
            sb5.append(r.h0() != null);
            sb5.append("]");
            QLog.w(str, 1, sb5.toString());
        }
        if (r.h0() == null || this.G == null || isDestroyed()) {
            return;
        }
        if (!r.h0().W0()) {
            if (QLog.isColorLevel()) {
                QLog.e(NTBaseVideoFragment.f75610s0, 2, "startOrResumeRemoteOrLocalVideo, Not in MultiVideoRoom");
                return;
            }
            return;
        }
        int r06 = r.h0().r0();
        int q16 = n.e().f().q(this.f75671z0, 1);
        boolean z16 = q16 != -1;
        if (QLog.isColorLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "startOrResumeRemoteOrLocalVideo, onStageNum[" + r06 + "], index[" + q16 + "]");
        }
        WeakReference<Context> weakReference = this.F;
        Context context = weakReference == null ? null : weakReference.get();
        if (!NetworkUtil.isWifiConnected(context) && !n.e().f().C1) {
            if (QLog.isColorLevel()) {
                QLog.d(NTBaseVideoFragment.f75610s0, 2, "startOrResumeRemoteOrLocalVideo --> is not connect wifi");
            }
            if (z16) {
                r.h0().h2(this.f75671z0, n.e().f().f73045k1, n.e().f().f73053m1, 1, false);
                r.h0().v3();
            }
            if (n.e().f().f73045k1.size() > 0) {
                n.e().f().w0(d16, "startOrResumeRemoteOrLocalVideo", true, true);
                Kl("startOrResumeRemoteOrLocalVideo", d16);
                if (!NetworkUtil.isNetworkAvailable(context)) {
                    VideoUtil.n(this.G, 0);
                    return;
                } else {
                    Fl(true, true, true);
                    return;
                }
            }
            sh();
            return;
        }
        if (z16) {
            if (r06 < T0) {
                if (Yk()) {
                    lk(d16, 33554431);
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.e(NTBaseVideoFragment.f75610s0, 2, "startOrResumeRemoteOrLocalVideo, Go on Stage Failed");
                    }
                    r.h0().h2(this.f75671z0, n.e().f().f73045k1, n.e().f().f73053m1, 1, false);
                    r.h0().v3();
                }
            } else {
                r.h0().h2(this.f75671z0, n.e().f().f73045k1, n.e().f().f73053m1, 1, false);
                r.h0().v3();
            }
        }
        if (n.e().f().f73045k1.size() > 0) {
            Il();
        } else {
            sh();
        }
    }

    public boolean Il() {
        if (QLog.isColorLevel()) {
            QLog.d(NTBaseVideoFragment.f75610s0, 2, "startRecvAllVideo");
        }
        if (r.h0() != null && this.G != null && this.F != null && !isDestroyed()) {
            Context context = this.F.get();
            boolean isResume = context instanceof AVActivity ? ((AVActivity) context).isResume() : true;
            if (QLog.isColorLevel()) {
                QLog.d(NTBaseVideoFragment.f75610s0, 2, "startRecvAllVideo --> isResume = " + isResume);
            }
            if (!isResume) {
                return false;
            }
            int size = n.e().f().f73045k1.size();
            if (n.e().f().N) {
                size--;
            }
            if (size <= 0) {
                if (QLog.isColorLevel()) {
                    QLog.e(NTBaseVideoFragment.f75610s0, 2, "startRecvAllVideo --> There is no video need request");
                }
                return false;
            }
            int c16 = tv.c.c(this.G.getApp());
            if (c16 == 1) {
                if (QLog.isColorLevel()) {
                    QLog.e(NTBaseVideoFragment.f75610s0, 2, "startRecvAllVideo --> This version is not supportsharpvideo or opengl.  GlVersion = " + c16);
                }
                return false;
            }
            ReportController.o(null, "CliOper", "", "", "0X8005617", "0X8005617", 0, 0, "", "", "", "");
            int H0 = r.h0().H0();
            if (QLog.isColorLevel()) {
                QLog.d(NTBaseVideoFragment.f75610s0, 2, "startRecvAllVideo --> Ability = " + H0);
            }
            if (H0 != 4) {
                if (this.f75668w0 == 2) {
                    ReportController.o(null, "CliOper", "", "", "0X8004CF6", "0X8004CF6", 0, 0, "", "", "", "");
                }
                if (n.e().f().f73045k1.size() > 1) {
                    cw.e.n(this.G, 3009);
                }
            }
            n.e().f().f73057n1.clear();
            long parseLong = Long.parseLong(this.G.getCurrentAccountUin());
            for (int i3 = 0; i3 < n.e().f().f73045k1.size(); i3++) {
                c cVar = n.e().f().f73045k1.get(i3);
                if (cVar.f73831e && parseLong != cVar.f73827a) {
                    n.e().f().f73057n1.add(cVar);
                }
            }
            Fl(false, false, false);
            Oh();
            cw.e.d(this.G, 1036);
            cw.e.d(this.G, 1037);
            return r.h0().m2(n.e().f().O1 == 3);
        }
        if (QLog.isColorLevel()) {
            QLog.e(NTBaseVideoFragment.f75610s0, 2, "startRecvAllVideo --> VideoController is null");
        }
        return false;
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void gi(long j3, boolean z16) {
        if (z16) {
            Il();
        }
        tl();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b extends GAudioUIObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void G(long j3, long j16, boolean z16, boolean z17) {
            super.G(j3, j16, z16, z17);
            if (QLog.isColorLevel()) {
                QLog.w(NTBaseVideoFragment.f75610s0, 1, "onMemberLeave, mRelationId[" + NTMultiVideoBaseFragment.this.f75670y0 + "], groupId[" + j3 + "], friendUin[" + j16 + "], isQQUser[" + NTMultiVideoBaseFragment.this.H0 + "->" + z16 + "]");
            }
            NTMultiVideoBaseFragment nTMultiVideoBaseFragment = NTMultiVideoBaseFragment.this;
            if (nTMultiVideoBaseFragment.f75670y0 != j3) {
                return;
            }
            nTMultiVideoBaseFragment.H0 = z16;
            super.G(j3, j16, z16, z17);
            NTMultiVideoBaseFragment.this.ul(j16, 1, true, z17 ? 71 : 69, 0);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void I(long j3, boolean z16, boolean z17, int i3) {
            super.I(j3, z16, z17, i3);
            NTMultiVideoBaseFragment.this.ul(j3, 2, z17, z16 ? 42 : 43, i3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void J(long j3, long j16) {
            super.J(j3, j16);
            NTMultiVideoBaseFragment.this.tl();
            NTMultiVideoBaseFragment.this.ul(j16, 5, false, 72, 0);
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void K(long j3, long j16, long j17, int i3) {
            if (j17 == NTMultiVideoBaseFragment.this.f75671z0) {
                if (n.e().f().N) {
                    if (QLog.isColorLevel()) {
                        QLog.w(NTBaseVideoFragment.f75610s0, 1, "onMemberVideoOut, seq[" + j3 + "]");
                    }
                    NTMultiVideoBaseFragment.this.Xk(j3);
                    if (r.h0() != null && !NTMultiVideoBaseFragment.this.isDestroyed()) {
                        r.h0().h2(NTMultiVideoBaseFragment.this.f75671z0, n.e().f().f73045k1, n.e().f().f73053m1, 1, false);
                    }
                }
            } else {
                c cVar = new c();
                cVar.f73827a = j17;
                cVar.f73828b = i3;
                ArrayList arrayList = new ArrayList();
                arrayList.add(cVar);
                NTMultiVideoBaseFragment.this.I.update(null, new Object[]{104, arrayList});
                if (i3 == 2) {
                    NTMultiVideoBaseFragment.this.Qh(1036);
                    cw.e.d(NTMultiVideoBaseFragment.this.G, 1036);
                }
            }
            NTMultiVideoBaseFragment.this.tl();
            NTMultiVideoBaseFragment.this.ul(j17, 6, false, 73, 0);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void i(long j3) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "onDestroyUI, groupId[" + j3 + "], mRelationId[" + NTMultiVideoBaseFragment.this.f75670y0 + "], mIntentRelationId[" + NTMultiVideoBaseFragment.this.f75669x0 + "]");
            NTMultiVideoBaseFragment nTMultiVideoBaseFragment = NTMultiVideoBaseFragment.this;
            if (nTMultiVideoBaseFragment.f75670y0 == j3 || nTMultiVideoBaseFragment.f75669x0 == j3) {
                nTMultiVideoBaseFragment.Wk(true);
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void j() {
            AVUserNamePart aVUserNamePart = NTMultiVideoBaseFragment.this.J0;
            if (aVUserNamePart != null) {
                aVUserNamePart.B9();
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void l(long j3, int i3) {
            long d16 = com.tencent.av.utils.e.d();
            int q16 = n.e().f().q(j3, i3);
            if (q16 != -1 && n.e().f().f73045k1.get(q16).f73829c) {
                NTMultiVideoBaseFragment.this.Oh();
                cw.e.d(NTMultiVideoBaseFragment.this.G, 1036);
                cw.e.d(NTMultiVideoBaseFragment.this.G, 1037);
            }
            NTMultiVideoBaseFragment.this.yj(d16);
            NTMultiVideoBaseFragment.this.wl();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void p(long j3, int i3, int i16, boolean z16) {
            super.p(j3, i3, i16, z16);
            AVMemberListUIPart aVMemberListUIPart = NTMultiVideoBaseFragment.this.N0;
            if (aVMemberListUIPart != null) {
                aVMemberListUIPart.H9(j3, z16);
            }
            NTMultiVideoBaseFragment nTMultiVideoBaseFragment = NTMultiVideoBaseFragment.this;
            if (j3 == nTMultiVideoBaseFragment.f75671z0) {
                nTMultiVideoBaseFragment.sl();
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void q(long j3, int i3) {
            d dVar = NTMultiVideoBaseFragment.this.f75622k0;
            if (dVar != null) {
                dVar.U9(j3, i3);
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void r(long j3, boolean z16, boolean z17) {
            d dVar = NTMultiVideoBaseFragment.this.f75622k0;
            if (dVar != null) {
                dVar.V9(j3, z16, z17);
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void t(ArrayList<Long> arrayList, int i3) {
            AudioSuspectNoisyPart audioSuspectNoisyPart = NTMultiVideoBaseFragment.this.O0;
            if (audioSuspectNoisyPart != null) {
                audioSuspectNoisyPart.x9(arrayList, i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void u(long j3, long j16, boolean z16, boolean z17) {
            int i3;
            int i16;
            super.u(j3, j16, z16, z17);
            if (z16) {
                i3 = 7;
                i16 = 78;
            } else {
                NTMultiVideoBaseFragment.this.Qh(1036);
                cw.e.d(NTMultiVideoBaseFragment.this.G, 1036);
                i3 = 8;
                i16 = 79;
            }
            NTMultiVideoBaseFragment.this.ul(j16, i3, false, i16, 0);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void F(long j3, long j16, boolean z16, boolean z17) {
            super.F(j3, j16, z16, z17);
            if (QLog.isDevelopLevel()) {
                QLog.w(NTBaseVideoFragment.f75610s0, 1, "onMemberJoin, mRelationId[" + NTMultiVideoBaseFragment.this.f75670y0 + "], groupId[" + j3 + "], isQQUser[" + z17 + "], friendUin[" + j16 + "], isRefresh[" + z16 + "]");
            }
            NTMultiVideoBaseFragment nTMultiVideoBaseFragment = NTMultiVideoBaseFragment.this;
            if (nTMultiVideoBaseFragment.f75670y0 != j3) {
                return;
            }
            nTMultiVideoBaseFragment.H0 = z17;
            nTMultiVideoBaseFragment.ul(j16, 0, z16, 70, 0);
            VideoAppInterface videoAppInterface = NTMultiVideoBaseFragment.this.G;
            if (videoAppInterface == null || j16 == videoAppInterface.getLongAccountUin()) {
                return;
            }
            QAVControllerForZplan.p().M(j16, false);
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void v(long j3, int i3, long j16, long j17, long j18, int i16) {
            boolean z16;
            if (QLog.isColorLevel()) {
                QLog.w(NTBaseVideoFragment.f75610s0, 1, "onGaOperationResult, result[" + i3 + "], uin[" + j16 + "], info[" + j17 + "], groupId[" + j18 + "], relationType[" + i16 + "], seq[" + j3 + "]");
            }
            switch (i3) {
                case 90:
                    if (j17 == 3) {
                        ArrayList<c> arrayList = n.e().f().f73045k1;
                        int i17 = 0;
                        while (true) {
                            if (i17 < arrayList.size()) {
                                c cVar = arrayList.get(i17);
                                if (j16 == cVar.f73827a && cVar.f73828b == 1) {
                                    z16 = cVar.f73829c;
                                } else {
                                    i17++;
                                }
                            } else {
                                z16 = false;
                            }
                        }
                        NTMultiVideoBaseFragment.this.I.update(null, new Object[]{105, Boolean.valueOf(z16), Long.valueOf(j3)});
                        NTMultiVideoBaseFragment.this.yj(j3);
                        NTMultiVideoBaseFragment.this.Kl("onGaOperationResult.2", j3);
                    } else {
                        NTMultiVideoBaseFragment nTMultiVideoBaseFragment = NTMultiVideoBaseFragment.this;
                        AVCameraPart aVCameraPart = nTMultiVideoBaseFragment.f75613b0;
                        if (aVCameraPart != null) {
                            aVCameraPart.R9(j17, j16, nTMultiVideoBaseFragment.f75668w0);
                        }
                    }
                    NTMultiVideoBaseFragment.this.lk(j3, 33554431);
                    return;
                case 91:
                case 92:
                    NTMultiVideoBaseFragment.this.nl(j17);
                    return;
                case 93:
                case 94:
                case 95:
                    NTMultiVideoBaseFragment.this.lk(j3, 33554431);
                    if (i3 == 93) {
                        NTMultiVideoBaseFragment.this.Kl("onGaOperationResult.93", j3);
                        return;
                    }
                    return;
                case 96:
                    if (j17 == 1) {
                        NTMultiVideoBaseFragment.this.Sk("onGaOperationResult");
                        NTMultiVideoBaseFragment.this.Kl("onGaOperationResult.1", j3);
                        NTMultiVideoBaseFragment.this.il(j3, n.e().f().f73045k1);
                        return;
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d(NTBaseVideoFragment.f75610s0, 2, "onGaOperationResult --> EV_GA_SDK_REQUEST_VIDEO_SUC Failed. Info = " + j17);
                            return;
                        }
                        return;
                    }
                case 97:
                case 98:
                    if (j17 == 1) {
                        NTMultiVideoBaseFragment nTMultiVideoBaseFragment2 = NTMultiVideoBaseFragment.this;
                        nTMultiVideoBaseFragment2.ul(nTMultiVideoBaseFragment2.f75671z0, i3, false, -1, 0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void nl(long j3) {
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.d(NTBaseVideoFragment.f75610s0, 2, "go on stage failed, info[" + j3 + "]");
        }
        Dl(m.l.A, 8);
        nj(false);
        lk(d16, 33554431);
        if (j3 == 7) {
            cw.e.n(this.G, 1029);
        } else if (j3 == 8) {
            cw.e.p(this.G, 1033, this.E.getString(R.string.f171253w35));
        } else {
            cw.e.n(this.G, 1028);
        }
        if (this.f75668w0 == 2) {
            ReportController.o(null, "CliOper", "", "", "0X800441E", "0X800441E", 0, 0, "", "", "", "");
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Li(long j3, int i3) {
        if (i3 == 2 || i3 == 1) {
            Xk(j3);
            r.h0().h2(this.f75671z0, n.e().f().f73045k1, n.e().f().f73053m1, 1, false);
        }
        super.Li(j3, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r6v4 */
    public void Vk(long j3, int i3, boolean z16, int i16) {
        int i17;
        boolean z17;
        int i18;
        long j16;
        ?? r65;
        String str;
        boolean z18;
        boolean z19;
        boolean z26;
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isDevelopLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "drawUI, uin[" + j3 + "], refreshType[" + i3 + "], needRefresh[" + z16 + "], originalType[" + i16 + "], seq[" + d16 + "]");
        }
        if (r.h0() == null || this.G == null || isDestroyed()) {
            return;
        }
        if (i3 == 0) {
            if (r.h0() != null && !isDestroyed() && j3 != this.f75671z0 && n.e().f().f73097x1) {
                TraeHelper.I().g0(d16, this.G, R.raw.qav_gaudio_join, null, 0, null);
            }
            if (j3 == this.f75671z0) {
                rl();
            }
        } else if (i3 == 1 && j3 != this.f75671z0) {
            TraeHelper.I().g0(d16, this.G, R.raw.f169419r, null, 0, null);
        }
        if (i3 != 0 && i3 != 1) {
            if (i3 == 5) {
                i18 = 6;
                j16 = d16;
                r65 = 1;
                str = "DrawUI:TYPE=";
            } else if (i3 == 6) {
                i18 = 6;
                str = "DrawUI:TYPE=";
                j16 = d16;
                r65 = 1;
            } else if (i3 == 7 || i3 == 8) {
                if (i3 == 8) {
                    c cVar = new c();
                    cVar.f73827a = j3;
                    cVar.f73828b = 2;
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(cVar);
                    this.I.update(null, new Object[]{104, arrayList});
                }
                if (i3 == 8) {
                    z19 = Tk(d16);
                    if (n.e().f().t()) {
                        sh();
                        Sj(d16, 0.0f);
                    }
                } else {
                    z19 = true;
                }
                if (!n.e().f().f73097x1 || !z19) {
                    z26 = true;
                } else {
                    if (this.C >= 4) {
                        return;
                    }
                    WeakReference<Context> weakReference = this.F;
                    if (!NetworkUtil.isWifiConnected(weakReference != null ? weakReference.get() : null) && n.e().f().o() == -1 && !n.e().f().C1) {
                        n.e().f().w0(d16, "drawUI.2", true, true);
                        Kl("drawUI.2", d16);
                        z26 = true;
                        Fl(true, true, true);
                    } else {
                        z26 = true;
                        Gl(i3);
                        this.G.M().removeCallbacks(this.R0);
                        this.R0.f75676d = "DrawUI:TYPE=" + String.valueOf(i3);
                        this.G.M().postDelayed(this.R0, 1000L);
                    }
                }
                z17 = z26;
            } else {
                if (i3 == 97 || i3 == 98) {
                    if (QLog.isColorLevel()) {
                        QLog.e(NTBaseVideoFragment.f75610s0, 2, "Request remote video failed.Uin = " + j3 + ",type=" + i3);
                    }
                    n.e().f().w0(d16, "drawUI.3", true, true);
                    Kl("drawUI.3", d16);
                    xl();
                }
                z17 = true;
            }
            boolean z27 = j3 == this.f75671z0 ? r65 : false;
            if (i3 == i18) {
                z18 = Tk(j16);
                if (n.e().f().t()) {
                    sh();
                    Sj(j16, 0.0f);
                }
                if (z27 && !n.e().f().A1) {
                    r.h0().h2(this.f75671z0, n.e().f().f73045k1, n.e().f().f73053m1, 1, false);
                }
            } else {
                z18 = r65;
            }
            if (n.e().f().f73097x1 && z18) {
                if (this.C >= 4) {
                    return;
                }
                WeakReference<Context> weakReference2 = this.F;
                if (NetworkUtil.isWifiConnected(weakReference2 == null ? null : weakReference2.get()) || n.e().f().o() != -1 || n.e().f().C1) {
                    if (!z27) {
                        Gl(i3);
                        this.G.M().removeCallbacks(this.R0);
                        this.R0.f75676d = str + String.valueOf(i3);
                        this.G.M().postDelayed(this.R0, 1000L);
                    } else {
                        String str2 = str;
                        int q16 = n.e().f().q(this.f75671z0, r65);
                        int o16 = n.e().f().o();
                        if (QLog.isColorLevel()) {
                            QLog.d(NTBaseVideoFragment.f75610s0, 2, "onSelfVideoIn.-->FirstVideo=" + o16 + ",index=" + q16);
                        }
                        if (o16 == -1 || (q16 == o16 && q16 != 0)) {
                            this.G.M().removeCallbacks(this.R0);
                            this.R0.f75676d = str2 + String.valueOf(i3);
                            this.G.M().postDelayed(this.R0, 1000L);
                        }
                    }
                } else if (!z27) {
                    n.e().f().w0(j16, "drawUI.1", true, true);
                    Kl("drawUI.1", j16);
                    Fl(r65, r65, r65);
                }
            }
            z17 = r65;
        } else {
            if (n.e().f().f73043k == 9) {
                if (i3 == 1) {
                    if (i16 != 69) {
                        Cl(0, R.string.dcu, String.valueOf(j3), null);
                    }
                    i17 = 1;
                } else {
                    i17 = -1;
                }
                Cj(d16, R.string.dcj);
            } else if (i3 == 0) {
                Dj(d16, null);
                dk(d16);
                if (n.e().f().f73097x1) {
                    Cl(0, R.string.dcn, String.valueOf(j3), null);
                    i17 = 0;
                }
                i17 = -1;
            } else {
                if (i3 == 1) {
                    if (i16 != 69) {
                        Cl(0, R.string.dcu, String.valueOf(j3), null);
                    }
                    i17 = 1;
                }
                i17 = -1;
            }
            z17 = true;
            fl(d16, "drawUI", i17, j3);
        }
        if (i16 == 42) {
            hl(j3, z17);
        } else if (i16 == 43) {
            hl(j3, false);
        }
        vl(i3);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void rj(String str, int i3, String str2, int i16) {
        int n3;
        super.rj(str, i3, str2, i16);
        if (QLog.isColorLevel()) {
            QLog.d(NTBaseVideoFragment.f75610s0, 2, "onVideoViewChange --> BigViewUin = " + str + " , BigViewVideoViewType = " + i3 + " , SmallViewUin = " + str2 + " , SmallViewVideoViewType = " + i16);
        }
        if (str == null || str2 == null || this.Q0) {
            return;
        }
        try {
            long longValue = Long.valueOf(str2).longValue();
            if (i3 == 2) {
                Qh(1036);
                cw.e.d(this.G, 1036);
            }
            int q16 = n.e().f().q(Long.valueOf(str).longValue(), i3);
            if (q16 == -1) {
                return;
            }
            c cVar = n.e().f().f73045k1.get(q16);
            int i17 = 0;
            while (true) {
                if (i17 >= n.e().f().f73045k1.size()) {
                    break;
                }
                c cVar2 = n.e().f().f73045k1.get(i17);
                long j3 = cVar2.f73827a;
                if (longValue == j3 && i16 == cVar2.f73828b) {
                    cVar.f73829c = false;
                    long j16 = cVar.f73827a;
                    long j17 = this.f75671z0;
                    if (j16 != j17 && j3 != j17 && 4 != r.h0().H0()) {
                        cVar.f73831e = false;
                    }
                    cVar2.f73829c = true;
                    if (4 != r.h0().H0() && !cVar2.f73831e && (n3 = n.e().f().n(this.f75671z0)) != -1) {
                        n.e().f().f73045k1.get(n3).f73831e = false;
                    }
                    cVar2.f73831e = true;
                    if (cVar2.f73827a == this.f75671z0 && this.f75668w0 == 2) {
                        ReportController.o(null, "CliOper", "", "", "0X80041B2", "0X80041B2", 0, 0, "", "", "", "");
                    }
                    if (!cVar2.f73830d && r.h0().H0() != 4) {
                        DataReport.G(n.e().f().f73063p);
                    }
                    n.e().f().f73045k1.set(q16, cVar2);
                    n.e().f().f73045k1.set(i17, cVar);
                    synchronized (n.e().f().f73053m1) {
                        n.e().f().f73053m1.set(q16, cVar2);
                        n.e().f().f73053m1.set(i17, cVar);
                        n.e().f().S();
                    }
                    if (((AVActivity) this.F.get()).J0 != null) {
                        ((AVActivity) this.F.get()).J0.K2(cVar2.f73827a, cVar2.f73828b, cVar.f73827a, cVar.f73828b);
                    }
                } else {
                    i17++;
                }
            }
            Il();
        } catch (Exception unused) {
            QLog.e(NTBaseVideoFragment.f75610s0, 2, "onVideoViewChange --> Parse String 2 Long Failed");
        }
    }

    void Gl(int i3) {
        if (i3 == 6 || i3 == 8 || i3 == 74 || tv.c.c(this.G.getApp()) != 1) {
            return;
        }
        VideoAppInterface videoAppInterface = this.G;
        cw.e.p(videoAppInterface, 1012, videoAppInterface.getApp().getString(R.string.idp));
        ReportController.o(null, "CliOper", "", "", "0X8004E94", "0X8004E94", 0, 0, "", "", "", "");
        ReportController.o(null, "CliOper", "", "", "0X8005618", "0X8005618", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
            QLog.e(NTBaseVideoFragment.f75610s0, 2, "startRecvAllVideo-->GLVersion not support");
        }
    }

    public NTMultiVideoBaseFragment(VideoAppInterface videoAppInterface, AVActivity aVActivity, ControlUIObserver controlUIObserver) {
        super(videoAppInterface, aVActivity, controlUIObserver);
        this.f75666u0 = -1;
        this.f75667v0 = -1;
        this.f75668w0 = 0;
        this.f75669x0 = 0L;
        this.f75670y0 = 0L;
        this.f75671z0 = 0L;
        this.A0 = 0;
        this.B0 = null;
        this.C0 = null;
        this.D0 = null;
        this.E0 = null;
        this.F0 = false;
        this.G0 = false;
        this.H0 = true;
        this.I0 = false;
        this.Q0 = false;
        this.R0 = new StartRecvVideoRunnable();
        this.S0 = new b();
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void hk(int i3) {
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void ji(long j3) {
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void ki(long j3) {
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void pj(long j3) {
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void qj(long j3) {
    }

    public void vl(int i3) {
    }
}
