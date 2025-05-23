package com.tencent.ims;

import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.smtt.sdk.stat.MttLoader;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class QSecCloudAVEngineMsg$QSecCloudQueryEntry extends MessageMicro<QSecCloudAVEngineMsg$QSecCloudQueryEntry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 66, 74, 82}, new String[]{MttLoader.ENTRY_ID, TagName.FILE_TYPE, "scenarioType", "fileSize", "packageName", WadlProxyConsts.PARAM_FILENAME, "appName", "fileMd5", "certMd5", "extraInfo"}, new Object[]{0, 0, 0, 0, "", "", "", "", "", ByteStringMicro.EMPTY}, QSecCloudAVEngineMsg$QSecCloudQueryEntry.class);
    public final PBUInt32Field entryId = PBField.initUInt32(0);
    public final PBUInt32Field fileType = PBField.initUInt32(0);
    public final PBUInt32Field scenarioType = PBField.initUInt32(0);
    public final PBUInt32Field fileSize = PBField.initUInt32(0);
    public final PBStringField packageName = PBField.initString("");
    public final PBStringField fileName = PBField.initString("");
    public final PBStringField appName = PBField.initString("");
    public final PBStringField fileMd5 = PBField.initString("");
    public final PBStringField certMd5 = PBField.initString("");
    public final PBBytesField extraInfo = PBField.initBytes(ByteStringMicro.EMPTY);
}
