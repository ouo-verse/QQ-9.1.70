package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes11.dex */
public final class ARCloudRecogCustomPb$FaceRect extends MessageMicro<ARCloudRecogCustomPb$FaceRect> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"face_rect_id", "face_origin_x", "face_origin_y", "face_size_w", "face_size_h"}, new Object[]{0, 0, 0, 0, 0}, ARCloudRecogCustomPb$FaceRect.class);
    public final PBInt32Field face_rect_id = PBField.initInt32(0);
    public final PBInt32Field face_origin_x = PBField.initInt32(0);
    public final PBInt32Field face_origin_y = PBField.initInt32(0);
    public final PBInt32Field face_size_w = PBField.initInt32(0);
    public final PBInt32Field face_size_h = PBField.initInt32(0);
}
