package com.tencent.trpcprotocol.kuolie.common.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class MatchFriendCommon$GetABTestExpReq extends MessageMicro<MatchFriendCommon$GetABTestExpReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"exp_name"}, new Object[]{""}, MatchFriendCommon$GetABTestExpReq.class);
    public final PBStringField exp_name = PBField.initString("");
}
