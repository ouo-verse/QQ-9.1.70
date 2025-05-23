package com.tencent.trpcprotocol.minibox.basicinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class VMBasicInfo$BatchGetVMAppInfoRsq extends MessageMicro<VMBasicInfo$BatchGetVMAppInfoRsq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"info_list"}, new Object[]{null}, VMBasicInfo$BatchGetVMAppInfoRsq.class);
    public final PBRepeatMessageField<VMBasicInfo$VMAppInfo> info_list = PBField.initRepeatMessage(VMBasicInfo$VMAppInfo.class);
}
