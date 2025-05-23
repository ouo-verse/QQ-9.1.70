package com.qzone.publish.business.task;

import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.business.protocol.QZoneQunUploadPicRequest;
import com.qzone.publish.business.protocol.QzoneQunUploadPicFinishRequest;
import com.qzone.publish.business.publishqueue.QZonePublishQueue;
import com.qzone.publish.ui.model.MediaWrapper;
import com.tencent.component.annotation.NeedParcel;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneQunUploadVideoTask extends QZoneUploadAlbumVideoTask {
    public static final int QUN_UPLOAD_ENTRANCE = 44;

    @NeedParcel
    private String mTroopId;

    @NeedParcel
    private int photoNum;

    @NeedParcel
    private int videoNum;

    public QZoneQunUploadVideoTask() {
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public boolean isQunTask() {
        return true;
    }

    @Override // com.qzone.publish.business.task.QZoneUploadAlbumVideoTask, com.qzone.publish.business.task.QZoneQueueTask
    public void onRun() {
        QZLog.e("[upload2_QZoneUploadAlbumVideoTask]", getTaskDesc() + ", onRun -- mStep: " + this.mStep);
        com.qzone.publish.business.model.a aVar = this.mReportInfo;
        if (aVar != null && (aVar.f51012c == 0 || aVar.f51014e < this.retryNum)) {
            com.qzone.publish.business.model.a aVar2 = new com.qzone.publish.business.model.a();
            this.mReportInfo = aVar2;
            aVar2.f51010a = 2;
            aVar2.f51012c = System.currentTimeMillis();
            this.mReportInfo.f51014e = this.retryNum;
        }
        if (this.mState != 5 && !this.mTaskIsRunning) {
            this.mTaskIsRunning = true;
        }
        int i3 = this.mStep;
        if (i3 != 2) {
            if (i3 != 3) {
                return;
            }
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "QZoneUploadPicTask.onRun STEP_FINISH");
            String str = this.mTroopId;
            long j3 = this.batchId;
            String str2 = this.sAlbumID;
            QzoneQunUploadPicFinishRequest qzoneQunUploadPicFinishRequest = new QzoneQunUploadPicFinishRequest(str, j3, str2 == null ? "" : str2, this.curNum, this.mSuccessCount, this.clientKey, this.taskRetryCount, TextUtils.isEmpty(str2) ? 1 : 0);
            this.mRequest = qzoneQunUploadPicFinishRequest;
            qzoneQunUploadPicFinishRequest.setRefer(this.mRefer);
            this.taskRetryCount++;
            return;
        }
        if (!isVideoNeedProcess() && !isVideoExist()) {
            this.f45835msg = this.notExist;
            QZLog.e("[upload2_QZoneUploadAlbumVideoTask]", getTaskDesc() + ", video file not found, completeTask false");
            QZonePublishQueue.w().g(this, false);
            return;
        }
        if (isVideoTask()) {
            UniAttribute uniAttribute = new UniAttribute();
            uniAttribute.setEncodeName("utf8");
            uniAttribute.put("hostuin", Long.valueOf(LoginData.getInstance().getUin()));
            if (!TextUtils.isEmpty(this.mRefer)) {
                uniAttribute.put("refer", this.mRefer);
            }
            byte[] buildExtra = buildExtra();
            com.qzone.publish.ui.model.a aVar3 = new com.qzone.publish.ui.model.a();
            aVar3.C(0).A(this.mRefer).d(this.batchId).f(this.clientKey).F(44).b(this.sAlbumID).H(this.uploadTime).q(111).L(0).O(buildExtra).N(this.stExternalMapExt).K(this.maxNum).M(this.curNum).l(true).y(k5.a.d(this.mPoiInfo)).B(this.mShootParams).e("video_shuoshuo").D(this.mTroopId);
            ArrayList arrayList = new ArrayList();
            ShuoshuoVideoInfo shuoshuoVideoInfo = this.mVideoInfo;
            shuoshuoVideoInfo.mDesc = this.mContent;
            arrayList.add(new MediaWrapper(shuoshuoVideoInfo));
            this.mRequest = new QZoneQunUploadPicRequest(arrayList, aVar3, this, this, this.mTroopId, this.photoNum, this.videoNum);
            com.qzone.publish.business.model.a aVar4 = this.mReportInfo;
            if (aVar4 != null) {
                aVar4.f51011b = 5;
            }
        }
    }

    public QZoneQunUploadVideoTask(int i3, ShuoshuoVideoInfo shuoshuoVideoInfo, String str, long j3, String str2, LbsDataV2.PoiInfo poiInfo, int i16, int i17, Map<String, String> map, String str3, int i18, int i19) {
        super(i3, shuoshuoVideoInfo, str, j3, str2, poiInfo, i16, i17, map);
        this.isQunUplaod = true;
        this.mTroopId = str3;
        this.photoNum = i18;
        this.videoNum = i19;
    }
}
