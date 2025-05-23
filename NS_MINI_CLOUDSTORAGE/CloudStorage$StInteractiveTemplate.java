package NS_MINI_CLOUDSTORAGE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CloudStorage$StInteractiveTemplate extends MessageMicro<CloudStorage$StInteractiveTemplate> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"action", "object", "ratio"}, new Object[]{"", "", 0}, CloudStorage$StInteractiveTemplate.class);
    public final PBStringField action = PBField.initString("");
    public final PBStringField object = PBField.initString("");
    public final PBUInt32Field ratio = PBField.initUInt32(0);
}
