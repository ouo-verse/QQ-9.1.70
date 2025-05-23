package com.tencent.mobileqq.qqecommerce.repo.pbfile;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class sellerMsgReader$GetMsgListRsp extends MessageMicro<sellerMsgReader$GetMsgListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"msg_details", "is_end", "cookie"}, new Object[]{null, 0, ByteStringMicro.EMPTY}, sellerMsgReader$GetMsgListRsp.class);
    public final PBRepeatMessageField<msgDetail$MsgDetail> msg_details = PBField.initRepeatMessage(msgDetail$MsgDetail.class);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
}
