package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveActivityServerOuterClass$GameCommodityInfo extends MessageMicro<LiveActivityServerOuterClass$GameCommodityInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48}, new String[]{"game_id", "title", "need_value", "remaining_text", "commodity_id", "status"}, new Object[]{0, "", 0, "", 0, 0}, LiveActivityServerOuterClass$GameCommodityInfo.class);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBStringField title = PBField.initString("");
    public final PBInt32Field need_value = PBField.initInt32(0);
    public final PBStringField remaining_text = PBField.initString("");
    public final PBInt32Field commodity_id = PBField.initInt32(0);
    public final PBInt32Field status = PBField.initInt32(0);
}
