package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AVFunDrawing$MessageBody extends MessageMicro<AVFunDrawing$MessageBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40}, new String[]{"uint32_msg_type", "versionInfo", "drawingInfo", "uint32_seq", "uint64_time"}, new Object[]{0, null, null, 0, 0L}, AVFunDrawing$MessageBody.class);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public AVFunDrawing$VersionInfo versionInfo = new AVFunDrawing$VersionInfo();
    public AVFunDrawing$DrawingInfo drawingInfo = new AVFunDrawing$DrawingInfo();
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0);
}
