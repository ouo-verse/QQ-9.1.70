package com.tencent.trpcprotocol.sc_report.sso_data_recv.sso_data_recv;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class DownloadApkReport$InstallInfo extends MessageMicro<DownloadApkReport$InstallInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField client_ip;
    public final PBStringField client_ver;
    public final PBBytesField filename;
    public final PBBytesField guid;
    public final PBStringField timestamp;
    public final PBStringField url;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"filename", "client_ip", "timestamp", "guid", "client_ver", "url"}, new Object[]{byteStringMicro, byteStringMicro, "", byteStringMicro, "", ""}, DownloadApkReport$InstallInfo.class);
    }

    public DownloadApkReport$InstallInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.filename = PBField.initBytes(byteStringMicro);
        this.client_ip = PBField.initBytes(byteStringMicro);
        this.timestamp = PBField.initString("");
        this.guid = PBField.initBytes(byteStringMicro);
        this.client_ver = PBField.initString("");
        this.url = PBField.initString("");
    }
}
