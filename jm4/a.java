package jm4;

import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.PremadesTeamServerOuterClass$BatchGetGameTeamInfoReq;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends pl4.a {
    public static NewIntent d(long j3, int i3, long j16) {
        PremadesTeamServerOuterClass$BatchGetGameTeamInfoReq premadesTeamServerOuterClass$BatchGetGameTeamInfoReq = new PremadesTeamServerOuterClass$BatchGetGameTeamInfoReq();
        premadesTeamServerOuterClass$BatchGetGameTeamInfoReq.uid.set(j3);
        premadesTeamServerOuterClass$BatchGetGameTeamInfoReq.game_id.set(i3);
        premadesTeamServerOuterClass$BatchGetGameTeamInfoReq.team_id_list.add(Long.valueOf(j16));
        return a.C11028a.a(premadesTeamServerOuterClass$BatchGetGameTeamInfoReq, a.class);
    }

    @Override // pl4.a
    protected int b() {
        return 508;
    }
}
