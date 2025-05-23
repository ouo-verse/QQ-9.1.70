package com.tencent.pb.vasreporter;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class VasReporter$StatisInfo extends MessageMicro<VasReporter$StatisInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 29, 32, 42}, new String[]{"appid", "key_list", "value_list", "ts", "msg"}, new Object[]{"", "", Float.valueOf(0.0f), 0L, ""}, VasReporter$StatisInfo.class);
    public final PBStringField appid = PBField.initString("");
    public final PBRepeatField<String> key_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatField<Float> value_list = PBField.initRepeat(PBFloatField.__repeatHelper__);

    /* renamed from: ts, reason: collision with root package name */
    public final PBInt64Field f342177ts = PBField.initInt64(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f342176msg = PBField.initString("");
}
