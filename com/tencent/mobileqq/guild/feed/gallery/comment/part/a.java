package com.tencent.mobileqq.guild.feed.gallery.comment.part;

import com.tencent.mobileqq.guild.feed.gallery.constants.GuildFeedGalleryMessage;
import com.tencent.mobileqq.guild.feed.gallery.data.GuildGalleryCommentPanelParams;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\bR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/comment/part/a;", "Lcom/tencent/mobileqq/guild/feed/part/d;", "Lcom/tencent/mobileqq/guild/feed/gallery/data/GuildGalleryCommentPanelParams;", "z9", "", "getGuildId", "getChannelId", "A9", "Lcom/tencent/mobileqq/guild/feed/gallery/constants/GuildFeedGalleryMessage$CommentPanelShowArgs;", "B9", "showArgs", "", "C9", "Lgk1/b;", "d", "Lgk1/b;", "x9", "()Lgk1/b;", "contextProvide", "e", "Lcom/tencent/mobileqq/guild/feed/gallery/constants/GuildFeedGalleryMessage$CommentPanelShowArgs;", "<init>", "(Lgk1/b;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class a extends com.tencent.mobileqq.guild.feed.part.d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final gk1.b contextProvide;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private GuildFeedGalleryMessage.CommentPanelShowArgs showArgs;

    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @NotNull
    public final String A9() {
        GuildFeedGalleryMessage.CommentPanelShowArgs commentPanelShowArgs = this.showArgs;
        if (commentPanelShowArgs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showArgs");
            commentPanelShowArgs = null;
        }
        return commentPanelShowArgs.getInitBean().getJoinGuildSig();
    }

    @NotNull
    public final GuildFeedGalleryMessage.CommentPanelShowArgs B9() {
        GuildFeedGalleryMessage.CommentPanelShowArgs commentPanelShowArgs = this.showArgs;
        if (commentPanelShowArgs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showArgs");
            return null;
        }
        return commentPanelShowArgs;
    }

    public final void C9(@NotNull GuildFeedGalleryMessage.CommentPanelShowArgs showArgs) {
        Intrinsics.checkNotNullParameter(showArgs, "showArgs");
        this.showArgs = showArgs;
    }

    @NotNull
    public final String getChannelId() {
        GuildFeedGalleryMessage.CommentPanelShowArgs commentPanelShowArgs = this.showArgs;
        if (commentPanelShowArgs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showArgs");
            commentPanelShowArgs = null;
        }
        return commentPanelShowArgs.getInitBean().getChannelId();
    }

    @NotNull
    public final String getGuildId() {
        GuildFeedGalleryMessage.CommentPanelShowArgs commentPanelShowArgs = this.showArgs;
        if (commentPanelShowArgs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showArgs");
            commentPanelShowArgs = null;
        }
        return commentPanelShowArgs.getInitBean().getGuildId();
    }

    @Nullable
    /* renamed from: x9, reason: from getter */
    public final gk1.b getContextProvide() {
        return this.contextProvide;
    }

    @NotNull
    public final GuildGalleryCommentPanelParams z9() {
        GuildFeedGalleryMessage.CommentPanelShowArgs commentPanelShowArgs = this.showArgs;
        if (commentPanelShowArgs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showArgs");
            commentPanelShowArgs = null;
        }
        return commentPanelShowArgs.getInitBean();
    }

    public /* synthetic */ a(gk1.b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : bVar);
    }

    public a(@Nullable gk1.b bVar) {
        this.contextProvide = bVar;
    }
}
