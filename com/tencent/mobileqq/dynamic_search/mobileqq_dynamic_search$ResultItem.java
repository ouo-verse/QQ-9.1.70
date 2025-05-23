package com.tencent.mobileqq.dynamic_search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class mobileqq_dynamic_search$ResultItem extends MessageMicro<mobileqq_dynamic_search$ResultItem> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField extension;
    public final PBBytesField jmp_url;
    public final PBBytesField name;
    public final PBBytesField pic_url;
    public final PBBytesField result_id;
    public final PBBytesField word;

    static {
        String[] strArr = {"result_id", "name", "pic_url", "jmp_url", "word", MimeTypeParser.ATTR_EXTENSION};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, strArr, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, mobileqq_dynamic_search$ResultItem.class);
    }

    public mobileqq_dynamic_search$ResultItem() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.result_id = PBField.initBytes(byteStringMicro);
        this.name = PBField.initBytes(byteStringMicro);
        this.pic_url = PBField.initBytes(byteStringMicro);
        this.jmp_url = PBField.initBytes(byteStringMicro);
        this.word = PBField.initBytes(byteStringMicro);
        this.extension = PBField.initBytes(byteStringMicro);
    }
}
