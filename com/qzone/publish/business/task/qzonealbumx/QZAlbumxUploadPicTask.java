package com.qzone.publish.business.task.qzonealbumx;

import NS_MOBILE_PHOTO.upload_finish_rsp;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.UploadFileResponse;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.publish.business.model.a;
import com.qzone.publish.business.protocol.QzoneMediaUploadRequest;
import com.qzone.publish.business.protocol.QzoneUploadPicFinishRequest;
import com.qzone.publish.business.publishqueue.common.CommonPublishVideoStatusInfo;
import com.qzone.publish.business.task.QZoneQueueTask;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadPicTaskParams;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxUploadAlbumEvent;
import com.qzone.util.image.ImageInfo;
import com.qzone.util.l;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFakeFeedLogicManager;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.upload.uinterface.AbstractUploadTask;
import common.config.service.QzoneConfig;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lc.i;
import lc.n;

/* loaded from: classes39.dex */
public class QZAlbumxUploadPicTask extends QZoneQueueTask implements QzoneMediaUploadRequest.b {
    public static final int STEP_FINISH = 2;
    public static final int STEP_UPLOAD = 1;
    private static final String TAG = "QZPublishX_QZAlbumxUploadPicTask";

    @NeedParcel
    private QZAlbumxUploadPicTaskParams mParams;
    String uploadToAlbum = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoUploadToAlbum", "\u4e0a\u4f20\u7167\u7247\u5230\u300a\u624b\u673a\u76f8\u518c\u300b");

    public QZAlbumxUploadPicTask() {
    }

