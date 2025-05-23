package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes6.dex */
public final class MonitReport$PublicAccountReq extends MessageMicro<MonitReport$PublicAccountReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40}, new String[]{"msgid", "action", "url", "ts", "taskid"}, new Object[]{0L, 0, "", 0L, 0L}, MonitReport$PublicAccountReq.class);
    public final PBUInt64Field msgid = PBField.initUInt64(0);
    public final PBUInt32Field action = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");

    /* renamed from: ts, reason: collision with root package name */
    public final PBUInt64Field f106728ts = PBField.initUInt64(0);
    public final PBUInt64Field taskid = PBField.initUInt64(0);
}
