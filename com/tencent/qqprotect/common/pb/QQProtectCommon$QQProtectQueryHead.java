package com.tencent.qqprotect.common.pb;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes25.dex */
public final class QQProtectCommon$QQProtectQueryHead extends MessageMicro<QQProtectCommon$QQProtectQueryHead> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field app_id;
    public final PBStringField brand_info;
    public final PBBytesField bytes_guid;
    public final PBBytesField bytes_imei;
    public final PBStringField cpu_arch;
    public final PBStringField manufacturer;
    public final PBUInt32Field os_version;
    public final PBStringField package_name;
    public final PBUInt32Field qq_version;
    public final PBStringField rom_info;
    public final PBUInt32Field root;
    public final PBStringField string_uin;
    public final PBUInt32Field uint32_sec_cmd = PBField.initUInt32(0);

    static {
        String[] strArr = {"uint32_sec_cmd", "bytes_imei", "bytes_guid", "string_uin", "os_version", AppConstants.Preferences.QQ_VERSION, "cpu_arch", "rom_info", "root", "brand_info", "manufacturer", "package_name", "app_id"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 58, 66, 72, 82, 90, 98, 104}, strArr, new Object[]{0, byteStringMicro, byteStringMicro, "", 0, 0, "", "", 0, "", "", "", 0}, QQProtectCommon$QQProtectQueryHead.class);
    }

    public QQProtectCommon$QQProtectQueryHead() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_imei = PBField.initBytes(byteStringMicro);
        this.bytes_guid = PBField.initBytes(byteStringMicro);
        this.string_uin = PBField.initString("");
        this.os_version = PBField.initUInt32(0);
        this.qq_version = PBField.initUInt32(0);
        this.cpu_arch = PBField.initString("");
        this.rom_info = PBField.initString("");
        this.root = PBField.initUInt32(0);
        this.brand_info = PBField.initString("");
        this.manufacturer = PBField.initString("");
        this.package_name = PBField.initString("");
        this.app_id = PBField.initUInt32(0);
    }
}
