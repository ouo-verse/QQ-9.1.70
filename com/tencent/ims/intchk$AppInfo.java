package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class intchk$AppInfo extends MessageMicro<intchk$AppInfo> {
    public static final int BYTES_APP_VERSION_FIELD_NUMBER = 3;
    public static final int BYTES_PACKAGE_NAME_FIELD_NUMBER = 2;
    public static final int UINT32_INTCHK_MODULE_VERSION_FIELD_NUMBER = 4;
    public static final int UINT32_NET_TYPE_FIELD_NUMBER = 5;
    public static final int UINT32_PLATFORM_TYPE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_app_version;
    public final PBBytesField bytes_package_name;
    public final PBUInt32Field uint32_intchk_module_version;
    public final PBUInt32Field uint32_net_type;
    public final PBUInt32Field uint32_platform_type = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40}, new String[]{"uint32_platform_type", "bytes_package_name", "bytes_app_version", "uint32_intchk_module_version", "uint32_net_type"}, new Object[]{0, byteStringMicro, byteStringMicro, 0, 0}, intchk$AppInfo.class);
    }

    public intchk$AppInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_package_name = PBField.initBytes(byteStringMicro);
        this.bytes_app_version = PBField.initBytes(byteStringMicro);
        this.uint32_intchk_module_version = PBField.initUInt32(0);
        this.uint32_net_type = PBField.initUInt32(0);
    }
}
