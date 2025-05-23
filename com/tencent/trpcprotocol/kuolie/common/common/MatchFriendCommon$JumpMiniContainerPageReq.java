package com.tencent.trpcprotocol.kuolie.common.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class MatchFriendCommon$JumpMiniContainerPageReq extends MessageMicro<MatchFriendCommon$JumpMiniContainerPageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"path"}, new Object[]{""}, MatchFriendCommon$JumpMiniContainerPageReq.class);
    public final PBStringField path = PBField.initString("");
}
