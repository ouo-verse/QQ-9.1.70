package com.tencent.pb.now;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_read$ReadFollowFeedsReq extends MessageMicro<ilive_feeds_read$ReadFollowFeedsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"start_time", WidgetCacheConstellationData.NUM, "load_num"}, new Object[]{0L, 0, 0}, ilive_feeds_read$ReadFollowFeedsReq.class);
    public final PBUInt64Field start_time = PBField.initUInt64(0);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt32Field load_num = PBField.initUInt32(0);
}
