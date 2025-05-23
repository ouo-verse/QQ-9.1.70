package com.tencent.pb.vasreporter;

import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class VasReporter$ReqBody extends MessageMicro<VasReporter$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42}, new String[]{"cmd", "plat", "qqversion", AdParam.OSVERSION, "statis_list"}, new Object[]{0, 0, "", "", null}, VasReporter$ReqBody.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBInt32Field plat = PBField.initInt32(0);
    public final PBStringField qqversion = PBField.initString("");
    public final PBStringField osversion = PBField.initString("");
    public final PBRepeatMessageField<VasReporter$StatisInfo> statis_list = PBField.initRepeatMessage(VasReporter$StatisInfo.class);
}
