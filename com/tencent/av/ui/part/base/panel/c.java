package com.tencent.av.ui.part.base.panel;

import android.view.View;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.MagicDataReport;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.ap;
import com.tencent.av.ui.m;
import com.tencent.av.ui.s;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.QQFrameByFrameAnimation;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.al;
import com.tencent.av.zplan.QAVControllerForZplan;
import com.tencent.avcore.rtc.node.report.data.NodeModel$NodeEndReason;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import fu.a;
import mw.j;
import mw.k;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c extends e {
    private int C;

    /* renamed from: h, reason: collision with root package name */
    private boolean f76353h;

    /* renamed from: i, reason: collision with root package name */
    private QQFrameByFrameAnimation f76354i;

    /* renamed from: m, reason: collision with root package name */
    private s f76355m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements s.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f76356a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f76357b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ s.e f76358c;

        a(long j3, String str, s.e eVar) {
            this.f76356a = j3;
            this.f76357b = str;
            this.f76358c = eVar;
        }

        @Override // com.tencent.av.ui.s.e
        public void a() {
            SessionInfo f16 = n.e().f();
            TraeHelper.I().k0(this.f76356a);
            f16.H = false;
            if (f16.A0 == -1) {
                f16.A0 = 0;
            }
            f16.X = true;
            DataReport.y();
            if (f16.z() && f16.f73035i == 2 && !f16.N) {
                DataReport.a0();
            }
            AVCoreLog.printColorLog(c.this.f76368d, "DataReport onClose: ");
            VideoAppInterface b16 = nw.b.b();
            EffectPendantTools.a.c(c.this.f76368d, b16);
            a.C10338a.d(b16);
            com.tencent.av.ui.effect.toolbar.a.a(b16.getCurrentAccountUin());
            ap.a(f16);
            String str = f16.b() + "";
            r.h0().r(this.f76357b, 237);
            r.h0().j2(237);
            MagicDataReport.i(b16, str);
            MagicDataReport.m(2, str);
            MagicDataReport.l(2);
            r.h0().q(this.f76357b, f16.A0);
            f16.d0("onClick_HangeUP", false);
            f16.q0("onClick_HangeUP", 0);
            c.this.f76353h = false;
            this.f76358c.a();
        }

        @Override // com.tencent.av.ui.s.e
        public void b() {
            c.this.f76353h = true;
            c.this.I9();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements s.e {
        b() {
        }

        @Override // com.tencent.av.ui.s.e
        public void a() {
            c.this.f76353h = false;
        }

        @Override // com.tencent.av.ui.s.e
        public void b() {
            c.this.f76353h = true;
            c.this.I9();
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class d implements s.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f76362a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f76363b;

        d(long j3, boolean z16) {
            this.f76362a = j3;
            this.f76363b = z16;
        }

        @Override // com.tencent.av.ui.s.e
        public void a() {
            ((k) RFWIocAbilityProvider.g().getIocInterface(k.class, c.this.getPartRootView(), null)).j(true, this.f76362a);
            c.this.J9(this.f76363b);
            c.this.f76353h = false;
        }

        @Override // com.tencent.av.ui.s.e
        public void b() {
            c.this.f76353h = true;
            c.this.I9();
        }
    }

    public c(QavPanel qavPanel) {
        super(qavPanel);
        this.f76353h = false;
        this.f76354i = null;
        this.C = 0;
    }

    private void K9() {
        if (this.f76354i != null) {
            return;
        }
        QQFrameByFrameAnimation qQFrameByFrameAnimation = new QQFrameByFrameAnimation();
        this.f76354i = qQFrameByFrameAnimation;
        qQFrameByFrameAnimation.c(100);
        this.f76354i.d(8);
        this.f76354i.e(new int[]{R.drawable.d_d, R.drawable.d_e});
        this.f76354i.b(new C0767c());
    }

    public void E9(long j3, View view, s.e eVar) {
        QLog.w(this.f76368d, 1, "onClick_Hangup, seq[" + j3 + "]");
        if (view.getId() == m.l.f76073s) {
            AVCoreLog.printAllUserLog(this.f76368d, "exit when click bottom bar hangup");
        }
        if (r.h0() == null) {
            QLog.e(this.f76368d, 1, "onClickHangup video controller is null");
            return;
        }
        String str = n.e().f().f73091w;
        if (n.e().f().I2) {
            QAVControllerForZplan.p().y(n.e().f().G, str);
        }
        SessionInfo f16 = n.e().f();
        if (f16.K() && !f16.G) {
            String r16 = f16.r("onClick_Hangup");
            com.tencent.avcore.rtc.node.report.utils.b.m(r16, f16.W);
            com.tencent.avcore.rtc.node.report.utils.b.i(r16, 5, NodeModel$NodeEndReason.K_INTERRUPTION.ordinal());
        }
        s sVar = this.f76355m;
        if (sVar == null) {
            return;
        }
        sVar.d(new a(j3, str, eVar));
    }

    public void F9() {
        K9();
        QavPanel qavPanel = this.f76370f;
        if (qavPanel != null) {
            qavPanel.W0(this.f76354i);
        }
    }

    public void G9() {
        mw.d dVar = (mw.d) RFWIocAbilityProvider.g().getIocInterface(mw.d.class, getPartRootView(), null);
        if (dVar != null) {
            dVar.o7(true);
        }
        s sVar = this.f76355m;
        if (sVar != null) {
            sVar.d(new b());
        }
    }

    public void H9(long j3) {
        int i3;
        SessionInfo f16 = n.e().f();
        ap.a(f16);
        if (f16.f73035i == 4) {
            com.tencent.mobileqq.statistics.h.c(nw.b.b());
        }
        if (f16.I2) {
            QAVControllerForZplan.p().x();
        }
        boolean z16 = f16.F() && ((i3 = f16.f73063p) == 10 || i3 == 17);
        if (this.f76355m != null) {
            if (r.h0().W0()) {
                r.h0().a2(r.h0().b0(), r.h0().X(), 100);
            } else {
                r.h0().a2(f16.S0, f16.P0, 101);
            }
            this.f76355m.d(new d(j3, z16));
            return;
        }
        ((k) RFWIocAbilityProvider.g().getIocInterface(k.class, getPartRootView(), null)).j(false, j3);
        if (r.h0().W0()) {
            r.h0().a2(r.h0().b0(), r.h0().X(), 102);
        } else {
            r.h0().a2(f16.S0, f16.P0, 103);
        }
        J9(z16);
    }

    public void I9() {
        QavPanel qavPanel;
        AVActivity aVActivity = (AVActivity) getActivity();
        if (aVActivity == null || aVActivity.isDestroyed() || (qavPanel = this.f76370f) == null) {
            return;
        }
        qavPanel.setViewEnable(m.l.f76080z, false);
        this.f76370f.setViewEnable(m.l.f76073s, false);
        this.f76370f.setViewEnable(m.l.f76074t, false);
    }

    public void L9(s sVar) {
        this.f76355m = sVar;
    }

    public void M9(int i3) {
        this.C = i3;
    }

    @Override // com.tencent.av.ui.part.base.panel.e
    public void onDestroy() {
        super.onDestroy();
        this.f76355m = null;
        this.f76354i = null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J9(boolean z16) {
        String str;
        String str2;
        String str3;
        if (z16) {
            str = "0X800592D";
        } else {
            str = "0X8004CF2";
        }
        String str4 = str;
        ReportController.o(null, "CliOper", "", "", str4, str4, 0, 0, "", "", "", "");
        int i3 = this.C;
        if ((i3 == 90 || i3 == 270) && n.e().f().o() != -1 && n.e().f().f73045k1.get(0).f73828b == 1) {
            if (z16) {
                str2 = "0X800594D";
            } else {
                str2 = "0X8004CFB";
            }
            String str5 = str2;
            ReportController.o(null, "CliOper", "", "", str5, str5, 0, 0, "", "", "", "");
            return;
        }
        int i16 = this.C;
        if ((i16 == 90 || i16 == 270) && n.e().f().o() != -1 && n.e().f().f73045k1.get(0).f73828b == 2) {
            if (z16) {
                str3 = "0X800594E";
            } else {
                str3 = "0X8004CFC";
            }
            String str6 = str3;
            ReportController.o(null, "CliOper", "", "", str6, str6, 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.av.ui.part.base.panel.c$c, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public class C0767c extends al {
        C0767c() {
        }

        @Override // com.tencent.av.utils.al
        public void b() {
            c.this.G9();
        }

        @Override // com.tencent.av.utils.al
        public void d() {
            ((j) RFWIocAbilityProvider.g().getIocInterface(j.class, c.this.getPartRootView(), null)).displayToolBar();
            if ("GT-I9100G".equals(DeviceInfoMonitor.getModel())) {
                if (QLog.isColorLevel()) {
                    QLog.d(c.this.f76368d, 2, "Model is 9100G, don't do animation");
                    return;
                }
                return;
            }
            ((mw.e) RFWIocAbilityProvider.g().getIocInterface(mw.e.class, c.this.getPartRootView(), null)).g1();
        }

        @Override // com.tencent.av.utils.al
        public void a() {
        }

        @Override // com.tencent.av.utils.al
        public void c() {
        }
    }
}
