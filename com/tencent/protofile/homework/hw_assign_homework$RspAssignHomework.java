package com.tencent.protofile.homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class hw_assign_homework$RspAssignHomework extends MessageMicro<hw_assign_homework$RspAssignHomework> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"errinfo", "hw_id"}, new Object[]{null, 0L}, hw_assign_homework$RspAssignHomework.class);
    public hw_assign_homework$ErrorInfo errinfo = new hw_assign_homework$ErrorInfo();
    public final PBUInt64Field hw_id = PBField.initUInt64(0);
}
