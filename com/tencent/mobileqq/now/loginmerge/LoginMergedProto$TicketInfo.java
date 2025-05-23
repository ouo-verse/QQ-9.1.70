package com.tencent.mobileqq.now.loginmerge;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;

/* loaded from: classes9.dex */
public final class LoginMergedProto$TicketInfo extends MessageMicro<LoginMergedProto$TicketInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"auth_key", QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN, "st", "stkey", "skey", "stweb"}, new Object[]{"", "", "", "", "", ""}, LoginMergedProto$TicketInfo.class);
    public final PBStringField auth_key = PBField.initString("");
    public final PBStringField access_token = PBField.initString("");

    /* renamed from: st, reason: collision with root package name */
    public final PBStringField f254342st = PBField.initString("");
    public final PBStringField stkey = PBField.initString("");
    public final PBStringField skey = PBField.initString("");
    public final PBStringField stweb = PBField.initString("");
}
