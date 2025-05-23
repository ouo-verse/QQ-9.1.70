package com.tencent.ecommerce.repo.proto.ecom.real_name_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECRealNameSvr$User extends MessageMicro<ECRealNameSvr$User> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"id", "name", "id_card"}, new Object[]{"", "", ""}, ECRealNameSvr$User.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f105262id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField id_card = PBField.initString("");
}
