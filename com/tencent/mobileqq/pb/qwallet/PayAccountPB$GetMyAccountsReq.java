package com.tencent.mobileqq.pb.qwallet;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class PayAccountPB$GetMyAccountsReq extends MessageMicro<PayAccountPB$GetMyAccountsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 58, 66}, new String[]{"token_id", CGNonAgeReport.EVENT_CHANNEL, "cre_id", "name", "cre_type", "pwd_token", WadlProxyConsts.CHANNEL, "regbind_param"}, new Object[]{"", "", "", "", 0, "", "", ""}, PayAccountPB$GetMyAccountsReq.class);
    public final PBStringField token_id = PBField.initString("");
    public final PBStringField channel_info = PBField.initString("");
    public final PBStringField cre_id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBEnumField cre_type = PBField.initEnum(0);
    public final PBStringField pwd_token = PBField.initString("");
    public final PBStringField channel = PBField.initString("");
    public final PBStringField regbind_param = PBField.initString("");
}
