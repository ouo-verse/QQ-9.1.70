package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$Birthday extends MessageMicro<userInfo$Birthday> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"year", "month", "day"}, new Object[]{0, 0, 0}, userInfo$Birthday.class);
    public final PBUInt32Field year = PBField.initUInt32(0);
    public final PBUInt32Field month = PBField.initUInt32(0);
    public final PBUInt32Field day = PBField.initUInt32(0);
}
