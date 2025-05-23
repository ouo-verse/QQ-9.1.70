package com.tencent.mobileqq;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class WebSsoBody$WebSsoControlData extends MessageMicro<WebSsoBody$WebSsoControlData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"frequency", "packageSize"}, new Object[]{0, 0}, WebSsoBody$WebSsoControlData.class);
    public final PBUInt32Field frequency = PBField.initUInt32(0);
    public final PBUInt32Field packageSize = PBField.initUInt32(0);
}
