package com.tencent.mobileqq.pic.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IPicDebugSettings extends QRouteApi {
    void cleanChatImageThumbs();

    void cleanChatImages();

    void cleanChatVideoThumbs();

    void cleanChatVideos();

    boolean isAvcodecInfoCache();

    boolean isMemoryImageCacheDisabled();

    boolean isSimulateFileImageExpire();

    boolean isSimulateFileVideoExpire();

    boolean isSimulateImageExpire();

    boolean isSimulateVideoExpire();

    boolean isVideoAutoPlayDisabled();

    void resetBubbleTime();

    void setAvcodecInfoCache(boolean z16);

    void setMemoryImageCacheDisabled(boolean z16);

    void setSimulateFileImageExpire(boolean z16);

    void setSimulateFileVideoExpire(boolean z16);

    void setSimulateImageExpire(boolean z16);

    void setSimulateVideoExpire(boolean z16);

    void setVideoAutoPlayDisabled(boolean z16);
}
