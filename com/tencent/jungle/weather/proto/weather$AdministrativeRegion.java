package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class weather$AdministrativeRegion extends MessageMicro<weather$AdministrativeRegion> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"adcode", "province", "city", "district"}, new Object[]{0, "", "", ""}, weather$AdministrativeRegion.class);
    public final PBUInt32Field adcode = PBField.initUInt32(0);
    public final PBStringField province = PBField.initString("");
    public final PBStringField city = PBField.initString("");
    public final PBStringField district = PBField.initString("");
}
