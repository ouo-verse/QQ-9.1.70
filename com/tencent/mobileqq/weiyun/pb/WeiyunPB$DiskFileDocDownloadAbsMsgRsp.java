package com.tencent.mobileqq.weiyun.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes20.dex */
public final class WeiyunPB$DiskFileDocDownloadAbsMsgRsp extends MessageMicro<WeiyunPB$DiskFileDocDownloadAbsMsgRsp> {
    public static final int COOKIE_FIELD_NUMBER = 6;
    public static final int DOWNLOADDNS_FIELD_NUMBER = 2;
    public static final int DOWNLOADIP_FIELD_NUMBER = 1;
    public static final int DOWNLOADKEY_FIELD_NUMBER = 5;
    public static final int DOWNLOADPORT_FIELD_NUMBER = 3;
    public static final int DOWNLOAD_URL_FIELD_NUMBER = 7;
    public static final int FILESHA_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField cookie;
    public final PBStringField download_url;
    public final PBBytesField downloadkey;
    public final PBBytesField filesha;
    public final PBStringField downloadip = PBField.initString("");
    public final PBStringField downloaddns = PBField.initString("");
    public final PBUInt32Field downloadport = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50, 58}, new String[]{"downloadip", "downloaddns", "downloadport", "filesha", "downloadkey", "cookie", "download_url"}, new Object[]{"", "", 0, byteStringMicro, byteStringMicro, "", ""}, WeiyunPB$DiskFileDocDownloadAbsMsgRsp.class);
    }

    public WeiyunPB$DiskFileDocDownloadAbsMsgRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.filesha = PBField.initBytes(byteStringMicro);
        this.downloadkey = PBField.initBytes(byteStringMicro);
        this.cookie = PBField.initString("");
        this.download_url = PBField.initString("");
    }
}
