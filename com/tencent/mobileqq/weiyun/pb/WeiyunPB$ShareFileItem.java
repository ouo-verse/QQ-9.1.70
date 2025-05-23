package com.tencent.mobileqq.weiyun.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes20.dex */
public final class WeiyunPB$ShareFileItem extends MessageMicro<WeiyunPB$ShareFileItem> {
    public static final int FILE_ID_FIELD_NUMBER = 2;
    public static final int PDIR_KEY_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"pdir_key", "file_id"}, new Object[]{ByteStringMicro.EMPTY, ""}, WeiyunPB$ShareFileItem.class);
    public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField file_id = PBField.initString("");
}
