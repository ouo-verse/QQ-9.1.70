package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class ConfigurationService$DeviceInfo extends MessageMicro<ConfigurationService$DeviceInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66}, new String[]{"brand", "model", "os", "cpu", "memory", QQPermissionConstants.Permission.STORAGE_GROUP, "screen", "camera"}, new Object[]{"", "", null, null, null, null, null, null}, ConfigurationService$DeviceInfo.class);
    public final PBStringField brand = PBField.initString("");
    public final PBStringField model = PBField.initString("");

    /* renamed from: os, reason: collision with root package name */
    public ConfigurationService$OS f202980os = new ConfigurationService$OS();
    public ConfigurationService$CPU cpu = new ConfigurationService$CPU();
    public ConfigurationService$Memory memory = new ConfigurationService$Memory();
    public ConfigurationService$Storage storage = new ConfigurationService$Storage();
    public ConfigurationService$Screen screen = new ConfigurationService$Screen();

    /* renamed from: camera, reason: collision with root package name */
    public ConfigurationService$Camera f202979camera = new ConfigurationService$Camera();
}
