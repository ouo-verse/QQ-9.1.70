package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class UserProxyCmdOuterClass$ArkMsgRecvInfo extends MessageMicro<UserProxyCmdOuterClass$ArkMsgRecvInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"send_type", "recv_uin", "c2c_relation"}, new Object[]{0, 0L, Boolean.FALSE}, UserProxyCmdOuterClass$ArkMsgRecvInfo.class);
    public final PBUInt32Field send_type = PBField.initUInt32(0);
    public final PBUInt64Field recv_uin = PBField.initUInt64(0);
    public final PBBoolField c2c_relation = PBField.initBool(false);
}
