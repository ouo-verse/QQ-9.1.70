package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* loaded from: classes12.dex */
public final class GameStrategyQA$PullGamesRequest extends MessageMicro<GameStrategyQA$PullGamesRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"page", "size"}, new Object[]{0L, 0L}, GameStrategyQA$PullGamesRequest.class);
    public final PBInt64Field page = PBField.initInt64(0);
    public final PBInt64Field size = PBField.initInt64(0);
}
