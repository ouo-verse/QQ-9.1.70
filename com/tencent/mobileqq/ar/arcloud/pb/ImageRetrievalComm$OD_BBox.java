package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class ImageRetrievalComm$OD_BBox extends MessageMicro<ImageRetrievalComm$OD_BBox> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 45, 48}, new String[]{"xmin", "ymin", "xmax", "ymax", "fScore", "iLabelID"}, new Object[]{0, 0, 0, 0, Float.valueOf(0.0f), 0}, ImageRetrievalComm$OD_BBox.class);
    public final PBInt32Field xmin = PBField.initInt32(0);
    public final PBInt32Field ymin = PBField.initInt32(0);
    public final PBInt32Field xmax = PBField.initInt32(0);
    public final PBInt32Field ymax = PBField.initInt32(0);
    public final PBFloatField fScore = PBField.initFloat(0.0f);
    public final PBInt32Field iLabelID = PBField.initInt32(0);
}
