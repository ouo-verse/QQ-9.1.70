package com.qzone.publish.business.task;

import a9.f;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.publish.business.model.a;
import com.qzone.publish.business.publishqueue.QZonePublishQueue;
import com.qzone.publish.business.publishqueue.intimate.i;
import com.qzone.video.service.QzoneVideoUploadActionReport;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.upload.network.route.UploadRoute;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.utils.Const;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.RecentPhotoManger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class QZoneQueueTask extends QZoneTask implements IQZoneServiceListener, com.qzone.publish.business.publishqueue.c, IQueueTask {
    public static final String ALBUMID = "albumid";
    public static final int EXACTTYPE_EDIT_SHUOSHUO = 12;
    public static final int EXACTTYPE_PIC_COMMENT = 13;
    public static final int EXACTTYPE_PUBLISH_MIX_VIDEO_PIC_MOOD = 19;
    public static final int EXACTTYPE_PUBLISH_MOOD = 1;
    public static final int EXACTTYPE_QUN_UPLOAD_PIC = 5;
    public static final int EXACTTYPE_QUOTE_PIC_FROM_AIO_TO_QZONE = 11;
    public static final int EXACTTYPE_QUOTE_PIC_FROM_QUN = 9;
    public static final int EXACTTYPE_QUOTE_QUN_PIC = 8;
    public static final int EXACTTYPE_REPORT = 17;
    public static final int EXACTTYPE_UPLOAD_FIRST_DYNAMIC_PHOTO_TASK = 21;
    public static final int EXACTTYPE_UPLOAD_GIFT = 4;
    public static final int EXACTTYPE_UPLOAD_H5_VIDEO = 18;
    public static final int EXACTTYPE_UPLOAD_PIC = 2;
    public static final int EXACTTYPE_UPLOAD_SINGLE_VIDEO = 15;
    public static final int EXACTTYPE_UPLOAD_UPS = 7;
    public static final int EXACTTYPE_UPLOAD_VIDEO_COVER = 14;
    public static final int EXACTTYPE_UPLOAD_VIDEO_PIC = 16;
    public static final int EXACTTYPE_VIDEO_COMPRESS_TASK = 20;
    public static final int FAILCODE_207 = -207;
    public static final String RESUMENUM = "207num";
    public static final int STATE_CANCEL = 5;
    public static final int STATE_CONNECTION = 4;
    public static final int STATE_FINISH = 3;
    public static final int STATE_FINISH_REQUEST = 7;
    public static final int STATE_OFFLINE_WAITTING = 6;
    public static final int STATE_PAUSE = 2;
    public static final int STATE_RUNNING = 1;
    public static final int STATE_WAITTING = 0;
    public static final int VIDEO_SERVICE_CONNECT_FAILED = 2;
    public static final int VIDEO_SERVICE_DISCONNECT = 1;
    public static final int VIDEO_SERVICE_ERROR_UNKNOWN = 0;

    @NeedParcel
    public long batchId;
    String cancel;
    String fail;
    String failMsg;
    String fileNotExist;

    /* renamed from: id, reason: collision with root package name */
    private long f51173id;

    @NeedParcel
    public String mDescription;
    public long mRecvDataSize;
    public com.qzone.publish.business.model.a mReportInfo;
    public long mResetTime;

    @NeedParcel
    public int mState;
    public long mTime;
    public long mTotalSize;

    @NeedParcel
    public int manualRetryNum;
    String netWorkError;
    String queueing;

    @NeedParcel
    public int retryNum;
    String stop;
    String success;

    @NeedParcel
    public String traceId;

    public QZoneQueueTask() {
        this.mTime = 0L;
        this.queueing = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoQueueing", "\u6392\u961f\u4e2d...");
        this.stop = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoStop", "\u4efb\u52a1\u6682\u505c");
        this.failMsg = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoFailMsg", "\u4efb\u52a1\u5931\u8d25,");
        this.fail = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoFail", "\u4efb\u52a1\u5931\u8d25");
        this.netWorkError = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoNetWorkError", VSNetLightQUICBaseRequest.NETWORK_ERROR_HINT);
        this.fileNotExist = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoFileNotExist", ImageTaskConst.ErrorDesciption.IMAGE_TASK_NO_SUCH_FILE_DESC);
        this.cancel = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoCancel", "\u5df2\u53d6\u6d88");
        this.success = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoSuccess", "\u4e0a\u4f20\u6210\u529f");
        this.mListener = this;
        this.mReportInfo = new com.qzone.publish.business.model.a();
        this.f51173id = System.nanoTime();
    }

    public void addToRecentPhotoBlacklists(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        RecentPhotoManger.addToRecentPhotoBlacklist(RecentPhotoManger.KEY_SHUOSHUO_RECENT_PHOTO_BLACKLIST, str);
        RecentPhotoManger.addToRecentPhotoBlacklist(RecentPhotoManger.KEY_PERSONAL_ALBUM_RECENT_PHOTO_BLACKLIST, str);
        RecentPhotoManger.addToRecentPhotoBlacklist(RecentPhotoManger.KEY_BANNER_RECENT_PHOTO_BLACKLIST, str);
    }

    public void addToTaskQueen() {
        RFWLog.d("[upload2][outbox] PublishQueue:QZoneQueueTask", RFWLog.USR, "addToTaskQueen:" + this);
        getPublishQueue().b(this);
    }

    public boolean cancel() {
        return false;
    }

    public long getBatchId() {
        return this.batchId;
    }

    /* renamed from: getCacheKey */
    public abstract String getCommentUniKey();

    @Override // com.qzone.publish.business.task.IQueueTask
    public String getCaseId() {
        return "0";
    }

    @Override // com.qzone.publish.business.task.IQueueTask
    public String getClientKey() {
        return this.clientKey;
    }

    public List<String> getEditMissionId() {
        return new ArrayList();
    }

    public abstract int getExactType();

    protected long getFakeSize() {
        return 0L;
    }

    public List<String> getImageUrls() {
        return null;
    }

    public c getInfo() {
        c cVar = new c();
        int i3 = this.mState;
        cVar.f51187c = i3;
        switch (i3) {
            case 0:
            case 6:
                cVar.f51186b = this.queueing;
                break;
            case 1:
                cVar.f51186b = this.queueing;
                break;
            case 2:
                QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "STATE_PAUSE mResultCode:" + this.mResultCode);
                if (this.mResultCode == 0) {
                    cVar.f51186b = this.stop;
                    break;
                } else if (!TextUtils.isEmpty(this.f45835msg)) {
                    cVar.f51186b = this.failMsg + this.f45835msg;
                    break;
                } else if (getPublishQueue().h(this, false)) {
                    cVar.f51186b = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PUBLISH_QUEUE_SAFETY_STRIKE_MESSAGE, QzoneConfig.DefaultValue.DEFAULT_PUBLISH_QUEUE_SAFETY_STRIKE_MESSAGE);
                    break;
                } else {
                    cVar.f51186b = this.fail;
                    break;
                }
            case 3:
                cVar.f51186b = this.success;
                break;
            case 4:
                cVar.f51186b = this.queueing;
                break;
            case 5:
                int i16 = this.mResultCode;
                if (i16 != 301002 && i16 != 301013) {
                    if (i16 == Const.UploadRetCode.FILE_NOT_EXIST.getCode()) {
                        cVar.f51186b = this.fileNotExist;
                        break;
                    } else {
                        QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "STATE_CANCEL mResultCode:" + this.mResultCode);
                        if (this.mResultCode == 0) {
                            cVar.f51186b = this.stop;
                            break;
                        } else {
                            cVar.f51186b = this.cancel;
                            break;
                        }
                    }
                } else {
                    cVar.f51186b = this.netWorkError;
                    break;
                }
                break;
        }
        cVar.f51188d = this.mRecvDataSize;
        cVar.f51189e = this.mTotalSize;
        return cVar;
    }

    public long getLeaveSize() {
        long fakeSize;
        long j3 = this.mTotalSize;
        if (j3 != 0) {
            fakeSize = (j3 * 1024) - (this.mRecvDataSize * 1024);
        } else {
            fakeSize = getFakeSize();
        }
        return fakeSize + 0;
    }

    @Override // com.qzone.publish.business.task.IQueueTask
    public int getManualRetryNum() {
        return this.manualRetryNum;
    }

    @Override // com.qzone.publish.business.task.IQueueTask
    public String getPhotoSource() {
        return null;
    }

    @Override // com.qzone.publish.business.task.IQueueTask
    public com.qzone.publish.business.publishqueue.a getPublishQueue() {
        if (com.qzone.publish.business.publishqueue.intimate.a.d(this)) {
            return f.f25725a.c();
        }
        if (com.qzone.publish.business.publishqueue.intimate.a.e(this)) {
            return QZonePublishQueue.w();
        }
        if (com.qzone.publish.business.publishqueue.intimate.a.b(this)) {
            return z8.c.f452134a.c(getCaseId());
        }
        if (com.qzone.publish.business.publishqueue.intimate.a.c(this)) {
            return i.f51168a.c(getCaseId());
        }
        return QZonePublishQueue.w();
    }

    public com.qzone.publish.business.model.a getReportInfo() {
        return this.mReportInfo;
    }

    @Override // com.qzone.publish.business.task.IQueueTask
    public int getResultCode() {
        return this.mResultCode;
    }

    @Override // com.qzone.publish.business.task.IQueueTask
    public String getResultMsg() {
        return this.f45835msg;
    }

    @Override // com.qzone.publish.business.task.IQueueTask
    public int getRetryNum() {
        return this.retryNum;
    }

    @Override // com.qzone.publish.business.publishqueue.c, com.qzone.publish.business.task.IQueueTask
    public int getState() {
        return this.mState;
    }

    @Override // com.qzone.publish.business.task.IQueueTask
    public long getTaskId() {
        return this.f51173id;
    }

    @Override // com.qzone.publish.business.task.IQueueTask
    public long getTime() {
        return this.mTime;
    }

    @Override // com.qzone.publish.business.task.IQueueTask
    public long getTimeStamp() {
        return this.timestamp;
    }

    @Override // com.qzone.publish.business.task.IQueueTask
    public String getTraceId() {
        if (TextUtils.isEmpty(this.traceId)) {
            resetTraceId();
        }
        return this.traceId;
    }

    @Override // com.qzone.publish.business.task.IQueueTask
    public long getUploadTime() {
        return 0L;
    }

    public boolean getWaterMark() {
        boolean i3 = oo.b.i();
        QLog.d("QZoneWatermark", 1, "getWaterMark: " + i3 + " uin:" + LoginData.getInstance().getUin());
        return i3;
    }

    @Override // com.qzone.publish.business.task.IQueueTask
    public synchronized void increaseManualRetryNum() {
        this.manualRetryNum++;
    }

    @Override // com.qzone.publish.business.task.IQueueTask
    public synchronized void increaseRetryNum() {
        this.retryNum++;
    }

    public boolean isNullTask() {
        return false;
    }

    @Override // com.qzone.publish.business.task.IQueueTask
    public boolean isQunTask() {
        return false;
    }

    @Override // com.qzone.publish.business.task.IQueueTask
    public boolean isVideoTask() {
        return false;
    }

    @Override // com.qzone.publish.business.task.IQueueTask
    public void onResume() {
        this.retryNum++;
        resetDataSize();
    }

    public abstract void onRun();

    @Override // com.qzone.publish.business.publishqueue.c
    public void onStateChanged(int i3) {
        this.mState = i3;
    }

    @Override // com.qzone.publish.business.publishqueue.c
    public void onUpdateDataSize(long j3, long j16) {
        this.mRecvDataSize = j3;
        this.mTotalSize = j16;
        getPublishQueue().d(this);
    }

    @Override // com.qzone.publish.business.publishqueue.c
    public void resetTime() {
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.mResetTime;
        if (j3 == 0 || currentTimeMillis - j3 > 20000) {
            this.mResetTime = currentTimeMillis;
            CopyOnWriteArrayList<IQueueTask> a16 = getPublishQueue().a();
            if (a16 == null || a16.size() == 0) {
                return;
            }
            for (IQueueTask iQueueTask : a16) {
                if (iQueueTask != null) {
                    iQueueTask.setTime(currentTimeMillis);
                }
            }
        }
    }

    @Override // com.qzone.publish.business.task.IQueueTask
    public void resetTraceId() {
        this.traceId = eo.d.a();
    }

    @Override // com.qzone.publish.business.task.IQueueTask
    public void setResultCode(int i3) {
        this.mResultCode = i3;
    }

    @Override // com.qzone.publish.business.task.IQueueTask
    public void setResultMsg(String str) {
        this.f45835msg = str;
    }

    @Override // com.qzone.publish.business.task.IQueueTask
    public void setState(int i3) {
        this.mState = i3;
    }

    @Override // com.qzone.publish.business.publishqueue.c, com.qzone.publish.business.task.IQueueTask
    public void setTime(long j3) {
        this.mTime = j3;
    }

    @Override // com.qzone.common.business.task.QZoneTask
    public void run() {
        if (5 == this.mState) {
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "QZoneQueueTask.run type:" + getExactType() + " is canceled");
            return;
        }
        onRun();
        this.mTime = System.currentTimeMillis();
        super.run();
    }

    public void addReportInfo(a.C0436a c0436a) {
        if (c0436a == null) {
            QZLog.e("[upload2][outbox] PublishQueue:QZoneQueueTask", "addReportInfo error, reportinfo null");
            return;
        }
        if (this.mReportInfo == null) {
            this.mReportInfo = new com.qzone.publish.business.model.a();
        }
        this.mReportInfo.a(c0436a);
    }

    @Override // com.qzone.publish.business.publishqueue.c
    public void onUploadError(Object obj, int i3, String str) {
        String str2;
        UploadRoute route = (obj == null || !(obj instanceof AbstractUploadTask)) ? null : ((AbstractUploadTask) obj).getRoute();
        QzoneVideoUploadActionReport b16 = QzoneVideoUploadActionReport.b();
        if (route != null) {
            str2 = route.toString();
        } else {
            str2 = "";
        }
        b16.f("end_upload", i3, str2, str, "shuoshuoORalbum");
    }

    @Override // com.qzone.publish.business.task.IQueueTask
    public void resetDataSize() {
        this.mRecvDataSize = 0L;
        this.mTotalSize = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int subFlowId(int i3, String str) {
        if (str == null) {
            str = "";
        }
        return i3 + (str + String.valueOf(i3) + System.currentTimeMillis()).hashCode();
    }

    public QZoneQueueTask(int i3) {
        super(null, null, null, i3);
        this.mTime = 0L;
        this.queueing = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoQueueing", "\u6392\u961f\u4e2d...");
        this.stop = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoStop", "\u4efb\u52a1\u6682\u505c");
        this.failMsg = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoFailMsg", "\u4efb\u52a1\u5931\u8d25,");
        this.fail = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoFail", "\u4efb\u52a1\u5931\u8d25");
        this.netWorkError = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoNetWorkError", VSNetLightQUICBaseRequest.NETWORK_ERROR_HINT);
        this.fileNotExist = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoFileNotExist", ImageTaskConst.ErrorDesciption.IMAGE_TASK_NO_SUCH_FILE_DESC);
        this.cancel = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoCancel", "\u5df2\u53d6\u6d88");
        this.success = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "BoxTaskInfoSuccess", "\u4e0a\u4f20\u6210\u529f");
        this.mListener = this;
        this.mReportInfo = new com.qzone.publish.business.model.a();
        this.f51173id = System.nanoTime();
    }

    public void clear() {
    }

    public void onRemove() {
    }

    @Override // com.qzone.publish.business.task.IQueueTask
    public void onRestore() {
    }

    @Override // com.qzone.publish.business.publishqueue.c
    public void onUploadSucceed(Object obj) {
    }
}
