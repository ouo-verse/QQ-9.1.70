package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$GetStarUsersReply extends MessageMicro<GameStrategyQA$GetStarUsersReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"star_users", "is_over", "star_num"}, new Object[]{null, Boolean.FALSE, 0L}, GameStrategyQA$GetStarUsersReply.class);
    public final PBRepeatMessageField<GameStrategyQA$StarUser> star_users = PBField.initRepeatMessage(GameStrategyQA$StarUser.class);
    public final PBBoolField is_over = PBField.initBool(false);
    public final PBInt64Field star_num = PBField.initInt64(0);
}
