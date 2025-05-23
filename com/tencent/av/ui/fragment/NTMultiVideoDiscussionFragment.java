package com.tencent.av.ui.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.ap;
import com.tencent.av.ui.m;
import com.tencent.av.ui.part.base.AVHidePart;
import com.tencent.av.ui.part.base.AVNetConnectInfoPart;
import com.tencent.av.ui.part.base.AVToolBarPart;
import com.tencent.av.ui.part.mav.AVInviteUserNoticePart;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.as;
import com.tencent.av.utils.e;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.h;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class NTMultiVideoDiscussionFragment extends NTMultiVideoBaseFragment {
    boolean U0;
    GAudioUIObserver V0;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class AutoCheckVideoRunnable implements Runnable {
        AutoCheckVideoRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (QLog.isColorLevel()) {
                QLog.d(NTBaseVideoFragment.f75610s0, 2, "AutoCheckVideoRunnable");
            }
            if (r.h0() != null) {
                n.e().f().f73097x1 = true;
            }
            NTMultiVideoDiscussionFragment.this.Hl();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ VideoAppInterface f75681d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f75682e;

        a(VideoAppInterface videoAppInterface, int i3) {
            this.f75681d = videoAppInterface;
            this.f75682e = i3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "showConfirmBoxToHangup, yes, mRelationId[" + NTMultiVideoDiscussionFragment.this.f75670y0 + "]");
            NTMultiVideoDiscussionFragment.this.Nl(0L);
            Bundle bundle = new Bundle();
            bundle.putString("uin", String.valueOf(NTMultiVideoDiscussionFragment.this.f75670y0));
            this.f75681d.s0(4, 0, 0, bundle, null);
            if (QAVHrMeeting.m(this.f75682e)) {
                return;
            }
            NTMultiVideoDiscussionFragment.Ol(NTBaseVideoFragment.f75610s0, this.f75681d, String.valueOf(NTMultiVideoDiscussionFragment.this.f75670y0), 3000, this.f75681d.getApp().getString(R.string.ddw));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QLog.w(NTBaseVideoFragment.f75610s0, 1, "showConfirmBoxToHangup, no, mRelationId[" + NTMultiVideoDiscussionFragment.this.f75670y0 + "]");
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f75685d;

        c(long j3) {
            this.f75685d = j3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            NTMultiVideoDiscussionFragment.this.Nl(this.f75685d);
        }
    }

    public NTMultiVideoDiscussionFragment() {
        this.U0 = false;
        this.V0 = new GAudioUIObserver() { // from class: com.tencent.av.ui.fragment.NTMultiVideoDiscussionFragment.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.av.app.GAudioUIObserver
            public void B(long j3, int i3) {
                if (QLog.isColorLevel()) {
                    QLog.w(NTBaseVideoFragment.f75610s0, 1, "onInviteSomeoneEnter, firstUin[" + j3 + "], length[" + i3 + "]");
                }
                super.B(j3, i3);
                NTMultiVideoDiscussionFragment nTMultiVideoDiscussionFragment = NTMultiVideoDiscussionFragment.this;
                nTMultiVideoDiscussionFragment.A0 = i3;
                nTMultiVideoDiscussionFragment.ul(j3, 68, true, -1, 0);
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void C(int i3, String str) {
                AVInviteUserNoticePart aVInviteUserNoticePart = NTMultiVideoDiscussionFragment.this.P0;
                if (aVInviteUserNoticePart != null) {
                    aVInviteUserNoticePart.x9(i3, str);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.av.app.GAudioUIObserver
            public void M(String str, String[] strArr) {
                super.M(str, strArr);
                NTMultiVideoDiscussionFragment nTMultiVideoDiscussionFragment = NTMultiVideoDiscussionFragment.this;
                long F = nTMultiVideoDiscussionFragment.G.F(String.valueOf(nTMultiVideoDiscussionFragment.f75670y0));
                if (QLog.isColorLevel()) {
                    String U = r.h0().U(str, String.valueOf(NTMultiVideoDiscussionFragment.this.f75670y0), NTMultiVideoDiscussionFragment.this.f75668w0);
                    QLog.d(NTBaseVideoFragment.f75610s0, 2, "onOtherMemberInvited --> l= " + String.valueOf(F) + "inviterName=" + U);
                }
                if (NTMultiVideoDiscussionFragment.this.T != null) {
                    if (QAVHrMeeting.k(F)) {
                        NTMultiVideoDiscussionFragment.this.T.S9(str, strArr);
                    } else {
                        NTMultiVideoDiscussionFragment.this.T.R9(str, strArr);
                        NTMultiVideoDiscussionFragment.this.ul(Long.valueOf(str).longValue(), 82, true, -1, 0);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.av.app.GAudioUIObserver
            public void O() {
                long[] E;
                if (QLog.isColorLevel()) {
                    QLog.d(NTBaseVideoFragment.f75610s0, 2, "onServiceConnected");
                }
                super.O();
                NTMultiVideoDiscussionFragment nTMultiVideoDiscussionFragment = NTMultiVideoDiscussionFragment.this;
                long j3 = nTMultiVideoDiscussionFragment.f75670y0;
                if (j3 != 0) {
                    int i3 = nTMultiVideoDiscussionFragment.f75667v0;
                    String valueOf = String.valueOf(j3);
                    NTMultiVideoDiscussionFragment.this.G.A0(i3, valueOf);
                    if (NTMultiVideoDiscussionFragment.this.f75666u0 != 0 || r.h0() == null) {
                        return;
                    }
                    Intent intent = NTMultiVideoDiscussionFragment.this.getIntent();
                    if ((intent == null || !intent.hasExtra("invitelist")) && (E = NTMultiVideoDiscussionFragment.this.G.E(valueOf)) != null) {
                        r.h0().Q2(E);
                        r.h0().T0(E, false, null);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.av.app.GAudioUIObserver
            public void R() {
                super.R();
                if (QLog.isColorLevel()) {
                    QLog.d(NTBaseVideoFragment.f75610s0, 2, "onUpdatePstnInfo --> Start");
                }
                AVActivity aVActivity = (AVActivity) NTMultiVideoDiscussionFragment.this.F.get();
                if (aVActivity != null) {
                    aVActivity.runOnUiThread(new Runnable() { // from class: com.tencent.av.ui.fragment.NTMultiVideoDiscussionFragment.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            NTMultiVideoDiscussionFragment.this.el(-1018L, "onUpdatePstnInfo");
                        }
                    });
                } else if (QLog.isColorLevel()) {
                    QLog.e(NTBaseVideoFragment.f75610s0, 2, "onUpdatePstnInfo-->Can not get AVActivity");
                }
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void g(long j3, long j16) {
                if (NTMultiVideoDiscussionFragment.this.isDestroyed()) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.w(NTBaseVideoFragment.f75610s0, 1, "onCreateRoomSuc, groupId[" + j16 + "], isVideo[" + NTMultiVideoDiscussionFragment.this.I0 + "], seq[" + j3 + "]");
                }
                h.f(NTMultiVideoDiscussionFragment.this.I0 ? 2 : 1, r.h0().g0() + "");
                ap.b(NTMultiVideoDiscussionFragment.this.I0 ? 4 : 3, r.h0().g0() + "");
                NTMultiVideoDiscussionFragment.this.bl();
                NTMultiVideoDiscussionFragment.this.zl(j3);
                as asVar = NTMultiVideoDiscussionFragment.this.L;
                if (asVar != null) {
                    asVar.m(true);
                    NTMultiVideoDiscussionFragment.this.L.n(true);
                    NTMultiVideoDiscussionFragment.this.L.p();
                }
                n.e().f().f73097x1 = true;
                NTMultiVideoDiscussionFragment.this.Pl(true, j16);
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void j() {
                NTMultiVideoDiscussionFragment nTMultiVideoDiscussionFragment = NTMultiVideoDiscussionFragment.this;
                if (nTMultiVideoDiscussionFragment.f75668w0 != 2) {
                    return;
                }
                nTMultiVideoDiscussionFragment.lk(0L, 33554431);
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void k(long j3, long j16) {
                if (NTMultiVideoDiscussionFragment.this.isDestroyed()) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.w(NTBaseVideoFragment.f75610s0, 1, "onEnterRoomSuc, groupId[" + j16 + "], seq[" + j3 + "]");
                }
                ap.b(NTMultiVideoDiscussionFragment.this.I0 ? 4 : 3, r.h0().g0() + "");
                h.f(NTMultiVideoDiscussionFragment.this.I0 ? 2 : 1, r.h0().g0() + "");
                NTMultiVideoDiscussionFragment.this.bl();
                NTMultiVideoDiscussionFragment.this.zl(j3);
                as asVar = NTMultiVideoDiscussionFragment.this.L;
                if (asVar != null) {
                    asVar.m(true);
                    NTMultiVideoDiscussionFragment.this.L.n(true);
                    NTMultiVideoDiscussionFragment.this.L.p();
                }
                NTMultiVideoDiscussionFragment.this.G.M().postDelayed(new AutoCheckVideoRunnable(), 500L);
                NTMultiVideoDiscussionFragment.this.dl();
                NTMultiVideoDiscussionFragment.this.Pl(false, j16);
                NTMultiVideoDiscussionFragment.this.lk(j3, 33554431);
                NTMultiVideoDiscussionFragment.this.El();
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void z(long j3, int i3, int i16) {
                NTMultiVideoDiscussionFragment.this.al(j3, i3, i16);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Ol(String str, VideoAppInterface videoAppInterface, String str2, int i3, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("uin", str2);
        bundle.putInt("uinType", i3);
        bundle.putString("wording", str3);
        try {
            QLog.w(str, 1, "notifyWriteGrayMsg, peerUin[" + str2 + "], wording[" + str3 + "]");
            videoAppInterface.s0(1, 0, 0, bundle, null);
        } catch (Exception e16) {
            QLog.w(str, 1, "notifyWriteGrayMsg, Exception[" + e16.getMessage() + "]");
        }
    }

    @Override // com.tencent.av.ui.fragment.NTMultiVideoBaseFragment
    void Cl(int i3, int i16, String str, String str2) {
        AVNetConnectInfoPart aVNetConnectInfoPart = this.T;
        if (aVNetConnectInfoPart != null) {
            aVNetConnectInfoPart.M9(this.H0, i3, i16, str, str2);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTMultiVideoBaseFragment, com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Ii() {
        super.Ii();
        if (QLog.isColorLevel()) {
            QLog.d(NTBaseVideoFragment.f75610s0, 2, "OnCreate");
        }
        this.U0 = false;
        this.G.addObserver(this.V0);
        initUI();
        Zk();
    }

    void Ml() {
        long[] jArr;
        ArrayList parcelableArrayListExtra;
        long d16 = e.d();
        QLog.w(NTBaseVideoFragment.f75610s0, 1, "createOrEnterVideo, mRelationId[" + this.f75670y0 + "], mIntentRelationId[" + this.f75669x0 + "], seq[" + d16 + "]");
        long j3 = this.f75669x0;
        this.f75670y0 = j3;
        if (j3 <= 0) {
            return;
        }
        Cj(d16, R.string.db6);
        int i3 = this.f75666u0;
        if (i3 != 0) {
            if (i3 == 1) {
                r.h0().a(d16, this.f75668w0, this.f75670y0, null, this.I0);
                return;
            }
            return;
        }
        Intent intent = getIntent();
        if (intent == null || (parcelableArrayListExtra = intent.getParcelableArrayListExtra("invitelist")) == null || parcelableArrayListExtra.size() <= 0) {
            jArr = null;
        } else {
            jArr = new long[parcelableArrayListExtra.size()];
            Iterator it = parcelableArrayListExtra.iterator();
            int i16 = 0;
            while (it.hasNext()) {
                jArr[i16] = e.v(((ResultRecord) it.next()).uin);
                i16++;
            }
        }
        if (jArr == null) {
            jArr = n.e().f().Q0;
        }
        r.h0().y3(this.f75668w0, this.f75670y0, 0, jArr, this.I0, null);
        this.G0 = true;
    }

    @Override // com.tencent.av.ui.fragment.NTMultiVideoBaseFragment, com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Pj(long j3, int i3) {
        boolean z16;
        super.Pj(j3, i3);
        if (r.h0() == null || n.e().f().t() || isDestroyed()) {
            return;
        }
        int i16 = 0;
        if (n.e().f().f73045k1.size() > 0) {
            z16 = n.e().f().f73045k1.get(0).f73830d;
            i16 = n.e().f().f73045k1.get(0).f73828b;
        } else {
            z16 = true;
        }
        if (!z16 || i16 == 0) {
            return;
        }
        DataReport.N(i16, i3);
    }

    void Ql(int i3) {
        VideoAppInterface videoAppInterface = this.G;
        AVActivity aVActivity = (AVActivity) this.F.get();
        QQCustomDialog positiveButton = DialogUtil.createCustomDialog(aVActivity, 230).setMessage(this.G.getApplication().getResources().getString(R.string.bry)).setNegativeButton(R.string.brz, new b()).setPositiveButton(R.string.f171024bs0, new a(videoAppInterface, i3));
        if (aVActivity.isResume()) {
            positiveButton.show();
        }
    }

    @Override // com.tencent.av.ui.fragment.NTMultiVideoBaseFragment
    void Zk() {
        int i3 = this.f75666u0;
        if (i3 == 0 || i3 == 1) {
            Uk(-1022L, "handleExtraData");
            Ml();
            return;
        }
        if (i3 == 2) {
            as asVar = this.L;
            if (asVar != null) {
                asVar.n(true);
                this.L.m(true);
            }
            this.f75670y0 = this.f75669x0;
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(NTBaseVideoFragment.f75610s0, 2, "handleExterData-->Wrong gaudioStatusType-->type = " + this.f75666u0 + " , relationId = " + this.f75669x0 + " , relationType = " + this.f75668w0);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTMultiVideoBaseFragment, com.tencent.av.ui.fragment.NTBaseVideoFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        AVToolBarPart aVToolBarPart = new AVToolBarPart(2);
        this.Y = aVToolBarPart;
        assembleParts.add(aVToolBarPart);
        com.tencent.av.ui.part.base.panel.d dVar = new com.tencent.av.ui.part.base.panel.d(this.J);
        this.f75622k0 = dVar;
        assembleParts.add(dVar);
        return assembleParts;
    }

    @Override // com.tencent.av.ui.fragment.NTMultiVideoBaseFragment
    public boolean cl() {
        int K = this.G.K(this.f75668w0, Long.toString(this.f75670y0));
        if (QLog.isColorLevel()) {
            QLog.d(NTBaseVideoFragment.f75610s0, 2, "isFull-->Discuss Num = " + K);
        }
        return K >= 100;
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public boolean mk(long j3) {
        boolean yh5 = yh(j3);
        sk(j3, yh5, 0);
        return yh5;
    }

    @Override // com.tencent.av.ui.fragment.NTMultiVideoBaseFragment
    void pl(Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.d(NTBaseVideoFragment.f75610s0, 2, "processExtraData--> Type = " + n.e().f().R0 + " , relationId = " + n.e().f().P0 + " , isInRoom = " + r.h0().W0() + " , RoomRelationId = " + r.h0().X());
        }
    }

    @Override // com.tencent.av.ui.fragment.NTMultiVideoBaseFragment, com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void ri(long j3) {
        com.tencent.av.ui.part.base.panel.d dVar = this.f75622k0;
        if (dVar != null) {
            dVar.P9(false);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void si(long j3, View view) {
        if (n.e().f().f73061o1.size() > 0 && n.e().f().f73041j1) {
            DialogUtil.createCustomDialog(this.F.get(), 230).setTitle(this.F.get().getString(R.string.f171241de4)).setMessage(this.F.get().getString(R.string.f171239de2)).setNegativeButton(this.F.get().getString(R.string.f171238de1), new d()).setPositiveButton(this.F.get().getString(R.string.f171240de3), new c(j3)).show();
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("uin", String.valueOf(this.f75670y0));
            Bundle s06 = this.G.s0(5, 0, 0, bundle, null);
            if (s06 == null) {
                Nl(j3);
            } else {
                long j16 = s06.getLong("Origin", 0L);
                long j17 = s06.getLong("OriginExtra", 0L);
                int i3 = s06.getInt("SelfRight", -1);
                if ((j16 & 2) == 2 && QAVHrMeeting.j(j17) == 0) {
                    Ql(i3);
                } else {
                    Nl(j3);
                }
            }
        }
        QLog.d(NTBaseVideoFragment.f75610s0, 1, "mNeedNotifyHangupEvent =" + n.e().f().I2);
    }

    @Override // com.tencent.av.ui.fragment.NTMultiVideoBaseFragment
    void sl() {
        QavPanel qavPanel = this.J;
        int i3 = m.l.f76060f;
        if (qavPanel.x(i3) || r.h0() == null) {
            return;
        }
        this.J.setViewEnable(i3, true);
        if (r.h0().X0()) {
            gk(i3);
        } else {
            fk(i3);
        }
        this.J.D0(r.h0().X0());
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void ti(long j3) {
        com.tencent.av.ui.part.dav.panel.d dVar = this.f75620i0;
        if (dVar != null) {
            dVar.E9(j3, cl());
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void ui(long j3, View view) {
        if (isDestroyed()) {
            return;
        }
        yj(j3);
        vi(j3, 1);
        wh().R2(j3);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void zj(boolean z16, int i3) {
        this.J.K0(z16, i3);
    }

    @Override // com.tencent.av.ui.fragment.NTMultiVideoBaseFragment, com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Ki(long j3) {
        this.U0 = true;
        QLog.w(NTBaseVideoFragment.f75610s0, 1, "onDestroy, seq[" + j3 + "]");
        VideoAppInterface videoAppInterface = this.G;
        if (videoAppInterface != null) {
            videoAppInterface.deleteObserver(this.V0);
        }
        super.Ki(j3);
    }

    void Nl(long j3) {
        Ph(true);
        com.tencent.av.ui.part.base.panel.c cVar = this.f75618g0;
        if (cVar != null) {
            cVar.H9(j3);
        }
    }

    void Pl(boolean z16, long j3) {
        long F = this.G.F(String.valueOf(this.f75670y0));
        if (F > 0) {
            long g06 = r.h0().g0();
            long f06 = r.h0().f0();
            String valueOf = String.valueOf(g06);
            String valueOf2 = String.valueOf(j3);
            String valueOf3 = String.valueOf(f06);
            String valueOf4 = String.valueOf(F);
            ReportController.o(null, "dc00898", "", "", "0X800827C", "0X800827C", z16 ? 1 : 2, 0, valueOf4, "", valueOf2 + "_" + valueOf + "_" + valueOf3 + "_" + valueOf4, "");
            QLog.e(NTBaseVideoFragment.f75610s0, 1, "onCreateRoomSuc post conf, GroupID = " + j3 + ", strRoomId=" + valueOf);
        }
    }

    public NTMultiVideoDiscussionFragment(VideoAppInterface videoAppInterface, AVActivity aVActivity, ControlUIObserver controlUIObserver) {
        super(videoAppInterface, aVActivity, controlUIObserver);
        this.U0 = false;
        this.V0 = new GAudioUIObserver() { // from class: com.tencent.av.ui.fragment.NTMultiVideoDiscussionFragment.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.av.app.GAudioUIObserver
            public void B(long j3, int i3) {
                if (QLog.isColorLevel()) {
                    QLog.w(NTBaseVideoFragment.f75610s0, 1, "onInviteSomeoneEnter, firstUin[" + j3 + "], length[" + i3 + "]");
                }
                super.B(j3, i3);
                NTMultiVideoDiscussionFragment nTMultiVideoDiscussionFragment = NTMultiVideoDiscussionFragment.this;
                nTMultiVideoDiscussionFragment.A0 = i3;
                nTMultiVideoDiscussionFragment.ul(j3, 68, true, -1, 0);
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void C(int i3, String str) {
                AVInviteUserNoticePart aVInviteUserNoticePart = NTMultiVideoDiscussionFragment.this.P0;
                if (aVInviteUserNoticePart != null) {
                    aVInviteUserNoticePart.x9(i3, str);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.av.app.GAudioUIObserver
            public void M(String str, String[] strArr) {
                super.M(str, strArr);
                NTMultiVideoDiscussionFragment nTMultiVideoDiscussionFragment = NTMultiVideoDiscussionFragment.this;
                long F = nTMultiVideoDiscussionFragment.G.F(String.valueOf(nTMultiVideoDiscussionFragment.f75670y0));
                if (QLog.isColorLevel()) {
                    String U = r.h0().U(str, String.valueOf(NTMultiVideoDiscussionFragment.this.f75670y0), NTMultiVideoDiscussionFragment.this.f75668w0);
                    QLog.d(NTBaseVideoFragment.f75610s0, 2, "onOtherMemberInvited --> l= " + String.valueOf(F) + "inviterName=" + U);
                }
                if (NTMultiVideoDiscussionFragment.this.T != null) {
                    if (QAVHrMeeting.k(F)) {
                        NTMultiVideoDiscussionFragment.this.T.S9(str, strArr);
                    } else {
                        NTMultiVideoDiscussionFragment.this.T.R9(str, strArr);
                        NTMultiVideoDiscussionFragment.this.ul(Long.valueOf(str).longValue(), 82, true, -1, 0);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.av.app.GAudioUIObserver
            public void O() {
                long[] E;
                if (QLog.isColorLevel()) {
                    QLog.d(NTBaseVideoFragment.f75610s0, 2, "onServiceConnected");
                }
                super.O();
                NTMultiVideoDiscussionFragment nTMultiVideoDiscussionFragment = NTMultiVideoDiscussionFragment.this;
                long j3 = nTMultiVideoDiscussionFragment.f75670y0;
                if (j3 != 0) {
                    int i3 = nTMultiVideoDiscussionFragment.f75667v0;
                    String valueOf = String.valueOf(j3);
                    NTMultiVideoDiscussionFragment.this.G.A0(i3, valueOf);
                    if (NTMultiVideoDiscussionFragment.this.f75666u0 != 0 || r.h0() == null) {
                        return;
                    }
                    Intent intent = NTMultiVideoDiscussionFragment.this.getIntent();
                    if ((intent == null || !intent.hasExtra("invitelist")) && (E = NTMultiVideoDiscussionFragment.this.G.E(valueOf)) != null) {
                        r.h0().Q2(E);
                        r.h0().T0(E, false, null);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.av.app.GAudioUIObserver
            public void R() {
                super.R();
                if (QLog.isColorLevel()) {
                    QLog.d(NTBaseVideoFragment.f75610s0, 2, "onUpdatePstnInfo --> Start");
                }
                AVActivity aVActivity2 = (AVActivity) NTMultiVideoDiscussionFragment.this.F.get();
                if (aVActivity2 != null) {
                    aVActivity2.runOnUiThread(new Runnable() { // from class: com.tencent.av.ui.fragment.NTMultiVideoDiscussionFragment.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            NTMultiVideoDiscussionFragment.this.el(-1018L, "onUpdatePstnInfo");
                        }
                    });
                } else if (QLog.isColorLevel()) {
                    QLog.e(NTBaseVideoFragment.f75610s0, 2, "onUpdatePstnInfo-->Can not get AVActivity");
                }
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void g(long j3, long j16) {
                if (NTMultiVideoDiscussionFragment.this.isDestroyed()) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.w(NTBaseVideoFragment.f75610s0, 1, "onCreateRoomSuc, groupId[" + j16 + "], isVideo[" + NTMultiVideoDiscussionFragment.this.I0 + "], seq[" + j3 + "]");
                }
                h.f(NTMultiVideoDiscussionFragment.this.I0 ? 2 : 1, r.h0().g0() + "");
                ap.b(NTMultiVideoDiscussionFragment.this.I0 ? 4 : 3, r.h0().g0() + "");
                NTMultiVideoDiscussionFragment.this.bl();
                NTMultiVideoDiscussionFragment.this.zl(j3);
                as asVar = NTMultiVideoDiscussionFragment.this.L;
                if (asVar != null) {
                    asVar.m(true);
                    NTMultiVideoDiscussionFragment.this.L.n(true);
                    NTMultiVideoDiscussionFragment.this.L.p();
                }
                n.e().f().f73097x1 = true;
                NTMultiVideoDiscussionFragment.this.Pl(true, j16);
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void j() {
                NTMultiVideoDiscussionFragment nTMultiVideoDiscussionFragment = NTMultiVideoDiscussionFragment.this;
                if (nTMultiVideoDiscussionFragment.f75668w0 != 2) {
                    return;
                }
                nTMultiVideoDiscussionFragment.lk(0L, 33554431);
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void k(long j3, long j16) {
                if (NTMultiVideoDiscussionFragment.this.isDestroyed()) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.w(NTBaseVideoFragment.f75610s0, 1, "onEnterRoomSuc, groupId[" + j16 + "], seq[" + j3 + "]");
                }
                ap.b(NTMultiVideoDiscussionFragment.this.I0 ? 4 : 3, r.h0().g0() + "");
                h.f(NTMultiVideoDiscussionFragment.this.I0 ? 2 : 1, r.h0().g0() + "");
                NTMultiVideoDiscussionFragment.this.bl();
                NTMultiVideoDiscussionFragment.this.zl(j3);
                as asVar = NTMultiVideoDiscussionFragment.this.L;
                if (asVar != null) {
                    asVar.m(true);
                    NTMultiVideoDiscussionFragment.this.L.n(true);
                    NTMultiVideoDiscussionFragment.this.L.p();
                }
                NTMultiVideoDiscussionFragment.this.G.M().postDelayed(new AutoCheckVideoRunnable(), 500L);
                NTMultiVideoDiscussionFragment.this.dl();
                NTMultiVideoDiscussionFragment.this.Pl(false, j16);
                NTMultiVideoDiscussionFragment.this.lk(j3, 33554431);
                NTMultiVideoDiscussionFragment.this.El();
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void z(long j3, int i3, int i16) {
                NTMultiVideoDiscussionFragment.this.al(j3, i3, i16);
            }
        };
        if (QLog.isColorLevel()) {
            QLog.d(NTBaseVideoFragment.f75610s0, 2, "MultiVideoCtrlLayerUI4Discussion --> Create");
        }
    }

    @Override // com.tencent.av.ui.fragment.NTMultiVideoBaseFragment
    public void Vk(long j3, int i3, boolean z16, int i16) {
        super.Vk(j3, i3, z16, i16);
        if (i3 == 0) {
            if (j3 == n.e().f().Z0 || j3 == this.f75671z0) {
                return;
            }
            cw.e.d(this.G, 1047);
            return;
        }
        if (i3 == 1) {
            cw.e.d(this.G, 1047);
            return;
        }
        if (i3 == 68) {
            AVNetConnectInfoPart aVNetConnectInfoPart = this.T;
            if (aVNetConnectInfoPart != null) {
                aVNetConnectInfoPart.J9(this.H0, this.A0, j3);
                return;
            }
            return;
        }
        if (i3 != 82) {
            if (i3 == 7) {
                ReportController.o(null, "CliOper", "", "", "0X8004CF0", "0X8004CF0", 0, 0, "", "", "", "");
            }
        } else {
            AVNetConnectInfoPart aVNetConnectInfoPart2 = this.T;
            if (aVNetConnectInfoPart2 != null) {
                aVNetConnectInfoPart2.L9(this.H0, 1, 0, null);
            }
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            DataReport.K(n.e().f().O, n.e().f().N, 1);
            AVHidePart aVHidePart = this.f75619h0;
            if (aVHidePart != null) {
                aVHidePart.E9();
            }
        } else if (i3 != 24 && i3 != 25) {
            if (QLog.isColorLevel()) {
                QLog.d(NTBaseVideoFragment.f75610s0, 2, "OnKeyDown --> WRONG KeyCode = " + i3);
            }
        } else {
            com.tencent.av.ui.part.base.panel.d dVar = this.f75622k0;
            if (dVar != null) {
                dVar.na();
            }
            return false;
        }
        return false;
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
