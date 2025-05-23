package feedcloud;

import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StImage extends MessageMicro<FeedCloudMeta$StImage> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 66, 74}, new String[]{"width", "height", "picUrl", "vecImageUrl", "picId", MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA, "imageMD5", "layerPicUrl", "materialList"}, new Object[]{0, 0, "", null, "", ByteStringMicro.EMPTY, "", "", null}, FeedCloudMeta$StImage.class);
    public final PBUInt32Field width = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBStringField picUrl = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudMeta$StImageUrl> vecImageUrl = PBField.initRepeatMessage(FeedCloudMeta$StImageUrl.class);
    public final PBStringField picId = PBField.initString("");
    public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField imageMD5 = PBField.initString("");
    public final PBStringField layerPicUrl = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudMeta$StMaterialDataNew> materialList = PBField.initRepeatMessage(FeedCloudMeta$StMaterialDataNew.class);
}
