package addcontacts;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes.dex */
public final class AccountSearchPb$hotwordrecord extends MessageMicro<AccountSearchPb$hotwordrecord> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42}, new String[]{"hotword", "hotword_type", "hotword_cover_url", "hotword_title", "hotword_description"}, new Object[]{"", 0, "", "", ""}, AccountSearchPb$hotwordrecord.class);
    public final PBStringField hotword = PBField.initString("");
    public final PBUInt32Field hotword_type = PBField.initUInt32(0);
    public final PBStringField hotword_cover_url = PBField.initString("");
    public final PBStringField hotword_title = PBField.initString("");
    public final PBStringField hotword_description = PBField.initString("");
}
