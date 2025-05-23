package com.qwallet.protocol.Wallet.pb.pet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class PetCommon$DeviceInfo extends MessageMicro<PetCommon$DeviceInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40}, new String[]{"phone_model", "memory_size", "cpu_type", "cpu_max_freq", "cpu_core_num"}, new Object[]{"", 0, "", 0, 0}, PetCommon$DeviceInfo.class);
    public final PBStringField phone_model = PBField.initString("");
    public final PBInt32Field memory_size = PBField.initInt32(0);
    public final PBStringField cpu_type = PBField.initString("");
    public final PBInt32Field cpu_max_freq = PBField.initInt32(0);
    public final PBInt32Field cpu_core_num = PBField.initInt32(0);
}
