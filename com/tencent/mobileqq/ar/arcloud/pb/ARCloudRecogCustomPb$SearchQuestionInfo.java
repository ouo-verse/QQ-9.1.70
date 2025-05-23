package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes11.dex */
public final class ARCloudRecogCustomPb$SearchQuestionInfo extends MessageMicro<ARCloudRecogCustomPb$SearchQuestionInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uin32_timeout_ms", "uin64_pic_height", "uin64_pic_width"}, new Object[]{0, 0L, 0L}, ARCloudRecogCustomPb$SearchQuestionInfo.class);
    public final PBUInt32Field uin32_timeout_ms = PBField.initUInt32(0);
    public final PBUInt64Field uin64_pic_height = PBField.initUInt64(0);
    public final PBUInt64Field uin64_pic_width = PBField.initUInt64(0);
}
