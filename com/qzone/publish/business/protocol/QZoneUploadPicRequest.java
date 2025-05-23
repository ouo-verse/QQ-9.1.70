package com.qzone.publish.business.protocol;

import FileUpload.MultiPicInfo;
import FileUpload.PicExtendInfo;
import FileUpload.stPoi;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.UploadFileResponse;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.publish.business.model.a;
import com.qzone.publish.business.publishqueue.QZonePreUploadInfo;
import com.qzone.publish.business.task.QZoneUploadPicTask;
import com.qzone.publish.business.task.intimate.QZoneImageUploadTask;
import com.qzone.util.image.b;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import com.tencent.upload.uinterface.data.ImageUploadResult;
import com.tencent.upload.uinterface.data.ImageUploadTask;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes39.dex */
public class QZoneUploadPicRequest extends QzoneUploadRequest {
    public static final int BLOG_SRC = 14302;
    public static final int SHUOSHUO_SRC = 14303;
    private static final String TAG = "[upload2_QZoneUploadPicRequest]";
    public static final int TARGET_BLOG = 1;
    public static final int TARGET_CHECKIN = 3;
    public static final int TARGET_SHUOSHUO = 4;
    public static final int TARGET_UPLOAD_PHOTO = 0;
    public static final int TARGET_UPLOAD_VIDEO_PIC = 5;
    public static final int UPLOAD_PHOTO_SRC = 14301;
    private String aAlbumsId;
    private String aPhotoFilePath;
    private String aPhotoName;
    private boolean autoRotate;
    private long batchId;
    private String clientFakeKey;
    private int curNum;
    private Map<String, String> extend_info;
    private int flowId;
    private HashMap<String, byte[]> mExternalByteData;
    private long mLastModifyTime;
    private Map<String, String> mPhotoTagExtendInfo;
    private stPoi mPoiInfo;
    private long mStartTime;
    public ImageUploadTask mTaskAdapter;
    IUploadTaskCallback mUploadTaskCallback;
    private long mUploadTime;
    private int maxNum;
    private a.C0436a mediaReportInfo;
    private boolean mixVideo;
    private boolean needWaterMark;
    private String open_appid;
    private int panoramaType;
    private String photoDescription;
    private int picQuality;
    private QZonePreUploadInfo preInfo;
    private String realFileName;
    private Map<String, String> shootParams;
    private int target;
    private int uploadEntrance;
    private byte[] vdata;

