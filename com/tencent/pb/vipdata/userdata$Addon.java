package com.tencent.pb.vipdata;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class userdata$Addon extends MessageMicro<userdata$Addon> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"itemid", "islogo"}, new Object[]{0, Boolean.FALSE}, userdata$Addon.class);
    public final PBInt32Field itemid = PBField.initInt32(0);
    public final PBBoolField islogo = PBField.initBool(false);
}
