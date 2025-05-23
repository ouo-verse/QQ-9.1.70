package com.tencent.gamematrix.gmcg.base.download.video;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.gamematrix.gmcg.base.helper.CGPersistHelper;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.utils.CGAppUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGSystemUtil;
import java.io.File;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGVideoDownloader {
    private static final String KEY_PERSIST_LOADING_VIDEO = ".key.persist.loading.video";
    private long downloadId;
    private CompleteReceiver mCompletedReceiver;
    private Context mContext;
    private DownloadManager mDownloadManager;
    private ResultListener mDownloadResultListener;
    private String mVideoSaveName;
    private String mVideoSavePath;
    private String mVideoUrl;
    private long startDownloadTime;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class CompleteReceiver extends BroadcastReceiver {
        CompleteReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getLongExtra("extra_download_id", -1L) == CGVideoDownloader.this.downloadId) {
                CGLog.i("CompleteReceiver video download success, url: " + CGVideoDownloader.this.mVideoUrl + ", address: " + CGVideoDownloader.this.mVideoSavePath + ", cast time: " + (System.currentTimeMillis() - CGVideoDownloader.this.startDownloadTime));
                CGVideoDownloader.this.mDownloadResultListener.onVideoDownloadResult(true, CGVideoDownloader.this.mVideoUrl, CGVideoDownloader.this.mVideoSavePath);
                CGVideoDownloader.this.mContext.unregisterReceiver(CGVideoDownloader.this.mCompletedReceiver);
                CGPersistHelper.removeKV(CGVideoDownloader.KEY_PERSIST_LOADING_VIDEO(CGVideoDownloader.this.mVideoUrl));
                CGVideoDownloader.this.mCompletedReceiver = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface ResultListener {
        void onVideoDownloadResult(boolean z16, String str, String str2);
    }

    public CGVideoDownloader(Context context) {
        this.mContext = context;
        this.mDownloadManager = (DownloadManager) context.getSystemService("download");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String KEY_PERSIST_LOADING_VIDEO(String str) {
        return ".key.persist.loading.video." + CGSystemUtil.encryptMd5(str.getBytes());
    }

    private void queryDownloadStatus(long j3, String str) {
        Cursor cursor = null;
        try {
            cursor = this.mDownloadManager.query(new DownloadManager.Query().setFilterById(j3));
            if (cursor != null && cursor.moveToFirst()) {
                int i3 = cursor.getInt(cursor.getColumnIndexOrThrow("bytes_so_far"));
                int i16 = cursor.getInt(cursor.getColumnIndexOrThrow("total_size"));
                int i17 = cursor.getInt(cursor.getColumnIndex("status"));
                if (i17 != 8) {
                    if (i17 == 16) {
                        CGLog.e("queryDownloadStatus failed! try to reload!");
                        this.mDownloadManager.remove(j3);
                        CGPersistHelper.removeKV(KEY_PERSIST_LOADING_VIDEO(this.mVideoUrl));
                        realDownloadVideo(str);
                    }
                } else {
                    if (this.mDownloadResultListener != null) {
                        CGLog.i("queryDownloadStatus video download success, url: " + this.mVideoUrl + ", address: " + this.mVideoSavePath);
                        this.mDownloadResultListener.onVideoDownloadResult(true, this.mVideoUrl, this.mVideoSavePath);
                    }
                    this.mContext.unregisterReceiver(this.mCompletedReceiver);
                    CGPersistHelper.removeKV(KEY_PERSIST_LOADING_VIDEO(this.mVideoUrl));
                }
                CGLog.i("queryDownloadStatus loadedSize: " + i3 + ", totalSize: " + i16 + ", state: " + i17);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private void realDownloadVideo(String str) {
        try {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.mVideoUrl));
            request.setNotificationVisibility(2);
            CGLog.i("downloadVideo url: " + this.mVideoUrl + ", savePath: " + this.mVideoSavePath);
            request.setVisibleInDownloadsUi(false);
            request.setDestinationInExternalFilesDir(this.mContext, "gmcg", this.mVideoSaveName);
            this.startDownloadTime = System.currentTimeMillis();
            this.downloadId = this.mDownloadManager.enqueue(request);
            CGPersistHelper.putKVasLong(KEY_PERSIST_LOADING_VIDEO(this.mVideoUrl), this.downloadId);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public void downloadVideo(String str, String str2, ResultListener resultListener) {
        this.mVideoUrl = str;
        this.mDownloadResultListener = resultListener;
        this.downloadId = CGPersistHelper.getKVasLong(KEY_PERSIST_LOADING_VIDEO(str), -1L);
        this.mVideoSaveName = str2 + ".mp4";
        this.mVideoSavePath = CGAppUtil.getAppVideoSaveDir() + File.separator + this.mVideoSaveName;
        if (this.mCompletedReceiver == null) {
            CompleteReceiver completeReceiver = new CompleteReceiver();
            this.mCompletedReceiver = completeReceiver;
            this.mContext.registerReceiver(completeReceiver, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
        }
        CGLog.i("downloadVideo url: " + str + ", downloadId: " + this.downloadId);
        long j3 = this.downloadId;
        if (j3 == -1) {
            realDownloadVideo(str2);
        } else {
            queryDownloadStatus(j3, str2);
        }
    }
}
