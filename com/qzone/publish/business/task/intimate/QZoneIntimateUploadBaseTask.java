package com.qzone.publish.business.task.intimate;

import FileUpload.UploadVideoInfoRsp;
import com.qq.taf.jce.JceStruct;
import com.qzone.common.business.result.UploadFileResponse;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.publish.business.model.a;
import com.qzone.publish.business.model.intimate.IntimateUploadAlbumParams;
import com.qzone.publish.business.model.intimate.IntimateUploadPoiInfo;
import com.qzone.publish.business.protocol.QzoneMediaUploadRequest;
import com.qzone.publish.business.publishqueue.intimate.b;
import com.qzone.publish.business.task.QZoneQueueTask;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.reborn.editdraft.QZWinkEditDraftUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.data.VideoUploadTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseMeta$StImage;
import qzone.QZoneBaseMeta$StMedia;
import qzone.QZoneBaseMeta$StPicSpecUrlEntry;
import qzone.QZoneBaseMeta$StPicUrl;
import qzone.QZoneBaseMeta$StVideo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001IB\u000f\u0012\u0006\u0010:\u001a\u000209\u00a2\u0006\u0004\bF\u0010GJ\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J,\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\u0012\u0010\u001a\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J0\u0010 \u001a\u00020\t2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001c0\u001b2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e0\u001bH\u0014J$\u0010\"\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0005H\u0016JB\u0010&\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010#2\b\u0010\u0019\u001a\u0004\u0018\u00010$2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010)\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010,\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J$\u0010.\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010-\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J,\u0010/\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u00102\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u00101\u001a\u000200H\u0016J\b\u00103\u001a\u00020\tH\u0016J\b\u00104\u001a\u00020\tH\u0017J\b\u00105\u001a\u00020\u001eH\u0016J\b\u00106\u001a\u00020\u001eH\u0016J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00020\u000507H\u0016R\u0016\u0010:\u001a\u0002098\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R&\u0010?\u001a\u0012\u0012\u0004\u0012\u00020=0<j\b\u0012\u0004\u0012\u00020=`>8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R0\u0010C\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001c0Aj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001c`B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR0\u0010E\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e0Aj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e`B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010D\u00a8\u0006J"}, d2 = {"Lcom/qzone/publish/business/task/intimate/QZoneIntimateUploadBaseTask;", "Lcom/qzone/publish/business/task/QZoneQueueTask;", "Lcom/qzone/publish/business/protocol/QzoneMediaUploadRequest$b;", "", "mediaIndex", "", "srcPath", "Lcom/qzone/common/business/result/UploadFileResponse;", "response", "", "onPicUploadSucceed", "getOriginPath", "LFileUpload/UploadVideoInfoRsp;", "Lcom/tencent/upload/uinterface/data/VideoUploadTask;", "videoUploadTask", "onVideoUploadSucceed", "notifyProgress", "getLogTag", "getCaseId", "getExactType", "getCacheKey", "onRun", "Lcom/qzone/publish/ui/model/a;", "buildUploadParams", "Lcom/qzone/common/business/task/QZoneTask;", "task", "onTaskResponse", "", "Lqzone/QZoneBaseMeta$StMedia;", "uploadResult", "", "uploadResultBool", "onUploadFinish", "uploadPath", "onMediaUploadStart", "Lcom/qq/taf/jce/JceStruct;", "Lcom/tencent/upload/uinterface/AbstractUploadTask;", "id", "onMediaUploadSuccess", "errCode", "errMsg", "onMediaUploadFailed", "Lcom/qzone/publish/business/model/a$a;", CacheTable.TABLE_NAME, "onMediaUploadReport", "destPath", "onMediaCompressSuccess", "onMediaCompressFailed", "", "progress", "onMediaCompressProgress", "onRestore", "onRemove", "cancel", "isNullTask", "", "getEditMissionId", "Lcom/qzone/publish/business/model/intimate/IntimateUploadAlbumParams;", "params", "Lcom/qzone/publish/business/model/intimate/IntimateUploadAlbumParams;", "Ljava/util/ArrayList;", "Lcom/qzone/publish/ui/model/MediaWrapper;", "Lkotlin/collections/ArrayList;", "mediaWrapperList", "Ljava/util/ArrayList;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "uploadResultMap", "Ljava/util/HashMap;", "uploadResultBoolMap", "<init>", "(Lcom/qzone/publish/business/model/intimate/IntimateUploadAlbumParams;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public abstract class QZoneIntimateUploadBaseTask extends QZoneQueueTask implements QzoneMediaUploadRequest.b {
    private static final String TAG = "QZoneIntimateUploadBaseTask";

    @NeedParcel
    public ArrayList<MediaWrapper> mediaWrapperList;

    @NeedParcel
    public IntimateUploadAlbumParams params;
    private final HashMap<String, Boolean> uploadResultBoolMap;
    private final HashMap<String, QZoneBaseMeta$StMedia> uploadResultMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneIntimateUploadBaseTask(IntimateUploadAlbumParams params) {
        super(params.getTaskParams().getType());
        Intrinsics.checkNotNullParameter(params, "params");
        this.params = params;
        this.mediaWrapperList = new ArrayList<>();
        this.uploadResultMap = new HashMap<>();
        this.uploadResultBoolMap = new HashMap<>();
        IntimateUploadAlbumParams intimateUploadAlbumParams = this.params;
        RFWLog.i(getLogTag(), RFWLog.USR, "init, params:" + intimateUploadAlbumParams);
        this.batchId = intimateUploadAlbumParams.getBatchId();
        this.clientKey = intimateUploadAlbumParams.getClientKey();
        this.mediaWrapperList = intimateUploadAlbumParams.getMediaWrapperList();
    }

    private final String getOriginPath(int mediaIndex) {
        String str;
        try {
            MediaWrapper mediaWrapper = this.params.getMediaWrapperList().get(mediaIndex);
            Intrinsics.checkNotNullExpressionValue(mediaWrapper, "params.mediaWrapperList[mediaIndex]");
            str = b.b(mediaWrapper);
        } catch (Exception e16) {
            RFWLog.fatal(getLogTag(), RFWLog.USR, e16);
            str = "";
        }
        RFWLog.i(getLogTag(), RFWLog.USR, "getOriginPath, ret:" + str);
        return str;
    }

    private final void notifyProgress() {
        getPublishQueue().d(this);
    }

    private final void onPicUploadSucceed(int mediaIndex, String srcPath, UploadFileResponse response) {
        List<QZoneBaseMeta$StPicSpecUrlEntry> listOf;
        String originPath = getOriginPath(mediaIndex);
        RFWLog.i(getLogTag(), RFWLog.USR, "onPicUploadSucceed, mediaIndex:" + mediaIndex + ", srcPath:" + srcPath + ", originPath:" + originPath + ", url:" + response.url + ", width:" + response.width + ", height:" + response.height);
        HashMap<String, QZoneBaseMeta$StMedia> hashMap = this.uploadResultMap;
        QZoneBaseMeta$StMedia qZoneBaseMeta$StMedia = hashMap.get(originPath);
        if (qZoneBaseMeta$StMedia == null) {
            if (isVideoTask()) {
                RFWLog.fatal(getLogTag(), RFWLog.USR, new RuntimeException("onPicUploadSucceed, video task should not execute here "));
            }
            qZoneBaseMeta$StMedia = new QZoneBaseMeta$StMedia();
            qZoneBaseMeta$StMedia.type.set(0);
            hashMap.put(originPath, qZoneBaseMeta$StMedia);
        }
        QZoneBaseMeta$StMedia qZoneBaseMeta$StMedia2 = qZoneBaseMeta$StMedia;
        QZoneBaseMeta$StPicUrl qZoneBaseMeta$StPicUrl = new QZoneBaseMeta$StPicUrl();
        qZoneBaseMeta$StPicUrl.url.set(response.url);
        qZoneBaseMeta$StPicUrl.width.set(response.width);
        qZoneBaseMeta$StPicUrl.height.set(response.height);
        QZoneBaseMeta$StPicSpecUrlEntry qZoneBaseMeta$StPicSpecUrlEntry = new QZoneBaseMeta$StPicSpecUrlEntry();
        qZoneBaseMeta$StPicSpecUrlEntry.url.set(qZoneBaseMeta$StPicUrl);
        qZoneBaseMeta$StPicSpecUrlEntry.spec.set(1);
        QZoneBaseMeta$StImage qZoneBaseMeta$StImage = new QZoneBaseMeta$StImage();
        PBRepeatMessageField<QZoneBaseMeta$StPicSpecUrlEntry> pBRepeatMessageField = qZoneBaseMeta$StImage.photo_url;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(qZoneBaseMeta$StPicSpecUrlEntry);
        pBRepeatMessageField.set(listOf);
        qZoneBaseMeta$StImage.lloc.set(response.photoId);
        qZoneBaseMeta$StImage.sloc.set(response.slocId);
        qZoneBaseMeta$StImage.default_url.set(qZoneBaseMeta$StPicUrl);
        if (isVideoTask()) {
            QZoneBaseMeta$StVideo qZoneBaseMeta$StVideo = qZoneBaseMeta$StMedia2.video;
            qZoneBaseMeta$StVideo.cover.set(qZoneBaseMeta$StImage);
            qZoneBaseMeta$StVideo.width.set(response.width);
            qZoneBaseMeta$StVideo.height.set(response.height);
        } else {
            qZoneBaseMeta$StMedia2.image.set(qZoneBaseMeta$StImage);
        }
        this.uploadResultBoolMap.put(originPath, Boolean.TRUE);
    }

    private final void onVideoUploadSucceed(int mediaIndex, String srcPath, UploadVideoInfoRsp response, VideoUploadTask videoUploadTask) {
        String originPath = getOriginPath(mediaIndex);
        RFWLog.i(getLogTag(), RFWLog.USR, "onVideoUploadSucceed, mediaIndex:" + mediaIndex + ", srcPath:" + srcPath + ", sVid:" + response.sVid + ", originPath:" + originPath);
        HashMap<String, QZoneBaseMeta$StMedia> hashMap = this.uploadResultMap;
        QZoneBaseMeta$StMedia qZoneBaseMeta$StMedia = hashMap.get(originPath);
        if (qZoneBaseMeta$StMedia == null) {
            qZoneBaseMeta$StMedia = new QZoneBaseMeta$StMedia();
            hashMap.put(originPath, qZoneBaseMeta$StMedia);
        }
        QZoneBaseMeta$StMedia qZoneBaseMeta$StMedia2 = qZoneBaseMeta$StMedia;
        qZoneBaseMeta$StMedia2.type.set(1);
        QZoneBaseMeta$StVideo qZoneBaseMeta$StVideo = qZoneBaseMeta$StMedia2.video;
        QZoneBaseMeta$StVideo qZoneBaseMeta$StVideo2 = new QZoneBaseMeta$StVideo();
        qZoneBaseMeta$StVideo2.f430340id.set(response.sVid);
        qZoneBaseMeta$StVideo2.video_time.set(videoUploadTask != null ? videoUploadTask.iPlayTime : -1L);
        qZoneBaseMeta$StVideo.set(qZoneBaseMeta$StVideo2);
        this.uploadResultBoolMap.put(originPath, Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.qzone.publish.ui.model.a buildUploadParams() {
        IntimateUploadAlbumParams intimateUploadAlbumParams = this.params;
        com.qzone.publish.ui.model.a L = new com.qzone.publish.ui.model.a().C(intimateUploadAlbumParams.getRequestParams().getTarget()).A(intimateUploadAlbumParams.getRequestParams().getRefer()).d(intimateUploadAlbumParams.getBatchId()).f(intimateUploadAlbumParams.getClientKey()).x(intimateUploadAlbumParams.getRequestParams().getPicQuality()).b(intimateUploadAlbumParams.getAlbumInfo().getAlbumId()).v(intimateUploadAlbumParams.getContent()).L(intimateUploadAlbumParams.getRequestParams().getIBusinessType());
        IntimateUploadPoiInfo poiInfo = intimateUploadAlbumParams.getPoiInfo();
        com.qzone.publish.ui.model.a K = L.y(poiInfo != null ? poiInfo.toStPoi() : null).G(intimateUploadAlbumParams.getRequestParams().getPicAppId()).I(intimateUploadAlbumParams.getRequestParams().getVideoAppId()).i(intimateUploadAlbumParams.getRequestParams().getExtendInfo()).M(intimateUploadAlbumParams.getCurNum()).K(intimateUploadAlbumParams.getMaxNum());
        Intrinsics.checkNotNullExpressionValue(K, "params.run {\n           \u2026loadNum(maxNum)\n        }");
        return K;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public boolean cancel() {
        RFWLog.i(getLogTag(), RFWLog.USR, "cancel ");
        QZoneRequest qZoneRequest = this.mRequest;
        if (!(qZoneRequest instanceof QzoneMediaUploadRequest)) {
            return true;
        }
        Intrinsics.checkNotNull(qZoneRequest, "null cannot be cast to non-null type com.qzone.publish.business.protocol.QzoneMediaUploadRequest");
        ((QzoneMediaUploadRequest) qZoneRequest).cancel();
        return true;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    /* renamed from: getCacheKey */
    public String getCommentUniKey() {
        return this.clientKey + "_" + this.params.getCurNum();
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public String getCaseId() {
        return this.params.getSpaceId();
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public List<String> getEditMissionId() {
        return QZWinkEditDraftUtil.h(this.mediaWrapperList);
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public int getExactType() {
        return this.params.getTaskParams().getExactType();
    }

    public String getLogTag() {
        return TAG;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public boolean isNullTask() {
        IntimateUploadAlbumParams intimateUploadAlbumParams;
        return super.isNullTask() || (intimateUploadAlbumParams = this.params) == null || intimateUploadAlbumParams.isEmpty();
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaCompressFailed(String srcPath, int mediaIndex, int errCode, String errMsg) {
        RFWLog.w(getLogTag(), RFWLog.USR, "onMediaCompressFailed, srcPath:" + srcPath + ", mediaIndex:" + mediaIndex + ", errCode:" + errCode + ", errMsg:" + errMsg);
        notifyProgress();
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaCompressProgress(String srcPath, int mediaIndex, double progress) {
        RFWLog.d(getLogTag(), RFWLog.DEV, "onMediaCompressProgress, srcPath:" + srcPath + ", mediaIndex:" + mediaIndex + ", progress:" + progress);
        notifyProgress();
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaCompressSuccess(String srcPath, String destPath, int mediaIndex) {
        RFWLog.i(getLogTag(), RFWLog.USR, "onMediaCompressSuccess, srcPath:" + srcPath + ", destPath:" + destPath + ", mediaIndex:" + mediaIndex);
        notifyProgress();
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadFailed(int mediaIndex, int errCode, String errMsg) {
        RFWLog.w(getLogTag(), RFWLog.USR, "onMediaUploadFailed, mediaIndex:" + mediaIndex + ", errCode:" + errCode + ", errMsg:" + errMsg);
        this.uploadResultBoolMap.put(getOriginPath(mediaIndex), Boolean.FALSE);
        notifyProgress();
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadStart(int mediaIndex, String srcPath, String uploadPath) {
        RFWLog.i(getLogTag(), RFWLog.USR, "onMediaUploadStart, mediaIndex:" + mediaIndex + ", srcPath:" + srcPath + ", uploadPath:" + uploadPath);
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadSuccess(JceStruct response, AbstractUploadTask task, int mediaIndex, String id5, String srcPath, String uploadPath) {
        RFWLog.i(getLogTag(), RFWLog.USR, "onMediaUploadSuccess, mediaIndex:" + mediaIndex + ", id:" + id5 + ", srcPath:" + srcPath + ", uploadPath:" + uploadPath + ", curNum: " + this.params.getCurNum());
        if (response instanceof UploadFileResponse) {
            onPicUploadSucceed(mediaIndex, srcPath, (UploadFileResponse) response);
        } else if (response instanceof UploadVideoInfoRsp) {
            onVideoUploadSucceed(mediaIndex, srcPath, (UploadVideoInfoRsp) response, task instanceof VideoUploadTask ? (VideoUploadTask) task : null);
        }
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public void onRemove() {
        cancel();
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public void onRestore() {
        this.params.setMediaWrapperList(this.mediaWrapperList);
        RFWLog.i(getLogTag(), RFWLog.USR, "onRestore, params:" + this.params);
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    public void onRun() {
        this.mRequest = new QzoneMediaUploadRequest(this.params.getMediaWrapperList(), buildUploadParams(), this, this);
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask task) {
        RFWLog.i(getLogTag(), RFWLog.USR, "onTaskResponse, succeeded:" + (task != null ? Boolean.valueOf(task.succeeded()) : null));
        if (task == null) {
            return;
        }
        getPublishQueue().g(this, task.succeeded());
        onUploadFinish(this.uploadResultMap, this.uploadResultBoolMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onUploadFinish(Map<String, QZoneBaseMeta$StMedia> uploadResult, Map<String, Boolean> uploadResultBool) {
        Intrinsics.checkNotNullParameter(uploadResult, "uploadResult");
        Intrinsics.checkNotNullParameter(uploadResultBool, "uploadResultBool");
        RFWLog.i(getLogTag(), RFWLog.USR, "onUploadFinish, uploadResult:" + uploadResult + ", uploadResultBool:" + uploadResultBool);
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadReport(a.C0436a reportInfo) {
    }
}
