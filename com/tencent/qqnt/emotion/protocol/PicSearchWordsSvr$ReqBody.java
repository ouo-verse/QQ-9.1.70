package com.tencent.qqnt.emotion.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes24.dex */
public final class PicSearchWordsSvr$ReqBody extends MessageMicro<PicSearchWordsSvr$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_appid;
    public final PBBytesField bytes_session_id;
    public final PBBytesField bytes_version;
    public final PBUInt32Field uin32_gender;
    public final PBUInt32Field uint32_age;
    public final PBUInt32Field uint32_src_term;
    public final PBUInt64Field uint64_src_uin;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 48, 56}, new String[]{"bytes_session_id", "uint64_src_uin", "uint32_src_term", "bytes_appid", "bytes_version", "uin32_gender", "uint32_age"}, new Object[]{byteStringMicro, 0L, 0, byteStringMicro, byteStringMicro, 0, 0}, PicSearchWordsSvr$ReqBody.class);
    }

    public PicSearchWordsSvr$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_session_id = PBField.initBytes(byteStringMicro);
        this.uint64_src_uin = PBField.initUInt64(0L);
        this.uint32_src_term = PBField.initUInt32(0);
        this.bytes_appid = PBField.initBytes(byteStringMicro);
        this.bytes_version = PBField.initBytes(byteStringMicro);
        this.uin32_gender = PBField.initUInt32(0);
        this.uint32_age = PBField.initUInt32(0);
    }
}
