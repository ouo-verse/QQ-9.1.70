package com.tencent.protofile.homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class hw_submit_homework$RspSubmitHomework extends MessageMicro<hw_submit_homework$RspSubmitHomework> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"errinfo", "status"}, new Object[]{null, 0}, hw_submit_homework$RspSubmitHomework.class);
    public hw_submit_homework$ErrorInfo errinfo = new hw_submit_homework$ErrorInfo();
    public final PBInt32Field status = PBField.initInt32(0);
}
