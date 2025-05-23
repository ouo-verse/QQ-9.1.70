package com.tencent.mobileqq.guild.setting.group.adapterDelegate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.group.BindTitleData;
import com.tencent.mobileqq.guild.setting.group.GuildBindGroupSettingFragment;
import com.tencent.mobileqq.guild.setting.group.adapterDelegate.BindTitleAdapterDelegate;
import com.tencent.mobileqq.guild.setting.group.y;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005:\u0001\u001eB\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001c\u0010\u001dJ&\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0014J(\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00042\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0007H\u0014J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/adapterDelegate/BindTitleAdapterDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lcom/tencent/mobileqq/guild/setting/group/e;", "Lcom/tencent/mobileqq/guild/setting/group/a;", "Lcom/tencent/mobileqq/guild/setting/group/adapterDelegate/BindTitleAdapterDelegate$a;", "Landroid/view/View$OnClickListener;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "o", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "holder", "", "payloads", "", "p", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingFragment$a;", "d", "Lcom/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingFragment$a;", "eventHandler", "<init>", "(Lcom/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingFragment$a;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class BindTitleAdapterDelegate extends AbsListItemAdapterDelegate<BindTitleData, com.tencent.mobileqq.guild.setting.group.a, a> implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildBindGroupSettingFragment.a eventHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/adapterDelegate/BindTitleAdapterDelegate$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/setting/group/e;", "data", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "E", "Landroid/view/View;", "o", "()Landroid/view/View;", "finishView", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "p", "()Landroid/widget/TextView;", "sortTextView", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final View finishView;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final TextView sortTextView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.v6l);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.finish_textview)");
            this.finishView = findViewById;
            View findViewById2 = itemView.findViewById(R.id.f86934t0);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.sort_textview)");
            this.sortTextView = (TextView) findViewById2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(a this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            VideoReport.reportEvent("imp", this$0.sortTextView, null);
        }

        public final void m(@NotNull BindTitleData data) {
            boolean z16;
            int i3;
            boolean z17;
            Intrinsics.checkNotNullParameter(data, "data");
            TextView textView = this.sortTextView;
            boolean z18 = true;
            if (data.getNeedShowSortView() && !data.getIsSorting()) {
                z16 = true;
            } else {
                z16 = false;
            }
            int i16 = 8;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView.setVisibility(i3);
            View view = this.finishView;
            if (data.getNeedShowSortView() && data.getIsSorting()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                i16 = 0;
            }
            view.setVisibility(i16);
            y yVar = y.f233563a;
            yVar.a(this.sortTextView, "em_sgrp_sort");
            yVar.a(this.finishView, "em_sgrp_complete_btn");
            if (this.sortTextView.getVisibility() != 0) {
                z18 = false;
            }
            if (z18) {
                this.sortTextView.post(new Runnable() { // from class: yy1.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        BindTitleAdapterDelegate.a.n(BindTitleAdapterDelegate.a.this);
                    }
                });
            }
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final View getFinishView() {
            return this.finishView;
        }

        @NotNull
        /* renamed from: p, reason: from getter */
        public final TextView getSortTextView() {
            return this.sortTextView;
        }
    }

    public BindTitleAdapterDelegate(@NotNull GuildBindGroupSettingFragment.a eventHandler) {
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        this.eventHandler = eventHandler;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull com.tencent.mobileqq.guild.setting.group.a item, @NotNull List<? extends com.tencent.mobileqq.guild.setting.group.a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof BindTitleData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getId() == R.id.v6l) {
            this.eventHandler.a().invoke(v3);
        } else if (v3.getId() == R.id.f86934t0) {
            this.eventHandler.a().invoke(v3);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull BindTitleData item, @NotNull a holder, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (payloads.isEmpty()) {
            holder.m(item);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public a d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.egz, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026sort_view, parent, false)");
        a aVar = new a(inflate);
        aVar.getSortTextView().setOnClickListener(this);
        aVar.getFinishView().setOnClickListener(this);
        return aVar;
    }
}
