package com.tencent.mobileqq.guild.feed.topic;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\n\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/f;", "Lcom/tencent/mobileqq/guild/feed/topic/e;", "", "getTopicId", "", "getTopicName", "getGuildId", "a", "J", "topicId", "b", "Ljava/lang/String;", "getTopicNameRef", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "topicNameRef", "c", "guildId", "d", "channelSign", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f implements e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long topicId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String topicNameRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String guildId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String channelSign;

    public f(long j3, @NotNull String topicNameRef, @NotNull String guildId, @NotNull String channelSign) {
        Intrinsics.checkNotNullParameter(topicNameRef, "topicNameRef");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelSign, "channelSign");
        this.topicId = j3;
        this.topicNameRef = topicNameRef;
        this.guildId = guildId;
        this.channelSign = channelSign;
    }

    @Override // com.tencent.mobileqq.guild.feed.topic.e
    @NotNull
    /* renamed from: a, reason: from getter */
    public String getChannelSign() {
        return this.channelSign;
    }

    public final void b(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.topicNameRef = str;
    }

    @Override // com.tencent.mobileqq.guild.feed.topic.e
    @NotNull
    public String getGuildId() {
        return this.guildId;
    }

    @Override // com.tencent.mobileqq.guild.feed.topic.e
    public long getTopicId() {
        return this.topicId;
    }

    @Override // com.tencent.mobileqq.guild.feed.topic.e
    @NotNull
    /* renamed from: getTopicName, reason: from getter */
    public String getTopicNameRef() {
        return this.topicNameRef;
    }
}
