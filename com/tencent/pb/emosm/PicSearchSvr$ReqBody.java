package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class PicSearchSvr$ReqBody extends MessageMicro<PicSearchSvr$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_app_qua;
    public final PBBytesField bytes_ext_info;
    public final PBRepeatField<ByteStringMicro> bytes_key_word;
    public final PBBytesField bytes_session_id;
    public final PBBytesField bytes_user_text;
    public final PBUInt32Field uin32_gender;
    public final PBUInt32Field uint32_age;
    public final PBUInt32Field uint32_aio_type;
    public final PBUInt32Field uint32_open_emotion;
    public final PBUInt32Field uint32_src_term;
    public final PBUInt32Field uint32_support_emotion;
    public final PBUInt64Field uint64_src_uin;
    public final PBUInt64Field uint64_to_uin;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 50, 58, 64, 72, 80, 90, 96, 106}, new String[]{"bytes_session_id", "uint64_src_uin", "uint32_src_term", "uint32_aio_type", "uint64_to_uin", "bytes_user_text", "bytes_key_word", "uin32_gender", "uint32_age", "uint32_open_emotion", "bytes_app_qua", "uint32_support_emotion", "bytes_ext_info"}, new Object[]{byteStringMicro, 0L, 0, 0, 0L, byteStringMicro, byteStringMicro, 0, 0, 0, byteStringMicro, 0, byteStringMicro}, PicSearchSvr$ReqBody.class);
    }

    public PicSearchSvr$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_session_id = PBField.initBytes(byteStringMicro);
        this.uint64_src_uin = PBField.initUInt64(0L);
        this.uint32_src_term = PBField.initUInt32(0);
        this.uint32_aio_type = PBField.initUInt32(0);
        this.uint64_to_uin = PBField.initUInt64(0L);
        this.bytes_user_text = PBField.initBytes(byteStringMicro);
        this.bytes_key_word = PBField.initRepeat(PBBytesField.__repeatHelper__);
        this.uin32_gender = PBField.initUInt32(0);
        this.uint32_age = PBField.initUInt32(0);
        this.uint32_open_emotion = PBField.initUInt32(0);
        this.bytes_app_qua = PBField.initBytes(byteStringMicro);
        this.uint32_support_emotion = PBField.initUInt32(0);
        this.bytes_ext_info = PBField.initBytes(byteStringMicro);
    }
}
