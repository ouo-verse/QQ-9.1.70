package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameMsgGreeting$GreetReply extends MessageMicro<GameMsgGreeting$GreetReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"msg", "retCode"}, new Object[]{"", 0}, GameMsgGreeting$GreetReply.class);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f213225msg = PBField.initString("");
    public final PBInt32Field retCode = PBField.initInt32(0);
}
