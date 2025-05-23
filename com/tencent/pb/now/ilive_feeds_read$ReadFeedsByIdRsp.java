package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_read$ReadFeedsByIdRsp extends MessageMicro<ilive_feeds_read$ReadFeedsByIdRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"infos"}, new Object[]{null}, ilive_feeds_read$ReadFeedsByIdRsp.class);
    public final PBRepeatMessageField<ilive_feeds_read$FeedsInfo> infos = PBField.initRepeatMessage(ilive_feeds_read$FeedsInfo.class);
}
