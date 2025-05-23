package com.tencent.icgame.game.liveroom.impl.room.util;

import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;

/* compiled from: P */
/* loaded from: classes7.dex */
public class i {
    public static PreloadTRTCPlayerParams a(LiveRoomExtraInfo liveRoomExtraInfo) {
        PreloadTRTCPlayerParams preloadTRTCPlayerParams = new PreloadTRTCPlayerParams();
        if (liveRoomExtraInfo == null) {
            return preloadTRTCPlayerParams;
        }
        preloadTRTCPlayerParams.trtcSig = liveRoomExtraInfo.b(PreloadTRTCPlayerParams.KEY_SIG);
        preloadTRTCPlayerParams.streamId = liveRoomExtraInfo.b(PreloadTRTCPlayerParams.KEY_STREAM_ID);
        preloadTRTCPlayerParams.anchorId = liveRoomExtraInfo.b("anchorid");
        return preloadTRTCPlayerParams;
    }
}
