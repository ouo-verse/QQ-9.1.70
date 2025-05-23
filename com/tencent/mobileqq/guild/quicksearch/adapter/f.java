package com.tencent.mobileqq.guild.quicksearch.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.quicksearch.adapter.f;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchFeedGroupInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import vp1.cy;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001%B/\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u001e\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000b0\u0014\u00a2\u0006\u0004\b#\u0010$J\u001c\u0010\u0007\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u001c\u0010\f\u001a\u00020\u000b2\n\u0010\t\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0014\u0010\u0010\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\u0014\u0010\u0013\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R,\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000b0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R2\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u001aj\b\u0012\u0004\u0012\u00020\u000e`\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/adapter/f;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/guild/quicksearch/adapter/f$a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "l0", "getItemCount", "holder", "position", "", "k0", "", "Lcom/tencent/mobileqq/guild/quicksearch/adapter/d;", "newDataList", "setData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "filterBoxReportType", "Lkotlin/Function3;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchFeedGroupInfo;", "", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function3;", "onItemClick", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "D", "Ljava/util/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "dataList", "<init>", "(ILkotlin/jvm/functions/Function3;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class f extends RecyclerView.Adapter<a> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Function3<Integer, IGProGuildSearchFeedGroupInfo, Boolean, Unit> onItemClick;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private ArrayList<QuickSearchModuleInfo> dataList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int filterBoxReportType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/adapter/f$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "Lcom/tencent/mobileqq/guild/quicksearch/adapter/d;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "o", "quickSearchModuleInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lvp1/cy;", "E", "Lvp1/cy;", "getBinding", "()Lvp1/cy;", "binding", "<init>", "(Lcom/tencent/mobileqq/guild/quicksearch/adapter/f;Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final cy binding;
        final /* synthetic */ f F;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull f fVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.F = fVar;
            cy e16 = cy.e(itemView);
            Intrinsics.checkNotNullExpressionValue(e16, "bind(itemView)");
            this.binding = e16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(f this$0, a this$1, QuickSearchModuleInfo quickSearchModuleInfo, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(quickSearchModuleInfo, "$quickSearchModuleInfo");
            this$0.onItemClick.invoke(Integer.valueOf(this$1.getAdapterPosition()), quickSearchModuleInfo.getInfo(), Boolean.valueOf(!quickSearchModuleInfo.getIsSelected()));
            View itemView = this$1.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            this$1.o(itemView, quickSearchModuleInfo);
            EventCollector.getInstance().onViewClicked(view);
        }

        private final void o(View itemView, QuickSearchModuleInfo item) {
            HashMap hashMapOf;
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("search_trace_id", kw1.a.f413327a.c(item.getInfo())), TuplesKt.to("sgrp_filter_box_type", String.valueOf(this.F.filterBoxReportType)), TuplesKt.to("sgrp_tag_text", item.getInfo().getChannelName()), TuplesKt.to("sgrp_tag_id", String.valueOf(item.getInfo().getChannelId())));
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(itemView, "em_sgrp_filter_box_second_tag", "clck", hashMapOf);
        }

        public final void m(@NotNull final QuickSearchModuleInfo quickSearchModuleInfo) {
            Intrinsics.checkNotNullParameter(quickSearchModuleInfo, "quickSearchModuleInfo");
            this.binding.f442831b.setChecked(quickSearchModuleInfo.getIsSelected());
            this.binding.f442832c.setText(quickSearchModuleInfo.getInfo().getChannelName());
            View view = this.itemView;
            final f fVar = this.F;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.quicksearch.adapter.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    f.a.n(f.this, this, quickSearchModuleInfo, view2);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(int i3, @NotNull Function3<? super Integer, ? super IGProGuildSearchFeedGroupInfo, ? super Boolean, Unit> onItemClick) {
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        this.filterBoxReportType = i3;
        this.onItemClick = onItemClick;
        this.dataList = new ArrayList<>();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull a holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        QuickSearchModuleInfo quickSearchModuleInfo = this.dataList.get(position);
        Intrinsics.checkNotNullExpressionValue(quickSearchModuleInfo, "dataList[position]");
        holder.m(quickSearchModuleInfo);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.f3f, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new a(this, view);
    }

    public final void setData(@NotNull List<QuickSearchModuleInfo> newDataList) {
        Intrinsics.checkNotNullParameter(newDataList, "newDataList");
        this.dataList.clear();
        this.dataList.addAll(newDataList);
        notifyDataSetChanged();
    }
}
