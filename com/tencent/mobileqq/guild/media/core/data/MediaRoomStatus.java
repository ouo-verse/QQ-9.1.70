package com.tencent.mobileqq.guild.media.core.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\n\u0010\u0016R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0018\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/data/g;", "", "", "d", "", "toString", "", "hashCode", "other", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "roomStrId", "b", "I", "getRoomNumId", "()I", "roomNumId", "privateMapKey", "Z", "()Z", "enableTRTCPublish", "e", "isMicInactive", "<init>", "(Ljava/lang/String;ILjava/lang/String;ZZ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.media.core.data.g, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class MediaRoomStatus {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String roomStrId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int roomNumId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String privateMapKey;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean enableTRTCPublish;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isMicInactive;

    public MediaRoomStatus() {
        this(null, 0, null, false, false, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getEnableTRTCPublish() {
        return this.enableTRTCPublish;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getPrivateMapKey() {
        return this.privateMapKey;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getRoomStrId() {
        return this.roomStrId;
    }

    public final boolean d() {
        if (this.roomNumId > 0) {
            return true;
        }
        return false;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsMicInactive() {
        return this.isMicInactive;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaRoomStatus)) {
            return false;
        }
        MediaRoomStatus mediaRoomStatus = (MediaRoomStatus) other;
        if (Intrinsics.areEqual(this.roomStrId, mediaRoomStatus.roomStrId) && this.roomNumId == mediaRoomStatus.roomNumId && Intrinsics.areEqual(this.privateMapKey, mediaRoomStatus.privateMapKey) && this.enableTRTCPublish == mediaRoomStatus.enableTRTCPublish && this.isMicInactive == mediaRoomStatus.isMicInactive) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.roomStrId.hashCode() * 31) + this.roomNumId) * 31) + this.privateMapKey.hashCode()) * 31;
        boolean z16 = this.enableTRTCPublish;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode + i16) * 31;
        boolean z17 = this.isMicInactive;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return i17 + i3;
    }

    @NotNull
    public String toString() {
        return "MediaRoomStatus(roomStrId='" + this.roomStrId + "', roomNumId=" + this.roomNumId + ", enableTRTCPublish=" + this.enableTRTCPublish + ", isMicInactive=" + this.isMicInactive + ")";
    }

    public MediaRoomStatus(@NotNull String roomStrId, int i3, @NotNull String privateMapKey, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(roomStrId, "roomStrId");
        Intrinsics.checkNotNullParameter(privateMapKey, "privateMapKey");
        this.roomStrId = roomStrId;
        this.roomNumId = i3;
        this.privateMapKey = privateMapKey;
        this.enableTRTCPublish = z16;
        this.isMicInactive = z17;
    }

    public /* synthetic */ MediaRoomStatus(String str, int i3, String str2, boolean z16, boolean z17, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) == 0 ? str2 : "", (i16 & 8) != 0 ? false : z16, (i16 & 16) != 0 ? false : z17);
    }
}
