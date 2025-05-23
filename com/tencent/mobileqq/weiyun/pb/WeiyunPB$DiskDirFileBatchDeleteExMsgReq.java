package com.tencent.mobileqq.weiyun.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes20.dex */
public final class WeiyunPB$DiskDirFileBatchDeleteExMsgReq extends MessageMicro<WeiyunPB$DiskDirFileBatchDeleteExMsgReq> {
    public static final int DELETE_COMPLETELY_FIELD_NUMBER = 3;
    public static final int DIR_LIST_FIELD_NUMBER = 1;
    public static final int FILE_LIST_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"dir_list", "file_list", "delete_completely"}, new Object[]{null, null, Boolean.FALSE}, WeiyunPB$DiskDirFileBatchDeleteExMsgReq.class);
    public final PBRepeatMessageField<WeiyunPB$DiskSimpleDirItem> dir_list = PBField.initRepeatMessage(WeiyunPB$DiskSimpleDirItem.class);
    public final PBRepeatMessageField<WeiyunPB$DiskSimpleFileItem> file_list = PBField.initRepeatMessage(WeiyunPB$DiskSimpleFileItem.class);
    public final PBBoolField delete_completely = PBField.initBool(false);
}
