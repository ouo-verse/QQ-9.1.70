package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes7.dex */
public final class ClientInfoB$ReportDetectResultPacket extends MessageMicro<ClientInfoB$ReportDetectResultPacket> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_buffer;
    public final PBBytesField bytes_buffer2;
    public final PBStringField str_safemd5;
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public ClientInfoB$EnvParamPacket envParam = new MessageMicro<ClientInfoB$EnvParamPacket>() { // from class: com.tencent.ims.ClientInfoB$EnvParamPacket
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50, 58}, new String[]{"u32_platform", "str_sysversion", "u32_appid", "str_uin", "str_qqversion", "str_safeversion", "bytes_guid"}, new Object[]{0, "", 0, "", "", "", ByteStringMicro.EMPTY}, ClientInfoB$EnvParamPacket.class);
        public final PBUInt32Field u32_platform = PBField.initUInt32(0);
        public final PBStringField str_sysversion = PBField.initString("");
        public final PBUInt32Field u32_appid = PBField.initUInt32(0);
        public final PBStringField str_uin = PBField.initString("");
        public final PBStringField str_qqversion = PBField.initString("");
        public final PBStringField str_safeversion = PBField.initString("");
        public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
    };

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"uint32_cmd", "envParam", "bytes_buffer", "bytes_buffer2", "str_safemd5"}, new Object[]{0, null, byteStringMicro, byteStringMicro, ""}, ClientInfoB$ReportDetectResultPacket.class);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.tencent.ims.ClientInfoB$EnvParamPacket] */
    public ClientInfoB$ReportDetectResultPacket() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_buffer = PBField.initBytes(byteStringMicro);
        this.bytes_buffer2 = PBField.initBytes(byteStringMicro);
        this.str_safemd5 = PBField.initString("");
    }
}
