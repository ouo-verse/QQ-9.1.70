package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes9.dex */
public final class NowQQLiveHomepageProto$RcmdAnchor extends MessageMicro<NowQQLiveHomepageProto$RcmdAnchor> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 58, 66, 74, 82, 90, 98, 104, 114, 120, 130, 138, 144, 152, 162, 168, 178, 186, 192}, new String[]{"string_name", "string_id", "string_head_img_url", "string_room_img_url", "string_location", "uint32_watch_count", "string_description", "string_jump_url", "string_authentication_tag", "rich_title", "extra_info", "propInfo", "hall_room_id", "award_pendant_url", "microphone_flag", "user_tag", "rtmp_url", "allow_play", "imsdk_tiny_id", "icon_url", "room_game_type", "advertising_sign", "union_channel_sign", "video_preview"}, new Object[]{"", "", "", "", "", 0, "", "", "", null, null, null, 0, "", 0, null, "", 0, 0L, "", 0, "", "", 0}, NowQQLiveHomepageProto$RcmdAnchor.class);
    public final PBStringField string_name = PBField.initString("");
    public final PBStringField string_id = PBField.initString("");
    public final PBStringField string_head_img_url = PBField.initString("");
    public final PBStringField string_room_img_url = PBField.initString("");
    public final PBStringField string_location = PBField.initString("");
    public final PBUInt32Field uint32_watch_count = PBField.initUInt32(0);
    public final PBStringField string_description = PBField.initString("");
    public final PBStringField string_jump_url = PBField.initString("");
    public final PBStringField string_authentication_tag = PBField.initString("");
    public NowQQLiveHomepageProto$RoomRichTitle rich_title = new NowQQLiveHomepageProto$RoomRichTitle();
    public NowQQLiveHomepageProto$UserExtraInfo extra_info = new NowQQLiveHomepageProto$UserExtraInfo();
    public NowQQLiveHomepageProto$PropInfo propInfo = new MessageMicro<NowQQLiveHomepageProto$PropInfo>() { // from class: com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto$PropInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"prop_type"}, new Object[]{""}, NowQQLiveHomepageProto$PropInfo.class);
        public final PBRepeatField<String> prop_type = PBField.initRepeat(PBStringField.__repeatHelper__);
    };
    public final PBUInt32Field hall_room_id = PBField.initUInt32(0);
    public final PBStringField award_pendant_url = PBField.initString("");
    public final PBUInt32Field microphone_flag = PBField.initUInt32(0);
    public NowQQLiveHomepageProto$UserTag user_tag = new NowQQLiveHomepageProto$UserTag();
    public final PBStringField rtmp_url = PBField.initString("");
    public final PBUInt32Field allow_play = PBField.initUInt32(0);
    public final PBUInt64Field imsdk_tiny_id = PBField.initUInt64(0);
    public final PBStringField icon_url = PBField.initString("");
    public final PBUInt32Field room_game_type = PBField.initUInt32(0);
    public final PBStringField advertising_sign = PBField.initString("");
    public final PBStringField union_channel_sign = PBField.initString("");
    public final PBUInt32Field video_preview = PBField.initUInt32(0);
}
