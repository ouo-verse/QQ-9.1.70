package com.tencent.filament.zplan.scene.square;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB#\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J)\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001J\t\u0010\f\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\rH\u00d6\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/filament/zplan/scene/square/OnObjectStateChangedEvent;", "Lcom/tencent/filament/zplan/scene/square/SquareMapEvent;", "", "component1", "Lcom/tencent/filament/zplan/scene/square/ObjectState;", "component2", "Lcom/tencent/filament/zplan/scene/square/SquareLoadObjectStatistics;", "component3", "id", "state", "loadStatistics", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "Lcom/tencent/filament/zplan/scene/square/ObjectState;", "getState", "()Lcom/tencent/filament/zplan/scene/square/ObjectState;", "Lcom/tencent/filament/zplan/scene/square/SquareLoadObjectStatistics;", "getLoadStatistics", "()Lcom/tencent/filament/zplan/scene/square/SquareLoadObjectStatistics;", "<init>", "(Ljava/lang/String;Lcom/tencent/filament/zplan/scene/square/ObjectState;Lcom/tencent/filament/zplan/scene/square/SquareLoadObjectStatistics;)V", "Companion", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class OnObjectStateChangedEvent extends SquareMapEvent {

    @NotNull
    public static final String NAME = "SquareMapScene.EVENT_ON_OBJECT_STATE_CHANGED";

    @NotNull
    private final String id;

    @Nullable
    private final SquareLoadObjectStatistics loadStatistics;

    @NotNull
    private final ObjectState state;

    public /* synthetic */ OnObjectStateChangedEvent(String str, ObjectState objectState, SquareLoadObjectStatistics squareLoadObjectStatistics, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, objectState, (i3 & 4) != 0 ? null : squareLoadObjectStatistics);
    }

    public static /* synthetic */ OnObjectStateChangedEvent copy$default(OnObjectStateChangedEvent onObjectStateChangedEvent, String str, ObjectState objectState, SquareLoadObjectStatistics squareLoadObjectStatistics, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = onObjectStateChangedEvent.id;
        }
        if ((i3 & 2) != 0) {
            objectState = onObjectStateChangedEvent.state;
        }
        if ((i3 & 4) != 0) {
            squareLoadObjectStatistics = onObjectStateChangedEvent.loadStatistics;
        }
        return onObjectStateChangedEvent.copy(str, objectState, squareLoadObjectStatistics);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final ObjectState getState() {
        return this.state;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final SquareLoadObjectStatistics getLoadStatistics() {
        return this.loadStatistics;
    }

    @NotNull
    public final OnObjectStateChangedEvent copy(@NotNull String id5, @NotNull ObjectState state, @Nullable SquareLoadObjectStatistics loadStatistics) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(state, "state");
        return new OnObjectStateChangedEvent(id5, state, loadStatistics);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof OnObjectStateChangedEvent) {
                OnObjectStateChangedEvent onObjectStateChangedEvent = (OnObjectStateChangedEvent) other;
                if (!Intrinsics.areEqual(this.id, onObjectStateChangedEvent.id) || !Intrinsics.areEqual(this.state, onObjectStateChangedEvent.state) || !Intrinsics.areEqual(this.loadStatistics, onObjectStateChangedEvent.loadStatistics)) {
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

    @Nullable
    public final SquareLoadObjectStatistics getLoadStatistics() {
        return this.loadStatistics;
    }

    @NotNull
    public final ObjectState getState() {
        return this.state;
    }

    public int hashCode() {
        int i3;
        int i16;
        String str = this.id;
        int i17 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = i3 * 31;
        ObjectState objectState = this.state;
        if (objectState != null) {
            i16 = objectState.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        SquareLoadObjectStatistics squareLoadObjectStatistics = this.loadStatistics;
        if (squareLoadObjectStatistics != null) {
            i17 = squareLoadObjectStatistics.hashCode();
        }
        return i19 + i17;
    }

    @NotNull
    public String toString() {
        return "OnObjectStateChangedEvent(id=" + this.id + ", state=" + this.state + ", loadStatistics=" + this.loadStatistics + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnObjectStateChangedEvent(@NotNull String id5, @NotNull ObjectState state, @Nullable SquareLoadObjectStatistics squareLoadObjectStatistics) {
        super(NAME);
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(state, "state");
        this.id = id5;
        this.state = state;
        this.loadStatistics = squareLoadObjectStatistics;
    }
}
