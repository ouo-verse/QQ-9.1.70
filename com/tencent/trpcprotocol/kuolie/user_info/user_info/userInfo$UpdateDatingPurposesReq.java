package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes38.dex */
public final class userInfo$UpdateDatingPurposesReq extends MessageMicro<userInfo$UpdateDatingPurposesReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"pick_ids", "open_id"}, new Object[]{0, ""}, userInfo$UpdateDatingPurposesReq.class);
    public final PBRepeatField<Integer> pick_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBStringField open_id = PBField.initString("");
}
