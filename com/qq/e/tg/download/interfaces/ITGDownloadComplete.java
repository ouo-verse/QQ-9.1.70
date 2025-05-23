package com.qq.e.tg.download.interfaces;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface ITGDownloadComplete {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class ApkInfo {
        public String appName;
        public String logoUrl;
        public int taskId;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface InstallNotification {
        void toInstall(int i3);
    }

    void onComplete(InstallNotification installNotification, ApkInfo apkInfo);
}
