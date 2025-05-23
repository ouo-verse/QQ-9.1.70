package com.tencent.trpcprotocol.minibox.basicinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class VMBasicInfo$ModifyVMAppJudgmentReq extends MessageMicro<VMBasicInfo$ModifyVMAppJudgmentReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"app_context", "should_block"}, new Object[]{null, Boolean.FALSE}, VMBasicInfo$ModifyVMAppJudgmentReq.class);
    public VMBasicInfo$VMAppLaunchContext app_context = new VMBasicInfo$VMAppLaunchContext();
    public final PBBoolField should_block = PBField.initBool(false);
}
