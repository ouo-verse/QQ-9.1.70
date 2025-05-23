package com.tencent.mobileqq.qqguildsdk.data;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0003B'\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\b\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u0017\u0010\u000f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\t\u001a\u0004\b\u0003\u0010\u000b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/fl;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "guildId", "", "J", "d", "()J", "topTimestamp", "c", "guildName", "avatarSeq", "<init>", "(Ljava/lang/String;JLjava/lang/String;J)V", "e", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class fl {

    /* renamed from: f, reason: collision with root package name */
    @JvmField
    @NotNull
    public static String f266051f = "groupprohead.gtimg.cn";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long topTimestamp;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long avatarSeq;

    public fl(@NotNull String guildId, long j3, @NotNull String guildName, long j16) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(guildName, "guildName");
        this.guildId = guildId;
        this.topTimestamp = j3;
        this.guildName = guildName;
        this.avatarSeq = j16;
    }

    /* renamed from: a, reason: from getter */
    public final long getAvatarSeq() {
        return this.avatarSeq;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    /* renamed from: d, reason: from getter */
    public final long getTopTimestamp() {
        return this.topTimestamp;
    }
}
