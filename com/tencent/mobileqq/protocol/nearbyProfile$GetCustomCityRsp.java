package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes35.dex */
public final class nearbyProfile$GetCustomCityRsp extends MessageMicro<nearbyProfile$GetCustomCityRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48}, new String[]{"ret_code", "ret_msg", "left_cnt", "city_code", "latitude", "longitude"}, new Object[]{0, "", 0, 0, 0L, 0L}, nearbyProfile$GetCustomCityRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField ret_msg = PBField.initString("");
    public final PBUInt32Field left_cnt = PBField.initUInt32(0);
    public final PBUInt32Field city_code = PBField.initUInt32(0);
    public final PBUInt64Field latitude = PBField.initUInt64(0);
    public final PBUInt64Field longitude = PBField.initUInt64(0);
}
