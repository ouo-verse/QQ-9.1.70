package com.tencent.trpcprotocol.minigame.terms_of_service.terms_of_service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class QueryToSReq extends MessageMicro<QueryToSReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"appid"}, new Object[]{""}, QueryToSReq.class);
    public final PBStringField appid = PBField.initString("");
}
