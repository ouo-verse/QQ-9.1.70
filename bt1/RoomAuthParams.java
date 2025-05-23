package bt1;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0007\u0012\b\b\u0002\u0010 \u001a\u00020\u0004\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u0010\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010 \u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016\u00a8\u0006#"}, d2 = {"Lbt1/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setGuildId", "(Ljava/lang/String;)V", "guildId", "b", "setChannelId", "channelId", "I", "()I", "setGameType", "(I)V", "gameType", "d", "Z", "()Z", "setNeedGameMode", "(Z)V", "needGameMode", "e", "setServiceType", "serviceType", "<init>", "(Ljava/lang/String;Ljava/lang/String;IZI)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: bt1.i, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class RoomAuthParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int gameType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean needGameMode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int serviceType;

    public RoomAuthParams() {
        this(null, null, 0, false, 0, 31, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    /* renamed from: b, reason: from getter */
    public final int getGameType() {
        return this.gameType;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getNeedGameMode() {
        return this.needGameMode;
    }

    /* renamed from: e, reason: from getter */
    public final int getServiceType() {
        return this.serviceType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoomAuthParams)) {
            return false;
        }
        RoomAuthParams roomAuthParams = (RoomAuthParams) other;
        if (Intrinsics.areEqual(this.guildId, roomAuthParams.guildId) && Intrinsics.areEqual(this.channelId, roomAuthParams.channelId) && this.gameType == roomAuthParams.gameType && this.needGameMode == roomAuthParams.needGameMode && this.serviceType == roomAuthParams.serviceType) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.guildId.hashCode() * 31) + this.channelId.hashCode()) * 31) + this.gameType) * 31;
        boolean z16 = this.needGameMode;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((hashCode + i3) * 31) + this.serviceType;
    }

    @NotNull
    public String toString() {
        return "RoomAuthParams(guildId=" + this.guildId + ", channelId=" + this.channelId + ", gameType=" + this.gameType + ", needGameMode=" + this.needGameMode + ", serviceType=" + this.serviceType + ")";
    }

    public RoomAuthParams(@NotNull String guildId, @NotNull String channelId, int i3, boolean z16, int i16) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.guildId = guildId;
        this.channelId = channelId;
        this.gameType = i3;
        this.needGameMode = z16;
        this.serviceType = i16;
    }

    public /* synthetic */ RoomAuthParams(String str, String str2, int i3, boolean z16, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? "" : str, (i17 & 2) == 0 ? str2 : "", (i17 & 4) != 0 ? -1 : i3, (i17 & 8) != 0 ? false : z16, (i17 & 16) != 0 ? 1 : i16);
    }
}
