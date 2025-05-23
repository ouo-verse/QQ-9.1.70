package ik4;

import cooperation.qzone.util.WnsError;
import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.YoloTeamOuterClass$YoloTeamJoinBattleReq;
import trpc.yes.common.YoloTeamOuterClass$YoloTeamUserShowInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b extends pl4.a {
    public static NewIntent d(long j3, int i3, int i16, String str, String str2, int i17) {
        YoloTeamOuterClass$YoloTeamJoinBattleReq yoloTeamOuterClass$YoloTeamJoinBattleReq = new YoloTeamOuterClass$YoloTeamJoinBattleReq();
        yoloTeamOuterClass$YoloTeamJoinBattleReq.team_id.set(j3);
        yoloTeamOuterClass$YoloTeamJoinBattleReq.enter_from.set(i3);
        yoloTeamOuterClass$YoloTeamJoinBattleReq.game_id.set(i16);
        YoloTeamOuterClass$YoloTeamUserShowInfo yoloTeamOuterClass$YoloTeamUserShowInfo = new YoloTeamOuterClass$YoloTeamUserShowInfo();
        yoloTeamOuterClass$YoloTeamUserShowInfo.show_avatar_url.set(str);
        yoloTeamOuterClass$YoloTeamUserShowInfo.show_nick.set(str2);
        yoloTeamOuterClass$YoloTeamUserShowInfo.gender.set(i17);
        yoloTeamOuterClass$YoloTeamJoinBattleReq.show_info.set(yoloTeamOuterClass$YoloTeamUserShowInfo);
        return a.C11028a.a(yoloTeamOuterClass$YoloTeamJoinBattleReq, b.class);
    }

    @Override // pl4.a
    protected int b() {
        return WnsError.WNS_CODE_LOGIN_3GSVR_BUSY;
    }
}
