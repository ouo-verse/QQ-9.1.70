package com.tencent.mobileqq.qqmatrix.threadleak;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes17.dex */
public final class matrix_thread$Business extends MessageMicro<matrix_thread$Business> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"app", "token"}, new Object[]{0, ""}, matrix_thread$Business.class);
    public final PBInt32Field app = PBField.initInt32(0);
    public final PBStringField token = PBField.initString("");
}
