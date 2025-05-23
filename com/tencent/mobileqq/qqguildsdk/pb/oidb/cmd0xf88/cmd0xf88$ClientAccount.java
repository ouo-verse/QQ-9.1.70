package com.tencent.mobileqq.qqguildsdk.pb.oidb.cmd0xf88;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes17.dex */
public final class cmd0xf88$ClientAccount extends MessageMicro<cmd0xf88$ClientAccount> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 56}, new String[]{CommonConstant.ReqAccessTokenParam.CLIENT_ID, "client_name", "account_secret", "account_name", "client_config", "icon", "bind_timestamp"}, new Object[]{0, "", "", "", null, "", 0L}, cmd0xf88$ClientAccount.class);
    public final PBUInt32Field client_id = PBField.initUInt32(0);
    public final PBStringField client_name = PBField.initString("");
    public final PBStringField account_secret = PBField.initString("");
    public final PBStringField account_name = PBField.initString("");
    public cmd0xf88$ClientConfig client_config = new MessageMicro<cmd0xf88$ClientConfig>() { // from class: com.tencent.mobileqq.qqguildsdk.pb.oidb.cmd0xf88.cmd0xf88$ClientConfig
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"show_presence", "show_archive", "items"}, new Object[]{0, 0, null}, cmd0xf88$ClientConfig.class);
        public final PBUInt32Field show_presence = PBField.initUInt32(0);
        public final PBUInt32Field show_archive = PBField.initUInt32(0);
        public final PBRepeatMessageField<cmd0xf88$ConfigItem> items = PBField.initRepeatMessage(cmd0xf88$ConfigItem.class);
    };
    public final PBStringField icon = PBField.initString("");
    public final PBInt64Field bind_timestamp = PBField.initInt64(0);
}
