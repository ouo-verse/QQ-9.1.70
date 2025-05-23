package com.tencent.qqnt.doutu.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class DoutuRecommend$GetImgInfoReq extends MessageMicro<DoutuRecommend$GetImgInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_md5;
    public final PBBytesField bytes_url;
    public final PBEnumField chat_type;
    public final PBUInt32Field uin32_gender;
    public final PBUInt32Field uint32_age;
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 50, 56, 64}, new String[]{"uint64_src_uin", "uint64_to_uin", "uint32_src_term", "bytes_md5", "chat_type", "bytes_url", "uin32_gender", "uint32_age"}, new Object[]{0L, 0L, 0, byteStringMicro, 1, byteStringMicro, 0, 0}, DoutuRecommend$GetImgInfoReq.class);
    }

    public DoutuRecommend$GetImgInfoReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_md5 = PBField.initBytes(byteStringMicro);
        this.chat_type = PBField.initEnum(1);
        this.bytes_url = PBField.initBytes(byteStringMicro);
        this.uin32_gender = PBField.initUInt32(0);
        this.uint32_age = PBField.initUInt32(0);
    }
}
