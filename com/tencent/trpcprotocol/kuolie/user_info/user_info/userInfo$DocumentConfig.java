package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$DocumentConfig extends MessageMicro<userInfo$DocumentConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"title", "body", "tips", "window_type"}, new Object[]{"", "", "", 0}, userInfo$DocumentConfig.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField body = PBField.initString("");
    public final PBStringField tips = PBField.initString("");
    public final PBUInt32Field window_type = PBField.initUInt32(0);
}
