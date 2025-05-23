package feedcloud;

import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StSingleMaterial extends MessageMicro<FeedCloudMeta$StSingleMaterial> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{DKConfiguration.PreloadKeys.KEY_MATERIAL_ID}, new Object[]{""}, FeedCloudMeta$StSingleMaterial.class);
    public final PBStringField materialId = PBField.initString("");
}
