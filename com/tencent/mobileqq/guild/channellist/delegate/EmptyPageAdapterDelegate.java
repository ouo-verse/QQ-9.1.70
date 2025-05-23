package com.tencent.mobileqq.guild.channellist.delegate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.channellist.EmptyPageData;
import com.tencent.mobileqq.guild.channellist.c;
import com.tencent.mobileqq.guild.channellist.delegate.EmptyPageAdapterDelegate;
import com.tencent.mobileqq.guild.component.GuildQUIEmptyState;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import eg1.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001d2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0002\u001e\u001fB\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001c\u0010\u001aJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0014J(\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0006H\u0014R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/delegate/EmptyPageAdapterDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lcom/tencent/mobileqq/guild/channellist/f;", "Lcom/tencent/mobileqq/guild/channellist/c;", "Lcom/tencent/mobileqq/guild/channellist/delegate/EmptyPageAdapterDelegate$b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "p", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, ReportConstant.COSTREPORT_PREFIX, "holder", "", "payloads", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Leg1/a;", "d", "Leg1/a;", "getEventHandler", "()Leg1/a;", "setEventHandler", "(Leg1/a;)V", "eventHandler", "<init>", "e", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class EmptyPageAdapterDelegate extends AbsListItemAdapterDelegate<EmptyPageData, c, b> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private a eventHandler;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/delegate/EmptyPageAdapterDelegate$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/LinearLayout;", "E", "Landroid/widget/LinearLayout;", "l", "()Landroid/widget/LinearLayout;", "emptyContainer", "<init>", "(Landroid/widget/LinearLayout;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
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

    public EmptyPageAdapterDelegate(@NotNull a eventHandler) {
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        this.eventHandler = eventHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(EmptyPageAdapterDelegate this$0, b holder, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        this$0.eventHandler.a().invoke(holder.getEmptyContainer());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull c item, @NotNull List<? extends c> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof EmptyPageData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull EmptyPageData item, @NotNull final b holder, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (holder.getEmptyContainer().getChildCount() > 0) {
            holder.getEmptyContainer().removeAllViews();
        }
        GuildQUIEmptyState.a o16 = new GuildQUIEmptyState.a(holder.itemView.getContext()).s(item.getImageType()).u(item.getTitle()).n(true).o(0);
        if (item.getShowAddButton()) {
            String qqStr = HardCodeUtil.qqStr(R.string.f142320j2);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_chat_create)");
            o16.p(qqStr, new View.OnClickListener() { // from class: eg1.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EmptyPageAdapterDelegate.r(EmptyPageAdapterDelegate.this, holder, view);
                }
            });
        }
        holder.getEmptyContainer().addView(o16.a());
        VideoReport.setElementReuseIdentifier(holder.getEmptyContainer(), "Guild.NewHome.subFrag.EmptyPageAdapterDelegate");
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
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setGravity(17);
        linearLayout.setPadding(0, 0, 0, QQGuildUIUtil.f(35.0f));
        return new b(linearLayout);
    }
}
