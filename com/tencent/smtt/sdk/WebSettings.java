package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings;

/* compiled from: P */
/* loaded from: classes23.dex */
public class WebSettings {
    public static final int FORCE_DARK_AUTO = 1;
    public static final int FORCE_DARK_OFF = 0;
    public static final int FORCE_DARK_ON = 2;
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_NO_CACHE = 2;

    /* renamed from: a, reason: collision with root package name */
    private IX5WebSettings f369201a;

    /* renamed from: b, reason: collision with root package name */
    private android.webkit.WebSettings f369202b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f369203c;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public enum LayoutAlgorithm {
        NORMAL,
        SINGLE_COLUMN,
        NARROW_COLUMNS
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public enum PluginState {
        ON,
        ON_DEMAND,
        OFF
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public enum RenderPriority {
        NORMAL,
        HIGH,
        LOW
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
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
    /* loaded from: classes23.dex */
    public enum ZoomDensity {
        FAR(150),
        MEDIUM(100),
        CLOSE(75);

        int value;

        ZoomDensity(int i3) {
            this.value = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSettings(IX5WebSettings iX5WebSettings) {
        this.f369201a = iX5WebSettings;
        this.f369202b = null;
        this.f369203c = true;
    }

    @TargetApi(17)
    public static String getDefaultUserAgent(Context context) {
        if (p.a().b()) {
            return p.a().c().i(context);
        }
        Object a16 = com.tencent.smtt.utils.k.a((Class<?>) android.webkit.WebSettings.class, "getDefaultUserAgent", (Class<?>[]) new Class[]{Context.class}, context);
        if (a16 == null) {
            return null;
        }
        return (String) a16;
    }

    @Deprecated
    public boolean enableSmoothTransition() {
        android.webkit.WebSettings webSettings;
        Object a16;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.enableSmoothTransition();
        }
        if (z16 || (webSettings = this.f369202b) == null || (a16 = com.tencent.smtt.utils.k.a(webSettings, "enableSmoothTransition")) == null) {
            return false;
        }
        return ((Boolean) a16).booleanValue();
    }

    @TargetApi(11)
    public boolean getAllowContentAccess() {
        android.webkit.WebSettings webSettings;
        Object a16;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getAllowContentAccess();
        }
        if (z16 || (webSettings = this.f369202b) == null || (a16 = com.tencent.smtt.utils.k.a(webSettings, "getAllowContentAccess")) == null) {
            return false;
        }
        return ((Boolean) a16).booleanValue();
    }

    @TargetApi(3)
    public boolean getAllowFileAccess() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getAllowFileAccess();
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return webSettings.getAllowFileAccess();
        }
        return false;
    }

    public synchronized boolean getBlockNetworkImage() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getBlockNetworkImage();
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return webSettings.getBlockNetworkImage();
        }
        return false;
    }

    @TargetApi(8)
    public synchronized boolean getBlockNetworkLoads() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getBlockNetworkLoads();
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return webSettings.getBlockNetworkLoads();
        }
        return false;
    }

    @TargetApi(3)
    public boolean getBuiltInZoomControls() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getBuiltInZoomControls();
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return webSettings.getBuiltInZoomControls();
        }
        return false;
    }

    public int getCacheMode() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getCacheMode();
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return webSettings.getCacheMode();
        }
        return 0;
    }

    public synchronized String getCursiveFontFamily() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getCursiveFontFamily();
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return webSettings.getCursiveFontFamily();
        }
        return "";
    }

    @TargetApi(5)
    public synchronized boolean getDatabaseEnabled() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getDatabaseEnabled();
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return webSettings.getDatabaseEnabled();
        }
        return false;
    }

    @TargetApi(5)
    @Deprecated
    public synchronized String getDatabasePath() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getDatabasePath();
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return webSettings.getDatabasePath();
        }
        return "";
    }

    public synchronized int getDefaultFixedFontSize() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getDefaultFixedFontSize();
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return webSettings.getDefaultFixedFontSize();
        }
        return 0;
    }

    public synchronized int getDefaultFontSize() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getDefaultFontSize();
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return webSettings.getDefaultFontSize();
        }
        return 0;
    }

    public synchronized String getDefaultTextEncodingName() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getDefaultTextEncodingName();
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return webSettings.getDefaultTextEncodingName();
        }
        return "";
    }

    @TargetApi(7)
    @Deprecated
    public ZoomDensity getDefaultZoom() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return ZoomDensity.valueOf(iX5WebSettings.getDefaultZoom().name());
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return ZoomDensity.valueOf(webSettings.getDefaultZoom().name());
        }
        return null;
    }

    @TargetApi(11)
    public boolean getDisplayZoomControls() {
        android.webkit.WebSettings webSettings;
        Object a16;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getDisplayZoomControls();
        }
        if (z16 || (webSettings = this.f369202b) == null || (a16 = com.tencent.smtt.utils.k.a(webSettings, "getDisplayZoomControls")) == null) {
            return false;
        }
        return ((Boolean) a16).booleanValue();
    }

    @TargetApi(7)
    public synchronized boolean getDomStorageEnabled() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getDomStorageEnabled();
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return webSettings.getDomStorageEnabled();
        }
        return false;
    }

    public synchronized String getFantasyFontFamily() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getFantasyFontFamily();
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return webSettings.getFantasyFontFamily();
        }
        return "";
    }

    public synchronized String getFixedFontFamily() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getFixedFontFamily();
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return webSettings.getFixedFontFamily();
        }
        return "";
    }

    public synchronized boolean getJavaScriptCanOpenWindowsAutomatically() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getJavaScriptCanOpenWindowsAutomatically();
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return webSettings.getJavaScriptCanOpenWindowsAutomatically();
        }
        return false;
    }

    public synchronized boolean getJavaScriptEnabled() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getJavaScriptEnabled();
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return webSettings.getJavaScriptEnabled();
        }
        return false;
    }

    public synchronized LayoutAlgorithm getLayoutAlgorithm() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return LayoutAlgorithm.valueOf(iX5WebSettings.getLayoutAlgorithm().name());
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return LayoutAlgorithm.valueOf(webSettings.getLayoutAlgorithm().name());
        }
        return null;
    }

    @Deprecated
    public boolean getLightTouchEnabled() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getLightTouchEnabled();
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return webSettings.getLightTouchEnabled();
        }
        return false;
    }

    @TargetApi(7)
    public boolean getLoadWithOverviewMode() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getLoadWithOverviewMode();
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return webSettings.getLoadWithOverviewMode();
        }
        return false;
    }

    public synchronized boolean getLoadsImagesAutomatically() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getLoadsImagesAutomatically();
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return webSettings.getLoadsImagesAutomatically();
        }
        return false;
    }

    @TargetApi(17)
    public boolean getMediaPlaybackRequiresUserGesture() {
        android.webkit.WebSettings webSettings;
        Object a16;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getMediaPlaybackRequiresUserGesture();
        }
        if (z16 || (webSettings = this.f369202b) == null || (a16 = com.tencent.smtt.utils.k.a(webSettings, "getMediaPlaybackRequiresUserGesture")) == null) {
            return false;
        }
        return ((Boolean) a16).booleanValue();
    }

    public synchronized int getMinimumFontSize() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getMinimumFontSize();
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return webSettings.getMinimumFontSize();
        }
        return 0;
    }

    public synchronized int getMinimumLogicalFontSize() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getMinimumLogicalFontSize();
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return webSettings.getMinimumLogicalFontSize();
        }
        return 0;
    }

    public synchronized int getMixedContentMode() {
        IX5WebSettings iX5WebSettings;
        int i3 = -1;
        if (this.f369203c && (iX5WebSettings = this.f369201a) != null) {
            try {
                return iX5WebSettings.getMixedContentMode();
            } catch (Throwable th5) {
                th5.printStackTrace();
                return -1;
            }
        }
        Object a16 = com.tencent.smtt.utils.k.a(this.f369202b, "getMixedContentMode", (Class<?>[]) new Class[0], new Object[0]);
        if (a16 != null) {
            i3 = ((Integer) a16).intValue();
        }
        return i3;
    }

    @Deprecated
    public boolean getNavDump() {
        android.webkit.WebSettings webSettings;
        Object a16;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getNavDump();
        }
        if (z16 || (webSettings = this.f369202b) == null || (a16 = com.tencent.smtt.utils.k.a(webSettings, "getNavDump")) == null) {
            return false;
        }
        return ((Boolean) a16).booleanValue();
    }

    @TargetApi(8)
    @Deprecated
    public synchronized PluginState getPluginState() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return PluginState.valueOf(iX5WebSettings.getPluginState().name());
        }
        if (z16 || (webSettings = this.f369202b) == null) {
            return null;
        }
        Object a16 = com.tencent.smtt.utils.k.a(webSettings, "getPluginState");
        if (a16 == null) {
            return null;
        }
        return PluginState.valueOf(((WebSettings.PluginState) a16).name());
    }

    @TargetApi(8)
    @Deprecated
    public synchronized boolean getPluginsEnabled() {
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (!z16 || (iX5WebSettings = this.f369201a) == null) {
            return (z16 || this.f369202b == null) ? false : false;
        }
        return iX5WebSettings.getPluginsEnabled();
    }

    @Deprecated
    public synchronized String getPluginsPath() {
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getPluginsPath();
        }
        if (!z16 && this.f369202b != null) {
            return "";
        }
        return "";
    }

    public boolean getSafeBrowsingEnabled() {
        IX5WebSettings iX5WebSettings;
        android.webkit.WebSettings webSettings;
        boolean safeBrowsingEnabled;
        boolean z16 = this.f369203c;
        if (!z16 && (webSettings = this.f369202b) != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                safeBrowsingEnabled = webSettings.getSafeBrowsingEnabled();
                return safeBrowsingEnabled;
            }
            return false;
        }
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            try {
                return iX5WebSettings.getSafeBrowsingEnabled();
            } catch (Throwable th5) {
                th5.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public synchronized String getSansSerifFontFamily() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getSansSerifFontFamily();
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return webSettings.getSansSerifFontFamily();
        }
        return "";
    }

    @Deprecated
    public boolean getSaveFormData() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getSaveFormData();
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return webSettings.getSaveFormData();
        }
        return false;
    }

    @Deprecated
    public boolean getSavePassword() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getSavePassword();
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return webSettings.getSavePassword();
        }
        return false;
    }

    public synchronized String getSerifFontFamily() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getSerifFontFamily();
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return webSettings.getSerifFontFamily();
        }
        return "";
    }

    public synchronized String getStandardFontFamily() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getStandardFontFamily();
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return webSettings.getStandardFontFamily();
        }
        return "";
    }

    @Deprecated
    public TextSize getTextSize() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return TextSize.valueOf(iX5WebSettings.getTextSize().name());
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return TextSize.valueOf(webSettings.getTextSize().name());
        }
        return null;
    }

    @TargetApi(14)
    public synchronized int getTextZoom() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getTextZoom();
        }
        if (z16 || (webSettings = this.f369202b) == null) {
            return 0;
        }
        try {
            return webSettings.getTextZoom();
        } catch (Exception unused) {
            Object a16 = com.tencent.smtt.utils.k.a(this.f369202b, "getTextZoom");
            if (a16 == null) {
                return 0;
            }
            return ((Integer) a16).intValue();
        }
    }

    @Deprecated
    public boolean getUseWebViewBackgroundForOverscrollBackground() {
        android.webkit.WebSettings webSettings;
        Object a16;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getUseWebViewBackgroundForOverscrollBackground();
        }
        if (z16 || (webSettings = this.f369202b) == null || (a16 = com.tencent.smtt.utils.k.a(webSettings, "getUseWebViewBackgroundForOverscrollBackground")) == null) {
            return false;
        }
        return ((Boolean) a16).booleanValue();
    }

    public synchronized boolean getUseWideViewPort() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getUseWideViewPort();
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return webSettings.getUseWideViewPort();
        }
        return false;
    }

    @TargetApi(3)
    public String getUserAgentString() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.getUserAgentString();
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return webSettings.getUserAgentString();
        }
        return "";
    }

    public boolean isAlgorithmicDarkeningAllowed() {
        android.webkit.WebSettings webSettings;
        if (!this.f369203c && (webSettings = this.f369202b) != null && Build.VERSION.SDK_INT >= 33) {
            Object a16 = com.tencent.smtt.utils.k.a(webSettings, "isAlgorithmicDarkeningAllowed");
            if (a16 instanceof Boolean) {
                return ((Boolean) a16).booleanValue();
            }
            return false;
        }
        return false;
    }

    public void setAlgorithmicDarkeningAllowed(boolean z16) {
        android.webkit.WebSettings webSettings;
        if (!this.f369203c && (webSettings = this.f369202b) != null && Build.VERSION.SDK_INT >= 33) {
            com.tencent.smtt.utils.k.a(webSettings, "setAlgorithmicDarkeningAllowed", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z16));
        }
    }

    @TargetApi(11)
    public void setAllowContentAccess(boolean z16) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z17 = this.f369203c;
        if (z17 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setAllowContentAccess(z16);
        } else if (!z17 && (webSettings = this.f369202b) != null) {
            com.tencent.smtt.utils.k.a(webSettings, "setAllowContentAccess", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z16));
        }
    }

    @TargetApi(3)
    public void setAllowFileAccess(boolean z16) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z17 = this.f369203c;
        if (z17 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setAllowFileAccess(z16);
        } else if (!z17 && (webSettings = this.f369202b) != null) {
            webSettings.setAllowFileAccess(z16);
        }
    }

    @TargetApi(16)
    public void setAllowFileAccessFromFileURLs(boolean z16) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z17 = this.f369203c;
        if (z17 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setAllowFileAccessFromFileURLs(z16);
        } else if (!z17 && (webSettings = this.f369202b) != null) {
            com.tencent.smtt.utils.k.a(webSettings, "setAllowFileAccessFromFileURLs", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z16));
        }
    }

    @TargetApi(16)
    public void setAllowUniversalAccessFromFileURLs(boolean z16) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z17 = this.f369203c;
        if (z17 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setAllowUniversalAccessFromFileURLs(z16);
        } else if (!z17 && (webSettings = this.f369202b) != null) {
            com.tencent.smtt.utils.k.a(webSettings, "setAllowUniversalAccessFromFileURLs", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z16));
        }
    }

    @TargetApi(7)
    public void setAppCacheEnabled(boolean z16) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z17 = this.f369203c;
        if (z17 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setAppCacheEnabled(z16);
        } else if (!z17 && (webSettings = this.f369202b) != null) {
            webSettings.setAppCacheEnabled(z16);
        }
    }

    @TargetApi(7)
    @Deprecated
    public void setAppCacheMaxSize(long j3) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setAppCacheMaxSize(j3);
        } else if (!z16 && (webSettings = this.f369202b) != null) {
            webSettings.setAppCacheMaxSize(j3);
        }
    }

    @TargetApi(7)
    public void setAppCachePath(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setAppCachePath(str);
        } else if (!z16 && (webSettings = this.f369202b) != null) {
            webSettings.setAppCachePath(str);
        }
    }

    public void setBlockNetworkImage(boolean z16) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z17 = this.f369203c;
        if (z17 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setBlockNetworkImage(z16);
        } else if (!z17 && (webSettings = this.f369202b) != null) {
            webSettings.setBlockNetworkImage(z16);
        }
    }

    @TargetApi(8)
    public synchronized void setBlockNetworkLoads(boolean z16) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z17 = this.f369203c;
        if (z17 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setBlockNetworkLoads(z16);
        } else if (!z17 && (webSettings = this.f369202b) != null) {
            webSettings.setBlockNetworkLoads(z16);
        }
    }

    @TargetApi(3)
    public void setBuiltInZoomControls(boolean z16) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z17 = this.f369203c;
        if (z17 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setBuiltInZoomControls(z16);
        } else if (!z17 && (webSettings = this.f369202b) != null) {
            webSettings.setBuiltInZoomControls(z16);
        }
    }

    public void setCacheMode(int i3) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setCacheMode(i3);
        } else if (!z16 && (webSettings = this.f369202b) != null) {
            webSettings.setCacheMode(i3);
        }
    }

    public synchronized void setCursiveFontFamily(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setCursiveFontFamily(str);
        } else if (!z16 && (webSettings = this.f369202b) != null) {
            webSettings.setCursiveFontFamily(str);
        }
    }

    @TargetApi(5)
    public void setDatabaseEnabled(boolean z16) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z17 = this.f369203c;
        if (z17 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setDatabaseEnabled(z16);
        } else if (!z17 && (webSettings = this.f369202b) != null) {
            webSettings.setDatabaseEnabled(z16);
        }
    }

    @TargetApi(5)
    @Deprecated
    public void setDatabasePath(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setDatabasePath(str);
        } else if (!z16 && (webSettings = this.f369202b) != null) {
            com.tencent.smtt.utils.k.a(webSettings, "setDatabasePath", (Class<?>[]) new Class[]{String.class}, str);
        }
    }

    public synchronized void setDefaultFixedFontSize(int i3) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setDefaultFixedFontSize(i3);
        } else if (!z16 && (webSettings = this.f369202b) != null) {
            webSettings.setDefaultFixedFontSize(i3);
        }
    }

    public synchronized void setDefaultFontSize(int i3) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setDefaultFontSize(i3);
        } else if (!z16 && (webSettings = this.f369202b) != null) {
            webSettings.setDefaultFontSize(i3);
        }
    }

    public synchronized void setDefaultTextEncodingName(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setDefaultTextEncodingName(str);
        } else if (!z16 && (webSettings = this.f369202b) != null) {
            webSettings.setDefaultTextEncodingName(str);
        }
    }

    @TargetApi(7)
    @Deprecated
    public void setDefaultZoom(ZoomDensity zoomDensity) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setDefaultZoom(IX5WebSettings.ZoomDensity.valueOf(zoomDensity.name()));
        } else if (!z16 && (webSettings = this.f369202b) != null) {
            webSettings.setDefaultZoom(WebSettings.ZoomDensity.valueOf(zoomDensity.name()));
        }
    }

    @TargetApi(11)
    public void setDisplayZoomControls(boolean z16) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z17 = this.f369203c;
        if (z17 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setDisplayZoomControls(z16);
        } else if (!z17 && (webSettings = this.f369202b) != null) {
            com.tencent.smtt.utils.k.a(webSettings, "setDisplayZoomControls", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z16));
        }
    }

    @TargetApi(7)
    public void setDomStorageEnabled(boolean z16) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z17 = this.f369203c;
        if (z17 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setDomStorageEnabled(z16);
        } else if (!z17 && (webSettings = this.f369202b) != null) {
            webSettings.setDomStorageEnabled(z16);
        }
    }

    @TargetApi(11)
    @Deprecated
    public void setEnableSmoothTransition(boolean z16) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z17 = this.f369203c;
        if (z17 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setEnableSmoothTransition(z16);
        } else if (!z17 && (webSettings = this.f369202b) != null) {
            com.tencent.smtt.utils.k.a(webSettings, "setEnableSmoothTransition", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z16));
        }
    }

    public synchronized void setFantasyFontFamily(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setFantasyFontFamily(str);
        } else if (!z16 && (webSettings = this.f369202b) != null) {
            webSettings.setFantasyFontFamily(str);
        }
    }

    public synchronized void setFixedFontFamily(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setFixedFontFamily(str);
        } else if (!z16 && (webSettings = this.f369202b) != null) {
            webSettings.setFixedFontFamily(str);
        }
    }

    public void setForceDark(int i3) {
        android.webkit.WebSettings webSettings;
        if (!this.f369203c && (webSettings = this.f369202b) != null && Build.VERSION.SDK_INT >= 29) {
            com.tencent.smtt.utils.k.a(webSettings, "setForceDark", (Class<?>[]) new Class[]{Integer.TYPE}, Integer.valueOf(i3));
        }
    }

    @TargetApi(5)
    @Deprecated
    public void setGeolocationDatabasePath(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setGeolocationDatabasePath(str);
        } else if (!z16 && (webSettings = this.f369202b) != null) {
            webSettings.setGeolocationDatabasePath(str);
        }
    }

    @TargetApi(5)
    public void setGeolocationEnabled(boolean z16) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z17 = this.f369203c;
        if (z17 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setGeolocationEnabled(z16);
        } else if (!z17 && (webSettings = this.f369202b) != null) {
            webSettings.setGeolocationEnabled(z16);
        }
    }

    public synchronized void setJavaScriptCanOpenWindowsAutomatically(boolean z16) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z17 = this.f369203c;
        if (z17 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setJavaScriptCanOpenWindowsAutomatically(z16);
        } else if (!z17 && (webSettings = this.f369202b) != null) {
            webSettings.setJavaScriptCanOpenWindowsAutomatically(z16);
        }
    }

    @Deprecated
    public void setJavaScriptEnabled(boolean z16) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        try {
            boolean z17 = this.f369203c;
            if (z17 && (iX5WebSettings = this.f369201a) != null) {
                iX5WebSettings.setJavaScriptEnabled(z16);
            } else if (!z17 && (webSettings = this.f369202b) != null) {
                webSettings.setJavaScriptEnabled(z16);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setLayoutAlgorithm(IX5WebSettings.LayoutAlgorithm.valueOf(layoutAlgorithm.name()));
        } else if (!z16 && (webSettings = this.f369202b) != null) {
            webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.valueOf(layoutAlgorithm.name()));
        }
    }

    @Deprecated
    public void setLightTouchEnabled(boolean z16) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z17 = this.f369203c;
        if (z17 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setLightTouchEnabled(z16);
        } else if (!z17 && (webSettings = this.f369202b) != null) {
            webSettings.setLightTouchEnabled(z16);
        }
    }

    @TargetApi(7)
    public void setLoadWithOverviewMode(boolean z16) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z17 = this.f369203c;
        if (z17 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setLoadWithOverviewMode(z16);
        } else if (!z17 && (webSettings = this.f369202b) != null) {
            webSettings.setLoadWithOverviewMode(z16);
        }
    }

    public void setLoadsImagesAutomatically(boolean z16) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z17 = this.f369203c;
        if (z17 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setLoadsImagesAutomatically(z16);
        } else if (!z17 && (webSettings = this.f369202b) != null) {
            webSettings.setLoadsImagesAutomatically(z16);
        }
    }

    @TargetApi(17)
    public void setMediaPlaybackRequiresUserGesture(boolean z16) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z17 = this.f369203c;
        if (z17 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setMediaPlaybackRequiresUserGesture(z16);
        } else if (!z17 && (webSettings = this.f369202b) != null) {
            com.tencent.smtt.utils.k.a(webSettings, "setMediaPlaybackRequiresUserGesture", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z16));
        }
    }

    public synchronized void setMinimumFontSize(int i3) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setMinimumFontSize(i3);
        } else if (!z16 && (webSettings = this.f369202b) != null) {
            webSettings.setMinimumFontSize(i3);
        }
    }

    public synchronized void setMinimumLogicalFontSize(int i3) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setMinimumLogicalFontSize(i3);
        } else if (!z16 && (webSettings = this.f369202b) != null) {
            webSettings.setMinimumLogicalFontSize(i3);
        }
    }

    @TargetApi(21)
    public void setMixedContentMode(int i3) {
        android.webkit.WebSettings webSettings;
        boolean z16 = this.f369203c;
        if ((!z16 || this.f369201a == null) && !z16 && (webSettings = this.f369202b) != null) {
            com.tencent.smtt.utils.k.a(webSettings, "setMixedContentMode", (Class<?>[]) new Class[]{Integer.TYPE}, Integer.valueOf(i3));
        }
    }

    @Deprecated
    public void setNavDump(boolean z16) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z17 = this.f369203c;
        if (z17 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setNavDump(z16);
        } else if (!z17 && (webSettings = this.f369202b) != null) {
            com.tencent.smtt.utils.k.a(webSettings, "setNavDump", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z16));
        }
    }

    public void setNeedInitialFocus(boolean z16) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z17 = this.f369203c;
        if (z17 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setNeedInitialFocus(z16);
        } else if (!z17 && (webSettings = this.f369202b) != null) {
            webSettings.setNeedInitialFocus(z16);
        }
    }

    @TargetApi(8)
    @Deprecated
    public synchronized void setPluginState(PluginState pluginState) {
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setPluginState(IX5WebSettings.PluginState.valueOf(pluginState.name()));
        } else if (!z16 && this.f369202b != null) {
            com.tencent.smtt.utils.k.a(this.f369202b, "setPluginState", (Class<?>[]) new Class[]{WebSettings.PluginState.class}, WebSettings.PluginState.valueOf(pluginState.name()));
        }
    }

    @Deprecated
    public void setPluginsEnabled(boolean z16) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z17 = this.f369203c;
        if (z17 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setPluginsEnabled(z16);
        } else if (!z17 && (webSettings = this.f369202b) != null) {
            com.tencent.smtt.utils.k.a(webSettings, "setPluginsEnabled", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z16));
        }
    }

    @Deprecated
    public synchronized void setPluginsPath(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setPluginsPath(str);
        } else if (!z16 && (webSettings = this.f369202b) != null) {
            com.tencent.smtt.utils.k.a(webSettings, "setPluginsPath", (Class<?>[]) new Class[]{String.class}, str);
        }
    }

    @Deprecated
    public void setRenderPriority(RenderPriority renderPriority) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setRenderPriority(IX5WebSettings.RenderPriority.valueOf(renderPriority.name()));
        } else if (!z16 && (webSettings = this.f369202b) != null) {
            webSettings.setRenderPriority(WebSettings.RenderPriority.valueOf(renderPriority.name()));
        }
    }

    public void setSafeBrowsingEnabled(boolean z16) {
        IX5WebSettings iX5WebSettings;
        android.webkit.WebSettings webSettings;
        boolean z17 = this.f369203c;
        if (!z17 && (webSettings = this.f369202b) != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                webSettings.setSafeBrowsingEnabled(z16);
            }
        } else if (z17 && (iX5WebSettings = this.f369201a) != null) {
            try {
                iX5WebSettings.setSafeBrowsingEnabled(z16);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    public synchronized void setSansSerifFontFamily(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setSansSerifFontFamily(str);
        } else if (!z16 && (webSettings = this.f369202b) != null) {
            webSettings.setSansSerifFontFamily(str);
        }
    }

    @Deprecated
    public void setSaveFormData(boolean z16) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z17 = this.f369203c;
        if (z17 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setSaveFormData(z16);
        } else if (!z17 && (webSettings = this.f369202b) != null) {
            webSettings.setSaveFormData(z16);
        }
    }

    @Deprecated
    public void setSavePassword(boolean z16) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z17 = this.f369203c;
        if (z17 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setSavePassword(z16);
        } else if (!z17 && (webSettings = this.f369202b) != null) {
            webSettings.setSavePassword(z16);
        }
    }

    public synchronized void setSerifFontFamily(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setSerifFontFamily(str);
        } else if (!z16 && (webSettings = this.f369202b) != null) {
            webSettings.setSerifFontFamily(str);
        }
    }

    public synchronized void setStandardFontFamily(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setStandardFontFamily(str);
        } else if (!z16 && (webSettings = this.f369202b) != null) {
            webSettings.setStandardFontFamily(str);
        }
    }

    public void setSupportMultipleWindows(boolean z16) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z17 = this.f369203c;
        if (z17 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setSupportMultipleWindows(z16);
        } else if (!z17 && (webSettings = this.f369202b) != null) {
            webSettings.setSupportMultipleWindows(z16);
        }
    }

    public void setSupportZoom(boolean z16) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z17 = this.f369203c;
        if (z17 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setSupportZoom(z16);
        } else if (!z17 && (webSettings = this.f369202b) != null) {
            webSettings.setSupportZoom(z16);
        }
    }

    @Deprecated
    public void setTextSize(TextSize textSize) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setTextSize(IX5WebSettings.TextSize.valueOf(textSize.name()));
        } else if (!z16 && (webSettings = this.f369202b) != null) {
            webSettings.setTextSize(WebSettings.TextSize.valueOf(textSize.name()));
        }
    }

    @TargetApi(14)
    public synchronized void setTextZoom(int i3) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setTextZoom(i3);
        } else if (!z16 && (webSettings = this.f369202b) != null) {
            try {
                webSettings.setTextZoom(i3);
            } catch (Exception unused) {
                com.tencent.smtt.utils.k.a(this.f369202b, "setTextZoom", (Class<?>[]) new Class[]{Integer.TYPE}, Integer.valueOf(i3));
            }
        }
    }

    @Deprecated
    public void setUseWebViewBackgroundForOverscrollBackground(boolean z16) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z17 = this.f369203c;
        if (z17 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setUseWebViewBackgroundForOverscrollBackground(z16);
        } else if (!z17 && (webSettings = this.f369202b) != null) {
            com.tencent.smtt.utils.k.a(webSettings, "setUseWebViewBackgroundForOverscrollBackground", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z16));
        }
    }

    public void setUseWideViewPort(boolean z16) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z17 = this.f369203c;
        if (z17 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setUseWideViewPort(z16);
        } else if (!z17 && (webSettings = this.f369202b) != null) {
            webSettings.setUseWideViewPort(z16);
        }
    }

    public void setUserAgent(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setUserAgent(str);
        } else if (!z16 && (webSettings = this.f369202b) != null) {
            webSettings.setUserAgentString(str);
        }
    }

    @TargetApi(3)
    public void setUserAgentString(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            iX5WebSettings.setUserAgentString(str);
        } else if (!z16 && (webSettings = this.f369202b) != null) {
            webSettings.setUserAgentString(str);
        }
    }

    public synchronized boolean supportMultipleWindows() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.supportMultipleWindows();
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return webSettings.supportMultipleWindows();
        }
        return false;
    }

    public boolean supportZoom() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z16 = this.f369203c;
        if (z16 && (iX5WebSettings = this.f369201a) != null) {
            return iX5WebSettings.supportZoom();
        }
        if (!z16 && (webSettings = this.f369202b) != null) {
            return webSettings.supportZoom();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSettings(android.webkit.WebSettings webSettings) {
        this.f369201a = null;
        this.f369202b = webSettings;
        this.f369203c = false;
    }
}
