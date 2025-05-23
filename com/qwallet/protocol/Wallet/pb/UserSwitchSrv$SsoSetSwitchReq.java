package com.qwallet.protocol.Wallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class UserSwitchSrv$SsoSetSwitchReq extends MessageMicro<UserSwitchSrv$SsoSetSwitchReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"items"}, new Object[]{null}, UserSwitchSrv$SsoSetSwitchReq.class);
    public final PBRepeatMessageField<UserSwitchSrv$OpItem> items = PBField.initRepeatMessage(UserSwitchSrv$OpItem.class);
}
