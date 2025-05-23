package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qzone.networkedmodule.QzoneModuleConst;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$UpdateResponseItem extends MessageMicro<mobileqq_mp$UpdateResponseItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48, 58}, new String[]{"module_id", QzoneModuleConst.QZONE_MODULE_CONFIG_MODULE_VERSION, "module_state", "download_url", "md5", "decrypt", "pwd"}, new Object[]{0, 0, 0, "", "", Boolean.FALSE, ""}, mobileqq_mp$UpdateResponseItem.class);
    public final PBUInt32Field module_id = PBField.initUInt32(0);
    public final PBUInt32Field module_version = PBField.initUInt32(0);
    public final PBUInt32Field module_state = PBField.initUInt32(0);
    public final PBStringField download_url = PBField.initString("");
    public final PBStringField md5 = PBField.initString("");
    public final PBBoolField decrypt = PBField.initBool(false);
    public final PBStringField pwd = PBField.initString("");
}
