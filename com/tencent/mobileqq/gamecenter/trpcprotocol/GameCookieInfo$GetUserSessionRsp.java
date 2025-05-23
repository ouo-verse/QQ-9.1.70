package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import cooperation.qzone.remote.ServiceConst;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameCookieInfo$GetUserSessionRsp extends MessageMicro<GameCookieInfo$GetUserSessionRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{RemoteMessageConst.TTL, ServiceConst.PARA_SESSION_ID, SessionDbHelper.SESSION_ID}, new Object[]{0L, "", null}, GameCookieInfo$GetUserSessionRsp.class);
    public final PBInt64Field ttl = PBField.initInt64(0);
    public final PBStringField session_id = PBField.initString("");
    public final PBRepeatMessageField<GameCookieInfo$SessionItem> session = PBField.initRepeatMessage(GameCookieInfo$SessionItem.class);
}
