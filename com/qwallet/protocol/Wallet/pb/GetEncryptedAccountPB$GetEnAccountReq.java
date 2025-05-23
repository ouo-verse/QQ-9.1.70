package com.qwallet.protocol.Wallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;

/* loaded from: classes3.dex */
public final class GetEncryptedAccountPB$GetEnAccountReq extends MessageMicro<GetEncryptedAccountPB$GetEnAccountReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"appid", "open_id", QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN, "domain", "bz_info", "sign"}, new Object[]{"", "", "", "", "", ""}, GetEncryptedAccountPB$GetEnAccountReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField open_id = PBField.initString("");
    public final PBStringField access_token = PBField.initString("");
    public final PBStringField domain = PBField.initString("");
    public final PBStringField bz_info = PBField.initString("");
    public final PBStringField sign = PBField.initString("");
}
