package com.tencent.trpcprotocol.qqexpand.userConfig.userConfig;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes27.dex */
public final class UserConfig$BatchGetPrefOptionsRsp extends MessageMicro<UserConfig$BatchGetPrefOptionsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"pref_infos"}, new Object[]{null}, UserConfig$BatchGetPrefOptionsRsp.class);
    public final PBRepeatMessageField<UserConfig$GetPrefOptionsRsp> pref_infos = PBField.initRepeatMessage(UserConfig$GetPrefOptionsRsp.class);
}
