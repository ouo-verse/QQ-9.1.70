package jm4;

import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomLeaveReq;

/* compiled from: P */
/* loaded from: classes26.dex */
public class h extends pl4.a {
    public static NewIntent d(long j3, boolean z16, int i3) {
        YoloRoomOuterClass$YoloRoomLeaveReq yoloRoomOuterClass$YoloRoomLeaveReq = new YoloRoomOuterClass$YoloRoomLeaveReq();
        yoloRoomOuterClass$YoloRoomLeaveReq.room_id.set(j3);
        yoloRoomOuterClass$YoloRoomLeaveReq.force_exit.set(z16 ? 1 : 0);
        yoloRoomOuterClass$YoloRoomLeaveReq.room_type.set(i3);
        return a.C11028a.a(yoloRoomOuterClass$YoloRoomLeaveReq, h.class);
    }

    @Override // pl4.a
    protected int b() {
        return 922;
    }
}
