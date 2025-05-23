package com.tencent.qqnt.ntrelation.protocol.onLineStatus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class OnlineStatusExtInfo$CustomStatus extends MessageMicro<OnlineStatusExtInfo$CustomStatus> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"ufaceIndex", "sWording", "ufaceType"}, new Object[]{0L, "", 0L}, OnlineStatusExtInfo$CustomStatus.class);
    public final PBUInt64Field ufaceIndex = PBField.initUInt64(0);
    public final PBStringField sWording = PBField.initString("");
    public final PBUInt64Field ufaceType = PBField.initUInt64(0);
}
