package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_tmem$FeedLikeStatus extends MessageMicro<ilive_feeds_tmem$FeedLikeStatus> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"like_status", "last_time"}, new Object[]{0, 0}, ilive_feeds_tmem$FeedLikeStatus.class);
    public final PBUInt32Field like_status = PBField.initUInt32(0);
    public final PBUInt32Field last_time = PBField.initUInt32(0);
}
