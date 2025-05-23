package com.qzone.publish.business.task;

import FileUpload.UploadVideoInfoRsp;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.qzone.common.business.result.UploadFileResponse;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.publish.business.model.a;
import com.qzone.publish.business.process.base.QZoneProcessType;
import com.qzone.publish.business.protocol.QzoneMediaUploadRequest;
import com.qzone.publish.business.publishqueue.h;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.reborn.editdraft.QZWinkEditDraftUtil;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.data.VideoUploadTask;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import qzone.QZoneBaseMeta$StImage;
import qzone.QZoneBaseMeta$StMedia;
import qzone.QZoneBaseMeta$StVideo;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class QZoneBaseUploadTask extends QZoneQueueTask implements QzoneMediaUploadRequest.b {
    private static final String TAG = "[upload2_QZoneBaseUploadTask]";
    public boolean isUploadStep;
    protected int mCurUploadIndex;
    private final ArrayList<Integer> mMediaUploadSuccessIndexList;
    public final List<QZoneBaseMeta$StMedia> mUploadMediaInfos;

    @NeedParcel
    private UploadParams mUploadParams;

    @NeedParcel
    private final ArrayList<MediaWrapper> mediaWrapperList;

    public QZoneBaseUploadTask() {
        this.mediaWrapperList = new ArrayList<>();
        this.mCurUploadIndex = 0;
        this.mUploadMediaInfos = new ArrayList();
        this.isUploadStep = false;
        this.mMediaUploadSuccessIndexList = new ArrayList<>();
    }

    private void addUploadVideoToUrlMap(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        QZLog.i(TAG, "addUploadVideoToUrlMap, id:" + str + ", path:" + str2);
    }

    private QZoneBaseMeta$StImage getImageInfoFromRsp(UploadFileResponse uploadFileResponse) {
        QZoneBaseMeta$StImage qZoneBaseMeta$StImage = new QZoneBaseMeta$StImage();
        qZoneBaseMeta$StImage.lloc.set(uploadFileResponse.photoId);
        qZoneBaseMeta$StImage.sloc.set(uploadFileResponse.slocId);
        qZoneBaseMeta$StImage.photo_url.add(oj.b.f423009a.b(uploadFileResponse.url, uploadFileResponse.width, uploadFileResponse.height, 1));
        return qZoneBaseMeta$StImage;
    }

    private void onStepUploadMixVideoPicRun() {
        QZLog.i(TAG, getStepDesc());
        this.isUploadStep = true;
        checkRequestReentrant();
        com.qzone.publish.ui.model.a aVar = new com.qzone.publish.ui.model.a();
        aVar.C(4).d(this.batchId).f(this.clientKey).H(h.d(this.batchId)).x(this.mUploadParams.photoQuality).G(getUploadImageAppId()).I(getUploadVideoAppId()).i(this.mUploadParams.extendInfo).c(22);
        aVar.L(0);
        this.mRequest = new QzoneMediaUploadRequest(this.mediaWrapperList, aVar, this, this);
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public boolean cancel() {
        QZLog.i(TAG, getStepDesc() + "cancel task");
        QZoneRequest qZoneRequest = this.mRequest;
        if (qZoneRequest instanceof QzoneMediaUploadRequest) {
            return ((QzoneMediaUploadRequest) qZoneRequest).cancel();
        }
        return true;
    }

    protected void checkRequestReentrant() {
        QZoneRequest qZoneRequest = this.mRequest;
        if (qZoneRequest instanceof QzoneMediaUploadRequest) {
            ((QzoneMediaUploadRequest) qZoneRequest).cancel();
            this.batchId = r7.a.a();
            if (getSuccessCount() > 0) {
                this.mMediaUploadSuccessIndexList.clear();
            }
            QZLog.w(TAG, getStepDesc() + ", checkRequestReentrant, cancel old request, reGenerateBatchId:" + this.batchId);
        }
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public void clear() {
        super.clear();
        QZoneRequest qZoneRequest = this.mRequest;
        if (qZoneRequest == null || !(qZoneRequest instanceof QzoneMediaUploadRequest)) {
            return;
        }
        ((QzoneMediaUploadRequest) qZoneRequest).clear();
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    /* renamed from: getCacheKey */
    public String getCommentUniKey() {
        return this.clientKey;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public List<String> getEditMissionId() {
        return QZWinkEditDraftUtil.h(this.mediaWrapperList);
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public int getExactType() {
        return 1;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    public long getFakeSize() {
        return getLeaveFakeSize();
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public c getInfo() {
        c info = super.getInfo();
        if (info != null) {
            setPreViewIconInfo(info);
        }
        return info;
    }

    public long getLeaveFakeSize() {
        List<String> list = this.mUploadParams.mLocalNeedUploadMediaPaths;
        long j3 = 0;
        if (list.size() > 0) {
            int i3 = 0;
            for (String str : list) {
                if (i3 > this.mCurUploadIndex - 1) {
                    j3 = ((float) j3) + com.qzone.util.image.c.y(str, this.mUploadParams.photoQuality);
                }
                i3++;
            }
        }
        return j3;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public long getLeaveSize() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PUBLISH_QUEUE_LEAVE_WIFI_CHECK_SIZE, 10) * 1024 * 1024;
    }

    protected String getStepDesc() {
        return ("id:" + getTaskId() + ", fakeKey:" + getCommentUniKey()) + ", step \u6587\u4ef6\u4e0a\u4f20";
    }

    protected int getSuccessCount() {
        return this.mMediaUploadSuccessIndexList.size();
    }

    public int getTotalMediaCount() {
        return this.mediaWrapperList.size();
    }

    protected abstract String getUploadImageAppId();

    protected abstract String getUploadVideoAppId();

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public boolean isNullTask() {
        return super.isNullTask() || this.mUploadParams == null;
    }

    protected void notifyProgress(IQueueTask iQueueTask) {
        getPublishQueue().d(iQueueTask);
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaCompressFailed(String str, int i3, int i16, String str2) {
        notifyProgress(this);
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaCompressProgress(String str, int i3, double d16) {
        notifyProgress(this);
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaCompressSuccess(String str, String str2, int i3) {
        notifyProgress(this);
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadFailed(int i3, int i16, String str) {
        QZLog.w(TAG, "onMediaUploadFailed mediaIndex:" + i3 + ", errCode:" + i16 + ", errMsg:" + str);
        notifyProgress(this);
    }

    @Override // com.qzone.common.business.task.QZoneTask, com.qzone.common.protocol.IQZoneProtocolListener
    public void onProtocolResponse(QZoneProcessType qZoneProcessType, UniAttribute uniAttribute, int i3, int i16, String str, boolean z16) {
        QZLog.i(TAG, "onProtocolResponse resultCode:" + i3 + ", failCode:" + i16 + ", errMsg:" + str + ", needRetry:" + z16 + ",isUploadStep\uff1a" + this.isUploadStep);
        if (this.isUploadStep) {
            super.onProtocolResponse(qZoneProcessType, uniAttribute, i3, i16, str, z16);
        } else {
            onSendCmdFinish(qZoneProcessType, uniAttribute, i3, i16, str, z16);
        }
        notifyProgress(this);
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public void onRemove() {
        super.onRemove();
        cancel();
    }

    protected abstract void onSendCmdFinish(QZoneProcessType qZoneProcessType, UniAttribute uniAttribute, int i3, int i16, String str, boolean z16);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        QZLog.i(TAG, getStepDesc() + " onTaskResponse succeed:" + qZoneTask.succeeded() + ", batchId:" + this.batchId);
        if (qZoneTask.mRequest != null) {
            QZLog.i(TAG, "[onTaskResponse]" + getStepDesc() + ", isSucceed:" + qZoneTask.succeeded());
            if (qZoneTask.succeeded()) {
                this.isUploadStep = false;
                onUploadFileFinish(this, this.mUploadMediaInfos);
            } else {
                getPublishQueue().g((IQueueTask) qZoneTask, false);
            }
        }
    }

    public abstract void onUploadFileFinish(IQueueTask iQueueTask, List<QZoneBaseMeta$StMedia> list);

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.common.business.task.QZoneTask
    public void run() {
        QZLog.i(TAG, getStepDesc() + ", run batchId:" + this.batchId);
        if (this.mediaWrapperList.isEmpty()) {
            QZLog.i(TAG, "run no media info");
            onUploadFileFinish(this, null);
        } else {
            onStepUploadMixVideoPicRun();
            super.run();
        }
    }

    public void setPreViewIconInfo(c cVar) {
        MediaWrapper mediaWrapper;
        if (this.mediaWrapperList.isEmpty() || (mediaWrapper = this.mediaWrapperList.get(0)) == null) {
            return;
        }
        if (mediaWrapper.isImage()) {
            cVar.f51192h = mediaWrapper.getImageInfo().mPath;
        } else if (mediaWrapper.isVideo()) {
            cVar.f51192h = mediaWrapper.getVideoInfo().mCoverUrl;
            cVar.f51193i = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class UploadParams implements Serializable {
        private static final long serialVersionUID = 1;
        public int photoQuality = 0;
        public final transient ArrayList<MediaWrapper> mediaWrapperList = new ArrayList<>();
        public Map<String, String> extendInfo = new HashMap();
        private final List<String> mLocalNeedUploadMediaPaths = new ArrayList();

        public void processMediaInfo() {
            if (this.mediaWrapperList.isEmpty()) {
                return;
            }
            this.mLocalNeedUploadMediaPaths.clear();
            for (int i3 = 0; i3 < this.mediaWrapperList.size(); i3++) {
                MediaWrapper mediaWrapper = this.mediaWrapperList.get(i3);
                if (mediaWrapper.isImage()) {
                    String str = mediaWrapper.getImageInfo().mPath;
                    if (!str.startsWith("http://") && !str.startsWith("https://")) {
                        this.mLocalNeedUploadMediaPaths.add(str);
                    }
                } else if (mediaWrapper.isVideo()) {
                    this.mLocalNeedUploadMediaPaths.add(mediaWrapper.getVideoInfo().mVideoPath);
                }
            }
            QZLog.w(QZoneBaseUploadTask.TAG, "processMediaInfo mLocalNeedUploadMediaPaths size:" + this.mLocalNeedUploadMediaPaths.size());
        }

        public static List<QZoneBaseMeta$StMedia> buildMediaInfo(UploadParams uploadParams) {
            if (uploadParams == null) {
                return new ArrayList();
            }
            return oj.b.f423009a.a(uploadParams.mediaWrapperList);
        }
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadStart(int i3, String str, String str2) {
        if (i3 < 0) {
            return;
        }
        this.mCurUploadIndex = i3;
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadSuccess(JceStruct jceStruct, AbstractUploadTask abstractUploadTask, int i3, String str, String str2, String str3) {
        if (jceStruct == null || i3 < 0) {
            return;
        }
        QZLog.i(TAG, "onMediaUploadSuccess mediaIndex:" + i3 + ", id:" + str + ", srcPath:" + str2 + ", uploadPath:" + str3);
        if (!this.mMediaUploadSuccessIndexList.contains(Integer.valueOf(i3))) {
            this.mMediaUploadSuccessIndexList.add(Integer.valueOf(i3));
        }
        if (jceStruct instanceof UploadVideoInfoRsp) {
            onVideoUploadSuccess((UploadVideoInfoRsp) jceStruct, abstractUploadTask, str2, str, i3);
        } else if (jceStruct instanceof UploadFileResponse) {
            onPhotoUploadSuccess((UploadFileResponse) jceStruct, abstractUploadTask, i3);
        }
    }

    public QZoneBaseUploadTask(int i3, UploadParams uploadParams) {
        super(i3);
        ArrayList<MediaWrapper> arrayList = new ArrayList<>();
        this.mediaWrapperList = arrayList;
        this.mCurUploadIndex = 0;
        this.mUploadMediaInfos = new ArrayList();
        this.isUploadStep = false;
        this.mMediaUploadSuccessIndexList = new ArrayList<>();
        uploadParams = uploadParams == null ? new UploadParams() : uploadParams;
        arrayList.addAll(uploadParams.mediaWrapperList);
        uploadParams.processMediaInfo();
        this.mUploadParams = uploadParams;
        this.batchId = r7.a.a();
        QZLog.i(TAG, "QZoneBaseUploadTask need upload size:" + arrayList.size());
    }

    protected void onPhotoUploadSuccess(UploadFileResponse uploadFileResponse, AbstractUploadTask abstractUploadTask, int i3) {
        QZoneBaseMeta$StVideo qZoneBaseMeta$StVideo;
        if (uploadFileResponse == null || i3 < 0) {
            return;
        }
        if (i3 >= this.mediaWrapperList.size()) {
            QZLog.i(TAG, "[onPhotoUploadSuccess] error mediaIndex:" + i3 + ",mParams.mediaWrapperList size:" + this.mediaWrapperList.size());
            return;
        }
        if (this.mUploadMediaInfos.size() < this.mediaWrapperList.size()) {
            for (int size = this.mUploadMediaInfos.size(); size < this.mediaWrapperList.size(); size++) {
                this.mUploadMediaInfos.add(new QZoneBaseMeta$StMedia());
            }
        }
        QZoneBaseMeta$StMedia qZoneBaseMeta$StMedia = this.mUploadMediaInfos.get(i3);
        if (this.mediaWrapperList.get(i3).isImage()) {
            qZoneBaseMeta$StMedia.type.set(0);
            qZoneBaseMeta$StMedia.image.set(getImageInfoFromRsp(uploadFileResponse));
        } else {
            qZoneBaseMeta$StMedia.type.set(1);
            if (!qZoneBaseMeta$StMedia.video.has()) {
                qZoneBaseMeta$StVideo = new QZoneBaseMeta$StVideo();
            } else {
                qZoneBaseMeta$StVideo = qZoneBaseMeta$StMedia.video;
            }
            qZoneBaseMeta$StVideo.width.set(uploadFileResponse.width);
            qZoneBaseMeta$StVideo.height.set(uploadFileResponse.height);
            qZoneBaseMeta$StVideo.cover.set(getImageInfoFromRsp(uploadFileResponse));
            qZoneBaseMeta$StMedia.video.set(qZoneBaseMeta$StVideo);
        }
        QZLog.i(TAG, "[onPhotoUploadSuccess] index:" + i3 + ",  response.url\uff1a" + uploadFileResponse.url);
    }

    protected void onVideoUploadSuccess(UploadVideoInfoRsp uploadVideoInfoRsp, AbstractUploadTask abstractUploadTask, String str, String str2, int i3) {
        QZoneBaseMeta$StVideo qZoneBaseMeta$StVideo;
        if (uploadVideoInfoRsp == null || i3 < 0) {
            return;
        }
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            addUploadVideoToUrlMap(str2, str);
        }
        QZLog.i(TAG, "[onVideoUploadSuccess] srcPath:" + str + ",vid:" + str2 + ",mediaIndex:" + i3);
        if (this.mUploadMediaInfos.size() < this.mediaWrapperList.size()) {
            for (int size = this.mUploadMediaInfos.size(); size < this.mediaWrapperList.size(); size++) {
                this.mUploadMediaInfos.add(new QZoneBaseMeta$StMedia());
            }
        }
        QZoneBaseMeta$StMedia qZoneBaseMeta$StMedia = this.mUploadMediaInfos.get(i3);
        qZoneBaseMeta$StMedia.type.set(1);
        if (!qZoneBaseMeta$StMedia.video.has()) {
            qZoneBaseMeta$StVideo = new QZoneBaseMeta$StVideo();
        } else {
            qZoneBaseMeta$StVideo = qZoneBaseMeta$StMedia.video;
        }
        qZoneBaseMeta$StVideo.f430340id.set(uploadVideoInfoRsp.sVid);
        if (abstractUploadTask instanceof VideoUploadTask) {
            qZoneBaseMeta$StVideo.video_time.set(((VideoUploadTask) abstractUploadTask).iPlayTime);
        }
        qZoneBaseMeta$StMedia.video.set(qZoneBaseMeta$StVideo);
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadReport(a.C0436a c0436a) {
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    public void onRun() {
    }
}
