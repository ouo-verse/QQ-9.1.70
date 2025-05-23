package com.tencent.trpcprotocol.minibox.va_stop_bleeding.VaStopBleeding;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;

/* loaded from: classes27.dex */
public final class VaStopBleedingPB$CrashReportRsp extends MessageMicro<VaStopBleedingPB$CrashReportRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"is_available", TransferConfig.ExtendParamFloats.KEY_RULE}, new Object[]{Boolean.FALSE, ""}, VaStopBleedingPB$CrashReportRsp.class);
    public final PBBoolField is_available = PBField.initBool(false);
    public final PBStringField rule = PBField.initString("");
}
