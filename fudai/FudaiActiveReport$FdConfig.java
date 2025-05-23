package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FudaiActiveReport$FdConfig extends MessageMicro<FudaiActiveReport$FdConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"result", "type", "version", "task_id", "msg"}, new Object[]{0, 0, 0, 0, ""}, FudaiActiveReport$FdConfig.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBUInt32Field task_id = PBField.initUInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f400837msg = PBField.initString("");
}
