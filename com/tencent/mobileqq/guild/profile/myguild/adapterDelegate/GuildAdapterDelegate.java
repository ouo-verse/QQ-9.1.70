package com.tencent.mobileqq.guild.profile.myguild.adapterDelegate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildContactApi;
import com.tencent.mobileqq.guild.component.RoundImageView;
import com.tencent.mobileqq.guild.profile.myguild.GuildData;
import com.tencent.mobileqq.guild.profile.myguild.GuildMyGuildFragment;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u00052\u00020\u0006:\u0001\"B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u00a2\u0006\u0004\b \u0010!J&\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J(\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013H\u0014J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/myguild/adapterDelegate/GuildAdapterDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lcom/tencent/mobileqq/guild/profile/myguild/c;", "Lcom/tencent/mobileqq/guild/profile/myguild/a;", "Lcom/tencent/mobileqq/guild/profile/myguild/adapterDelegate/GuildAdapterDelegate$a;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "o", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "guildData", "holder", "", "", "payloads", "", "p", "Landroid/view/View;", "v", NodeProps.ON_CLICK, NodeProps.ON_LONG_CLICK, "Lcom/tencent/mobileqq/guild/profile/myguild/GuildMyGuildFragment$b;", "d", "Lcom/tencent/mobileqq/guild/profile/myguild/GuildMyGuildFragment$b;", "eventHandler", "<init>", "(Lcom/tencent/mobileqq/guild/profile/myguild/GuildMyGuildFragment$b;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildAdapterDelegate extends AbsListItemAdapterDelegate<GuildData, com.tencent.mobileqq.guild.profile.myguild.a, a> implements View.OnClickListener, View.OnLongClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildMyGuildFragment.b eventHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/myguild/adapterDelegate/GuildAdapterDelegate$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/profile/myguild/c;", "guildData", "", "l", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "guildName", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "notDisturbMsgIcon", "Lcom/tencent/mobileqq/guild/component/RoundImageView;", "G", "Lcom/tencent/mobileqq/guild/component/RoundImageView;", "guildAvatar", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private TextView guildName;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private ImageView notDisturbMsgIcon;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private RoundImageView guildAvatar;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.wrw);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.guild_name)");
            this.guildName = (TextView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.zse);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.not_disturb_msg_icon)");
            this.notDisturbMsgIcon = (ImageView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.vzu);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.guild_avatar)");
            this.guildAvatar = (RoundImageView) findViewById3;
        }

        public final void l(@NotNull GuildData guildData) {
            Intrinsics.checkNotNullParameter(guildData, "guildData");
            ((IGuildContactApi) QRoute.api(IGuildContactApi.class)).updateGuildAvatar(this.guildAvatar, guildData.getUrl(), guildData.getGuildName());
            this.guildName.setText(guildData.getGuildName());
            if (guildData.getUnNotifyIsOpen()) {
                this.notDisturbMsgIcon.setVisibility(0);
            } else {
                this.notDisturbMsgIcon.setVisibility(8);
            }
        }
    }

    public GuildAdapterDelegate(@NotNull GuildMyGuildFragment.b eventHandler) {
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        this.eventHandler = eventHandler;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull com.tencent.mobileqq.guild.profile.myguild.a item, @NotNull List<com.tencent.mobileqq.guild.profile.myguild.a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof GuildData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        Object tag = v3.getTag();
        if (tag instanceof GuildData) {
            this.eventHandler.a().invoke(((GuildData) tag).getId(), v3);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(@NotNull View v3) {
        boolean z16;
        EventCollector.getInstance().onViewLongClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        Object tag = v3.getTag();
        if (!(tag instanceof GuildData)) {
            z16 = false;
        } else {
            GuildData guildData = (GuildData) tag;
            this.eventHandler.b().invoke(guildData.getId(), guildData.getGuildName(), Boolean.valueOf(!guildData.getIsTop()));
            z16 = true;
        }
        EventCollector.getInstance().onViewLongClicked(v3);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull GuildData guildData, @NotNull a holder, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(guildData, "guildData");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.itemView.setTag(guildData);
        holder.l(guildData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public a d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f0o, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026uild_item, parent, false)");
        a aVar = new a(inflate);
        aVar.itemView.setOnClickListener(this);
        aVar.itemView.setOnLongClickListener(this);
        return aVar;
    }
}
