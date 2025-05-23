package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes11.dex */
public final class ARCloudRecogCustomPb$ARFaceRegInfo extends MessageMicro<ARCloudRecogCustomPb$ARFaceRegInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42}, new String[]{"uint32_img_cnt", "uin32_timeout_ms", "person_id", "person_name", "group_ids"}, new Object[]{0, 0, "", "", ""}, ARCloudRecogCustomPb$ARFaceRegInfo.class);
    public final PBUInt32Field uint32_img_cnt = PBField.initUInt32(0);
    public final PBUInt32Field uin32_timeout_ms = PBField.initUInt32(0);
    public final PBStringField person_id = PBField.initString("");
    public final PBStringField person_name = PBField.initString("");
    public final PBRepeatField<String> group_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
}
