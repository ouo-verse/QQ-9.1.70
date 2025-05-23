package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudSeedsvr$SEAGIComfyMedia extends MessageMicro<FeedCloudSeedsvr$SEAGIComfyMedia> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"width", "height", "url", "mediaType"}, new Object[]{0, 0, "", 0}, FeedCloudSeedsvr$SEAGIComfyMedia.class);
    public final PBUInt32Field width = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
    public final PBEnumField mediaType = PBField.initEnum(0);
}
