package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes7.dex */
public final class ClientInfoA$ReportDetectResultPacket extends MessageMicro<ClientInfoA$ReportDetectResultPacket> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_buffer;
    public final PBBytesField bytes_buffer2;
    public final PBStringField str_qqmd5;
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public ClientInfoA$EnvParamPacket envParam = new MessageMicro<ClientInfoA$EnvParamPacket>() { // from class: com.tencent.ims.ClientInfoA$EnvParamPacket
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50}, new String[]{"u32_platform", "str_sysversion", "str_qqversion", "u32_appid", "bytes_guid", "str_uin"}, new Object[]{0, "", "", 0, ByteStringMicro.EMPTY, ""}, ClientInfoA$EnvParamPacket.class);
        public final PBUInt32Field u32_platform = PBField.initUInt32(0);
        public final PBStringField str_sysversion = PBField.initString("");
        public final PBStringField str_qqversion = PBField.initString("");
        public final PBUInt32Field u32_appid = PBField.initUInt32(0);
        public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBStringField str_uin = PBField.initString("");
    };

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"uint32_cmd", "envParam", "bytes_buffer", "bytes_buffer2", "str_qqmd5"}, new Object[]{0, null, byteStringMicro, byteStringMicro, ""}, ClientInfoA$ReportDetectResultPacket.class);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.tencent.ims.ClientInfoA$EnvParamPacket] */
    public ClientInfoA$ReportDetectResultPacket() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_buffer = PBField.initBytes(byteStringMicro);
        this.bytes_buffer2 = PBField.initBytes(byteStringMicro);
        this.str_qqmd5 = PBField.initString("");
    }
}
