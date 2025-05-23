package com.tencent.trpcprotocol.qqva.vipdata.oidbdata;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.trpcprotocol.qqva.vipdata.userdata.userdata$UserData;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class OidbUserData extends MessageMicro<OidbUserData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"vip", "gxh", "vipdata"}, new Object[]{null, null, null}, OidbUserData.class);
    public VipOidbInfo vip = new VipOidbInfo();
    public GxhOidbInfo gxh = new GxhOidbInfo();
    public userdata$UserData vipdata = new userdata$UserData();
}
