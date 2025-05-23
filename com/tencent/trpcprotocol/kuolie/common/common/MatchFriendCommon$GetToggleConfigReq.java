package com.tencent.trpcprotocol.kuolie.common.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class MatchFriendCommon$GetToggleConfigReq extends MessageMicro<MatchFriendCommon$GetToggleConfigReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"toogle_key"}, new Object[]{""}, MatchFriendCommon$GetToggleConfigReq.class);
    public final PBStringField toogle_key = PBField.initString("");
}
