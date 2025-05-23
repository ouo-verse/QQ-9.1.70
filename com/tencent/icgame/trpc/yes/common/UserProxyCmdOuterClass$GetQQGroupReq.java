package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class UserProxyCmdOuterClass$GetQQGroupReq extends MessageMicro<UserProxyCmdOuterClass$GetQQGroupReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"live_room_id", "live_uid", "query_word"}, new Object[]{0L, 0L, ""}, UserProxyCmdOuterClass$GetQQGroupReq.class);
    public final PBUInt64Field live_room_id = PBField.initUInt64(0);
    public final PBUInt64Field live_uid = PBField.initUInt64(0);
    public final PBStringField query_word = PBField.initString("");
}
