package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class NearbyCommonOuterClass$YesGameRecommendUserAchievement extends MessageMicro<NearbyCommonOuterClass$YesGameRecommendUserAchievement> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"type", "icon", "big_icon", "text", "background"}, new Object[]{0, "", "", "", ""}, NearbyCommonOuterClass$YesGameRecommendUserAchievement.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField icon = PBField.initString("");
    public final PBStringField big_icon = PBField.initString("");
    public final PBStringField text = PBField.initString("");
    public final PBStringField background = PBField.initString("");
}
