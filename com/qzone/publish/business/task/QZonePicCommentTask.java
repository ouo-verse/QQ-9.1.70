package com.qzone.publish.business.task;

import NS_MOBILE_OPERATION.MediaInfo;
import NS_MOBILE_OPERATION.PicInfo;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.qzone.common.business.result.UploadFileResponse;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneAddCommentRequest;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.publish.business.model.a;
import com.qzone.publish.business.protocol.QzoneMediaUploadRequest;
import com.qzone.publish.business.publishqueue.QZonePublishQueue;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.upload.uinterface.AbstractUploadTask;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes39.dex */
public class QZonePicCommentTask extends QZoneQueueTask implements QzoneMediaUploadRequest.b, a {
    private static final int STEP_COMMENT = 1;
    private static final int STEP_UPLOAD_PHOTOS = 0;
    private static final String TAG = "[upload2_QZonePicCommentTask]";

    @NeedParcel
    private int appid;

    @NeedParcel
    private Map<Integer, String> busi_param;

    @NeedParcel
    private String commentUniKey;

    @NeedParcel
    private String content;

    @NeedParcel
    private String contentCacheUniKey;

    @NeedParcel
    public int curImageIndex;

    @NeedParcel
    private Map<String, String> extendInfo;

    @NeedParcel
    private ArrayList<String> images;

    @NeedParcel
    private boolean isPrivate;

    @NeedParcel
    private int isverified;

    @NeedParcel
    public Map<String, String> localUrlMap;

    @NeedParcel
    private MediaInfo mediaInfo;

    @NeedParcel
    private long ownuin;

    @NeedParcel
    private String refer;

    @NeedParcel
    private String srcId;

    @NeedParcel
    private int step;

    @NeedParcel
    private Map<String, PicInfo> uploadPicInfoMap;

    public QZonePicCommentTask() {
        this.step = 0;
        this.mediaInfo = new MediaInfo();
        this.curImageIndex = 0;
        this.localUrlMap = new HashMap();
        this.commentUniKey = "";
    }

