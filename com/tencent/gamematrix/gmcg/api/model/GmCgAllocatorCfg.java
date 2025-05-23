package com.tencent.gamematrix.gmcg.api.model;

import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GmCgAllocatorCfg {
    public List<GmCgAllocDeviceLabel> pAllocDeviceLabels;
    public String pBizExtraInfo;
    public List<Rect> pBoundingRects;
    public boolean pCanWaitIfQueue;
    public String pCgGameId;
    public String pCloudGameAppBizInfo;
    public boolean pEnableCloudAppAssistScreen;
    public boolean pEnableCloudAppOuterWebJump;
    public boolean pEnableCloudAppPowerSaveModeNotify;
    public boolean pEnableCloudAppSendDownLoadRequest;
    public int pGamePlayType;
    public int pIdentityProfileType;
    public String pMidGameId;
    public boolean pNeedColdStartDevice;
    public boolean pNeedNewDevice;
    public boolean pNeedReplaceDevice;
    public long pPlayLimitTime;
    public int pQueuePriority;
    public int pRoi;
    public int pRotation;
    public int pSafeInsetBottom;
    public int pSafeInsetLeft;
    public int pSafeInsetRight;
    public int pSafeInsetTop;
    public int pScreenHeight;
    public int pScreenType;
    public int pScreenWidth;
    public boolean pSkipNetDetect;
    public int pSuperResolutionType;
    public String pUseFixedIpToNetDetect;
    public boolean pUseIpToNetDetect;
    public int pcLoginType;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class Builder {
        private String bizExtraInfo;
        private String cgGameId;
        private int identityProfileType;
        private List<GmCgAllocDeviceLabel> labels;
        private String midGameId;
        private boolean needColdStartDevice;
        private boolean needNewDevice;
        private boolean needReplaceDevice;
        private int pcLoginType;
        private long playLimitTime;
        private int queuePriority;
        private int roi;
        private int safeInsetBottom;
        private int safeInsetLeft;
        private int safeInsetRight;
        private int safeInsetTop;
        private int screenHeight;
        private int screenType;
        private int screenWidth;
        private String useFixedIpToNetDetect;
        private boolean useIpToNetDetect;
        private int gamePlayType = 0;
        private boolean canWaitIfQueue = true;
        private boolean skipNetDetect = true;
        private int rotation = 0;
        private boolean enableCloudAppOuterWebJump = false;
        private boolean enableCloudAppAssistScreen = false;
        private boolean enableCloudAppPowerSaveModeNotify = false;
        private boolean enableCloudAppSendDownLoadRequest = false;
        private List<Rect> boundingRects = new ArrayList();

        public Builder(String str, long j3) {
            this.cgGameId = str;
            this.playLimitTime = j3;
        }

        public Builder addLabel(String str, String str2, String str3, boolean z16) {
            return addLabel(new GmCgAllocDeviceLabel(str, str2, str3, z16));
        }

        public GmCgAllocatorCfg build() {
            return new GmCgAllocatorCfg(this);
        }

        public Builder enableCloudAppAssistScreen() {
            this.enableCloudAppAssistScreen = true;
            return this;
        }

        public Builder enableCloudAppOuterWebJump() {
            this.enableCloudAppOuterWebJump = true;
            return this;
        }

        public Builder enableCloudAppPowerSaveModeNotify() {
            this.enableCloudAppPowerSaveModeNotify = true;
            return this;
        }

        public Builder enableCloudAppSendDownLoadRequest() {
            this.enableCloudAppSendDownLoadRequest = true;
            return this;
        }

        public Builder needColdStartDevice(boolean z16) {
            this.needColdStartDevice = z16;
            return this;
        }

        public Builder needNewDevice(boolean z16) {
            this.needNewDevice = z16;
            return this;
        }

        public Builder needReplaceDevice(boolean z16) {
            this.needReplaceDevice = z16;
            return this;
        }

        public Builder setBizExtraInfo(String str) {
            this.bizExtraInfo = str;
            return this;
        }

        public Builder setBoundingRects(List<Rect> list) {
            if (list != null) {
                this.boundingRects.addAll(list);
            }
            return this;
        }

        public Builder setDisplay(Display display) {
            this.rotation = display.getRotation();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            display.getRealMetrics(displayMetrics);
            this.screenWidth = displayMetrics.widthPixels;
            this.screenHeight = displayMetrics.heightPixels;
            return this;
        }

        public Builder setFixedIpToNetDetect(String str) {
            this.useFixedIpToNetDetect = str;
            return this;
        }

        public Builder setGamePlayType(int i3) {
            this.gamePlayType = i3;
            return this;
        }

        public Builder setGameRoi(int i3) {
            this.roi = i3;
            return this;
        }

        public Builder setIdentityProfileType(int i3) {
            this.identityProfileType = i3;
            return this;
        }

        public Builder setMidGameId(String str) {
            this.midGameId = str;
            return this;
        }

        public Builder setPCLoginType(int i3) {
            this.pcLoginType = i3;
            return this;
        }

        public Builder setQueueConfig(boolean z16, int i3) {
            this.canWaitIfQueue = z16;
            this.queuePriority = i3;
            return this;
        }

        @Deprecated
        public Builder setRotation(int i3) {
            this.rotation = i3;
            return this;
        }

        public Builder setSafeInsetBottom(int i3) {
            this.safeInsetBottom = i3;
            return this;
        }

        public Builder setSafeInsetLeft(int i3) {
            this.safeInsetLeft = i3;
            return this;
        }

        public Builder setSafeInsetRight(int i3) {
            this.safeInsetRight = i3;
            return this;
        }

        public Builder setSafeInsetTop(int i3) {
            this.safeInsetTop = i3;
            return this;
        }

        @Deprecated
        public Builder setScreenSize(int i3, int i16) {
            this.screenWidth = i3;
            this.screenHeight = i16;
            return this;
        }

        public Builder setScreenType(int i3) {
            this.screenType = i3;
            return this;
        }

        public Builder skipNetDetect(boolean z16) {
            this.skipNetDetect = z16;
            return this;
        }

        public Builder useIpToNetDetect(boolean z16) {
            this.useIpToNetDetect = z16;
            return this;
        }

        public Builder addLabel(GmCgAllocDeviceLabel gmCgAllocDeviceLabel) {
            if (gmCgAllocDeviceLabel == null) {
                return this;
            }
            if (this.labels == null) {
                this.labels = new ArrayList();
            }
            this.labels.add(gmCgAllocDeviceLabel);
            return this;
        }
    }

    GmCgAllocatorCfg(Builder builder) {
        this.pEnableCloudAppOuterWebJump = false;
        this.pEnableCloudAppAssistScreen = false;
        this.pEnableCloudAppPowerSaveModeNotify = false;
        this.pEnableCloudAppSendDownLoadRequest = false;
        this.pCgGameId = builder.cgGameId;
        this.pPlayLimitTime = builder.playLimitTime;
        this.pGamePlayType = builder.gamePlayType;
        this.pCanWaitIfQueue = builder.canWaitIfQueue;
        this.pQueuePriority = builder.queuePriority;
        this.pBizExtraInfo = builder.bizExtraInfo;
        this.pNeedNewDevice = builder.needNewDevice;
        this.pNeedReplaceDevice = builder.needReplaceDevice;
        this.pIdentityProfileType = builder.identityProfileType;
        this.pSkipNetDetect = builder.skipNetDetect;
        this.pUseIpToNetDetect = builder.useIpToNetDetect;
        this.pUseFixedIpToNetDetect = builder.useFixedIpToNetDetect;
        this.pNeedColdStartDevice = builder.needColdStartDevice;
        this.pAllocDeviceLabels = builder.labels;
        this.pScreenType = builder.screenType;
        this.pMidGameId = builder.midGameId;
        this.pRoi = builder.roi;
        this.pcLoginType = builder.pcLoginType;
        this.pRotation = builder.rotation;
        this.pScreenWidth = builder.screenWidth;
        this.pScreenHeight = builder.screenHeight;
        this.pSafeInsetLeft = builder.safeInsetLeft;
        this.pSafeInsetTop = builder.safeInsetTop;
        this.pSafeInsetRight = builder.safeInsetRight;
        this.pSafeInsetBottom = builder.safeInsetBottom;
        this.pBoundingRects = builder.boundingRects;
        this.pEnableCloudAppOuterWebJump = builder.enableCloudAppOuterWebJump;
        this.pEnableCloudAppAssistScreen = builder.enableCloudAppAssistScreen;
        this.pEnableCloudAppPowerSaveModeNotify = builder.enableCloudAppPowerSaveModeNotify;
        this.pEnableCloudAppSendDownLoadRequest = builder.enableCloudAppSendDownLoadRequest;
    }
}
