package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class FeedsProtocol$FeedViewOverRsp extends MessageMicro<FeedsProtocol$FeedViewOverRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"result"}, new Object[]{0}, FeedsProtocol$FeedViewOverRsp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
}
