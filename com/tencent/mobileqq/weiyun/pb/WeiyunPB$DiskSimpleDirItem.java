package com.tencent.mobileqq.weiyun.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes20.dex */
public final class WeiyunPB$DiskSimpleDirItem extends MessageMicro<WeiyunPB$DiskSimpleDirItem> {
    public static final int DIR_KEY_FIELD_NUMBER = 1;
    public static final int DIR_NAME_FIELD_NUMBER = 2;
    public static final int PDIR_KEY_FIELD_NUMBER = 5;
    public static final int PPDIR_KEY_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField dir_key;
    public final PBStringField dir_name;
    public final PBBytesField pdir_key;
    public final PBBytesField ppdir_key;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 34, 42}, new String[]{"dir_key", "dir_name", "ppdir_key", "pdir_key"}, new Object[]{byteStringMicro, "", byteStringMicro, byteStringMicro}, WeiyunPB$DiskSimpleDirItem.class);
    }

    public WeiyunPB$DiskSimpleDirItem() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.dir_key = PBField.initBytes(byteStringMicro);
        this.dir_name = PBField.initString("");
        this.ppdir_key = PBField.initBytes(byteStringMicro);
        this.pdir_key = PBField.initBytes(byteStringMicro);
    }
}
