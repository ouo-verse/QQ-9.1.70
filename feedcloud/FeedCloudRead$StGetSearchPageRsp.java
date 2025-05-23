package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetSearchPageRsp extends MessageMicro<FeedCloudRead$StGetSearchPageRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public FeedCloudRead$StSearchTagInfo searchTagInfo = new FeedCloudRead$StSearchTagInfo();
    public FeedCloudRead$StSearchUserInfo searchUserInfo = new FeedCloudRead$StSearchUserInfo();
    public FeedCloudRead$StSearchFeedInfo searchFeedInfo = new FeedCloudRead$StSearchFeedInfo();
    public final PBBoolField isFirstLogin = PBField.initBool(false);
    public final PBBytesField busiReport = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField searchReportData = PBField.initString("");
    public FeedCloudRead$StSearchBannerInfo bannerInfo = new FeedCloudRead$StSearchBannerInfo();
    public FeedCloudRead$StSearchHotEventInfo searchHotEventInfo = new FeedCloudRead$StSearchHotEventInfo();
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudRead$StSearchMixPageTagInfo mixPageTagInfo = new FeedCloudRead$StSearchMixPageTagInfo();
    public FeedCloudRead$StSearchMixPageUserInfo mixPageUserInfo = new FeedCloudRead$StSearchMixPageUserInfo();
    public final PBRepeatMessageField<FeedCloudRead$StSearchSubTag> subTags = PBField.initRepeatMessage(FeedCloudRead$StSearchSubTag.class);
    public FeedCloudRead$StSearchPublisher searchPublisherInfo = new FeedCloudRead$StSearchPublisher();
    public FeedCloudRead$StSearchGame searchGameInfo = new FeedCloudRead$StSearchGame();
    public FeedCloudRead$StSearchMiniApp searchMiniAppInfo = new FeedCloudRead$StSearchMiniApp();
    public FeedCloudRead$StSearchRelatedGoods searchRelatedGoodsInfo = new FeedCloudRead$StSearchRelatedGoods();
    public final PBBoolField grey = PBField.initBool(false);
    public FeedCloudRead$Filter filter = new FeedCloudRead$Filter();
    public FeedCloudRead$StSearchGameDesc searchGameDesc = new FeedCloudRead$StSearchGameDesc();
    public FeedCloudRead$StSearchGameCollection searchGameCollection = new FeedCloudRead$StSearchGameCollection();
    public FeedCloudRead$StCorrectionInfo correction_info = new FeedCloudRead$StCorrectionInfo();
    public FeedCloudRead$StVideoCollectionInfo videoCollection = new FeedCloudRead$StVideoCollectionInfo();
    public FeedCloudRead$StSearchMixTag searchMixTag = new FeedCloudRead$StSearchMixTag();
    public FeedCloudRead$StSearchKuikly searchKuikly = new FeedCloudRead$StSearchKuikly();

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 58, 66, 74, 82, 90, 98, 114, 122, 130, 138, 144, 154, 162, 170, 178, 186, 194, 202}, new String[]{"searchTagInfo", "searchUserInfo", "searchFeedInfo", "isFirstLogin", "busiReport", "searchReportData", "bannerInfo", "searchHotEventInfo", "extInfo", "mixPageTagInfo", "mixPageUserInfo", "subTags", "searchPublisherInfo", "searchGameInfo", "searchMiniAppInfo", "searchRelatedGoodsInfo", "grey", "filter", "searchGameDesc", "searchGameCollection", "correction_info", "videoCollection", "searchMixTag", "searchKuikly"}, new Object[]{null, null, null, bool, ByteStringMicro.EMPTY, "", null, null, null, null, null, null, null, null, null, null, bool, null, null, null, null, null, null, null}, FeedCloudRead$StGetSearchPageRsp.class);
    }
}
