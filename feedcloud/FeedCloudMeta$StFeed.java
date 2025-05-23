package feedcloud;

import com.tencent.ad.tangram.statistics.AdReporterForEffect;
import com.tencent.ams.dynamicwidget.http.Method;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBottomDynamicGuideEvent;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.ecommerce.repo.consumer.resp.PlayUI;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.ig.l;
import com.tencent.luggage.wxa.rf.g;
import com.tencent.luggage.wxa.xd.m0;
import com.tencent.mobileqq.activity.richmedia.p2veffect.effect.base.P2VGlobalConfig;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mobileqq.vas.config.business.qvip.QVipServiceAccountFolderProcessor;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import com.tencent.view.FilterEnum;
import tianshu.QQCircleTianShu$RspEntry;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StFeed extends MessageMicro<FeedCloudMeta$StFeed> {
    static final MessageMicro.FieldMap __fieldMap__;
    public FeedCloudMeta$StActivityInfo activityInfo;
    public final PBBytesField adBuffer;
    public FeedCloudMeta$StFeedAdv advInfo;
    public final PBRepeatMessageField<FeedCloudMeta$FeedAlbumInfo> album_infos;
    public final PBRepeatField<String> atUinList;
    public FeedCloudMeta$StTagInfo authSchoolInfo;
    public FeedCloudMeta$AvatarJump avatarJump;
    public FeedCloudMeta$StSpecialPublisherInfo busiCustomPublisherEntrance;
    public final PBBytesField busiData;
    public final PBBytesField busiPublisherEntrance;
    public final PBBytesField busiReport;
    public final PBRepeatMessageField<FeedCloudCommon$BytesEntry> busiTranparent;
    public FeedCloudMeta$StButtomBanner buttomBanner;
    public FeedCloudMeta$StClientInfo clientInfo;
    public FeedCloudMeta$StCollection collection;
    public final PBStringField collectionName;
    public final PBStringField commentBoxDesc;
    public FeedCloudMeta$StCommentExtraInfo commentExtraInfo;
    public FeedCloudMeta$StCommentTextInfo commentTextInfo;
    public FeedCloudMeta$StCommInfo commonInfo;
    public FeedCloudMeta$StCommunityInfo communityInfo;
    public final PBStringField contentLabel;
    public FeedCloudMeta$StCountInfo countinfo;
    public final PBUInt64Field createTimeNs;
    public FeedCloudMeta$StDebugInfo debugInfo;
    public final PBBoolField disableNearbyRecomm;
    public FeedCloudMeta$StDittoFeed dittoFeed;
    public FeedCloudMeta$StEShopGoods eShopGoods;
    public FeedCloudMeta$StEveryoneSearchInfo everyone_search_info;
    public final PBRepeatMessageField<FeedCloudCommon$Entry> extInfo;
    public FeedCloudMeta$StFeedDrawerBase feedDrawerBase;
    public FeedCloudMeta$StFeedExtraInfo feedExtraInfo;
    public FeedCloudMeta$StFeedShowReason feedShowReason;
    public final PBUInt32Field feedSubType;
    public final PBRepeatMessageField<FeedCloudCommon$Entry> feedTextInfo;
    public final PBUInt32Field feedType;
    public final PBStringField feedbackUrl;
    public final PBUInt32Field from;
    public final PBRepeatMessageField<FeedCloudMeta$StGuideInfo> guideInfos;
    public FeedCloudMeta$StHotEventInfo hotEventInfo;
    public final PBBoolField isRecomFd;
    public final PBBoolField iscachedAdsFeeds;
    public FeedCloudMeta$StLiteBanner liteBanner;
    public FeedCloudMeta$StLive live;
    public final PBStringField mainCate;
    public FeedCloudMeta$StFeedMusic musicInfo;
    public final PBRepeatField<Integer> opMask;
    public final PBRepeatField<Integer> opMask2;
    public FeedCloudMeta$StOpinfo opinfo;
    public final PBBoolField orgFeedDeleted;
    public FeedCloudMeta$StPost post;
    public FeedCloudMeta$StPromoteInfo promoteInfo;
    public final PBStringField publishTimeDesc;
    public FeedCloudMeta$StPushList pushList;
    public FeedCloudMeta$StQuickPushBoxInfo quick_push_info;
    public FeedCloudMeta$StRecomForward recomForward;
    public FeedCloudMeta$StRecomInfo recomInfo;
    public FeedCloudMeta$StRecommendInfo recommend_info;
    public final PBBytesField reportInfoForClient;
    public FeedCloudMeta$StRight right;
    public FeedCloudMeta$StSameTopicGuideInfo sameTopicGuideInfo;
    public final PBRepeatField<Integer> secondaryLoadMask;
    public FeedCloudMeta$StSecurityInfo securityInfo;
    public FeedCloudMeta$StShadingWords shading_words;
    public FeedCloudMeta$ShareMessageReplyBox shareMessageReplyBox;
    public final PBStringField sharedUIN;
    public final PBEnumField sourceType;
    public final PBStringField subCate;
    public final PBUInt32Field syncStatus;
    public final PBUInt64Field syncTime;
    public final PBRepeatMessageField<FeedCloudMeta$StTagInfo> tagInfos;
    public final PBRepeatMessageField<QQCircleTianShu$RspEntry> tianshuEntry;
    public final PBRepeatMessageField<FeedCloudCommon$Entry> urlInfo;
    public FeedCloudMeta$StYuHengContentInfo yuhengContentInfos;
    public final PBRepeatMessageField<FeedCloudMeta$StYuHengMaterialInfo> yuhengMaterInfos;

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398449id = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField subtitle = PBField.initString("");
    public FeedCloudMeta$StUser poster = new FeedCloudMeta$StUser();
    public FeedCloudMeta$StImage cover = new FeedCloudMeta$StImage();
    public FeedCloudMeta$StVideo video = new FeedCloudMeta$StVideo();
    public final PBStringField content = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt64Field createTime = PBField.initUInt64(0);
    public FeedCloudMeta$StLike likeInfo = new FeedCloudMeta$StLike();
    public final PBUInt32Field commentCount = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta$StComment> vecComment = PBField.initRepeatMessage(FeedCloudMeta$StComment.class);
    public FeedCloudMeta$StShare share = new FeedCloudMeta$StShare();
    public FeedCloudMeta$StVisitor visitorInfo = new FeedCloudMeta$StVisitor();
    public final PBRepeatMessageField<FeedCloudMeta$StImage> images = PBField.initRepeatMessage(FeedCloudMeta$StImage.class);
    public final PBUInt32Field status = PBField.initUInt32(0);
    public FeedCloudMeta$StPoiInfoV2 poiInfo = new FeedCloudMeta$StPoiInfoV2();

    static {
        int[] iArr = {10, 18, 26, 34, 42, 50, 58, 64, 72, 82, 88, 98, 106, 114, 122, 128, 138, 146, 154, 160, 170, 178, 184, 194, 202, 208, 218, 224, 234, 240, 250, 256, 266, 274, FilterEnum.MIC_PTU_TRANS_XINXIAN, 290, 298, 306, 312, 322, AdReporterForEffect.ACTION_MOBILEAPP_QUICKAPP_OPEN_FAILURE, 338, 346, g.CTRL_INDEX, 362, 370, NotificationUtil.Constants.NOTIFY_ID_APPCENTER_BEGIN, 386, QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_BUTTON_TYPE, 402, 410, 418, PlayUI.UIType.BIG_CARD_SHAPED_PIC, 434, 442, 458, m0.CTRL_INDEX, 474, 482, P2VGlobalConfig.WATER_MARKER_WIDTH, l.CTRL_INDEX, 506, 514, 522, 530, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_REFRESH_PLAYER_WITH_REOPEN_START, 546, PlayerResources.ViewId.SWITCH_LANDSCAPE_BUTTON, PlayerResources.ViewId.GET_MORE_JUMP_AREA, PlayerResources.ViewId.EXTENDED_VIEW_BTN_BUTTON_TEXT, 578, 586, 594, 602, 610, 618, 626, 634, 642, 648, 658, 666, 674, 680, 690, 698, 706, 714, QVipServiceAccountFolderProcessor.CMD, TMAssistantDownloadErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH, 738, 746};
        String[] strArr = {"id", "title", "subtitle", QAdVrReport.ElementID.AD_POSTER, "cover", "video", "content", "type", WadlProxyConsts.CREATE_TIME, "likeInfo", "commentCount", "vecComment", "share", "visitorInfo", "images", "status", "poiInfo", "adBuffer", MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA, "isRecomFd", "recomForward", "tagInfos", "syncStatus", "busiReport", "dittoFeed", "feedType", "busiTranparent", "orgFeedDeleted", "recomInfo", "opMask", "reportInfoForClient", "opMask2", "opinfo", "atUinList", "from", "sameTopicGuideInfo", "clientInfo", "debugInfo", "createTimeNs", "extInfo", "syncTime", "feedbackUrl", "collectionName", "disableNearbyRecomm", "right", "musicInfo", "liteBanner", "busiPublisherEntrance", "feedSubType", "live", "yuhengMaterInfos", "album_infos", "commentBoxDesc", "eShopGoods", "commentTextInfo", "feedShowReason", "feedExtraInfo", "advInfo", "contentLabel", "authSchoolInfo", "promoteInfo", "commentExtraInfo", "tianshuEntry", "buttomBanner", "busiCustomPublisherEntrance", "sourceType", "publishTimeDesc", "yuhengContentInfos", "feedTextInfo", "securityInfo", "quick_push_info", "everyone_search_info", "countinfo", "guideInfos", "recommend_info", "commonInfo", "activityInfo", "communityInfo", "shading_words", "secondaryLoadMask", "feedDrawerBase", Method.POST, "urlInfo", "iscachedAdsFeeds", "collection", "mainCate", "subCate", "hotEventInfo", "shareMessageReplyBox", "sharedUIN", "pushList", "avatarJump"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(iArr, strArr, new Object[]{"", "", "", null, null, null, "", 0, 0L, null, 0, null, null, null, null, 0, null, byteStringMicro, byteStringMicro, bool, null, null, 0, byteStringMicro, null, 0, null, bool, null, 0, byteStringMicro, 0, null, "", 0, null, null, null, 0L, null, 0L, "", "", bool, null, null, null, byteStringMicro, 0, null, null, null, "", null, null, null, null, null, "", null, null, null, null, null, null, 0, "", null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, bool, null, "", "", null, null, "", null, null}, FeedCloudMeta$StFeed.class);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [feedcloud.FeedCloudMeta$AvatarJump] */
    /* JADX WARN: Type inference failed for: r2v29, types: [feedcloud.FeedCloudMeta$StSpecialPublisherInfo] */
    /* JADX WARN: Type inference failed for: r6v3, types: [feedcloud.FeedCloudMeta$StOpinfo] */
    /* JADX WARN: Type inference failed for: r6v7, types: [feedcloud.FeedCloudMeta$StSameTopicGuideInfo] */
    public FeedCloudMeta$StFeed() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.adBuffer = PBField.initBytes(byteStringMicro);
        this.busiData = PBField.initBytes(byteStringMicro);
        this.isRecomFd = PBField.initBool(false);
        this.recomForward = new FeedCloudMeta$StRecomForward();
        this.tagInfos = PBField.initRepeatMessage(FeedCloudMeta$StTagInfo.class);
        this.syncStatus = PBField.initUInt32(0);
        this.busiReport = PBField.initBytes(byteStringMicro);
        this.dittoFeed = new FeedCloudMeta$StDittoFeed();
        this.feedType = PBField.initUInt32(0);
        this.busiTranparent = PBField.initRepeatMessage(FeedCloudCommon$BytesEntry.class);
        this.orgFeedDeleted = PBField.initBool(false);
        this.recomInfo = new FeedCloudMeta$StRecomInfo();
        PBUInt32Field pBUInt32Field = PBUInt32Field.__repeatHelper__;
        this.opMask = PBField.initRepeat(pBUInt32Field);
        this.reportInfoForClient = PBField.initBytes(byteStringMicro);
        this.opMask2 = PBField.initRepeat(pBUInt32Field);
        this.opinfo = new MessageMicro<FeedCloudMeta$StOpinfo>() { // from class: feedcloud.FeedCloudMeta$StOpinfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{WadlProxyConsts.CREATE_TIME}, new Object[]{0L}, FeedCloudMeta$StOpinfo.class);
            public final PBRepeatField<Long> createTime = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        };
        this.atUinList = PBField.initRepeat(PBStringField.__repeatHelper__);
        this.from = PBField.initUInt32(0);
        this.sameTopicGuideInfo = new MessageMicro<FeedCloudMeta$StSameTopicGuideInfo>() { // from class: feedcloud.FeedCloudMeta$StSameTopicGuideInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50}, new String[]{"isSameTopicGuide", "stayShowTime", "hashTag", "words", WadlProxyConsts.KEY_JUMP_URL, "reportExt"}, new Object[]{0, 0L, "", "", "", ""}, FeedCloudMeta$StSameTopicGuideInfo.class);
            public final PBUInt32Field isSameTopicGuide = PBField.initUInt32(0);
            public final PBInt64Field stayShowTime = PBField.initInt64(0);
            public final PBStringField hashTag = PBField.initString("");
            public final PBStringField words = PBField.initString("");
            public final PBStringField jumpUrl = PBField.initString("");
            public final PBStringField reportExt = PBField.initString("");
        };
        this.clientInfo = new FeedCloudMeta$StClientInfo();
        this.debugInfo = new FeedCloudMeta$StDebugInfo();
        this.createTimeNs = PBField.initUInt64(0L);
        this.extInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
        this.syncTime = PBField.initUInt64(0L);
        this.feedbackUrl = PBField.initString("");
        this.collectionName = PBField.initString("");
        this.disableNearbyRecomm = PBField.initBool(false);
        this.right = new FeedCloudMeta$StRight();
        this.musicInfo = new FeedCloudMeta$StFeedMusic();
        this.liteBanner = new FeedCloudMeta$StLiteBanner();
        this.busiPublisherEntrance = PBField.initBytes(byteStringMicro);
        this.feedSubType = PBField.initUInt32(0);
        this.live = new FeedCloudMeta$StLive();
        this.yuhengMaterInfos = PBField.initRepeatMessage(FeedCloudMeta$StYuHengMaterialInfo.class);
        this.album_infos = PBField.initRepeatMessage(FeedCloudMeta$FeedAlbumInfo.class);
        this.commentBoxDesc = PBField.initString("");
        this.eShopGoods = new FeedCloudMeta$StEShopGoods();
        this.commentTextInfo = new FeedCloudMeta$StCommentTextInfo();
        this.feedShowReason = new FeedCloudMeta$StFeedShowReason();
        this.feedExtraInfo = new FeedCloudMeta$StFeedExtraInfo();
        this.advInfo = new FeedCloudMeta$StFeedAdv();
        this.contentLabel = PBField.initString("");
        this.authSchoolInfo = new FeedCloudMeta$StTagInfo();
        this.promoteInfo = new FeedCloudMeta$StPromoteInfo();
        this.commentExtraInfo = new FeedCloudMeta$StCommentExtraInfo();
        this.tianshuEntry = PBField.initRepeatMessage(QQCircleTianShu$RspEntry.class);
        this.buttomBanner = new FeedCloudMeta$StButtomBanner();
        this.busiCustomPublisherEntrance = new MessageMicro<FeedCloudMeta$StSpecialPublisherInfo>() { // from class: feedcloud.FeedCloudMeta$StSpecialPublisherInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"id", "publisherSchema", "tip"}, new Object[]{0, "", null}, FeedCloudMeta$StSpecialPublisherInfo.class);

            /* renamed from: id, reason: collision with root package name */
            public final PBUInt32Field f398462id = PBField.initUInt32(0);
            public final PBStringField publisherSchema = PBField.initString("");
            public FeedCloudMeta$DisplayedTips tip = new MessageMicro<FeedCloudMeta$DisplayedTips>() { // from class: feedcloud.FeedCloudMeta$DisplayedTips
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40}, new String[]{"id", "text", "durationMs", "canExpose", "showAfterTime"}, new Object[]{0, "", 0, Boolean.FALSE, 0}, FeedCloudMeta$DisplayedTips.class);

                /* renamed from: id, reason: collision with root package name */
                public final PBUInt32Field f398440id = PBField.initUInt32(0);
                public final PBStringField text = PBField.initString("");
                public final PBUInt32Field durationMs = PBField.initUInt32(0);
                public final PBBoolField canExpose = PBField.initBool(false);
                public final PBUInt32Field showAfterTime = PBField.initUInt32(0);
            };
        };
        this.sourceType = PBField.initEnum(0);
        this.publishTimeDesc = PBField.initString("");
        this.yuhengContentInfos = new FeedCloudMeta$StYuHengContentInfo();
        this.feedTextInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
        this.securityInfo = new FeedCloudMeta$StSecurityInfo();
        this.quick_push_info = new FeedCloudMeta$StQuickPushBoxInfo();
        this.everyone_search_info = new FeedCloudMeta$StEveryoneSearchInfo();
        this.countinfo = new FeedCloudMeta$StCountInfo();
        this.guideInfos = PBField.initRepeatMessage(FeedCloudMeta$StGuideInfo.class);
        this.recommend_info = new FeedCloudMeta$StRecommendInfo();
        this.commonInfo = new FeedCloudMeta$StCommInfo();
        this.activityInfo = new FeedCloudMeta$StActivityInfo();
        this.communityInfo = new FeedCloudMeta$StCommunityInfo();
        this.shading_words = new FeedCloudMeta$StShadingWords();
        this.secondaryLoadMask = PBField.initRepeat(pBUInt32Field);
        this.feedDrawerBase = new FeedCloudMeta$StFeedDrawerBase();
        this.post = new FeedCloudMeta$StPost();
        this.urlInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
        this.iscachedAdsFeeds = PBField.initBool(false);
        this.collection = new FeedCloudMeta$StCollection();
        this.mainCate = PBField.initString("");
        this.subCate = PBField.initString("");
        this.hotEventInfo = new FeedCloudMeta$StHotEventInfo();
        this.shareMessageReplyBox = new FeedCloudMeta$ShareMessageReplyBox();
        this.sharedUIN = PBField.initString("");
        this.pushList = new FeedCloudMeta$StPushList();
        this.avatarJump = new MessageMicro<FeedCloudMeta$AvatarJump>() { // from class: feedcloud.FeedCloudMeta$AvatarJump
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"type"}, new Object[]{0}, FeedCloudMeta$AvatarJump.class);
            public final PBEnumField type = PBField.initEnum(0);
        };
    }
}
