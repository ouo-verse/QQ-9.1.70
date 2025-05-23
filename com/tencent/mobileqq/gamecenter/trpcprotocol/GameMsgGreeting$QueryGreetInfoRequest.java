package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameMsgGreeting$QueryGreetInfoRequest extends MessageMicro<GameMsgGreeting$QueryGreetInfoRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42}, new String[]{"openid", GdtGetUserInfoHandler.KEY_AREA, "partition", "platid", "appid"}, new Object[]{"", 0, 0, 0, ""}, GameMsgGreeting$QueryGreetInfoRequest.class);
    public final PBStringField openid = PBField.initString("");
    public final PBInt32Field area = PBField.initInt32(0);
    public final PBInt32Field partition = PBField.initInt32(0);
    public final PBInt32Field platid = PBField.initInt32(0);
    public final PBStringField appid = PBField.initString("");
}
