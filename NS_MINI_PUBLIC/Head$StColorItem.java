package NS_MINI_PUBLIC;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Head$StColorItem extends MessageMicro<Head$StColorItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"moduleName", "l5Mod", "l5Cmd"}, new Object[]{"", 0, 0}, Head$StColorItem.class);
    public final PBStringField moduleName = PBField.initString("");
    public final PBInt32Field l5Mod = PBField.initInt32(0);
    public final PBInt32Field l5Cmd = PBField.initInt32(0);
}
