package com.tencent.pb.now;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_read$ReadNewUserFeedsReq extends MessageMicro<ilive_feeds_read$ReadNewUserFeedsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{c.G, WidgetCacheConstellationData.NUM, "uin"}, new Object[]{0L, 0, 0L}, ilive_feeds_read$ReadNewUserFeedsReq.class);
    public final PBUInt64Field pos = PBField.initUInt64(0);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
}
