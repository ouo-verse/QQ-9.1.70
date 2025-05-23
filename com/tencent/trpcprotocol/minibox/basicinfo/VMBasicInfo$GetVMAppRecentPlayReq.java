package com.tencent.trpcprotocol.minibox.basicinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes27.dex */
public final class VMBasicInfo$GetVMAppRecentPlayReq extends MessageMicro<VMBasicInfo$GetVMAppRecentPlayReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"number"}, new Object[]{0}, VMBasicInfo$GetVMAppRecentPlayReq.class);
    public final PBUInt32Field number = PBField.initUInt32(0);
}
