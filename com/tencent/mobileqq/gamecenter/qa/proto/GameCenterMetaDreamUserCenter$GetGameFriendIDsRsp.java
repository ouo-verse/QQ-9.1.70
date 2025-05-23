package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.mini.servlet.GetCMShowInfoServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameCenterMetaDreamUserCenter$GetGameFriendIDsRsp extends MessageMicro<GameCenterMetaDreamUserCenter$GetGameFriendIDsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{GetCMShowInfoServlet.EXTRA_OPENID}, new Object[]{""}, GameCenterMetaDreamUserCenter$GetGameFriendIDsRsp.class);
    public final PBRepeatField<String> openids = PBField.initRepeat(PBStringField.__repeatHelper__);
}
