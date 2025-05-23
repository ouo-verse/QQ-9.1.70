package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class EmosmPb$ReqBody extends MessageMicro<EmosmPb$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 160}, new String[]{"uint32_sub_cmd", "uint64_uin", "msg_subcmd0x1_req_deltab", "msg_subcmd0x2_req_fetchtab", "msg_subcmd0x3_req_fetchbq", "int32_plat_id", "str_app_version", "msg_subcmd0x6_req", "msg_subcmd0x7_req", "msg_subcmd0x8_req_addtab", "msg_subcmd0x9_req", "msg_subcmd0x10_req", "msg_subcmd0x5_req", "msg_subcmd0x11_req", "msg_subcmd0x12_req", "msg_subcmd0x13_req", "msg_subcmd0x14_req_fetchtab_mac", "msg_subcmd0x18_req", "msg_subcmd0x19_req", "uint32_business_id"}, new Object[]{0, 0L, null, null, null, 0, "", null, null, null, null, null, null, null, null, null, null, null, null, 0}, EmosmPb$ReqBody.class);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public EmosmPb$SubCmd0x1ReqDelTab msg_subcmd0x1_req_deltab = new EmosmPb$SubCmd0x1ReqDelTab();
    public EmosmPb$SubCmd0x2ReqFetchTab msg_subcmd0x2_req_fetchtab = new EmosmPb$SubCmd0x2ReqFetchTab();
    public EmosmPb$SubCmd0x3ReqFetchBq msg_subcmd0x3_req_fetchbq = new EmosmPb$SubCmd0x3ReqFetchBq();
    public final PBInt32Field int32_plat_id = PBField.initInt32(0);
    public final PBStringField str_app_version = PBField.initString("");
    public EmosmPb$SubCmd0x6Req msg_subcmd0x6_req = new EmosmPb$SubCmd0x6Req();
    public EmosmPb$SubCmd0x7Req msg_subcmd0x7_req = new EmosmPb$SubCmd0x7Req();
    public EmosmPb$SubCmd0x8ReqAddTab msg_subcmd0x8_req_addtab = new EmosmPb$SubCmd0x8ReqAddTab();
    public EmosmPb$SubCmd0x9BqAssocReq msg_subcmd0x9_req = new MessageMicro<EmosmPb$SubCmd0x9BqAssocReq>() { // from class: com.tencent.pb.emosm.EmosmPb$SubCmd0x9BqAssocReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"str_key_word", "rpt_str_bq_item_id", "rpt_str_dead_bq_item_id"}, new Object[]{"", "", ""}, EmosmPb$SubCmd0x9BqAssocReq.class);
        public final PBRepeatField<String> rpt_str_bq_item_id;
        public final PBRepeatField<String> rpt_str_dead_bq_item_id;
        public final PBStringField str_key_word = PBField.initString("");

        {
            PBStringField pBStringField = PBStringField.__repeatHelper__;
            this.rpt_str_bq_item_id = PBField.initRepeat(pBStringField);
            this.rpt_str_dead_bq_item_id = PBField.initRepeat(pBStringField);
        }
    };
    public EmosmPb$SubCmd0x10MoveOrderReq msg_subcmd0x10_req = new EmosmPb$SubCmd0x10MoveOrderReq();
    public EmosmPb$SubCmd0x5ReqBQRecommend msg_subcmd0x5_req = new EmosmPb$SubCmd0x5ReqBQRecommend();
    public EmosmPb$SubCmd0x11Req msg_subcmd0x11_req = new MessageMicro<EmosmPb$SubCmd0x11Req>() { // from class: com.tencent.pb.emosm.EmosmPb$SubCmd0x11Req
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], EmosmPb$SubCmd0x11Req.class);
    };
    public EmosmPb$SubCmd0x12Req msg_subcmd0x12_req = new MessageMicro<EmosmPb$SubCmd0x12Req>() { // from class: com.tencent.pb.emosm.EmosmPb$SubCmd0x12Req
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"itemlist"}, new Object[]{null}, EmosmPb$SubCmd0x12Req.class);
        public final PBRepeatMessageField<EmosmPb$SmallYellowItem> itemlist = PBField.initRepeatMessage(EmosmPb$SmallYellowItem.class);
    };
    public EmosmPb$SubCmd0x13Req msg_subcmd0x13_req = new EmosmPb$SubCmd0x13Req();
    public EmosmPb$SubCmd0x14ReqFetchTabMac msg_subcmd0x14_req_fetchtab_mac = new MessageMicro<EmosmPb$SubCmd0x14ReqFetchTabMac>() { // from class: com.tencent.pb.emosm.EmosmPb$SubCmd0x14ReqFetchTabMac
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{13, 16, 29, 32}, new String[]{"fixed32_timestamp_ios", "int32_segment_flag_ios", "fixed32_timestamp_android", "int32_segment_flag_android"}, new Object[]{0, 0, 0, 0}, EmosmPb$SubCmd0x14ReqFetchTabMac.class);
        public final PBFixed32Field fixed32_timestamp_ios = PBField.initFixed32(0);
        public final PBInt32Field int32_segment_flag_ios = PBField.initInt32(0);
        public final PBFixed32Field fixed32_timestamp_android = PBField.initFixed32(0);
        public final PBInt32Field int32_segment_flag_android = PBField.initInt32(0);
    };
    public EmosmPb$SubCmd0x18Req msg_subcmd0x18_req = new EmosmPb$SubCmd0x18Req();
    public EmosmPb$SubCmd0x19Req msg_subcmd0x19_req = new MessageMicro<EmosmPb$SubCmd0x19Req>() { // from class: com.tencent.pb.emosm.EmosmPb$SubCmd0x19Req
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_package_id"}, new Object[]{0}, EmosmPb$SubCmd0x19Req.class);
        public final PBUInt32Field uint32_package_id = PBField.initUInt32(0);
    };
    public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
}
