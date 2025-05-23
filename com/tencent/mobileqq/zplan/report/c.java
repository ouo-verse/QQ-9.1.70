package com.tencent.mobileqq.zplan.report;

import android.view.View;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import id3.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J4\u0010\t\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006J*\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0006JL\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\"\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0006R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zplan/report/c;", "", "target", "view", "", ISchemeApi.KEY_PAGE_ID, "", "businessParams", "", "d", "Landroid/view/View;", "elementID", "b", "", "onlyClick", "isAsync", IECDtReport.ACTION_IDENTIFIER, "c", "eventID", "a", "Lid3/d;", "Lid3/d;", "dtReportHelper", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f335070a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final d dtReportHelper = new d(null, 1, 0 == true ? 1 : 0);

    c() {
    }

    public final void a(String eventID, Map<String, Object> businessParams) {
        Intrinsics.checkNotNullParameter(eventID, "eventID");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        dtReportHelper.d(eventID, businessParams);
    }

    public final void b(View view, String elementID, Map<String, Object> businessParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        d.h(dtReportHelper, view, elementID, businessParams, false, false, null, 56, null);
    }

    public final void c(View view, String elementID, Map<String, Object> businessParams, boolean onlyClick, boolean isAsync, String identifier) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        dtReportHelper.f(view, elementID, businessParams, onlyClick, isAsync, identifier);
    }

    public final void d(Object target, Object view, String pageID, Map<String, Object> businessParams) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(pageID, "pageID");
        dtReportHelper.j(target, view, pageID, businessParams);
    }
}
