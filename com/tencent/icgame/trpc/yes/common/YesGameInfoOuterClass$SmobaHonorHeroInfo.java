package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YesGameInfoOuterClass$SmobaHonorHeroInfo extends MessageMicro<YesGameInfoOuterClass$SmobaHonorHeroInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"hero_id", "location_type", "rank", "fight_score", "is_show"}, new Object[]{0, 0, 0, 0, Boolean.FALSE}, YesGameInfoOuterClass$SmobaHonorHeroInfo.class);
    public final PBInt32Field hero_id = PBField.initInt32(0);
    public final PBInt32Field location_type = PBField.initInt32(0);
    public final PBInt32Field rank = PBField.initInt32(0);
    public final PBInt32Field fight_score = PBField.initInt32(0);
    public final PBBoolField is_show = PBField.initBool(false);
}
