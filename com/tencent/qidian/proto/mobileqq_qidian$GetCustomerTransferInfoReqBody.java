package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class mobileqq_qidian$GetCustomerTransferInfoReqBody extends MessageMicro<mobileqq_qidian$GetCustomerTransferInfoReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint64_qq_uin", "uint64_kfext_uin", "uint32_mobile_client", "uint32_ver_no"}, new Object[]{0L, 0L, 0, 0}, mobileqq_qidian$GetCustomerTransferInfoReqBody.class);
    public final PBUInt64Field uint64_qq_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_kfext_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_mobile_client = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ver_no = PBField.initUInt32(0);
}
