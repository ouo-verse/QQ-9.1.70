package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameCenterMetaDreamUserCenter$IsFriendRsp extends MessageMicro<GameCenterMetaDreamUserCenter$IsFriendRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"is_friend"}, new Object[]{Boolean.FALSE}, GameCenterMetaDreamUserCenter$IsFriendRsp.class);
    public final PBBoolField is_friend = PBField.initBool(false);
}
