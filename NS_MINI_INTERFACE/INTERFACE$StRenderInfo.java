package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StRenderInfo extends MessageMicro<INTERFACE$StRenderInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"renderMode", "renderMaterials"}, new Object[]{0, null}, INTERFACE$StRenderInfo.class);
    public final PBEnumField renderMode = PBField.initEnum(0);
    public final PBRepeatMessageField<INTERFACE$StRenderMaterial> renderMaterials = PBField.initRepeatMessage(INTERFACE$StRenderMaterial.class);
}
