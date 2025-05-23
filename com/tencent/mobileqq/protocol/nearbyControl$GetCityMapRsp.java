package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class nearbyControl$GetCityMapRsp extends MessageMicro<nearbyControl$GetCityMapRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"ret_code", "ret_msg", "content", "md5", "url"}, new Object[]{0, "", "", "", ""}, nearbyControl$GetCityMapRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField ret_msg = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBStringField md5 = PBField.initString("");
    public final PBStringField url = PBField.initString("");
}
