package com.tencent.biz.qqstory.network.pb;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class qqstory_lbs$LbsData extends MessageMicro<qqstory_lbs$LbsData> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBDoubleField lat = PBField.initDouble(0.0d);
    public final PBDoubleField lng = PBField.initDouble(0.0d);
    public final PBDoubleField alt = PBField.initDouble(0.0d);
    public final PBFloatField accuracy = PBField.initFloat(0.0f);
    public final PBStringField bussinessTag = PBField.initString("");
    public final PBUInt32Field plat_type = PBField.initUInt32(0);
    public final PBUInt32Field oper_time = PBField.initUInt32(0);
    public final PBStringField nation = PBField.initString("");
    public final PBStringField province = PBField.initString("");
    public final PBStringField city = PBField.initString("");
    public final PBStringField district = PBField.initString("");

    static {
        String[] strArr = {QCircleSchemeAttr.Polymerize.LAT, "lng", QCircleSchemeAttr.Polymerize.ALT, "accuracy", "bussinessTag", "plat_type", "oper_time", "nation", "province", "city", "district"};
        Double valueOf = Double.valueOf(0.0d);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{9, 17, 25, 37, 42, 48, 56, 66, 74, 82, 90}, strArr, new Object[]{valueOf, valueOf, valueOf, Float.valueOf(0.0f), "", 0, 0, "", "", "", ""}, qqstory_lbs$LbsData.class);
    }
}
