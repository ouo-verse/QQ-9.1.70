package com.tencent.relation.common.security;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class RoomAuth$AuthReq extends MessageMicro<RoomAuth$AuthReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"uid", "need_doc"}, new Object[]{"", Boolean.FALSE}, RoomAuth$AuthReq.class);
    public final PBStringField uid = PBField.initString("");
    public final PBBoolField need_doc = PBField.initBool(false);
}
