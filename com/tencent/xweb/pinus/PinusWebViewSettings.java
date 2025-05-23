package com.tencent.xweb.pinus;

import android.webkit.WebSettings;
import com.tencent.xweb.WebSettings;
import com.tencent.xweb.pinus.sdk.WebSettingsInterface;
import com.tencent.xweb.pinus.sdk.WebView;
import java.util.Map;

/* loaded from: classes27.dex */
public class PinusWebViewSettings extends WebSettings {
    private static final String TAG = "PinusWebViewSettings";
    private final WebSettingsInterface mWebSettings;

    public PinusWebViewSettings(WebView webView) {
        this.mWebSettings = webView.getSettings();
    }

    @Override // com.tencent.xweb.WebSettings
    public void disableCustomizedLongPressTimeout() {
        this.mWebSettings.disableCustomizedLongPressTimeout();
    }

    @Override // com.tencent.xweb.WebSettings
    public void enableCustomizedLongPressTimeout(int i3) {
        this.mWebSettings.enableCustomizedLongPressTimeout(i3);
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getAllowContentAccess() {
        return this.mWebSettings.getAllowContentAccess();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getAllowFileAccess() {
        return this.mWebSettings.getAllowFileAccess();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getAllowFileAccessFromFileURLs() {
        return this.mWebSettings.getAllowFileAccessFromFileURLs();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getAllowUniversalAccessFromFileURLs() {
        return this.mWebSettings.getAllowUniversalAccessFromFileURLs();
    }

    @Override // com.tencent.xweb.WebSettings
    public Map<String, String> getAppBrandInfo() {
        return this.mWebSettings.getAppBrandInfo();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getBackgroundAudioPause() {
        return this.mWebSettings.getBackgroundAudioPause();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getBlockNetworkImage() {
        return this.mWebSettings.getBlockNetworkImage();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getBlockNetworkLoads() {
        return this.mWebSettings.getBlockNetworkLoads();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getBuiltInZoomControls() {
        return this.mWebSettings.getBuiltInZoomControls();
    }

    @Override // com.tencent.xweb.WebSettings
    public int getCacheMode() {
        return this.mWebSettings.getCacheMode();
    }

    @Override // com.tencent.xweb.WebSettings
    public String getCursiveFontFamily() {
        return this.mWebSettings.getCursiveFontFamily();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getDatabaseEnabled() {
        return this.mWebSettings.getDatabaseEnabled();
    }

    @Override // com.tencent.xweb.WebSettings
    public String getDatabasePath() {
        return this.mWebSettings.getDatabasePath();
    }

    @Override // com.tencent.xweb.WebSettings
    public int getDefaultFixedFontSize() {
        return this.mWebSettings.getDefaultFixedFontSize();
    }

    @Override // com.tencent.xweb.WebSettings
    public int getDefaultFontSize() {
        return this.mWebSettings.getDefaultFontSize();
    }

    @Override // com.tencent.xweb.WebSettings
    public String getDefaultTextEncodingName() {
        return this.mWebSettings.getDefaultTextEncodingName();
    }

    @Override // com.tencent.xweb.WebSettings
    public int getDisabledActionModeMenuItems() {
        return this.mWebSettings.getDisabledActionModeMenuItems();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getDomStorageEnabled() {
        return this.mWebSettings.getDomStorageEnabled();
    }

    @Override // com.tencent.xweb.WebSettings
    public String getFantasyFontFamily() {
        return this.mWebSettings.getFantasyFontFamily();
    }

    @Override // com.tencent.xweb.WebSettings
    public String getFixedFontFamily() {
        return this.mWebSettings.getFixedFontFamily();
    }

    @Override // com.tencent.xweb.WebSettings
    public int getForceDarkBehavior() {
        return this.mWebSettings.getForceDarkBehavior();
    }

    @Override // com.tencent.xweb.WebSettings
    public int getForceDarkMode() {
        return this.mWebSettings.getForceDarkMode();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getJavaScriptCanOpenWindowsAutomatically() {
        return this.mWebSettings.getJavaScriptCanOpenWindowsAutomatically();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getJavaScriptEnabled() {
        return this.mWebSettings.getJavaScriptEnabled();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getJavascriptCanAccessClipboard() {
        return this.mWebSettings.getJavascriptCanAccessClipboard();
    }

    @Override // com.tencent.xweb.WebSettings
    public WebSettings.LayoutAlgorithm getLayoutAlgorithm() {
        return this.mWebSettings.getLayoutAlgorithm();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getLoadWithOverviewMode() {
        return this.mWebSettings.getLoadWithOverviewMode();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getLoadsImagesAutomatically() {
        return this.mWebSettings.getLoadsImagesAutomatically();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getMediaPlaybackRequiresUserGesture() {
        return this.mWebSettings.getMediaPlaybackRequiresUserGesture();
    }

    @Override // com.tencent.xweb.WebSettings
    public int getMinimumFontSize() {
        return this.mWebSettings.getMinimumFontSize();
    }

    @Override // com.tencent.xweb.WebSettings
    public int getMinimumLogicalFontSize() {
        return this.mWebSettings.getMinimumLogicalFontSize();
    }

    @Override // com.tencent.xweb.WebSettings
    public int getMixedContentMode() {
        return this.mWebSettings.getMixedContentMode();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getOffscreenPreRaster() {
        return this.mWebSettings.getOffscreenPreRaster();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getSafeBrowsingEnabled() {
        return false;
    }

    @Override // com.tencent.xweb.WebSettings
    public String getSansSerifFontFamily() {
        return this.mWebSettings.getSansSerifFontFamily();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getSaveFormData() {
        return this.mWebSettings.getSaveFormData();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getSavePassword() {
        return this.mWebSettings.getSavePassword();
    }

    @Override // com.tencent.xweb.WebSettings
    public String getSerifFontFamily() {
        return this.mWebSettings.getSerifFontFamily();
    }

    @Override // com.tencent.xweb.WebSettings
    public String getStandardFontFamily() {
        return this.mWebSettings.getStandardFontFamily();
    }

    @Override // com.tencent.xweb.WebSettings
    public int getTextZoom() {
        return this.mWebSettings.getTextZoom();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean getUseWideViewPort() {
        return this.mWebSettings.getUseWideViewPort();
    }

    @Override // com.tencent.xweb.WebSettings
    public String getUserAgentString() {
        return this.mWebSettings.getUserAgentString();
    }

    @Override // com.tencent.xweb.WebSettings
    public int getUsingForAppBrand() {
        return this.mWebSettings.getUsingForAppBrand();
    }

    @Override // com.tencent.xweb.WebSettings
    public void setAllowContentAccess(boolean z16) {
        this.mWebSettings.setAllowContentAccess(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setAllowFileAccess(boolean z16) {
        this.mWebSettings.setAllowFileAccess(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setAllowFileAccessFromFileURLs(boolean z16) {
        this.mWebSettings.setAllowFileAccessFromFileURLs(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setAllowUniversalAccessFromFileURLs(boolean z16) {
        this.mWebSettings.setAllowUniversalAccessFromFileURLs(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setAppBrandInfo(Map<String, String> map) {
        this.mWebSettings.setAppBrandInfo(map);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setAppCacheEnabled(boolean z16) {
        this.mWebSettings.setAppCacheEnabled(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setAppCacheMaxSize(long j3) {
        this.mWebSettings.setAppCacheMaxSize(j3);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setAppCachePath(String str) {
        this.mWebSettings.setAppCachePath(str);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setAudioPlaybackRequiresUserGesture(boolean z16) {
        this.mWebSettings.setAudioPlaybackRequiresUserGesture(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setBackgroundAudioPause(boolean z16) {
        this.mWebSettings.setBackgroundAudioPause(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setBlockNetworkImage(boolean z16) {
        this.mWebSettings.setBlockNetworkImage(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setBlockNetworkLoads(boolean z16) {
        this.mWebSettings.setBlockNetworkLoads(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setBuiltInZoomControls(boolean z16) {
        this.mWebSettings.setBuiltInZoomControls(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setCacheMode(int i3) {
        this.mWebSettings.setCacheMode(i3);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setCursiveFontFamily(String str) {
        this.mWebSettings.setCursiveFontFamily(str);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setDatabaseEnabled(boolean z16) {
        this.mWebSettings.setDatabaseEnabled(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setDatabasePath(String str) {
        this.mWebSettings.setDatabasePath(str);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setDefaultFixedFontSize(int i3) {
        this.mWebSettings.setDefaultFixedFontSize(i3);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setDefaultFontSize(int i3) {
        this.mWebSettings.setDefaultFontSize(i3);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setDefaultTextEncodingName(String str) {
        this.mWebSettings.setDefaultTextEncodingName(str);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setDisabledActionModeMenuItems(int i3) {
        this.mWebSettings.setDisabledActionModeMenuItems(i3);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setDisplayZoomControls(boolean z16) {
        this.mWebSettings.setDisplayZoomControls(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setDomStorageEnabled(boolean z16) {
        this.mWebSettings.setDomStorageEnabled(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setFantasyFontFamily(String str) {
        this.mWebSettings.setFantasyFontFamily(str);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setFixedFontFamily(String str) {
        this.mWebSettings.setFixedFontFamily(str);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setForceDarkBehavior(int i3) {
        this.mWebSettings.setForceDarkBehavior(i3);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setForceDarkMode(int i3) {
        this.mWebSettings.setForceDarkMode(i3);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setGeolocationEnabled(boolean z16) {
        this.mWebSettings.setGeolocationEnabled(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setJavaScriptCanOpenWindowsAutomatically(boolean z16) {
        this.mWebSettings.setJavaScriptCanOpenWindowsAutomatically(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setJavaScriptEnabled(boolean z16) {
        this.mWebSettings.setJavaScriptEnabled(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setJavascriptCanAccessClipboard(boolean z16) {
        this.mWebSettings.setJavascriptCanAccessClipboard(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setLayoutAlgorithm(WebSettings.LayoutAlgorithm layoutAlgorithm) {
        this.mWebSettings.setLayoutAlgorithm(layoutAlgorithm);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setLoadWithOverviewMode(boolean z16) {
        this.mWebSettings.setLoadWithOverviewMode(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setLoadsImagesAutomatically(boolean z16) {
        this.mWebSettings.setLoadsImagesAutomatically(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setMediaPlaybackRequiresUserGesture(boolean z16) {
        this.mWebSettings.setMediaPlaybackRequiresUserGesture(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setMinimumFontSize(int i3) {
        this.mWebSettings.setMinimumFontSize(i3);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setMinimumLogicalFontSize(int i3) {
        this.mWebSettings.setMinimumLogicalFontSize(i3);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setMixedContentMode(int i3) {
        this.mWebSettings.setMixedContentMode(i3);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setNeedInitialFocus(boolean z16) {
        this.mWebSettings.setNeedInitialFocus(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setOffscreenPreRaster(boolean z16) {
        this.mWebSettings.setOffscreenPreRaster(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setSafeBrowsingEnabled(boolean z16) {
        this.mWebSettings.setSafeBrowsingEnabled(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setSansSerifFontFamily(String str) {
        this.mWebSettings.setSansSerifFontFamily(str);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setSaveFormData(boolean z16) {
        this.mWebSettings.setSaveFormData(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setSavePassword(boolean z16) {
        this.mWebSettings.setSavePassword(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setSerifFontFamily(String str) {
        this.mWebSettings.setSerifFontFamily(str);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setStandardFontFamily(String str) {
        this.mWebSettings.setStandardFontFamily(str);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setSupportMultipleWindows(boolean z16) {
        this.mWebSettings.setSupportMultipleWindows(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setSupportZoom(boolean z16) {
        this.mWebSettings.setSupportZoom(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setTextZoom(int i3) {
        this.mWebSettings.setTextZoom(i3);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setUseWideViewPort(boolean z16) {
        this.mWebSettings.setUseWideViewPort(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setUserAgentString(String str) {
        this.mWebSettings.setUserAgentString(str);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setUsingForAppBrand(int i3) {
        this.mWebSettings.setUsingForAppBrand(i3);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setVideoHideDownloadUi(boolean z16) {
        this.mWebSettings.setVideoHideDownloadUi(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public void setVideoPlaybackRequiresUserGesture(boolean z16) {
        this.mWebSettings.setVideoPlaybackRequiresUserGesture(z16);
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean supportMultipleWindows() {
        return this.mWebSettings.supportMultipleWindows();
    }

    @Override // com.tencent.xweb.WebSettings
    public boolean supportZoom() {
        return this.mWebSettings.supportZoom();
    }

    @Override // com.tencent.xweb.WebSettings
    public void setRenderPriority(WebSettings.RenderPriority renderPriority) {
    }
}
