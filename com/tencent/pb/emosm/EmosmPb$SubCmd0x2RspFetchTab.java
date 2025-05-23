package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class EmosmPb$SubCmd0x2RspFetchTab extends MessageMicro<EmosmPb$SubCmd0x2RspFetchTab> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{13, 16, 26, 34, 42, 48}, new String[]{"fixed32_timestamp", "int32_segment_flag", "rpt_msg_tabinfo", "rpt_magic_tabinfo", "rpt_smallbq_tabinfo", "uint32_tab_id"}, new Object[]{0, 0, null, null, null, 0}, EmosmPb$SubCmd0x2RspFetchTab.class);
    public final PBFixed32Field fixed32_timestamp = PBField.initFixed32(0);
    public final PBInt32Field int32_segment_flag = PBField.initInt32(0);
    public final PBRepeatMessageField<TabInfo> rpt_msg_tabinfo = PBField.initRepeatMessage(TabInfo.class);
    public final PBRepeatMessageField<TabInfo> rpt_magic_tabinfo = PBField.initRepeatMessage(TabInfo.class);
    public final PBRepeatMessageField<TabInfo> rpt_smallbq_tabinfo = PBField.initRepeatMessage(TabInfo.class);
    public final PBRepeatField<Integer> uint32_tab_id = PBField.initRepeat(PBInt32Field.__repeatHelper__);

    /* loaded from: classes22.dex */
    public static final class TabInfo extends MessageMicro<TabInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 21, 24, 32, 40, 50}, new String[]{"uint32_tab_id", "fixed32_expire_time", "uint32_flags", "int32_wording_id", "int32_tab_type", "str_tab_name"}, new Object[]{0, 0, 0, 0, 0, ""}, TabInfo.class);
        public final PBUInt32Field uint32_tab_id = PBField.initUInt32(0);
        public final PBFixed32Field fixed32_expire_time = PBField.initFixed32(0);
        public final PBUInt32Field uint32_flags = PBField.initUInt32(0);
        public final PBInt32Field int32_wording_id = PBField.initInt32(0);
        public final PBInt32Field int32_tab_type = PBField.initInt32(0);
        public final PBStringField str_tab_name = PBField.initString("");
    }
}
