package feedcloud;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudFavoritessvr$GetFavoritesListRsp extends MessageMicro<FeedCloudFavoritessvr$GetFavoritesListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"favorites_list", "draft_favorites_list", PictureConst.KEY_HAS_MORE, "attch_info"}, new Object[]{null, null, Boolean.FALSE, ""}, FeedCloudFavoritessvr$GetFavoritesListRsp.class);
    public final PBRepeatMessageField<FeedCloudFavoritessvr$FavoritesInfo> favorites_list = PBField.initRepeatMessage(FeedCloudFavoritessvr$FavoritesInfo.class);
    public final PBRepeatMessageField<FeedCloudFavoritessvr$FavoritesInfo> draft_favorites_list = PBField.initRepeatMessage(FeedCloudFavoritessvr$FavoritesInfo.class);
    public final PBBoolField has_more = PBField.initBool(false);
    public final PBStringField attch_info = PBField.initString("");
}