    private void finalSuccessOperation(QZoneQueueTask qZoneQueueTask) {
        getPublishQueue().g(qZoneQueueTask, true);
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.publish.business.task.qzonealbumx.d
            @Override // java.lang.Runnable
            public final void run() {
                QZAlbumxUploadPicTask.this.lambda$finalSuccessOperation$3();
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$finalSuccessOperation$3() {
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        String uinString = LoginData.getInstance().getUinString();
        QZAlbumxUploadPicTaskParams qZAlbumxUploadPicTaskParams = this.mParams;
        simpleEventBus.dispatchEvent(new QZAlbumxUploadAlbumEvent(uinString, qZAlbumxUploadPicTaskParams.albumId, this.batchId, qZAlbumxUploadPicTaskParams.successCount, this.clientKey));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onTaskResponse$0() {
        run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onTaskResponse$1() {
        run();
    }

    private void triggerFetchRealFeed(final QZoneQueueTask qZoneQueueTask) {
        if (com.qzone.reborn.feedpro.utils.d.f54318a.b()) {
            le.b.f414397d.f(true, this.clientKey, new QzoneFakeFeedLogicManager.OnFetchFeedCompleteCallback() { // from class: com.qzone.publish.business.task.qzonealbumx.a
                @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFakeFeedLogicManager.OnFetchFeedCompleteCallback
                public final void onComplete(boolean z16) {
                    QZAlbumxUploadPicTask.this.lambda$triggerFetchRealFeed$2(qZoneQueueTask, z16);
                }
            });
        } else {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).postDelayed(new Runnable() { // from class: com.qzone.publish.business.task.qzonealbumx.QZAlbumxUploadPicTask.1
                @Override // java.lang.Runnable
                public void run() {
                    QZAlbumxUploadPicTask.this.run();
                }
            }, 1000L);
        }
    }

    protected com.qzone.publish.ui.model.a buildQZoneMediaUploadParams(Map<String, String> map) {
        com.qzone.publish.ui.model.a aVar = new com.qzone.publish.ui.model.a();
        aVar.C(this.mParams.target).A(this.mParams.refer).d(this.batchId).f(this.clientKey).F(this.mParams.uploadEntrance).H(this.mParams.uploadTime).x(this.mParams.picQuality).b(this.mParams.albumId).v(this.mParams.photoDescription).t(getWaterMark()).L(0).K(this.mParams.maxNum).M(this.mParams.curNum).p(map).y(this.mParams.stPoi).B(this.mParams.shootParams).u(this.mParams.openAppId).h(this.mParams.extendInfo).s(this.mParams.isVideoMix).j(this.mParams.externalData);
        return aVar;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public boolean cancel() {
        QZLog.i(TAG, getTaskDesc() + ", cancel");
        QZoneRequest qZoneRequest = this.mRequest;
        if (qZoneRequest == null || !(qZoneRequest instanceof QzoneMediaUploadRequest)) {
            return false;
        }
        return ((QzoneMediaUploadRequest) qZoneRequest).cancel();
    }

    public String getAlbumId() {
        return this.mParams.albumId;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    /* renamed from: getCacheKey */
    public String getCommentUniKey() {
        Object obj;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.clientKey);
        sb5.append("_");
        QZAlbumxUploadPicTaskParams qZAlbumxUploadPicTaskParams = this.mParams;
        if (qZAlbumxUploadPicTaskParams != null) {
            obj = Integer.valueOf(qZAlbumxUploadPicTaskParams.curNum);
        } else {
            obj = "";
        }
        sb5.append(obj);
        return sb5.toString();
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public String getCaseId() {
        return LoginData.getInstance().getUinString();
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public int getExactType() {
        return 2;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    public long getFakeSize() {
        QZAlbumxUploadPicTaskParams qZAlbumxUploadPicTaskParams = this.mParams;
        return com.qzone.util.image.c.y(qZAlbumxUploadPicTaskParams.photoFilePath, qZAlbumxUploadPicTaskParams.picQuality);
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public com.qzone.publish.business.task.c getInfo() {
        com.qzone.publish.business.task.c info = super.getInfo();
        String str = this.mParams.albumName;
        if (str != null && str.length() != 0) {
            info.f51185a = l.a(R.string.s_h) + this.mParams.albumName + "\u300b";
        } else {
            info.f51185a = this.uploadToAlbum;
        }
        if (getState() != 0 && getState() != 1) {
            if (getState() == 7) {
                info.f51186b = com.qzone.reborn.configx.g.f53821a.j().t();
            }
        } else {
            long j3 = this.mRecvDataSize;
            if (j3 > 0) {
                long j16 = this.mTotalSize;
                if (j16 > 0) {
                    info.f51190f = (int) ((j3 * 100) / j16);
                    info.f51186b = this.mRecvDataSize + "k/" + this.mTotalSize + "k";
                }
            }
            info.f51190f = 0;
        }
        return info;
    }

    public Map<String, String> getLocalUrlMap() {
        return this.mParams.localUrlMap;
    }

    public QZAlbumxUploadPicTaskParams getParams() {
        return this.mParams;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public String getPhotoSource() {
        return this.mParams.photoFilePath;
    }

    protected String getTaskDesc() {
        return "id:" + getTaskId() + ", batchId:" + this.batchId + ", fakeKey:" + getCommentUniKey();
    }

    public int getUploadEntrance() {
        return this.mParams.uploadEntrance;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public long getUploadTime() {
        return this.mParams.uploadTime;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public boolean isNullTask() {
        return this.mParams == null;
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadFailed(int i3, int i16, String str) {
        getPublishQueue().d(this);
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadReport(a.C0436a c0436a) {
        addReportInfo(c0436a);
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadStart(int i3, String str, String str2) {
        getPublishQueue().d(this);
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public void onRemove() {
        super.onRemove();
        QZLog.i(TAG, getTaskDesc() + ", onRemove");
        if (n.c(this.batchId)) {
            long j3 = this.batchId;
            HashMap hashMap = new HashMap();
            QZAlbumxUploadPicTaskParams qZAlbumxUploadPicTaskParams = this.mParams;
            n.a b16 = n.b(j3, false, hashMap, qZAlbumxUploadPicTaskParams.albumId, qZAlbumxUploadPicTaskParams.clientKey);
            this.mParams.localUrlMap = b16.f414356e;
            QZLog.i(TAG, 1, getTaskDesc() + ", remove pid upload, " + b16);
            n.d(this.batchId);
        }
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public void onResume() {
        super.onResume();
        resetStep();
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    public void onRun() {
        Object obj;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(getTaskDesc());
        sb5.append(", onRun -- step:");
        QZAlbumxUploadPicTaskParams qZAlbumxUploadPicTaskParams = this.mParams;
        if (qZAlbumxUploadPicTaskParams == null) {
            obj = "";
        } else {
            obj = Integer.valueOf(qZAlbumxUploadPicTaskParams.step);
        }
        sb5.append(obj);
        QZLog.i(TAG, sb5.toString());
        if (this.mParams == null) {
            return;
        }
        com.qzone.publish.business.model.a aVar = this.mReportInfo;
        if (aVar != null && (aVar.f51012c == 0 || aVar.f51014e < this.retryNum)) {
            com.qzone.publish.business.model.a aVar2 = new com.qzone.publish.business.model.a();
            this.mReportInfo = aVar2;
            aVar2.f51010a = 2;
            aVar2.f51012c = System.currentTimeMillis();
            this.mReportInfo.f51014e = this.retryNum;
        }
        QZAlbumxUploadPicTaskParams qZAlbumxUploadPicTaskParams2 = this.mParams;
        int i3 = qZAlbumxUploadPicTaskParams2.step;
        if (i3 != 1) {
            if (i3 != 2) {
                return;
            }
            long j3 = this.batchId;
            QZAlbumxUploadPicTaskParams qZAlbumxUploadPicTaskParams3 = this.mParams;
            String str = qZAlbumxUploadPicTaskParams3.albumId;
            QzoneUploadPicFinishRequest qzoneUploadPicFinishRequest = new QzoneUploadPicFinishRequest(j3, str == null ? "" : str, qZAlbumxUploadPicTaskParams3.maxNum, qZAlbumxUploadPicTaskParams3.successCount, qZAlbumxUploadPicTaskParams3.uploadFinishRetryCount, this.clientKey, 0);
            this.mRequest = qzoneUploadPicFinishRequest;
            qzoneUploadPicFinishRequest.setRefer(this.mParams.refer);
            this.mParams.uploadFinishRetryCount++;
            return;
        }
        if (TextUtils.isEmpty(qZAlbumxUploadPicTaskParams2.photoFilePath)) {
            QZLog.w(TAG, "onRun STEP_UPLOAD photoFilePath empty, break");
            return;
        }
        HashMap hashMap = new HashMap();
        QZAlbumxUploadPicTaskParams qZAlbumxUploadPicTaskParams4 = this.mParams;
        hashMap.put(qZAlbumxUploadPicTaskParams4.photoFilePath, String.valueOf(qZAlbumxUploadPicTaskParams4.panoramaType));
        com.qzone.publish.ui.model.a buildQZoneMediaUploadParams = buildQZoneMediaUploadParams(hashMap);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MediaWrapper(new ImageInfo(this.mParams.photoFilePath)));
        this.mRequest = new QzoneMediaUploadRequest(arrayList, buildQZoneMediaUploadParams, this, this);
        com.qzone.publish.business.model.a aVar3 = this.mReportInfo;
        if (aVar3 != null) {
            aVar3.f51011b = 4;
        }
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        int i3;
        QZLog.i(TAG, getTaskDesc() + ", onTaskResponse -- step:" + this.mParams.step);
        if (qZoneTask == null) {
            return;
        }
        int i16 = this.mParams.step;
        boolean z16 = false;
        if (i16 != 1) {
            if (i16 == 2) {
                if (qZoneTask.succeeded()) {
                    upload_finish_rsp upload_finish_rspVar = (upload_finish_rsp) qZoneTask.mRequest.rsp;
                    if (upload_finish_rspVar != null && upload_finish_rspVar.retry_timeout > 0) {
                        QZLog.i(TAG, 1, getTaskDesc() + " send upload_finish_rsp failed, retry timeout:" + upload_finish_rspVar.retry_timeout);
                        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).postDelayed(new Runnable() { // from class: com.qzone.publish.business.task.qzonealbumx.b
                            @Override // java.lang.Runnable
                            public final void run() {
                                QZAlbumxUploadPicTask.this.lambda$onTaskResponse$0();
                            }
                        }, (long) (upload_finish_rspVar.retry_timeout * 1000));
                        z16 = true;
                    }
                    if (z16) {
                        return;
                    }
                    QZLog.i(TAG, 1, getTaskDesc() + "send upload_finish_rsp success");
                    i.f414345a.n(this.clientKey, (HashMap) getLocalUrlMap(), this.mUniAttr);
                    finalSuccessOperation((QZoneQueueTask) qZoneTask);
                    return;
                }
                String[] split = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_FAKE_FEED_RETRY_TIMEOUT, QzoneConfig.DefaultValue.DEFAULT_FAKE_FEED_RETRY_TIMEOUT).split("/");
                if (split == null || (i3 = this.mParams.uploadFinishRetryCount) > split.length) {
                    return;
                }
                int parseInt = Integer.parseInt(split[i3 - 1]);
                QZLog.i(TAG, 1, getTaskDesc() + "send upload_finish_rsp failed, wns config retry timeout:" + parseInt);
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).postDelayed(new Runnable() { // from class: com.qzone.publish.business.task.qzonealbumx.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        QZAlbumxUploadPicTask.this.lambda$onTaskResponse$1();
                    }
                }, (long) (parseInt * 1000));
                return;
            }
            return;
        }
        if (qZoneTask.succeeded()) {
            if (n.c(this.batchId)) {
                UploadFileResponse uploadFileResponse = (UploadFileResponse) qZoneTask.mUniAttr.get("response");
                HashMap hashMap = new HashMap();
                if (uploadFileResponse != null) {
                    hashMap.put(uploadFileResponse.clientFakeKey, uploadFileResponse.originUploadUrl);
                }
                long j3 = this.batchId;
                boolean succeeded = qZoneTask.succeeded();
                QZAlbumxUploadPicTaskParams qZAlbumxUploadPicTaskParams = this.mParams;
                n.a b16 = n.b(j3, succeeded, hashMap, qZAlbumxUploadPicTaskParams.albumId, qZAlbumxUploadPicTaskParams.clientKey);
                this.mParams.localUrlMap = b16.f414356e;
                QZLog.i(TAG, 1, getTaskDesc() + ", upload pic success, uploadTime:" + this.mParams.uploadTime + ", picPath:" + this.mParams.photoFilePath + ", " + b16);
                if (b16.f414353b == b16.f414355d && b16.f414354c == 0) {
                    if (this.mParams.isVideoMix) {
                        i.f414345a.z(this.clientKey, new CommonPublishVideoStatusInfo(false, 2, null));
                    }
                    QZAlbumxUploadPicTaskParams qZAlbumxUploadPicTaskParams2 = this.mParams;
                    qZAlbumxUploadPicTaskParams2.step = 2;
                    qZAlbumxUploadPicTaskParams2.successCount = b16.f414353b;
                    QZLog.i(TAG, getTaskDesc() + ", all batch media upload finish, send upload_finish_rsp");
                    if (com.qzone.reborn.configx.g.f53821a.j().n()) {
                        setState(7);
                        getPublishQueue().c(this);
                        QZLog.i(TAG, 1, getTaskDesc() + "onTaskResponse, set STATE_FINISH_REQUEST");
                    }
                    triggerFetchRealFeed((QZoneQueueTask) qZoneTask);
                    return;
                }
                getPublishQueue().g((QZoneQueueTask) qZoneTask, true);
                return;
            }
            getPublishQueue().g((QZoneQueueTask) qZoneTask, true);
            return;
        }
        QZLog.e(TAG, getTaskDesc() + ", upload pic failed, resultCode:" + this.mResultCode + ", resultMsg:" + this.f45835msg + ",completeTask false, picPath:" + this.mParams.photoFilePath);
        getPublishQueue().g((QZoneQueueTask) qZoneTask, false);
    }

    public void resetStep() {
        this.mParams.step = 1;
    }

    public QZAlbumxUploadPicTask(QZAlbumxUploadPicTaskParams qZAlbumxUploadPicTaskParams) {
        this.mParams = qZAlbumxUploadPicTaskParams;
        if (qZAlbumxUploadPicTaskParams == null) {
            return;
        }
        this.clientKey = qZAlbumxUploadPicTaskParams.clientKey;
        this.batchId = qZAlbumxUploadPicTaskParams.batchId;
        LbsDataV2.PoiInfo poiInfo = qZAlbumxUploadPicTaskParams.poiInfo;
        if (poiInfo != null) {
            qZAlbumxUploadPicTaskParams.stPoi = k5.a.d(poiInfo);
        }
        qZAlbumxUploadPicTaskParams.step = 1;
        qZAlbumxUploadPicTaskParams.flowId = subFlowId((int) this.batchId, qZAlbumxUploadPicTaskParams.photoFilePath);
        QZLog.i(TAG, getTaskDesc() + ", constructor flowId:" + qZAlbumxUploadPicTaskParams.flowId + ", photoFilePath:" + qZAlbumxUploadPicTaskParams.photoFilePath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$triggerFetchRealFeed$2(QZoneQueueTask qZoneQueueTask, boolean z16) {
        if (z16) {
            finalSuccessOperation(qZoneQueueTask);
        }
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadSuccess(JceStruct jceStruct, AbstractUploadTask abstractUploadTask, int i3, String str, String str2, String str3) {
        if (jceStruct == null || i3 < 0) {
            return;
        }
        QZLog.i(TAG, "onMediaUploadSuccess mediaIndex:" + i3 + ", id:" + str + ", srcPath:" + str2 + ", uploadPath:" + str3);
        getPublishQueue().d(this);
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaCompressProgress(String str, int i3, double d16) {
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaCompressSuccess(String str, String str2, int i3) {
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaCompressFailed(String str, int i3, int i16, String str2) {
    }
}
