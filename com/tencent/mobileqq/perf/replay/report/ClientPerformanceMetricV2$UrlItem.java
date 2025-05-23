package com.tencent.mobileqq.perf.replay.report;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class ClientPerformanceMetricV2$UrlItem extends MessageMicro<ClientPerformanceMetricV2$UrlItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"name", "url"}, new Object[]{"", ""}, ClientPerformanceMetricV2$UrlItem.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField url = PBField.initString("");
}
