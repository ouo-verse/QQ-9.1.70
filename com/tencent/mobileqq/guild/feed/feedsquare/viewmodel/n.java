package com.tencent.mobileqq.guild.feed.feedsquare.viewmodel;

import com.tencent.mobileqq.guild.feed.feedsquare.utils.DeleteFeedArgs;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.InsertFeedArgs;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.ModifyFeedArgs;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.ModifyFeedArgsV2;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\nH&J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u000fH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/n;", "", "", "Lij1/g;", "newFeedList", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/n;", "args", "", "J1", "modifyFeed", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/p;", "x1", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/q;", "argsV2", "i1", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/b;", "J0", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface n {
    void J0(@NotNull DeleteFeedArgs args);

    void J1(@NotNull List<? extends ij1.g> newFeedList, @NotNull InsertFeedArgs args);

    void i1(@NotNull ModifyFeedArgsV2 argsV2);

    void x1(@NotNull ij1.g modifyFeed, @NotNull ModifyFeedArgs args);
}
