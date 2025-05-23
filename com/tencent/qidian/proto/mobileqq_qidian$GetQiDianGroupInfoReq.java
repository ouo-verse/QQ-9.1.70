package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class mobileqq_qidian$GetQiDianGroupInfoReq extends MessageMicro<mobileqq_qidian$GetQiDianGroupInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_groupcode", "uint64_groupowner"}, new Object[]{0, 0L}, mobileqq_qidian$GetQiDianGroupInfoReq.class);
    public final PBUInt32Field uint32_groupcode = PBField.initUInt32(0);
    public final PBUInt64Field uint64_groupowner = PBField.initUInt64(0);
}
