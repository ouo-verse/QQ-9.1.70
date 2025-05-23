package com.tencent.trpcprotocol.kuolie.user_config.user_config;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class UserConfig$SetOptionsReq extends MessageMicro<UserConfig$SetOptionsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"option_ids", "options"}, new Object[]{0, null}, UserConfig$SetOptionsReq.class);
    public final PBRepeatField<Integer> option_ids = PBField.initRepeat(PBEnumField.__repeatHelper__);
    public UserConfig$Options options = new UserConfig$Options();
}
