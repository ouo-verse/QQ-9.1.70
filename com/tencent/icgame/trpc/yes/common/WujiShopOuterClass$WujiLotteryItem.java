package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WujiShopOuterClass$WujiLotteryItem extends MessageMicro<WujiShopOuterClass$WujiLotteryItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48, 58, 64}, new String[]{"id", "reward_id", "reward_name", "reward_tips_title", "reward_tips_text", "probability", "reward_img", "reward_num_limit"}, new Object[]{0, 0, "", "", "", 0, "", 0}, WujiShopOuterClass$WujiLotteryItem.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBInt32Field f116210id = PBField.initInt32(0);
    public final PBInt32Field reward_id = PBField.initInt32(0);
    public final PBStringField reward_name = PBField.initString("");
    public final PBStringField reward_tips_title = PBField.initString("");
    public final PBStringField reward_tips_text = PBField.initString("");
    public final PBInt32Field probability = PBField.initInt32(0);
    public final PBStringField reward_img = PBField.initString("");
    public final PBInt32Field reward_num_limit = PBField.initInt32(0);
}
