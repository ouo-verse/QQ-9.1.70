package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes16.dex */
public final class QWalletAuthorize$RenewPhoneReq extends MessageMicro<QWalletAuthorize$RenewPhoneReq> {
    public static final int GATEWAY_TOKEN = 2;
    public static final int VERIFY_CODE = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 56}, new String[]{"appid", "phone_no", "verify_code", "mobile_gateway_tokens", "msg_no", "qpay_token", "check_type"}, new Object[]{0L, "", "", "", "", "", 1}, QWalletAuthorize$RenewPhoneReq.class);
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBStringField phone_no = PBField.initString("");
    public final PBStringField verify_code = PBField.initString("");
    public final PBStringField mobile_gateway_tokens = PBField.initString("");
    public final PBStringField msg_no = PBField.initString("");
    public final PBStringField qpay_token = PBField.initString("");
    public final PBEnumField check_type = PBField.initEnum(1);
}
