package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$OpaqueObj extends MessageMicro<userInfo$OpaqueObj> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uin", "sync_from_qq", "pic_wall_url"}, new Object[]{0L, Boolean.FALSE, ""}, userInfo$OpaqueObj.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBBoolField sync_from_qq = PBField.initBool(false);
    public final PBStringField pic_wall_url = PBField.initString("");
}
