package com.tencent.upload.uinterface;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IUploadConfig {

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class UploadImageSize {
        static IPatchRedirector $redirector_;
        public int height;
        public int quality;
        public int width;

        public UploadImageSize(int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            this.width = i3;
            this.height = i16;
            this.quality = i17;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "[width=" + this.width + ", height=" + this.height + ", quality=" + this.quality + "]";
        }
    }

    boolean canHoldSystemLock();

    boolean checkApnChangeForInit();

    boolean enableBitmapNativeAlloc();

    boolean enableV6Route();

    int getAppId();

    String getChangeRouteRetCodes();

    int getCompressToWebpFlag();

    int getConnectTimeout();

    long getCurrentUin();

    int getDataTimeout();

    String getDeviceInfo();

    int getDoNotFragment();

    String getExifTagCode(String str);

    int getGifUploadLimit(int i3);

    String getMaxSegmentSizeArray();

    String getMobileLogUrl();

    String getMobileLogUrlV6();

    String getNetworkUnavailableRetCodes();

    String getOtherBakUrl();

    String getOtherHostUrl();

    String getOtherOptUrl();

    String getOtherOptUrlV6();

    String getPhotoBakUrl();

    String getPhotoHostUrl();

    String getPhotoHostUrlV6();

    String getPhotoOptUrl();

    String getPhotoOptUrlV6();

    float getPictureQuality(String str);

    String getQUA3();

    long getRecentRouteExpire();

    int getTimeoutRetryCount();

    UploadImageSize getUploadImageSize(UploadImageSize uploadImageSize, int i3, AbstractUploadTask abstractUploadTask);

    String getUploadPort();

    String getVideoBakUrl();

    String getVideoHostUrl();

    String getVideoHostUrlV6();

    String getVideoOptUrl();

    String getVideoOptUrlV6();

    int getWifiOperator();

    long getWtAppId();

    boolean isNeedReleasePool();

    boolean isPictureNeedToCompress(String str);

    boolean isReleaseMode();

    boolean isSwitchOn(String str);

    String loadAsString(String str, String str2);

    boolean useNewCopyExif();
}
