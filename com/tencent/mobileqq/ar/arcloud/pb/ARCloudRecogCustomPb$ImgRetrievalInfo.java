package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes11.dex */
public final class ARCloudRecogCustomPb$ImgRetrievalInfo extends MessageMicro<ARCloudRecogCustomPb$ImgRetrievalInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uin32_timeout_ms"}, new Object[]{0}, ARCloudRecogCustomPb$ImgRetrievalInfo.class);
    public final PBUInt32Field uin32_timeout_ms = PBField.initUInt32(0);
}
