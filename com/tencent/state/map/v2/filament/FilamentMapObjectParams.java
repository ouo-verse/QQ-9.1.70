package com.tencent.state.map.v2.filament;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.state.map.v2.Location;
import com.tencent.state.map.v2.ObjectParams;
import com.tencent.state.map.v2.ObjectType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\t\u0010 \u001a\u00020\rH\u00c6\u0003JI\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u00c6\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u00d6\u0003J\t\u0010&\u001a\u00020'H\u00d6\u0001J\u000e\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\u0000J\b\u0010*\u001a\u00020#H\u0016J\t\u0010+\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006,"}, d2 = {"Lcom/tencent/state/map/v2/filament/FilamentMapObjectParams;", "Lcom/tencent/state/map/v2/ObjectParams;", "id", "", "type", "Lcom/tencent/state/map/v2/ObjectType;", "location", "Lcom/tencent/state/map/v2/Location;", "avatarResource", "Lcom/tencent/state/map/v2/filament/AvatarResource;", "imageResource", "Lcom/tencent/state/map/v2/filament/ImageResource;", "depth", "", "(Ljava/lang/String;Lcom/tencent/state/map/v2/ObjectType;Lcom/tencent/state/map/v2/Location;Lcom/tencent/state/map/v2/filament/AvatarResource;Lcom/tencent/state/map/v2/filament/ImageResource;F)V", "getAvatarResource", "()Lcom/tencent/state/map/v2/filament/AvatarResource;", "getDepth", "()F", "getId", "()Ljava/lang/String;", "getImageResource", "()Lcom/tencent/state/map/v2/filament/ImageResource;", "getLocation", "()Lcom/tencent/state/map/v2/Location;", "getType", "()Lcom/tencent/state/map/v2/ObjectType;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "isChange", "check", AppConstants.Key.COLUMN_IS_VALID, "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final /* data */ class FilamentMapObjectParams implements ObjectParams {
    private final AvatarResource avatarResource;
    private final float depth;
    private final String id;
    private final ImageResource imageResource;
    private final Location location;
    private final ObjectType type;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ObjectType.values().length];
            $EnumSwitchMapping$0 = iArr;
            ObjectType objectType = ObjectType.AVATAR;
            iArr[objectType.ordinal()] = 1;
            ObjectType objectType2 = ObjectType.IMAGE;
            iArr[objectType2.ordinal()] = 2;
            int[] iArr2 = new int[ObjectType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[objectType.ordinal()] = 1;
            iArr2[objectType2.ordinal()] = 2;
        }
    }

    public FilamentMapObjectParams(String id5, ObjectType type, Location location, AvatarResource avatarResource, ImageResource imageResource, float f16) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(location, "location");
        this.id = id5;
        this.type = type;
        this.location = location;
        this.avatarResource = avatarResource;
        this.imageResource = imageResource;
        this.depth = f16;
    }

    public final String component1() {
        return getId();
    }

    public final ObjectType component2() {
        return getType();
    }

    public final Location component3() {
        return getLocation();
    }

    /* renamed from: component4, reason: from getter */
    public final AvatarResource getAvatarResource() {
        return this.avatarResource;
    }

    /* renamed from: component5, reason: from getter */
    public final ImageResource getImageResource() {
        return this.imageResource;
    }

    /* renamed from: component6, reason: from getter */
    public final float getDepth() {
        return this.depth;
    }

    public final FilamentMapObjectParams copy(String id5, ObjectType type, Location location, AvatarResource avatarResource, ImageResource imageResource, float depth) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(location, "location");
        return new FilamentMapObjectParams(id5, type, location, avatarResource, imageResource, depth);
    }

    public final AvatarResource getAvatarResource() {
        return this.avatarResource;
    }

    public final float getDepth() {
        return this.depth;
    }

    @Override // com.tencent.state.map.v2.ObjectParams
    public String getId() {
        return this.id;
    }

    public final ImageResource getImageResource() {
        return this.imageResource;
    }

    @Override // com.tencent.state.map.v2.ObjectParams
    public Location getLocation() {
        return this.location;
    }

    @Override // com.tencent.state.map.v2.ObjectParams
    public ObjectType getType() {
        return this.type;
    }

    public int hashCode() {
        String id5 = getId();
        int hashCode = (id5 != null ? id5.hashCode() : 0) * 31;
        ObjectType type = getType();
        int hashCode2 = (hashCode + (type != null ? type.hashCode() : 0)) * 31;
        Location location = getLocation();
        int hashCode3 = (hashCode2 + (location != null ? location.hashCode() : 0)) * 31;
        AvatarResource avatarResource = this.avatarResource;
        int hashCode4 = (hashCode3 + (avatarResource != null ? avatarResource.hashCode() : 0)) * 31;
        ImageResource imageResource = this.imageResource;
        return ((hashCode4 + (imageResource != null ? imageResource.hashCode() : 0)) * 31) + Float.floatToIntBits(this.depth);
    }

    public final boolean isChange(FilamentMapObjectParams check) {
        Intrinsics.checkNotNullParameter(check, "check");
        int i3 = WhenMappings.$EnumSwitchMapping$1[getType().ordinal()];
        if (i3 == 1) {
            AvatarResource avatarResource = check.avatarResource;
            if (avatarResource == null) {
                return false;
            }
            AvatarResource avatarResource2 = this.avatarResource;
            if (avatarResource2 == null) {
                return true;
            }
            if (!(!Intrinsics.areEqual(avatarResource.getUrl(), avatarResource2.getUrl())) && avatarResource.getHostUin() == avatarResource2.getHostUin() && !(!Intrinsics.areEqual(avatarResource.getGuestUin(), avatarResource2.getGuestUin()))) {
                return false;
            }
        } else if (i3 == 2) {
            ImageResource imageResource = check.imageResource;
            if (imageResource == null) {
                return false;
            }
            ImageResource imageResource2 = this.imageResource;
            if (imageResource2 == null) {
                return true;
            }
            if (!(!Intrinsics.areEqual(imageResource.getUrl(), imageResource2.getUrl())) && imageResource.getSize().getWidth() == imageResource2.getSize().getWidth() && imageResource.getSize().getHeight() == imageResource2.getSize().getHeight()) {
                return false;
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return true;
    }

    @Override // com.tencent.state.map.v2.ObjectParams
    public boolean isValid() {
        int i3 = WhenMappings.$EnumSwitchMapping$0[getType().ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                if (this.imageResource == null) {
                    return false;
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if (this.avatarResource == null) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "FilamentMapObjectParams(id=" + getId() + ", type=" + getType() + ", location=" + getLocation() + ", avatarResource=" + this.avatarResource + ", imageResource=" + this.imageResource + ", depth=" + this.depth + ")";
    }

    public /* synthetic */ FilamentMapObjectParams(String str, ObjectType objectType, Location location, AvatarResource avatarResource, ImageResource imageResource, float f16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, objectType, location, (i3 & 8) != 0 ? null : avatarResource, (i3 & 16) != 0 ? null : imageResource, f16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FilamentMapObjectParams)) {
            return false;
        }
        FilamentMapObjectParams filamentMapObjectParams = (FilamentMapObjectParams) other;
        return Intrinsics.areEqual(getId(), filamentMapObjectParams.getId()) && Intrinsics.areEqual(getType(), filamentMapObjectParams.getType()) && Intrinsics.areEqual(getLocation(), filamentMapObjectParams.getLocation()) && Intrinsics.areEqual(this.avatarResource, filamentMapObjectParams.avatarResource) && Intrinsics.areEqual(this.imageResource, filamentMapObjectParams.imageResource) && Float.compare(this.depth, filamentMapObjectParams.depth) == 0;
    }

    public static /* synthetic */ FilamentMapObjectParams copy$default(FilamentMapObjectParams filamentMapObjectParams, String str, ObjectType objectType, Location location, AvatarResource avatarResource, ImageResource imageResource, float f16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = filamentMapObjectParams.getId();
        }
        if ((i3 & 2) != 0) {
            objectType = filamentMapObjectParams.getType();
        }
        ObjectType objectType2 = objectType;
        if ((i3 & 4) != 0) {
            location = filamentMapObjectParams.getLocation();
        }
        Location location2 = location;
        if ((i3 & 8) != 0) {
            avatarResource = filamentMapObjectParams.avatarResource;
        }
        AvatarResource avatarResource2 = avatarResource;
        if ((i3 & 16) != 0) {
            imageResource = filamentMapObjectParams.imageResource;
        }
        ImageResource imageResource2 = imageResource;
        if ((i3 & 32) != 0) {
            f16 = filamentMapObjectParams.depth;
        }
        return filamentMapObjectParams.copy(str, objectType2, location2, avatarResource2, imageResource2, f16);
    }
}
