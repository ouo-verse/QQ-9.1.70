package com.tencent.pb.share;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes22.dex */
public final class ServicePB$OperateShareDataReq extends MessageMicro<ServicePB$OperateShareDataReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"info", "operations"}, new Object[]{null, null}, ServicePB$OperateShareDataReq.class);
    public ServicePB$ShareInfo info = new ServicePB$ShareInfo();
    public final PBRepeatMessageField<ServicePB$Operation> operations = PBField.initRepeatMessage(ServicePB$Operation.class);
}
