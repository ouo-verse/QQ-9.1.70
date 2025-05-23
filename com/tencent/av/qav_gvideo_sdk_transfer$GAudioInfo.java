package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class qav_gvideo_sdk_transfer$GAudioInfo extends MessageMicro<qav_gvideo_sdk_transfer$GAudioInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uint64_relationId", "uint32_relationType", "uint32_multiBusiType", "uint64_roomId", "uint32_roomCreateTime"}, new Object[]{0L, 0, 0, 0L, 0}, qav_gvideo_sdk_transfer$GAudioInfo.class);
    public final PBUInt64Field uint64_relationId = PBField.initUInt64(0);
    public final PBUInt32Field uint32_relationType = PBField.initUInt32(0);
    public final PBUInt32Field uint32_multiBusiType = PBField.initUInt32(0);
    public final PBUInt64Field uint64_roomId = PBField.initUInt64(0);
    public final PBUInt32Field uint32_roomCreateTime = PBField.initUInt32(0);
}
