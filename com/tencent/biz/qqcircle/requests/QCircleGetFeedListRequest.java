package com.tencent.biz.qqcircle.requests;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.HotEventInfo;
import com.tencent.biz.qqcircle.beans.QCircleAlbumBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizeDetailBean;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.PbExtKt;
import com.tencent.biz.qqcircle.immersive.utils.j;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.RequestInterceptor;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$FeedAlbum;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StTagInfo;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudRead$StGetFeedListReq;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.HashMap;
import qqcircle.QQCircleFeedBase$StFeedListBusiReqData;
import uq3.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleGetFeedListRequest extends QCircleBaseRequest {
    private String mCmd;
    private String mDtPageId;
    private QCircleInitBean mInitBean;
    private boolean mIsLoadFullScreenFeed;
    private boolean mIsLoadMore;
    private final int mListNum;
    public FeedCloudRead$StGetFeedListReq mRequest;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements RequestInterceptor {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.request.RequestInterceptor
        public void interceptRequest(BaseRequest baseRequest) {
            com.tencent.biz.richframework.network.request.a.a(this, baseRequest);
            cq.f92752a.b(QCircleGetFeedListRequest.this.mRequest);
        }

        @Override // com.tencent.biz.richframework.network.request.RequestInterceptor
        public /* synthetic */ void interceptResponse(Object[] objArr) {
            com.tencent.biz.richframework.network.request.a.b(this, objArr);
        }
    }

    public QCircleGetFeedListRequest(String str, String str2, String str3, String str4) {
        this(str, str2, false, str3, str4);
    }

    private void a() {
        if (this.mRequest == null) {
            return;
        }
        addRequestInterceptor(new a());
    }

    private void b(QQCircleFeedBase$StFeedListBusiReqData qQCircleFeedBase$StFeedListBusiReqData) {
        int i3;
        try {
            i3 = Integer.parseInt(c.x2());
        } catch (Exception e16) {
            e16.printStackTrace();
            i3 = 0;
        }
        QLog.i("QCircleGetFeedListRequest", 1, "isNewLayerMode:" + i3);
        if (i3 > 0) {
            qQCircleFeedBase$StFeedListBusiReqData.pageLayoutType.set(i3);
        }
    }

    private void c(int i3) {
        if (i3 != -1) {
            if (i3 != 0) {
                if (i3 == 1) {
                    this.mRequest.source.set(69);
                    return;
                }
                return;
            }
            this.mRequest.source.set(68);
            return;
        }
        this.mRequest.source.set(7);
    }

    public static int covertToProtocolSource(int i3) {
        if (i3 == 1) {
            return 1;
        }
        if (i3 != 88) {
            if (i3 != 69) {
                if (i3 == 70) {
                    return 1;
                }
                switch (i3) {
                    case 3:
                        return 3;
                    case 4:
                        return 4;
                    case 5:
                        return 5;
                    case 6:
                        return 6;
                    case 7:
                        return 7;
                    case 8:
                    case 11:
                        return 8;
                    case 9:
                        return 9;
                    case 10:
                        return 10;
                    case 12:
                        return 16;
                    case 13:
                        return 20;
                    default:
                        return i3;
                }
            }
            return 17;
        }
        return 10;
    }

    private void d(QCircleInitBean qCircleInitBean, QQCircleFeedBase$StFeedListBusiReqData qQCircleFeedBase$StFeedListBusiReqData) {
        String str;
        if (qCircleInitBean == null) {
            return;
        }
        if (qCircleInitBean.isMiddlePage()) {
            this.mRequest.isMiddlePage.set(true);
        }
        if (qCircleInitBean.getSchemeAttrs() != null && qCircleInitBean.getSchemeAttrs().containsKey("key_scheme") && (str = qCircleInitBean.getSchemeAttrs().get("key_scheme")) != null) {
            qQCircleFeedBase$StFeedListBusiReqData.entrySchema.set(str);
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return this.mCmd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest
    public int getCount(@Nullable Object obj) {
        PBRepeatMessageField<FeedCloudMeta$StFeed> pBRepeatMessageField;
        if ((obj instanceof FeedCloudRead$StGetFeedListRsp) && (pBRepeatMessageField = ((FeedCloudRead$StGetFeedListRsp) obj).vecFeed) != null) {
            return pBRepeatMessageField.get().size();
        }
        return super.getCount(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest
    public String getExt1() {
        return this.mDtPageId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest
    public String getInfo() {
        HashMap<String, String> hashMap;
        QCircleInitBean qCircleInitBean = this.mInitBean;
        if (qCircleInitBean != null) {
            hashMap = qCircleInitBean.getSchemeAttrs();
        } else {
            hashMap = null;
        }
        if (hashMap != null && hashMap.size() > 0) {
            return hashMap.get("xsj_main_entrance");
        }
        return super.getInfo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest
    public String getRefer() {
        FeedCloudRead$StGetFeedListReq feedCloudRead$StGetFeedListReq = this.mRequest;
        if (feedCloudRead$StGetFeedListReq == null) {
            return super.getRefer();
        }
        if (!TextUtils.isEmpty(feedCloudRead$StGetFeedListReq.feedAttchInfo.get())) {
            return "0";
        }
        return "1";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public byte[] getRequestByteKey() {
        return get$pbReqBytes();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest
    public String getType() {
        FeedCloudRead$StGetFeedListReq feedCloudRead$StGetFeedListReq = this.mRequest;
        if (feedCloudRead$StGetFeedListReq != null) {
            return String.valueOf(feedCloudRead$StGetFeedListReq.source.get());
        }
        return super.getType();
    }

    protected boolean isLoadFullScreenFeed(int i3) {
        return this.mIsLoadFullScreenFeed;
    }

    public void setDtPageId(String str) {
        this.mDtPageId = str;
    }

    public void setIsLoadMore(boolean z16) {
        this.mIsLoadMore = z16;
    }

    public void setLoadFullScreenFeed(boolean z16) {
        this.mIsLoadFullScreenFeed = z16;
    }

    public QCircleGetFeedListRequest(String str, String str2, boolean z16, String str3, String str4) {
        this.mListNum = 10;
        this.mIsLoadFullScreenFeed = false;
        this.mCmd = QCircleTabGetFeedListRequest.CMD_GET_FEED_LIST;
        FeedCloudRead$StGetFeedListReq feedCloudRead$StGetFeedListReq = new FeedCloudRead$StGetFeedListReq();
        this.mRequest = feedCloudRead$StGetFeedListReq;
        if (str3 != null) {
            feedCloudRead$StGetFeedListReq.feedAttchInfo.set(str3);
        }
        this.mRequest.listNum.set(10);
        this.mRequest.from.set(0);
        this.mRequest.source.set(7);
        QQCircleFeedBase$StFeedListBusiReqData qQCircleFeedBase$StFeedListBusiReqData = new QQCircleFeedBase$StFeedListBusiReqData();
        if (!TextUtils.isEmpty(str)) {
            qQCircleFeedBase$StFeedListBusiReqData.tagId.set(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            qQCircleFeedBase$StFeedListBusiReqData.tagName.set(str2);
        }
        if (str4 != null) {
            qQCircleFeedBase$StFeedListBusiReqData.refreshAttachInfo.set(str4);
            QLog.d("QCircleGetFeedListRequest", 2, "QCircleGetFeedListRequest RefreshAttachInfo:" + str4);
        }
        qQCircleFeedBase$StFeedListBusiReqData.isReqLayer.set(z16);
        this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StFeedListBusiReqData.toByteArray()));
        setTimeout(c.P4());
        a();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp = new FeedCloudRead$StGetFeedListRsp();
        try {
            feedCloudRead$StGetFeedListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetFeedListRsp;
    }

    public QCircleGetFeedListRequest(String str, String str2, String str3) {
        this.mListNum = 10;
        this.mIsLoadFullScreenFeed = false;
        this.mCmd = QCircleTabGetFeedListRequest.CMD_GET_FEED_LIST;
        FeedCloudRead$StGetFeedListReq feedCloudRead$StGetFeedListReq = new FeedCloudRead$StGetFeedListReq();
        this.mRequest = feedCloudRead$StGetFeedListReq;
        if (str2 != null) {
            feedCloudRead$StGetFeedListReq.feedAttchInfo.set(str2);
        }
        this.mRequest.listNum.set(10);
        this.mRequest.from.set(0);
        this.mRequest.source.set(9);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
        FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
        feedCloudMeta$StUser.f398463id.set(str);
        feedCloudMeta$StFeed.poster.set(feedCloudMeta$StUser);
        this.mRequest.feed.set(feedCloudMeta$StFeed);
        QQCircleFeedBase$StFeedListBusiReqData qQCircleFeedBase$StFeedListBusiReqData = new QQCircleFeedBase$StFeedListBusiReqData();
        if (str3 != null) {
            qQCircleFeedBase$StFeedListBusiReqData.refreshAttachInfo.set(str3);
            QLog.d("QCircleGetFeedListRequest", 2, "QCircleGetFeedListRequest RefreshAttachInfo:" + str3);
        }
        this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StFeedListBusiReqData.toByteArray()));
        setTimeout(c.P4());
        a();
    }

    public QCircleGetFeedListRequest(QCirclePolymerizationBean qCirclePolymerizationBean, String str, String str2) {
        this.mListNum = 10;
        this.mIsLoadFullScreenFeed = false;
        this.mCmd = QCircleTabGetFeedListRequest.CMD_GET_FEED_LIST;
        if (qCirclePolymerizationBean == null) {
            return;
        }
        this.mRequest = new FeedCloudRead$StGetFeedListReq();
        if (!TextUtils.isEmpty(str)) {
            this.mRequest.feedAttchInfo.set(str);
        }
        this.mRequest.listNum.set(10);
        this.mRequest.from.set(qCirclePolymerizationBean.isFromGalleryPage() ? 10 : 0);
        QQCircleFeedBase$StFeedListBusiReqData qQCircleFeedBase$StFeedListBusiReqData = new QQCircleFeedBase$StFeedListBusiReqData();
        if (!TextUtils.isEmpty(str2)) {
            qQCircleFeedBase$StFeedListBusiReqData.refreshAttachInfo.set(str2);
        }
        int polymerizationType = qCirclePolymerizationBean.getPolymerizationType();
        if (polymerizationType == 4) {
            this.mRequest.source.set(4);
            FeedCloudMeta$StTagInfo tagInfo = qCirclePolymerizationBean.getTagInfo();
            if (qCirclePolymerizationBean.getTagInfo().has()) {
                if (!TextUtils.isEmpty(tagInfo.tagId.get())) {
                    qQCircleFeedBase$StFeedListBusiReqData.tagId.set(tagInfo.tagId.get());
                }
                if (!TextUtils.isEmpty(tagInfo.tagName.get())) {
                    qQCircleFeedBase$StFeedListBusiReqData.tagName.set(tagInfo.tagName.get());
                }
                QLog.d("QCircleGetFeedListRequest", 1, "QCircleGetFeedListRequest schoolPolymerization tagId: " + tagInfo.tagId.get() + " , tagname: " + tagInfo.tagName.get());
            }
        } else if (polymerizationType == 7) {
            c(qCirclePolymerizationBean.getTagTabType());
            FeedCloudMeta$StTagInfo tagInfo2 = qCirclePolymerizationBean.getTagInfo();
            if (qCirclePolymerizationBean.getTagInfo().has()) {
                if (!TextUtils.isEmpty(tagInfo2.tagId.get())) {
                    qQCircleFeedBase$StFeedListBusiReqData.tagId.set(tagInfo2.tagId.get());
                }
                if (!TextUtils.isEmpty(tagInfo2.tagName.get())) {
                    qQCircleFeedBase$StFeedListBusiReqData.tagName.set(tagInfo2.tagName.get());
                }
                QLog.d("QCircleGetFeedListRequest", 1, "QCircleGetFeedListRequest tagPolymerization tagId: " + tagInfo2.tagId.get() + " , tagname: " + tagInfo2.tagName.get());
            }
        } else if (polymerizationType == 16) {
            this.mRequest.source.set(16);
            if (qCirclePolymerizationBean.getPoiInfo().has()) {
                if (!TextUtils.isEmpty(qCirclePolymerizationBean.getPoiInfo().name.get())) {
                    qQCircleFeedBase$StFeedListBusiReqData.tagName.set(qCirclePolymerizationBean.getPoiInfo().name.get());
                }
                if (qCirclePolymerizationBean.getPoiInfo().gps.has()) {
                    qQCircleFeedBase$StFeedListBusiReqData.gpsInfo.set(qCirclePolymerizationBean.getPoiInfo().gps.get());
                }
                QLog.d("QCircleGetFeedListRequest", 1, "QCircleGetFeedListRequest lbsPolymerization  tagname: " + qQCircleFeedBase$StFeedListBusiReqData.tagName.get());
            }
        } else if (polymerizationType == 20) {
            this.mRequest.source.set(20);
            if (qCirclePolymerizationBean.getSimulateData().has()) {
                qQCircleFeedBase$StFeedListBusiReqData.simulateInfo.set(qCirclePolymerizationBean.getSimulateData());
            }
            QLog.d("QCircleGetFeedListRequest", 1, "QCircleGetFeedListRequest patSamePolymerization  simulate_name: " + qQCircleFeedBase$StFeedListBusiReqData.simulateInfo.simulate_name.get());
        } else if (polymerizationType == 63) {
            this.mRequest.source.set(63);
            HotEventInfo hotEventInfo = qCirclePolymerizationBean.getHotEventInfo();
            if (hotEventInfo != null) {
                PbExtKt.b(this.mRequest.extInfo.mapInfo, hotEventInfo);
                String id5 = hotEventInfo.getId();
                if (TextUtils.isEmpty(id5)) {
                    QLog.e("QCircleGetFeedListRequest", 1, "QCircleGetFeedListRequest hotEventId is empty");
                } else {
                    qQCircleFeedBase$StFeedListBusiReqData.tagId.set(id5);
                    QLog.d("QCircleGetFeedListRequest", 1, "hotEventPolymerization eventId: " + id5);
                }
            }
        }
        QLog.d("QCircleGetFeedListRequest", 1, "QCircleGetFeedListRequest polymerization type: " + qCirclePolymerizationBean.getPolymerizationType());
        d(qCirclePolymerizationBean, qQCircleFeedBase$StFeedListBusiReqData);
        this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StFeedListBusiReqData.toByteArray()));
        setTimeout(c.P4());
        a();
    }

    public QCircleGetFeedListRequest(QCirclePolymerizeDetailBean qCirclePolymerizeDetailBean, String str, String str2) {
        this(qCirclePolymerizeDetailBean, str, str2, false);
    }

    public QCircleGetFeedListRequest(QCirclePolymerizeDetailBean qCirclePolymerizeDetailBean, String str, String str2, boolean z16) {
        this.mListNum = 10;
        this.mIsLoadFullScreenFeed = false;
        this.mCmd = QCircleTabGetFeedListRequest.CMD_GET_FEED_LIST;
        if (qCirclePolymerizeDetailBean == null) {
            return;
        }
        this.mRequest = new FeedCloudRead$StGetFeedListReq();
        if (!TextUtils.isEmpty(str)) {
            this.mRequest.feedAttchInfo.set(str);
        }
        this.mRequest.listNum.set(10);
        this.mRequest.from.set(0);
        this.mRequest.source.set(qCirclePolymerizeDetailBean.getSourceType());
        QQCircleFeedBase$StFeedListBusiReqData qQCircleFeedBase$StFeedListBusiReqData = new QQCircleFeedBase$StFeedListBusiReqData();
        if (!TextUtils.isEmpty(str2)) {
            qQCircleFeedBase$StFeedListBusiReqData.refreshAttachInfo.set(str2);
        }
        if (qCirclePolymerizeDetailBean.getTransData() != null) {
            qQCircleFeedBase$StFeedListBusiReqData.schemaTrans.set(qCirclePolymerizeDetailBean.getTransData());
        }
        qQCircleFeedBase$StFeedListBusiReqData.groupNumber.set(qCirclePolymerizeDetailBean.getGroupId());
        qQCircleFeedBase$StFeedListBusiReqData.isNewPageStyle.set(z16);
        d(qCirclePolymerizeDetailBean, qQCircleFeedBase$StFeedListBusiReqData);
        b(qQCircleFeedBase$StFeedListBusiReqData);
        this.mRequest.adres.set(j.f90213a.m(qQCircleFeedBase$StFeedListBusiReqData.entrySchema.get(), qCirclePolymerizeDetailBean.getFromReportBean() == null ? "" : qCirclePolymerizeDetailBean.getFromReportBean().getDtFromPageId()));
        this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StFeedListBusiReqData.toByteArray()));
        setTimeout(c.P4());
        a();
    }

    public QCircleGetFeedListRequest(QCircleInitBean qCircleInitBean, String str, String str2, String str3) {
        this.mListNum = 10;
        this.mIsLoadFullScreenFeed = false;
        this.mCmd = QCircleTabGetFeedListRequest.CMD_GET_FEED_LIST;
        this.mInitBean = qCircleInitBean;
        this.mRequest = new FeedCloudRead$StGetFeedListReq();
        FeedCloudMeta$StFeed simpleFeed = QCirclePluginUtil.getSimpleFeed(qCircleInitBean.getFeed());
        if (qCircleInitBean.getExtraTypeInfo().sourceType == 9) {
            this.mRequest.dstUserId.set(qCircleInitBean.getUin());
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102085", true);
        if (str == null && !isSwitchOn) {
            this.mRequest.feed.set(simpleFeed);
            this.mRequest.feed.busiTranparent.set(qCircleInitBean.getFeed().busiTranparent.get());
        }
        this.mRequest.source.set(covertToProtocolSource(qCircleInitBean.getExtraTypeInfo().sourceType));
        this.mRequest.isFetchFullScreenFeed.set(isLoadFullScreenFeed(qCircleInitBean.getExtraTypeInfo().sourceType));
        this.mRequest.listNum.set(10);
        if (str2 != null) {
            this.mRequest.adAttchInfo.set(str2);
        }
        if (str != null) {
            this.mRequest.feedAttchInfo.set(str);
        }
        QQCircleFeedBase$StFeedListBusiReqData feedListBusiReq = qCircleInitBean.getFeedListBusiReq();
        feedListBusiReq.isReqLayer.set(true);
        feedListBusiReq.detailFeed.set(simpleFeed);
        if (TextUtils.isEmpty(feedListBusiReq.tagId.get()) && TextUtils.isEmpty(feedListBusiReq.tagName.get()) && qCircleInitBean.getFeed().tagInfos.has() && qCircleInitBean.getFeed().tagInfos.get().size() > 0) {
            feedListBusiReq.tagId.set(qCircleInitBean.getFeed().tagInfos.get().get(0).tagId.get());
            feedListBusiReq.tagName.set(qCircleInitBean.getFeed().tagInfos.get().get(0).tagName.get());
        }
        if (qCircleInitBean.getPoiInfo().has()) {
            feedListBusiReq.tagName.set(qCircleInitBean.getPoiInfo().name.get());
        }
        if (str3 != null) {
            feedListBusiReq.refreshAttachInfo.set(str3);
            QLog.d("QCircleGetFeedListRequest", 2, "QCircleGetFeedListRequest RefreshAttachInfo:" + str3);
        }
        if (qCircleInitBean.getExtraTypeInfo().sourceType == 5) {
            feedListBusiReq.gpsInfo.set(com.tencent.biz.qqcircle.c.e().d());
            QLog.d("QCircleGetFeedListRequest", 2, "QCircleGetFeedListRequest setGpsInfo from nearbyTab:" + com.tencent.biz.qqcircle.c.e().d());
        }
        b(feedListBusiReq);
        this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(feedListBusiReq.toByteArray()));
        setTimeout(c.P4());
        a();
    }

    public QCircleGetFeedListRequest(QCircleInitBean qCircleInitBean, String str) {
        this.mListNum = 10;
        this.mIsLoadFullScreenFeed = false;
        this.mCmd = QCircleTabGetFeedListRequest.CMD_GET_FEED_LIST;
        this.mRequest = new FeedCloudRead$StGetFeedListReq();
        if (qCircleInitBean == null) {
            return;
        }
        FeedCloudMeta$StFeed simpleFeed = QCirclePluginUtil.getSimpleFeed(qCircleInitBean.getFeed());
        if (str == null) {
            this.mRequest.feed.set(simpleFeed);
            this.mRequest.feed.busiTranparent.set(qCircleInitBean.getFeed().busiTranparent.get());
        }
        this.mRequest.source.set(17);
        this.mRequest.listNum.set(10);
        if (str != null) {
            this.mRequest.feedAttchInfo.set(str);
        }
        QQCircleFeedBase$StFeedListBusiReqData feedListBusiReq = qCircleInitBean.getFeedListBusiReq();
        feedListBusiReq.detailFeed.set(simpleFeed);
        this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(feedListBusiReq.toByteArray()));
        setTimeout(c.P4());
        a();
    }

    public QCircleGetFeedListRequest(QCircleAlbumBean qCircleAlbumBean, String str) {
        this.mListNum = 10;
        this.mIsLoadFullScreenFeed = false;
        this.mCmd = QCircleTabGetFeedListRequest.CMD_GET_FEED_LIST;
        this.mRequest = new FeedCloudRead$StGetFeedListReq();
        if (qCircleAlbumBean == null || qCircleAlbumBean.getFeedAlbumInfo() == null) {
            return;
        }
        if (str != null) {
            this.mRequest.feedAttchInfo.set(str);
        }
        this.mRequest.source.set(52);
        QQCircleFeedBase$StFeedListBusiReqData feedListBusiReq = qCircleAlbumBean.getFeedListBusiReq();
        FeedCloudMeta$FeedAlbum feedCloudMeta$FeedAlbum = new FeedCloudMeta$FeedAlbum();
        feedCloudMeta$FeedAlbum.f398441id.set(qCircleAlbumBean.getFeedAlbumInfo().mAlbumId);
        feedListBusiReq.album_info.set(feedCloudMeta$FeedAlbum);
        this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(feedListBusiReq.toByteArray()));
        setTimeout(c.P4());
        a();
    }
}
