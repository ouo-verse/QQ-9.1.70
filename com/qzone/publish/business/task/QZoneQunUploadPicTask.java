package com.qzone.publish.business.task;

import android.text.TextUtils;
import com.qzone.album.data.model.GifInfo;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.publish.business.protocol.QZoneQunUploadPicRequest;
import com.qzone.publish.business.protocol.QzoneQunUploadPicFinishRequest;
import com.qzone.publish.business.publishqueue.QZonePreUploadInfo;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.util.image.ImageInfo;
import com.tencent.component.annotation.NeedParcel;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes39.dex */
public class QZoneQunUploadPicTask extends QZoneUploadPicTask {
    public static final int QUN_UPLOAD_ENTRANCE = 44;
    protected static final String TAG = "[upload2_QZoneQunUploadPicTask]";

    @NeedParcel
    private String mTroopId;

    @NeedParcel
    private int photoNum;

    @NeedParcel
    private int videoNum;

    public QZoneQunUploadPicTask() {
    }

    public String getQunCode() {
        return this.mTroopId;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public boolean isQunTask() {
        return true;
    }

    @Override // com.qzone.publish.business.task.QZoneUploadPicTask, com.qzone.publish.business.task.QZoneQueueTask
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
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "QZoneUploadPicTask.onRun STEP_FINISH");
            String str = this.mTroopId;
            long j3 = this.batchId;
            String str2 = this.albumsId;
            QzoneQunUploadPicFinishRequest qzoneQunUploadPicFinishRequest = new QzoneQunUploadPicFinishRequest(str, j3, str2 == null ? "" : str2, this.curNum, this.successCount, this.clientKey, this.uploadFinishRetryCount, TextUtils.isEmpty(str2) ? 1 : 0);
            this.mRequest = qzoneQunUploadPicFinishRequest;
            qzoneQunUploadPicFinishRequest.setRefer(this.mRefer);
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
        com.qzone.publish.ui.model.a aVar3 = new com.qzone.publish.ui.model.a();
        aVar3.C(this.target).A(this.mRefer).d(this.batchId).f(this.clientKey).F(44).H(this.uploadTime).x(this.picQuality).b(this.albumsId).v(this.photoDescription).t(getWaterMark()).L(0).K(this.maxNum).M(this.curNum).z(this.preUploadInfo).p(hashMap).y(this.mStPoi).B(this.shootParams).u(this.open_appid).h(this.extend_info).s(this.isVideoMix).j(this.mExternalData).D(this.mTroopId);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MediaWrapper(new ImageInfo(this.photoFilePath)));
        this.mRequest = new QZoneQunUploadPicRequest(arrayList, aVar3, this, this, this.mTroopId, this.photoNum, this.videoNum);
        com.qzone.publish.business.model.a aVar4 = this.mReportInfo;
        if (aVar4 != null) {
            aVar4.f51011b = 4;
        }
    }

    @Override // com.qzone.publish.business.task.QZoneUploadPicTask, com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        super.onTaskResponse(qZoneTask);
    }

    public QZoneQunUploadPicTask(int i3, int i16, String str, String str2, long j3, String str3, String str4, String str5, int i17, LbsDataV2.PoiInfo poiInfo, int i18, int i19, long j16, int i26, long j17, String str6, String str7, QZonePreUploadInfo qZonePreUploadInfo, Map<String, String> map, int i27, int i28, String str8, Map<String, byte[]> map2, Map<String, String> map3, boolean z16, ArrayList<GifInfo> arrayList, HashMap<String, byte[]> hashMap, String str9, int i29, int i36) {
        super(i3, i16, str, str2, j3, str3, str4, str5, i17, poiInfo, i18, i19, j16, i26, j17, str6, str7, qZonePreUploadInfo, map, i27, i28, str8, map2, map3, false, arrayList, hashMap);
        this.mTroopId = str9;
        this.photoNum = i29;
        this.videoNum = i36;
    }
}
