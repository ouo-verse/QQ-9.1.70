package com.tencent.mobileqq.weiyun.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes20.dex */
public final class WeiyunPB$DiskPicBackupRsp extends MessageMicro<WeiyunPB$DiskPicBackupRsp> {
    public static final int BACKUP_PATH_FIELD_NUMBER = 17;
    public static final int CHANNEL_COUNT_FIELD_NUMBER = 30;
    public static final int CHECK_KEY_FIELD_NUMBER = 7;
    public static final int COUPON_COUNT_FIELD_NUMBER = 31;
    public static final int DUP_ITEM_FIELD_NUMBER = 22;
    public static final int EXT_INFO_FIELD_NUMBER = 21;
    public static final int FILENAME_FIELD_NUMBER = 2;
    public static final int FILE_BACKUP_FIELD_NUMBER = 13;
    public static final int FILE_CTIME_FIELD_NUMBER = 3;
    public static final int FILE_EXIST_FIELD_NUMBER = 8;
    public static final int FILE_ID_FIELD_NUMBER = 1;
    public static final int FILE_KEY_FIELD_NUMBER = 10;
    public static final int FILE_VERSION_FIELD_NUMBER = 9;
    public static final int INSIDE_UPLOAD_IP_FIELD_NUMBER = 14;
    public static final int OUTSIDE_UPLOAD_IP_FIELD_NUMBER = 15;
    public static final int PDIR_KEY_FIELD_NUMBER = 11;
    public static final int PDIR_MTIME_FIELD_NUMBER = 4;
    public static final int PPDIR_KEY_FIELD_NUMBER = 12;
    public static final int SERVER_NAME_FIELD_NUMBER = 5;
    public static final int SERVER_PORT_FIELD_NUMBER = 6;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField backup_path;
    public final PBUInt32Field channel_count;
    public final PBBytesField check_key;
    public final PBUInt32Field coupon_count;
    public WeiyunPB$DirFileDupItem dup_item;
    public WeiyunPB$FileExtInfo ext_info;
    public final PBBoolField file_backup;
    public final PBBoolField file_exist;
    public final PBBytesField file_key;
    public final PBUInt32Field file_version;
    public final PBStringField inside_upload_ip;
    public final PBStringField outside_upload_ip;
    public final PBBytesField pdir_key;
    public final PBBytesField ppdir_key;
    public final PBStringField file_id = PBField.initString("");
    public final PBStringField filename = PBField.initString("");
    public final PBUInt64Field file_ctime = PBField.initUInt64(0);
    public final PBUInt64Field pdir_mtime = PBField.initUInt64(0);
    public final PBStringField server_name = PBField.initString("");
    public final PBUInt32Field server_port = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 48, 58, 64, 72, 82, 90, 98, 104, 114, 122, 138, 170, 178, 240, 248}, new String[]{"file_id", "filename", "file_ctime", "pdir_mtime", "server_name", "server_port", "check_key", "file_exist", "file_version", "file_key", "pdir_key", "ppdir_key", "file_backup", "inside_upload_ip", "outside_upload_ip", "backup_path", "ext_info", "dup_item", "channel_count", "coupon_count"}, new Object[]{"", "", 0L, 0L, "", 0, byteStringMicro, bool, 0, byteStringMicro, byteStringMicro, byteStringMicro, bool, "10.130.69.41", "", "", null, null, 0, 0}, WeiyunPB$DiskPicBackupRsp.class);
    }

    public WeiyunPB$DiskPicBackupRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.check_key = PBField.initBytes(byteStringMicro);
        this.file_exist = PBField.initBool(false);
        this.file_version = PBField.initUInt32(0);
        this.file_key = PBField.initBytes(byteStringMicro);
        this.pdir_key = PBField.initBytes(byteStringMicro);
        this.ppdir_key = PBField.initBytes(byteStringMicro);
        this.file_backup = PBField.initBool(false);
        this.inside_upload_ip = PBField.initString("10.130.69.41");
        this.outside_upload_ip = PBField.initString("");
        this.backup_path = PBField.initString("");
        this.ext_info = new WeiyunPB$FileExtInfo();
        this.dup_item = new WeiyunPB$DirFileDupItem();
        this.channel_count = PBField.initUInt32(0);
        this.coupon_count = PBField.initUInt32(0);
    }
}
