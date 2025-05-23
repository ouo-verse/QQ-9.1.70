package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class VaProfileGate$CommTaskInfo extends MessageMicro<VaProfileGate$CommTaskInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_appid", "bytes_task_data"}, new Object[]{0, ByteStringMicro.EMPTY}, VaProfileGate$CommTaskInfo.class);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBBytesField bytes_task_data = PBField.initBytes(ByteStringMicro.EMPTY);
}
