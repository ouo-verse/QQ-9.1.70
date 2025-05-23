package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$GetUserTacitHistoryReq extends MessageMicro<userInfo$GetUserTacitHistoryReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"filter", "offset", "limit"}, new Object[]{0, 0, 0}, userInfo$GetUserTacitHistoryReq.class);
    public final PBEnumField filter = PBField.initEnum(0);
    public final PBUInt32Field offset = PBField.initUInt32(0);
    public final PBUInt32Field limit = PBField.initUInt32(0);
}
