package com.tencent.filament.zplanservice.pbjava.huateng;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes6.dex */
public final class HuatengSvr$FlowerProp extends MessageMicro<HuatengSvr$FlowerProp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48, 58}, new String[]{"id", "name", "op", "icon_url", "remain_times", "ad_extra_flag", "ad_id"}, new Object[]{0, "", 0, "", 0, Boolean.FALSE, ""}, HuatengSvr$FlowerProp.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f106422id = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");

    /* renamed from: op, reason: collision with root package name */
    public final PBEnumField f106423op = PBField.initEnum(0);
    public final PBStringField icon_url = PBField.initString("");
    public final PBUInt32Field remain_times = PBField.initUInt32(0);
    public final PBBoolField ad_extra_flag = PBField.initBool(false);
    public final PBStringField ad_id = PBField.initString("");
}
