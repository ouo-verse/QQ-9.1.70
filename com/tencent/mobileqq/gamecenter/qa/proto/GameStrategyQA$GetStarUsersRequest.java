package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$GetStarUsersRequest extends MessageMicro<GameStrategyQA$GetStarUsersRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"appid", "page", "size"}, new Object[]{0, 0L, 0L}, GameStrategyQA$GetStarUsersRequest.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBInt64Field page = PBField.initInt64(0);
    public final PBInt64Field size = PBField.initInt64(0);
}
