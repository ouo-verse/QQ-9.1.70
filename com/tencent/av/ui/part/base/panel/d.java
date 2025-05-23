package com.tencent.av.ui.part.base.panel;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.m;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.af;
import com.tencent.av.utils.q;
import com.tencent.avcore.jni.audiodevice.TraeConstants;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.api.IMediaPlayerApi;
import mw.j;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d extends e {
    private boolean C;
    String D;
    IMediaPlayerApi E;

    /* renamed from: h, reason: collision with root package name */
    TraeHelper f76365h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f76366i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f76367m;

    public d(QavPanel qavPanel) {
        this(qavPanel, false);
    }

    private void D9() {
        int i3;
        QavPanel qavPanel = this.f76370f;
        if (qavPanel == null) {
            return;
        }
        if (!qavPanel.I() || this.f76370f.u()) {
            n.e().f().d0("doMute", !n.e().f().K);
            int i16 = n.e().f().J;
            if (n.e().f().K) {
                n.e().f().q0("doMute", 1);
                i3 = 1;
            } else {
                n.e().f().q0("doMute", 0);
                if (AVUtil.l()) {
                    r.h0().c3();
                }
                i3 = 0;
            }
            this.f76370f.H("DoubleVideoCtrl.doMute", i16, i3, false);
            G9(true);
            DataReport.E();
        }
    }

    private void G9(boolean z16) {
        boolean z17 = n.e().f().K;
        ca(z17, z16);
        if (z16) {
            r.h0().I2(z17, null);
        }
        N9(!n.e().f().K);
    }

    private void L9() {
        SessionInfo f16 = n.e().f();
        this.f76365h.L();
        if (f16.K()) {
            if (f16.f73035i == 1) {
                this.D = TraeConstants.VOICE_CALL_CONFIG;
            } else {
                this.D = TraeConstants.VIDEO_CALL_CONFIG;
            }
            this.f76365h.i0(this.D);
        }
    }

    void E9(long j3) {
        if (this.f76370f.I() && !this.f76370f.u()) {
            QLog.d(this.f76368d, 1, "intercept doMute operation");
            return;
        }
        boolean X0 = r.h0().X0();
        SessionInfo f16 = n.e().f();
        long j16 = f16.P0;
        if (QLog.isColorLevel()) {
            QLog.w(this.f76368d, 1, "doMute, relationId[" + j16 + "], mute[" + X0 + "], seq[" + j3 + "]");
        }
        VideoAppInterface b16 = nw.b.b();
        if (X0) {
            if (C9(true)) {
                return;
            }
            if (f16.f73071r) {
                if (QLog.isColorLevel()) {
                    QLog.w(this.f76368d, 1, "PhoneCalling-status not support open MIC");
                    return;
                }
                return;
            }
            if (f16.S0 == 2) {
                DataReport.M(true, 1);
            } else {
                DataReport.M(true, 10);
            }
            N9(true);
            int e06 = r.h0().e0();
            r.h0().z("doMute.1", j16, true, true, -1);
            this.f76370f.H("doMute.1", e06, r.h0().e0(), false);
            qa(m.l.f76060f);
            if (b16 != null) {
                b16.k0(new Object[]{108});
            }
            if (AVUtil.l()) {
                r.h0().c3();
                return;
            }
            return;
        }
        if (f16.S0 == 2) {
            DataReport.M(false, 1);
        } else {
            DataReport.M(false, 10);
        }
        N9(false);
        int e07 = r.h0().e0();
        r.h0().z("doMute.2", j16, false, true, -1);
        this.f76370f.H("doMute.2", e07, r.h0().e0(), false);
        ra(m.l.f76060f);
        if (b16 != null) {
            b16.k0(new Object[]{109});
        }
    }

    public void F9(boolean z16) {
        if (r.h0() == null) {
            QLog.e(this.f76368d, 1, "doMuteAction video controller is null");
        } else {
            G9(z16);
        }
    }

    public void H9(int i3, int i16) {
        boolean X0 = r.h0().X0();
        QavPanel qavPanel = this.f76370f;
        if (qavPanel != null) {
            qavPanel.H("doRefreshGaudioMuteUIStatus", i3, i16, false);
        }
        VideoAppInterface b16 = nw.b.b();
        if (X0) {
            qa(m.l.f76060f);
            if (b16 != null) {
                b16.k0(new Object[]{108});
                return;
            }
            return;
        }
        ra(m.l.f76060f);
        if (b16 != null) {
            b16.k0(new Object[]{109});
        }
    }

    public void I9(int i3, int i16) {
        boolean X0 = r.h0().X0();
        VideoAppInterface b16 = nw.b.b();
        QavPanel qavPanel = this.f76370f;
        if (qavPanel != null) {
            qavPanel.H("doRefreshMuteUIStatus", i3, i16, false);
        }
        if (X0) {
            ra(m.l.f76060f);
            ra(m.l.O);
            if (b16 != null) {
                b16.k0(new Object[]{109});
                return;
            }
            return;
        }
        qa(m.l.f76060f);
        qa(m.l.O);
        if (b16 != null) {
            b16.k0(new Object[]{108});
        }
    }

    public void J9(long j3) {
        if (this.f76367m) {
            return;
        }
        int i3 = j3 == 0 ? 2968 : j3 == 100 ? 7187 : (int) (((((float) j3) * 4218.75f) / 100.0f) + 2968.75f);
        QavPanel qavPanel = this.f76370f;
        if (qavPanel != null) {
            qavPanel.setAudioVolumeValue(i3);
        }
    }

    public void K9(int i3, boolean z16) {
        QavPanel qavPanel = this.f76370f;
        if (qavPanel == null) {
            return;
        }
        int i16 = m.l.P;
        if (i3 != i16 && i3 != m.l.f76059e) {
            int i17 = m.l.O;
            if (i3 != i17 && i3 != m.l.f76060f) {
                int i18 = m.l.B;
                if (i3 == i18) {
                    qavPanel.setViewEnable(i18, z16);
                    return;
                }
                return;
            }
            qavPanel.setViewEnable(m.l.f76060f, z16);
            this.f76370f.setViewEnable(i17, z16);
            this.f76366i = z16;
            this.f76370f.e1(z16, this.f76367m);
            return;
        }
        qavPanel.setViewEnable(m.l.f76059e, z16);
        this.f76370f.setViewEnable(i16, z16);
    }

    public void M9(long j3, boolean z16) {
        TraeHelper traeHelper = this.f76365h;
        if (traeHelper == null) {
            return;
        }
        traeHelper.L();
        if (z16) {
            String str = n.e().f().F0;
            this.f76365h.h0(j3, this.D, str);
            if (QLog.isColorLevel()) {
                QLog.w(this.f76368d, 1, "onCreate, switchToGaudio, mAudioSesstionType[" + this.D + "], deviceName[" + str + "], seq[" + j3 + "]");
            }
            this.f76365h.E(j3, str);
            return;
        }
        this.f76365h.i0(this.D);
    }

    public void P9(boolean z16) {
        QLog.d(this.f76368d, 1, "onClick QavPanel.ViewID.HAND_FREE");
        if (z16) {
            String[] strArr = n.e().f().H0;
            if (n.e().f().I0 && strArr != null) {
                DataReport.J(true, 10);
            } else if (strArr == null) {
                if (QLog.isColorLevel()) {
                    QLog.e(this.f76368d, 2, "DeviceList is null");
                }
            } else {
                DataReport.J(false, 10);
            }
        }
        if (n.e().f().f73071r && !n.e().f().I0) {
            QLog.d(this.f76368d, 1, "in mIsPhoneCalling status, could not open Speaker");
        } else {
            this.f76365h.T(TraeHelper.D);
        }
    }

    public void Q9(boolean z16) {
        QLog.d(this.f76368d, 1, "onClick QavPanel.ViewID.HAND_FREE canClick:=" + z16);
        if (z16) {
            DataReport.x(!n.e().f().I0);
            TraeHelper traeHelper = this.f76365h;
            if (traeHelper != null) {
                traeHelper.T(TraeHelper.D);
            }
        }
    }

    public void S9(long j3, View view, boolean z16) {
        if (r.h0() == null) {
            QLog.e(this.f76368d, 1, "onClickMute video controller is null");
            return;
        }
        QLog.w(this.f76368d, 1, "onClick_Mute, micPermission[" + n.e().f().U + "], localMute[" + n.e().f().K + "], seq[" + j3 + "], canClick[" + z16 + "]");
        mw.h hVar = (mw.h) RFWIocAbilityProvider.g().getIocInterface(mw.h.class, getPartRootView(), null);
        if (hVar != null && hVar.f1(j3, QQPermissionConstants.Permission.RECORD_AUDIO, view, null) && z16) {
            D9();
        }
        ((j) RFWIocAbilityProvider.g().getIocInterface(j.class, getPartRootView(), null)).resetToolBarTimer(j3);
    }

    public void T9() {
        int i3;
        if (r.h0() == null) {
            QLog.e(this.f76368d, 1, "onClickMute video controller is null");
            return;
        }
        int i16 = n.e().f().J;
        if (n.e().f().K) {
            n.e().f().q0("onDavSpeakerModeChange", 1);
            i3 = 1;
        } else {
            n.e().f().q0("onDavSpeakerModeChange", 0);
            i3 = 0;
        }
        QavPanel qavPanel = this.f76370f;
        if (qavPanel != null) {
            qavPanel.H("DoubleVideoCtrl.onDavSpeakerModeChange", i16, i3, false);
        }
        G9(true);
    }

    public void U9(long j3, int i3) {
        VideoAppInterface b16 = nw.b.b();
        if (j3 == b16.getLongAccountUin() || i3 != 0 || j3 == 0) {
            la();
        }
        if (r.h0().Z0() || j3 == Long.parseLong(b16.getCurrentAccountUin()) || j3 == 0) {
            return;
        }
        Resources resources = getContext().getResources();
        StringBuilder sb5 = new StringBuilder();
        SessionInfo f16 = n.e().f();
        if (i3 == 1) {
            String U = r.h0().U(String.valueOf(j3), String.valueOf(f16.P0), f16.S0);
            if (U == null || U.length() == 0) {
                U = String.valueOf(j3);
            }
            float dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.f158932sr);
            sb5.append(resources.getString(R.string.vud));
            com.tencent.av.utils.n.a(sb5, U, ((mw.f) RFWIocAbilityProvider.g().getIocInterface(mw.f.class, getPartRootView(), null)).j(), dimensionPixelSize);
            sb5.append(resources.getString(R.string.vuc));
        } else if (i3 == 0) {
            sb5.append(resources.getString(R.string.dcc));
        }
        cw.e.p(b16, 1033, sb5.toString());
        ha(i3 == 1);
    }

    public void V9(long j3, boolean z16, boolean z17) {
        int i3;
        VideoAppInterface b16 = nw.b.b();
        long longValue = Long.valueOf(b16.getCurrentAccountUin()).longValue();
        if ((j3 != longValue && z16) || j3 == 0) {
            la();
        }
        if (j3 == longValue || j3 == 0) {
            return;
        }
        Resources resources = getContext().getResources();
        StringBuilder sb5 = new StringBuilder();
        SessionInfo f16 = n.e().f();
        mw.f fVar = (mw.f) RFWIocAbilityProvider.g().getIocInterface(mw.f.class, getPartRootView(), null);
        if (z16) {
            if (f16 != null && f16.X0 != 1) {
                String U = r.h0().U(String.valueOf(j3), String.valueOf(f16.P0), f16.S0);
                if (U == null || U.length() == 0) {
                    U = String.valueOf(j3);
                }
                String string = resources.getString(R.string.dc_);
                com.tencent.av.utils.n.a(sb5, U, fVar.j(), Math.min((resources.getDisplayMetrics().widthPixels - com.tencent.av.utils.n.c(string, fVar.j())) - (resources.getDimensionPixelSize(R.dimen.a_3) * 2), resources.getDimensionPixelSize(R.dimen.f158932sr)));
                sb5.append(string);
            }
        } else if (f16 != null && f16.X0 != 0) {
            sb5.append(resources.getString(R.string.dc9));
        }
        cw.e.p(b16, 1033, sb5.toString());
        if (f16 != null && (((i3 = f16.X0) != 1 || !z16) && (i3 != 0 || z16))) {
            ha(z16);
        }
        if (f16 == null || z17) {
            return;
        }
        f16.e0("setRoomMicOff", z16 ? 1 : 0);
    }

    public void X9(long j3, int i3, int i16) {
        if (C9(r.h0().X0())) {
            return;
        }
        H9(i3, i16);
    }

    public void Y9(long j3, View view) {
        QLog.w(this.f76368d, 1, "onClick_Mute, micPermission[" + n.e().f().U + "], seq[" + j3 + "]");
        mw.h hVar = (mw.h) RFWIocAbilityProvider.g().getIocInterface(mw.h.class, getPartRootView(), null);
        if (hVar != null && hVar.f1(j3, QQPermissionConstants.Permission.RECORD_AUDIO, view, null)) {
            E9(j3);
        }
        ((j) RFWIocAbilityProvider.g().getIocInterface(j.class, getPartRootView(), null)).resetToolBarTimer(j3);
    }

    public void Z9() {
        if (n.e().f().f73071r && n.e().f().I0) {
            this.f76365h.T(TraeHelper.C);
        }
    }

    public void aa(boolean z16, boolean z17) {
        VideoAppInterface b16 = nw.b.b();
        if (z16) {
            qa(m.l.f76060f);
            if (b16 == null || !z17) {
                return;
            }
            if (this.f76370f.L() != 3) {
                N9(true);
            } else {
                cw.e.g(VideoAppInterface.N(), 1071, 3000L);
            }
            b16.k0(new Object[]{108});
            return;
        }
        int i3 = m.l.f76060f;
        ra(i3);
        cw.e.b(VideoAppInterface.N(), false);
        QavPanel qavPanel = this.f76370f;
        if (qavPanel != null) {
            qavPanel.Q0(i3, getContext().getString(R.string.f1376907j));
        }
        if (b16 == null || !z17) {
            return;
        }
        N9(false);
        b16.k0(new Object[]{109});
    }

    public void ba(int i3) {
        QavPanel qavPanel;
        QavPanel qavPanel2;
        SessionInfo f16 = n.e().f();
        f16.d0("onTerSwitchSyncStatus", i3 == 0);
        f16.q0("onTerSwitchSyncStatus", i3 == 0 ? 1 : 0);
        String str = f16.f73091w;
        Context context = getContext();
        VideoAppInterface b16 = nw.b.b();
        if (f16.K) {
            int i16 = m.l.f76060f;
            ra(i16);
            int i17 = m.l.O;
            ra(i17);
            b16.k0(new Object[]{109});
            r.h0().I2(true, str);
            if (context == null || (qavPanel2 = this.f76370f) == null) {
                return;
            }
            qavPanel2.Q0(i16, context.getResources().getString(R.string.f170484sl));
            this.f76370f.Q0(i17, context.getResources().getString(R.string.f170484sl));
            return;
        }
        int i18 = m.l.f76060f;
        qa(i18);
        int i19 = m.l.O;
        qa(i19);
        b16.k0(new Object[]{108});
        r.h0().I2(false, str);
        if (context == null || (qavPanel = this.f76370f) == null) {
            return;
        }
        qavPanel.Q0(i18, context.getResources().getString(R.string.f170477sh));
        this.f76370f.Q0(i19, context.getResources().getString(R.string.f170477sh));
    }

    public void ca(boolean z16, boolean z17) {
        QavPanel qavPanel;
        QavPanel qavPanel2;
        Context context = getContext();
        VideoAppInterface b16 = nw.b.b();
        if (z16) {
            int i3 = m.l.f76060f;
            ra(i3);
            int i16 = m.l.O;
            ra(i16);
            if (z17) {
                b16.k0(new Object[]{109});
            }
            if (context == null || (qavPanel2 = this.f76370f) == null) {
                return;
            }
            qavPanel2.Q0(i3, context.getResources().getString(R.string.f170484sl));
            this.f76370f.Q0(i16, context.getResources().getString(R.string.f170484sl));
            return;
        }
        int i17 = m.l.f76060f;
        qa(i17);
        int i18 = m.l.O;
        qa(i18);
        if (z17) {
            b16.k0(new Object[]{108});
        }
        if (context == null || (qavPanel = this.f76370f) == null) {
            return;
        }
        qavPanel.Q0(i17, context.getResources().getString(R.string.f170477sh));
        this.f76370f.Q0(i18, context.getResources().getString(R.string.f170477sh));
    }

    public void da() {
        TraeHelper traeHelper = this.f76365h;
        if (traeHelper != null) {
            this.f76370f.M0(traeHelper);
            this.f76365h.a0();
        }
    }

    public void ea() {
        TraeHelper traeHelper = this.f76365h;
        if (traeHelper != null) {
            this.f76370f.N0(traeHelper);
            this.f76365h.a0();
        }
    }

    public void ga() {
        QavPanel qavPanel = this.f76370f;
        if (qavPanel != null) {
            qavPanel.setViewEnable(m.l.f76060f, false);
            this.f76370f.setViewEnable(m.l.f76059e, false);
            this.f76370f.setViewEnable(m.l.O, false);
            this.f76370f.setViewEnable(m.l.P, false);
        }
    }

    void ha(boolean z16) {
        long d16 = com.tencent.av.utils.e.d();
        IMediaPlayerApi iMediaPlayerApi = this.E;
        if (iMediaPlayerApi == null) {
            IMediaPlayerApi iMediaPlayerApi2 = (IMediaPlayerApi) QRoute.api(IMediaPlayerApi.class);
            this.E = iMediaPlayerApi2;
            iMediaPlayerApi2.init(getContext(), null);
        } else {
            iMediaPlayerApi.stopRing(d16);
        }
        if (z16) {
            if (q.b("qav_gaudio_muted.mp3")) {
                this.E.playRing(d16, 2, 0, null, q.a() + "qav_gaudio_muted.mp3", false, 1, false, true, 0);
                return;
            }
            return;
        }
        if (q.b("qav_gaudio_cancel_muted.mp3")) {
            this.E.playRing(d16, 2, 0, null, q.a() + "qav_gaudio_cancel_muted.mp3", false, 1, false, true, 0);
        }
    }

    public void ia() {
        TraeHelper traeHelper = this.f76365h;
        if (traeHelper != null) {
            traeHelper.T(TraeHelper.D);
        }
    }

    public void ja() {
        if (r.h0().X0()) {
            ra(m.l.f76060f);
            ra(m.l.O);
        } else {
            qa(m.l.f76060f);
            qa(m.l.O);
        }
    }

    void la() {
        QavPanel qavPanel = this.f76370f;
        int i3 = m.l.f76060f;
        if (qavPanel.x(i3) || r.h0() == null) {
            return;
        }
        this.f76370f.setViewEnable(i3, true);
        if (r.h0().X0()) {
            ra(i3);
        } else {
            qa(i3);
        }
        this.f76370f.D0(r.h0().X0());
    }

    public void ma() {
        this.f76365h.L();
    }

    public void na() {
        TraeHelper traeHelper = this.f76365h;
        if (traeHelper != null) {
            traeHelper.a0();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        QavPanel qavPanel;
        QavPanel qavPanel2;
        QavPanel qavPanel3;
        QavPanel qavPanel4;
        int i3;
        QavPanel qavPanel5;
        super.onInitView(view);
        TraeHelper I = TraeHelper.I();
        this.f76365h = I;
        if (I == null) {
            this.f76365h = TraeHelper.G(getContext());
        }
        SessionInfo f16 = n.e().f();
        if (this.C) {
            M9(com.tencent.av.utils.e.d(), f16.V0);
        } else if (f16.E()) {
            L9();
        } else {
            M9(0L, n.e().f().G());
        }
        if (!f16.U && (qavPanel5 = this.f76370f) != null) {
            int i16 = m.l.f76060f;
            qavPanel5.setViewEnable(i16, false);
            this.f76370f.S0(i16, false);
            QavPanel qavPanel6 = this.f76370f;
            int i17 = m.l.O;
            qavPanel6.setViewEnable(i17, false);
            this.f76370f.S0(i17, false);
        }
        QavPanel qavPanel7 = this.f76370f;
        if (qavPanel7 != null) {
            if (this.C && ((i3 = f16.f73046k2) == 2 || i3 == 1)) {
                qavPanel7.N0(this.f76365h);
            } else {
                qavPanel7.M0(this.f76365h);
            }
        }
        TraeHelper traeHelper = this.f76365h;
        if (traeHelper != null) {
            traeHelper.a0();
        }
        Context context = getContext();
        if (f16.K) {
            int i18 = m.l.f76060f;
            ra(i18);
            if (context != null && (qavPanel4 = this.f76370f) != null) {
                qavPanel4.Q0(i18, context.getResources().getString(R.string.f170484sl));
            }
            int i19 = m.l.O;
            ra(i19);
            if (context != null && (qavPanel3 = this.f76370f) != null) {
                qavPanel3.Q0(i19, context.getResources().getString(R.string.f170484sl));
            }
        } else {
            int i26 = m.l.f76060f;
            qa(i26);
            if (context != null && (qavPanel2 = this.f76370f) != null) {
                qavPanel2.Q0(i26, context.getResources().getString(R.string.f170477sh));
            }
            int i27 = m.l.O;
            qa(i27);
            if (context != null && (qavPanel = this.f76370f) != null) {
                qavPanel.Q0(i27, context.getResources().getString(R.string.f170477sh));
            }
        }
        if (f16.G() && f16.K) {
            int e06 = r.h0().e0();
            r.h0().z("initUI", f16.P0, false, true, -1);
            QavPanel qavPanel8 = this.f76370f;
            if (qavPanel8 != null) {
                qavPanel8.H("initUI", e06, r.h0().e0(), false);
            }
            ra(m.l.f76060f);
        }
    }

    @Override // com.tencent.av.ui.part.base.panel.e, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        this.f76365h = null;
        this.D = null;
        IMediaPlayerApi iMediaPlayerApi = this.E;
        if (iMediaPlayerApi != null) {
            iMediaPlayerApi.stopRing(com.tencent.av.utils.e.d());
            this.E = null;
        }
    }

    public void pa(boolean z16, boolean z17) {
        TraeHelper traeHelper = this.f76365h;
        if (traeHelper != null) {
            traeHelper.d0(z16);
            if (z17) {
                this.f76365h.a0();
            }
        }
    }

    public void qa(int i3) {
        QavPanel qavPanel;
        if ((i3 == m.l.O || i3 == m.l.f76060f) && (qavPanel = this.f76370f) != null) {
            qavPanel.Q0(i3, getContext().getResources().getString(R.string.bh_));
            this.f76370f.T0(i3, false);
            this.f76370f.T0(m.l.f76061g, false);
            this.f76367m = false;
            this.f76370f.e1(this.f76366i, false);
        }
    }

    public void ra(int i3) {
        QavPanel qavPanel;
        if ((i3 == m.l.O || i3 == m.l.f76060f) && (qavPanel = this.f76370f) != null) {
            qavPanel.Q0(i3, getContext().getResources().getString(R.string.bhh));
            this.f76370f.T0(i3, true);
            this.f76370f.T0(m.l.f76061g, true);
            this.f76367m = true;
            this.f76370f.e1(this.f76366i, true);
        }
    }

    public void sa() {
        if (r.h0() == null || this.f76370f == null) {
            return;
        }
        if (!r.h0().i1()) {
            this.f76370f.setViewEnable(m.l.f76059e, false);
            this.f76370f.setViewEnable(m.l.P, false);
        } else {
            this.f76370f.setViewEnable(m.l.f76059e, true);
            this.f76370f.setViewEnable(m.l.P, true);
        }
    }

    public d(QavPanel qavPanel, boolean z16) {
        super(qavPanel);
        this.f76365h = null;
        this.f76366i = true;
        this.f76367m = false;
        this.D = TraeConstants.VIDEO_CALL_CONFIG;
        this.E = null;
        this.C = z16;
    }

    public void O9() {
        P9(true);
    }

    public void oa(boolean z16) {
        pa(z16, true);
    }

    public boolean C9(boolean z16) {
        SessionInfo f16 = n.e().f();
        boolean v3 = af.v();
        boolean z17 = (f16.f73037i1 || f16.f73041j1) ? false : true;
        if (QLog.isColorLevel()) {
            QLog.w(this.f76368d, 1, "checkBlockOpenMicOrCamera, isAllowedControlMicAfterBeMuted[" + v3 + "], isNormalUser[" + z17 + "], isRoomMicOff[" + f16.W0 + "], micAuthByAdmin[" + f16.X0 + "], openMic[" + z16 + "]");
        }
        VideoAppInterface b16 = nw.b.b();
        if (z17 && f16.W0 && f16.X0 != 0) {
            cw.e.p(b16, 1033, getContext().getResources().getString(z16 ? R.string.vu_ : R.string.f171253w35));
            ReportController.o(null, "dc00898", "", "", "0X800AB7F", "0X800AB7F", z16 ? 1 : 2, 0, "1", "", "", "");
            return true;
        }
        if (v3 || !z17 || f16.X0 != 1) {
            return false;
        }
        cw.e.p(b16, 1033, getContext().getResources().getString(z16 ? R.string.vub : R.string.w36));
        ReportController.o(null, "CliOper", "", "", "0X800AB7F", "0X800AB7F", z16 ? 1 : 2, 0, "2", "", "", "");
        return true;
    }

    public void R9() {
        QLog.d(this.f76368d, 1, "onClick QavPanel.ViewID.HAND_FREE");
        this.f76365h.T(TraeHelper.D);
        SessionInfo f16 = n.e().f();
        if (f16.I0 && f16.H0 != null) {
            ReportController.o(null, "CliOper", "", "", "0X8005202", "0X8005202", 0, 0, "", "", "", "");
        } else {
            ReportController.o(null, "CliOper", "", "", "0X8005201", "0X8005201", 0, 0, "", "", "", "");
        }
    }

    public void W9(long j3, View view) {
        mw.h hVar = (mw.h) RFWIocAbilityProvider.g().getIocInterface(mw.h.class, getPartRootView(), null);
        if (hVar != null && hVar.f1(j3, QQPermissionConstants.Permission.RECORD_AUDIO, view, null)) {
            boolean X0 = r.h0().X0();
            N9(X0);
            SessionInfo f16 = n.e().f();
            long longValue = TextUtils.isEmpty(f16.f73091w) ? 0L : Long.valueOf(f16.f73091w).longValue();
            VideoAppInterface b16 = nw.b.b();
            int e06 = r.h0().e0();
            if (X0) {
                r.h0().z("doMute.1", longValue, true, true, -1);
                this.f76370f.H("doMute.1", e06, r.h0().e0(), false);
                qa(m.l.f76060f);
                qa(m.l.O);
                if (b16 != null) {
                    b16.k0(new Object[]{108});
                }
                if (AVUtil.l()) {
                    r.h0().c3();
                }
                ReportController.o(null, "CliOper", "", "", "0X8005204", "0X8005204", 0, 0, "", "", "", "");
            } else {
                r.h0().z("doMute.2", longValue, false, true, -1);
                this.f76370f.H("doMute.2", e06, r.h0().e0(), false);
                ra(m.l.f76060f);
                ra(m.l.O);
                if (b16 != null) {
                    b16.k0(new Object[]{109});
                }
                ReportController.o(null, "CliOper", "", "", "0X8005203", "0X8005203", 0, 0, "", "", "", "");
            }
        }
        ((j) RFWIocAbilityProvider.g().getIocInterface(j.class, getPartRootView(), null)).resetToolBarTimer(j3);
    }

    public void N9(boolean z16) {
        cw.e.g(nw.b.b(), z16 ? 1062 : 1063, 3000L);
    }
}
