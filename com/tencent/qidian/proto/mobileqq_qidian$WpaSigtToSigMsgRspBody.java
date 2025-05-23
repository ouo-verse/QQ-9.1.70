package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class mobileqq_qidian$WpaSigtToSigMsgRspBody extends MessageMicro<mobileqq_qidian$WpaSigtToSigMsgRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"int32_result", "bytes_sigmsg_ext", "uint64_kfext_uin", "str_err_msg"}, new Object[]{0, ByteStringMicro.EMPTY, 0L, ""}, mobileqq_qidian$WpaSigtToSigMsgRspBody.class);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBBytesField bytes_sigmsg_ext = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_kfext_uin = PBField.initUInt64(0);
    public final PBStringField str_err_msg = PBField.initString("");
}
