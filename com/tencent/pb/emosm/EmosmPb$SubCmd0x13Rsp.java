package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes22.dex */
public final class EmosmPb$SubCmd0x13Rsp extends MessageMicro<EmosmPb$SubCmd0x13Rsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"itemlist"}, new Object[]{null}, EmosmPb$SubCmd0x13Rsp.class);
    public final PBRepeatMessageField<EmosmPb$SmallYellowItem> itemlist = PBField.initRepeatMessage(EmosmPb$SmallYellowItem.class);
}
