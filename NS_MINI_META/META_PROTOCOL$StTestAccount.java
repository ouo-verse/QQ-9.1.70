package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class META_PROTOCOL$StTestAccount extends MessageMicro<META_PROTOCOL$StTestAccount> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"uin", "pwd", "comment"}, new Object[]{"", "", ""}, META_PROTOCOL$StTestAccount.class);
    public final PBStringField uin = PBField.initString("");
    public final PBStringField pwd = PBField.initString("");
    public final PBStringField comment = PBField.initString("");
}
