package com.tencent.mobileqq.setting.utils;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J@\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002JP\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002J<\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0018\u0010\u0014\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015J2\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u001a\b\u0002\u0010\u0014\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0013J2\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u001a\b\u0002\u0010\u0014\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0013J4\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00022\u0014\b\u0002\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0013\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/setting/utils/o;", "", "", "tv", "", IProfileCardConst.KEY_FROM_TYPE, "r2", "r3", "r4", "r5", "", "j", "tag", "subAction", "actionName", "c", "Landroid/view/View;", "view", "id", "", "elementParams", "", "needReportClick", "l", "f", tl.h.F, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "pgId", "param", DomainData.DOMAIN_NAME, "<init>", "()V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f286768a = new o();

    o() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(String tag, String subAction, String actionName, int i3, String r26, String r36, String r46, String r56) {
        Intrinsics.checkNotNullParameter(tag, "$tag");
        Intrinsics.checkNotNullParameter(subAction, "$subAction");
        Intrinsics.checkNotNullParameter(actionName, "$actionName");
        Intrinsics.checkNotNullParameter(r26, "$r2");
        Intrinsics.checkNotNullParameter(r36, "$r3");
        Intrinsics.checkNotNullParameter(r46, "$r4");
        Intrinsics.checkNotNullParameter(r56, "$r5");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        ReportController.o(peekAppRuntime, tag, "", "", subAction, actionName, i3, 0, r26, r36, r46, r56);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(View view, String id5, Map map) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(id5, "$id");
        VideoReport.setElementId(view, id5);
        if (map != null) {
            VideoReport.setElementParams(view, map);
        }
        if (view.getParent() == null) {
            return;
        }
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_imp", view, null);
    }

    public static /* synthetic */ void k(o oVar, String str, int i3, String str2, String str3, String str4, String str5, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        oVar.j(str, i3, (i16 & 4) != 0 ? "" : str2, (i16 & 8) != 0 ? "" : str3, (i16 & 16) != 0 ? "" : str4, (i16 & 32) != 0 ? "" : str5);
    }

    public final void c(final String tag, final String subAction, final String actionName, final int fromType, final String r26, final String r36, final String r46, final String r56) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(subAction, "subAction");
        Intrinsics.checkNotNullParameter(actionName, "actionName");
        Intrinsics.checkNotNullParameter(r26, "r2");
        Intrinsics.checkNotNullParameter(r36, "r3");
        Intrinsics.checkNotNullParameter(r46, "r4");
        Intrinsics.checkNotNullParameter(r56, "r5");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.setting.utils.m
            @Override // java.lang.Runnable
            public final void run() {
                o.e(tag, subAction, actionName, fromType, r26, r36, r46, r56);
            }
        }, 16, null, true);
    }

    public final void f(View view, String id5, Map<String, ? extends Object> elementParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(id5, "id");
        VideoReport.setElementId(view, id5);
        if (elementParams != null) {
            VideoReport.setElementParams(view, elementParams);
        }
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_clck", view, null);
    }

    public final void h(final View view, final String id5, final Map<String, ? extends Object> elementParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(id5, "id");
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.setting.utils.n
            @Override // java.lang.Runnable
            public final void run() {
                o.i(view, id5, elementParams);
            }
        }, 16, null, false, 2000L);
    }

    public final void j(String tv5, int fromType, String r26, String r36, String r46, String r56) {
        Intrinsics.checkNotNullParameter(tv5, "tv");
        Intrinsics.checkNotNullParameter(r26, "r2");
        Intrinsics.checkNotNullParameter(r36, "r3");
        Intrinsics.checkNotNullParameter(r46, "r4");
        Intrinsics.checkNotNullParameter(r56, "r5");
        c("dc00898", tv5, tv5, fromType, r26, r36, r46, r56);
    }

    public final void l(View view, String id5, Map<String, ? extends Object> elementParams, boolean needReportClick) {
        Intrinsics.checkNotNullParameter(view, "view");
        VideoReport.setElementId(view, id5);
        VideoReport.setElementReuseIdentifier(view, id5);
        if (elementParams != null) {
            VideoReport.setElementParams(view, elementParams);
        }
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        if (needReportClick) {
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        }
    }

    public final void n(Activity activity, View view, String pgId, Map<String, ? extends Object> param) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(pgId, "pgId");
        Intrinsics.checkNotNullParameter(param, "param");
        VideoReport.addToDetectionWhitelist(activity);
        VideoReport.setPageId(view, pgId);
        VideoReport.setPageParams(view, new PageParams(param));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void o(o oVar, Activity activity, View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            map = MapsKt__MapsKt.emptyMap();
        }
        oVar.n(activity, view, str, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void g(o oVar, View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        oVar.f(view, str, map);
    }

    public static /* synthetic */ void m(o oVar, View view, String str, Map map, boolean z16, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z16 = true;
        }
        oVar.l(view, str, map, z16);
    }
}
