package com.tencent.trpcprotocol.kuolie.user_config.user_config;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class UserConfig$GetOptionsRsp extends MessageMicro<UserConfig$GetOptionsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"options", "ret_code"}, new Object[]{null, 0}, UserConfig$GetOptionsRsp.class);
    public UserConfig$Options options = new UserConfig$Options();
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
}
