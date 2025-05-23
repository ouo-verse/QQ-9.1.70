package com.tencent.mobileqq.bigbrother;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class ServerApi$RspJumpCheckRecmd extends MessageMicro<ServerApi$RspJumpCheckRecmd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"err_info", "jump_method"}, new Object[]{null, 0}, ServerApi$RspJumpCheckRecmd.class);
    public ServerApi$ErrorInfo err_info = new ServerApi$ErrorInfo();
    public final PBUInt32Field jump_method = PBField.initUInt32(0);
}
