package com.tencent.mobileqq.onlinestatus.view.withAvatar;

import com.tencent.mobileqq.onlinestatus.networkhandler.CustomHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.onlinestatus.OnlineStatusShareInfo$ShareInfoItem;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00040\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u0004H\u0016J\u001e\u0010\b\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u0004H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/v;", "Lcom/tencent/mobileqq/onlinestatus/networkhandler/CustomHandler$a;", "Lcom/tencent/mobileqq/onlinestatus/observer/a;", "Ltencent/im/onlinestatus/OnlineStatusShareInfo$ShareInfoItem;", "Lcom/tencent/mobileqq/onlinestatus/observer/CustomInfoGetResPack;", "resPack", "", "c", "b", "", "a", "Ljava/lang/String;", "getUin", "()Ljava/lang/String;", "uin", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarViewHolder;", "Lmqq/util/WeakReference;", "holderRef", "holder", "<init>", "(Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarViewHolder;Ljava/lang/String;)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class v implements CustomHandler.a<com.tencent.mobileqq.onlinestatus.observer.a<OnlineStatusShareInfo$ShareInfoItem>> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String uin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<OnlineStatusLikeWithAvatarViewHolder> holderRef;

    public v(@NotNull OnlineStatusLikeWithAvatarViewHolder holder, @NotNull String uin) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uin = uin;
        this.holderRef = new WeakReference<>(holder);
    }

    @Override // com.tencent.mobileqq.onlinestatus.networkhandler.CustomHandler.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(@Nullable com.tencent.mobileqq.onlinestatus.observer.a<OnlineStatusShareInfo$ShareInfoItem> resPack) {
        OnlineStatusLikeWithAvatarViewHolder onlineStatusLikeWithAvatarViewHolder = this.holderRef.get();
        if (onlineStatusLikeWithAvatarViewHolder != null && Intrinsics.areEqual(this.uin, onlineStatusLikeWithAvatarViewHolder.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x())) {
            onlineStatusLikeWithAvatarViewHolder.a0();
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.networkhandler.CustomHandler.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onSuccess(@Nullable com.tencent.mobileqq.onlinestatus.observer.a<OnlineStatusShareInfo$ShareInfoItem> resPack) {
        OnlineStatusLikeWithAvatarViewHolder onlineStatusLikeWithAvatarViewHolder;
        if (resPack == null || (onlineStatusLikeWithAvatarViewHolder = this.holderRef.get()) == null) {
            return;
        }
        if (resPack.a() != null) {
            OnlineStatusShareInfo$ShareInfoItem a16 = resPack.a();
            Intrinsics.checkNotNull(a16);
            onlineStatusLikeWithAvatarViewHolder.d0(a16);
        } else if (Intrinsics.areEqual(this.uin, onlineStatusLikeWithAvatarViewHolder.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x())) {
            onlineStatusLikeWithAvatarViewHolder.a0();
        }
    }
}
