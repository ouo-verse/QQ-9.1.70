package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$JuBaoGetUserInfoReq extends MessageMicro<userInfo$JuBaoGetUserInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uin"}, new Object[]{0L}, userInfo$JuBaoGetUserInfoReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
}
