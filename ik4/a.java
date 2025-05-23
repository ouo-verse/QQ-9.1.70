package ik4;

import android.text.TextUtils;
import cooperation.qzone.util.WnsError;
import hk4.a;
import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.YoloRoomOuterClass$QQLiveRoomConfig;
import trpc.yes.common.YoloTeamOuterClass$YoloSmobaTeamParams;
import trpc.yes.common.YoloTeamOuterClass$YoloTeamEnterCondition;
import trpc.yes.common.YoloTeamOuterClass$YoloTeamEnterConditionReq;
import trpc.yes.common.YoloTeamOuterClass$YoloTeamUserShowInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends pl4.a {
    public static NewIntent d(a.b bVar) {
        YoloTeamOuterClass$YoloTeamEnterCondition yoloTeamOuterClass$YoloTeamEnterCondition = new YoloTeamOuterClass$YoloTeamEnterCondition();
        yoloTeamOuterClass$YoloTeamEnterCondition.game_id.set(bVar.f405218c);
        YoloTeamOuterClass$YoloTeamUserShowInfo yoloTeamOuterClass$YoloTeamUserShowInfo = new YoloTeamOuterClass$YoloTeamUserShowInfo();
        if (!TextUtils.isEmpty(bVar.f405220e)) {
            yoloTeamOuterClass$YoloTeamUserShowInfo.show_avatar_url.set(bVar.f405220e);
        }
        if (!TextUtils.isEmpty(bVar.f405219d)) {
            yoloTeamOuterClass$YoloTeamUserShowInfo.show_nick.set(bVar.f405219d);
        }
        yoloTeamOuterClass$YoloTeamUserShowInfo.gender.set(bVar.f405221f);
        yoloTeamOuterClass$YoloTeamEnterCondition.show_info.set(yoloTeamOuterClass$YoloTeamUserShowInfo);
        YoloRoomOuterClass$QQLiveRoomConfig yoloRoomOuterClass$QQLiveRoomConfig = bVar.f405216a;
        if (yoloRoomOuterClass$QQLiveRoomConfig != null) {
            yoloTeamOuterClass$YoloTeamEnterCondition.qq_live_room_config.set(yoloRoomOuterClass$QQLiveRoomConfig);
            YoloTeamOuterClass$YoloSmobaTeamParams yoloTeamOuterClass$YoloSmobaTeamParams = new YoloTeamOuterClass$YoloSmobaTeamParams();
            yoloTeamOuterClass$YoloSmobaTeamParams.game_mode.set(bVar.f405222g);
            yoloTeamOuterClass$YoloTeamEnterCondition.smoba_team_params.set(yoloTeamOuterClass$YoloSmobaTeamParams);
        } else {
            yoloTeamOuterClass$YoloTeamEnterCondition.guild_join_config.set(bVar.f405217b);
            yoloTeamOuterClass$YoloTeamEnterCondition.type_source.set(3);
        }
        YoloTeamOuterClass$YoloTeamEnterConditionReq yoloTeamOuterClass$YoloTeamEnterConditionReq = new YoloTeamOuterClass$YoloTeamEnterConditionReq();
        yoloTeamOuterClass$YoloTeamEnterConditionReq.enter_condition.set(yoloTeamOuterClass$YoloTeamEnterCondition);
        return a.C11028a.a(yoloTeamOuterClass$YoloTeamEnterConditionReq, a.class);
    }

    @Override // pl4.a
    protected int b() {
        return WnsError.WNS_CODE_LOGIN_PTLOGIN_BUSY;
    }
}
