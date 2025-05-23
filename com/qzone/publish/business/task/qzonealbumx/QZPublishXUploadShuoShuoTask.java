package com.qzone.publish.business.task.qzonealbumx;

import FileUpload.UploadVideoInfoRsp;
import NS_MOBILE_FEEDS.single_feed;
import NS_MOBILE_OPERATION.LbsInfo;
import NS_MOBILE_OPERATION.MediaInfo;
import NS_MOBILE_OPERATION.PicInfo;
import NS_MOBILE_OPERATION.Source;
import NS_MOBILE_OPERATION.operation_publishmood_req;
import NS_MOBILE_OPERATION.operation_publishmood_rsp;
import NS_MOBILE_PHOTO.active_photo;
import NS_MOBILE_PHOTO.shuoshuo_privacy;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.qzone.album.data.model.GifInfo;
import com.qzone.album.protocol.QZoneModifyDynamicRequest;
import com.qzone.album.protocol.QZoneQueryDynamicRequest;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.UploadFileResponse;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.ui.model.PublishEventTag;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.publish.business.model.LocalImageInfo;
import com.qzone.publish.business.model.NetworkImageInfo;
import com.qzone.publish.business.model.UploadImageObject;
import com.qzone.publish.business.model.a;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.qzone.publish.business.protocol.QZoneUploadMoodRequest;
import com.qzone.publish.business.protocol.QZoneVideoShuoshuoUploadFinishRequest;
import com.qzone.publish.business.protocol.QzoneMediaUploadRequest;
import com.qzone.publish.business.publishqueue.h;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.publish.business.task.QZoneQueueTask;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.reborn.editdraft.QZWinkEditDraftUtil;
import com.qzone.util.ToastUtil;
import com.qzone.util.image.ImageInfo;
import com.qzone.util.j;
import com.qzone.util.l;
import com.qzone.util.u;
import com.qzone.video.service.QzoneVideoPerfReport;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.util.Pair;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.Lbs.QzoneLbsConstant;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.model.DynamicPhotoData;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lc.i;
import lc.m;

/* loaded from: classes39.dex */
public class QZPublishXUploadShuoShuoTask extends QZoneQueueTask implements QzoneMediaUploadRequest.b {
    private static final int DEFAULT_RECORD_MEDIA_COUNT = 1;
    private static final int DEFAULT_UPLOAD_RECORD_VIDEO_WITH_MIX_MODE = 1;
    private static final String KEY_FAKE_SINGLE_FEED = "fakeSingleFeed";
    public static final int MIXUPLOAD = 1;
    public static final int PHOTO = 0;
    private static final String REFER_VIDEO_SHUOSHUO = "video_shuoshuo";
    private static final int STEP_UPLOAD_DYNAMIC_TASK = 6;
    private static final int STEP_UPLOAD_MIX_VIDEO_PIC_MOOD_TASK = 8;
    private static final int STEP_UPLOAD_MIX_VIDEO_PIC_TASK = 7;
    private static final int STEP_UPLOAD_MOOD_TASK = 5;
    private static final int STEP_UPLOAD_PHOTO_WITH_MOOD = 3;
    private static final int STEP_UPLOAD_TASK = 0;
    private static final int STEP_UPLOAD_VIDEO = 2;
    private static final int STEP_VIDEO_UPLOAD_SUCCESS = 4;
    private static final int STEP_WRITE_CONTENT = 1;
    private static final String TAG = "QZPublishX_QZPublishXUploadShuoShuoTask";

    @NeedParcel
    public Map<DynamicPhotoData, active_photo> activePhotosMap;

    @NeedParcel
    protected String content;

    @NeedParcel
    public List<DynamicPhotoData> dynamicPhotoDatas;

    @NeedParcel
    private String extParam;

    @NeedParcel
    private HashMap<String, String> extendParams;

    @NeedParcel
    public Map<String, byte[]> faceOperationMap;

    @NeedParcel
    private HashMap<String, Integer> flowIdMap;

    @NeedParcel
    public boolean fromKuolie;

    @NeedParcel
    public ArrayList<GifInfo> gifList;

    @NeedParcel
    public LbsInfo hiddenPoi;

    @NeedParcel
    public HashMap<String, String> imagePanoramaMap;

    @NeedParcel
    protected List<String> images;

    @NeedParcel
    protected boolean isFromAIO;

    @NeedParcel
    public boolean isMakeVideo;

    @NeedParcel
    private boolean isSyncToQQStory;

    @NeedParcel
    boolean isTopic;

    @NeedParcel
    public boolean isVideoToGif;

    @NeedParcel
    public String kuolieCampus;
    protected LbsInfo lbsInfo;

    @NeedParcel
    public Map<String, String> localUrlMap;

    @NeedParcel
    public long mDeleteTime;
    private PublishEventTag mEventTag;

    @NeedParcel
    protected LbsDataV2.PoiInfo mPoiInfo;

    @NeedParcel
    public long mPublishTime;
    protected a.C0436a mediaReportInfo;

    @NeedParcel
    protected int mediaType;

    @NeedParcel
    protected List<String> mixAllimages;

    @NeedParcel
    private String operationParams;

    @NeedParcel
    public Map<String, String> photoTagResult;

    @NeedParcel
    private Map<String, byte[]> protoExtendInfo;

    @NeedParcel
    private QzoneVerticalVideoTopicInfo qzoneVerticalVideoTopicInfo;

    @NeedParcel
    public String refer;

    @NeedParcel
    protected ArrayList<Pair<Integer, PicInfo>> richImageList;

    @NeedParcel
    private HashMap<String, PicInfo> richImageMap;

    @NeedParcel
    private int selectedCountFromRecent;

    @NeedParcel
    private Map<String, String> shootParams;

    @NeedParcel
    private shuoshuo_privacy shuoshuoPrivacy;

    @NeedParcel
    private Map<String, String> storedExtendInfo;

    @NeedParcel
    private boolean syncQQ;

    @NeedParcel
    public String syncToFriendInfo;

    @NeedParcel
    public String syncToKuolie;

    @NeedParcel
    private boolean syncWeibo;

    @NeedParcel
    public String syncWeiboImageUrl;

    @NeedParcel
    public String title;

    @NeedParcel
    public int uploadEntrance;

    @NeedParcel
    protected ShuoshuoVideoInfo videoInfo;

    @NeedParcel
    private int curImageIndex = 0;

    @NeedParcel
    public MediaInfo mediaInfo = new MediaInfo();

    @NeedParcel
    private String mvTemplateShuoshuo = null;

    @NeedParcel
    protected List<ShuoshuoVideoInfo> mMixVideoInfos = new ArrayList();

    @NeedParcel
    protected List<ShuoshuoVideoInfo> mMixWaitintCompressVideoInfos = new ArrayList();

    @NeedParcel
    protected List<ShuoshuoVideoInfo> mMixOrignalWaitingUploadVideo = new ArrayList();

    @NeedParcel
    protected Map<Integer, String> mMixOrgVideoPaths = new HashMap();

    @NeedParcel
    protected List<MediaWrapper> mMediaList = new ArrayList();

    @NeedParcel
    public boolean mIsMixTask = false;

    @NeedParcel
    protected int mMixBatchedMediaNum = 0;

    @NeedParcel
    public volatile int step = 0;

    @NeedParcel
    protected int photoQuality = 0;

    @NeedParcel
    private int priv = 1;

    @NeedParcel
    private ArrayList<String> privUinList = null;

    @NeedParcel
    private int subtype = 2;
    public boolean isRestoreFromCache = false;
    private ArrayList<Integer> mediaUploadSuccessIndexList = new ArrayList<>();
    private boolean isFromVideoSign = false;
    String uploadDynamicPic = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoUploadDynamicPic", "\u4e0a\u4f20\u52a8\u56fe\uff1a");
    String publishMood = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoPublishMood", "\u53d1\u8868\u8bf4\u8bf4\uff1a");
    String publishVideo = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoPublishVideo", "\u4e0a\u4f20\u89c6\u9891\uff1a");
    String publishing = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoPublishing", "\u53d1\u8868\u4e2d...");
    String uploadVideo = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoUploadVideo", "\u4e0a\u4f20\u89c6\u9891");
    String publishSignMood = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoPublishSignMood", "\u53d1\u8868\u7b7e\u5230\uff1a");

    public QZPublishXUploadShuoShuoTask() {
    }

