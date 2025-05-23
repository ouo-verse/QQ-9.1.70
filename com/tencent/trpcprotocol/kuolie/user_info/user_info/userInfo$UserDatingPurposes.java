package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes38.dex */
public final class userInfo$UserDatingPurposes extends MessageMicro<userInfo$UserDatingPurposes> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"open_id", "dp_ids"}, new Object[]{"", 0}, userInfo$UserDatingPurposes.class);
    public final PBStringField open_id = PBField.initString("");
    public final PBRepeatField<Integer> dp_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
