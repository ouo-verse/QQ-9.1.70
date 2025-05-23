package com.tencent.mobileqq.qwallet.pb;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class QWalletAuthorize$UrlData extends MessageMicro<QWalletAuthorize$UrlData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 26}, new String[]{WadlProxyConsts.CHANNEL, "url"}, new Object[]{0, ""}, QWalletAuthorize$UrlData.class);
    public final PBInt32Field channel = PBField.initInt32(0);
    public final PBStringField url = PBField.initString("");
}
