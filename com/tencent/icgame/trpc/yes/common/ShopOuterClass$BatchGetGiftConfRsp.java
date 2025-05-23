package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class ShopOuterClass$BatchGetGiftConfRsp extends MessageMicro<ShopOuterClass$BatchGetGiftConfRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"gift_conf_list", "gift_tag_conf_list"}, new Object[]{null, null}, ShopOuterClass$BatchGetGiftConfRsp.class);
    public ShopOuterClass$GiftConfList gift_conf_list = new ShopOuterClass$GiftConfList();
    public ShopOuterClass$GiftTagConfList gift_tag_conf_list = new ShopOuterClass$GiftTagConfList();
}
