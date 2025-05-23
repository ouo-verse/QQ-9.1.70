package com.tencent.trpcprotocol.qqexpand.userConfig.userConfig;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class UserConfig$GetOptionsRsp extends MessageMicro<UserConfig$GetOptionsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"options", "next_pull_time"}, new Object[]{null, 0}, UserConfig$GetOptionsRsp.class);
    public UserConfig$Options options = new UserConfig$Options();
    public final PBUInt32Field next_pull_time = PBField.initUInt32(0);
}
