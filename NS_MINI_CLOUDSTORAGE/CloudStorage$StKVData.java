package NS_MINI_CLOUDSTORAGE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CloudStorage$StKVData extends MessageMicro<CloudStorage$StKVData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, CloudStorage$StKVData.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
}
