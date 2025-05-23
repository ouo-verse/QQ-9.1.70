package com.tencent.pb.now;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class FeedsProtocol$GetLivingAnchorListReq extends MessageMicro<FeedsProtocol$GetLivingAnchorListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"start", WidgetCacheConstellationData.NUM}, new Object[]{0, 0}, FeedsProtocol$GetLivingAnchorListReq.class);
    public final PBUInt32Field start = PBField.initUInt32(0);
    public final PBUInt32Field num = PBField.initUInt32(0);
}
