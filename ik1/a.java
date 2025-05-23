package ik1;

import com.tencent.mobileqq.guild.feed.gallery.constants.GuildFeedGalleryMessage;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.CommentFunctionPart;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lik1/a;", "", "Lcom/tencent/mobileqq/guild/feed/gallery/constants/GuildFeedGalleryMessage$CommentPanelShowArgs;", "showArgs", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/CommentFunctionPart$a$a;", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f407902a = new a();

    a() {
    }

    @NotNull
    public final CommentFunctionPart.Companion.CommentInitArgs a(@Nullable GuildFeedGalleryMessage.CommentPanelShowArgs showArgs) {
        if (showArgs != null) {
            return new CommentFunctionPart.Companion.CommentInitArgs(showArgs.getInitBean().getGuildId(), showArgs.getInitBean().getChannelId(), showArgs.getInitBean().getFeedId(), null, false, 24, null);
        }
        return new CommentFunctionPart.Companion.CommentInitArgs(null, null, null, null, false, 31, null);
    }
}
