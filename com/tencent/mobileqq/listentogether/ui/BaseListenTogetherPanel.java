package com.tencent.mobileqq.listentogether.ui;

import android.content.Context;
import android.text.TextUtils;
import android.widget.PopupWindow;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherPlayFragment;
import com.tencent.mobileqq.listentogether.i;
import com.tencent.mobileqq.listentogether.nt.e;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import tr2.g;

/* loaded from: classes33.dex */
public abstract class BaseListenTogetherPanel {

    /* renamed from: a, reason: collision with root package name */
    protected com.tencent.aio.api.runtime.a f241140a;

    /* renamed from: b, reason: collision with root package name */
    protected e f241141b;

    /* renamed from: c, reason: collision with root package name */
    QBaseActivity f241142c;

    /* renamed from: e, reason: collision with root package name */
    PopupWindow f241144e;

    /* renamed from: k, reason: collision with root package name */
    ReportInfo f241150k;

    /* renamed from: d, reason: collision with root package name */
    UiData f241143d = new UiData();

    /* renamed from: f, reason: collision with root package name */
    long f241145f = 0;

    /* renamed from: g, reason: collision with root package name */
    boolean f241146g = false;

    /* renamed from: h, reason: collision with root package name */
    boolean f241147h = false;

    /* renamed from: i, reason: collision with root package name */
    boolean f241148i = true;

    /* renamed from: j, reason: collision with root package name */
    boolean f241149j = false;

    /* renamed from: l, reason: collision with root package name */
    i f241151l = new a();

    /* renamed from: m, reason: collision with root package name */
    com.tencent.mobileqq.avatar.observer.a f241152m = new b();

    /* renamed from: n, reason: collision with root package name */
    com.tencent.mobileqq.listentogether.e f241153n = new c();

    /* loaded from: classes33.dex */
    public static class ReportInfo implements Serializable {
        public String mainAction = "";
        public String reportUin = "";
        public int shenFen;
    }

    /* loaded from: classes33.dex */
    class c extends com.tencent.mobileqq.listentogether.e {
        c() {
        }

        @Override // com.tencent.mobileqq.listentogether.e
        protected void c(int i3, String str) {
            BaseListenTogetherPanel.this.r(i3, str);
        }

        @Override // com.tencent.mobileqq.listentogether.e
        protected void i(int i3, String str, boolean z16) {
            BaseListenTogetherPanel.this.t(i3, str, z16);
        }

        @Override // com.tencent.mobileqq.listentogether.e
        protected void j(int i3, String str, String str2) {
            BaseListenTogetherPanel.this.u(i3, str, str2);
        }

        @Override // com.tencent.mobileqq.listentogether.e
        protected void k(int i3, String str) {
            BaseListenTogetherPanel.this.w(i3, str);
        }

