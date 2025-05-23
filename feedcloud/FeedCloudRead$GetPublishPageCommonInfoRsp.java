package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudRead$GetPublishPageCommonInfoRsp extends MessageMicro<FeedCloudRead$GetPublishPageCommonInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", "userEShopInfo", "publishUser"}, new Object[]{null, null, null}, FeedCloudRead$GetPublishPageCommonInfoRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudRead$StUserEShopInfo userEShopInfo = new MessageMicro<FeedCloudRead$StUserEShopInfo>() { // from class: feedcloud.FeedCloudRead$StUserEShopInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"isBindEShop", "goodsPickPageUrl"}, new Object[]{Boolean.FALSE, ""}, FeedCloudRead$StUserEShopInfo.class);
        public final PBBoolField isBindEShop = PBField.initBool(false);
        public final PBStringField goodsPickPageUrl = PBField.initString("");
    };
    public FeedCloudMeta$StUser publishUser = new FeedCloudMeta$StUser();
}
