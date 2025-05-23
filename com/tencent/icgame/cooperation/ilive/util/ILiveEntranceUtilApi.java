package com.tencent.icgame.cooperation.ilive.util;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import xt0.a;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes7.dex */
public interface ILiveEntranceUtilApi extends QRouteApi {
    boolean checkIsAnchorRoomNow();

    Class getICGameJumpParserClass();

    boolean isClickEnable(int i3);

    void liveWatchEntranceJump(a aVar);
}
