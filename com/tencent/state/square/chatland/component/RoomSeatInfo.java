package com.tencent.state.square.chatland.component;

import com.tencent.mobileqq.vas.banner.c;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00d6\u0001J\u0006\u0010\u0018\u001a\u00020\u0015J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/state/square/chatland/component/RoomSeatInfo;", "", "roomId", "", "appId", "", "currentUserCount", "userCapacity", "(JIII)V", "getAppId", "()I", "getCurrentUserCount", "getRoomId", "()J", "getUserCapacity", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "isFull", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class RoomSeatInfo {
    private final int appId;
    private final int currentUserCount;
    private final long roomId;
    private final int userCapacity;

    public RoomSeatInfo(long j3, int i3, int i16, int i17) {
        this.roomId = j3;
        this.appId = i3;
        this.currentUserCount = i16;
        this.userCapacity = i17;
    }

    /* renamed from: component1, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getAppId() {
        return this.appId;
    }

    /* renamed from: component3, reason: from getter */
    public final int getCurrentUserCount() {
        return this.currentUserCount;
    }

    /* renamed from: component4, reason: from getter */
    public final int getUserCapacity() {
        return this.userCapacity;
    }

    public final RoomSeatInfo copy(long roomId, int appId, int currentUserCount, int userCapacity) {
        return new RoomSeatInfo(roomId, appId, currentUserCount, userCapacity);
    }

    public final int getAppId() {
        return this.appId;
    }

    public final int getCurrentUserCount() {
        return this.currentUserCount;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final int getUserCapacity() {
        return this.userCapacity;
    }

    public int hashCode() {
        return (((((c.a(this.roomId) * 31) + this.appId) * 31) + this.currentUserCount) * 31) + this.userCapacity;
    }

    public final boolean isFull() {
        return this.currentUserCount >= this.userCapacity;
    }

    public String toString() {
        return "RoomSeatInfo(roomId=" + this.roomId + ", appId=" + this.appId + ", currentUserCount=" + this.currentUserCount + ", userCapacity=" + this.userCapacity + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoomSeatInfo)) {
            return false;
        }
        RoomSeatInfo roomSeatInfo = (RoomSeatInfo) other;
        return this.roomId == roomSeatInfo.roomId && this.appId == roomSeatInfo.appId && this.currentUserCount == roomSeatInfo.currentUserCount && this.userCapacity == roomSeatInfo.userCapacity;
    }

    public static /* synthetic */ RoomSeatInfo copy$default(RoomSeatInfo roomSeatInfo, long j3, int i3, int i16, int i17, int i18, Object obj) {
        if ((i18 & 1) != 0) {
            j3 = roomSeatInfo.roomId;
        }
        long j16 = j3;
        if ((i18 & 2) != 0) {
            i3 = roomSeatInfo.appId;
        }
        int i19 = i3;
        if ((i18 & 4) != 0) {
            i16 = roomSeatInfo.currentUserCount;
        }
        int i26 = i16;
        if ((i18 & 8) != 0) {
            i17 = roomSeatInfo.userCapacity;
        }
        return roomSeatInfo.copy(j16, i19, i26, i17);
    }
}
