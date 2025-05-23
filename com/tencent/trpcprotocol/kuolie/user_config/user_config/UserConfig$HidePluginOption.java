package com.tencent.trpcprotocol.kuolie.user_config.user_config;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes27.dex */
public final class UserConfig$HidePluginOption extends MessageMicro<UserConfig$HidePluginOption> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"hide"}, new Object[]{Boolean.FALSE}, UserConfig$HidePluginOption.class);
    public final PBBoolField hide = PBField.initBool(false);
}
