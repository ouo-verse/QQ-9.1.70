package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class mobileqq_qidian$GetUserDetailInfoReqBody extends MessageMicro<mobileqq_qidian$GetUserDetailInfoReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_req_type", "uint64_uin", "uint32_mobile_client"}, new Object[]{0, 0L, 0}, mobileqq_qidian$GetUserDetailInfoReqBody.class);
    public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_mobile_client = PBField.initUInt32(0);
}
