package com.tencent.filament.zplan.scene.square;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\t\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/OnObjectTappedEvent;", "Lcom/tencent/filament/zplan/scene/square/SquareMapEvent;", "", "component1", "Lcom/tencent/filament/zplan/scene/square/ObjectTapType;", "component2", "id", "type", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "Lcom/tencent/filament/zplan/scene/square/ObjectTapType;", "getType", "()Lcom/tencent/filament/zplan/scene/square/ObjectTapType;", "<init>", "(Ljava/lang/String;Lcom/tencent/filament/zplan/scene/square/ObjectTapType;)V", "Companion", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class OnObjectTappedEvent extends SquareMapEvent {

    @NotNull
    public static final String NAME = "SquareMapScene.EVENT_ON_OBJECT_TAPPED";

    @NotNull
    private final String id;

    @NotNull
    private final ObjectTapType type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnObjectTappedEvent(@NotNull String id5, @NotNull ObjectTapType type) {
        super(NAME);
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id5;
        this.type = type;
    }

    public static /* synthetic */ OnObjectTappedEvent copy$default(OnObjectTappedEvent onObjectTappedEvent, String str, ObjectTapType objectTapType, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = onObjectTappedEvent.id;
        }
        if ((i3 & 2) != 0) {
            objectTapType = onObjectTappedEvent.type;
        }
        return onObjectTappedEvent.copy(str, objectTapType);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final ObjectTapType getType() {
        return this.type;
    }

    @NotNull
    public final OnObjectTappedEvent copy(@NotNull String id5, @NotNull ObjectTapType type) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        return new OnObjectTappedEvent(id5, type);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof OnObjectTappedEvent) {
                OnObjectTappedEvent onObjectTappedEvent = (OnObjectTappedEvent) other;
                if (!Intrinsics.areEqual(this.id, onObjectTappedEvent.id) || !Intrinsics.areEqual(this.type, onObjectTappedEvent.type)) {
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
    public final ObjectTapType getType() {
        return this.type;
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
        ObjectTapType objectTapType = this.type;
        if (objectTapType != null) {
            i16 = objectTapType.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "OnObjectTappedEvent(id=" + this.id + ", type=" + this.type + ")";
    }
}
