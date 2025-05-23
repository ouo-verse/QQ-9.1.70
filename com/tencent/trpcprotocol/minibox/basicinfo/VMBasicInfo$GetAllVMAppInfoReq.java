package com.tencent.trpcprotocol.minibox.basicinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class VMBasicInfo$GetAllVMAppInfoReq extends MessageMicro<VMBasicInfo$GetAllVMAppInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"offset", "size"}, new Object[]{0, 0}, VMBasicInfo$GetAllVMAppInfoReq.class);
    public final PBUInt32Field offset = PBField.initUInt32(0);
    public final PBUInt32Field size = PBField.initUInt32(0);
}
