package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

/* loaded from: classes22.dex */
public final class FeedsProtocol$DelFeedReq extends MessageMicro<FeedsProtocol$DelFeedReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"feed_ids"}, new Object[]{ByteStringMicro.EMPTY}, FeedsProtocol$DelFeedReq.class);
    public final PBRepeatField<ByteStringMicro> feed_ids = PBField.initRepeat(PBBytesField.__repeatHelper__);
}
