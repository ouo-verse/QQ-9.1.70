package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class ShopOuterClass$BatchGetGiftConfReq extends MessageMicro<ShopOuterClass$BatchGetGiftConfReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"gift_id", "tag_id"}, new Object[]{0, 0}, ShopOuterClass$BatchGetGiftConfReq.class);
    public final PBRepeatField<Integer> gift_id;
    public final PBRepeatField<Integer> tag_id;

    public ShopOuterClass$BatchGetGiftConfReq() {
        PBUInt32Field pBUInt32Field = PBUInt32Field.__repeatHelper__;
        this.gift_id = PBField.initRepeat(pBUInt32Field);
        this.tag_id = PBField.initRepeat(pBUInt32Field);
    }
}
