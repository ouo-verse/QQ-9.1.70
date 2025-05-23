package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Qworkflow$OrdinaryFile extends MessageMicro<Qworkflow$OrdinaryFile> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_file_md5;
    public final PBBytesField bytes_file_name;
    public final PBBytesField bytes_file_sha;
    public final PBBytesField bytes_file_url;
    public final PBBytesField bytes_file_uuid;
    public final PBBytesField bytes_userdef;
    public final PBUInt32Field uint32_file_size;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50, 58}, new String[]{"bytes_file_name", "bytes_file_url", "uint32_file_size", "bytes_file_sha", "bytes_file_md5", "bytes_file_uuid", "bytes_userdef"}, new Object[]{byteStringMicro, byteStringMicro, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, Qworkflow$OrdinaryFile.class);
    }

    public Qworkflow$OrdinaryFile() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_file_name = PBField.initBytes(byteStringMicro);
        this.bytes_file_url = PBField.initBytes(byteStringMicro);
        this.uint32_file_size = PBField.initUInt32(0);
        this.bytes_file_sha = PBField.initBytes(byteStringMicro);
        this.bytes_file_md5 = PBField.initBytes(byteStringMicro);
        this.bytes_file_uuid = PBField.initBytes(byteStringMicro);
        this.bytes_userdef = PBField.initBytes(byteStringMicro);
    }
}
