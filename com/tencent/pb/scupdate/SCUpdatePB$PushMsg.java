package com.tencent.pb.scupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes22.dex */
public final class SCUpdatePB$PushMsg extends MessageMicro<SCUpdatePB$PushMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"update_items"}, new Object[]{null}, SCUpdatePB$PushMsg.class);
    public final PBRepeatMessageField<SCUpdatePB$Item> update_items = PBField.initRepeatMessage(SCUpdatePB$Item.class);
}
