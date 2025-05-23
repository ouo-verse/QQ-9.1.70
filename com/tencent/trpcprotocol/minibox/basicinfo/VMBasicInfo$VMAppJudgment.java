package com.tencent.trpcprotocol.minibox.basicinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class VMBasicInfo$VMAppJudgment extends MessageMicro<VMBasicInfo$VMAppJudgment> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"app_context", "is_blocked", "update_time"}, new Object[]{null, Boolean.FALSE, 0L}, VMBasicInfo$VMAppJudgment.class);
    public VMBasicInfo$VMAppLaunchContext app_context = new VMBasicInfo$VMAppLaunchContext();
    public final PBBoolField is_blocked = PBField.initBool(false);
    public final PBInt64Field update_time = PBField.initInt64(0);
}
