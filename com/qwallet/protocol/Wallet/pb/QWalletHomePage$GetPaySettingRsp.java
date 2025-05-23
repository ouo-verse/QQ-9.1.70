package com.qwallet.protocol.Wallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes3.dex */
public final class QWalletHomePage$GetPaySettingRsp extends MessageMicro<QWalletHomePage$GetPaySettingRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"groups"}, new Object[]{null}, QWalletHomePage$GetPaySettingRsp.class);
    public final PBRepeatMessageField<QWalletHomePage$SettingGroup> groups = PBField.initRepeatMessage(QWalletHomePage$SettingGroup.class);
}
