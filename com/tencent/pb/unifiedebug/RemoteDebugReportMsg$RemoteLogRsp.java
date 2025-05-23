package com.tencent.pb.unifiedebug;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class RemoteDebugReportMsg$RemoteLogRsp extends MessageMicro<RemoteDebugReportMsg$RemoteLogRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"i32_ret"}, new Object[]{0}, RemoteDebugReportMsg$RemoteLogRsp.class);
    public final PBInt32Field i32_ret = PBField.initInt32(0);
}
