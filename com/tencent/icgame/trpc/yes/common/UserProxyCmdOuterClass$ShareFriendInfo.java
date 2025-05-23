package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class UserProxyCmdOuterClass$ShareFriendInfo extends MessageMicro<UserProxyCmdOuterClass$ShareFriendInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"uin", "nick", "icon", "icon_flag"}, new Object[]{0L, "", "", 0}, UserProxyCmdOuterClass$ShareFriendInfo.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField nick = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBUInt32Field icon_flag = PBField.initUInt32(0);
}
