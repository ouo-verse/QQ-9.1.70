package com.tencent.mobileqq.weiyun.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;

/* loaded from: classes20.dex */
public final class WeiyunPB$DiskFileBatchDownloadMsgReq extends MessageMicro<WeiyunPB$DiskFileBatchDownloadMsgReq> {
    public static final int DOWNLOAD_TYPE_FIELD_NUMBER = 4;
    public static final int FILE_LIST_FIELD_NUMBER = 1;
    public static final int FILE_OWNER_FIELD_NUMBER = 2;
    public static final int NEED_THUMB_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"file_list", "file_owner", "need_thumb", VRReportDefine$ReportParam.DOWNLOAD_TYPE}, new Object[]{null, 0L, Boolean.FALSE, 0}, WeiyunPB$DiskFileBatchDownloadMsgReq.class);
    public final PBRepeatMessageField<WeiyunPB$DiskSimpleFileItem> file_list = PBField.initRepeatMessage(WeiyunPB$DiskSimpleFileItem.class);
    public final PBUInt64Field file_owner = PBField.initUInt64(0);
    public final PBBoolField need_thumb = PBField.initBool(false);
    public final PBUInt32Field download_type = PBField.initUInt32(0);
}
