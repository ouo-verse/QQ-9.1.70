package com.tencent.trpcprotocol.kuolie.user_config.user_config;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class UserConfig$BatchGetOptionsReq extends MessageMicro<UserConfig$BatchGetOptionsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"option_ids", "open_ids"}, new Object[]{0, ""}, UserConfig$BatchGetOptionsReq.class);
    public final PBRepeatField<Integer> option_ids = PBField.initRepeat(PBEnumField.__repeatHelper__);
    public final PBRepeatField<String> open_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
}
