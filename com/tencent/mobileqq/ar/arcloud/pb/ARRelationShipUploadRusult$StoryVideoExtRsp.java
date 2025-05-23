package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class ARRelationShipUploadRusult$StoryVideoExtRsp extends MessageMicro<ARRelationShipUploadRusult$StoryVideoExtRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cdn_url;
    public final PBBytesField bytes_file_id;
    public final PBBytesField bytes_file_key;
    public final PBBytesField bytes_msg;
    public final PBInt32Field int32_retcode = PBField.initInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"int32_retcode", "bytes_msg", "bytes_cdn_url", "bytes_file_key", "bytes_file_id"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, ARRelationShipUploadRusult$StoryVideoExtRsp.class);
    }

    public ARRelationShipUploadRusult$StoryVideoExtRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_msg = PBField.initBytes(byteStringMicro);
        this.bytes_cdn_url = PBField.initBytes(byteStringMicro);
        this.bytes_file_key = PBField.initBytes(byteStringMicro);
        this.bytes_file_id = PBField.initBytes(byteStringMicro);
    }
}
