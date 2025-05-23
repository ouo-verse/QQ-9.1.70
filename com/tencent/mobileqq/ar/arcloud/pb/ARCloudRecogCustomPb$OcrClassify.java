package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes11.dex */
public final class ARCloudRecogCustomPb$OcrClassify extends MessageMicro<ARCloudRecogCustomPb$OcrClassify> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 21}, new String[]{"ocr_class", "confidence"}, new Object[]{"", Float.valueOf(0.0f)}, ARCloudRecogCustomPb$OcrClassify.class);
    public final PBStringField ocr_class = PBField.initString("");
    public final PBFloatField confidence = PBField.initFloat(0.0f);
}
