package com.tencent.mobileqq.pb.financial;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class FinancialEntry$DrawerReq extends MessageMicro<FinancialEntry$DrawerReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"child_mode_flag"}, new Object[]{0}, FinancialEntry$DrawerReq.class);
    public final PBInt32Field child_mode_flag = PBField.initInt32(0);
}
