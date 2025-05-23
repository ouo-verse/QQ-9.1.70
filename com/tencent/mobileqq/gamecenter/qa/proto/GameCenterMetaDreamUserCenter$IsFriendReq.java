package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameCenterMetaDreamUserCenter$IsFriendReq extends MessageMicro<GameCenterMetaDreamUserCenter$IsFriendReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uid", "aio_role_id"}, new Object[]{0L, ""}, GameCenterMetaDreamUserCenter$IsFriendReq.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBStringField aio_role_id = PBField.initString("");
}
