package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameCookieInfo$GetUserSessionReq extends MessageMicro<GameCookieInfo$GetUserSessionReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"url"}, new Object[]{""}, GameCookieInfo$GetUserSessionReq.class);
    public final PBStringField url = PBField.initString("");
}
