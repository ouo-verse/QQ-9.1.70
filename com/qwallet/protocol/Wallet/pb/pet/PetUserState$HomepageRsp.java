package com.qwallet.protocol.Wallet.pb.pet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes3.dex */
public final class PetUserState$HomepageRsp extends MessageMicro<PetUserState$HomepageRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50, 56, 64, 74, 80, 88, 96, 104, 112, 120, 130}, new String[]{"user_type", "pet_type", "pet_name", "adopt_time", "level", "dress", "foods", "exp", "profit_date", "trial_fund", "total_trial_profit", "ytd_trial_profit", "fund", "profit", "ytd_profit", "device_support"}, new Object[]{0, "", "", "", 0L, null, 0L, 0L, "", 0L, 0L, 0L, 0L, 0L, 0L, null}, PetUserState$HomepageRsp.class);
    public final PBEnumField user_type = PBField.initEnum(0);
    public final PBStringField pet_type = PBField.initString("");
    public final PBStringField pet_name = PBField.initString("");
    public final PBStringField adopt_time = PBField.initString("");
    public final PBInt64Field level = PBField.initInt64(0);
    public PetCommon$Dress dress = new PetCommon$Dress();
    public final PBUInt64Field foods = PBField.initUInt64(0);
    public final PBUInt64Field exp = PBField.initUInt64(0);
    public final PBStringField profit_date = PBField.initString("");
    public final PBUInt64Field trial_fund = PBField.initUInt64(0);
    public final PBUInt64Field total_trial_profit = PBField.initUInt64(0);
    public final PBUInt64Field ytd_trial_profit = PBField.initUInt64(0);
    public final PBUInt64Field fund = PBField.initUInt64(0);
    public final PBUInt64Field profit = PBField.initUInt64(0);
    public final PBUInt64Field ytd_profit = PBField.initUInt64(0);
    public PetCommon$DeviceSupport device_support = new PetCommon$DeviceSupport();
}
