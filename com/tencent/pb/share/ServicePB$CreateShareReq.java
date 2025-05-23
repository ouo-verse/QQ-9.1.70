package com.tencent.pb.share;

import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes22.dex */
public final class ServicePB$CreateShareReq extends MessageMicro<ServicePB$CreateShareReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"info"}, new Object[]{null}, ServicePB$CreateShareReq.class);
    public ServicePB$ShareInfo info = new ServicePB$ShareInfo();
}
