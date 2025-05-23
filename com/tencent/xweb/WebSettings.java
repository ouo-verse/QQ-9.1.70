package com.tencent.xweb;

import android.webkit.WebSettings;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class WebSettings {
    public static final int APP_BRAND_TYPE_NONE = 0;
    public static final int APP_BRAND_TYPE_WE_APP = 1;
    public static final int APP_BRAND_TYPE_WE_APP_EMBEDDED_HTML = 2;
    public static final int FORCE_DARK_OFF = 0;
    public static final int FORCE_DARK_ON = 2;
    public static final int FORCE_DARK_ONLY = 0;
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;

    @Deprecated
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_NO_CACHE = 2;
    public static final int MEDIA_QUERY_ONLY = 1;
    public static final int MIXED_CONTENT_ALWAYS_ALLOW = 0;
    public static final int MIXED_CONTENT_COMPATIBILITY_MODE = 2;
    public static final int MIXED_CONTENT_NEVER_ALLOW = 1;
    public static final int PREFER_MEDIA_QUERY_OVER_FORCE_DARK = 2;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public enum TextSize {
        SMALLEST(50),
        SMALLER(75),
        NORMAL(100),
        LARGER(150),
        LARGEST(200);


        /* renamed from: a, reason: collision with root package name */
        public int f384994a;

        TextSize(int i3) {
            this.f384994a = i3;
        }
    }

    public abstract void disableCustomizedLongPressTimeout();

    public abstract void enableCustomizedLongPressTimeout(int i3);

    public abstract boolean getAllowContentAccess();

    public abstract boolean getAllowFileAccess();

    public abstract boolean getAllowFileAccessFromFileURLs();

    public abstract boolean getAllowUniversalAccessFromFileURLs();

    public abstract Map<String, String> getAppBrandInfo();

    public abstract boolean getBackgroundAudioPause();

    public abstract boolean getBlockNetworkImage();

    public abstract boolean getBlockNetworkLoads();

    public abstract boolean getBuiltInZoomControls();

    public abstract int getCacheMode();

    public abstract String getCursiveFontFamily();

    public abstract boolean getDatabaseEnabled();

    @Deprecated
    public abstract String getDatabasePath();

    public abstract int getDefaultFixedFontSize();

    public abstract int getDefaultFontSize();

    public abstract String getDefaultTextEncodingName();

    public abstract int getDisabledActionModeMenuItems();

    public abstract boolean getDomStorageEnabled();

    public abstract String getFantasyFontFamily();

    public abstract String getFixedFontFamily();

    public abstract int getForceDarkBehavior();

    public abstract int getForceDarkMode();

    public abstract boolean getJavaScriptCanOpenWindowsAutomatically();

    public abstract boolean getJavaScriptEnabled();

    public abstract boolean getJavascriptCanAccessClipboard();

    public abstract WebSettings.LayoutAlgorithm getLayoutAlgorithm();

    public abstract boolean getLoadWithOverviewMode();

    public abstract boolean getLoadsImagesAutomatically();

    public abstract boolean getMediaPlaybackRequiresUserGesture();

    public abstract int getMinimumFontSize();

    public abstract int getMinimumLogicalFontSize();

    public abstract int getMixedContentMode();

    public abstract boolean getOffscreenPreRaster();

    public abstract boolean getSafeBrowsingEnabled();

    public abstract String getSansSerifFontFamily();

    public abstract boolean getSaveFormData();

    @Deprecated
    public abstract boolean getSavePassword();

    public abstract String getSerifFontFamily();

    public abstract String getStandardFontFamily();

    public synchronized TextSize getTextSize() {
        int textZoom = getTextZoom();
        TextSize textSize = null;
        int i3 = Integer.MAX_VALUE;
        for (TextSize textSize2 : TextSize.values()) {
            int abs = Math.abs(textZoom - textSize2.f384994a);
            if (abs == 0) {
                return textSize2;
            }
            if (abs < i3) {
                textSize = textSize2;
                i3 = abs;
            }
        }
        if (textSize == null) {
            textSize = TextSize.NORMAL;
        }
        return textSize;
    }

    public abstract int getTextZoom();

    @Deprecated
    public boolean getUseDoubleTree() {
        return false;
    }

    public abstract boolean getUseWideViewPort();

    public abstract String getUserAgentString();

    public abstract int getUsingForAppBrand();

    public abstract void setAllowContentAccess(boolean z16);

    public abstract void setAllowFileAccess(boolean z16);

    public abstract void setAllowFileAccessFromFileURLs(boolean z16);

    public abstract void setAllowUniversalAccessFromFileURLs(boolean z16);

    public abstract void setAppBrandInfo(Map<String, String> map);

    public abstract void setAppCacheEnabled(boolean z16);

    @Deprecated
    public abstract void setAppCacheMaxSize(long j3);

    public abstract void setAppCachePath(String str);

    public abstract void setAudioPlaybackRequiresUserGesture(boolean z16);

    public abstract void setBackgroundAudioPause(boolean z16);

    public abstract void setBlockNetworkImage(boolean z16);

    public abstract void setBlockNetworkLoads(boolean z16);

    public abstract void setBuiltInZoomControls(boolean z16);

    public abstract void setCacheMode(int i3);

    public abstract void setCursiveFontFamily(String str);

    public abstract void setDatabaseEnabled(boolean z16);

    @Deprecated
    public abstract void setDatabasePath(String str);

    public abstract void setDefaultFixedFontSize(int i3);

    public abstract void setDefaultFontSize(int i3);

    public abstract void setDefaultTextEncodingName(String str);

    public abstract void setDisabledActionModeMenuItems(int i3);

    public abstract void setDisplayZoomControls(boolean z16);

    public abstract void setDomStorageEnabled(boolean z16);

    public abstract void setFantasyFontFamily(String str);

    public abstract void setFixedFontFamily(String str);

    public abstract void setForceDarkBehavior(int i3);

    public abstract void setForceDarkMode(int i3);

    public abstract void setGeolocationEnabled(boolean z16);

    @Deprecated
    public abstract void setJavaScriptCanOpenWindowsAutomatically(boolean z16);

    public abstract void setJavaScriptEnabled(boolean z16);

    public abstract void setJavascriptCanAccessClipboard(boolean z16);

    public abstract void setLayoutAlgorithm(WebSettings.LayoutAlgorithm layoutAlgorithm);

    public abstract void setLoadWithOverviewMode(boolean z16);

    public abstract void setLoadsImagesAutomatically(boolean z16);

    public abstract void setMediaPlaybackRequiresUserGesture(boolean z16);

    public abstract void setMinimumFontSize(int i3);

    public abstract void setMinimumLogicalFontSize(int i3);

    public abstract void setMixedContentMode(int i3);

    public abstract void setNeedInitialFocus(boolean z16);

    public abstract void setOffscreenPreRaster(boolean z16);

    @Deprecated
    public abstract void setRenderPriority(WebSettings.RenderPriority renderPriority);

    public abstract void setSafeBrowsingEnabled(boolean z16);

    public abstract void setSansSerifFontFamily(String str);

    public abstract void setSaveFormData(boolean z16);

    @Deprecated
    public abstract void setSavePassword(boolean z16);

    public abstract void setSerifFontFamily(String str);

    public abstract void setStandardFontFamily(String str);

    public abstract void setSupportMultipleWindows(boolean z16);

    public abstract void setSupportZoom(boolean z16);

    public synchronized void setTextSize(TextSize textSize) {
        setTextZoom(textSize.f384994a);
    }

    public abstract void setTextZoom(int i3);

    public abstract void setUseWideViewPort(boolean z16);

    public abstract void setUserAgentString(String str);

    public abstract void setUsingForAppBrand(int i3);

    public abstract void setVideoHideDownloadUi(boolean z16);

    public abstract void setVideoPlaybackRequiresUserGesture(boolean z16);

    public abstract boolean supportMultipleWindows();

    public abstract boolean supportZoom();

    @Deprecated
    public void setUseDoubleTree(boolean z16) {
    }
}
