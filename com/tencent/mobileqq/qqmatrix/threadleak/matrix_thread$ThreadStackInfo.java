package com.tencent.mobileqq.qqmatrix.threadleak;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes17.dex */
public final class matrix_thread$ThreadStackInfo extends MessageMicro<matrix_thread$ThreadStackInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42}, new String[]{"native_stack", "java_stack", "count", "threads", "hash"}, new Object[]{"", "", 0, null, ""}, matrix_thread$ThreadStackInfo.class);
    public final PBStringField native_stack = PBField.initString("");
    public final PBStringField java_stack = PBField.initString("");
    public final PBInt32Field count = PBField.initInt32(0);
    public final PBRepeatMessageField<matrix_thread$ThreadInfo> threads = PBField.initRepeatMessage(matrix_thread$ThreadInfo.class);
    public final PBStringField hash = PBField.initString("");
}
