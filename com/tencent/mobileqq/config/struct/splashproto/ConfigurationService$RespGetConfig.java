package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class ConfigurationService$RespGetConfig extends MessageMicro<ConfigurationService$RespGetConfig> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cookies;
    public final PBBytesField cookies_new;
    public final PBUInt32Field min_req_interval_for_reconnect;
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBRepeatMessageField<ConfigurationService$Config> config_list = PBField.initRepeatMessage(ConfigurationService$Config.class);
    public final PBRepeatField<String> debug_msg_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatField<Integer> next_req_types = PBField.initRepeat(PBInt32Field.__repeatHelper__);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 802, 808, 818}, new String[]{"result", "config_list", "debug_msg_list", "next_req_types", "cookies", "min_req_interval_for_reconnect", "cookies_new"}, new Object[]{0, null, "", 0, byteStringMicro, 0, byteStringMicro}, ConfigurationService$RespGetConfig.class);
    }

    public ConfigurationService$RespGetConfig() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.cookies = PBField.initBytes(byteStringMicro);
        this.min_req_interval_for_reconnect = PBField.initUInt32(0);
        this.cookies_new = PBField.initBytes(byteStringMicro);
    }
}
