package com.tencent.trpcprotocol.kuolie.common.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class MatchFriendCommon$ReportABTestReq extends MessageMicro<MatchFriendCommon$ReportABTestReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"exp_name"}, new Object[]{""}, MatchFriendCommon$ReportABTestReq.class);
    public final PBStringField exp_name = PBField.initString("");
}
