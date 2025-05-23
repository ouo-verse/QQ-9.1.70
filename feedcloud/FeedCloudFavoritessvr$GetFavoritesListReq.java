package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudFavoritessvr$GetFavoritesListReq extends MessageMicro<FeedCloudFavoritessvr$GetFavoritesListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"uin", "count", "attach_info"}, new Object[]{"", 0, ""}, FeedCloudFavoritessvr$GetFavoritesListReq.class);
    public final PBStringField uin = PBField.initString("");
    public final PBInt32Field count = PBField.initInt32(0);
    public final PBStringField attach_info = PBField.initString("");
}
