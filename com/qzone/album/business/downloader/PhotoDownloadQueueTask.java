package com.qzone.album.business.downloader;

import android.text.TextUtils;
import com.qzone.common.tool.ReportUtils;
import com.tencent.component.annotation.NeedParcel;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes39.dex */
public class PhotoDownloadQueueTask extends DownloaderQueueTask {

    @NeedParcel
    volatile ArrayList<String> downloadPhotoList;

    @NeedParcel
    volatile ArrayList<String> failDownloadPhotoList;

    @NeedParcel
    volatile ArrayList<String> hasLeaveDownloadList;

    @NeedParcel
    volatile int mRunningCount;

    @NeedParcel
    String mTaskId;

    /* loaded from: classes39.dex */
    class a implements com.qzone.homepage.ui.Facade.a {
        a() {
        }

        @Override // com.qzone.homepage.ui.Facade.a
        public void b(String str, int i3, int i16, String str2) {
            QZLog.d("[PhotoAlbum]downloadPhotoAndVideo", 2, "PhotoDownloadQueueTask onDownloadFailed url:", str2);
            if (!TextUtils.isEmpty(str2)) {
                PhotoDownloadQueueTask.this.failDownloadPhotoList.add(str2);
                PhotoDownloadQueueTask.this.hasLeaveDownloadList.remove(str2);
            }
            PhotoDownloadQueueTask.this.mRunningCount = i3 - i16;
            PhotoDownloadQueueTask.this.updateTask();
            PhotoDownloadQueueTask.this.notifyDownloadBox();
        }

        @Override // com.qzone.homepage.ui.Facade.a
        public void c(String str, int i3, int i16) {
            QZLog.d("[PhotoAlbum]downloadPhotoAndVideo", 2, "PhotoDownloadQueueTask onAllDownloadComplete fail size:", Integer.valueOf(PhotoDownloadQueueTask.this.failDownloadPhotoList.size()));
            PhotoDownloadQueueTask.this.mRunningCount = 0;
            PhotoDownloadQueueTask.this.reportBatchDownloadData(i3, i16);
            if (i3 == 0) {
                PhotoDownloadQueueTask.this.failDownloadPhotoList.clear();
                PhotoDownloadQueueTask.this.complete(true);
            } else {
                PhotoDownloadQueueTask.this.complete(false);
            }
        }

        @Override // com.qzone.homepage.ui.Facade.a
        public void d(String str, int i3, int i16, String str2) {
            QZLog.d("[PhotoAlbum]downloadPhotoAndVideo", 2, "PhotoDownloadQueueTask onDownloadCanceled url:", str2);
            if (!TextUtils.isEmpty(str2)) {
                PhotoDownloadQueueTask.this.failDownloadPhotoList.add(str2);
                PhotoDownloadQueueTask.this.hasLeaveDownloadList.remove(str2);
            }
            PhotoDownloadQueueTask.this.mRunningCount = i3 - i16;
            PhotoDownloadQueueTask.this.updateTask();
            PhotoDownloadQueueTask.this.notifyDownloadBox();
        }

        @Override // com.qzone.homepage.ui.Facade.a
        public void e(String str, int i3, int i16, String str2) {
            QZLog.d("[PhotoAlbum]downloadPhotoAndVideo", 2, "PhotoDownloadQueueTask onDownloadSucceed totalCount:", Integer.valueOf(i3), " curCount:", Integer.valueOf(i16));
            PhotoDownloadQueueTask.this.mRunningCount = i3 - i16;
            PhotoDownloadQueueTask.this.hasLeaveDownloadList.remove(str2);
            PhotoDownloadQueueTask.this.updateTask();
            PhotoDownloadQueueTask.this.notifyDownloadBox();
        }

        @Override // com.qzone.homepage.ui.Facade.a
        public void a(String str, int i3) {
        }
    }

    public PhotoDownloadQueueTask() {
        this.downloadPhotoList = new ArrayList<>();
        this.failDownloadPhotoList = new ArrayList<>();
        this.hasLeaveDownloadList = new ArrayList<>();
        this.mRunningCount = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportBatchDownloadData(int i3, int i16) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("failDownloadPhotoCounts", String.valueOf(i3));
        hashMap.put("successDownloadPhotoCounts", String.valueOf(i16));
        ReportUtils.b("batchDownload", hashMap);
    }

    @Override // com.qzone.album.business.downloader.IDownloadQueueTask
    public boolean cancel() {
        if (this.mRunningCount == 0) {
            return false;
        }
        u4.a.z().l(this.mTaskId, this.downloadPhotoList);
        return true;
    }

    @Override // com.qzone.album.business.downloader.IDownloadQueueTask
    public int getCount() {
        return this.downloadPhotoList.size();
    }

    @Override // com.qzone.album.business.downloader.IDownloadQueueTask
    public int getFailCount() {
        return this.failDownloadPhotoList.size();
    }

    @Override // com.qzone.album.business.downloader.IDownloadQueueTask
    public int getRunningCount() {
        return this.mRunningCount;
    }

    @Override // com.qzone.album.business.downloader.IDownloadQueueTask
    public int getType() {
        return 1;
    }

    @Override // com.qzone.album.business.downloader.IDownloadQueueTask
    public boolean isNullTask() {
        return this.downloadPhotoList.size() == 0 && this.failDownloadPhotoList.size() == 0;
    }

    @Override // com.qzone.album.business.downloader.IDownloadQueueTask
    public void run() {
        this.mTaskId = System.currentTimeMillis() + "";
        u4.a.z().u(this.mTaskId, new ArrayList(this.downloadPhotoList), new a());
    }

    @Override // com.qzone.album.business.downloader.IDownloadQueueTask
    public void onRestore() {
        QZLog.d("[PhotoAlbum]downloadPhotoAndVideo", 2, "PhotoDownloadQueueTask onRestore hasLeaveSize:", Integer.valueOf(this.hasLeaveDownloadList.size()), " fail size:", Integer.valueOf(this.failDownloadPhotoList.size()));
        ArrayList<String> arrayList = new ArrayList<>(this.hasLeaveDownloadList);
        ArrayList arrayList2 = new ArrayList(this.failDownloadPhotoList);
        ArrayList<String> arrayList3 = new ArrayList<>();
        arrayList3.addAll(arrayList);
        arrayList3.addAll(arrayList2);
        arrayList.addAll(arrayList2);
        this.downloadPhotoList = arrayList3;
        this.hasLeaveDownloadList = arrayList;
        this.failDownloadPhotoList = new ArrayList<>();
        this.mRunningCount = this.downloadPhotoList.size();
    }

    public PhotoDownloadQueueTask(ArrayList<String> arrayList) {
        this.downloadPhotoList = new ArrayList<>();
        this.failDownloadPhotoList = new ArrayList<>();
        this.hasLeaveDownloadList = new ArrayList<>();
        this.mRunningCount = 0;
        this.downloadPhotoList.addAll(arrayList);
        this.hasLeaveDownloadList.addAll(arrayList);
        this.mRunningCount = this.downloadPhotoList.size();
    }

    @Override // com.qzone.album.business.downloader.IDownloadQueueTask
    public void onResume() {
    }
}
