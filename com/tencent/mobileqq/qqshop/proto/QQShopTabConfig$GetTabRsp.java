package com.tencent.mobileqq.qqshop.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes17.dex */
public final class QQShopTabConfig$GetTabRsp extends MessageMicro<QQShopTabConfig$GetTabRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"tab_items"}, new Object[]{null}, QQShopTabConfig$GetTabRsp.class);
    public final PBRepeatMessageField<QQShopTabConfig$TabItem> tab_items = PBField.initRepeatMessage(QQShopTabConfig$TabItem.class);
}
