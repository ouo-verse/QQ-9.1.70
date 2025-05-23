package dw2;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADLandingPageInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.QAdH5ReportInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.b;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.e;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.g;
import com.tencent.qqlive.ona.protocol.jce.AdActionItem;
import com.tencent.qqlive.ona.protocol.jce.AdH5UrlItem;
import java.util.Map;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends b {

    /* renamed from: g, reason: collision with root package name */
    private static volatile boolean f395104g = false;

    public a(Context context, wv2.a aVar) {
        super(context, aVar);
    }

    private String m() {
        AdH5UrlItem adH5UrlItem = this.f303963a.f446565a.adH5UrlItem;
        if (adH5UrlItem != null) {
            return adH5UrlItem.adxSplashH5Url;
        }
        return "";
    }

    private String n(d dVar, g gVar) {
        if (q()) {
            b(dVar, gVar);
            return m();
        }
        wv2.a aVar = this.f303963a;
        if (aVar != null && aVar.f446589y) {
            e.g(dVar, gVar);
        }
        if (dVar.r() && !TextUtils.isEmpty(dVar.i())) {
            return dVar.i();
        }
        return dVar.q();
    }

    private int o() {
        int i3 = 1;
        if (this.f303963a.f446565a == null || f395104g) {
            return 1;
        }
        wv2.a aVar = this.f303963a;
        AdH5UrlItem adH5UrlItem = aVar.f446565a.adH5UrlItem;
        if (adH5UrlItem != null) {
            i3 = adH5UrlItem.webviewType;
        }
        if (adH5UrlItem == null && aVar.f446568d) {
            return 2;
        }
        return i3;
    }

    private int p() {
        return 2;
    }

    private boolean q() {
        AdH5UrlItem adH5UrlItem;
        AdActionItem adActionItem = this.f303963a.f446565a;
        if (adActionItem != null && (adH5UrlItem = adActionItem.adH5UrlItem) != null && adH5UrlItem.h5UrlValid == 1) {
            return true;
        }
        return false;
    }

    private boolean r(d dVar) {
        if (this.f303963a != null && dVar != null) {
            if (q()) {
                return !TextUtils.isEmpty(this.f303963a.f446565a.adH5UrlItem.adxSplashH5Url);
            }
            return !TextUtils.isEmpty(dVar.q());
        }
        return false;
    }

    private boolean t(String str, String str2, String str3, Map<String, String> map) {
        n.e("QADWebActionHandler", "openLandPageByApp, url = " + str);
        g(18);
        w();
        try {
            QAdH5ReportInfo u16 = new QAdH5ReportInfo.a().t(this.f303963a.f446571g).q(this.f303963a.f446569e).o(this.f303963a.f446567c).p("").r(str2).s(str3).n(map).x(this.f303963a.E).v(this.f303963a.f446573i).w(this.f303963a.f446575k).A(o()).z(this.f303963a.F).y(this.f303963a.I).u();
            QADLandingPageInfo qADLandingPageInfo = new QADLandingPageInfo();
            qADLandingPageInfo.setFrom(d().f446570f);
            qADLandingPageInfo.setQAdH5ReportInfo(u16);
            qADLandingPageInfo.setUrl(str);
            qADLandingPageInfo.setDownloadItem(mw2.a.f(this.f303963a));
            ev2.g.a(this.f303964b, qADLandingPageInfo);
            return true;
        } catch (Throwable unused) {
            y();
            n.b("QADWebActionHandler", "startActivity error");
            return false;
        }
    }

    private void u(d dVar, String str) {
        x(s(str, dVar.f304051d, dVar.f304052e, this.f303967e));
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean v(String str, String str2, String str3, Map<String, String> map) {
        boolean t16;
        if (p() == 1) {
            n.e("QADWebActionHandler", "adReportKey = " + str2 + " adReportParams = " + str3);
        } else if (p() == 2) {
            t16 = t(str, str2, str3, map);
            if (!t16) {
                y();
            }
            return t16;
        }
        t16 = false;
        if (!t16) {
        }
        return t16;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.b
    public void c(d dVar, g gVar) {
        n.e("QADWebActionHandler", "doClick");
        if (!r(dVar)) {
            g(15);
            return;
        }
        g(10001);
        u(dVar, n(dVar, gVar));
        a(dVar);
    }

    public boolean l(String str, String str2) {
        if (this.f303963a != null && !TextUtils.isEmpty(str)) {
            g(10001);
            boolean s16 = s(str, str2, "", this.f303967e);
            if (s16) {
                g(14);
            } else {
                g(15);
            }
            return s16;
        }
        g(15);
        return false;
    }

    @RequiresApi(api = 14)
    protected boolean s(String str, String str2, String str3, Map<String, String> map) {
        n.e("QADWebActionHandler", "openLandPage url = " + str);
        return v(str, str2, str3, map);
    }

    public void x(boolean z16) {
        if (z16) {
            g(14);
        } else {
            g(15);
        }
    }

    @RequiresApi(api = 14)
    private void w() {
    }

    private void y() {
    }
}
