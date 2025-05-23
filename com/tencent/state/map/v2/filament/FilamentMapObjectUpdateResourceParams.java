package com.tencent.state.map.v2.filament;

import com.tencent.state.map.v2.ObjectUpdateResourceParams;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/map/v2/filament/FilamentMapObjectUpdateResourceParams;", "Lcom/tencent/state/map/v2/ObjectUpdateResourceParams;", "id", "", "avatarResource", "Lcom/tencent/state/map/v2/filament/AvatarResource;", "imageResource", "Lcom/tencent/state/map/v2/filament/ImageResource;", "(Ljava/lang/String;Lcom/tencent/state/map/v2/filament/AvatarResource;Lcom/tencent/state/map/v2/filament/ImageResource;)V", "getAvatarResource", "()Lcom/tencent/state/map/v2/filament/AvatarResource;", "getId", "()Ljava/lang/String;", "getImageResource", "()Lcom/tencent/state/map/v2/filament/ImageResource;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final /* data */ class FilamentMapObjectUpdateResourceParams implements ObjectUpdateResourceParams {
    private final AvatarResource avatarResource;
    private final String id;
    private final ImageResource imageResource;

    public FilamentMapObjectUpdateResourceParams(String id5, AvatarResource avatarResource, ImageResource imageResource) {
        Intrinsics.checkNotNullParameter(id5, "id");
        this.id = id5;
        this.avatarResource = avatarResource;
        this.imageResource = imageResource;
    }

    public final String component1() {
        return getId();
    }

    /* renamed from: component2, reason: from getter */
    public final AvatarResource getAvatarResource() {
        return this.avatarResource;
    }

    /* renamed from: component3, reason: from getter */
    public final ImageResource getImageResource() {
        return this.imageResource;
    }

    public final FilamentMapObjectUpdateResourceParams copy(String id5, AvatarResource avatarResource, ImageResource imageResource) {
        Intrinsics.checkNotNullParameter(id5, "id");
        return new FilamentMapObjectUpdateResourceParams(id5, avatarResource, imageResource);
    }

    public final AvatarResource getAvatarResource() {
        return this.avatarResource;
    }

    @Override // com.tencent.state.map.v2.ObjectUpdateResourceParams
    public String getId() {
        return this.id;
    }

    public final ImageResource getImageResource() {
        return this.imageResource;
    }

    public int hashCode() {
        String id5 = getId();
        int hashCode = (id5 != null ? id5.hashCode() : 0) * 31;
        AvatarResource avatarResource = this.avatarResource;
        int hashCode2 = (hashCode + (avatarResource != null ? avatarResource.hashCode() : 0)) * 31;
        ImageResource imageResource = this.imageResource;
        return hashCode2 + (imageResource != null ? imageResource.hashCode() : 0);
    }

    public String toString() {
        return "FilamentMapObjectUpdateResourceParams(id=" + getId() + ", avatarResource=" + this.avatarResource + ", imageResource=" + this.imageResource + ")";
    }

    public /* synthetic */ FilamentMapObjectUpdateResourceParams(String str, AvatarResource avatarResource, ImageResource imageResource, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : avatarResource, (i3 & 4) != 0 ? null : imageResource);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FilamentMapObjectUpdateResourceParams)) {
            return false;
        }
        FilamentMapObjectUpdateResourceParams filamentMapObjectUpdateResourceParams = (FilamentMapObjectUpdateResourceParams) other;
        return Intrinsics.areEqual(getId(), filamentMapObjectUpdateResourceParams.getId()) && Intrinsics.areEqual(this.avatarResource, filamentMapObjectUpdateResourceParams.avatarResource) && Intrinsics.areEqual(this.imageResource, filamentMapObjectUpdateResourceParams.imageResource);
    }

    public static /* synthetic */ FilamentMapObjectUpdateResourceParams copy$default(FilamentMapObjectUpdateResourceParams filamentMapObjectUpdateResourceParams, String str, AvatarResource avatarResource, ImageResource imageResource, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = filamentMapObjectUpdateResourceParams.getId();
        }
        if ((i3 & 2) != 0) {
            avatarResource = filamentMapObjectUpdateResourceParams.avatarResource;
        }
        if ((i3 & 4) != 0) {
            imageResource = filamentMapObjectUpdateResourceParams.imageResource;
        }
        return filamentMapObjectUpdateResourceParams.copy(str, avatarResource, imageResource);
    }
}
