package feedcloud;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$GetFeedAdviceReq extends MessageMicro<FeedCloudRead$GetFeedAdviceReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40}, new String[]{"extInfo", "user_id", "from", "feed_id", AlbumCacheData.CREATE_TIME}, new Object[]{null, "", 0, "", 0L}, FeedCloudRead$GetFeedAdviceReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBStringField user_id = PBField.initString("");
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBStringField feed_id = PBField.initString("");
    public final PBInt64Field create_time = PBField.initInt64(0);
}
