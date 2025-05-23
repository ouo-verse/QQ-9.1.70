package com.tencent.trpcprotocol.minibox.basicinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class VMBasicInfo$BatchGetVMAppInfoReq extends MessageMicro<VMBasicInfo$BatchGetVMAppInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"app_ids"}, new Object[]{""}, VMBasicInfo$BatchGetVMAppInfoReq.class);
    public final PBRepeatField<String> app_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
}
