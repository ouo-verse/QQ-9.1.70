package com.qwallet.protocol.Wallet.pb.pet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes3.dex */
public final class PetUserState$HomepageReq extends MessageMicro<PetUserState$HomepageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"device_info", "qry_flag"}, new Object[]{null, 0}, PetUserState$HomepageReq.class);
    public PetCommon$DeviceInfo device_info = new PetCommon$DeviceInfo();
    public final PBEnumField qry_flag = PBField.initEnum(0);
}
