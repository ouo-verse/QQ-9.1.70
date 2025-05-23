package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class appoint_define$AppointContent extends MessageMicro<appoint_define$AppointContent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58}, new String[]{"uint32_appoint_subject", "uint32_pay_type", "uint32_appoint_date", "uint32_appoint_gender", "str_appoint_introduce", "msg_appoint_address", "msg_travel_info"}, new Object[]{0, 0, 0, 0, "", null, null}, appoint_define$AppointContent.class);
    public final PBUInt32Field uint32_appoint_subject = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pay_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_appoint_date = PBField.initUInt32(0);
    public final PBUInt32Field uint32_appoint_gender = PBField.initUInt32(0);
    public final PBStringField str_appoint_introduce = PBField.initString("");
    public appoint_define$AddressInfo msg_appoint_address = new MessageMicro<appoint_define$AddressInfo>() { // from class: appoint.define.appoint_define$AddressInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"str_company_zone", "str_company_name", "str_company_addr", "str_company_pic_url", "str_company_url", "msg_company_id"}, new Object[]{"", "", "", "", "", null}, appoint_define$AddressInfo.class);
        public final PBStringField str_company_zone = PBField.initString("");
        public final PBStringField str_company_name = PBField.initString("");
        public final PBStringField str_company_addr = PBField.initString("");
        public final PBStringField str_company_pic_url = PBField.initString("");
        public final PBStringField str_company_url = PBField.initString("");
        public appoint_define$ShopID msg_company_id = new MessageMicro<appoint_define$ShopID>() { // from class: appoint.define.appoint_define$ShopID
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"str_shopid", "uint32_sp"}, new Object[]{"", 0}, appoint_define$ShopID.class);
            public final PBStringField str_shopid = PBField.initString("");
            public final PBUInt32Field uint32_sp = PBField.initUInt32(0);
        };
    };
    public appoint_define$TravelInfo msg_travel_info = new MessageMicro<appoint_define$TravelInfo>() { // from class: appoint.define.appoint_define$TravelInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 50}, new String[]{"msg_depart_locale", "msg_destination", "uint32_vehicle", "uint32_partner_count", "str_place_pic_url", "str_place_url"}, new Object[]{null, null, 0, 0, "", ""}, appoint_define$TravelInfo.class);
        public appoint_define$LocaleInfo msg_depart_locale = new appoint_define$LocaleInfo();
        public appoint_define$LocaleInfo msg_destination = new appoint_define$LocaleInfo();
        public final PBUInt32Field uint32_vehicle = PBField.initUInt32(0);
        public final PBUInt32Field uint32_partner_count = PBField.initUInt32(0);
        public final PBStringField str_place_pic_url = PBField.initString("");
        public final PBStringField str_place_url = PBField.initString("");
    };
}
