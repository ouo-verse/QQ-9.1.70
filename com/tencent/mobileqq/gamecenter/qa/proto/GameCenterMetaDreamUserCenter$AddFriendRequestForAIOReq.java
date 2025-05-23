package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameCenterMetaDreamUserCenter$AddFriendRequestForAIOReq extends MessageMicro<GameCenterMetaDreamUserCenter$AddFriendRequestForAIOReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"to_openid", "to_aio_role_id"}, new Object[]{"", ""}, GameCenterMetaDreamUserCenter$AddFriendRequestForAIOReq.class);
    public final PBStringField to_openid = PBField.initString("");
    public final PBStringField to_aio_role_id = PBField.initString("");
}
