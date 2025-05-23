package com.tencent.smtt.export.external.interfaces;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IX5WebSettings {
    public static final int DEFAULT_CACHE_CAPACITY = 15;
    public static final int LOAD_CACHE_AD = 100;
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_NO_CACHE = 2;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public enum LayoutAlgorithm {
        NORMAL,
        SINGLE_COLUMN,
        NARROW_COLUMNS
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public enum PluginState {
        ON,
        ON_DEMAND,
        OFF
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public enum RenderPriority {
        NORMAL,
        HIGH,
        LOW
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public enum TextSize {
        SMALLEST(50),
        SMALLER(75),
        NORMAL(100),
        LARGER(125),
        LARGEST(150);

        int value;

        TextSize(int i3) {
            this.value = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public enum ZoomDensity {
        FAR(150),
        MEDIUM(100),
        CLOSE(75);

        int value;

        ZoomDensity(int i3) {
            this.value = i3;
        }
    }

    boolean enableSmoothTransition();

    boolean getAllowContentAccess();

    boolean getAllowFileAccess();

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

    ZoomDensity getDefaultZoom();

    boolean getDisplayZoomControls();

    boolean getDomStorageEnabled();

    String getFantasyFontFamily();

    String getFixedFontFamily();

    boolean getJavaScriptCanOpenWindowsAutomatically();

    boolean getJavaScriptEnabled();

    LayoutAlgorithm getLayoutAlgorithm();

    boolean getLightTouchEnabled();

    boolean getLoadWithOverviewMode();

    boolean getLoadsImagesAutomatically();

    boolean getMediaPlaybackRequiresUserGesture();

    int getMinimumFontSize();

    int getMinimumLogicalFontSize();

    int getMixedContentMode();

    boolean getNavDump();

    PluginState getPluginState();

    boolean getPluginsEnabled();

    String getPluginsPath();

    boolean getSafeBrowsingEnabled();

    String getSansSerifFontFamily();

    boolean getSaveFormData();

    boolean getSavePassword();

    String getSerifFontFamily();

    String getStandardFontFamily();

    TextSize getTextSize();

    int getTextZoom();

    boolean getUseWebViewBackgroundForOverscrollBackground();

    boolean getUseWideViewPort();

    String getUserAgent();

    String getUserAgentString();

    void setAllowContentAccess(boolean z16);

    void setAllowFileAccess(boolean z16);

    void setAllowFileAccessFromFileURLs(boolean z16);

    void setAllowUniversalAccessFromFileURLs(boolean z16);

    void setAppCacheEnabled(boolean z16);

    void setAppCacheMaxSize(long j3);

    void setAppCachePath(String str);

    void setBlockNetworkImage(boolean z16);

    void setBlockNetworkLoads(boolean z16);

    void setBuiltInZoomControls(boolean z16);

    void setCacheMode(int i3);

    void setCursiveFontFamily(String str);

    void setDatabaseEnabled(boolean z16);

    void setDatabasePath(String str);

    void setDefaultDatabasePath(boolean z16);

    void setDefaultFixedFontSize(int i3);

    void setDefaultFontSize(int i3);

    void setDefaultTextEncodingName(String str);

    void setDefaultZoom(ZoomDensity zoomDensity);

    void setDisplayZoomControls(boolean z16);

    void setDomStorageEnabled(boolean z16);

    void setEnableSmoothTransition(boolean z16);

    void setFantasyFontFamily(String str);

    void setFixedFontFamily(String str);

    void setGeolocationDatabasePath(String str);

    void setGeolocationEnabled(boolean z16);

    void setJavaScriptCanOpenWindowsAutomatically(boolean z16);

    void setJavaScriptEnabled(boolean z16);

    void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm);

    void setLightTouchEnabled(boolean z16);

    void setLoadWithOverviewMode(boolean z16);

    void setLoadsImagesAutomatically(boolean z16);

    void setMediaPlaybackRequiresUserGesture(boolean z16);

    void setMinimumFontSize(int i3);

    void setMinimumLogicalFontSize(int i3);

    void setNavDump(boolean z16);

    void setNeedInitialFocus(boolean z16);

    void setPluginEnabled(boolean z16);

    void setPluginState(PluginState pluginState);

    void setPluginsEnabled(boolean z16);

    void setPluginsPath(String str);

    void setRenderPriority(RenderPriority renderPriority);

    void setSafeBrowsingEnabled(boolean z16);

    void setSansSerifFontFamily(String str);

    void setSaveFormData(boolean z16);

    void setSavePassword(boolean z16);

    void setSerifFontFamily(String str);

    void setStandardFontFamily(String str);

    void setSupportMultipleWindows(boolean z16);

    void setSupportZoom(boolean z16);

    void setTextSize(TextSize textSize);

    void setTextZoom(int i3);

    void setUseWebViewBackgroundForOverscrollBackground(boolean z16);

    void setUseWideViewPort(boolean z16);

    void setUserAgent(String str);

    void setUserAgent(String str, boolean z16);

    void setUserAgentString(String str);

    boolean supportMultipleWindows();

    boolean supportZoom();
}
