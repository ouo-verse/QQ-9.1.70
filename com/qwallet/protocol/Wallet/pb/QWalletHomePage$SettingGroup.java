package com.qwallet.protocol.Wallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class QWalletHomePage$SettingGroup extends MessageMicro<QWalletHomePage$SettingGroup> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"id", "name", "items"}, new Object[]{0, "", null}, QWalletHomePage$SettingGroup.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBInt32Field f41697id = PBField.initInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBRepeatMessageField<QWalletHomePage$SettingItem> items = PBField.initRepeatMessage(QWalletHomePage$SettingItem.class);
}
