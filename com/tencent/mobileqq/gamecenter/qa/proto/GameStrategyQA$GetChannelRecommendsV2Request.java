package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$GetChannelRecommendsV2Request extends MessageMicro<GameStrategyQA$GetChannelRecommendsV2Request> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 50}, new String[]{"appid", "page", "tag", "size", "view_sign"}, new Object[]{0, 0L, 0L, 0L, ""}, GameStrategyQA$GetChannelRecommendsV2Request.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBInt64Field page = PBField.initInt64(0);
    public final PBInt64Field tag = PBField.initInt64(0);
    public final PBInt64Field size = PBField.initInt64(0);
    public final PBStringField view_sign = PBField.initString("");
}
