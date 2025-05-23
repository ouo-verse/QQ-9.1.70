package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes38.dex */
public final class userInfo$GetDatingPurposesRsp extends MessageMicro<userInfo$GetDatingPurposesRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"ret_code", "err_msg", "dating_purposes", "pick_ids"}, new Object[]{0, "", null, 0}, userInfo$GetDatingPurposesRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBRepeatMessageField<userInfo$DatingPurpose> dating_purposes = PBField.initRepeatMessage(userInfo$DatingPurpose.class);
    public final PBRepeatField<Integer> pick_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
