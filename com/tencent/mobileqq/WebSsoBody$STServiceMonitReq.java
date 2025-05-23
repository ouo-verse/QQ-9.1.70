package com.tencent.mobileqq;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class WebSsoBody$STServiceMonitReq extends MessageMicro<WebSsoBody$STServiceMonitReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"list"}, new Object[]{null}, WebSsoBody$STServiceMonitReq.class);
    public final PBRepeatMessageField<WebSsoBody$STServiceMonitItem> list = PBField.initRepeatMessage(WebSsoBody$STServiceMonitItem.class);
}
