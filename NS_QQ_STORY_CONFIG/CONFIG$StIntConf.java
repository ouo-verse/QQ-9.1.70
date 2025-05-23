package NS_QQ_STORY_CONFIG;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CONFIG$StIntConf extends MessageMicro<CONFIG$StIntConf> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"key", "value"}, new Object[]{"", 0L}, CONFIG$StIntConf.class);
    public final PBStringField key = PBField.initString("");
    public final PBInt64Field value = PBField.initInt64(0);
}
