package com.tencent.icgame.trpc.yes.common;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class PremadesTeamServerOuterClass$YesGamePremadesTeamInfo extends MessageMicro<PremadesTeamServerOuterClass$YesGamePremadesTeamInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50, 56, 66, 72, 82, 90, 98, 104, 112, 120, 130, 138, 144, 154, 160, 168, 178, 184, 192}, new String[]{"id", "type", "name", "grade_desc", "grade_list", "lane_type_desc", "lane_type_list", "game_mode_name", "game_mode", "user_list", "icon_list", "origin_id", AlbumCacheData.CREATE_TIME, "status", "game_status", "gift_config", "qq_live_room_config", "owner_uid", "lable_list", "private_show", "game_id", "owner_user_id", "create_from", "channel_id"}, new Object[]{0L, 0, "", "", 0, "", 0, "", 0, null, null, "", 0L, 0, 0, null, null, 0L, "", 0, 0, null, 0, 0L}, PremadesTeamServerOuterClass$YesGamePremadesTeamInfo.class);
    public final PBUInt64Field channel_id;
    public final PBUInt32Field create_from;
    public final PBInt64Field create_time;
    public final PBInt32Field game_id;
    public final PBInt32Field game_mode;
    public final PBStringField game_mode_name;
    public final PBInt32Field game_status;
    public YoloRoomOuterClass$YoloGiftConfig gift_config;
    public final PBRepeatField<Integer> grade_list;
    public final PBRepeatMessageField<PremadesTeamServerOuterClass$YesGamePremadesTeamIcon> icon_list;
    public final PBRepeatField<String> lable_list;
    public final PBStringField lane_type_desc;
    public final PBRepeatField<Integer> lane_type_list;
    public final PBStringField origin_id;
    public final PBUInt64Field owner_uid;
    public CommonOuterClass$QQUserId owner_user_id;
    public final PBInt32Field private_show;
    public YoloRoomOuterClass$QQLiveRoomConfig qq_live_room_config;
    public final PBInt32Field status;
    public final PBRepeatMessageField<PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo> user_list;

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f116206id = PBField.initUInt64(0);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField grade_desc = PBField.initString("");

    public PremadesTeamServerOuterClass$YesGamePremadesTeamInfo() {
        PBInt32Field pBInt32Field = PBInt32Field.__repeatHelper__;
        this.grade_list = PBField.initRepeat(pBInt32Field);
        this.lane_type_desc = PBField.initString("");
        this.lane_type_list = PBField.initRepeat(pBInt32Field);
        this.game_mode_name = PBField.initString("");
        this.game_mode = PBField.initInt32(0);
        this.user_list = PBField.initRepeatMessage(PremadesTeamServerOuterClass$YesGamePremadesTeamUserInfo.class);
        this.icon_list = PBField.initRepeatMessage(PremadesTeamServerOuterClass$YesGamePremadesTeamIcon.class);
        this.origin_id = PBField.initString("");
        this.create_time = PBField.initInt64(0L);
        this.status = PBField.initInt32(0);
        this.game_status = PBField.initInt32(0);
        this.gift_config = new YoloRoomOuterClass$YoloGiftConfig();
        this.qq_live_room_config = new YoloRoomOuterClass$QQLiveRoomConfig();
        this.owner_uid = PBField.initUInt64(0L);
        this.lable_list = PBField.initRepeat(PBStringField.__repeatHelper__);
        this.private_show = PBField.initInt32(0);
        this.game_id = PBField.initInt32(0);
        this.owner_user_id = new CommonOuterClass$QQUserId();
        this.create_from = PBField.initUInt32(0);
        this.channel_id = PBField.initUInt64(0L);
    }
}
