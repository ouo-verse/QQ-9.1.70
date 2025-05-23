package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.openingending;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanelViewController;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.tuxmeterqui.config.TuxUIConstants;
import com.tencent.videocut.utils.e;
import f63.b;
import g63.CommonConfig;
import g63.LayoutConfig;
import h63.a;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001\u0006B'\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010'\u001a\u00020\u000b\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010J\u0010\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u0014J\u0010\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u0014J\u0014\u0010\u001a\u001a\u00020\b2\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001eR\u0016\u0010 \u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001eR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/openingending/OpeningEndingAddBtnView;", "Landroid/widget/FrameLayout;", "Lf63/b;", "", TuxUIConstants.POP_BTN_TEXT, "Landroid/view/View;", "a", "btnView", "", "b", "c", "", "leftMargin", "g", NodeProps.MIN_WIDTH, "f", "Landroid/view/View$OnClickListener;", "onClickListener", "setOpeningBtnClickListener", "setEndingBtnClickListener", "", "show", "e", "d", "Lf63/a;", "controller", ReportConstant.COSTREPORT_PREFIX, "Lh63/a;", "Lh63/a;", "timelineViewController", "Landroid/view/View;", "addOpeningBtnContainer", "addEndingBtnContainer", h.F, "I", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class OpeningEndingAddBtnView extends FrameLayout implements b {
    private static final int C;
    private static final int D;
    private static final int E;
    private static final int F;
    private static final int G;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a timelineViewController;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View addOpeningBtnContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View addEndingBtnContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int leftMargin;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f319448i;

    static {
        e eVar = e.f384236a;
        C = eVar.a(56.0f);
        D = eVar.a(22.0f);
        E = eVar.a(22.0f);
        F = R.string.f215615w3;
        G = R.string.f215605w2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OpeningEndingAddBtnView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final View a(String btnText) {
        View container = LayoutInflater.from(getContext()).inflate(R.layout.f168937he3, (ViewGroup) this, false);
        TextView textView = (TextView) container.findViewById(R.id.scl);
        if (textView != null) {
            Intrinsics.checkNotNullExpressionValue(textView, "findViewById<TextView>(R.id.addBtnTextView)");
            textView.setText(btnText);
        }
        ViewGroup.LayoutParams layoutParams = container.getLayoutParams();
        int i3 = C;
        layoutParams.width = i3;
        container.getLayoutParams().height = i3;
        addView(container);
        Intrinsics.checkNotNullExpressionValue(container, "container");
        return container;
    }

    private final void b(View btnView, String btnText) {
        VideoReport.setElementId(btnView, WinkDaTongReportConstant.ElementId.EM_XSJ_ADD_OPENING_ENDING_BUTTON);
        Map<String, Object> reportMap = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(reportMap, "reportMap");
        reportMap.put("xsj_button_text", btnText);
        VideoReport.setElementParams(btnView, reportMap);
        VideoReport.setElementEndExposePolicy(btnView, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(btnView, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(btnView, ExposurePolicy.REPORT_NONE);
    }

    private final void c(View btnView, String btnText) {
        VideoReport.setElementId(btnView, WinkDaTongReportConstant.ElementId.EM_XSJ_ADD_OPENING_ENDING_BUTTON);
        Map<String, Object> reportMap = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(reportMap, "reportMap");
        reportMap.put("xsj_button_text", btnText);
        VideoReport.setElementParams(btnView, reportMap);
        VideoReport.reportEvent("dt_imp", btnView, reportMap);
    }

    public final void d(boolean show) {
        int i3 = 8;
        if (show && this.addEndingBtnContainer.getVisibility() == 8) {
            View view = this.addEndingBtnContainer;
            String string = getContext().getString(G);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(ADD_ENDING_TEXT_ID)");
            c(view, string);
        }
        View view2 = this.addEndingBtnContainer;
        if (show) {
            i3 = 0;
        }
        view2.setVisibility(i3);
    }

    public final void e(boolean show) {
        int i3 = 8;
        if (show && this.addOpeningBtnContainer.getVisibility() == 8) {
            View view = this.addOpeningBtnContainer;
            String string = getContext().getString(F);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(ADD_OPENING_TEXT_ID)");
            c(view, string);
        }
        View view2 = this.addOpeningBtnContainer;
        if (show) {
            i3 = 0;
        }
        view2.setVisibility(i3);
    }

    public final void f(int minWidth) {
        int i3;
        TimelinePanelViewController panelViewController;
        CommonConfig commonConfig;
        LayoutConfig layoutConfig;
        a aVar = this.timelineViewController;
        if (aVar != null && (panelViewController = aVar.getPanelViewController()) != null && (commonConfig = panelViewController.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String()) != null && (layoutConfig = commonConfig.getLayoutConfig()) != null) {
            i3 = layoutConfig.getPanelStartOffset();
        } else {
            i3 = 0;
        }
        int i16 = ((i3 - C) - D) + this.leftMargin;
        ViewGroup.LayoutParams layoutParams = this.addOpeningBtnContainer.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i16;
        int i17 = (minWidth + E) - i3;
        ViewGroup.LayoutParams layoutParams2 = this.addEndingBtnContainer.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = i17;
    }

    public final void g(int leftMargin) {
        int i3;
        int i16;
        TimelinePanelViewController panelViewController;
        TimelinePanelViewController panelViewController2;
        CommonConfig commonConfig;
        LayoutConfig layoutConfig;
        a aVar = this.timelineViewController;
        int i17 = 0;
        if (aVar != null && (panelViewController2 = aVar.getPanelViewController()) != null && (commonConfig = panelViewController2.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String()) != null && (layoutConfig = commonConfig.getLayoutConfig()) != null) {
            i3 = layoutConfig.getPanelStartOffset();
        } else {
            i3 = 0;
        }
        if (leftMargin <= 0) {
            i16 = getScrollX();
        } else {
            i16 = 0;
        }
        this.leftMargin = (leftMargin - i3) + e.f384236a.a(16.0f) + i16;
        a aVar2 = this.timelineViewController;
        if (aVar2 != null && (panelViewController = aVar2.getPanelViewController()) != null) {
            i17 = panelViewController.m();
        }
        f(i17);
    }

    @Override // f63.b
    public void s(@NotNull f63.a<?> controller) {
        a aVar;
        Intrinsics.checkNotNullParameter(controller, "controller");
        if (controller instanceof a) {
            aVar = (a) controller;
        } else {
            aVar = null;
        }
        this.timelineViewController = aVar;
    }

    public final void setEndingBtnClickListener(@NotNull View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.addEndingBtnContainer.setOnClickListener(onClickListener);
    }

    public final void setOpeningBtnClickListener(@NotNull View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.addOpeningBtnContainer.setOnClickListener(onClickListener);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OpeningEndingAddBtnView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OpeningEndingAddBtnView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f319448i = new LinkedHashMap();
        String string = context.getString(F);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(ADD_OPENING_TEXT_ID)");
        this.addOpeningBtnContainer = a(string);
        e(false);
        b(this.addOpeningBtnContainer, string);
        String string2 = context.getString(G);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(ADD_ENDING_TEXT_ID)");
        this.addEndingBtnContainer = a(string2);
        d(false);
        b(this.addEndingBtnContainer, string2);
    }

    public /* synthetic */ OpeningEndingAddBtnView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }
}
