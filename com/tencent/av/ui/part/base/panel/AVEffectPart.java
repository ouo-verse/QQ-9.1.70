package com.tencent.av.ui.part.base.panel;

import android.view.View;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.n;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.effect.menuview.QavEffectBaseMenuView;
import com.tencent.av.ui.m;
import com.tencent.av.ui.x;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.af;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mw.j;

/* loaded from: classes32.dex */
public class AVEffectPart extends e {

    /* renamed from: h, reason: collision with root package name */
    a f76317h;

    /* loaded from: classes32.dex */
    class a extends ControlUIObserver {
        a() {
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void J(long j3, boolean z16, int i3) {
            QavPanel qavPanel;
            if (AVEffectPart.this.getActivity() == null || AVEffectPart.this.getActivity().isDestroyed() || ((j) RFWIocAbilityProvider.g().getIocInterface(j.class, AVEffectPart.this.getPartRootView(), null)).isToolBarDisplay() || (qavPanel = AVEffectPart.this.f76370f) == null) {
                return;
            }
            qavPanel.V0(j3, i3);
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void K(long j3) {
            QavPanel qavPanel;
            if (AVEffectPart.this.getActivity() == null || AVEffectPart.this.getActivity().isDestroyed() || !((j) RFWIocAbilityProvider.g().getIocInterface(j.class, AVEffectPart.this.getPartRootView(), null)).isToolBarDisplay() || (qavPanel = AVEffectPart.this.f76370f) == null || !qavPanel.v0(0)) {
                return;
            }
            AVEffectPart.this.f76370f.X0(j3, 0, true);
        }
    }

    public AVEffectPart(QavPanel qavPanel) {
        super(qavPanel);
        this.f76317h = new a();
        nw.b.b().addObserver(this.f76317h);
    }

    public void C9(long j3) {
        QavPanel qavPanel = this.f76370f;
        if (qavPanel != null && qavPanel.v0(5)) {
            this.f76370f.X0(j3, 0, true);
        }
    }

    public void D9(final long j3, View view) {
        QavPanel qavPanel = this.f76370f;
        if (qavPanel != null) {
            if (qavPanel.v0(3)) {
                this.f76370f.X0(j3, 0, true);
            } else {
                this.f76370f.X0(j3, 3, true);
            }
        }
        AVUtil.a("0X800A566", 0);
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.av.ui.part.base.panel.AVEffectPart.1
            @Override // java.lang.Runnable
            public void run() {
                AVActivity aVActivity = (AVActivity) AVEffectPart.this.getActivity();
                if (aVActivity != null) {
                    aVActivity.R2(j3);
                }
            }
        }, 100L);
    }

    public void E9(long j3, View view) {
        ControlUIObserver.b bVar = new ControlUIObserver.b(view, 2);
        QavEffectBaseMenuView z95 = z9();
        if (z95 != null && z95.q() != -1 && z95.q() != 100) {
            bVar.f74773g = z95.q();
        } else {
            bVar.f74773g = 1;
        }
        QLog.w(this.f76368d, 1, "onClick_Effect, mEffectBtnID[" + bVar.f74773g + "], seq[" + j3 + "]");
        QavPanel qavPanel = this.f76370f;
        if (qavPanel != null) {
            boolean v06 = qavPanel.v0(5);
            QLog.d(this.f76368d, 1, "onClick_Effect isMenuShow=" + v06);
            if (v06) {
                ((QavEffectBaseMenuView) this.f76370f.N(5)).m(bVar.f74773g);
                return;
            }
            this.f76370f.V0(j3, bVar.f74773g);
            A9(j3, m.e.f76018e);
            this.f76370f.z();
        }
    }

    public void F9(long j3, View view) {
        DataReport.q();
        ControlUIObserver.b bVar = new ControlUIObserver.b(view, 1);
        bVar.f74773g = 5;
        QLog.w(this.f76368d, 1, "onClick_Voice, mEffectBtnID[" + bVar.f74773g + "], seq[" + j3 + "]");
        QavPanel qavPanel = this.f76370f;
        if (qavPanel == null) {
            return;
        }
        qavPanel.V0(j3, bVar.f74773g);
        A9(j3, m.e.f76018e);
    }

    public void G9(long j3) {
        if (r.h0() == null) {
            return;
        }
        SessionInfo f16 = n.e().f();
        int i3 = 8;
        if (!com.tencent.av.opengl.effects.j.D()) {
            if (com.tencent.av.utils.e.j()) {
                QLog.w(this.f76368d, 1, "updateBtn_Beauty, !isEnableAEModuleManager, seq[" + j3 + "]");
            }
        } else if (!f16.N) {
            if (com.tencent.av.utils.e.j()) {
                QLog.w(this.f76368d, 1, "updateBtn_Beauty, !localHasVideo, seq[" + j3 + "]");
            }
        } else if (!uv.b.f().i()) {
            if (com.tencent.av.utils.e.j()) {
                QLog.w(this.f76368d, 1, "updateBtn_Beauty, !isFilterSoDownLoadSuc, seq[" + j3 + "]");
            }
        } else if (!AEFilterSupport.f(2)) {
            if (com.tencent.av.utils.e.j()) {
                QLog.w(this.f76368d, 1, "updateBtn_Beauty, AEKitSo not ready, seq[" + j3 + "]");
            }
        } else if (!f16.f73102y2 && !f16.f73098x2) {
            i3 = 0;
        } else if (com.tencent.av.utils.e.j()) {
            QLog.w(this.f76368d, 1, "updateBtn_Beauty, isAvatarUsing, seq[" + j3 + "]");
        }
        QavPanel qavPanel = this.f76370f;
        if (qavPanel != null) {
            qavPanel.p(i3);
        }
        rw.a x95 = x9(m.e.f76028o, j3);
        if (x95 != null) {
            x95.n(i3 == 0);
        }
        if (com.tencent.av.utils.e.j()) {
            QLog.d(this.f76368d, 1, "updateBtn_Beauty, show[" + i3 + "], seq[" + j3 + "]");
        }
    }

