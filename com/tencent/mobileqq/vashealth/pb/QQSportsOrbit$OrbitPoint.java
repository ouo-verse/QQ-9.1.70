package com.tencent.mobileqq.vashealth.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes20.dex */
public final class QQSportsOrbit$OrbitPoint extends MessageMicro<QQSportsOrbit$OrbitPoint> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBDoubleField speed = PBField.initDouble(0.0d);
    public final PBDoubleField latitude = PBField.initDouble(0.0d);
    public final PBDoubleField longitude = PBField.initDouble(0.0d);
    public final PBInt32Field time = PBField.initInt32(0);
    public final PBFloatField latitudef = PBField.initFloat(0.0f);
    public final PBFloatField longitudef = PBField.initFloat(0.0f);
    public final PBFixed32Field timef = PBField.initFixed32(0);
    public final PBFloatField speedf = PBField.initFloat(0.0f);
    public final PBInt32Field accuracy = PBField.initInt32(0);
    public final PBInt32Field step = PBField.initInt32(0);
    public final PBFloatField altitude = PBField.initFloat(0.0f);
    public final PBInt32Field millisecond = PBField.initInt32(0);

    static {
        Double valueOf = Double.valueOf(0.0d);
        Float valueOf2 = Float.valueOf(0.0f);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{9, 17, 25, 32, 45, 53, 61, 69, 72, 80, 93, 96}, new String[]{"speed", "latitude", "longitude", "time", "latitudef", "longitudef", "timef", "speedf", "accuracy", "step", "altitude", "millisecond"}, new Object[]{valueOf, valueOf, valueOf, 0, valueOf2, valueOf2, 0, valueOf2, 0, 0, valueOf2, 0}, QQSportsOrbit$OrbitPoint.class);
    }
}
