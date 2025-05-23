package NS_QQ_STORY_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class META$StUser extends MessageMicro<META$StUser> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"uin", "nick", "icon", "total"}, new Object[]{0L, "", "", 0}, META$StUser.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField nick = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBUInt32Field total = PBField.initUInt32(0);
}
