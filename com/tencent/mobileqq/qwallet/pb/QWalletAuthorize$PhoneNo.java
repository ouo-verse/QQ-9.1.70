package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class QWalletAuthorize$PhoneNo extends MessageMicro<QWalletAuthorize$PhoneNo> {
    public static final int GATEWAY_TOKEN = 2;
    public static final int GATEWAY_TOKEN_V5 = 4;
    public static final int LAST_LOGIN = 3;
    public static final int NORMAL = 1;
    public static final int OVERDUE = 2;
    public static final int PHONE_NOT_SAVE = 1;
    public static final int QPAY_TOKEN = 0;
    public static final int UNKNOWN = 0;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 48, 56}, new String[]{"mask_no", "token", "source", "source_tag", "no", "carrier_type", "state"}, new Object[]{"", "", 0, "", "", 0, 0}, QWalletAuthorize$PhoneNo.class);
    public final PBStringField mask_no = PBField.initString("");
    public final PBStringField token = PBField.initString("");
    public final PBEnumField source = PBField.initEnum(0);
    public final PBStringField source_tag = PBField.initString("");

    /* renamed from: no, reason: collision with root package name */
    public final PBStringField f278700no = PBField.initString("");
    public final PBEnumField carrier_type = PBField.initEnum(0);
    public final PBEnumField state = PBField.initEnum(0);
}
