package com.tencent.mobileqq.guild.discoveryv2.hotlive.delegate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import gi1.EmptyPageData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001e2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0002\u001f B\u001b\u0012\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00120\u0014\u00a2\u0006\u0004\b\u001d\u0010\u001bJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0014J(\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0006H\u0014R.\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00120\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/delegate/EmptyPageAdapterDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lgi1/i;", "Lgi1/b;", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/delegate/EmptyPageAdapterDelegate$b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "p", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, ReportConstant.COSTREPORT_PREFIX, "holder", "", "payloads", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lkotlin/Function1;", "Landroid/view/View;", "d", "Lkotlin/jvm/functions/Function1;", "getOnRefresh", "()Lkotlin/jvm/functions/Function1;", "setOnRefresh", "(Lkotlin/jvm/functions/Function1;)V", HippyScrollViewEventHelper.EVENT_TYPE_REFRESH, "<init>", "e", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class EmptyPageAdapterDelegate extends AbsListItemAdapterDelegate<EmptyPageData, gi1.b, b> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function1<? super View, Unit> onRefresh;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/delegate/EmptyPageAdapterDelegate$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/LinearLayout;", "E", "Landroid/widget/LinearLayout;", "l", "()Landroid/widget/LinearLayout;", "emptyContainer", "<init>", "(Landroid/widget/LinearLayout;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final LinearLayout emptyContainer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull LinearLayout emptyContainer) {
            super(emptyContainer);
            Intrinsics.checkNotNullParameter(emptyContainer, "emptyContainer");
            this.emptyContainer = emptyContainer;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final LinearLayout getEmptyContainer() {
            return this.emptyContainer;
        }
    }

    public EmptyPageAdapterDelegate(@NotNull Function1<? super View, Unit> onRefresh) {
        Intrinsics.checkNotNullParameter(onRefresh, "onRefresh");
        this.onRefresh = onRefresh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(EmptyPageAdapterDelegate this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.c("EmptyPageAdapterDelegate")) {
            Function1<? super View, Unit> function1 = this$0.onRefresh;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            function1.invoke(it);
            bt.h(bt.f235484a, it, "em_sgrp_empty_create_aio", "clck", null, 8, null);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull gi1.b item, @NotNull List<? extends gi1.b> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof EmptyPageData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull EmptyPageData item, @NotNull b holder, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (holder.getEmptyContainer().getChildCount() > 0) {
            holder.getEmptyContainer().removeAllViews();
        }
        QUIEmptyState.Builder backgroundColorType = new QUIEmptyState.Builder(holder.itemView.getContext()).setImageType(item.getImageType()).setTitle(item.getTitle()).setHalfScreenState(false).setAutoCenter(false).setBackgroundColorType(0);
        if (item.getShowRefreshButton()) {
            backgroundColorType.setButton("\u5237\u65b0", new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.hotlive.delegate.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EmptyPageAdapterDelegate.r(EmptyPageAdapterDelegate.this, view);
                }
            });
        }
        holder.getEmptyContainer().addView(backgroundColorType.build());
        VideoReport.setElementReuseIdentifier(holder.getEmptyContainer(), "EmptyPageAdapterDelegate");
        bt btVar = bt.f235484a;
        bt.d(holder.getEmptyContainer(), "em_sgrp_empty_create_aio", null, ClickPolicy.REPORT_NONE, null, EndExposurePolicy.REPORT_NONE, 20, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public b d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LinearLayout linearLayout = new LinearLayout(parent.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setGravity(1);
        linearLayout.setPadding(0, QQGuildUIUtil.f(160.0f), 0, 0);
        return new b(linearLayout);
    }
}
