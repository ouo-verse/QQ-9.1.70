package com.tencent.mobileqq.qqecommerce.repo.pbfile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class sellerMsgConfig$GetUserSettingsRsp extends MessageMicro<sellerMsgConfig$GetUserSettingsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"items"}, new Object[]{null}, sellerMsgConfig$GetUserSettingsRsp.class);
    public final PBRepeatMessageField<sellerMsgConfig$MsgTypeItem> items = PBField.initRepeatMessage(sellerMsgConfig$MsgTypeItem.class);
}
