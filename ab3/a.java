package ab3;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.ad.tangram.AdClickLocationParams;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.statistics.AdReporterForClick;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class a {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: ab3.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public static class C0025a {

        /* renamed from: a, reason: collision with root package name */
        public GdtAd f25776a;

        /* renamed from: c, reason: collision with root package name */
        public HashMap<String, Object> f25778c;

        /* renamed from: b, reason: collision with root package name */
        public int f25777b = Integer.MIN_VALUE;

        /* renamed from: d, reason: collision with root package name */
        public int f25779d = Integer.MIN_VALUE;

        /* renamed from: e, reason: collision with root package name */
        public AdClickLocationParams f25780e = null;

        /* renamed from: f, reason: collision with root package name */
        long f25781f = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;

        C0025a() {
        }

        public boolean a() {
            GdtAd gdtAd = this.f25776a;
            boolean z16 = (gdtAd == null || !gdtAd.isValid() || TextUtils.isEmpty(this.f25776a.getTraceId()) || TextUtils.isEmpty(this.f25776a.getUrlForEffect()) || TextUtils.isEmpty(this.f25776a.getUrlForAction()) || TextUtils.isEmpty(this.f25776a.getUrlForImpression()) || TextUtils.isEmpty(this.f25776a.getUrlForClick(this.f25780e))) ? false : true;
            int i3 = this.f25777b;
            boolean z17 = i3 == Integer.MIN_VALUE || i3 >= 0;
            boolean z18 = this.f25779d != Integer.MIN_VALUE;
            AdClickLocationParams adClickLocationParams = this.f25780e;
            return z16 && z17 && z18 && (adClickLocationParams == null || adClickLocationParams.isValid(this.f25776a));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class b extends C0025a {

        /* renamed from: g, reason: collision with root package name */
        public WeakReference<Activity> f25782g;

        @Override // ab3.a.C0025a
        public boolean a() {
            WeakReference<Activity> weakReference;
            return (!super.a() || (weakReference = this.f25782g) == null || weakReference.get() == null) ? false : true;
        }

        public String toString() {
            GdtAd gdtAd = this.f25776a;
            String posId = gdtAd != null ? gdtAd.getPosId() : null;
            GdtAd gdtAd2 = this.f25776a;
            long aId = gdtAd2 != null ? gdtAd2.getAId() : WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            GdtAd gdtAd3 = this.f25776a;
            String traceId = gdtAd3 != null ? gdtAd3.getTraceId() : null;
            WeakReference<Activity> weakReference = this.f25782g;
            return "WxMiniGameCenterAdClickHandler.Params(posId=" + posId + ", aid=" + aId + ", traceId=" + traceId + ", slot=" + this.f25777b + ", wxMiniExtraData=" + this.f25778c + ", wxMiniHostScene=" + this.f25779d + ", clickLocationParams=" + this.f25780e + ", clickStartTimeMillis=" + this.f25781f + ", activity=" + (weakReference != null ? weakReference.get() : null) + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final AdError f25783a;

        /* renamed from: b, reason: collision with root package name */
        private final int f25784b;

        public c(int i3, int i16) {
            this.f25783a = new AdError(i3);
            this.f25784b = i16;
        }

        public int a() {
            return this.f25784b;
        }

        public int b() {
            AdError adError = this.f25783a;
            if (adError != null) {
                return adError.getErrorCode();
            }
            return 1;
        }

        public boolean c() {
            AdError adError = this.f25783a;
            return adError != null && adError.isSuccess();
        }

        public String toString() {
            return "WxMiniGameCenterAdClickHandler.Result(errorCode=" + b() + ",action=" + this.f25784b + ",)";
        }
    }

    private static void a(b bVar, c cVar) {
        WeakReference<Activity> weakReference;
        if (cVar != null && cVar.c()) {
            ab3.b.d("WxMiniGameCenterAdClickHandler", "[afterClick] params:" + bVar + " result:" + cVar, 200001L, bVar, cVar);
        } else {
            ab3.b.b("WxMiniGameCenterAdClickHandler", "[afterClick] error, params:" + bVar + " result:" + cVar, 200002L, bVar, cVar);
        }
        AdReporterForClick.reportAsync(new WeakReference((bVar == null || (weakReference = bVar.f25782g) == null) ? null : weakReference.get()), bVar != null ? bVar.f25776a : null, d(bVar), bVar != null ? bVar.f25781f : WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, 1);
    }

    private static void b(b bVar) {
        ab3.b.c("WxMiniGameCenterAdClickHandler", "[beforeClick] params:" + bVar, 200000L, bVar);
    }

    public static void e(b bVar) {
        QLog.i("WxMiniGameCenterAdClickHandler", 1, "[handle] start, params:" + bVar);
        c(bVar);
        b(bVar);
        c f16 = f(bVar);
        a(bVar, f16);
        QLog.i("WxMiniGameCenterAdClickHandler", 1, "[handle] end, params:" + bVar + " result:" + f16);
    }

    private static c f(b bVar) {
        if (!(MobileQQ.sProcessId == 1)) {
            QLog.e("WxMiniGameCenterAdClickHandler", 1, "[handleImpl] error, not on main process, params:" + bVar);
            return new c(20, 0);
        }
        if (bVar != null && bVar.a()) {
            QLog.i("WxMiniGameCenterAdClickHandler", 1, "[handleImpl] params:" + bVar);
            if (bVar.f25776a.isWXMINIGameProductType()) {
                return g(bVar);
            }
            QLog.e("WxMiniGameCenterAdClickHandler", 1, "[handleImpl] error, unknown ad, params:" + bVar);
            return new c(4, 0);
        }
        QLog.e("WxMiniGameCenterAdClickHandler", 1, "[handleImpl] error, not valid, params:" + bVar);
        return new c(4, 0);
    }

    private static String h(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            if (!str.contains(str2)) {
                QLog.e("WxMiniGameCenterAdClickHandler", 1, "[replaceUrlWithMacro] do nothing, url do not contain macro, macro:" + str2 + " value:" + str3 + " url:" + str);
                return str;
            }
            String replaceAll = str.replaceAll(str2, str3);
            if (TextUtils.isEmpty(replaceAll)) {
                QLog.i("WxMiniGameCenterAdClickHandler", 1, "[replaceUrlWithMacro] error, newUrl is empty, macro:" + str2 + " value:" + str3 + " url:" + str);
                return str;
            }
            QLog.i("WxMiniGameCenterAdClickHandler", 1, "[replaceUrlWithMacro] macro:" + str2 + " value:" + str3 + " newUrl:" + str + " url:" + str);
            return replaceAll;
        }
        QLog.e("WxMiniGameCenterAdClickHandler", 1, "[replaceUrlWithMacro] do nothing, macro:" + str2 + " value:" + str3 + " url:" + str);
        return str;
    }

    private static void c(b bVar) {
        if (bVar == null) {
            QLog.e("WxMiniGameCenterAdClickHandler", 1, "[fillParams] error, params is null");
            return;
        }
        bVar.f25781f = System.currentTimeMillis();
        QLog.i("WxMiniGameCenterAdClickHandler", 1, "[fillParams] params:" + bVar);
    }

    private static c g(b bVar) {
        if (bVar != null && bVar.a() && bVar.f25776a.isWXMINIProgramOrWXMINIGameProductType()) {
            String wXMINIProgramUserName = bVar.f25776a.getWXMINIProgramUserName(bVar.f25780e);
            String wXMINIProgramPath = bVar.f25776a.getWXMINIProgramPath(bVar.f25780e);
            if (!TextUtils.isEmpty(wXMINIProgramUserName) && !TextUtils.isEmpty(wXMINIProgramPath)) {
                QLog.i("WxMiniGameCenterAdClickHandler", 1, "[handleWXMINIGameProductType] params:" + bVar + " username:" + wXMINIProgramUserName + " path:" + wXMINIProgramPath);
                try {
                    ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByUsername(bVar.f25782g.get(), wXMINIProgramUserName, wXMINIProgramPath, bVar.f25779d, bVar.f25778c);
                    return new c(0, 9);
                } catch (Throwable th5) {
                    QLog.e("WxMiniGameCenterAdClickHandler", 1, "[handleWXMINIGameProductType] error, params:" + bVar + " username:" + wXMINIProgramUserName + " path:" + wXMINIProgramPath, th5);
                    return new c(15, 9);
                }
            }
            QLog.e("WxMiniGameCenterAdClickHandler", 1, "[handleWXMINIGameProductType] error, not valid, params:" + bVar + " username:" + wXMINIProgramUserName + " path:" + wXMINIProgramPath);
            return new c(4, 9);
        }
        QLog.e("WxMiniGameCenterAdClickHandler", 1, "[handleWXMINIGameProductType] error, not valid, params:" + bVar);
        return new c(4, 9);
    }

    private static String d(b bVar) {
        GdtAd gdtAd;
        String str = null;
        AdClickLocationParams adClickLocationParams = bVar != null ? bVar.f25780e : null;
        if (bVar != null && (gdtAd = bVar.f25776a) != null) {
            str = gdtAd.getUrlForClick(adClickLocationParams);
        }
        return h(str, "__SLOT__", String.valueOf(bVar != null ? bVar.f25777b : Integer.MIN_VALUE));
    }
}
