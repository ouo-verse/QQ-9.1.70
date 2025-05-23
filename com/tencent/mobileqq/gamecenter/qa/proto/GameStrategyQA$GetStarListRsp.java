package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$GetStarListRsp extends MessageMicro<GameStrategyQA$GetStarListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"star_users", "is_over", "total_num"}, new Object[]{null, Boolean.FALSE, 0L}, GameStrategyQA$GetStarListRsp.class);
    public final PBRepeatMessageField<GameStrategyQA$StarUserInfo> star_users = PBField.initRepeatMessage(GameStrategyQA$StarUserInfo.class);
    public final PBBoolField is_over = PBField.initBool(false);
    public final PBInt64Field total_num = PBField.initInt64(0);
}
