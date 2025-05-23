package com.qzone.publish.business.task;

import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.publish.business.protocol.QZoneReportRequest;
import com.qzone.publish.business.protocol.QzoneUploadRequest;
import com.qzone.publish.business.publishqueue.QZoneReportTaskQueue;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneReportTask extends QZoneQueueTask {
    private static final String BEACON_REPORT_TAG = "upload_report_event";

    @NeedParcel
    public long createTime;

    @NeedParcel
    public String path;

    public QZoneReportTask() {
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public boolean cancel() {
        QZoneRequest qZoneRequest = this.mRequest;
        if (qZoneRequest == null || !(qZoneRequest instanceof QzoneUploadRequest)) {
            return false;
        }
        if (QZLog.isColorLevel()) {
            QZLog.i(QZLog.REPORT_QUEUE_TAG, 2, "QZoneReportTask.cancel path:" + this.path);
        }
        return ((QzoneUploadRequest) this.mRequest).cancel();
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    /* renamed from: getCacheKey */
    public String getCommentUniKey() {
        return this.clientKey;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public int getExactType() {
        return 17;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public void onRemove() {
        long j3;
        super.onRemove();
        if (TextUtils.isEmpty(this.path)) {
            return;
        }
        File file = new File(this.path);
        if (file.exists()) {
            if (QZLog.isColorLevel()) {
                QZLog.i(QZLog.REPORT_QUEUE_TAG, 2, "QZoneReportTask.onRemove path:" + this.path);
            }
            j3 = file.length();
            file.delete();
        } else {
            j3 = 0;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_FailCode", String.valueOf(this.mResultCode));
        hashMap.put(TVKCommonParamEnum.REQ_PARAM_KEY_RETRY, String.valueOf(this.retryNum));
        hashMap.put("size", String.valueOf(j3));
        hashMap.put("netType", String.valueOf(NetworkState.getNetworkType()));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(LoginData.getInstance().getUinString(), BEACON_REPORT_TAG, succeeded(), 0L, 0L, hashMap, null);
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    public void onRun() {
        QZoneReportRequest qZoneReportRequest = new QZoneReportRequest(this.path);
        this.mRequest = qZoneReportRequest;
        qZoneReportRequest.setUploadQueueListener(this);
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.publishqueue.c
    public void onUpdateDataSize(long j3, long j16) {
        this.mRecvDataSize = j3;
        this.mTotalSize = j16;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.publishqueue.c
    public void resetTime() {
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.mResetTime;
        if (j3 == 0 || currentTimeMillis - j3 > 20000) {
            this.mResetTime = currentTimeMillis;
            CopyOnWriteArrayList<IQueueTask> j16 = QZoneReportTaskQueue.h().j();
            if (j16 == null || j16.size() == 0) {
                return;
            }
            Iterator<IQueueTask> it = j16.iterator();
            while (it.hasNext()) {
                it.next().setTime(currentTimeMillis);
            }
        }
    }

    public QZoneReportTask(String str) {
        this.path = str;
        this.clientKey = UUID.randomUUID().toString();
        this.createTime = NetConnInfoCenter.getServerTime();
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        QZoneReportTaskQueue.h().g(this, qZoneTask != null ? qZoneTask.succeeded() : false);
    }
}
