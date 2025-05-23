package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.remote.ServiceConst;

/* loaded from: classes16.dex */
public final class QWalletLocalPhone$GetMobileGWPhoneRsp extends MessageMicro<QWalletLocalPhone$GetMobileGWPhoneRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50}, new String[]{ServiceConst.PARA_SESSION_ID, "phone_token", "mask_phone", "plain_phone", "carrier_type", "ext_info"}, new Object[]{"", "", null, null, 0, ""}, QWalletLocalPhone$GetMobileGWPhoneRsp.class);
    public final PBStringField session_id = PBField.initString("");
    public final PBStringField phone_token = PBField.initString("");
    public QWalletLocalPhone$MaskPhoneData mask_phone = new QWalletLocalPhone$MaskPhoneData();
    public QWalletLocalPhone$PlainPhoneData plain_phone = new QWalletLocalPhone$PlainPhoneData();
    public final PBEnumField carrier_type = PBField.initEnum(0);
    public final PBStringField ext_info = PBField.initString("");
}
