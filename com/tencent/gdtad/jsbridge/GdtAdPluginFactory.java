package com.tencent.gdtad.jsbridge;

import androidx.annotation.Nullable;

/* loaded from: classes6.dex */
public class GdtAdPluginFactory {
    public static final int ADPlugin_LOAD_AD = 5;
    public static final int AD_PLUGIN_LAUNCH_APP_MARKET = 36;
    public static final int AD_PLUGIN_OPEN_VIDEO_CELLING = 40;
    public static final int AD_PLUGIN_SHOW_BUTTON_DEMO = 38;
    public static final int AD_PLUGIN_SHOW_MOTIVE_AD = 39;
    public static final int AD_PLUGIN_WX_CANVAS = 37;
    public static final int AD_PLUGIN_WX_MINI_PROGRAM = 35;
    public static final int AdPlugin_Banner = 13;
    public static final int AdPlugin_C2S_MONITOR = 15;
    public static final int AdPlugin_GET_DEVICE_INFO = 14;
    public static final int AdPlugin_GET_USER_INFO = 17;
    public static final int AdPlugin_HANDLE_CLICK = 12;
    public static final int AdPlugin_INTERSTITIAL = 19;
    public static final int AdPlugin_INTERSTITIAL_FOR_JS = 20;
    public static final int AdPlugin_LAUNCH_APP_WITH_DEEPLINK = 24;
    public static final int AdPlugin_OPEN_MV_PAGE = 16;
    public static final int AdPlugin_PRELOAD_AFTER_AD_LOADED = 18;
    public static final int AdPlugin_REPORT_AD_EVENT_VAS = 34;
    public static final int AdPlugin_SHOW_DEVICE_DEMO = 28;
    public static final int AdPlugin_SHOW_MOTIVE_VIDEO_DEMO = 33;
    public static final int AdPlugin_SHOW_NEGATIVE_FEEDBACK = 32;
    private static volatile GdtAdPluginFactory self;
    GdtBannerJsCallHandler mBannerJsCallHandler;
    a mButtonDemoJsCallHandler;
    GdtDeviceDemoJsCallHandler mDeviceDemoJsCallHandler;
    GdtDeviceInfoJsCallHandler mDeviceInfoJsCallHandler;
    GdtC2SJsCallHandler mGdtC2SJsCallHandler;
    GdtGetUserInfoHandler mGdtGetUserInfo;
    GdtLoadAdJsCallHandler mGdtLoadAdJsCallHandler;
    GdtOpenMvPageHandler mGdtOpenMvPage;
    GdtReportAdJsCallHandler mGdtReportAdJsCallHandler;
    GdtHandleClickJsCallHandler mHandleClickJsCallHandler;
    GdtInterstitialForJSHandler mInterstitialForJSHandler;
    GdtInterstitialJsCallHandler mInterstitialJsCallHandler;
    GdtLaunchAppMarketJsCallHandler mLaunchAppMarketJsCallHandler;
    GdtLaunchAppWithDeeplinkJsCallHandler mLaunchAppWithDeeplinkJsCallHandler;
    GdtMotiveVideoDemoHandler mMotiveVideoDemoHandler;
    GdtFeedbackJsCallHandler mNegativeFeedbackJsCallHandler;
    GdtOpenMotiveAdHandler mOpenMotiveAdHandler;
    GdtPreLoadAfterAdLoadedJsCallHandler mPreLoadAfterAdLoadedJsCallHandler;
    b mVideoCellingJsCallHandler;
    GdtWXCanvasJsCallHandler mWXCANVASJsCallHandler;
    GdtWXMINIProgramJsCallHandler mWXMINIProgramJsCallHandler;

    GdtAdPluginFactory() {
    }

    public static GdtAdPluginFactory getInstance() {
        if (self == null) {
            synchronized (GdtAdPluginFactory.class) {
                if (self == null) {
                    self = new GdtAdPluginFactory();
                }
            }
        }
        return self;
    }

