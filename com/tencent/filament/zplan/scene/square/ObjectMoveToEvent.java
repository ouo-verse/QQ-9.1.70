package com.tencent.filament.zplan.scene.square;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u001f\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J'\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0006H\u00c6\u0001J\t\u0010\f\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\rH\u00d6\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/filament/zplan/scene/square/ObjectMoveToEvent;", "Lcom/tencent/filament/zplan/scene/square/SquareMapEvent;", "", "component1", "Lcom/tencent/filament/zplan/scene/square/Location;", "component2", "", "component3", "id", "targetLocation", "duration", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "Lcom/tencent/filament/zplan/scene/square/Location;", "getTargetLocation", "()Lcom/tencent/filament/zplan/scene/square/Location;", "J", "getDuration", "()J", "<init>", "(Ljava/lang/String;Lcom/tencent/filament/zplan/scene/square/Location;J)V", "Companion", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class ObjectMoveToEvent extends SquareMapEvent {

    @NotNull
    public static final String NAME = "SquareMapScene.EVENT_ON_OBJECT_MOVE_TO";
    private final long duration;

    @NotNull
    private final String id;

    @NotNull
    private final Location targetLocation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObjectMoveToEvent(@NotNull String id5, @NotNull Location targetLocation, long j3) {
        super(NAME);
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(targetLocation, "targetLocation");
        this.id = id5;
        this.targetLocation = targetLocation;
        this.duration = j3;
    }

    public static /* synthetic */ ObjectMoveToEvent copy$default(ObjectMoveToEvent objectMoveToEvent, String str, Location location, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = objectMoveToEvent.id;
        }
        if ((i3 & 2) != 0) {
            location = objectMoveToEvent.targetLocation;
        }
        if ((i3 & 4) != 0) {
            j3 = objectMoveToEvent.duration;
        }
        return objectMoveToEvent.copy(str, location, j3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final Location getTargetLocation() {
        return this.targetLocation;
    }

    /* renamed from: component3, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    public final ObjectMoveToEvent copy(@NotNull String id5, @NotNull Location targetLocation, long duration) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(targetLocation, "targetLocation");
        return new ObjectMoveToEvent(id5, targetLocation, duration);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ObjectMoveToEvent) {
                ObjectMoveToEvent objectMoveToEvent = (ObjectMoveToEvent) other;
                if (!Intrinsics.areEqual(this.id, objectMoveToEvent.id) || !Intrinsics.areEqual(this.targetLocation, objectMoveToEvent.targetLocation) || this.duration != objectMoveToEvent.duration) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final Location getTargetLocation() {
        return this.targetLocation;
    }

    public int hashCode() {
        int i3;
        String str = this.id;
        int i16 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        Location location = this.targetLocation;
        if (location != null) {
            i16 = location.hashCode();
        }
        int i18 = (i17 + i16) * 31;
        long j3 = this.duration;
        return i18 + ((int) (j3 ^ (j3 >>> 32)));
    }

    @NotNull
    public String toString() {
        return "ObjectMoveToEvent(id=" + this.id + ", targetLocation=" + this.targetLocation + ", duration=" + this.duration + ")";
    }
}
