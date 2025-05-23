package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_tmem$RedInfo extends MessageMicro<ilive_feeds_tmem$RedInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uid", "time", "last_feed_time"}, new Object[]{0L, 0L, 0L}, ilive_feeds_tmem$RedInfo.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBUInt64Field time = PBField.initUInt64(0);
    public final PBUInt64Field last_feed_time = PBField.initUInt64(0);
}
