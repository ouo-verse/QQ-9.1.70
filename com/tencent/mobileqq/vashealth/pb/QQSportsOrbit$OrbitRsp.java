package com.tencent.mobileqq.vashealth.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class QQSportsOrbit$OrbitRsp extends MessageMicro<QQSportsOrbit$OrbitRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"retCode", "lastNum", "isOver", "rspHeader"}, new Object[]{0, 0, 0, null}, QQSportsOrbit$OrbitRsp.class);
    public final PBInt32Field retCode = PBField.initInt32(0);
    public final PBInt32Field lastNum = PBField.initInt32(0);
    public final PBInt32Field isOver = PBField.initInt32(0);
    public QQSportsOrbit$OrbitHeader rspHeader = new QQSportsOrbit$OrbitHeader();
}
