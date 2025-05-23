package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudFavoritessvr$FavoritesPeople extends MessageMicro<FeedCloudFavoritessvr$FavoritesPeople> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"owner_id", "status"}, new Object[]{"", 0}, FeedCloudFavoritessvr$FavoritesPeople.class);
    public final PBStringField owner_id = PBField.initString("");
    public final PBEnumField status = PBField.initEnum(0);
}
