package com.qwallet.protocol.Wallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class QWalletHomePage$AppGroup extends MessageMicro<QWalletHomePage$AppGroup> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"title", "apps"}, new Object[]{"", null}, QWalletHomePage$AppGroup.class);
    public final PBStringField title = PBField.initString("");
    public final PBRepeatMessageField<QWalletHomePage$AppInfo> apps = PBField.initRepeatMessage(QWalletHomePage$AppInfo.class);
}
