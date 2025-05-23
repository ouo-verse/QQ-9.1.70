package com.tencent.mobileqq.now.loginmerge;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes9.dex */
public final class LoginMergedProto$LoginRsp extends MessageMicro<LoginMergedProto$LoginRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"result", "errMsg", "account_base_info", "tickets"}, new Object[]{0, "", null, null}, LoginMergedProto$LoginRsp.class);
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBStringField errMsg = PBField.initString("");
    public LoginMergedProto$AccountBaseInfo account_base_info = new LoginMergedProto$AccountBaseInfo();
    public LoginMergedProto$TicketInfo tickets = new LoginMergedProto$TicketInfo();
}
