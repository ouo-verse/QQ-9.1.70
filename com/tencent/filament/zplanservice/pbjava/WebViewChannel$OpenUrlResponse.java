package com.tencent.filament.zplanservice.pbjava;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class WebViewChannel$OpenUrlResponse extends MessageMicro<WebViewChannel$OpenUrlResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"success", "error"}, new Object[]{Boolean.FALSE, null}, WebViewChannel$OpenUrlResponse.class);
    public final PBBoolField success = PBField.initBool(false);
    public ZPlanError error = new ZPlanError();
}
