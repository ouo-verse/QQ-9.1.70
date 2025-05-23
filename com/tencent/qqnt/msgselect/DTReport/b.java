package com.tencent.qqnt.msgselect.DTReport;

import android.util.ArrayMap;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J&\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nH\u0007J&\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nH\u0007J:\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\"\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0010j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001`\u0011J\"\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004J2\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0010j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001`\u0011J\u000e\u0010\u0016\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005R\u0017\u0010\u001a\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/msgselect/DTReport/b;", "", "Landroid/view/View;", "target", "", "", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "", "d", "elementId", "", "params", "e", "g", "Lcom/tencent/qqnt/msgselect/DTReport/a;", "builder", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "reportParam", "a", "b", "c", "f", "Lcom/tencent/qqnt/msgselect/DTReport/a;", "getParamBuilder", "()Lcom/tencent/qqnt/msgselect/DTReport/a;", "paramBuilder", "Landroid/util/ArrayMap;", "", "Landroid/util/ArrayMap;", "exploreMap", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f359718a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final a paramBuilder;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayMap<String, Long> exploreMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65763);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        f359718a = new b();
        paramBuilder = new a();
        exploreMap = new ArrayMap<>();
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void d(View target, Map<String, Object> pageParams) {
        VideoReport.setPageId(target, "pg_bas_includes_history_selection");
        VideoReport.setPageReportPolicy(target, PageReportPolicy.REPORT_NONE);
        VideoReport.setPageParams(target, new PageParams((Map<String, ?>) pageParams));
        VideoReport.reportPgOut(target);
    }

    @JvmStatic
    public static final void e(@NotNull String elementId, @Nullable Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Map<String, Object> a16 = paramBuilder.a();
        a16.put("qq_eid", elementId);
        if (params != null) {
            a16.putAll(params);
        }
        VideoReport.reportEvent("qq_clck", a16);
        if (QLog.isDevelopLevel()) {
            QLog.d("AIO_Report", 4, "reportClick " + elementId + " = " + params);
        }
    }

    @JvmStatic
    public static final void g(@NotNull String elementId, @Nullable Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        exploreMap.put(elementId, Long.valueOf(System.currentTimeMillis()));
        Map<String, Object> a16 = paramBuilder.a();
        a16.put("qq_eid", elementId);
        if (params != null) {
            a16.putAll(params);
        }
        VideoReport.reportEvent("qq_imp", a16);
        if (QLog.isDevelopLevel()) {
            QLog.d("AIO_Report", 4, "reportQQImp " + elementId + " = " + params);
        }
    }

    public final void a(@NotNull View target, @NotNull a builder, @NotNull HashMap<String, Object> reportParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, target, builder, reportParam);
            return;
        }
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(reportParam, "reportParam");
        a aVar = paramBuilder;
        aVar.b(builder);
        Map<String, Object> a16 = aVar.a();
        a16.putAll(reportParam);
        b(target, a16);
    }

    public final void b(@NotNull View target, @NotNull Map<String, Object> pageParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) target, (Object) pageParams);
            return;
        }
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(pageParams, "pageParams");
        VideoReport.setPageId(target, "pg_bas_includes_history_selection");
        VideoReport.setPageReportPolicy(target, PageReportPolicy.REPORT_NONE);
        VideoReport.setPageParams(target, new PageParams((Map<String, ?>) pageParams));
        VideoReport.reportPgIn(target);
    }

    public final void c(@NotNull View target, @NotNull HashMap<String, Object> reportParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) target, (Object) reportParam);
            return;
        }
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(reportParam, "reportParam");
        Map<String, Object> a16 = paramBuilder.a();
        a16.putAll(reportParam);
        d(target, a16);
    }

    public final void f(@NotNull String elementId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) elementId);
        } else {
            Intrinsics.checkNotNullParameter(elementId, "elementId");
            g(elementId, null);
        }
    }
}
