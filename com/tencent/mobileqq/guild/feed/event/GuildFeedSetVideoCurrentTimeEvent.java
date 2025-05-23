package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/event/GuildFeedSetVideoCurrentTimeEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "videoId", "", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "", "(Ljava/lang/String;I)V", "getCurrentTime", "()I", "getVideoId", "()Ljava/lang/String;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildFeedSetVideoCurrentTimeEvent extends SimpleBaseEvent {
    private final int currentTime;

    @Nullable
    private final String videoId;

    public GuildFeedSetVideoCurrentTimeEvent(@Nullable String str, int i3) {
        this.videoId = str;
        this.currentTime = i3;
    }

    public final int getCurrentTime() {
        return this.currentTime;
    }

    @Nullable
    public final String getVideoId() {
        return this.videoId;
    }
}
