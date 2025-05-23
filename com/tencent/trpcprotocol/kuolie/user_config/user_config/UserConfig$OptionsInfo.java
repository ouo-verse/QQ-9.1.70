package com.tencent.trpcprotocol.kuolie.user_config.user_config;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class UserConfig$OptionsInfo extends MessageMicro<UserConfig$OptionsInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"open_id", "options"}, new Object[]{"", null}, UserConfig$OptionsInfo.class);
    public final PBStringField open_id = PBField.initString("");
    public UserConfig$Options options = new UserConfig$Options();
}