    private void addUploadPhotoResponse(UploadFileResponse uploadFileResponse, String str, int i3) {
        PicInfo picInfo = new PicInfo();
        picInfo.picheight = uploadFileResponse.height;
        picInfo.picwidth = uploadFileResponse.width;
        picInfo.pictype = uploadFileResponse.picType;
        picInfo.albumid = uploadFileResponse.albumId;
        picInfo.pictureid = uploadFileResponse.photoId;
        picInfo.hdwidth = uploadFileResponse.owidth;
        picInfo.hdheight = uploadFileResponse.oheight;
        picInfo.sloc = uploadFileResponse.slocId;
        picInfo.pic_url = uploadFileResponse.url;
        if (this.uploadPicInfoMap == null) {
            this.uploadPicInfoMap = new HashMap();
        }
        if (TextUtils.isEmpty(str)) {
            ArrayList<String> arrayList = this.images;
            if (arrayList != null && arrayList.size() > 0 && this.images.size() > i3) {
                str = this.images.get(i3);
            } else if (!TextUtils.isEmpty(uploadFileResponse.originUploadUrl)) {
                str = uploadFileResponse.originUploadUrl;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            this.uploadPicInfoMap.put(str, picInfo);
        } else {
            QZLog.w(TAG, "addUploadPhotoResponse picPath is null, index:" + i3);
        }
        if (!TextUtils.isEmpty(uploadFileResponse.originUploadUrl)) {
            if (!uploadFileResponse.originUploadUrl.startsWith("file://")) {
                uploadFileResponse.originUploadUrl = "file://" + uploadFileResponse.originUploadUrl;
            }
            this.localUrlMap.put(uploadFileResponse.clientFakeKey, uploadFileResponse.originUploadUrl);
        }
        this.curImageIndex = i3;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public boolean cancel() {
        QZoneRequest qZoneRequest = this.mRequest;
        if (qZoneRequest == null) {
            return false;
        }
        if (qZoneRequest instanceof QzoneMediaUploadRequest) {
            return ((QzoneMediaUploadRequest) qZoneRequest).cancel();
        }
        if (!(qZoneRequest instanceof QZoneAddCommentRequest)) {
            return false;
        }
        ((QZoneAddCommentRequest) qZoneRequest).cancel(true);
        return true;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public void clear() {
        QZoneRequest qZoneRequest = this.mRequest;
        if (qZoneRequest == null || !(qZoneRequest instanceof QzoneMediaUploadRequest)) {
            return;
        }
        ((QzoneMediaUploadRequest) qZoneRequest).clear();
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    /* renamed from: getCacheKey */
    public String getCommentUniKey() {
        return this.commentUniKey;
    }

    public int getCurrentImgIndex() {
        return this.curImageIndex;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public int getExactType() {
        return 13;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    public long getFakeSize() {
        ArrayList<String> arrayList = this.images;
        if (arrayList == null) {
            return 0L;
        }
        Iterator<String> it = arrayList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 = (int) (i3 + com.qzone.util.image.c.y(it.next(), 0));
        }
        return i3;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    public List<String> getImageUrls() {
        return this.images;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public c getInfo() {
        c info = super.getInfo();
        info.f51185a = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoComment", "\u53d1\u8bc4\u8bba");
        if (getState() == 1) {
            long j3 = this.mRecvDataSize;
            if (j3 > 0) {
                long j16 = this.mTotalSize;
                if (j16 > 0) {
                    info.f51190f = (int) ((j3 * 100) / j16);
                    if (this.curImageIndex >= 0 && this.images.size() > 0) {
                        info.f51186b = this.mRecvDataSize + "k/" + this.mTotalSize + "k";
                    }
                }
            }
        }
        if (getImageUrls() != null && getImageUrls().size() != 0) {
            int size = getImageUrls().size();
            int currentImgIndex = getCurrentImgIndex();
            if (currentImgIndex >= 0 && size > currentImgIndex) {
                info.f51194j = size - currentImgIndex;
                info.f51192h = getImageUrls().get(currentImgIndex);
            }
        }
        return info;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public boolean isNullTask() {
        return getImageUrls() == null || getImageUrls().size() == 0;
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadFailed(int i3, int i16, String str) {
        QZLog.i(TAG, "onMediaUploadFailed mediaIndex:" + i3 + ", errCode:" + i16 + ", errMsg:" + str);
        QZonePublishQueue.w().d(this);
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        int i3 = this.step;
        if (i3 == 0) {
            if (qZoneTask.succeeded()) {
                this.step = 1;
                super.run();
                return;
            } else {
                QZonePublishQueue.w().g(this, false);
                return;
            }
        }
        if (i3 != 1) {
            return;
        }
        if (qZoneTask.succeeded()) {
            QZonePublishQueue.w().g(this, true);
            QZoneWriteOperationService.v0().onTaskResponse(qZoneTask);
        } else {
            QZonePublishQueue.w().g(this, false);
        }
    }

    public void setCommentUniKey(String str) {
        this.commentUniKey = str;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    public void onRun() {
        int i3 = this.step;
        if (i3 == 0) {
            com.qzone.publish.ui.model.a aVar = new com.qzone.publish.ui.model.a();
            aVar.C(4).d(this.batchId).f(this.clientKey).x(0).c(22).F(33);
            this.mRequest = new QzoneMediaUploadRequest(com.qzone.publish.utils.c.h(this.images), aVar, this, this);
            return;
        }
        if (i3 != 1) {
            return;
        }
        ArrayList<String> arrayList = this.images;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<String> it = this.images.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    Map<String, PicInfo> map = this.uploadPicInfoMap;
                    if (map != null && map.get(next) != null) {
                        appendPicInfo(this.uploadPicInfoMap.get(next));
                    } else {
                        QZLog.w(TAG, "on STEP_COMMENT, image:" + next + " picInfo null");
                    }
                }
            }
        }
        this.mRequest = new QZoneAddCommentRequest(0, this.appid, this.ownuin, this.srcId, this.content, this.contentCacheUniKey, this.isverified, this.busi_param, this.refer, this.isPrivate, this.mediaInfo, this.extendInfo);
    }

    private void appendPicInfo(PicInfo picInfo) {
        if (picInfo == null) {
            return;
        }
        if (this.mediaInfo == null) {
            this.mediaInfo = new MediaInfo();
        }
        MediaInfo mediaInfo = this.mediaInfo;
        if (mediaInfo.picinfolist == null) {
            mediaInfo.picinfolist = new ArrayList<>();
        }
        this.mediaInfo.picinfolist.add(picInfo);
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadSuccess(JceStruct jceStruct, AbstractUploadTask abstractUploadTask, int i3, String str, String str2, String str3) {
        if (jceStruct == null || i3 < 0) {
            return;
        }
        QZLog.i(TAG, "onMediaUploadSuccess mediaIndex:" + i3 + ", id:" + str + ", srcPath:" + str2 + ", uploadPath:" + str3);
        if (jceStruct instanceof UploadFileResponse) {
            addUploadPhotoResponse((UploadFileResponse) jceStruct, str2, i3);
        }
        QZonePublishQueue.w().d(this);
    }

    public QZonePicCommentTask(int i3, int i16, long j3, String str, String str2, String str3, String str4, int i17, Map<Integer, String> map, String str5, boolean z16, ArrayList<String> arrayList, Map<String, String> map2) {
        super(i3);
        this.step = 0;
        this.mediaInfo = new MediaInfo();
        this.curImageIndex = 0;
        this.localUrlMap = new HashMap();
        this.commentUniKey = "";
        this.appid = i16;
        this.ownuin = j3;
        this.srcId = str;
        this.content = str2;
        this.contentCacheUniKey = str3;
        this.clientKey = str4;
        this.batchId = r7.a.a();
        this.isverified = i17;
        this.busi_param = map;
        this.refer = str5;
        this.images = arrayList;
        this.isPrivate = z16;
        this.extendInfo = map2;
        if (arrayList != null && arrayList.size() > 0) {
            this.step = 0;
        } else {
            this.step = 1;
        }
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadReport(a.C0436a c0436a) {
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaCompressProgress(String str, int i3, double d16) {
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaCompressSuccess(String str, String str2, int i3) {
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadStart(int i3, String str, String str2) {
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaCompressFailed(String str, int i3, int i16, String str2) {
    }
}
