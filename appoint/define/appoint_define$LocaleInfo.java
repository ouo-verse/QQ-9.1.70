package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class appoint_define$LocaleInfo extends MessageMicro<appoint_define$LocaleInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66}, new String[]{"str_name", "str_country", "str_province", "str_city", "str_region", "str_poi", "msg_gps", "str_address"}, new Object[]{"", "", "", "", "", "", null, ""}, appoint_define$LocaleInfo.class);
    public final PBStringField str_name = PBField.initString("");
    public final PBStringField str_country = PBField.initString("");
    public final PBStringField str_province = PBField.initString("");
    public final PBStringField str_city = PBField.initString("");
    public final PBStringField str_region = PBField.initString("");
    public final PBStringField str_poi = PBField.initString("");
    public appoint_define$GPS msg_gps = new appoint_define$GPS();
    public final PBStringField str_address = PBField.initString("");
}
