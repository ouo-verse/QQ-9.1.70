package fg4;

import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.GameDataServerOuterClass$CreateCODMGroupRoomReq;
import trpc.yes.common.GameDataServerOuterClass$CreateCODMGroupRoomRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class e extends pl4.a {
    private static NewIntent d(int i3) {
        GameDataServerOuterClass$CreateCODMGroupRoomReq gameDataServerOuterClass$CreateCODMGroupRoomReq = new GameDataServerOuterClass$CreateCODMGroupRoomReq();
        gameDataServerOuterClass$CreateCODMGroupRoomReq.uid.set(((ll4.a) mm4.b.b(ll4.a.class)).h());
        gameDataServerOuterClass$CreateCODMGroupRoomReq.area.set(9012);
        gameDataServerOuterClass$CreateCODMGroupRoomReq.plat_id.set(1);
        gameDataServerOuterClass$CreateCODMGroupRoomReq.room_type.set(i3);
        return a.C11028a.a(gameDataServerOuterClass$CreateCODMGroupRoomReq, e.class);
    }

    public static void e(int i3, pl4.d<GameDataServerOuterClass$CreateCODMGroupRoomRsp> dVar) {
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(d(i3), GameDataServerOuterClass$CreateCODMGroupRoomRsp.class, dVar);
    }

    @Override // pl4.a
    protected int b() {
        return 325;
    }
}
