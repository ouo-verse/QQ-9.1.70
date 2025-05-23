package com.tencent.mobileqq.tvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.util.Consumer;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardBlacklistReportConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.view.TVideoSettingChooseItemView;
import com.tencent.mobileqq.tvideo.view.TVideoSettingSkipHeadTailView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import gy2.c;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0001$B1\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0006\u0012\b\b\u0002\u0010 \u001a\u00020\u0006\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0014J\b\u0010\u000b\u001a\u00020\nH\u0014J\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fJ\u0014\u0010\u0011\u001a\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000fR\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/tvideo/view/TVideoSettingSkipHeadTailView;", "Lcom/tencent/mobileqq/tvideo/view/TVideoSettingChooseView;", "", "g", "Landroid/view/View;", "view", "", "switchStatus", "j", "d", "", "c", "", "isSkip", "setSkipState", "Landroidx/core/util/Consumer;", "callback", "setOnSkipChangedCallback", h.F, "Landroidx/core/util/Consumer;", "skipHeadTailConsumer", "Lcom/tencent/mobileqq/tvideo/view/TVideoSettingChooseItemView;", "i", "Lcom/tencent/mobileqq/tvideo/view/TVideoSettingChooseItemView;", "skipItemView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "notSkipItemView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TVideoSettingSkipHeadTailView extends TVideoSettingChooseView {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Consumer<Boolean> skipHeadTailConsumer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TVideoSettingChooseItemView skipItemView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TVideoSettingChooseItemView notSkipItemView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TVideoSettingSkipHeadTailView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void g() {
        LinearLayout itemContainerView = getItemContainerView();
        if (itemContainerView != null) {
            itemContainerView.removeAllViews();
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        final TVideoSettingChooseItemView tVideoSettingChooseItemView = new TVideoSettingChooseItemView(context, null, 0, 6, null);
        tVideoSettingChooseItemView.setContent("\u8df3\u8fc7");
        LinearLayout itemContainerView2 = getItemContainerView();
        if (itemContainerView2 != null) {
            itemContainerView2.addView(tVideoSettingChooseItemView);
        }
        tVideoSettingChooseItemView.setOnClickListener(new View.OnClickListener() { // from class: ky2.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TVideoSettingSkipHeadTailView.h(TVideoSettingChooseItemView.this, this, view);
            }
        });
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        final TVideoSettingChooseItemView tVideoSettingChooseItemView2 = new TVideoSettingChooseItemView(context2, null, 0, 6, null);
        tVideoSettingChooseItemView2.setContent("\u4e0d\u8df3\u8fc7");
        LinearLayout itemContainerView3 = getItemContainerView();
        if (itemContainerView3 != null) {
            itemContainerView3.addView(tVideoSettingChooseItemView2);
        }
        tVideoSettingChooseItemView2.setOnClickListener(new View.OnClickListener() { // from class: ky2.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TVideoSettingSkipHeadTailView.i(TVideoSettingChooseItemView.this, this, view);
            }
        });
        this.skipItemView = tVideoSettingChooseItemView;
        this.notSkipItemView = tVideoSettingChooseItemView2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(TVideoSettingChooseItemView itemView, TVideoSettingSkipHeadTailView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(itemView, "$itemView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!itemView.getIsChosen()) {
            this$0.setSkipState(true);
            Consumer<Boolean> consumer = this$0.skipHeadTailConsumer;
            if (consumer != null) {
                consumer.accept(Boolean.TRUE);
            }
        }
        this$0.j(itemView, 1);
        VideoReport.reportEvent("clck", itemView, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(TVideoSettingChooseItemView notSkipItemView, TVideoSettingSkipHeadTailView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(notSkipItemView, "$notSkipItemView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!notSkipItemView.getIsChosen()) {
            this$0.setSkipState(false);
            Consumer<Boolean> consumer = this$0.skipHeadTailConsumer;
            if (consumer != null) {
                consumer.accept(Boolean.FALSE);
            }
        }
        this$0.j(notSkipItemView, 0);
        VideoReport.reportEvent("clck", notSkipItemView, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void j(View view, int switchStatus) {
        Map<String, Object> h16 = c.h("more_float");
        h16.put(ProfileCardBlacklistReportConst.ELEM_PARAM_SWITCH_STATUS, Integer.valueOf(switchStatus));
        VideoReport.setElementParams(view, h16);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(view, "jump_opening");
    }

    @Override // com.tencent.mobileqq.tvideo.view.TVideoSettingChooseView
    @NotNull
    protected String c() {
        return "\u7247\u5934\u5c3e";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.tvideo.view.TVideoSettingChooseView
    public void d() {
        super.d();
        g();
    }

    public final void setOnSkipChangedCallback(@NotNull Consumer<Boolean> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.skipHeadTailConsumer = callback;
    }

    public final void setSkipState(boolean isSkip) {
        QLog.i("TVideoSettingSkipHeadTailView", 1, "isSkip:" + isSkip);
        if (isSkip) {
            TVideoSettingChooseItemView tVideoSettingChooseItemView = this.skipItemView;
            if (tVideoSettingChooseItemView != null) {
                tVideoSettingChooseItemView.setChosen(true);
            }
            TVideoSettingChooseItemView tVideoSettingChooseItemView2 = this.notSkipItemView;
            if (tVideoSettingChooseItemView2 != null) {
                tVideoSettingChooseItemView2.setChosen(false);
                return;
            }
            return;
        }
        TVideoSettingChooseItemView tVideoSettingChooseItemView3 = this.skipItemView;
        if (tVideoSettingChooseItemView3 != null) {
            tVideoSettingChooseItemView3.setChosen(false);
        }
        TVideoSettingChooseItemView tVideoSettingChooseItemView4 = this.notSkipItemView;
        if (tVideoSettingChooseItemView4 != null) {
            tVideoSettingChooseItemView4.setChosen(true);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TVideoSettingSkipHeadTailView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TVideoSettingSkipHeadTailView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TVideoSettingSkipHeadTailView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TVideoSettingSkipHeadTailView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        d();
    }
}
