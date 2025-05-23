package com.tencent.filament.zplan.scene.square;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u00d6\u0003R\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/OnViewportChangedEvent;", "Lcom/tencent/filament/zplan/scene/square/SquareMapEvent;", "Lcom/tencent/filament/zplan/scene/square/ViewportInfo;", "component1", "viewport", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/filament/zplan/scene/square/ViewportInfo;", "getViewport", "()Lcom/tencent/filament/zplan/scene/square/ViewportInfo;", "<init>", "(Lcom/tencent/filament/zplan/scene/square/ViewportInfo;)V", "Companion", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class OnViewportChangedEvent extends SquareMapEvent {

    @NotNull
    public static final String NAME = "SquareMapScene.EVENT_ON_VIEWPORT_CHANGED";

    @NotNull
    private final ViewportInfo viewport;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnViewportChangedEvent(@NotNull ViewportInfo viewport) {
        super(NAME);
        Intrinsics.checkNotNullParameter(viewport, "viewport");
        this.viewport = viewport;
    }

    public static /* synthetic */ OnViewportChangedEvent copy$default(OnViewportChangedEvent onViewportChangedEvent, ViewportInfo viewportInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            viewportInfo = onViewportChangedEvent.viewport;
        }
        return onViewportChangedEvent.copy(viewportInfo);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final ViewportInfo getViewport() {
        return this.viewport;
    }

    @NotNull
    public final OnViewportChangedEvent copy(@NotNull ViewportInfo viewport) {
        Intrinsics.checkNotNullParameter(viewport, "viewport");
        return new OnViewportChangedEvent(viewport);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (!(other instanceof OnViewportChangedEvent) || !Intrinsics.areEqual(this.viewport, ((OnViewportChangedEvent) other).viewport)) {
                return false;
            }
            return true;
        }
        return true;
    }

    @NotNull
    public final ViewportInfo getViewport() {
        return this.viewport;
    }

    public int hashCode() {
        ViewportInfo viewportInfo = this.viewport;
        if (viewportInfo != null) {
            return viewportInfo.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "OnViewportChangedEvent(viewport=" + this.viewport + ")";
    }
}
