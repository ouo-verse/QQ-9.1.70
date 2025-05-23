package com.qzone.publish.business.task;

import FileUpload.stPoi;
import NS_MOBILE_PHOTO.upload_finish_rsp;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.qzone.album.data.model.GifInfo;
import com.qzone.common.business.result.UploadFileResponse;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.publish.business.model.a;
import com.qzone.publish.business.protocol.QzoneMediaUploadRequest;
import com.qzone.publish.business.protocol.QzoneUploadPicFinishRequest;
import com.qzone.publish.business.publishqueue.QZonePreUploadInfo;
import com.qzone.publish.business.publishqueue.h;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.util.image.ImageInfo;
import com.qzone.util.l;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.upload.uinterface.AbstractUploadTask;
import common.config.service.QzoneConfig;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes39.dex */
public class QZoneUploadPicTask extends QZoneQueueTask implements QzoneMediaUploadRequest.b {
    protected static final int STEP_FINISH = 2;
    protected static final int STEP_UPLOAD = 1;
    protected static final String TAG = "[upload2_QZoneUploadPicTask]";

    @NeedParcel
    public String albumname;

    @NeedParcel
    public String albumsId;

    @NeedParcel
    protected int curNum;
    Map<String, String> extend_info;

    @NeedParcel
    protected int flowId;

    @NeedParcel
    public ArrayList<GifInfo> gifList;
    boolean isVideoMix;

    @NeedParcel
    long lastModifyTime;

    @NeedParcel
    protected Map<String, String> localUrlMap;

    @NeedParcel
    public HashMap<String, byte[]> mExternalData;

    @NeedParcel
    protected Map<String, byte[]> mPasters;

    @NeedParcel
    protected Map<String, String> mPhotoTagExtendInfo;

    @NeedParcel
    protected LbsDataV2.PoiInfo mPoiInfo;

    @NeedParcel
    protected String mRefer;

    @NeedParcel
    protected stPoi mStPoi;

    @NeedParcel
    protected int maxNum;
    b mixUploadTask;
    protected String open_appid;

    @NeedParcel
    protected int panoramaType;

    @NeedParcel
    protected String photoDescription;

    @NeedParcel
    protected String photoFilePath;

    @NeedParcel
    protected String photoName;

    @NeedParcel
    protected int picQuality;
    protected QZonePreUploadInfo preUploadInfo;
    protected int recentPicCount;
    protected Map<String, String> shootParams;

    @NeedParcel
    protected int step;
    protected int successCount;

    @NeedParcel
    protected int target;

    @NeedParcel
    protected int uploadEntrance;
    protected int uploadFinishRetryCount;

    @NeedParcel
    protected long uploadTime;
    String uploadToAlbum;

    public QZoneUploadPicTask() {
        this.albumname = "";
        this.uploadFinishRetryCount = 0;
        this.step = 1;
        this.uploadToAlbum = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoUploadToAlbum", "\u4e0a\u4f20\u7167\u7247\u5230\u300a\u624b\u673a\u76f8\u518c\u300b");
    }

