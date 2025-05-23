package com.qwallet.protocol.Wallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes3.dex */
public final class QWalletHomePage$GetHomepageV2Req extends MessageMicro<QWalletHomePage$GetHomepageV2Req> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"head", "support_app_list"}, new Object[]{null, Boolean.FALSE}, QWalletHomePage$GetHomepageV2Req.class);
    public QWalletHomePage$Head head = new QWalletHomePage$Head();
    public final PBBoolField support_app_list = PBField.initBool(false);
}
