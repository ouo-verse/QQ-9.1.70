package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class Hongbao$Quota extends MessageMicro<Hongbao$Quota> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"min_price_for_one", "max_price_for_one", "max_amount", "max_total_price"}, new Object[]{0L, 0L, 0L, 0L}, Hongbao$Quota.class);
    public final PBInt64Field min_price_for_one = PBField.initInt64(0);
    public final PBInt64Field max_price_for_one = PBField.initInt64(0);
    public final PBInt64Field max_amount = PBField.initInt64(0);
    public final PBInt64Field max_total_price = PBField.initInt64(0);
}