    private void addUploadVideoToUrlMap(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.localUrlMap == null) {
            this.localUrlMap = new HashMap();
        }
        this.localUrlMap.put(str, str2);
    }

    private void compressGif(GifInfo gifInfo) {
        if (com.qzone.util.image.c.b(gifInfo)) {
            gifInfo.mDestPath = gifInfo.mSavePath;
            File file = new File(gifInfo.mDestPath);
            if (file.exists()) {
                if (!gifInfo.mOrignPath.equals(gifInfo.mCombineImagePath)) {
                    new File(gifInfo.mCombineImagePath).delete();
                }
                addToRecentPhotoBlacklists(gifInfo.mDestPath);
                int indexOf = this.images.indexOf(gifInfo.mCombineImagePath);
                if (QZLog.isColorLevel()) {
                    QZLog.d(TAG, 2, "compressGif, index:" + indexOf);
                }
                this.images.remove(gifInfo.mCombineImagePath);
                this.images.add(indexOf, gifInfo.mDestPath);
                HashMap<String, Integer> hashMap = this.flowIdMap;
                if (hashMap != null) {
                    hashMap.remove(gifInfo.mCombineImagePath);
                    HashMap<String, Integer> hashMap2 = this.flowIdMap;
                    String str = gifInfo.mDestPath;
                    hashMap2.put(str, Integer.valueOf(subFlowId((int) this.batchId, str)));
                }
                BaseApplication.getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
            }
        }
    }

    private void compressListToGif(GifInfo gifInfo) {
        if (com.qzone.util.image.c.e(gifInfo)) {
            gifInfo.mDestPath = gifInfo.mSavePath;
            File file = new File(gifInfo.mDestPath);
            if (file.exists()) {
                if (!gifInfo.mOrignPath.equals(gifInfo.mCombineImagePath)) {
                    new File(gifInfo.mCombineImagePath).delete();
                }
                addToRecentPhotoBlacklists(gifInfo.mDestPath);
                int indexOf = this.images.indexOf(gifInfo.mCombineImagePath);
                this.images.remove(gifInfo.mCombineImagePath);
                this.images.add(indexOf, gifInfo.mDestPath);
                HashMap<String, Integer> hashMap = this.flowIdMap;
                if (hashMap != null) {
                    hashMap.remove(gifInfo.mCombineImagePath);
                    HashMap<String, Integer> hashMap2 = this.flowIdMap;
                    String str = gifInfo.mDestPath;
                    hashMap2.put(str, Integer.valueOf(subFlowId((int) this.batchId, str)));
                }
                if (QZLog.isColorLevel()) {
                    QZLog.d(TAG, 2, "compressListToGif, index:" + indexOf);
                }
                BaseApplication.getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
            }
        }
    }

    private int getSuccessCount() {
        return this.mediaUploadSuccessIndexList.size();
    }

    private void initImageFlowId() {
        if (this.images == null) {
            return;
        }
        if (this.flowIdMap == null) {
            this.flowIdMap = new HashMap<>();
        }
        for (int i3 = 0; i3 < this.images.size(); i3++) {
            this.flowIdMap.put(this.images.get(i3), Integer.valueOf(subFlowId((int) this.batchId, this.images.get(i3))));
        }
    }

    private void initImageStep() {
        ArrayList<Pair<Integer, PicInfo>> arrayList;
        List<String> list = this.images;
        if ((list != null && list.size() > 1) || ((arrayList = this.richImageList) != null && arrayList.size() > 0)) {
            this.step = 0;
        } else {
            this.step = 3;
        }
        this.mediaType = 1;
    }

    private void initMixUpload(com.qzone.publish.ui.model.c cVar) {
        initParams(cVar);
        this.isFromVideoSign = cVar.f51933a0;
        this.syncToKuolie = cVar.S;
        this.kuolieCampus = cVar.T;
        initMixPicVideoInfos(cVar.M);
        initImageFlowId();
        initLbsInfo(cVar.f51948j, cVar.f51962x);
        processVideoSyncWeibo(this.syncWeibo);
        this.mIsMixTask = isMixVideoPicTask();
        if (this.storedExtendInfo == null) {
            this.storedExtendInfo = new HashMap();
        }
        HashMap<String, String> hashMap = cVar.E;
        if (hashMap != null) {
            this.storedExtendInfo.putAll(hashMap);
        }
        Map<String, String> map = cVar.f51935b0;
        if (map != null) {
            this.storedExtendInfo.putAll(map);
        }
        initStep();
        QZLog.i(TAG, "initMixUpload, " + getStepDesc());
    }

    private void initNormal(com.qzone.publish.ui.model.c cVar) {
        initParams(cVar);
        this.mvTemplateShuoshuo = null;
        this.videoInfo = cVar.f51946h;
        initImageInfo(cVar.f51936c);
        initImageFlowId();
        initLbsInfo(cVar.f51948j, cVar.f51962x);
        processVideoSyncWeibo(this.syncWeibo);
        if (this.storedExtendInfo == null) {
            this.storedExtendInfo = new HashMap();
        }
        HashMap<String, String> hashMap = cVar.E;
        if (hashMap != null) {
            this.storedExtendInfo.putAll(hashMap);
        }
        Map<String, String> map = cVar.f51935b0;
        if (map != null) {
            this.storedExtendInfo.putAll(map);
        }
        if (cVar.N != null) {
            MediaInfo mediaInfo = this.mediaInfo;
            if (mediaInfo.picinfolist == null) {
                mediaInfo.picinfolist = new ArrayList<>();
            }
            this.mediaInfo.picinfolist.add(cVar.N);
        }
        initStep();
        QZLog.i(TAG, "initNormal, " + getStepDesc());
    }

    private void initParams(com.qzone.publish.ui.model.c cVar) {
        this.content = cVar.f51934b;
        ArrayList<DynamicPhotoData> arrayList = cVar.f51938d;
        this.dynamicPhotoDatas = arrayList;
        if (arrayList != null) {
            this.activePhotosMap = new HashMap();
        }
        this.extendParams = cVar.f51942f;
        this.shuoshuoPrivacy = cVar.f51944g;
        this.syncQQ = cVar.f51950l;
        this.syncWeibo = cVar.f51949k;
        this.fromKuolie = cVar.U;
        this.batchId = r7.a.a();
        this.photoQuality = cVar.f51956r;
        this.mPublishTime = cVar.f51957s;
        this.mDeleteTime = cVar.f51958t;
        this.priv = cVar.f51959u;
        this.privUinList = cVar.f51960v;
        this.extParam = cVar.f51961w;
        this.operationParams = cVar.f51963y;
        this.mPoiInfo = cVar.f51948j;
        this.selectedCountFromRecent = cVar.f51952n;
        this.shootParams = cVar.f51954p;
        Map<String, byte[]> b16 = cVar.b();
        this.protoExtendInfo = b16;
        this.protoExtendInfo = cVar.c(b16);
        this.richImageMap = cVar.f51947i;
        this.gifList = cVar.B;
        this.mEventTag = cVar.C;
        this.faceOperationMap = cVar.F;
        this.imagePanoramaMap = cVar.L;
        this.photoTagResult = cVar.G;
        this.subtype = cVar.H;
        this.isSyncToQQStory = cVar.J;
        this.qzoneVerticalVideoTopicInfo = cVar.K;
        this.isFromAIO = cVar.O;
        this.title = cVar.f51932a;
    }

    private boolean isNeedReplacePath(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        File file = new File(str);
        return !file.exists() || file.isDirectory();
    }

    private void onStepUploadDynamicResponse(QZoneTask qZoneTask) {
        if (qZoneTask.succeeded()) {
            QZLog.i(TAG, getStepDesc() + ", UploadDynamicSuccess, Finish");
            onSuccess();
            completeTask(this, true);
            updateFakeFeedResponse((QZPublishXUploadShuoShuoTask) qZoneTask);
        } else {
            QZLog.i(TAG, getStepDesc() + " fail, completeTask false");
            completeTask(this, false);
        }
        com.qzone.album.base.Service.e.e().s(false);
    }

    private void onStepUploadDynamicRun() {
        if (isDynamicTask()) {
            ArrayList arrayList = new ArrayList();
            List<DynamicPhotoData> list = this.dynamicPhotoDatas;
            if (list != null && list.size() > 0) {
                if (this.activePhotosMap == null) {
                    this.activePhotosMap = new HashMap();
                }
                for (DynamicPhotoData dynamicPhotoData : this.dynamicPhotoDatas) {
                    if (dynamicPhotoData != null) {
                        if (this.activePhotosMap.get(dynamicPhotoData) == null) {
                            if (!TextUtils.isEmpty(dynamicPhotoData.mAlbumid) && !TextUtils.isEmpty(dynamicPhotoData.mPhotoid)) {
                                this.activePhotosMap.put(dynamicPhotoData, new active_photo(dynamicPhotoData.mAlbumid, dynamicPhotoData.mPhotoid, dynamicPhotoData.mTitle, dynamicPhotoData.mDesc));
                            } else {
                                QZLog.w(TAG, "onStepUploadDynamicRun pass dynamicData on send DynamicRequest, url:" + dynamicPhotoData.mUrl);
                            }
                        }
                        if (this.activePhotosMap.get(dynamicPhotoData) != null) {
                            arrayList.add(this.activePhotosMap.get(dynamicPhotoData));
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                active_photo active_photoVar = (active_photo) arrayList.get(0);
                this.extendParams.put(QZoneJsConstants.DYNAMIC_ALBUM_COVER_AID, active_photoVar.albumid);
                this.extendParams.put(QZoneJsConstants.DYNAMIC_ALBUM_COVER_PIC, active_photoVar.photoid);
                this.extendParams.put("client_key", this.clientKey);
                this.extendParams.put(QZoneJsConstants.DYNAMIC_ALBUM_IS_PUBLIC_SHUOSHUO, "1");
                String h06 = u5.b.h0("key_dynamic_mgz_id", "null");
                if (!h06.equals("") && !h06.equals("null")) {
                    QZLog.i(TAG, 1, getStepDesc() + ", dynamicAlbum prePost succeed: start QZoneModifyDynamicRequest");
                    this.mRequest = new QZoneModifyDynamicRequest(h06, arrayList, this.extendParams, this.shuoshuoPrivacy, (long) arrayList.size());
                    if (!TextUtils.isEmpty(this.refer)) {
                        this.mRequest.setRefer(this.refer);
                    }
                } else {
                    QZLog.i(TAG, 1, getStepDesc() + ", dynamicAlbum prePost failed: start QZoneQueryDynamicRequest");
                    this.mRequest = new QZoneQueryDynamicRequest(arrayList, this.extendParams, this.shuoshuoPrivacy, (long) arrayList.size(), LoginData.getInstance().getUin());
                    if (!TextUtils.isEmpty(this.refer)) {
                        this.mRequest.setRefer(this.refer);
                    }
                }
            }
            u5.b.v0("key_dynamic_share_url", "null");
            u5.b.v0("key_dynamic_share_cover_url", "null");
            u5.b.v0("key_dynamic_client_ket", "null");
            u5.b.v0("key_dynamic_mgz_id", "null");
        }
    }

    private void onStepUploadMixVideoPicMoodRun() {
        if (this.mixAllimages == null) {
            QZLog.i(TAG, getStepDesc() + ", mixAllimages is null, break now");
            return;
        }
        byte[] uploadMoodBytes = getUploadMoodBytes(true);
        if (uploadMoodBytes == null) {
            QZLog.i(TAG, getStepDesc() + ", getMixUploadMoodBytes is null, break now");
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.mixAllimages) {
            if (!TextUtils.isEmpty(str)) {
                LocalImageInfo create = LocalImageInfo.create(str);
                if (create == null) {
                    if (URLUtil.isNetworkUrl(str)) {
                        create = new NetworkImageInfo();
                        create.setPath(str);
                    } else {
                        create = new LocalImageInfo();
                        create.setPath(str);
                    }
                }
                arrayList.add(UploadImageObject.createFromLocalImageInfo(create));
            } else {
                QZLog.e(TAG, getStepDesc() + ", create mixImageObjects error. image path null");
            }
        }
        QZLog.i(TAG, getStepDesc() + ", start mixMood request");
        QZoneUploadMoodRequest qZoneUploadMoodRequest = new QZoneUploadMoodRequest(4, this.batchId, null, this.photoQuality, uploadMoodBytes, arrayList, this.mIsMixTask);
        this.mRequest = qZoneUploadMoodRequest;
        qZoneUploadMoodRequest.setUploadQueueListener(this);
        if (!TextUtils.isEmpty(this.refer)) {
            this.mRequest.setRefer(this.refer);
        }
        com.qzone.publish.business.model.a aVar = this.mReportInfo;
        if (aVar != null) {
            aVar.f51011b = 2;
        }
    }

    private void onStepUploadMixVideoPicResponse(QZoneTask qZoneTask) {
        if (qZoneTask.succeeded()) {
            if (this.mMixBatchedMediaNum == 1) {
                this.step = 8;
                completeTask(this, true);
                updateFakeFeedResponse((QZPublishXUploadShuoShuoTask) qZoneTask);
                return;
            } else {
                this.step = 8;
                QZLog.i(TAG, "mixMood all request succeed, next " + getStepDesc());
                super.run();
                return;
            }
        }
        if (qZoneTask.mRequest != null) {
            completeTask(this, false);
        }
    }

    private void onStepUploadMixVideoPicRun() {
        QZLog.i(TAG, getStepDesc());
        if (this.mMixWaitintCompressVideoInfos.size() + this.mMixOrignalWaitingUploadVideo.size() == this.mMixVideoInfos.size()) {
            encodeGif();
        }
        checkRequestReentrant();
        com.qzone.publish.ui.model.a aVar = new com.qzone.publish.ui.model.a();
        aVar.C(4).A(this.refer).d(this.batchId).f(this.clientKey).F(this.uploadEntrance).H(h.d(this.batchId)).x(this.photoQuality).t(oo.b.i()).q(2002).O(getUploadMoodBytes(true)).g(isDynamicTask()).p(this.imagePanoramaMap).r(this.lbsInfo).o(this.mPoiInfo).m(this.isFromAIO);
        int i3 = this.mMixBatchedMediaNum;
        if (i3 == 1) {
            aVar.L(1);
        } else if (i3 > 1) {
            aVar.L(2);
        } else {
            aVar.L(0);
        }
        this.mRequest = new QzoneMediaUploadRequest(this.mMediaList, aVar, this, this);
    }

    private void onStepUploadMoodResponse(QZoneTask qZoneTask) {
        if (this.step == 8) {
            QZLog.i(TAG, "mixMood UploadMoodSuccess, success = " + qZoneTask.succeeded());
        }
        if (qZoneTask.succeeded()) {
            onSuccess();
            completeTask(this, true);
            updateFakeFeedResponse((QZPublishXUploadShuoShuoTask) qZoneTask);
        } else {
            QZLog.i(TAG, getStepDesc() + " fail, completeTask false");
            completeTask(this, false);
        }
    }

    private void onStepUploadPhotoWithMoodResponse(QZoneTask qZoneTask) {
        if (qZoneTask.succeeded()) {
            onSuccess();
            completeTask(this, true);
            updateFakeFeedResponse((QZPublishXUploadShuoShuoTask) qZoneTask);
            return;
        }
        completeTask(this, false);
    }

    private void onStepUploadTaskResponse(QZoneTask qZoneTask) {
        if (qZoneTask.mRequest instanceof QzoneMediaUploadRequest ? ((QzoneMediaUploadRequest) this.mRequest).needUploadMoodAsync() : false) {
            if (qZoneTask.succeeded()) {
                if (isDynamicTask()) {
                    this.step = 6;
                } else {
                    this.step = 5;
                }
                super.run();
                return;
            }
            completeTask(this, false);
            return;
        }
        if (qZoneTask.succeeded()) {
            this.step = 1;
            super.run();
        } else {
            completeTask(this, false);
        }
    }

    private void onStepUploadVideoResponse(QZoneTask qZoneTask) {
        if (qZoneTask.succeeded()) {
            this.step = 4;
            addReportInfo(this.mediaReportInfo);
            completeTask(this, true);
            QzoneVideoPerfReport.a(this.videoInfo.perfKey, 4).d(this.videoInfo.perfKey, LoginData.getInstance().getUin() + "");
            UploadVideoInfoRsp uploadVideoInfoRsp = (UploadVideoInfoRsp) qZoneTask.mUniAttr.get("response");
            if (uploadVideoInfoRsp != null) {
                if (!TextUtils.isEmpty(uploadVideoInfoRsp.sVid)) {
                    ShuoshuoVideoInfo shuoshuoVideoInfo = this.videoInfo;
                    if (shuoshuoVideoInfo.mVideoType == 0 && !com.qzone.publish.utils.c.e(shuoshuoVideoInfo.mVideoPath)) {
                        this.localUrlMap.put(uploadVideoInfoRsp.sVid, this.videoInfo.mVideoPath);
                        QZoneWriteOperationService v06 = QZoneWriteOperationService.v0();
                        String str = uploadVideoInfoRsp.sVid;
                        ShuoshuoVideoInfo shuoshuoVideoInfo2 = this.videoInfo;
                        v06.h2(str, shuoshuoVideoInfo2.mStartTime, shuoshuoVideoInfo2.mEndTime);
                    }
                }
                if (uploadVideoInfoRsp.iBusiNessType == 1) {
                    byte[] bArr = uploadVideoInfoRsp.vBusiNessData;
                    if (bArr != null) {
                        UniAttribute uniAttribute = new UniAttribute();
                        uniAttribute.setEncodeName("utf8");
                        uniAttribute.decode(bArr);
                        operation_publishmood_rsp operation_publishmood_rspVar = (operation_publishmood_rsp) uniAttribute.get("publishmood");
                        if (operation_publishmood_rspVar != null && operation_publishmood_rspVar.ret == 0) {
                            single_feed single_feedVar = (single_feed) uniAttribute.get(KEY_FAKE_SINGLE_FEED);
                            if (single_feedVar != null && !qZoneTask.mUniAttr.containsKey(KEY_FAKE_SINGLE_FEED)) {
                                qZoneTask.mUniAttr.put(KEY_FAKE_SINGLE_FEED, single_feedVar);
                            }
                            updateFakeFeedResponse((QZPublishXUploadShuoShuoTask) qZoneTask);
                            if (this.isTopic && !TextUtils.isEmpty(operation_publishmood_rspVar.tid)) {
                                Intent intent = new Intent(PeakConstants.ACTION_TOPIC_VIDEO_HALF_FAKE_FEED);
                                intent.putExtra(PeakConstants.KEY_TOPIC_VIDEO_PUBLISH_MSG, operation_publishmood_rspVar.f25020msg);
                                intent.putExtra(PeakConstants.KEY_TOPIC_VIDEO_TID, operation_publishmood_rspVar.tid);
                                intent.putExtra(PeakConstants.KEY_TOPIC_VIDEO_CLIENTKEY, this.clientKey);
                                BaseApplication.getContext().sendBroadcast(intent);
                            }
                        }
                    }
                    onSuccess();
                    return;
                }
                QZLog.i(TAG, "video shuoshuo upload fail,must manual operation");
                this.step = 1;
                super.run();
                return;
            }
            return;
        }
        if (qZoneTask.mResultCode == 1000004) {
            QZLog.i(TAG, getStepDesc() + ", video handle ing");
            return;
        }
        QZLog.i(TAG, getStepDesc() + " fail, completeTask false");
        completeTask(this, false);
    }

    private void onStepVideoUploadSuccessRun() {
        if (isVideoTask()) {
            ShuoshuoVideoInfo shuoshuoVideoInfo = this.videoInfo;
            this.mRequest = new QZoneVideoShuoshuoUploadFinishRequest((int) shuoshuoVideoInfo.mSize, (int) shuoshuoVideoInfo.mDuration, this.clientKey);
            if (TextUtils.isEmpty(this.refer)) {
                return;
            }
            this.mRequest.setRefer(this.refer);
        }
    }

    private void onStepWriteContentResponse(QZoneTask qZoneTask) {
        if (qZoneTask.succeeded()) {
            onSuccess();
            completeTask(this, true);
            updateFakeFeedResponse((QZPublishXUploadShuoShuoTask) qZoneTask);
            return;
        }
        if (qZoneTask.mResultCode == -11258) {
            String string = BaseApplication.getContext().getString(R.string.gld);
            QZLog.i(TAG, getStepDesc() + ", resultCode:" + qZoneTask.mResultCode + ", " + string);
            ToastUtil.r(string);
            completeTask(this, true);
            updateFakeFeedResponse((QZPublishXUploadShuoShuoTask) qZoneTask);
            return;
        }
        QZLog.i(TAG, getStepDesc() + " fail, completeTask false");
        completeTask(this, false);
    }

    private void onSuccess() {
        long j3 = this.mPublishTime;
        if (j3 <= 0 || j3 <= System.currentTimeMillis() / 1000) {
            return;
        }
        ToastUtil.r(BaseApplication.getContext().getString(R.string.glx));
        EventCenter.getInstance().post("Feed", 35, (Object[]) null);
    }

    private static void updateFakeFeedResponse(QZPublishXUploadShuoShuoTask qZPublishXUploadShuoShuoTask) {
        try {
            if (com.qzone.reborn.feedpro.utils.d.f54318a.b()) {
                le.b.f414397d.f(qZPublishXUploadShuoShuoTask.mResultCode == 0, qZPublishXUploadShuoShuoTask.clientKey, null);
            } else {
                i.f414345a.q(qZPublishXUploadShuoShuoTask);
            }
        } catch (Exception e16) {
            xe.b.f447841a.d(e16);
        }
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public boolean cancel() {
        QZLog.i(TAG, getStepDesc() + "cancel task");
        QZoneRequest qZoneRequest = this.mRequest;
        if (qZoneRequest == null || !(qZoneRequest instanceof QzoneMediaUploadRequest)) {
            return true;
        }
        return ((QzoneMediaUploadRequest) qZoneRequest).cancel();
    }

    protected void checkRequestReentrant() {
        QZoneRequest qZoneRequest = this.mRequest;
        if (qZoneRequest == null || !(qZoneRequest instanceof QzoneMediaUploadRequest)) {
            return;
        }
        ((QzoneMediaUploadRequest) qZoneRequest).cancel();
        this.batchId = r7.a.a();
        if (getSuccessCount() > 0) {
            this.mediaUploadSuccessIndexList.clear();
        }
        QZLog.w(TAG, getStepDesc() + ", checkRequestReentrant, cancel old request, reGenerateBatchId:" + this.batchId);
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

    public void clearExtraData() {
        HashMap<String, PicInfo> hashMap = this.richImageMap;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    protected void completeTask(IQueueTask iQueueTask, boolean z16) {
        getPublishQueue().g(iQueueTask, z16);
    }

    protected void encodeGif() {
        ArrayList<GifInfo> arrayList = this.gifList;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        for (int i3 = 0; i3 < this.gifList.size(); i3++) {
            if (this.images.contains(this.gifList.get(i3).mCombineImagePath) && this.gifList.get(i3).mDestPath != null) {
                QZLog.d(TAG, 2, "encodeGif, mDestPath has exist !! mDestPath:" + this.gifList.get(i3).mDestPath);
                if (new File(this.gifList.get(i3).mDestPath).exists()) {
                    int indexOf = this.images.indexOf(this.gifList.get(i3).mCombineImagePath);
                    if (QZLog.isColorLevel()) {
                        QZLog.d(TAG, 2, "encodeGif, index:" + indexOf);
                    }
                    this.images.remove(this.gifList.get(i3).mCombineImagePath);
                    this.images.add(indexOf, this.gifList.get(i3).mDestPath);
                    HashMap<String, Integer> hashMap = this.flowIdMap;
                    if (hashMap != null) {
                        hashMap.remove(this.gifList.get(i3).mCombineImagePath);
                        this.flowIdMap.put(this.gifList.get(i3).mDestPath, Integer.valueOf(subFlowId((int) this.batchId, this.gifList.get(i3).mDestPath)));
                    }
                }
            } else if (this.images.contains(this.gifList.get(i3).mCombineImagePath)) {
                if (this.gifList.get(i3).isBaseGif) {
                    compressGif(this.gifList.get(i3));
                } else {
                    compressListToGif(this.gifList.get(i3));
                }
            }
        }
    }

    public String getAudioSummary() {
        if (isTemplateShuoshuo()) {
            return this.content;
        }
        return "";
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    /* renamed from: getCacheKey */
    public String getCommentUniKey() {
        return this.clientKey;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public String getCaseId() {
        return LoginData.getInstance().getUinString();
    }

    public String getContent() {
        return this.content;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public List<String> getEditMissionId() {
        return QZWinkEditDraftUtil.h(this.mMediaList);
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public int getExactType() {
        return 1;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    public long getFakeSize() {
        return getLeaveFakeSize();
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    public List<String> getImageUrls() {
        return this.images;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public com.qzone.publish.business.task.c getInfo() {
        String str;
        com.qzone.publish.business.task.c info = super.getInfo();
        String str2 = this.content;
        if (str2 != null && str2.length() > 320) {
            str = this.content.substring(0, 320);
        } else {
            str = this.content;
        }
        if (this.syncQQ && !TextUtils.isEmpty(str) && str.startsWith("qm")) {
            str = str.substring(2);
        }
        if (this.isVideoToGif) {
            info.f51185a = this.uploadDynamicPic + str;
        } else if (this.isFromVideoSign) {
            info.f51185a = this.publishSignMood + str;
        } else if (this.mIsMixTask) {
            info.f51185a = this.publishMood + str;
        } else if (isVideoTask()) {
            info.f51185a = this.publishVideo + str;
        } else {
            info.f51185a = this.publishMood + str;
        }
        if (getState() == 1) {
            long j3 = this.mRecvDataSize;
            if (j3 > 0) {
                long j16 = this.mTotalSize;
                if (j16 > 0) {
                    info.f51190f = Math.max((int) ((j3 * 100) / j16), 1);
                    if (this.curImageIndex >= 0 && getTotalImgCount() > 0) {
                        info.f51186b = this.mRecvDataSize + "k/" + this.mTotalSize + "k";
                    } else if (isVideoTask()) {
                        info.f51186b = this.uploadVideo + this.mRecvDataSize + "/" + this.mTotalSize + "k";
                    }
                }
            }
            if (!this.mIsMixTask && !isVideoTask()) {
                if (getTotalImgCount() == 0 || this.curImageIndex == getTotalImgCount()) {
                    info.f51186b = this.publishing;
                }
            } else {
                QZoneRequest qZoneRequest = this.mRequest;
                if (qZoneRequest instanceof QzoneMediaUploadRequest) {
                    info = ((QzoneMediaUploadRequest) qZoneRequest).getInfo(info);
                }
            }
        }
        int totalImgCount = getTotalImgCount();
        int successCount = getSuccessCount();
        if (successCount >= 0 && totalImgCount > successCount) {
            info.f51194j = totalImgCount - successCount;
            if (TextUtils.isEmpty(info.f51192h)) {
                String str3 = getImageUrls().get(successCount);
                info.f51192h = str3;
                if (!TextUtils.isEmpty(str3)) {
                    if (com.qzone.publish.utils.c.c(info.f51192h) == 1) {
                        info.f51193i = true;
                    }
                    File file = new File(info.f51192h);
                    if (file.exists() && file.isDirectory() && isVideoTask()) {
                        info.f51192h = getVideoCoverUrl();
                    }
                }
            }
        } else if (isVideoTask()) {
            info.f51192h = getVideoCoverUrl();
            if (!this.isVideoToGif) {
                info.f51193i = true;
            }
            info.f51194j = 1;
        }
        return info;
    }

    public long getLeaveFakeSize() {
        if (isVideoTask()) {
            ShuoshuoVideoInfo shuoshuoVideoInfo = this.videoInfo;
            double d16 = shuoshuoVideoInfo.mEstimateSize;
            return d16 > 0.0d ? (long) d16 : shuoshuoVideoInfo.mSize;
        }
        List<String> list = this.images;
        long j3 = 0;
        if (list != null && list.size() > 0) {
            int i3 = 0;
            for (String str : this.images) {
                if (i3 > this.curImageIndex - 1) {
                    j3 = ((float) j3) + com.qzone.util.image.c.y(str, this.photoQuality);
                }
                i3++;
            }
        }
        return j3;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public long getLeaveSize() {
        if (this.mIsMixTask) {
            return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PUBLISH_QUEUE_LEAVE_WIFI_CHECK_SIZE, 10) * 1024 * 1024;
        }
        if (!isVideoTask()) {
            return 0 + ((this.mTotalSize * 1024) - (this.mRecvDataSize * 1024)) + getFakeSize();
        }
        return 0 + super.getLeaveSize();
    }

    public Map<String, String> getLocalUrlMap() {
        return this.localUrlMap;
    }

    public List<MediaWrapper> getMediaList() {
        return this.mMediaList;
    }

    public LbsDataV2.PoiInfo getPoiInfo() {
        return this.mPoiInfo;
    }

    protected String getStepDesc() {
        String str = "id:" + getTaskId() + ", fakeKey:" + getCommentUniKey();
        switch (this.step) {
            case 0:
                return str + l.a(R.string.s_1);
            case 1:
                return str + ", step: STEP_WRITE_CONTENT_\u53d1\u8868\u6587\u5b57";
            case 2:
                return str + ", step: STEP_UPLOAD_VIDEO_\u53d1\u8868\u89c6\u9891";
            case 3:
                return str + l.a(R.string.s_j);
            case 4:
                return str + ", step: STEP_VIDEO_UPLOAD_SUCCESS_\u89c6\u9891\u53d1\u9001\u6210\u529f\u540e\u5411server\u4e0a\u62a5";
            case 5:
                return str + ", step: STEP_UPLOAD_MOOD_TASK";
            case 6:
                return str + ", step: STEP_UPLOAD_DYNAMIC_TASK_\u52a8\u611f\u5f71\u96c6";
            case 7:
                return str + ", step: STEP_UPLOAD_MIX_VIDEO_PIC_TASK_\u6df7\u4f20_\u6587\u4ef6\u4e0a\u4f20";
            case 8:
                return str + ", step: STEP_UPLOAD_MIX_VIDEO_PIC_MOOD_TAS_\u6df7\u4f20_\u8bf4\u8bf4\u53d1\u8868";
            default:
                return getCommentUniKey() + ", step: unknown step";
        }
    }

    public int getTotalImgCount() {
        List<String> list = this.images;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public String getVideoCoverUrl() {
        if (isVideoTask()) {
            return this.videoInfo.mCoverUrl;
        }
        return null;
    }

    public ShuoshuoVideoInfo getVideoInfo() {
        return this.videoInfo;
    }

    protected void initStep() {
        if (this.mIsMixTask) {
            this.step = 7;
        } else if (isImageTask()) {
            initImageStep();
        } else if (isDynamicTask()) {
            this.step = 0;
        } else if (isVideoTask()) {
            this.step = 2;
        } else {
            ArrayList<Pair<Integer, PicInfo>> arrayList = this.richImageList;
            if (arrayList != null && arrayList.size() > 0) {
                this.step = 1;
                this.mediaType = 1;
            } else {
                this.step = 1;
                this.mediaType = 0;
            }
        }
        QZLog.i(TAG, "initStep, " + getStepDesc());
    }

    public boolean isDynamicTask() {
        return this.dynamicPhotoDatas != null;
    }

    public boolean isImageTask() {
        List<String> list = this.images;
        return list != null && list.size() > 0;
    }

    public boolean isMixVideoPicTask() {
        List<ShuoshuoVideoInfo> list = this.mMixVideoInfos;
        return list != null && list.size() >= 1;
    }

    public boolean isTemplateShuoshuo() {
        return !TextUtils.isEmpty(this.mvTemplateShuoshuo) && this.mvTemplateShuoshuo.equals("1");
    }

    public boolean isUploadMoodStep() {
        return this.step == 3 || this.step == 5 || this.step == 8;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public boolean isVideoTask() {
        return this.videoInfo != null;
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
        checkVideoFilePath(str2, i3);
        if (this.step == 2 && this.isVideoToGif) {
            if (this.images == null) {
                this.images = new ArrayList();
            }
            this.images.add(str2);
            this.step = 3;
        }
        notifyProgress(this);
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadFailed(int i3, int i16, String str) {
        QZLog.w(TAG, "onMediaUploadFailed mediaIndex:" + i3 + ", errCode:" + i16 + ", errMsg:" + str);
        notifyProgress(this);
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadReport(a.C0436a c0436a) {
        addReportInfo(c0436a);
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public void onRemove() {
        super.onRemove();
        clearExtraData();
        cancel();
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public void onRestore() {
        super.onRestore();
        this.isRestoreFromCache = true;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public void onResume() {
        super.onResume();
        if (this.isRestoreFromCache) {
            this.batchId = r7.a.a();
            this.isRestoreFromCache = false;
        }
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    public void onRun() {
        QZLog.i(TAG, getStepDesc() + ", onRun batchId:" + this.batchId);
        com.qzone.publish.business.model.a aVar = this.mReportInfo;
        if (aVar != null && (aVar.f51012c == 0 || aVar.f51014e < this.retryNum)) {
            com.qzone.publish.business.model.a aVar2 = new com.qzone.publish.business.model.a();
            this.mReportInfo = aVar2;
            aVar2.f51010a = 1;
            aVar2.f51012c = System.currentTimeMillis();
            this.mReportInfo.f51014e = this.retryNum;
        }
        switch (this.step) {
            case 0:
            case 3:
                onStepUploadPhotoWithMoodRun();
                return;
            case 1:
                onStepWriteContentRun();
                return;
            case 2:
                onStepUploadVideoRun();
                return;
            case 4:
                onStepVideoUploadSuccessRun();
                return;
            case 5:
                onStepUploadMoodRun();
                return;
            case 6:
                onStepUploadDynamicRun();
                return;
            case 7:
                onStepUploadMixVideoPicRun();
                return;
            case 8:
                onStepUploadMixVideoPicMoodRun();
                return;
            default:
                return;
        }
    }

    protected void onStepUploadPhotoWithMoodRun() {
        encodeGif();
        List<String> list = this.images;
        if (list != null && list.size() != 0) {
            QZLog.i(TAG, getStepDesc() + ", -- curImageIndex:" + this.curImageIndex);
            checkRequestReentrant();
            long d16 = h.d(this.batchId);
            if (d16 == 0) {
                d16 = NetConnInfoCenter.getServerTimeMillis() / 1000;
                h.i(this.batchId, d16);
            }
            com.qzone.publish.ui.model.a aVar = new com.qzone.publish.ui.model.a();
            aVar.C(4).A(this.refer).d(this.batchId).f(this.clientKey).F(this.uploadEntrance).H(d16).x(this.photoQuality).t(getWaterMark()).O(getUploadMoodBytes(false)).g(isDynamicTask()).p(this.imagePanoramaMap).k(this.faceOperationMap).w(this.photoTagResult);
            ArrayList<Pair<Integer, PicInfo>> arrayList = this.richImageList;
            boolean z16 = arrayList != null && arrayList.size() > 0;
            int i3 = this.mMixBatchedMediaNum;
            if (i3 > 0 && z16) {
                aVar.L(2);
            } else if (i3 == 1 && !z16) {
                aVar.L(1);
            } else if (i3 > 1 && !z16) {
                aVar.L(2);
            } else {
                aVar.L(0);
            }
            this.mRequest = new QzoneMediaUploadRequest(com.qzone.publish.utils.c.h(this.images), aVar, this, this);
            com.qzone.publish.business.model.a aVar2 = this.mReportInfo;
            if (aVar2 != null) {
                aVar2.f51011b = 1;
                return;
            }
            return;
        }
        if (isDynamicTask()) {
            this.step = 6;
            onRun();
        }
    }

    protected void onStepUploadVideoRun() {
        String str;
        byte[] uploadMoodBytes4RecordVideo;
        if (isVideoTask()) {
            if (this.mediaReportInfo == null) {
                a.C0436a c0436a = new a.C0436a(2, this.videoInfo.mVideoPath);
                this.mediaReportInfo = c0436a;
                c0436a.f51028c = this.videoInfo.mSize / 1024;
            }
            if (this.localUrlMap == null) {
                this.localUrlMap = new HashMap();
            }
            this.localUrlMap.put(this.clientKey, this.videoInfo.mVideoPath);
            j.b().d(getCommentUniKey(), m.f414350a.h(this.videoInfo));
            com.qzone.publish.business.model.a aVar = this.mReportInfo;
            if (aVar != null) {
                aVar.f51011b = 3;
            }
            int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_UPLOAD, QzoneConfig.SECONDARY_UPLOAD_RECORD_VIDEO_WITH_MIX_MODE, 1);
            if (!this.isMakeVideo && config == 1) {
                if (this.mMediaList == null) {
                    this.mMediaList = new ArrayList();
                }
                ShuoshuoVideoInfo shuoshuoVideoInfo = this.videoInfo;
                shuoshuoVideoInfo.mDesc = this.content;
                this.mMediaList.add(new MediaWrapper(shuoshuoVideoInfo, shuoshuoVideoInfo.mNeedProcess, this.isVideoToGif));
                this.mMixBatchedMediaNum = this.mMediaList.size();
                if (this.images == null) {
                    this.images = new ArrayList();
                }
                this.images.add(this.videoInfo.mVideoPath);
                if (this.mixAllimages == null) {
                    this.mixAllimages = new ArrayList();
                }
                this.mixAllimages.add(this.videoInfo.mVideoPath);
                this.step = 7;
                QZLog.i(TAG, getStepDesc() + ", onStepUploadVideoRun, upload video with MixMode, batchId:" + this.batchId + "\uff0c videoPath:" + this.videoInfo.mVideoPath);
                onStepUploadMixVideoPicRun();
                return;
            }
            checkRequestReentrant();
            if (this.isVideoToGif) {
                this.mediaType = 1;
            }
            com.qzone.publish.ui.model.a aVar2 = new com.qzone.publish.ui.model.a();
            com.qzone.publish.ui.model.a A = aVar2.C(4).A(this.refer);
            if (this.isVideoToGif) {
                str = this.refer;
            } else {
                str = "video_shuoshuo";
            }
            com.qzone.publish.ui.model.a L = A.e(str).d(this.batchId).F(this.uploadEntrance).L(1);
            if (this.isVideoToGif) {
                uploadMoodBytes4RecordVideo = getUploadMoodBytes(false);
            } else {
                uploadMoodBytes4RecordVideo = getUploadMoodBytes4RecordVideo();
            }
            L.O(uploadMoodBytes4RecordVideo).l(true).J(false).m(this.isFromAIO);
            if (this.isMakeVideo) {
                aVar2.J(true).E(true);
            }
            this.mMediaList = new ArrayList();
            ShuoshuoVideoInfo shuoshuoVideoInfo2 = this.videoInfo;
            shuoshuoVideoInfo2.mDesc = this.content;
            this.mMediaList.add(new MediaWrapper(shuoshuoVideoInfo2, shuoshuoVideoInfo2.mNeedProcess, this.isVideoToGif));
            this.mRequest = new QzoneMediaUploadRequest(this.mMediaList, aVar2, this, this);
        }
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        QZLog.i(TAG, getStepDesc() + " onTaskResponse succeed:" + qZoneTask.succeeded() + ", batchId:" + this.batchId);
        switch (this.step) {
            case 0:
                onStepUploadTaskResponse(qZoneTask);
                return;
            case 1:
                onStepWriteContentResponse(qZoneTask);
                return;
            case 2:
                onStepUploadVideoResponse(qZoneTask);
                return;
            case 3:
                onStepUploadPhotoWithMoodResponse(qZoneTask);
                return;
            case 4:
                QZLog.i(TAG, getStepDesc() + ", video upload success");
                return;
            case 5:
            case 8:
                onStepUploadMoodResponse(qZoneTask);
                return;
            case 6:
                onStepUploadDynamicResponse(qZoneTask);
                return;
            case 7:
                onStepUploadMixVideoPicResponse(qZoneTask);
                return;
            default:
                return;
        }
    }

    public void setCurrentImageIndex(int i3) {
        this.curImageIndex = i3;
    }

    public void setLocalUrlMap(Map<String, String> map) {
        this.localUrlMap = map;
    }

    private void onStepUploadMoodRun() {
        byte[] uploadMoodBytes = getUploadMoodBytes(false);
        if (uploadMoodBytes == null) {
            return;
        }
        ArrayList<Pair<Integer, PicInfo>> arrayList = this.richImageList;
        if (arrayList != null && arrayList.size() > 0) {
            if (this.images == null) {
                this.images = new ArrayList();
            }
            for (int i3 = 0; i3 < this.richImageList.size(); i3++) {
                Pair<Integer, PicInfo> pair = this.richImageList.get(i3);
                if (pair.first.intValue() >= 0 && pair.second != null) {
                    this.images.add(pair.first.intValue(), pair.second.pic_url);
                }
            }
            this.richImageList.clear();
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str : this.images) {
            LocalImageInfo create = LocalImageInfo.create(str);
            if (create == null && URLUtil.isNetworkUrl(str)) {
                create = new NetworkImageInfo();
                create.setPath(str);
            }
            arrayList2.add(UploadImageObject.createFromLocalImageInfo(create));
        }
        QZoneUploadMoodRequest qZoneUploadMoodRequest = new QZoneUploadMoodRequest(4, this.batchId, null, this.photoQuality, uploadMoodBytes, arrayList2, this.mIsMixTask);
        this.mRequest = qZoneUploadMoodRequest;
        qZoneUploadMoodRequest.setUploadQueueListener(this);
        if (TextUtils.isEmpty(this.refer)) {
            return;
        }
        this.mRequest.setRefer(this.refer);
    }

    private void onStepWriteContentRun() {
        ArrayList<Pair<Integer, PicInfo>> arrayList = this.richImageList;
        if (arrayList != null && arrayList.size() > 0) {
            if (this.images == null) {
                this.images = new ArrayList();
            }
            for (int i3 = 0; i3 < this.richImageList.size(); i3++) {
                Pair<Integer, PicInfo> pair = this.richImageList.get(i3);
                MediaInfo mediaInfo = this.mediaInfo;
                if (mediaInfo.picinfolist == null) {
                    mediaInfo.picinfolist = new ArrayList<>();
                }
                if (pair.second != null) {
                    if (pair.first.intValue() > this.mediaInfo.picinfolist.size()) {
                        this.mediaInfo.picinfolist.add(pair.second);
                    } else {
                        this.mediaInfo.picinfolist.add(pair.first.intValue(), pair.second);
                    }
                    this.images.add(pair.second.pic_url);
                }
            }
            this.richImageList.clear();
        }
        if (this.storedExtendInfo == null) {
            this.storedExtendInfo = new HashMap();
        }
        fullEventTagParams(this.mEventTag, this.storedExtendInfo);
        if (!TextUtils.isEmpty(this.mvTemplateShuoshuo)) {
            this.storedExtendInfo.put(QZonePublishMoodRequest.EXT_INFO_KEY_TEMPLATE_SHUOSHUO, this.mvTemplateShuoshuo);
        }
        if (!TextUtils.isEmpty(this.syncToFriendInfo)) {
            this.storedExtendInfo.put(QZonePublishMoodRequest.EXT_INFO_KEY_SYNC_TO_FRIEND, this.syncToFriendInfo);
        }
        if (!TextUtils.isEmpty(this.syncToKuolie)) {
            this.storedExtendInfo.put(QZonePublishMoodRequest.EXT_INFO_KEY_ISKUOLIE, this.syncToKuolie);
        }
        if (!TextUtils.isEmpty(this.kuolieCampus)) {
            this.storedExtendInfo.put(QZonePublishMoodRequest.EXT_INFO_KEY_KUOLIE_CAMPUS, this.kuolieCampus);
        }
        this.mRequest = new QZonePublishMoodRequest(u.c(this.content), true, this.syncWeibo, this.syncWeiboImageUrl, this.mediaType, this.mediaInfo, this.lbsInfo, new Source(this.subtype, 4), this.clientKey, this.selectedCountFromRecent, this.mPublishTime, this.priv, this.privUinList, this.shootParams, this.protoExtendInfo, this.extParam, this.operationParams, this.hiddenPoi, this.storedExtendInfo);
        if (TextUtils.isEmpty(this.refer)) {
            return;
        }
        this.mRequest.setRefer(this.refer);
    }

    public void checkVideoFilePath(String str, int i3) {
        VideoInfo a16;
        VideoUrl videoUrl;
        if (str == null || str.length() == 0) {
            return;
        }
        File file = new File(str);
        if (!file.exists() || file.isDirectory()) {
            return;
        }
        List<String> list = this.mixAllimages;
        if (list != null && list.size() > i3) {
            File file2 = new File(this.mixAllimages.get(i3));
            if (!file2.exists() || file2.isDirectory()) {
                this.mixAllimages.set(i3, str);
            }
        }
        if (!isVideoTask() || (a16 = j.b().a(getCommentUniKey())) == null || (videoUrl = a16.videoUrl) == null) {
            return;
        }
        videoUrl.url = str;
    }

    public byte[] getUploadMoodBytes(boolean z16) {
        MediaInfo mediaInfo = new MediaInfo();
        mediaInfo.picinfolist = new ArrayList<>();
        if (this.storedExtendInfo == null) {
            this.storedExtendInfo = new HashMap();
        }
        fullEventTagParams(this.mEventTag, this.storedExtendInfo);
        if (!TextUtils.isEmpty(this.syncToFriendInfo)) {
            this.storedExtendInfo.put(QZonePublishMoodRequest.EXT_INFO_KEY_SYNC_TO_FRIEND, this.syncToFriendInfo);
        }
        if (!TextUtils.isEmpty(this.syncToKuolie)) {
            this.storedExtendInfo.put(QZonePublishMoodRequest.EXT_INFO_KEY_ISKUOLIE, this.syncToKuolie);
        }
        if (!TextUtils.isEmpty(this.kuolieCampus)) {
            this.storedExtendInfo.put(QZonePublishMoodRequest.EXT_INFO_KEY_KUOLIE_CAMPUS, this.kuolieCampus);
        }
        QzoneVerticalVideoTopicInfo qzoneVerticalVideoTopicInfo = this.qzoneVerticalVideoTopicInfo;
        if (qzoneVerticalVideoTopicInfo != null && !TextUtils.isEmpty(qzoneVerticalVideoTopicInfo.toJSONString())) {
            this.storedExtendInfo.put(QZonePublishMoodRequest.EXT_INFO_KEY_TOPOC, this.qzoneVerticalVideoTopicInfo.toJSONString());
        }
        QZonePublishMoodRequest qZonePublishMoodRequest = new QZonePublishMoodRequest(this.content, true, this.syncWeibo, this.syncWeiboImageUrl, this.mediaType, this.mediaInfo, this.lbsInfo, new Source(this.subtype, 4, 1), this.clientKey, this.selectedCountFromRecent, this.mPublishTime, this.priv, this.privUinList, this.shootParams, this.protoExtendInfo, this.extParam, this.operationParams, this.hiddenPoi, this.storedExtendInfo);
        if (!TextUtils.isEmpty(this.refer)) {
            qZonePublishMoodRequest.setRefer(this.refer);
        }
        operation_publishmood_req operation_publishmood_reqVar = (operation_publishmood_req) qZonePublishMoodRequest.req;
        if (operation_publishmood_reqVar != null) {
            if (z16) {
                if (operation_publishmood_reqVar.extend_info == null) {
                    operation_publishmood_reqVar.extend_info = new HashMap();
                }
                operation_publishmood_reqVar.extend_info.put("has_video", "1");
                operation_publishmood_reqVar.mediatype = 1;
                operation_publishmood_reqVar.mediabittype = 1;
            }
            if (this.isSyncToQQStory) {
                if (operation_publishmood_reqVar.extend_info == null) {
                    operation_publishmood_reqVar.extend_info = new HashMap();
                }
                operation_publishmood_reqVar.extend_info.put(QZonePublishMoodRequest.EXT_INFO_KEY_IS_SYNC_TO_QQSTORY, "1");
            }
        }
        UniAttribute uniAttribute = new UniAttribute();
        uniAttribute.setEncodeName("utf8");
        uniAttribute.put("hostuin", Long.valueOf(LoginData.getInstance().getUin()));
        if (!TextUtils.isEmpty(this.refer)) {
            uniAttribute.put("refer", this.refer);
        }
        if (operation_publishmood_reqVar != null) {
            operation_publishmood_reqVar.mediainfo = mediaInfo;
            try {
                uniAttribute.put("publishmood", operation_publishmood_reqVar);
            } catch (Throwable th5) {
                QZLog.e(TAG, getStepDesc() + ", getUploadMoodBytes", th5);
                return null;
            }
        }
        return uniAttribute.encode();
    }

    protected byte[] getUploadMoodBytes4RecordVideo() {
        String str;
        if (this.shootParams == null) {
            this.shootParams = new HashMap();
        }
        if (!TextUtils.isEmpty(this.videoInfo.topicId)) {
            this.isTopic = true;
            this.shootParams.put("tid", this.videoInfo.topicId);
            if (this.videoInfo.topicSyncQzone) {
                this.shootParams.put("sync", "qzone");
            }
        }
        Map<String, String> map = this.shootParams;
        String str2 = "0";
        if (!this.videoInfo.mIsUploadOrigin) {
            str = "0";
        } else {
            str = "1";
        }
        map.put(QZonePublishMoodRequest.EXT_INFO_KEY_IS_ORIGIN_VIDEO, str);
        QZLog.i(TAG, getStepDesc() + ", video has been compressed by client : " + this.videoInfo.mHasCompressed);
        int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_CLIENT_COMPRESS, 1);
        QZLog.i(TAG, getStepDesc() + ", WNS Config [force server reCompress to F20]: need client compress:" + config);
        if (config == 0) {
            this.videoInfo.mHasCompressed = false;
        }
        Map<String, String> map2 = this.shootParams;
        if (this.videoInfo.mHasCompressed) {
            str2 = "1";
        }
        map2.put(QZonePublishMoodRequest.EXT_INFO_KEY_IS_FORMAT_F20, str2);
        this.shootParams.put(QZonePublishMoodRequest.EXT_INFO_KEY_VIDEO_SIZE, String.valueOf(this.videoInfo.mSize));
        if (this.storedExtendInfo == null) {
            this.storedExtendInfo = new HashMap();
        }
        fullEventTagParams(this.mEventTag, this.storedExtendInfo);
        if (!TextUtils.isEmpty(this.syncToFriendInfo)) {
            this.storedExtendInfo.put(QZonePublishMoodRequest.EXT_INFO_KEY_SYNC_TO_FRIEND, this.syncToFriendInfo);
        }
        if (!TextUtils.isEmpty(this.syncToKuolie)) {
            this.storedExtendInfo.put(QZonePublishMoodRequest.EXT_INFO_KEY_ISKUOLIE, this.syncToKuolie);
        }
        if (!TextUtils.isEmpty(this.kuolieCampus)) {
            this.storedExtendInfo.put(QZonePublishMoodRequest.EXT_INFO_KEY_KUOLIE_CAMPUS, this.kuolieCampus);
        }
        QzoneVerticalVideoTopicInfo qzoneVerticalVideoTopicInfo = this.qzoneVerticalVideoTopicInfo;
        if (qzoneVerticalVideoTopicInfo != null && !TextUtils.isEmpty(qzoneVerticalVideoTopicInfo.toJSONString())) {
            this.storedExtendInfo.put(QZonePublishMoodRequest.EXT_INFO_KEY_TOPOC, this.qzoneVerticalVideoTopicInfo.toJSONString());
        }
        if (this.isSyncToQQStory) {
            this.shootParams.put(QZonePublishMoodRequest.EXT_INFO_KEY_IS_SYNC_TO_QQSTORY, "1");
        }
        QZonePublishMoodRequest qZonePublishMoodRequest = new QZonePublishMoodRequest(this.content, true, this.syncWeibo, this.syncWeiboImageUrl, this.mediaType, this.mediaInfo, this.lbsInfo, new Source(this.subtype, 4, 1), this.clientKey, this.selectedCountFromRecent, this.mPublishTime, this.priv, this.privUinList, this.shootParams, this.protoExtendInfo, this.extParam, this.storedExtendInfo);
        if (!TextUtils.isEmpty(this.refer)) {
            qZonePublishMoodRequest.setRefer(this.refer);
        }
        operation_publishmood_req operation_publishmood_reqVar = (operation_publishmood_req) qZonePublishMoodRequest.req;
        operation_publishmood_reqVar.mediainfo = null;
        UniAttribute uniAttribute = new UniAttribute();
        uniAttribute.setEncodeName("utf8");
        uniAttribute.put("hostuin", Long.valueOf(LoginData.getInstance().getUin()));
        uniAttribute.put("publishmood", operation_publishmood_reqVar);
        if (!TextUtils.isEmpty(this.refer)) {
            uniAttribute.put("refer", this.refer);
        }
        return uniAttribute.encode();
    }

    protected void initMixPicVideoInfos(List<MediaWrapper> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.mMediaList = list;
        this.images = new ArrayList();
        this.mixAllimages = new ArrayList();
        this.richImageList = new ArrayList<>();
        this.mMixVideoInfos = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            MediaWrapper mediaWrapper = list.get(i3);
            if (mediaWrapper.isImage()) {
                this.mMixBatchedMediaNum++;
                String str = mediaWrapper.getImageInfo().mPath;
                if (!str.startsWith("http://") && !str.startsWith("https://")) {
                    this.images.add(str);
                } else {
                    HashMap<String, PicInfo> hashMap = this.richImageMap;
                    PicInfo picInfo = hashMap != null ? hashMap.get(str) : null;
                    if (picInfo != null) {
                        this.richImageList.add(new Pair<>(Integer.valueOf(i3), picInfo));
                    }
                }
                this.mixAllimages.add(str);
            } else if (mediaWrapper.isVideo()) {
                this.mMixBatchedMediaNum++;
                this.images.add(mediaWrapper.getVideoInfo().mVideoPath);
                this.mixAllimages.add(mediaWrapper.getVideoInfo().mVideoPath);
                this.mMixVideoInfos.add(mediaWrapper.getVideoInfo());
                this.mMixOrgVideoPaths.put(Integer.valueOf(i3), mediaWrapper.getVideoInfo().mVideoPath);
                if (mediaWrapper.getVideoInfo() != null && mediaWrapper.getVideoInfo().mNeedProcess) {
                    this.mMixWaitintCompressVideoInfos.add(mediaWrapper.getVideoInfo());
                } else if (mediaWrapper.getVideoInfo() != null) {
                    this.mMixOrignalWaitingUploadVideo.add(mediaWrapper.getVideoInfo());
                }
                if (this.videoInfo == null) {
                    this.videoInfo = mediaWrapper.getVideoInfo();
                }
            }
        }
    }

    private void initImageInfo(List<String> list) {
        if (list == null) {
            return;
        }
        this.images = new ArrayList();
        this.richImageList = new ArrayList<>();
        this.mMediaList = new ArrayList();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            String str = list.get(i3);
            if (!TextUtils.isEmpty(str)) {
                if (!str.startsWith("http://") && !str.startsWith("https://")) {
                    this.images.add(list.get(i3));
                } else {
                    HashMap<String, PicInfo> hashMap = this.richImageMap;
                    this.richImageList.add(new Pair<>(Integer.valueOf(i3), hashMap != null ? hashMap.get(str) : null));
                }
                this.mMediaList.add(new MediaWrapper(ImageInfo.create(list.get(i3))));
            }
        }
        this.mMixBatchedMediaNum = this.mMediaList.size();
    }

    private void processVideoSyncWeibo(boolean z16) {
        if (z16 && isVideoTask()) {
            this.videoInfo.mFlag |= 1;
        }
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadStart(int i3, String str, String str2) {
        if (i3 < 0) {
            return;
        }
        setCurrentImageIndex(i3);
    }

    protected void onMediaVideoUploadSuccess(UploadVideoInfoRsp uploadVideoInfoRsp, int i3) {
        if (uploadVideoInfoRsp == null) {
            return;
        }
        if (this.mUniAttr == null) {
            this.mUniAttr = new UniAttribute();
        }
        this.mUniAttr.put("response", uploadVideoInfoRsp);
    }

    private void fullEventTagParams(PublishEventTag publishEventTag, Map<String, String> map) {
        if (map == null || publishEventTag == null) {
            return;
        }
        if (!TextUtils.isEmpty(publishEventTag.f45887protocol)) {
            map.put(QZonePublishMoodRequest.EXT_INFO_KEY_EVENT_TAG, publishEventTag.f45887protocol);
        }
        if (TextUtils.isEmpty(publishEventTag.f45886id)) {
            return;
        }
        map.put(QZonePublishMoodRequest.EXT_INFO_KEY_EVENT_TAG_ID, publishEventTag.f45886id);
    }

    protected void onMediaPhotoUploadSuccess(UploadFileResponse uploadFileResponse, AbstractUploadTask abstractUploadTask, int i3) {
        if (uploadFileResponse == null || i3 < 0) {
            return;
        }
        if (this.mediaInfo == null) {
            this.mediaInfo = new MediaInfo();
        }
        MediaInfo mediaInfo = this.mediaInfo;
        if (mediaInfo.picinfolist == null) {
            mediaInfo.picinfolist = new ArrayList<>();
            for (int i16 = 0; i16 < this.mMediaList.size(); i16++) {
                this.mediaInfo.picinfolist.add(null);
            }
        }
        String str = this.syncWeiboImageUrl;
        if (str == null || str.equals("")) {
            this.syncWeiboImageUrl = uploadFileResponse.url;
        }
        PicInfo picInfo = new PicInfo();
        picInfo.picheight = uploadFileResponse.height;
        picInfo.picwidth = uploadFileResponse.width;
        picInfo.hdheight = uploadFileResponse.oheight;
        picInfo.hdwidth = uploadFileResponse.owidth;
        picInfo.pictype = uploadFileResponse.picType;
        picInfo.albumid = uploadFileResponse.albumId;
        picInfo.pictureid = uploadFileResponse.photoId;
        picInfo.sloc = uploadFileResponse.slocId;
        picInfo.picmd5 = uploadFileResponse.md5;
        picInfo.uploadtime = this.mPublishTime;
        picInfo.hdid = uploadFileResponse.originId;
        if (i3 < this.mediaInfo.picinfolist.size()) {
            this.mediaInfo.picinfolist.set(i3, picInfo);
        } else {
            this.mediaInfo.picinfolist.add(picInfo);
        }
        List<DynamicPhotoData> list = this.dynamicPhotoDatas;
        if (list == null || list.size() <= 0) {
            return;
        }
        if (this.activePhotosMap == null) {
            this.activePhotosMap = new HashMap();
        }
        for (DynamicPhotoData dynamicPhotoData : this.dynamicPhotoDatas) {
            if (dynamicPhotoData.mUrl.startsWith("https://www.dynamicalbumlocalimage.com") && uploadFileResponse.originUploadUrl.equals(dynamicPhotoData.mUrl.replace("https://www.dynamicalbumlocalimage.com", ""))) {
                this.activePhotosMap.put(dynamicPhotoData, new active_photo(uploadFileResponse.albumId, uploadFileResponse.photoId, dynamicPhotoData.mTitle, dynamicPhotoData.mDesc));
                return;
            }
        }
    }

    @Override // com.qzone.publish.business.protocol.QzoneMediaUploadRequest.b
    public void onMediaUploadSuccess(JceStruct jceStruct, AbstractUploadTask abstractUploadTask, int i3, String str, String str2, String str3) {
        if (jceStruct == null || i3 < 0) {
            return;
        }
        QZLog.i(TAG, "onMediaUploadSuccess mediaIndex:" + i3 + ", id:" + str + ", srcPath:" + str2 + ", uploadPath:" + str3);
        if (!this.mediaUploadSuccessIndexList.contains(Integer.valueOf(i3))) {
            this.mediaUploadSuccessIndexList.add(Integer.valueOf(i3));
        }
        if (jceStruct instanceof UploadVideoInfoRsp) {
            QZLog.i(TAG, "response is UploadVideoInfoRsp");
            onMediaVideoUploadSuccess((UploadVideoInfoRsp) jceStruct, i3);
            if (isNeedReplacePath(str2, str3)) {
                str2 = str3;
            }
            if (TextUtils.isEmpty(str2) || !new File(str2).exists()) {
                return;
            }
            addUploadVideoToUrlMap(str, str2);
            QZLog.i(TAG, "addUploadVideoToUrlMap, id:" + str + ", path:" + str2);
            return;
        }
        if (jceStruct instanceof UploadFileResponse) {
            QZLog.i(TAG, "response is UploadFileResponse");
            onMediaPhotoUploadSuccess((UploadFileResponse) jceStruct, abstractUploadTask, i3);
        }
    }

    private void initLbsInfo(LbsDataV2.PoiInfo poiInfo, LbsDataV2.PoiInfo poiInfo2) {
        if (poiInfo != null) {
            LbsInfo lbsInfo = new LbsInfo();
            this.lbsInfo = lbsInfo;
            if (poiInfo.gpsInfo != null) {
                lbsInfo.lbs_x = String.valueOf(r3.lon / 1000000.0d);
                this.lbsInfo.lbs_y = String.valueOf(poiInfo.gpsInfo.lat / 1000000.0d);
            }
            if (!TextUtils.isEmpty(poiInfo.poiDefaultName)) {
                LbsInfo lbsInfo2 = this.lbsInfo;
                String str = poiInfo.poiDefaultName;
                lbsInfo2.lbs_idnm = str;
                lbsInfo2.lbs_nm = str;
            } else if (!TextUtils.isEmpty(poiInfo.poiName)) {
                LbsInfo lbsInfo3 = this.lbsInfo;
                String str2 = poiInfo.poiName;
                lbsInfo3.lbs_idnm = str2;
                lbsInfo3.lbs_nm = str2;
            } else {
                LbsInfo lbsInfo4 = this.lbsInfo;
                String str3 = poiInfo.address;
                lbsInfo4.lbs_idnm = str3;
                lbsInfo4.lbs_nm = str3;
            }
            LbsInfo lbsInfo5 = this.lbsInfo;
            lbsInfo5.i_poi_order_type = poiInfo.poiOrderType;
            lbsInfo5.i_poi_num = poiInfo.poiNum;
            lbsInfo5.i_poi_type = poiInfo.poiType;
            try {
                lbsInfo5.lbs_id = Integer.parseInt(poiInfo.poiId);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "initLbsInfo e = " + e16);
            }
        }
        if (poiInfo2 == null) {
            poiInfo2 = com.qzone.business.lbsv2.business.c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_SAY).e();
        }
        if (poiInfo2 != null) {
            this.hiddenPoi = new LbsInfo();
            LbsDataV2.GpsInfo gpsInfo = poiInfo2.gpsInfo;
            if (gpsInfo != null && gpsInfo.isValid()) {
                this.hiddenPoi.lbs_x = String.valueOf(gpsInfo.lon / 1000000.0d);
                this.hiddenPoi.lbs_y = String.valueOf(gpsInfo.lat / 1000000.0d);
            }
            Map<String, String> map = this.hiddenPoi.extend_info;
            if (map == null) {
                map = new HashMap<>();
            }
            String str4 = poiInfo2.province;
            if (str4 != null) {
                map.put("province_nm", str4);
            }
            String str5 = poiInfo2.city;
            if (str5 != null) {
                map.put("city_nm", str5);
            }
            String str6 = poiInfo2.district;
            if (str6 != null) {
                map.put("district_nm", str6);
            }
            this.hiddenPoi.extend_info = map;
        }
    }

    public QZPublishXUploadShuoShuoTask(int i3, com.qzone.publish.ui.model.c cVar) {
        if (i3 == 0) {
            initNormal(cVar);
        } else {
            if (i3 != 1) {
                return;
            }
            initMixUpload(cVar);
        }
    }
}
