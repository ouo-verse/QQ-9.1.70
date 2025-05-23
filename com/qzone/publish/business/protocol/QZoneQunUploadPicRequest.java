package com.qzone.publish.business.protocol;

import FileUpload.MultiPicInfo;
import FileUpload.PicExtendInfo;
import SLICE_UPLOAD.cnst.appid_qun;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.UploadFileResponse;
import com.qzone.common.protocol.IQZoneProtocolListener;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.business.model.UploadVideoObject;
import com.qzone.publish.business.protocol.QzoneMediaUploadRequest;
import com.qzone.publish.business.task.upload.QZoneVideoUploadTask;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.publish.utils.c;
import com.qzone.util.image.ImageInfo;
import com.qzone.util.image.b;
import com.tencent.component.network.module.report.ReportObj;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.data.ImageUploadTask;
import com.tencent.upload.uinterface.data.NewQunUploadTask;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes39.dex */
public class QZoneQunUploadPicRequest extends QzoneMediaUploadRequest {
    private static final String TAG = "[upload2_QZoneQunUploadPicRequest]";
    public static final int TARGET_QUN_UPLOAD_PHOTO = 1;
    private String mTroopId;
    private int photoNum;
    private int videoNum;

    public QZoneQunUploadPicRequest() {
    }

    private void sendResponse(int i3, UploadFileResponse uploadFileResponse, String str) {
        String str2;
        UniAttribute uniAttribute = new UniAttribute();
        uniAttribute.setEncodeName("utf8");
        uniAttribute.put("ReplyCode", Integer.valueOf(i3 == 0 ? 0 : -1));
        if (i3 == 0) {
            str2 = "success";
        } else {
            str2 = "fail";
        }
        uniAttribute.put("StrResult", str2);
        if (uploadFileResponse != null) {
            uniAttribute.put("response", uploadFileResponse);
        }
        IQZoneProtocolListener iQZoneProtocolListener = this.mListner;
        if (iQZoneProtocolListener != null) {
            iQZoneProtocolListener.onProtocolResponse(uniAttribute, i3, i3, str, false);
        }
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest
    protected ImageUploadTask createImageUploadTask(ImageInfo imageInfo, byte[] bArr, int i3, boolean z16, String str) {
        if (this.mAborted) {
            QZLog.e(TAG, getRequestDesc() + ", createImageUploadTask after aborted, return null!");
            return null;
        }
        if (imageInfo == null) {
            QZLog.e(TAG, getRequestDesc() + ", createImageUploadTask with null imageInfo, return null!");
            return null;
        }
        String str2 = imageInfo.mPath;
        String a16 = a9.a.f25720a.a(str2);
        if (!TextUtils.isEmpty(a16)) {
            str2 = a16;
        }
        NewQunUploadTask newQunUploadTask = new NewQunUploadTask(str2);
        newQunUploadTask.setInnerAppid(appid_qun.value);
        newQunUploadTask.iUin = LoginData.getInstance().getUin();
        newQunUploadTask.sRefer = ReportObj.REPORT_REFER_QQ_QUN;
        newQunUploadTask.vLoginData = bArr;
        String a26 = LoginData.getInstance().getA2();
        newQunUploadTask.a2_key = a26 != null ? a26.getBytes() : null;
        newQunUploadTask.userid = this.uploadParams.K;
        HashMap<String, String> hashMap = new HashMap<>();
        newQunUploadTask.mapExt = hashMap;
        hashMap.put("userid", this.mTroopId);
        newQunUploadTask.sRefer = ReportObj.REPORT_REFER_QQ_QUN;
        newQunUploadTask.flowId = subFlowId((int) this.uploadParams.f51903c, str2);
        newQunUploadTask.sPicTitle = "";
        com.qzone.publish.ui.model.a aVar = this.uploadParams;
        newQunUploadTask.sPicDesc = aVar.f51909i;
        newQunUploadTask.autoRotate = this.autoRotate;
        newQunUploadTask.clientFakeKey = aVar.f51904d;
        newQunUploadTask.iSync = 1;
        newQunUploadTask.sAlbumID = aVar.f51907g;
        newQunUploadTask.iBatchID = aVar.f51903c;
        newQunUploadTask.iUploadType = aVar.f51908h;
        QZLog.e(TAG, "iBatchID:" + this.uploadParams.f51903c);
        newQunUploadTask.uploadFilePath = str2;
        newQunUploadTask.md5 = createFileMD5(str2);
        newQunUploadTask.stExtendInfo = null;
        com.qzone.publish.ui.model.a aVar2 = this.uploadParams;
        long j3 = aVar2.f51906f;
        int i16 = aVar2.f51922v;
        if (i16 < 0) {
            i16 = i3;
        }
        newQunUploadTask.iUploadTime = j3 - i16;
        newQunUploadTask.stExternalMapExt = new HashMap<>();
        try {
            if (newQunUploadTask.stExtendInfo == null) {
                newQunUploadTask.stExtendInfo = new PicExtendInfo();
            }
            newQunUploadTask.stExtendInfo.mapParams = new HashMap();
            newQunUploadTask.stExtendInfo.mapParams.put("photo_num", this.photoNum + "");
            newQunUploadTask.stExtendInfo.mapParams.put("video_num", this.videoNum + "");
            newQunUploadTask.stExtendInfo.mapParams.put("userid", this.mTroopId);
            newQunUploadTask.stExtendInfo.mapParams.put("a2_key", LoginData.getInstance().getA2());
            if (!JpegExifReader.isCrashJpeg(newQunUploadTask.uploadFilePath)) {
                newQunUploadTask.stExtendInfo.mapExif = com.qzone.util.image.a.b(new b(newQunUploadTask.uploadFilePath));
            }
        } catch (Exception unused) {
            QZLog.e(QZLog.TO_DEVICE_TAG, "read pic exif error");
        }
        com.qzone.publish.ui.model.a aVar3 = this.uploadParams;
        newQunUploadTask.uploadPoi = aVar3.f51923w;
        setPreUploadParams(newQunUploadTask, aVar3);
        MultiPicInfo multiPicInfo = new MultiPicInfo();
        com.qzone.publish.ui.model.a aVar4 = this.uploadParams;
        int i17 = aVar4.f51921u;
        if (i17 <= 0) {
            i17 = this.batchMediaNum;
        }
        multiPicInfo.iBatUploadNum = i17;
        int i18 = aVar4.f51922v;
        if (i18 >= 0) {
            i3 = i18;
        }
        multiPicInfo.iCurUpload = i3;
        newQunUploadTask.mutliPicInfo = multiPicInfo;
        newQunUploadTask.uploadTaskCallback = this;
        return newQunUploadTask;
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest
    protected AbstractUploadTask createVideoUploadTask(ShuoshuoVideoInfo shuoshuoVideoInfo, byte[] bArr, int i3) {
        byte[] buildVideoTaskExtra;
        if (this.mAborted) {
            QZLog.e(TAG, getRequestDesc() + ", createVideoUploadTask after aborted, return null!");
            return null;
        }
        if (shuoshuoVideoInfo == null) {
            QZLog.e(TAG, getRequestDesc() + ", createVideoUploadTask with null videoInfo, return null!");
            return null;
        }
        UploadVideoObject createFromShuoshuoVideoInfo = UploadVideoObject.createFromShuoshuoVideoInfo(shuoshuoVideoInfo);
        String str = shuoshuoVideoInfo.mVideoPath;
        if (!TextUtils.isEmpty(str) && !c.e(str)) {
            createFromShuoshuoVideoInfo.mOriganlVideoPath = str;
        }
        this.uploadVideoObjects.put(createFromShuoshuoVideoInfo.getFilePath(), createFromShuoshuoVideoInfo);
        QZoneVideoUploadTask qZoneVideoUploadTask = new QZoneVideoUploadTask(createFromShuoshuoVideoInfo.getFilePath(), this.uploadParams.f51904d);
        qZoneVideoUploadTask.setInnerAppid("video_qun");
        int i16 = this.uploadParams.f51911k;
        if (i16 <= 0) {
            i16 = createFromShuoshuoVideoInfo.getIsNew();
        }
        qZoneVideoUploadTask.iIsNew = i16;
        qZoneVideoUploadTask.iUin = LoginData.getInstance().getUin();
        qZoneVideoUploadTask.sRefer = "mqq";
        qZoneVideoUploadTask.vLoginData = bArr;
        qZoneVideoUploadTask.md5 = createFromShuoshuoVideoInfo.getFileMd5();
        qZoneVideoUploadTask.sTitle = createFromShuoshuoVideoInfo.getTitle();
        qZoneVideoUploadTask.sDesc = createFromShuoshuoVideoInfo.getDesc();
        qZoneVideoUploadTask.iFlag = createFromShuoshuoVideoInfo.getFlag();
        qZoneVideoUploadTask.sCoverUrl = createFromShuoshuoVideoInfo.getCoverUrl();
        qZoneVideoUploadTask.iPlayTime = (int) createFromShuoshuoVideoInfo.getDuration();
        com.qzone.publish.ui.model.a aVar = this.uploadParams;
        long j3 = aVar.f51906f;
        int i17 = aVar.f51922v;
        if (i17 < 0) {
            i17 = i3;
        }
        long j16 = j3 - i17;
        qZoneVideoUploadTask.iUploadTime = j16;
        qZoneVideoUploadTask.iBusiNessType = aVar.f51912l;
        if (aVar.f51915o) {
            buildVideoTaskExtra = aVar.f51913m;
        } else {
            buildVideoTaskExtra = buildVideoTaskExtra(this.batchMediaNum, i3, j16, createFromShuoshuoVideoInfo);
        }
        qZoneVideoUploadTask.vBusiNessData = buildVideoTaskExtra;
        qZoneVideoUploadTask.iIsOriginalVideo = createFromShuoshuoVideoInfo.getIsUploadOrigin();
        qZoneVideoUploadTask.iIsFormatF20 = createFromShuoshuoVideoInfo.getHasCompressed();
        qZoneVideoUploadTask.uploadEntrance = this.uploadParams.f51905e;
        qZoneVideoUploadTask.uploadTaskCallback = this;
        HashMap hashMap = new HashMap();
        qZoneVideoUploadTask.extend_info = hashMap;
        hashMap.put("video_type", UploadVideoObject.getVideoType(shuoshuoVideoInfo));
        qZoneVideoUploadTask.extend_info.put(FSUploadConst.KEY_VIDEO_FORMAT, UploadVideoObject.getVideoForMat(shuoshuoVideoInfo));
        qZoneVideoUploadTask.extend_info.put("qun_id", this.uploadParams.K);
        qZoneVideoUploadTask.extend_info.put("photo_num", this.photoNum + "");
        qZoneVideoUploadTask.extend_info.put("video_num", this.videoNum + "");
        qZoneVideoUploadTask.extend_info.put("time_len", shuoshuoVideoInfo.mDuration + "");
        setUploadEntranceParams(qZoneVideoUploadTask, this.uploadParams.f51905e);
        QZLog.i(TAG, getRequestDesc() + ", createVideoUploadTask finish. videoPath:" + qZoneVideoUploadTask.uploadFilePath + ", flowId:" + qZoneVideoUploadTask.flowId + ", index: " + i3 + ", iUploadTime:" + qZoneVideoUploadTask.iUploadTime);
        return qZoneVideoUploadTask;
    }

    public QZoneQunUploadPicRequest(List<MediaWrapper> list, com.qzone.publish.ui.model.a aVar, com.qzone.publish.business.publishqueue.c cVar, QzoneMediaUploadRequest.b bVar, String str, int i3, int i16) {
        super(list, aVar, cVar, bVar);
        this.mTroopId = str;
        this.photoNum = i3;
        this.videoNum = i16;
    }
}
