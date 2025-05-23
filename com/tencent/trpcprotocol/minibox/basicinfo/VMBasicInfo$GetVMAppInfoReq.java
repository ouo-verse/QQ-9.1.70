package com.tencent.trpcprotocol.minibox.basicinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class VMBasicInfo$GetVMAppInfoReq extends MessageMicro<VMBasicInfo$GetVMAppInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"app_id"}, new Object[]{""}, VMBasicInfo$GetVMAppInfoReq.class);
    public final PBStringField app_id = PBField.initString("");
}