    @Nullable
    public GdtJsCallHandler findJsCallHandler(int i3) {
        if (i3 != 5) {
            if (i3 != 24) {
                if (i3 != 28) {
                    switch (i3) {
                        case 12:
                            if (this.mHandleClickJsCallHandler == null) {
                                this.mHandleClickJsCallHandler = new GdtHandleClickJsCallHandler();
                            }
                            return this.mHandleClickJsCallHandler;
                        case 13:
                            if (this.mBannerJsCallHandler == null) {
                                this.mBannerJsCallHandler = new GdtBannerJsCallHandler();
                            }
                            return this.mBannerJsCallHandler;
                        case 14:
                            if (this.mDeviceInfoJsCallHandler == null) {
                                this.mDeviceInfoJsCallHandler = new GdtDeviceInfoJsCallHandler();
                            }
                            return this.mDeviceInfoJsCallHandler;
                        case 15:
                            if (this.mGdtC2SJsCallHandler == null) {
                                this.mGdtC2SJsCallHandler = new GdtC2SJsCallHandler();
                            }
                            return this.mGdtC2SJsCallHandler;
                        case 16:
                            if (this.mGdtOpenMvPage == null) {
                                this.mGdtOpenMvPage = new GdtOpenMvPageHandler();
                            }
                            return this.mGdtOpenMvPage;
                        case 17:
                            if (this.mGdtGetUserInfo == null) {
                                this.mGdtGetUserInfo = new GdtGetUserInfoHandler();
                            }
                            return this.mGdtGetUserInfo;
                        case 18:
                            if (this.mPreLoadAfterAdLoadedJsCallHandler == null) {
                                this.mPreLoadAfterAdLoadedJsCallHandler = new GdtPreLoadAfterAdLoadedJsCallHandler();
                            }
                            return this.mPreLoadAfterAdLoadedJsCallHandler;
                        case 19:
                            if (this.mInterstitialJsCallHandler == null) {
                                this.mInterstitialJsCallHandler = new GdtInterstitialJsCallHandler();
                            }
                            return this.mInterstitialJsCallHandler;
                        case 20:
                            if (this.mInterstitialForJSHandler == null) {
                                this.mInterstitialForJSHandler = new GdtInterstitialForJSHandler();
                            }
                            return this.mInterstitialForJSHandler;
                        default:
                            switch (i3) {
                                case 32:
                                    if (this.mNegativeFeedbackJsCallHandler == null) {
                                        this.mNegativeFeedbackJsCallHandler = new GdtFeedbackJsCallHandler();
                                    }
                                    return this.mNegativeFeedbackJsCallHandler;
                                case 33:
                                    if (this.mMotiveVideoDemoHandler == null) {
                                        this.mMotiveVideoDemoHandler = new GdtMotiveVideoDemoHandler();
                                    }
                                    return this.mMotiveVideoDemoHandler;
                                case 34:
                                    if (this.mGdtReportAdJsCallHandler == null) {
                                        this.mGdtReportAdJsCallHandler = new GdtReportAdJsCallHandler();
                                    }
                                    return this.mGdtReportAdJsCallHandler;
                                case 35:
                                    if (this.mWXMINIProgramJsCallHandler == null) {
                                        this.mWXMINIProgramJsCallHandler = new GdtWXMINIProgramJsCallHandler();
                                    }
                                    return this.mWXMINIProgramJsCallHandler;
                                case 36:
                                    if (this.mLaunchAppMarketJsCallHandler == null) {
                                        this.mLaunchAppMarketJsCallHandler = new GdtLaunchAppMarketJsCallHandler();
                                    }
                                    return this.mLaunchAppMarketJsCallHandler;
                                case 37:
                                    if (this.mWXCANVASJsCallHandler == null) {
                                        this.mWXCANVASJsCallHandler = new GdtWXCanvasJsCallHandler();
                                    }
                                    return this.mWXCANVASJsCallHandler;
                                case 38:
                                    if (this.mButtonDemoJsCallHandler == null) {
                                        this.mButtonDemoJsCallHandler = new a();
                                    }
                                    return this.mButtonDemoJsCallHandler;
                                case 39:
                                    if (this.mOpenMotiveAdHandler == null) {
                                        this.mOpenMotiveAdHandler = new GdtOpenMotiveAdHandler();
                                    }
                                    return this.mOpenMotiveAdHandler;
                                case 40:
                                    if (this.mVideoCellingJsCallHandler == null) {
                                        this.mVideoCellingJsCallHandler = new b();
                                    }
                                    return this.mVideoCellingJsCallHandler;
                                default:
                                    return null;
                            }
                    }
                }
                if (this.mDeviceDemoJsCallHandler == null) {
                    this.mDeviceDemoJsCallHandler = new GdtDeviceDemoJsCallHandler();
                }
                return this.mDeviceDemoJsCallHandler;
            }
            if (this.mLaunchAppWithDeeplinkJsCallHandler == null) {
                this.mLaunchAppWithDeeplinkJsCallHandler = new GdtLaunchAppWithDeeplinkJsCallHandler();
            }
            return this.mLaunchAppWithDeeplinkJsCallHandler;
        }
        if (this.mGdtLoadAdJsCallHandler == null) {
            this.mGdtLoadAdJsCallHandler = new GdtLoadAdJsCallHandler();
        }
        return this.mGdtLoadAdJsCallHandler;
    }
}
