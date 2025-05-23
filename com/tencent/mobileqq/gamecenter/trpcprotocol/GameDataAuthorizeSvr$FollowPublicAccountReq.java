package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes12.dex */
public final class GameDataAuthorizeSvr$FollowPublicAccountReq extends MessageMicro<GameDataAuthorizeSvr$FollowPublicAccountReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"source", "appid", "account_type"}, new Object[]{"", 0, 0}, GameDataAuthorizeSvr$FollowPublicAccountReq.class);
    public final PBStringField source = PBField.initString("");
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBEnumField account_type = PBField.initEnum(0);
}
