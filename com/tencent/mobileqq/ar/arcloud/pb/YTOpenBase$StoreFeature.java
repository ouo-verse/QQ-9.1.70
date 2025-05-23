package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class YTOpenBase$StoreFeature extends MessageMicro<YTOpenBase$StoreFeature> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 34, 50}, new String[]{"person_id", "feature", "group_ids", "version"}, new Object[]{"", null, "", ""}, YTOpenBase$StoreFeature.class);
    public final PBStringField person_id = PBField.initString("");
    public final PBRepeatMessageField<YTOpenBase$FeatureItem> feature = PBField.initRepeatMessage(YTOpenBase$FeatureItem.class);
    public final PBRepeatField<String> group_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField version = PBField.initString("");
}
