package com.tencent.pb.now;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class FeedsProtocol$PersonFeedReq extends MessageMicro<FeedsProtocol$PersonFeedReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"start", WidgetCacheConstellationData.NUM, "uid"}, new Object[]{0, 0, 0L}, FeedsProtocol$PersonFeedReq.class);
    public final PBUInt32Field start = PBField.initUInt32(0);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0);
}
