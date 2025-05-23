package com.qzone.publish.business.protocol;

import FileUpload.UploadPicInfoRsp;
import NS_MOBILE_FEEDS.single_feed;
import NS_MOBILE_OPERATION.operation_publishmood_rsp;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.qzone.common.account.LoginData;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.publish.business.model.AlbumPhotoInfo;
import com.qzone.publish.business.model.UploadImageObject;
import com.qzone.publish.business.process.base.QZoneProcessType;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.data.MoodUploadResult;
import com.tencent.upload.uinterface.data.MoodUploadTask;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneUploadMoodRequest extends QzoneUploadRequest {
    private static final String KEY_FAKE_SINGLE_FEED = "fakeSingleFeed";
    private static final String TAG = "QZoneUploadMoodRequest";
    private String aAlbumsId;
    private ArrayList<UploadImageObject> aPhotoFilePaths;
    private long batchId;
    private boolean isMixShuoshuo;
    private MoodUploadTask mTask;
    private int picQuality;
    private int target;
    private byte[] vBusiNessData;

    public QZoneUploadMoodRequest() {
    }

    private MoodUploadTask createMoodUploadTask() {
        UploadPicInfoRsp uploadPicInfoRsp;
        MoodUploadTask moodUploadTask = new MoodUploadTask();
        moodUploadTask.flowId = subFlowId((int) this.batchId, toString());
        moodUploadTask.sRefer = "mqq";
        moodUploadTask.reportRefer = "mqq";
        moodUploadTask.businessData = this.vBusiNessData;
        moodUploadTask.sAlbumID = this.aAlbumsId;
        moodUploadTask.iBatchID = this.batchId;
        moodUploadTask.iUin = LoginData.getInstance().getUin();
        int i3 = this.target;
        if (i3 != 4 && i3 != 1 && i3 != 3) {
            if (TextUtils.isEmpty(this.aAlbumsId)) {
                moodUploadTask.iAlbumTypeID = 1;
            } else {
                moodUploadTask.iAlbumTypeID = 0;
                moodUploadTask.sAlbumID = this.aAlbumsId;
            }
        } else {
            moodUploadTask.sAlbumID = "";
            moodUploadTask.iAlbumTypeID = 7;
        }
        moodUploadTask.iSync = 1;
        Iterator<UploadImageObject> it = this.aPhotoFilePaths.iterator();
        while (it.hasNext()) {
            UploadImageObject next = it.next();
            if (next == null) {
                QZLog.e(TAG, "createMoodUploadTask(), current image is null");
            } else {
                if (moodUploadTask.pictureInfoList == null) {
                    moodUploadTask.pictureInfoList = new ArrayList();
                }
                MoodUploadTask.PictureInfo pictureInfo = new MoodUploadTask.PictureInfo();
                AlbumPhotoInfo picInfo = next.getPicInfo();
                if (picInfo != null) {
                    uploadPicInfoRsp = picInfo.toUploadPicInfoRsp();
                    pictureInfo.pictureid = picInfo.pictureid;
                } else {
                    uploadPicInfoRsp = null;
                }
                if (uploadPicInfoRsp != null) {
                    pictureInfo.picheight = uploadPicInfoRsp.iHeight;
                    pictureInfo.picwidth = uploadPicInfoRsp.iWidth;
                    int i16 = uploadPicInfoRsp.iPicType;
                    pictureInfo.pictype = i16;
                    pictureInfo.albumid = uploadPicInfoRsp.sAlbumID;
                    pictureInfo.ishd = this.picQuality == 2;
                    pictureInfo.hdid = uploadPicInfoRsp.sPhotoID;
                    pictureInfo.hdwidth = uploadPicInfoRsp.iOriWidth;
                    pictureInfo.hdheight = uploadPicInfoRsp.iOriHeight;
                    pictureInfo.sloc = uploadPicInfoRsp.sSloc;
                    pictureInfo.pictype = i16;
                }
                if (next.getType() == 1) {
                    pictureInfo.picUrl = "";
                } else if (next.getType() == 2) {
                    pictureInfo.picUrl = next.getFilePath();
                } else if (next.getType() == 3) {
                    pictureInfo.picUrl = next.pic_url;
                }
                pictureInfo.isAppExtPic = next.is_appext_pic;
                pictureInfo.richval = next.richval;
                moodUploadTask.pictureInfoList.add(pictureInfo);
            }
        }
        return moodUploadTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendResponse(boolean z16, int i3, String str, Object obj) {
        byte[] bArr;
        single_feed single_feedVar;
        if (str == null) {
            str = "";
        }
        String str2 = str;
        UniAttribute uniAttribute = new UniAttribute();
        uniAttribute.setEncodeName("utf8");
        uniAttribute.put("ReplyCode", Integer.valueOf(i3));
        uniAttribute.put("StrResult", i3 == 0 ? "success" : "fail");
        if (obj != null && (obj instanceof MoodUploadResult) && (bArr = ((MoodUploadResult) obj).vBusiNessDataRsp) != null) {
            UniAttribute uniAttribute2 = new UniAttribute();
            uniAttribute2.setEncodeName("utf8");
            uniAttribute2.decode(bArr);
            operation_publishmood_rsp operation_publishmood_rspVar = (operation_publishmood_rsp) uniAttribute2.get("publishmood");
            if (operation_publishmood_rspVar != null && operation_publishmood_rspVar.ret == 0 && (single_feedVar = (single_feed) uniAttribute2.get(KEY_FAKE_SINGLE_FEED)) != null) {
                uniAttribute.put(KEY_FAKE_SINGLE_FEED, single_feedVar);
            }
        }
        this.mListner.onProtocolResponse(QZoneProcessType.PROCESS_TYPE_UPLOAD, uniAttribute, i3, i3, str2, false);
    }

    @Override // com.qzone.publish.business.protocol.QzoneUploadRequest
    protected int checkValidValue(AbstractUploadTask abstractUploadTask) {
        byte[] bArr = abstractUploadTask.vLoginData;
        if (!((bArr == null || bArr.length == 0) ? false : true)) {
            return FSUploadConst.ERR_LOGIN_STATUS_EMPTY;
        }
        if (abstractUploadTask.iUin < 10000) {
            return FSUploadConst.ERR_LOGIN_UIN_ILLEGAL;
        }
        return 0;
    }

    @Override // com.qzone.publish.business.protocol.QzoneUploadRequest, y8.a
    public String getFlowMessage() {
        MoodUploadTask moodUploadTask = this.mTask;
        if (moodUploadTask == null) {
            return "";
        }
        return moodUploadTask.getFlowMessage();
    }

    @Override // com.qzone.publish.business.protocol.QzoneUploadRequest
    public void upload(byte[] bArr) {
        MoodUploadTask createMoodUploadTask = createMoodUploadTask();
        this.mTask = createMoodUploadTask;
        createMoodUploadTask.vLoginData = bArr;
        createMoodUploadTask.uploadTaskCallback = new a();
        validAndUpload(this.mTask);
    }

    public QZoneUploadMoodRequest(int i3, long j3, String str, int i16, byte[] bArr, ArrayList<UploadImageObject> arrayList, boolean z16) {
        super(null);
        this.aAlbumsId = str;
        this.target = i3;
        this.batchId = j3;
        this.picQuality = i16;
        this.vBusiNessData = bArr;
        this.aPhotoFilePaths = arrayList;
        this.isMixShuoshuo = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendResponse(boolean z16, int i3, String str) {
        sendResponse(z16, i3, str, null);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IUploadTaskCallback {
        a() {
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadError(AbstractUploadTask abstractUploadTask, int i3, String str) {
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "QZoneUploadMoodRequest.onUploadError {" + QZoneUploadMoodRequest.this.aPhotoFilePaths + "} retCode:" + i3 + " msg:" + str);
            QZoneUploadMoodRequest.this.sendResponse(false, i3, str);
            if (((QZoneRequest) QZoneUploadMoodRequest.this).mUploadQueueListener != null) {
                ((QZoneRequest) QZoneUploadMoodRequest.this).mUploadQueueListener.onUploadError(abstractUploadTask, i3, str);
            }
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadProgress(AbstractUploadTask abstractUploadTask, long j3, long j16) {
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "QZoneUploadMoodRequest.onUploadProgress {" + QZoneUploadMoodRequest.this.aPhotoFilePaths + "} recvDataSize : " + j16 + " totalSize : " + j3);
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadSucceed(AbstractUploadTask abstractUploadTask, Object obj) {
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "QZoneUploadMoodRequest.onUploadSucceed() {" + QZoneUploadMoodRequest.this.aPhotoFilePaths + "}");
            QZoneUploadMoodRequest.this.sendResponse(true, 0, "success", obj);
            if (((QZoneRequest) QZoneUploadMoodRequest.this).mUploadQueueListener != null) {
                ((QZoneRequest) QZoneUploadMoodRequest.this).mUploadQueueListener.onUpdateDataSize(0L, 0L);
            }
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadStateChange(AbstractUploadTask abstractUploadTask, int i3) {
        }
    }
}
