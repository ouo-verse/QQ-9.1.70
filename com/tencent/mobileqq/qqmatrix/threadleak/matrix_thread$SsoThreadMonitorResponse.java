package com.tencent.mobileqq.qqmatrix.threadleak;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes17.dex */
public final class matrix_thread$SsoThreadMonitorResponse extends MessageMicro<matrix_thread$SsoThreadMonitorResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"code", "msg"}, new Object[]{0, ""}, matrix_thread$SsoThreadMonitorResponse.class);
    public final PBInt32Field code = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f274135msg = PBField.initString("");
}
