package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class QBoxEmoticonAuth$GetExpressAuthRsp extends MessageMicro<QBoxEmoticonAuth$GetExpressAuthRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"result_code", QZoneDTLoginReporter.SCHEMA}, new Object[]{0, ""}, QBoxEmoticonAuth$GetExpressAuthRsp.class);
    public final PBUInt32Field result_code = PBField.initUInt32(0);
    public final PBStringField schema = PBField.initString("");
}
