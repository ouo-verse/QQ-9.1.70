package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes11.dex */
public final class ARCloudRecogCommonPb$ARFileReqInfo extends MessageMicro<ARCloudRecogCommonPb$ARFileReqInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"str_file_name", "uint32_file_format"}, new Object[]{"", 0}, ARCloudRecogCommonPb$ARFileReqInfo.class);
    public final PBStringField str_file_name = PBField.initString("");
    public final PBUInt32Field uint32_file_format = PBField.initUInt32(0);
}
