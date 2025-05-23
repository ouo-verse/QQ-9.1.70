package com.tencent.mobileqq.troop.org.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class oidb_0xac5$NowHaiWanStorage extends MessageMicro<oidb_0xac5$NowHaiWanStorage> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_haiwan_record"}, new Object[]{null}, oidb_0xac5$NowHaiWanStorage.class);
    public final PBRepeatMessageField<oidb_0xac5$HaiWanRecord> rpt_msg_haiwan_record = PBField.initRepeatMessage(oidb_0xac5$HaiWanRecord.class);
}
