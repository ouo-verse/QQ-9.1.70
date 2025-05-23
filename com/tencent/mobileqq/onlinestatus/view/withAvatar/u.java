package com.tencent.mobileqq.onlinestatus.view.withAvatar;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.onlinestatus.olympic.helper.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.qq_status_rank.status_rank_mgr.StatusRankMgr$StatusRankResponse;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/u;", "Lcom/tencent/mobileqq/onlinestatus/olympic/helper/a$b;", "Ltrpc/qq_status_rank/status_rank_mgr/StatusRankMgr$StatusRankResponse;", "response", "", "a", "Lcom/tencent/mobileqq/onlinestatus/model/d;", "Lcom/tencent/mobileqq/onlinestatus/model/d;", "getFriend", "()Lcom/tencent/mobileqq/onlinestatus/model/d;", GuildMsgItem.NICK_FRIEND, "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarViewHolder;", "b", "Lmqq/util/WeakReference;", "holderRef", "holder", "<init>", "(Lcom/tencent/mobileqq/onlinestatus/model/d;Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarViewHolder;)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class u implements a.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.onlinestatus.model.d friend;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<OnlineStatusLikeWithAvatarViewHolder> holderRef;

    public u(@NotNull com.tencent.mobileqq.onlinestatus.model.d friend, @NotNull OnlineStatusLikeWithAvatarViewHolder holder) {
        Intrinsics.checkNotNullParameter(friend, "friend");
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.friend = friend;
        this.holderRef = new WeakReference<>(holder);
    }

    @Override // com.tencent.mobileqq.onlinestatus.olympic.helper.a.b
    public void a(@Nullable StatusRankMgr$StatusRankResponse response) {
        if (response != null && response.res.get() == 0) {
            this.friend.getStatus().D0(response.rank.get());
            OnlineStatusLikeWithAvatarViewHolder onlineStatusLikeWithAvatarViewHolder = this.holderRef.get();
            if (onlineStatusLikeWithAvatarViewHolder != null && Intrinsics.areEqual(onlineStatusLikeWithAvatarViewHolder.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x(), this.friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x())) {
                onlineStatusLikeWithAvatarViewHolder.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().getStatus().D0(response.rank.get());
                onlineStatusLikeWithAvatarViewHolder.j0();
            }
        }
    }
}
