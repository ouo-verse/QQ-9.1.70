package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class mobileqq_qidian$ReqCorpUinWpaReq extends MessageMicro<mobileqq_qidian$ReqCorpUinWpaReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40}, new String[]{"bytes_sigt", "uint64_qquin", "uint64_touin", "uint32_assign_type", "uint64_assign_id"}, new Object[]{ByteStringMicro.EMPTY, 0L, 0L, 0, 0L}, mobileqq_qidian$ReqCorpUinWpaReq.class);
    public final PBBytesField bytes_sigt = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_qquin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_touin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_assign_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_assign_id = PBField.initUInt64(0);
}
