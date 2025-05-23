package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

/* loaded from: classes22.dex */
public final class ilive_feeds_read$FollowTabRedPointReq extends MessageMicro<ilive_feeds_read$FollowTabRedPointReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"op", "time"}, new Object[]{0, 0L}, ilive_feeds_read$FollowTabRedPointReq.class);

    /* renamed from: op, reason: collision with root package name */
    public final PBInt32Field f342144op = PBField.initInt32(0);
    public final PBInt64Field time = PBField.initInt64(0);
}
