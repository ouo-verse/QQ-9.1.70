package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class weather$GetNewsReply extends MessageMicro<weather$GetNewsReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"news", "covid_info"}, new Object[]{"", null}, weather$GetNewsReply.class);
    public final PBStringField news = PBField.initString("");
    public weather$CovidInfo covid_info = new MessageMicro<weather$CovidInfo>() { // from class: com.tencent.jungle.weather.proto.weather$CovidInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 66}, new String[]{"is_city", "confirmed_add", "wzz_add", "continue_day_zero_confirm_add", "risk_area_url", "nucleic_acid_test_url", "travel_policy_url", "local_epidemic_url"}, new Object[]{Boolean.FALSE, 0, 0, 0, "", "", "", ""}, weather$CovidInfo.class);
        public final PBBoolField is_city = PBField.initBool(false);
        public final PBUInt32Field confirmed_add = PBField.initUInt32(0);
        public final PBUInt32Field wzz_add = PBField.initUInt32(0);
        public final PBUInt32Field continue_day_zero_confirm_add = PBField.initUInt32(0);
        public final PBStringField risk_area_url = PBField.initString("");
        public final PBStringField nucleic_acid_test_url = PBField.initString("");
        public final PBStringField travel_policy_url = PBField.initString("");
        public final PBStringField local_epidemic_url = PBField.initString("");
    };
}
