package com.tencent.trpcprotocol.minigame.oidb_proxy.s2c_content;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class s2cContent$SparkRewardNotify extends MessageMicro<s2cContent$SparkRewardNotify> {
    public static final int LIMIT = 2;
    public static final int REWARD = 1;
    public static final int UNKNOWN = 0;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"type", "appid", "title", "sub_title", "icon_url"}, new Object[]{0, "", "", "", ""}, s2cContent$SparkRewardNotify.class);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField sub_title = PBField.initString("");
    public final PBStringField icon_url = PBField.initString("");
}
