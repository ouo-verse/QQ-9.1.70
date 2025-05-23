package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RobotGuideInfo {
    public String bannerBg = "";
    public String fullscreenBg = "";
    public String robotUrl = "";
    public String title = "";
    public String videoUrl = "";
    public RobotCoreInfo robotInfo = new RobotCoreInfo();
    public ArrayList<String> features = new ArrayList<>();

    public String getBannerBg() {
        return this.bannerBg;
    }

    public ArrayList<String> getFeatures() {
        return this.features;
    }

    public String getFullscreenBg() {
        return this.fullscreenBg;
    }

    public RobotCoreInfo getRobotInfo() {
        return this.robotInfo;
    }

    public String getRobotUrl() {
        return this.robotUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }
}
