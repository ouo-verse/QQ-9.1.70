package com.tencent.pb.scupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class SCUpdatePB$GetUrlReq extends MessageMicro<SCUpdatePB$GetUrlReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, new String[]{"delta_mode", "storage_mode", "compress_mode", "item_list", "partial_download_flag"}, new Object[]{0, 0, 0, null, 0}, SCUpdatePB$GetUrlReq.class);
    public final PBUInt32Field delta_mode = PBField.initUInt32(0);
    public final PBUInt32Field storage_mode = PBField.initUInt32(0);
    public final PBUInt32Field compress_mode = PBField.initUInt32(0);
    public final PBRepeatMessageField<SCUpdatePB$ItemVersion> item_list = PBField.initRepeatMessage(SCUpdatePB$ItemVersion.class);
    public final PBUInt32Field partial_download_flag = PBField.initUInt32(0);
}
