package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FudaiActiveReport$ExceptionHandle extends MessageMicro<FudaiActiveReport$ExceptionHandle> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"task_id", "errcode", "msg", "version"}, new Object[]{0, 0, "", 0}, FudaiActiveReport$ExceptionHandle.class);
    public final PBUInt32Field task_id = PBField.initUInt32(0);
    public final PBEnumField errcode = PBField.initEnum(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f400836msg = PBField.initString("");
    public final PBUInt32Field version = PBField.initUInt32(0);
}
