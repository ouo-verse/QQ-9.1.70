package com.tencent.mobileqq.gamecenter.qa.proto;

import com.huawei.hms.common.data.DataBufferUtils;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes12.dex */
public final class GameStrategyQA$PullGamesReply extends MessageMicro<GameStrategyQA$PullGamesReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"games", DataBufferUtils.NEXT_PAGE, "is_over"}, new Object[]{null, 0L, Boolean.FALSE}, GameStrategyQA$PullGamesReply.class);
    public final PBRepeatMessageField<GameStrategyQA$GameInfo> games = PBField.initRepeatMessage(GameStrategyQA$GameInfo.class);
    public final PBInt64Field next_page = PBField.initInt64(0);
    public final PBBoolField is_over = PBField.initBool(false);
}
