package com.tencent.mobileqq.qwallet.pb;

import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class QWalletAuthorize$GetMobileGatewayURLRsp extends MessageMicro<QWalletAuthorize$GetMobileGatewayURLRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{CoverDBCacheData.URLS, "msg_no"}, new Object[]{null, ""}, QWalletAuthorize$GetMobileGatewayURLRsp.class);
    public final PBRepeatMessageField<QWalletAuthorize$UrlData> urls = PBField.initRepeatMessage(QWalletAuthorize$UrlData.class);
    public final PBStringField msg_no = PBField.initString("");
}
