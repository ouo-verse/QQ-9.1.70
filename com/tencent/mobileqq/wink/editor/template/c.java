package com.tencent.mobileqq.wink.editor.template;

import android.view.View;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ$\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002JL\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042,\b\u0002\u0010\f\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\nj\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001`\u000bJL\u0010\u000f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042,\b\u0002\u0010\f\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\nj\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001`\u000bJ<\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\b2,\b\u0002\u0010\u0011\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\nj\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001`\u000bJ<\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\b2,\b\u0002\u0010\u0011\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\nj\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001`\u000bJ\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\bJ&\u0010\u0018\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004J \u0010\u001d\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001c\u001a\u00020\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/wink/editor/template/c;", "", "", "materialID", "", "isFirstTemplate", "", "d", "Landroid/view/View;", "view", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "", tl.h.F, "i", "closeIcon", "map", "e", "f", "entryBtn", "a", "b", "isReplaced", "c", "filterIcon", "type", "", "isBigPanel", "g", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f322362a = new c();

    c() {
    }

    private final Map<String, String> d(String materialID, boolean isFirstTemplate) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_template_id", materialID);
        if (isFirstTemplate) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_ALIENATION_TEMPLATE, str);
        return hashMap;
    }

    public final void a(@NotNull View entryBtn) {
        Intrinsics.checkNotNullParameter(entryBtn, "entryBtn");
        VideoReport.setElementId(entryBtn, WinkDaTongReportConstant.ElementId.EM_XSJ_TEMPLATE_BUTTON);
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_ALIENATION_TEMPLATE, "1");
        VideoReport.reportEvent("dt_clck", entryBtn, params);
    }

    public final void b(@NotNull View entryBtn) {
        Intrinsics.checkNotNullParameter(entryBtn, "entryBtn");
        VideoReport.setElementId(entryBtn, WinkDaTongReportConstant.ElementId.EM_XSJ_TEMPLATE_BUTTON);
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_ALIENATION_TEMPLATE, "1");
        VideoReport.reportEvent("dt_imp", entryBtn, params);
    }

    public final void c(@NotNull View view, @NotNull String materialID, boolean isFirstTemplate, boolean isReplaced) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(materialID, "materialID");
        VideoReport.setElementId(view, "em_xsj_publish_button");
        Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
        map.putAll(d(materialID, isFirstTemplate));
        Intrinsics.checkNotNullExpressionValue(map, "map");
        if (isReplaced) {
            str = "1";
        } else {
            str = "0";
        }
        map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_REPLACE_VIDEO_OR_PIC, str);
        VideoReport.reportEvent("ev_xsj_camera_action", view, map);
    }

    public final void e(@NotNull View closeIcon, @Nullable HashMap<String, Object> map) {
        Intrinsics.checkNotNullParameter(closeIcon, "closeIcon");
        VideoReport.setElementId(closeIcon, WinkDaTongReportConstant.ElementId.EM_XSJ_TEMPLATE_FOLD_BUTTON);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        if (map != null) {
            buildElementParams.putAll(map);
        }
        VideoReport.reportEvent("dt_clck", closeIcon, buildElementParams);
    }

    public final void f(@NotNull View closeIcon, @Nullable HashMap<String, Object> map) {
        Intrinsics.checkNotNullParameter(closeIcon, "closeIcon");
        VideoReport.setElementId(closeIcon, WinkDaTongReportConstant.ElementId.EM_XSJ_TEMPLATE_FOLD_BUTTON);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        if (map != null) {
            buildElementParams.putAll(map);
        }
        VideoReport.reportEvent("dt_imp", closeIcon, buildElementParams);
    }

    public final void g(@NotNull View filterIcon, @Nullable String type, int isBigPanel) {
        Intrinsics.checkNotNullParameter(filterIcon, "filterIcon");
        Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put("xsj_action_type", type);
        map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_BIG_PANEL, Integer.valueOf(isBigPanel));
        VideoReport.reportEvent("dt_clck", filterIcon, map);
    }

    public final void h(@NotNull View view, @NotNull String materialID, boolean isFirstTemplate, @Nullable HashMap<String, Object> params) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(materialID, "materialID");
        VideoReport.setElementId(view, "em_xsj_template_item");
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.putAll(d(materialID, isFirstTemplate));
        if (params != null) {
            buildElementParams.putAll(params);
        }
        VideoReport.reportEvent("dt_clck", view, buildElementParams);
    }

    public final void i(@NotNull View view, @NotNull String materialID, boolean isFirstTemplate, @Nullable HashMap<String, Object> params) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(materialID, "materialID");
        VideoReport.setElementId(view, "em_xsj_template_item");
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.putAll(d(materialID, isFirstTemplate));
        if (params != null) {
            buildElementParams.putAll(params);
        }
        VideoReport.reportEvent("dt_imp", view, buildElementParams);
    }
}
