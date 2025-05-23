package com.tencent.trpcprotocol.qqva.intimacy;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class IntimacyIdentifierServer$SsoGetUsingItemReq extends MessageMicro<IntimacyIdentifierServer$SsoGetUsingItemReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"appid", "friend_uin"}, new Object[]{0, 0L}, IntimacyIdentifierServer$SsoGetUsingItemReq.class);
    public final PBRepeatField<Integer> appid = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBUInt64Field friend_uin = PBField.initUInt64(0);
}
