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
public final class EmosmPb$RspBody extends MessageMicro<EmosmPb$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 138, 146, 154, 160}, new String[]{"uint32_sub_cmd", "int32_result", "msg_subcmd0x1_rsp_deltab", "msg_subcmd0x2_rsp_fetchtab", "msg_subcmd0x3_rsp_fetchbq", "msg_subcmd0x5_recommend", "msg_subcmd0x6_collect_auth", "msg_subcmd0x7_rsp", "msg_subcmd0x8_rsp_addtab", "msg_subcmd0x9_rsp", "msg_subcmd0x10_rsp", "msg_subcmd0x11_rsp", "msg_subcmd0x12_rsp", "msg_subcmd0x13_rsp", "msg_subcmd0x14_rsp_fetchtab_mac", "msg_subcmd0x18_rsp", "msg_subcmd0x19_rsp", "uint32_business_id"}, new Object[]{0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0}, EmosmPb$RspBody.class);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public EmosmPb$SubCmd0x1RspDelTab msg_subcmd0x1_rsp_deltab = new EmosmPb$SubCmd0x1RspDelTab();
    public EmosmPb$SubCmd0x2RspFetchTab msg_subcmd0x2_rsp_fetchtab = new EmosmPb$SubCmd0x2RspFetchTab();
    public EmosmPb$SubCmd0x3RspFetchBq msg_subcmd0x3_rsp_fetchbq = new EmosmPb$SubCmd0x3RspFetchBq();
    public EmosmPb$SubCmd0x5RspBQRecommend msg_subcmd0x5_recommend = new EmosmPb$SubCmd0x5RspBQRecommend();
    public EmosmPb$SubCmd0x6Rsp msg_subcmd0x6_collect_auth = new EmosmPb$SubCmd0x6Rsp();
    public EmosmPb$SubCmd0x7Rsp msg_subcmd0x7_rsp = new EmosmPb$SubCmd0x7Rsp();
    public EmosmPb$SubCmd0x8RspAddTab msg_subcmd0x8_rsp_addtab = new MessageMicro<EmosmPb$SubCmd0x8RspAddTab>() { // from class: com.tencent.pb.emosm.EmosmPb$SubCmd0x8RspAddTab
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], EmosmPb$SubCmd0x8RspAddTab.class);
    };
    public EmosmPb$SubCmd0x9BqAssocRsp msg_subcmd0x9_rsp = new EmosmPb$SubCmd0x9BqAssocRsp();
    public EmosmPb$SubCmd0x10MoveOrderRsp msg_subcmd0x10_rsp = new MessageMicro<EmosmPb$SubCmd0x10MoveOrderRsp>() { // from class: com.tencent.pb.emosm.EmosmPb$SubCmd0x10MoveOrderRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"int32_move_detail"}, new Object[]{0}, EmosmPb$SubCmd0x10MoveOrderRsp.class);
        public final PBInt32Field int32_move_detail = PBField.initInt32(0);
    };
    public EmosmPb$SubCmd0x11Rsp msg_subcmd0x11_rsp = new MessageMicro<EmosmPb$SubCmd0x11Rsp>() { // from class: com.tencent.pb.emosm.EmosmPb$SubCmd0x11Rsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"itemlist"}, new Object[]{null}, EmosmPb$SubCmd0x11Rsp.class);
        public final PBRepeatMessageField<EmosmPb$SmallYellowItem> itemlist = PBField.initRepeatMessage(EmosmPb$SmallYellowItem.class);
    };
    public EmosmPb$SubCmd0x12Rsp msg_subcmd0x12_rsp = new MessageMicro<EmosmPb$SubCmd0x12Rsp>() { // from class: com.tencent.pb.emosm.EmosmPb$SubCmd0x12Rsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"ret"}, new Object[]{0}, EmosmPb$SubCmd0x12Rsp.class);
        public final PBInt32Field ret = PBField.initInt32(0);
    };
    public EmosmPb$SubCmd0x13Rsp msg_subcmd0x13_rsp = new EmosmPb$SubCmd0x13Rsp();
    public EmosmPb$SubCmd0x14RspFetchTabMac msg_subcmd0x14_rsp_fetchtab_mac = new MessageMicro<EmosmPb$SubCmd0x14RspFetchTabMac>() { // from class: com.tencent.pb.emosm.EmosmPb$SubCmd0x14RspFetchTabMac
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{13, 16, 29, 32, 42, 50, 58, 64}, new String[]{"fixed32_timestamp_ios", "int32_segment_flag_ios", "fixed32_timestamp_android", "int32_segment_flag_android", "rpt_msg_tabinfo", "rpt_magic_tabinfo", "rpt_smallbq_tabinfo", "uint32_tab_id"}, new Object[]{0, 0, 0, 0, null, null, null, 0}, EmosmPb$SubCmd0x14RspFetchTabMac.class);
        public final PBFixed32Field fixed32_timestamp_ios = PBField.initFixed32(0);
        public final PBInt32Field int32_segment_flag_ios = PBField.initInt32(0);
        public final PBFixed32Field fixed32_timestamp_android = PBField.initFixed32(0);
        public final PBInt32Field int32_segment_flag_android = PBField.initInt32(0);
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
    };
    public EmosmPb$SubCmd0x18Rsp msg_subcmd0x18_rsp = new EmosmPb$SubCmd0x18Rsp();
    public EmosmPb$SubCmd0x19Rsp msg_subcmd0x19_rsp = new EmosmPb$SubCmd0x19Rsp();
    public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
}
