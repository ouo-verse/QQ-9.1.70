package com.tencent.trpcprotocol.zplan.user_info_ext.user_info_ext;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class userInfoExt$ExtInfo extends MessageMicro<userInfoExt$ExtInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, userInfoExt$ExtInfo.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
}
