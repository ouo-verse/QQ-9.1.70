package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.transfile.CarrierImgDownloader;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class ConfigurationService$ReqGetConfig extends MessageMicro<ConfigurationService$ReqGetConfig> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cookies;
    public final PBBytesField cookies_new;
    public final PBInt32Field version;
    public final PBRepeatMessageField<ConfigurationService$ConfigSeq> seq_list = PBField.initRepeatMessage(ConfigurationService$ConfigSeq.class);
    public ConfigurationService$DeviceInfo device_info = new ConfigurationService$DeviceInfo();
    public final PBStringField str_info = PBField.initString("");
    public final PBStringField province = PBField.initString("");
    public final PBStringField city = PBField.initString("");
    public final PBUInt64Field adcode = PBField.initUInt64(0);
    public final PBInt32Field int32_lat = PBField.initInt32(900000000);
    public final PBInt32Field int32_lon = PBField.initInt32(900000000);
    public final PBInt32Field carrier = PBField.initInt32(0);
    public final PBRepeatField<String> phone_nos = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField bind_phone_no = PBField.initString("");
    public final PBRepeatField<Integer> carriers = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBInt32Field req_debug_msg = PBField.initInt32(0);
    public final PBInt32Field is_page_req = PBField.initInt32(0);

    static {
        int[] iArr = {10, 18, 26, 34, 42, 48, 56, 64, 72, 82, 90, 96, 104, 808, 818, BusinessInfoCheckUpdateItem.UIAPPID_XINGQU_BULUO, 832};
        String[] strArr = {"seq_list", "device_info", "str_info", "province", "city", "adcode", "int32_lat", "int32_lon", CarrierImgDownloader.PROTOCAL_CARRIER_IMG, "phone_nos", "bind_phone_no", "carriers", "req_debug_msg", "is_page_req", "cookies", "cookies_new", "version"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(iArr, strArr, new Object[]{null, null, "", "", "", 0L, 900000000, 900000000, 0, "", "", 0, 0, 0, byteStringMicro, byteStringMicro, 0}, ConfigurationService$ReqGetConfig.class);
    }

    public ConfigurationService$ReqGetConfig() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.cookies = PBField.initBytes(byteStringMicro);
        this.cookies_new = PBField.initBytes(byteStringMicro);
        this.version = PBField.initInt32(0);
    }
}
