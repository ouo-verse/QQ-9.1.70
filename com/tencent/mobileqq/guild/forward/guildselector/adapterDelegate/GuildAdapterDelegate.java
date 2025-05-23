package com.tencent.mobileqq.guild.forward.guildselector.adapterDelegate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.forward.guildselector.GuildData;
import com.tencent.mobileqq.guild.forward.guildselector.GuildSelectorForwardFragment;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005:\u0001 B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001e\u0010\u001fJ&\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0014J(\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00042\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0014J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/forward/guildselector/adapterDelegate/GuildAdapterDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lcom/tencent/mobileqq/guild/forward/guildselector/c;", "Lcom/tencent/mobileqq/guild/forward/guildselector/a;", "Lcom/tencent/mobileqq/guild/forward/guildselector/adapterDelegate/GuildAdapterDelegate$a;", "Landroid/view/View$OnClickListener;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "o", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "guildData", "holder", "", "", "payloads", "", "p", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/guild/forward/guildselector/GuildSelectorForwardFragment$b;", "d", "Lcom/tencent/mobileqq/guild/forward/guildselector/GuildSelectorForwardFragment$b;", "eventHandler", "<init>", "(Lcom/tencent/mobileqq/guild/forward/guildselector/GuildSelectorForwardFragment$b;)V", "a", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class GuildAdapterDelegate extends AbsListItemAdapterDelegate<GuildData, com.tencent.mobileqq.guild.forward.guildselector.a, a> implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final GuildSelectorForwardFragment.b eventHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/forward/guildselector/adapterDelegate/GuildAdapterDelegate$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/forward/guildselector/c;", "guildData", "", "l", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "guildName", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "guildIcon", "Lcom/tencent/mobileqq/widget/RoundImageView;", "G", "Lcom/tencent/mobileqq/widget/RoundImageView;", "guildAvatar", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private TextView guildName;

        /* renamed from: F, reason: from kotlin metadata */
        private ImageView guildIcon;

        /* renamed from: G, reason: from kotlin metadata */
        private RoundImageView guildAvatar;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.wrw);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.guild_name)");
            this.guildName = (TextView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.wim);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(co\u2026eqq.R.id.guild_icon_tail)");
            this.guildIcon = (ImageView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.vzu);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.guild_avatar)");
            this.guildAvatar = (RoundImageView) findViewById3;
        }

        public final void l(GuildData guildData) {
            Intrinsics.checkNotNullParameter(guildData, "guildData");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
            IQQGuildAvatarApi iQQGuildAvatarApi = (IQQGuildAvatarApi) (appInterface != null ? appInterface.getRuntimeService(IQQGuildAvatarApi.class, "") : null);
            this.guildAvatar.setImageDrawable(iQQGuildAvatarApi != null ? iQQGuildAvatarApi.getAvatarDrawable(guildData.getUrl(), 100, 100, (String) null) : null);
            this.guildName.setText(guildData.getGuildName());
            this.guildIcon.setImageResource(QQTheme.isNowThemeIsNight() ? R.drawable.jns : R.drawable.jnr);
        }
    }

    public GuildAdapterDelegate(GuildSelectorForwardFragment.b eventHandler) {
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        this.eventHandler = eventHandler;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public boolean j(com.tencent.mobileqq.guild.forward.guildselector.a item, List<com.tencent.mobileqq.guild.forward.guildselector.a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof GuildData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        Object tag = v3.getTag();
        if (tag instanceof GuildData) {
            this.eventHandler.a().invoke(tag, v3);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(GuildData guildData, a holder, List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(guildData, "guildData");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.itemView.setTag(guildData);
        holder.l(guildData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public a d(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f8c, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026em_layout, parent, false)");
        a aVar = new a(inflate);
        aVar.itemView.setOnClickListener(this);
        return aVar;
    }
}
