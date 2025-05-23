package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes11.dex */
public final class ARCloudRecogCustomPb$ARWordDetectInfo extends MessageMicro<ARCloudRecogCustomPb$ARWordDetectInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uin32_timeout_ms", "uin32_get_ocr_class"}, new Object[]{0, 0}, ARCloudRecogCustomPb$ARWordDetectInfo.class);
    public final PBUInt32Field uin32_timeout_ms = PBField.initUInt32(0);
    public final PBUInt32Field uin32_get_ocr_class = PBField.initUInt32(0);
}
