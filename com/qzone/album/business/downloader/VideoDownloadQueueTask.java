package com.qzone.album.business.downloader;

import android.text.TextUtils;
import androidx.core.util.Consumer;
import com.qzone.common.tool.ReportUtils;
import com.qzone.misc.network.downloader.i;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.biz.richframework.util.bean.RFWSaveMediaResultBean;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.oskplayer.util.VideoSpeedReport;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class VideoDownloadQueueTask extends DownloaderQueueTask {
    private static final String TAG = "VideoDownloadQueueTask";

    @NeedParcel
    ArrayList<String> downloadVideoList = new ArrayList<>(1);

    @NeedParcel
    ArrayList<String> failDownloadVideoList = new ArrayList<>(1);

    @NeedParcel
    ArrayList<String> hasLeaveDownloadList = new ArrayList<>(1);

    @NeedParcel
    int mDownloadCount;

    @NeedParcel
    int mFailCount;

    @NeedParcel
    int mTotalCount;

    public VideoDownloadQueueTask() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportBatchDownloadData(int i3, int i16) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("failDownloadVideoCounts", String.valueOf(i3));
        hashMap.put("successDownloadVideoCounts", String.valueOf(i16));
        ReportUtils.b("batchDownload", hashMap);
    }

    @Override // com.qzone.album.business.downloader.IDownloadQueueTask
    public boolean cancel() {
        u4.a.z().f();
        return true;
    }

    @Override // com.qzone.album.business.downloader.IDownloadQueueTask
    public int getCount() {
        return this.mTotalCount;
    }

    @Override // com.qzone.album.business.downloader.IDownloadQueueTask
    public int getFailCount() {
        return this.mFailCount;
    }

    @Override // com.qzone.album.business.downloader.IDownloadQueueTask
    public int getRunningCount() {
        if (this.mState == 51) {
            return this.mDownloadCount + this.mFailCount;
        }
        return this.mDownloadCount;
    }

    @Override // com.qzone.album.business.downloader.IDownloadQueueTask
    public int getType() {
        return 2;
    }

    @Override // com.qzone.album.business.downloader.IDownloadQueueTask
    public boolean isNullTask() {
        return this.downloadVideoList.size() == 0 && this.failDownloadVideoList.size() == 0;
    }

    public boolean removeLeaveDownloadList(String str) {
        String substring = str.substring(0, str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER));
        String substring2 = substring.substring(substring.lastIndexOf("/") + 1);
        QZLog.d("[PhotoAlbum]downloadPhotoAndVideo", 2, "removeLeaveDownloadList tmp:", substring2);
        for (int i3 = 0; i3 < this.hasLeaveDownloadList.size(); i3++) {
            if (this.hasLeaveDownloadList.get(i3).contains(substring2)) {
                QZLog.d("[PhotoAlbum]downloadPhotoAndVideo", 2, "removeLeaveDownloadList isdelete:", this.hasLeaveDownloadList.remove(i3));
                return true;
            }
        }
        return false;
    }

    public void removeUrlFromVideoPlay(String str) {
        com.tencent.mobileqq.qzoneplayer.videosource.b.b().stopPlay(PlayerUtils.getVideoUuidFromVideoUrl(str));
    }

    @Override // com.qzone.album.business.downloader.IDownloadQueueTask
    public void run() {
        int size = this.downloadVideoList.size();
        this.mTotalCount = size;
        this.mDownloadCount = size;
        VideoSpeedReport.ReportType.removeVideoReportType(VideoSpeedReport.ReportType.TYPE_VIDEO_PLAY);
        for (int i3 = 0; i3 < this.downloadVideoList.size(); i3++) {
            u4.a.z().v(this.downloadVideoList.get(i3), new a(this.downloadVideoList.get(i3)), null);
        }
    }

    @Override // com.qzone.album.business.downloader.IDownloadQueueTask
    public void onRestore() {
        QZLog.d("[PhotoAlbum]downloadPhotoAndVideo", 2, "VideoDownloadQueueTask onRestore hasLeaveSize:", Integer.valueOf(this.hasLeaveDownloadList.size()), " fail size:", Integer.valueOf(this.failDownloadVideoList.size()));
        this.mFailCount = 0;
        this.mDownloadCount = 0;
        this.downloadVideoList.clear();
        for (int i3 = 0; i3 < this.hasLeaveDownloadList.size(); i3++) {
            this.downloadVideoList.add(new String(this.hasLeaveDownloadList.get(i3)));
        }
        for (int i16 = 0; i16 < this.failDownloadVideoList.size(); i16++) {
            QZLog.d("[PhotoAlbum]downloadPhotoAndVideo", 2, "failDownloadVideoList url:", this.failDownloadVideoList.get(i16));
            this.downloadVideoList.add(new String(this.failDownloadVideoList.get(i16)));
            this.hasLeaveDownloadList.add(new String(this.failDownloadVideoList.get(i16)));
        }
        this.failDownloadVideoList.clear();
        this.mDownloadCount = this.downloadVideoList.size();
    }

    public VideoDownloadQueueTask(ArrayList<String> arrayList) {
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            this.downloadVideoList.add(new String(arrayList.get(i3)));
            this.hasLeaveDownloadList.add(new String(arrayList.get(i3)));
        }
        this.mDownloadCount = this.downloadVideoList.size();
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements i.f {

        /* renamed from: a, reason: collision with root package name */
        String f42412a;

        public a(String str) {
            this.f42412a = str;
        }

        @Override // com.qzone.misc.network.downloader.i.f
        public void A(String str, int i3, String str2) {
            VideoDownloadQueueTask videoDownloadQueueTask = VideoDownloadQueueTask.this;
            videoDownloadQueueTask.mFailCount++;
            int i16 = videoDownloadQueueTask.mDownloadCount - 1;
            videoDownloadQueueTask.mDownloadCount = i16;
            QZLog.d("[PhotoAlbum]downloadPhotoAndVideo", 2, "VideoDownloadQueueTask onDownloadFailed mDownloadCount:", Integer.valueOf(i16), " mFailCount:", Integer.valueOf(VideoDownloadQueueTask.this.mFailCount), " url:", str, "\norginUrl:", this.f42412a);
            VideoDownloadQueueTask.this.failDownloadVideoList.add(this.f42412a);
            VideoDownloadQueueTask.this.removeLeaveDownloadList(str);
            VideoDownloadQueueTask.this.removeUrlFromVideoPlay(str);
            VideoDownloadQueueTask.this.updateTask();
            VideoDownloadQueueTask videoDownloadQueueTask2 = VideoDownloadQueueTask.this;
            if (videoDownloadQueueTask2.mDownloadCount == 0) {
                videoDownloadQueueTask2.complete(false);
            } else {
                videoDownloadQueueTask2.notifyDownloadBox();
            }
            VideoDownloadQueueTask.this.reportBatchDownloadData(1, 0);
        }

        @Override // com.qzone.misc.network.downloader.i.f
        public void x(String str) {
            VideoDownloadQueueTask videoDownloadQueueTask = VideoDownloadQueueTask.this;
            videoDownloadQueueTask.mFailCount++;
            videoDownloadQueueTask.mDownloadCount--;
            videoDownloadQueueTask.failDownloadVideoList.add(this.f42412a);
            VideoDownloadQueueTask.this.removeLeaveDownloadList(str);
            VideoDownloadQueueTask.this.removeUrlFromVideoPlay(str);
            QZLog.d("[PhotoAlbum]downloadPhotoAndVideo", 2, "VideoDownloadQueueTask onDownloadCancel mDownloadCount:", Integer.valueOf(VideoDownloadQueueTask.this.mDownloadCount), " mFailCount:", Integer.valueOf(VideoDownloadQueueTask.this.mFailCount), " url:", str, "\norginUrl:", this.f42412a);
            VideoDownloadQueueTask.this.complete(false);
        }

        @Override // com.qzone.misc.network.downloader.i.f
        public void y(ArrayList<String> arrayList) {
            VideoDownloadQueueTask videoDownloadQueueTask = VideoDownloadQueueTask.this;
            int i3 = videoDownloadQueueTask.mDownloadCount - 1;
            videoDownloadQueueTask.mDownloadCount = i3;
            QZLog.d("[PhotoAlbum]downloadPhotoAndVideo", 2, "VideoDownloadQueueTask onAllDownloadSuccessful mDownloadCount:", Integer.valueOf(i3), " mFailCount:", Integer.valueOf(VideoDownloadQueueTask.this.mFailCount), " mTotalCount:", Integer.valueOf(VideoDownloadQueueTask.this.mTotalCount), " url:", arrayList.get(0));
            VideoDownloadQueueTask.this.removeUrlFromVideoPlay(arrayList.get(0));
            if (VideoDownloadQueueTask.this.hasLeaveDownloadList.size() > 0) {
                VideoDownloadQueueTask.this.hasLeaveDownloadList.remove(0);
            }
            VideoDownloadQueueTask videoDownloadQueueTask2 = VideoDownloadQueueTask.this;
            if (videoDownloadQueueTask2.mDownloadCount == 0) {
                if (videoDownloadQueueTask2.mFailCount == 0) {
                    VideoSpeedReport.ReportType.removeVideoReportType(VideoSpeedReport.ReportType.TYPE_VIDEO_PLAY);
                    VideoDownloadQueueTask.this.complete(true);
                } else {
                    videoDownloadQueueTask2.complete(false);
                }
            } else {
                videoDownloadQueueTask2.updateTask();
                VideoDownloadQueueTask.this.notifyDownloadBox();
            }
            VideoDownloadQueueTask.this.reportBatchDownloadData(0, 1);
        }

        @Override // com.qzone.misc.network.downloader.i.f
        public void z(String str) {
            if (TextUtils.isEmpty(str)) {
                QLog.e(VideoDownloadQueueTask.TAG, 2, "video path is empty");
                return;
            }
            QLog.i(VideoDownloadQueueTask.TAG, 2, "video path is " + str);
            RFWSaveUtil.insertMedia(BaseApplication.getContext(), str, new C0319a());
        }

        /* compiled from: P */
        /* renamed from: com.qzone.album.business.downloader.VideoDownloadQueueTask$a$a, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        class C0319a implements Consumer<RFWSaveMediaResultBean> {
            C0319a() {
            }

            @Override // androidx.core.util.Consumer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(RFWSaveMediaResultBean rFWSaveMediaResultBean) {
            }
        }
    }

    @Override // com.qzone.album.business.downloader.IDownloadQueueTask
    public void onResume() {
    }
}