    /* loaded from: classes39.dex */
    class a implements IUploadTaskCallback {
        a() {
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadError(AbstractUploadTask abstractUploadTask, int i3, String str) {
            QZLog.i(QZoneUploadPicRequest.TAG, 1, QZoneUploadPicRequest.this.getRequestDesc() + ", onUploadError flowId:" + abstractUploadTask.flowId + ", {" + QZoneUploadPicRequest.this.realFileName + "} retCode:" + i3 + " msg:" + str);
            if (str == null) {
                str = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadFail", "\u4e0a\u4f20\u5931\u8d25");
            }
            QZoneUploadPicRequest.this.sendResponse(i3, null, str);
            if (((QZoneRequest) QZoneUploadPicRequest.this).mUploadQueueListener != null) {
                ((QZoneRequest) QZoneUploadPicRequest.this).mUploadQueueListener.onUploadError(abstractUploadTask, i3, str);
            }
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadProgress(AbstractUploadTask abstractUploadTask, long j3, long j16) {
            if (((QZoneRequest) QZoneUploadPicRequest.this).mUploadQueueListener != null) {
                ((QZoneRequest) QZoneUploadPicRequest.this).mUploadQueueListener.onUpdateDataSize(j16 / 1024, j3 / 1024);
                if (((QZoneRequest) QZoneUploadPicRequest.this).mUploadQueueListener.getState() != 1) {
                    ((QZoneRequest) QZoneUploadPicRequest.this).mUploadQueueListener.onStateChanged(1);
                    ((QZoneRequest) QZoneUploadPicRequest.this).mUploadQueueListener.setTime(System.currentTimeMillis());
                }
                ((QZoneRequest) QZoneUploadPicRequest.this).mUploadQueueListener.resetTime();
            }
            if (-1 == QZoneUploadPicRequest.this.mStartTime) {
                QZoneUploadPicRequest.this.mStartTime = System.currentTimeMillis();
            }
            QZLog.d(QZoneUploadPicRequest.TAG, 1, QZoneUploadPicRequest.this.getRequestDesc() + ", onUploadProgress flowId:" + abstractUploadTask.flowId + ", {" + QZoneUploadPicRequest.this.realFileName + "} recvDataSize : " + j16 + " totalSize : " + j3);
            if (j16 != j3 || j3 == 0) {
                return;
            }
            QZLog.i(QZoneUploadPicRequest.TAG, 1, QZoneUploadPicRequest.this.getRequestDesc() + ", onUploadProgress upload file flowId:" + abstractUploadTask.flowId + ", {" + QZoneUploadPicRequest.this.realFileName + "} succeed use time : " + (((float) (System.currentTimeMillis() - QZoneUploadPicRequest.this.mStartTime)) / 1000.0f) + ReportConstant.COSTREPORT_PREFIX);
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadStateChange(AbstractUploadTask abstractUploadTask, int i3) {
            QZLog.i(QZoneUploadPicRequest.TAG, 1, QZoneUploadPicRequest.this.getRequestDesc() + ", onUploadStateChange flowId:" + abstractUploadTask.flowId + ", {" + QZoneUploadPicRequest.this.realFileName + "} state:" + i3);
            if (((QZoneRequest) QZoneUploadPicRequest.this).mUploadQueueListener == null || ((QZoneRequest) QZoneUploadPicRequest.this).mUploadQueueListener.getState() == i3) {
                return;
            }
            ((QZoneRequest) QZoneUploadPicRequest.this).mUploadQueueListener.onStateChanged(i3);
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadSucceed(AbstractUploadTask abstractUploadTask, Object obj) {
            QZLog.i(QZoneUploadPicRequest.TAG, 1, QZoneUploadPicRequest.this.getRequestDesc() + ", onUploadSucceed flowId: " + abstractUploadTask.flowId + ", {" + QZoneUploadPicRequest.this.realFileName + "}");
            if ((abstractUploadTask instanceof ImageUploadTask) && QZoneUploadPicRequest.this.mediaReportInfo != null) {
                ImageUploadTask imageUploadTask = (ImageUploadTask) abstractUploadTask;
                QZoneUploadPicRequest.this.mediaReportInfo.f51030e = imageUploadTask.compressStartTime;
                QZoneUploadPicRequest.this.mediaReportInfo.f51031f = imageUploadTask.compressEndTime;
                if (((QZoneRequest) QZoneUploadPicRequest.this).mUploadQueueListener != null && (((QZoneRequest) QZoneUploadPicRequest.this).mUploadQueueListener instanceof QZoneUploadPicTask)) {
                    ((QZoneUploadPicTask) ((QZoneRequest) QZoneUploadPicRequest.this).mUploadQueueListener).addReportInfo(QZoneUploadPicRequest.this.mediaReportInfo);
                }
            }
            ImageUploadResult imageUploadResult = (ImageUploadResult) obj;
            UploadFileResponse uploadFileResponse = new UploadFileResponse();
            uploadFileResponse.albumId = imageUploadResult.sAlbumID;
            uploadFileResponse.height = imageUploadResult.iHeight;
            uploadFileResponse.width = imageUploadResult.iWidth;
            uploadFileResponse.photoId = imageUploadResult.sPhotoID;
            uploadFileResponse.slocId = imageUploadResult.sSloc;
            uploadFileResponse.url = imageUploadResult.sBURL;
            uploadFileResponse.uploadTime = QZoneUploadPicRequest.this.mUploadTime;
            uploadFileResponse.originUploadUrl = QZoneUploadPicRequest.this.aPhotoFilePath;
            uploadFileResponse.clientFakeKey = LoginData.getInstance().getUin() + "_" + QZoneUploadPicRequest.this.mUploadTime + "_" + QZoneUploadPicRequest.this.clientFakeKey;
            QZoneUploadPicRequest.this.sendResponse(0, uploadFileResponse, "");
            imageUploadResult.imageFilePath = QZoneUploadPicRequest.this.aPhotoFilePath;
            if (((QZoneRequest) QZoneUploadPicRequest.this).mUploadQueueListener != null) {
                ((QZoneRequest) QZoneUploadPicRequest.this).mUploadQueueListener.onUploadSucceed(imageUploadResult);
            }
        }
    }

    public QZoneUploadPicRequest() {
        this.mStartTime = -1L;
        this.realFileName = "";
        this.autoRotate = false;
        this.open_appid = "";
        this.mUploadTaskCallback = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getRequestDesc() {
        return "batchId:" + this.batchId + ", fakeKey:" + this.clientFakeKey;
    }

    private void initTaskAdapter(byte[] bArr) {
        QZoneImageUploadTask qZoneImageUploadTask = new QZoneImageUploadTask(false, this.aPhotoFilePath, this.clientFakeKey);
        this.mTaskAdapter = qZoneImageUploadTask;
        int i3 = this.flowId;
        if (i3 != 0) {
            qZoneImageUploadTask.flowId = i3;
        } else {
            qZoneImageUploadTask.flowId = subFlowId((int) this.batchId, this.aPhotoFilePath);
        }
        QZLog.i(TAG, getRequestDesc() + ", create ImageUploadTask, path:" + this.aPhotoFilePath + ", flowId:" + qZoneImageUploadTask.flowId + ", uploadTime:" + this.mUploadTime);
        qZoneImageUploadTask.iUin = LoginData.getInstance().getUin();
        qZoneImageUploadTask.sRefer = "mqq";
        qZoneImageUploadTask.vLoginData = bArr;
        String str = this.aPhotoFilePath;
        qZoneImageUploadTask.uploadFilePath = str;
        qZoneImageUploadTask.md5 = createFileMD5(str);
        qZoneImageUploadTask.sPicTitle = "";
        qZoneImageUploadTask.vBusiNessData = this.vdata;
        qZoneImageUploadTask.sPicDesc = this.photoDescription;
        qZoneImageUploadTask.sAlbumName = "";
        qZoneImageUploadTask.iBitmap = 0;
        qZoneImageUploadTask.iUploadType = this.picQuality;
        qZoneImageUploadTask.iUpPicType = this.maxNum > 0 ? 1 : 0;
        qZoneImageUploadTask.iBatchID = this.batchId;
        qZoneImageUploadTask.iUploadTime = this.mUploadTime;
        QZonePreUploadInfo qZonePreUploadInfo = this.preInfo;
        if (qZonePreUploadInfo != null) {
            qZoneImageUploadTask.preupload = qZonePreUploadInfo.preUploadType;
        } else {
            qZoneImageUploadTask.preupload = 0;
        }
        if (qZonePreUploadInfo != null && qZonePreUploadInfo.isPreUploaded(this.aPhotoFilePath)) {
            qZoneImageUploadTask.preupload = 2;
        }
        setTargetParams(qZoneImageUploadTask);
        MultiPicInfo multiPicInfo = new MultiPicInfo();
        multiPicInfo.iBatUploadNum = this.maxNum;
        multiPicInfo.iCurUpload = this.curNum;
        qZoneImageUploadTask.mutliPicInfo = multiPicInfo;
        setExtendInfo(qZoneImageUploadTask);
        qZoneImageUploadTask.bWaterType = this.needWaterMark;
        qZoneImageUploadTask.uploadPoi = this.mPoiInfo;
        qZoneImageUploadTask.clientFakeKey = this.clientFakeKey;
        qZoneImageUploadTask.autoRotate = this.autoRotate;
        qZoneImageUploadTask.uploadEntrance = this.uploadEntrance;
        qZoneImageUploadTask.uploadTaskCallback = this.mUploadTaskCallback;
        qZoneImageUploadTask.mExternalByteData = this.mExternalByteData;
        setUploadEntrance(qZoneImageUploadTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendResponse(int i3, UploadFileResponse uploadFileResponse, String str) {
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
        this.mListner.onProtocolResponse(uniAttribute, i3, (i3 == -2000 && str.contains("-207")) ? -207 : i3, str, false);
    }

    private void setExtendInfo(ImageUploadTask imageUploadTask) {
        if (imageUploadTask.stExtendInfo == null) {
            imageUploadTask.stExtendInfo = new PicExtendInfo();
        }
        try {
            if (!JpegExifReader.isCrashJpeg(this.mTaskAdapter.uploadFilePath)) {
                b bVar = new b(this.mTaskAdapter.uploadFilePath);
                imageUploadTask.stExtendInfo.mapExif = com.qzone.util.image.a.b(bVar);
                imageUploadTask.exifTime = appendShootTime(bVar, this.mLastModifyTime);
            }
        } catch (Exception e16) {
            QZLog.w(e16);
        }
        imageUploadTask.stExtendInfo.mapParams = new HashMap();
        if (this.mixVideo && imageUploadTask.stExternalMapExt == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            imageUploadTask.stExternalMapExt = hashMap;
            hashMap.put(FSUploadConst.KEY_MIX_FEED, "1");
        }
        if (imageUploadTask.stExternalMapExt == null) {
            imageUploadTask.stExternalMapExt = new HashMap<>();
        }
        HashMap<String, String> panoramaType = setPanoramaType(imageUploadTask.stExternalMapExt);
        imageUploadTask.stExternalMapExt = panoramaType;
        if (this.extend_info != null) {
            if (panoramaType == null) {
                imageUploadTask.stExternalMapExt = new HashMap<>();
            }
            imageUploadTask.stExternalMapExt.putAll(this.extend_info);
        }
        if (this.mPhotoTagExtendInfo != null) {
            if (imageUploadTask.stExternalMapExt == null) {
                imageUploadTask.stExternalMapExt = new HashMap<>();
            }
            imageUploadTask.stExternalMapExt.putAll(this.mPhotoTagExtendInfo);
        }
        Map<String, String> map = this.shootParams;
        if (map != null && map.get("targetShootIndex") != null) {
            if (Integer.parseInt(this.shootParams.get("targetShootIndex")) == this.curNum) {
                appendPhotoShootParams(imageUploadTask, this.shootParams);
            } else {
                appendPhotoShootParamsByExif(imageUploadTask);
            }
        } else {
            appendPhotoShootParamsByExif(imageUploadTask);
        }
        if (!TextUtils.isEmpty(this.open_appid)) {
            imageUploadTask.stExtendInfo.mapParams.put("open_appid", this.open_appid);
        }
        if (this.mPoiInfo != null) {
            imageUploadTask.stExtendInfo.mapParams.put("show_geo", "" + this.mPoiInfo.show_poi);
            if (QZLog.isDevelopLevel()) {
                QZLog.d(TAG, 4, " mPoiInfo.show_poi:" + this.mPoiInfo.show_poi + " show_geo:" + imageUploadTask.stExtendInfo.mapParams.get("show_geo"));
                return;
            }
            return;
        }
        imageUploadTask.stExtendInfo.mapParams.put("show_geo", "0");
        if (QZLog.isDevelopLevel()) {
            QZLog.d(TAG, 4, " show_geo:0");
        }
    }

    private void setTargetParams(ImageUploadTask imageUploadTask) {
        int i3 = this.target;
        if (i3 != 4 && i3 != 1 && i3 != 3) {
            imageUploadTask.iSync = 1;
            if (TextUtils.isEmpty(this.aAlbumsId)) {
                imageUploadTask.iAlbumTypeID = 1;
            } else {
                imageUploadTask.iAlbumTypeID = 0;
                imageUploadTask.sAlbumID = this.aAlbumsId;
            }
        } else {
            imageUploadTask.iSync = 0;
            imageUploadTask.sAlbumID = "";
            imageUploadTask.iAlbumTypeID = 7;
        }
        int i16 = this.target;
        if (i16 == 0) {
            imageUploadTask.iDistinctUse = UPLOAD_PHOTO_SRC;
            return;
        }
        if (i16 == 1) {
            imageUploadTask.iDistinctUse = BLOG_SRC;
        } else if (i16 == 4 || i16 == 3) {
            imageUploadTask.iDistinctUse = SHUOSHUO_SRC;
        }
    }

    private void setUploadEntrance(ImageUploadTask imageUploadTask) {
        switch (this.uploadEntrance) {
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
                imageUploadTask.entry = "album";
                return;
            case 16:
            case 17:
            case 18:
            case 20:
            default:
                return;
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
                imageUploadTask.entry = AbstractUploadTask.ENTRY_TYPE_SHUOSHUO;
                return;
        }
    }

    @Override // com.qzone.publish.business.protocol.QzoneUploadRequest
    public boolean cancel() {
        QZoneUploadPicRequest qZoneUploadPicRequest;
        boolean cancel = this.mTaskAdapter != null ? UploadServiceBuilder.getInstance().cancel(this.mTaskAdapter) : false;
        QZonePreUploadInfo qZonePreUploadInfo = this.preInfo;
        return (qZonePreUploadInfo == null || (qZoneUploadPicRequest = qZonePreUploadInfo.preUploadingRequest) == null || qZoneUploadPicRequest.mTaskAdapter == null || !qZonePreUploadInfo.isNowPreLoading(this.aPhotoFilePath)) ? cancel : UploadServiceBuilder.getInstance().cancel(this.preInfo.preUploadingRequest.mTaskAdapter);
    }

    public String getFilePath() {
        return this.aPhotoFilePath;
    }

    @Override // com.qzone.publish.business.protocol.QzoneUploadRequest, y8.a
    public String getFlowMessage() {
        ImageUploadTask imageUploadTask = this.mTaskAdapter;
        if (imageUploadTask == null) {
            return "";
        }
        return imageUploadTask.getFlowMessage();
    }

    @Override // com.qzone.publish.business.protocol.QzoneUploadRequest, com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public boolean needReport() {
        return false;
    }

    public void setPhotoTagExtendInfo(Map<String, String> map) {
        this.mPhotoTagExtendInfo = map;
    }

    @Override // com.qzone.publish.business.protocol.QzoneUploadRequest, com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "null";
    }

    @Override // com.qzone.publish.business.protocol.QzoneUploadRequest
    public void upload(byte[] bArr) {
        initTaskAdapter(bArr);
        validAndUpload(this.mTaskAdapter);
    }

    public HashMap<String, String> setPanoramaType(HashMap<String, String> hashMap) {
        if (hashMap != null) {
            int i3 = this.panoramaType;
            if (i3 == 1) {
                hashMap.put("panorama_type", "1");
            } else if (i3 == 2) {
                hashMap.put("panorama_type", "2");
            } else if (i3 != 3) {
                hashMap.put("panorama_type", "0");
            } else {
                hashMap.put("panorama_type", "0");
            }
        }
        return hashMap;
    }

    public QZoneUploadPicRequest(int i3, int i16, int i17, String str, String str2, long j3, String str3, String str4, int i18, int i19, int i26, long j16, boolean z16, stPoi stpoi, long j17, String str5, int i27, QZonePreUploadInfo qZonePreUploadInfo, Map<String, String> map, String str6, Map<String, byte[]> map2, Map<String, String> map3, boolean z17, HashMap<String, byte[]> hashMap) {
        this(i3, i16, i17, str, str2, str3, str4, i18, i19, i26, j16, z16, stpoi, j17, str5, i27);
        this.preInfo = qZonePreUploadInfo;
        this.shootParams = map;
        this.open_appid = str6;
        this.mLastModifyTime = j3;
        this.extend_info = map3;
        this.mixVideo = z17;
        this.mExternalByteData = hashMap;
    }

    public QZoneUploadPicRequest(int i3, int i16, int i17, String str, String str2, String str3, String str4, int i18, int i19, int i26, long j3, boolean z16, stPoi stpoi, long j16, String str5, int i27) {
        super(null);
        this.mStartTime = -1L;
        this.realFileName = "";
        this.autoRotate = false;
        this.open_appid = "";
        this.mUploadTaskCallback = new a();
        this.target = i16;
        this.panoramaType = i17;
        this.realFileName = str;
        this.flowId = i3;
        this.aPhotoName = "";
        this.aPhotoFilePath = str2;
        this.aAlbumsId = str3;
        this.photoDescription = str4;
        this.picQuality = i18;
        this.maxNum = i19;
        this.curNum = i26;
        this.batchId = j3;
        this.needWaterMark = z16;
        this.autoRotate = i16 == 0 || i16 == 4 || i16 == 5;
        this.mPoiInfo = stpoi;
        this.mUploadTime = j16;
        this.clientFakeKey = str5;
        this.uploadEntrance = i27;
        this.mediaReportInfo = new a.C0436a(1, str2);
        File file = new File(str2);
        if (file.exists()) {
            this.mediaReportInfo.f51028c = file.length() / 1024;
        }
    }
}
