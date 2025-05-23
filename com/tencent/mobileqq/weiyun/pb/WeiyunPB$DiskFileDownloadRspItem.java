package com.tencent.mobileqq.weiyun.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes20.dex */
public final class WeiyunPB$DiskFileDownloadRspItem extends MessageMicro<WeiyunPB$DiskFileDownloadRspItem> {
    public static final int CHANNEL_COUNT_FIELD_NUMBER = 25;
    public static final int COOKIE_NAME_FIELD_NUMBER = 5;
    public static final int COOKIE_VALUE_FIELD_NUMBER = 6;
    public static final int DOWNLOAD_URL_FIELD_NUMBER = 13;
    public static final int ENCODE_URL_FIELD_NUMBER = 2;
    public static final int FILE_ID_FIELD_NUMBER = 7;
    public static final int FILE_MD5_FIELD_NUMBER = 8;
    public static final int FILE_MTIME_FIELD_NUMBER = 10;
    public static final int INSIDE_DOWNLOAD_IP_FIELD_NUMBER = 11;
    public static final int OUTSIDE_DOWNLOAD_IP_FIELD_NUMBER = 12;
    public static final int RETCODE_FIELD_NUMBER = 1;
    public static final int RETMSG_FIELD_NUMBER = 21;
    public static final int SERVER_NAME_FIELD_NUMBER = 3;
    public static final int SERVER_PORT_FIELD_NUMBER = 4;
    public static final int VIDEO_URL_FIELD_NUMBER = 9;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field channel_count;
    public final PBStringField cookie_name;
    public final PBStringField cookie_value;
    public final PBStringField download_url;
    public final PBBytesField encode_url;
    public final PBStringField file_id;
    public final PBBytesField file_md5;
    public final PBUInt64Field file_mtime;
    public final PBStringField inside_download_ip;
    public final PBStringField outside_download_ip;
    public final PBInt32Field retcode = PBField.initInt32(0);
    public final PBStringField retmsg;
    public final PBStringField server_name;
    public final PBUInt32Field server_port;
    public final PBStringField video_url;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 58, 66, 74, 80, 90, 98, 106, 170, 200}, new String[]{"retcode", "encode_url", "server_name", "server_port", "cookie_name", "cookie_value", "file_id", "file_md5", "video_url", "file_mtime", "inside_download_ip", "outside_download_ip", "download_url", "retmsg", "channel_count"}, new Object[]{0, byteStringMicro, "", 0, "", "", "", byteStringMicro, "", 0L, "", "", "", "", 0}, WeiyunPB$DiskFileDownloadRspItem.class);
    }

    public WeiyunPB$DiskFileDownloadRspItem() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.encode_url = PBField.initBytes(byteStringMicro);
        this.server_name = PBField.initString("");
        this.server_port = PBField.initUInt32(0);
        this.cookie_name = PBField.initString("");
        this.cookie_value = PBField.initString("");
        this.file_id = PBField.initString("");
        this.file_md5 = PBField.initBytes(byteStringMicro);
        this.video_url = PBField.initString("");
        this.file_mtime = PBField.initUInt64(0L);
        this.inside_download_ip = PBField.initString("");
        this.outside_download_ip = PBField.initString("");
        this.download_url = PBField.initString("");
        this.retmsg = PBField.initString("");
        this.channel_count = PBField.initUInt32(0);
    }
}
