package com.tencent.icgame.trpc.yes.common;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloTeamOuterClass$YoloTeamCreateReq extends MessageMicro<YoloTeamOuterClass$YoloTeamCreateReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 26, 34, 802}, new String[]{"show_info", "team_params", "smoba_room_params", "game_route_info"}, new Object[]{null, null, null, null}, YoloTeamOuterClass$YoloTeamCreateReq.class);
    public YoloTeamOuterClass$YoloTeamUserShowInfo show_info = new YoloTeamOuterClass$YoloTeamUserShowInfo();
    public YoloTeamOuterClass$YoloTeamParams team_params = new MessageMicro<YoloTeamOuterClass$YoloTeamParams>() { // from class: com.tencent.icgame.trpc.yes.common.YoloTeamOuterClass$YoloTeamParams
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 800, 808, 818}, new String[]{"game_id", "create_from", "guild_id", "game_openid", "team_id", "create_with_battle", "anchor_smoba_info"}, new Object[]{0, 0, 0L, "", 0L, Boolean.FALSE, null}, YoloTeamOuterClass$YoloTeamParams.class);
        public final PBInt32Field game_id = PBField.initInt32(0);
        public final PBInt32Field create_from = PBField.initInt32(0);
        public final PBUInt64Field guild_id = PBField.initUInt64(0);
        public final PBStringField game_openid = PBField.initString("");
        public final PBUInt64Field team_id = PBField.initUInt64(0);
        public final PBBoolField create_with_battle = PBField.initBool(false);
        public YoloTeamOuterClass$YoloTeamAnchorSmobaInfo anchor_smoba_info = new MessageMicro<YoloTeamOuterClass$YoloTeamAnchorSmobaInfo>() { // from class: com.tencent.icgame.trpc.yes.common.YoloTeamOuterClass$YoloTeamAnchorSmobaInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40}, new String[]{"phone_system", "game_openid", GdtGetUserInfoHandler.KEY_AREA, "partition", "camp_id"}, new Object[]{0, "", 0, 0, 0}, YoloTeamOuterClass$YoloTeamAnchorSmobaInfo.class);
            public final PBInt32Field phone_system = PBField.initInt32(0);
            public final PBStringField game_openid = PBField.initString("");
            public final PBInt32Field area = PBField.initInt32(0);
            public final PBInt32Field partition = PBField.initInt32(0);
            public final PBInt32Field camp_id = PBField.initInt32(0);
        };
    };
    public YoloRoomOuterClass$YoloSmobaRoomParams smoba_room_params = new YoloRoomOuterClass$YoloSmobaRoomParams();
    public YoloRoomOuterClass$YoloGameRouteInfo game_route_info = new YoloRoomOuterClass$YoloGameRouteInfo();
}
