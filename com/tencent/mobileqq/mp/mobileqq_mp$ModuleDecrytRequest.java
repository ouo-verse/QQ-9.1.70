package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qzone.networkedmodule.QzoneModuleConst;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$ModuleDecrytRequest extends MessageMicro<mobileqq_mp$ModuleDecrytRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"versionInfo", "module_id", QzoneModuleConst.QZONE_MODULE_CONFIG_MODULE_VERSION}, new Object[]{"", 0, 0}, mobileqq_mp$ModuleDecrytRequest.class);
    public final PBStringField versionInfo = PBField.initString("");
    public final PBUInt32Field module_id = PBField.initUInt32(0);
    public final PBUInt32Field module_version = PBField.initUInt32(0);
}
