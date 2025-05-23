package com.tencent.mobileqq.guild.feed.publish.event;

import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/event/GuildFeedThirdContentMediaEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "jsonFeed", "", AEEditorConstants.KEY_WINK_LOCAL_MEDIA_INFOS, "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "(Ljava/lang/String;Ljava/util/List;)V", "getJsonFeed", "()Ljava/lang/String;", "getLocalMediaInfos", "()Ljava/util/List;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildFeedThirdContentMediaEvent extends SimpleBaseEvent {

    @NotNull
    private final String jsonFeed;

    @NotNull
    private final List<LocalMediaInfo> localMediaInfos;

    /* JADX WARN: Multi-variable type inference failed */
    public GuildFeedThirdContentMediaEvent(@NotNull String jsonFeed, @NotNull List<? extends LocalMediaInfo> localMediaInfos) {
        Intrinsics.checkNotNullParameter(jsonFeed, "jsonFeed");
        Intrinsics.checkNotNullParameter(localMediaInfos, "localMediaInfos");
        this.jsonFeed = jsonFeed;
        this.localMediaInfos = localMediaInfos;
    }

    @NotNull
    public final String getJsonFeed() {
        return this.jsonFeed;
    }

    @NotNull
    public final List<LocalMediaInfo> getLocalMediaInfos() {
        return this.localMediaInfos;
    }
}
