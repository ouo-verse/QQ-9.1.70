package com.tencent.trpcprotocol.minibox.basicinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class VMBasicInfo$VMAppJudgmentRecord extends MessageMicro<VMBasicInfo$VMAppJudgmentRecord> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"app_context", "modify_status", JsonRuleKey.OPERATOR, "modify_time"}, new Object[]{null, 0, "", 0L}, VMBasicInfo$VMAppJudgmentRecord.class);
    public VMBasicInfo$VMAppLaunchContext app_context = new VMBasicInfo$VMAppLaunchContext();
    public final PBEnumField modify_status = PBField.initEnum(0);
    public final PBStringField operator = PBField.initString("");
    public final PBInt64Field modify_time = PBField.initInt64(0);
}
