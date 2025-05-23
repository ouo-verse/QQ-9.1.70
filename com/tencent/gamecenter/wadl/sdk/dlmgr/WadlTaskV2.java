package com.tencent.gamecenter.wadl.sdk.dlmgr;

import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.sdk.dlapt.WadlAgentV2Adapter;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskListener;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlTaskV2 extends WadlTask implements DownloaderTaskListener {
    public static final String TAG = "Wadl_WadlTaskV2";

    public WadlTaskV2(int i3, @NotNull WadlParams wadlParams) {
        super(i3, wadlParams);
        wadlParams.setFlags(1024);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.dlmgr.WadlTask
    public synchronized void deleteDownload(boolean z16) {
        super.deleteDownload(z16);
        if (this.downloaderTask == null) {
            this.downloaderTask = WadlAgentV2Adapter.getInstance().getDownloaderTask(this);
        }
        WadlAgentV2Adapter.getInstance().deleteDownload(this);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.dlmgr.WadlTask, com.tencent.gamecenter.wadl.sdk.dlapt.WadlTaskListener
    public long getAverageSpeed() {
        if (this.downloaderTask == null) {
            this.downloaderTask = WadlAgentV2Adapter.getInstance().getDownloaderTask(this);
        }
        if (this.downloaderTask != null) {
            return r0.getAverageSpeed();
        }
        return 0L;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskListener
    public void onTaskCompletedSubloop(DownloaderTask downloaderTask) {
        String savePath = downloaderTask.getSavePath();
        long costTime = downloaderTask.getCostTime();
        WadlParams wadlParams = this.mWadlParams;
        if (wadlParams != null) {
            wadlParams.speedBuffer = WadlAgentV2Adapter.getInstance().getSpeedBuffer();
        }
        onTaskCompleted(savePath, costTime, "");
        QLog.d(TAG, 1, "onTaskCompletedSubloop appId=" + this.appId + ",businessId=" + this.businessId + ",costTime=" + costTime + ",speed=" + getAverageSpeed() + ",savePath=" + savePath);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.dlmgr.WadlTask, com.tencent.gamecenter.wadl.sdk.dlapt.WadlTaskListener
    public void onTaskDetected() {
        long j3;
        try {
            DownloaderTask downloaderTask = this.downloaderTask;
            if (downloaderTask != null) {
                j3 = downloaderTask.getTotalLength();
            } else {
                j3 = 0;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            j3 = -1;
        }
        this.fileSize = j3;
        super.onTaskDetected();
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskListener
    public void onTaskDetectedSubloop(DownloaderTask downloaderTask) {
        onTaskDetected();
    }

    @Override // com.tencent.gamecenter.wadl.sdk.dlmgr.WadlTask, com.tencent.gamecenter.wadl.sdk.dlapt.WadlTaskListener
    public void onTaskFailed(int i3, String str) {
        QLog.w(TAG, 1, "onTaskFailed code=" + i3 + ",errMsg=" + str);
        if (i3 != -15 && i3 != -16 && i3 != -23 && i3 != -24 && i3 != -25 && i3 != -26 && i3 != -27) {
            super.onTaskFailed(i3, str);
        } else {
            pauseDownload("4");
            this.isPausedByWifiDisconnected = true;
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskListener
    public void onTaskFailedSubloop(DownloaderTask downloaderTask) {
        int failCode = downloaderTask.getFailCode();
        onTaskFailed(failCode, downloaderTask.getFailInfo());
        QLog.w(TAG, 1, "onTaskFailedSubloop appId=" + this.appId + ",businessId=" + this.businessId + ",failCode=" + failCode + JefsClass.INDEX_URL + downloaderTask.getUrl());
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskListener
    public void onTaskPausedSubloop(DownloaderTask downloaderTask) {
        onTaskPaused();
        QLog.d(TAG, 1, "onTaskPausedSubloop appId=" + this.appId + ",businessId=" + this.businessId);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.dlmgr.WadlTask, com.tencent.gamecenter.wadl.sdk.dlapt.WadlTaskListener
    public void onTaskReceived(int i3) {
        long j3;
        DownloaderTask downloaderTask = this.downloaderTask;
        if (downloaderTask != null) {
            j3 = downloaderTask.getReceivedLength();
        } else {
            j3 = 0;
        }
        this.errCode = 0;
        this.downloadFileSize = j3;
        super.onTaskReceived(i3);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskListener
    public void onTaskReceivedSubloop(DownloaderTask downloaderTask) {
        int percentage = downloaderTask.getPercentage();
        this.lastFloatProgress = getPercentage(downloaderTask.getReceivedLength(), downloaderTask.getTotalLength());
        if (Math.abs(percentage - this.lastProgress) < 1 && percentage != 100) {
            onTaskReceived(1);
        } else {
            this.lastProgress = percentage;
            onTaskReceived(0);
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskListener
    public void onTaskStartedSubloop(DownloaderTask downloaderTask) {
        QLog.d(TAG, 1, "onTaskStartedSubloop appId=" + this.appId + ",businessId=" + this.businessId);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.dlmgr.WadlTask
    public synchronized void pauseDownload(String str) {
        super.pauseDownload(str);
        if (this.downloaderTask == null) {
            this.downloaderTask = WadlAgentV2Adapter.getInstance().getDownloaderTask(this);
        }
        if (!WadlAgentV2Adapter.getInstance().pauseDownload(this)) {
            onTaskPaused();
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.dlmgr.WadlTask
    public synchronized void startDownload() {
        super.startDownload();
        QLog.d(TAG, 1, "startDownload businessId=" + this.businessId + ",downloaderTask=" + this.downloaderTask);
        if (this.downloaderTask == null) {
            this.downloaderTask = WadlAgentV2Adapter.getInstance().getDownloaderTask(this);
        }
        WadlAgentV2Adapter.getInstance().startDownload(this);
    }

    @Override // com.tencent.gamecenter.wadl.biz.entity.f
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("WadlTask{");
        stringBuffer.append("wadlParams=");
        stringBuffer.append(this.mWadlParams);
        stringBuffer.append(", businessId=");
        stringBuffer.append(this.businessId);
        stringBuffer.append(", taskStatus=");
        stringBuffer.append(this.taskStatus);
        stringBuffer.append(", fileSize=");
        stringBuffer.append(this.fileSize);
        stringBuffer.append(", downloadFileSize=");
        stringBuffer.append(this.downloadFileSize);
        stringBuffer.append(", downloadFilePath=");
        stringBuffer.append(this.downloadFilePath);
        stringBuffer.append(", createTime=");
        stringBuffer.append(this.createTime);
        stringBuffer.append(", errCode=");
        stringBuffer.append(this.errCode);
        stringBuffer.append(", isPausedByWifiDisconnected=");
        stringBuffer.append(this.isPausedByWifiDisconnected);
        stringBuffer.append(", isStartedUnderWifi=");
        stringBuffer.append(this.isStartedUnderWifi);
        stringBuffer.append(", downloaderTask=");
        stringBuffer.append(this.downloaderTask);
        stringBuffer.append(", interruptedFlag=");
        stringBuffer.append(this.interruptedFlag);
        stringBuffer.append(", speed=");
        stringBuffer.append(getAverageSpeed());
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
