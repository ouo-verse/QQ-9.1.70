package feedcloud;

import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tianshu.QQCircleTianShu$RspEntry;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetMainPageCommDataRsp extends MessageMicro<FeedCloudRead$StGetMainPageCommDataRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public FeedCloudRead$UserAlbumInfo albumInfo;
    public final PBBytesField busiPublisherEntrance;
    public final PBBytesField busiRspData;
    public final PBUInt32Field collectionCount;
    public final PBStringField draftBoxButtonName;
    public FeedCloudPubGuideSvr$AdsInfo guide_banner;
    public final PBBoolField isOpenShareAD;
    public final PBUInt32Field likedFeedCount;
    public final PBUInt32Field pushRocketCount;
    public final PBStringField specialMainPageTailText;
    public FeedCloudRead$StTemplateInfo templateInfo;
    public final PBRepeatMessageField<QQCircleTianShu$RspEntry> tianshuMaterialInfos;
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBUInt32Field feedCount = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta$StFeed> vecFeed = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public final PBStringField feedAttchInfo = PBField.initString("");

    static {
        String[] strArr = {"extInfo", QFSSearchBaseRequest.EXTRA_KEY_FEED_COUNT, "vecFeed", "isFinish", "feedAttchInfo", "busiRspData", "likedFeedCount", "pushRocketCount", "collectionCount", "albumInfo", "templateInfo", "busiPublisherEntrance", "draftBoxButtonName", "specialMainPageTailText", "tianshuMaterialInfos", "isOpenShareAD", "guide_banner"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 42, 50, 56, 64, 72, 82, 90, 98, 106, 114, 122, 128, 138}, strArr, new Object[]{null, 0, null, 0, "", byteStringMicro, 0, 0, 0, null, null, byteStringMicro, "", "", null, Boolean.FALSE, null}, FeedCloudRead$StGetMainPageCommDataRsp.class);
    }

    public FeedCloudRead$StGetMainPageCommDataRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.busiRspData = PBField.initBytes(byteStringMicro);
        this.likedFeedCount = PBField.initUInt32(0);
        this.pushRocketCount = PBField.initUInt32(0);
        this.collectionCount = PBField.initUInt32(0);
        this.albumInfo = new FeedCloudRead$UserAlbumInfo();
        this.templateInfo = new FeedCloudRead$StTemplateInfo();
        this.busiPublisherEntrance = PBField.initBytes(byteStringMicro);
        this.draftBoxButtonName = PBField.initString("");
        this.specialMainPageTailText = PBField.initString("");
        this.tianshuMaterialInfos = PBField.initRepeatMessage(QQCircleTianShu$RspEntry.class);
        this.isOpenShareAD = PBField.initBool(false);
        this.guide_banner = new FeedCloudPubGuideSvr$AdsInfo();
    }
}
