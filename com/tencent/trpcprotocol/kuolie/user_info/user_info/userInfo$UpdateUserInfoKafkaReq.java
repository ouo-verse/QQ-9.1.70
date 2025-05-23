package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$UpdateUserInfoKafkaReq extends MessageMicro<userInfo$UpdateUserInfoKafkaReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"open_id", "uin"}, new Object[]{"", 0L}, userInfo$UpdateUserInfoKafkaReq.class);
    public final PBStringField open_id = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0);
}
