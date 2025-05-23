package com.qwallet.protocol.Wallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class QWalletHomePrivilege$Privilege extends MessageMicro<QWalletHomePrivilege$Privilege> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"name", "level", "is_open", "icon"}, new Object[]{"", 0, Boolean.FALSE, ""}, QWalletHomePrivilege$Privilege.class);
    public final PBStringField name = PBField.initString("");
    public final PBInt32Field level = PBField.initInt32(0);
    public final PBBoolField is_open = PBField.initBool(false);
    public final PBStringField icon = PBField.initString("");
}
