package com.tencent.pb.vipdata;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class userdata$Item extends MessageMicro<userdata$Item> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"appid", "itemid"}, new Object[]{0, 0}, userdata$Item.class);
    public final PBInt32Field appid = PBField.initInt32(0);
    public final PBInt32Field itemid = PBField.initInt32(0);
}
