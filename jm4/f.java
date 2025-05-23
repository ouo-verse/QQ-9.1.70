package jm4;

import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.YoloRoomOuterClass$GetYoloRoomDataReq;

/* compiled from: P */
/* loaded from: classes26.dex */
public class f extends pl4.a {
    public static NewIntent d(long j3, long j16, int i3) {
        YoloRoomOuterClass$GetYoloRoomDataReq yoloRoomOuterClass$GetYoloRoomDataReq = new YoloRoomOuterClass$GetYoloRoomDataReq();
        yoloRoomOuterClass$GetYoloRoomDataReq.room_id.set(j3);
        yoloRoomOuterClass$GetYoloRoomDataReq.client_max_id.set(j16);
        yoloRoomOuterClass$GetYoloRoomDataReq.is_update_heartbeat.set(i3);
        return a.C11028a.a(yoloRoomOuterClass$GetYoloRoomDataReq, f.class);
    }

    @Override // pl4.a
    protected int b() {
        return 925;
    }
}
