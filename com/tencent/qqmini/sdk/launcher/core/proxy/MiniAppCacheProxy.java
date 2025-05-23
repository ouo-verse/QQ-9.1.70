package com.tencent.qqmini.sdk.launcher.core.proxy;

/* loaded from: classes23.dex */
public interface MiniAppCacheProxy {

    /* loaded from: classes23.dex */
    public static class LinkData {
        public byte[] appInfo;
        public String shareTicket;

        public LinkData() {
        }

        public byte[] getAppInfo() {
            return this.appInfo;
        }

        public String getShareTicket() {
            return this.shareTicket;
        }

        public void setAppInfo(byte[] bArr) {
            this.appInfo = bArr;
        }

        public void setShareTicket(String str) {
            this.shareTicket = str;
        }

        public LinkData(byte[] bArr, String str) {
            this.appInfo = bArr;
            this.shareTicket = str;
        }
    }

    boolean deleteCacheByTimeStamp(long j3);

    boolean enableMiniAppCache();

    long getDeleteIntervalTime();

    byte[] getIdInfo(String str, String str2);

    LinkData getLinkInfo(String str, int i3);

    boolean saveIdInfo(String str, String str2, byte[] bArr, long j3);

    boolean saveLinkInfo(String str, int i3, String str2, byte[] bArr, long j3);
}
