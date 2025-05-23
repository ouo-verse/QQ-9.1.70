package ktvchannel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KtvCommon$KVItem extends MessageMicro<KtvCommon$KVItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, KtvCommon$KVItem.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
}
