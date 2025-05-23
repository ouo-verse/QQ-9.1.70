package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$GroupInfo extends MessageMicro<mobileqq_mp$GroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"id", "name", "flag"}, new Object[]{0, "", 0}, mobileqq_mp$GroupInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f247283id = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBUInt32Field flag = PBField.initUInt32(0);
}
