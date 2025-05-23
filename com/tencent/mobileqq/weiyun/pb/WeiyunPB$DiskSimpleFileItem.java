package com.tencent.mobileqq.weiyun.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes20.dex */
public final class WeiyunPB$DiskSimpleFileItem extends MessageMicro<WeiyunPB$DiskSimpleFileItem> {
    public static final int FILENAME_FIELD_NUMBER = 2;
    public static final int FILE_ID_FIELD_NUMBER = 1;
    public static final int PDIR_KEY_FIELD_NUMBER = 3;
    public static final int PPDIR_KEY_FIELD_NUMBER = 7;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField file_id = PBField.initString("");
    public final PBStringField filename = PBField.initString("");
    public final PBBytesField pdir_key;
    public final PBBytesField ppdir_key;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 58}, new String[]{"file_id", "filename", "pdir_key", "ppdir_key"}, new Object[]{"", "", byteStringMicro, byteStringMicro}, WeiyunPB$DiskSimpleFileItem.class);
    }

    public WeiyunPB$DiskSimpleFileItem() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.pdir_key = PBField.initBytes(byteStringMicro);
        this.ppdir_key = PBField.initBytes(byteStringMicro);
    }
}
