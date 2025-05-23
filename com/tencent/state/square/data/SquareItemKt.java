package com.tencent.state.square.data;

import android.graphics.Point;
import android.util.Size;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.zplan.api.impl.ZPlanApiImpl;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareKt;
import com.tencent.state.square.media.MapPlayableSource;
import com.tencent.state.square.media.MediaSource;
import com.tencent.state.utils.SquareSwitchUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001an\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u001a\u0012\u0010\u0014\u001a\u00020\u0015*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0005\u001a\u0012\u0010\u0017\u001a\u00020\u0015*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0005\u001a\n\u0010\u0018\u001a\u00020\r*\u00020\u0003\u001a\u001b\u0010\u0019\u001a\u00020\u001a*\u00020\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u001c\u001a+\u0010\u001d\u001a\u00020\u001a*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00152\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010 \u001a\u001b\u0010\u001d\u001a\u00020\u001a*\u00020\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u001c\u001a\n\u0010!\u001a\u00020\"*\u00020\u0003\u001a\u0012\u0010!\u001a\u00020\"*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u001e\u00a8\u0006#"}, d2 = {"copyDepth", "Lcom/tencent/state/square/data/AvatarAction;", "copyResource", "Lcom/tencent/state/square/data/Resource;", "actionId", "", TabPreloadItem.TAB_NAME_DYNAMIC, "Lcom/tencent/state/square/data/ResourceIdentify;", "static", "showSize", "Landroid/util/Size;", "recordSize", "isDefault", "", "bubbleCoordinate", "Landroid/graphics/Point;", "actionType", "actionStyle", ZPlanApiImpl.FILAMENT_TAG, "Lcom/tencent/state/square/data/FilamentResource;", "getDownloadFile", "", "type", "getDownloadUrl", "hasAvatar", "toLibraryMapPlayableSource", "Lcom/tencent/state/square/media/MapPlayableSource;", "defaultResourceId", "(Lcom/tencent/state/square/data/Resource;Ljava/lang/Integer;)Lcom/tencent/state/square/media/MapPlayableSource;", "toMapPlayableSource", "Lcom/tencent/state/square/data/MapResourceType;", "uin", "(Lcom/tencent/state/square/data/Resource;Lcom/tencent/state/square/data/MapResourceType;Ljava/lang/String;Ljava/lang/Integer;)Lcom/tencent/state/square/media/MapPlayableSource;", "toMediaSource", "Lcom/tencent/state/square/media/MediaSource;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareItemKt {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MapResourceType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[MapResourceType.Filament.ordinal()] = 1;
            iArr[MapResourceType.Mp4.ordinal()] = 2;
        }
    }

    public static final AvatarAction copyDepth(AvatarAction copyDepth) {
        Intrinsics.checkNotNullParameter(copyDepth, "$this$copyDepth");
        int actionId = copyDepth.getLookFront().getActionId();
        int i3 = 0;
        int i16 = 16;
        DefaultConstructorMarker defaultConstructorMarker = null;
        ResourceIdentify resourceIdentify = new ResourceIdentify(copyDepth.getLookFront().getDynamic().getUrl(), copyDepth.getLookFront().getDynamic().getMd5(), copyDepth.getLookFront().getDynamic().getDefaultUrl(), copyDepth.getLookFront().getDynamic().getDefaultMd5(), i3, i16, defaultConstructorMarker);
        resourceIdentify.setMultiExtra(copyDepth.getLookFront().getDynamic().getMultiExtra());
        Unit unit = Unit.INSTANCE;
        ResourceIdentify resourceIdentify2 = new ResourceIdentify(copyDepth.getLookFront().getStatic().getUrl(), copyDepth.getLookFront().getStatic().getMd5(), copyDepth.getLookFront().getStatic().getDefaultUrl(), copyDepth.getLookFront().getStatic().getDefaultMd5(), i3, i16, defaultConstructorMarker);
        resourceIdentify2.setMultiExtra(copyDepth.getLookFront().getStatic().getMultiExtra());
        Resource resource = new Resource(actionId, resourceIdentify, resourceIdentify2, copyDepth.getLookFront().getShowSize(), copyDepth.getLookFront().getRecordSize(), copyDepth.getLookFront().getIsDefault(), copyDepth.getLookFront().getBubbleCoordinate(), copyDepth.getLookFront().getActionType(), copyDepth.getLookFront().getActionStyle(), copyDepth.getLookFront().getFilament());
        int actionId2 = copyDepth.getUnread().getActionId();
        ResourceIdentify resourceIdentify3 = new ResourceIdentify(copyDepth.getUnread().getDynamic().getUrl(), copyDepth.getUnread().getDynamic().getMd5(), copyDepth.getUnread().getDynamic().getDefaultUrl(), copyDepth.getUnread().getDynamic().getDefaultMd5(), 0, 16, null);
        resourceIdentify3.setMultiExtra(copyDepth.getUnread().getDynamic().getMultiExtra());
        ResourceIdentify resourceIdentify4 = new ResourceIdentify(copyDepth.getUnread().getStatic().getUrl(), copyDepth.getUnread().getStatic().getMd5(), copyDepth.getUnread().getStatic().getDefaultUrl(), copyDepth.getUnread().getStatic().getDefaultMd5(), 0, 16, null);
        resourceIdentify4.setMultiExtra(copyDepth.getUnread().getStatic().getMultiExtra());
        return new AvatarAction(resource, new Resource(actionId2, resourceIdentify3, resourceIdentify4, copyDepth.getUnread().getShowSize(), copyDepth.getUnread().getRecordSize(), copyDepth.getUnread().getIsDefault(), copyDepth.getUnread().getBubbleCoordinate(), copyDepth.getUnread().getActionType(), copyDepth.getUnread().getActionStyle(), copyDepth.getUnread().getFilament()), null, null, 12, null);
    }

    public static final Resource copyResource(Resource copyResource, int i3, ResourceIdentify dynamic, ResourceIdentify resourceIdentify, Size showSize, Size recordSize, boolean z16, Point bubbleCoordinate, int i16, int i17, FilamentResource filament) {
        Intrinsics.checkNotNullParameter(copyResource, "$this$copyResource");
        Intrinsics.checkNotNullParameter(dynamic, "dynamic");
        Intrinsics.checkNotNullParameter(resourceIdentify, "static");
        Intrinsics.checkNotNullParameter(showSize, "showSize");
        Intrinsics.checkNotNullParameter(recordSize, "recordSize");
        Intrinsics.checkNotNullParameter(bubbleCoordinate, "bubbleCoordinate");
        Intrinsics.checkNotNullParameter(filament, "filament");
        int i18 = 0;
        int i19 = 16;
        DefaultConstructorMarker defaultConstructorMarker = null;
        ResourceIdentify resourceIdentify2 = new ResourceIdentify(dynamic.getUrl(), dynamic.getMd5(), dynamic.getDefaultUrl(), dynamic.getDefaultMd5(), i18, i19, defaultConstructorMarker);
        resourceIdentify2.setMultiExtra(dynamic.getMultiExtra());
        Unit unit = Unit.INSTANCE;
        ResourceIdentify resourceIdentify3 = new ResourceIdentify(resourceIdentify.getUrl(), resourceIdentify.getMd5(), resourceIdentify.getDefaultUrl(), resourceIdentify.getDefaultMd5(), i18, i19, defaultConstructorMarker);
        resourceIdentify3.setMultiExtra(resourceIdentify.getMultiExtra());
        return new Resource(i3, resourceIdentify2, resourceIdentify3, showSize, recordSize, z16, bubbleCoordinate, i16, i17, filament);
    }

    public static final String getDownloadFile(Resource getDownloadFile, int i3) {
        Intrinsics.checkNotNullParameter(getDownloadFile, "$this$getDownloadFile");
        String animImageFile = SquareKt.getSquareHelper().getAnimImageFile(getDownloadFile, i3);
        if (animImageFile == null) {
            animImageFile = Square.INSTANCE.getAvatarFile(getDownloadFile, i3);
        }
        SquareBaseKt.getSquareLog().i("SquareItem", "getDownloadFile this:" + getDownloadFile + ", file:" + animImageFile);
        return animImageFile;
    }

    public static final String getDownloadUrl(Resource getDownloadUrl, int i3) {
        Intrinsics.checkNotNullParameter(getDownloadUrl, "$this$getDownloadUrl");
        String animImageUrl = SquareKt.getSquareHelper().getAnimImageUrl(getDownloadUrl, i3);
        if (animImageUrl != null) {
            return animImageUrl;
        }
        if (i3 == 1) {
            return getDownloadUrl.getStatic().getUrl();
        }
        if (i3 != 2) {
            return "";
        }
        return getDownloadUrl.getDynamic().getUrl();
    }

    public static final boolean hasAvatar(Resource hasAvatar) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(hasAvatar, "$this$hasAvatar");
        isBlank = StringsKt__StringsJVMKt.isBlank(hasAvatar.getDynamic().getUrl());
        return !isBlank;
    }

    public static final MapPlayableSource toLibraryMapPlayableSource(Resource toLibraryMapPlayableSource, Integer num) {
        Intrinsics.checkNotNullParameter(toLibraryMapPlayableSource, "$this$toLibraryMapPlayableSource");
        return new MapPlayableSource(toMediaSource(toLibraryMapPlayableSource), num != null ? num.intValue() : 0, new com.tencent.state.square.media.Size(toLibraryMapPlayableSource.getShowSize().getWidth(), toLibraryMapPlayableSource.getShowSize().getHeight()), null, 8, null);
    }

    public static final MapPlayableSource toMapPlayableSource(Resource toMapPlayableSource, Integer num) {
        Intrinsics.checkNotNullParameter(toMapPlayableSource, "$this$toMapPlayableSource");
        return new MapPlayableSource(toMediaSource(toMapPlayableSource), num != null ? num.intValue() : 0, new com.tencent.state.square.media.Size(toMapPlayableSource.getShowSize().getWidth(), toMapPlayableSource.getShowSize().getHeight()), toMapPlayableSource.getFilament().getUrl());
    }

    public static /* synthetic */ MapPlayableSource toMapPlayableSource$default(Resource resource, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = null;
        }
        return toMapPlayableSource(resource, num);
    }

    public static final MediaSource toMediaSource(Resource toMediaSource) {
        Intrinsics.checkNotNullParameter(toMediaSource, "$this$toMediaSource");
        boolean areEqual = Intrinsics.areEqual(SquareSwitchUtils.INSTANCE.getEnableFilamentIndex(), Boolean.TRUE);
        String encode = toMediaSource.getFilamentCoverUrl().encode();
        String downloadUrl = getDownloadUrl(toMediaSource, 2);
        String downloadFile = getDownloadFile(toMediaSource, 2);
        if (!areEqual || !toMediaSource.getFilamentReady()) {
            encode = getDownloadUrl(toMediaSource, 1);
        }
        return new MediaSource(downloadUrl, downloadFile, encode, Square.INSTANCE.getAvatarFile(toMediaSource, 1), false, 16, null);
    }

    public static /* synthetic */ MapPlayableSource toMapPlayableSource$default(Resource resource, MapResourceType mapResourceType, String str, Integer num, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        return toMapPlayableSource(resource, mapResourceType, str, num);
    }

    public static /* synthetic */ MapPlayableSource toLibraryMapPlayableSource$default(Resource resource, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = null;
        }
        return toLibraryMapPlayableSource(resource, num);
    }

    public static final MapPlayableSource toMapPlayableSource(Resource toMapPlayableSource, MapResourceType type, String uin, Integer num) {
        Intrinsics.checkNotNullParameter(toMapPlayableSource, "$this$toMapPlayableSource");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(uin, "uin");
        return new FilamentMapPlayableSource(uin, toMediaSource(toMapPlayableSource, type), num != null ? num.intValue() : 0, toMapPlayableSource.isMultiAction(), toMapPlayableSource.isSingleAction(), toMapPlayableSource.getFilament().getMultiUser());
    }

    public static final MediaSource toMediaSource(Resource toMediaSource, MapResourceType type) {
        Intrinsics.checkNotNullParameter(toMediaSource, "$this$toMediaSource");
        Intrinsics.checkNotNullParameter(type, "type");
        int i3 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i3 == 1) {
            return new MediaSource(toMediaSource.getFilament().getUrl(), "", toMediaSource.getFilamentCoverUrl().encode(), Square.INSTANCE.getAvatarFile(toMediaSource, 1), false, 16, null);
        }
        if (i3 == 2) {
            return toMediaSource(toMediaSource);
        }
        throw new NoWhenBranchMatchedException();
    }
}
