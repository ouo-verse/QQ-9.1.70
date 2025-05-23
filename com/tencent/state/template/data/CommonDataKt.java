package com.tencent.state.template.data;

import android.graphics.Point;
import android.util.Size;
import com.tencent.state.map.Location;
import com.tencent.state.map.MapItemKt;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.data.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0007\u001a\n\u0010\b\u001a\u00020\t*\u00020\u0003\u001a\n\u0010\n\u001a\u00020\t*\u00020\u000b\u001a\n\u0010\f\u001a\u00020\t*\u00020\u000b\u001a\n\u0010\r\u001a\u00020\t*\u00020\u0004\u001a\n\u0010\u000e\u001a\u00020\u0003*\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"FLEX_TABLE_SIT_OFFSET_Y", "", "countDownTime", "", "Lcom/tencent/state/template/data/RemainTimeInfo;", "getLocation", "Lcom/tencent/state/map/Location;", "Lcom/tencent/state/template/data/User;", "isMe", "", "isMeSeated", "Lcom/tencent/state/template/data/CommonRoomInfo;", "isRoomFull", "needShowCallBackIcon", "pastTime", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class CommonDataKt {
    public static final float FLEX_TABLE_SIT_OFFSET_Y = 0.85f;

    public static final long countDownTime(RemainTimeInfo countDownTime) {
        Intrinsics.checkNotNullParameter(countDownTime, "$this$countDownTime");
        return countDownTime.getMaxLifeSeconds() - ((System.currentTimeMillis() / 1000) - countDownTime.getHeartbeatLastTs());
    }

    public static final Location getLocation(User getLocation) {
        Table table;
        Location location;
        Point sitLocation;
        Point sitLocation2;
        InterReceiverInfo receiverInfo;
        InterPlaceholderInfo placeholder;
        Dpi dpi;
        InterSenderInfo senderInfo;
        Resource interactionResource;
        Resource resource;
        Intrinsics.checkNotNullParameter(getLocation, "$this$getLocation");
        SitDownInfo sitDown = getLocation.getSitDown();
        Size size = null;
        Size showSize = (sitDown == null || (resource = sitDown.getResource()) == null) ? null : resource.getShowSize();
        if (getLocation.isSend()) {
            InterResourceInfo interaction = getLocation.getInteraction();
            showSize = (interaction == null || (senderInfo = interaction.getSenderInfo()) == null || (interactionResource = senderInfo.getInteractionResource()) == null) ? null : interactionResource.getShowSize();
        }
        if (getLocation.isReceiver()) {
            InterResourceInfo interaction2 = getLocation.getInteraction();
            if (interaction2 != null && (receiverInfo = interaction2.getReceiverInfo()) != null && (placeholder = receiverInfo.getPlaceholder()) != null && (dpi = placeholder.getDpi()) != null) {
                size = Dpi.formatSize$default(dpi, false, 1, null);
            }
            showSize = size;
        }
        SitDownInfo sitDown2 = getLocation.getSitDown();
        if (sitDown2 != null && sitDown2.getIsFlexTable()) {
            Square.INSTANCE.getApplication();
            SitDownInfo sitDown3 = getLocation.getSitDown();
            int i3 = (sitDown3 == null || (sitLocation2 = sitDown3.getSitLocation()) == null) ? 0 : sitLocation2.x;
            SitDownInfo sitDown4 = getLocation.getSitDown();
            int i16 = (sitDown4 == null || (sitLocation = sitDown4.getSitLocation()) == null) ? 0 : sitLocation.y;
            int width = showSize != null ? showSize.getWidth() : 0;
            int height = showSize != null ? showSize.getHeight() : 0;
            return new Location(i3 - (width / 2), i16 - ((int) (height * 0.85f)), width, height, 0, 0, 48, null);
        }
        Location location2 = new Location(0, 0, 0, 0, 0, 0, 48, null);
        SitDownInfo sitDown5 = getLocation.getSitDown();
        return (sitDown5 == null || (table = sitDown5.getTable()) == null || (location = table.getLocation()) == null || showSize == null) ? location2 : MapItemKt.relocation(location, showSize);
    }

    public static final boolean isMe(long j3) {
        return Intrinsics.areEqual(String.valueOf(j3), SquareBaseKt.getSquareCommon().getCurrentAccountUin());
    }

    public static final boolean isMeSeated(CommonRoomInfo isMeSeated) {
        Intrinsics.checkNotNullParameter(isMeSeated, "$this$isMeSeated");
        List<User> users = isMeSeated.getUsers();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = users.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((User) next).getStatus() == UserStatus.SIT_DOWN) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                if (((User) it5.next()).isMe()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean isRoomFull(CommonRoomInfo isRoomFull) {
        Intrinsics.checkNotNullParameter(isRoomFull, "$this$isRoomFull");
        List<User> users = isRoomFull.getUsers();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = users.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((User) next).getStatus() == UserStatus.SIT_DOWN) {
                arrayList.add(next);
            }
        }
        int size = arrayList.size();
        return isRoomFull.getMaxPeople() > 0 ? size >= isRoomFull.getMaxPeople() : size >= isRoomFull.getTables().size();
    }

    public static final boolean needShowCallBackIcon(RemainTimeInfo needShowCallBackIcon) {
        Intrinsics.checkNotNullParameter(needShowCallBackIcon, "$this$needShowCallBackIcon");
        return needShowCallBackIcon.getSitDownStartTs() > 0 && needShowCallBackIcon.getHeartbeatLastTs() > 0 && needShowCallBackIcon.getMaxLifeSeconds() > 0 && (System.currentTimeMillis() / ((long) 1000)) - needShowCallBackIcon.getHeartbeatLastTs() < ((long) needShowCallBackIcon.getMaxLifeSeconds());
    }

    public static final long pastTime(RemainTimeInfo pastTime) {
        Intrinsics.checkNotNullParameter(pastTime, "$this$pastTime");
        return System.currentTimeMillis() - (pastTime.getHeartbeatLastTs() * 1000);
    }
}
