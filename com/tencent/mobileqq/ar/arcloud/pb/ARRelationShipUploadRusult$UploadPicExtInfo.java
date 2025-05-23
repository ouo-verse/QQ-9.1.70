package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes11.dex */
public final class ARRelationShipUploadRusult$UploadPicExtInfo extends MessageMicro<ARRelationShipUploadRusult$UploadPicExtInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_download_url;
    public final PBBytesField bytes_file_resid;
    public final PBBytesField bytes_thumb_download_url;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"bytes_file_resid", "bytes_download_url", "bytes_thumb_download_url"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro}, ARRelationShipUploadRusult$UploadPicExtInfo.class);
    }

    public ARRelationShipUploadRusult$UploadPicExtInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_file_resid = PBField.initBytes(byteStringMicro);
        this.bytes_download_url = PBField.initBytes(byteStringMicro);
        this.bytes_thumb_download_url = PBField.initBytes(byteStringMicro);
    }
}
