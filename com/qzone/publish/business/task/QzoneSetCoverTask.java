package com.qzone.publish.business.task;

import FileUpload.UploadUpsInfoRsp;
import NS_MOBILE_MAIN_PAGE.mobile_sub_set_cover_req;
import NS_MOBILE_MAIN_PAGE.mobile_sub_set_cover_rsp;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.cover.business.protocol.QZoneSetCoverRequest;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.publish.business.protocol.QZoneUploadUpsInfoRequest;
import com.qzone.publish.business.publishqueue.QZonePublishQueue;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.upload.uinterface.data.UpsImageUploadTask;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneSetCoverTask extends QZoneQueueTask {
    public static final int STEP_SET_COVER = 1;
    public static final int STEP_UPLOAD_COVER = 0;

    @NeedParcel
    private String mCoverType;

    @NeedParcel
    private String mCoverUrl;

    @NeedParcel
    private String mCoverkey;

    @NeedParcel
    private ArrayList<String> mImageList;

    @NeedParcel
    private int mSendFeed;

    @NeedParcel
    private int mSetSource;

    @NeedParcel
    public int mStep;

    @NeedParcel
    private int mSyncFlag;

    @NeedParcel
    private long mUin;

    @NeedParcel
    private int mUploadType;

    /* renamed from: msg, reason: collision with root package name */
    String f51179msg;

    @NeedParcel
    private String pathString;

    public QzoneSetCoverTask() {
        this.mSyncFlag = 0;
        this.mSetSource = 0;
        this.mSendFeed = 0;
        this.f51179msg = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoUploadBg", "\u4e0a\u4f20\u80cc\u666f");
    }

    private void onSetCoverResponse(QZoneTask qZoneTask) {
        QZonePublishQueue.w().g(this, qZoneTask.succeeded());
        QZoneWriteOperationService.v0().onTaskResponse(qZoneTask);
    }

    private void onUploadCoverResponse(QZoneTask qZoneTask) {
        UploadUpsInfoRsp uploadUpsInfoRsp;
        byte[] bArr;
        if (qZoneTask.succeeded() && (qZoneTask.mRequest instanceof QZoneUploadUpsInfoRequest) && (uploadUpsInfoRsp = (UploadUpsInfoRsp) qZoneTask.mUniAttr.get("response")) != null && !TextUtils.isEmpty(uploadUpsInfoRsp.sUrl) && (bArr = uploadUpsInfoRsp.vBusiNessData) != null) {
            UniAttribute uniAttribute = new UniAttribute();
            uniAttribute.setEncodeName("utf8");
            uniAttribute.decode(bArr);
            Object obj = uniAttribute.get(QZoneSetCoverRequest.getCmd());
            if (obj != null && (obj instanceof mobile_sub_set_cover_rsp)) {
                mobile_sub_set_cover_rsp mobile_sub_set_cover_rspVar = (mobile_sub_set_cover_rsp) obj;
                qZoneTask.mRequest.rsp = mobile_sub_set_cover_rspVar;
                if (mobile_sub_set_cover_rspVar.ret == 0) {
                    QZonePublishQueue.w().g(this, true);
                    QZoneWriteOperationService.v0().onTaskResponse(qZoneTask);
                    return;
                } else {
                    this.mStep = 1;
                    this.mCoverUrl = uploadUpsInfoRsp.sUrl;
                    super.run();
                    return;
                }
            }
        }
        QZonePublishQueue.w().g(this, false);
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public boolean cancel() {
        QZoneRequest qZoneRequest = this.mRequest;
        if (qZoneRequest == null || !(qZoneRequest instanceof QZoneUploadUpsInfoRequest)) {
            return false;
        }
        return ((QZoneUploadUpsInfoRequest) qZoneRequest).cancel();
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    /* renamed from: getCacheKey */
    public String getCommentUniKey() {
        return this.clientKey;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public int getExactType() {
        return 7;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    public long getFakeSize() {
        return com.qzone.util.image.c.y(this.pathString, 2);
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public c getInfo() {
        c info = super.getInfo();
        info.f51185a = this.f51179msg;
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

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public String getPhotoSource() {
        return this.pathString;
    }

    public int getSetSouce() {
        return this.mSetSource;
    }

    public int getSyncFlag() {
        return this.mSyncFlag;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.publishqueue.c
    public void onUploadError(Object obj, int i3, String str) {
        super.onUploadError(obj, i3, str);
        QZonePublishQueue.w().g(this, false);
        QZoneWriteOperationService.v0().onTaskResponse(this);
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    public void onRun() {
        int i3 = this.mStep;
        if (i3 != 0) {
            if (i3 != 1 || TextUtils.isEmpty(this.mCoverUrl) || TextUtils.isEmpty(this.mCoverType) || this.mUin == 0) {
                return;
            }
            this.mRequest = new QZoneSetCoverRequest(this.mUin, this.mCoverUrl, this.mCoverType, this.mCoverkey, this.mSyncFlag, this.mSetSource, this.mSendFeed, "");
            return;
        }
        ArrayList<String> arrayList = this.mImageList;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        String str = this.mImageList.get(0);
        QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "QzoneSetCoverTask upload set business data, coverType: " + this.mCoverType + " coverKey: " + this.mCoverkey + ", syncFlag: " + this.mSyncFlag);
        mobile_sub_set_cover_req jceRequest = new QZoneSetCoverRequest(LoginData.getInstance().getUin(), null, QzoneCoverConst.CoverStringType.COVER_TYPE_CUSTOM, null, this.mSyncFlag, this.mSetSource, this.mSendFeed, "").getJceRequest();
        UniAttribute uniAttribute = new UniAttribute();
        uniAttribute.setEncodeName("utf8");
        uniAttribute.put("hostuin", Long.valueOf(LoginData.getInstance().getUin()));
        if (jceRequest != null) {
            uniAttribute.put(QZoneSetCoverRequest.getCmd(), jceRequest);
        }
        QZoneUploadUpsInfoRequest qZoneUploadUpsInfoRequest = new QZoneUploadUpsInfoRequest(UpsImageUploadTask.BUSINESS_COVER, this.mUploadType, true, true, uniAttribute.encode(), str);
        this.mRequest = qZoneUploadUpsInfoRequest;
        qZoneUploadUpsInfoRequest.setUploadQueueListener(this);
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (qZoneTask == null) {
            return;
        }
        int i3 = this.mStep;
        if (i3 == 0) {
            onUploadCoverResponse(qZoneTask);
        } else {
            if (i3 != 1) {
                return;
            }
            onSetCoverResponse(qZoneTask);
        }
    }

    public QzoneSetCoverTask(long j3, String str, String str2, String str3, String str4, String str5, int i3, int i16, int i17, int i18) {
        super(i3);
        this.mSyncFlag = 0;
        this.mSetSource = 0;
        this.mSendFeed = 0;
        this.f51179msg = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoUploadBg", "\u4e0a\u4f20\u80cc\u666f");
        this.mUploadType = 16;
        this.pathString = str2;
        ArrayList<String> arrayList = new ArrayList<>();
        this.mImageList = arrayList;
        arrayList.add(str2);
        this.mCoverType = str;
        this.mCoverkey = str3;
        this.mCoverUrl = str4;
        this.mUin = j3;
        this.mSyncFlag = i16;
        this.mSetSource = i17;
        this.clientKey = str5;
        if (this.mImageList.size() > 0 && this.mCoverUrl == null) {
            this.mStep = 0;
        } else {
            this.mStep = 1;
        }
        this.mSendFeed = i18;
    }
}
