package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes10.dex */
public final class ConfigurationService$ReqGetConfigByPage extends MessageMicro<ConfigurationService$ReqGetConfigByPage> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40}, new String[]{"type", "page_info", "device_info", "adcode", "stagger_version"}, new Object[]{0, null, null, 0L, 0}, ConfigurationService$ReqGetConfigByPage.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public ConfigurationService$PageReqInfo page_info = new ConfigurationService$PageReqInfo();
    public ConfigurationService$DeviceInfo device_info = new ConfigurationService$DeviceInfo();
    public final PBUInt64Field adcode = PBField.initUInt64(0);
    public final PBUInt32Field stagger_version = PBField.initUInt32(0);
}
