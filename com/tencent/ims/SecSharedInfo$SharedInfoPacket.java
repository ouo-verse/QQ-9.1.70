package com.tencent.ims;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes7.dex */
public final class SecSharedInfo$SharedInfoPacket extends MessageMicro<SecSharedInfo$SharedInfoPacket> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 50, 58, 64, 74, 82}, new String[]{"version", "type", "bytes_guid", "uint32_appid", "str_sysversion", "str_brand", "str_model", AppConstants.Preferences.QQ_VERSION, "send_info", "file_info"}, new Object[]{0, 1, ByteStringMicro.EMPTY, 0, "", "", "", 0, null, null}, SecSharedInfo$SharedInfoPacket.class);
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBEnumField type = PBField.initEnum(1);
    public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBStringField str_sysversion = PBField.initString("");
    public final PBStringField str_brand = PBField.initString("");
    public final PBStringField str_model = PBField.initString("");
    public final PBUInt32Field qq_version = PBField.initUInt32(0);
    public final PBRepeatMessageField<SecSharedInfo$SendInfo> send_info = PBField.initRepeatMessage(SecSharedInfo$SendInfo.class);
    public SecSharedInfo$FileInfo file_info = new MessageMicro<SecSharedInfo$FileInfo>() { // from class: com.tencent.ims.SecSharedInfo$FileInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"package_name", "soft_name", "cert_md5", "apk_filesize"}, new Object[]{"", "", "", 0}, SecSharedInfo$FileInfo.class);
        public final PBStringField package_name = PBField.initString("");
        public final PBStringField soft_name = PBField.initString("");
        public final PBStringField cert_md5 = PBField.initString("");
        public final PBUInt32Field apk_filesize = PBField.initUInt32(0);
    };
}
