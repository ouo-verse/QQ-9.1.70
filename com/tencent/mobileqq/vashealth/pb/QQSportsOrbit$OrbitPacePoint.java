package com.tencent.mobileqq.vashealth.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes20.dex */
public final class QQSportsOrbit$OrbitPacePoint extends MessageMicro<QQSportsOrbit$OrbitPacePoint> {
    static final MessageMicro.FieldMap __fieldMap__;

    /* renamed from: km, reason: collision with root package name */
    public final PBInt32Field f312321km = PBField.initInt32(0);
    public final PBInt32Field time = PBField.initInt32(0);
    public final PBDoubleField latitude = PBField.initDouble(0.0d);
    public final PBDoubleField longitude = PBField.initDouble(0.0d);

    static {
        Double valueOf = Double.valueOf(0.0d);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 25, 33}, new String[]{"km", "time", "latitude", "longitude"}, new Object[]{0, 0, valueOf, valueOf}, QQSportsOrbit$OrbitPacePoint.class);
    }
}
