package com.tencent.mobileqq.flashchat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class FlashChatSso$TSsoRsp extends MessageMicro<FlashChatSso$TSsoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"i32_ret", "str_msg", "st_cmd0x1_rsp"}, new Object[]{0, "", null}, FlashChatSso$TSsoRsp.class);
    public final PBInt32Field i32_ret = PBField.initInt32(0);
    public final PBStringField str_msg = PBField.initString("");
    public FlashChatSso$TSsoCmd0x1Rsp st_cmd0x1_rsp = new FlashChatSso$TSsoCmd0x1Rsp();
}
