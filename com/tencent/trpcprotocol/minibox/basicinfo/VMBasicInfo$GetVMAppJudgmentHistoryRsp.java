package com.tencent.trpcprotocol.minibox.basicinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class VMBasicInfo$GetVMAppJudgmentHistoryRsp extends MessageMicro<VMBasicInfo$GetVMAppJudgmentHistoryRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"records", "total"}, new Object[]{null, 0L}, VMBasicInfo$GetVMAppJudgmentHistoryRsp.class);
    public final PBRepeatMessageField<VMBasicInfo$VMAppJudgmentRecord> records = PBField.initRepeatMessage(VMBasicInfo$VMAppJudgmentRecord.class);
    public final PBInt64Field total = PBField.initInt64(0);
}
