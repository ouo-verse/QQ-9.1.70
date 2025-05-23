package com.tencent.trpcprotocol.kuolie.user_config.user_config;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class UserConfig$MessageOption extends MessageMicro<UserConfig$MessageOption> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"receive_offline_message"}, new Object[]{Boolean.FALSE}, UserConfig$MessageOption.class);
    public final PBBoolField receive_offline_message = PBField.initBool(false);
}
