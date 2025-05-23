package com.tencent.qqlive.module.videoreport.dtreport.api;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DTConfig {
    private boolean videoReportSupport = false;
    private boolean newPlayTypeSupport = false;
    private boolean webViewReportSupport = false;
    private boolean seekReportSupport = false;
    private boolean speedRatioReportSupport = false;
    private boolean audioReportSupport = false;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class Builder {
        private boolean videoReportSupport = false;
        private boolean webViewReportSupport = false;
        private boolean seekReportSupport = false;
        private boolean speedRatioReportSupport = false;

        public DTConfig build() {
            DTConfig dTConfig = new DTConfig();
            dTConfig.videoReportSupport = this.videoReportSupport;
            dTConfig.webViewReportSupport = this.webViewReportSupport;
            dTConfig.seekReportSupport = this.seekReportSupport;
            dTConfig.speedRatioReportSupport = this.speedRatioReportSupport;
            return dTConfig;
        }

        public Builder supportSeekReport(boolean z16) {
            this.seekReportSupport = z16;
            return this;
        }

        public Builder supportSpeedRatioReport(boolean z16) {
            this.speedRatioReportSupport = z16;
            return this;
        }

        public Builder supportVideoReport(boolean z16) {
            this.videoReportSupport = z16;
            return this;
        }

        public Builder supportWebViewReport(boolean z16) {
            this.webViewReportSupport = z16;
            return this;
        }
    }

    public boolean audioReportSupport() {
        return this.audioReportSupport;
    }

    public void newPlayTypeSupport(boolean z16) {
        this.newPlayTypeSupport = z16;
    }

    public boolean seekReportSupport() {
        return this.seekReportSupport;
    }

    public boolean speedRatioReportSupport() {
        return this.speedRatioReportSupport;
    }

    public boolean videoReportSupport() {
        return this.videoReportSupport;
    }

    public boolean webViewReportSupport() {
        return this.webViewReportSupport;
    }

    public void audioReportSupport(boolean z16) {
        this.audioReportSupport = z16;
    }

    public boolean newPlayTypeSupport() {
        return this.newPlayTypeSupport;
    }

    public void seekReportSupport(boolean z16) {
        this.seekReportSupport = z16;
    }

    public void speedRatioReportSupport(boolean z16) {
        this.speedRatioReportSupport = z16;
    }

    public void videoReportSupport(boolean z16) {
        this.videoReportSupport = z16;
    }

    public void webViewReportSupport(boolean z16) {
        this.webViewReportSupport = z16;
    }
}
