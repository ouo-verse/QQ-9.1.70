package com.tencent.biz.pubaccount.weishi.event;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/event/WSSpeedChangeEvent;", "Lcom/tencent/biz/pubaccount/weishi/event/WSSimpleBaseEvent;", "speed", "", "source", "", "(FI)V", "getSource", "()I", "getSpeed", "()F", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes32.dex */
public final /* data */ class WSSpeedChangeEvent extends WSSimpleBaseEvent {
    private final int source;
    private final float speed;

    public WSSpeedChangeEvent(float f16, int i3) {
        this.speed = f16;
        this.source = i3;
    }

    /* renamed from: component1, reason: from getter */
    public final float getSpeed() {
        return this.speed;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSource() {
        return this.source;
    }

    public final WSSpeedChangeEvent copy(float speed, int source) {
        return new WSSpeedChangeEvent(speed, source);
    }

    public final int getSource() {
        return this.source;
    }

    public final float getSpeed() {
        return this.speed;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.speed) * 31) + this.source;
    }

    public String toString() {
        return "WSSpeedChangeEvent(speed=" + this.speed + ", source=" + this.source + ")";
    }

    public static /* synthetic */ WSSpeedChangeEvent copy$default(WSSpeedChangeEvent wSSpeedChangeEvent, float f16, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            f16 = wSSpeedChangeEvent.speed;
        }
        if ((i16 & 2) != 0) {
            i3 = wSSpeedChangeEvent.source;
        }
        return wSSpeedChangeEvent.copy(f16, i3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WSSpeedChangeEvent)) {
            return false;
        }
        WSSpeedChangeEvent wSSpeedChangeEvent = (WSSpeedChangeEvent) other;
        return Float.compare(this.speed, wSSpeedChangeEvent.speed) == 0 && this.source == wSSpeedChangeEvent.source;
    }
}
