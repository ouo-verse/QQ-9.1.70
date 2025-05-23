package NS_MINI_REALTIMELOG;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class REALTIMELOG$StLogItem extends MessageMicro<REALTIMELOG$StLogItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"log_time", "log_level", "msg"}, new Object[]{0L, 0, ""}, REALTIMELOG$StLogItem.class);
    public final PBInt64Field log_time = PBField.initInt64(0);
    public final PBInt32Field log_level = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f24968msg = PBField.initString("");
}
