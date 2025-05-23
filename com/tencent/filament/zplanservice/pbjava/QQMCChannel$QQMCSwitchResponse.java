package com.tencent.filament.zplanservice.pbjava;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class QQMCChannel$QQMCSwitchResponse extends MessageMicro<QQMCChannel$QQMCSwitchResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"is_on", "error"}, new Object[]{Boolean.FALSE, null}, QQMCChannel$QQMCSwitchResponse.class);
    public final PBBoolField is_on = PBField.initBool(false);
    public ZPlanError error = new ZPlanError();
}
