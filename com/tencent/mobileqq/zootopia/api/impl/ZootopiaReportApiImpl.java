package com.tencent.mobileqq.zootopia.api.impl;

import android.view.View;
import com.tencent.mobileqq.zootopia.api.IZootopiaReportApi;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bH\u0016J,\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bH\u0016J6\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zootopia/api/impl/ZootopiaReportApiImpl;", "Lcom/tencent/mobileqq/zootopia/api/IZootopiaReportApi;", "()V", "reportEvent", "", "eventID", "", "businessParams", "", "", "setElementInfo", "view", "Landroid/view/View;", "elementID", "setPageInfo", "target", ISchemeApi.KEY_PAGE_ID, "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ZootopiaReportApiImpl implements IZootopiaReportApi {
    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaReportApi
    public void reportEvent(String eventID, Map<String, Object> businessParams) {
        Intrinsics.checkNotNullParameter(eventID, "eventID");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        com.tencent.mobileqq.zplan.report.c.f335070a.a(eventID, businessParams);
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaReportApi
    public void setElementInfo(View view, String elementID, Map<String, Object> businessParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        com.tencent.mobileqq.zplan.report.c.f335070a.b(view, elementID, businessParams);
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaReportApi
    public void setPageInfo(Object target, Object view, String pageID, Map<String, Object> businessParams) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(pageID, "pageID");
        com.tencent.mobileqq.zplan.report.c.f335070a.d(target, view, pageID, businessParams);
    }
}
