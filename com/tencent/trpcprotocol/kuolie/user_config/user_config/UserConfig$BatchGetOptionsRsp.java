package com.tencent.trpcprotocol.kuolie.user_config.user_config;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class UserConfig$BatchGetOptionsRsp extends MessageMicro<UserConfig$BatchGetOptionsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"option_infos", "ret_code"}, new Object[]{null, 0}, UserConfig$BatchGetOptionsRsp.class);
    public final PBRepeatMessageField<UserConfig$OptionsInfo> option_infos = PBField.initRepeatMessage(UserConfig$OptionsInfo.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
}
