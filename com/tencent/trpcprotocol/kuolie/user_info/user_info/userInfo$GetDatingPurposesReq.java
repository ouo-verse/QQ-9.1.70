package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes38.dex */
public final class userInfo$GetDatingPurposesReq extends MessageMicro<userInfo$GetDatingPurposesReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"open_id"}, new Object[]{""}, userInfo$GetDatingPurposesReq.class);
    public final PBStringField open_id = PBField.initString("");
}
