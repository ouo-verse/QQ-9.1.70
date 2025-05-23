package com.tencent.trpcprotocol.minibox.basicinfo;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class VMBasicInfo$IsVMAppBlockedReq extends MessageMicro<VMBasicInfo$IsVMAppBlockedReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"app_context"}, new Object[]{null}, VMBasicInfo$IsVMAppBlockedReq.class);
    public VMBasicInfo$VMAppLaunchContext app_context = new VMBasicInfo$VMAppLaunchContext();
}
