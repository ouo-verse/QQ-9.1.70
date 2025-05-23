package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameMsgGreeting$GreetRequest extends MessageMicro<GameMsgGreeting$GreetRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 42}, new String[]{"appid", "scene"}, new Object[]{"", ""}, GameMsgGreeting$GreetRequest.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField scene = PBField.initString("");
}
