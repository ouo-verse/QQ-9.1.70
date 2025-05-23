package guild;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GuildShowTag$CustomManageTag extends MessageMicro<GuildShowTag$CustomManageTag> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 24, 32, 40}, new String[]{"tag_name", "color", "role_id", "word_color"}, new Object[]{"", 0, 0L, 0}, GuildShowTag$CustomManageTag.class);
    public final PBStringField tag_name = PBField.initString("");
    public final PBUInt32Field color = PBField.initUInt32(0);
    public final PBUInt64Field role_id = PBField.initUInt64(0);
    public final PBUInt32Field word_color = PBField.initUInt32(0);
}
