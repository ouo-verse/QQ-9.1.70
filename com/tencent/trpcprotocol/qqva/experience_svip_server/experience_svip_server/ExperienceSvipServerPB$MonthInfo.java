package com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class ExperienceSvipServerPB$MonthInfo extends MessageMicro<ExperienceSvipServerPB$MonthInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 48, 58, 64, 72, 82, 90, 96, 106, 114, 122, 130, 138, 146, 154, 162, 170, 178}, new String[]{"tianxuan", "introduce", "is_show", "aid", "type", "index", "title", "month", "price", "text", "description", "ori_price", "ori_price_remark", "tip_text", "service", "active_img", "inactive_img", "black_inactive_img", "paybtn_img", "pay_aid", "group_id", "pt_data"}, new Object[]{null, null, Boolean.FALSE, "", 0, 0, "", 0, 0, "", "", 0, "", "", null, "", "", "", "", "", "", null}, ExperienceSvipServerPB$MonthInfo.class);
    public ExperienceSvipServerPB$Tianxuan tianxuan = new ExperienceSvipServerPB$Tianxuan();
    public ExperienceSvipServerPB$Introduce introduce = new MessageMicro<ExperienceSvipServerPB$Introduce>() { // from class: com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server.ExperienceSvipServerPB$Introduce
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"title", "tip", "img", "item_id"}, new Object[]{"", "", "", ""}, ExperienceSvipServerPB$Introduce.class);
        public final PBStringField title = PBField.initString("");
        public final PBStringField tip = PBField.initString("");
        public final PBStringField img = PBField.initString("");
        public final PBStringField item_id = PBField.initString("");
    };
    public final PBBoolField is_show = PBField.initBool(false);
    public final PBRepeatField<String> aid = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBInt32Field index = PBField.initInt32(0);
    public final PBStringField title = PBField.initString("");
    public final PBInt32Field month = PBField.initInt32(0);
    public final PBInt32Field price = PBField.initInt32(0);
    public final PBStringField text = PBField.initString("");
    public final PBStringField description = PBField.initString("");
    public final PBInt32Field ori_price = PBField.initInt32(0);
    public final PBStringField ori_price_remark = PBField.initString("");
    public final PBStringField tip_text = PBField.initString("");
    public ExperienceSvipServerPB$Service service = new ExperienceSvipServerPB$Service();
    public final PBStringField active_img = PBField.initString("");
    public final PBStringField inactive_img = PBField.initString("");
    public final PBStringField black_inactive_img = PBField.initString("");
    public final PBStringField paybtn_img = PBField.initString("");
    public final PBStringField pay_aid = PBField.initString("");
    public final PBStringField group_id = PBField.initString("");
    public ExperienceSvipServerPB$PtData pt_data = new MessageMicro<ExperienceSvipServerPB$PtData>() { // from class: com.tencent.trpcprotocol.qqva.experience_svip_server.experience_svip_server.ExperienceSvipServerPB$PtData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"act_id", "sub_id", "price"}, new Object[]{0L, 0L, 0L}, ExperienceSvipServerPB$PtData.class);
        public final PBInt64Field act_id = PBField.initInt64(0);
        public final PBInt64Field sub_id = PBField.initInt64(0);
        public final PBInt64Field price = PBField.initInt64(0);
    };
}
