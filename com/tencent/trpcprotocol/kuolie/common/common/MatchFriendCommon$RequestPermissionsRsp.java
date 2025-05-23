package com.tencent.trpcprotocol.kuolie.common.common;

import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

/* loaded from: classes27.dex */
public final class MatchFriendCommon$RequestPermissionsRsp extends MessageMicro<MatchFriendCommon$RequestPermissionsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{ForwardMiniChooseFriendOption.RESULT_LIST}, new Object[]{0}, MatchFriendCommon$RequestPermissionsRsp.class);
    public final PBRepeatField<Integer> results = PBField.initRepeat(PBEnumField.__repeatHelper__);
}
