package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes7.dex */
public final class UserProxyCmdOuterClass$GetArkMsgBodyRsp extends MessageMicro<UserProxyCmdOuterClass$GetArkMsgBodyRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"body_json"}, new Object[]{""}, UserProxyCmdOuterClass$GetArkMsgBodyRsp.class);
    public final PBStringField body_json = PBField.initString("");
}
