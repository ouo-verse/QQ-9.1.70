package com.tencent.trpcprotocol.minigame.terms_of_service.terms_of_service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class QueryToSRsp extends MessageMicro<QueryToSRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField is_compulsory = PBField.initBool(false);
    public ToSInfo tos = new ToSInfo();
    public final PBBoolField is_subscribe = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"is_compulsory", "tos", "is_subscribe"}, new Object[]{bool, null, bool}, QueryToSRsp.class);
    }
}
