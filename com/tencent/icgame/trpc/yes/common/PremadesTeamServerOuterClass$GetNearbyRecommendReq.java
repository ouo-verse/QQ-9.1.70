package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class PremadesTeamServerOuterClass$GetNearbyRecommendReq extends MessageMicro<PremadesTeamServerOuterClass$GetNearbyRecommendReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uid", "user_id", "game_ids"}, new Object[]{0L, null, 0}, PremadesTeamServerOuterClass$GetNearbyRecommendReq.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
    public final PBRepeatField<Integer> game_ids = PBField.initRepeat(PBInt32Field.__repeatHelper__);
}
