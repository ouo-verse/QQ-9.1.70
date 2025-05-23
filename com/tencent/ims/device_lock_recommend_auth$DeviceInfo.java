package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class device_lock_recommend_auth$DeviceInfo extends MessageMicro<device_lock_recommend_auth$DeviceInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_appname;
    public final PBBytesField bytes_device_name;
    public final PBBytesField bytes_device_typeinfo;
    public final PBBytesField bytes_guid;
    public final PBUInt32Field uint32_appid;
    public final PBUInt32Field uint32_auth_status;
    public final PBUInt32Field uint32_subappid;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 50, 56}, new String[]{"bytes_device_name", "bytes_device_typeinfo", "bytes_guid", "uint32_appid", "uint32_subappid", "bytes_appname", "uint32_auth_status"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, 0}, device_lock_recommend_auth$DeviceInfo.class);
    }

    public device_lock_recommend_auth$DeviceInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_device_name = PBField.initBytes(byteStringMicro);
        this.bytes_device_typeinfo = PBField.initBytes(byteStringMicro);
        this.bytes_guid = PBField.initBytes(byteStringMicro);
        this.uint32_appid = PBField.initUInt32(0);
        this.uint32_subappid = PBField.initUInt32(0);
        this.bytes_appname = PBField.initBytes(byteStringMicro);
        this.uint32_auth_status = PBField.initUInt32(0);
    }
}
