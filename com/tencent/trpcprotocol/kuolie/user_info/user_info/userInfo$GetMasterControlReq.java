package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$GetMasterControlReq extends MessageMicro<userInfo$GetMasterControlReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"source", "req_flag", "mc_type"}, new Object[]{"", 0, 0}, userInfo$GetMasterControlReq.class);
    public final PBStringField source = PBField.initString("");
    public final PBRepeatField<Integer> req_flag = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBEnumField mc_type = PBField.initEnum(0);
}
