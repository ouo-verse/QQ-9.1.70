package cw2;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.Nullable;
import bw2.h;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.OpenSdkManager;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.e;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.g;
import com.tencent.qqlive.ona.protocol.jce.AdActionItem;
import com.tencent.qqlive.ona.protocol.jce.AdAndroidMarketInfo;
import com.tencent.qqlive.ona.protocol.jce.AdDownloadItem;
import com.tencent.qqlive.ona.protocol.jce.AdH5UrlItem;
import com.tencent.qqlive.ona.protocol.jce.AdOpenAppItem;
import com.tencent.qqlive.ona.protocol.jce.AdOpenMiniProgramItem;
import com.tencent.qqlive.ona.protocol.jce.AdUrlItem;
import com.tencent.qqlive.ona.protocol.jce.PackageAction;
import pw2.k;
import pw2.m;
import pw2.n;
import pw2.u;
import zv2.b;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c extends com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.b {

    /* renamed from: g, reason: collision with root package name */
    private volatile ew2.c f391991g;

    /* renamed from: h, reason: collision with root package name */
    private Dialog f391992h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d f391993i;

    /* renamed from: j, reason: collision with root package name */
    private Dialog f391994j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f391995k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f391996l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f392001a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f392002b;

        b(g gVar, boolean z16) {
            this.f392001a = gVar;
            this.f392002b = z16;
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.g
        public void a(int i3, String str, int i16) {
            g gVar = this.f392001a;
            if (gVar != null) {
                gVar.a(i3, str, i16);
            }
            c.this.S(this.f392002b, i3, str, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: cw2.c$c, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public class C10143c implements com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.c {
        C10143c() {
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.c
        public void a(boolean z16, int i3) {
            c.this.v(z16);
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.c
        public void b() {
            n.a("QAdOpenAppActionHandler", "doOpenMiniProgramItem, onWillLaunch");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class d implements e {
        d() {
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.c
        public void a(boolean z16, int i3) {
            c.this.v(z16);
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.c
        public void b() {
            n.a("QAdOpenAppActionHandler", "doOpenMiniProgramItemWithDiag, onWillLaunch");
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.e
        public void onCancel() {
            c.this.g(2);
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.e
        public void onConfirm() {
            c.this.g(10001);
            c.this.g(20);
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.e
        public void onShow() {
            n.a("QAdOpenAppActionHandler", "open mini program with dialog show.");
        }
    }

    public c(Context context, wv2.a aVar) {
        super(context, aVar);
        this.f391992h = null;
    }

    private void A(String str, String str2) {
        h(27, this.f391991g);
        h(5, this.f391991g);
        h(29, this.f391991g);
        if (!TextUtils.isEmpty(str)) {
            f(str, str2);
            if (!t(true)) {
                Z();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(String str, boolean z16, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d dVar) {
        if (z16) {
            A(str, dVar.f304051d);
        }
    }

    private void C(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d dVar, g gVar) {
        wv2.a aVar = this.f303963a;
        if (!aVar.f446579o) {
            if (aVar.f446577m) {
                y(dVar, gVar);
            } else {
                T(dVar, true, gVar);
            }
            X(dVar);
            return;
        }
        int i3 = aVar.f446565a.adOpenApp.openFailedAction;
        if (i3 == 1) {
            T(dVar, true, gVar);
        } else if (i3 == 2) {
            y(dVar, gVar);
        }
        X(dVar);
    }

    private void D(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d dVar, g gVar) {
        wv2.a aVar = this.f303963a;
        if (!aVar.f446579o) {
            E(dVar, gVar);
            return;
        }
        int i3 = aVar.f446565a.adOpenApp.openFailedAction;
        if (i3 == 1) {
            E(dVar, gVar);
        } else if (i3 == 2) {
            y(dVar, gVar);
        }
    }

    private void E(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d dVar, g gVar) {
        h(27, this.f391991g);
        h(5, this.f391991g);
        h(29, this.f391991g);
        Z();
        e(dVar, gVar);
        b0(dVar);
    }

    private void F(AdOpenMiniProgramItem adOpenMiniProgramItem, g gVar) {
        OpenSdkManager.INSTANCE.launchMiniProgram(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.a.a(adOpenMiniProgramItem, "MiniProgram"), new C10143c());
    }

    private void G(AdOpenMiniProgramItem adOpenMiniProgramItem, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d dVar, g gVar) {
        n.a("QAdOpenAppActionHandler", "OpenMiniProgramWithDiag : name = " + adOpenMiniProgramItem.appName + " , url = " + adOpenMiniProgramItem.urlItem + " , token = " + adOpenMiniProgramItem.token + " , trace = " + adOpenMiniProgramItem.adTraceData);
        try {
            Dialog W = h.W(this.f303964b, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.a.a(adOpenMiniProgramItem, "MiniProgram"), new d());
            this.f391994j = W;
            if (W != null) {
                g(4);
            }
        } catch (Throwable th5) {
            n.a("QAdOpenAppActionHandler", th5.toString());
        }
    }

    private void H() {
        O();
        wv2.a aVar = this.f303963a;
        if (!aVar.A) {
            u.i(aVar, this.f391993i, true);
            wv2.a aVar2 = this.f303963a;
            if (aVar2 != null && !TextUtils.isEmpty(aVar2.f446588x)) {
                this.f391991g.f397280b = this.f303963a.f446588x;
            }
        }
    }

    private String I() {
        AdActionItem adActionItem;
        AdOpenAppItem adOpenAppItem;
        wv2.a aVar = this.f303963a;
        if (aVar != null && (adActionItem = aVar.f446565a) != null && (adOpenAppItem = adActionItem.adOpenApp) != null) {
            return adOpenAppItem.packageName;
        }
        return "";
    }

    private String J() {
        AdActionItem adActionItem;
        AdOpenAppItem adOpenAppItem;
        PackageAction packageAction;
        wv2.a aVar = this.f303963a;
        if (aVar != null && (adActionItem = aVar.f446565a) != null && (adOpenAppItem = adActionItem.adOpenApp) != null && (packageAction = adOpenAppItem.packageAction) != null) {
            return packageAction.url;
        }
        return "";
    }

    private String K() {
        AdH5UrlItem adH5UrlItem;
        if (this.f303963a.f446568d && this.f391991g != null) {
            return this.f391991g.f397281c;
        }
        AdActionItem adActionItem = this.f303963a.f446565a;
        if (adActionItem != null && (adH5UrlItem = adActionItem.adH5UrlItem) != null && adH5UrlItem.h5UrlValid == 1) {
            return adH5UrlItem.adxSplashH5Url;
        }
        return "";
    }

    private boolean L() {
        wv2.a aVar = this.f303963a;
        if (aVar != null && aVar.f446566b == 4) {
            return true;
        }
        return false;
    }

    private boolean M() {
        return this.f303963a.f446565a.adOpenMiniProgram.disableDialog;
    }

    private void O() {
        if (this.f391991g != null) {
            return;
        }
        int a16 = m.a();
        this.f391991g = new ew2.c();
        this.f391991g.f397282d = a16;
    }

    private boolean P(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d dVar) {
        AdActionItem adActionItem;
        wv2.a aVar = this.f303963a;
        if (aVar != null && (adActionItem = aVar.f446565a) != null && adActionItem.adOpenApp != null) {
            return false;
        }
        return true;
    }

    private void R(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d dVar, g gVar) {
        g(10001);
        this.f391995k = false;
        boolean d16 = uv2.b.d(this.f303964b, J());
        T(dVar, !d16, gVar);
        h(27, this.f391991g);
        if (d16) {
            h(28, this.f391991g);
        } else {
            h(29, this.f391991g);
        }
        Q(d16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(boolean z16, int i3, String str, int i16) {
        n.a("QAdOpenAppActionHandler", "reportWhenNeedParse --> onReportFinish : resultStr = " + str + " , errCode = " + i16 + " , reporterType = " + i3);
        if (i3 == 0 && i16 == 0) {
            if (this.f391991g != null) {
                this.f391991g = ew2.c.a(str, this.f391991g);
            }
            if (this.f391991g != null && this.f391991g.f397279a == 0) {
                B(K(), z16, this.f391993i);
            }
            z();
        }
    }

    private void T(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d dVar, boolean z16, g gVar) {
        if (!t(z16)) {
            U(dVar, z16, false, gVar);
            return;
        }
        h(27, this.f391991g);
        h(29, this.f391991g);
        U(dVar, false, true, gVar);
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.e.i(dVar.f304048a, dVar.b(), gVar);
        if (M()) {
            F(this.f303963a.f446565a.adOpenMiniProgram, gVar);
        } else {
            G(this.f303963a.f446565a.adOpenMiniProgram, dVar, gVar);
        }
    }

    private void U(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d dVar, boolean z16, boolean z17, g gVar) {
        n.a("QAdOpenAppActionHandler", "reportWhenNeedParse isFromMiniApp = " + z17 + " needOpenLandPage = " + z16);
        new zv2.b(this.f303964b, this.f303963a).p(dVar, null, false, new a(z16, dVar, gVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d dVar, boolean z16, g gVar) {
        n.a("QAdOpenAppActionHandler", "reportWhenNeedParse needOpenLandPage = " + z16);
        b(dVar, new b(gVar, z16));
        Y(z16);
    }

    private void Y(boolean z16) {
        wv2.a aVar = this.f303963a;
        if (aVar != null && aVar.f446566b == 110 && z16) {
            h(27, this.f391991g);
            h(5, this.f391991g);
            h(29, this.f391991g);
        }
    }

    private void a0(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d dVar, g gVar) {
        if (dVar == null) {
            return;
        }
        if (P(dVar)) {
            h(27, this.f391991g);
            g(5);
            h(29, this.f391991g);
            wv2.a aVar = this.f303963a;
            if (aVar != null && aVar.f446568d) {
                V(dVar, false, gVar);
                return;
            }
            return;
        }
        if (this.f303963a.f446568d) {
            C(dVar, gVar);
        } else {
            D(dVar, gVar);
        }
    }

    private boolean s(boolean z16, @Nullable com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d dVar) {
        if (mw2.a.d(z16, this.f303963a) && mw2.a.m(dVar, this.f303963a)) {
            return true;
        }
        return false;
    }

    private boolean t(boolean z16) {
        wv2.a aVar;
        AdActionItem adActionItem;
        AdOpenMiniProgramItem adOpenMiniProgramItem;
        AdUrlItem adUrlItem;
        if (z16 && L() && this.f391993i != null && OpenSdkManager.INSTANCE.isWXInstalled() && (aVar = this.f303963a) != null && (adActionItem = aVar.f446565a) != null && (adOpenMiniProgramItem = adActionItem.adOpenMiniProgram) != null && !TextUtils.isEmpty(adOpenMiniProgramItem.appName) && (adUrlItem = this.f303963a.f446565a.adOpenMiniProgram.urlItem) != null && !TextUtils.isEmpty(adUrlItem.url)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z16) {
        if (z16) {
            g(3);
        } else {
            g(1);
            Toast.makeText(this.f303964b, "\u8bf7\u66f4\u65b0\u5fae\u4fe1App\u540e\u4f53\u9a8c", 0).show();
        }
    }

    private void x(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d dVar, g gVar) {
        if (u()) {
            g(10001);
            this.f391995k = false;
            boolean d16 = uv2.b.d(this.f303964b, J());
            Q(d16);
            h(27, this.f391991g);
            if (d16) {
                b(dVar, gVar);
                h(28, this.f391991g);
                return;
            }
            h(29, this.f391991g);
        }
        D(dVar, gVar);
    }

    private void y(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d dVar, g gVar) {
        AdUrlItem adUrlItem;
        String str;
        int i3;
        if (!s(false, dVar)) {
            T(dVar, true, gVar);
            return;
        }
        AdDownloadItem adDownloadItem = new AdDownloadItem();
        wv2.a aVar = this.f303963a;
        AdActionItem adActionItem = aVar.f446565a;
        AdOpenAppItem adOpenAppItem = adActionItem.adOpenApp;
        adDownloadItem.packageName = adOpenAppItem.packageName;
        adDownloadItem.appName = adOpenAppItem.appName;
        AdDownloadItem adDownloadItem2 = adOpenAppItem.downloadItem;
        AdAndroidMarketInfo adAndroidMarketInfo = null;
        if (adDownloadItem2 == null) {
            adUrlItem = null;
        } else {
            adUrlItem = adDownloadItem2.urlItem;
        }
        adDownloadItem.urlItem = adUrlItem;
        if (adDownloadItem2 == null) {
            str = null;
        } else {
            str = adDownloadItem2.appIconUrl;
        }
        adDownloadItem.appIconUrl = str;
        adActionItem.adDownload = adDownloadItem;
        if (aVar.f446568d) {
            i3 = 3;
        } else {
            i3 = 2;
        }
        adDownloadItem.downloadType = i3;
        if (adDownloadItem2 != null) {
            adAndroidMarketInfo = adDownloadItem2.androidMarketInfo;
        }
        adDownloadItem.androidMarketInfo = adAndroidMarketInfo;
        xv2.a aVar2 = new xv2.a(this.f303964b, aVar);
        aVar2.i(this.f303965c);
        aVar2.c(dVar, gVar);
    }

    private void z() {
        if (this.f391991g != null && !TextUtils.isEmpty(this.f391991g.f397280b) && this.f391991g.f397282d != -1) {
            k.a().b(this.f391991g.f397280b, this.f391991g.f397282d);
        }
    }

    protected boolean N(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d dVar) {
        if (dVar != null && mw2.a.p(this.f303963a) && !TextUtils.isEmpty(I())) {
            return true;
        }
        return false;
    }

    protected void Z() {
        if (this.f391996l) {
            return;
        }
        this.f391996l = true;
        h(30, this.f391991g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.b
    public void b(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d dVar, g gVar) {
        if (this.f303963a.f446580p) {
            W();
        } else {
            super.b(dVar, gVar);
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.b
    public void c(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d dVar, g gVar) {
        n.e("QAdOpenAppActionHandler", "doClick");
        this.f391993i = dVar;
        H();
        if (N(dVar)) {
            if (this.f303963a.f446568d) {
                w(dVar, gVar);
                return;
            } else {
                x(dVar, gVar);
                return;
            }
        }
        a0(dVar, gVar);
        Q(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.b
    public void e(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d dVar, g gVar) {
        super.e(dVar, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.b
    public void f(String str, String str2) {
        super.f(str, str2);
    }

    protected boolean u() {
        AdOpenAppItem adOpenAppItem = this.f303963a.f446565a.adOpenApp;
        return uv2.b.a(this.f303964b, new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(adOpenAppItem.packageAction.url)), adOpenAppItem.packageName);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d dVar, g gVar) {
        if (u()) {
            R(dVar, gVar);
        } else {
            C(dVar, gVar);
            Q(false);
        }
    }

    private void W() {
    }

    private void Q(boolean z16) {
    }

    private void X(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d dVar) {
    }

    private void b0(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d dVar) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements b.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f391997a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d f391998b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ g f391999c;

        a(boolean z16, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d dVar, g gVar) {
            this.f391997a = z16;
            this.f391998b = dVar;
            this.f391999c = gVar;
        }

        @Override // zv2.b.c
        public void b() {
            c.this.V(this.f391998b, this.f391997a, this.f391999c);
        }

        @Override // zv2.b.c
        public void c(String str) {
            c.this.B(str, this.f391997a, this.f391998b);
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.g
        public void a(int i3, String str, int i16) {
        }
    }
}
