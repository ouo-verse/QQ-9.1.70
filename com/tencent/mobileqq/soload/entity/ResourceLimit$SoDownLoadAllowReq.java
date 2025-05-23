package com.tencent.mobileqq.soload.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class ResourceLimit$SoDownLoadAllowReq extends MessageMicro<ResourceLimit$SoDownLoadAllowReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"resource_url"}, new Object[]{""}, ResourceLimit$SoDownLoadAllowReq.class);
    public final PBStringField resource_url = PBField.initString("");
}
