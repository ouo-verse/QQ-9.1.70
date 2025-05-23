package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes27.dex */
public final class Qworkflow$Picture extends MessageMicro<Qworkflow$Picture> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pic_md5;
    public final PBBytesField bytes_pic_url;
    public final PBBytesField bytes_userdef;
    public final PBUInt32Field uint32_pic_size = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint32_pic_size", "bytes_pic_url", "bytes_pic_md5", "bytes_userdef"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro}, Qworkflow$Picture.class);
    }

    public Qworkflow$Picture() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_pic_url = PBField.initBytes(byteStringMicro);
        this.bytes_pic_md5 = PBField.initBytes(byteStringMicro);
        this.bytes_userdef = PBField.initBytes(byteStringMicro);
    }
}
