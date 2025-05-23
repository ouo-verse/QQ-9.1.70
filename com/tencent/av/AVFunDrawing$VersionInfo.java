package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AVFunDrawing$VersionInfo extends MessageMicro<AVFunDrawing$VersionInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_version", "uint32_support_drawing"}, new Object[]{0, 0}, AVFunDrawing$VersionInfo.class);
    public final PBUInt32Field uint32_version = PBField.initUInt32(0);
    public final PBUInt32Field uint32_support_drawing = PBField.initUInt32(0);
}
