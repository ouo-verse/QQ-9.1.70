package com.tencent.luggage.wxa.xq;

import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.WebSettings;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public class g extends WebSettings {

    /* renamed from: a, reason: collision with root package name */
    public final android.webkit.WebSettings f145404a;

    /* renamed from: b, reason: collision with root package name */
    public String f145405b = "";

    public g(WebView webView) {
        this.f145404a = webView.getSettings();
        getUserAgentString();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getAllowContentAccess() {
        return this.f145404a.getAllowContentAccess();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getAllowFileAccess() {
        return this.f145404a.getAllowFileAccess();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getAllowFileAccessFromFileURLs() {
        return this.f145404a.getAllowFileAccessFromFileURLs();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getAllowUniversalAccessFromFileURLs() {
        return this.f145404a.getAllowUniversalAccessFromFileURLs();
    }

    @Override // com.tencent.xweb.WebSettings
    public Map getAppBrandInfo() {
        return null;
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getBackgroundAudioPause() {
        return false;
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getBlockNetworkImage() {
        return this.f145404a.getBlockNetworkImage();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getBlockNetworkLoads() {
        return this.f145404a.getBlockNetworkLoads();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getBuiltInZoomControls() {
        return this.f145404a.getBuiltInZoomControls();
    }

    @Override // com.tencent.xweb.WebSettings
    public int getCacheMode() {
        return this.f145404a.getCacheMode();
    }

    @Override // com.tencent.xweb.WebSettings
    public String getCursiveFontFamily() {
        return this.f145404a.getCursiveFontFamily();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getDatabaseEnabled() {
        return this.f145404a.getDatabaseEnabled();
    }

    @Override // com.tencent.xweb.WebSettings
    public String getDatabasePath() {
        return this.f145404a.getDatabasePath();
    }

    @Override // com.tencent.xweb.WebSettings
    public int getDefaultFixedFontSize() {
        return this.f145404a.getDefaultFixedFontSize();
    }

    @Override // com.tencent.xweb.WebSettings
    public int getDefaultFontSize() {
        return this.f145404a.getDefaultFontSize();
    }

    @Override // com.tencent.xweb.WebSettings
    public String getDefaultTextEncodingName() {
        return this.f145404a.getDefaultTextEncodingName();
    }

    @Override // com.tencent.xweb.WebSettings
    public int getDisabledActionModeMenuItems() {
        int disabledActionModeMenuItems;
        if (Build.VERSION.SDK_INT >= 24) {
            disabledActionModeMenuItems = this.f145404a.getDisabledActionModeMenuItems();
            return disabledActionModeMenuItems;
        }
        return 0;
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getDomStorageEnabled() {
        return this.f145404a.getDomStorageEnabled();
    }

    @Override // com.tencent.xweb.WebSettings
    public String getFantasyFontFamily() {
        return this.f145404a.getFantasyFontFamily();
    }

    @Override // com.tencent.xweb.WebSettings
    public String getFixedFontFamily() {
        return this.f145404a.getFixedFontFamily();
    }

    @Override // com.tencent.xweb.WebSettings
    public int getForceDarkBehavior() {
        return 0;
    }

    @Override // com.tencent.xweb.WebSettings
    public int getForceDarkMode() {
        return 0;
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getJavaScriptCanOpenWindowsAutomatically() {
        return this.f145404a.getJavaScriptCanOpenWindowsAutomatically();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getJavaScriptEnabled() {
        return this.f145404a.getJavaScriptEnabled();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getJavascriptCanAccessClipboard() {
        return true;
    }

    @Override // com.tencent.xweb.WebSettings
    public WebSettings.LayoutAlgorithm getLayoutAlgorithm() {
        return this.f145404a.getLayoutAlgorithm();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getLoadWithOverviewMode() {
        return this.f145404a.getLoadWithOverviewMode();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getLoadsImagesAutomatically() {
        return this.f145404a.getLoadsImagesAutomatically();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getMediaPlaybackRequiresUserGesture() {
        return this.f145404a.getMediaPlaybackRequiresUserGesture();
    }

    @Override // com.tencent.xweb.WebSettings
    public int getMinimumFontSize() {
        return this.f145404a.getMinimumFontSize();
    }

    @Override // com.tencent.xweb.WebSettings
    public int getMinimumLogicalFontSize() {
        return this.f145404a.getMinimumLogicalFontSize();
    }

    @Override // com.tencent.xweb.WebSettings
    public int getMixedContentMode() {
        return this.f145404a.getMixedContentMode();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getOffscreenPreRaster() {
        return this.f145404a.getOffscreenPreRaster();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getSafeBrowsingEnabled() {
        return false;
    }

    @Override // com.tencent.xweb.WebSettings
    public String getSansSerifFontFamily() {
        return this.f145404a.getSansSerifFontFamily();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getSaveFormData() {
        return this.f145404a.getSaveFormData();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getSavePassword() {
        return this.f145404a.getSavePassword();
    }

    @Override // com.tencent.xweb.WebSettings
    public String getSerifFontFamily() {
        return this.f145404a.getSerifFontFamily();
    }

    @Override // com.tencent.xweb.WebSettings
    public String getStandardFontFamily() {
        return this.f145404a.getStandardFontFamily();
    }

    @Override // com.tencent.xweb.WebSettings
    public int getTextZoom() {
        return this.f145404a.getTextZoom();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getUseWideViewPort() {
        return this.f145404a.getUseWideViewPort();
    }

    @Override // com.tencent.xweb.WebSettings
    public String getUserAgentString() {
        String str = this.f145405b;
        if (str == null || str.isEmpty()) {
            try {
                this.f145405b = this.f145404a.getUserAgentString();
            } catch (Throwable th5) {
                x0.a("SysWebViewSettings", "getUserAgentString error", th5);
            }
        }
        return this.f145405b;
    }

    @Override // com.tencent.xweb.WebSettings
    public int getUsingForAppBrand() {
        return 0;
    }

    @Override // com.tencent.xweb.WebSettings
    public void setAllowContentAccess(boolean z16) {
        this.f145404a.setAllowContentAccess(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setAllowFileAccess(boolean z16) {
        this.f145404a.setAllowFileAccess(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setAllowFileAccessFromFileURLs(boolean z16) {
        this.f145404a.setAllowFileAccessFromFileURLs(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setAllowUniversalAccessFromFileURLs(boolean z16) {
        this.f145404a.setAllowUniversalAccessFromFileURLs(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setBlockNetworkImage(boolean z16) {
        this.f145404a.setBlockNetworkImage(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setBlockNetworkLoads(boolean z16) {
        this.f145404a.setBlockNetworkLoads(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setBuiltInZoomControls(boolean z16) {
        this.f145404a.setBuiltInZoomControls(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setCacheMode(int i3) {
        this.f145404a.setCacheMode(i3);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setCursiveFontFamily(String str) {
        this.f145404a.setCursiveFontFamily(str);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setDatabaseEnabled(boolean z16) {
        this.f145404a.setDatabaseEnabled(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setDatabasePath(String str) {
        this.f145404a.setDatabasePath(str);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setDefaultFixedFontSize(int i3) {
        this.f145404a.setDefaultFixedFontSize(i3);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setDefaultFontSize(int i3) {
        this.f145404a.setDefaultFontSize(i3);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setDefaultTextEncodingName(String str) {
        this.f145404a.setDefaultTextEncodingName(str);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setDisabledActionModeMenuItems(int i3) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f145404a.setDisabledActionModeMenuItems(i3);
        }
    }

    @Override // com.tencent.xweb.WebSettings
    public void setDisplayZoomControls(boolean z16) {
        this.f145404a.setDisplayZoomControls(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setDomStorageEnabled(boolean z16) {
        this.f145404a.setDomStorageEnabled(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setFantasyFontFamily(String str) {
        this.f145404a.setFantasyFontFamily(str);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setFixedFontFamily(String str) {
        this.f145404a.setFixedFontFamily(str);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setGeolocationEnabled(boolean z16) {
        this.f145404a.setGeolocationEnabled(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setJavaScriptCanOpenWindowsAutomatically(boolean z16) {
        this.f145404a.setJavaScriptCanOpenWindowsAutomatically(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setJavaScriptEnabled(boolean z16) {
        this.f145404a.setJavaScriptEnabled(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setJavascriptCanAccessClipboard(boolean z16) {
        x0.f("SysWebViewSettings", "setJavascriptCanAccessClipboard not supported");
    }

    @Override // com.tencent.xweb.WebSettings
    public void setLayoutAlgorithm(WebSettings.LayoutAlgorithm layoutAlgorithm) {
        this.f145404a.setLayoutAlgorithm(layoutAlgorithm);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setLoadWithOverviewMode(boolean z16) {
        this.f145404a.setLoadWithOverviewMode(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setLoadsImagesAutomatically(boolean z16) {
        this.f145404a.setLoadsImagesAutomatically(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setMediaPlaybackRequiresUserGesture(boolean z16) {
        this.f145404a.setMediaPlaybackRequiresUserGesture(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setMinimumFontSize(int i3) {
        this.f145404a.setMinimumFontSize(i3);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setMinimumLogicalFontSize(int i3) {
        this.f145404a.setMinimumLogicalFontSize(i3);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setMixedContentMode(int i3) {
        this.f145404a.setMixedContentMode(i3);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setNeedInitialFocus(boolean z16) {
        this.f145404a.setNeedInitialFocus(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setOffscreenPreRaster(boolean z16) {
        this.f145404a.setOffscreenPreRaster(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setRenderPriority(WebSettings.RenderPriority renderPriority) {
        this.f145404a.setRenderPriority(renderPriority);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setSafeBrowsingEnabled(boolean z16) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f145404a.setSafeBrowsingEnabled(z16);
        }
    }

    @Override // com.tencent.xweb.WebSettings
    public void setSansSerifFontFamily(String str) {
        this.f145404a.setSansSerifFontFamily(str);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setSaveFormData(boolean z16) {
        this.f145404a.setSaveFormData(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setSavePassword(boolean z16) {
        this.f145404a.setSavePassword(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setSerifFontFamily(String str) {
        this.f145404a.setSerifFontFamily(str);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setStandardFontFamily(String str) {
        this.f145404a.setStandardFontFamily(str);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setSupportMultipleWindows(boolean z16) {
        this.f145404a.setSupportMultipleWindows(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setSupportZoom(boolean z16) {
        this.f145404a.setSupportZoom(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setTextZoom(int i3) {
        this.f145404a.setTextZoom(i3);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setUseWideViewPort(boolean z16) {
        this.f145404a.setUseWideViewPort(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setUserAgentString(String str) {
        this.f145405b = str;
        this.f145404a.setUserAgentString(str);
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean supportMultipleWindows() {
        return this.f145404a.supportMultipleWindows();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean supportZoom() {
        return this.f145404a.supportZoom();
    }

    @Override // com.tencent.xweb.WebSettings
    public void disableCustomizedLongPressTimeout() {
    }

    @Override // com.tencent.xweb.WebSettings
    public void enableCustomizedLongPressTimeout(int i3) {
    }

    @Override // com.tencent.xweb.WebSettings
    public void setAppBrandInfo(Map map) {
    }

    @Override // com.tencent.xweb.WebSettings
    public void setAppCacheEnabled(boolean z16) {
    }

    @Override // com.tencent.xweb.WebSettings
    public void setAppCacheMaxSize(long j3) {
    }

    @Override // com.tencent.xweb.WebSettings
    public void setAppCachePath(String str) {
    }

    @Override // com.tencent.xweb.WebSettings
    public void setAudioPlaybackRequiresUserGesture(boolean z16) {
    }

    @Override // com.tencent.xweb.WebSettings
    public void setBackgroundAudioPause(boolean z16) {
    }

    @Override // com.tencent.xweb.WebSettings
    public void setForceDarkBehavior(int i3) {
    }

    @Override // com.tencent.xweb.WebSettings
    public void setForceDarkMode(int i3) {
    }

    @Override // com.tencent.xweb.WebSettings
    public void setUsingForAppBrand(int i3) {
    }

    @Override // com.tencent.xweb.WebSettings
    public void setVideoHideDownloadUi(boolean z16) {
    }

    @Override // com.tencent.xweb.WebSettings
    public void setVideoPlaybackRequiresUserGesture(boolean z16) {
    }
}
