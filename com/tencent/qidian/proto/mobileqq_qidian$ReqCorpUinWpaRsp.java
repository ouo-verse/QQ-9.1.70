package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class mobileqq_qidian$ReqCorpUinWpaRsp extends MessageMicro<mobileqq_qidian$ReqCorpUinWpaRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"msg_ret", "uint32_aio_type", "bytes_sigmsg"}, new Object[]{null, 0, ByteStringMicro.EMPTY}, mobileqq_qidian$ReqCorpUinWpaRsp.class);
    public mobileqq_qidian$RetInfo msg_ret = new mobileqq_qidian$RetInfo();
    public final PBUInt32Field uint32_aio_type = PBField.initUInt32(0);
    public final PBBytesField bytes_sigmsg = PBField.initBytes(ByteStringMicro.EMPTY);
}
