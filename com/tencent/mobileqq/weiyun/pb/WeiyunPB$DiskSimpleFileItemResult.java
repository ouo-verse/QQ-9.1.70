package com.tencent.mobileqq.weiyun.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes20.dex */
public final class WeiyunPB$DiskSimpleFileItemResult extends MessageMicro<WeiyunPB$DiskSimpleFileItemResult> {
    public static final int FILE_ID_FIELD_NUMBER = 1;
    public static final int PDIR_KEY_FIELD_NUMBER = 5;
    public static final int PPDIR_KEY_FIELD_NUMBER = 4;
    public static final int RETCODE_FIELD_NUMBER = 2;
    public static final int RETMSG_FIELD_NUMBER = 21;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField pdir_key;
    public final PBBytesField ppdir_key;
    public final PBStringField retmsg;
    public final PBStringField file_id = PBField.initString("");
    public final PBInt32Field retcode = PBField.initInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 34, 42, 170}, new String[]{"file_id", "retcode", "ppdir_key", "pdir_key", "retmsg"}, new Object[]{"", 0, byteStringMicro, byteStringMicro, ""}, WeiyunPB$DiskSimpleFileItemResult.class);
    }

    public WeiyunPB$DiskSimpleFileItemResult() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.ppdir_key = PBField.initBytes(byteStringMicro);
        this.pdir_key = PBField.initBytes(byteStringMicro);
        this.retmsg = PBField.initString("");
    }
}
