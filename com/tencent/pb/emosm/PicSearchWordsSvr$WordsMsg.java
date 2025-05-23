package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class PicSearchWordsSvr$WordsMsg extends MessageMicro<PicSearchWordsSvr$WordsMsg> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_words_md5;
    public final PBBytesField bytes_words_other;
    public final PBBytesField bytes_words_url;
    public final PBBytesField bytes_words_version;
    public final PBUInt32Field uint32_words_type;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"bytes_words_version", "bytes_words_url", "bytes_words_md5", "uint32_words_type", "bytes_words_other"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, 0, byteStringMicro}, PicSearchWordsSvr$WordsMsg.class);
    }

    public PicSearchWordsSvr$WordsMsg() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_words_version = PBField.initBytes(byteStringMicro);
        this.bytes_words_url = PBField.initBytes(byteStringMicro);
        this.bytes_words_md5 = PBField.initBytes(byteStringMicro);
        this.uint32_words_type = PBField.initUInt32(0);
        this.bytes_words_other = PBField.initBytes(byteStringMicro);
    }
}
