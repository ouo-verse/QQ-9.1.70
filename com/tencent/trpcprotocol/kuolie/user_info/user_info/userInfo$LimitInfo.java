package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$LimitInfo extends MessageMicro<userInfo$LimitInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField limit_gender = PBField.initBool(false);
    public final PBBoolField limit_birth = PBField.initBool(false);
    public final PBStringField open_id = PBField.initString("");

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"limit_gender", "limit_birth", "open_id"}, new Object[]{bool, bool, ""}, userInfo$LimitInfo.class);
    }
}
