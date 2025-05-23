package com.tencent.trpcprotocol.minigame.terms_of_service.terms_of_service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class SignToSReq extends MessageMicro<SignToSReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"tos", "is_subscribe"}, new Object[]{null, Boolean.FALSE}, SignToSReq.class);
    public ToSInfo tos = new ToSInfo();
    public final PBBoolField is_subscribe = PBField.initBool(false);
}
