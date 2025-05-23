package com.tencent.richmediabrowser.log;

/* compiled from: P */
/* loaded from: classes25.dex */
public class BrowserLogHelper {
    private IBrowserLog mGalleryLog;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class SingletonHolder {
        private static final BrowserLogHelper INSTANCE = new BrowserLogHelper();

        SingletonHolder() {
        }
    }

    public static BrowserLogHelper getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public IBrowserLog getGalleryLog() {
        if (this.mGalleryLog == null) {
            this.mGalleryLog = new BrowserLog();
        }
        return this.mGalleryLog;
    }

    public void setLogProxy(IBrowserLog iBrowserLog) {
        this.mGalleryLog = iBrowserLog;
    }

    BrowserLogHelper() {
    }
}
