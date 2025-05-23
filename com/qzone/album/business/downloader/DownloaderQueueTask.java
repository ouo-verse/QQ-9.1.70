package com.qzone.album.business.downloader;

import com.tencent.component.annotation.NeedParcel;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class DownloaderQueueTask implements IDownloadQueueTask {
    public static final int STATE_CANCEL = 6;
    public static final int STATE_ERROR = 3;
    public static final int STATE_FINISH = 2;
    public static final int STATE_PAUSE = 5;
    public static final int STATE_PAUSE_VISIABLE = 51;
    public static final int STATE_RUNNING = 1;
    public static final int STATE_TIME_ERROR = 4;
    public static final int STATE_WAITTING = 0;
    public static final int TYPE_PHOTO = 1;
    public static final int TYPE_VIDEO = 2;

    @NeedParcel
    int mState;

    @NeedParcel
    long mTaskId;

    @NeedParcel
    public long mTime = 0;

    @NeedParcel
    int type;

    @Override // com.qzone.album.business.downloader.IDownloadQueueTask
    public int getState() {
        return this.mState;
    }

    @Override // com.qzone.album.business.downloader.IDownloadQueueTask
    public long getTaskId() {
        return this.mTaskId;
    }

    @Override // com.qzone.album.business.downloader.IDownloadQueueTask
    public long getTime() {
        return this.mTime;
    }

    public void notifyDownloadBox() {
        DownloadQueue.j().n();
    }

    @Override // com.qzone.album.business.downloader.IDownloadQueueTask
    public void setState(int i3) {
        this.mState = i3;
    }

    @Override // com.qzone.album.business.downloader.IDownloadQueueTask
    public void setTaskId(long j3) {
        this.mTaskId = j3;
    }

    @Override // com.qzone.album.business.downloader.IDownloadQueueTask
    public void setTime(long j3) {
        this.mTime = j3;
    }

    @Override // com.qzone.album.business.downloader.IDownloadQueueTask
    public void updateTask() {
        DownloadTaskManager.i().A(this);
    }

    public void complete(boolean z16) {
        QZLog.d("[PhotoAlbum]downloadPhotoAndVideo", 2, "complete task:", this, " suceess:", Boolean.valueOf(z16));
        DownloadQueue.j().d(this, z16);
    }
}
