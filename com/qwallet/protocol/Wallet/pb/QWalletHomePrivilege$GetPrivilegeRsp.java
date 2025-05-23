package com.qwallet.protocol.Wallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes3.dex */
public final class QWalletHomePrivilege$GetPrivilegeRsp extends MessageMicro<QWalletHomePrivilege$GetPrivilegeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"privileges"}, new Object[]{null}, QWalletHomePrivilege$GetPrivilegeRsp.class);
    public final PBRepeatMessageField<QWalletHomePrivilege$Privilege> privileges = PBField.initRepeatMessage(QWalletHomePrivilege$Privilege.class);
}
