package com.tencent.filament.zplanservice.pbjava;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class QQReport$QQReportRequest extends MessageMicro<QQReport$QQReportRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48}, new String[]{"page_id", "element_id", "event", "params", "page_params", TVKDataBinder.KEY_REPORT_TYPE}, new Object[]{"", "", "", "", "", 0}, QQReport$QQReportRequest.class);
    public final PBStringField page_id = PBField.initString("");
    public final PBStringField element_id = PBField.initString("");
    public final PBStringField event = PBField.initString("");
    public final PBStringField params = PBField.initString("");
    public final PBStringField page_params = PBField.initString("");
    public final PBEnumField report_type = PBField.initEnum(0);
}
