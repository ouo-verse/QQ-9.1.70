package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YesUserRankingOuterClass$QueryUserRankingRsp extends MessageMicro<YesUserRankingOuterClass$QueryUserRankingRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"RankingList", "Total"}, new Object[]{null, 0}, YesUserRankingOuterClass$QueryUserRankingRsp.class);
    public final PBRepeatMessageField<YesUserRankingOuterClass$UserRanking> RankingList = PBField.initRepeatMessage(YesUserRankingOuterClass$UserRanking.class);
    public final PBUInt32Field Total = PBField.initUInt32(0);
}
