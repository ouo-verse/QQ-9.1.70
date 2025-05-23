package com.tencent.pb.now;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class FeedsProtocol$PersonFeedRsp extends MessageMicro<FeedsProtocol$PersonFeedRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42}, new String[]{"result", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "total", "end_flag", "msg_feeds"}, new Object[]{0, ByteStringMicro.EMPTY, 0, 0, null}, FeedsProtocol$PersonFeedRsp.class);
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBBytesField errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field total = PBField.initUInt32(0);
    public final PBUInt32Field end_flag = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedsProtocol$FeedsInfo> msg_feeds = PBField.initRepeatMessage(FeedsProtocol$FeedsInfo.class);
}
