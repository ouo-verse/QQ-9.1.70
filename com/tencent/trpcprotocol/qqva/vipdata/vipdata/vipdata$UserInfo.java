package com.tencent.trpcprotocol.qqva.vipdata.vipdata;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.trpcprotocol.qqva.vipdata.userdata.userdata$UserData;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class vipdata$UserInfo extends MessageMicro<vipdata$UserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uin", "data"}, new Object[]{0L, null}, vipdata$UserInfo.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public userdata$UserData data = new userdata$UserData();
}
