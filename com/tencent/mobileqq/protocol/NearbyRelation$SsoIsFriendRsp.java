package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class NearbyRelation$SsoIsFriendRsp extends MessageMicro<NearbyRelation$SsoIsFriendRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"ret_code", "ret_msg", "is_friend", "is_friend_list"}, new Object[]{0, "", "", 0}, NearbyRelation$SsoIsFriendRsp.class);
    public final PBEnumField ret_code = PBField.initEnum(0);
    public final PBStringField ret_msg = PBField.initString("");
    public final PBStringField is_friend = PBField.initString("");
    public final PBRepeatField<Integer> is_friend_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
