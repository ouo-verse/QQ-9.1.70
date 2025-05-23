package com.tencent.icgame.trpc.yes.common;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tenpay.sdk.util.UinConfigManager;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$YoloRoomInfo extends MessageMicro<YoloRoomOuterClass$YoloRoomInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 82, 88, 98, 106, 114, 122, 130, 136, 146, 154, 800, 808, 816, 824}, new String[]{AudienceReportConst.ROOM_ID, "owner_uid", "create_uid", "tim_group_id", "room_type", "status", "is_private", "theme", "background", "introduce", AlbumCacheData.CREATE_TIME, "game_route_info", "game_data_info", "room_data_info", UinConfigManager.KEY_ADS, "room_cover", "is_need_apply_inspeaking", "owner_user_id", "create_user_id", "server_index", "is_not_close", "owner_yes_uid", "create_yes_uid"}, new Object[]{0L, 0L, 0L, 0L, 0, 0, 0, 0, 0, "", 0, null, null, null, "", "", 0, null, null, 0, 0, 0L, 0L}, YoloRoomOuterClass$YoloRoomInfo.class);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBUInt64Field owner_uid = PBField.initUInt64(0);
    public final PBUInt64Field create_uid = PBField.initUInt64(0);
    public final PBUInt64Field tim_group_id = PBField.initUInt64(0);
    public final PBInt32Field room_type = PBField.initInt32(0);
    public final PBInt32Field status = PBField.initInt32(0);
    public final PBInt32Field is_private = PBField.initInt32(0);
    public final PBInt32Field theme = PBField.initInt32(0);
    public final PBInt32Field background = PBField.initInt32(0);
    public final PBStringField introduce = PBField.initString("");
    public final PBUInt32Field create_time = PBField.initUInt32(0);
    public YoloRoomOuterClass$YoloGameRouteInfo game_route_info = new YoloRoomOuterClass$YoloGameRouteInfo();
    public YoloRoomOuterClass$YoloGameDataInfo game_data_info = new YoloRoomOuterClass$YoloGameDataInfo();
    public YoloRoomOuterClass$YoloRoomDataInfo room_data_info = new MessageMicro<YoloRoomOuterClass$YoloRoomDataInfo>() { // from class: com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomDataInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 66, 72, 80}, new String[]{"min_player_num", "max_player_num", "max_user_num", "max_speaking_num", "create_from", "guild_id", "channel_id", "channel_name", "sub_create_from", "game_id"}, new Object[]{0, 0, 0, 0, 0, 0L, 0L, "", 0, 0}, YoloRoomOuterClass$YoloRoomDataInfo.class);
        public final PBInt32Field min_player_num = PBField.initInt32(0);
        public final PBInt32Field max_player_num = PBField.initInt32(0);
        public final PBInt32Field max_user_num = PBField.initInt32(0);
        public final PBInt32Field max_speaking_num = PBField.initInt32(0);
        public final PBInt32Field create_from = PBField.initInt32(0);
        public final PBUInt64Field guild_id = PBField.initUInt64(0);
        public final PBUInt64Field channel_id = PBField.initUInt64(0);
        public final PBStringField channel_name = PBField.initString("");
        public final PBInt32Field sub_create_from = PBField.initInt32(0);
        public final PBInt32Field game_id = PBField.initInt32(0);
    };
    public final PBStringField notice = PBField.initString("");
    public final PBStringField room_cover = PBField.initString("");
    public final PBInt32Field is_need_apply_inspeaking = PBField.initInt32(0);
    public CommonOuterClass$QQUserId owner_user_id = new CommonOuterClass$QQUserId();
    public CommonOuterClass$QQUserId create_user_id = new CommonOuterClass$QQUserId();
    public final PBInt32Field server_index = PBField.initInt32(0);
    public final PBInt32Field is_not_close = PBField.initInt32(0);
    public final PBUInt64Field owner_yes_uid = PBField.initUInt64(0);
    public final PBUInt64Field create_yes_uid = PBField.initUInt64(0);
}
