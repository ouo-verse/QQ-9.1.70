package com.tencent.filament.zplan.scene.square;

import androidx.annotation.Keep;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001f\b\u0087\b\u0018\u0000 :2\u00020\u0001:\u0001;BG\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b8\u00109J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\t\u001a\u00020\bH\u00c6\u0003J\t\u0010\u000b\u001a\u00020\nH\u00c6\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003JS\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\n2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u00c6\u0001J\t\u0010\u0018\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0019H\u00d6\u0001J\u0013\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u0012\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\u0013\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010\u0014\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010+\u001a\u0004\b,\u0010-R$\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u0010\u0016\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107\u00a8\u0006<"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/AddObjectEvent;", "Lcom/tencent/filament/zplan/scene/square/SquareMapEvent;", "", "component1", "Lcom/tencent/filament/zplan/scene/square/ObjectType;", "component2", "Lcom/tencent/filament/zplan/scene/square/Location;", "component3", "Lcom/tencent/filament/zplan/scene/square/Size;", "component4", "", "component5", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData;", "component6", "Lcom/tencent/filament/zplan/scene/square/SquareImageData;", "component7", "id", "type", "location", "size", "depth", "avatarResource", "imageResource", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "Lcom/tencent/filament/zplan/scene/square/ObjectType;", "getType", "()Lcom/tencent/filament/zplan/scene/square/ObjectType;", "Lcom/tencent/filament/zplan/scene/square/Location;", "getLocation", "()Lcom/tencent/filament/zplan/scene/square/Location;", "Lcom/tencent/filament/zplan/scene/square/Size;", "getSize", "()Lcom/tencent/filament/zplan/scene/square/Size;", UserInfo.SEX_FEMALE, "getDepth", "()F", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData;", "getAvatarResource", "()Lcom/tencent/filament/zplan/scene/square/SquareAvatarData;", "setAvatarResource", "(Lcom/tencent/filament/zplan/scene/square/SquareAvatarData;)V", "Lcom/tencent/filament/zplan/scene/square/SquareImageData;", "getImageResource", "()Lcom/tencent/filament/zplan/scene/square/SquareImageData;", "setImageResource", "(Lcom/tencent/filament/zplan/scene/square/SquareImageData;)V", "<init>", "(Ljava/lang/String;Lcom/tencent/filament/zplan/scene/square/ObjectType;Lcom/tencent/filament/zplan/scene/square/Location;Lcom/tencent/filament/zplan/scene/square/Size;FLcom/tencent/filament/zplan/scene/square/SquareAvatarData;Lcom/tencent/filament/zplan/scene/square/SquareImageData;)V", "Companion", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class AddObjectEvent extends SquareMapEvent {

    @NotNull
    public static final String NAME = "SquareMapScene.EVENT_ON_ADD_OBJECT";

    @Nullable
    private SquareAvatarData avatarResource;
    private final float depth;

    @NotNull
    private final String id;

    @Nullable
    private SquareImageData imageResource;

    @NotNull
    private final Location location;

    @NotNull
    private final Size size;

    @NotNull
    private final ObjectType type;

    public /* synthetic */ AddObjectEvent(String str, ObjectType objectType, Location location, Size size, float f16, SquareAvatarData squareAvatarData, SquareImageData squareImageData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, objectType, location, size, f16, (i3 & 32) != 0 ? null : squareAvatarData, (i3 & 64) != 0 ? null : squareImageData);
    }

    public static /* synthetic */ AddObjectEvent copy$default(AddObjectEvent addObjectEvent, String str, ObjectType objectType, Location location, Size size, float f16, SquareAvatarData squareAvatarData, SquareImageData squareImageData, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = addObjectEvent.id;
        }
        if ((i3 & 2) != 0) {
            objectType = addObjectEvent.type;
        }
        ObjectType objectType2 = objectType;
        if ((i3 & 4) != 0) {
            location = addObjectEvent.location;
        }
        Location location2 = location;
        if ((i3 & 8) != 0) {
            size = addObjectEvent.size;
        }
        Size size2 = size;
        if ((i3 & 16) != 0) {
            f16 = addObjectEvent.depth;
        }
        float f17 = f16;
        if ((i3 & 32) != 0) {
            squareAvatarData = addObjectEvent.avatarResource;
        }
        SquareAvatarData squareAvatarData2 = squareAvatarData;
        if ((i3 & 64) != 0) {
            squareImageData = addObjectEvent.imageResource;
        }
        return addObjectEvent.copy(str, objectType2, location2, size2, f17, squareAvatarData2, squareImageData);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final ObjectType getType() {
        return this.type;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final Location getLocation() {
        return this.location;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final Size getSize() {
        return this.size;
    }

    /* renamed from: component5, reason: from getter */
    public final float getDepth() {
        return this.depth;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final SquareAvatarData getAvatarResource() {
        return this.avatarResource;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final SquareImageData getImageResource() {
        return this.imageResource;
    }

    @NotNull
    public final AddObjectEvent copy(@NotNull String id5, @NotNull ObjectType type, @NotNull Location location, @NotNull Size size, float depth, @Nullable SquareAvatarData avatarResource, @Nullable SquareImageData imageResource) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(size, "size");
        return new AddObjectEvent(id5, type, location, size, depth, avatarResource, imageResource);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof AddObjectEvent) {
                AddObjectEvent addObjectEvent = (AddObjectEvent) other;
                if (!Intrinsics.areEqual(this.id, addObjectEvent.id) || !Intrinsics.areEqual(this.type, addObjectEvent.type) || !Intrinsics.areEqual(this.location, addObjectEvent.location) || !Intrinsics.areEqual(this.size, addObjectEvent.size) || Float.compare(this.depth, addObjectEvent.depth) != 0 || !Intrinsics.areEqual(this.avatarResource, addObjectEvent.avatarResource) || !Intrinsics.areEqual(this.imageResource, addObjectEvent.imageResource)) {
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

    public final float getDepth() {
        return this.depth;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final SquareImageData getImageResource() {
        return this.imageResource;
    }

    @NotNull
    public final Location getLocation() {
        return this.location;
    }

    @NotNull
    public final Size getSize() {
        return this.size;
    }

    @NotNull
    public final ObjectType getType() {
        return this.type;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        String str = this.id;
        int i26 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i27 = i3 * 31;
        ObjectType objectType = this.type;
        if (objectType != null) {
            i16 = objectType.hashCode();
        } else {
            i16 = 0;
        }
        int i28 = (i27 + i16) * 31;
        Location location = this.location;
        if (location != null) {
            i17 = location.hashCode();
        } else {
            i17 = 0;
        }
        int i29 = (i28 + i17) * 31;
        Size size = this.size;
        if (size != null) {
            i18 = size.hashCode();
        } else {
            i18 = 0;
        }
        int floatToIntBits = (((i29 + i18) * 31) + Float.floatToIntBits(this.depth)) * 31;
        SquareAvatarData squareAvatarData = this.avatarResource;
        if (squareAvatarData != null) {
            i19 = squareAvatarData.hashCode();
        } else {
            i19 = 0;
        }
        int i36 = (floatToIntBits + i19) * 31;
        SquareImageData squareImageData = this.imageResource;
        if (squareImageData != null) {
            i26 = squareImageData.hashCode();
        }
        return i36 + i26;
    }

    public final void setAvatarResource(@Nullable SquareAvatarData squareAvatarData) {
        this.avatarResource = squareAvatarData;
    }

    public final void setImageResource(@Nullable SquareImageData squareImageData) {
        this.imageResource = squareImageData;
    }

    @NotNull
    public String toString() {
        return "AddObjectEvent(id=" + this.id + ", type=" + this.type + ", location=" + this.location + ", size=" + this.size + ", depth=" + this.depth + ", avatarResource=" + this.avatarResource + ", imageResource=" + this.imageResource + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddObjectEvent(@NotNull String id5, @NotNull ObjectType type, @NotNull Location location, @NotNull Size size, float f16, @Nullable SquareAvatarData squareAvatarData, @Nullable SquareImageData squareImageData) {
        super(NAME);
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(size, "size");
        this.id = id5;
        this.type = type;
        this.location = location;
        this.size = size;
        this.depth = f16;
        this.avatarResource = squareAvatarData;
        this.imageResource = squareImageData;
    }
}
