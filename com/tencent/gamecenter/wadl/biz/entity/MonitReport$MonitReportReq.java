package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class MonitReport$MonitReportReq extends MessageMicro<MonitReport$MonitReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 26}, new String[]{"type", "publicAcctReq"}, new Object[]{0, null}, MonitReport$MonitReportReq.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBRepeatMessageField<MonitReport$PublicAccountReq> publicAcctReq = PBField.initRepeatMessage(MonitReport$PublicAccountReq.class);
}
