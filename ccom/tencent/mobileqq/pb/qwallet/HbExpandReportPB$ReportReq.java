package ccom.tencent.mobileqq.pb.qwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;

/* loaded from: classes.dex */
public final class HbExpandReportPB$ReportReq extends MessageMicro<HbExpandReportPB$ReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{TVKDataBinder.KEY_REPORT_TYPE, QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO, "token"}, new Object[]{0, "", ""}, HbExpandReportPB$ReportReq.class);
    public final PBEnumField report_type = PBField.initEnum(0);
    public final PBStringField report_info = PBField.initString("");
    public final PBStringField token = PBField.initString("");
}
