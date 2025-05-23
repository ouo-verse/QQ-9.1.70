package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class AppMsg$Request extends MessageMicro<AppMsg$Request> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"data"}, new Object[]{""}, AppMsg$Request.class);
    public final PBStringField data = PBField.initString("");
}
