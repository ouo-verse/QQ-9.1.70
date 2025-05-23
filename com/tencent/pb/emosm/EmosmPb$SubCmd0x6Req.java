package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class EmosmPb$SubCmd0x6Req extends MessageMicro<EmosmPb$SubCmd0x6Req> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"u32_tab_id", "str_item_id"}, new Object[]{0, ""}, EmosmPb$SubCmd0x6Req.class);
    public final PBUInt32Field u32_tab_id = PBField.initUInt32(0);
    public final PBStringField str_item_id = PBField.initString("");
}
