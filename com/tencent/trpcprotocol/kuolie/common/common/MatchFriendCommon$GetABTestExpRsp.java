package com.tencent.trpcprotocol.kuolie.common.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class MatchFriendCommon$GetABTestExpRsp extends MessageMicro<MatchFriendCommon$GetABTestExpRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"gray_id"}, new Object[]{0L}, MatchFriendCommon$GetABTestExpRsp.class);
    public final PBUInt64Field gray_id = PBField.initUInt64(0);
}
