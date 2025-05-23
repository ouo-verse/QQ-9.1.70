package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class META_PROTOCOL$StBaselibVersion extends MessageMicro<META_PROTOCOL$StBaselibVersion> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"version", "affectedPercentage"}, new Object[]{"", ""}, META_PROTOCOL$StBaselibVersion.class);
    public final PBStringField version = PBField.initString("");
    public final PBStringField affectedPercentage = PBField.initString("");
}
