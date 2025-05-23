package com.tencent.trpcprotocol.minibox.basicinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class VMBasicInfo$GetVMAppJudgmentsRsp extends MessageMicro<VMBasicInfo$GetVMAppJudgmentsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"judgments", "total"}, new Object[]{null, 0L}, VMBasicInfo$GetVMAppJudgmentsRsp.class);
    public final PBRepeatMessageField<VMBasicInfo$VMAppJudgment> judgments = PBField.initRepeatMessage(VMBasicInfo$VMAppJudgment.class);
    public final PBInt64Field total = PBField.initInt64(0);
}
