package com.tencent.mobileqq.tablequery;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class ReportData$ReportDataItem extends MessageMicro<ReportData$ReportDataItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 48, 58, 66, 74, 82, 90}, new String[]{"reqReportId", "reportId", "pv", "pv_day_earlier", "pv_month_earlier", "uv", "uv_day_earlier", "uv_month_earlier", "time", "param", "description"}, new Object[]{"", "", 0L, "", "", 0L, "", "", "", "", ""}, ReportData$ReportDataItem.class);
    public final PBStringField reqReportId = PBField.initString("");
    public final PBStringField reportId = PBField.initString("");

    /* renamed from: pv, reason: collision with root package name */
    public final PBUInt64Field f291340pv = PBField.initUInt64(0);
    public final PBStringField pv_day_earlier = PBField.initString("");
    public final PBStringField pv_month_earlier = PBField.initString("");

    /* renamed from: uv, reason: collision with root package name */
    public final PBUInt64Field f291341uv = PBField.initUInt64(0);
    public final PBStringField uv_day_earlier = PBField.initString("");
    public final PBStringField uv_month_earlier = PBField.initString("");
    public final PBStringField time = PBField.initString("");
    public final PBStringField param = PBField.initString("");
    public final PBStringField description = PBField.initString("");
}
