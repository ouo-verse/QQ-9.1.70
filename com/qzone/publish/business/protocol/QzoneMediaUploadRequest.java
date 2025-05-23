package com.qzone.publish.business.protocol;

import FileUpload.MultiPicInfo;
import FileUpload.PicExtendInfo;
import FileUpload.UploadPicInfoReq;
import FileUpload.UploadVideoInfoRsp;
import FileUpload.cnst.kExtKeyMarkUinBeforeUpload;
import FileUpload.stPoi;
import NS_MOBILE_OPERATION.LbsInfo;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.qq.jce.wup.UniAttribute;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceStruct;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.UploadFileResponse;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.business.model.UploadVideoObject;
import com.qzone.publish.business.model.a;
import com.qzone.publish.business.process.QZoneMediaDealWithManager;
import com.qzone.publish.business.process.base.QZoneProcessType;
import com.qzone.publish.business.process.base.a;
import com.qzone.publish.business.publishqueue.QZonePreUploadInfo;
import com.qzone.publish.business.task.compress.VideoCompressEngine;
import com.qzone.publish.business.task.compress.VideoCompressTask;
import com.qzone.publish.business.task.intimate.QZoneImageUploadTask;
import com.qzone.publish.business.task.upload.QZoneVideoUploadTask;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.util.ag;
import com.qzone.util.image.ImageInfo;
import com.qzone.util.l;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import com.tencent.upload.uinterface.data.ImageUploadResult;
import com.tencent.upload.uinterface.data.ImageUploadTask;
import com.tencent.upload.uinterface.data.VideoUploadResult;
import com.tencent.upload.uinterface.data.VideoUploadTask;
import common.config.service.QzoneConfig;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.GpsInfo4LocalImage;
import cooperation.qzone.util.FileUtils;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneMediaUploadRequest extends QzoneUploadRequest implements IUploadTaskCallback, VideoCompressTask.a {
    private static final int COMPRESS_STATE_FAILED = 1;
    private static final int COMPRESS_STATE_SUCCESS = 0;
    private static final int COMPRESS_STATE_TIMEOUT = 2;
    private static final String TAG = "[upload2_QzoneMediaUploadRequest]";
    protected boolean autoRotate;
    private long batchId;
    protected int batchMediaNum;
    protected String clientKey;
    private ArrayList<VideoCompressTask> compressTasks;
    protected c iUploadQunVideoCoverTask;
    protected volatile boolean mAborted;
    private HashMap<String, d> mCompressVideoList;
    private int mCurrentTaskState;
    private AbstractUploadTask mErrorTask;
    private final HashMap<String, d> mProcessVideoList;
    private final com.qzone.publish.business.protocol.a mQZoneMediaProcessStatusWrapper;
    private int mSuccessCompressCnt;
    private final a.InterfaceC0438a<ShuoshuoVideoInfo> mVideoProcessListener;
    protected List<MediaWrapper> mediaList;
    private b mediaUploadListener;
    protected LinkedHashMap<String, d> photoList;
    private int richPhotoNum;
    private volatile int successImageCnt;
    private int totalMediaNum;
    public com.qzone.publish.ui.model.a uploadParams;
    protected CopyOnWriteArrayList<AbstractUploadTask> uploadTasks;
    protected HashMap<String, UploadVideoObject> uploadVideoObjects;
    protected LinkedHashMap<String, d> videoList;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface b {
        void onMediaCompressFailed(String str, int i3, int i16, String str2);

        void onMediaCompressProgress(String str, int i3, double d16);

        void onMediaCompressSuccess(String str, String str2, int i3);

        void onMediaUploadFailed(int i3, int i16, String str);

        void onMediaUploadReport(a.C0436a c0436a);

        void onMediaUploadStart(int i3, String str, String str2);

        void onMediaUploadSuccess(JceStruct jceStruct, AbstractUploadTask abstractUploadTask, int i3, String str, String str2, String str3);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface c {
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        MediaWrapper f51070a;

        /* renamed from: b, reason: collision with root package name */
        int f51071b;

        /* renamed from: c, reason: collision with root package name */
        String f51072c;

        /* renamed from: d, reason: collision with root package name */
        String f51073d;

        /* renamed from: e, reason: collision with root package name */
        int f51074e;

        /* renamed from: f, reason: collision with root package name */
        JceStruct f51075f;

        /* renamed from: g, reason: collision with root package name */
        a.C0436a f51076g;
    }

    public QzoneMediaUploadRequest() {
        this.successImageCnt = 0;
        this.mSuccessCompressCnt = 0;
        this.mCurrentTaskState = 0;
        this.photoList = new LinkedHashMap<>();
        this.videoList = new LinkedHashMap<>();
        this.mCompressVideoList = new HashMap<>();
        this.uploadVideoObjects = new HashMap<>();
        this.uploadTasks = new CopyOnWriteArrayList<>();
        this.compressTasks = new ArrayList<>();
        this.mQZoneMediaProcessStatusWrapper = new com.qzone.publish.business.protocol.a();
        this.mProcessVideoList = new HashMap<>();
        this.mVideoProcessListener = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cancelAllTasks() {
        QZLog.i(TAG, getRequestDesc() + ", cancelAllTasks");
        this.mAborted = true;
        if (this.uploadTasks.size() > 0) {
            Iterator<AbstractUploadTask> it = this.uploadTasks.iterator();
            while (it.hasNext()) {
                AbstractUploadTask next = it.next();
                UploadServiceBuilder.getInstance().cancel(next);
                QZLog.i(TAG, 1, getRequestDesc() + ", cancel flowId:" + next.flowId);
            }
            this.uploadTasks.clear();
        }
        if (this.compressTasks.size() > 0) {
            Iterator<VideoCompressTask> it5 = this.compressTasks.iterator();
            while (it5.hasNext()) {
                it5.next().cancel();
            }
        }
        this.mQZoneMediaProcessStatusWrapper.h();
    }

    private void doUploadPhoto(byte[] bArr) {
        Collection<d> values = this.photoList.values();
        if (values == null || values.isEmpty()) {
            return;
        }
        for (d dVar : values) {
            if (this.mAborted) {
                QZLog.e(TAG, getRequestDesc() + ", doUploadPhoto aborted");
                return;
            }
            if (dVar != null) {
                ImageUploadTask createImageUploadTask = createImageUploadTask(dVar.f51070a.getImageInfo(), bArr, dVar.f51071b);
                if (createImageUploadTask != null) {
                    doUploadTask(createImageUploadTask, dVar.f51071b, dVar.f51073d);
                } else {
                    QZLog.e(TAG, getRequestDesc() + ", doUploadPhoto, createImageUploadTask error");
                }
            }
        }
    }

    private void fillExtendInfo2(AbstractUploadTask abstractUploadTask) {
        if (abstractUploadTask.mExtend_info == null) {
            abstractUploadTask.mExtend_info = new HashMap();
        }
        Map<String, String> map = this.uploadParams.G;
        if (map == null || map.size() <= 0) {
            return;
        }
        abstractUploadTask.mExtend_info.putAll(this.uploadParams.G);
    }

    private com.qzone.publish.business.process.base.a getQCircleProcess(ShuoshuoVideoInfo shuoshuoVideoInfo, a.InterfaceC0438a<ShuoshuoVideoInfo> interfaceC0438a) {
        if (!TextUtils.isEmpty(shuoshuoVideoInfo.mProcessMissionID)) {
            return QZoneMediaDealWithManager.o().l(shuoshuoVideoInfo, QZoneProcessType.PROCESS_TYPE_QCIRCLE_EXPORT, interfaceC0438a);
        }
        return QZoneMediaDealWithManager.o().l(shuoshuoVideoInfo, QZoneProcessType.PROCESS_TYPE_QCIRCLE_COMPRESS, interfaceC0438a);
    }

    private d getVideoUploadMediaInfo(VideoUploadTask videoUploadTask) {
        d dVar = this.videoList.get(videoUploadTask.uploadFilePath);
        if (dVar == null) {
            dVar = this.mCompressVideoList.get(videoUploadTask.uploadFilePath);
        }
        return dVar == null ? this.mProcessVideoList.get(videoUploadTask.uploadFilePath) : dVar;
    }

    private boolean isNeedReplaceGpsInfo() {
        Map<String, String> map = this.uploadParams.E;
        if (map == null || map.get("targetShootIndex") == null) {
            return false;
        }
        int parseInt = Integer.parseInt(this.uploadParams.E.get("targetShootIndex"));
        int i3 = this.uploadParams.f51922v;
        return i3 != -1 && parseInt == i3;
    }

    private void resetConvertTaskOriginPath(AbstractUploadTask abstractUploadTask) {
        String c16 = a9.a.f25720a.c(abstractUploadTask.uploadFilePath);
        QLog.w("QZPublishX_[upload2_QzoneMediaUploadRequest]", 1, "resetConvertTaskOriginPath  | uploadFilePath:" + abstractUploadTask.uploadFilePath + " | originPath:" + c16);
        if (TextUtils.isEmpty(c16)) {
            return;
        }
        abstractUploadTask.uploadFilePath = c16;
        abstractUploadTask.mOriginFilePath = c16;
    }

    private void sendResponse(int i3, String str, JceStruct jceStruct) {
        sendResponse(QZoneProcessType.PROCESS_UNKNOW, i3, str, jceStruct);
    }

    private void setInfoByOldCompress(com.qzone.publish.business.task.c cVar) {
        MediaWrapper mediaWrapper;
        String format;
        VideoCompressTask d16 = VideoCompressEngine.e().d();
        if (d16 != null) {
            String a16 = l.a(R.string.rze);
            d dVar = this.videoList.get(d16.mVideoSourcePath);
            if (dVar != null ? dVar.f51070a.isVideo2Gif() : false) {
                a16 = l.a(R.string.rz_);
            }
            if (d16.isVideoHandling()) {
                double progress = d16.getProgress();
                if (progress == 0.0d) {
                    format = "0.00";
                } else {
                    double exp = ((1.0d / (Math.exp(-progress) + 1.0d)) - 0.5d) * 200.0d;
                    Object[] objArr = new Object[1];
                    objArr[0] = Double.valueOf(Double.isNaN(exp) ? 0.0d : exp);
                    format = String.format("%.2f", objArr);
                }
                if (this.videoList.size() > 1) {
                    cVar.f51186b = l.a(R.string.rza) + (this.mSuccessCompressCnt + 1) + l.a(R.string.rz6) + a16 + l.a(R.string.rzf) + format + "%";
                } else {
                    cVar.f51186b = a16 + l.a(R.string.rz8) + format + "%";
                }
                cVar.f51191g = false;
                cVar.f51190f = 0;
            } else {
                int i3 = this.mCurrentTaskState;
                if (i3 == 0) {
                    cVar.f51186b = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadWait", "\u7b49\u5f85\u4e0a\u4f20");
                    cVar.f51190f = 0;
                } else if (i3 == 1) {
                    if (this.videoList.size() > 1) {
                        cVar.f51186b = l.a(R.string.rz7) + (this.mSuccessCompressCnt + 1) + l.a(R.string.rzb) + a16 + l.a(R.string.rzg);
                    } else {
                        cVar.f51186b = a16 + l.a(R.string.rzd);
                    }
                }
            }
            String str = d16.mVideoSourcePath;
            if ((TextUtils.isEmpty(str) || !new File(str).exists() || new File(str).isDirectory()) && dVar != null && (mediaWrapper = dVar.f51070a) != null && mediaWrapper.getVideoInfo() != null) {
                str = dVar.f51070a.getVideoInfo().mCoverUrl;
            }
            cVar.f51192h = str;
            cVar.f51193i = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] buildVideoTaskExtra(int i3, int i16, long j3, UploadVideoObject uploadVideoObject) {
        UploadPicInfoReq uploadPicInfoReq = new UploadPicInfoReq();
        uploadPicInfoReq.iBatchID = this.uploadParams.f51903c;
        MultiPicInfo multiPicInfo = new MultiPicInfo();
        uploadPicInfoReq.mutliPicInfo = multiPicInfo;
        multiPicInfo.iBatUploadNum = i3;
        multiPicInfo.iCurUpload = i16;
        if (uploadPicInfoReq.stExtendInfo == null) {
            PicExtendInfo picExtendInfo = new PicExtendInfo();
            uploadPicInfoReq.stExtendInfo = picExtendInfo;
            picExtendInfo.mapParams = new HashMap();
        }
        PicExtendInfo picExtendInfo2 = uploadPicInfoReq.stExtendInfo;
        if (picExtendInfo2 != null && picExtendInfo2.mapParams != null && !TextUtils.isEmpty(this.clientKey)) {
            uploadPicInfoReq.stExtendInfo.mapParams.put(v4.b.CLIENTKEY, this.clientKey);
        }
        if (uploadPicInfoReq.stExternalMapExt == null) {
            uploadPicInfoReq.stExternalMapExt = new HashMap();
        }
        if (this.uploadParams.f51920t) {
            uploadPicInfoReq.stExternalMapExt.put(FSUploadConst.KEY_CLIENT_UPLOOAD_COVER, "1");
            uploadPicInfoReq.stExternalMapExt.put(FSUploadConst.KEY_MIX_FEED, "1");
        }
        if (uploadVideoObject != null) {
            uploadPicInfoReq.stExternalMapExt.put(FSUploadConst.KEY_MIX_VIDEO_SIZE, uploadVideoObject.getSize() + "");
            uploadPicInfoReq.stExternalMapExt.put(FSUploadConst.KEY_MIX_ORIGIN_VIDEO, uploadVideoObject.getIsUploadOrigin() + "");
            uploadPicInfoReq.stExternalMapExt.put(FSUploadConst.KEY_MIX_TIME, uploadVideoObject.getDuration() + "");
        }
        PicExtendInfo picExtendInfo3 = uploadPicInfoReq.stExtendInfo;
        Map<String, String> map = picExtendInfo3 == null ? null : picExtendInfo3.mapExif;
        if (map != null) {
            String str = map.get(UploadConfiguration.getExifTagCode("Make"));
            if (str == null) {
                str = "";
            }
            uploadPicInfoReq.sExif_CameraMaker = str;
            String str2 = map.get(UploadConfiguration.getExifTagCode("Model"));
            if (str2 == null) {
                str2 = "";
            }
            uploadPicInfoReq.sExif_CameraModel = str2;
            String str3 = map.get(UploadConfiguration.getExifTagCode("GPSLatitude"));
            if (str3 == null) {
                str3 = "";
            }
            uploadPicInfoReq.sExif_Latitude = str3;
            String str4 = map.get(UploadConfiguration.getExifTagCode("GPSLatitudeRef"));
            if (str4 == null) {
                str4 = "";
            }
            uploadPicInfoReq.sExif_LatitudeRef = str4;
            String str5 = map.get(UploadConfiguration.getExifTagCode("GPSLongitude"));
            if (str5 == null) {
                str5 = "";
            }
            uploadPicInfoReq.sExif_Longitude = str5;
            String str6 = map.get(UploadConfiguration.getExifTagCode("GPSLongitudeRef"));
            if (str6 == null) {
                str6 = "";
            }
            uploadPicInfoReq.sExif_LongitudeRef = str6;
        }
        uploadPicInfoReq.iUploadTime = j3;
        HashMap hashMap = (HashMap) uploadPicInfoReq.mapExt;
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        String str7 = this.uploadParams.f51904d;
        hashMap.put(FSUploadConst.KEY_FAKEFEED_CLIENTKEY, str7 != null ? str7 : "");
        PicExtendInfo picExtendInfo4 = uploadPicInfoReq.stExtendInfo;
        if (picExtendInfo4 != null && picExtendInfo4.mapParams == null) {
            picExtendInfo4.mapParams = new HashMap();
        }
        if (!TextUtils.isEmpty(this.uploadParams.f51902b)) {
            hashMap.put("refer", this.uploadParams.f51902b);
        }
        uploadPicInfoReq.mapExt = hashMap;
        com.qzone.publish.ui.model.a aVar = this.uploadParams;
        int i17 = aVar.f51912l;
        uploadPicInfoReq.iBusiNessType = i17;
        if (i17 == 1) {
            byte[] bArr = aVar.f51913m;
            if (bArr == null) {
                bArr = new byte[0];
            }
            uploadPicInfoReq.vBusiNessData = bArr;
        } else {
            uploadPicInfoReq.vBusiNessData = new byte[0];
        }
        try {
            return pack("UploadPicInfoReq", uploadPicInfoReq);
        } catch (Exception e16) {
            QZLog.e(TAG, e16.toString());
            return null;
        }
    }

    @Override // com.qzone.publish.business.protocol.QzoneUploadRequest
    public boolean cancel() {
        cancelAllTasks();
        return true;
    }

    protected void completeRequest(int i3, String str) {
        completeRequest(QZoneProcessType.PROCESS_UNKNOW, i3, str);
    }

    protected ImageUploadTask createImageUploadTask(ImageInfo imageInfo, byte[] bArr, int i3, boolean z16, String str) {
        if (this.mAborted) {
            QZLog.e(TAG, getRequestDesc() + ", createImageUploadTask after aborted, return null!");
            return null;
        }
        if (imageInfo == null) {
            QZLog.e(TAG, getRequestDesc() + ", createImageUploadTask with null imageInfo, return null!");
            return null;
        }
        long j3 = this.uploadParams.f51906f - i3;
        String str2 = imageInfo.mPath;
        String a16 = a9.a.f25720a.a(str2);
        if (!TextUtils.isEmpty(a16)) {
            str2 = a16;
        }
        QZoneImageUploadTask qZoneImageUploadTask = new QZoneImageUploadTask(false, str2, this.clientKey + "_" + j3);
        qZoneImageUploadTask.uploadTaskCallback = this;
        qZoneImageUploadTask.iUin = LoginData.getInstance().getUin();
        qZoneImageUploadTask.sRefer = "mqq";
        qZoneImageUploadTask.vLoginData = bArr;
        qZoneImageUploadTask.md5 = createFileMD5(str2);
        qZoneImageUploadTask.sAlbumName = "";
        qZoneImageUploadTask.flowId = subFlowId((int) this.uploadParams.f51903c, str2);
        com.qzone.publish.ui.model.a aVar = this.uploadParams;
        qZoneImageUploadTask.uploadEntrance = aVar.f51905e;
        qZoneImageUploadTask.sPicTitle = "";
        qZoneImageUploadTask.sPicDesc = aVar.f51909i;
        qZoneImageUploadTask.bWaterType = aVar.f51910j;
        qZoneImageUploadTask.autoRotate = this.autoRotate;
        qZoneImageUploadTask.clientFakeKey = aVar.f51904d;
        qZoneImageUploadTask.uploadPoi = aVar.f51923w;
        int i16 = aVar.f51912l;
        qZoneImageUploadTask.iBusiNessType = i16;
        if (i16 == 1) {
            qZoneImageUploadTask.vBusiNessData = aVar.f51913m;
        }
        MultiPicInfo multiPicInfo = new MultiPicInfo();
        com.qzone.publish.ui.model.a aVar2 = this.uploadParams;
        int i17 = aVar2.f51921u;
        if (i17 <= 0) {
            i17 = this.batchMediaNum;
        }
        multiPicInfo.iBatUploadNum = i17;
        int i18 = aVar2.f51922v;
        if (i18 < 0) {
            i18 = i3;
        }
        multiPicInfo.iCurUpload = i18;
        qZoneImageUploadTask.mutliPicInfo = multiPicInfo;
        qZoneImageUploadTask.iUploadTime = j3;
        qZoneImageUploadTask.iUploadType = aVar2.f51908h;
        qZoneImageUploadTask.iBatchID = aVar2.f51903c;
        qZoneImageUploadTask.iUpPicType = this.batchMediaNum > 0 ? 1 : 0;
        if (!TextUtils.isEmpty(aVar2.M)) {
            qZoneImageUploadTask.setInnerAppid(this.uploadParams.M);
        }
        setTargetParams(qZoneImageUploadTask, this.uploadParams.f51901a);
        setExtendInfoParams(qZoneImageUploadTask, this.uploadParams, imageInfo, z16, str);
        setPreUploadParams(qZoneImageUploadTask, this.uploadParams);
        setUploadEntranceParams(qZoneImageUploadTask, this.uploadParams.f51905e);
        QZLog.i(TAG, getRequestDesc() + ", createImageUploadTask finish, picPath:" + qZoneImageUploadTask.uploadFilePath + ", flowId:" + qZoneImageUploadTask.flowId + ", index: " + i3 + ", iUploadTime:" + qZoneImageUploadTask.iUploadTime + ",uploadAppId:" + qZoneImageUploadTask.getProtocolAppid());
        fillExtendInfo2(qZoneImageUploadTask);
        return qZoneImageUploadTask;
    }

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
        if (!TextUtils.isEmpty(str) && !com.qzone.publish.utils.c.e(str)) {
            createFromShuoshuoVideoInfo.mOriganlVideoPath = str;
        }
        this.uploadVideoObjects.put(createFromShuoshuoVideoInfo.getFilePath(), createFromShuoshuoVideoInfo);
        long j3 = this.uploadParams.f51906f - i3;
        QZoneVideoUploadTask qZoneVideoUploadTask = new QZoneVideoUploadTask(createFromShuoshuoVideoInfo.getFilePath(), this.uploadParams.f51904d + "_" + j3);
        int i16 = this.uploadParams.f51911k;
        if (i16 <= 0) {
            i16 = createFromShuoshuoVideoInfo.getIsNew();
        }
        qZoneVideoUploadTask.iIsNew = i16;
        qZoneVideoUploadTask.flowId = subFlowId(this.uploadParams.f51904d, createFromShuoshuoVideoInfo.getFilePath());
        qZoneVideoUploadTask.iUin = LoginData.getInstance().getUin();
        qZoneVideoUploadTask.sRefer = "mqq";
        qZoneVideoUploadTask.vLoginData = bArr;
        qZoneVideoUploadTask.md5 = createFromShuoshuoVideoInfo.getFileMd5();
        qZoneVideoUploadTask.sTitle = createFromShuoshuoVideoInfo.getTitle();
        qZoneVideoUploadTask.sDesc = createFromShuoshuoVideoInfo.getDesc();
        qZoneVideoUploadTask.iFlag = createFromShuoshuoVideoInfo.getFlag();
        qZoneVideoUploadTask.sCoverUrl = createFromShuoshuoVideoInfo.getCoverUrl();
        qZoneVideoUploadTask.iPlayTime = (int) createFromShuoshuoVideoInfo.getDuration();
        qZoneVideoUploadTask.iUploadTime = j3;
        com.qzone.publish.ui.model.a aVar = this.uploadParams;
        qZoneVideoUploadTask.mClientKey = aVar.f51904d;
        qZoneVideoUploadTask.iBusiNessType = aVar.f51912l;
        if (aVar.f51915o) {
            buildVideoTaskExtra = aVar.f51913m;
        } else {
            buildVideoTaskExtra = buildVideoTaskExtra(this.batchMediaNum, i3, j3, createFromShuoshuoVideoInfo);
        }
        qZoneVideoUploadTask.vBusiNessData = buildVideoTaskExtra;
        qZoneVideoUploadTask.iIsOriginalVideo = createFromShuoshuoVideoInfo.getIsUploadOrigin();
        qZoneVideoUploadTask.iIsFormatF20 = createFromShuoshuoVideoInfo.getHasCompressed();
        com.qzone.publish.ui.model.a aVar2 = this.uploadParams;
        qZoneVideoUploadTask.uploadEntrance = aVar2.f51905e;
        qZoneVideoUploadTask.uploadTaskCallback = this;
        if (aVar2.L) {
            qZoneVideoUploadTask.setInnerAppid("qq_story_video");
            qZoneVideoUploadTask.iSync = 0;
        } else if (!TextUtils.isEmpty(aVar2.N)) {
            qZoneVideoUploadTask.setInnerAppid(this.uploadParams.N);
        }
        setWeishiTag(qZoneVideoUploadTask, shuoshuoVideoInfo);
        HashMap hashMap = new HashMap();
        qZoneVideoUploadTask.extend_info = hashMap;
        hashMap.put("video_type", UploadVideoObject.getVideoType(shuoshuoVideoInfo));
        qZoneVideoUploadTask.extend_info.put(FSUploadConst.KEY_VIDEO_FORMAT, UploadVideoObject.getVideoForMat(shuoshuoVideoInfo));
        setUploadEntranceParams(qZoneVideoUploadTask, this.uploadParams.f51905e);
        QZLog.i(TAG, getRequestDesc() + ", createVideoUploadTask finish. videoPath:" + qZoneVideoUploadTask.uploadFilePath + ", flowId:" + qZoneVideoUploadTask.flowId + ", index: " + i3 + ", iUploadTime:" + qZoneVideoUploadTask.iUploadTime);
        fillExtendInfo2(qZoneVideoUploadTask);
        return qZoneVideoUploadTask;
    }

    protected void doUploadTask(AbstractUploadTask abstractUploadTask, int i3, String str) {
        this.uploadTasks.add(abstractUploadTask);
        if (validAndUpload(abstractUploadTask)) {
            b bVar = this.mediaUploadListener;
            if (bVar != null) {
                bVar.onMediaUploadStart(i3, str, abstractUploadTask.uploadFilePath);
                return;
            }
            return;
        }
        QZLog.e(TAG, getRequestDesc() + ", validAndUpload fail, srcPath:" + str + ", flowId:" + abstractUploadTask.flowId);
    }

    protected void doUploadVideo(byte[] bArr) {
        MediaWrapper mediaWrapper;
        ShuoshuoVideoInfo videoInfo;
        Collection<d> values = this.videoList.values();
        if (values == null || values.isEmpty()) {
            return;
        }
        for (d dVar : values) {
            if (this.mAborted) {
                QZLog.e(TAG, getRequestDesc() + ", doUploadVideo aborted");
                return;
            }
            if (dVar != null && (mediaWrapper = dVar.f51070a) != null && (videoInfo = mediaWrapper.getVideoInfo()) != null) {
                dVar.f51072c = getVideoCover(videoInfo);
                if (dealWithByProcess(videoInfo, dVar, this.mVideoProcessListener)) {
                    continue;
                } else {
                    boolean z16 = false;
                    if ((videoInfo.mIsUploadOrigin && videoInfo.mDuration == videoInfo.mTotalDuration) || videoInfo.mTotalDuration >= QZoneHelper.getVideoCanCompressLimitMs()) {
                        videoInfo.mNeedProcess = false;
                    }
                    if (com.qzone.publish.utils.c.e(videoInfo.mVideoPath)) {
                        videoInfo.mNeedProcess = true;
                    }
                    if (!com.qzone.publish.utils.c.b(videoInfo.mVideoPath)) {
                        cancelAllTasks();
                        sendResponse(FSUploadConst.ERR_FILE_NOT_EXIST, r7.c.a(FSUploadConst.ERR_FILE_NOT_EXIST), null);
                        b bVar = this.mediaUploadListener;
                        if (bVar != null) {
                            bVar.onMediaCompressFailed(videoInfo.mVideoPath, dVar.f51071b, FSUploadConst.ERR_FILE_NOT_EXIST, "");
                            return;
                        }
                        return;
                    }
                    if (com.qzone.publish.utils.c.g(videoInfo)) {
                        if (videoInfo.mNeedProcess && videoInfo.mVideoType == 0 && com.qzone.publish.utils.c.e(videoInfo.mVideoPath)) {
                            z16 = true;
                        }
                        VideoCompressTask videoCompressTask = new VideoCompressTask(videoInfo, this.uploadParams.f51904d, this, com.qzone.publish.business.task.compress.a.a() ? true : z16);
                        if (dVar.f51070a.isVideo2Gif()) {
                            videoCompressTask.setIsVideoToGif(dVar.f51070a.isVideo2Gif());
                        }
                        videoCompressTask.setFromAIO(this.uploadParams.J);
                        videoCompressTask.setOriginalVideo(videoInfo.mIsUploadOrigin);
                        this.compressTasks.add(videoCompressTask);
                        VideoCompressEngine.e().c(videoCompressTask);
                    } else {
                        if (!com.qzone.publish.utils.c.f() && (com.qzone.publish.utils.c.e(videoInfo.mVideoPath) || !com.qzone.publish.utils.c.a(videoInfo))) {
                            cancelAllTasks();
                            String a16 = r7.c.a(FSUploadConst.ERR_COMPRESS_ENV_UNPREPAERD);
                            completeRequest(FSUploadConst.ERR_COMPRESS_ENV_UNPREPAERD, a16);
                            b bVar2 = this.mediaUploadListener;
                            if (bVar2 != null) {
                                bVar2.onMediaCompressFailed(videoInfo.mVideoPath, dVar.f51071b, FSUploadConst.ERR_COMPRESS_ENV_UNPREPAERD, a16);
                            }
                            QZLog.e(TAG, getRequestDesc() + ", upload video which must compress, but check video compress env failed.");
                            return;
                        }
                        if (videoInfo.mNeedProcess) {
                            QZLog.i(TAG, getRequestDesc() + ", video[" + videoInfo.mVideoPath + "] need compress but env check failed, upload directly");
                            videoInfo.mNeedProcess = false;
                        }
                        AbstractUploadTask createVideoUploadTask = createVideoUploadTask(videoInfo, bArr, dVar.f51071b);
                        if (createVideoUploadTask != null) {
                            doUploadTask(createVideoUploadTask, dVar.f51071b, dVar.f51073d);
                        } else {
                            QZLog.e(TAG, getRequestDesc() + ", doUploadVideo, createVideoUploadTask error");
                        }
                    }
                }
            }
        }
    }

    @Override // com.qzone.publish.business.protocol.QzoneUploadRequest, y8.a
    public String getFlowMessage() {
        AbstractUploadTask abstractUploadTask = this.mErrorTask;
        if (abstractUploadTask == null) {
            return "";
        }
        return abstractUploadTask.getFlowMessage();
    }

    public com.qzone.publish.business.task.c getInfo(com.qzone.publish.business.task.c cVar) {
        if (this.mAborted) {
            return cVar;
        }
        com.qzone.publish.business.process.base.a i3 = this.mQZoneMediaProcessStatusWrapper.i();
        if (i3 != null) {
            int j3 = this.mQZoneMediaProcessStatusWrapper.j();
            float l3 = i3.l();
            if (l3 > 100.0f) {
                l3 = 100.0f;
            }
            Object[] objArr = new Object[1];
            double d16 = l3;
            if (Double.isNaN(d16)) {
                d16 = 0.0d;
            }
            objArr[0] = Double.valueOf(d16);
            String format = String.format("%.2f", objArr);
            String a16 = l.a(R.string.rze);
            if (this.videoList.size() > 1) {
                cVar.f51186b = l.a(R.string.rza) + (j3 + 1) + l.a(R.string.rz6) + a16 + l.a(R.string.rzf) + format + "%";
            } else {
                cVar.f51186b = a16 + l.a(R.string.rz8) + format + "%";
            }
            cVar.f51191g = false;
            cVar.f51190f = 0;
        } else {
            setInfoByOldCompress(cVar);
        }
        setPreViewIconInfo(cVar);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getRequestDesc() {
        return "batchId:" + this.batchId + ", fakeKey:" + this.clientKey;
    }

    public boolean needUploadMoodAsync() {
        com.qzone.publish.ui.model.a aVar = this.uploadParams;
        return aVar.L || aVar.f51912l == 2;
    }

    @Override // com.qzone.publish.business.task.compress.VideoCompressTask.a
    public void onCompressFailed(VideoCompressTask videoCompressTask, int i3) {
        this.compressTasks.remove(videoCompressTask);
        String str = videoCompressTask.mVideoSourcePath;
        d dVar = this.videoList.get(str);
        ShuoshuoVideoInfo videoInfo = videoCompressTask.getVideoInfo();
        if (!TextUtils.isEmpty(str) && new File(str).exists() && !str.equals(videoInfo.mVideoPath)) {
            videoInfo.mVideoPath = str;
        }
        if (!this.mAborted && com.qzone.publish.utils.c.a(videoInfo)) {
            QZLog.i(TAG, getRequestDesc() + ", onCompressFailed errorCode:" + i3 + ", videoPath:" + videoInfo.mVideoPath + ", upload video without compress");
            Intent intent = new Intent();
            intent.putExtra("video_source_path", videoInfo.mVideoPath);
            onCompressSuccess(videoCompressTask, intent);
            VideoCompressEngine.e().b(videoCompressTask);
            return;
        }
        QZLog.e(TAG, getRequestDesc() + ", onCompressFailed errorCode:" + i3 + ", videoPath:" + videoInfo.mVideoPath + ", do not upload");
        this.mCurrentTaskState = 1;
        cancelAllTasks();
        if (this.mUploadQueueListener.getState() != 2 || !videoCompressTask.isCanceled()) {
            sendResponse(i3, l.a(R.string.rz9) + (this.mSuccessCompressCnt + 1) + l.a(R.string.rzc), null);
        }
        b bVar = this.mediaUploadListener;
        if (bVar != null) {
            bVar.onMediaCompressFailed(str, dVar != null ? dVar.f51071b : -1, i3, "");
        }
    }

    @Override // com.qzone.publish.business.task.compress.VideoCompressTask.a
    public void onCompressSuccess(VideoCompressTask videoCompressTask, Intent intent) {
        if (this.mAborted) {
            return;
        }
        this.compressTasks.remove(videoCompressTask);
        this.mCurrentTaskState = 0;
        this.mSuccessCompressCnt++;
        String stringExtra = intent.getStringExtra("video_source_path");
        d dVar = this.videoList.get(stringExtra);
        if (dVar == null) {
            QZLog.i(TAG, getRequestDesc() + ", onCompressSuccess but get UploadMediaInfo fail path = " + dVar);
            return;
        }
        boolean isVideo2Gif = dVar.f51070a.isVideo2Gif();
        ShuoshuoVideoInfo videoInfo = videoCompressTask.getVideoInfo();
        this.mCompressVideoList.put(videoInfo.mVideoPath, dVar);
        QZLog.i(TAG, getRequestDesc() + ", onCompressSuccess srcPath:" + dVar.f51073d + ", destPath:" + videoInfo.mVideoPath);
        if (!isVideo2Gif && videoInfo.mStartTime > 0) {
            dVar.f51072c = ag.h(videoInfo.mVideoPath);
        }
        dVar.f51076g.f51031f = System.currentTimeMillis();
        File file = new File(videoInfo.mVideoPath);
        if (file.exists()) {
            dVar.f51076g.f51029d = file.length() / 1024;
        }
        b bVar = this.mediaUploadListener;
        if (bVar != null) {
            bVar.onMediaCompressSuccess(dVar.f51073d, videoInfo.mVideoPath, dVar.f51074e);
        }
        com.qzone.publish.business.publishqueue.c cVar = this.mUploadQueueListener;
        if (cVar == null || cVar.getState() != 1) {
            QZLog.w(TAG, getRequestDesc() + " don't in running state, upload paused");
        } else if (isVideo2Gif) {
            ImageInfo imageInfo = new ImageInfo(videoInfo.mVideoPath);
            if (!this.photoList.containsKey(imageInfo.mPath)) {
                MediaWrapper mediaWrapper = new MediaWrapper(imageInfo);
                d dVar2 = new d();
                dVar2.f51070a = mediaWrapper;
                dVar2.f51071b = dVar.f51071b;
                dVar2.f51074e = dVar.f51074e;
                dVar2.f51073d = dVar.f51073d;
                this.photoList.put(imageInfo.mPath, dVar2);
            }
            ImageUploadTask createImageUploadTask = createImageUploadTask(imageInfo, LoginData.getInstance().getA2Bytes(), dVar.f51071b);
            if (createImageUploadTask == null) {
                QZLog.e(TAG, getRequestDesc() + ", onCompressSuccess, createImageUploadTask[gif] error, return");
                return;
            }
            QZLog.i(TAG, getRequestDesc() + ", validAndUpload gif, path:" + createImageUploadTask.uploadFilePath + ", flowId:" + createImageUploadTask.flowId);
            doUploadTask(createImageUploadTask, dVar.f51071b, dVar.f51073d);
        } else {
            AbstractUploadTask createVideoUploadTask = createVideoUploadTask(videoInfo, LoginData.getInstance().getA2Bytes(), dVar.f51071b);
            if (createVideoUploadTask == null) {
                QZLog.e(TAG, getRequestDesc() + ", onCompressSuccess, createVideoUploadTask error, return");
                return;
            }
            QZLog.i(TAG, getRequestDesc() + ", validAndUpload, path:" + createVideoUploadTask.uploadFilePath + ", flowId:" + createVideoUploadTask.flowId);
            doUploadTask(createVideoUploadTask, dVar.f51071b, dVar.f51073d);
        }
        if (videoCompressTask.keepSourceFile && !TextUtils.isEmpty(stringExtra) && com.qzone.publish.utils.c.e(stringExtra)) {
            try {
                QZLog.i(TAG, getRequestDesc() + ", delete directory file, path:" + stringExtra);
                FileUtils.deleteFile(new File(stringExtra));
            } catch (Exception e16) {
                QZLog.w(e16);
            }
        }
    }

    @Override // com.tencent.upload.uinterface.IUploadTaskCallback
    public void onUploadError(AbstractUploadTask abstractUploadTask, int i3, String str) {
        d videoUploadMediaInfo;
        this.mErrorTask = abstractUploadTask;
        this.uploadTasks.remove(abstractUploadTask);
        if (str == null) {
            str = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadFail", "\u4e0a\u4f20\u5931\u8d25");
        }
        QZLog.e(TAG, getRequestDesc() + ", onUploadError path:" + abstractUploadTask.uploadFilePath + ", flowId:" + abstractUploadTask.flowId + " errorCode:" + i3 + ", errorMsg:" + str + ", sessionId: " + abstractUploadTask.getSessionId());
        resetConvertTaskOriginPath(abstractUploadTask);
        cancelAllTasks();
        com.qzone.publish.business.publishqueue.c cVar = this.mUploadQueueListener;
        if (cVar != null) {
            cVar.onUploadError(abstractUploadTask, i3, str);
        }
        if (this.mediaUploadListener != null) {
            if (abstractUploadTask instanceof ImageUploadTask) {
                videoUploadMediaInfo = this.photoList.get(abstractUploadTask.uploadFilePath);
                if (videoUploadMediaInfo == null) {
                    ImageUploadTask imageUploadTask = (ImageUploadTask) abstractUploadTask;
                    if (imageUploadTask.isCover) {
                        videoUploadMediaInfo = this.videoList.get(imageUploadTask.srcVideoPath);
                    }
                }
            } else {
                videoUploadMediaInfo = abstractUploadTask instanceof VideoUploadTask ? getVideoUploadMediaInfo((VideoUploadTask) abstractUploadTask) : null;
            }
            this.mediaUploadListener.onMediaUploadFailed(videoUploadMediaInfo != null ? videoUploadMediaInfo.f51071b : -1, i3, str);
        }
        sendResponse(QZoneProcessType.PROCESS_TYPE_UPLOAD, i3, str, null);
    }

    @Override // com.tencent.upload.uinterface.IUploadTaskCallback
    public void onUploadProgress(AbstractUploadTask abstractUploadTask, long j3, long j16) {
        if (this.mAborted) {
            return;
        }
        QZLog.d(TAG, 1, getRequestDesc() + ", onUploadProgress totalSize:" + j3 + ", recvDataSize:" + j16 + ", sessionId: " + abstractUploadTask.getSessionId());
        com.qzone.publish.business.publishqueue.c cVar = this.mUploadQueueListener;
        if (cVar != null) {
            cVar.onUpdateDataSize(j16 / 1024, j3 / 1024);
            if (this.mUploadQueueListener.getState() != 1) {
                this.mUploadQueueListener.onStateChanged(1);
                this.mUploadQueueListener.setTime(System.currentTimeMillis());
            }
            this.mUploadQueueListener.resetTime();
        }
    }

    @Override // com.tencent.upload.uinterface.IUploadTaskCallback
    public void onUploadStateChange(AbstractUploadTask abstractUploadTask, int i3) {
        if (this.mAborted || i3 == 3) {
            return;
        }
        QZLog.i(TAG, getRequestDesc() + ", onUploadStateChange , sessionId: " + abstractUploadTask.getSessionId() + ", state: " + i3);
        com.qzone.publish.business.publishqueue.c cVar = this.mUploadQueueListener;
        if (cVar == null || cVar.getState() == i3) {
            return;
        }
        this.mUploadQueueListener.onStateChanged(i3);
    }

    @Override // com.tencent.upload.uinterface.IUploadTaskCallback
    public void onUploadSucceed(AbstractUploadTask abstractUploadTask, Object obj) {
        if (this.mAborted) {
            return;
        }
        QZLog.i(TAG, getRequestDesc() + ", onUploadSucceed, path:" + abstractUploadTask.uploadFilePath + ", flowId:" + abstractUploadTask.flowId + ", mCurNumImage:" + this.successImageCnt + ", sessionId: " + abstractUploadTask.getSessionId());
        this.uploadTasks.remove(abstractUploadTask);
        resetConvertTaskOriginPath(abstractUploadTask);
        if (abstractUploadTask instanceof ImageUploadTask) {
            doUploadPhotoSucceed((ImageUploadTask) abstractUploadTask, obj);
        } else if (abstractUploadTask instanceof VideoUploadTask) {
            doUploadVideoSucceed((VideoUploadTask) abstractUploadTask, obj);
        }
    }

    protected void setExtendInfoParams(ImageUploadTask imageUploadTask, com.qzone.publish.ui.model.a aVar, ImageInfo imageInfo, boolean z16, String str) {
        HashMap<String, String> hashMap;
        HashMap<String, byte[]> hashMap2;
        GpsInfo4LocalImage gpsInfo4LocalImage;
        if (imageUploadTask == null || aVar == null) {
            return;
        }
        if (imageUploadTask.stExtendInfo == null) {
            imageUploadTask.stExtendInfo = new PicExtendInfo();
        }
        PicExtendInfo picExtendInfo = imageUploadTask.stExtendInfo;
        if (picExtendInfo.mapParams == null) {
            picExtendInfo.mapParams = new HashMap();
        }
        if (imageUploadTask.stExternalMapExt == null) {
            imageUploadTask.stExternalMapExt = new HashMap<>();
        }
        if (TextUtils.isEmpty(str)) {
            str = imageInfo.mPath;
        }
        oo.d.f423238a.c(str, imageUploadTask.stExternalMapExt);
        if (aVar.f51920t) {
            imageUploadTask.stExternalMapExt.put(FSUploadConst.KEY_MIX_FEED, "1");
        }
        imageUploadTask.stExternalMapExt = setPanoramaType(imageUploadTask.stExternalMapExt, imageUploadTask.uploadFilePath, aVar.A);
        Map<String, String> map = aVar.D;
        if (map != null && map.size() > 0) {
            imageUploadTask.stExternalMapExt.putAll(aVar.D);
        }
        try {
            if (!JpegExifReader.isCrashJpeg(imageUploadTask.uploadFilePath)) {
                com.qzone.util.image.b bVar = new com.qzone.util.image.b(imageUploadTask.uploadFilePath);
                imageUploadTask.stExtendInfo.mapExif = com.qzone.util.image.a.b(bVar);
                imageUploadTask.exifTime = appendShootTime(bVar, imageUploadTask.uploadFilePath);
            }
        } catch (Exception unused) {
            QZLog.e(TAG, "read pic exif error");
        }
        if (z16 || isNeedReplaceGpsInfo()) {
            appendPhotoShootParams(imageUploadTask, aVar.E);
        } else if (imageInfo != null && (gpsInfo4LocalImage = imageInfo.mGpsInfo) != null) {
            appendVideoGeoToCover(imageUploadTask, gpsInfo4LocalImage);
        } else {
            appendPhotoShootParamsByExif(imageUploadTask);
        }
        HashMap<String, byte[]> hashMap3 = new HashMap<>();
        if (imageInfo != null && (hashMap2 = imageInfo.mExternalData) != null && hashMap2.size() > 0) {
            for (String str2 : imageInfo.mExternalData.keySet()) {
                hashMap3.put(str2, imageInfo.mExternalData.get(str2));
            }
        }
        Map<String, byte[]> map2 = aVar.B;
        if (map2 != null && imageInfo != null && map2.containsKey(imageInfo.mPath)) {
            hashMap3.put(kExtKeyMarkUinBeforeUpload.value, aVar.B.get(imageInfo.mPath));
        } else {
            hashMap3.put(kExtKeyMarkUinBeforeUpload.value, new byte[0]);
        }
        imageUploadTask.mExternalByteData = hashMap3;
        Map<String, byte[]> map3 = aVar.F;
        if (map3 != null && map3.size() > 0) {
            imageUploadTask.mExternalByteData.putAll(aVar.F);
        }
        Map<String, String> map4 = aVar.C;
        if (map4 != null && imageInfo != null && map4.containsKey(imageInfo.mPath)) {
            HashMap hashMap4 = new HashMap();
            hashMap4.put("youtu_tag_array", aVar.C.get(imageInfo.mPath));
            imageUploadTask.stExternalMapExt.putAll(hashMap4);
        }
        if (imageInfo != null && (hashMap = imageInfo.mPhotoTagInfo) != null && hashMap.size() > 0) {
            imageUploadTask.stExternalMapExt.putAll(imageInfo.mPhotoTagInfo);
        }
        if (!TextUtils.isEmpty(aVar.f51924x)) {
            imageUploadTask.stExtendInfo.mapParams.put("open_appid", aVar.f51924x);
        }
        stPoi stpoi = aVar.f51923w;
        if (stpoi != null) {
            imageUploadTask.stExtendInfo.mapParams.put("show_geo", String.valueOf(stpoi.show_poi));
            if (QZLog.isDevelopLevel()) {
                QZLog.d(TAG, 4, ", show_geo:" + aVar.f51923w.show_poi);
                return;
            }
            return;
        }
        imageUploadTask.stExtendInfo.mapParams.put("show_geo", "0");
        if (QZLog.isDevelopLevel()) {
            QZLog.d(TAG, 4, ", show_geo:0");
        }
    }

    public void setPreViewIconInfo(com.qzone.publish.business.task.c cVar) {
        if (TextUtils.isEmpty(cVar.f51192h)) {
            int i3 = this.successImageCnt;
            List<MediaWrapper> list = this.mediaList;
            if (list == null || list.size() <= 0 || i3 < 0 || i3 > this.mediaList.size()) {
                return;
            }
            if (i3 == this.mediaList.size()) {
                i3--;
            }
            MediaWrapper mediaWrapper = this.mediaList.get(i3);
            if (mediaWrapper != null) {
                if (mediaWrapper.isImage()) {
                    cVar.f51192h = mediaWrapper.getImageInfo().mPath;
                } else if (mediaWrapper.isVideo()) {
                    cVar.f51192h = mediaWrapper.getVideoInfo().mCoverUrl;
                    cVar.f51193i = true;
                }
            }
        }
    }

    @Override // com.qzone.publish.business.protocol.QzoneUploadRequest
    public void upload(byte[] bArr) {
        doUploadPhoto(bArr);
        doUploadVideo(bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendResponse(QZoneProcessType qZoneProcessType, int i3, String str, JceStruct jceStruct) {
        UniAttribute uniAttribute = new UniAttribute();
        uniAttribute.setEncodeName("utf8");
        uniAttribute.put("ReplyCode", Integer.valueOf(i3));
        uniAttribute.put("StrResult", i3 == 0 ? "success" : "fail");
        if (jceStruct != null) {
            uniAttribute.put("response", jceStruct);
        }
        this.mListner.onProtocolResponse(qZoneProcessType, uniAttribute, i3, i3, str, false);
    }

    protected void completeRequest(QZoneProcessType qZoneProcessType, int i3, String str) {
        sendResponse(qZoneProcessType, i3, str, null);
        com.qzone.publish.business.publishqueue.c cVar = this.mUploadQueueListener;
        if (cVar != null) {
            cVar.onUploadError(null, i3, str);
        }
    }

    protected void initUploadMediaList(List<MediaWrapper> list) {
        String str;
        if (list == null || list.isEmpty()) {
            return;
        }
        QZLog.i(TAG, getRequestDesc() + ", initUploadMediaList mediaList size:" + list.size());
        this.batchMediaNum = 0;
        this.videoList.clear();
        this.photoList.clear();
        this.totalMediaNum = list.size();
        Iterator<MediaWrapper> it = list.iterator();
        while (it.hasNext()) {
            MediaWrapper next = it.next();
            if (next != null) {
                int indexOf = list.indexOf(next);
                d dVar = new d();
                dVar.f51070a = next;
                dVar.f51071b = indexOf;
                dVar.f51074e = this.richPhotoNum + indexOf;
                if (next.isVideo()) {
                    this.batchMediaNum++;
                    String str2 = next.getVideoInfo().mVideoPath;
                    dVar.f51073d = str2;
                    this.videoList.put(str2, dVar);
                    QZLog.i(TAG, getRequestDesc() + ", load video " + dVar.f51073d);
                    a.C0436a c0436a = new a.C0436a(2, dVar.f51073d);
                    dVar.f51076g = c0436a;
                    c0436a.f51028c = next.getVideoInfo().mSize / 1024;
                } else if (next.isImage()) {
                    ImageInfo imageInfo = next.getImageInfo();
                    if (imageInfo != null && !URLUtil.isNetworkUrl(imageInfo.mPath)) {
                        this.batchMediaNum++;
                        String str3 = imageInfo.mPath;
                        dVar.f51073d = str3;
                        this.photoList.put(str3, dVar);
                        QZLog.i(TAG, getRequestDesc() + ", load photo " + imageInfo.mPath);
                        a.C0436a c0436a2 = new a.C0436a(1, imageInfo.mPath);
                        dVar.f51076g = c0436a2;
                        c0436a2.f51028c = imageInfo.mSize / 1024;
                    } else {
                        it.remove();
                        this.richPhotoNum++;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(getRequestDesc());
                        sb5.append(", load photo ");
                        if (imageInfo == null) {
                            str = "null imageInfo";
                        } else {
                            str = "rich image:" + imageInfo.mPath;
                        }
                        sb5.append(str);
                        sb5.append(", pass this one, current index:");
                        sb5.append(indexOf);
                        QZLog.i(TAG, sb5.toString());
                    }
                }
            }
        }
        QZLog.i(TAG, getRequestDesc() + ", uploadMediaList total num:" + this.totalMediaNum + ", batch num:" + this.batchMediaNum + ", rich photo num:" + this.richPhotoNum);
    }

    @Override // com.qzone.publish.business.task.compress.VideoCompressTask.a
    public void onCompressProgressUpdate(VideoCompressTask videoCompressTask, double d16) {
        d dVar;
        if (videoCompressTask == null || this.mediaUploadListener == null || (dVar = this.videoList.get(videoCompressTask.mVideoSourcePath)) == null) {
            return;
        }
        this.mediaUploadListener.onMediaCompressProgress(dVar.f51073d, dVar.f51071b, d16);
    }

    @Override // com.qzone.publish.business.task.compress.VideoCompressTask.a
    public void onCompressStart(VideoCompressTask videoCompressTask) {
        d dVar;
        a.C0436a c0436a;
        if (videoCompressTask == null || TextUtils.isEmpty(videoCompressTask.mVideoSourcePath) || !this.videoList.containsKey(videoCompressTask.mVideoSourcePath) || (dVar = this.videoList.get(videoCompressTask.mVideoSourcePath)) == null || (c0436a = dVar.f51076g) == null) {
            return;
        }
        c0436a.f51030e = System.currentTimeMillis();
    }

    protected void setWeishiTag(AbstractUploadTask abstractUploadTask, ShuoshuoVideoInfo shuoshuoVideoInfo) {
        PicExtendInfo picExtendInfo;
        if (shuoshuoVideoInfo != null) {
            Bundle bundle = shuoshuoVideoInfo.mExtras;
            boolean z16 = bundle != null ? bundle.getBoolean(ShortVideoConstants.VIDEO_IS_SYNC_TO_WEISHI, false) : false;
            abstractUploadTask.isSyncWeishi = z16;
            if (z16) {
                abstractUploadTask.sDevIMEI = PlatformInfor.g().getIMEI();
                if (abstractUploadTask instanceof ImageUploadTask) {
                    ImageUploadTask imageUploadTask = (ImageUploadTask) abstractUploadTask;
                    LbsInfo lbsInfo = this.uploadParams.H;
                    if (lbsInfo != null && (picExtendInfo = imageUploadTask.stExtendInfo) != null && picExtendInfo.mapParams != null) {
                        imageUploadTask.stExternalMapExt.put("geo_x_choose", String.valueOf(lbsInfo.lbs_x));
                        imageUploadTask.stExternalMapExt.put("geo_y_choose", String.valueOf(this.uploadParams.H.lbs_y));
                    }
                    String str = shuoshuoVideoInfo.mDescription;
                    if (str == null) {
                        str = "";
                    }
                    imageUploadTask.sPicDesc = str;
                }
            }
        }
    }

    protected int subFlowId(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        return (str2 + String.valueOf(str)).hashCode();
    }

    private boolean dealWithByProcess(ShuoshuoVideoInfo shuoshuoVideoInfo, d dVar, a.InterfaceC0438a<ShuoshuoVideoInfo> interfaceC0438a) {
        if (shuoshuoVideoInfo == null) {
            return false;
        }
        if (shuoshuoVideoInfo.mIsUploadOrigin && TextUtils.isEmpty(shuoshuoVideoInfo.mProcessMissionID)) {
            return false;
        }
        com.qzone.publish.business.process.base.a qCircleProcess = shuoshuoVideoInfo.mProcessType != 1 ? null : getQCircleProcess(shuoshuoVideoInfo, interfaceC0438a);
        if (qCircleProcess != null) {
            QZLog.d(TAG, 1, getRequestDesc() + "dealWithByProcess process:" + qCircleProcess + "mProcessType\uff1a" + shuoshuoVideoInfo.mProcessType);
            qCircleProcess.n(dVar);
            this.mQZoneMediaProcessStatusWrapper.g(qCircleProcess);
            return true;
        }
        QZLog.d(TAG, 1, getRequestDesc() + "dealWithByProcess process is null mProcessType\uff1a" + shuoshuoVideoInfo.mProcessType);
        return false;
    }

    private String getVideoCover(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        if (shuoshuoVideoInfo == null) {
            return null;
        }
        String str = shuoshuoVideoInfo.mCoverUrl;
        return (TextUtils.isEmpty(str) || !new File(str).exists() || new File(str).isDirectory()) ? ag.h(shuoshuoVideoInfo.mVideoPath) : str;
    }

    public HashMap<String, String> setPanoramaType(HashMap<String, String> hashMap, String str, Map<String, String> map) {
        if (map != null) {
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            String str2 = map.get(str);
            if (!TextUtils.isEmpty(str2)) {
                int parseInt = Integer.parseInt(str2);
                if (parseInt == 1) {
                    hashMap.put("panorama_type", "1");
                } else if (parseInt == 2) {
                    hashMap.put("panorama_type", "2");
                } else if (parseInt != 3) {
                    hashMap.put("panorama_type", "0");
                } else {
                    hashMap.put("panorama_type", "0");
                }
            }
        }
        return hashMap;
    }

    public static final byte[] pack(String str, Object obj) throws Exception {
        if (str == null || obj == null) {
            return null;
        }
        UniPacket uniPacket = new UniPacket();
        uniPacket.setEncodeName("UTF-8");
        uniPacket.setRequestId(0);
        uniPacket.setFuncName("FuncName");
        uniPacket.setServantName("ServantName");
        uniPacket.put(str, obj);
        byte[] encode = uniPacket.encode();
        uniPacket.clearCacheData();
        return encode;
    }

    protected void doUploadPhotoSucceed(ImageUploadTask imageUploadTask, Object obj) {
        String str;
        int i3;
        a.C0436a c0436a;
        this.successImageCnt++;
        d dVar = this.photoList.get(imageUploadTask.uploadFilePath);
        if (dVar == null && !TextUtils.isEmpty(imageUploadTask.mOriginFilePath)) {
            dVar = this.photoList.get(imageUploadTask.mOriginFilePath);
        }
        if (dVar != null && (c0436a = dVar.f51076g) != null) {
            c0436a.f51030e = imageUploadTask.compressStartTime;
            c0436a.f51031f = imageUploadTask.compressEndTime;
            b bVar = this.mediaUploadListener;
            if (bVar != null) {
                bVar.onMediaUploadReport(c0436a);
            }
        }
        d dVar2 = imageUploadTask.isCover ? this.videoList.get(imageUploadTask.srcVideoPath) : null;
        if (obj instanceof ImageUploadResult) {
            ImageUploadResult imageUploadResult = (ImageUploadResult) obj;
            UploadFileResponse uploadFileResponse = new UploadFileResponse();
            uploadFileResponse.albumId = imageUploadResult.sAlbumID;
            uploadFileResponse.height = imageUploadResult.iHeight;
            uploadFileResponse.width = imageUploadResult.iWidth;
            uploadFileResponse.photoId = imageUploadResult.sPhotoID;
            uploadFileResponse.slocId = imageUploadResult.sSloc;
            uploadFileResponse.originId = imageUploadResult.sOriPhotoID;
            uploadFileResponse.oheight = imageUploadResult.iOriHeight;
            uploadFileResponse.owidth = imageUploadResult.iOriWidth;
            uploadFileResponse.url = imageUploadResult.sBURL;
            uploadFileResponse.picType = imageUploadResult.iPicType;
            uploadFileResponse.md5 = imageUploadResult.sPhotoMD5;
            uploadFileResponse.clientFakeKey = LoginData.getInstance().getUin() + "_" + imageUploadTask.iUploadTime + "_" + this.uploadParams.f51904d;
            if (dVar == null) {
                str = "";
            } else {
                str = dVar.f51073d;
            }
            uploadFileResponse.originUploadUrl = str;
            if (dVar != null) {
                dVar.f51075f = uploadFileResponse;
            }
            b bVar2 = this.mediaUploadListener;
            if (bVar2 != null) {
                if (dVar != null) {
                    i3 = dVar.f51074e;
                } else {
                    i3 = dVar2 != null ? dVar2.f51074e : 0;
                }
                bVar2.onMediaUploadSuccess(uploadFileResponse, imageUploadTask, i3, imageUploadResult.sPhotoID, dVar != null ? dVar.f51073d : null, imageUploadTask.uploadFilePath);
            }
            com.qzone.publish.business.publishqueue.c cVar = this.mUploadQueueListener;
            if (cVar != null) {
                cVar.onUploadSucceed(obj);
            }
            if (this.successImageCnt >= this.batchMediaNum) {
                JceStruct jceStruct = uploadFileResponse;
                jceStruct = uploadFileResponse;
                if (imageUploadTask.isCover && dVar2 != null) {
                    jceStruct = dVar2.f51075f;
                }
                sendResponse(QZoneProcessType.PROCESS_TYPE_UPLOAD, 0, "", jceStruct);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPreUploadParams(ImageUploadTask imageUploadTask, com.qzone.publish.ui.model.a aVar) {
        if (imageUploadTask == null || aVar == null) {
            return;
        }
        QZonePreUploadInfo qZonePreUploadInfo = aVar.f51926z;
        if (qZonePreUploadInfo != null) {
            imageUploadTask.preupload = qZonePreUploadInfo.preUploadType;
            if (qZonePreUploadInfo.isPreUploaded(imageUploadTask.uploadFilePath)) {
                imageUploadTask.preupload = 2;
                return;
            }
            return;
        }
        imageUploadTask.preupload = 0;
    }

    protected void setTargetParams(ImageUploadTask imageUploadTask, int i3) {
        if (imageUploadTask == null) {
            return;
        }
        if (i3 == 4) {
            if (imageUploadTask.iBusiNessType != 0 && !this.uploadParams.f51919s) {
                imageUploadTask.iSync = 1;
            } else {
                imageUploadTask.iSync = 0;
            }
            com.qzone.publish.ui.model.a aVar = this.uploadParams;
            imageUploadTask.iSync = aVar.L ? 0 : imageUploadTask.iSync;
            imageUploadTask.sAlbumID = "";
            int i16 = aVar.f51925y;
            imageUploadTask.iAlbumTypeID = i16 != -1 ? i16 : 7;
        } else if (i3 != 1 && i3 != 3) {
            imageUploadTask.iSync = 1;
            if (TextUtils.isEmpty(this.uploadParams.f51907g)) {
                int i17 = this.uploadParams.f51925y;
                if (i17 == -1) {
                    i17 = 1;
                }
                imageUploadTask.iAlbumTypeID = i17;
            } else {
                com.qzone.publish.ui.model.a aVar2 = this.uploadParams;
                int i18 = aVar2.f51925y;
                if (i18 == -1) {
                    i18 = 0;
                }
                imageUploadTask.iAlbumTypeID = i18;
                imageUploadTask.sAlbumID = aVar2.f51907g;
            }
            if (i3 == 6) {
                imageUploadTask.iSync = 0;
            }
        } else {
            imageUploadTask.iSync = 0;
            imageUploadTask.sAlbumID = "";
            int i19 = this.uploadParams.f51925y;
            imageUploadTask.iAlbumTypeID = i19 != -1 ? i19 : 7;
        }
        if (i3 == 0) {
            imageUploadTask.iDistinctUse = QZoneUploadPicRequest.UPLOAD_PHOTO_SRC;
            return;
        }
        if (i3 == 1) {
            imageUploadTask.iDistinctUse = QZoneUploadPicRequest.BLOG_SRC;
        } else if (i3 == 4 || i3 == 3) {
            imageUploadTask.iDistinctUse = QZoneUploadPicRequest.SHUOSHUO_SRC;
        }
    }

    private void appendCoverTaskParams(AbstractUploadTask abstractUploadTask, ImageUploadTask imageUploadTask, String str) {
        if (abstractUploadTask == null || imageUploadTask == null) {
            return;
        }
        imageUploadTask.iUploadTime = abstractUploadTask.iUploadTime;
        if (imageUploadTask.stExtendInfo == null) {
            imageUploadTask.stExtendInfo = new PicExtendInfo();
        }
        PicExtendInfo picExtendInfo = imageUploadTask.stExtendInfo;
        if (picExtendInfo.mapParams == null) {
            picExtendInfo.mapParams = new HashMap();
        }
        imageUploadTask.stExtendInfo.mapParams.put("vid", str);
        if (imageUploadTask.stExternalMapExt == null) {
            imageUploadTask.stExternalMapExt = new HashMap<>();
        }
        HashMap<String, String> hashMap = this.uploadParams.f51914n;
        if (hashMap != null) {
            imageUploadTask.stExternalMapExt.putAll(hashMap);
        }
        imageUploadTask.stExternalMapExt.put(FSUploadConst.KEY_CLIENT_UPLOOAD_COVER, "1");
        imageUploadTask.stExternalMapExt.put(FSUploadConst.KEY_MIX_FEED, "1");
        UploadVideoObject uploadVideoObject = this.uploadVideoObjects.get(abstractUploadTask.uploadFilePath);
        if (uploadVideoObject != null) {
            imageUploadTask.stExternalMapExt.put(FSUploadConst.KEY_MIX_VIDEO_SIZE, uploadVideoObject.getSize() + "");
            imageUploadTask.stExternalMapExt.put(FSUploadConst.KEY_MIX_ORIGIN_VIDEO, uploadVideoObject.getIsUploadOrigin() + "");
            imageUploadTask.stExternalMapExt.put(FSUploadConst.KEY_MIX_TIME, uploadVideoObject.getDuration() + "");
            imageUploadTask.sPicDesc = uploadVideoObject.getDesc();
        }
        if (imageUploadTask.iDistinctUse == 14301 && imageUploadTask.isCover) {
            imageUploadTask.iBusiNessType = 0;
            imageUploadTask.vBusiNessData = null;
        }
        if (this.uploadParams.a()) {
            imageUploadTask.vBusiNessData = null;
        }
    }

    protected void doUploadVideoSucceed(VideoUploadTask videoUploadTask, Object obj) {
        b bVar;
        d videoUploadMediaInfo = getVideoUploadMediaInfo(videoUploadTask);
        if (videoUploadMediaInfo == null) {
            QZLog.i(TAG, getRequestDesc() + ", get MediaOrderInfo fail path = " + videoUploadTask.uploadFilePath + ", flowId:" + videoUploadTask.flowId);
            return;
        }
        a.C0436a c0436a = videoUploadMediaInfo.f51076g;
        if (c0436a != null && (bVar = this.mediaUploadListener) != null) {
            bVar.onMediaUploadReport(c0436a);
        }
        VideoUploadResult videoUploadResult = (VideoUploadResult) obj;
        UploadVideoInfoRsp uploadVideoInfoRsp = new UploadVideoInfoRsp();
        uploadVideoInfoRsp.iBusiNessType = videoUploadResult.iBusiNessType;
        String str = videoUploadResult.sVid;
        uploadVideoInfoRsp.sVid = str;
        uploadVideoInfoRsp.vBusiNessData = videoUploadResult.vBusiNessData;
        videoUploadMediaInfo.f51075f = uploadVideoInfoRsp;
        MediaWrapper mediaWrapper = videoUploadMediaInfo.f51070a;
        if (mediaWrapper != null && mediaWrapper.isVideo()) {
            ShuoshuoVideoInfo videoInfo = mediaWrapper.getVideoInfo();
            QZoneWriteOperationService.v0().h2(str, videoInfo.mStartTime, videoInfo.mEndTime);
        }
        UploadVideoObject uploadVideoObject = this.uploadVideoObjects.get(videoUploadTask.uploadFilePath);
        if (uploadVideoObject != null && TextUtils.isEmpty(uploadVideoObject.mOriganlVideoPath) && mediaWrapper != null && mediaWrapper.isVideo() && mediaWrapper.getVideoInfo().mVideoType == 0 && !com.qzone.publish.utils.c.e(videoUploadTask.uploadFilePath)) {
            String str2 = videoUploadTask.uploadFilePath;
            uploadVideoObject.mOriganlVideoPath = str2;
            videoUploadMediaInfo.f51073d = str2;
        }
        b bVar2 = this.mediaUploadListener;
        if (bVar2 != null) {
            bVar2.onMediaUploadSuccess(uploadVideoInfoRsp, videoUploadTask, videoUploadMediaInfo.f51074e, str, videoUploadMediaInfo.f51073d, videoUploadTask.uploadFilePath);
        }
        com.qzone.publish.business.publishqueue.c cVar = this.mUploadQueueListener;
        if (cVar != null) {
            cVar.onUploadSucceed(obj);
        }
        boolean z16 = false;
        if (this.uploadParams.f51917q) {
            String str3 = videoUploadMediaInfo.f51072c;
            if (TextUtils.isEmpty(str3)) {
                QZLog.i(TAG, getRequestDesc() + ", coverPath == null, reget cover, videoPath:" + videoUploadTask.uploadFilePath + ", flowId:" + videoUploadTask.flowId);
                str3 = ag.h(videoUploadTask.uploadFilePath);
            }
            String str4 = str3;
            QZLog.i(TAG, getRequestDesc() + ", create VideoCover Upload Task, videoPath:" + videoUploadTask.uploadFilePath + ", coverPath:" + str4);
            ImageInfo create = ImageInfo.create(str4);
            if (isNeedReplaceGpsInfo()) {
                z16 = true;
            } else if (create != null) {
                create.mGpsInfo = getGpsInfoForVideo(videoUploadMediaInfo.f51073d);
            }
            ImageUploadTask createImageUploadTask = createImageUploadTask(create, LoginData.getInstance().getA2Bytes(), videoUploadMediaInfo.f51071b, z16, videoUploadTask.mOriginFilePath);
            if (createImageUploadTask == null) {
                String a16 = r7.c.a(FSUploadConst.ERR_GENERATE_VIDEO_COVER_FAIL);
                completeRequest(QZoneProcessType.PROCESS_TYPE_BUILD_VIDEO_COVER, FSUploadConst.ERR_GENERATE_VIDEO_COVER_FAIL, a16);
                QZLog.e(TAG, getRequestDesc() + ", create VideoCover Upload Task failed msg:" + a16 + ", videoPath:" + videoUploadTask.uploadFilePath + ", coverPath:" + str4);
                return;
            }
            createImageUploadTask.isCover = true;
            createImageUploadTask.srcVideoPath = videoUploadMediaInfo.f51073d;
            appendCoverTaskParams(videoUploadTask, createImageUploadTask, str);
            appendVideoShootTimeToCover(createImageUploadTask, videoUploadMediaInfo.f51073d);
            if (mediaWrapper != null && mediaWrapper.isVideo()) {
                setWeishiTag(createImageUploadTask, mediaWrapper.getVideoInfo());
            }
            doUploadTask(createImageUploadTask, videoUploadMediaInfo.f51071b, videoUploadMediaInfo.f51073d);
            QZLog.i(TAG, getRequestDesc() + ", upload video succeed, videoPath:" + videoUploadTask.uploadFilePath + ", flowId:" + videoUploadTask.flowId + ", vid:" + str + ", validAndUpload, coverPath:" + createImageUploadTask.uploadFilePath + ", cover flowId:" + createImageUploadTask.flowId);
            return;
        }
        QZLog.i(TAG, getRequestDesc() + ", upload video succeed, videoPath:" + videoUploadTask.uploadFilePath + ", flowId:" + videoUploadTask.flowId + ", vid:" + str + ", don't need upload cover");
        this.successImageCnt = this.successImageCnt + 1;
        if (this.successImageCnt >= this.batchMediaNum) {
            sendResponse(QZoneProcessType.PROCESS_TYPE_UPLOAD, 0, "", uploadVideoInfoRsp);
        }
    }

    public QzoneMediaUploadRequest(List<MediaWrapper> list, com.qzone.publish.ui.model.a aVar, com.qzone.publish.business.publishqueue.c cVar, b bVar) {
        super(null);
        this.successImageCnt = 0;
        this.mSuccessCompressCnt = 0;
        this.mCurrentTaskState = 0;
        this.photoList = new LinkedHashMap<>();
        this.videoList = new LinkedHashMap<>();
        this.mCompressVideoList = new HashMap<>();
        this.uploadVideoObjects = new HashMap<>();
        this.uploadTasks = new CopyOnWriteArrayList<>();
        this.compressTasks = new ArrayList<>();
        this.mQZoneMediaProcessStatusWrapper = new com.qzone.publish.business.protocol.a();
        this.mProcessVideoList = new HashMap<>();
        this.mVideoProcessListener = new a();
        this.uploadParams = aVar;
        if (aVar == null) {
            this.uploadParams = new com.qzone.publish.ui.model.a();
            QZLog.e(TAG, "constructor error, uploadParams null, set to default");
        }
        com.qzone.publish.ui.model.a aVar2 = this.uploadParams;
        int i3 = aVar2.f51901a;
        if (i3 == 0 || i3 == 4 || i3 == 5 || i3 == 6) {
            this.autoRotate = true;
        }
        if (!TextUtils.isEmpty(aVar2.f51902b)) {
            setRefer(this.uploadParams.f51902b);
        }
        if (!TextUtils.isEmpty(this.uploadParams.f51916p)) {
            this.mBusinessRefer = this.uploadParams.f51916p;
        }
        com.qzone.publish.ui.model.a aVar3 = this.uploadParams;
        if (aVar3.f51906f == 0) {
            aVar3.f51906f = NetConnInfoCenter.getServerTimeMillis() / 1000;
            QZLog.w(TAG, getRequestDesc() + ", get uploadTime 0, reset to serverTime:" + this.uploadParams.f51906f);
        }
        com.qzone.publish.ui.model.a aVar4 = this.uploadParams;
        this.batchId = aVar4.f51903c;
        this.clientKey = aVar4.f51904d;
        if (cVar != null) {
            setUploadQueueListener(cVar);
        }
        if (bVar != null) {
            this.mediaUploadListener = bVar;
        }
        this.mediaList = list;
        initUploadMediaList(list);
        if (this.photoList.size() <= 0 || this.videoList.size() <= 0) {
            return;
        }
        com.qzone.publish.ui.model.a aVar5 = this.uploadParams;
        if (aVar5.f51920t) {
            return;
        }
        aVar5.s(true);
    }

    public void clear() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUploadEntranceParams(AbstractUploadTask abstractUploadTask, int i3) {
        if (abstractUploadTask == null) {
            return;
        }
        if (i3 != 19) {
            if (i3 != 45 && i3 != 207) {
                switch (i3) {
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        break;
                    default:
                        switch (i3) {
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                                break;
                            default:
                                return;
                        }
                }
            }
            abstractUploadTask.entry = AbstractUploadTask.ENTRY_TYPE_SHUOSHUO;
            return;
        }
        abstractUploadTask.entry = "album";
    }

    private ImageUploadTask createImageUploadTask(ImageInfo imageInfo, byte[] bArr, int i3) {
        return createImageUploadTask(imageInfo, bArr, i3, false, null);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements a.InterfaceC0438a<ShuoshuoVideoInfo> {
        a() {
        }

        private d m(ShuoshuoVideoInfo shuoshuoVideoInfo, ShuoshuoVideoInfo shuoshuoVideoInfo2) {
            d dVar = QzoneMediaUploadRequest.this.videoList.get(shuoshuoVideoInfo.mVideoPath);
            if (dVar == null) {
                QZLog.i(QzoneMediaUploadRequest.TAG, QzoneMediaUploadRequest.this.getRequestDesc() + ", changeVideoInfoByDealWithResult uploadVideo is null\uff1b origin Path\uff1a" + shuoshuoVideoInfo.mVideoPath + ",videoList size:" + QzoneMediaUploadRequest.this.videoList.size());
                return null;
            }
            QZLog.i(QzoneMediaUploadRequest.TAG, QzoneMediaUploadRequest.this.getRequestDesc() + ",changeVideoInfoByDealWithResult onCompressSuccess srcPath:" + dVar.f51073d + ", destPath:" + shuoshuoVideoInfo2.mVideoPath);
            if (shuoshuoVideoInfo2.mStartTime > 0) {
                dVar.f51072c = ag.h(shuoshuoVideoInfo2.mVideoPath);
            }
            dVar.f51076g.f51031f = System.currentTimeMillis();
            File file = new File(shuoshuoVideoInfo2.mVideoPath);
            if (file.exists()) {
                dVar.f51076g.f51029d = file.length() / 1024;
            }
            return dVar;
        }

        @Override // com.qzone.publish.business.process.base.a.InterfaceC0438a
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void f(com.qzone.publish.business.process.base.a aVar, ShuoshuoVideoInfo shuoshuoVideoInfo, int i3, String str) {
            QZLog.e(QzoneMediaUploadRequest.TAG, QzoneMediaUploadRequest.this.getRequestDesc() + ", onProcessFailed " + shuoshuoVideoInfo + ",errorCode:" + i3 + ",msg:" + str);
            QzoneMediaUploadRequest.this.mCurrentTaskState = 1;
            QzoneMediaUploadRequest.this.cancelAllTasks();
            String str2 = shuoshuoVideoInfo.mVideoPath;
            d dVar = QzoneMediaUploadRequest.this.videoList.get(str2);
            if (((QZoneRequest) QzoneMediaUploadRequest.this).mUploadQueueListener.getState() != 2) {
                QzoneMediaUploadRequest.this.sendResponse(aVar.k(), i3, l.a(R.string.rz9) + (QzoneMediaUploadRequest.this.mSuccessCompressCnt + 1) + "\u5408\u6210\u5931\u8d25", null);
            }
            if (QzoneMediaUploadRequest.this.mediaUploadListener != null) {
                QzoneMediaUploadRequest.this.mediaUploadListener.onMediaCompressFailed(str2, dVar != null ? dVar.f51071b : -1, i3, str);
            }
        }

        @Override // com.qzone.publish.business.process.base.a.InterfaceC0438a
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void a(com.qzone.publish.business.process.base.a aVar, ShuoshuoVideoInfo shuoshuoVideoInfo, ShuoshuoVideoInfo shuoshuoVideoInfo2, float f16) {
            d dVar;
            if (QzoneMediaUploadRequest.this.mediaUploadListener == null || (dVar = QzoneMediaUploadRequest.this.videoList.get(shuoshuoVideoInfo.mVideoPath)) == null) {
                return;
            }
            QzoneMediaUploadRequest.this.mediaUploadListener.onMediaCompressProgress(dVar.f51073d, dVar.f51071b, f16);
        }

        @Override // com.qzone.publish.business.process.base.a.InterfaceC0438a
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void c(com.qzone.publish.business.process.base.a aVar, ShuoshuoVideoInfo shuoshuoVideoInfo, ShuoshuoVideoInfo shuoshuoVideoInfo2) {
            d dVar;
            a.C0436a c0436a;
            if (TextUtils.isEmpty(shuoshuoVideoInfo.mVideoPath) || !QzoneMediaUploadRequest.this.videoList.containsKey(shuoshuoVideoInfo.mVideoPath) || (dVar = QzoneMediaUploadRequest.this.videoList.get(shuoshuoVideoInfo.mVideoPath)) == null || (c0436a = dVar.f51076g) == null) {
                return;
            }
            c0436a.f51030e = System.currentTimeMillis();
        }

        @Override // com.qzone.publish.business.process.base.a.InterfaceC0438a
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void d(com.qzone.publish.business.process.base.a aVar, ShuoshuoVideoInfo shuoshuoVideoInfo, ShuoshuoVideoInfo shuoshuoVideoInfo2) {
            ShuoshuoVideoInfo videoInfo;
            if (shuoshuoVideoInfo != null && shuoshuoVideoInfo2 != null) {
                d m3 = m(shuoshuoVideoInfo, shuoshuoVideoInfo2);
                if (m3 == null) {
                    QZLog.i(QzoneMediaUploadRequest.TAG, QzoneMediaUploadRequest.this.getRequestDesc() + ", onProcessSucceed but get uploadMediaInfo == null");
                    QzoneMediaUploadRequest.this.sendResponse(aVar.k(), -202, "\u4e0a\u4f20\u6570\u636e\u89e3\u6790\u5f02\u5e38-202", null);
                    return;
                }
                MediaWrapper mediaWrapper = m3.f51070a;
                if (mediaWrapper != null && (videoInfo = mediaWrapper.getVideoInfo()) != null) {
                    videoInfo.mVideoPath = shuoshuoVideoInfo2.mVideoPath;
                }
                QzoneMediaUploadRequest.this.mProcessVideoList.put(shuoshuoVideoInfo2.mVideoPath, m3);
                AbstractUploadTask createVideoUploadTask = QzoneMediaUploadRequest.this.createVideoUploadTask(shuoshuoVideoInfo2, LoginData.getInstance().getA2Bytes(), m3.f51071b);
                if (createVideoUploadTask == null) {
                    QZLog.e(QzoneMediaUploadRequest.TAG, QzoneMediaUploadRequest.this.getRequestDesc() + ", onCompressSuccess, createVideoUploadTask error, return");
                    QzoneMediaUploadRequest.this.sendResponse(aVar.k(), -202, "\u4e0a\u4f20Task\u89e3\u6790\u5f02\u5e38-202", null);
                    return;
                }
                QZLog.i(QzoneMediaUploadRequest.TAG, QzoneMediaUploadRequest.this.getRequestDesc() + ", validAndUpload, path:" + createVideoUploadTask.uploadFilePath + ", flowId:" + createVideoUploadTask.flowId);
                QzoneMediaUploadRequest.this.doUploadTask(createVideoUploadTask, m3.f51071b, shuoshuoVideoInfo2.mVideoPath);
                return;
            }
            QZLog.i(QzoneMediaUploadRequest.TAG, QzoneMediaUploadRequest.this.getRequestDesc() + ", onProcessSucceed but endObj == null");
            QzoneMediaUploadRequest.this.sendResponse(aVar.k(), -202, "\u4e0a\u4f20\u6570\u636e\u89e3\u6790\u5f02\u5e38-202", null);
        }

        @Override // com.qzone.publish.business.process.base.a.InterfaceC0438a
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void b(com.qzone.publish.business.process.base.a aVar, ShuoshuoVideoInfo shuoshuoVideoInfo) {
        }

        @Override // com.qzone.publish.business.process.base.a.InterfaceC0438a
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void e(com.qzone.publish.business.process.base.a aVar, ShuoshuoVideoInfo shuoshuoVideoInfo) {
        }
    }
}
