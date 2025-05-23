package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes9.dex */
public final class NowQQLiveHomepageProto$LiveAnchorItem extends MessageMicro<NowQQLiveHomepageProto$LiveAnchorItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56, 66, 74}, new String[]{"string_name", "string_id", "string_head_img_url", "string_room_img_url", "string_location", "string_description", "uint32_watch_count", "string_jump_url", "rich_title"}, new Object[]{"", "", "", "", "", "", 0, "", null}, NowQQLiveHomepageProto$LiveAnchorItem.class);
    public final PBStringField string_name = PBField.initString("");
    public final PBStringField string_id = PBField.initString("");
    public final PBStringField string_head_img_url = PBField.initString("");
    public final PBStringField string_room_img_url = PBField.initString("");
    public final PBStringField string_location = PBField.initString("");
    public final PBStringField string_description = PBField.initString("");
    public final PBUInt32Field uint32_watch_count = PBField.initUInt32(0);
    public final PBStringField string_jump_url = PBField.initString("");
    public NowQQLiveHomepageProto$RoomRichTitle rich_title = new NowQQLiveHomepageProto$RoomRichTitle();
}
