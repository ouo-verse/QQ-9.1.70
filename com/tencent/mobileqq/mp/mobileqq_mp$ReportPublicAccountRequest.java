package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;

/* loaded from: classes15.dex */
public final class mobileqq_mp$ReportPublicAccountRequest extends MessageMicro<mobileqq_mp$ReportPublicAccountRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 56, 64, 74, 82, 90, 98}, new String[]{"tag", "mainAction", "toUin", "subAction", "actionName", IProfileCardConst.KEY_FROM_TYPE, "count", "result", "r2", "r3", "r4", "r5"}, new Object[]{"", "", "", "", "", 0, 0, 0, "", "", "", ""}, mobileqq_mp$ReportPublicAccountRequest.class);
    public final PBStringField tag = PBField.initString("");
    public final PBStringField mainAction = PBField.initString("");
    public final PBStringField toUin = PBField.initString("");
    public final PBStringField subAction = PBField.initString("");
    public final PBStringField actionName = PBField.initString("");
    public final PBUInt32Field fromType = PBField.initUInt32(0);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBUInt32Field result = PBField.initUInt32(0);

    /* renamed from: r2, reason: collision with root package name */
    public final PBStringField f247284r2 = PBField.initString("");

    /* renamed from: r3, reason: collision with root package name */
    public final PBStringField f247285r3 = PBField.initString("");

    /* renamed from: r4, reason: collision with root package name */
    public final PBStringField f247286r4 = PBField.initString("");

    /* renamed from: r5, reason: collision with root package name */
    public final PBRepeatField<String> f247287r5 = PBField.initRepeat(PBStringField.__repeatHelper__);
}
