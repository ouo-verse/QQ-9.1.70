package com.qwallet.protocol.Wallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class QWalletHomePage$GetPopWindowReq extends MessageMicro<QWalletHomePage$GetPopWindowReq> {
    public static final int HOMEPAGE_RED_DOT = 1;
    public static final int UNKNOWN = 0;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"scene", "biz_request"}, new Object[]{0, ""}, QWalletHomePage$GetPopWindowReq.class);
    public final PBEnumField scene = PBField.initEnum(0);
    public final PBStringField biz_request = PBField.initString("");
}
