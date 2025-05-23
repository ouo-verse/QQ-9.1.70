package com.tencent.mobileqq.flashchat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class FlashChatSso$TItem extends MessageMicro<FlashChatSso$TItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 66}, new String[]{"i32_id", "uint32_feetype", "string_name", "string_icon_url", "string_app_name", "string_main_view", "string_ver", "string_bg_color"}, new Object[]{0, 0, "", "", "", "", "", ""}, FlashChatSso$TItem.class);
    public final PBInt32Field i32_id = PBField.initInt32(0);
    public final PBUInt32Field uint32_feetype = PBField.initUInt32(0);
    public final PBStringField string_name = PBField.initString("");
    public final PBStringField string_icon_url = PBField.initString("");
    public final PBStringField string_app_name = PBField.initString("");
    public final PBStringField string_main_view = PBField.initString("");
    public final PBStringField string_ver = PBField.initString("");
    public final PBStringField string_bg_color = PBField.initString("");
}
