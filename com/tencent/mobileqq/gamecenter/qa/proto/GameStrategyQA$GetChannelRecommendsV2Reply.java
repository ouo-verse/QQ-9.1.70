package com.tencent.mobileqq.gamecenter.qa.proto;

import com.huawei.hms.common.data.DataBufferUtils;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$GetChannelRecommendsV2Reply extends MessageMicro<GameStrategyQA$GetChannelRecommendsV2Reply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"recommends", DataBufferUtils.NEXT_PAGE, "is_over", "total_num"}, new Object[]{null, 0L, Boolean.FALSE, 0L}, GameStrategyQA$GetChannelRecommendsV2Reply.class);
    public final PBRepeatMessageField<GameStrategyQA$FeedsCard> recommends = PBField.initRepeatMessage(GameStrategyQA$FeedsCard.class);
    public final PBInt64Field next_page = PBField.initInt64(0);
    public final PBBoolField is_over = PBField.initBool(false);
    public final PBInt64Field total_num = PBField.initInt64(0);
}
