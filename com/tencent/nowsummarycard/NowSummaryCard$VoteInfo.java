package com.tencent.nowsummarycard;

import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class NowSummaryCard$VoteInfo extends MessageMicro<NowSummaryCard$VoteInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{INearbySPUtil.VOTE_COUNT, "latest_vote_count"}, new Object[]{0, 0}, NowSummaryCard$VoteInfo.class);
    public final PBUInt32Field vote_count = PBField.initUInt32(0);
    public final PBUInt32Field latest_vote_count = PBField.initUInt32(0);
}
