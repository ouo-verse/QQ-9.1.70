package an0;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.wechat.AdWXCustomerService;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.config.data.k;
import com.tencent.gdtad.kuikly.dex.GdtKuiklyDexManager;
import com.tencent.gdtad.kuikly.fragment.a;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b implements a.d {

    /* renamed from: a, reason: collision with root package name */
    private final AdWXCustomerService.Params f26329a;

    /* renamed from: d, reason: collision with root package name */
    private GdtKuiklyDexManager.a f26332d;

    /* renamed from: c, reason: collision with root package name */
    private volatile long f26331c = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;

    /* renamed from: b, reason: collision with root package name */
    private final k f26330b = wm0.b.m().l();

    public b(AdWXCustomerService.Params params) {
        this.f26329a = params;
    }

    @Override // com.tencent.gdtad.kuikly.fragment.a.d
    public a.c a() {
        return a.n().m();
    }

    @Override // com.tencent.gdtad.kuikly.fragment.a.d
    public GdtAd b() {
        AdWXCustomerService.Params params = this.f26329a;
        if (params != null) {
            Ad ad5 = params.f61350ad;
            if (ad5 instanceof GdtAd) {
                return (GdtAd) ad5;
            }
        }
        return null;
    }

    @Override // com.tencent.gdtad.kuikly.fragment.a.d
    public void c(GdtKuiklyDexManager.a aVar) {
        this.f26332d = aVar;
    }

    @Override // com.tencent.gdtad.kuikly.fragment.a.d
    public long d() {
        return this.f26331c;
    }

    @Override // com.tencent.gdtad.kuikly.fragment.a.d
    public long e() {
        k kVar = this.f26330b;
        if (kVar != null) {
            return kVar.timeoutMillis;
        }
        return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
    }

    @Override // com.tencent.gdtad.kuikly.fragment.a.d
    public long f() {
        GdtAd b16 = b();
        if (b16 != null) {
            return b16.getWXCustomerServiceKuiklyMinVersion();
        }
        return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
    }

    @Override // com.tencent.gdtad.kuikly.fragment.a.d
    public a.b g() {
        return a.n().l();
    }

    @Override // com.tencent.gdtad.kuikly.fragment.a.d
    public Activity getActivity() {
        AdWXCustomerService.Params params = this.f26329a;
        if (params != null) {
            return params.waekActivity.get();
        }
        return null;
    }

    @Override // com.tencent.gdtad.kuikly.fragment.a.d
    public String getPageName() {
        return "gdt_wx_customer_service_card_page";
    }

    @Override // com.tencent.gdtad.kuikly.fragment.a.d
    public long h() {
        if (this.f26331c == WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
            return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        return System.currentTimeMillis() - this.f26331c;
    }

    @Override // com.tencent.gdtad.kuikly.fragment.a.d
    public String i() {
        return "gdt_wx_customer_service_card_module";
    }

    @Override // com.tencent.gdtad.kuikly.fragment.a.d
    public boolean isValid() {
        AdWXCustomerService.Params params = this.f26329a;
        if (params != null && params.isValid() && com.tencent.gdtad.kuikly.fragment.a.i(this) && this.f26330b != null) {
            return true;
        }
        return false;
    }

    public Bundle j() {
        AdWXCustomerService.Params params = this.f26329a;
        if (params != null) {
            return params.extrasForIntent;
        }
        return null;
    }

    public AdWXCustomerService.Params k() {
        return this.f26329a;
    }

    public void l(long j3) {
        this.f26331c = j3;
    }
}
