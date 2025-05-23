package com.tencent.mobileqq.qqvideoedit.editor;

import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\u001a\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0016\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0000\u001a \u0010\r\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n\u001a\u001a\u0010\u0010\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u001a\u0010\u0010\u0011\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u0018\u0010\u0013\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000f\u001a\u00020\u0012\u001a\u0010\u0010\u0014\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u0010\u0010\u0015\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u0010\u0010\u0016\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u0010\u0010\u0017\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u0010\u0010\u0018\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u0010\u0010\u0019\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u0010\u0010\u001a\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u0018\u0010\u001c\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u001b\u001a\u00020\u0012\u00a8\u0006\u001d"}, d2 = {"Landroid/view/View;", "view", "", "isPlaying", "", "a", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "j", "i", "o", "", "originLength", "processTime", DomainData.DOMAIN_NAME, "", "errorMessage", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "", "k", "p", "b", "g", "d", tl.h.F, "e", "c", "ratio", "f", "qqvideoedit_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c {
    public static final void a(@NotNull View view, boolean z16) {
        int i3;
        Intrinsics.checkNotNullParameter(view, "view");
        Map<String, Object> params = ek2.a.a();
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        Integer valueOf = Integer.valueOf(i3);
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("video_edit_processbar_playstate", valueOf);
        VideoReport.setElementId(view, "em_video_edit_processbar");
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.reportEvent("dt_clck", view, params);
    }

    public static final void b(@Nullable View view) {
        Map<String, Object> a16 = ek2.a.a();
        VideoReport.setElementId(view, "em_video_size_crop_cancel");
        VideoReport.reportEvent("dt_clck", view, a16);
    }

    public static final void c(@Nullable View view) {
        Map<String, Object> a16 = ek2.a.a();
        VideoReport.setElementId(view, "em_video_size_crop_finish");
        VideoReport.reportEvent("dt_clck", view, a16);
    }

    public static final void d(@Nullable View view) {
        Map<String, Object> a16 = ek2.a.a();
        VideoReport.setElementId(view, "em_video_size_crop_processbar");
        VideoReport.reportEvent("ev_qq_video_processbar_drag", view, a16);
    }

    public static final void e(@Nullable View view) {
        Map<String, Object> a16 = ek2.a.a();
        VideoReport.setElementId(view, "em_video_size_crop_size");
        VideoReport.reportEvent("dt_clck", view, a16);
    }

    public static final void f(@Nullable View view, int i3) {
        Map<String, Object> params = ek2.a.a();
        Integer valueOf = Integer.valueOf(i3);
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("video_size_crop_size_format", valueOf);
        VideoReport.setElementId(view, "em_video_size_crop_size_choose");
        VideoReport.reportEvent("dt_clck", view, params);
    }

    public static final void g(@Nullable View view) {
        Map<String, Object> a16 = ek2.a.a();
        VideoReport.setElementId(view, "em_video_size_crop_reset");
        VideoReport.reportEvent("dt_clck", view, a16);
    }

    public static final void h(@Nullable View view) {
        Map<String, Object> a16 = ek2.a.a();
        VideoReport.setElementId(view, "em_video_size_crop_rotate");
        VideoReport.reportEvent("dt_clck", view, a16);
    }

    public static final void i(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Map<String, Object> a16 = ek2.a.a();
        VideoReport.setElementId(view, "em_video_edit_back");
        VideoReport.reportEvent("dt_clck", view, a16);
    }

    public static final void j(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Map<String, Object> a16 = ek2.a.a();
        VideoReport.setElementId(view, "em_video_edit_finish");
        VideoReport.reportEvent("dt_clck", view, a16);
    }

    public static final void k(@Nullable View view, int i3) {
        Map<String, Object> params = ek2.a.a();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("video_edit_download_fail_reason", HardCodeUtil.qqStr(i3));
        VideoReport.setElementId(view, "em_video_edit_download_fail");
        VideoReport.reportEvent("dt_imp", view, params);
    }

    public static final void l(@Nullable View view) {
        Map<String, Object> a16 = ek2.a.a();
        VideoReport.setElementId(view, "em_video_edit_download_success");
        VideoReport.reportEvent("dt_imp", view, a16);
    }

    public static final void m(@Nullable View view, @Nullable String str) {
        Map<String, Object> params = ek2.a.a();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("video_edit_process_fail_reason", str);
        VideoReport.setElementId(view, "em_video_edit_process_fail");
        VideoReport.reportEvent("dt_imp", view, params);
    }

    public static final void n(@Nullable View view, long j3, long j16) {
        Map<String, Object> params = ek2.a.a();
        Long valueOf = Long.valueOf(j3);
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("video_edit_origin_length", valueOf);
        params.put("video_edit_process_time", Long.valueOf(j16));
        VideoReport.setElementId(view, "em_video_edit_process_success");
        VideoReport.reportEvent("dt_imp", view, params);
    }

    public static final void o(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Map<String, Object> a16 = ek2.a.a();
        VideoReport.setElementId(view, "em_video_edit_mute");
        VideoReport.reportEvent("dt_clck", view, a16);
    }

    public static final void p(@Nullable View view) {
        Map<String, Object> a16 = ek2.a.a();
        VideoReport.setElementId(view, "em_video_process_window_cancel");
        VideoReport.reportEvent("dt_clck", view, a16);
    }

    public static final void q(@NotNull View view, boolean z16) {
        int i3;
        Intrinsics.checkNotNullParameter(view, "view");
        Map<String, Object> params = ek2.a.a();
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        Integer valueOf = Integer.valueOf(i3);
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("video_edit_processbar_playstate", valueOf);
        VideoReport.setElementId(view, "em_video_edit_processbar");
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.reportEvent("ev_qq_video_processbar_drag", view, params);
    }
}
