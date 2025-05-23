package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* loaded from: classes12.dex */
public final class SgamePartnerSvr$SendMsgReq extends MessageMicro<SgamePartnerSvr$SendMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40}, new String[]{"uid", "text", "from_gamemsg_role_id", "to_gamemsg_role_id", QQHealthReportApiImpl.MSG_TYPE_KEY}, new Object[]{"", "", "", "", 0}, SgamePartnerSvr$SendMsgReq.class);
    public final PBStringField uid = PBField.initString("");
    public final PBStringField text = PBField.initString("");
    public final PBStringField from_gamemsg_role_id = PBField.initString("");
    public final PBStringField to_gamemsg_role_id = PBField.initString("");
    public final PBEnumField msg_type = PBField.initEnum(0);
}
