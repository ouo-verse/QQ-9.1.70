package com.tencent.biz.pubaccount.weishi.event;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/event/WSSpeedPlayEvent;", "Lcom/tencent/biz/pubaccount/weishi/event/WSSimpleBaseEvent;", "isActive", "", "speed", "", "code", "", "(ZFI)V", "getCode", "()I", "()Z", "getSpeed", "()F", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes32.dex */
public final /* data */ class WSSpeedPlayEvent extends WSSimpleBaseEvent {
    private final int code;
    private final boolean isActive;
    private final float speed;

    public WSSpeedPlayEvent(boolean z16, float f16, int i3) {
        this.isActive = z16;
        this.speed = f16;
        this.code = i3;
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    /* renamed from: component2, reason: from getter */
    public final float getSpeed() {
        return this.speed;
    }

    /* renamed from: component3, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    public final WSSpeedPlayEvent copy(boolean isActive, float speed, int code) {
        return new WSSpeedPlayEvent(isActive, speed, code);
    }

    public final int getCode() {
        return this.code;
    }

    public final float getSpeed() {
        return this.speed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.isActive;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((r06 * 31) + Float.floatToIntBits(this.speed)) * 31) + this.code;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public String toString() {
        return "WSSpeedPlayEvent(isActive=" + this.isActive + ", speed=" + this.speed + ", code=" + this.code + ")";
    }

    public static /* synthetic */ WSSpeedPlayEvent copy$default(WSSpeedPlayEvent wSSpeedPlayEvent, boolean z16, float f16, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            z16 = wSSpeedPlayEvent.isActive;
        }
        if ((i16 & 2) != 0) {
            f16 = wSSpeedPlayEvent.speed;
        }
        if ((i16 & 4) != 0) {
            i3 = wSSpeedPlayEvent.code;
        }
        return wSSpeedPlayEvent.copy(z16, f16, i3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WSSpeedPlayEvent)) {
            return false;
        }
        WSSpeedPlayEvent wSSpeedPlayEvent = (WSSpeedPlayEvent) other;
        return this.isActive == wSSpeedPlayEvent.isActive && Float.compare(this.speed, wSSpeedPlayEvent.speed) == 0 && this.code == wSSpeedPlayEvent.code;
    }
}
