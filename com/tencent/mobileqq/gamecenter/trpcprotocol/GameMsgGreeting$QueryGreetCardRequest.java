package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameMsgGreeting$QueryGreetCardRequest extends MessageMicro<GameMsgGreeting$QueryGreetCardRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50, 58}, new String[]{"fromOpenid", "toOpenid", GdtGetUserInfoHandler.KEY_AREA, "partition", "platid", "appid", "scene"}, new Object[]{"", "", 0, 0, 0, "", ""}, GameMsgGreeting$QueryGreetCardRequest.class);
    public final PBStringField fromOpenid = PBField.initString("");
    public final PBStringField toOpenid = PBField.initString("");
    public final PBInt32Field area = PBField.initInt32(0);
    public final PBInt32Field partition = PBField.initInt32(0);
    public final PBInt32Field platid = PBField.initInt32(0);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField scene = PBField.initString("");
}
