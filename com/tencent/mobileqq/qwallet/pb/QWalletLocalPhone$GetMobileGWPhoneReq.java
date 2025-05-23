package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qzone.remote.ServiceConst;

/* loaded from: classes16.dex */
public final class QWalletLocalPhone$GetMobileGWPhoneReq extends MessageMicro<QWalletLocalPhone$GetMobileGWPhoneReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"appid", ServiceConst.PARA_SESSION_ID, "phone_token", "sign"}, new Object[]{0L, "", "", ""}, QWalletLocalPhone$GetMobileGWPhoneReq.class);
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBStringField session_id = PBField.initString("");
    public final PBStringField phone_token = PBField.initString("");
    public final PBStringField sign = PBField.initString("");
}
