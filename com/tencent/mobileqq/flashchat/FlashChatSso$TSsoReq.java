package com.tencent.mobileqq.flashchat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class FlashChatSso$TSsoReq extends MessageMicro<FlashChatSso$TSsoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"i32_cmd", "i32_implat", "str_qq_ver"}, new Object[]{0, 0, ""}, FlashChatSso$TSsoReq.class);
    public final PBInt32Field i32_cmd = PBField.initInt32(0);
    public final PBInt32Field i32_implat = PBField.initInt32(0);
    public final PBStringField str_qq_ver = PBField.initString("");
}
