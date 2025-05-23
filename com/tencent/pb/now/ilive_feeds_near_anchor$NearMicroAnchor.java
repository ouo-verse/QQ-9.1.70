package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_near_anchor$NearMicroAnchor extends MessageMicro<ilive_feeds_near_anchor$NearMicroAnchor> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBFloatField longitude = PBField.initFloat(0.0f);
    public final PBFloatField latitude = PBField.initFloat(0.0f);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBUInt32Field roomid = PBField.initUInt32(0);

    static {
        Float valueOf = Float.valueOf(0.0f);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{13, 21, 24, 32}, new String[]{"longitude", "latitude", "uid", "roomid"}, new Object[]{valueOf, valueOf, 0L, 0}, ilive_feeds_near_anchor$NearMicroAnchor.class);
    }
}
