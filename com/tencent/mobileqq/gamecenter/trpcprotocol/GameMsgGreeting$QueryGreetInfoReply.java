package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameMsgGreeting$QueryGreetInfoReply extends MessageMicro<GameMsgGreeting$QueryGreetInfoReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"tendencyDesc", "playDateTimeDesc", "expertAreaDesc", "vistorNum"}, new Object[]{"", "", "", 0}, GameMsgGreeting$QueryGreetInfoReply.class);
    public final PBStringField tendencyDesc = PBField.initString("");
    public final PBStringField playDateTimeDesc = PBField.initString("");
    public final PBStringField expertAreaDesc = PBField.initString("");
    public final PBInt32Field vistorNum = PBField.initInt32(0);
}
