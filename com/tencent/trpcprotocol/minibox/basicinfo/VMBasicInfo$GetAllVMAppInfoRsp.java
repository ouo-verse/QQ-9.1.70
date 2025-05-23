package com.tencent.trpcprotocol.minibox.basicinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class VMBasicInfo$GetAllVMAppInfoRsp extends MessageMicro<VMBasicInfo$GetAllVMAppInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"info_list", "total"}, new Object[]{null, 0}, VMBasicInfo$GetAllVMAppInfoRsp.class);
    public final PBRepeatMessageField<VMBasicInfo$VMAppInfo> info_list = PBField.initRepeatMessage(VMBasicInfo$VMAppInfo.class);
    public final PBUInt32Field total = PBField.initUInt32(0);
}
