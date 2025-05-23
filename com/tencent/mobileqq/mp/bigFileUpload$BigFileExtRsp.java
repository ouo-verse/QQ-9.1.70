package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class bigFileUpload$BigFileExtRsp extends MessageMicro<bigFileUpload$BigFileExtRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_download_url;
    public final PBBytesField bytes_file_md5;
    public final PBBytesField bytes_file_name;
    public final PBBytesField bytes_msg;
    public final PBInt32Field int32_retcode = PBField.initInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"int32_retcode", "bytes_msg", "bytes_download_url", "bytes_file_name", "bytes_file_md5"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, bigFileUpload$BigFileExtRsp.class);
    }

    public bigFileUpload$BigFileExtRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_msg = PBField.initBytes(byteStringMicro);
        this.bytes_download_url = PBField.initBytes(byteStringMicro);
        this.bytes_file_name = PBField.initBytes(byteStringMicro);
        this.bytes_file_md5 = PBField.initBytes(byteStringMicro);
    }
}
