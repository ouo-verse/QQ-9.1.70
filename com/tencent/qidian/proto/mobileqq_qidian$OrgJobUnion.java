package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class mobileqq_qidian$OrgJobUnion extends MessageMicro<mobileqq_qidian$OrgJobUnion> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_parentorgid", "str_job"}, new Object[]{0L, ""}, mobileqq_qidian$OrgJobUnion.class);
    public final PBUInt64Field uint64_parentorgid = PBField.initUInt64(0);
    public final PBStringField str_job = PBField.initString("");
}
