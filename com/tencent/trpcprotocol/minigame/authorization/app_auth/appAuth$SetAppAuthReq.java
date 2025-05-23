package com.tencent.trpcprotocol.minigame.authorization.app_auth;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class appAuth$SetAppAuthReq extends MessageMicro<appAuth$SetAppAuthReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"appid", "type", "state"}, new Object[]{"", 0, 0}, appAuth$SetAppAuthReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBInt32Field state = PBField.initInt32(0);
}
