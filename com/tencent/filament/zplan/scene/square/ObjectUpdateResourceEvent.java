package com.tencent.filament.zplan.scene.square;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0001#B'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J+\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001J\t\u0010\f\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\rH\u00d6\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R$\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/ObjectUpdateResourceEvent;", "Lcom/tencent/filament/zplan/scene/square/SquareMapEvent;", "", "component1", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData;", "component2", "Lcom/tencent/filament/zplan/scene/square/SquareImageData;", "component3", "id", "avatarResource", "imageResource", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData;", "getAvatarResource", "()Lcom/tencent/filament/zplan/scene/square/SquareAvatarData;", "setAvatarResource", "(Lcom/tencent/filament/zplan/scene/square/SquareAvatarData;)V", "Lcom/tencent/filament/zplan/scene/square/SquareImageData;", "getImageResource", "()Lcom/tencent/filament/zplan/scene/square/SquareImageData;", "setImageResource", "(Lcom/tencent/filament/zplan/scene/square/SquareImageData;)V", "<init>", "(Ljava/lang/String;Lcom/tencent/filament/zplan/scene/square/SquareAvatarData;Lcom/tencent/filament/zplan/scene/square/SquareImageData;)V", "Companion", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class ObjectUpdateResourceEvent extends SquareMapEvent {

    @NotNull
    public static final String NAME = "SquareMapScene.EVENT_ON_OBJECT_UPDATE";

    @Nullable
    private SquareAvatarData avatarResource;

    @NotNull
    private final String id;

    @Nullable
    private SquareImageData imageResource;

    public /* synthetic */ ObjectUpdateResourceEvent(String str, SquareAvatarData squareAvatarData, SquareImageData squareImageData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : squareAvatarData, (i3 & 4) != 0 ? null : squareImageData);
    }

    public static /* synthetic */ ObjectUpdateResourceEvent copy$default(ObjectUpdateResourceEvent objectUpdateResourceEvent, String str, SquareAvatarData squareAvatarData, SquareImageData squareImageData, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = objectUpdateResourceEvent.id;
        }
        if ((i3 & 2) != 0) {
            squareAvatarData = objectUpdateResourceEvent.avatarResource;
        }
        if ((i3 & 4) != 0) {
            squareImageData = objectUpdateResourceEvent.imageResource;
        }
        return objectUpdateResourceEvent.copy(str, squareAvatarData, squareImageData);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final SquareAvatarData getAvatarResource() {
        return this.avatarResource;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final SquareImageData getImageResource() {
        return this.imageResource;
    }

    @NotNull
    public final ObjectUpdateResourceEvent copy(@NotNull String id5, @Nullable SquareAvatarData avatarResource, @Nullable SquareImageData imageResource) {
        Intrinsics.checkNotNullParameter(id5, "id");
        return new ObjectUpdateResourceEvent(id5, avatarResource, imageResource);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ObjectUpdateResourceEvent) {
                ObjectUpdateResourceEvent objectUpdateResourceEvent = (ObjectUpdateResourceEvent) other;
                if (!Intrinsics.areEqual(this.id, objectUpdateResourceEvent.id) || !Intrinsics.areEqual(this.avatarResource, objectUpdateResourceEvent.avatarResource) || !Intrinsics.areEqual(this.imageResource, objectUpdateResourceEvent.imageResource)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final SquareAvatarData getAvatarResource() {
        return this.avatarResource;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final SquareImageData getImageResource() {
        return this.imageResource;
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
        SquareAvatarData squareAvatarData = this.avatarResource;
        if (squareAvatarData != null) {
            i16 = squareAvatarData.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        SquareImageData squareImageData = this.imageResource;
        if (squareImageData != null) {
            i17 = squareImageData.hashCode();
        }
        return i19 + i17;
    }

    public final void setAvatarResource(@Nullable SquareAvatarData squareAvatarData) {
        this.avatarResource = squareAvatarData;
    }

    public final void setImageResource(@Nullable SquareImageData squareImageData) {
        this.imageResource = squareImageData;
    }

    @NotNull
    public String toString() {
        return "ObjectUpdateResourceEvent(id=" + this.id + ", avatarResource=" + this.avatarResource + ", imageResource=" + this.imageResource + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObjectUpdateResourceEvent(@NotNull String id5, @Nullable SquareAvatarData squareAvatarData, @Nullable SquareImageData squareImageData) {
        super(NAME);
        Intrinsics.checkNotNullParameter(id5, "id");
        this.id = id5;
        this.avatarResource = squareAvatarData;
        this.imageResource = squareImageData;
    }
}
