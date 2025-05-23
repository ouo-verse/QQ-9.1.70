package com.tencent.smtt.export.external.extension.interfaces;

import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IX5WebSettingsExtension {
    public static final int PicModel_NORMAL = 1;
    public static final int PicModel_NetNoPic = 3;
    public static final int PicModel_NoPic = 2;

    void customDiskCachePathEnabled(boolean z16, String str);

    boolean getBlockLocalAddressEnable();

    boolean getPageSolarEnableFlag();

    boolean isFitScreen();

    boolean isReadModeWebView();

    boolean isWapSitePreferred();

    boolean isWebViewInBackground();

    void setARModeEnable(boolean z16);

    void setAcceptCookie(boolean z16);

    void setAdditionalHttpHeaders(Map<String, String> map);

    void setAutoDetectToOpenFitScreenEnabled(boolean z16);

    void setAutoRecoredAndRestoreScaleEnabled(boolean z16);

    void setBlockLocalAddressEnable(boolean z16);

    void setContentCacheEnable(boolean z16);

    void setDayOrNight(boolean z16);

    void setDisplayCutoutEnable(boolean z16);

    void setEnableUnderLine(boolean z16);

    void setFirstScreenDetect(boolean z16);

    void setFirstScreenSoftwareTextureDraw(boolean z16);

    void setFitScreen(boolean z16);

    void setForcePinchScaleEnabled(boolean z16);

    void setFramePerformanceRecordEnable(boolean z16);

    boolean setHttpDnsDomains(List<String> list);

    void setImageScanEnable(boolean z16);

    void setImgAsDownloadFile(boolean z16);

    void setIsViewSourceMode(boolean z16);

    void setJSPerformanceRecordEnable(boolean z16);

    void setJavaScriptOpenWindowsBlockedNotifyEnabled(boolean z16);

    void setOnContextMenuEnable(boolean z16);

    void setOnlyDomTreeBuild(boolean z16);

    void setPageCacheCapacity(int i3);

    void setPageSolarEnableFlag(boolean z16);

    void setPicModel(int i3);

    void setPreFectch(boolean z16);

    void setPreFectchEnableWhenHasMedia(boolean z16);

    void setReadModeWebView(boolean z16);

    void setRecordRequestEnabled(boolean z16);

    void setRememberScaleValue(boolean z16);

    void setSelectionColorEnabled(boolean z16);

    void setShouldRequestFavicon(boolean z16);

    void setShouldTrackVisitedLinks(boolean z16);

    void setSmartFullScreenEnabled(boolean z16);

    void setTbsARShareType(int i3);

    void setTextDecorationUnlineEnabled(boolean z16);

    void setUseQProxy(boolean z16);

    void setWapSitePreferred(boolean z16);

    void setWebViewInBackground(boolean z16);
}
