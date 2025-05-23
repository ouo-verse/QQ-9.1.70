package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudFavoritessvr$GetFavoritesFeedListReq extends MessageMicro<FeedCloudFavoritessvr$GetFavoritesFeedListReq> {
    static final MessageMicro.FieldMap __fieldMap__;

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f398435id = PBField.initUInt64(0);
    public final PBStringField attach_info = PBField.initString("");
    public final PBInt32Field count = PBField.initInt32(0);
    public final PBBoolField isAddFeedsPage = PBField.initBool(false);
    public final PBBoolField isDraft = PBField.initBool(false);
    public FeedCloudCommon$StCommonExt ext_info = new FeedCloudCommon$StCommonExt();

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 82}, new String[]{"id", "attach_info", "count", "isAddFeedsPage", "isDraft", "ext_info"}, new Object[]{0L, "", 0, bool, bool, null}, FeedCloudFavoritessvr$GetFavoritesFeedListReq.class);
    }
}
