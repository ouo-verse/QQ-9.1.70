package com.tencent.mobileqq.icgame.base.baseroom.enterexitroom;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/icgame/base/baseroom/enterexitroom/d;", "Lg32/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "c", "J", "()J", "roomId", "<init>", "(J)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.d, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class EnterRoomSuccessEvent extends g32.b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long roomId;

    public EnterRoomSuccessEvent(long j3) {
        this.roomId = j3;
    }

    /* renamed from: c, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof EnterRoomSuccessEvent) && this.roomId == ((EnterRoomSuccessEvent) other).roomId) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return androidx.fragment.app.a.a(this.roomId);
    }

    @NotNull
    public String toString() {
        return "EnterRoomSuccessEvent(roomId=" + this.roomId + ")";
    }
}
