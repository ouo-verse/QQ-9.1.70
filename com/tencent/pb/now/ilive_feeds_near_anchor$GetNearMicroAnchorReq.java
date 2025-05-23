package com.tencent.pb.now;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_near_anchor$GetNearMicroAnchorReq extends MessageMicro<ilive_feeds_near_anchor$GetNearMicroAnchorReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBFloatField longitude = PBField.initFloat(0.0f);
    public final PBFloatField latitude = PBField.initFloat(0.0f);
    public final PBUInt32Field start = PBField.initUInt32(0);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt32Field gender = PBField.initUInt32(0);

    static {
        String[] strArr = {"longitude", "latitude", "start", WidgetCacheConstellationData.NUM, "source", "gender"};
        Float valueOf = Float.valueOf(0.0f);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{13, 21, 24, 32, 40, 48}, strArr, new Object[]{valueOf, valueOf, 0, 0, 0, 0}, ilive_feeds_near_anchor$GetNearMicroAnchorReq.class);
    }
}
