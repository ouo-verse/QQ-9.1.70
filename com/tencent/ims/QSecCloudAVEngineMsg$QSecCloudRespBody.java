package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class QSecCloudAVEngineMsg$QSecCloudRespBody extends MessageMicro<QSecCloudAVEngineMsg$QSecCloudRespBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"status", "version", "respEntry"}, new Object[]{0, 0, null}, QSecCloudAVEngineMsg$QSecCloudRespBody.class);
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBRepeatMessageField<QSecCloudAVEngineMsg$QSecCloudRespEntry> respEntry = PBField.initRepeatMessage(QSecCloudAVEngineMsg$QSecCloudRespEntry.class);
}
