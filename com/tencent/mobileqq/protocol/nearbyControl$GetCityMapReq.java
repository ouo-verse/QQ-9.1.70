package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class nearbyControl$GetCityMapReq extends MessageMicro<nearbyControl$GetCityMapReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"md5"}, new Object[]{""}, nearbyControl$GetCityMapReq.class);
    public final PBStringField md5 = PBField.initString("");
}
