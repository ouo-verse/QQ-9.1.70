package com.tencent.mobileqq.pb.qwallet;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class PayAccountPB$CancelAccountByFaceReq extends MessageMicro<PayAccountPB$CancelAccountByFaceReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"token_id", CGNonAgeReport.EVENT_CHANNEL, "uin", WadlProxyConsts.CHANNEL}, new Object[]{"", "", null, ""}, PayAccountPB$CancelAccountByFaceReq.class);
    public final PBStringField token_id = PBField.initString("");
    public final PBStringField channel_info = PBField.initString("");
    public PayAccountPB$UIN uin = new PayAccountPB$UIN();
    public final PBStringField channel = PBField.initString("");
}
