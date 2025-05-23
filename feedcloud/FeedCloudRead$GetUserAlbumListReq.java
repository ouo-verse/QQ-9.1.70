package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$GetUserAlbumListReq extends MessageMicro<FeedCloudRead$GetUserAlbumListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", "user_id", "attach_info"}, new Object[]{null, "", ""}, FeedCloudRead$GetUserAlbumListReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBStringField user_id = PBField.initString("");
    public final PBStringField attach_info = PBField.initString("");
}
