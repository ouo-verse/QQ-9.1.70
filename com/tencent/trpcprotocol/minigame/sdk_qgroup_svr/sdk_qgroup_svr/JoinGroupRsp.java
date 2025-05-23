package com.tencent.trpcprotocol.minigame.sdk_qgroup_svr.sdk_qgroup_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class JoinGroupRsp extends MessageMicro<JoinGroupRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"group_list"}, new Object[]{0L}, JoinGroupRsp.class);
    public final PBRepeatField<Long> group_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
