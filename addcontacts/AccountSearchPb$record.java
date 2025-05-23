package addcontacts;

import com.heytap.databaseengine.type.DeviceType;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.RichStatus;
import cooperation.qqcircle.report.QCircleLpReportDc05494;

/* loaded from: classes.dex */
public final class AccountSearchPb$record extends MessageMicro<AccountSearchPb$record> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field account_flag;
    public final PBUInt64Field account_id;
    public final PBStringField article_author;
    public final PBStringField article_create_time;
    public final PBStringField article_short_url;
    public final PBBytesField bytes_join_group_auth;
    public final PBBytesField bytes_token;
    public final PBUInt32Field city;
    public final PBStringField city_name;
    public final PBUInt32Field class_index;
    public final PBStringField class_name;
    public final PBUInt32Field country;
    public final PBStringField country_name;
    public final PBRepeatMessageField<AccountSearchPb$Label> msg_group_labels;
    public final PBUInt32Field province;
    public final PBStringField province_name;
    public RichStatus richStatus;
    public final PBBytesField sign;
    public final PBStringField title_image;
    public final PBInt32Field uin_privilege;
    public final PBUInt32Field uint32_richflag1_59;
    public final PBUInt32Field uint32_richflag4_409;
    public final PBUInt32Field video_account;
    public final PBUInt32Field video_article;
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt64Field code = PBField.initUInt64(0);
    public final PBEnumField source = PBField.initEnum(1);
    public final PBStringField name = PBField.initString("");
    public final PBUInt32Field sex = PBField.initUInt32(0);
    public final PBUInt32Field age = PBField.initUInt32(0);
    public final PBStringField accout = PBField.initString("");
    public final PBStringField brief = PBField.initString("");
    public final PBUInt32Field number = PBField.initUInt32(0);
    public final PBUInt64Field flag = PBField.initUInt64(0);
    public final PBUInt64Field relation = PBField.initUInt64(0);
    public final PBStringField mobile = PBField.initString("");

    static {
        String[] strArr = {"uin", "code", "source", "name", "sex", "age", "accout", "brief", "number", "flag", "relation", DeviceType.DeviceCategory.MOBILE, "sign", "country", "province", "city", "class_index", PictureConst.KEY_CLASSNAME, QCircleLpReportDc05494.KEY_COUNTRY_NAME, "province_name", "city_name", "account_flag", "title_image", "article_short_url", "article_create_time", "article_author", ReportDataBuilder.KEY_ACCOUNT_ID, "msg_group_labels", "video_account", "video_article", "uin_privilege", "bytes_join_group_auth", "bytes_token", "uint32_richflag1_59", "uint32_richflag4_409"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 58, 66, 72, 80, 88, 98, 106, 112, 120, 128, 136, 146, 154, 162, 170, 176, 186, 194, 202, 210, 216, 242, 248, 256, 264, 274, 4002, 324824, 339272}, strArr, new Object[]{0L, 0L, 1, "", 0, 0, "", "", 0, 0L, 0L, "", byteStringMicro, 0, 0, 0, 0, "", "", "", "", 0, "", "", "", "", 0L, null, 0, 0, 0, byteStringMicro, byteStringMicro, 0, 0}, AccountSearchPb$record.class);
    }

    public AccountSearchPb$record() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.sign = PBField.initBytes(byteStringMicro);
        this.country = PBField.initUInt32(0);
        this.province = PBField.initUInt32(0);
        this.city = PBField.initUInt32(0);
        this.class_index = PBField.initUInt32(0);
        this.class_name = PBField.initString("");
        this.country_name = PBField.initString("");
        this.province_name = PBField.initString("");
        this.city_name = PBField.initString("");
        this.account_flag = PBField.initUInt32(0);
        this.title_image = PBField.initString("");
        this.article_short_url = PBField.initString("");
        this.article_create_time = PBField.initString("");
        this.article_author = PBField.initString("");
        this.account_id = PBField.initUInt64(0L);
        this.msg_group_labels = PBField.initRepeatMessage(AccountSearchPb$Label.class);
        this.video_account = PBField.initUInt32(0);
        this.video_article = PBField.initUInt32(0);
        this.uin_privilege = PBField.initInt32(0);
        this.bytes_join_group_auth = PBField.initBytes(byteStringMicro);
        this.bytes_token = PBField.initBytes(byteStringMicro);
        this.uint32_richflag1_59 = PBField.initUInt32(0);
        this.uint32_richflag4_409 = PBField.initUInt32(0);
    }
}
