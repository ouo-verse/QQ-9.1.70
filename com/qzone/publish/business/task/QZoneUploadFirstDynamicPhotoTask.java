package com.qzone.publish.business.task;

import NS_MOBILE_PHOTO.active_photo;
import NS_MOBILE_PHOTO.publish_active_album_rsp;
import NS_MOBILE_PHOTO.shuoshuo_privacy;
import com.qzone.album.protocol.QZoneQueryDynamicRequest;
import com.qzone.album.protocol.QZoneUploadFirstDynamicPhotoRequest;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.task.QZoneTask;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.data.ImageUploadResult;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/* loaded from: classes39.dex */
public class QZoneUploadFirstDynamicPhotoTask extends QZoneQueueTask {
    protected static final int STEP_UPLOAD_DONE = 2;
    protected static final int STEP_UPLOAD_FIRST_DYNAMIC_PHOTO = 1;
    private static final int TARGET_CREATE_DYNAMIC_ALBUM = 11;
    private static final int TARGET_UPLOAD_FIRST_DYNAMIC_PHOTO = 10;
    private String firstAlbumId;
    private String firstPhotoId;
    private String firstPhotoUrl;
    private boolean isSkidPreLoad;
    private String mFirstPhotoPath;
    private int mTotalNum;
    protected int step;

    public QZoneUploadFirstDynamicPhotoTask(String str, int i3) {
        this.step = 1;
        this.firstAlbumId = null;
        this.firstPhotoId = null;
        this.firstPhotoUrl = null;
        this.isSkidPreLoad = false;
        this.mFirstPhotoPath = str;
        this.mTotalNum = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createDynamicAlbum(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        String uuid = UUID.randomUUID().toString();
        this.clientKey = uuid;
        u5.b.v0("key_dynamic_client_ket", uuid);
        hashMap.put(QZoneJsConstants.DYNAMIC_ALBUM_COVER_AID, str);
        hashMap.put(QZoneJsConstants.DYNAMIC_ALBUM_COVER_PIC, str2);
        hashMap.put("cover_url", str3);
        hashMap.put("client_key", this.clientKey);
        hashMap.put(QZoneJsConstants.DYNAMIC_ALBUM_NAME, QZoneJsConstants.DEFAULT_DYNAMIC_ALBUM_NAME);
        hashMap.put(QZoneJsConstants.DYNAMIC_ALBUM_DESC, QZoneJsConstants.DEFAULT_DYNAMIC_ALBUM_DESC);
        hashMap.put(QZoneJsConstants.DYNAMIC_ALBUM_TEMPLT_ID, QZoneJsConstants.DEFAULT_DYNAMIC_ALBUM_TEMPLT_ID);
        hashMap.put(QZoneJsConstants.DYNAMIC_ALBUM_IS_PUBLIC_SHUOSHUO, "0");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new active_photo(str, str2, "", ""));
        shuoshuo_privacy shuoshuo_privacyVar = new shuoshuo_privacy();
        shuoshuo_privacyVar.mood_permission = String.valueOf(64);
        u5.b.v0("key_dynamic_share_cover_url", str3);
        QZoneTask qZoneTask = new QZoneTask(new QZoneQueryDynamicRequest(arrayList, hashMap, shuoshuo_privacyVar, this.mTotalNum, LoginData.getInstance().getUin()), null, null, 11);
        qZoneTask.clientKey = this.clientKey;
        qZoneTask.setListener(this);
        qZoneTask.run();
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    /* renamed from: getCacheKey */
    public String getCommentUniKey() {
        return null;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public int getExactType() {
        return 21;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    public void onRun() {
        String str;
        String str2;
        String str3;
        if (this.step != 1) {
            return;
        }
        if (this.isSkidPreLoad && (str = this.firstAlbumId) != null && (str2 = this.firstPhotoId) != null && (str3 = this.firstPhotoUrl) != null) {
            this.step = 2;
            createDynamicAlbum(str, str2, str3);
        } else {
            if (this.mFirstPhotoPath == null || this.mTotalNum <= 0) {
                return;
            }
            QZoneUploadFirstDynamicPhotoRequest qZoneUploadFirstDynamicPhotoRequest = new QZoneUploadFirstDynamicPhotoRequest(10, this.mFirstPhotoPath, new a());
            this.mRequest = qZoneUploadFirstDynamicPhotoRequest;
            qZoneUploadFirstDynamicPhotoRequest.setRefer("shuoshuoOther");
        }
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (qZoneTask != null && qZoneTask.mType == 11) {
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "QZoneUploadFirstDynamicPhotoTask.onTaskResponse() - TARGET_CREATE_DYNAMIC_ALBUM {" + this.mFirstPhotoPath + "}");
            publish_active_album_rsp publish_active_album_rspVar = (publish_active_album_rsp) qZoneTask.mUniAttr.getByClass("CreateActiveAlbum", new publish_active_album_rsp());
            String str = publish_active_album_rspVar.share_url;
            if (str != null && !str.equals("") && !publish_active_album_rspVar.mgz_id.equals("")) {
                QZLog.d(QZLog.PUBLISH_QUEUE_TAG, 1, "get dynamicShareUrl succeed:" + publish_active_album_rspVar.share_url);
                u5.b.v0("key_dynamic_share_url", publish_active_album_rspVar.share_url);
                u5.b.v0("key_dynamic_mgz_id", publish_active_album_rspVar.mgz_id);
                return;
            }
            u5.b.v0("key_dynamic_share_url", "null");
            u5.b.v0("key_dynamic_share_cover_url", "null");
            u5.b.v0("key_dynamic_client_ket", "null");
            u5.b.v0("key_dynamic_mgz_id", "null");
        }
    }

    public QZoneUploadFirstDynamicPhotoTask(String str, String str2, String str3, boolean z16, int i3) {
        this.step = 1;
        this.firstAlbumId = str;
        this.firstPhotoId = str2;
        this.firstPhotoUrl = str3;
        this.isSkidPreLoad = z16;
        this.mTotalNum = i3;
    }

    /* loaded from: classes39.dex */
    class a implements IUploadTaskCallback {
        a() {
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadError(AbstractUploadTask abstractUploadTask, int i3, String str) {
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "QzoneUploadFirstDynamicPhotoRequest.onUploadError() {" + QZoneUploadFirstDynamicPhotoTask.this.mFirstPhotoPath + "}");
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadProgress(AbstractUploadTask abstractUploadTask, long j3, long j16) {
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "QzoneUploadFirstDynamicPhotoRequest.onUploadProgress() {" + QZoneUploadFirstDynamicPhotoTask.this.mFirstPhotoPath + "}");
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadSucceed(AbstractUploadTask abstractUploadTask, Object obj) {
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "QzoneUploadFirstDynamicPhotoRequest.onUploadSucceed() {" + QZoneUploadFirstDynamicPhotoTask.this.mFirstPhotoPath + "}");
            if (obj instanceof ImageUploadResult) {
                QZoneUploadFirstDynamicPhotoTask qZoneUploadFirstDynamicPhotoTask = QZoneUploadFirstDynamicPhotoTask.this;
                qZoneUploadFirstDynamicPhotoTask.step = 2;
                ImageUploadResult imageUploadResult = (ImageUploadResult) obj;
                qZoneUploadFirstDynamicPhotoTask.createDynamicAlbum(imageUploadResult.sAlbumID, imageUploadResult.sPhotoID, imageUploadResult.sBURL);
            }
        }

        @Override // com.tencent.upload.uinterface.IUploadTaskCallback
        public void onUploadStateChange(AbstractUploadTask abstractUploadTask, int i3) {
        }
    }
}
