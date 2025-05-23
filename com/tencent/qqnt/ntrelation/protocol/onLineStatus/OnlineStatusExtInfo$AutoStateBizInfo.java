package com.tencent.qqnt.ntrelation.protocol.onLineStatus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class OnlineStatusExtInfo$AutoStateBizInfo extends MessageMicro<OnlineStatusExtInfo$AutoStateBizInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_update_time"}, new Object[]{0L}, OnlineStatusExtInfo$AutoStateBizInfo.class);
    public final PBUInt64Field uint64_update_time = PBField.initUInt64(0);
}
