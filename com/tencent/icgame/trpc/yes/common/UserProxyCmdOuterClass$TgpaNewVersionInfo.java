package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes7.dex */
public final class UserProxyCmdOuterClass$TgpaNewVersionInfo extends MessageMicro<UserProxyCmdOuterClass$TgpaNewVersionInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"cur_version_id", "new_version_id", "cur_source_id", "new_source_id"}, new Object[]{"", "", "", ""}, UserProxyCmdOuterClass$TgpaNewVersionInfo.class);
    public final PBStringField cur_version_id = PBField.initString("");
    public final PBStringField new_version_id = PBField.initString("");
    public final PBStringField cur_source_id = PBField.initString("");
    public final PBStringField new_source_id = PBField.initString("");
}
