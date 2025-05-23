package com.tencent.biz.qqcircle.immersive.redpacket.util;

import android.view.View;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J \u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u001e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u001e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/util/b;", "", "Landroid/view/View;", "view", "", "activityId", "", "a", "templateId", "g", "elementId", "feedId", "", "isRedPacketOpen", "d", "c", "e", "f", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f89584a = new b();

    b() {
    }

    public static /* synthetic */ void b(b bVar, View view, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "qqhongbao-1";
        }
        bVar.a(view, str);
    }

    public static /* synthetic */ void h(b bVar, View view, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "qqhongbao-2";
        }
        bVar.g(view, str, str2);
    }

    public final void a(@NotNull View view, @NotNull String activityId) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_operation_activity_id", activityId);
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_QQ_BEGIN_MAKE_BUTTON);
        VideoReport.setElementParams(view, params);
    }

    public final void c(@NotNull String elementId, @NotNull String feedId, boolean isRedPacketOpen) {
        String str;
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_QQ_PREVIEW_RED_ENVELOPE_COVER_PAGE);
        params.put("xsj_eid", elementId);
        if (isRedPacketOpen) {
            str = "1";
        } else {
            str = "0";
        }
        params.put(QCircleDaTongConstant.ElementParamKey.QQ_IS_RED_ENVELOPE_OPEN, str);
        params.put("xsj_feed_id", feedId);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", params);
    }

    public final void d(@NotNull String elementId, @NotNull String feedId, boolean isRedPacketOpen) {
        String str;
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_QQ_PREVIEW_RED_ENVELOPE_COVER_PAGE);
        params.put("xsj_eid", elementId);
        if (isRedPacketOpen) {
            str = "1";
        } else {
            str = "0";
        }
        params.put(QCircleDaTongConstant.ElementParamKey.QQ_IS_RED_ENVELOPE_OPEN, str);
        params.put("xsj_feed_id", feedId);
        VideoReport.reportEvent("ev_xsj_abnormal_imp", params);
    }

    public final void e(boolean isRedPacketOpen) {
        String str;
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("dt_pgid", QCircleDaTongConstant.PageId.PG_QQ_PREVIEW_RED_ENVELOPE_COVER_PAGE);
        if (isRedPacketOpen) {
            str = "1";
        } else {
            str = "0";
        }
        params.put(QCircleDaTongConstant.ElementParamKey.QQ_IS_RED_ENVELOPE_OPEN, str);
        VideoReport.reportEvent("dt_pgin", params);
    }

    public final void f(boolean isRedPacketOpen) {
        String str;
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("dt_pgid", QCircleDaTongConstant.PageId.PG_QQ_PREVIEW_RED_ENVELOPE_COVER_PAGE);
        if (isRedPacketOpen) {
            str = "1";
        } else {
            str = "0";
        }
        params.put(QCircleDaTongConstant.ElementParamKey.QQ_IS_RED_ENVELOPE_OPEN, str);
        VideoReport.reportEvent("dt_pgout", params);
    }

    public final void g(@NotNull View view, @NotNull String activityId, @NotNull String templateId) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Intrinsics.checkNotNullParameter(templateId, "templateId");
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_operation_activity_id", activityId);
        params.put(QCircleDaTongConstant.ElementParamKey.QQ_RED_ENVELOPE_TEMPLATE_ID, templateId);
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_QQ_RED_ENVELOPE_TEMPLATE_ITEM);
        VideoReport.setElementReuseIdentifier(view, templateId);
        VideoReport.setElementParams(view, params);
    }
}
