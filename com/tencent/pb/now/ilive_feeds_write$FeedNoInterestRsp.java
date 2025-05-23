package com.tencent.pb.now;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_write$FeedNoInterestRsp extends MessageMicro<ilive_feeds_write$FeedNoInterestRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret", HippyReporter.EXTRA_KEY_REPORT_ERRMSG}, new Object[]{0, ByteStringMicro.EMPTY}, ilive_feeds_write$FeedNoInterestRsp.class);
    public final PBInt32Field ret = PBField.initInt32(0);
    public final PBBytesField errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
}
