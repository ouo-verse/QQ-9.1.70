package com.tencent.mobileqq.avifcodec.config.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class AvifCodecConfig$FeatureInfo extends MessageMicro<AvifCodecConfig$FeatureInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40}, new String[]{"feature_name", "feature_attribute_1", "feature_attribute_2", "feature_time", "feature_qp"}, new Object[]{"", "", "", 0L, 0L}, AvifCodecConfig$FeatureInfo.class);
    public final PBStringField feature_name = PBField.initString("");
    public final PBStringField feature_attribute_1 = PBField.initString("");
    public final PBStringField feature_attribute_2 = PBField.initString("");
    public final PBUInt64Field feature_time = PBField.initUInt64(0);
    public final PBUInt64Field feature_qp = PBField.initUInt64(0);
}
