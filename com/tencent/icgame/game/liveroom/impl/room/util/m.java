package com.tencent.icgame.game.liveroom.impl.room.util;

import android.os.Bundle;
import android.view.View;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.mobileqq.icgame.api.room.IAudienceRoom;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\n"}, d2 = {"", "roomId", "", "b", "Lcom/tencent/mobileqq/qqlive/data/room/LiveAnchorInfo;", "a", "Landroid/view/View;", "decorView", "", "c", "ic-game-timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class m {
    @Nullable
    public static final LiveAnchorInfo a(long j3) {
        IAudienceRoom N = ((fu0.c) qx0.a.b(fu0.c.class)).N(j3);
        if (N == null) {
            com.tencent.icgame.game.utils.g.d("ICGameRoomUtil", "audience room is null");
            return null;
        }
        LiveInfo roomLiveInfo = N.getRoomLiveInfo();
        if (roomLiveInfo == null) {
            com.tencent.icgame.game.utils.g.d("ICGameRoomUtil", "liveInfo is null");
            return null;
        }
        LiveAnchorInfo liveAnchorInfo = roomLiveInfo.anchorInfo;
        if (liveAnchorInfo == null) {
            com.tencent.icgame.game.utils.g.d("ICGameRoomUtil", "anchorInfo is null");
            return null;
        }
        return liveAnchorInfo;
    }

    public static final int b(long j3) {
        LiveRoomInfo liveRoomInfo;
        Bundle bundle;
        boolean z16;
        IAudienceRoom y16 = ((fu0.c) qx0.a.b(fu0.c.class)).y(j3);
        LiveRoomExtraInfo liveRoomExtraInfo = null;
        if (y16 != null) {
            Integer valueOf = Integer.valueOf(y16.getRoomType());
            if (valueOf.intValue() != -1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                valueOf = null;
            }
            if (valueOf != null) {
                int intValue = valueOf.intValue();
                QLog.i("ICGameRoomUtil", 4, "preload audienceRoom roomType:" + intValue);
                return intValue;
            }
        }
        fu0.d s16 = ((fu0.c) qx0.a.b(fu0.c.class)).s();
        if (s16 != null) {
            LiveInfo d16 = s16.d(j3);
            if (d16 != null && (liveRoomInfo = d16.roomInfo) != null && (bundle = liveRoomInfo.extData) != null) {
                liveRoomExtraInfo = (LiveRoomExtraInfo) bundle.getParcelable("live_room_extra_data");
            }
            if (liveRoomExtraInfo != null) {
                int i3 = liveRoomExtraInfo.f114882f;
                QLog.i("ICGameRoomUtil", 4, "audienceRoom roomType:" + i3);
                return i3;
            }
        }
        QLog.i("ICGameRoomUtil", 1, "unknownRoom");
        return 1;
    }

    public static final void c(@NotNull View decorView) {
        Intrinsics.checkNotNullParameter(decorView, "decorView");
        decorView.setSystemUiVisibility(5894);
    }
}
