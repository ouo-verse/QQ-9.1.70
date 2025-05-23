package com.tencent.mobileqq.qqecommerce.biz.hr.api.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.ecommerce.richtext.ui.dom.style.g;
import com.tencent.mobileqq.qqecommerce.biz.hr.api.IECHRAccessHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J0\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J8\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/ECHRAccessHelperImpl;", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/IECHRAccessHelper;", "()V", "dip2px", "", "dp", "", "ensureNVViewMVPEnvironment", "", "getviolaurlfromweb", "", "webUrl", "isKanDianWebHost", "", "isViolaUrlFromWeb", "startViolaPage", "context", "Landroid/content/Context;", "title", "jsUrl", "bundle", "Landroid/os/Bundle;", "useTransParentfragment", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ECHRAccessHelperImpl implements IECHRAccessHelper {
    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.IECHRAccessHelper
    public int dip2px(float dp5) {
        return g.h(dp5);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.IECHRAccessHelper
    public void ensureNVViewMVPEnvironment() {
        a.a();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.IECHRAccessHelper
    public String getviolaurlfromweb(String webUrl) {
        String c16 = a.c(webUrl);
        Intrinsics.checkNotNullExpressionValue(c16, "getViolaUrlFromWeb(webUrl)");
        return c16;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.IECHRAccessHelper
    public boolean isKanDianWebHost(String webUrl) {
        return a.d(webUrl);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.IECHRAccessHelper
    public boolean isViolaUrlFromWeb(String webUrl) {
        return a.e(webUrl);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.IECHRAccessHelper
    public void startViolaPage(Context context, String title, String jsUrl, Bundle bundle) {
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.IECHRAccessHelper
    public void startViolaPage(Context context, String title, String jsUrl, Bundle bundle, boolean useTransParentfragment) {
    }
}
