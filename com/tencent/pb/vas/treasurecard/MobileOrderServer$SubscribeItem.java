package com.tencent.pb.vas.treasurecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class MobileOrderServer$SubscribeItem extends MessageMicro<MobileOrderServer$SubscribeItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"ProductID", "ProductName"}, new Object[]{"", ""}, MobileOrderServer$SubscribeItem.class);
    public final PBStringField ProductID = PBField.initString("");
    public final PBStringField ProductName = PBField.initString("");
}
