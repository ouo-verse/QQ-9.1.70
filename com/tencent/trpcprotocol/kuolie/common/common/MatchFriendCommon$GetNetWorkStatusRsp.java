package com.tencent.trpcprotocol.kuolie.common.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class MatchFriendCommon$GetNetWorkStatusRsp extends MessageMicro<MatchFriendCommon$GetNetWorkStatusRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"status"}, new Object[]{0}, MatchFriendCommon$GetNetWorkStatusRsp.class);
    public final PBEnumField status = PBField.initEnum(0);
}
