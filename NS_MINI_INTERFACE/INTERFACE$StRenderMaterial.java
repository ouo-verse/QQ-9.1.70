package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StRenderMaterial extends MessageMicro<INTERFACE$StRenderMaterial> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"renderMode", "downloadUrl"}, new Object[]{0, ""}, INTERFACE$StRenderMaterial.class);
    public final PBEnumField renderMode = PBField.initEnum(0);
    public final PBStringField downloadUrl = PBField.initString("");
}
