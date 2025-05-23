package com.tencent.trpcprotocol.qqva;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes27.dex */
public final class midasPayCoinb$Balance extends MessageMicro<midasPayCoinb$Balance> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72}, new String[]{"account_type", "balance", "gen_balance", "first_save", "save_amt", "save_sum", "cost_sum", "present_sum", "marketing_balance"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, 0}, midasPayCoinb$Balance.class);
    public final PBInt32Field account_type = PBField.initInt32(0);
    public final PBInt32Field balance = PBField.initInt32(0);
    public final PBInt32Field gen_balance = PBField.initInt32(0);
    public final PBInt32Field first_save = PBField.initInt32(0);
    public final PBInt32Field save_amt = PBField.initInt32(0);
    public final PBInt32Field save_sum = PBField.initInt32(0);
    public final PBInt32Field cost_sum = PBField.initInt32(0);
    public final PBInt32Field present_sum = PBField.initInt32(0);
    public final PBInt32Field marketing_balance = PBField.initInt32(0);
}
