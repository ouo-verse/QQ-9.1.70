package com.tencent.trpcprotocol.qqstranger.common.common_system_msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes38.dex */
public final class CommonSystemMsgPB$UserInfo extends MessageMicro<CommonSystemMsgPB$UserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"nick", "tid"}, new Object[]{"", 0L}, CommonSystemMsgPB$UserInfo.class);
    public final PBStringField nick = PBField.initString("");
    public final PBUInt64Field tid = PBField.initUInt64(0);
}
