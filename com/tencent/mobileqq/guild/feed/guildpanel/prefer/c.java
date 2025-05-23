package com.tencent.mobileqq.guild.feed.guildpanel.prefer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarViewWithPendant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProLikeUserInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0018\u0010\u0019J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0014J.\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0014R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/guildpanel/prefer/c;", "Lcom/tencent/biz/richframework/part/adapter/delegate/AbsListItemAdapterDelegate;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProLikeUserInfo;", "Lcom/tencent/mobileqq/guild/feed/guildpanel/prefer/c$a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "c", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "f", "holder", "", "payloads", "", "d", "Lcom/tencent/mobileqq/guild/feed/guildpanel/prefer/k;", "Lcom/tencent/mobileqq/guild/feed/guildpanel/prefer/k;", "getUserPreferListener", "()Lcom/tencent/mobileqq/guild/feed/guildpanel/prefer/k;", "userPreferListener", "<init>", "(Lcom/tencent/mobileqq/guild/feed/guildpanel/prefer/k;)V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c extends AbsListItemAdapterDelegate<GProLikeUserInfo, GProLikeUserInfo, a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final k userPreferListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/guildpanel/prefer/c$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProLikeUserInfo;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "l", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "itemUserName", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarViewWithPendant;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarViewWithPendant;", "itemUserAvatar", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final TextView itemUserName;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final GuildUserAvatarViewWithPendant itemUserAvatar;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.xy6);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.item_user_name)");
            this.itemUserName = (TextView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.f165880xy3);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.item_user_avatar)");
            this.itemUserAvatar = (GuildUserAvatarViewWithPendant) findViewById2;
        }

        public final void l(@NotNull GProLikeUserInfo item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.itemUserName.setText(item.nick);
            GuildUserAvatarViewWithPendant guildUserAvatarViewWithPendant = this.itemUserAvatar;
            String str = item.avatar;
            Intrinsics.checkNotNullExpressionValue(str, "item.avatar");
            String str2 = item.avatarPendant;
            Intrinsics.checkNotNullExpressionValue(str2, "item.avatarPendant");
            guildUserAvatarViewWithPendant.setUrl(str, str2);
        }
    }

    public c(@NotNull k userPreferListener) {
        Intrinsics.checkNotNullParameter(userPreferListener, "userPreferListener");
        this.userPreferListener = userPreferListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(c this$0, GProLikeUserInfo item, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        if (!o.c("fastClickGuard")) {
            k kVar = this$0.userPreferListener;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            kVar.a(it, item);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NotNull GProLikeUserInfo item, @NotNull List<GProLikeUserInfo> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder2(@NotNull final GProLikeUserInfo item, @NotNull a holder, int position, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.l(item);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.guildpanel.prefer.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.e(c.this, item, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NotNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ers, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new a(view);
    }
}
