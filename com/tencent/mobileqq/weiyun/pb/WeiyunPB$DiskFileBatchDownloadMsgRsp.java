package com.tencent.mobileqq.weiyun.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes20.dex */
public final class WeiyunPB$DiskFileBatchDownloadMsgRsp extends MessageMicro<WeiyunPB$DiskFileBatchDownloadMsgRsp> {
    public static final int FILE_LIST_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"file_list"}, new Object[]{null}, WeiyunPB$DiskFileBatchDownloadMsgRsp.class);
    public final PBRepeatMessageField<WeiyunPB$DiskFileDownloadRspItem> file_list = PBField.initRepeatMessage(WeiyunPB$DiskFileDownloadRspItem.class);
}
