package com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.GuildNewRecommendFragment;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.e;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J0\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0006H\u0014J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0014\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/delegate/e;", "Lcom/tencent/biz/richframework/part/adapter/delegate/AbsListItemAdapterDelegate;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/o;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/h;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "b", "holder", "", "payloads", "", "c", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "onCreateViewHolder", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e extends AbsListItemAdapterDelegate<com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.o, com.tencent.mobileqq.guild.discoveryv2.content.base.h, RecyclerView.ViewHolder> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/recommend/delegate/e$a", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends RecyclerView.ViewHolder {
        a(ViewGroup viewGroup, TextView textView) {
            super(textView);
            View view = this.itemView;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView2 = (TextView) view;
            StaggeredGridLayoutManager.LayoutParams layoutParams = new StaggeredGridLayoutManager.LayoutParams(viewGroup.getWidth(), -2);
            layoutParams.setFullSpan(true);
            textView2.setLayoutParams(layoutParams);
            textView2.setText("\u52a0\u5165\u9891\u9053\u66f4\u65b0\u5df2\u770b\u5b8c\uff0c\u8bd5\u8bd5\u52a0\u5165\u66f4\u591a\u9891\u9053\u5427 >");
            textView2.setTextSize(14.0f);
            textView2.setTextColor(((TextView) this.itemView).getResources().getColor(R.color.qui_common_text_secondary_light));
            textView2.setGravity(17);
            textView2.setPadding(0, kotlin.g.c(textView2, 48.0f), 0, kotlin.g.c(textView2, 48.0f));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    e.a.m(view2);
                }
            });
            com.tencent.mobileqq.guild.discoveryv2.util.b.b(textView2, "em_sgrp_view_end", "em_sgrp_view_end", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL, EndExposurePolicy.REPORT_ALL, null, null, null, MsgConstant.KRMFILETHUMBSIZE384, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            GuildNewRecommendFragment.Companion companion = GuildNewRecommendFragment.INSTANCE;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "it.context");
            companion.d(context, 0, "", 5, new GuildAppReportSourceInfo(), new ArrayList<>());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.base.h item, @NotNull List<? extends com.tencent.mobileqq.guild.discoveryv2.content.base.h> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder2(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.o item, @NotNull RecyclerView.ViewHolder holder, int position, @NotNull List<? extends Object> payloads) {
        StaggeredGridLayoutManager.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        ViewGroup.LayoutParams layoutParams2 = holder.itemView.getLayoutParams();
        if (layoutParams2 instanceof StaggeredGridLayoutManager.LayoutParams) {
            layoutParams = (StaggeredGridLayoutManager.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.setFullSpan(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new a(parent, new TextView(parent.getContext()));
    }
}
