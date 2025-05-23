package com.tencent.mobileqq.weiyun.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes20.dex */
public final class WeiyunPB$QqSdkFileUploadMsgRsp extends MessageMicro<WeiyunPB$QqSdkFileUploadMsgRsp> {
    public static final int CHANNEL_COUNT_FIELD_NUMBER = 25;
    public static final int CHECK_KEY_FIELD_NUMBER = 7;
    public static final int DUP_ITEM_FIELD_NUMBER = 21;
    public static final int FILENAME_FIELD_NUMBER = 2;
    public static final int FILE_CTIME_FIELD_NUMBER = 3;
    public static final int FILE_EXIST_FIELD_NUMBER = 8;
    public static final int FILE_ID_FIELD_NUMBER = 1;
    public static final int FILE_KEY_FIELD_NUMBER = 10;
    public static final int FILE_MTIME_FIELD_NUMBER = 23;
    public static final int FILE_VERSION_FIELD_NUMBER = 9;
    public static final int FLOW_FILE_SIZE_FIELD_NUMBER = 40;
    public static final int INSIDE_UPLOAD_IP_FIELD_NUMBER = 11;
    public static final int LIB_ID_FIELD_NUMBER = 16;
    public static final int NEED_ADD_EVERY_DAY_FIELD_NUMBER = 30;
    public static final int OUTSIDE_UPLOAD_IP_FIELD_NUMBER = 12;
    public static final int PDIR_KEY_FIELD_NUMBER = 101;
    public static final int PDIR_MTIME_FIELD_NUMBER = 4;
    public static final int PPDIR_KEY_FIELD_NUMBER = 100;
    public static final int REMAIN_FLOW_SIZE_FIELD_NUMBER = 50;
    public static final int SERVER_NAME_FIELD_NUMBER = 5;
    public static final int SERVER_PORT_FIELD_NUMBER = 6;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field channel_count;
    public final PBBytesField check_key;
    public WeiyunPB$DirFileDupItem dup_item;
    public final PBBoolField file_exist;
    public final PBBytesField file_key;
    public final PBUInt64Field file_mtime;
    public final PBUInt32Field file_version;
    public final PBInt64Field flow_file_size;
    public final PBStringField inside_upload_ip;
    public final PBUInt32Field lib_id;
    public final PBBoolField need_add_every_day;
    public final PBStringField outside_upload_ip;
    public final PBBytesField pdir_key;
    public final PBBytesField ppdir_key;
    public final PBInt64Field remain_flow_size;
    public final PBStringField file_id = PBField.initString("");
    public final PBStringField filename = PBField.initString("");
    public final PBUInt64Field file_ctime = PBField.initUInt64(0);
    public final PBUInt64Field pdir_mtime = PBField.initUInt64(0);
    public final PBStringField server_name = PBField.initString("");
    public final PBUInt32Field server_port = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 48, 58, 64, 72, 82, 90, 98, 128, 170, 184, 200, 240, 320, 400, 802, 810}, new String[]{"file_id", "filename", "file_ctime", "pdir_mtime", "server_name", "server_port", "check_key", "file_exist", "file_version", "file_key", "inside_upload_ip", "outside_upload_ip", "lib_id", "dup_item", "file_mtime", "channel_count", "need_add_every_day", "flow_file_size", "remain_flow_size", "ppdir_key", "pdir_key"}, new Object[]{"", "", 0L, 0L, "", 0, byteStringMicro, bool, 0, byteStringMicro, "", "", 0, null, 0L, 0, bool, 0L, 0L, byteStringMicro, byteStringMicro}, WeiyunPB$QqSdkFileUploadMsgRsp.class);
    }

    public WeiyunPB$QqSdkFileUploadMsgRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.check_key = PBField.initBytes(byteStringMicro);
        this.file_exist = PBField.initBool(false);
        this.file_version = PBField.initUInt32(0);
        this.file_key = PBField.initBytes(byteStringMicro);
        this.inside_upload_ip = PBField.initString("");
        this.outside_upload_ip = PBField.initString("");
        this.lib_id = PBField.initUInt32(0);
        this.dup_item = new WeiyunPB$DirFileDupItem();
        this.file_mtime = PBField.initUInt64(0L);
        this.channel_count = PBField.initUInt32(0);
        this.need_add_every_day = PBField.initBool(false);
        this.flow_file_size = PBField.initInt64(0L);
        this.remain_flow_size = PBField.initInt64(0L);
        this.ppdir_key = PBField.initBytes(byteStringMicro);
        this.pdir_key = PBField.initBytes(byteStringMicro);
    }
}
