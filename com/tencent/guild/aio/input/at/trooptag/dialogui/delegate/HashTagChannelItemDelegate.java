package com.tencent.guild.aio.input.at.trooptag.dialogui.delegate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.widget.RFWRoundImageView;
import com.tencent.guild.aio.input.at.trooptag.dialogui.delegate.HashTagChannelItemDelegate;
import com.tencent.guild.aio.input.at.utils.i;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.util.GuildChannelIconUtil;
import com.tencent.mobileqq.guild.util.HashTagViewType;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cp0.HashTagChannelData;
import cp0.a;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001c2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0002\u001d\u001eB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J&\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0014J&\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\tH\u0014J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/guild/aio/input/at/trooptag/dialogui/delegate/HashTagChannelItemDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lcp0/d;", "Lcp0/a;", "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/delegate/HashTagChannelItemDelegate$b;", "data", "", "p", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "position", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "holder", "", "payloads", "", "r", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "t", "Lip0/a;", "d", "Lip0/a;", "itemCallback", "<init>", "(Lip0/a;)V", "e", "a", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class HashTagChannelItemDelegate extends AbsListItemAdapterDelegate<HashTagChannelData, a, b> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ip0.a itemCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/guild/aio/input/at/trooptag/dialogui/delegate/HashTagChannelItemDelegate$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/biz/richframework/widget/RFWRoundImageView;", "E", "Lcom/tencent/biz/richframework/widget/RFWRoundImageView;", "o", "()Lcom/tencent/biz/richframework/widget/RFWRoundImageView;", "channelTypeIV", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "l", "()Landroid/widget/TextView;", "channelNameView", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/ImageView;", "channelTick", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final RFWRoundImageView channelTypeIV;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final TextView channelNameView;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final ImageView channelTick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.f164764tr4);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById<RF\u2026.api.R.id.chanel_type_iv)");
            this.channelTypeIV = (RFWRoundImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.ato);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById<TextView>(R.id.channel_name)");
            this.channelNameView = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.tsh);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById<Im\u2026ld.api.R.id.channel_tick)");
            this.channelTick = (ImageView) findViewById3;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final TextView getChannelNameView() {
            return this.channelNameView;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final ImageView getChannelTick() {
            return this.channelTick;
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final RFWRoundImageView getChannelTypeIV() {
            return this.channelTypeIV;
        }
    }

    public HashTagChannelItemDelegate(@NotNull ip0.a itemCallback) {
        Intrinsics.checkNotNullParameter(itemCallback, "itemCallback");
        this.itemCallback = itemCallback;
    }

    private final int p(HashTagChannelData data) {
        if (data.getAioHashViewType() == HashTagViewType.VIEW_TYPE_FEED_SECTION) {
            return R.drawable.guild_channel_feeds_p;
        }
        return GuildChannelIconUtil.j(data.getChannelType(), data.getSubtypeId(), 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(b holder, HashTagChannelData data, HashTagChannelItemDelegate this$0, View view) {
        HashMap hashMapOf;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        View view2 = holder.itemView;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("sgrp_sub_channel_id", String.valueOf(data.getChannelUin())));
        iGuildDTReportApi.reportDtEventManual(view2, "em_sgrp_sub_channel_link", "clck", hashMapOf);
        this$0.itemCallback.O(data);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull a item, @NotNull List<a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof HashTagChannelData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull final HashTagChannelData data, @NotNull final b holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.itemView.setTag(data);
        holder.getChannelNameView().setText(data.getChannelName());
        if (data.getIsSelect()) {
            i iVar = i.f111117a;
            Context context = holder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "holder.itemView.context");
            holder.getChannelTypeIV().setBackground(iVar.a(context, p(data), Integer.valueOf(R.color.qui_common_brand_standard)));
            holder.getChannelNameView().setTextColor(holder.itemView.getContext().getColor(R.color.qui_common_brand_standard));
            holder.getChannelTick().setVisibility(0);
        } else {
            i iVar2 = i.f111117a;
            Context context2 = holder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "holder.itemView.context");
            holder.getChannelTypeIV().setBackground(iVar2.a(context2, p(data), Integer.valueOf(R.color.qui_common_icon_primary)));
            holder.getChannelNameView().setTextColor(holder.itemView.getContext().getColor(R.color.qui_common_text_primary));
            holder.getChannelTick().setVisibility(8);
        }
        QUIListItemBackgroundType b16 = this.itemCallback.b(data);
        View view = holder.itemView;
        Context context3 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "holder.itemView.context");
        view.setBackground(b16.getBackground(context3, 1000));
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: hp0.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HashTagChannelItemDelegate.s(HashTagChannelItemDelegate.b.this, data, this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public b d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f168102et4, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026nnel_item, parent, false)");
        return new b(inflate);
    }
}
