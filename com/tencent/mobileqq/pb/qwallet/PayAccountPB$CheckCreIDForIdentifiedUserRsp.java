package com.tencent.mobileqq.pb.qwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class PayAccountPB$CheckCreIDForIdentifiedUserRsp extends MessageMicro<PayAccountPB$CheckCreIDForIdentifiedUserRsp> {
    public static final int USER_ID_OPENID = 0;
    public static final int USER_ID_UIN = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 48, 56, 66, 74}, new String[]{"busi_info", "nav_type", "userid_type", "userid", "time_stamp", "token_scene", "token_type", "mch_id", "sign"}, new Object[]{"", 0L, 0, "", 0L, 0L, 0L, "", ""}, PayAccountPB$CheckCreIDForIdentifiedUserRsp.class);
    public final PBStringField busi_info = PBField.initString("");
    public final PBInt64Field nav_type = PBField.initInt64(0);
    public final PBEnumField userid_type = PBField.initEnum(0);
    public final PBStringField userid = PBField.initString("");
    public final PBInt64Field time_stamp = PBField.initInt64(0);
    public final PBInt64Field token_scene = PBField.initInt64(0);
    public final PBInt64Field token_type = PBField.initInt64(0);
    public final PBStringField mch_id = PBField.initString("");
    public final PBStringField sign = PBField.initString("");
}
