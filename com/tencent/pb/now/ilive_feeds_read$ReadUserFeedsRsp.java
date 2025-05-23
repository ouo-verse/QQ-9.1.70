package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_read$ReadUserFeedsRsp extends MessageMicro<ilive_feeds_read$ReadUserFeedsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"infos", "total", "user_infos", "h5_url"}, new Object[]{null, 0, null, ""}, ilive_feeds_read$ReadUserFeedsRsp.class);
    public final PBRepeatMessageField<ilive_feeds_read$FeedsInfo> infos = PBField.initRepeatMessage(ilive_feeds_read$FeedsInfo.class);
    public final PBUInt32Field total = PBField.initUInt32(0);
    public final PBRepeatMessageField<ilive_feeds_read$FeedUserInfo> user_infos = PBField.initRepeatMessage(ilive_feeds_read$FeedUserInfo.class);
    public final PBStringField h5_url = PBField.initString("");
}
