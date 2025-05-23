package com.qzone.proto.share;

import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes39.dex */
public final class ServicePB$CreateShareReq extends MessageMicro<ServicePB$CreateShareReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"info"}, new Object[]{null}, ServicePB$CreateShareReq.class);
    public ServicePB$ShareInfo info = new ServicePB$ShareInfo();
}
