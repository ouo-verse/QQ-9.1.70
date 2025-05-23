package com.tencent.mobileqq.weiyun.pb;

import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.ad.tangram.statistics.AdReporterForEffect;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes20.dex */
public final class WeiyunPB$DiskPicBackupReq extends MessageMicro<WeiyunPB$DiskPicBackupReq> {
    public static final int AUTO_CREATE_USER_FIELD_NUMBER = 9;
    public static final int AUTO_FLAG_FIELD_NUMBER = 11;
    public static final int BACKUP_DIR_NAME_FIELD_NUMBER = 10;
    public static final int BACKUP_TYPE_FIELD_NUMBER = 31;
    public static final int EDIT_FIELD_NUMBER = 41;
    public static final int EXT_INFO_FIELD_NUMBER = 21;
    public static final int FILENAME_FIELD_NUMBER = 1;
    public static final int FILE_EXIST_OPTION_FIELD_NUMBER = 7;
    public static final int FILE_MD5_FIELD_NUMBER = 3;
    public static final int FILE_SHA_FIELD_NUMBER = 2;
    public static final int FILE_SIZE_FIELD_NUMBER = 4;
    public static final int FIRST_256K_CRC_FIELD_NUMBER = 13;
    public static final int UPLOAD_TYPE_FIELD_NUMBER = 5;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField auto_create_user;
    public final PBBoolField auto_flag;
    public final PBStringField backup_dir_name;
    public final PBUInt32Field backup_type;
    public final PBBoolField edit;
    public WeiyunPB$FileExtInfo ext_info;
    public final PBUInt32Field file_exist_option;
    public final PBBytesField file_md5;
    public final PBBytesField file_sha;
    public final PBUInt64Field file_size;
    public final PBStringField filename = PBField.initString("");
    public final PBUInt32Field first_256k_crc;
    public final PBUInt32Field upload_type;

    static {
        int[] iArr = {10, 18, 26, 32, 40, 56, 72, 82, 88, 104, 170, 248, AdReporterForEffect.ACTION_MOBILEAPP_QUICKAPP_OPEN_FAILURE};
        String[] strArr = {"filename", "file_sha", "file_md5", "file_size", QZoneAdTianshuFeedData.KEY_AD_TYPE, "file_exist_option", "auto_create_user", "backup_dir_name", "auto_flag", "first_256k_crc", "ext_info", "backup_type", "edit"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(iArr, strArr, new Object[]{"", byteStringMicro, byteStringMicro, 0L, 0, 0, bool, "", bool, 0, null, 0, bool}, WeiyunPB$DiskPicBackupReq.class);
    }

    public WeiyunPB$DiskPicBackupReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.file_sha = PBField.initBytes(byteStringMicro);
        this.file_md5 = PBField.initBytes(byteStringMicro);
        this.file_size = PBField.initUInt64(0L);
        this.upload_type = PBField.initUInt32(0);
        this.file_exist_option = PBField.initUInt32(0);
        this.auto_create_user = PBField.initBool(false);
        this.backup_dir_name = PBField.initString("");
        this.auto_flag = PBField.initBool(false);
        this.first_256k_crc = PBField.initUInt32(0);
        this.ext_info = new WeiyunPB$FileExtInfo();
        this.backup_type = PBField.initUInt32(0);
        this.edit = PBField.initBool(false);
    }
}
