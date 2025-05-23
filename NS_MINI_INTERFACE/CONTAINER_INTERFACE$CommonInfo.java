package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CONTAINER_INTERFACE$CommonInfo extends MessageMicro<CONTAINER_INTERFACE$CommonInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"scene_id", "model_type"}, new Object[]{0, 1}, CONTAINER_INTERFACE$CommonInfo.class);
    public final PBUInt32Field scene_id = PBField.initUInt32(0);
    public final PBEnumField model_type = PBField.initEnum(1);
}
