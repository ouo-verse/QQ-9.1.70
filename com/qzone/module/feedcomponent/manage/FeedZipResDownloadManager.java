package com.qzone.module.feedcomponent.manage;

import android.graphics.drawable.Drawable;
import cooperation.vip.vipcomponent.util.ZipResDownloadManager;
import cooperation.vip.vipcomponent.util.e;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedZipResDownloadManager {
    private static FeedZipResDownloadManager instance;
    private ZipResDownloadManager mZipResDownloadManager;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface FeedZipResDownloadListener {
        void onDownloaded(String str, String str2);

        void onFailed(String str);
    }

    FeedZipResDownloadManager() {
        this.mZipResDownloadManager = null;
        this.mZipResDownloadManager = ZipResDownloadManager.C();
    }

    public static FeedZipResDownloadManager getInstance() {
        if (instance == null) {
            instance = new FeedZipResDownloadManager();
        }
        return instance;
    }

    public String getUnzippedFolderPath(String str, final FeedZipResDownloadListener feedZipResDownloadListener) {
        return this.mZipResDownloadManager.A(str, new e() { // from class: com.qzone.module.feedcomponent.manage.FeedZipResDownloadManager.1
            @Override // cooperation.vip.vipcomponent.util.e
            public void onDownloaded(String str2, int i3, String str3, Drawable drawable) {
                FeedZipResDownloadListener feedZipResDownloadListener2 = feedZipResDownloadListener;
                if (feedZipResDownloadListener2 != null) {
                    feedZipResDownloadListener2.onDownloaded(str2, str3);
                }
            }

            @Override // cooperation.vip.vipcomponent.util.e
            public void onFailed(String str2, int i3, String str3) {
                FeedZipResDownloadListener feedZipResDownloadListener2 = feedZipResDownloadListener;
                if (feedZipResDownloadListener2 != null) {
                    feedZipResDownloadListener2.onFailed(str2);
                }
            }
        });
    }

    public void preDownloadZipImage(String str) {
        this.mZipResDownloadManager.G(str);
    }
}
