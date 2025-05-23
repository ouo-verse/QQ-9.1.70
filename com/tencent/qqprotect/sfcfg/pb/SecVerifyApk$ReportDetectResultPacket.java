package com.tencent.qqprotect.sfcfg.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes25.dex */
public final class SecVerifyApk$ReportDetectResultPacket extends MessageMicro<SecVerifyApk$ReportDetectResultPacket> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122}, new String[]{"uint32_cmd", "uint32_result", "uint32_appid", "str_signature", "str_apkmd5", "str_rsamd5", "str_txsfcfgkmd5", "str_apkversion", "str_channelid", "str_uin", "bytes_guid", "str_sysversion", "str_brand", "str_model", "package_name"}, new Object[]{0, 0, 0, "", "", "", "", "", "", "", ByteStringMicro.EMPTY, "", "", "", ""}, SecVerifyApk$ReportDetectResultPacket.class);
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBStringField str_signature = PBField.initString("");
    public final PBStringField str_apkmd5 = PBField.initString("");
    public final PBStringField str_rsamd5 = PBField.initString("");
    public final PBStringField str_txsfcfgkmd5 = PBField.initString("");
    public final PBStringField str_apkversion = PBField.initString("");
    public final PBStringField str_channelid = PBField.initString("");
    public final PBStringField str_uin = PBField.initString("");
    public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_sysversion = PBField.initString("");
    public final PBStringField str_brand = PBField.initString("");
    public final PBStringField str_model = PBField.initString("");
    public final PBStringField package_name = PBField.initString("");
}
