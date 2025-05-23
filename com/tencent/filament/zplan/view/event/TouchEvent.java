package com.tencent.filament.zplan.view.event;

import android.graphics.PointF;
import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\rJ\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\tH\u00c6\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0011J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0011JN\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u00c6\u0001\u00a2\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010%\u001a\u00020\u0007H\u00d6\u0001J\b\u0010&\u001a\u00020'H\u0016R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0019\u0010\u0011\u00a8\u0006("}, d2 = {"Lcom/tencent/filament/zplan/view/event/TouchEvent;", "", "type", "Lcom/tencent/filament/zplan/view/event/TouchEventType;", "state", "Lcom/tencent/filament/zplan/view/event/TouchEventState;", "touchCount", "", "location", "Landroid/graphics/PointF;", "velocity", "", "scale", "(Lcom/tencent/filament/zplan/view/event/TouchEventType;Lcom/tencent/filament/zplan/view/event/TouchEventState;ILandroid/graphics/PointF;Ljava/lang/Float;Ljava/lang/Float;)V", "getLocation", "()Landroid/graphics/PointF;", "getScale", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getState", "()Lcom/tencent/filament/zplan/view/event/TouchEventState;", "getTouchCount", "()I", "getType", "()Lcom/tencent/filament/zplan/view/event/TouchEventType;", "getVelocity", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/tencent/filament/zplan/view/event/TouchEventType;Lcom/tencent/filament/zplan/view/event/TouchEventState;ILandroid/graphics/PointF;Ljava/lang/Float;Ljava/lang/Float;)Lcom/tencent/filament/zplan/view/event/TouchEvent;", "equals", "", "other", "hashCode", "toString", "", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class TouchEvent {

    @SerializedName("location")
    @NotNull
    private final PointF location;

    @SerializedName("scale")
    @Nullable
    private final Float scale;

    @SerializedName("state")
    @NotNull
    private final TouchEventState state;

    @SerializedName("touchCount")
    private final int touchCount;

    @SerializedName("type")
    @NotNull
    private final TouchEventType type;

    @SerializedName("velocity")
    @Nullable
    private final Float velocity;

    public TouchEvent(@NotNull TouchEventType type, @NotNull TouchEventState state, int i3, @NotNull PointF location, @Nullable Float f16, @Nullable Float f17) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(location, "location");
        this.type = type;
        this.state = state;
        this.touchCount = i3;
        this.location = location;
        this.velocity = f16;
        this.scale = f17;
    }

    public static /* synthetic */ TouchEvent copy$default(TouchEvent touchEvent, TouchEventType touchEventType, TouchEventState touchEventState, int i3, PointF pointF, Float f16, Float f17, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            touchEventType = touchEvent.type;
        }
        if ((i16 & 2) != 0) {
            touchEventState = touchEvent.state;
        }
        TouchEventState touchEventState2 = touchEventState;
        if ((i16 & 4) != 0) {
            i3 = touchEvent.touchCount;
        }
        int i17 = i3;
        if ((i16 & 8) != 0) {
            pointF = touchEvent.location;
        }
        PointF pointF2 = pointF;
        if ((i16 & 16) != 0) {
            f16 = touchEvent.velocity;
        }
        Float f18 = f16;
        if ((i16 & 32) != 0) {
            f17 = touchEvent.scale;
        }
        return touchEvent.copy(touchEventType, touchEventState2, i17, pointF2, f18, f17);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final TouchEventType getType() {
        return this.type;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final TouchEventState getState() {
        return this.state;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTouchCount() {
        return this.touchCount;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final PointF getLocation() {
        return this.location;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Float getVelocity() {
        return this.velocity;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Float getScale() {
        return this.scale;
    }

    @NotNull
    public final TouchEvent copy(@NotNull TouchEventType type, @NotNull TouchEventState state, int touchCount, @NotNull PointF location, @Nullable Float velocity, @Nullable Float scale) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(location, "location");
        return new TouchEvent(type, state, touchCount, location, velocity, scale);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof TouchEvent) {
                TouchEvent touchEvent = (TouchEvent) other;
                if (!Intrinsics.areEqual(this.type, touchEvent.type) || !Intrinsics.areEqual(this.state, touchEvent.state) || this.touchCount != touchEvent.touchCount || !Intrinsics.areEqual(this.location, touchEvent.location) || !Intrinsics.areEqual((Object) this.velocity, (Object) touchEvent.velocity) || !Intrinsics.areEqual((Object) this.scale, (Object) touchEvent.scale)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final PointF getLocation() {
        return this.location;
    }

    @Nullable
    public final Float getScale() {
        return this.scale;
    }

    @NotNull
    public final TouchEventState getState() {
        return this.state;
    }

    public final int getTouchCount() {
        return this.touchCount;
    }

    @NotNull
    public final TouchEventType getType() {
        return this.type;
    }

    @Nullable
    public final Float getVelocity() {
        return this.velocity;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        TouchEventType touchEventType = this.type;
        int i19 = 0;
        if (touchEventType != null) {
            i3 = touchEventType.hashCode();
        } else {
            i3 = 0;
        }
        int i26 = i3 * 31;
        TouchEventState touchEventState = this.state;
        if (touchEventState != null) {
            i16 = touchEventState.hashCode();
        } else {
            i16 = 0;
        }
        int i27 = (((i26 + i16) * 31) + this.touchCount) * 31;
        PointF pointF = this.location;
        if (pointF != null) {
            i17 = pointF.hashCode();
        } else {
            i17 = 0;
        }
        int i28 = (i27 + i17) * 31;
        Float f16 = this.velocity;
        if (f16 != null) {
            i18 = f16.hashCode();
        } else {
            i18 = 0;
        }
        int i29 = (i28 + i18) * 31;
        Float f17 = this.scale;
        if (f17 != null) {
            i19 = f17.hashCode();
        }
        return i29 + i19;
    }

    @NotNull
    public String toString() {
        return "type: " + this.type + ", state: " + this.state.toTouchEventIntState() + ", touchCount: " + this.touchCount + ", location: " + this.location + ", velocity: " + this.velocity + ", scale: " + this.scale;
    }

    public /* synthetic */ TouchEvent(TouchEventType touchEventType, TouchEventState touchEventState, int i3, PointF pointF, Float f16, Float f17, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(touchEventType, touchEventState, i3, pointF, (i16 & 16) != 0 ? null : f16, (i16 & 32) != 0 ? null : f17);
    }
}
