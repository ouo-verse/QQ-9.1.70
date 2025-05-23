package com.tencent.icgame.trpc.yes.common;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class ShopOuterClass$GiftNumItem extends MessageMicro<ShopOuterClass$GiftNumItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"text", WidgetCacheConstellationData.NUM}, new Object[]{"", 0}, ShopOuterClass$GiftNumItem.class);
    public final PBStringField text = PBField.initString("");
    public final PBInt32Field num = PBField.initInt32(0);
}
