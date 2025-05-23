package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes35.dex */
public final class nearbyProfile$SetCustomCityReq extends MessageMicro<nearbyProfile$SetCustomCityReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"city_code"}, new Object[]{0}, nearbyProfile$SetCustomCityReq.class);
    public final PBUInt32Field city_code = PBField.initUInt32(0);
}
