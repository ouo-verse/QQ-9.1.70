package com.tencent.mobileqq.vashealth.pb;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class QQSportsOrbit$OrbitReq extends MessageMicro<QQSportsOrbit$OrbitReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"reqHeader", "tracePath", "isOver", WidgetCacheConstellationData.NUM}, new Object[]{null, null, 0, 0}, QQSportsOrbit$OrbitReq.class);
    public QQSportsOrbit$OrbitHeader reqHeader = new QQSportsOrbit$OrbitHeader();
    public final PBRepeatMessageField<QQSportsOrbit$OrbitPoint> tracePath = PBField.initRepeatMessage(QQSportsOrbit$OrbitPoint.class);
    public final PBInt32Field isOver = PBField.initInt32(0);
    public final PBInt32Field num = PBField.initInt32(0);
}
