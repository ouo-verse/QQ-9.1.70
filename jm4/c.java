package jm4;

import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.YoloRoomOuterClass$DoYoloRoomCmdReq;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomCmdReq;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c extends pl4.a {
    public static NewIntent d(long j3, int i3, long j16, YoloRoomOuterClass$YoloRoomCmdReq yoloRoomOuterClass$YoloRoomCmdReq) {
        YoloRoomOuterClass$DoYoloRoomCmdReq yoloRoomOuterClass$DoYoloRoomCmdReq = new YoloRoomOuterClass$DoYoloRoomCmdReq();
        yoloRoomOuterClass$DoYoloRoomCmdReq.room_id.set(j3);
        yoloRoomOuterClass$DoYoloRoomCmdReq.cmd_type.set(i3);
        yoloRoomOuterClass$DoYoloRoomCmdReq.client_seq_id.set(j16);
        if (yoloRoomOuterClass$YoloRoomCmdReq != null) {
            yoloRoomOuterClass$DoYoloRoomCmdReq.yolo_room_cmd_req.set(yoloRoomOuterClass$YoloRoomCmdReq);
        }
        return a.C11028a.a(yoloRoomOuterClass$DoYoloRoomCmdReq, c.class);
    }

    @Override // pl4.a
    protected int b() {
        return 924;
    }
}
