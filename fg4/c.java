package fg4;

import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.GameDataServerOuterClass$CreateCFMGroupRoomReq;
import trpc.yes.common.GameDataServerOuterClass$CreateCFMGroupRoomRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c extends pl4.a {
    private static NewIntent d(int i3, int i16, int i17, String str) {
        GameDataServerOuterClass$CreateCFMGroupRoomReq gameDataServerOuterClass$CreateCFMGroupRoomReq = new GameDataServerOuterClass$CreateCFMGroupRoomReq();
        gameDataServerOuterClass$CreateCFMGroupRoomReq.uid.set(((ll4.a) mm4.b.b(ll4.a.class)).h());
        gameDataServerOuterClass$CreateCFMGroupRoomReq.area.set(203);
        gameDataServerOuterClass$CreateCFMGroupRoomReq.plat_id.set(1);
        gameDataServerOuterClass$CreateCFMGroupRoomReq.room_id.set(i3);
        gameDataServerOuterClass$CreateCFMGroupRoomReq.map_id.set(i16);
        gameDataServerOuterClass$CreateCFMGroupRoomReq.match_type.set(i17);
        gameDataServerOuterClass$CreateCFMGroupRoomReq.room_name.set(str);
        return a.C11028a.a(gameDataServerOuterClass$CreateCFMGroupRoomReq, c.class);
    }

    public static void e(int i3, int i16, int i17, String str, pl4.d<GameDataServerOuterClass$CreateCFMGroupRoomRsp> dVar) {
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(d(i3, i16, i17, str), GameDataServerOuterClass$CreateCFMGroupRoomRsp.class, dVar);
    }

    @Override // pl4.a
    protected int b() {
        return 327;
    }
}
