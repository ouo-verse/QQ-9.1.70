package com.tencent.mobileqq.qqshop.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes17.dex */
public final class QQShopPAMenuPB$GetBottomMenuRsp extends MessageMicro<QQShopPAMenuPB$GetBottomMenuRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"menu", "next_period"}, new Object[]{null, 0L}, QQShopPAMenuPB$GetBottomMenuRsp.class);
    public final PBRepeatMessageField<QQShopPAMenuPB$MenuItem> menu = PBField.initRepeatMessage(QQShopPAMenuPB$MenuItem.class);
    public final PBInt64Field next_period = PBField.initInt64(0);
}
