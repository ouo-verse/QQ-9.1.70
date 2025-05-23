package com.tencent.mobileqq.wink.editor.subtitle;

import android.view.View;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J6\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0002\b\u0003\u0018\u00010\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0002\b\u0003\u0018\u00010\tJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0002J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0002J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0002J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0004J\u0006\u0010\u001d\u001a\u00020\u0004J\u0006\u0010\u001e\u001a\u00020\u0004J\u0006\u0010\u001f\u001a\u00020\u0004\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/wink/editor/subtitle/m;", "", "Landroid/view/View;", "loadingIcon", "", "c", "loadingErrIcon", "b", "subtitleList", "", "", "exposureParams", "endExposureParams", "d", "cancelButton", "a", "e", "editButton", tl.h.F, "styleButton", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "deleteButton", "g", "confirmButton", "f", "view", DomainData.DOMAIN_NAME, "o", "i", "k", "l", "j", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f322215a = new m();

    m() {
    }

    public final void a(@NotNull View cancelButton) {
        Intrinsics.checkNotNullParameter(cancelButton, "cancelButton");
        com.tencent.mobileqq.wink.report.e.f(com.tencent.mobileqq.wink.report.e.f326265a, cancelButton, WinkDaTongReportConstant.ElementId.EM_XSJ_SUBTITLE_CANCEL_BUTTON, null, null, 12, null);
    }

    public final void b(@NotNull View loadingErrIcon) {
        Intrinsics.checkNotNullParameter(loadingErrIcon, "loadingErrIcon");
        com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
        com.tencent.mobileqq.wink.report.e.f(eVar, loadingErrIcon, WinkDaTongReportConstant.ElementId.EM_XSJ_SUBTITLE_LOADING_FAILED_PANEL, null, null, 12, null);
        com.tencent.mobileqq.wink.report.e.d(eVar, loadingErrIcon, WinkDaTongReportConstant.ElementId.EM_XSJ_SUBTITLE_LOADING_FAILED_PANEL, null, null, 12, null);
    }

    public final void c(@NotNull View loadingIcon) {
        Intrinsics.checkNotNullParameter(loadingIcon, "loadingIcon");
        com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
        com.tencent.mobileqq.wink.report.e.f(eVar, loadingIcon, WinkDaTongReportConstant.ElementId.EM_XSJ_SUBTITLE_LOADING_PANEL, null, null, 12, null);
        com.tencent.mobileqq.wink.report.e.d(eVar, loadingIcon, WinkDaTongReportConstant.ElementId.EM_XSJ_SUBTITLE_LOADING_PANEL, null, null, 12, null);
    }

    public final void d(@NotNull View subtitleList, @Nullable Map<String, ?> exposureParams, @Nullable Map<String, ?> endExposureParams) {
        Intrinsics.checkNotNullParameter(subtitleList, "subtitleList");
        com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
        com.tencent.mobileqq.wink.report.e.f(eVar, subtitleList, WinkDaTongReportConstant.ElementId.EM_XSJ_SUBTITLE_PANEL, exposureParams, null, 8, null);
        com.tencent.mobileqq.wink.report.e.d(eVar, subtitleList, WinkDaTongReportConstant.ElementId.EM_XSJ_SUBTITLE_PANEL, endExposureParams, null, 8, null);
    }

    public final void e(@NotNull View cancelButton) {
        Intrinsics.checkNotNullParameter(cancelButton, "cancelButton");
        com.tencent.mobileqq.wink.report.e.k(com.tencent.mobileqq.wink.report.e.f326265a, cancelButton, WinkDaTongReportConstant.ElementId.EM_XSJ_SUBTITLE_CANCEL_BUTTON, null, null, 12, null);
    }

    public final void f(@NotNull View confirmButton) {
        Intrinsics.checkNotNullParameter(confirmButton, "confirmButton");
        com.tencent.mobileqq.wink.report.e.k(com.tencent.mobileqq.wink.report.e.f326265a, confirmButton, WinkDaTongReportConstant.ElementId.EM_XSJ_SUBTITLE_PANEL_FINISH, null, null, 12, null);
    }

    public final void g(@NotNull View deleteButton) {
        Intrinsics.checkNotNullParameter(deleteButton, "deleteButton");
        com.tencent.mobileqq.wink.report.e.k(com.tencent.mobileqq.wink.report.e.f326265a, deleteButton, WinkDaTongReportConstant.ElementId.EM_XSJ_PANEL_DELETE_BUTTON, null, null, 12, null);
    }

    public final void h(@NotNull View editButton) {
        Intrinsics.checkNotNullParameter(editButton, "editButton");
        com.tencent.mobileqq.wink.report.e.k(com.tencent.mobileqq.wink.report.e.f326265a, editButton, WinkDaTongReportConstant.ElementId.EM_XSJ_SUBTITLE_BATCH_EDIT_BUTTON, null, null, 12, null);
    }

    public final void i() {
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_bilingual_subtitle_request_status", 2);
        VideoReport.reportEvent("ev_xsj_camera_action", params);
    }

    public final void j() {
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_bilingual_subtitle_request_status", 3);
        VideoReport.reportEvent("ev_xsj_camera_action", params);
    }

    public final void k() {
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_bilingual_subtitle_request_status", 0);
        VideoReport.reportEvent("ev_xsj_camera_action", params);
    }

    public final void l() {
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_bilingual_subtitle_request_status", 1);
        VideoReport.reportEvent("ev_xsj_camera_action", params);
    }

    public final void m(@NotNull View styleButton) {
        Intrinsics.checkNotNullParameter(styleButton, "styleButton");
        com.tencent.mobileqq.wink.report.e.k(com.tencent.mobileqq.wink.report.e.f326265a, styleButton, WinkDaTongReportConstant.ElementId.EM_XSJ_PANEL_STYLE_BUTTON, null, null, 12, null);
    }

    public final void n(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        com.tencent.mobileqq.wink.report.e.k(com.tencent.mobileqq.wink.report.e.f326265a, view, WinkDaTongReportConstant.ElementId.EM_XSJ_SUBTITLE_HALF_SCREEN_PANEL, null, null, 12, null);
    }

    public final void o() {
        com.tencent.mobileqq.wink.report.e.f326265a.y();
    }
}
