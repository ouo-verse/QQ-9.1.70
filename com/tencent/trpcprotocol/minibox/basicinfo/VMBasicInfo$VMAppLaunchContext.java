package com.tencent.trpcprotocol.minibox.basicinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class VMBasicInfo$VMAppLaunchContext extends MessageMicro<VMBasicInfo$VMAppLaunchContext> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"system_version", "device", "mobileqq_version", "app_id", "app_version"}, new Object[]{"", "", "", "", ""}, VMBasicInfo$VMAppLaunchContext.class);
    public final PBStringField system_version = PBField.initString("");
    public final PBStringField device = PBField.initString("");
    public final PBStringField mobileqq_version = PBField.initString("");
    public final PBStringField app_id = PBField.initString("");
    public final PBStringField app_version = PBField.initString("");
}
