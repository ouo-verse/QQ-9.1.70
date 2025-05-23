package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import feedcloud.FeedCloudRead$StGetMainPageReq;
import feedcloud.FeedCloudRead$StGetMainPageRsp;
import qqcircle.QQCircleFeedBase$StMainPageBusiReqData;

/* loaded from: classes5.dex */
public class QCircleGetMainPageRequest extends QCircleBaseRequest {
    public FeedCloudRead$StGetMainPageReq mRequest;

    public QCircleGetMainPageRequest(String str) {
        this(str, null);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetMainpage";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    public QCircleGetMainPageRequest(String str, String str2) {
        this(str, str2, null);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        MessageMicro<FeedCloudRead$StGetMainPageRsp> messageMicro = new MessageMicro<FeedCloudRead$StGetMainPageRsp>() { // from class: feedcloud.FeedCloudRead$StGetMainPageRsp
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField busiPublisherEntrance;
            public final PBBytesField busiRspData;
            public final PBUInt32Field collectionCount;
            public final PBUInt32Field fansValueStyle;
            public FeedCloudMeta$StFollowRecomInfo followRecomInfo;
            public FeedCloudMeta$StGuidePublishBubble guidePublishBubble;
            public FeedCloudRead$GuildInfo guildInfo;
            public final PBBoolField isFirstLogin;
            public final PBUInt32Field isPenguinUser;
            public final PBUInt32Field likedFeedCount;
            public final PBUInt32Field likedNum;
            public FeedCloudMeta$StExternalMedalWallInfo medalWall;
            public final PBUInt32Field newAddedFansCount;
            public final PBRepeatMessageField<FeedCloudRead$StMainPageOperateInfo> operateInfo;
            public final PBStringField pmBeginShow;
            public final PBUInt32Field pushRocketCount;
            public FeedCloudRead$StTemplateInfo templateInfo;
            public FeedCloudRead$UserAlbumInfo user_album_info;
            public final PBUInt64Field visitorCount;
            public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
            public FeedCloudMeta$StUser user = new FeedCloudMeta$StUser();
            public final PBUInt32Field feedCount = PBField.initUInt32(0);
            public final PBUInt32Field fansCount = PBField.initUInt32(0);
            public final PBUInt32Field followCount = PBField.initUInt32(0);
            public final PBRepeatMessageField<FeedCloudMeta$StFeed> vecFeed = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
            public final PBUInt32Field isFinish = PBField.initUInt32(0);
            public FeedCloudMeta$StShare share = new FeedCloudMeta$StShare();
            public final PBStringField feedAttchInfo = PBField.initString("");

            static {
                String[] strArr = {"extInfo", QCircleAlphaUserReporter.KEY_USER, QFSSearchBaseRequest.EXTRA_KEY_FEED_COUNT, "fansCount", "followCount", "vecFeed", "isFinish", "share", "feedAttchInfo", "busiRspData", "pmBeginShow", "fansValueStyle", "guidePublishBubble", "isFirstLogin", "pushRocketCount", "followRecomInfo", "medalWall", "likedNum", "likedFeedCount", "isPenguinUser", "busiPublisherEntrance", "newAddedFansCount", "user_album_info", "operateInfo", "templateInfo", "guildInfo", "visitorCount", "collectionCount"};
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50, 56, 66, 74, 82, 90, 96, 106, 112, 120, 130, 138, 144, 152, 160, 170, 176, 186, 194, 202, 210, 216, 224}, strArr, new Object[]{null, null, 0, 0, 0, null, 0, null, "", byteStringMicro, "", 0, null, Boolean.FALSE, 0, null, null, 0, 0, 0, byteStringMicro, 0, null, null, null, null, 0L, 0}, FeedCloudRead$StGetMainPageRsp.class);
            }

            {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                this.busiRspData = PBField.initBytes(byteStringMicro);
                this.pmBeginShow = PBField.initString("");
                this.fansValueStyle = PBField.initUInt32(0);
                this.guidePublishBubble = new FeedCloudMeta$StGuidePublishBubble();
                this.isFirstLogin = PBField.initBool(false);
                this.pushRocketCount = PBField.initUInt32(0);
                this.followRecomInfo = new FeedCloudMeta$StFollowRecomInfo();
                this.medalWall = new FeedCloudMeta$StExternalMedalWallInfo();
                this.likedNum = PBField.initUInt32(0);
                this.likedFeedCount = PBField.initUInt32(0);
                this.isPenguinUser = PBField.initUInt32(0);
                this.busiPublisherEntrance = PBField.initBytes(byteStringMicro);
                this.newAddedFansCount = PBField.initUInt32(0);
                this.user_album_info = new FeedCloudRead$UserAlbumInfo();
                this.operateInfo = PBField.initRepeatMessage(FeedCloudRead$StMainPageOperateInfo.class);
                this.templateInfo = new FeedCloudRead$StTemplateInfo();
                this.guildInfo = new FeedCloudRead$GuildInfo();
                this.visitorCount = PBField.initUInt64(0L);
                this.collectionCount = PBField.initUInt32(0);
            }
        };
        try {
            messageMicro.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return messageMicro;
    }

    public QCircleGetMainPageRequest(String str, String str2, QCircleInitBean qCircleInitBean) {
        FeedCloudRead$StGetMainPageReq feedCloudRead$StGetMainPageReq = new FeedCloudRead$StGetMainPageReq();
        this.mRequest = feedCloudRead$StGetMainPageReq;
        if (str2 != null) {
            feedCloudRead$StGetMainPageReq.feedAttchInfo.set(str2);
        }
        if (str != null) {
            this.mRequest.userId.set(str);
        }
        this.mRequest.from.set(0);
        if (qCircleInitBean != null) {
            if (qCircleInitBean.isMiddlePage()) {
                this.mRequest.isMiddlePage.set(true);
            }
            if (qCircleInitBean.getSchemeAttrs() == null || !qCircleInitBean.getSchemeAttrs().containsKey("key_scheme")) {
                return;
            }
            String str3 = qCircleInitBean.getSchemeAttrs().get("key_scheme");
            QQCircleFeedBase$StMainPageBusiReqData qQCircleFeedBase$StMainPageBusiReqData = new QQCircleFeedBase$StMainPageBusiReqData();
            if (str3 != null) {
                qQCircleFeedBase$StMainPageBusiReqData.entrySchema.set(str3);
            }
            this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StMainPageBusiReqData.toByteArray()));
        }
    }
}
