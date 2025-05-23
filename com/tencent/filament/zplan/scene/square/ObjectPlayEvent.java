package com.tencent.filament.zplan.scene.square;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u0006\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u00d6\u0003R\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/ObjectPlayEvent;", "Lcom/tencent/filament/zplan/scene/square/SquareMapEvent;", "", "component1", "id", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class ObjectPlayEvent extends SquareMapEvent {

    @NotNull
    public static final String NAME = "SquareMapScene.EVENT_ON_OBJECT_PLAY";

    @NotNull
    private final String id;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObjectPlayEvent(@NotNull String id5) {
        super(NAME);
        Intrinsics.checkNotNullParameter(id5, "id");
        this.id = id5;
    }

    public static /* synthetic */ ObjectPlayEvent copy$default(ObjectPlayEvent objectPlayEvent, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = objectPlayEvent.id;
        }
        return objectPlayEvent.copy(str);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final ObjectPlayEvent copy(@NotNull String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        return new ObjectPlayEvent(id5);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (!(other instanceof ObjectPlayEvent) || !Intrinsics.areEqual(this.id, ((ObjectPlayEvent) other).id)) {
                return false;
            }
            return true;
        }
        return true;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public int hashCode() {
        String str = this.id;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "ObjectPlayEvent(id=" + this.id + ")";
    }
}
