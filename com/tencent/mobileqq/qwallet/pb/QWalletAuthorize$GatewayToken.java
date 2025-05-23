package com.tencent.mobileqq.qwallet.pb;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class QWalletAuthorize$GatewayToken extends MessageMicro<QWalletAuthorize$GatewayToken> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{WadlProxyConsts.CHANNEL, "data"}, new Object[]{0, ""}, QWalletAuthorize$GatewayToken.class);
    public final PBInt32Field channel = PBField.initInt32(0);
    public final PBStringField data = PBField.initString("");
}
