package com.tencent.mobileqq.onlinestatus.view.withAvatar;

import android.os.Bundle;
import com.tencent.mobileqq.text.QQText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.observer.BusinessObserver;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/r;", "Lmqq/observer/BusinessObserver;", "", "type", "", "isSuccess", "Landroid/os/Bundle;", "bundle", "", "onReceive", "", "d", "Ljava/lang/String;", "getUin", "()Ljava/lang/String;", "uin", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarViewHolder;", "e", "Lmqq/util/WeakReference;", "holderRef", "holder", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarViewHolder;)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class r implements BusinessObserver {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String uin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<OnlineStatusLikeWithAvatarViewHolder> holderRef;

    public r(@NotNull String uin, @NotNull OnlineStatusLikeWithAvatarViewHolder holder) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.uin = uin;
        this.holderRef = new WeakReference<>(holder);
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int type, boolean isSuccess, @Nullable Bundle bundle) {
        OnlineStatusLikeWithAvatarViewHolder onlineStatusLikeWithAvatarViewHolder = this.holderRef.get();
        if (isSuccess && bundle != null && bundle.getString("key_auto_reply") != null && onlineStatusLikeWithAvatarViewHolder != null && Intrinsics.areEqual(this.uin, onlineStatusLikeWithAvatarViewHolder.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x())) {
            OnlineStatusLikeWithAvatarViewHolder.E0(onlineStatusLikeWithAvatarViewHolder, new QQText(bundle.getString("key_auto_reply"), 3, 16), false, 2, null);
            onlineStatusLikeWithAvatarViewHolder.w0(true);
        }
    }
}
