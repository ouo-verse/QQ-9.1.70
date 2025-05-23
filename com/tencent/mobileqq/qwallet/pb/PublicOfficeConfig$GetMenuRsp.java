package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes16.dex */
public final class PublicOfficeConfig$GetMenuRsp extends MessageMicro<PublicOfficeConfig$GetMenuRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"menu"}, new Object[]{null}, PublicOfficeConfig$GetMenuRsp.class);
    public final PBRepeatMessageField<PublicOfficeConfig$MenuItem> menu = PBField.initRepeatMessage(PublicOfficeConfig$MenuItem.class);
}
