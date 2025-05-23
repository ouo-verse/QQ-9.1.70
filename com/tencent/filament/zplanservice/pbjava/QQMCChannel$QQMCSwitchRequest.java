package com.tencent.filament.zplanservice.pbjava;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class QQMCChannel$QQMCSwitchRequest extends MessageMicro<QQMCChannel$QQMCSwitchRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"key", "default_value"}, new Object[]{"", Boolean.FALSE}, QQMCChannel$QQMCSwitchRequest.class);
    public final PBStringField key = PBField.initString("");
    public final PBBoolField default_value = PBField.initBool(false);
}
