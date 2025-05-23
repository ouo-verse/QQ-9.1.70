package com.tencent.mobileqq.perf.replay.report;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;

/* loaded from: classes16.dex */
public final class ClientPerformanceMetricV2$DetailValue extends MessageMicro<ClientPerformanceMetricV2$DetailValue> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 17}, new String[]{PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "value"}, new Object[]{"", Double.valueOf(0.0d)}, ClientPerformanceMetricV2$DetailValue.class);
    public final PBStringField timeStamp = PBField.initString("");
    public final PBDoubleField value = PBField.initDouble(0.0d);
}
