package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_like$FeedsLikeRsp extends MessageMicro<ilive_feeds_like$FeedsLikeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"total", "ret"}, new Object[]{0, 0}, ilive_feeds_like$FeedsLikeRsp.class);
    public final PBUInt32Field total = PBField.initUInt32(0);
    public final PBUInt32Field ret = PBField.initUInt32(0);
}
