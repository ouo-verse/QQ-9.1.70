package com.tencent.mobileqq.perf.replay.report;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes16.dex */
public final class ClientPerformanceMetricV2$PerfDataV2 extends MessageMicro<ClientPerformanceMetricV2$PerfDataV2> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 17, 26, 34}, new String[]{"type_id", "value", "detail_data_list", "url_list"}, new Object[]{0L, Double.valueOf(0.0d), null, null}, ClientPerformanceMetricV2$PerfDataV2.class);
    public final PBInt64Field type_id = PBField.initInt64(0);
    public final PBDoubleField value = PBField.initDouble(0.0d);
    public final PBRepeatMessageField<ClientPerformanceMetricV2$DetailValue> detail_data_list = PBField.initRepeatMessage(ClientPerformanceMetricV2$DetailValue.class);
    public final PBRepeatMessageField<ClientPerformanceMetricV2$UrlItem> url_list = PBField.initRepeatMessage(ClientPerformanceMetricV2$UrlItem.class);
}
