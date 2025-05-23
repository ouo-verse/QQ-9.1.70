package com.tencent.filament.zplanservice.pbjava;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class WebViewChannel$OpenUrlRequest extends MessageMicro<WebViewChannel$OpenUrlRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"url"}, new Object[]{""}, WebViewChannel$OpenUrlRequest.class);
    public final PBStringField url = PBField.initString("");
}
