package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$ABTestControlMsgRequest extends MessageMicro<mobileqq_mp$ABTestControlMsgRequest> {
    public static final int ABTEST_GUANLIZHONGXIN = 2;
    public static final int ABTEST_SUBSCRIBE = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"versionInfo", "testType"}, new Object[]{"", 1}, mobileqq_mp$ABTestControlMsgRequest.class);
    public final PBStringField versionInfo = PBField.initString("");
    public final PBEnumField testType = PBField.initEnum(1);
}
