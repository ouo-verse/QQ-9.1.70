package fg4;

import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.GameDataServerOuterClass$CreateCFMGroupTeamReq;
import trpc.yes.common.GameDataServerOuterClass$CreateCFMGroupTeamRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d extends pl4.a {
    private static NewIntent d(int i3, int i16, int i17) {
        GameDataServerOuterClass$CreateCFMGroupTeamReq gameDataServerOuterClass$CreateCFMGroupTeamReq = new GameDataServerOuterClass$CreateCFMGroupTeamReq();
        gameDataServerOuterClass$CreateCFMGroupTeamReq.uid.set(((ll4.a) mm4.b.b(ll4.a.class)).h());
        gameDataServerOuterClass$CreateCFMGroupTeamReq.area.set(203);
        gameDataServerOuterClass$CreateCFMGroupTeamReq.plat_id.set(1);
        gameDataServerOuterClass$CreateCFMGroupTeamReq.room_id.set(i3);
        gameDataServerOuterClass$CreateCFMGroupTeamReq.map_id.set(i16);
        gameDataServerOuterClass$CreateCFMGroupTeamReq.match_type.set(i17);
        return a.C11028a.a(gameDataServerOuterClass$CreateCFMGroupTeamReq, d.class);
    }

    public static void e(int i3, int i16, int i17, pl4.d<GameDataServerOuterClass$CreateCFMGroupTeamRsp> dVar) {
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(d(i3, i16, i17), GameDataServerOuterClass$CreateCFMGroupTeamRsp.class, dVar);
    }

    @Override // pl4.a
    protected int b() {
        return 326;
    }
}
