package com.tencent.pb.vasreporter;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class VasClubAmsReport$AdvReportReq extends MessageMicro<VasClubAmsReport$AdvReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{TVKDataBinder.KEY_REPORT_TYPE, "report_url"}, new Object[]{0, ""}, VasClubAmsReport$AdvReportReq.class);
    public final PBInt32Field report_type = PBField.initInt32(0);
    public final PBStringField report_url = PBField.initString("");
}
