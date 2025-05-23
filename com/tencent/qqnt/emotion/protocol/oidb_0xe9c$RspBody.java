package com.tencent.qqnt.emotion.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class oidb_0xe9c$RspBody extends MessageMicro<oidb_0xe9c$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 82}, new String[]{"bytes_session_id", "int32_ret_code", "str_ret_msg", "relatedFaceRspBody"}, new Object[]{ByteStringMicro.EMPTY, 0, "", null}, oidb_0xe9c$RspBody.class);
    public final PBBytesField bytes_session_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_ret_msg = PBField.initString("");
    public oidb_0xe9c$RelatedFaceRsp relatedFaceRspBody = new oidb_0xe9c$RelatedFaceRsp();
}
