package com.tencent.trpcprotocol.tianxuan.commpay.service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;

/* loaded from: classes27.dex */
public final class QZoneVipPayInfo$UserAccount extends MessageMicro<QZoneVipPayInfo$UserAccount> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50, 58, 66}, new String[]{"uid", MessageRoamJsPlugin.USERTYPE, "appid", "sessionKey", "skey", "ip", "pUid", "pUserType"}, new Object[]{"", 0, "", "", "", "", "", ""}, QZoneVipPayInfo$UserAccount.class);
    public final PBStringField uid = PBField.initString("");
    public final PBEnumField userType = PBField.initEnum(0);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField sessionKey = PBField.initString("");
    public final PBStringField skey = PBField.initString("");

    /* renamed from: ip, reason: collision with root package name */
    public final PBStringField f381669ip = PBField.initString("");
    public final PBStringField pUid = PBField.initString("");
    public final PBStringField pUserType = PBField.initString("");
}
