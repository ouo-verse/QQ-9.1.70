package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class CloudGameServerOuterClass$CloudGameCreateSessionReq extends MessageMicro<CloudGameServerOuterClass$CloudGameCreateSessionReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uid", "client_session"}, new Object[]{0L, ""}, CloudGameServerOuterClass$CloudGameCreateSessionReq.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBStringField client_session = PBField.initString("");
}
