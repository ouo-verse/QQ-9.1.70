package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_read$ReadFeedsByIdReq extends MessageMicro<ilive_feeds_read$ReadFeedsByIdReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"feeds_ids"}, new Object[]{ByteStringMicro.EMPTY}, ilive_feeds_read$ReadFeedsByIdReq.class);
    public final PBRepeatField<ByteStringMicro> feeds_ids = PBField.initRepeat(PBBytesField.__repeatHelper__);
}