        @Override // com.tencent.mobileqq.listentogether.e
        protected void n(boolean z16, int i3, String str, String str2, int i16, String str3) {
            UiData uiData = BaseListenTogetherPanel.this.f241143d;
            if (i3 == uiData.f241157d && str.equals(uiData.f241158e) && !z16) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = BaseListenTogetherPanel.this.f241142c.getResources().getString(R.string.f1625320o);
                }
                QQToast.makeText(BaseListenTogetherPanel.this.f241142c, str2, 0).show();
            }
        }

        @Override // com.tencent.mobileqq.listentogether.e
        protected void q(String str, int i3, int i16) {
            BaseListenTogetherPanel.this.y(str, i3, i16);
        }

        @Override // com.tencent.mobileqq.listentogether.e
        protected void u(ListenTogetherSession listenTogetherSession) {
            BaseListenTogetherPanel.this.D(listenTogetherSession);
        }

        @Override // com.tencent.mobileqq.listentogether.e
        protected void h(int i3, String str) {
            ListenTogetherManager j3;
            BaseListenTogetherPanel baseListenTogetherPanel;
            UiData uiData;
            int i16;
            BaseListenTogetherPanel baseListenTogetherPanel2 = BaseListenTogetherPanel.this;
            QLog.d("BaseListenTogetherPanel", 1, String.format("onJoinAndEnter [%d,%s] [%d,%s] resumed=[%b] ", Integer.valueOf(i3), str, Integer.valueOf(BaseListenTogetherPanel.this.f241143d.f241157d), baseListenTogetherPanel2.f241143d.f241158e, Boolean.valueOf(baseListenTogetherPanel2.f241147h)));
            BaseListenTogetherPanel baseListenTogetherPanel3 = BaseListenTogetherPanel.this;
            if (baseListenTogetherPanel3.f241147h) {
                UiData uiData2 = baseListenTogetherPanel3.f241143d;
                if (uiData2.f241157d == i3 && uiData2.f241158e.equalsIgnoreCase(str) && (j3 = BaseListenTogetherPanel.this.j()) != null) {
                    ListenTogetherSession Q = j3.Q(i3, str);
                    if (Q != null && (i16 = (uiData = (baseListenTogetherPanel = BaseListenTogetherPanel.this).f241143d).f241159f) != 3) {
                        if (uiData.f241161i != 2) {
                            QQToast.makeText(baseListenTogetherPanel.f241142c, R.string.isc, 0).show();
                            return;
                        } else {
                            if (i16 == 4) {
                                QQToast.makeText(baseListenTogetherPanel.f241142c, R.string.isf, 0).show();
                                return;
                            }
                            MusicInfo c16 = Q.c();
                            BaseListenTogetherPanel baseListenTogetherPanel4 = BaseListenTogetherPanel.this;
                            ListenTogetherPlayFragment.Hh(baseListenTogetherPanel4.f241142c, Q, c16, baseListenTogetherPanel4.f241143d.f241160h, null);
                            return;
                        }
                    }
                    QQToast.makeText(BaseListenTogetherPanel.this.f241142c, R.string.isa, 0).show();
                }
            }
        }
    }

    public BaseListenTogetherPanel(com.tencent.aio.api.runtime.a aVar, Context context) {
        QBaseActivity qBaseActivity;
        if (QLog.isColorLevel()) {
            QLog.d("BaseListenTogetherPanel", 2, "onInstanceCreate");
        }
        this.f241140a = aVar;
        if (context instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) context;
        } else {
            qBaseActivity = QBaseActivity.sTopActivity;
        }
        this.f241142c = qBaseActivity;
        com.tencent.mobileqq.listentogether.ui.a.k().m(m());
    }

    private void H() {
        ListenTogetherManager j3 = j();
        if (j3 != null) {
            j3.A1(this.f241142c, this.f241143d, this.f241150k);
        }
    }

    private void J(ListenTogetherSession listenTogetherSession) {
        if (QLog.isColorLevel()) {
            QLog.i("BaseListenTogetherPanel", 2, "updateCurUiData");
        }
        ListenTogetherSession listenTogetherSession2 = this.f241143d.M;
        MusicInfo c16 = listenTogetherSession2 != null ? listenTogetherSession2.c() : null;
        MusicInfo c17 = listenTogetherSession.c();
        if (c16 == null || c17 == null || c16.f240910d != c17.f240910d) {
            UiData uiData = this.f241143d;
            uiData.E = 0;
            uiData.C = 0L;
            uiData.D = 0L;
            uiData.G = true;
        }
        UiData uiData2 = this.f241143d;
        uiData2.f241159f = listenTogetherSession.f437191i;
        uiData2.f241161i = listenTogetherSession.f437192m;
        uiData2.M = listenTogetherSession;
        uiData2.F = !listenTogetherSession.M;
        uiData2.I = listenTogetherSession.C;
        uiData2.J = listenTogetherSession.D;
        uiData2.f241160h = m();
        this.f241143d.f241162m = c();
        UiData uiData3 = this.f241143d;
        uiData3.K = listenTogetherSession.V;
        uiData3.L = listenTogetherSession.W;
        if (c16 != null) {
            long j3 = c16.D;
            if (j3 >= 0) {
                uiData3.C = j3;
            }
            if (uiData3.D == 0 && c16.G != 0) {
                uiData3.G = true;
            }
            uiData3.D = c16.G * 1000;
        }
        com.tencent.mobileqq.listentogether.ui.a.k().m(this.f241143d.f241160h);
    }

    private boolean e(int i3, String str) {
        boolean z16 = this.f241143d.f241158e.equals(str) && this.f241143d.f241157d == i3;
        if (QLog.isColorLevel()) {
            QLog.d("BaseListenTogetherPanel", 2, "checkTypeAndUin, result=" + z16 + ",type=" + i3 + ",uin=" + str);
        }
        return z16;
    }

    private void f() {
        if (QLog.isColorLevel()) {
            QLog.d("BaseListenTogetherPanel", 2, "destroyUI()");
        }
        PopupWindow popupWindow = this.f241144e;
        if (popupWindow != null) {
            popupWindow.dismiss();
            this.f241144e = null;
        }
        this.f241143d.a();
        this.f241145f = 0L;
        this.f241146g = false;
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ListenTogetherManager j() {
        QQAppInterface f16 = TroopUtils.f();
        if (f16 != null) {
            return ListenTogetherManager.J(f16);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i3, String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("BaseListenTogetherPanel", 2, "onListenTogetherJoinedCountChange");
        }
        if (e(i3, str)) {
            this.f241143d.H = str2;
            C();
            g(this.f241143d);
        }
    }

    public void A() {
        QQAppInterface f16 = TroopUtils.f();
        QBaseActivity qBaseActivity = this.f241142c;
        UiData uiData = this.f241143d;
        d72.b.c(qBaseActivity, f16, uiData.f241157d, uiData.f241158e);
    }

    public abstract void C();

    public void E(e eVar) {
        this.f241141b = eVar;
    }

    public void F() {
        if (!NetworkUtil.isNetworkAvailable(this.f241142c)) {
            QBaseActivity qBaseActivity = this.f241142c;
            QQToast.makeText(qBaseActivity, 1, qBaseActivity.getString(R.string.f171155cp4), 0).show();
        } else {
            ListenTogetherManager j3 = j();
            if (j3 != null) {
                j3.D(this.f241143d, this.f241150k, this.f241151l);
            }
        }
    }

    public boolean I() {
        if (QLog.isColorLevel()) {
            QLog.d("BaseListenTogetherPanel", 2, "showTogetherTip");
        }
        e eVar = this.f241141b;
        if (eVar == null) {
            QLog.i("BaseListenTogetherPanel", 1, "mNTMusicTipBarStatusListener is null");
            return false;
        }
        eVar.a(false);
        return true;
    }

    public abstract boolean c();

    protected void g(UiData uiData) {
        if (QLog.isDebugVersion()) {
            QLog.d("BaseListenTogetherPanel", 4, "freshUI, isListenTogetherTime=" + n() + ",isPanelShow=" + o());
        }
        if (n()) {
            ListenTogetherSession listenTogetherSession = uiData.M;
            int i3 = uiData.f241159f;
            MusicInfo c16 = listenTogetherSession.c();
            int i16 = uiData.f241161i;
            if (i16 == 2) {
                if (i3 == 4) {
                    e eVar = this.f241141b;
                    if (eVar != null) {
                        eVar.b(HardCodeUtil.qqStr(R.string.isf));
                        return;
                    }
                    return;
                }
                if (c16 != null) {
                    e eVar2 = this.f241141b;
                    if (eVar2 != null) {
                        eVar2.b(d72.b.g(c16));
                    }
                } else {
                    e eVar3 = this.f241141b;
                    if (eVar3 != null) {
                        eVar3.b(this.f241142c.getResources().getString(R.string.isf));
                    }
                }
                UiData uiData2 = this.f241143d;
                if (uiData2.G) {
                    uiData2.G = false;
                    return;
                }
                return;
            }
            if (i16 == 1 || i16 == 3) {
                if (i3 == 4) {
                    e eVar4 = this.f241141b;
                    if (eVar4 != null) {
                        eVar4.b(HardCodeUtil.qqStr(R.string.isf));
                        return;
                    }
                    return;
                }
                if (c16 != null) {
                    e eVar5 = this.f241141b;
                    if (eVar5 != null) {
                        eVar5.b(d72.b.g(c16));
                        return;
                    }
                    return;
                }
                e eVar6 = this.f241141b;
                if (eVar6 != null) {
                    eVar6.b(HardCodeUtil.qqStr(R.string.isf));
                }
            }
        }
    }

    public String h(int i3) {
        String str = this.f241143d.J;
        if (str == null) {
            return this.f241142c.getResources().getString(R.string.iru);
        }
        if (TextUtils.isEmpty(str)) {
            return this.f241142c.getResources().getString(R.string.is_);
        }
        return g.f(i3, str) + this.f241142c.getResources().getString(R.string.isr);
    }

    public String i() {
        ListenTogetherSession listenTogetherSession;
        UiData uiData = this.f241143d;
        if (uiData == null || (listenTogetherSession = uiData.M) == null || TextUtils.isEmpty(listenTogetherSession.N)) {
            return "";
        }
        return listenTogetherSession.N;
    }

    public boolean l() {
        if (QLog.isColorLevel()) {
            QLog.d("BaseListenTogetherPanel", 2, "dismissTogetherTip");
        }
        e eVar = this.f241141b;
        if (eVar == null) {
            QLog.i("BaseListenTogetherPanel", 1, "mNTMusicTipBarStatusListener is null");
            return false;
        }
        eVar.onHide(false);
        return true;
    }

    public abstract boolean m();

    public boolean n() {
        UiData uiData = this.f241143d;
        int i3 = uiData.f241159f;
        return (i3 == 0 || i3 == 3 || uiData.M == null) ? false : true;
    }

    public boolean o() {
        e eVar = this.f241141b;
        if (eVar != null) {
            return eVar.c();
        }
        return false;
    }

    public void p() {
        if (QLog.isColorLevel()) {
            QLog.d("BaseListenTogetherPanel", 2, "onCreate()");
        }
        QQAppInterface f16 = TroopUtils.f();
        if (f16 == null) {
            return;
        }
        f16.addObserver(this.f241153n);
        f16.addObserver(this.f241152m);
    }

    public void q() {
        if (QLog.isColorLevel()) {
            QLog.d("BaseListenTogetherPanel", 2, "onDestroy()");
        }
        QQAppInterface f16 = TroopUtils.f();
        if (f16 != null) {
            f16.removeObserver(this.f241153n);
        }
        ListenTogetherManager j3 = j();
        if (j3 != null) {
            UiData uiData = this.f241143d;
            j3.T0(uiData.f241157d, uiData.f241158e, this.f241140a.hashCode());
        }
        if (f16 != null) {
            f16.removeObserver(this.f241152m);
        }
        f();
        e eVar = this.f241141b;
        if (eVar != null) {
            eVar.onHide(true);
            this.f241141b = null;
        }
    }

    public void r(int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("BaseListenTogetherPanel", 2, "onExitListenTogetherFail");
        }
        if (e(i3, str)) {
            QQToast.makeText(this.f241142c, HardCodeUtil.qqStr(R.string.jyl), 1).show();
        }
    }

    public void s() {
        QQAppInterface f16 = TroopUtils.f();
        UiData uiData = this.f241143d;
        ListenTogetherManager.M0(f16, uiData.f241157d, uiData.f241158e, this.f241140a.hashCode());
    }

    public void t(int i3, String str, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("BaseListenTogetherPanel", 2, "onJoinListenTogetherFail");
        }
        if (e(i3, str)) {
            QQToast.makeText(this.f241142c, HardCodeUtil.qqStr(R.string.jyk), 1).show();
            UiData uiData = this.f241143d;
            uiData.f241161i = 1;
            g(uiData);
        }
    }

    public void v() {
        int i3 = this.f241143d.f241161i;
        if (i3 == 2) {
            F();
        } else if (i3 == 1 || i3 == 3) {
            H();
        }
    }

    protected void w(int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("BaseListenTogetherPanel", 2, "onLyricModuleCloseByFloat");
        }
    }

    protected void y(String str, int i3, int i16) {
        MusicInfo c16;
        if (n()) {
            UiData uiData = this.f241143d;
            if (uiData.f241161i == 2 && (c16 = uiData.M.c()) != null && TextUtils.equals(str, c16.f240910d)) {
                try {
                    UiData uiData2 = this.f241143d;
                    if (uiData2.E > 97 && i3 < 0) {
                        i3 = i16;
                    }
                    uiData2.C = i3;
                    uiData2.D = i16;
                    uiData2.E = (int) (((i3 * 1.0f) / i16) * 100.0f);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("BaseListenTogetherPanel", 2, "onPlayProgressChange, exception:", e16);
                    }
                }
            }
        }
    }

    public void B() {
        String str;
        this.f241147h = false;
        if (QLog.isColorLevel()) {
            QLog.d("BaseListenTogetherPanel", 2, "onStop()");
        }
        this.f241146g = false;
        if (n()) {
            String str2 = this.f241150k.mainAction;
            if (o()) {
                str = "clk_expand";
            } else {
                str = "clk_fold";
            }
            ReportController.o(null, "dc00899", str2, "", "music_tab", str, 0, 0, this.f241150k.reportUin, "", this.f241150k.shenFen + "", "");
        }
    }

    public void x() {
        this.f241147h = false;
        if (QLog.isColorLevel()) {
            QLog.d("BaseListenTogetherPanel", 2, "onPause()");
        }
        ListenTogetherManager j3 = j();
        if (j3 != null) {
            UiData uiData = this.f241143d;
            j3.X0(uiData.f241157d, uiData.f241158e, this.f241140a.hashCode());
        }
    }

    public void z() {
        this.f241147h = true;
        if (QLog.isColorLevel()) {
            QLog.d("BaseListenTogetherPanel", 2, "onResume()");
        }
        this.f241146g = false;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel.4
            @Override // java.lang.Runnable
            public void run() {
                ListenTogetherManager j3 = BaseListenTogetherPanel.this.j();
                if (j3 != null) {
                    BaseListenTogetherPanel baseListenTogetherPanel = BaseListenTogetherPanel.this;
                    UiData uiData = baseListenTogetherPanel.f241143d;
                    j3.U0(uiData.f241157d, uiData.f241158e, baseListenTogetherPanel.f241140a.hashCode());
                }
            }
        }, 32, null, true);
    }

    private boolean d(ListenTogetherSession listenTogetherSession) {
        return listenTogetherSession != null && listenTogetherSession.f437189f.equals(this.f241143d.f241158e) && listenTogetherSession.f437188e == this.f241143d.f241157d;
    }

    public void D(ListenTogetherSession listenTogetherSession) {
        String str;
        if (!d(listenTogetherSession)) {
            if (QLog.isColorLevel()) {
                QLog.d("BaseListenTogetherPanel", 2, "onUIModuleNeedRefresh, checkSession is false");
                return;
            }
            return;
        }
        J(listenTogetherSession);
        if (QLog.isColorLevel()) {
            QLog.d("BaseListenTogetherPanel", 2, "onUIModuleNeedRefresh, uidata=" + this.f241143d);
        }
        if (this.f241143d.f241159f == 3) {
            if (n()) {
                String str2 = this.f241150k.mainAction;
                if (o()) {
                    str = "clk_expand";
                } else {
                    str = "clk_fold";
                }
                ReportController.o(null, "dc00899", str2, "", "music_tab", str, 0, 0, this.f241150k.reportUin, "", this.f241150k.shenFen + "", "");
            }
            ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A5BD", 0, 0, "", "", "", "");
            l();
            return;
        }
        com.tencent.mobileqq.listentogether.ui.a.k().m(m());
        boolean z16 = this.f241143d.F;
        if (o() != z16) {
            if (z16) {
                I();
            } else {
                l();
            }
        }
        g(this.f241143d);
        C();
        if (!z16 || this.f241149j || this.f241148i) {
            return;
        }
        this.f241149j = true;
        G();
    }

    /* loaded from: classes33.dex */
    class a implements i {
        a() {
        }

        @Override // com.tencent.mobileqq.listentogether.i
        public void a(boolean z16) {
            String str;
            ListenTogetherManager j3 = BaseListenTogetherPanel.this.j();
            if (j3 != null) {
                UiData uiData = BaseListenTogetherPanel.this.f241143d;
                j3.Y0(uiData.f241157d, uiData.f241158e, z16);
            }
            ReportInfo reportInfo = BaseListenTogetherPanel.this.f241150k;
            String str2 = reportInfo.mainAction;
            String str3 = reportInfo.reportUin;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(BaseListenTogetherPanel.this.f241150k.shenFen);
            String str4 = "";
            sb5.append("");
            ReportController.o(null, "dc00899", str2, "", "music_tab", "clk_quit", 0, 0, str3, "", sb5.toString(), "");
            QQAppInterface f16 = TroopUtils.f();
            if (f16 != null) {
                str4 = f16.getCurrentAccountUin();
            }
            if (str4 == null || !str4.equalsIgnoreCase(BaseListenTogetherPanel.this.f241143d.I)) {
                return;
            }
            ReportInfo reportInfo2 = BaseListenTogetherPanel.this.f241150k;
            String str5 = reportInfo2.mainAction;
            String str6 = reportInfo2.reportUin;
            if (z16) {
                str = "1";
            } else {
                str = "0";
            }
            ReportController.o(null, "dc00899", str5, "", "music_tab", "clk_quit_opener", 0, 0, str6, "", str, "");
        }

        @Override // com.tencent.mobileqq.listentogether.i
        public void onCancel() {
        }
    }

    /* loaded from: classes33.dex */
    class b extends com.tencent.mobileqq.avatar.observer.a {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onUpdateCustomHead(boolean z16, String str) {
            if (z16 && str != null && str.equalsIgnoreCase(BaseListenTogetherPanel.this.f241143d.I)) {
                BaseListenTogetherPanel baseListenTogetherPanel = BaseListenTogetherPanel.this;
                baseListenTogetherPanel.g(baseListenTogetherPanel.f241143d);
            }
        }
    }

    public String k(boolean z16) {
        String str;
        if (HardCodeUtil.qqStr(R.string.isg).equals(this.f241143d.H)) {
            str = h(16);
        } else {
            str = this.f241143d.H;
        }
        return z16 ? HardCodeUtil.qqStr(R.string.isv) : str;
    }

    protected void G() {
    }
}
