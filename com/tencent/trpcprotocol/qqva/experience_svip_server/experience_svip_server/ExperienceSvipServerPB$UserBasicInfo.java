package com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes27.dex */
public final class ExperienceSvipServerPB$UserBasicInfo extends MessageMicro<ExperienceSvipServerPB$UserBasicInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"nick", "avatar", "uin"}, new Object[]{"", "", 0L}, ExperienceSvipServerPB$UserBasicInfo.class);
    public final PBStringField nick = PBField.initString("");
    public final PBStringField avatar = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0);
}
