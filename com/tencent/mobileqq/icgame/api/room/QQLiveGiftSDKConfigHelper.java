package com.tencent.mobileqq.icgame.api.room;

import com.tencent.icgame.game.liveroom.impl.room.util.m;
import com.tencent.mobileqq.icgame.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import fu0.c;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qx0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0017\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/room/QQLiveGiftSDKConfigHelper;", "", "()V", "getSceneIdAuto", "", "roomId", "", "(Ljava/lang/Long;)I", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class QQLiveGiftSDKConfigHelper {

    @NotNull
    public static final QQLiveGiftSDKConfigHelper INSTANCE = new QQLiveGiftSDKConfigHelper();

    QQLiveGiftSDKConfigHelper() {
    }

    public static /* synthetic */ int getSceneIdAuto$default(QQLiveGiftSDKConfigHelper qQLiveGiftSDKConfigHelper, Long l3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            l3 = null;
        }
        return qQLiveGiftSDKConfigHelper.getSceneIdAuto(l3);
    }

    public final int getSceneIdAuto() {
        BaseRoomInfo q16 = ((c) a.b(c.class)).q(0L);
        return q16 == null ? QQLiveSDKConfigHelper.getSceneId() : QQLiveSDKConfigHelper.getSceneIdByRoomType(m.b(q16.getRoomId()));
    }

    public final int getSceneIdAuto(@Nullable Long roomId) {
        if (roomId != null && roomId.longValue() > 0) {
            return QQLiveSDKConfigHelper.getSceneIdByRoomType(m.b(roomId.longValue()));
        }
        return getSceneIdAuto();
    }
}
