package com.tencent.filament.zplanservice.pbjava.huateng;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class HuatengSvr$FlowerUserInfo extends MessageMicro<HuatengSvr$FlowerUserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50}, new String[]{"level", "status", "current_exp", "levelup_exp", "level_icon", "props"}, new Object[]{0, 0, 0, 0, "", null}, HuatengSvr$FlowerUserInfo.class);
    public final PBUInt32Field level = PBField.initUInt32(0);
    public final PBEnumField status = PBField.initEnum(0);
    public final PBUInt32Field current_exp = PBField.initUInt32(0);
    public final PBUInt32Field levelup_exp = PBField.initUInt32(0);
    public final PBStringField level_icon = PBField.initString("");
    public final PBRepeatMessageField<HuatengSvr$FlowerProp> props = PBField.initRepeatMessage(HuatengSvr$FlowerProp.class);
}
