package guild;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class GuildShowTag$PersonalMedal extends MessageMicro<GuildShowTag$PersonalMedal> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"start_time", "end_time", "url"}, new Object[]{0L, 0L, ""}, GuildShowTag$PersonalMedal.class);
    public final PBInt64Field start_time = PBField.initInt64(0);
    public final PBInt64Field end_time = PBField.initInt64(0);
    public final PBStringField url = PBField.initString("");
}
