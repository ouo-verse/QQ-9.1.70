package com.tencent.mobileqq.troop.org.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class oidb_0xac5$NearbyNowData extends MessageMicro<oidb_0xac5$NearbyNowData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_now_haiwan"}, new Object[]{null}, oidb_0xac5$NearbyNowData.class);
    public final PBRepeatMessageField<oidb_0xac5$NowHaiWan> rpt_msg_now_haiwan = PBField.initRepeatMessage(oidb_0xac5$NowHaiWan.class);
}
