package com.tencent.mobileqq.pb.qwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes16.dex */
public final class PayAccountPB$GetMyAccountsRsp extends MessageMicro<PayAccountPB$GetMyAccountsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"uins"}, new Object[]{null}, PayAccountPB$GetMyAccountsRsp.class);
    public final PBRepeatMessageField<PayAccountPB$UIN> uins = PBField.initRepeatMessage(PayAccountPB$UIN.class);
}
