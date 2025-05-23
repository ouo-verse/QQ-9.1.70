package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$LoginInfo extends MessageMicro<userInfo$LoginInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"open_id", "version", "last_login_time", "first_login_time", "is_set_use_flag"}, new Object[]{"", "", 0L, 0L, Boolean.FALSE}, userInfo$LoginInfo.class);
    public final PBStringField open_id = PBField.initString("");
    public final PBStringField version = PBField.initString("");
    public final PBUInt64Field last_login_time = PBField.initUInt64(0);
    public final PBUInt64Field first_login_time = PBField.initUInt64(0);
    public final PBBoolField is_set_use_flag = PBField.initBool(false);
}
