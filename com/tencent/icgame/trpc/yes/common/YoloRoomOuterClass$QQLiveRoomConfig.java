package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$QQLiveRoomConfig extends MessageMicro<YoloRoomOuterClass$QQLiveRoomConfig> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField qq_live_room_id = PBField.initString("");
    public final PBUInt64Field qq_live_uid = PBField.initUInt64(0);
    public final PBStringField trtc_room_id = PBField.initString("");
    public final PBInt32Field enter_condition = PBField.initInt32(0);
    public final PBStringField anchor_id = PBField.initString("");
    public final PBBoolField is_screen_capture = PBField.initBool(false);
    public final PBInt64Field live_uid = PBField.initInt64(0);
    public CommonOuterClass$QQUserId qq_live_user_id = new CommonOuterClass$QQUserId();
    public final PBBoolField is_live_event_room = PBField.initBool(false);
    public final PBStringField game_openid = PBField.initString("");

    static {
        String[] strArr = {"qq_live_room_id", "qq_live_uid", "trtc_room_id", "enter_condition", AudienceReportConst.ANCHOR_ID, "is_screen_capture", "live_uid", "qq_live_user_id", "is_live_event_room", "game_openid"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 42, 48, 56, 66, 72, 802}, strArr, new Object[]{"", 0L, "", 0, "", bool, 0L, null, bool, ""}, YoloRoomOuterClass$QQLiveRoomConfig.class);
    }
}
