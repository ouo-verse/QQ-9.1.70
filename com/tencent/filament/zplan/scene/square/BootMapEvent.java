package com.tencent.filament.zplan.scene.square;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\u001d\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0005\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0013\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/BootMapEvent;", "Lcom/tencent/filament/zplan/scene/square/SquareMapEvent;", "Lcom/tencent/filament/zplan/scene/square/Size;", "component1", "component2", "mapSize", "viewportSize", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/filament/zplan/scene/square/Size;", "getMapSize", "()Lcom/tencent/filament/zplan/scene/square/Size;", "getViewportSize", "<init>", "(Lcom/tencent/filament/zplan/scene/square/Size;Lcom/tencent/filament/zplan/scene/square/Size;)V", "Companion", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class BootMapEvent extends SquareMapEvent {

    @NotNull
    public static final String NAME = "SquareMapScene.EVENT_ON_BOOT_MAP";

    @NotNull
    private final Size mapSize;

    @NotNull
    private final Size viewportSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BootMapEvent(@NotNull Size mapSize, @NotNull Size viewportSize) {
        super(NAME);
        Intrinsics.checkNotNullParameter(mapSize, "mapSize");
        Intrinsics.checkNotNullParameter(viewportSize, "viewportSize");
        this.mapSize = mapSize;
        this.viewportSize = viewportSize;
    }

    public static /* synthetic */ BootMapEvent copy$default(BootMapEvent bootMapEvent, Size size, Size size2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            size = bootMapEvent.mapSize;
        }
        if ((i3 & 2) != 0) {
            size2 = bootMapEvent.viewportSize;
        }
        return bootMapEvent.copy(size, size2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final Size getMapSize() {
        return this.mapSize;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final Size getViewportSize() {
        return this.viewportSize;
    }

    @NotNull
    public final BootMapEvent copy(@NotNull Size mapSize, @NotNull Size viewportSize) {
        Intrinsics.checkNotNullParameter(mapSize, "mapSize");
        Intrinsics.checkNotNullParameter(viewportSize, "viewportSize");
        return new BootMapEvent(mapSize, viewportSize);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof BootMapEvent) {
                BootMapEvent bootMapEvent = (BootMapEvent) other;
                if (!Intrinsics.areEqual(this.mapSize, bootMapEvent.mapSize) || !Intrinsics.areEqual(this.viewportSize, bootMapEvent.viewportSize)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final Size getMapSize() {
        return this.mapSize;
    }

    @NotNull
    public final Size getViewportSize() {
        return this.viewportSize;
    }

    public int hashCode() {
        int i3;
        Size size = this.mapSize;
        int i16 = 0;
        if (size != null) {
            i3 = size.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        Size size2 = this.viewportSize;
        if (size2 != null) {
            i16 = size2.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "BootMapEvent(mapSize=" + this.mapSize + ", viewportSize=" + this.viewportSize + ")";
    }
}
