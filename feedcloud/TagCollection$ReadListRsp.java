package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class TagCollection$ReadListRsp extends MessageMicro<TagCollection$ReadListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"unified_id"}, new Object[]{""}, TagCollection$ReadListRsp.class);
    public final PBRepeatField<String> unified_id = PBField.initRepeat(PBStringField.__repeatHelper__);
}
