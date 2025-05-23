package com.tencent.qqprotect.qsec.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.smtt.sdk.stat.MttLoader;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class QSecCloudAVEngineMsg$QSecCloudRespEntry extends MessageMicro<QSecCloudAVEngineMsg$QSecCloudRespEntry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58}, new String[]{MttLoader.ENTRY_ID, "attrType", "category", "subCategory", "timeToLive", "actionType", "extraInfo"}, new Object[]{0, 0, 0, 0, 0, 0, ByteStringMicro.EMPTY}, QSecCloudAVEngineMsg$QSecCloudRespEntry.class);
    public final PBUInt32Field entryId = PBField.initUInt32(0);
    public final PBUInt32Field attrType = PBField.initUInt32(0);
    public final PBUInt32Field category = PBField.initUInt32(0);
    public final PBUInt32Field subCategory = PBField.initUInt32(0);
    public final PBUInt32Field timeToLive = PBField.initUInt32(0);
    public final PBUInt32Field actionType = PBField.initUInt32(0);
    public final PBBytesField extraInfo = PBField.initBytes(ByteStringMicro.EMPTY);
}
