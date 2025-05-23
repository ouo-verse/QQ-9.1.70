package com.tencent.mobileqq.qqmatrix.threadleak;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes17.dex */
public final class matrix_thread$SsoThreadMonitorRequest extends MessageMicro<matrix_thread$SsoThreadMonitorRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 56, 66, 74}, new String[]{"business", "uin", "version", "brand", "model", "timestamp_millisecond", "total_thread_num", "top_threads", "leak_threads"}, new Object[]{null, "", "", "", "", 0L, 0, null, null}, matrix_thread$SsoThreadMonitorRequest.class);
    public matrix_thread$Business business = new matrix_thread$Business();
    public final PBStringField uin = PBField.initString("");
    public final PBStringField version = PBField.initString("");
    public final PBStringField brand = PBField.initString("");
    public final PBStringField model = PBField.initString("");
    public final PBInt64Field timestamp_millisecond = PBField.initInt64(0);
    public final PBInt32Field total_thread_num = PBField.initInt32(0);
    public final PBRepeatMessageField<matrix_thread$ThreadStackInfo> top_threads = PBField.initRepeatMessage(matrix_thread$ThreadStackInfo.class);
    public final PBRepeatMessageField<matrix_thread$ThreadStackInfo> leak_threads = PBField.initRepeatMessage(matrix_thread$ThreadStackInfo.class);
}
