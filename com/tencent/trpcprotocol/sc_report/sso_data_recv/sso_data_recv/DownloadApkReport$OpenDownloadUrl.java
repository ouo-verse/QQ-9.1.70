package com.tencent.trpcprotocol.sc_report.sso_data_recv.sso_data_recv;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class DownloadApkReport$OpenDownloadUrl extends MessageMicro<DownloadApkReport$OpenDownloadUrl> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField client_ip;
    public final PBStringField client_ver;
    public final PBUInt32Field download_type;
    public final PBStringField file_type;
    public final PBBytesField filename;
    public final PBBytesField guid;
    public final PBStringField timestamp;
    public final PBStringField url;

    static {
        String[] strArr = {"client_ip", "timestamp", "guid", "client_ver", VRReportDefine$ReportParam.DOWNLOAD_TYPE, "filename", "file_type", "url"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 26, 34, 42, 48, 58, 66, 74}, strArr, new Object[]{byteStringMicro, "", byteStringMicro, "", 0, byteStringMicro, "", ""}, DownloadApkReport$OpenDownloadUrl.class);
    }

    public DownloadApkReport$OpenDownloadUrl() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.client_ip = PBField.initBytes(byteStringMicro);
        this.timestamp = PBField.initString("");
        this.guid = PBField.initBytes(byteStringMicro);
        this.client_ver = PBField.initString("");
        this.download_type = PBField.initUInt32(0);
        this.filename = PBField.initBytes(byteStringMicro);
        this.file_type = PBField.initString("");
        this.url = PBField.initString("");
    }
}
