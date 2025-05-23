package com.tencent.mobileqq.qqecommerce.repo.pbfile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class sellerMsgConfig$GetTabsRsp extends MessageMicro<sellerMsgConfig$GetTabsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"items"}, new Object[]{null}, sellerMsgConfig$GetTabsRsp.class);
    public final PBRepeatMessageField<sellerMsgConfig$TabItem> items = PBField.initRepeatMessage(sellerMsgConfig$TabItem.class);
}
