package com.qzone.publish.business.task.intimate;

import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.qzone.common.account.LoginData;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.publish.business.process.base.QZoneProcessType;
import com.qzone.publish.business.protocol.QzoneMediaUploadRequest;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.publish.business.task.QZoneBaseUploadTask;
import com.qzone.publish.business.task.c;
import com.qzone.reborn.intimate.request.QZoneIntimatePublishRequest;
import com.qzone.reborn.part.publish.fakefeed.QZoneGetFakeFeedFeature;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import cooperation.qzone.LbsDataV2;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import qzone.QZIntimateSpaceReader$GetFeedDetailRsp;
import qzone.QZIntimateSpaceWriter$StPublishFeedRsp;
import qzone.QZoneBaseCommon$StCommonExt;
import qzone.QZoneBaseMeta$StFeed;
import qzone.QZoneBaseMeta$StFeedCellCommon;
import qzone.QZoneBaseMeta$StFeedCellLBS;
import qzone.QZoneBaseMeta$StFeedCellMedia;
import qzone.QZoneBaseMeta$StFeedCellSpaceInfo;
import qzone.QZoneBaseMeta$StFeedCellSummary;
import qzone.QZoneBaseMeta$StFeedCellUserInfo;
import qzone.QZoneBaseMeta$StGPS;
import qzone.QZoneBaseMeta$StLBS;
import qzone.QZoneBaseMeta$StMedia;
import qzone.QZoneBaseMeta$StRichMsg;
import qzone.QZoneBaseMeta$StUser;
import sm.h;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneUploadIntimateTask extends QZoneBaseUploadTask {
    private static final String IMAGE_APP_ID = "intimacy_mood_photo";
    private static final String TAG = "[upload2_QZoneUploadIntimateTask]";
    private static final String VIDEO_APP_ID = "intimacy_mood_video";

    @NeedParcel
    protected IntimatePublishParams mIntimatePublishParams;

    @NeedParcel
    protected transient LbsDataV2.PoiInfo mPoiInfo;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class IntimatePublishParams implements Serializable {
        private static final long serialVersionUID = 1;
        public String content;
        public boolean needSyncFriendFeed;
        public transient LbsDataV2.PoiInfo poiInfo;
        public long publishTime;
        public String spaceId;
        public Map<String, String> storedExtendInfo;
        public transient QZoneBaseUploadTask.UploadParams uploadParams;

        public IntimatePublishParams() {
        }

        public IntimatePublishParams(String str) {
            this.spaceId = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements Continuation<QZIntimateSpaceReader$GetFeedDetailRsp> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QZIntimateSpaceWriter$StPublishFeedRsp f51212d;

        a(QZIntimateSpaceWriter$StPublishFeedRsp qZIntimateSpaceWriter$StPublishFeedRsp) {
            this.f51212d = qZIntimateSpaceWriter$StPublishFeedRsp;
        }

        @Override // kotlin.coroutines.Continuation
        /* renamed from: getContext */
        public CoroutineContext get$context() {
            return EmptyCoroutineContext.INSTANCE;
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object obj) {
            RFWLog.d(QZoneUploadIntimateTask.TAG, RFWLog.USR, "[tryGetRealFeed] rsp: " + obj);
            if (obj instanceof QZIntimateSpaceReader$GetFeedDetailRsp) {
                QZIntimateSpaceReader$GetFeedDetailRsp qZIntimateSpaceReader$GetFeedDetailRsp = (QZIntimateSpaceReader$GetFeedDetailRsp) obj;
                h.A(QZoneUploadIntimateTask.this.getCaseId(), qZIntimateSpaceReader$GetFeedDetailRsp.feed.feed, qZIntimateSpaceReader$GetFeedDetailRsp.ext);
                return;
            }
            RFWLog.d(QZoneUploadIntimateTask.TAG, RFWLog.USR, "[tryGetRealFeed] error, feedId:" + this.f51212d.feed.cell_common.feed_id.get() + ",clintKey:" + this.f51212d.feed.cell_common.client_key.get());
        }
    }

    public QZoneUploadIntimateTask() {
    }

    private QZoneBaseMeta$StFeedCellLBS buildLbsInfo() {
        String str;
        QZoneBaseMeta$StFeedCellLBS qZoneBaseMeta$StFeedCellLBS = new QZoneBaseMeta$StFeedCellLBS();
        if (this.mPoiInfo == null) {
            return qZoneBaseMeta$StFeedCellLBS;
        }
        RFWLog.e(TAG, RFWLog.USR, "buildLbsInfo:" + this.mPoiInfo.poiNum);
        QZoneBaseMeta$StGPS qZoneBaseMeta$StGPS = new QZoneBaseMeta$StGPS();
        qZoneBaseMeta$StGPS.lat.set((long) (this.mPoiInfo.gpsInfo.lat / 1000000));
        qZoneBaseMeta$StGPS.lon.set((long) (this.mPoiInfo.gpsInfo.lon / 1000000));
        QZoneBaseMeta$StLBS qZoneBaseMeta$StLBS = new QZoneBaseMeta$StLBS();
        qZoneBaseMeta$StLBS.gps.set(qZoneBaseMeta$StGPS);
        if (!TextUtils.isEmpty(this.mPoiInfo.poiDefaultName)) {
            str = this.mPoiInfo.poiDefaultName;
        } else if (!TextUtils.isEmpty(this.mPoiInfo.poiName)) {
            str = this.mPoiInfo.poiName;
        } else {
            str = this.mPoiInfo.address;
        }
        if (str == null) {
            RFWLog.e(TAG, RFWLog.USR, "buildLbsInfo address is null");
            str = "";
        }
        qZoneBaseMeta$StLBS.location.set(str);
        qZoneBaseMeta$StFeedCellLBS.lbs.set(qZoneBaseMeta$StLBS);
        return qZoneBaseMeta$StFeedCellLBS;
    }

    private QZoneBaseMeta$StFeedCellSummary buildSummary() {
        QZoneBaseMeta$StFeedCellSummary qZoneBaseMeta$StFeedCellSummary = new QZoneBaseMeta$StFeedCellSummary();
        ArrayList arrayList = new ArrayList();
        String str = this.mIntimatePublishParams.content;
        if (!TextUtils.isEmpty(str)) {
            QZoneBaseMeta$StRichMsg qZoneBaseMeta$StRichMsg = new QZoneBaseMeta$StRichMsg();
            qZoneBaseMeta$StRichMsg.type.set(0);
            qZoneBaseMeta$StRichMsg.content.set(str);
            arrayList.add(qZoneBaseMeta$StRichMsg);
            RFWLog.d(TAG, RFWLog.USR, "buildTitle:" + str);
        }
        qZoneBaseMeta$StFeedCellSummary.summary.set(arrayList);
        return qZoneBaseMeta$StFeedCellSummary;
    }

    private void dispatchFakeFeed(IntimatePublishParams intimatePublishParams) {
        QZoneBaseMeta$StFeed buildFeedInfo = buildFeedInfo();
        QZoneBaseMeta$StFeedCellMedia qZoneBaseMeta$StFeedCellMedia = new QZoneBaseMeta$StFeedCellMedia();
        qZoneBaseMeta$StFeedCellMedia.media_items.set(QZoneBaseUploadTask.UploadParams.buildMediaInfo(intimatePublishParams.uploadParams));
        buildFeedInfo.cell_media.set(qZoneBaseMeta$StFeedCellMedia);
        h.g(getCaseId(), buildFeedInfo, oj.a.f423008a.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUploadFileFinish$0(QZoneIntimatePublishRequest qZoneIntimatePublishRequest, IQueueTask iQueueTask, BaseRequest baseRequest, boolean z16, long j3, String str, QZIntimateSpaceWriter$StPublishFeedRsp qZIntimateSpaceWriter$StPublishFeedRsp) {
        RFWLog.d(TAG, RFWLog.USR, "[publishMood] traceId: " + qZoneIntimatePublishRequest.getTraceId() + ", isSuccess: " + z16 + ", retCode: " + j3 + ", needSyncFriendFeed: " + this.mIntimatePublishParams.needSyncFriendFeed + ", errMsg: " + str);
        this.mResultCode = safeLongToInt(j3);
        this.f45835msg = str;
        boolean z17 = z16 && j3 == 0 && qZIntimateSpaceWriter$StPublishFeedRsp != null;
        if (z17) {
            tryGetFakeFeed(qZIntimateSpaceWriter$StPublishFeedRsp);
        }
        getPublishQueue().g(iQueueTask, z17);
    }

    public QZoneBaseMeta$StFeed buildFeedInfo() {
        QZoneBaseMeta$StFeed qZoneBaseMeta$StFeed = new QZoneBaseMeta$StFeed();
        qZoneBaseMeta$StFeed.cell_summary.set(buildSummary());
        qZoneBaseMeta$StFeed.cell_lbs.set(buildLbsInfo());
        QZoneBaseMeta$StFeedCellCommon qZoneBaseMeta$StFeedCellCommon = new QZoneBaseMeta$StFeedCellCommon();
        qZoneBaseMeta$StFeedCellCommon.time.set(this.mIntimatePublishParams.publishTime);
        String str = "";
        if (this.clientKey == null) {
            this.clientKey = "";
            RFWLog.e(TAG, RFWLog.USR, "[buildFeedInfo] clientKey is null");
        }
        qZoneBaseMeta$StFeedCellCommon.client_key.set(this.clientKey);
        qZoneBaseMeta$StFeedCellCommon.app_id.set(1);
        qZoneBaseMeta$StFeed.cell_common.set(qZoneBaseMeta$StFeedCellCommon);
        QZoneBaseMeta$StFeedCellSpaceInfo qZoneBaseMeta$StFeedCellSpaceInfo = new QZoneBaseMeta$StFeedCellSpaceInfo();
        String caseId = getCaseId();
        if (caseId == null) {
            RFWLog.e(TAG, RFWLog.USR, "[buildFeedInfo] spaceId is null");
            caseId = "";
        }
        qZoneBaseMeta$StFeedCellSpaceInfo.space_id.set(caseId);
        qZoneBaseMeta$StFeed.cell_space_info.set(qZoneBaseMeta$StFeedCellSpaceInfo);
        QZoneBaseMeta$StUser qZoneBaseMeta$StUser = new QZoneBaseMeta$StUser();
        qZoneBaseMeta$StUser.uid.set(LoginData.getInstance().getUid() + "");
        String nickName = LoginData.getInstance().getNickName(null);
        if (nickName == null) {
            RFWLog.e(TAG, RFWLog.USR, "[buildFeedInfo] nickName is null");
        } else {
            str = nickName;
        }
        qZoneBaseMeta$StUser.nick.set(str);
        QZoneBaseMeta$StFeedCellUserInfo qZoneBaseMeta$StFeedCellUserInfo = new QZoneBaseMeta$StFeedCellUserInfo();
        qZoneBaseMeta$StFeedCellUserInfo.user.set(qZoneBaseMeta$StUser);
        qZoneBaseMeta$StFeed.cell_user_info.set(qZoneBaseMeta$StFeedCellUserInfo);
        return qZoneBaseMeta$StFeed;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public String getCaseId() {
        return this.mIntimatePublishParams.spaceId;
    }

    @Override // com.qzone.publish.business.task.QZoneBaseUploadTask, com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public c getInfo() {
        c info = super.getInfo();
        info.f51185a = "\u53d1\u8868\u8bf4\u8bf4\uff1a" + this.mIntimatePublishParams.content;
        if (getState() != 1) {
            return info;
        }
        if (getTotalMediaCount() != 0 && this.mCurUploadIndex != getTotalMediaCount()) {
            long j3 = this.mRecvDataSize;
            if (j3 > 0) {
                long j16 = this.mTotalSize;
                if (j16 > 0) {
                    info.f51190f = Math.max((int) ((j3 * 100) / j16), 1);
                    if (getTotalMediaCount() > 0) {
                        info.f51186b = this.mRecvDataSize + "k/" + this.mTotalSize + "k";
                    }
                }
            }
            QZoneRequest qZoneRequest = this.mRequest;
            return qZoneRequest instanceof QzoneMediaUploadRequest ? ((QzoneMediaUploadRequest) qZoneRequest).getInfo(info) : info;
        }
        info.f51186b = "\u53d1\u8868\u4e2d...";
        return info;
    }

    @Override // com.qzone.publish.business.task.QZoneBaseUploadTask
    protected String getUploadImageAppId() {
        return IMAGE_APP_ID;
    }

    @Override // com.qzone.publish.business.task.QZoneBaseUploadTask
    protected String getUploadVideoAppId() {
        return VIDEO_APP_ID;
    }

    @Override // com.qzone.publish.business.task.QZoneBaseUploadTask, com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public boolean isNullTask() {
        return super.isNullTask() || this.mIntimatePublishParams == null;
    }

    @Override // com.qzone.publish.business.task.QZoneBaseUploadTask, com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public void onRemove() {
        super.onRemove();
        h.t(getCaseId(), this.clientKey);
    }

    @Override // com.qzone.publish.business.task.QZoneBaseUploadTask
    public void onUploadFileFinish(final IQueueTask iQueueTask, List<QZoneBaseMeta$StMedia> list) {
        int i3 = RFWLog.USR;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onUploadFileFinish do publish,media:");
        sb5.append(list == null ? null : Integer.valueOf(list.size()));
        RFWLog.i(TAG, i3, sb5.toString());
        QZoneBaseMeta$StFeed buildFeedInfo = buildFeedInfo();
        if (list != null) {
            QZoneBaseMeta$StFeedCellMedia qZoneBaseMeta$StFeedCellMedia = new QZoneBaseMeta$StFeedCellMedia();
            qZoneBaseMeta$StFeedCellMedia.media_items.set(list);
            buildFeedInfo.cell_media.set(qZoneBaseMeta$StFeedCellMedia);
        }
        final QZoneIntimatePublishRequest qZoneIntimatePublishRequest = new QZoneIntimatePublishRequest(buildFeedInfo, 0, this.mIntimatePublishParams.needSyncFriendFeed, new QZoneBaseCommon$StCommonExt());
        VSNetworkHelper.getInstance().sendRequest(qZoneIntimatePublishRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.qzone.publish.business.task.intimate.a
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                QZoneUploadIntimateTask.this.lambda$onUploadFileFinish$0(qZoneIntimatePublishRequest, iQueueTask, baseRequest, z16, j3, str, (QZIntimateSpaceWriter$StPublishFeedRsp) obj);
            }
        });
    }

    public QZoneUploadIntimateTask(int i3, IntimatePublishParams intimatePublishParams) {
        super(i3, intimatePublishParams.uploadParams);
        this.clientKey = UUID.randomUUID().toString();
        this.mIntimatePublishParams = intimatePublishParams;
        this.mPoiInfo = intimatePublishParams.poiInfo;
        dispatchFakeFeed(intimatePublishParams);
    }

    private void tryGetFakeFeed(QZIntimateSpaceWriter$StPublishFeedRsp qZIntimateSpaceWriter$StPublishFeedRsp) {
        if (qZIntimateSpaceWriter$StPublishFeedRsp == null) {
            RFWLog.d(TAG, RFWLog.USR, "[tryGetFakeFeed] rsp is null");
        } else {
            new QZoneGetFakeFeedFeature().k(qZIntimateSpaceWriter$StPublishFeedRsp.feed.cell_common.feed_id.get(), qZIntimateSpaceWriter$StPublishFeedRsp.feed.cell_common.time.get(), new a(qZIntimateSpaceWriter$StPublishFeedRsp));
        }
    }

    public static int safeLongToInt(long j3) {
        return (int) Math.max(Math.min(TTL.MAX_VALUE, j3), WebViewConstants.WV.ENABLE_WEBAIO_SWITCH);
    }

    @Override // com.qzone.publish.business.task.QZoneBaseUploadTask
    protected void onSendCmdFinish(QZoneProcessType qZoneProcessType, UniAttribute uniAttribute, int i3, int i16, String str, boolean z16) {
    }
}
