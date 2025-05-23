package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YesGameInfoOuterClass$SmobaExtInfo extends MessageMicro<YesGameInfoOuterClass$SmobaExtInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 58, 64}, new String[]{"display_hero_list", "display_branch_list", "winning_streak", "last_match_achievement", "honor_info", "user_privacy_bits", "role_achievement", "match_achievement"}, new Object[]{0, 0, 0, 0L, null, 0L, null, 0L}, YesGameInfoOuterClass$SmobaExtInfo.class);
    public final PBRepeatField<Integer> display_branch_list;
    public final PBRepeatField<Integer> display_hero_list;
    public YesGameInfoOuterClass$SmobaHonorInfo honor_info;
    public final PBUInt64Field last_match_achievement;
    public final PBRepeatField<Long> match_achievement;
    public final PBRepeatMessageField<YesGameInfoOuterClass$YesGameRoleAchievement> role_achievement;
    public final PBUInt64Field user_privacy_bits;
    public final PBInt32Field winning_streak;

    /* JADX WARN: Type inference failed for: r2v1, types: [com.tencent.icgame.trpc.yes.common.YesGameInfoOuterClass$SmobaHonorInfo] */
    public YesGameInfoOuterClass$SmobaExtInfo() {
        PBInt32Field pBInt32Field = PBInt32Field.__repeatHelper__;
        this.display_hero_list = PBField.initRepeat(pBInt32Field);
        this.display_branch_list = PBField.initRepeat(pBInt32Field);
        this.winning_streak = PBField.initInt32(0);
        this.last_match_achievement = PBField.initUInt64(0L);
        this.honor_info = new MessageMicro<YesGameInfoOuterClass$SmobaHonorInfo>() { // from class: com.tencent.icgame.trpc.yes.common.YesGameInfoOuterClass$SmobaHonorInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"hero_list", "ad_code"}, new Object[]{null, ""}, YesGameInfoOuterClass$SmobaHonorInfo.class);
            public final PBRepeatMessageField<YesGameInfoOuterClass$SmobaHonorHeroInfo> hero_list = PBField.initRepeatMessage(YesGameInfoOuterClass$SmobaHonorHeroInfo.class);
            public final PBStringField ad_code = PBField.initString("");
        };
        this.user_privacy_bits = PBField.initUInt64(0L);
        this.role_achievement = PBField.initRepeatMessage(YesGameInfoOuterClass$YesGameRoleAchievement.class);
        this.match_achievement = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    }
}