    private void triggerFetchRealFeed() {
        if (com.qzone.reborn.feedpro.utils.d.f54318a.b()) {
            le.b.f414397d.f(true, this.clientKey, null);
        } else {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).postDelayed(new Runnable() { // from class: com.qzone.publish.business.task.QZoneUploadPicTask.3
                @Override // java.lang.Runnable
                public void run() {
                    QZoneUploadPicTask.this.run();
                }
            }, 1000L);
        }
    }

    protected com.qzone.publish.ui.model.a buildQZoneMediaUploadParams(Map<String, String> map) {
        com.qzone.publish.ui.model.a aVar = new com.qzone.publish.ui.model.a();
        aVar.C(this.target).A(this.mRefer).d(this.batchId).f(this.clientKey).F(this.uploadEntrance).H(this.uploadTime).x(this.picQuality).b(this.albumsId).v(this.photoDescription).t(getWaterMark()).L(0).K(this.maxNum).M(this.curNum).z(this.preUploadInfo).p(map).y(this.mStPoi).B(this.shootParams).u(this.open_appid).h(this.extend_info).s(this.isVideoMix).j(this.mExternalData);
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

    protected void compressGif(GifInfo gifInfo) {
        if (com.qzone.util.image.c.b(gifInfo)) {
            gifInfo.mDestPath = gifInfo.mSavePath;
            File file = new File(gifInfo.mDestPath);
            if (file.exists()) {
                if (!gifInfo.mOrignPath.equals(gifInfo.mCombineImagePath)) {
                    new File(gifInfo.mCombineImagePath).delete();
                }
                addToRecentPhotoBlacklists(gifInfo.mDestPath);
                String str = gifInfo.mDestPath;
                this.photoFilePath = str;
                this.flowId = subFlowId((int) this.batchId, str);
                BaseApplication.getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
            }
        }
    }

    protected void compressListToGif(GifInfo gifInfo) {
        if (com.qzone.util.image.c.e(gifInfo)) {
            gifInfo.mDestPath = gifInfo.mSavePath;
            File file = new File(gifInfo.mDestPath);
            if (file.exists()) {
                if (!gifInfo.mOrignPath.equals(gifInfo.mCombineImagePath)) {
                    new File(gifInfo.mCombineImagePath).delete();
                }
                addToRecentPhotoBlacklists(gifInfo.mDestPath);
                String str = gifInfo.mDestPath;
                this.photoFilePath = str;
                this.flowId = subFlowId((int) this.batchId, str);
                BaseApplication.getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void encodeGif() {
        if (this.gifList == null) {
            return;
        }
        QZLog.i(TAG, 2, "encodeGif gifList size:" + this.gifList.size());
        for (int i3 = 0; i3 < this.gifList.size(); i3++) {
            QZLog.i(TAG, 2, getTaskDesc() + ", photoFilePath:" + this.photoFilePath + ", mCombineImagePath:" + this.gifList.get(i3).mCombineImagePath);
            if (this.photoFilePath.equals(this.gifList.get(i3).mCombineImagePath) && this.gifList.get(i3).mDestPath != null) {
                QZLog.i(TAG, 2, getTaskDesc() + ", mDestPath has exist !! mDestPath:" + this.gifList.get(i3).mDestPath);
                if (new File(this.gifList.get(i3).mDestPath).exists()) {
                    String str = this.gifList.get(i3).mDestPath;
                    this.photoFilePath = str;
                    this.flowId = subFlowId((int) this.batchId, str);
                }
            } else if (this.photoFilePath.equals(this.gifList.get(i3).mCombineImagePath)) {
                if (this.gifList.get(i3).isBaseGif) {
                    compressGif(this.gifList.get(i3));
                } else {
                    compressListToGif(this.gifList.get(i3));
                }
            }
        }
    }

    public String getAlbumId() {
        return this.albumsId;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    /* renamed from: getCacheKey */
    public String getCommentUniKey() {
        return this.clientKey + "_" + this.curNum;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public int getExactType() {
        return 2;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    public long getFakeSize() {
        return com.qzone.util.image.c.y(this.photoFilePath, this.picQuality);
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public c getInfo() {
        c info = super.getInfo();
        String str = this.albumname;
        if (str != null && str.length() != 0) {
            info.f51185a = l.a(R.string.s_h) + this.albumname + "\u300b";
        } else {
            info.f51185a = this.uploadToAlbum;
        }
        if (getState() == 0 || getState() == 1) {
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
        return this.localUrlMap;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public String getPhotoSource() {
        return this.photoFilePath;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getTaskDesc() {
        return "id:" + getTaskId() + ", batchId:" + this.batchId + ", fakeKey:" + getCommentUniKey();
    }

    public int getUploadEntrance() {
        return this.uploadEntrance;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public long getUploadTime() {
        return this.uploadTime;
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
        if (h.c(this.batchId)) {
            h.a b16 = h.b(this.batchId, false, new HashMap());
            this.localUrlMap = b16.f51146e;
            QZLog.i(TAG, 1, getTaskDesc() + ", remove pid upload, " + b16.toString());
            if ((b16.f51142a == 0 && b16.f51143b > 0) || b16.f51143b == b16.f51145d) {
                QZLog.i(TAG, 1, getTaskDesc() + ", send upload_finish_rsp rptFinish on task remove");
                this.step = 2;
                this.mState = 7;
                this.successCount = b16.f51143b;
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).postDelayed(new Runnable() { // from class: com.qzone.publish.business.task.QZoneUploadPicTask.4
                    @Override // java.lang.Runnable
                    public void run() {
                        QZoneUploadPicTask.this.run();
                    }
                }, 1000L);
            }
            h.g(this.batchId);
        }
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public void onResume() {
        super.onResume();
        h.h(this.batchId);
        resetStep();
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    public void onRun() {
        QZLog.i(TAG, getTaskDesc() + ", onRun -- step:" + this.step);
        com.qzone.publish.business.model.a aVar = this.mReportInfo;
        if (aVar != null && (aVar.f51012c == 0 || aVar.f51014e < this.retryNum)) {
            com.qzone.publish.business.model.a aVar2 = new com.qzone.publish.business.model.a();
            this.mReportInfo = aVar2;
            aVar2.f51010a = 2;
            aVar2.f51012c = System.currentTimeMillis();
            this.mReportInfo.f51014e = this.retryNum;
        }
        int i3 = this.step;
        if (i3 != 1) {
            if (i3 != 2) {
                return;
            }
            long j3 = this.batchId;
            String str = this.albumsId;
            if (str == null) {
                str = "";
            }
            QzoneUploadPicFinishRequest qzoneUploadPicFinishRequest = new QzoneUploadPicFinishRequest(j3, str, this.maxNum, this.successCount, this.uploadFinishRetryCount, this.clientKey, this.recentPicCount);
            this.mRequest = qzoneUploadPicFinishRequest;
            qzoneUploadPicFinishRequest.setRefer(this.mRefer);
            this.uploadFinishRetryCount++;
            return;
        }
        if (TextUtils.isEmpty(this.photoFilePath)) {
            QZLog.w(TAG, "onRun STEP_UPLOAD photoFilePath empty, break");
            return;
        }
        encodeGif();
        HashMap hashMap = new HashMap();
        hashMap.put(this.photoFilePath, String.valueOf(this.panoramaType));
        com.qzone.publish.ui.model.a buildQZoneMediaUploadParams = buildQZoneMediaUploadParams(hashMap);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MediaWrapper(new ImageInfo(this.photoFilePath)));
        this.mRequest = new QzoneMediaUploadRequest(arrayList, buildQZoneMediaUploadParams, this, this);
        com.qzone.publish.business.model.a aVar3 = this.mReportInfo;
        if (aVar3 != null) {
            aVar3.f51011b = 4;
        }
    }

    public void onTaskResponse(QZoneTask qZoneTask) {
        int i3;
        QZLog.i(TAG, getTaskDesc() + ", onTaskResponse -- step:" + this.step);
        if (qZoneTask == null) {
            return;
        }
        int i16 = this.step;
        boolean z16 = false;
        if (i16 != 1) {
            if (i16 == 2) {
                if (qZoneTask.succeeded()) {
                    upload_finish_rsp upload_finish_rspVar = (upload_finish_rsp) qZoneTask.mRequest.rsp;
                    if (upload_finish_rspVar != null && upload_finish_rspVar.retry_timeout > 0) {
                        QZLog.i(TAG, 1, getTaskDesc() + " send upload_finish_rsp failed, retry timeout:" + upload_finish_rspVar.retry_timeout);
                        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).postDelayed(new Runnable() { // from class: com.qzone.publish.business.task.QZoneUploadPicTask.1
                            @Override // java.lang.Runnable
                            public void run() {
                                QZoneUploadPicTask.this.run();
                            }
                        }, (long) (upload_finish_rspVar.retry_timeout * 1000));
                        z16 = true;
                    }
                    if (z16) {
                        return;
                    }
                    if (this.isVideoMix) {
                        this.mType = 28;
                    }
                    QZoneWriteOperationService.v0().onTaskResponse(qZoneTask);
                    QZLog.i(TAG, 1, getTaskDesc() + "send upload_finish_rsp success");
                    return;
                }
                String[] split = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_FAKE_FEED_RETRY_TIMEOUT, QzoneConfig.DefaultValue.DEFAULT_FAKE_FEED_RETRY_TIMEOUT).split("/");
                if (split == null || (i3 = this.uploadFinishRetryCount) > split.length) {
                    return;
                }
                int parseInt = Integer.parseInt(split[i3 - 1]);
                QZLog.i(TAG, 1, getTaskDesc() + "send upload_finish_rsp failed, wns config retry timeout:" + parseInt);
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).postDelayed(new Runnable() { // from class: com.qzone.publish.business.task.QZoneUploadPicTask.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QZoneUploadPicTask.this.run();
                    }
                }, (long) (parseInt * 1000));
                return;
            }
            return;
        }
        getPublishQueue().g((QZoneQueueTask) qZoneTask, qZoneTask.succeeded());
        if (qZoneTask.succeeded() && h.c(this.batchId)) {
            UploadFileResponse uploadFileResponse = (UploadFileResponse) qZoneTask.mUniAttr.get("response");
            HashMap hashMap = new HashMap();
            if (uploadFileResponse != null) {
                hashMap.put(uploadFileResponse.clientFakeKey, uploadFileResponse.originUploadUrl);
            }
            h.a b16 = h.b(this.batchId, qZoneTask.succeeded(), hashMap);
            this.localUrlMap = b16.f51146e;
            QZLog.i(TAG, 1, getTaskDesc() + ", upload pic success, uploadTime:" + this.uploadTime + ", picPath:" + this.photoFilePath + ", " + b16.toString());
            if ((b16.f51142a != 0 || b16.f51143b <= 0) && b16.f51143b != b16.f51145d) {
                return;
            }
            if (this.isVideoMix) {
                QZoneWriteOperationService v06 = QZoneWriteOperationService.v0();
                b bVar = this.mixUploadTask;
                b bVar2 = this.mixUploadTask;
                v06.notify(49, this.clientKey, this.mixUploadTask.a(), bVar.f51182c, Long.valueOf(bVar.f51183d), bVar2.f51181b, bVar2.f51184e, 2);
            }
            this.step = 2;
            this.successCount = b16.f51143b;
            QZLog.i(TAG, getTaskDesc() + ", all batch media upload finish, send upload_finish_rsp");
            triggerFetchRealFeed();
        }
    }

    public void setLocalUrlMap(Map<String, String> map) {
        this.localUrlMap = map;
    }

    public void setMixUploadTaskInfo(b bVar) {
        this.mixUploadTask = bVar;
    }

    public void setPhotoTagExtendInfo(Map<String, String> map) {
        this.mPhotoTagExtendInfo = map;
    }

    public void resetStep() {
        this.step = 1;
    }

    protected void convertPoiInfo(LbsDataV2.PoiInfo poiInfo) {
        if (poiInfo != null) {
            this.mStPoi = k5.a.d(poiInfo);
        }
    }

    public QZoneUploadPicTask(int i3, int i16, String str, String str2, long j3, String str3, String str4, String str5, int i17, LbsDataV2.PoiInfo poiInfo, int i18, int i19, long j16, int i26, long j17, String str6, String str7, QZonePreUploadInfo qZonePreUploadInfo, Map<String, String> map, int i27, int i28, String str8, Map<String, byte[]> map2, Map<String, String> map3, boolean z16, ArrayList<GifInfo> arrayList, HashMap<String, byte[]> hashMap) {
        this(i3, i16, str, str2, str3, str4, str5, i17, poiInfo, i18, i19, j16, i26, j17, str6, str7, i28, arrayList);
        this.preUploadInfo = qZonePreUploadInfo;
        this.shootParams = map;
        this.recentPicCount = i27;
        this.open_appid = str8;
        this.mPasters = map2;
        this.lastModifyTime = j3;
        this.extend_info = map3;
        this.isVideoMix = z16;
        this.mExternalData = hashMap;
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadSuccess(JceStruct jceStruct, AbstractUploadTask abstractUploadTask, int i3, String str, String str2, String str3) {
        if (jceStruct == null || i3 < 0) {
            return;
        }
        QZLog.i(TAG, "onMediaUploadSuccess mediaIndex:" + i3 + ", id:" + str + ", srcPath:" + str2 + ", uploadPath:" + str3);
        getPublishQueue().d(this);
    }

    public QZoneUploadPicTask(int i3, int i16, String str, String str2, String str3, String str4, String str5, int i17, LbsDataV2.PoiInfo poiInfo, int i18, int i19, long j3, int i26, long j16, String str6, String str7, int i27, ArrayList<GifInfo> arrayList) {
        super(i26);
        this.albumname = "";
        this.uploadFinishRetryCount = 0;
        this.step = 1;
        this.uploadToAlbum = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoUploadToAlbum", "\u4e0a\u4f20\u7167\u7247\u5230\u300a\u624b\u673a\u76f8\u518c\u300b");
        this.photoName = str;
        this.panoramaType = i16;
        this.target = i3;
        this.photoFilePath = str2;
        this.photoDescription = str5;
        this.albumsId = str3;
        this.albumname = str4;
        this.picQuality = i17;
        this.maxNum = i18;
        this.curNum = i19;
        this.batchId = j3;
        this.mPoiInfo = poiInfo;
        this.uploadTime = j16;
        this.clientKey = str6;
        this.mRefer = str7;
        this.uploadEntrance = i27;
        this.gifList = arrayList;
        convertPoiInfo(poiInfo);
        this.step = 1;
        this.flowId = subFlowId((int) j3, str2);
        QZLog.i(TAG, getTaskDesc() + ", constructor flowId:" + this.flowId + ", photoFilePath:" + str2);
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
