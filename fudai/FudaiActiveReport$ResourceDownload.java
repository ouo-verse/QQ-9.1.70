package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FudaiActiveReport$ResourceDownload extends MessageMicro<FudaiActiveReport$ResourceDownload> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"result", "url", "version", "task_id"}, new Object[]{0, "", 0, 0}, FudaiActiveReport$ResourceDownload.class);
    public final PBEnumField result = PBField.initEnum(0);
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBUInt32Field task_id = PBField.initUInt32(0);
}
