package com.tencent.mobileqq.guild.media.core.logic;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0017\u0012\b\b\u0002\u0010!\u001a\u00020\u0017\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0010R\"\u0010\u001c\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\t\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0018\u001a\u0004\b\u0014\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\"\u0010!\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0018\u001a\u0004\b\u001f\u0010\u0019\"\u0004\b \u0010\u001b\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "sdkAppId", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "privateMapKey", "e", "userId", "d", "f", "userSign", "", "J", "()J", "g", "(J)V", "disConnectTRTCSeconds", "setSigValidSecond", "sigValidSecond", "getRoomDataVersion", "setRoomDataVersion", "roomDataVersion", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final /* data */ class j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int sdkAppId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String privateMapKey;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String userId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String userSign;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long disConnectTRTCSeconds;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private long sigValidSecond;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private long roomDataVersion;

    public j() {
        this(0, null, null, null, 0L, 0L, 0L, 127, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getDisConnectTRTCSeconds() {
        return this.disConnectTRTCSeconds;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getPrivateMapKey() {
        return this.privateMapKey;
    }

    /* renamed from: c, reason: from getter */
    public final int getSdkAppId() {
        return this.sdkAppId;
    }

    /* renamed from: d, reason: from getter */
    public final long getSigValidSecond() {
        return this.sigValidSecond;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof j)) {
            return false;
        }
        j jVar = (j) other;
        if (this.sdkAppId == jVar.sdkAppId && Intrinsics.areEqual(this.privateMapKey, jVar.privateMapKey) && Intrinsics.areEqual(this.userId, jVar.userId) && Intrinsics.areEqual(this.userSign, jVar.userSign) && this.disConnectTRTCSeconds == jVar.disConnectTRTCSeconds && this.sigValidSecond == jVar.sigValidSecond && this.roomDataVersion == jVar.roomDataVersion) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getUserSign() {
        return this.userSign;
    }

    public final void g(long j3) {
        this.disConnectTRTCSeconds = j3;
    }

    public int hashCode() {
        return (((((((((((this.sdkAppId * 31) + this.privateMapKey.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.userSign.hashCode()) * 31) + androidx.fragment.app.a.a(this.disConnectTRTCSeconds)) * 31) + androidx.fragment.app.a.a(this.sigValidSecond)) * 31) + androidx.fragment.app.a.a(this.roomDataVersion);
    }

    @NotNull
    public String toString() {
        return "EnterChannelParamsForTRTCRoom: disConnectTRTCSeconds=" + this.disConnectTRTCSeconds + ", sigValidSecond=" + this.sigValidSecond + ", roomDataVersion=" + this.roomDataVersion;
    }

    public j(int i3, @NotNull String privateMapKey, @NotNull String userId, @NotNull String userSign, long j3, long j16, long j17) {
        Intrinsics.checkNotNullParameter(privateMapKey, "privateMapKey");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(userSign, "userSign");
        this.sdkAppId = i3;
        this.privateMapKey = privateMapKey;
        this.userId = userId;
        this.userSign = userSign;
        this.disConnectTRTCSeconds = j3;
        this.sigValidSecond = j16;
        this.roomDataVersion = j17;
    }

    public /* synthetic */ j(int i3, String str, String str2, String str3, long j3, long j16, long j17, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? "" : str2, (i16 & 8) == 0 ? str3 : "", (i16 & 16) != 0 ? 0L : j3, (i16 & 32) != 0 ? 0L : j16, (i16 & 64) == 0 ? j17 : 0L);
    }
}
