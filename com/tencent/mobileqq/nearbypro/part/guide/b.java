package com.tencent.mobileqq.nearbypro.part.guide;

import android.view.View;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002J\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/part/guide/b;", "", "Landroid/view/View;", "guideContentView", "", "d", "e", "enterView", "c", "b", "view", "", "isAuth", "a", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f253690a = new b();

    b() {
    }

    public final void a(@NotNull View view, boolean isAuth) {
        Intrinsics.checkNotNullParameter(view, "view");
        HashMap hashMap = new HashMap();
        hashMap.put("nearby_is_auth", Integer.valueOf(isAuth ? 1 : 0));
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        VideoReport.setElementId(view, "em_nearby_authlayer");
        VideoReport.reportEvent("dt_imp_end", view, hashMap);
    }

    public final void b(@NotNull View enterView) {
        Intrinsics.checkNotNullParameter(enterView, "enterView");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        VideoReport.setElementId(enterView, "em_nearby_enter_btn");
        VideoReport.reportEvent("dt_clck", enterView, hashMap);
    }

    public final void c(@NotNull View enterView) {
        Intrinsics.checkNotNullParameter(enterView, "enterView");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        VideoReport.setElementId(enterView, "em_nearby_enter_btn");
        VideoReport.reportEvent("dt_imp", enterView, hashMap);
    }

    public final void d(@NotNull View guideContentView) {
        Intrinsics.checkNotNullParameter(guideContentView, "guideContentView");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        VideoReport.setPageId(guideContentView, "pg_nearby_auth_layer");
        VideoReport.setPageParams(guideContentView, new PageParams(hashMap));
        VideoReport.reportEvent("dt_pgin", guideContentView, hashMap);
    }

    public final void e(@NotNull View guideContentView) {
        Intrinsics.checkNotNullParameter(guideContentView, "guideContentView");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        VideoReport.setPageId(guideContentView, "pg_nearby_auth_layer");
        VideoReport.setPageParams(guideContentView, new PageParams(hashMap));
        VideoReport.reportEvent("dt_pgout", guideContentView, hashMap);
    }
}