    public boolean H9(long j3) {
        boolean z16;
        QavPanel qavPanel = this.f76370f;
        if (qavPanel == null) {
            return false;
        }
        rw.a M = qavPanel.M(m.e.f76018e);
        rw.a M2 = this.f76370f.M(m.e.f76015b);
        if ((M == null && M2 == null) || r.h0() == null) {
            return false;
        }
        SessionInfo f16 = n.e().f();
        if (!af.x()) {
            if (M != null) {
                M.n(false);
            }
            if (M2 != null) {
                M2.n(false);
            }
            return false;
        }
        boolean D = com.tencent.av.opengl.effects.j.D();
        boolean z17 = D ? !com.tencent.av.camera.b.a(getContext()).isCameraOpening(j3) : false;
        if (f16.f73098x2 || f16.f73102y2 || f16.f73060o0) {
            z17 = false;
            z16 = true;
        } else {
            z16 = false;
        }
        if (f16.N) {
            if (M != null) {
                M.k(!z17);
                M.i(z17);
                M.n(D);
            }
            if (M2 != null) {
                M2.n(!D);
            }
            QavPanel qavPanel2 = this.f76370f;
            int i3 = m.l.C;
            qavPanel2.setViewVisibility(i3, (!D || z16) ? 8 : 0);
            this.f76370f.S0(i3, z17);
            this.f76370f.setViewEnable(i3, z17);
        } else {
            if (M2 != null) {
                M2.k(false);
                M2.i(true);
                M2.n(true);
            }
            if (M != null) {
                M.n(false);
            }
            this.f76370f.setViewVisibility(m.l.C, 8);
        }
        if (com.tencent.av.utils.e.j()) {
            QLog.d(this.f76368d, 1, "updateBtn_EffectAndVoice, enable[" + z17 + "], enableAE[" + D + "], relationType[" + f16.S0 + "], mShareState[" + f16.f73046k2 + "], isDoubleVideoMeeting[" + f16.f73060o0 + "], isTurnDoubleVideoMeeting2Multi[" + f16.f73068q0 + "], isInMeetingRoom[" + f16.f73064p0 + "], isDoubleMeetingCreator[" + f16.f73072r0 + "], mSessionState[" + f16.f73043k + "], mSessionStatus[" + f16.f73025g + "], seq[" + j3 + "]");
        }
        return true;
    }

    @Override // com.tencent.av.ui.part.base.panel.e
    public void onDestroy() {
        super.onDestroy();
        if (this.f76317h != null) {
            nw.b.b().deleteObserver(this.f76317h);
            this.f76317h = null;
        }
    }

    public boolean I9(long j3) {
        boolean z16;
        String str;
        String str2;
        AVActivity aVActivity = (AVActivity) getActivity();
        int i3 = 0;
        if (aVActivity == null || aVActivity.isDestroyed() || this.f76370f == null) {
            return false;
        }
        if (r.h0() == null) {
            QLog.e(this.f76368d, 2, "updateBtnEffectAndVoiceExternal-->VideoController.getInstance() is null, Why???");
            return false;
        }
        SessionInfo f16 = n.e().f();
        if (f16 == null) {
            return false;
        }
        boolean z17 = com.tencent.av.opengl.effects.j.D() ? !com.tencent.av.camera.b.a(getContext()).isCameraOpening(j3) : false;
        if (f16.f73035i != 1 || f16.z()) {
            z16 = true;
        } else {
            QavPanel qavPanel = this.f76370f;
            if (qavPanel != null) {
                qavPanel.w(!f16.f73098x2);
            }
            if (QLog.isDevelopLevel()) {
                QLog.w(this.f76368d, 1, "updateBtn_EffectAndVoiceExternal, state[" + f16.f73043k + "], seq[" + j3 + "]");
            }
            z16 = false;
        }
        QavPanel qavPanel2 = this.f76370f;
        if (qavPanel2 == null) {
            return f16.N ? z17 : z16;
        }
        if (f16.f73098x2) {
            boolean z18 = f16.f73102y2 && r.h0().U0();
            boolean z19 = f16.O1 == 2;
            boolean s36 = aVActivity.s3();
            if (z18 && (z19 || s36)) {
                i3 = 1;
            }
            QavPanel qavPanel3 = this.f76370f;
            int i16 = m.l.f76075u;
            int P = qavPanel3.P(i16);
            this.f76370f.j1(z18, i3);
            if (P != 0) {
                if (z18) {
                    str2 = "1";
                } else {
                    str2 = "2";
                }
                ReportController.o(null, "dc00898", "", "", "0X800C43C", "0X800C43C", 0, 0, str2, "", "", "");
            }
            View h16 = this.f76370f.h1(i16);
            if (h16 != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("\u5e73\u884c\u6a21\u5f0f\u6309\u94ae");
                if (z18) {
                    str = "";
                } else {
                    str = "\uff0c\u5df2\u505c\u7528";
                }
                sb5.append(str);
                h16.setContentDescription(sb5.toString());
            }
        } else {
            qavPanel2.i1(f16.N);
            if (af.x() && !x.g(BaseApplication.getContext())) {
                this.f76370f.setViewEnable(m.l.L, true);
                this.f76370f.setViewEnable(m.l.K, true);
            } else {
                this.f76370f.setViewEnable(m.l.L, z16);
                this.f76370f.setViewEnable(m.l.K, z17);
            }
        }
        return f16.N ? z17 : z16;
    }
}
