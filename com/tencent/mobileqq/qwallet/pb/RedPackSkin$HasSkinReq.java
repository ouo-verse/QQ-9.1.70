package com.tencent.mobileqq.qwallet.pb;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class RedPackSkin$HasSkinReq extends MessageMicro<RedPackSkin$HasSkinReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48}, new String[]{"uin", "skin_id", "skin_from", "outer_skin_id", WidgetCacheConstellationData.MONEY, "hb_from"}, new Object[]{0L, 0, 0, "", 0L, 0}, RedPackSkin$HasSkinReq.class);
    public final PBInt64Field uin = PBField.initInt64(0);
    public final PBInt32Field skin_id = PBField.initInt32(0);
    public final PBEnumField skin_from = PBField.initEnum(0);
    public final PBStringField outer_skin_id = PBField.initString("");
    public final PBInt64Field money = PBField.initInt64(0);
    public final PBInt32Field hb_from = PBField.initInt32(0);
}
