package com.tencent.mobileqq.qqguildsdk.data;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u001e2\u00020\u0001:\u0001\u0003BG\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001b\u0010\u001cB!\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001b\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\u000f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u0017\u0010\u0015\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\b\u0010\u000eR\u0017\u0010\u0019\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\u0013\u0010\u0018R\u0017\u0010\u001a\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\f\u001a\u0004\b\u0003\u0010\u000e\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/fk;", "", "", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "guildId", "b", "c", "channelId", "", "J", tl.h.F, "()J", "topTimestamp", "d", "g", "guildName", "e", "channelName", "avatarSeq", "", "I", "()I", "channelType", "appId", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;JIJ)V", "(Ljava/lang/String;Ljava/lang/String;J)V", "i", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class fk {

    /* renamed from: j, reason: collision with root package name */
    @JvmField
    @NotNull
    public static String f266041j = "groupprohead.gtimg.cn";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long topTimestamp;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String channelName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long avatarSeq;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int channelType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final long appId;

    public fk(@NotNull String guildId, @NotNull String channelId, long j3, @NotNull String guildName, @NotNull String channelName, long j16, int i3, long j17) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(guildName, "guildName");
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        this.guildId = guildId;
        this.channelId = channelId;
        this.topTimestamp = j3;
        this.guildName = guildName;
        this.channelName = channelName;
        this.avatarSeq = j16;
        this.channelType = i3;
        this.appId = j17;
    }

    /* renamed from: a, reason: from getter */
    public final long getAppId() {
        return this.appId;
    }

    /* renamed from: b, reason: from getter */
    public final long getAvatarSeq() {
        return this.avatarSeq;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getChannelName() {
        return this.channelName;
    }

    /* renamed from: e, reason: from getter */
    public final int getChannelType() {
        return this.channelType;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    /* renamed from: h, reason: from getter */
    public final long getTopTimestamp() {
        return this.topTimestamp;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public fk(@NotNull String guildId, @NotNull String channelId, long j3) {
        this(guildId, channelId, j3, "guildName", "channelName", 0L, 0, 0L);
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
    }
}
