package com.tencent.trpcprotocol.kuolie.common.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

/* loaded from: classes27.dex */
public final class MatchFriendCommon$RequestPermissionsReq extends MessageMicro<MatchFriendCommon$RequestPermissionsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"permissions"}, new Object[]{0}, MatchFriendCommon$RequestPermissionsReq.class);
    public final PBRepeatField<Integer> permissions = PBField.initRepeat(PBEnumField.__repeatHelper__);
}
