package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes9.dex */
public final class NowQQLiveHomepageProto$RecommendPageRsp extends MessageMicro<NowQQLiveHomepageProto$RecommendPageRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 56, 66}, new String[]{"uint32_new_timestamp", "rpt_msg_rcmd", "retInfo", "uint32_endFlag", "uint32_next_index", "uint32_total_num", "rcmd_col_mode", "union_channel"}, new Object[]{0, null, null, 0, 0, 0, 0, ""}, NowQQLiveHomepageProto$RecommendPageRsp.class);
    public final PBUInt32Field uint32_new_timestamp = PBField.initUInt32(0);
    public final PBRepeatMessageField<NowQQLiveHomepageProto$RecommendItem> rpt_msg_rcmd = PBField.initRepeatMessage(NowQQLiveHomepageProto$RecommendItem.class);
    public NowQQLiveHomepageProto$RetInfo retInfo = new MessageMicro<NowQQLiveHomepageProto$RetInfo>() { // from class: com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto$RetInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{CheckForwardServlet.KEY_ERR_CODE, "err_info"}, new Object[]{0, ""}, NowQQLiveHomepageProto$RetInfo.class);
        public final PBUInt32Field err_code = PBField.initUInt32(0);
        public final PBStringField err_info = PBField.initString("");
    };
    public final PBUInt32Field uint32_endFlag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_next_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_num = PBField.initUInt32(0);
    public final PBUInt32Field rcmd_col_mode = PBField.initUInt32(0);
    public final PBStringField union_channel = PBField.initString("");
}
