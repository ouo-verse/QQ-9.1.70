package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class ShopOuterClass$GiftConfList extends MessageMicro<ShopOuterClass$GiftConfList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"data"}, new Object[]{null}, ShopOuterClass$GiftConfList.class);
    public final PBRepeatMessageField<ShopOuterClass$GiftConf> data = PBField.initRepeatMessage(ShopOuterClass$GiftConf.class);
}
