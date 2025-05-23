package dn4;

import java.util.List;
import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.PremadesTeamServerOuterClass$RefreshGameRoomInfoReq;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends pl4.a {
    public static NewIntent d(List<Long> list, List<CommonOuterClass$QQUserId> list2, int i3) {
        PremadesTeamServerOuterClass$RefreshGameRoomInfoReq premadesTeamServerOuterClass$RefreshGameRoomInfoReq = new PremadesTeamServerOuterClass$RefreshGameRoomInfoReq();
        premadesTeamServerOuterClass$RefreshGameRoomInfoReq.team_id_list.set(list);
        premadesTeamServerOuterClass$RefreshGameRoomInfoReq.user_id_list.set(list2);
        premadesTeamServerOuterClass$RefreshGameRoomInfoReq.game_id.set(i3);
        return a.C11028a.a(premadesTeamServerOuterClass$RefreshGameRoomInfoReq, a.class);
    }

    @Override // pl4.a
    protected int b() {
        return 507;
    }
}
