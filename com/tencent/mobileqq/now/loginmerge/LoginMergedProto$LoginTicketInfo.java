package com.tencent.mobileqq.now.loginmerge;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes9.dex */
public final class LoginMergedProto$LoginTicketInfo extends MessageMicro<LoginMergedProto$LoginTicketInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50}, new String[]{"client_version", MsfConstants.ATTRIBUTE_LOGIN_TYPE, AudienceReportConst.CLIENT_TYPE, ReportDataBuilder.KEY_ACCOUNT_ID, "ticket_info", "auth_appid"}, new Object[]{0, 0, 0, "", null, ""}, LoginMergedProto$LoginTicketInfo.class);
    public final PBUInt32Field client_version = PBField.initUInt32(0);
    public final PBUInt32Field login_type = PBField.initUInt32(0);
    public final PBUInt32Field client_type = PBField.initUInt32(0);
    public final PBStringField account_id = PBField.initString("");
    public LoginMergedProto$TicketInfo ticket_info = new LoginMergedProto$TicketInfo();
    public final PBStringField auth_appid = PBField.initString("");
}
