package com.tencent.biz.qrcode.logindev.pclock;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class StatusService$ChangeLockStatusReq extends MessageMicro<StatusService$ChangeLockStatusReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"instance_id", "lock_status"}, new Object[]{0, 0}, StatusService$ChangeLockStatusReq.class);
    public final PBUInt32Field instance_id = PBField.initUInt32(0);
    public final PBUInt32Field lock_status = PBField.initUInt32(0);
}
