package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class FeedsProtocol$FeedDetailRsp extends MessageMicro<FeedsProtocol$FeedDetailRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"result", "media_infos", "is_end", "total"}, new Object[]{0, null, 0, 0}, FeedsProtocol$FeedDetailRsp.class);
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBRepeatMessageField<FeedsProtocol$MediaInfo> media_infos = PBField.initRepeatMessage(FeedsProtocol$MediaInfo.class);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBUInt32Field total = PBField.initUInt32(0);
}
