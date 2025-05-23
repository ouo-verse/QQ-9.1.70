package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_write$FeedNoInterestReq extends MessageMicro<ilive_feeds_write$FeedNoInterestReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"feedid", "is_nointerest", "type"}, new Object[]{"", 0, 0}, ilive_feeds_write$FeedNoInterestReq.class);
    public final PBStringField feedid = PBField.initString("");
    public final PBInt32Field is_nointerest = PBField.initInt32(0);
    public final PBInt32Field type = PBField.initInt32(0);
}
