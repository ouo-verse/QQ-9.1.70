package com.tencent.av.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.ap;
import com.tencent.av.ui.m;
import com.tencent.av.ui.part.base.AVHidePart;
import com.tencent.av.ui.part.base.AVNetConnectInfoPart;
import com.tencent.av.ui.part.base.AVSmallHomeTipsPart;
import com.tencent.av.ui.part.base.AVToolBarPart;
import com.tencent.av.ui.part.base.panel.AVScreenSharePart;
import com.tencent.av.ui.part.base.panel.b;
import com.tencent.av.ui.part.base.panel.c;
import com.tencent.av.ui.part.base.panel.d;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.as;
import com.tencent.av.utils.e;
import com.tencent.biz.richframework.part.Part;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.statistics.h;
import com.tencent.mobileqq.utils.cp;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class NTMultiVideoGroupFragment extends NTMultiVideoBaseFragment {
    boolean U0;
    ControlUIObserver V0;
    GAudioUIObserver W0;
    int X0;

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
            NTMultiVideoGroupFragment.super.Hl();
            NTMultiVideoGroupFragment nTMultiVideoGroupFragment = NTMultiVideoGroupFragment.this;
            VideoAppInterface videoAppInterface = nTMultiVideoGroupFragment.G;
            if (videoAppInterface != null) {
                videoAppInterface.V(nTMultiVideoGroupFragment.f75670y0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends ControlUIObserver {
        a() {
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void C(cp.b bVar) {
            if (QLog.isDevelopLevel() || NTMultiVideoGroupFragment.this.U0 != bVar.f307553b) {
                QLog.w(NTBaseVideoFragment.f75610s0, 1, "onGroupInviteFlagChanged, mCanAutoInviteMemIntoTroop[" + NTMultiVideoGroupFragment.this.U0 + "->" + bVar.f307553b + "]");
            }
            NTMultiVideoGroupFragment nTMultiVideoGroupFragment = NTMultiVideoGroupFragment.this;
            boolean z16 = nTMultiVideoGroupFragment.U0;
            boolean z17 = bVar.f307553b;
            if (z16 != z17) {
                nTMultiVideoGroupFragment.U0 = z17;
                nTMultiVideoGroupFragment.lk(0L, 33554431);
            }
        }
    }

    public NTMultiVideoGroupFragment() {
        this.U0 = true;
        this.V0 = new a();
        this.W0 = new GAudioUIObserver() { // from class: com.tencent.av.ui.fragment.NTMultiVideoGroupFragment.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.av.app.GAudioUIObserver
            public void L(long j3, boolean z16, int i3) {
                NTMultiVideoGroupFragment.this.lk(0L, 33554431);
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void f(int i3, byte[] bArr) {
                AVScreenSharePart aVScreenSharePart = NTMultiVideoGroupFragment.this.f75623l0;
                if (aVScreenSharePart != null) {
                    aVScreenSharePart.J9(i3, bArr);
                }
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void k(long j3, long j16) {
                if (NTMultiVideoGroupFragment.this.isDestroyed()) {
                    return;
                }
                QLog.w(NTBaseVideoFragment.f75610s0, 1, "onEnterRoomSuc, GroupID[" + j16 + "], seq[" + j3 + "]");
                ap.b(NTMultiVideoGroupFragment.this.I0 ? 4 : 3, r.h0().g0() + "");
                h.f(NTMultiVideoGroupFragment.this.I0 ? 4 : 3, r.h0().g0() + "");
                NTMultiVideoGroupFragment.this.bl();
                NTMultiVideoGroupFragment.this.zl(j3);
                as asVar = NTMultiVideoGroupFragment.this.L;
                if (asVar != null) {
                    asVar.m(true);
                    NTMultiVideoGroupFragment.this.L.n(true);
                    NTMultiVideoGroupFragment.this.L.p();
                }
                VideoAppInterface videoAppInterface = NTMultiVideoGroupFragment.this.G;
                if (videoAppInterface != null) {
                    videoAppInterface.M().postDelayed(new AutoCheckVideoRunnable(), 500L);
                }
                NTMultiVideoGroupFragment.super.dl();
                NTMultiVideoGroupFragment.this.lk(j3, 33554431);
                NTMultiVideoGroupFragment.this.El();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.av.app.GAudioUIObserver
            public void w(long j3, long j16, String str) {
                super.w(j3, j16, str);
                if (QLog.isColorLevel()) {
                    QLog.d(NTBaseVideoFragment.f75610s0, 2, "onGroupSecurityLimit-->groupid=" + j3 + " info=" + j16 + " strMsg=" + str);
                }
                if (NTMultiVideoGroupFragment.this.f75668w0 != 1) {
                    return;
                }
                Intent intent = new Intent();
                intent.setAction("tencent.av.v2q.MultiVideo");
                intent.putExtra("type", 33);
                intent.putExtra("relationId", j3);
                intent.putExtra("uinType", NTMultiVideoGroupFragment.this.f75667v0);
                intent.putExtra("info", j16);
                intent.putExtra("strMsg", str);
                intent.putExtra("from", "MultiVideoCtrlLayerUI4NewGroupChat1");
                AVActivity aVActivity = (AVActivity) NTMultiVideoGroupFragment.this.F.get();
                if (aVActivity != null) {
                    VideoAppInterface videoAppInterface = NTMultiVideoGroupFragment.this.G;
                    if (videoAppInterface != null) {
                        intent.setPackage(videoAppInterface.getApplication().getPackageName());
                    }
                    aVActivity.sendBroadcast(intent);
                    NTMultiVideoGroupFragment.super.Wk(true);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.e(NTBaseVideoFragment.f75610s0, 2, "onGroupSecurityLimit-->can not get the activity");
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.av.app.GAudioUIObserver
            public void x(long j3, long j16, boolean z16) {
                super.x(j3, j16, z16);
                n.e().f().f73037i1 = false;
                if (n.e().f().f73063p == 10) {
                    NTMultiVideoGroupFragment.super.rl();
                }
                boolean z17 = n.e().f().N;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.av.app.GAudioUIObserver
            public void y(long j3, long j16, boolean z16) {
                super.y(j3, j16, z16);
                n.e().f().f73037i1 = true;
                if (n.e().f().f73063p == 10) {
                    NTMultiVideoGroupFragment.super.rl();
                }
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void z(long j3, int i3, int i16) {
                NTMultiVideoGroupFragment.this.al(j3, i3, i16);
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void g(final long j3, long j16) {
                AVActivity aVActivity;
                if (NTMultiVideoGroupFragment.this.isDestroyed()) {
                    return;
                }
                if (j16 != NTMultiVideoGroupFragment.this.f75670y0) {
                    QLog.i(NTBaseVideoFragment.f75610s0, 1, "onCreateRoomSuc, not right session. [" + j16 + "," + NTMultiVideoGroupFragment.this.f75670y0 + "]");
                    return;
                }
                SessionInfo f16 = n.e().f();
                QLog.w(NTBaseVideoFragment.f75610s0, 1, "onCreateRoomSuc, GroupID[" + j16 + "], seq[" + j3 + "], sessionId[" + f16.f73030h + "]");
                ap.b(NTMultiVideoGroupFragment.this.I0 ? 4 : 3, r.h0().g0() + "");
                h.f(NTMultiVideoGroupFragment.this.I0 ? 4 : 3, r.h0().g0() + "");
                if (f16.H2) {
                    DataReport.T(null, "dc00898", "", f16.f73091w, "0X800C26A", "0X800C26A", 0, 0, "", "", "", r.h0().g0() + "");
                }
                NTMultiVideoGroupFragment.this.bl();
                NTMultiVideoGroupFragment.this.zl(j3);
                as asVar = NTMultiVideoGroupFragment.this.L;
                if (asVar != null) {
                    asVar.m(true);
                    NTMultiVideoGroupFragment.this.L.n(true);
                    NTMultiVideoGroupFragment.this.L.p();
                }
                f16.f73097x1 = true;
                NTMultiVideoGroupFragment nTMultiVideoGroupFragment = NTMultiVideoGroupFragment.this;
                VideoAppInterface videoAppInterface = nTMultiVideoGroupFragment.G;
                if (videoAppInterface != null) {
                    videoAppInterface.V(nTMultiVideoGroupFragment.f75670y0);
                }
                if (f16.f73042j2 != 4 || (aVActivity = (AVActivity) NTMultiVideoGroupFragment.this.F.get()) == null || aVActivity.isFinishing()) {
                    return;
                }
                aVActivity.runOnUiThread(new Runnable() { // from class: com.tencent.av.ui.fragment.NTMultiVideoGroupFragment.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ScreenShareCtrl y06 = r.h0().y0();
                        if (y06 != null) {
                            y06.u(NTMultiVideoGroupFragment.this.wh(), j3);
                        }
                    }
                });
            }
        };
        this.X0 = 0;
    }

    public static int Sl(String str, VideoAppInterface videoAppInterface, String str2, boolean z16) {
        if (cp.n() <= 0) {
            return R.string.f171236dd4;
        }
        int size = r.h0().Y().size();
        if (cp.m() <= size) {
            if (e.j()) {
                QLog.w(str, 1, "isFull, \u901a\u8bdd\u6210\u5458\u8d85\u51fa\u4e0a\u9650[" + size + "]");
            }
            return R.string.f171235dd2;
        }
        if (e.j()) {
            QLog.w(str, 1, "isGAudioFull, gAudioMemCount[" + size + "], canAutoInviteMemIntoTroop[" + z16 + "], wording[0]");
        }
        return 0;
    }

    private void Vl(long j3, View view) {
        AVScreenSharePart aVScreenSharePart = this.f75623l0;
        if (aVScreenSharePart != null) {
            aVScreenSharePart.L9(j3, view);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Bi(long j3, View view) {
        AVSmallHomeTipsPart aVSmallHomeTipsPart = this.W;
        if (aVSmallHomeTipsPart != null) {
            aVSmallHomeTipsPart.B9(j3, view);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTMultiVideoBaseFragment
    void Cl(int i3, int i16, String str, String str2) {
        AVNetConnectInfoPart aVNetConnectInfoPart = this.T;
        if (aVNetConnectInfoPart != null) {
            aVNetConnectInfoPart.M9(true, i3, i16, str, str2);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Hk(long j3) {
        AVScreenSharePart aVScreenSharePart = this.f75623l0;
        if (aVScreenSharePart != null) {
            aVScreenSharePart.X9(j3);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTMultiVideoBaseFragment, com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Ii() {
        super.Ii();
        VideoAppInterface videoAppInterface = this.G;
        if (videoAppInterface != null) {
            videoAppInterface.addObserver(this.W0);
            this.G.addObserver(this.V0);
        }
        initUI();
        Zk();
    }

    @Override // com.tencent.av.ui.fragment.NTMultiVideoBaseFragment, com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Ki(long j3) {
        QLog.w(NTBaseVideoFragment.f75610s0, 1, "onDestroy, seq[" + j3 + "]");
        VideoAppInterface videoAppInterface = this.G;
        if (videoAppInterface != null) {
            videoAppInterface.deleteObserver(this.W0);
            this.G.deleteObserver(this.V0);
        }
        super.Ki(j3);
    }

    @Override // com.tencent.av.ui.fragment.NTMultiVideoBaseFragment, com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Ni(int i3) {
        Pk();
        super.Ni(i3);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void Qk(long j3) {
        AVSmallHomeTipsPart aVSmallHomeTipsPart = this.W;
        if (aVSmallHomeTipsPart != null) {
            aVSmallHomeTipsPart.C9();
        }
    }

    void Ql() {
        String[] strArr;
        ArrayList parcelableArrayListExtra;
        long d16 = e.d();
        QLog.w(NTBaseVideoFragment.f75610s0, 1, "createOrEnterVideo, mRelationId[" + this.f75670y0 + "], mIntentRelationId[" + this.f75669x0 + "], mStatusType[" + this.f75666u0 + "], seq[" + d16 + "]");
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
        long[] jArr = null;
        if (intent == null || (parcelableArrayListExtra = intent.getParcelableArrayListExtra("invitelist")) == null || parcelableArrayListExtra.size() <= 0) {
            strArr = null;
        } else {
            int i16 = 0;
            if (n.e().f().f73063p == 17) {
                String[] strArr2 = new String[parcelableArrayListExtra.size()];
                Iterator it = parcelableArrayListExtra.iterator();
                while (it.hasNext()) {
                    strArr2[i16] = ((ResultRecord) it.next()).uin;
                    i16++;
                }
                strArr = strArr2;
            } else {
                long[] jArr2 = new long[parcelableArrayListExtra.size()];
                Iterator it5 = parcelableArrayListExtra.iterator();
                while (it5.hasNext()) {
                    jArr2[i16] = e.v(((ResultRecord) it5.next()).uin);
                    i16++;
                }
                strArr = null;
                jArr = jArr2;
            }
        }
        if (jArr == null) {
            jArr = n.e().f().Q0;
        }
        r.h0().y3(this.f75668w0, this.f75670y0, 0, jArr, this.I0, strArr);
        this.G0 = true;
    }

    public int Rl() {
        return this.X0;
    }

    public void Tl(long j3) {
        com.tencent.av.ui.part.base.panel.a aVar = this.Z;
        if (aVar != null) {
            aVar.D9(j3, true);
        }
        lk(j3, 33554431);
    }

    public void Ul(long j3, View view) {
        b bVar = this.f75614c0;
        if (bVar != null) {
            bVar.C9(j3, view);
        }
        tl();
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public boolean Yh() {
        VideoAppInterface videoAppInterface = this.G;
        return videoAppInterface != null && yt.e.c(videoAppInterface.getCurrentAccountUin());
    }

    @Override // com.tencent.av.ui.fragment.NTMultiVideoBaseFragment
    void Zk() {
        if (QLog.isColorLevel()) {
            QLog.i(NTBaseVideoFragment.f75610s0, 2, "handleExtraData, mStatusType[" + this.f75666u0 + "]");
        }
        int i3 = this.f75666u0;
        if (i3 == 0 || i3 == 1) {
            super.Uk(-1022L, "handleExtraData");
            Ql();
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
        AVToolBarPart aVToolBarPart = new AVToolBarPart(1);
        this.Y = aVToolBarPart;
        assembleParts.add(aVToolBarPart);
        d dVar = new d(this.J);
        this.f75622k0 = dVar;
        assembleParts.add(dVar);
        return assembleParts;
    }

    @Override // com.tencent.av.ui.fragment.NTMultiVideoBaseFragment
    public boolean cl() {
        if (isDestroyed()) {
            return true;
        }
        int Sl = Sl(NTBaseVideoFragment.f75610s0, this.G, this.f75670y0 + "", this.U0);
        this.X0 = Sl;
        return Sl != 0;
    }

    @Override // com.tencent.av.ui.fragment.NTMultiVideoBaseFragment, com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void mi(long j3, View view) {
        super.mi(j3, view);
        WeakReference<Context> weakReference = this.F;
        if (weakReference == null || !(weakReference.get() instanceof AVActivity)) {
            return;
        }
        int id5 = view.getId();
        if (id5 == m.e.f76024k) {
            Vl(j3, view);
            return;
        }
        if (id5 == m.e.f76029p) {
            zi(j3, view);
            return;
        }
        if (id5 == m.e.f76027n) {
            Tl(j3);
        } else if (id5 == m.e.f76020g) {
            Ul(j3, view);
        } else if (id5 == m.e.f76025l) {
            Di(j3, view);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void oj(Boolean bool) {
        Pk();
        super.oj(bool);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
    }

    @Override // com.tencent.av.ui.fragment.NTMultiVideoBaseFragment
    void sl() {
        if (QLog.isDevelopLevel()) {
            QLog.d(NTBaseVideoFragment.f75610s0, 2, "refreshMuteBtnState");
        }
        QavPanel qavPanel = this.J;
        if (qavPanel != null) {
            int i3 = m.l.f76060f;
            if (qavPanel.x(i3) || r.h0() == null) {
                return;
            }
            this.J.setViewEnable(i3, true);
            if (r.h0().X0()) {
                super.gk(i3);
            } else {
                super.fk(i3);
            }
            this.J.D0(r.h0().X0());
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void ti(long j3) {
        com.tencent.av.ui.part.dav.panel.d dVar = this.f75620i0;
        if (dVar != null) {
            dVar.F9(j3);
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void zj(boolean z16, int i3) {
        this.J.J0(z16, i3);
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public boolean zk(long j3) {
        super.zk(j3);
        return yk(j3);
    }

    @Override // com.tencent.av.ui.fragment.NTMultiVideoBaseFragment
    void pl(Intent intent) {
        Object obj;
        if (intent != null) {
            if (intent.hasExtra("enableInvite")) {
                this.U0 = intent.getBooleanExtra("enableInvite", false);
            } else {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.ui.fragment.NTMultiVideoGroupFragment.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (r.h0() == null || NTMultiVideoGroupFragment.this.G == null) {
                            return;
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString("uin", n.e().f().P0 + "");
                        Bundle s06 = NTMultiVideoGroupFragment.this.G.s0(3, 0, 0, bundle, null);
                        e.m(Const.BUNDLE_KEY_REQUEST, bundle);
                        e.m("response", s06);
                        if (s06 != null) {
                            NTMultiVideoGroupFragment.this.U0 = s06.getBoolean("enableInvite", false);
                        }
                    }
                }, 16, null, true);
            }
        }
        if (!QLog.isColorLevel() || r.h0() == null) {
            return;
        }
        String str = NTBaseVideoFragment.f75610s0;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("processExtraData, gaudioStatusType[");
        sb5.append(n.e().f().R0);
        sb5.append("], relationId[");
        sb5.append(n.e().f().P0);
        sb5.append("], isInRoom[");
        sb5.append(r.h0().W0());
        sb5.append("], mGAudioGroupId[");
        sb5.append(r.h0().X());
        sb5.append("], isVideo[");
        sb5.append(this.I0);
        sb5.append("], mCanAutoInviteMemIntoTroop[");
        sb5.append(this.U0);
        sb5.append(" ");
        if (intent != null) {
            obj = Boolean.valueOf(intent.hasExtra("enableInvite"));
        } else {
            obj = "";
        }
        sb5.append(obj);
        sb5.append("]");
        QLog.w(str, 1, sb5.toString());
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public void si(long j3, View view) {
        Ph(true);
        c cVar = this.f75618g0;
        if (cVar != null) {
            cVar.H9(j3);
        }
    }

    public NTMultiVideoGroupFragment(VideoAppInterface videoAppInterface, AVActivity aVActivity, ControlUIObserver controlUIObserver) {
        super(videoAppInterface, aVActivity, controlUIObserver);
        this.U0 = true;
        this.V0 = new a();
        this.W0 = new GAudioUIObserver() { // from class: com.tencent.av.ui.fragment.NTMultiVideoGroupFragment.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.av.app.GAudioUIObserver
            public void L(long j3, boolean z16, int i3) {
                NTMultiVideoGroupFragment.this.lk(0L, 33554431);
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void f(int i3, byte[] bArr) {
                AVScreenSharePart aVScreenSharePart = NTMultiVideoGroupFragment.this.f75623l0;
                if (aVScreenSharePart != null) {
                    aVScreenSharePart.J9(i3, bArr);
                }
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void k(long j3, long j16) {
                if (NTMultiVideoGroupFragment.this.isDestroyed()) {
                    return;
                }
                QLog.w(NTBaseVideoFragment.f75610s0, 1, "onEnterRoomSuc, GroupID[" + j16 + "], seq[" + j3 + "]");
                ap.b(NTMultiVideoGroupFragment.this.I0 ? 4 : 3, r.h0().g0() + "");
                h.f(NTMultiVideoGroupFragment.this.I0 ? 4 : 3, r.h0().g0() + "");
                NTMultiVideoGroupFragment.this.bl();
                NTMultiVideoGroupFragment.this.zl(j3);
                as asVar = NTMultiVideoGroupFragment.this.L;
                if (asVar != null) {
                    asVar.m(true);
                    NTMultiVideoGroupFragment.this.L.n(true);
                    NTMultiVideoGroupFragment.this.L.p();
                }
                VideoAppInterface videoAppInterface2 = NTMultiVideoGroupFragment.this.G;
                if (videoAppInterface2 != null) {
                    videoAppInterface2.M().postDelayed(new AutoCheckVideoRunnable(), 500L);
                }
                NTMultiVideoGroupFragment.super.dl();
                NTMultiVideoGroupFragment.this.lk(j3, 33554431);
                NTMultiVideoGroupFragment.this.El();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.av.app.GAudioUIObserver
            public void w(long j3, long j16, String str) {
                super.w(j3, j16, str);
                if (QLog.isColorLevel()) {
                    QLog.d(NTBaseVideoFragment.f75610s0, 2, "onGroupSecurityLimit-->groupid=" + j3 + " info=" + j16 + " strMsg=" + str);
                }
                if (NTMultiVideoGroupFragment.this.f75668w0 != 1) {
                    return;
                }
                Intent intent = new Intent();
                intent.setAction("tencent.av.v2q.MultiVideo");
                intent.putExtra("type", 33);
                intent.putExtra("relationId", j3);
                intent.putExtra("uinType", NTMultiVideoGroupFragment.this.f75667v0);
                intent.putExtra("info", j16);
                intent.putExtra("strMsg", str);
                intent.putExtra("from", "MultiVideoCtrlLayerUI4NewGroupChat1");
                AVActivity aVActivity2 = (AVActivity) NTMultiVideoGroupFragment.this.F.get();
                if (aVActivity2 != null) {
                    VideoAppInterface videoAppInterface2 = NTMultiVideoGroupFragment.this.G;
                    if (videoAppInterface2 != null) {
                        intent.setPackage(videoAppInterface2.getApplication().getPackageName());
                    }
                    aVActivity2.sendBroadcast(intent);
                    NTMultiVideoGroupFragment.super.Wk(true);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.e(NTBaseVideoFragment.f75610s0, 2, "onGroupSecurityLimit-->can not get the activity");
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.av.app.GAudioUIObserver
            public void x(long j3, long j16, boolean z16) {
                super.x(j3, j16, z16);
                n.e().f().f73037i1 = false;
                if (n.e().f().f73063p == 10) {
                    NTMultiVideoGroupFragment.super.rl();
                }
                boolean z17 = n.e().f().N;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.av.app.GAudioUIObserver
            public void y(long j3, long j16, boolean z16) {
                super.y(j3, j16, z16);
                n.e().f().f73037i1 = true;
                if (n.e().f().f73063p == 10) {
                    NTMultiVideoGroupFragment.super.rl();
                }
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void z(long j3, int i3, int i16) {
                NTMultiVideoGroupFragment.this.al(j3, i3, i16);
            }

            @Override // com.tencent.av.app.GAudioUIObserver
            protected void g(final long j3, long j16) {
                AVActivity aVActivity2;
                if (NTMultiVideoGroupFragment.this.isDestroyed()) {
                    return;
                }
                if (j16 != NTMultiVideoGroupFragment.this.f75670y0) {
                    QLog.i(NTBaseVideoFragment.f75610s0, 1, "onCreateRoomSuc, not right session. [" + j16 + "," + NTMultiVideoGroupFragment.this.f75670y0 + "]");
                    return;
                }
                SessionInfo f16 = n.e().f();
                QLog.w(NTBaseVideoFragment.f75610s0, 1, "onCreateRoomSuc, GroupID[" + j16 + "], seq[" + j3 + "], sessionId[" + f16.f73030h + "]");
                ap.b(NTMultiVideoGroupFragment.this.I0 ? 4 : 3, r.h0().g0() + "");
                h.f(NTMultiVideoGroupFragment.this.I0 ? 4 : 3, r.h0().g0() + "");
                if (f16.H2) {
                    DataReport.T(null, "dc00898", "", f16.f73091w, "0X800C26A", "0X800C26A", 0, 0, "", "", "", r.h0().g0() + "");
                }
                NTMultiVideoGroupFragment.this.bl();
                NTMultiVideoGroupFragment.this.zl(j3);
                as asVar = NTMultiVideoGroupFragment.this.L;
                if (asVar != null) {
                    asVar.m(true);
                    NTMultiVideoGroupFragment.this.L.n(true);
                    NTMultiVideoGroupFragment.this.L.p();
                }
                f16.f73097x1 = true;
                NTMultiVideoGroupFragment nTMultiVideoGroupFragment = NTMultiVideoGroupFragment.this;
                VideoAppInterface videoAppInterface2 = nTMultiVideoGroupFragment.G;
                if (videoAppInterface2 != null) {
                    videoAppInterface2.V(nTMultiVideoGroupFragment.f75670y0);
                }
                if (f16.f73042j2 != 4 || (aVActivity2 = (AVActivity) NTMultiVideoGroupFragment.this.F.get()) == null || aVActivity2.isFinishing()) {
                    return;
                }
                aVActivity2.runOnUiThread(new Runnable() { // from class: com.tencent.av.ui.fragment.NTMultiVideoGroupFragment.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ScreenShareCtrl y06 = r.h0().y0();
                        if (y06 != null) {
                            y06.u(NTMultiVideoGroupFragment.this.wh(), j3);
                        }
                    }
                });
            }
        };
        this.X0 = 0;
        if (QLog.isColorLevel()) {
            QLog.d(NTBaseVideoFragment.f75610s0, 2, "MultiVideoCtrlLayerUI4NewGroupChat --> Create");
        }
    }

    @Override // com.tencent.av.ui.fragment.NTBaseVideoFragment
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            DataReport.K(n.e().f().O, n.e().f().N, 10);
            AVHidePart aVHidePart = this.f75619h0;
            if (aVHidePart != null) {
                aVHidePart.E9();
            }
        } else if (i3 != 24 && i3 != 25) {
            if (QLog.isColorLevel()) {
                QLog.d(NTBaseVideoFragment.f75610s0, 2, "OnKeyDown --> WRONG KeyCode = " + i3);
            }
        } else {
            d dVar = this.f75622k0;
            if (dVar != null) {
                dVar.na();
            }
            return false;
        }
        return false;
    }

    @Override // com.tencent.av.ui.fragment.NTMultiVideoBaseFragment
    public void vl(int i3) {
        boolean z16 = i3 == 5 || i3 == 6;
        boolean z17 = i3 == 7 || i3 == 8;
        if (z16 || z17) {
            Pk();
        }
    }
}
