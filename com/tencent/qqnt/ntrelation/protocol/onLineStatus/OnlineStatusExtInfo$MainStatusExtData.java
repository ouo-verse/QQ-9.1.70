package com.tencent.qqnt.ntrelation.protocol.onLineStatus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class OnlineStatusExtInfo$MainStatusExtData extends MessageMicro<OnlineStatusExtInfo$MainStatusExtData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_status_set_time"}, new Object[]{0L}, OnlineStatusExtInfo$MainStatusExtData.class);
    public final PBUInt64Field uint64_status_set_time = PBField.initUInt64(0);
}
