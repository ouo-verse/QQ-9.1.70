package com.tencent.mobileqq.guild.feed.nativedetail.bottom.send;

import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ReplyCommentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.commentfeed.CommentFeedRequestArgs;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\tH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/c;", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStUser;", ITVKPlayerEventListener.KEY_USER_INFO, "", "c", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/commentfeed/c;", "args", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/h;", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface c {
    void a(@NotNull ReplyCommentArgs args);

    void b(@NotNull CommentFeedRequestArgs args);

    void c(@NotNull GProStUser userInfo);
}
