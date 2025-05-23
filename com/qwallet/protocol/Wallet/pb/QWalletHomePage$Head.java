package com.qwallet.protocol.Wallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class QWalletHomePage$Head extends MessageMicro<QWalletHomePage$Head> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField qyy_switch = PBField.initBool(false);
    public final PBBoolField is_youth_mode = PBField.initBool(false);
    public final PBStringField phone_model = PBField.initString("");
    public final PBInt32Field memory_size = PBField.initInt32(0);
    public final PBStringField cpu_type = PBField.initString("");
    public final PBInt32Field cpu_max_freq = PBField.initInt32(0);
    public final PBInt32Field cpu_core_num = PBField.initInt32(0);
    public final PBRepeatMessageField<QWalletHomePage$ABTest> abtest = PBField.initRepeatMessage(QWalletHomePage$ABTest.class);
    public final PBBoolField care_model = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 48, 56, 66, 72}, new String[]{"qyy_switch", "is_youth_mode", "phone_model", "memory_size", "cpu_type", "cpu_max_freq", "cpu_core_num", "abtest", "care_model"}, new Object[]{bool, bool, "", 0, "", 0, 0, null, bool}, QWalletHomePage$Head.class);
    }
}
