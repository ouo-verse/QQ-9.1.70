package com.tencent.trpcprotocol.kuolie.user_config.user_config;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes27.dex */
public final class UserConfig$PrivacyOption extends MessageMicro<UserConfig$PrivacyOption> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"is_not_disturb"}, new Object[]{Boolean.FALSE}, UserConfig$PrivacyOption.class);
    public final PBBoolField is_not_disturb = PBField.initBool(false);
}
