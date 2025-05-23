package com.tencent.pb.vipdata;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class vipdata$UserInfo extends MessageMicro<vipdata$UserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uin", "data"}, new Object[]{0L, null}, vipdata$UserInfo.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public userdata$UserData data = new userdata$UserData();
}
