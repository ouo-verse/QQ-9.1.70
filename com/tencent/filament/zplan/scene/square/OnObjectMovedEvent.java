package com.tencent.filament.zplan.scene.square;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\t\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/OnObjectMovedEvent;", "Lcom/tencent/filament/zplan/scene/square/SquareMapEvent;", "", "component1", "Lcom/tencent/filament/zplan/scene/square/Location;", "component2", "id", "location", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "Lcom/tencent/filament/zplan/scene/square/Location;", "getLocation", "()Lcom/tencent/filament/zplan/scene/square/Location;", "<init>", "(Ljava/lang/String;Lcom/tencent/filament/zplan/scene/square/Location;)V", "Companion", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class OnObjectMovedEvent extends SquareMapEvent {

    @NotNull
    public static final String NAME = "SquareMapScene.EVENT_ON_OBJECT_MOVED";

    @NotNull
    private final String id;

    @NotNull
    private final Location location;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnObjectMovedEvent(@NotNull String id5, @NotNull Location location) {
        super(NAME);
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(location, "location");
        this.id = id5;
        this.location = location;
    }

    public static /* synthetic */ OnObjectMovedEvent copy$default(OnObjectMovedEvent onObjectMovedEvent, String str, Location location, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = onObjectMovedEvent.id;
        }
        if ((i3 & 2) != 0) {
            location = onObjectMovedEvent.location;
        }
        return onObjectMovedEvent.copy(str, location);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final Location getLocation() {
        return this.location;
    }

    @NotNull
    public final OnObjectMovedEvent copy(@NotNull String id5, @NotNull Location location) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(location, "location");
        return new OnObjectMovedEvent(id5, location);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof OnObjectMovedEvent) {
                OnObjectMovedEvent onObjectMovedEvent = (OnObjectMovedEvent) other;
                if (!Intrinsics.areEqual(this.id, onObjectMovedEvent.id) || !Intrinsics.areEqual(this.location, onObjectMovedEvent.location)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final Location getLocation() {
        return this.location;
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
        Location location = this.location;
        if (location != null) {
            i16 = location.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "OnObjectMovedEvent(id=" + this.id + ", location=" + this.location + ")";
    }
}
