package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class fd_comm$FDShareMeta extends MessageMicro<fd_comm$FDShareMeta> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"type", "target_id"}, new Object[]{1, 0L}, fd_comm$FDShareMeta.class);
    public final PBEnumField type = PBField.initEnum(1);
    public final PBUInt64Field target_id = PBField.initUInt64(0);
}
