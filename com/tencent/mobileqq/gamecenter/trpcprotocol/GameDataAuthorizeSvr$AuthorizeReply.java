package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameDataAuthorizeSvr$AuthorizeReply extends MessageMicro<GameDataAuthorizeSvr$AuthorizeReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"authoritys"}, new Object[]{null}, GameDataAuthorizeSvr$AuthorizeReply.class);
    public final PBRepeatMessageField<GameDataAuthorizeSvr$Authorization> authoritys = PBField.initRepeatMessage(GameDataAuthorizeSvr$Authorization.class);
}
