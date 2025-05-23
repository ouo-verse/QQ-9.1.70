package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$BatchGetUserInfoReq extends MessageMicro<userInfo$BatchGetUserInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"account_ids", "account_type", "mini_info_ids"}, new Object[]{"", 0, 0}, userInfo$BatchGetUserInfoReq.class);
    public final PBRepeatField<String> account_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBEnumField account_type = PBField.initEnum(0);
    public final PBRepeatField<Integer> mini_info_ids = PBField.initRepeat(PBEnumField.__repeatHelper__);
}
