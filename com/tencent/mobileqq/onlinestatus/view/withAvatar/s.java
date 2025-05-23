package com.tencent.mobileqq.onlinestatus.view.withAvatar;

import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u001e\u001a\u00020\u001a\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0013\u00a2\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/s;", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "", "throwable", "onLoadFialed", "onLoadCanceled", "", "progress", "onLoadProgressed", "", "d", "Ljava/lang/String;", "getUin", "()Ljava/lang/String;", "uin", "", "e", "Z", "getTryLoadManageIfFailed", "()Z", "tryLoadManageIfFailed", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarViewHolder;", "f", "Lmqq/util/WeakReference;", "holderRef", "holder", "<init>", "(Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarViewHolder;Ljava/lang/String;Z)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class s implements URLDrawable.URLDrawableListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String uin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean tryLoadManageIfFailed;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<OnlineStatusLikeWithAvatarViewHolder> holderRef;

    public s(@NotNull OnlineStatusLikeWithAvatarViewHolder holder, @NotNull String uin, boolean z16) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uin = uin;
        this.tryLoadManageIfFailed = z16;
        this.holderRef = new WeakReference<>(holder);
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadCanceled(@Nullable URLDrawable drawable) {
        QLog.e("OnlineStatusLikeWithAvatarExt", 1, "onLoadCanceled");
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadFialed(@Nullable URLDrawable drawable, @Nullable Throwable throwable) {
        OnlineStatusLikeWithAvatarViewHolder onlineStatusLikeWithAvatarViewHolder;
        QLog.e("OnlineStatusLikeWithAvatarExt", 1, "onLoadFailed\n", throwable);
        if (this.tryLoadManageIfFailed && (onlineStatusLikeWithAvatarViewHolder = this.holderRef.get()) != null && Intrinsics.areEqual(this.uin, onlineStatusLikeWithAvatarViewHolder.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x())) {
            onlineStatusLikeWithAvatarViewHolder.a0();
        }
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadSuccessed(@Nullable URLDrawable drawable) {
        OnlineStatusLikeWithAvatarViewHolder onlineStatusLikeWithAvatarViewHolder = this.holderRef.get();
        if (drawable != null && onlineStatusLikeWithAvatarViewHolder != null) {
            String url = drawable.getURL().toString();
            Intrinsics.checkNotNullExpressionValue(url, "drawable.url.toString()");
            if (Intrinsics.areEqual(url, onlineStatusLikeWithAvatarViewHolder.getCustomImageUrl())) {
                onlineStatusLikeWithAvatarViewHolder.c0(drawable);
            }
        }
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadProgressed(@Nullable URLDrawable drawable, int progress) {
    }
}
