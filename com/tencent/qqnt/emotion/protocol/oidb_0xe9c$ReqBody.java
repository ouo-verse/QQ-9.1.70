package com.tencent.qqnt.emotion.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class oidb_0xe9c$ReqBody extends MessageMicro<oidb_0xe9c$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 50, 82}, new String[]{"bytes_session_id", "uint64_src_uin", "uint32_src_term", "uint32_aio_type", "uint32_age", "str_client_ver", "relatedFaceReqBody"}, new Object[]{ByteStringMicro.EMPTY, 0L, 0, 0, 0, "", null}, oidb_0xe9c$ReqBody.class);
    public final PBBytesField bytes_session_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
    public final PBUInt32Field uint32_aio_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBStringField str_client_ver = PBField.initString("");
    public oidb_0xe9c$RelatedFaceReq relatedFaceReqBody = new oidb_0xe9c$RelatedFaceReq();
}
