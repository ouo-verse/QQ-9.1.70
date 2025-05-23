package com.qzone.publish.business.task;

import FileUpload.UploadVideoInfoRsp;
import NS_MOBILE_FEEDS.single_feed;
import NS_MOBILE_OPERATION.LbsInfo;
import NS_MOBILE_OPERATION.Source;
import NS_MOBILE_OPERATION.operation_publishmood_req;
import NS_MOBILE_OPERATION.operation_publishmood_rsp;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.qzone.album.protocol.QZoneQueryServerTimeRequest;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.business.model.a;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.qzone.publish.business.protocol.QZoneVideoShuoshuoUploadFinishRequest;
import com.qzone.publish.business.protocol.QzoneMediaUploadRequest;
import com.qzone.publish.business.publishqueue.QZonePublishQueue;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.reborn.editdraft.QZWinkEditDraftUtil;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.upload.uinterface.AbstractUploadTask;
import common.config.service.QzoneConfig;
import cooperation.qzone.Lbs.QzoneLbsConstant;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneUploadVideoCoverTask extends QZoneQueueTask implements QzoneMediaUploadRequest.b {
    private static final String KEY_FAKE_SINGLE_FEED = "fakeSingleFeed";
    public static final String REFER_VIDEO_SHUOSHUO = "video_shuoshuo";
    private static final int STEP_UPLOAD_VIDEO = 0;
    private static final int STEP_VIDEO_UPLOAD_SUCCESS = 1;
    private static final String TAG = "QZoneUploadVideoCoverTask";
    private static final int TASK_TYPE_GET_SERVER_TIME = 1;
    private static final long WAIT_GET_NETWORK_TIME_SECONDS = 10;
    private Runnable getNetworkTimeTimeoutRunnable;

    @NeedParcel
    public LbsInfo hiddenPoi;
    private LbsInfo lbsInfo;
    private final CountDownLatch mCountDownLatch;
    private boolean mHasGetNetworkTime;

    @NeedParcel
    private LbsDataV2.PoiInfo mPoiInfo;

    @NeedParcel
    private long publishTime;

    @NeedParcel
    public String refer;

    @NeedParcel
    private Map<String, String> shootParams;

    @NeedParcel
    private int step;

    @NeedParcel
    private boolean syncFeed;

    @NeedParcel
    public int uploadEntrance;
    String uploadVideo;

    @NeedParcel
    private ShuoshuoVideoInfo videoInfo;
    private int videoRetryNum;

    public QZoneUploadVideoCoverTask() {
        this.step = 0;
        this.mCountDownLatch = new CountDownLatch(1);
        this.getNetworkTimeTimeoutRunnable = new Runnable() { // from class: com.qzone.publish.business.task.QZoneUploadVideoCoverTask.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (QZoneUploadVideoCoverTask.this.mCountDownLatch != null) {
                        QZoneUploadVideoCoverTask.this.mCountDownLatch.countDown();
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        };
        this.uploadVideo = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoUploadVideo", "\u4e0a\u4f20\u89c6\u9891");
    }

    private void getNetworkTimeOnce() {
        if (this.mHasGetNetworkTime) {
            return;
        }
        this.mHasGetNetworkTime = true;
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QZoneQueryServerTimeRequest(""), getHandler(), this, 1));
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).getHandler().postDelayed(this.getNetworkTimeTimeoutRunnable, 10000L);
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public boolean cancel() {
        QZoneRequest qZoneRequest = this.mRequest;
        if (qZoneRequest instanceof QzoneMediaUploadRequest) {
            return ((QzoneMediaUploadRequest) qZoneRequest).cancel();
        }
        return true;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    /* renamed from: getCacheKey */
    public String getCommentUniKey() {
        return this.clientKey;
    }

    public String getContent() {
        return "";
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public List<String> getEditMissionId() {
        return QZWinkEditDraftUtil.g(this.videoInfo);
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public int getExactType() {
        return 14;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    public long getFakeSize() {
        ShuoshuoVideoInfo shuoshuoVideoInfo = this.videoInfo;
        if (shuoshuoVideoInfo == null) {
            return 0L;
        }
        double d16 = shuoshuoVideoInfo.mEstimateSize;
        return d16 > 0.0d ? (long) d16 : shuoshuoVideoInfo.mSize;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public c getInfo() {
        c info = super.getInfo();
        info.f51185a = this.uploadVideo;
        if (getState() == 1) {
            long j3 = this.mRecvDataSize;
            if (j3 > 0) {
                long j16 = this.mTotalSize;
                if (j16 > 0) {
                    info.f51190f = (int) ((j3 * 100) / j16);
                    info.f51186b = this.uploadVideo + this.mRecvDataSize + "/" + this.mTotalSize + "K";
                }
            }
            QZoneRequest qZoneRequest = this.mRequest;
            if (qZoneRequest instanceof QzoneMediaUploadRequest) {
                info = ((QzoneMediaUploadRequest) qZoneRequest).getInfo(info);
            }
        }
        info.f51192h = getVideoCoverUrl();
        info.f51193i = true;
        return info;
    }

    public String getVideoCoverUrl() {
        return this.videoInfo.mCoverUrl;
    }

    public ShuoshuoVideoInfo getVideoInfo() {
        return this.videoInfo;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public boolean isVideoTask() {
        return true;
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaCompressFailed(String str, int i3, int i16, String str2) {
        QZonePublishQueue.w().d(this);
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaCompressProgress(String str, int i3, double d16) {
        QZonePublishQueue.w().d(this);
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaCompressSuccess(String str, String str2, int i3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || i3 < 0) {
            return;
        }
        ShuoshuoVideoInfo shuoshuoVideoInfo = this.videoInfo;
        shuoshuoVideoInfo.mNeedProcess = false;
        shuoshuoVideoInfo.mVideoPath = str2;
        File file = new File(this.videoInfo.mVideoPath);
        if (file.exists()) {
            this.videoInfo.mSize = file.length();
        }
        this.videoInfo.mHasCompressed = !r3.mIsUploadOrigin;
        QZoneWriteOperationService.v0().onTaskResponse(this);
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadFailed(int i3, int i16, String str) {
        QZonePublishQueue.w().d(this);
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadStart(int i3, String str, String str2) {
        QZonePublishQueue.w().d(this);
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public void onRemove() {
        cancel();
        super.onRemove();
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        byte[] bArr;
        single_feed single_feedVar;
        QZLog.i(TAG, 1, "QZoneUploadVideoCoverTask.onTaskResponse step:" + this.step);
        int i3 = this.step;
        if (i3 != 0) {
            if (i3 != 1) {
                return;
            }
            QZLog.i(TAG, 1, "QZoneUploadVideoCoverTask video upload success");
            return;
        }
        if (qZoneTask.succeeded()) {
            this.step = 1;
            QZonePublishQueue.w().g(this, true);
            UploadVideoInfoRsp uploadVideoInfoRsp = (UploadVideoInfoRsp) qZoneTask.mUniAttr.get("response");
            if (uploadVideoInfoRsp == null || uploadVideoInfoRsp.iBusiNessType != 1 || (bArr = uploadVideoInfoRsp.vBusiNessData) == null) {
                return;
            }
            UniAttribute uniAttribute = new UniAttribute();
            uniAttribute.setEncodeName("utf8");
            uniAttribute.decode(bArr);
            operation_publishmood_rsp operation_publishmood_rspVar = (operation_publishmood_rsp) uniAttribute.get("publishmood");
            if (operation_publishmood_rspVar == null || operation_publishmood_rspVar.ret != 0 || (single_feedVar = (single_feed) uniAttribute.get(KEY_FAKE_SINGLE_FEED)) == null || qZoneTask.mUniAttr.containsKey(KEY_FAKE_SINGLE_FEED)) {
                return;
            }
            qZoneTask.mUniAttr.put(KEY_FAKE_SINGLE_FEED, single_feedVar);
            return;
        }
        if (qZoneTask.mResultCode == 1000004) {
            QZLog.i(TAG, 1, "QZoneUploadVideoCoverTask video handle ing");
        } else {
            QZonePublishQueue.w().g(this, false);
        }
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    public void onRun() {
        String str;
        String str2;
        int i3 = this.step;
        if (i3 != 0) {
            if (i3 != 1) {
                return;
            }
            ShuoshuoVideoInfo shuoshuoVideoInfo = this.videoInfo;
            this.mRequest = new QZoneVideoShuoshuoUploadFinishRequest((int) shuoshuoVideoInfo.mSize, (int) shuoshuoVideoInfo.mDuration, this.clientKey);
            if (TextUtils.isEmpty(this.refer)) {
                return;
            }
            this.mRequest.setRefer(this.refer);
            return;
        }
        if (this.shootParams == null) {
            this.shootParams = new HashMap();
        }
        Map<String, String> map = this.shootParams;
        String str3 = "1";
        if (this.videoInfo.mIsUploadOrigin) {
            str = "1";
        } else {
            str = "0";
        }
        map.put(QZonePublishMoodRequest.EXT_INFO_KEY_IS_ORIGIN_VIDEO, str);
        QZLog.i(TAG, 1, "video has been compressed by client : " + this.videoInfo.mHasCompressed);
        int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_CLIENT_COMPRESS, 1);
        QZLog.i(TAG, 1, "need client compress:" + config);
        if (config == 0) {
            this.videoInfo.mHasCompressed = false;
        }
        Map<String, String> map2 = this.shootParams;
        if (this.videoInfo.mHasCompressed) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        map2.put(QZonePublishMoodRequest.EXT_INFO_KEY_IS_FORMAT_F20, str2);
        this.shootParams.put(QZonePublishMoodRequest.EXT_INFO_KEY_VIDEO_SIZE, String.valueOf(this.videoInfo.mSize));
        Map<String, String> map3 = this.shootParams;
        if (!this.syncFeed) {
            str3 = "0";
        }
        map3.put(QZonePublishMoodRequest.EXT_INFO_KEY_IS_SEND_FEED, str3);
        QZonePublishMoodRequest qZonePublishMoodRequest = new QZonePublishMoodRequest("", true, false, null, 0, null, this.lbsInfo, new Source(2, 4, 1), this.clientKey, 0, this.publishTime, 1, null, this.shootParams, null, null, null);
        if (!TextUtils.isEmpty(this.refer)) {
            qZonePublishMoodRequest.setRefer(this.refer);
        }
        operation_publishmood_req operation_publishmood_reqVar = (operation_publishmood_req) qZonePublishMoodRequest.req;
        operation_publishmood_reqVar.mediainfo = null;
        UniAttribute uniAttribute = new UniAttribute();
        uniAttribute.setEncodeName("utf8");
        uniAttribute.put("hostuin", Long.valueOf(LoginData.getInstance().getUin()));
        uniAttribute.put("publishmood", operation_publishmood_reqVar);
        if (!TextUtils.isEmpty(this.refer)) {
            uniAttribute.put("refer", this.refer);
        }
        byte[] encode = uniAttribute.encode();
        com.qzone.publish.ui.model.a aVar = new com.qzone.publish.ui.model.a();
        aVar.A(this.refer).e("video_shuoshuo").d(this.batchId).F(this.uploadEntrance).L(1).O(encode).l(true).J(false);
        ArrayList arrayList = new ArrayList();
        ShuoshuoVideoInfo shuoshuoVideoInfo2 = this.videoInfo;
        arrayList.add(new MediaWrapper(shuoshuoVideoInfo2, shuoshuoVideoInfo2.mNeedProcess));
        this.mRequest = new QzoneMediaUploadRequest(arrayList, aVar, this, this);
    }

    public QZoneUploadVideoCoverTask(ShuoshuoVideoInfo shuoshuoVideoInfo, long j3, int i3, boolean z16, Map<String, String> map, LbsDataV2.PoiInfo poiInfo, LbsDataV2.GpsInfo gpsInfo, String str) {
        super(i3);
        this.step = 0;
        this.mCountDownLatch = new CountDownLatch(1);
        this.getNetworkTimeTimeoutRunnable = new Runnable() { // from class: com.qzone.publish.business.task.QZoneUploadVideoCoverTask.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (QZoneUploadVideoCoverTask.this.mCountDownLatch != null) {
                        QZoneUploadVideoCoverTask.this.mCountDownLatch.countDown();
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        };
        this.uploadVideo = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoUploadVideo", "\u4e0a\u4f20\u89c6\u9891");
        this.videoInfo = shuoshuoVideoInfo;
        this.batchId = j3;
        this.syncFeed = z16;
        this.shootParams = map;
        this.refer = str;
        initLbsInfo(poiInfo, gpsInfo);
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadSuccess(JceStruct jceStruct, AbstractUploadTask abstractUploadTask, int i3, String str, String str2, String str3) {
        if (jceStruct == null || i3 < 0) {
            return;
        }
        QZLog.i(TAG, "onMediaUploadSuccess mediaIndex:" + i3 + ", id:" + str + ", srcPath:" + str2 + ", uploadPath:" + str3);
        QZonePublishQueue.w().d(this);
    }

    private void initLbsInfo(LbsDataV2.PoiInfo poiInfo, LbsDataV2.GpsInfo gpsInfo) {
        if (poiInfo != null) {
            LbsInfo lbsInfo = new LbsInfo();
            this.lbsInfo = lbsInfo;
            if (poiInfo.gpsInfo != null) {
                lbsInfo.lbs_x = String.valueOf(r3.lon / 1000000.0d);
                this.lbsInfo.lbs_y = String.valueOf(poiInfo.gpsInfo.lat / 1000000.0d);
            }
            if (!TextUtils.isEmpty(poiInfo.poiDefaultName)) {
                LbsInfo lbsInfo2 = this.lbsInfo;
                String str = poiInfo.poiDefaultName;
                lbsInfo2.lbs_idnm = str;
                lbsInfo2.lbs_nm = str;
            } else if (!TextUtils.isEmpty(poiInfo.poiName)) {
                LbsInfo lbsInfo3 = this.lbsInfo;
                String str2 = poiInfo.poiName;
                lbsInfo3.lbs_idnm = str2;
                lbsInfo3.lbs_nm = str2;
            } else {
                LbsInfo lbsInfo4 = this.lbsInfo;
                String str3 = poiInfo.address;
                lbsInfo4.lbs_idnm = str3;
                lbsInfo4.lbs_nm = str3;
            }
            LbsInfo lbsInfo5 = this.lbsInfo;
            lbsInfo5.i_poi_order_type = poiInfo.poiOrderType;
            lbsInfo5.i_poi_num = poiInfo.poiNum;
            lbsInfo5.i_poi_type = poiInfo.poiType;
            try {
                lbsInfo5.lbs_id = Integer.parseInt(poiInfo.poiId);
            } catch (Exception unused) {
            }
        }
        if (gpsInfo != null) {
            LbsInfo lbsInfo6 = new LbsInfo();
            this.hiddenPoi = lbsInfo6;
            lbsInfo6.lbs_x = String.valueOf(gpsInfo.lon / 1000000.0d);
            this.hiddenPoi.lbs_y = String.valueOf(gpsInfo.lat / 1000000.0d);
            return;
        }
        LbsDataV2.GpsInfo a16 = com.qzone.business.lbsv2.business.c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_UPLOAD_PIC_VIDEO).a();
        if (a16 == null || !a16.isValid()) {
            return;
        }
        LbsInfo lbsInfo7 = new LbsInfo();
        this.hiddenPoi = lbsInfo7;
        lbsInfo7.lbs_x = String.valueOf(a16.lon / 1000000.0d);
        this.hiddenPoi.lbs_y = String.valueOf(a16.lat / 1000000.0d);
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadReport(a.C0436a c0436a) {
    }
}
