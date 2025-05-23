package com.tencent.filament.zplan.scene.square;

import androidx.annotation.Keep;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\r\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\t\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/ObjectUpdateVisibleEvent;", "Lcom/tencent/filament/zplan/scene/square/SquareMapEvent;", "", "component1", "", "component2", "id", NodeProps.VISIBLE, "copy", "toString", "", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "Z", "getVisible", "()Z", "<init>", "(Ljava/lang/String;Z)V", "Companion", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class ObjectUpdateVisibleEvent extends SquareMapEvent {

    @NotNull
    public static final String NAME = "SquareMapScene.EVENT_ON_OBJECT_UPDATE_VISIBLE";

    @NotNull
    private final String id;
    private final boolean visible;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObjectUpdateVisibleEvent(@NotNull String id5, boolean z16) {
        super(NAME);
        Intrinsics.checkNotNullParameter(id5, "id");
        this.id = id5;
        this.visible = z16;
    }

    public static /* synthetic */ ObjectUpdateVisibleEvent copy$default(ObjectUpdateVisibleEvent objectUpdateVisibleEvent, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = objectUpdateVisibleEvent.id;
        }
        if ((i3 & 2) != 0) {
            z16 = objectUpdateVisibleEvent.visible;
        }
        return objectUpdateVisibleEvent.copy(str, z16);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getVisible() {
        return this.visible;
    }

    @NotNull
    public final ObjectUpdateVisibleEvent copy(@NotNull String id5, boolean visible) {
        Intrinsics.checkNotNullParameter(id5, "id");
        return new ObjectUpdateVisibleEvent(id5, visible);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ObjectUpdateVisibleEvent) {
                ObjectUpdateVisibleEvent objectUpdateVisibleEvent = (ObjectUpdateVisibleEvent) other;
                if (!Intrinsics.areEqual(this.id, objectUpdateVisibleEvent.id) || this.visible != objectUpdateVisibleEvent.visible) {
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

    public final boolean getVisible() {
        return this.visible;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        String str = this.id;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i16 = i3 * 31;
        boolean z16 = this.visible;
        int i17 = z16;
        if (z16 != 0) {
            i17 = 1;
        }
        return i16 + i17;
    }

    @NotNull
    public String toString() {
        return "ObjectUpdateVisibleEvent(id=" + this.id + ", visible=" + this.visible + ")";
    }
}
