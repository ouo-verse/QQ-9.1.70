package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StMaterialDataNew extends MessageMicro<FeedCloudMeta$StMaterialDataNew> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"materialType", "materialList"}, new Object[]{"", null}, FeedCloudMeta$StMaterialDataNew.class);
    public final PBStringField materialType = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudMeta$StSingleMaterial> materialList = PBField.initRepeatMessage(FeedCloudMeta$StSingleMaterial.class);
}
