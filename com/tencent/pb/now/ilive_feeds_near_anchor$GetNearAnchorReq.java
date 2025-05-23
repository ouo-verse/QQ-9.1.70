package com.tencent.pb.now;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_near_anchor$GetNearAnchorReq extends MessageMicro<ilive_feeds_near_anchor$GetNearAnchorReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBFloatField longitude = PBField.initFloat(0.0f);
    public final PBFloatField latitude = PBField.initFloat(0.0f);
    public final PBUInt32Field start = PBField.initUInt32(0);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt32Field gender = PBField.initUInt32(0);
    public final PBEnumField gender_filter = PBField.initEnum(0);
    public final PBStringField qq_version = PBField.initString("");

    static {
        String[] strArr = {"longitude", "latitude", "start", WidgetCacheConstellationData.NUM, "source", "gender", "gender_filter", AppConstants.Preferences.QQ_VERSION};
        Float valueOf = Float.valueOf(0.0f);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{13, 21, 24, 32, 40, 48, 56, 74}, strArr, new Object[]{valueOf, valueOf, 0, 0, 0, 0, 0, ""}, ilive_feeds_near_anchor$GetNearAnchorReq.class);
    }
}
