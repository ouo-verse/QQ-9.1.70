package jm4;

import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomRecoverReq;

/* compiled from: P */
/* loaded from: classes26.dex */
public class i extends pl4.a {
    public static NewIntent d(long j3) {
        YoloRoomOuterClass$YoloRoomRecoverReq yoloRoomOuterClass$YoloRoomRecoverReq = new YoloRoomOuterClass$YoloRoomRecoverReq();
        yoloRoomOuterClass$YoloRoomRecoverReq.room_id.set(j3);
        return a.C11028a.a(yoloRoomOuterClass$YoloRoomRecoverReq, i.class);
    }

    @Override // pl4.a
    protected int b() {
        return 923;
    }
}
