package feedcloud;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StEShopGoodsInfo extends MessageMicro<FeedCloudMeta$StEShopGoodsInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"id", "name", "desc", "goodsJumpInfo", "cover", "customTitle"}, new Object[]{"", "", "", null, null, ""}, FeedCloudMeta$StEShopGoodsInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398448id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public FeedCloudMeta$StEShopJumpInfo goodsJumpInfo = new MessageMicro<FeedCloudMeta$StEShopJumpInfo>() { // from class: feedcloud.FeedCloudMeta$StEShopJumpInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{WadlProxyConsts.KEY_JUMP_URL}, new Object[]{""}, FeedCloudMeta$StEShopJumpInfo.class);
        public final PBStringField jumpUrl = PBField.initString("");
    };
    public FeedCloudMeta$StImage cover = new FeedCloudMeta$StImage();
    public final PBStringField customTitle = PBField.initString("");
}
