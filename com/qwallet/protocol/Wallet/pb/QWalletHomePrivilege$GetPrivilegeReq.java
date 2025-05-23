package com.qwallet.protocol.Wallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class QWalletHomePrivilege$GetPrivilegeReq extends MessageMicro<QWalletHomePrivilege$GetPrivilegeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"src"}, new Object[]{""}, QWalletHomePrivilege$GetPrivilegeReq.class);
    public final PBStringField src = PBField.initString("");
}
