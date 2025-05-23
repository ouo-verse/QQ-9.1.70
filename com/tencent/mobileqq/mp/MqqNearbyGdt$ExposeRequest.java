package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class MqqNearbyGdt$ExposeRequest extends MessageMicro<MqqNearbyGdt$ExposeRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40}, new String[]{"resolution", "apurl", "qua", "platform_type", "ad_source"}, new Object[]{"", "", "", 0, 0}, MqqNearbyGdt$ExposeRequest.class);
    public final PBStringField resolution = PBField.initString("");
    public final PBStringField apurl = PBField.initString("");
    public final PBStringField qua = PBField.initString("");
    public final PBInt32Field platform_type = PBField.initInt32(0);
    public final PBInt32Field ad_source = PBField.initInt32(0);
}
