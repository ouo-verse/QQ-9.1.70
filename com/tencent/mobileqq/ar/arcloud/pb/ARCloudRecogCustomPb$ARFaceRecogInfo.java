package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes11.dex */
public final class ARCloudRecogCustomPb$ARFaceRecogInfo extends MessageMicro<ARCloudRecogCustomPb$ARFaceRecogInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uin32_timeout_ms", "face_rect"}, new Object[]{0, null}, ARCloudRecogCustomPb$ARFaceRecogInfo.class);
    public final PBUInt32Field uin32_timeout_ms = PBField.initUInt32(0);
    public final PBRepeatMessageField<ARCloudRecogCustomPb$FaceRect> face_rect = PBField.initRepeatMessage(ARCloudRecogCustomPb$FaceRect.class);
}
