package com.tencent.xweb.pinus.sdk;

import android.annotation.SuppressLint;
import android.util.Log;
import android.webkit.WebSettings;
import com.tencent.luggage.wxa.ar.g0;
import com.tencent.xweb.XWEB_BUILDFLAG;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WebSettingsInterfaceImpl implements WebSettingsInterface {
    private static final String TAG = "WebSettingsInterfaceImpl";

    @XWEB_BUILDFLAG.XWEB_LONG_PRESS_TIME_CUSTOMIZE
    private g0 disableCustomizedLongPressTimeoutMethod;

    @XWEB_BUILDFLAG.XWEB_LONG_PRESS_TIME_CUSTOMIZE
    private g0 enableCustomizedLongPressTimeoutintMethod;
    private g0 getAllowContentAccessMethod;
    private g0 getAllowFileAccessFromFileURLsMethod;
    private g0 getAllowFileAccessMethod;
    private g0 getAllowUniversalAccessFromFileURLsMethod;

    @XWEB_BUILDFLAG.XWEB_COMMON
    private g0 getAppBrandInfoMethod;

    @XWEB_BUILDFLAG.XWEB_AUDIO_AUTOPLAY_FLAG
    private g0 getAudioPlaybackRequiresUserGestureMethod;

    @XWEB_BUILDFLAG.XWEB_BACKGROUND_AUDIO_PAUSE
    private g0 getBackgroundAudioPauseMethod;
    private g0 getBlockNetworkImageMethod;
    private g0 getBlockNetworkLoadsMethod;
    private g0 getBuiltInZoomControlsMethod;
    private g0 getCacheModeMethod;
    private g0 getCursiveFontFamilyMethod;
    private g0 getDatabaseEnabledMethod;
    private g0 getDatabasePathMethod;
    private g0 getDefaultFixedFontSizeMethod;
    private g0 getDefaultFontSizeMethod;
    private g0 getDefaultTextEncodingNameMethod;
    private g0 getDisabledActionModeMenuItemsMethod;
    private g0 getDisplayZoomControlsMethod;
    private g0 getDomStorageEnabledMethod;
    private g0 getFantasyFontFamilyMethod;
    private g0 getFixedFontFamilyMethod;

    @XWEB_BUILDFLAG.XWEB_DARK_MODE
    private g0 getForceDarkBehaviorMethod;
    private g0 getForceDarkMethod;

    @XWEB_BUILDFLAG.XWEB_DARK_MODE
    private g0 getForceDarkModeMethod;
    private g0 getJavaScriptCanOpenWindowsAutomaticallyMethod;
    private g0 getJavaScriptEnabledMethod;

    @XWEB_BUILDFLAG.XWEB_JAVASCRIPT_CAN_ACCESS_CLIPBOARD
    private g0 getJavascriptCanAccessClipboardMethod;
    private g0 getLayoutAlgorithmMethod;
    private g0 getLoadWithOverviewModeMethod;
    private g0 getLoadsImagesAutomaticallyMethod;
    private g0 getMediaPlaybackRequiresUserGestureMethod;
    private g0 getMinimumFontSizeMethod;
    private g0 getMinimumLogicalFontSizeMethod;
    private g0 getMixedContentModeMethod;
    private g0 getOffscreenPreRasterMethod;
    private g0 getSafeBrowsingEnabledMethod;
    private g0 getSansSerifFontFamilyMethod;
    private g0 getSaveFormDataMethod;
    private g0 getSavePasswordMethod;
    private g0 getSerifFontFamilyMethod;
    private g0 getStandardFontFamilyMethod;
    private g0 getTextZoomMethod;
    private g0 getUseWideViewPortMethod;
    private g0 getUserAgentStringMethod;

    @XWEB_BUILDFLAG.XWEB_COMMON
    private g0 getUsingForAppBrandMethod;

    @XWEB_BUILDFLAG.XWEB_VIDEO_AUTOPLAY_FLAG
    private g0 getVideoPlaybackRequiresUserGestureMethod;
    private final Object inner;
    private g0 setAllowContentAccessbooleanMethod;
    private g0 setAllowFileAccessFromFileURLsbooleanMethod;
    private g0 setAllowFileAccessbooleanMethod;
    private g0 setAllowUniversalAccessFromFileURLsbooleanMethod;

    @XWEB_BUILDFLAG.XWEB_COMMON
    private g0 setAppBrandInfoMapStringStringMethod;
    private g0 setAppCacheEnabledbooleanMethod;
    private g0 setAppCacheMaxSizelongMethod;
    private g0 setAppCachePathStringMethod;

    @XWEB_BUILDFLAG.XWEB_AUDIO_AUTOPLAY_FLAG
    private g0 setAudioPlaybackRequiresUserGesturebooleanMethod;

    @XWEB_BUILDFLAG.XWEB_BACKGROUND_AUDIO_PAUSE
    private g0 setBackgroundAudioPausebooleanMethod;
    private g0 setBlockNetworkImagebooleanMethod;
    private g0 setBlockNetworkLoadsbooleanMethod;
    private g0 setBuiltInZoomControlsbooleanMethod;
    private g0 setCacheModeintMethod;
    private g0 setCursiveFontFamilyStringMethod;
    private g0 setDatabaseEnabledbooleanMethod;
    private g0 setDatabasePathStringMethod;
    private g0 setDefaultFixedFontSizeintMethod;
    private g0 setDefaultFontSizeintMethod;
    private g0 setDefaultTextEncodingNameStringMethod;
    private g0 setDisabledActionModeMenuItemsintMethod;
    private g0 setDisplayZoomControlsbooleanMethod;
    private g0 setDomStorageEnabledbooleanMethod;
    private g0 setFantasyFontFamilyStringMethod;
    private g0 setFixedFontFamilyStringMethod;

    @XWEB_BUILDFLAG.XWEB_DARK_MODE
    private g0 setForceDarkBehaviorintMethod;

    @XWEB_BUILDFLAG.XWEB_DARK_MODE
    private g0 setForceDarkModeintMethod;
    private g0 setForceDarkintMethod;
    private g0 setGeolocationEnabledbooleanMethod;
    private g0 setJavaScriptCanOpenWindowsAutomaticallybooleanMethod;
    private g0 setJavaScriptEnabledbooleanMethod;

    @XWEB_BUILDFLAG.XWEB_JAVASCRIPT_CAN_ACCESS_CLIPBOARD
    private g0 setJavascriptCanAccessClipboardbooleanMethod;
    private g0 setLayoutAlgorithmWebSettingsLayoutAlgorithmMethod;
    private g0 setLoadWithOverviewModebooleanMethod;
    private g0 setLoadsImagesAutomaticallybooleanMethod;
    private g0 setMediaPlaybackRequiresUserGesturebooleanMethod;
    private g0 setMinimumFontSizeintMethod;
    private g0 setMinimumLogicalFontSizeintMethod;
    private g0 setMixedContentModeintMethod;
    private g0 setNeedInitialFocusbooleanMethod;
    private g0 setOffscreenPreRasterbooleanMethod;
    private g0 setSafeBrowsingEnabledbooleanMethod;
    private g0 setSansSerifFontFamilyStringMethod;
    private g0 setSaveFormDatabooleanMethod;
    private g0 setSavePasswordbooleanMethod;
    private g0 setSerifFontFamilyStringMethod;
    private g0 setStandardFontFamilyStringMethod;
    private g0 setSupportMultipleWindowsbooleanMethod;
    private g0 setSupportZoombooleanMethod;
    private g0 setTextZoomintMethod;
    private g0 setUseWideViewPortbooleanMethod;
    private g0 setUserAgentStringStringMethod;

    @XWEB_BUILDFLAG.XWEB_COMMON
    private g0 setUsingForAppBrandintMethod;

    @XWEB_BUILDFLAG.XWEB_VIDEO_HIDE_DOWNLOAD_UI
    private g0 setVideoHideDownloadUibooleanMethod;

    @XWEB_BUILDFLAG.XWEB_VIDEO_AUTOPLAY_FLAG
    private g0 setVideoPlaybackRequiresUserGesturebooleanMethod;
    private g0 supportMultipleWindowsMethod;
    private g0 supportZoomMethod;

    public WebSettingsInterfaceImpl(Object obj) {
        this.inner = obj;
    }

    @XWEB_BUILDFLAG.XWEB_LONG_PRESS_TIME_CUSTOMIZE
    private synchronized g0 getDisableCustomizedLongPressTimeoutMethod() {
        g0 g0Var;
        g0Var = this.disableCustomizedLongPressTimeoutMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "disableCustomizedLongPressTimeout", new Class[0]);
            this.disableCustomizedLongPressTimeoutMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_LONG_PRESS_TIME_CUSTOMIZE
    private synchronized g0 getEnableCustomizedLongPressTimeoutintMethod() {
        g0 g0Var;
        g0Var = this.enableCustomizedLongPressTimeoutintMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "enableCustomizedLongPressTimeout", Integer.TYPE);
            this.enableCustomizedLongPressTimeoutintMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetAllowContentAccessMethod() {
        g0 g0Var;
        g0Var = this.getAllowContentAccessMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getAllowContentAccess", new Class[0]);
            this.getAllowContentAccessMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetAllowFileAccessFromFileURLsMethod() {
        g0 g0Var;
        g0Var = this.getAllowFileAccessFromFileURLsMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getAllowFileAccessFromFileURLs", new Class[0]);
            this.getAllowFileAccessFromFileURLsMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetAllowFileAccessMethod() {
        g0 g0Var;
        g0Var = this.getAllowFileAccessMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getAllowFileAccess", new Class[0]);
            this.getAllowFileAccessMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetAllowUniversalAccessFromFileURLsMethod() {
        g0 g0Var;
        g0Var = this.getAllowUniversalAccessFromFileURLsMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getAllowUniversalAccessFromFileURLs", new Class[0]);
            this.getAllowUniversalAccessFromFileURLsMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_COMMON
    private synchronized g0 getGetAppBrandInfoMethod() {
        g0 g0Var;
        g0Var = this.getAppBrandInfoMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getAppBrandInfo", new Class[0]);
            this.getAppBrandInfoMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_AUDIO_AUTOPLAY_FLAG
    private synchronized g0 getGetAudioPlaybackRequiresUserGestureMethod() {
        g0 g0Var;
        g0Var = this.getAudioPlaybackRequiresUserGestureMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getAudioPlaybackRequiresUserGesture", new Class[0]);
            this.getAudioPlaybackRequiresUserGestureMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_BACKGROUND_AUDIO_PAUSE
    private synchronized g0 getGetBackgroundAudioPauseMethod() {
        g0 g0Var;
        g0Var = this.getBackgroundAudioPauseMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getBackgroundAudioPause", new Class[0]);
            this.getBackgroundAudioPauseMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetBlockNetworkImageMethod() {
        g0 g0Var;
        g0Var = this.getBlockNetworkImageMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getBlockNetworkImage", new Class[0]);
            this.getBlockNetworkImageMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetBlockNetworkLoadsMethod() {
        g0 g0Var;
        g0Var = this.getBlockNetworkLoadsMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getBlockNetworkLoads", new Class[0]);
            this.getBlockNetworkLoadsMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetBuiltInZoomControlsMethod() {
        g0 g0Var;
        g0Var = this.getBuiltInZoomControlsMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getBuiltInZoomControls", new Class[0]);
            this.getBuiltInZoomControlsMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetCacheModeMethod() {
        g0 g0Var;
        g0Var = this.getCacheModeMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getCacheMode", new Class[0]);
            this.getCacheModeMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetCursiveFontFamilyMethod() {
        g0 g0Var;
        g0Var = this.getCursiveFontFamilyMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getCursiveFontFamily", new Class[0]);
            this.getCursiveFontFamilyMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetDatabaseEnabledMethod() {
        g0 g0Var;
        g0Var = this.getDatabaseEnabledMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getDatabaseEnabled", new Class[0]);
            this.getDatabaseEnabledMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetDatabasePathMethod() {
        g0 g0Var;
        g0Var = this.getDatabasePathMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getDatabasePath", new Class[0]);
            this.getDatabasePathMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetDefaultFixedFontSizeMethod() {
        g0 g0Var;
        g0Var = this.getDefaultFixedFontSizeMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getDefaultFixedFontSize", new Class[0]);
            this.getDefaultFixedFontSizeMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetDefaultFontSizeMethod() {
        g0 g0Var;
        g0Var = this.getDefaultFontSizeMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getDefaultFontSize", new Class[0]);
            this.getDefaultFontSizeMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetDefaultTextEncodingNameMethod() {
        g0 g0Var;
        g0Var = this.getDefaultTextEncodingNameMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getDefaultTextEncodingName", new Class[0]);
            this.getDefaultTextEncodingNameMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetDisabledActionModeMenuItemsMethod() {
        g0 g0Var;
        g0Var = this.getDisabledActionModeMenuItemsMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getDisabledActionModeMenuItems", new Class[0]);
            this.getDisabledActionModeMenuItemsMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetDisplayZoomControlsMethod() {
        g0 g0Var;
        g0Var = this.getDisplayZoomControlsMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getDisplayZoomControls", new Class[0]);
            this.getDisplayZoomControlsMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetDomStorageEnabledMethod() {
        g0 g0Var;
        g0Var = this.getDomStorageEnabledMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getDomStorageEnabled", new Class[0]);
            this.getDomStorageEnabledMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetFantasyFontFamilyMethod() {
        g0 g0Var;
        g0Var = this.getFantasyFontFamilyMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getFantasyFontFamily", new Class[0]);
            this.getFantasyFontFamilyMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetFixedFontFamilyMethod() {
        g0 g0Var;
        g0Var = this.getFixedFontFamilyMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getFixedFontFamily", new Class[0]);
            this.getFixedFontFamilyMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_DARK_MODE
    private synchronized g0 getGetForceDarkBehaviorMethod() {
        g0 g0Var;
        g0Var = this.getForceDarkBehaviorMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getForceDarkBehavior", new Class[0]);
            this.getForceDarkBehaviorMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetForceDarkMethod() {
        g0 g0Var;
        g0Var = this.getForceDarkMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getForceDark", new Class[0]);
            this.getForceDarkMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_DARK_MODE
    private synchronized g0 getGetForceDarkModeMethod() {
        g0 g0Var;
        g0Var = this.getForceDarkModeMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getForceDarkMode", new Class[0]);
            this.getForceDarkModeMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetJavaScriptCanOpenWindowsAutomaticallyMethod() {
        g0 g0Var;
        g0Var = this.getJavaScriptCanOpenWindowsAutomaticallyMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getJavaScriptCanOpenWindowsAutomatically", new Class[0]);
            this.getJavaScriptCanOpenWindowsAutomaticallyMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetJavaScriptEnabledMethod() {
        g0 g0Var;
        g0Var = this.getJavaScriptEnabledMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getJavaScriptEnabled", new Class[0]);
            this.getJavaScriptEnabledMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_JAVASCRIPT_CAN_ACCESS_CLIPBOARD
    private synchronized g0 getGetJavascriptCanAccessClipboardMethod() {
        g0 g0Var;
        g0Var = this.getJavascriptCanAccessClipboardMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getJavascriptCanAccessClipboard", new Class[0]);
            this.getJavascriptCanAccessClipboardMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetLayoutAlgorithmMethod() {
        g0 g0Var;
        g0Var = this.getLayoutAlgorithmMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getLayoutAlgorithm", new Class[0]);
            this.getLayoutAlgorithmMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetLoadWithOverviewModeMethod() {
        g0 g0Var;
        g0Var = this.getLoadWithOverviewModeMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getLoadWithOverviewMode", new Class[0]);
            this.getLoadWithOverviewModeMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetLoadsImagesAutomaticallyMethod() {
        g0 g0Var;
        g0Var = this.getLoadsImagesAutomaticallyMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getLoadsImagesAutomatically", new Class[0]);
            this.getLoadsImagesAutomaticallyMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetMediaPlaybackRequiresUserGestureMethod() {
        g0 g0Var;
        g0Var = this.getMediaPlaybackRequiresUserGestureMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getMediaPlaybackRequiresUserGesture", new Class[0]);
            this.getMediaPlaybackRequiresUserGestureMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetMinimumFontSizeMethod() {
        g0 g0Var;
        g0Var = this.getMinimumFontSizeMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getMinimumFontSize", new Class[0]);
            this.getMinimumFontSizeMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetMinimumLogicalFontSizeMethod() {
        g0 g0Var;
        g0Var = this.getMinimumLogicalFontSizeMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getMinimumLogicalFontSize", new Class[0]);
            this.getMinimumLogicalFontSizeMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetMixedContentModeMethod() {
        g0 g0Var;
        g0Var = this.getMixedContentModeMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getMixedContentMode", new Class[0]);
            this.getMixedContentModeMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetOffscreenPreRasterMethod() {
        g0 g0Var;
        g0Var = this.getOffscreenPreRasterMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getOffscreenPreRaster", new Class[0]);
            this.getOffscreenPreRasterMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetSafeBrowsingEnabledMethod() {
        g0 g0Var;
        g0Var = this.getSafeBrowsingEnabledMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getSafeBrowsingEnabled", new Class[0]);
            this.getSafeBrowsingEnabledMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetSansSerifFontFamilyMethod() {
        g0 g0Var;
        g0Var = this.getSansSerifFontFamilyMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getSansSerifFontFamily", new Class[0]);
            this.getSansSerifFontFamilyMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetSaveFormDataMethod() {
        g0 g0Var;
        g0Var = this.getSaveFormDataMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getSaveFormData", new Class[0]);
            this.getSaveFormDataMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetSavePasswordMethod() {
        g0 g0Var;
        g0Var = this.getSavePasswordMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getSavePassword", new Class[0]);
            this.getSavePasswordMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetSerifFontFamilyMethod() {
        g0 g0Var;
        g0Var = this.getSerifFontFamilyMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getSerifFontFamily", new Class[0]);
            this.getSerifFontFamilyMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetStandardFontFamilyMethod() {
        g0 g0Var;
        g0Var = this.getStandardFontFamilyMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getStandardFontFamily", new Class[0]);
            this.getStandardFontFamilyMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetTextZoomMethod() {
        g0 g0Var;
        g0Var = this.getTextZoomMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getTextZoom", new Class[0]);
            this.getTextZoomMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetUseWideViewPortMethod() {
        g0 g0Var;
        g0Var = this.getUseWideViewPortMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getUseWideViewPort", new Class[0]);
            this.getUseWideViewPortMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetUserAgentStringMethod() {
        g0 g0Var;
        g0Var = this.getUserAgentStringMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getUserAgentString", new Class[0]);
            this.getUserAgentStringMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_COMMON
    private synchronized g0 getGetUsingForAppBrandMethod() {
        g0 g0Var;
        g0Var = this.getUsingForAppBrandMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getUsingForAppBrand", new Class[0]);
            this.getUsingForAppBrandMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_VIDEO_AUTOPLAY_FLAG
    private synchronized g0 getGetVideoPlaybackRequiresUserGestureMethod() {
        g0 g0Var;
        g0Var = this.getVideoPlaybackRequiresUserGestureMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getVideoPlaybackRequiresUserGesture", new Class[0]);
            this.getVideoPlaybackRequiresUserGestureMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetAllowContentAccessbooleanMethod() {
        g0 g0Var;
        g0Var = this.setAllowContentAccessbooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setAllowContentAccess", Boolean.TYPE);
            this.setAllowContentAccessbooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetAllowFileAccessFromFileURLsbooleanMethod() {
        g0 g0Var;
        g0Var = this.setAllowFileAccessFromFileURLsbooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setAllowFileAccessFromFileURLs", Boolean.TYPE);
            this.setAllowFileAccessFromFileURLsbooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetAllowFileAccessbooleanMethod() {
        g0 g0Var;
        g0Var = this.setAllowFileAccessbooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setAllowFileAccess", Boolean.TYPE);
            this.setAllowFileAccessbooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetAllowUniversalAccessFromFileURLsbooleanMethod() {
        g0 g0Var;
        g0Var = this.setAllowUniversalAccessFromFileURLsbooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setAllowUniversalAccessFromFileURLs", Boolean.TYPE);
            this.setAllowUniversalAccessFromFileURLsbooleanMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_COMMON
    private synchronized g0 getSetAppBrandInfoMapStringStringMethod() {
        g0 g0Var;
        g0Var = this.setAppBrandInfoMapStringStringMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setAppBrandInfo", Map.class);
            this.setAppBrandInfoMapStringStringMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetAppCacheEnabledbooleanMethod() {
        g0 g0Var;
        g0Var = this.setAppCacheEnabledbooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setAppCacheEnabled", Boolean.TYPE);
            this.setAppCacheEnabledbooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetAppCacheMaxSizelongMethod() {
        g0 g0Var;
        g0Var = this.setAppCacheMaxSizelongMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setAppCacheMaxSize", Long.TYPE);
            this.setAppCacheMaxSizelongMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetAppCachePathStringMethod() {
        g0 g0Var;
        g0Var = this.setAppCachePathStringMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setAppCachePath", String.class);
            this.setAppCachePathStringMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_AUDIO_AUTOPLAY_FLAG
    private synchronized g0 getSetAudioPlaybackRequiresUserGesturebooleanMethod() {
        g0 g0Var;
        g0Var = this.setAudioPlaybackRequiresUserGesturebooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setAudioPlaybackRequiresUserGesture", Boolean.TYPE);
            this.setAudioPlaybackRequiresUserGesturebooleanMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_BACKGROUND_AUDIO_PAUSE
    private synchronized g0 getSetBackgroundAudioPausebooleanMethod() {
        g0 g0Var;
        g0Var = this.setBackgroundAudioPausebooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setBackgroundAudioPause", Boolean.TYPE);
            this.setBackgroundAudioPausebooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetBlockNetworkImagebooleanMethod() {
        g0 g0Var;
        g0Var = this.setBlockNetworkImagebooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setBlockNetworkImage", Boolean.TYPE);
            this.setBlockNetworkImagebooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetBlockNetworkLoadsbooleanMethod() {
        g0 g0Var;
        g0Var = this.setBlockNetworkLoadsbooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setBlockNetworkLoads", Boolean.TYPE);
            this.setBlockNetworkLoadsbooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetBuiltInZoomControlsbooleanMethod() {
        g0 g0Var;
        g0Var = this.setBuiltInZoomControlsbooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setBuiltInZoomControls", Boolean.TYPE);
            this.setBuiltInZoomControlsbooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetCacheModeintMethod() {
        g0 g0Var;
        g0Var = this.setCacheModeintMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setCacheMode", Integer.TYPE);
            this.setCacheModeintMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetCursiveFontFamilyStringMethod() {
        g0 g0Var;
        g0Var = this.setCursiveFontFamilyStringMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setCursiveFontFamily", String.class);
            this.setCursiveFontFamilyStringMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetDatabaseEnabledbooleanMethod() {
        g0 g0Var;
        g0Var = this.setDatabaseEnabledbooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setDatabaseEnabled", Boolean.TYPE);
            this.setDatabaseEnabledbooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetDatabasePathStringMethod() {
        g0 g0Var;
        g0Var = this.setDatabasePathStringMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setDatabasePath", String.class);
            this.setDatabasePathStringMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetDefaultFixedFontSizeintMethod() {
        g0 g0Var;
        g0Var = this.setDefaultFixedFontSizeintMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setDefaultFixedFontSize", Integer.TYPE);
            this.setDefaultFixedFontSizeintMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetDefaultFontSizeintMethod() {
        g0 g0Var;
        g0Var = this.setDefaultFontSizeintMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setDefaultFontSize", Integer.TYPE);
            this.setDefaultFontSizeintMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetDefaultTextEncodingNameStringMethod() {
        g0 g0Var;
        g0Var = this.setDefaultTextEncodingNameStringMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setDefaultTextEncodingName", String.class);
            this.setDefaultTextEncodingNameStringMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetDisabledActionModeMenuItemsintMethod() {
        g0 g0Var;
        g0Var = this.setDisabledActionModeMenuItemsintMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setDisabledActionModeMenuItems", Integer.TYPE);
            this.setDisabledActionModeMenuItemsintMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetDisplayZoomControlsbooleanMethod() {
        g0 g0Var;
        g0Var = this.setDisplayZoomControlsbooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setDisplayZoomControls", Boolean.TYPE);
            this.setDisplayZoomControlsbooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetDomStorageEnabledbooleanMethod() {
        g0 g0Var;
        g0Var = this.setDomStorageEnabledbooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setDomStorageEnabled", Boolean.TYPE);
            this.setDomStorageEnabledbooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetFantasyFontFamilyStringMethod() {
        g0 g0Var;
        g0Var = this.setFantasyFontFamilyStringMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setFantasyFontFamily", String.class);
            this.setFantasyFontFamilyStringMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetFixedFontFamilyStringMethod() {
        g0 g0Var;
        g0Var = this.setFixedFontFamilyStringMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setFixedFontFamily", String.class);
            this.setFixedFontFamilyStringMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_DARK_MODE
    private synchronized g0 getSetForceDarkBehaviorintMethod() {
        g0 g0Var;
        g0Var = this.setForceDarkBehaviorintMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setForceDarkBehavior", Integer.TYPE);
            this.setForceDarkBehaviorintMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_DARK_MODE
    private synchronized g0 getSetForceDarkModeintMethod() {
        g0 g0Var;
        g0Var = this.setForceDarkModeintMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setForceDarkMode", Integer.TYPE);
            this.setForceDarkModeintMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetForceDarkintMethod() {
        g0 g0Var;
        g0Var = this.setForceDarkintMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setForceDark", Integer.TYPE);
            this.setForceDarkintMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetGeolocationEnabledbooleanMethod() {
        g0 g0Var;
        g0Var = this.setGeolocationEnabledbooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setGeolocationEnabled", Boolean.TYPE);
            this.setGeolocationEnabledbooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetJavaScriptCanOpenWindowsAutomaticallybooleanMethod() {
        g0 g0Var;
        g0Var = this.setJavaScriptCanOpenWindowsAutomaticallybooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setJavaScriptCanOpenWindowsAutomatically", Boolean.TYPE);
            this.setJavaScriptCanOpenWindowsAutomaticallybooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetJavaScriptEnabledbooleanMethod() {
        g0 g0Var;
        g0Var = this.setJavaScriptEnabledbooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setJavaScriptEnabled", Boolean.TYPE);
            this.setJavaScriptEnabledbooleanMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_JAVASCRIPT_CAN_ACCESS_CLIPBOARD
    private synchronized g0 getSetJavascriptCanAccessClipboardbooleanMethod() {
        g0 g0Var;
        g0Var = this.setJavascriptCanAccessClipboardbooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setJavascriptCanAccessClipboard", Boolean.TYPE);
            this.setJavascriptCanAccessClipboardbooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetLayoutAlgorithmWebSettingsLayoutAlgorithmMethod() {
        g0 g0Var;
        g0Var = this.setLayoutAlgorithmWebSettingsLayoutAlgorithmMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setLayoutAlgorithm", WebSettings.LayoutAlgorithm.class);
            this.setLayoutAlgorithmWebSettingsLayoutAlgorithmMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetLoadWithOverviewModebooleanMethod() {
        g0 g0Var;
        g0Var = this.setLoadWithOverviewModebooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setLoadWithOverviewMode", Boolean.TYPE);
            this.setLoadWithOverviewModebooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetLoadsImagesAutomaticallybooleanMethod() {
        g0 g0Var;
        g0Var = this.setLoadsImagesAutomaticallybooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setLoadsImagesAutomatically", Boolean.TYPE);
            this.setLoadsImagesAutomaticallybooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetMediaPlaybackRequiresUserGesturebooleanMethod() {
        g0 g0Var;
        g0Var = this.setMediaPlaybackRequiresUserGesturebooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setMediaPlaybackRequiresUserGesture", Boolean.TYPE);
            this.setMediaPlaybackRequiresUserGesturebooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetMinimumFontSizeintMethod() {
        g0 g0Var;
        g0Var = this.setMinimumFontSizeintMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setMinimumFontSize", Integer.TYPE);
            this.setMinimumFontSizeintMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetMinimumLogicalFontSizeintMethod() {
        g0 g0Var;
        g0Var = this.setMinimumLogicalFontSizeintMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setMinimumLogicalFontSize", Integer.TYPE);
            this.setMinimumLogicalFontSizeintMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetMixedContentModeintMethod() {
        g0 g0Var;
        g0Var = this.setMixedContentModeintMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setMixedContentMode", Integer.TYPE);
            this.setMixedContentModeintMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetNeedInitialFocusbooleanMethod() {
        g0 g0Var;
        g0Var = this.setNeedInitialFocusbooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setNeedInitialFocus", Boolean.TYPE);
            this.setNeedInitialFocusbooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetOffscreenPreRasterbooleanMethod() {
        g0 g0Var;
        g0Var = this.setOffscreenPreRasterbooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setOffscreenPreRaster", Boolean.TYPE);
            this.setOffscreenPreRasterbooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetSafeBrowsingEnabledbooleanMethod() {
        g0 g0Var;
        g0Var = this.setSafeBrowsingEnabledbooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setSafeBrowsingEnabled", Boolean.TYPE);
            this.setSafeBrowsingEnabledbooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetSansSerifFontFamilyStringMethod() {
        g0 g0Var;
        g0Var = this.setSansSerifFontFamilyStringMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setSansSerifFontFamily", String.class);
            this.setSansSerifFontFamilyStringMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetSaveFormDatabooleanMethod() {
        g0 g0Var;
        g0Var = this.setSaveFormDatabooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setSaveFormData", Boolean.TYPE);
            this.setSaveFormDatabooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetSavePasswordbooleanMethod() {
        g0 g0Var;
        g0Var = this.setSavePasswordbooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setSavePassword", Boolean.TYPE);
            this.setSavePasswordbooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetSerifFontFamilyStringMethod() {
        g0 g0Var;
        g0Var = this.setSerifFontFamilyStringMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setSerifFontFamily", String.class);
            this.setSerifFontFamilyStringMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetStandardFontFamilyStringMethod() {
        g0 g0Var;
        g0Var = this.setStandardFontFamilyStringMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setStandardFontFamily", String.class);
            this.setStandardFontFamilyStringMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetSupportMultipleWindowsbooleanMethod() {
        g0 g0Var;
        g0Var = this.setSupportMultipleWindowsbooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setSupportMultipleWindows", Boolean.TYPE);
            this.setSupportMultipleWindowsbooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetSupportZoombooleanMethod() {
        g0 g0Var;
        g0Var = this.setSupportZoombooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setSupportZoom", Boolean.TYPE);
            this.setSupportZoombooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetTextZoomintMethod() {
        g0 g0Var;
        g0Var = this.setTextZoomintMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setTextZoom", Integer.TYPE);
            this.setTextZoomintMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetUseWideViewPortbooleanMethod() {
        g0 g0Var;
        g0Var = this.setUseWideViewPortbooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setUseWideViewPort", Boolean.TYPE);
            this.setUseWideViewPortbooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetUserAgentStringStringMethod() {
        g0 g0Var;
        g0Var = this.setUserAgentStringStringMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setUserAgentString", String.class);
            this.setUserAgentStringStringMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_COMMON
    private synchronized g0 getSetUsingForAppBrandintMethod() {
        g0 g0Var;
        g0Var = this.setUsingForAppBrandintMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setUsingForAppBrand", Integer.TYPE);
            this.setUsingForAppBrandintMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_VIDEO_HIDE_DOWNLOAD_UI
    private synchronized g0 getSetVideoHideDownloadUibooleanMethod() {
        g0 g0Var;
        g0Var = this.setVideoHideDownloadUibooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setVideoHideDownloadUi", Boolean.TYPE);
            this.setVideoHideDownloadUibooleanMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_VIDEO_AUTOPLAY_FLAG
    private synchronized g0 getSetVideoPlaybackRequiresUserGesturebooleanMethod() {
        g0 g0Var;
        g0Var = this.setVideoPlaybackRequiresUserGesturebooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setVideoPlaybackRequiresUserGesture", Boolean.TYPE);
            this.setVideoPlaybackRequiresUserGesturebooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSupportMultipleWindowsMethod() {
        g0 g0Var;
        g0Var = this.supportMultipleWindowsMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "supportMultipleWindows", new Class[0]);
            this.supportMultipleWindowsMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSupportZoomMethod() {
        g0 g0Var;
        g0Var = this.supportZoomMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "supportZoom", new Class[0]);
            this.supportZoomMethod = g0Var;
        }
        return g0Var;
    }

    @SuppressLint({"LongLogTag"})
    public static void handleRuntimeError(Exception exc) {
        Log.e(TAG, "This API is incompatible with the xweb pinus library");
        exc.printStackTrace();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    @XWEB_BUILDFLAG.XWEB_LONG_PRESS_TIME_CUSTOMIZE
    public void disableCustomizedLongPressTimeout() {
        try {
            getDisableCustomizedLongPressTimeoutMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    @XWEB_BUILDFLAG.XWEB_LONG_PRESS_TIME_CUSTOMIZE
    public void enableCustomizedLongPressTimeout(int i3) {
        try {
            getEnableCustomizedLongPressTimeoutintMethod().a(Integer.valueOf(i3));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public boolean getAllowContentAccess() {
        try {
            return ((Boolean) getGetAllowContentAccessMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public boolean getAllowFileAccess() {
        try {
            return ((Boolean) getGetAllowFileAccessMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public boolean getAllowFileAccessFromFileURLs() {
        try {
            return ((Boolean) getGetAllowFileAccessFromFileURLsMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public boolean getAllowUniversalAccessFromFileURLs() {
        try {
            return ((Boolean) getGetAllowUniversalAccessFromFileURLsMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    @XWEB_BUILDFLAG.XWEB_COMMON
    public Map<String, String> getAppBrandInfo() {
        try {
            return (Map) getGetAppBrandInfoMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return null;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    @XWEB_BUILDFLAG.XWEB_AUDIO_AUTOPLAY_FLAG
    public boolean getAudioPlaybackRequiresUserGesture() {
        try {
            return ((Boolean) getGetAudioPlaybackRequiresUserGestureMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    @XWEB_BUILDFLAG.XWEB_BACKGROUND_AUDIO_PAUSE
    public boolean getBackgroundAudioPause() {
        try {
            return ((Boolean) getGetBackgroundAudioPauseMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public boolean getBlockNetworkImage() {
        try {
            return ((Boolean) getGetBlockNetworkImageMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public boolean getBlockNetworkLoads() {
        try {
            return ((Boolean) getGetBlockNetworkLoadsMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public boolean getBuiltInZoomControls() {
        try {
            return ((Boolean) getGetBuiltInZoomControlsMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public int getCacheMode() {
        try {
            return ((Integer) getGetCacheModeMethod().a(new Object[0])).intValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return 0;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public String getCursiveFontFamily() {
        try {
            return (String) getGetCursiveFontFamilyMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return null;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public boolean getDatabaseEnabled() {
        try {
            return ((Boolean) getGetDatabaseEnabledMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public String getDatabasePath() {
        try {
            return (String) getGetDatabasePathMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return null;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public int getDefaultFixedFontSize() {
        try {
            return ((Integer) getGetDefaultFixedFontSizeMethod().a(new Object[0])).intValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return 0;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public int getDefaultFontSize() {
        try {
            return ((Integer) getGetDefaultFontSizeMethod().a(new Object[0])).intValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return 0;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public String getDefaultTextEncodingName() {
        try {
            return (String) getGetDefaultTextEncodingNameMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return null;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public int getDisabledActionModeMenuItems() {
        try {
            return ((Integer) getGetDisabledActionModeMenuItemsMethod().a(new Object[0])).intValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return 0;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public boolean getDisplayZoomControls() {
        try {
            return ((Boolean) getGetDisplayZoomControlsMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public boolean getDomStorageEnabled() {
        try {
            return ((Boolean) getGetDomStorageEnabledMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public String getFantasyFontFamily() {
        try {
            return (String) getGetFantasyFontFamilyMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return null;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public String getFixedFontFamily() {
        try {
            return (String) getGetFixedFontFamilyMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return null;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public int getForceDark() {
        try {
            return ((Integer) getGetForceDarkMethod().a(new Object[0])).intValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return 0;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    @XWEB_BUILDFLAG.XWEB_DARK_MODE
    public int getForceDarkBehavior() {
        try {
            return ((Integer) getGetForceDarkBehaviorMethod().a(new Object[0])).intValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return 0;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    @XWEB_BUILDFLAG.XWEB_DARK_MODE
    public int getForceDarkMode() {
        try {
            return ((Integer) getGetForceDarkModeMethod().a(new Object[0])).intValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return 0;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public boolean getJavaScriptCanOpenWindowsAutomatically() {
        try {
            return ((Boolean) getGetJavaScriptCanOpenWindowsAutomaticallyMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public boolean getJavaScriptEnabled() {
        try {
            return ((Boolean) getGetJavaScriptEnabledMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    @XWEB_BUILDFLAG.XWEB_JAVASCRIPT_CAN_ACCESS_CLIPBOARD
    public boolean getJavascriptCanAccessClipboard() {
        try {
            return ((Boolean) getGetJavascriptCanAccessClipboardMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public WebSettings.LayoutAlgorithm getLayoutAlgorithm() {
        try {
            return (WebSettings.LayoutAlgorithm) getGetLayoutAlgorithmMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return null;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public boolean getLoadWithOverviewMode() {
        try {
            return ((Boolean) getGetLoadWithOverviewModeMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public boolean getLoadsImagesAutomatically() {
        try {
            return ((Boolean) getGetLoadsImagesAutomaticallyMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public boolean getMediaPlaybackRequiresUserGesture() {
        try {
            return ((Boolean) getGetMediaPlaybackRequiresUserGestureMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public int getMinimumFontSize() {
        try {
            return ((Integer) getGetMinimumFontSizeMethod().a(new Object[0])).intValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return 0;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public int getMinimumLogicalFontSize() {
        try {
            return ((Integer) getGetMinimumLogicalFontSizeMethod().a(new Object[0])).intValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return 0;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public int getMixedContentMode() {
        try {
            return ((Integer) getGetMixedContentModeMethod().a(new Object[0])).intValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return 0;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public boolean getOffscreenPreRaster() {
        try {
            return ((Boolean) getGetOffscreenPreRasterMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public boolean getSafeBrowsingEnabled() {
        try {
            return ((Boolean) getGetSafeBrowsingEnabledMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public String getSansSerifFontFamily() {
        try {
            return (String) getGetSansSerifFontFamilyMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return null;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public boolean getSaveFormData() {
        try {
            return ((Boolean) getGetSaveFormDataMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public boolean getSavePassword() {
        try {
            return ((Boolean) getGetSavePasswordMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public String getSerifFontFamily() {
        try {
            return (String) getGetSerifFontFamilyMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return null;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public String getStandardFontFamily() {
        try {
            return (String) getGetStandardFontFamilyMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return null;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public int getTextZoom() {
        try {
            return ((Integer) getGetTextZoomMethod().a(new Object[0])).intValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return 0;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public boolean getUseWideViewPort() {
        try {
            return ((Boolean) getGetUseWideViewPortMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public String getUserAgentString() {
        try {
            return (String) getGetUserAgentStringMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return null;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    @XWEB_BUILDFLAG.XWEB_COMMON
    public int getUsingForAppBrand() {
        try {
            return ((Integer) getGetUsingForAppBrandMethod().a(new Object[0])).intValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return 0;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    @XWEB_BUILDFLAG.XWEB_VIDEO_AUTOPLAY_FLAG
    public boolean getVideoPlaybackRequiresUserGesture() {
        try {
            return ((Boolean) getGetVideoPlaybackRequiresUserGestureMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setAllowContentAccess(boolean z16) {
        try {
            getSetAllowContentAccessbooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setAllowFileAccess(boolean z16) {
        try {
            getSetAllowFileAccessbooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setAllowFileAccessFromFileURLs(boolean z16) {
        try {
            getSetAllowFileAccessFromFileURLsbooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setAllowUniversalAccessFromFileURLs(boolean z16) {
        try {
            getSetAllowUniversalAccessFromFileURLsbooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    @XWEB_BUILDFLAG.XWEB_COMMON
    public void setAppBrandInfo(Map<String, String> map) {
        try {
            getSetAppBrandInfoMapStringStringMethod().a(map);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setAppCacheEnabled(boolean z16) {
        try {
            getSetAppCacheEnabledbooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setAppCacheMaxSize(long j3) {
        try {
            getSetAppCacheMaxSizelongMethod().a(Long.valueOf(j3));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setAppCachePath(String str) {
        try {
            getSetAppCachePathStringMethod().a(str);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    @XWEB_BUILDFLAG.XWEB_AUDIO_AUTOPLAY_FLAG
    public void setAudioPlaybackRequiresUserGesture(boolean z16) {
        try {
            getSetAudioPlaybackRequiresUserGesturebooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    @XWEB_BUILDFLAG.XWEB_BACKGROUND_AUDIO_PAUSE
    public void setBackgroundAudioPause(boolean z16) {
        try {
            getSetBackgroundAudioPausebooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setBlockNetworkImage(boolean z16) {
        try {
            getSetBlockNetworkImagebooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setBlockNetworkLoads(boolean z16) {
        try {
            getSetBlockNetworkLoadsbooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setBuiltInZoomControls(boolean z16) {
        try {
            getSetBuiltInZoomControlsbooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setCacheMode(int i3) {
        try {
            getSetCacheModeintMethod().a(Integer.valueOf(i3));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setCursiveFontFamily(String str) {
        try {
            getSetCursiveFontFamilyStringMethod().a(str);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setDatabaseEnabled(boolean z16) {
        try {
            getSetDatabaseEnabledbooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setDatabasePath(String str) {
        try {
            getSetDatabasePathStringMethod().a(str);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setDefaultFixedFontSize(int i3) {
        try {
            getSetDefaultFixedFontSizeintMethod().a(Integer.valueOf(i3));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setDefaultFontSize(int i3) {
        try {
            getSetDefaultFontSizeintMethod().a(Integer.valueOf(i3));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setDefaultTextEncodingName(String str) {
        try {
            getSetDefaultTextEncodingNameStringMethod().a(str);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setDisabledActionModeMenuItems(int i3) {
        try {
            getSetDisabledActionModeMenuItemsintMethod().a(Integer.valueOf(i3));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setDisplayZoomControls(boolean z16) {
        try {
            getSetDisplayZoomControlsbooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setDomStorageEnabled(boolean z16) {
        try {
            getSetDomStorageEnabledbooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setFantasyFontFamily(String str) {
        try {
            getSetFantasyFontFamilyStringMethod().a(str);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setFixedFontFamily(String str) {
        try {
            getSetFixedFontFamilyStringMethod().a(str);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setForceDark(int i3) {
        try {
            getSetForceDarkintMethod().a(Integer.valueOf(i3));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    @XWEB_BUILDFLAG.XWEB_DARK_MODE
    public void setForceDarkBehavior(int i3) {
        try {
            getSetForceDarkBehaviorintMethod().a(Integer.valueOf(i3));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    @XWEB_BUILDFLAG.XWEB_DARK_MODE
    public void setForceDarkMode(int i3) {
        try {
            getSetForceDarkModeintMethod().a(Integer.valueOf(i3));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setGeolocationEnabled(boolean z16) {
        try {
            getSetGeolocationEnabledbooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setJavaScriptCanOpenWindowsAutomatically(boolean z16) {
        try {
            getSetJavaScriptCanOpenWindowsAutomaticallybooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setJavaScriptEnabled(boolean z16) {
        try {
            getSetJavaScriptEnabledbooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    @XWEB_BUILDFLAG.XWEB_JAVASCRIPT_CAN_ACCESS_CLIPBOARD
    public void setJavascriptCanAccessClipboard(boolean z16) {
        try {
            getSetJavascriptCanAccessClipboardbooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setLayoutAlgorithm(WebSettings.LayoutAlgorithm layoutAlgorithm) {
        try {
            getSetLayoutAlgorithmWebSettingsLayoutAlgorithmMethod().a(layoutAlgorithm);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setLoadWithOverviewMode(boolean z16) {
        try {
            getSetLoadWithOverviewModebooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setLoadsImagesAutomatically(boolean z16) {
        try {
            getSetLoadsImagesAutomaticallybooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setMediaPlaybackRequiresUserGesture(boolean z16) {
        try {
            getSetMediaPlaybackRequiresUserGesturebooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setMinimumFontSize(int i3) {
        try {
            getSetMinimumFontSizeintMethod().a(Integer.valueOf(i3));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setMinimumLogicalFontSize(int i3) {
        try {
            getSetMinimumLogicalFontSizeintMethod().a(Integer.valueOf(i3));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setMixedContentMode(int i3) {
        try {
            getSetMixedContentModeintMethod().a(Integer.valueOf(i3));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setNeedInitialFocus(boolean z16) {
        try {
            getSetNeedInitialFocusbooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setOffscreenPreRaster(boolean z16) {
        try {
            getSetOffscreenPreRasterbooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setSafeBrowsingEnabled(boolean z16) {
        try {
            getSetSafeBrowsingEnabledbooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setSansSerifFontFamily(String str) {
        try {
            getSetSansSerifFontFamilyStringMethod().a(str);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setSaveFormData(boolean z16) {
        try {
            getSetSaveFormDatabooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setSavePassword(boolean z16) {
        try {
            getSetSavePasswordbooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setSerifFontFamily(String str) {
        try {
            getSetSerifFontFamilyStringMethod().a(str);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setStandardFontFamily(String str) {
        try {
            getSetStandardFontFamilyStringMethod().a(str);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setSupportMultipleWindows(boolean z16) {
        try {
            getSetSupportMultipleWindowsbooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setSupportZoom(boolean z16) {
        try {
            getSetSupportZoombooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setTextZoom(int i3) {
        try {
            getSetTextZoomintMethod().a(Integer.valueOf(i3));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setUseWideViewPort(boolean z16) {
        try {
            getSetUseWideViewPortbooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public void setUserAgentString(String str) {
        try {
            getSetUserAgentStringStringMethod().a(str);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    @XWEB_BUILDFLAG.XWEB_COMMON
    public void setUsingForAppBrand(int i3) {
        try {
            getSetUsingForAppBrandintMethod().a(Integer.valueOf(i3));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    @XWEB_BUILDFLAG.XWEB_VIDEO_HIDE_DOWNLOAD_UI
    public void setVideoHideDownloadUi(boolean z16) {
        try {
            getSetVideoHideDownloadUibooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    @XWEB_BUILDFLAG.XWEB_VIDEO_AUTOPLAY_FLAG
    public void setVideoPlaybackRequiresUserGesture(boolean z16) {
        try {
            getSetVideoPlaybackRequiresUserGesturebooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public boolean supportMultipleWindows() {
        try {
            return ((Boolean) getSupportMultipleWindowsMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebSettingsInterface
    public boolean supportZoom() {
        try {
            return ((Boolean) getSupportZoomMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }
}
