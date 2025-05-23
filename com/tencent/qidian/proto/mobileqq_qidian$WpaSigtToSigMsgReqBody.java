package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class mobileqq_qidian$WpaSigtToSigMsgReqBody extends MessageMicro<mobileqq_qidian$WpaSigtToSigMsgReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_sigT_ext", "uint64_kfext_uin"}, new Object[]{ByteStringMicro.EMPTY, 0L}, mobileqq_qidian$WpaSigtToSigMsgReqBody.class);
    public final PBBytesField bytes_sigT_ext = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_kfext_uin = PBField.initUInt64(0);
}
