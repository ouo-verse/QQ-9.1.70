package com.tencent.mobileqq.sharepanel.repo.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes18.dex */
public final class ServicePB$BusiErr extends MessageMicro<ServicePB$BusiErr> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"code", "msg"}, new Object[]{0, ""}, ServicePB$BusiErr.class);
    public final PBInt32Field code = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f287582msg = PBField.initString("");
}
