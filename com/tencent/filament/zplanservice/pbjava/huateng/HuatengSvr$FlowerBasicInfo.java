package com.tencent.filament.zplanservice.pbjava.huateng;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.QCircleWeakNetReporter;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class HuatengSvr$FlowerBasicInfo extends MessageMicro<HuatengSvr$FlowerBasicInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"id", "name", "coin_type", QCircleWeakNetReporter.KEY_COST}, new Object[]{0, "", 0, 0}, HuatengSvr$FlowerBasicInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f106421id = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBEnumField coin_type = PBField.initEnum(0);
    public final PBUInt32Field cost = PBField.initUInt32(0);
}
