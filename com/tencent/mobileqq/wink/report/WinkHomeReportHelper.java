package com.tencent.mobileqq.wink.report;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.wink.QQWinkPage;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ:\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bJ.\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0001J\"\u0010\u0010\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\bJ\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0006R'\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00060\u00138FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/wink/report/WinkHomeReportHelper;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View;", "contentView", "", "pgId", "", "extraPageParams", "", "c", "eid", "paramsMap", "obj", "f", "a", "view", "e", "", "Lcom/tencent/mobileqq/wink/QQWinkPage;", "b", "Lkotlin/Lazy;", "()Ljava/util/Map;", "pageToElementId", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkHomeReportHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkHomeReportHelper f326257a = new WinkHomeReportHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy pageToElementId;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Map<QQWinkPage, ? extends String>>() { // from class: com.tencent.mobileqq.wink.report.WinkHomeReportHelper$pageToElementId$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<QQWinkPage, ? extends String> invoke() {
                Map<QQWinkPage, ? extends String> mapOf;
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(QQWinkPage.Capture, WinkDaTongReportConstant.ElementId.EM_XSJ_CAMERA_ICON), TuplesKt.to(QQWinkPage.MediaPicker, WinkDaTongReportConstant.ElementId.EM_XSJ_ALBUM_TAB));
                return mapOf;
            }
        });
        pageToElementId = lazy;
    }

    WinkHomeReportHelper() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(WinkHomeReportHelper winkHomeReportHelper, Activity activity, View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            map = null;
        }
        winkHomeReportHelper.c(activity, view, str, map);
    }

    public final void a(@NotNull String eid, @NotNull Map<String, Object> paramsMap) {
        Intrinsics.checkNotNullParameter(eid, "eid");
        Intrinsics.checkNotNullParameter(paramsMap, "paramsMap");
        paramsMap.put("xsj_eid", eid);
        if (!paramsMap.containsKey("dt_eid")) {
            paramsMap.put("dt_eid", eid);
        }
    }

    @NotNull
    public final Map<QQWinkPage, String> b() {
        return (Map) pageToElementId.getValue();
    }

    public final void c(@Nullable Activity activity, @Nullable View contentView, @NotNull String pgId, @Nullable Map<String, Object> extraPageParams) {
        String str;
        Intent intent;
        Intent intent2;
        Intrinsics.checkNotNullParameter(pgId, "pgId");
        if (contentView == null) {
            w53.b.c("WinkHomeReportHelper", "[reportPageExpose] contentView is null");
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            if (extraPageParams != null) {
                hashMap.putAll(extraPageParams);
                w53.b.a("WinkHomeReportHelper", "[reportPageExpose] extraPageParams is : " + extraPageParams);
            }
            Bundle bundle = null;
            if (activity != null && (intent2 = activity.getIntent()) != null) {
                str = intent2.getStringExtra("xsj_ref_pgid");
            } else {
                str = null;
            }
            w53.b.a("WinkHomeReportHelper", "[reportPageExpose] refPg: " + str + ", pgId: " + pgId);
            hashMap.put("xsj_ref_pgid", str);
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, str);
            hashMap.put("xsj_custom_pgid", pgId);
            c cVar = c.f326261a;
            if (activity != null && (intent = activity.getIntent()) != null) {
                bundle = intent.getExtras();
            }
            cVar.a(bundle, hashMap);
            PageParams buildPageParams = new WinkDTParamBuilder().buildPageParams(hashMap, WinkContext.INSTANCE.d().getDtParams().c());
            VideoReport.addToDetectionWhitelist(activity);
            VideoReport.setPageId(contentView, pgId);
            VideoReport.setPageParams(contentView, buildPageParams);
        } catch (Exception e16) {
            w53.b.d("WinkHomeReportHelper", "[reportPageExpose] exception", e16);
        }
    }

    public final void e(@NotNull View view, @Nullable String eid) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (eid == null) {
            return;
        }
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(buildElementParams, "this");
        buildElementParams.put("xsj_eid", eid);
        VideoReport.setElementId(view, eid);
        VideoReport.reportEvent("dt_clck", view, buildElementParams);
    }

    public final void f(@NotNull String eid, @NotNull Map<String, Object> paramsMap, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(eid, "eid");
        Intrinsics.checkNotNullParameter(paramsMap, "paramsMap");
        a(eid, paramsMap);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", obj, paramsMap);
    }
}
