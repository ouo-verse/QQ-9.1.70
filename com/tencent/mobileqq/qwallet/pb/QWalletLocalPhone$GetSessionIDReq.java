package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes16.dex */
public final class QWalletLocalPhone$GetSessionIDReq extends MessageMicro<QWalletLocalPhone$GetSessionIDReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"appid"}, new Object[]{0L}, QWalletLocalPhone$GetSessionIDReq.class);
    public final PBUInt64Field appid = PBField.initUInt64(0);
}
