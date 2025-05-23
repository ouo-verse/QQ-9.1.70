package bq1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\t\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u0017\u0010\u000f\u00a8\u0006\u001b"}, d2 = {"Lbq1/a;", "", "", "a", "b", "", "c", "d", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "getChannelId", "channelId", "I", "getBusinessType", "()I", "businessType", "getInviteCode", "inviteCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: bq1.a, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class JoinInfoParamData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int businessType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String inviteCode;

    public JoinInfoParamData(@NotNull String guildId, @NotNull String channelId, int i3, @NotNull String inviteCode) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(inviteCode, "inviteCode");
        this.guildId = guildId;
        this.channelId = channelId;
        this.businessType = i3;
        this.inviteCode = inviteCode;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    /* renamed from: c, reason: from getter */
    public final int getBusinessType() {
        return this.businessType;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getInviteCode() {
        return this.inviteCode;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JoinInfoParamData)) {
            return false;
        }
        JoinInfoParamData joinInfoParamData = (JoinInfoParamData) other;
        if (Intrinsics.areEqual(this.guildId, joinInfoParamData.guildId) && Intrinsics.areEqual(this.channelId, joinInfoParamData.channelId) && this.businessType == joinInfoParamData.businessType && Intrinsics.areEqual(this.inviteCode, joinInfoParamData.inviteCode)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.guildId.hashCode() * 31) + this.channelId.hashCode()) * 31) + this.businessType) * 31) + this.inviteCode.hashCode();
    }

    @NotNull
    public String toString() {
        return "JoinInfoParamData(guildId=" + this.guildId + ", channelId=" + this.channelId + ", businessType=" + this.businessType + ", inviteCode=" + this.inviteCode + ')';
    }
}
