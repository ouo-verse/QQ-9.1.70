package com.qwallet.protocol.Wallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class GetEncryptedAccountPB$GetEnAccountRsp extends MessageMicro<GetEncryptedAccountPB$GetEnAccountRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"en_acc_id", "pass_sdk_flag", "sign"}, new Object[]{"", "", ""}, GetEncryptedAccountPB$GetEnAccountRsp.class);
    public final PBStringField en_acc_id = PBField.initString("");
    public final PBStringField pass_sdk_flag = PBField.initString("");
    public final PBStringField sign = PBField.initString("");
}
