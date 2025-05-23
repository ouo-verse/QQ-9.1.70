package addcontacts;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes.dex */
public final class AccountSearchPb$search extends MessageMicro<AccountSearchPb$search> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field start = PBField.initInt32(0);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBUInt32Field end = PBField.initUInt32(0);
    public final PBStringField keyword = PBField.initString("");
    public final PBRepeatMessageField<AccountSearchPb$record> list = PBField.initRepeatMessage(AccountSearchPb$record.class);
    public final PBRepeatField<String> highlight = PBField.initRepeat(PBStringField.__repeatHelper__);
    public AccountSearchPb$Location msg_user_location = new AccountSearchPb$Location();
    public final PBBoolField bool_location_group = PBField.initBool(false);
    public final PBInt32Field filtertype = PBField.initInt32(0);
    public final PBRepeatMessageField<AccountSearchPb$record> recommend_list = PBField.initRepeatMessage(AccountSearchPb$record.class);
    public AccountSearchPb$hotwordrecord hotword_record = new AccountSearchPb$hotwordrecord();
    public final PBStringField article_more_url = PBField.initString("");
    public final PBRepeatMessageField<AccountSearchPb$ResultItem> result_items = PBField.initRepeatMessage(AccountSearchPb$ResultItem.class);
    public final PBBoolField bool_keyword_suicide = PBField.initBool(false);
    public final PBBoolField bool_exact_search = PBField.initBool(false);
    public final PBStringField trace_id = PBField.initString("");

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 82, 88, 96, 106, 114, 122, 130, 136, 144, 154}, new String[]{"start", "count", "end", "keyword", "list", "highlight", "msg_user_location", "bool_location_group", "filtertype", "recommend_list", "hotword_record", "article_more_url", "result_items", "bool_keyword_suicide", "bool_exact_search", "trace_id"}, new Object[]{0, 0, 0, "", null, "", null, bool, 0, null, null, "", null, bool, bool, ""}, AccountSearchPb$search.class);
    }
}
