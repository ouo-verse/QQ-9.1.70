package com.tencent.mobileqq;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class WebSsoBody$WebSsoResponseBody extends MessageMicro<WebSsoBody$WebSsoResponseBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, new String[]{"version", "type", "ret", "data", "controlData"}, new Object[]{0, 0, 0, "", null}, WebSsoBody$WebSsoResponseBody.class);
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field ret = PBField.initUInt32(0);
    public final PBStringField data = PBField.initString("");
    public WebSsoBody$WebSsoControlData controlData = new WebSsoBody$WebSsoControlData();
}
