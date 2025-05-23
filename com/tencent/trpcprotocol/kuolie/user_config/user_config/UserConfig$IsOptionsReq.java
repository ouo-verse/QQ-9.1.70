package com.tencent.trpcprotocol.kuolie.user_config.user_config;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class UserConfig$IsOptionsReq extends MessageMicro<UserConfig$IsOptionsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"open_id"}, new Object[]{""}, UserConfig$IsOptionsReq.class);
    public final PBStringField open_id = PBField.initString("");
}
