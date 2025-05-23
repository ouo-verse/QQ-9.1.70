package com.tencent.gamematrix.gmcg.api.model;

import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import com.tencent.gamematrix.gmcg.api.GmCgAutoLoginIdType;
import com.tencent.gamematrix.gmcg.api.GmCgLogger;
import com.tencent.gamematrix.gmcg.api.util.CGStringUtil;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GmCgSessionCfg {
    public boolean pAllowWorkIfNoGameConfig;
    public String pArchiveSessionId;
    public String pAutoLoginChannelAccessToken;
    public String pAutoLoginChannelAppId;
    public String pAutoLoginChannelOpenId;
    public String pAutoLoginChannelParam1;
    public String pAutoLoginChannelParam2;
    public String pAutoLoginChannelParam3;
    public String pAutoLoginChannelParam4;
    public String pAutoLoginChannelParam5;
    public String pAutoLoginChannelParam6;
    public String pAutoLoginChannelQQSkey;
    public String pAutoLoginChannelQQUin;
    public int pAutoLoginChannelType;

    @GmCgAutoLoginIdType
    public int pAutoLoginIdType;

    @DrawableRes
    public int pDefaultLoadingBackgroundResId;

    @DrawableRes
    public int pDefaultLoadingLandscapeResId;

    @DrawableRes
    public int pDefaultLoadingPortraitResId;
    public List<GmCgGameStreamQualityCfg> pDefaultStreamQualityCfg;
    public boolean pEnableAdaptiveStreamQuality;
    public boolean pEnableAdjustPreviewFpsRes;
    public boolean pEnableClipboard;
    public boolean pEnableCloudAppMonitor;
    public boolean pEnableConfigCallback;
    public boolean pEnableCumulativeDelayed;
    public boolean pEnableCustomizeDecoder;
    public boolean pEnableExtraInfoOverlay;
    public boolean pEnableGetBatterInfo;
    public boolean pEnableImgQualityPerferred;
    public boolean pEnableKeepSession;
    public boolean pEnableLegacyDataChannel;
    public boolean pEnableLocalRtcEventLog;
    public boolean pEnablePinchFace;
    public boolean pEnableQuic;
    public boolean pEnableRtcDump;
    public boolean pEnableRtcLog;
    public boolean pEnableTouchInterpolation;
    public boolean pExtraInfoOverLayBottomOrTop;
    public boolean pExtraInfoOverlayRightOrLeft;
    public int pFeatSwitchForLocalImeInput;
    public boolean pForceSkipLoadArchive;
    public boolean pForceSkipSetResolution;
    public boolean pForceUseCustomDecType;
    public boolean pForceUseDecH265;
    public boolean pForceUseDecSoft;
    public String pGameLoginPayLoad;
    public int pGameScreenOrientation;
    public int pLaunchBitrate;
    public int pLoadingDelayTimeMillis;
    public ImageView.ScaleType pLoadingScaleType;
    public int pMaxDefaultBitRate;
    public String pMidasPayClientOfferId;
    public String pMidasPayClientOpenId;
    public String pMidasPayLinkId;
    public String pMidasPayPlatformId;
    public String pMidasPayPlatformType;
    public int pMinDefaultBitRate;
    public int pNoTouchEventCallbackTimeSeconds;
    public int pNoTouchLongTime;
    public int pNoTouchLongTimeCountdown;
    public int pRtcCurrAudioVolume;
    public String pRtcDumpPath;
    public int pRtcDumpSize;
    public Boolean pRtcHwDecode;
    public GmCgLogger pRtcLogger;
    public int pRtcLoggingSeverity;
    public int pRtcMaxAudioVolume;
    public int pRtcToCGLogSeverity;
    public boolean pSuperResolutionOnlyHwDecode;
    public boolean pUseCustomInputView;
    public boolean pUseCustomLoadingView;
    public boolean pUseLegacyStreamQualityCfg;
    public boolean pUseV2CloudGameLogin;
    public int pViewHeight;
    public int pViewWidth;
    public Integer pWebRTCAudioSource;
    public int pWebrtcConnectionTime;
    public String pYybLoginAccessToken;
    public int pYybLoginChannel;
    public int pYybLoginLoginType;
    public String pYybLoginOpenId;
    public String pYybLoginParam1;
    public String pYybLoginParam2;
    public String pYybLoginParam3;
    public int pYybLoginSdkType;
    public String pYybLoginSrcAppId;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class Builder {
        private boolean allowWorkIfNoGameConfig;
        private String archiveSessionId;
        private String autoLoginChannelAccessToken;
        private String autoLoginChannelAppId;
        private String autoLoginChannelOpenId;
        private String autoLoginChannelParam1;
        private String autoLoginChannelParam2;
        private String autoLoginChannelParam3;
        private String autoLoginChannelParam4;
        private String autoLoginChannelParam5;
        private String autoLoginChannelParam6;
        private String autoLoginChannelQQSkey;
        private String autoLoginChannelQQUin;
        private int autoLoginChannelType;

        @DrawableRes
        private int defaultLoadingBackgroundResId;

        @DrawableRes
        private int defaultLoadingLandscapeResId;

        @DrawableRes
        private int defaultLoadingPortraitResId;
        private int defaultMaxBitrate;
        private int defaultMinBitrate;
        private List<GmCgGameStreamQualityCfg> defaultStreamQualityCfg;
        private boolean enableAdaptiveStreamQualityAdjust;
        private boolean enableAdjustPreviewFpsRes;
        private boolean enableClipboard;
        private boolean enableCloudAppMonitor;
        public boolean enableCumulativeDelayed;
        private boolean enableCustomizeDecoder;
        private boolean enableExtraInfoOverlay;
        public boolean enableGetBatteryInfo;
        private boolean enableImgQualityFirst;
        private boolean enableKeepSession;
        private boolean enableLegacyDataChannel;
        private boolean enableLocalRtcEventLog;
        private boolean enablePinchFace;
        private boolean enableRtcDump;
        private boolean enableRtcLog;
        private boolean enableTouchInterpolation;
        private boolean extraOverLayBottomOrTop;
        private boolean extraOverlayRightOrLeft;
        private int featSwitchForLocalImeInput;
        private boolean forceSkipLoadArchive;
        private boolean forceSkipSetResolution;
        private boolean forceUseCustomDecType;
        private boolean forceUseDecH265;
        private boolean forceUseDecSoft;
        private String gameLoginPayLoad;
        private int launchBitrate;
        private int loadingDelayTimeMillis;
        private String midasPayClientOfferId;
        private String midasPayClientOpenId;
        private String midasPayLinkId;
        private String midasPayPlatformId;
        private String midasPayPlatformType;
        private int noTouchEventCallbackTimeSeconds;
        private int noTouchLongTime;
        private int noTouchLongTimeCountdown;
        public GmCgLogger rtcLogger;
        public boolean superResolutionOnlyHwDecode;
        private boolean useCustomInputView;
        private boolean useCustomLoadingView;
        private boolean useLegacyStreamQualityCfg;
        private boolean useV2CloudGameLogin;
        private Integer webrtcAudioSource;
        private String yybLoginAccessToken;
        private int yybLoginChannel;
        private int yybLoginLoginType;
        private String yybLoginOpenId;
        private String yybLoginParam1;
        private String yybLoginParam2;
        private String yybLoginParam3;
        private int yybLoginSdkType;
        private String yybLoginSrcAppId;
        private int gameScreenOrientation = 1;

        @GmCgAutoLoginIdType
        private int autoLoginIdType = 0;
        private ImageView.ScaleType loadingScaleType = ImageView.ScaleType.FIT_CENTER;
        private boolean enableViewConfigCallback = true;
        private boolean enableQuic = false;
        public int rtcCurrAudioVolume = -1;
        public int rtcMaxAudioVolume = -1;
        public int rtcLoggingSeverity = -1;
        public Boolean rtcHwDecode = null;
        public String rtcDumpPath = null;
        public int rtcDumpSize = -1;
        public int webrtcConnectionTime = -1;

        public Builder allowWorkIfNoGameConfig(boolean z16) {
            this.allowWorkIfNoGameConfig = z16;
            return this;
        }

        public GmCgSessionCfg build() {
            return new GmCgSessionCfg(this);
        }

        public Builder configAutoLogin(int i3, String str, String str2, String str3) {
            this.autoLoginIdType = 0;
            this.autoLoginChannelType = i3;
            this.autoLoginChannelAppId = str;
            this.autoLoginChannelOpenId = str2;
            this.autoLoginChannelAccessToken = str3;
            return this;
        }

        public void configAutoLoginForDelegateCode(int i3, String str, String str2) {
            this.autoLoginIdType = 3;
            this.autoLoginChannelType = i3;
            this.autoLoginChannelParam1 = str;
            this.autoLoginChannelParam2 = str2;
        }

        public void configAutoLoginForType5(String str, String str2, String str3, String str4, String str5) {
            this.autoLoginIdType = 5;
            this.autoLoginChannelType = 2;
            this.autoLoginChannelAppId = str4;
            this.autoLoginChannelAccessToken = str5;
            this.autoLoginChannelParam1 = str;
            this.autoLoginChannelParam2 = str2;
            this.autoLoginChannelParam6 = str3;
        }

        public Builder configAutoLoginForWeGame(int i3, String str, String str2, String str3, String str4) {
            this.autoLoginIdType = 2;
            this.autoLoginChannelType = i3;
            this.autoLoginChannelAppId = str;
            this.autoLoginChannelParam1 = str2;
            this.autoLoginChannelParam2 = str3;
            this.autoLoginChannelParam3 = str4;
            return this;
        }

        public Builder configAutoLoginForWtlogin(String str, String str2, String str3) {
            this.autoLoginIdType = 1;
            this.autoLoginChannelType = 2;
            this.autoLoginChannelAppId = str;
            this.autoLoginChannelQQUin = str2;
            this.autoLoginChannelQQSkey = str3;
            return this;
        }

        public void configAutoLoginForYsdk(int i3, String str, String str2, String str3, String str4) {
            this.autoLoginIdType = 6;
            this.autoLoginChannelType = i3;
            this.autoLoginChannelAppId = str;
            this.autoLoginChannelOpenId = str2;
            this.autoLoginChannelAccessToken = str3;
            this.autoLoginChannelParam1 = str4;
        }

        public Builder configExtraInfoOverlay(boolean z16, boolean z17, boolean z18) {
            this.enableExtraInfoOverlay = z16;
            this.extraOverlayRightOrLeft = z17;
            this.extraOverLayBottomOrTop = z18;
            return this;
        }

        public Builder configMidasPay(String str, String str2, String str3, String str4, String str5) {
            this.midasPayLinkId = str;
            this.midasPayClientOfferId = str2;
            this.midasPayClientOpenId = str3;
            this.midasPayPlatformId = str4;
            this.midasPayPlatformType = str5;
            return this;
        }

        public void configYybLoginForType0(int i3, String str, String str2) {
            this.yybLoginLoginType = 0;
            this.yybLoginChannel = i3;
            this.yybLoginOpenId = str;
            this.yybLoginAccessToken = str2;
        }

        public void configYybLoginForType1(int i3, String str, String str2, String str3) {
            this.yybLoginLoginType = 1;
            this.yybLoginChannel = i3;
            this.yybLoginOpenId = str2;
            this.yybLoginSrcAppId = str;
            this.yybLoginAccessToken = str3;
        }

        public void configYybLoginForType2(String str, String str2, String str3, String str4, String str5) {
            this.yybLoginLoginType = 2;
            this.yybLoginOpenId = str;
            this.yybLoginAccessToken = str2;
            this.yybLoginParam1 = str3;
            this.yybLoginParam2 = str4;
            this.yybLoginParam3 = str5;
        }

        public void configYybLoginForType3(String str, String str2, String str3, String str4, String str5) {
            this.yybLoginLoginType = 3;
            this.yybLoginOpenId = str;
            this.yybLoginAccessToken = str2;
            this.yybLoginParam1 = str3;
            this.yybLoginParam2 = str4;
            this.yybLoginParam3 = str5;
        }

        public Builder enableAdaptiveStreamQuality(boolean z16) {
            this.enableAdaptiveStreamQualityAdjust = z16;
            return this;
        }

        public Builder enableAdjustPreviewFpsRes(boolean z16) {
            this.enableAdjustPreviewFpsRes = z16;
            return this;
        }

        public Builder enableClipboard(boolean z16) {
            this.enableClipboard = z16;
            return this;
        }

        public Builder enableCloudAppMonitor(boolean z16) {
            this.enableCloudAppMonitor = z16;
            return this;
        }

        public Builder enableCustomizeDecoder(boolean z16) {
            this.enableCustomizeDecoder = z16;
            return this;
        }

        public Builder enableEnableCumulativeDelayed(boolean z16) {
            this.enableCumulativeDelayed = z16;
            return this;
        }

        public Builder enableGetBatteryInfo(boolean z16) {
            this.enableGetBatteryInfo = z16;
            return this;
        }

        public Builder enableImgQualityFirst(boolean z16) {
            this.enableImgQualityFirst = z16;
            return this;
        }

        public Builder enableKeepSession(boolean z16) {
            this.enableKeepSession = z16;
            return this;
        }

        public Builder enableLegacyDataChannel(boolean z16) {
            this.enableLegacyDataChannel = z16;
            return this;
        }

        public Builder enableLocalRtcEventLog(boolean z16) {
            this.enableLocalRtcEventLog = z16;
            return this;
        }

        public Builder enablePinchFace(boolean z16) {
            this.enablePinchFace = z16;
            return this;
        }

        public Builder enableQuic(boolean z16) {
            this.enableQuic = z16;
            return this;
        }

        public Builder enableRtcDump(boolean z16) {
            this.enableRtcDump = z16;
            return this;
        }

        public Builder enableRtcLog(boolean z16) {
            this.enableRtcLog = z16;
            return this;
        }

        public Builder enableTouchInterpolation(boolean z16) {
            this.enableTouchInterpolation = z16;
            return this;
        }

        public Builder enableViewConfigCallback(boolean z16) {
            this.enableViewConfigCallback = z16;
            return this;
        }

        public Builder forceSkipLoadArchive(boolean z16) {
            this.forceSkipLoadArchive = z16;
            return this;
        }

        public Builder forceSkipSetResolution(boolean z16) {
            this.forceSkipSetResolution = z16;
            return this;
        }

        public Builder forceUseCustomDecType(boolean z16, boolean z17, boolean z18) {
            this.forceUseCustomDecType = z16;
            this.forceUseDecH265 = z17;
            this.forceUseDecSoft = z18;
            return this;
        }

        public Builder setArchiveSessionId(String str) {
            this.archiveSessionId = str;
            return this;
        }

        public Builder setDefaultLoadingBackgroundResId(@DrawableRes int i3) {
            this.defaultLoadingBackgroundResId = i3;
            return this;
        }

        public Builder setDefaultLoadingLandscapeResId(@DrawableRes int i3) {
            this.defaultLoadingLandscapeResId = i3;
            return this;
        }

        public Builder setDefaultLoadingPortraitResId(@DrawableRes int i3) {
            this.defaultLoadingPortraitResId = i3;
            return this;
        }

        public Builder setDefaultMaxBitrate(int i3) {
            this.defaultMaxBitrate = i3;
            return this;
        }

        public Builder setDefaultMinBitrate(int i3) {
            this.defaultMinBitrate = i3;
            return this;
        }

        public Builder setDefaultStreamQualityCfg(List<GmCgGameStreamQualityCfg> list) {
            this.defaultStreamQualityCfg = list;
            return this;
        }

        public Builder setFeatSwitchForLocalImeInput(int i3) {
            this.featSwitchForLocalImeInput = i3;
            return this;
        }

        public Builder setGameLoginPayLoad(String str) {
            this.gameLoginPayLoad = str;
            return this;
        }

        public Builder setGameScreenOrientation(int i3) {
            this.gameScreenOrientation = i3;
            return this;
        }

        public Builder setLaunchBitrate(int i3) {
            this.launchBitrate = i3;
            return this;
        }

        public Builder setLoadingDelayTimeMillis(int i3) {
            this.loadingDelayTimeMillis = i3;
            return this;
        }

        public Builder setLoadingScaleType(ImageView.ScaleType scaleType) {
            this.loadingScaleType = scaleType;
            return this;
        }

        public Builder setLongTimeNoTouchAndCountdown(int i3, int i16) {
            this.noTouchLongTime = i3;
            this.noTouchLongTimeCountdown = i16;
            return this;
        }

        public Builder setNoTouchEventTimeSeconds(int i3) {
            this.noTouchEventCallbackTimeSeconds = i3;
            return this;
        }

        public Builder setRtcCurrAudioVolume(int i3) {
            this.rtcCurrAudioVolume = i3;
            return this;
        }

        public Builder setRtcDumpPath(String str) {
            this.rtcDumpPath = str;
            return this;
        }

        public Builder setRtcDumpSize(int i3) {
            this.rtcDumpSize = i3;
            return this;
        }

        public Builder setRtcHwDecode(Boolean bool) {
            this.rtcHwDecode = bool;
            return this;
        }

        public Builder setRtcLogger(GmCgLogger gmCgLogger) {
            this.rtcLogger = gmCgLogger;
            return this;
        }

        public Builder setRtcLoggingSeverity(int i3) {
            this.rtcLoggingSeverity = i3;
            return this;
        }

        public Builder setRtcMaxAudioVolume(int i3) {
            this.rtcMaxAudioVolume = i3;
            return this;
        }

        public Builder setSuperResolutionOnlyHwDecode(boolean z16) {
            this.superResolutionOnlyHwDecode = z16;
            return this;
        }

        public Builder setWebRtcAudioSource(@Nullable Integer num) {
            this.webrtcAudioSource = num;
            return this;
        }

        public Builder setWebrtcConnectionTime(int i3) {
            this.webrtcConnectionTime = i3;
            return this;
        }

        public Builder useCustomInputView(boolean z16) {
            this.useCustomInputView = z16;
            return this;
        }

        public Builder useCustomLoadingView(boolean z16) {
            this.useCustomLoadingView = z16;
            return this;
        }

        public Builder useLegacyStreamQualityCfg(boolean z16) {
            this.useLegacyStreamQualityCfg = z16;
            return this;
        }

        public Builder useV2CloudGameLogin(boolean z16) {
            this.useV2CloudGameLogin = z16;
            return this;
        }
    }

    public GmCgSessionCfg(Builder builder) {
        this.pRtcCurrAudioVolume = -1;
        this.pRtcMaxAudioVolume = -1;
        this.pRtcLoggingSeverity = -1;
        this.pRtcHwDecode = null;
        this.pRtcDumpPath = null;
        this.pRtcDumpSize = -1;
        this.pEnableImgQualityPerferred = false;
        this.pWebrtcConnectionTime = -1;
        this.pEnableAdjustPreviewFpsRes = false;
        this.pGameScreenOrientation = builder.gameScreenOrientation;
        this.pAutoLoginIdType = builder.autoLoginIdType;
        this.pAutoLoginChannelType = builder.autoLoginChannelType;
        this.pAutoLoginChannelAppId = builder.autoLoginChannelAppId;
        this.pAutoLoginChannelOpenId = builder.autoLoginChannelOpenId;
        this.pAutoLoginChannelAccessToken = builder.autoLoginChannelAccessToken;
        this.pAutoLoginChannelQQUin = builder.autoLoginChannelQQUin;
        this.pAutoLoginChannelQQSkey = builder.autoLoginChannelQQSkey;
        this.pAutoLoginChannelParam1 = builder.autoLoginChannelParam1;
        this.pAutoLoginChannelParam2 = builder.autoLoginChannelParam2;
        this.pAutoLoginChannelParam3 = builder.autoLoginChannelParam3;
        this.pAutoLoginChannelParam4 = builder.autoLoginChannelParam4;
        this.pAutoLoginChannelParam5 = builder.autoLoginChannelParam5;
        this.pAutoLoginChannelParam6 = builder.autoLoginChannelParam6;
        this.pYybLoginSrcAppId = builder.yybLoginSrcAppId;
        this.pYybLoginChannel = builder.yybLoginChannel;
        this.pYybLoginOpenId = builder.yybLoginOpenId;
        this.pYybLoginAccessToken = builder.yybLoginAccessToken;
        this.pYybLoginLoginType = builder.yybLoginLoginType;
        this.pYybLoginSdkType = builder.yybLoginSdkType;
        this.pYybLoginParam1 = builder.yybLoginParam1;
        this.pYybLoginParam2 = builder.yybLoginParam2;
        this.pYybLoginParam3 = builder.yybLoginParam3;
        this.pMidasPayLinkId = builder.midasPayLinkId;
        this.pMidasPayClientOfferId = builder.midasPayClientOfferId;
        this.pMidasPayClientOpenId = builder.midasPayClientOpenId;
        this.pMidasPayPlatformId = builder.midasPayPlatformId;
        this.pMidasPayPlatformType = builder.midasPayPlatformType;
        this.pLaunchBitrate = builder.launchBitrate;
        this.pMinDefaultBitRate = builder.defaultMinBitrate;
        this.pMaxDefaultBitRate = builder.defaultMaxBitrate;
        this.pEnableAdaptiveStreamQuality = builder.enableAdaptiveStreamQualityAdjust;
        this.pEnableExtraInfoOverlay = builder.enableExtraInfoOverlay;
        this.pExtraInfoOverlayRightOrLeft = builder.extraOverlayRightOrLeft;
        this.pExtraInfoOverLayBottomOrTop = builder.extraOverLayBottomOrTop;
        this.pEnableLegacyDataChannel = builder.enableLegacyDataChannel;
        this.pAllowWorkIfNoGameConfig = builder.allowWorkIfNoGameConfig;
        this.pEnablePinchFace = builder.enablePinchFace;
        this.pEnableKeepSession = builder.enableKeepSession;
        this.pEnableCloudAppMonitor = builder.enableCloudAppMonitor;
        this.pUseCustomLoadingView = builder.useCustomLoadingView;
        this.pEnableClipboard = builder.enableClipboard;
        this.pUseV2CloudGameLogin = builder.useV2CloudGameLogin;
        this.pDefaultLoadingPortraitResId = builder.defaultLoadingPortraitResId;
        this.pDefaultLoadingLandscapeResId = builder.defaultLoadingLandscapeResId;
        this.pDefaultLoadingBackgroundResId = builder.defaultLoadingBackgroundResId;
        this.pLoadingScaleType = builder.loadingScaleType;
        this.pEnableRtcDump = builder.enableRtcDump;
        this.pEnableLocalRtcEventLog = builder.enableLocalRtcEventLog;
        this.pEnableRtcLog = builder.enableRtcLog;
        this.pLoadingDelayTimeMillis = builder.loadingDelayTimeMillis;
        this.pNoTouchEventCallbackTimeSeconds = builder.noTouchEventCallbackTimeSeconds;
        this.pFeatSwitchForLocalImeInput = builder.featSwitchForLocalImeInput;
        this.pDefaultStreamQualityCfg = builder.defaultStreamQualityCfg;
        this.pUseLegacyStreamQualityCfg = builder.useLegacyStreamQualityCfg;
        this.pForceUseCustomDecType = builder.forceUseCustomDecType;
        this.pForceUseDecH265 = builder.forceUseDecH265;
        this.pForceUseDecSoft = builder.forceUseDecSoft;
        this.pEnableConfigCallback = builder.enableViewConfigCallback;
        this.pEnableQuic = builder.enableQuic;
        this.pEnableCustomizeDecoder = builder.enableCustomizeDecoder;
        this.pArchiveSessionId = builder.archiveSessionId;
        this.pUseCustomInputView = builder.useCustomInputView;
        this.pForceSkipLoadArchive = builder.forceSkipLoadArchive;
        this.pForceSkipSetResolution = builder.forceSkipSetResolution;
        this.pNoTouchLongTime = builder.noTouchLongTime;
        this.pNoTouchLongTimeCountdown = builder.noTouchLongTimeCountdown;
        this.pRtcCurrAudioVolume = builder.rtcCurrAudioVolume;
        this.pRtcMaxAudioVolume = builder.rtcMaxAudioVolume;
        this.pRtcLoggingSeverity = builder.rtcLoggingSeverity;
        this.pRtcLogger = builder.rtcLogger;
        this.pRtcHwDecode = builder.rtcHwDecode;
        this.pRtcDumpPath = builder.rtcDumpPath;
        this.pRtcDumpSize = builder.rtcDumpSize;
        this.pSuperResolutionOnlyHwDecode = builder.superResolutionOnlyHwDecode;
        this.pEnableCumulativeDelayed = builder.enableCumulativeDelayed;
        this.pWebrtcConnectionTime = builder.webrtcConnectionTime;
        this.pEnableGetBatterInfo = builder.enableGetBatteryInfo;
        this.pEnableImgQualityPerferred = builder.enableImgQualityFirst;
        this.pEnableTouchInterpolation = builder.enableTouchInterpolation;
        this.pEnableAdjustPreviewFpsRes = builder.enableAdjustPreviewFpsRes;
        this.pGameLoginPayLoad = builder.gameLoginPayLoad;
        this.pWebRTCAudioSource = builder.webrtcAudioSource;
    }

    private boolean isAutoLoginOfDelegateCodeValid() {
        if (3 == this.pAutoLoginIdType && this.pAutoLoginChannelType != 0 && CGStringUtil.notEmpty(this.pAutoLoginChannelParam1) && CGStringUtil.notEmpty(this.pAutoLoginChannelParam2)) {
            return true;
        }
        return false;
    }

    private boolean isAutoLoginOfOpenIdValid() {
        if (this.pAutoLoginIdType == 0 && this.pAutoLoginChannelType != 0 && CGStringUtil.notEmpty(this.pAutoLoginChannelAppId) && CGStringUtil.notEmpty(this.pAutoLoginChannelOpenId) && CGStringUtil.notEmpty(this.pAutoLoginChannelAccessToken)) {
            return true;
        }
        return false;
    }

    private boolean isAutoLoginOfType5Valid() {
        if (5 == this.pAutoLoginIdType && 2 == this.pAutoLoginChannelType && CGStringUtil.notEmpty(this.pAutoLoginChannelParam1) && CGStringUtil.notEmpty(this.pAutoLoginChannelParam2) && CGStringUtil.notEmpty(this.pAutoLoginChannelAccessToken) && CGStringUtil.notEmpty(this.pAutoLoginChannelParam6)) {
            return true;
        }
        return false;
    }

    private boolean isAutoLoginOfUinValid() {
        if (1 == this.pAutoLoginIdType && 2 == this.pAutoLoginChannelType && CGStringUtil.notEmpty(this.pAutoLoginChannelAppId) && CGStringUtil.notEmpty(this.pAutoLoginChannelQQUin) && CGStringUtil.notEmpty(this.pAutoLoginChannelQQSkey)) {
            return true;
        }
        return false;
    }

    private boolean isAutoLoginOfWeGameValid() {
        if (2 == this.pAutoLoginIdType && this.pAutoLoginChannelType != 0 && CGStringUtil.notEmpty(this.pAutoLoginChannelParam1) && CGStringUtil.notEmpty(this.pAutoLoginChannelParam2) && CGStringUtil.notEmpty(this.pAutoLoginChannelParam3)) {
            return true;
        }
        return false;
    }

    private boolean isAutoLoginOfYSDValid() {
        if (6 == this.pAutoLoginIdType && this.pAutoLoginChannelType != 0 && CGStringUtil.notEmpty(this.pAutoLoginChannelAppId) && CGStringUtil.notEmpty(this.pAutoLoginChannelOpenId) && CGStringUtil.notEmpty(this.pAutoLoginChannelParam1) && CGStringUtil.notEmpty(this.pAutoLoginChannelAccessToken)) {
            return true;
        }
        return false;
    }

    private boolean isYybLoginType0Valid() {
        if (this.pYybLoginLoginType == 0 && this.pYybLoginChannel != 0 && CGStringUtil.notEmpty(this.pYybLoginOpenId) && CGStringUtil.notEmpty(this.pYybLoginAccessToken)) {
            return true;
        }
        return false;
    }

    private boolean isYybLoginType1Valid() {
        if (1 == this.pYybLoginLoginType && this.pYybLoginChannel != 0 && CGStringUtil.notEmpty(this.pYybLoginSrcAppId) && CGStringUtil.notEmpty(this.pYybLoginOpenId) && CGStringUtil.notEmpty(this.pYybLoginAccessToken)) {
            return true;
        }
        return false;
    }

    private boolean isYybLoginType2Valid() {
        if (2 == this.pYybLoginLoginType && CGStringUtil.notEmpty(this.pYybLoginOpenId) && CGStringUtil.notEmpty(this.pYybLoginAccessToken) && CGStringUtil.notEmpty(this.pYybLoginParam1)) {
            return true;
        }
        return false;
    }

    private boolean isYybLoginType3Valid() {
        if (3 == this.pYybLoginLoginType && CGStringUtil.notEmpty(this.pYybLoginOpenId) && CGStringUtil.notEmpty(this.pYybLoginAccessToken) && CGStringUtil.notEmpty(this.pYybLoginParam1)) {
            return true;
        }
        return false;
    }

    public boolean needConfigMidasPay() {
        if (CGStringUtil.notEmpty(this.pMidasPayLinkId) && CGStringUtil.notEmpty(this.pMidasPayClientOfferId) && CGStringUtil.notEmpty(this.pMidasPayClientOpenId) && CGStringUtil.notEmpty(this.pMidasPayPlatformId) && CGStringUtil.notEmpty(this.pMidasPayPlatformType)) {
            return true;
        }
        return false;
    }

    public boolean wantAutoLogin() {
        if (!isAutoLoginOfOpenIdValid() && !isAutoLoginOfUinValid() && !isAutoLoginOfWeGameValid() && !isAutoLoginOfDelegateCodeValid() && !isAutoLoginOfYSDValid() && !isAutoLoginOfType5Valid()) {
            return false;
        }
        return true;
    }

    public boolean wantYybLogin() {
        if (!isYybLoginType0Valid() && !isYybLoginType1Valid() && !isYybLoginType2Valid() && !isYybLoginType3Valid()) {
            return false;
        }
        return true;
    }
}
