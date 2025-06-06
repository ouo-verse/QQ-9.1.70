package com.tencent.mobileqq.weiyun.pb;

import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes20.dex */
public final class WeiyunPB$QqSdkFileUploadMsgReq extends MessageMicro<WeiyunPB$QqSdkFileUploadMsgReq> {
    public static final int AUTO_CREATE_USER_FIELD_NUMBER = 11;
    public static final int EXT_INFO_FIELD_NUMBER = 20;
    public static final int FILENAME_FIELD_NUMBER = 3;
    public static final int FILE_ATTR_FIELD_NUMBER = 8;
    public static final int FILE_ATTR_MTIME_FIELD_NUMBER = 7;
    public static final int FILE_EXIST_OPTION_FIELD_NUMBER = 10;
    public static final int FILE_MD5_FIELD_NUMBER = 5;
    public static final int FILE_SHA_FIELD_NUMBER = 4;
    public static final int FILE_SIZE_FIELD_NUMBER = 6;
    public static final int PDIR_KEY_FIELD_NUMBER = 2;
    public static final int PPDIR_KEY_FIELD_NUMBER = 1;
    public static final int UPLOAD_TYPE_FIELD_NUMBER = 9;
    public static final int USE_MUTIL_CHANNEL_FIELD_NUMBER = 30;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField auto_create_user;
    public WeiyunPB$FileExtInfo ext_info;
    public final PBUInt64Field file_attr;
    public final PBUInt64Field file_attr_mtime;
    public final PBUInt32Field file_exist_option;
    public final PBBytesField file_md5;
    public final PBBytesField file_sha;
    public final PBUInt64Field file_size;
    public final PBStringField filename;
    public final PBBytesField pdir_key;
    public final PBBytesField ppdir_key;
    public final PBUInt32Field upload_type;
    public final PBBoolField use_mutil_channel;

    static {
        String[] strArr = {"ppdir_key", "pdir_key", "filename", "file_sha", "file_md5", "file_size", "file_attr_mtime", "file_attr", QZoneAdTianshuFeedData.KEY_AD_TYPE, "file_exist_option", "auto_create_user", "ext_info", "use_mutil_channel"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 56, 64, 72, 80, 88, 162, 240}, strArr, new Object[]{byteStringMicro, byteStringMicro, "", byteStringMicro, byteStringMicro, 0L, 0L, 0L, 0, 0, bool, null, bool}, WeiyunPB$QqSdkFileUploadMsgReq.class);
    }

    public WeiyunPB$QqSdkFileUploadMsgReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.ppdir_key = PBField.initBytes(byteStringMicro);
        this.pdir_key = PBField.initBytes(byteStringMicro);
        this.filename = PBField.initString("");
        this.file_sha = PBField.initBytes(byteStringMicro);
        this.file_md5 = PBField.initBytes(byteStringMicro);
        this.file_size = PBField.initUInt64(0L);
        this.file_attr_mtime = PBField.initUInt64(0L);
        this.file_attr = PBField.initUInt64(0L);
        this.upload_type = PBField.initUInt32(0);
        this.file_exist_option = PBField.initUInt32(0);
        this.auto_create_user = PBField.initBool(false);
        this.ext_info = new WeiyunPB$FileExtInfo();
        this.use_mutil_channel = PBField.initBool(false);
    }
}
