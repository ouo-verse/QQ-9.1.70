package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_tmem$NoInterest extends MessageMicro<ilive_feeds_tmem$NoInterest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"feedid", "type", "count"}, new Object[]{"", 0, 0}, ilive_feeds_tmem$NoInterest.class);
    public final PBStringField feedid = PBField.initString("");
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBInt32Field count = PBField.initInt32(0);
}
