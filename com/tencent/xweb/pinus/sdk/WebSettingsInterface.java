package com.tencent.xweb.pinus.sdk;

import android.webkit.WebSettings;
import com.tencent.xweb.XWEB_BUILDFLAG;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface WebSettingsInterface {
    @XWEB_BUILDFLAG.XWEB_LONG_PRESS_TIME_CUSTOMIZE
    void disableCustomizedLongPressTimeout();

    @XWEB_BUILDFLAG.XWEB_LONG_PRESS_TIME_CUSTOMIZE
    void enableCustomizedLongPressTimeout(int i3);

    boolean getAllowContentAccess();

    boolean getAllowFileAccess();

    boolean getAllowFileAccessFromFileURLs();

    boolean getAllowUniversalAccessFromFileURLs();

    @XWEB_BUILDFLAG.XWEB_COMMON
    Map<String, String> getAppBrandInfo();

    @XWEB_BUILDFLAG.XWEB_AUDIO_AUTOPLAY_FLAG
    boolean getAudioPlaybackRequiresUserGesture();

    @XWEB_BUILDFLAG.XWEB_BACKGROUND_AUDIO_PAUSE
    boolean getBackgroundAudioPause();

    boolean getBlockNetworkImage();

    boolean getBlockNetworkLoads();

    boolean getBuiltInZoomControls();

    int getCacheMode();

    String getCursiveFontFamily();

    boolean getDatabaseEnabled();

    String getDatabasePath();

    int getDefaultFixedFontSize();

    int getDefaultFontSize();

    String getDefaultTextEncodingName();

    int getDisabledActionModeMenuItems();

    boolean getDisplayZoomControls();

    boolean getDomStorageEnabled();

    String getFantasyFontFamily();

    String getFixedFontFamily();

    int getForceDark();

    @XWEB_BUILDFLAG.XWEB_DARK_MODE
    int getForceDarkBehavior();

    @XWEB_BUILDFLAG.XWEB_DARK_MODE
    int getForceDarkMode();

    boolean getJavaScriptCanOpenWindowsAutomatically();

    boolean getJavaScriptEnabled();

    @XWEB_BUILDFLAG.XWEB_JAVASCRIPT_CAN_ACCESS_CLIPBOARD
    boolean getJavascriptCanAccessClipboard();

    WebSettings.LayoutAlgorithm getLayoutAlgorithm();

    boolean getLoadWithOverviewMode();

    boolean getLoadsImagesAutomatically();

    boolean getMediaPlaybackRequiresUserGesture();

    int getMinimumFontSize();

    int getMinimumLogicalFontSize();

    int getMixedContentMode();

    boolean getOffscreenPreRaster();

    boolean getSafeBrowsingEnabled();

    String getSansSerifFontFamily();

    boolean getSaveFormData();

    boolean getSavePassword();

    String getSerifFontFamily();

    String getStandardFontFamily();

    int getTextZoom();

    boolean getUseWideViewPort();

    String getUserAgentString();

    @XWEB_BUILDFLAG.XWEB_COMMON
    int getUsingForAppBrand();

    @XWEB_BUILDFLAG.XWEB_VIDEO_AUTOPLAY_FLAG
    boolean getVideoPlaybackRequiresUserGesture();

    void setAllowContentAccess(boolean z16);

    void setAllowFileAccess(boolean z16);

    void setAllowFileAccessFromFileURLs(boolean z16);

    void setAllowUniversalAccessFromFileURLs(boolean z16);

    @XWEB_BUILDFLAG.XWEB_COMMON
    void setAppBrandInfo(Map<String, String> map);

    void setAppCacheEnabled(boolean z16);

    void setAppCacheMaxSize(long j3);

    void setAppCachePath(String str);

    @XWEB_BUILDFLAG.XWEB_AUDIO_AUTOPLAY_FLAG
    void setAudioPlaybackRequiresUserGesture(boolean z16);

    @XWEB_BUILDFLAG.XWEB_BACKGROUND_AUDIO_PAUSE
    void setBackgroundAudioPause(boolean z16);

    void setBlockNetworkImage(boolean z16);

    void setBlockNetworkLoads(boolean z16);

    void setBuiltInZoomControls(boolean z16);

    void setCacheMode(int i3);

    void setCursiveFontFamily(String str);

    void setDatabaseEnabled(boolean z16);

    void setDatabasePath(String str);

    void setDefaultFixedFontSize(int i3);

    void setDefaultFontSize(int i3);

    void setDefaultTextEncodingName(String str);

    void setDisabledActionModeMenuItems(int i3);

    void setDisplayZoomControls(boolean z16);

    void setDomStorageEnabled(boolean z16);

    void setFantasyFontFamily(String str);

    void setFixedFontFamily(String str);

    void setForceDark(int i3);

    @XWEB_BUILDFLAG.XWEB_DARK_MODE
    void setForceDarkBehavior(int i3);

    @XWEB_BUILDFLAG.XWEB_DARK_MODE
    void setForceDarkMode(int i3);

    void setGeolocationEnabled(boolean z16);

    void setJavaScriptCanOpenWindowsAutomatically(boolean z16);

    void setJavaScriptEnabled(boolean z16);

    @XWEB_BUILDFLAG.XWEB_JAVASCRIPT_CAN_ACCESS_CLIPBOARD
    void setJavascriptCanAccessClipboard(boolean z16);

    void setLayoutAlgorithm(WebSettings.LayoutAlgorithm layoutAlgorithm);

    void setLoadWithOverviewMode(boolean z16);

    void setLoadsImagesAutomatically(boolean z16);

    void setMediaPlaybackRequiresUserGesture(boolean z16);

    void setMinimumFontSize(int i3);

    void setMinimumLogicalFontSize(int i3);

    void setMixedContentMode(int i3);

    void setNeedInitialFocus(boolean z16);

    void setOffscreenPreRaster(boolean z16);

    void setSafeBrowsingEnabled(boolean z16);

    void setSansSerifFontFamily(String str);

    void setSaveFormData(boolean z16);

    void setSavePassword(boolean z16);

    void setSerifFontFamily(String str);

    void setStandardFontFamily(String str);

    void setSupportMultipleWindows(boolean z16);

    void setSupportZoom(boolean z16);

    void setTextZoom(int i3);

    void setUseWideViewPort(boolean z16);

    void setUserAgentString(String str);

    @XWEB_BUILDFLAG.XWEB_COMMON
    void setUsingForAppBrand(int i3);

    @XWEB_BUILDFLAG.XWEB_VIDEO_HIDE_DOWNLOAD_UI
    void setVideoHideDownloadUi(boolean z16);

    @XWEB_BUILDFLAG.XWEB_VIDEO_AUTOPLAY_FLAG
    void setVideoPlaybackRequiresUserGesture(boolean z16);

    boolean supportMultipleWindows();

    boolean supportZoom();
}
