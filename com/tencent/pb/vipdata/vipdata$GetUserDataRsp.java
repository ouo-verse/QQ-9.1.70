package com.tencent.pb.vipdata;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class vipdata$GetUserDataRsp extends MessageMicro<vipdata$GetUserDataRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"info"}, new Object[]{null}, vipdata$GetUserDataRsp.class);
    public final PBRepeatMessageField<vipdata$UserInfo> info = PBField.initRepeatMessage(vipdata$UserInfo.class);
}
