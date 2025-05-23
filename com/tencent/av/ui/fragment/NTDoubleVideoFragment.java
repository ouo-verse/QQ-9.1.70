package com.tencent.av.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.SafetyHandler;
import com.tencent.av.business.manager.magicface.MagicDataReport;
import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.av.doodle.DoodleLogic;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.ap;
import com.tencent.av.ui.api.IAVFoldingDeviceBizApi;
import com.tencent.av.ui.api.IAVVideoFunCallBizApi;
import com.tencent.av.ui.api.IAVVideoRecordBizApi;
import com.tencent.av.ui.api.IAVZplanAvatarBizApi;
import com.tencent.av.ui.m;
import com.tencent.av.ui.part.base.AVChildGuideUIPart;
import com.tencent.av.ui.part.base.AVDoubleGlassCheckPart;
import com.tencent.av.ui.part.base.AVHidePart;
import com.tencent.av.ui.part.base.AVNameAndHeadPart;
import com.tencent.av.ui.part.base.AVNetConnectInfoPart;
import com.tencent.av.ui.part.base.AVSmallHomeTipsPart;
import com.tencent.av.ui.part.base.AVToolBarPart;
import com.tencent.av.ui.part.base.f;
import com.tencent.av.ui.part.base.g;
import com.tencent.av.ui.part.base.i;
import com.tencent.av.ui.part.base.panel.AVChatTimePart;
import com.tencent.av.ui.part.base.panel.AVScreenSharePart;
import com.tencent.av.ui.part.base.panel.AVVideoRecordUIPart;
import com.tencent.av.ui.part.base.panel.d;
import com.tencent.av.ui.part.dav.panel.AVAvatarEntryPart;
import com.tencent.av.ui.part.dav.panel.AVCameraPart;
import com.tencent.av.ui.s;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.VideoUtil;
import com.tencent.av.utils.aj;
import com.tencent.av.utils.as;
import com.tencent.av.utils.e;
import com.tencent.av.utils.q;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzonestatus.QAVBackPressedBeforeEnterQZoneEvent;
import com.tencent.mobileqq.qzonestatus.QAVChangeToSmallScreenEvent;
import com.tencent.mobileqq.qzonestatus.QZoneVideoContactsFeedHelper;
import com.tencent.mobileqq.vas.funcall.IVasFunCallKuikly;
import com.tencent.mobileqq.vas.h;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.sharp.jni.api.IMediaPlayerApi;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class NTDoubleVideoFragment extends NTBaseVideoFragment implements SimpleEventReceiver {
    private IAVVideoFunCallBizApi A0;
    private IVasFunCallKuikly B0;
    private IAVVideoRecordBizApi C0;
    private IAVZplanAvatarBizApi D0;
    private IAVFoldingDeviceBizApi E0;
    private AVChildGuideUIPart F0;
    private AVDoubleGlassCheckPart G0;
    private AVNameAndHeadPart H0;
    private g I0;
    private AVSmallHomeTipsPart J0;
    private AVVideoRecordUIPart K0;
    private com.tencent.av.ui.part.dav.panel.b L0;
    protected com.tencent.av.ui.part.dav.panel.c M0;
    Runnable N0;
    Runnable O0;
    private long P0;
    private int Q0;
    Runnable R0;
    lu.b S0;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f75652u0;

    /* renamed from: v0, reason: collision with root package name */
    boolean f75653v0;

    /* renamed from: w0, reason: collision with root package name */
    boolean f75654w0;

    /* renamed from: x0, reason: collision with root package name */
    boolean f75655x0;

    /* renamed from: y0, reason: collision with root package name */
    s f75656y0;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f75657z0;

    public NTDoubleVideoFragment() {
        this.f75652u0 = false;
        this.f75653v0 = false;
        this.f75654w0 = false;
        this.f75655x0 = false;
        this.f75656y0 = null;
        this.N0 = new Runnable() { // from class: com.tencent.av.ui.fragment.NTDoubleVideoFragment.1
            @Override // java.lang.Runnable
            public void run() {
                if (NTDoubleVideoFragment.this.isDestroyed()) {
                    return;
                }
                long d16 = e.d();
                if (!r.h0().e() && n.e().f().f73039j == 1 && n.e().f().N) {
                    if (QLog.isColorLevel()) {
                        QLog.w(NTBaseVideoFragment.f75610s0, 1, "FixTerSwitchStatus ,switch to pc ,local close camera, seq[" + d16 + "]");
                    }
                    NTDoubleVideoFragment.this.ji(d16);
                    NTDoubleVideoFragment.this.G.k0(new Object[]{106, Long.valueOf(d16)});
                    cw.e.n(NTDoubleVideoFragment.this.G, 1021);
                }
                NTDoubleVideoFragment.this.lk(d16, 33554431);
                if (n.e().f().K) {
                    r.h0().I2(true, n.e().f().f73091w);
                }
            }
        };
        this.O0 = new Runnable() { // from class: com.tencent.av.ui.fragment.NTDoubleVideoFragment.2
            @Override // java.lang.Runnable
            public void run() {
                if (r.h0() == null || n.e().f().z()) {
                    return;
                }
                cw.e.n(NTDoubleVideoFragment.this.G, 1049);
                DataReport.T(null, "CliOper", "", "", "0X8009D02", "0X8009D02", 0, 0, "", "", "", "");
            }
        };
        this.P0 = -1L;
        this.Q0 = 0;
        this.R0 = new Runnable() { // from class: com.tencent.av.ui.fragment.NTDoubleVideoFragment.3
            @Override // java.lang.Runnable
            public void run() {
                SessionInfo f16 = n.e().f();
                QLog.w(NTBaseVideoFragment.f75610s0, 1, "CheckRemoteCameraRunnable, 5s has past, \u5bf9\u65b9\u89c6\u9891\u6570\u636e\u6ca1\u6765, mRecvVideoData[" + NTDoubleVideoFragment.this.f75652u0 + "], SessionType[" + f16.f73035i + "], shutCameraAnswer[" + f16.S + "], cameraPermission[" + f16.T + "]");
                if (NTDoubleVideoFragment.this.f75652u0 || f16.f73035i != 2) {
                    return;
                }
                r.h0().J1(f16.f73091w);
                if (f16.S || !f16.T) {
                    f16.p0(-1011L, "CheckRemoteCameraRunnable", 1);
                    NTDoubleVideoFragment.this.Vk("CheckRemoteCameraRunnable", 1);
                }
                NTDoubleVideoFragment.this.yj(-1011L);
            }
        };
        this.S0 = new a();
    }

    private void Tk(final AVActivity aVActivity, SessionInfo sessionInfo) {
        String str = sessionInfo.f73091w;
        int a16 = kw.a.a(aVActivity.getAppRuntime(), str, true, aVActivity.f74644b0 == 1);
        if (sessionInfo.f73043k == 4 || !sessionInfo.E() || aVActivity.f74679u0 || aVActivity.f74644b0 != 1 || aVActivity.isDestroyed()) {
            return;
        }
        final ViewGroup viewGroup = (ViewGroup) aVActivity.findViewById(R.id.g6f);
        VideoAppInterface videoAppInterface = aVActivity.H0;
        this.B0.addFunCallVideo(aVActivity, viewGroup, str, a16, videoAppInterface != null ? AVUtil.k(videoAppInterface.getCurrentAccountUin()) : false);
        aVActivity.H0.M().postDelayed(new Runnable() { // from class: com.tencent.av.ui.fragment.NTDoubleVideoFragment.5
            @Override // java.lang.Runnable
            public void run() {
                if (r.h0() == null || aVActivity.isDestroyed() || n.e().f().f73043k == 4) {
                    return;
                }
                AVActivity aVActivity2 = aVActivity;
                if (aVActivity2.f74644b0 != 1 || aVActivity2.f74679u0 || viewGroup == null) {
                    return;
                }
                VideoLayerUI videoLayerUI = aVActivity2.J0;
                if (videoLayerUI != null) {
                    videoLayerUI.G0();
                }
                aVActivity.X3(false);
                aVActivity.U3();
            }
        }, 1000L);
    }

    private boolean Xk(long j3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis <= this.P0 + j3) {
            return false;
        }
        this.P0 = currentTimeMillis;
        return true;
    }

    private void bl(boolean z16) {
        AVHidePart aVHidePart = this.f75619h0;
        if (aVHidePart != null) {
            aVHidePart.C9(z16);
        }
        if (QZoneVideoContactsFeedHelper.g(z16)) {
            return;
        }
        onBackPressed();
    }

    private void el() {
        if (this.D0 != null) {
            return;
        }
        IAVZplanAvatarBizApi iAVZplanAvatarBizApi = (IAVZplanAvatarBizApi) QRoute.api(IAVZplanAvatarBizApi.class);
        this.D0 = iAVZplanAvatarBizApi;
        iAVZplanAvatarBizApi.init(wh());
    }

    private void fl() {
        if (wh() == null || wh().f74657h1 == null || r.h0() == null || wh().f74657h1.q() || !VideoUtil.h(this.G)) {
            return;
        }
        QZoneVideoContactsFeedHelper.c(this.G, n.e().f(), wh());
    }

    private void gl() {
        if (VideoUtil.h(this.G) && this.f75657z0) {
            fl();
        } else {
            ll();
        }
    }

    private void jl(String str, SessionInfo sessionInfo) {
        if (this.G == null || sessionInfo == null || sessionInfo.G || sessionInfo.P2.booleanValue() || !sessionInfo.K()) {
            return;
        }
        ((SafetyHandler) this.G.getBusinessHandler(SafetyHandler.class.getName())).E2(str, sessionInfo.f73091w, sessionInfo.G);
        sessionInfo.P2 = Boolean.TRUE;
    }

    private void kl() {
        IAVFoldingDeviceBizApi iAVFoldingDeviceBizApi = this.E0;
        if (iAVFoldingDeviceBizApi != null) {
            iAVFoldingDeviceBizApi.hideNavBarForOppoFindN();
        }
    }

    private void ll() {
        cw.e.c(this.G);
    }

    private void ol() {
        AVAvatarEntryPart aVAvatarEntryPart = this.f75612a0;
        if (aVAvatarEntryPart != null) {
            aVAvatarEntryPart.G9();
        }
    }

    private void pl() {
        AVAvatarEntryPart aVAvatarEntryPart = this.f75612a0;
        if (aVAvatarEntryPart != null) {
            aVAvatarEntryPart.H9();
        }
    }

    private void tl() {
        AVAvatarEntryPart aVAvatarEntryPart = this.f75612a0;
        if (aVAvatarEntryPart != null) {
            aVAvatarEntryPart.I9();
        }
    }

    private void wl() {
        f fVar = this.U;
        boolean z16 = fVar != null && fVar.O9();
        QLog.w(NTBaseVideoFragment.f75610s0, 1, "setForground, requestPermissionIng[" + z16 + "]");
        if (z16 || r.h0() == null || this.f75653v0 || n.e().m() || n.e().f().H2) {
            return;
        }
        r.h0().K3();
    }

    private void zl(final long j3) {
        SessionInfo f16 = n.e().f();
        if (f16.z()) {
            if (!r.h0().e1() && r.h0().K() >= 2 && !f16.L && r.h0().t0(f16.f73091w) == 5) {
                DataReport.S();
            }
            if (f16.f73035i == 2) {
                dl(j3, true);
            }
            this.G.A0(f16.f73067q, f16.f73091w);
            return;
        }
        if (f16.A()) {
            xl(f16.M0 ? R.string.db6 : R.string.iel);
            return;
        }
        if (f16.K()) {
            int i3 = f16.f73081t1 ? R.string.djs : R.string.djr;
            if (f16.f73067q == 1011) {
                i3 = R.string.d_a;
            }
            if (f16.M0) {
                QLog.w(NTBaseVideoFragment.f75610s0, 1, "Inviting, remotePhoneState[" + f16.f73008c0 + "], isPeerNetworkWell[" + f16.V + "], remoteOnline[" + f16.W + "], remoteTerminal[" + f16.Q + "]");
                if (f16.f73008c0 == 0 && f16.V && f16.Q != 2 && f16.f73035i == 1) {
                    cw.e.n(this.G, 1038);
                }
            }
            xl(i3);
            this.G.A0(f16.f73067q, f16.f73091w);
            int i16 = f16.f73008c0;
            if (i16 <= 0 || i16 == 3) {
                return;
            }
            DataReport.R();
            return;
        }
        if (f16.u()) {
            xl(R.string.dfx);
            return;
        }
        if (f16.w() || f16.x()) {
            Oj(f16.A0);
            if (f16.f73067q == 1011) {
                xl(R.string.dj8);
            }
            this.G.M().postDelayed(new Runnable() { // from class: com.tencent.av.ui.fragment.NTDoubleVideoFragment.6
                @Override // java.lang.Runnable
                public void run() {
                    if (NTDoubleVideoFragment.this.isDestroyed()) {
                        return;
                    }
                    SessionInfo f17 = n.e().f();
                    r.h0().r(f17.f73091w, 239);
                    r.h0().j2(239);
                    r.h0().q(f17.f73091w, 9);
                    NTDoubleVideoFragment.this.G.k0(new Object[]{28, f17.f73091w, Boolean.TRUE});
                    QLog.w(NTBaseVideoFragment.f75610s0, 1, "onCreate, exit when OnCreate, seq[" + j3 + "]");
                    NTDoubleVideoFragment.this.G.u(j3, 1008);
                }
            }, 150L);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public IAVFoldingDeviceBizApi Bh() {
        return this.E0;
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Bi(long j3, View view) {
        AVSmallHomeTipsPart aVSmallHomeTipsPart = this.J0;
        if (aVSmallHomeTipsPart != null) {
            aVSmallHomeTipsPart.B9(j3, view);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public int Ch() {
        return m.j.f76050a;
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Ci(long j3) {
        AVCameraPart aVCameraPart = this.f75613b0;
        if (aVCameraPart != null) {
            aVCameraPart.Q9(j3);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public boolean Ej(int i3) {
        AVDoubleGlassCheckPart aVDoubleGlassCheckPart = this.G0;
        return aVDoubleGlassCheckPart != null && aVDoubleGlassCheckPart.R9(i3);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Fj(int i3) {
        SessionInfo f16 = n.e().f();
        if (i3 != f16.V1) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "setGlassWaitTime, WaitTime[" + f16.V1 + "->" + i3 + "]");
        }
        f16.V1 = i3;
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    void Gi() {
        com.tencent.av.ui.part.base.panel.c cVar = this.f75618g0;
        if (cVar != null) {
            cVar.F9();
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Gk(long j3) {
        AVVideoRecordUIPart aVVideoRecordUIPart;
        if (isDestroyed() || (aVVideoRecordUIPart = this.K0) == null) {
            return;
        }
        aVVideoRecordUIPart.F9(wh(), n.e().f(), this.J, j3);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Hk(long j3) {
        AVScreenSharePart aVScreenSharePart = this.f75623l0;
        if (aVScreenSharePart != null) {
            aVScreenSharePart.V9(j3);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Ji() {
        d dVar = this.f75622k0;
        if (dVar != null) {
            dVar.T9();
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public IAVVideoRecordBizApi Kh() {
        return this.C0;
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Ki(long j3) {
        QLog.w(NTBaseVideoFragment.f75610s0, 1, "onDestroy, seq[" + j3 + "]");
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        VideoAppInterface videoAppInterface = this.G;
        if (videoAppInterface != null) {
            videoAppInterface.removeObserver(this.S0);
            this.G.C0("DoubleVideoCtrlUI");
            this.G.M().removeCallbacks(this.R0);
            this.G.M().removeCallbacks(this.N0);
            this.G.M().removeCallbacks(this.O0);
            Vj(true);
            ll();
        }
        ViewGroup viewGroup = this.H;
        if (viewGroup != null) {
            RelativeLayout relativeLayout = (RelativeLayout) viewGroup.findViewById(R.id.bok);
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            this.H.removeAllViews();
        }
        IAVVideoRecordBizApi iAVVideoRecordBizApi = this.C0;
        if (iAVVideoRecordBizApi != null) {
            iAVVideoRecordBizApi.onDestroy(r.h0() == null ? null : n.e().f());
        }
        this.E = null;
        this.I = null;
        this.N0 = null;
        this.O0 = null;
        this.R0 = null;
        s sVar = this.f75656y0;
        if (sVar != null) {
            sVar.a();
            this.f75656y0 = null;
        }
        if (this.B0 != null) {
            if (VipFunCallUtil.ifUseKuikly()) {
                this.B0.onDestroy();
            } else {
                IAVVideoFunCallBizApi iAVVideoFunCallBizApi = this.A0;
                if (iAVVideoFunCallBizApi != null) {
                    iAVVideoFunCallBizApi.onDestroy();
                }
            }
        }
        IAVZplanAvatarBizApi iAVZplanAvatarBizApi = this.D0;
        if (iAVZplanAvatarBizApi != null) {
            iAVZplanAvatarBizApi.onDestroy();
        }
        IAVFoldingDeviceBizApi iAVFoldingDeviceBizApi = this.E0;
        if (iAVFoldingDeviceBizApi != null) {
            iAVFoldingDeviceBizApi.onDestroy();
            this.E0 = null;
        }
        super.Ki(j3);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Li(long j3, int i3) {
        if (r.h0() == null || this.G == null) {
            return;
        }
        if (i3 == 2) {
            if (n.e().f().N) {
                ji(j3);
                this.G.k0(new Object[]{106, Long.valueOf(j3)});
                if (QLog.isColorLevel()) {
                    QLog.w(NTBaseVideoFragment.f75610s0, 1, "onDetectNoDevicePermission local close camera, remote[" + n.e().f().O + "]");
                }
            }
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "onDetectNoDevicePermission, set cameraPermission = false");
            n.e().f().T = false;
            lk(j3, 33554431);
        }
        super.Li(j3, i3);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Mh() {
        super.Mh();
        this.f75657z0 = true;
        gl();
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Mj(String str, Bitmap bitmap) {
        this.H0.M9(str, bitmap);
        super.Mj(str, bitmap);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    void Mk(long j3) {
        AVVideoRecordUIPart aVVideoRecordUIPart;
        if (isDestroyed() || (aVVideoRecordUIPart = this.K0) == null) {
            return;
        }
        aVVideoRecordUIPart.G9(this.J);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Nh(boolean z16) {
        super.Nh(z16);
        QZoneVideoContactsFeedHelper.j(z16);
        if (z16) {
            ll();
        } else {
            fl();
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Ni(int i3) {
        IAVVideoRecordBizApi iAVVideoRecordBizApi = this.C0;
        if (iAVVideoRecordBizApi != null) {
            iAVVideoRecordBizApi.changeVideoLayoutMode(wh());
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Nj(String str) {
        this.H0.N9(str, n.e().f());
        super.Nj(str);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Oi() {
        AVVideoRecordUIPart aVVideoRecordUIPart = this.K0;
        if (aVVideoRecordUIPart != null) {
            aVVideoRecordUIPart.E9();
        }
        lk(-1027L, 33554431);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Pj(long j3, int i3) {
        if (!n.e().f().N && !n.e().f().O) {
            Sj(j3, 0.0f);
        } else {
            Sj(j3, 360 - i3);
        }
        AVChildGuideUIPart aVChildGuideUIPart = this.F0;
        if (aVChildGuideUIPart != null) {
            aVChildGuideUIPart.G9(i3);
        }
        IAVVideoRecordBizApi iAVVideoRecordBizApi = this.C0;
        if (iAVVideoRecordBizApi != null) {
            iAVVideoRecordBizApi.handleVideoOrientationChanged(i3);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Qk(long j3) {
        AVSmallHomeTipsPart aVSmallHomeTipsPart = this.J0;
        if (aVSmallHomeTipsPart != null) {
            aVSmallHomeTipsPart.C9();
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Ri() {
        if (tv.c.c(this.G.getApp()) == 1) {
            this.f75652u0 = true;
            return;
        }
        long d16 = e.d();
        QLog.d(NTBaseVideoFragment.f75610s0, 1, "onNeedShowPeerVideo, CheckRemoteCameraRunnable stop, shutCameraAnswer[" + n.e().f().S + ", seq[" + d16 + "]");
        this.G.M().removeCallbacks(this.R0);
        if (n.e().f().S) {
            Vk("onNeedShowPeerVideo.1", 2);
            lk(d16, 33554431);
        }
        if (n.e().f().f73035i == 1) {
            n.e().f().p0(d16, "onNeedShowPeerVideo.2", 2);
            Vk("onNeedShowPeerVideo.2", 2);
        }
        this.f75652u0 = true;
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Rk() {
        AVAvatarEntryPart aVAvatarEntryPart = this.f75612a0;
        if (aVAvatarEntryPart != null) {
            aVAvatarEntryPart.M9();
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Th() {
        AVNameAndHeadPart aVNameAndHeadPart = this.H0;
        if (aVNameAndHeadPart != null) {
            aVNameAndHeadPart.H9();
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Ti(boolean z16) {
        long d16 = e.d();
        if (QLog.isColorLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "onNotRecvAudioData, bNotRecv[" + z16 + "], seq[" + d16 + "]");
        }
        if (z16) {
            this.D = 1;
        } else {
            this.D = 2;
        }
        if (z16) {
            if (r.h0().t0(n.e().f().f73091w) != 5) {
                cw.e.n(this.G, 3005);
            }
        } else {
            if (r.h0().t0(n.e().f().f73091w) != 5) {
                cw.e.d(this.G, 3005);
            }
            AVChatTimePart aVChatTimePart = this.f75615d0;
            if (aVChatTimePart != null) {
                aVChatTimePart.M9(d16);
            }
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Tj(int i3, boolean z16) {
        i iVar = this.Q;
        if (iVar != null) {
            iVar.D9(getContext(), i3, z16);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Uj(long j3, String str, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "setTitleText, startRingAnimator[" + z16 + "], seq[" + j3 + "]");
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Dj(j3, str);
    }

    public void Uk(int i3, boolean z16, int i16) {
        QavPanel qavPanel;
        int i17 = m.l.f76072r;
        if ((i3 == i17 || i3 == m.l.f76071q) && (qavPanel = this.J) != null) {
            qavPanel.v(z16, i16);
            this.J.S0(i17, z16);
            this.J.setViewEnable(i17, z16);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Vh() {
        super.Vh();
        ll();
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Vi() {
        long d16 = e.d();
        if (e.k()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "onOppositeAudioEngineReady, seq[" + d16 + "]");
        }
        String str = n.e().f().f73091w;
        int t06 = r.h0().t0(str);
        int s06 = r.h0().s0(str);
        if (t06 == 5 || t06 == 0 || !r.h0().i1() || !n.e().f().z() || s06 <= 18 || !n.e().f().f73101y1) {
            return;
        }
        this.f75615d0.M9(d16);
    }

    void Vk(String str, int i3) {
        long d16 = e.d();
        QLog.w(NTBaseVideoFragment.f75610s0, 1, "avSwitch[" + str + "], sessionType[" + i3 + "], seq[" + d16 + "]");
        d dVar = this.f75622k0;
        if (dVar != null) {
            dVar.na();
        }
        SessionInfo f16 = n.e().f();
        if (i3 == 1 && !f16.f73098x2 && !f16.f73102y2) {
            refreshUI();
            dl(d16, false);
            lk(d16, 33554431);
        } else if (i3 == 2) {
            dl(d16, true);
        }
        as asVar = this.L;
        if (asVar != null) {
            asVar.m(n.e().f().f73035i == 1);
            this.L.n(n.e().f().f73035i == 1);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Wi(long j3) {
        super.ej(j3);
        as asVar = this.L;
        if (asVar != null) {
            asVar.q(false);
        }
        QLog.i(NTBaseVideoFragment.f75610s0, 1, "onPause enter background");
        r.h0().H3(true);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Wj(boolean z16) {
        View findViewById;
        ViewGroup viewGroup = this.H;
        if (viewGroup == null || (findViewById = viewGroup.findViewById(R.id.acz)) == null) {
            return;
        }
        if (z16 && findViewById.getVisibility() != 0) {
            findViewById.setVisibility(0);
        } else {
            if (z16 || findViewById.getVisibility() == 8) {
                return;
            }
            findViewById.setVisibility(8);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Xh(Activity activity) {
        if (this.C0 == null) {
            IAVVideoRecordBizApi iAVVideoRecordBizApi = (IAVVideoRecordBizApi) QRoute.api(IAVVideoRecordBizApi.class);
            this.C0 = iAVVideoRecordBizApi;
            iAVVideoRecordBizApi.init(activity);
        }
        this.C0.initRecordUiCtrl(activity, 0L);
        this.C0.initVideoLayerUI(activity);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public boolean Yh() {
        return yt.e.c(this.G.getCurrentAccountUin());
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Yi() {
        super.Yi();
        this.f75655x0 = true;
        wl();
        yl();
    }

    public void Yk(boolean z16) {
        d dVar = this.f75622k0;
        if (dVar != null) {
            dVar.oa(z16);
        }
        if (z16) {
            if (this.J != null) {
                if (n.e().f().f73067q == 9500 && !r.h0().k1()) {
                    this.J.H0(n.e().f().f73035i == 2, 0, false);
                    return;
                } else {
                    boolean z17 = n.e().f().f73035i == 2;
                    this.J.H0(z17, z17 ? 2 : 1, true);
                    return;
                }
            }
            return;
        }
        if (this.J != null) {
            if (n.e().f().f73067q == 9500 && !r.h0().k1()) {
                this.J.H0(n.e().f().f73035i == 2, 0, false);
            } else {
                boolean z18 = n.e().f().f73035i == 2;
                this.J.H0(z18, z18 ? 2 : 1, false);
            }
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public boolean Zh() {
        AVChildGuideUIPart aVChildGuideUIPart = this.F0;
        return aVChildGuideUIPart != null && aVChildGuideUIPart.D9();
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Zi() {
        long d16 = e.d();
        QLog.w(NTBaseVideoFragment.f75610s0, 1, "onPauseVideo, seq[" + d16 + "]");
        if (!n.e().f().N) {
            Vk("onPauseVideo", 1);
            il();
        } else {
            n.e().f().U1 = 0;
        }
        if (!n.e().f().N) {
            if (QLog.isColorLevel()) {
                QLog.d(NTBaseVideoFragment.f75610s0, 2, "onResumeVideo setRotation");
            }
            Sj(d16, 0.0f);
        }
        IAVVideoRecordBizApi iAVVideoRecordBizApi = this.C0;
        if (iAVVideoRecordBizApi != null) {
            iAVVideoRecordBizApi.onPauseVideo(wh(), n.e().f(), d16);
        }
    }

    public void Zk(boolean z16, boolean z17) {
        boolean z18 = false;
        boolean z19 = (r.h0() == null || n.e().f() == null) ? false : n.e().f().f73098x2;
        g gVar = this.I0;
        if (gVar != null) {
            gVar.A9((!z16 || z19) ? 8 : 0);
        }
        if (this.H == null || !z17) {
            return;
        }
        QavPanel qavPanel = this.J;
        if (qavPanel != null) {
            qavPanel.c1(!z16);
        }
        i iVar = this.Q;
        if (iVar != null) {
            if (z16 && !z19) {
                z18 = true;
            }
            iVar.C9(z18);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void aj(String str, boolean z16) {
        long d16 = e.d();
        if (QLog.isColorLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "onPeerSwitchTerminal, peerUin[" + str + "], bStartSwitch[" + z16 + "], seq[" + d16 + "]");
        }
        if (z16) {
            cw.e.n(this.G, 1020);
        } else {
            cw.e.d(this.G, 1020);
            if (!r.h0().e() && n.e().f().f73039j == 1 && n.e().f().N) {
                if (QLog.isColorLevel()) {
                    QLog.d(NTBaseVideoFragment.f75610s0, 2, "onPeerSwitchTerminal, local close camera");
                }
                ji(d16);
                this.G.k0(new Object[]{106, Long.valueOf(d16)});
                cw.e.n(this.G, 1021);
            }
            this.G.M().postDelayed(this.N0, 2000L);
            r.h0().R1();
        }
        lk(d16, 33554431);
        DoodleLogic b16 = DoodleLogic.b();
        if (z16) {
            b16.f73593l = false;
            b16.f73594m = 0;
            if (QLog.isColorLevel()) {
                QLog.e(NTBaseVideoFragment.f75610s0, 2, "WL_DEBUG onPeerSwitchTerminal mPeerVersion = " + b16.f73594m + ", mIsPeerSupport = " + b16.f73593l);
            }
            SmallScreenUtils.m();
            this.G.k0(new Object[]{127});
        } else {
            b16.k();
        }
        IAVVideoRecordBizApi iAVVideoRecordBizApi = this.C0;
        if (iAVVideoRecordBizApi != null) {
            iAVVideoRecordBizApi.onPeerSwitchTerminal(wh());
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void ak(int i3) {
        AVToolBarPart aVToolBarPart = this.Y;
        if (aVToolBarPart != null) {
            aVToolBarPart.ga(i3);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        AVChildGuideUIPart aVChildGuideUIPart = new AVChildGuideUIPart();
        this.F0 = aVChildGuideUIPart;
        assembleParts.add(aVChildGuideUIPart);
        com.tencent.av.ui.part.base.c cVar = new com.tencent.av.ui.part.base.c();
        this.R = cVar;
        assembleParts.add(cVar);
        AVDoubleGlassCheckPart aVDoubleGlassCheckPart = new AVDoubleGlassCheckPart();
        this.G0 = aVDoubleGlassCheckPart;
        assembleParts.add(aVDoubleGlassCheckPart);
        AVNameAndHeadPart aVNameAndHeadPart = new AVNameAndHeadPart(false);
        this.H0 = aVNameAndHeadPart;
        assembleParts.add(aVNameAndHeadPart);
        QLog.w(NTBaseVideoFragment.f75610s0, 1, "assembleParts......");
        g gVar = new g();
        this.I0 = gVar;
        assembleParts.add(gVar);
        AVSmallHomeTipsPart aVSmallHomeTipsPart = new AVSmallHomeTipsPart();
        this.J0 = aVSmallHomeTipsPart;
        assembleParts.add(aVSmallHomeTipsPart);
        AVVideoRecordUIPart aVVideoRecordUIPart = new AVVideoRecordUIPart(this.J);
        this.K0 = aVVideoRecordUIPart;
        assembleParts.add(aVVideoRecordUIPart);
        AVToolBarPart aVToolBarPart = new AVToolBarPart(3);
        this.Y = aVToolBarPart;
        assembleParts.add(aVToolBarPart);
        d dVar = new d(this.J);
        this.f75622k0 = dVar;
        assembleParts.add(dVar);
        AVAvatarEntryPart aVAvatarEntryPart = new AVAvatarEntryPart(this.J);
        this.f75612a0 = aVAvatarEntryPart;
        assembleParts.add(aVAvatarEntryPart);
        com.tencent.av.ui.part.dav.panel.b bVar = new com.tencent.av.ui.part.dav.panel.b(this.J);
        this.L0 = bVar;
        assembleParts.add(bVar);
        com.tencent.av.ui.part.dav.panel.c cVar2 = new com.tencent.av.ui.part.dav.panel.c(this.J);
        this.M0 = cVar2;
        assembleParts.add(cVar2);
        return assembleParts;
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public boolean bi() {
        if (r.h0() == null) {
            return false;
        }
        return n.e().f().z();
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void bk() {
        super.bk();
        fl();
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void cj(int i3) {
        IAVVideoFunCallBizApi iAVVideoFunCallBizApi = this.A0;
        if (iAVVideoFunCallBizApi != null) {
            iAVVideoFunCallBizApi.onPlayAnimate(i3);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void ck(String str) {
        super.ck(str);
        n.e().f().f73052m0 = false;
        il();
    }

    public void cl(long j3, int i3) {
        if (isDestroyed()) {
            return;
        }
        boolean n3 = AVUtil.n(i3);
        if (this.Q0 != i3) {
            if (QLog.isDevelopLevel()) {
                QLog.i(NTBaseVideoFragment.f75610s0, 4, "changeUIMode, [" + this.Q0 + "-->" + i3 + "], isVideo[" + n3 + "] isToolBarDisplay[" + di() + "]");
            }
            this.Q0 = i3;
            if (i3 == 1 && !di()) {
                ak(0);
            }
        }
        if (n.e().f().f73067q == 9500 && !r.h0().k1()) {
            this.J.H0(n3, 0, false);
            d dVar = this.f75622k0;
            if (dVar != null) {
                dVar.na();
            }
        } else {
            lk(-1014L, 33554431);
        }
        WeakReference<Context> weakReference = this.F;
        if (weakReference != null && (weakReference.get() instanceof AVActivity)) {
            AVActivity aVActivity = (AVActivity) this.F.get();
            aVActivity.X3(!n3);
            aVActivity.U3();
            kl();
        }
        AVNameAndHeadPart aVNameAndHeadPart = this.H0;
        if (aVNameAndHeadPart != null) {
            aVNameAndHeadPart.D9(i3);
        }
        AVNetConnectInfoPart aVNetConnectInfoPart = this.T;
        if (aVNetConnectInfoPart != null) {
            aVNetConnectInfoPart.D9(i3);
        }
        oj(Boolean.valueOf(n3));
        vj();
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void dj(long j3, boolean z16) {
        if (n.e().f().f73035i == 1) {
            lk(j3, 33554431);
        }
    }

    void dl(long j3, boolean z16) {
        SessionInfo f16 = n.e().f();
        int i3 = (z16 || ((f16.f73098x2 || f16.f73102y2) && ax.a.c(this.G))) ? 2 : 1;
        if (z16) {
            ll();
        }
        cl(j3, i3);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void ej(long j3) {
        super.ej(j3);
        as asVar = this.L;
        if (asVar != null) {
            asVar.q(true);
        }
        QLog.i(NTBaseVideoFragment.f75610s0, 1, "onResume from background");
        r.h0().H3(false);
        SessionInfo f16 = n.e().f();
        if (f16.z()) {
            if (f16.f73076s0 != 1) {
                super.dk(j3);
            }
            as asVar2 = this.L;
            if (asVar2 != null) {
                asVar2.n(f16.f73035i == 1);
            }
        }
        refreshUI();
        DataReport.u();
        this.f75655x0 = false;
        AVDoubleGlassCheckPart aVDoubleGlassCheckPart = this.G0;
        if (aVDoubleGlassCheckPart != null) {
            aVDoubleGlassCheckPart.onResume();
        }
        IAVVideoRecordBizApi iAVVideoRecordBizApi = this.C0;
        if (iAVVideoRecordBizApi != null) {
            iAVVideoRecordBizApi.onResume(f16, this.I);
        }
        IAVFoldingDeviceBizApi iAVFoldingDeviceBizApi = this.E0;
        if (iAVFoldingDeviceBizApi != null) {
            iAVFoldingDeviceBizApi.onResume(f16.F());
        }
        QLog.d(NTBaseVideoFragment.f75610s0, 1, "[old] QAV_CALL_START_COST end: " + System.currentTimeMillis());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QAVChangeToSmallScreenEvent.class);
        arrayList.add(QAVBackPressedBeforeEnterQZoneEvent.class);
        return arrayList;
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void gi(long j3, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "onAfterCloseCamera, success[" + z16 + "], seq[" + j3 + "]");
        }
        lk(j3, 33554431);
        if (z16) {
            DataReport.Z();
            DataReport.O();
            if (!n.e().f().O) {
                Vk("onAfterCloseCamera", 1);
            }
            if (n.e().f().O) {
                return;
            }
            Sj(j3, 0.0f);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void hi(long j3, boolean z16, int i3) {
        if (isDestroyed()) {
            return;
        }
        WeakReference<Context> weakReference = this.F;
        AVActivity aVActivity = (weakReference == null || weakReference.get() == null) ? null : (AVActivity) this.F.get();
        boolean z17 = aVActivity == null || aVActivity.checkSelfPermission(QQPermissionConstants.Permission.CAMERA) == 0;
        QLog.w(NTBaseVideoFragment.f75610s0, 1, "onAfterOpenCamera, success[" + z16 + "], preSessionType[" + i3 + "], isConnected[" + n.e().f().f73043k + "], remoteHasVideo[" + n.e().f().O + "], checkCameraResult[" + z17 + "], seq[" + j3 + "]");
        if (z16) {
            this.J.setViewVisibility(m.l.A, 0);
            nj(true);
            n.e().f().T = true;
            DataReport.c();
            DataReport.z();
            if (!n.e().f().O && (n.e().f().z() || n.e().f().f73098x2)) {
                Vk("onAfterOpenCamera", 2);
            }
            yj(j3);
        }
        if (n.e().f().f73035i == 2 && aVActivity != null) {
            ((ViewGroup) aVActivity.findViewById(R.id.bok)).setBackground(null);
        }
        lk(j3, 33554431);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void hj() {
        long d16 = e.d();
        if (e.k()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "onSelfAudioEngineReady, seq[" + d16 + "]");
        }
        int t06 = r.h0().t0(n.e().f().f73091w);
        if (t06 == 5 || t06 == 0) {
            this.f75615d0.M9(d16);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void hk(int i3) {
        AVChildGuideUIPart aVChildGuideUIPart = this.F0;
        if (aVChildGuideUIPart != null) {
            aVChildGuideUIPart.J9(i3, this.f75655x0);
        }
    }

    public void hl() {
        AVToolBarPart aVToolBarPart = this.Y;
        if (aVToolBarPart != null) {
            aVToolBarPart.childLock();
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void ij(boolean z16, boolean z17) {
        d dVar = this.f75622k0;
        if (dVar != null) {
            dVar.F9(z17);
        }
    }

    public void il() {
        yl();
        AVToolBarPart aVToolBarPart = this.Y;
        if (aVToolBarPart != null) {
            aVToolBarPart.N9();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void initUI() {
        int i3;
        super.initUI();
        q.c(BaseApplicationImpl.getApplication());
        SessionInfo f16 = n.e().f();
        if (f16.f73035i == 1 && ((i3 = f16.f73043k) == 1 || i3 == 0)) {
            DataReport.T(null, "CliOper", "", "", "0X8009ED8", "0X8009ED8", 1, 1, "", "", "", "");
        }
        aj.a(wh());
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void ji(long j3) {
        if (QLog.isColorLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "onBeforeCloseCamera, seq[" + j3 + "]");
        }
        lk(j3, 33554431);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void jj() {
        if (n.e().f().K()) {
            this.G.A0(n.e().f().f73067q, n.e().f().f73091w);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void lj(long j3) {
        f fVar = this.U;
        boolean z16 = fVar != null && fVar.O9();
        if (QLog.isDevelopLevel() || z16) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "onStop, requestPermissionIng[" + z16 + "], seq[" + j3 + "]");
        }
        super.lj(j3);
        IAVVideoRecordBizApi iAVVideoRecordBizApi = this.C0;
        if (iAVVideoRecordBizApi != null) {
            iAVVideoRecordBizApi.onStop(n.e().f());
        }
        if (r.h0() == null || !n.e().f().z()) {
            return;
        }
        super.ek(j3);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void mj(int i3, int i16) {
        long d16 = e.d();
        if (QLog.isColorLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "onTerSwitchSyncStatus, cameraStatus[" + i3 + "], micStatus[" + i16 + "]");
        }
        if (isDestroyed()) {
            return;
        }
        boolean z16 = i3 == 1;
        if (!z16) {
            ji(d16);
            this.G.k0(new Object[]{106, Long.valueOf(d16)});
        } else {
            ki(d16);
            this.G.k0(new Object[]{105, Boolean.FALSE, Long.valueOf(d16)});
        }
        SessionInfo f16 = n.e().f();
        if (!z16 && !f16.O) {
            if (f16.f73035i == 2) {
                f16.p0(d16, "onTerSwitchSyncStatus.2", 1);
                Vk("onTerSwitchSyncStatus.2", f16.f73035i);
            }
        } else if (f16.f73035i == 1) {
            f16.p0(d16, "onTerSwitchSyncStatus.1", 2);
            Vk("onTerSwitchSyncStatus.1", f16.f73035i);
        }
        d dVar = this.f75622k0;
        if (dVar != null) {
            dVar.ba(i16);
        }
    }

    public void nl(long j3) {
        com.tencent.av.ui.part.base.panel.a aVar = this.Z;
        if (aVar != null) {
            aVar.D9(j3, false);
        }
        lk(j3, 33554431);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void oi(long j3, View view) {
        AVCameraPart aVCameraPart = this.f75613b0;
        if (aVCameraPart != null) {
            aVCameraPart.N9(j3, view);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void ok(long j3) {
        AVAvatarEntryPart aVAvatarEntryPart = this.f75612a0;
        if (aVAvatarEntryPart != null) {
            aVAvatarEntryPart.L9(j3);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public boolean onBackPressed() {
        long d16 = e.d();
        SessionInfo f16 = n.e().f();
        QLog.w(NTBaseVideoFragment.f75610s0, 1, "onBackPressed, seq[" + d16 + "], isChildLock[" + f16.f73048l0 + "]");
        AVChildGuideUIPart aVChildGuideUIPart = this.F0;
        if ((aVChildGuideUIPart != null && aVChildGuideUIPart.onBackPressed()) || f16.f73048l0) {
            return true;
        }
        if (super.onBackPressed()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "onBackPressed called return 2, seq[" + d16 + "]");
            return true;
        }
        wl();
        if (f16.w() || f16.x()) {
            Oj(f16.A0);
        }
        AVHidePart aVHidePart = this.f75619h0;
        if (aVHidePart == null) {
            return false;
        }
        aVHidePart.D9(d16);
        return false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QAVChangeToSmallScreenEvent) {
            QLog.d(NTBaseVideoFragment.f75610s0, 1, "change to small screen mode");
            bl(true);
        } else if (simpleBaseEvent instanceof QAVBackPressedBeforeEnterQZoneEvent) {
            onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        s sVar = new s(this.F.get(), 2, this.J, this.H.findViewById(m.d.f76006d), null, this.H0.F9(), this.H0.G9(), this.H.findViewById(m.n.f76083a), null);
        this.f75656y0 = sVar;
        sVar.b();
        this.f75618g0.L9(this.f75656y0);
        long d16 = e.d();
        SessionInfo f16 = n.e().f();
        ml(d16);
        if (f16.f73035i == 1) {
            dl(d16, false);
            if (f16.f73098x2 && ax.a.c(this.G)) {
                this.G.k0(new Object[]{Integer.valueOf(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_ON_RICH_MEDIA_PREPARED), Boolean.TRUE});
            } else if (f16.f73102y2 && ax.a.c(this.G)) {
                this.G.k0(new Object[]{530, f16.f73091w, Boolean.TRUE, "", 1});
            }
        } else {
            dl(d16, true);
        }
        zl(d16);
        if (f16.S) {
            refreshUI();
        }
        vl(d16, false);
    }

    void ql(String str) {
        com.tencent.av.ui.part.dav.panel.b bVar = this.L0;
        if (bVar != null) {
            bVar.C9(str);
        }
        this.f75653v0 = true;
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void refreshUI() {
        if (isDestroyed()) {
            return;
        }
        SessionInfo f16 = n.e().f();
        long d16 = e.d();
        if (QLog.isColorLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "refreshUI, SessionType[" + f16.f73035i + "], seq[" + d16 + "]");
        }
        AVNameAndHeadPart aVNameAndHeadPart = this.H0;
        if (aVNameAndHeadPart != null && aVNameAndHeadPart.L9(this.H)) {
            dl(d16, f16.f73035i == 2);
        }
        int i3 = f16.f73035i;
        if (i3 == 2) {
            dl(d16, true);
        } else if (i3 == 1) {
            Yk(false);
        }
        vj();
        lk(d16, 33554431);
        gl();
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void ri(long j3) {
        if (this.f75622k0 != null) {
            this.f75622k0.Q9(Wk());
        }
    }

    public void rl(long j3, View view) {
        com.tencent.av.ui.part.base.panel.b bVar = this.f75614c0;
        if (bVar != null) {
            bVar.C9(j3, view);
        }
    }

    public void sl(long j3, View view) {
        com.tencent.av.ui.part.dav.panel.c cVar = this.M0;
        if (cVar != null) {
            cVar.C9(j3, view);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void ti(long j3) {
        com.tencent.av.ui.part.dav.panel.d dVar = this.f75620i0;
        if (dVar != null) {
            dVar.G9(j3, false);
        }
    }

    void ul() {
        QavPanel qavPanel;
        if ((n.e().f().f73067q == 21 || n.e().f().f73067q == 1011) && (qavPanel = this.J) != null) {
            qavPanel.setViewVisibility(m.l.A, 8);
            this.J.setViewVisibility(m.l.B, 8);
            nj(false);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void vj() {
        AVNameAndHeadPart aVNameAndHeadPart = this.H0;
        if (aVNameAndHeadPart != null) {
            aVNameAndHeadPart.K9();
        }
    }

    void vl(long j3, boolean z16) {
        int i3 = n.e().f().f73035i;
        lk(j3, 33554431);
        SessionInfo f16 = n.e().f();
        if (i3 == 2 && tv.c.c(this.G.getApp()) == 1 && z16 && f16.z()) {
            VideoUtil.o(this.G);
            DataReport.T(null, "CliOper", "", "", "0X8004E92", "0X8004E92", 0, 0, "", "", "", "");
        }
        ul();
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void wi(long j3, View view) {
        boolean Wk = Wk();
        d dVar = this.f75622k0;
        if (dVar != null) {
            dVar.S9(j3, view, Wk);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void wk(long j3) {
        com.tencent.av.ui.part.dav.panel.c cVar = this.M0;
        if (cVar != null) {
            cVar.D9(j3);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void xi(long j3) {
        AVVideoRecordUIPart aVVideoRecordUIPart = this.K0;
        if (aVVideoRecordUIPart != null) {
            aVVideoRecordUIPart.D9(j3);
        }
    }

    void xl(int i3) {
        AVNetConnectInfoPart aVNetConnectInfoPart = this.T;
        if (aVNetConnectInfoPart != null) {
            aVNetConnectInfoPart.K9(i3);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void yi(long j3, View view) {
        AVScreenSharePart aVScreenSharePart = this.f75623l0;
        if (aVScreenSharePart != null) {
            aVScreenSharePart.M9(j3, view);
        }
    }

    void yl() {
        AVChildGuideUIPart aVChildGuideUIPart = this.F0;
        if (aVChildGuideUIPart != null) {
            aVChildGuideUIPart.I9();
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public boolean zk(long j3) {
        super.zk(j3);
        return yk(j3);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends lu.b {
        a() {
        }

        @Override // lu.b
        public void a(boolean z16, Object obj) {
            VideoAppInterface videoAppInterface;
            if (z16 && !NTDoubleVideoFragment.this.wh().isFinishing() && (obj instanceof String)) {
                String str = (String) obj;
                if (TextUtils.isEmpty(str) || (videoAppInterface = NTDoubleVideoFragment.this.G) == null) {
                    return;
                }
                videoAppInterface.k0(new Object[]{526, str});
            }
        }
    }

    private void al() {
        bl(false);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void si(long j3, View view) {
        Ph(true);
        com.tencent.av.ui.part.base.panel.c cVar = this.f75618g0;
        if (cVar != null) {
            cVar.E9(j3, view, new c());
        }
    }

    private boolean Wk() {
        return Xk(200L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v34, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r1v45 */
    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Ii() {
        String str;
        String str2;
        String str3;
        SessionInfo sessionInfo;
        long j3;
        int k26;
        SessionInfo sessionInfo2;
        ?? r16;
        Activity activity;
        as asVar;
        super.Ii();
        long d16 = e.d();
        SimpleEventBus.getInstance().registerReceiver(this);
        SessionInfo f16 = n.e().f();
        QLog.w(NTBaseVideoFragment.f75610s0, 1, "avideo onCreate, state[" + f16.f73043k + "], seq[" + d16 + "]");
        QZoneVideoContactsFeedHelper.f(this.G, f16, wh());
        initUI();
        if (f16.S0 == 0) {
            f16.S0 = 3;
        }
        if (!f16.D() && !f16.u()) {
            r16 = 1;
            str2 = "]";
            str3 = "], seq[";
            sessionInfo2 = f16;
            j3 = d16;
        } else {
            int i3 = (f16.M0 || f16.f73098x2) ? 0 : 1;
            int i16 = !f16.f73084u0 ? 4 : 1;
            int i17 = f16.f73067q;
            int i18 = (1008 == i17 || 1044 == i17) ? 4 : i16;
            if (f16.G) {
                k26 = r.h0().b(d16, f16.f73091w, i3, i18);
                str2 = "]";
                str3 = "], seq[";
                sessionInfo = f16;
                j3 = d16;
            } else {
                if (wh() != null) {
                    str = wh().getIntent().getStringExtra("trace_id");
                } else {
                    str = "";
                }
                str2 = "]";
                str3 = "], seq[";
                sessionInfo = f16;
                j3 = d16;
                k26 = r.h0().k2(j3, f16.f73091w, i3, i18, f16.C, f16.D, f16.B, f16.f73067q, f16.f73103z, f16.A, f16.J0, null, null, 0, 0, null, str);
            }
            if (QLog.isColorLevel()) {
                QLog.d(NTBaseVideoFragment.f75610s0, 2, "result = " + k26);
            }
            if (k26 != 0) {
                AVCoreLog.printAllUserLog(NTBaseVideoFragment.f75610s0, "Video connect fail:" + k26);
                if (k26 == -2) {
                    SessionInfo sessionInfo3 = sessionInfo;
                    r.h0().r(sessionInfo3.f73091w, 238);
                    r.h0().j2(238);
                    r.h0().q(sessionInfo3.f73091w, 9);
                }
                this.f75653v0 = true;
                WeakReference<Context> weakReference = this.F;
                if (weakReference == null || weakReference.get() == null || (activity = (Activity) this.F.get()) == null) {
                    return;
                }
                activity.finish();
                return;
            }
            sessionInfo2 = sessionInfo;
            r16 = 1;
        }
        if (QLog.isColorLevel()) {
            String str4 = NTBaseVideoFragment.f75610s0;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onCreate, ofter Request, state[");
            sb5.append(sessionInfo2.f73043k);
            sb5.append("], SessionType[");
            sb5.append(sessionInfo2.f73035i);
            sb5.append("], deviceName[");
            sb5.append(sessionInfo2.F0);
            sb5.append(str3);
            sb5.append(j3);
            sb5.append("], mApp[");
            sb5.append(this.G != null ? r16 : false);
            sb5.append(str2);
            QLog.w(str4, r16, sb5.toString());
        }
        VideoAppInterface videoAppInterface = this.G;
        if (videoAppInterface == null) {
            return;
        }
        videoAppInterface.addObserver(this.S0);
        if (sessionInfo2.M0 && (asVar = this.L) != 0) {
            asVar.m(r16);
            this.L.m(r16);
        }
        this.H.post(new Runnable() { // from class: com.tencent.av.ui.fragment.NTDoubleVideoFragment.4
            @Override // java.lang.Runnable
            public void run() {
                if (NTDoubleVideoFragment.this.isDestroyed()) {
                    return;
                }
                NTDoubleVideoFragment.this.G.k0(new Object[]{102});
            }
        });
        jl(this.G.getCurrentAccountUin(), sessionInfo2);
        if (this.B0 == null) {
            this.B0 = (IVasFunCallKuikly) QRoute.api(IVasFunCallKuikly.class);
        }
        AVActivity wh5 = wh();
        if (wh5 != null) {
            if (VipFunCallUtil.ifUseKuikly()) {
                Tk(wh5, sessionInfo2);
            } else {
                if (this.A0 == null) {
                    this.A0 = (IAVVideoFunCallBizApi) QRoute.api(IAVVideoFunCallBizApi.class);
                }
                this.A0.addVipCallVideo(wh5);
            }
        }
        IAVVideoRecordBizApi iAVVideoRecordBizApi = this.C0;
        if (iAVVideoRecordBizApi != null) {
            iAVVideoRecordBizApi.resetControlUI(this);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public IAVZplanAvatarBizApi Lh(boolean z16) {
        if (z16) {
            el();
        }
        return this.D0;
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void gj() {
        final long d16 = e.d();
        QLog.d(NTBaseVideoFragment.f75610s0, 1, "onResumeVideo, SessionType[" + n.e().f().f73035i + "], seq[" + d16 + "]");
        if (tv.c.c(this.G.getApp()) == 1) {
            VideoAppInterface videoAppInterface = this.G;
            cw.e.p(videoAppInterface, 1012, videoAppInterface.getApp().getString(R.string.idp));
            DataReport.T(null, "CliOper", "", "", "0X8004E94", "0X8004E94", 0, 0, "", "", "", "");
            DataReport.T(null, "CliOper", "", "", "0X8005614", "0X8005614", 0, 0, "", "", "", "");
            return;
        }
        DataReport.T(null, "CliOper", "", "", "0X8005613", "0X8005613", 0, 0, "", "", "", "");
        if (n.e().f().f73035i == 1) {
            n.e().f().p0(d16, "onResumeVideo", 2);
            Vk("onResumeVideo", 2);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.ui.fragment.NTDoubleVideoFragment.8
                @Override // java.lang.Runnable
                public void run() {
                    TraeHelper.I().g0(d16, NTDoubleVideoFragment.this.G, R.raw.qav_gaudio_join, null, 0, null);
                }
            }, 16, null, false);
            if (n.e().f().f73052m0) {
                hl();
            }
        } else {
            lk(d16, 33554431);
        }
        if (n.e().f().f73035i == 2) {
            ((ViewGroup) wh().findViewById(R.id.bok)).setBackground(null);
        }
        yj(d16);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x01bf  */
    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void kj(long j3) {
        boolean z16;
        SessionInfo f16;
        super.kj(j3);
        if (r.h0() != null) {
            if (n.e().f().K()) {
                String r16 = n.e().f().r("doubleVideoCtrl");
                if (zv.b.a().f453493c) {
                    long currentTimeMillis = System.currentTimeMillis() - n.e().f().f73083u;
                    com.tencent.avcore.rtc.node.report.utils.b.k(r16);
                    if (currentTimeMillis > 5 && currentTimeMillis < 10000) {
                        com.tencent.avcore.rtc.node.report.utils.b.j(r16, currentTimeMillis);
                        com.tencent.avcore.rtc.node.report.utils.b.l(r16, "rtc_caller_page_old_exposure_cost_time_ms", currentTimeMillis);
                    }
                    zv.b.a().f453513m = SystemClock.elapsedRealtime();
                } else {
                    zv.b.a().B = SystemClock.elapsedRealtime();
                }
                if (n.e().f().f73008c0 >= 0) {
                    if (n.e().f().f73067q == 1011) {
                        Cj(-1015L, R.string.d_a);
                    } else {
                        Cj(-1015L, R.string.d95);
                        long j16 = n.e().f().f73012d0;
                        String e16 = h.e(j16, 3);
                        if (new File(e16).exists()) {
                            if (!n.e().f().H) {
                                TraeHelper.I().g0(j3, this.G, 0, e16, -1, null);
                            }
                            DataReport.T(null, "CliOper", "", "", "0X8004A21", "0X8004A21", 0, 0, "" + n.e().f().f73016e0, j16 + "", "", "");
                        } else if (!n.e().f().H) {
                            TraeHelper.I().g0(j3, this.G, R.raw.f169426x, null, -1, null);
                        }
                    }
                }
                if (!n.e().f().z()) {
                    this.G.M().postDelayed(this.O0, 20000L);
                }
            }
            if (n.e().f().z()) {
                int i3 = n.e().f().f73035i;
                if (i3 != 1 && i3 != 3 && n.e().f().f73052m0) {
                    z16 = false;
                    n.e().f().f73048l0 = false;
                    hl();
                } else {
                    z16 = false;
                    il();
                }
                f16 = n.e().f();
                if ((f16 != null && (f16.f73098x2 || f16.f73102y2)) || (wh() != null && wh().J0 != null && wh().J0.P0())) {
                    el();
                    this.D0.switchFilamentViewMode(f16, true);
                }
                if (this.E0 == null) {
                    IAVFoldingDeviceBizApi iAVFoldingDeviceBizApi = (IAVFoldingDeviceBizApi) QRoute.api(IAVFoldingDeviceBizApi.class);
                    this.E0 = iAVFoldingDeviceBizApi;
                    AVActivity wh5 = wh();
                    if (f16 != null && f16.F()) {
                        z16 = true;
                    }
                    iAVFoldingDeviceBizApi.init(wh5, z16);
                }
                kl();
            }
        }
        z16 = false;
        f16 = n.e().f();
        if (f16 != null) {
            el();
            this.D0.switchFilamentViewMode(f16, true);
            if (this.E0 == null) {
            }
            kl();
        }
        el();
        this.D0.switchFilamentViewMode(f16, true);
        if (this.E0 == null) {
        }
        kl();
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void ki(long j3) {
        lk(j3, 33554431);
    }

    void ml(long j3) {
        lk(j3, 33554431);
        ul();
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Hi(long j3) {
        QavPanel qavPanel;
        AVToolBarPart aVToolBarPart;
        kl();
        SessionInfo f16 = n.e().f();
        long J = r.h0().J(f16.f73091w);
        QLog.w(NTBaseVideoFragment.f75610s0, 1, "onConnected, roomid[" + J + "], seq[" + j3 + "]");
        super.Hi(j3);
        VideoAppInterface videoAppInterface = this.G;
        if (videoAppInterface == null) {
            return;
        }
        if (videoAppInterface.M() != null && this.O0 != null) {
            this.G.M().removeCallbacks(this.O0);
        }
        Hk(j3);
        if (J > 0) {
            ((VideoNodeReporter) this.G.B(4)).w(J, 26, J);
        }
        int i3 = f16.f73035i;
        ap.b(i3, (J + "") + "");
        if (f16.f73051m != 4) {
            Cj(j3, R.string.dav);
        }
        cw.e.d(this.G, 1038);
        cw.e.d(this.G, 1050);
        cw.e.d(this.G, 1049);
        if (!f16.G) {
            if (f16.I0) {
                DataReport.T(null, "CliOper", "", "", "Two_call", "Two_launch_HF_result", 0, 0, "0", "", "", "");
            } else {
                DataReport.T(null, "CliOper", "", "", "Two_call", "Two_launch_HF_result", 0, 0, "1", "", "", "");
            }
            if (f16.K) {
                DataReport.T(null, "CliOper", "", "", "Two_call", "Two_launch_mute_result", 0, 0, "0", "", "", "");
            } else {
                DataReport.T(null, "CliOper", "", "", "Two_call", "Two_launch_mute_result", 0, 0, "1", "", "", "");
            }
            DataReport.u();
        }
        if (f16.f73035i == 2) {
            dl(j3, true);
        }
        vl(j3, true);
        String str = f16.f73091w;
        AVChatTimePart aVChatTimePart = this.f75615d0;
        if (aVChatTimePart != null) {
            aVChatTimePart.L9(j3);
        }
        as asVar = this.L;
        if (asVar != null) {
            asVar.n(f16.f73035i == 1);
        }
        this.G.A0(f16.f73067q, str);
        this.G.k0(new Object[]{102});
        if (f16.S && (aVToolBarPart = this.Y) != null) {
            aVToolBarPart.onPause();
        }
        if (f16.f73035i == 2) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "onConnected, CheckRemoteCameraRunnable");
            this.G.M().removeCallbacks(this.R0);
            this.G.M().postDelayed(this.R0, 5000L);
        }
        if (f16.S && !f16.O) {
            Vk("onConnected", 1);
        }
        int i16 = f16.f73035i;
        if ((i16 == 1 || i16 == 2) && (qavPanel = this.J) != null) {
            qavPanel.w(false);
        }
        if (this.B0 != null) {
            if (VipFunCallUtil.ifUseKuikly()) {
                this.B0.onConnected();
            } else {
                IAVVideoFunCallBizApi iAVVideoFunCallBizApi = this.A0;
                if (iAVVideoFunCallBizApi != null) {
                    iAVVideoFunCallBizApi.onConnected();
                }
            }
        }
        if (f16.f73098x2) {
            el();
            this.D0.onConnect();
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void bj(boolean z16, boolean z17) {
        VideoAppInterface videoAppInterface;
        long d16 = e.d();
        QLog.w(NTBaseVideoFragment.f75610s0, 1, "onPhoneCalling, isSelf[" + z16 + "], seq[" + d16 + "]");
        if (r.h0() == null) {
            return;
        }
        if (z16) {
            if (z17) {
                cw.e.n(this.G, 1019);
                return;
            }
            cw.e.d(this.G, 1019);
            WeakReference<Context> weakReference = this.F;
            if (weakReference == null || weakReference.get() == null || (videoAppInterface = this.G) == null) {
                return;
            }
            cw.e.n(videoAppInterface, 1018);
            DataReport.T(null, "CliOper", "", "", "0x80060EE", "0x80060EE", 0, 0, "", "", "", "");
            return;
        }
        String str = n.e().f().f73091w;
        if (z17) {
            if (!n.e().f().K) {
                r.h0().I2(true, str);
            }
            IMediaPlayerApi iMediaPlayerApi = (IMediaPlayerApi) QRoute.api(IMediaPlayerApi.class);
            WeakReference<Context> weakReference2 = this.F;
            iMediaPlayerApi.init(weakReference2 == null ? null : weakReference2.get(), null);
            if (q.b("qav_peer_phone_calling.mp3")) {
                iMediaPlayerApi.playRing(d16, 2, 0, null, q.a() + "qav_peer_phone_calling.mp3", false, 1, false, true, 0);
            } else {
                iMediaPlayerApi.playRing(d16, 0, R.raw.f169419r, null, null, false, 1, false, true, 0);
                q.c(BaseApplicationImpl.getApplication());
            }
            if (n.e().f().M0) {
                DataReport.T(null, "CliOper", "", "", "0x80049AA", "0x80049AA", 0, 0, "", "", "", "");
                return;
            } else {
                DataReport.T(null, "CliOper", "", "", "0x80049BA", "0x80049BA", 0, 0, "", "", "", "");
                return;
            }
        }
        if (n.e().f().K) {
            return;
        }
        r.h0().I2(false, str);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Fi(long j3, int i3) {
        if (QLog.isColorLevel()) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "onClose, type[" + i3 + "], seq[" + j3 + "]");
        }
        AVChildGuideUIPart aVChildGuideUIPart = this.F0;
        if (aVChildGuideUIPart != null) {
            aVChildGuideUIPart.E9();
        }
        if (this.C0 != null) {
            this.C0.onVideoClose(r.h0() == null ? null : n.e().f(), i3);
        }
        il();
        super.Fi(j3, i3);
        SessionInfo f16 = n.e().f();
        int i16 = f16.f73067q;
        boolean z16 = f16.f73076s0 == 2;
        boolean z17 = i3 == 12;
        if (((f16.w() && (i3 == 3 || ((z17 && !z16) || i3 == 42))) || (f16.x() && z17 && z16)) && ((i16 == 0 || i16 == 1006 || i16 == 25 || i16 == 24 || i16 == 22 || i16 == 26 || i16 == 1044) && this.J != null)) {
            DataReport.C();
            this.J.Y0(new b(j3));
            String str = n.e().f().B;
            if (QLog.isColorLevel()) {
                QLog.w(NTBaseVideoFragment.f75610s0, 1, "onClose phoneNumber is " + str);
            }
            if (!TextUtils.isEmpty(str) && i3 != 3) {
                DataReport.T(null, "CliOper", "", "", "0X800A8D6", "0X800A8D6", 0, 0, "", "", "", "");
                this.J.setViewEnable(m.l.f76062h, true);
            } else {
                this.J.setViewVisibility(m.l.f76062h, 8);
                Button button = (Button) this.J.h1(m.l.f76063i);
                if (button != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) button.getLayoutParams();
                    layoutParams.rightMargin = 0;
                    layoutParams.removeRule(11);
                    layoutParams.addRule(14);
                    button.setLayoutParams(layoutParams);
                }
            }
            if (i3 == 3) {
                this.J.setViewEnable(m.l.B, false);
            }
            this.J.setViewEnable(m.l.f76063i, true);
        }
        this.f75653v0 = true;
        if (f16.z() && f16.f73035i == 2 && !f16.N) {
            DataReport.a0();
        }
        f16.d0("onClose", false);
        f16.q0("onClose", 0);
        if (i3 == 24) {
            this.M = true;
            Cj(j3, R.string.f171257dj1);
        }
        if (i3 == 42) {
            this.G.M().removeCallbacks(this.O0);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Mi(String str, String str2) {
        if (r.h0() == null) {
            return;
        }
        SessionInfo f16 = n.e().f();
        long d16 = e.d();
        QLog.w(NTBaseVideoFragment.f75610s0, 1, "onInviteReached, peerUin[" + str + "], showMsg[" + str2 + "], remotePhoneState[" + f16.f73008c0 + "], remoteTerminal[" + f16.Q + "], phoneOnLine[" + f16.f73000a0 + "], pcOnLine[" + f16.Z + "], subState[" + f16.f73076s0 + "], isPeerNetworkWell[" + f16.V + "], seq[" + d16 + "]");
        if (!f16.K() || f16.f73081t1 || f16.f73067q == 1011 || !f16.f73091w.contains(str)) {
            return;
        }
        int i3 = f16.f73008c0;
        if (i3 >= 0) {
            if (TextUtils.isEmpty(str2)) {
                Cj(d16, R.string.d95);
            } else {
                Dj(d16, str2);
            }
        }
        if (f16.f73076s0 == 2) {
            r.h0().x1(f16.f73091w, 8, 0L, null, 0, null);
            if (!TextUtils.isEmpty(f16.f73080t0)) {
                cw.e.p(this.G, 3010, f16.f73080t0);
            }
            DataReport.T(null, "CliOper", "", "", "0X800515D", "0X800515D", 0, 0, "", "", "", "");
        }
        if (i3 > 0 && i3 != 3) {
            DataReport.R();
        } else if (i3 == 0 && f16.V && f16.Q != 2 && f16.f73035i == 1) {
            cw.e.n(this.G, 1038);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void mi(long j3, View view) {
        String str;
        if (Zh()) {
            this.F0.onClick(view);
            return;
        }
        if (r.h0() == null) {
            QLog.d(NTBaseVideoFragment.f75610s0, 1, "onClick VideoController.getInstance() == null");
            return;
        }
        if (this.J == null) {
            QLog.d(NTBaseVideoFragment.f75610s0, 1, "onClick mQavPanel == null");
            return;
        }
        if (n.e().f().f73048l0) {
            QLog.d(NTBaseVideoFragment.f75610s0, 1, "onClick isChildLock");
            return;
        }
        WeakReference<Context> weakReference = this.F;
        if (weakReference == null || !(weakReference.get() instanceof AVActivity)) {
            return;
        }
        String str2 = n.e().f().f73091w;
        super.mi(j3, view);
        int id5 = view.getId();
        if (id5 == m.e.f76019f) {
            xi(j3);
            return;
        }
        if (id5 == m.l.G) {
            DataReport.T(null, "dc00898", "", "", "0X800BCE2", "0X800BCE2", 0, 0, "", "", "", "");
            xi(j3);
            return;
        }
        if (id5 == m.l.F) {
            QLog.d(NTBaseVideoFragment.f75610s0, 1, "onClick qav_titlebar_quit_double_screen ");
            MagicDataReport.e(r.h0().J(n.e().f().f73091w) + "");
            this.I.update(null, new Object[]{134});
            return;
        }
        if (id5 == m.l.f76080z) {
            al();
            return;
        }
        if (id5 == m.l.f76062h) {
            DataReport.o(view.getId(), n.e().f().f73035i);
            ql(str2);
            return;
        }
        if (id5 == m.l.f76063i) {
            QLog.d(NTBaseVideoFragment.f75610s0, 1, "onClick QavPanel.ViewID.LEAVE_MSG");
            if (r.h0() != null) {
                TraeHelper.I().k0(j3);
                r.h0().y2(n.e().f().f73067q, n.e().f().f73091w, n.e().f().f73099y, n.e().f().f73103z, true);
                DataReport.D();
                r.h0().q(str2, n.e().f().A0);
                return;
            }
            return;
        }
        if (id5 == m.e.f76015b) {
            QLog.d(NTBaseVideoFragment.f75610s0, 1, "onClick QavPanel.ViewID.Voice");
            Ei(j3, view);
            SessionInfo f16 = n.e().f();
            if (f16 == null || f16.f73067q != 1044) {
                return;
            }
            DataReport.T(null, "dc00898", "", "", "0X800AD94", "0X800AD94", 0, 0, "", "", "", "");
            return;
        }
        if (id5 != m.e.f76018e && id5 != m.l.C) {
            if (id5 == m.l.f76072r) {
                return;
            }
            if (id5 == m.e.f76017d) {
                com.tencent.av.ui.part.base.panel.g gVar = this.f75625n0;
                if (gVar != null) {
                    gVar.C9(j3);
                    return;
                }
                return;
            }
            if (id5 == m.e.f76020g) {
                rl(j3, view);
                SessionInfo f17 = n.e().f();
                if (f17 == null || f17.f73067q != 1044) {
                    return;
                }
                DataReport.T(null, "dc00898", "", "", "0X800AD95", "0X800AD95", 0, 0, "", "", "", "");
                return;
            }
            if (id5 == m.l.S) {
                yi(j3, view);
                return;
            }
            if (id5 == m.e.f76024k) {
                com.tencent.av.screenshare.c.a("0X800AD8D");
                AVScreenSharePart aVScreenSharePart = this.f75623l0;
                if (aVScreenSharePart != null) {
                    aVScreenSharePart.N9(j3, view);
                    return;
                }
                return;
            }
            if (id5 == m.e.f76027n) {
                nl(j3);
                return;
            }
            if (id5 == m.e.f76025l) {
                Di(j3, view);
                return;
            }
            if (id5 == m.e.f76026m) {
                sl(j3, view);
                return;
            }
            if (id5 == m.e.f76028o) {
                ni(j3, view);
                return;
            }
            if (id5 == m.g.f76034b) {
                Bi(j3, view);
                return;
            }
            if (id5 == m.l.H) {
                ol();
                SessionInfo f18 = n.e().f();
                if (f18 != null) {
                    if (f18.P()) {
                        str = "2";
                    } else {
                        str = "1";
                    }
                    DataReport.T(null, "dc00898", "", "", "0X800C435", "0X800C435", 0, 0, str, "", "", "");
                    return;
                }
                return;
            }
            if (id5 == m.l.J) {
                tl();
                DataReport.T(null, "dc00898", "", "", "0X800C43A", "0X800C43A", 0, 0, "", "", "", "");
                return;
            } else {
                if (id5 == m.l.f76075u) {
                    pl();
                    return;
                }
                return;
            }
        }
        QLog.d(NTBaseVideoFragment.f75610s0, 1, "onClick QavPanel.ViewID.Effect");
        qi(j3, view);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 != 24 && i3 != 25) {
            return n.e().f().f73048l0;
        }
        d dVar = this.f75622k0;
        if (dVar == null) {
            return false;
        }
        dVar.na();
        return false;
    }

    public NTDoubleVideoFragment(VideoAppInterface videoAppInterface, AVActivity aVActivity, ControlUIObserver controlUIObserver) {
        super(videoAppInterface, aVActivity, controlUIObserver);
        this.f75652u0 = false;
        this.f75653v0 = false;
        this.f75654w0 = false;
        this.f75655x0 = false;
        this.f75656y0 = null;
        this.N0 = new Runnable() { // from class: com.tencent.av.ui.fragment.NTDoubleVideoFragment.1
            @Override // java.lang.Runnable
            public void run() {
                if (NTDoubleVideoFragment.this.isDestroyed()) {
                    return;
                }
                long d16 = e.d();
                if (!r.h0().e() && n.e().f().f73039j == 1 && n.e().f().N) {
                    if (QLog.isColorLevel()) {
                        QLog.w(NTBaseVideoFragment.f75610s0, 1, "FixTerSwitchStatus ,switch to pc ,local close camera, seq[" + d16 + "]");
                    }
                    NTDoubleVideoFragment.this.ji(d16);
                    NTDoubleVideoFragment.this.G.k0(new Object[]{106, Long.valueOf(d16)});
                    cw.e.n(NTDoubleVideoFragment.this.G, 1021);
                }
                NTDoubleVideoFragment.this.lk(d16, 33554431);
                if (n.e().f().K) {
                    r.h0().I2(true, n.e().f().f73091w);
                }
            }
        };
        this.O0 = new Runnable() { // from class: com.tencent.av.ui.fragment.NTDoubleVideoFragment.2
            @Override // java.lang.Runnable
            public void run() {
                if (r.h0() == null || n.e().f().z()) {
                    return;
                }
                cw.e.n(NTDoubleVideoFragment.this.G, 1049);
                DataReport.T(null, "CliOper", "", "", "0X8009D02", "0X8009D02", 0, 0, "", "", "", "");
            }
        };
        this.P0 = -1L;
        this.Q0 = 0;
        this.R0 = new Runnable() { // from class: com.tencent.av.ui.fragment.NTDoubleVideoFragment.3
            @Override // java.lang.Runnable
            public void run() {
                SessionInfo f16 = n.e().f();
                QLog.w(NTBaseVideoFragment.f75610s0, 1, "CheckRemoteCameraRunnable, 5s has past, \u5bf9\u65b9\u89c6\u9891\u6570\u636e\u6ca1\u6765, mRecvVideoData[" + NTDoubleVideoFragment.this.f75652u0 + "], SessionType[" + f16.f73035i + "], shutCameraAnswer[" + f16.S + "], cameraPermission[" + f16.T + "]");
                if (NTDoubleVideoFragment.this.f75652u0 || f16.f73035i != 2) {
                    return;
                }
                r.h0().J1(f16.f73091w);
                if (f16.S || !f16.T) {
                    f16.p0(-1011L, "CheckRemoteCameraRunnable", 1);
                    NTDoubleVideoFragment.this.Vk("CheckRemoteCameraRunnable", 1);
                }
                NTDoubleVideoFragment.this.yj(-1011L);
            }
        };
        this.S0 = new a();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f75663d;

        b(long j3) {
            this.f75663d = j3;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "showNoAnswerAnimation, onAnimationEnd, seq[" + this.f75663d + "]");
            NTDoubleVideoFragment nTDoubleVideoFragment = NTDoubleVideoFragment.this;
            QavPanel qavPanel = nTDoubleVideoFragment.J;
            if (qavPanel != null) {
                nTDoubleVideoFragment.f75654w0 = true;
                qavPanel.Z0();
            }
            AVActivity wh5 = NTDoubleVideoFragment.this.wh();
            if (wh5 != null) {
                wh5.R2(this.f75663d);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "showNoAnswerAnimation, onAnimationStart, seq[" + this.f75663d + "]");
            AVActivity wh5 = NTDoubleVideoFragment.this.wh();
            if (wh5 != null) {
                wh5.R2(this.f75663d);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class c implements s.e {
        c() {
        }

        @Override // com.tencent.av.ui.s.e
        public void a() {
            NTDoubleVideoFragment.this.f75653v0 = true;
        }

        @Override // com.tencent.av.ui.s.e
        public void b() {
        }
    }
}
