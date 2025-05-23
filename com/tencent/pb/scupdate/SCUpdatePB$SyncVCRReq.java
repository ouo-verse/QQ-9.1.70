package com.tencent.pb.scupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes22.dex */
public final class SCUpdatePB$SyncVCRReq extends MessageMicro<SCUpdatePB$SyncVCRReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40}, new String[]{"seq", "sync_mode", "item_list", "plver", "rpver"}, new Object[]{0L, 0, null, 0L, 0L}, SCUpdatePB$SyncVCRReq.class);
    public final PBInt64Field seq = PBField.initInt64(0);
    public final PBInt32Field sync_mode = PBField.initInt32(0);
    public final PBRepeatMessageField<SCUpdatePB$ItemVersion> item_list = PBField.initRepeatMessage(SCUpdatePB$ItemVersion.class);
    public final PBInt64Field plver = PBField.initInt64(0);
    public final PBInt64Field rpver = PBField.initInt64(0);
}
