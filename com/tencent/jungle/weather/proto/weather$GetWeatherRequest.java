package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class weather$GetWeatherRequest extends MessageMicro<weather$GetWeatherRequest> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field adcode = PBField.initUInt32(0);
    public final PBUInt32Field area_id = PBField.initUInt32(0);
    public final PBStringField city = PBField.initString("");
    public final PBEnumField from = PBField.initEnum(0);
    public final PBRepeatField<Integer> types = PBField.initRepeat(PBEnumField.__repeatHelper__);
    public final PBBoolField allAstro = PBField.initBool(false);
    public final PBBoolField isRealAdcode = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 48, 56}, new String[]{"adcode", "area_id", "city", "from", "types", "allAstro", "isRealAdcode"}, new Object[]{0, 0, "", 0, 1, bool, bool}, weather$GetWeatherRequest.class);
    }
}
