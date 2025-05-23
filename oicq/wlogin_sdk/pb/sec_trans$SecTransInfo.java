package oicq.wlogin_sdk.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class sec_trans$SecTransInfo extends MessageMicro<sec_trans$SecTransInfo> {
    public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 58}, new String[]{"str_phone_brand", "str_model_type", "str_wifi_mac", "str_bssid", "str_os_language", "uint32_qq_language", "str_gps_location"}, new Object[]{"", "", "", "", "", 0, ""}, sec_trans$SecTransInfo.class);
    public final PBStringField str_phone_brand = PBField.initString("");
    public final PBStringField str_model_type = PBField.initString("");
    public final PBStringField str_wifi_mac = PBField.initString("");
    public final PBStringField str_bssid = PBField.initString("");
    public final PBStringField str_os_language = PBField.initString("");
    public final PBUInt32Field uint32_qq_language = PBField.initUInt32(0);
    public final PBStringField str_gps_location = PBField.initString("");
}
