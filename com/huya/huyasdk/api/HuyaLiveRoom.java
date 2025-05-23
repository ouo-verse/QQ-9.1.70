package com.huya.huyasdk.api;

import com.huya.huyasdk.api.HuyaLiveJoinConfig;
import com.huya.huyasdk.api.HuyaLiveJoinResult;
import com.huya.huyasdk.api.HuyaLiveRoom;
import com.huya.huyasdk.service.api.IBarrageService;
import com.huya.huyasdk.service.api.ILiveRoomEventService;
import com.huya.huyasdk.service.api.ISubscribeService;
import hynb.i.a;
import hynb.j.d;
import hynb.p.g;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HuyaLiveRoom {
    public static final String TAG = "HuyaLiveRoom";

    public static /* synthetic */ void a(HuyaLiveJoinConfig huyaLiveJoinConfig, HuyaLiveJoinCallback huyaLiveJoinCallback, HuyaLiveJoinResult huyaLiveJoinResult) {
        if (huyaLiveJoinResult.isSucceed) {
            long j3 = huyaLiveJoinConfig.presenterUid;
            ((ISubscribeService) d.a(ISubscribeService.class)).startSubscriptionMonitoring(j3);
            ((IBarrageService) d.a(IBarrageService.class)).onJoinLive(j3);
            a.a().b(j3);
        }
        if (huyaLiveJoinCallback != null) {
            huyaLiveJoinCallback.onJoinResult(huyaLiveJoinResult);
        }
    }

    public static void joinLive(final HuyaLiveJoinConfig huyaLiveJoinConfig, final HuyaLiveJoinCallback huyaLiveJoinCallback) {
        ((ILiveRoomEventService) d.a(ILiveRoomEventService.class)).enterLiveRoom(huyaLiveJoinConfig, new HuyaLiveJoinCallback() { // from class: z2.a
            @Override // com.huya.huyasdk.api.HuyaLiveJoinCallback
            public final void onJoinResult(HuyaLiveJoinResult huyaLiveJoinResult) {
                HuyaLiveRoom.a(HuyaLiveJoinConfig.this, huyaLiveJoinCallback, huyaLiveJoinResult);
            }
        });
    }

    public static void quitLive() {
        long quitLiveRoom = ((ILiveRoomEventService) d.a(ILiveRoomEventService.class)).quitLiveRoom();
        g.f406799a.a(TAG, "quitLive: quitPresenterId: %s", Long.valueOf(quitLiveRoom));
        if (quitLiveRoom == 0) {
            return;
        }
        ((ISubscribeService) d.a(ISubscribeService.class)).stopSubscriptionMonitoring(quitLiveRoom);
        ((IBarrageService) d.a(IBarrageService.class)).onQuitLive(quitLiveRoom);
        a.a().a(quitLiveRoom);
    }

    public static void setLiveRoomEventCallback(LiveRoomEventCallback liveRoomEventCallback) {
        g.f406799a.info(TAG, "setLiveRoomEventCallback: callback: " + liveRoomEventCallback);
        ((ILiveRoomEventService) d.a(ILiveRoomEventService.class)).registerLiveEvent(liveRoomEventCallback);
    }
}
