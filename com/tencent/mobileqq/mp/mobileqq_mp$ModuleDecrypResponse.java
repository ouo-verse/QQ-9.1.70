package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qzone.networkedmodule.QzoneModuleConst;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$ModuleDecrypResponse extends MessageMicro<mobileqq_mp$ModuleDecrypResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42}, new String[]{"ret_info", "module_id", QzoneModuleConst.QZONE_MODULE_CONFIG_MODULE_VERSION, "decrypt", "pwd"}, new Object[]{null, 0, 0, Boolean.FALSE, ""}, mobileqq_mp$ModuleDecrypResponse.class);
    public mobileqq_mp$RetInfo ret_info = new mobileqq_mp$RetInfo();
    public final PBUInt32Field module_id = PBField.initUInt32(0);
    public final PBUInt32Field module_version = PBField.initUInt32(0);
    public final PBBoolField decrypt = PBField.initBool(false);
    public final PBStringField pwd = PBField.initString("");
}
