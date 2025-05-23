package com.tencent.trpcprotocol.qqva;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class midasPayCoinb$ProductItem extends MessageMicro<midasPayCoinb$ProductItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"ProductID", "Quantity"}, new Object[]{"", 0}, midasPayCoinb$ProductItem.class);
    public final PBStringField ProductID = PBField.initString("");
    public final PBInt32Field Quantity = PBField.initInt32(0);
}
