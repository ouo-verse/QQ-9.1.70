package com.tencent.mobileqq.qqmatrix.threadleak;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes17.dex */
public final class matrix_thread$ThreadInfo extends MessageMicro<matrix_thread$ThreadInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"tid", "name"}, new Object[]{"", ""}, matrix_thread$ThreadInfo.class);
    public final PBStringField tid = PBField.initString("");
    public final PBStringField name = PBField.initString("");
}
