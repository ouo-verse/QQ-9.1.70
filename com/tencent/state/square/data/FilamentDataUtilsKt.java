package com.tencent.state.square.data;

import com.tencent.state.map.MapItem;
import com.tencent.state.map.v2.Location;
import com.tencent.state.map.v2.ObjectType;
import com.tencent.state.map.v2.Size;
import com.tencent.state.map.v2.filament.AvatarResource;
import com.tencent.state.map.v2.filament.FilamentMapObjectParams;
import com.tencent.state.map.v2.filament.FilamentMapObjectUpdateResourceParams;
import com.tencent.state.map.v2.filament.ImageResource;
import com.tencent.state.square.chatland.data.ChatLandAvatarItem;
import com.tencent.state.square.chatland.data.ChatLandTableItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u001a\f\u0010\u000b\u001a\u0004\u0018\u00010\u0001*\u00020\f\u001a\f\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\f\u001a\n\u0010\u000f\u001a\u00020\u0003*\u00020\f\u001a\f\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\u0011\u001a\f\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\u0012\u001a\f\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\u0013\u001a\n\u0010\u0010\u001a\u00020\u0001*\u00020\u0014\u001a\f\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\u0015\u00a8\u0006\u0016"}, d2 = {"createImageFilamentObject", "Lcom/tencent/state/map/v2/filament/FilamentMapObjectParams;", "id", "", "url", "location", "Lcom/tencent/state/map/v2/Location;", "size", "Lcom/tencent/state/map/v2/Size;", "depth", "", "formatFilamentObject", "Lcom/tencent/state/map/MapItem;", "formatFilamentUpdateObject", "Lcom/tencent/state/map/v2/filament/FilamentMapObjectUpdateResourceParams;", "getFilamentId", "getFilamentObject", "Lcom/tencent/state/square/chatland/data/ChatLandAvatarItem;", "Lcom/tencent/state/square/chatland/data/ChatLandTableItem;", "Lcom/tencent/state/square/data/SquareAvatarItem;", "Lcom/tencent/state/square/data/SquareEntranceItem;", "Lcom/tencent/state/square/data/SquareTroopItem;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class FilamentDataUtilsKt {
    public static final FilamentMapObjectParams createImageFilamentObject(String id5, String url, Location location, Size size, float f16) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(size, "size");
        return new FilamentMapObjectParams(id5, ObjectType.IMAGE, location, null, new ImageResource(url, size), f16, 8, null);
    }

    public static final FilamentMapObjectParams formatFilamentObject(MapItem formatFilamentObject) {
        Intrinsics.checkNotNullParameter(formatFilamentObject, "$this$formatFilamentObject");
        if (formatFilamentObject instanceof ChatLandAvatarItem) {
            return getFilamentObject((ChatLandAvatarItem) formatFilamentObject);
        }
        if (formatFilamentObject instanceof SquareTroopItem) {
            return getFilamentObject((SquareTroopItem) formatFilamentObject);
        }
        if (formatFilamentObject instanceof SquareAvatarItem) {
            return getFilamentObject((SquareAvatarItem) formatFilamentObject);
        }
        return null;
    }

    public static final FilamentMapObjectUpdateResourceParams formatFilamentUpdateObject(MapItem formatFilamentUpdateObject) {
        Intrinsics.checkNotNullParameter(formatFilamentUpdateObject, "$this$formatFilamentUpdateObject");
        FilamentMapObjectParams formatFilamentObject = formatFilamentObject(formatFilamentUpdateObject);
        if (formatFilamentObject != null) {
            return new FilamentMapObjectUpdateResourceParams(formatFilamentObject.getId(), formatFilamentObject.getAvatarResource(), null, 4, null);
        }
        return null;
    }

    public static final String getFilamentId(MapItem getFilamentId) {
        Intrinsics.checkNotNullParameter(getFilamentId, "$this$getFilamentId");
        return getFilamentId.getType() + util.base64_pad_url + getFilamentId.getUin();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final FilamentMapObjectParams getFilamentObject(SquareAvatarItem getFilamentObject) {
        boolean z16;
        FilamentResource filament;
        boolean isBlank;
        FilamentResource filament2;
        Intrinsics.checkNotNullParameter(getFilamentObject, "$this$getFilamentObject");
        Resource userResource = getFilamentObject.getUserResource();
        Long l3 = null;
        String url = (userResource == null || (filament2 = userResource.getFilament()) == null) ? null : filament2.getUrl();
        if (url != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(url);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return null;
                }
                String str = getFilamentObject.getType() + util.base64_pad_url + getFilamentObject.getUin();
                ObjectType objectType = ObjectType.AVATAR;
                Location location = new Location(getFilamentObject.getLocation().getX(), getFilamentObject.getLocation().getY());
                long parseLong = Long.parseLong(getFilamentObject.getUin());
                Resource userResource2 = getFilamentObject.getUserResource();
                if (userResource2 != null && (filament = userResource2.getFilament()) != null) {
                    l3 = filament.getToUin();
                }
                return new FilamentMapObjectParams(str, objectType, location, new AvatarResource(parseLong, l3, url, new Size(getFilamentObject.getLocation().getWidth(), getFilamentObject.getLocation().getHeight())), null, 0.0f, 16, null);
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    public static final FilamentMapObjectParams getFilamentObject(SquareEntranceItem getFilamentObject) {
        Intrinsics.checkNotNullParameter(getFilamentObject, "$this$getFilamentObject");
        return new FilamentMapObjectParams(getFilamentObject.getType() + util.base64_pad_url + getFilamentObject.getUin(), ObjectType.IMAGE, new Location(getFilamentObject.getLocation().getX(), getFilamentObject.getLocation().getY()), null, new ImageResource(getFilamentObject.getShowUrl(), new Size(getFilamentObject.getLocation().getWidth(), getFilamentObject.getLocation().getHeight())), 0.3f, 8, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final FilamentMapObjectParams getFilamentObject(SquareTroopItem getFilamentObject) {
        boolean z16;
        FilamentResource filament;
        android.util.Size showSize;
        android.util.Size showSize2;
        boolean isBlank;
        FilamentResource filament2;
        Intrinsics.checkNotNullParameter(getFilamentObject, "$this$getFilamentObject");
        Resource userResource = getFilamentObject.getUserResource();
        Long l3 = null;
        String url = (userResource == null || (filament2 = userResource.getFilament()) == null) ? null : filament2.getUrl();
        if (url != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(url);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return null;
                }
                Resource userResource2 = getFilamentObject.getUserResource();
                int width = (userResource2 == null || (showSize2 = userResource2.getShowSize()) == null) ? getFilamentObject.getLocation().getWidth() : showSize2.getWidth();
                Resource userResource3 = getFilamentObject.getUserResource();
                int height = (userResource3 == null || (showSize = userResource3.getShowSize()) == null) ? getFilamentObject.getLocation().getHeight() : showSize.getHeight();
                String str = getFilamentObject.getType() + util.base64_pad_url + getFilamentObject.getUin();
                ObjectType objectType = ObjectType.AVATAR;
                Location location = new Location(getFilamentObject.getLocation().getX(), getFilamentObject.getLocation().getY());
                long parseLong = Long.parseLong(getFilamentObject.getOwnerUin());
                Resource userResource4 = getFilamentObject.getUserResource();
                if (userResource4 != null && (filament = userResource4.getFilament()) != null) {
                    l3 = filament.getToUin();
                }
                return new FilamentMapObjectParams(str, objectType, location, new AvatarResource(parseLong, l3, url, new Size(width, height)), null, 0.0f, 16, null);
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final FilamentMapObjectParams getFilamentObject(ChatLandAvatarItem getFilamentObject) {
        boolean z16;
        FilamentResource filament;
        boolean isBlank;
        FilamentResource filament2;
        Intrinsics.checkNotNullParameter(getFilamentObject, "$this$getFilamentObject");
        Resource userResource = getFilamentObject.getUserResource();
        Long l3 = null;
        String url = (userResource == null || (filament2 = userResource.getFilament()) == null) ? null : filament2.getUrl();
        if (url != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(url);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return null;
                }
                String str = getFilamentObject.getType() + util.base64_pad_url + getFilamentObject.getUin();
                ObjectType objectType = ObjectType.AVATAR;
                Location location = new Location(getFilamentObject.getLocation().getX(), getFilamentObject.getLocation().getY());
                long parseLong = Long.parseLong(getFilamentObject.getUin());
                Resource userResource2 = getFilamentObject.getUserResource();
                if (userResource2 != null && (filament = userResource2.getFilament()) != null) {
                    l3 = filament.getToUin();
                }
                return new FilamentMapObjectParams(str, objectType, location, new AvatarResource(parseLong, l3, url, new Size(getFilamentObject.getLocation().getWidth(), getFilamentObject.getLocation().getHeight())), null, 0.0f, 16, null);
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    public static final FilamentMapObjectParams getFilamentObject(ChatLandTableItem getFilamentObject) {
        Intrinsics.checkNotNullParameter(getFilamentObject, "$this$getFilamentObject");
        return new FilamentMapObjectParams(getFilamentObject.getType() + util.base64_pad_url + getFilamentObject.getUin(), ObjectType.IMAGE, new Location(getFilamentObject.getLocation().getX(), getFilamentObject.getLocation().getY()), null, new ImageResource(getFilamentObject.getTable().getImage().getUrl(), new Size(getFilamentObject.getTable().getImage().getSize().getWidth(), getFilamentObject.getTable().getImage().getSize().getHeight())), 0.0f, 8, null);
    }
}
