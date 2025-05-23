package com.qwallet.protocol.Wallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* loaded from: classes3.dex */
public final class QWalletHomePage$DateRange extends MessageMicro<QWalletHomePage$DateRange> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"begin", "end"}, new Object[]{0L, 0L}, QWalletHomePage$DateRange.class);
    public final PBInt64Field begin = PBField.initInt64(0);
    public final PBInt64Field end = PBField.initInt64(0);
}
