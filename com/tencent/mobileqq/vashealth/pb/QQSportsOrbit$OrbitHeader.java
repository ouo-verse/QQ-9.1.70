package com.tencent.mobileqq.vashealth.pb;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class QQSportsOrbit$OrbitHeader extends MessageMicro<QQSportsOrbit$OrbitHeader> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 45, 50, 56, 64, 72, 80}, new String[]{"type", "startTime", "endTime", "totalTime", Element.ELEMENT_NAME_DISTANCE, "kmRecords", "totalSteps", "platform", "source", "stepType"}, new Object[]{0, 0, 0, 0, Float.valueOf(0.0f), null, 0, 0, 0, 0}, QQSportsOrbit$OrbitHeader.class);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBInt32Field startTime = PBField.initInt32(0);
    public final PBInt32Field endTime = PBField.initInt32(0);
    public final PBInt32Field totalTime = PBField.initInt32(0);
    public final PBFloatField distance = PBField.initFloat(0.0f);
    public final PBRepeatMessageField<QQSportsOrbit$OrbitPacePoint> kmRecords = PBField.initRepeatMessage(QQSportsOrbit$OrbitPacePoint.class);
    public final PBInt32Field totalSteps = PBField.initInt32(0);
    public final PBInt32Field platform = PBField.initInt32(0);
    public final PBInt32Field source = PBField.initInt32(0);
    public final PBInt32Field stepType = PBField.initInt32(0);
}
