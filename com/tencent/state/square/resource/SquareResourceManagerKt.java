package com.tencent.state.square.resource;

import android.util.Size;
import com.tencent.state.battery.SquareBatteryStatusManager;
import com.tencent.state.map.MapPlayableItem;
import com.tencent.state.square.data.AvatarAction;
import com.tencent.state.square.data.FilamentResource;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.record.SquareRecordManager;
import com.tencent.state.view.OnlineStatusBubbleViewHelperKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u00a2\u0006\u0002\u0010\u0003\u001a\f\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0002\u001a\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u00a2\u0006\u0002\u0010\u0003\u001a\f\u0010\u0007\u001a\u0004\u0018\u00010\u0005*\u00020\u0002\u001a\f\u0010\b\u001a\u0004\u0018\u00010\u0005*\u00020\u0002\u001a\n\u0010\t\u001a\u00020\n*\u00020\u0002\u001a\n\u0010\u000b\u001a\u00020\n*\u00020\u0002\u001a\n\u0010\f\u001a\u00020\n*\u00020\u0002\u001a\u0012\u0010\r\u001a\u00020\n*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010\r\u001a\u00020\n*\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0005\u00a8\u0006\u0012"}, d2 = {"getOnlineStatusId", "", "Lcom/tencent/state/square/data/SquareAvatarItem;", "(Lcom/tencent/state/square/data/SquareAvatarItem;)Ljava/lang/Integer;", "getResource", "Lcom/tencent/state/square/data/Resource;", "getRichStatusId", "getStateResource", "getUnreadResource", "hasFeedsNewMessage", "", "hasSpecialState", "hasUnreadMessage", "isSameSize", "Lcom/tencent/state/map/MapPlayableItem;", "size", "Landroid/util/Size;", "resource", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareResourceManagerKt {
    public static final Integer getOnlineStatusId(SquareAvatarItem getOnlineStatusId) {
        Intrinsics.checkNotNullParameter(getOnlineStatusId, "$this$getOnlineStatusId");
        OnlineStatus onlineStatus = getOnlineStatusId.getExtra().getOnlineStatus();
        if (onlineStatus != null) {
            return Integer.valueOf(onlineStatus.getId());
        }
        return null;
    }

    public static final Resource getResource(SquareAvatarItem getResource) {
        Resource stateResource;
        FilamentResource filament;
        Intrinsics.checkNotNullParameter(getResource, "$this$getResource");
        if (hasUnreadMessage(getResource)) {
            stateResource = getUnreadResource(getResource);
        } else {
            stateResource = getStateResource(getResource);
        }
        if (stateResource != null && (filament = stateResource.getFilament()) != null) {
            filament.checkOwnerDressKey(getResource.getDressKey(), getResource.getUin());
        }
        return stateResource;
    }

    public static final Integer getRichStatusId(SquareAvatarItem getRichStatusId) {
        int id5;
        Intrinsics.checkNotNullParameter(getRichStatusId, "$this$getRichStatusId");
        OnlineStatus onlineStatus = getRichStatusId.getExtra().getOnlineStatus();
        Integer valueOf = onlineStatus != null ? Integer.valueOf(onlineStatus.getId()) : null;
        OnlineStatus onlineStatus2 = getRichStatusId.getExtra().getOnlineStatus();
        if (Intrinsics.areEqual(valueOf, onlineStatus2 != null ? Integer.valueOf(onlineStatus2.getTopStatusId()) : null)) {
            id5 = 0;
        } else {
            OnlineStatus onlineStatus3 = getRichStatusId.getExtra().getOnlineStatus();
            if (onlineStatus3 == null) {
                return null;
            }
            id5 = onlineStatus3.getId();
        }
        return Integer.valueOf(id5);
    }

    public static final Resource getStateResource(SquareAvatarItem getStateResource) {
        Object firstOrNull;
        OnlineStatus onlineStatus;
        Intrinsics.checkNotNullParameter(getStateResource, "$this$getStateResource");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) getStateResource.getActions());
        AvatarAction avatarAction = (AvatarAction) firstOrNull;
        if (!getStateResource.isMe() || (onlineStatus = getStateResource.getExtra().getOnlineStatus()) == null || !OnlineStatusBubbleViewHelperKt.isBatteryStatus(onlineStatus)) {
            if (avatarAction != null) {
                return avatarAction.getLookFront();
            }
            return null;
        }
        Resource curBatteryLevelResource = SquareBatteryStatusManager.INSTANCE.getCurBatteryLevelResource(getStateResource.getUin(), getStateResource.getIsGenderMale(), SquareRecordManager.INSTANCE.getDressKey());
        if (curBatteryLevelResource == null) {
            curBatteryLevelResource = avatarAction != null ? avatarAction.getLookFront() : null;
        }
        if (curBatteryLevelResource != null && avatarAction != null) {
            avatarAction.setBattery(curBatteryLevelResource);
        }
        if (avatarAction != null) {
            return avatarAction.getBattery();
        }
        return null;
    }

    public static final Resource getUnreadResource(SquareAvatarItem getUnreadResource) {
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(getUnreadResource, "$this$getUnreadResource");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) getUnreadResource.getActions());
        AvatarAction avatarAction = (AvatarAction) firstOrNull;
        if (avatarAction != null) {
            return avatarAction.getUnread();
        }
        return null;
    }

    public static final boolean hasFeedsNewMessage(SquareAvatarItem hasFeedsNewMessage) {
        Intrinsics.checkNotNullParameter(hasFeedsNewMessage, "$this$hasFeedsNewMessage");
        return hasFeedsNewMessage.getFeedInfo().getHasNew();
    }

    public static final boolean hasSpecialState(SquareAvatarItem hasSpecialState) {
        Intrinsics.checkNotNullParameter(hasSpecialState, "$this$hasSpecialState");
        return hasUnreadMessage(hasSpecialState);
    }

    public static final boolean hasUnreadMessage(SquareAvatarItem hasUnreadMessage) {
        Intrinsics.checkNotNullParameter(hasUnreadMessage, "$this$hasUnreadMessage");
        return hasUnreadMessage.getExtra().unReadCount() > 0;
    }

    public static final boolean isSameSize(MapPlayableItem isSameSize, Resource resource) {
        Intrinsics.checkNotNullParameter(isSameSize, "$this$isSameSize");
        Intrinsics.checkNotNullParameter(resource, "resource");
        return isSameSize(isSameSize, resource.getShowSize());
    }

    public static final boolean isSameSize(MapPlayableItem isSameSize, Size size) {
        Intrinsics.checkNotNullParameter(isSameSize, "$this$isSameSize");
        Intrinsics.checkNotNullParameter(size, "size");
        return size.getWidth() == isSameSize.getLocation().getWidth() && size.getHeight() == isSameSize.getLocation().getHeight();
    }
}
